package pomplatform.ht.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.OutDesignConsideration;
import com.pomplatform.db.dao.OutQuotation;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.ProductionValueCoefficientType;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.SubContract;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.ht.bean.BaseOutQuotationWithO;
import pomplatform.ht.dao.OutQuotationWithO;
import pomplatform.outQuotations.bean.BaseMoutquotationooor;
import pomplatform.outQuotations.bean.ConditionMoutquotationooor;
import pomplatform.outQuotations.query.QueryMoutquotationooor;
import pomplatform.project.bean.BaseOnLoadMainProjectEmployeeByOutQuotations;
import pomplatform.project.bean.ConditionOnLoadMainProjectEmployeeByOutQuotations;
import pomplatform.project.query.QueryOnLoadMainProjectEmployeeByOutQuotations;

public class OutQuotationApplicationWorker implements GenericWorkflowProcessor {

	protected BaseOutQuotationWithO bean = new BaseOutQuotationWithO();
	protected BaseOutQuotation baseOutQuotation = new BaseOutQuotation();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		
		OutQuotationWithO dao = new OutQuotationWithO();
		bean.setDataFromMap(params);
		dao.setDataFromBase(bean);
		params.put("businessType", StaticUtils.BUSINESS_TYPE_STATUS_1);
		updateSubMsg(params, employeeId);
//		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getOutQuotationId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {
				return null;
			}
		}

		OutQuotation dao = new OutQuotation();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		Map<String, Object> result = updateSubMsg(params, employeeId);
		BigDecimal moneySum = BaseHelpUtils.getBigDecimalValue(result.get("moneySum"));
		int mainProjectId = BaseHelpUtils.getIntValue(result.get("mainProjectId"));
		int outQuotationId = BaseHelpUtils.getIntValue(bean.getOutQuotationId());
		String projectCode = BaseHelpUtils.getString(bean.getProjectCode());
		String infoCode = BaseHelpUtils.getString(bean.getInfoCode());
		
		if(completed){
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
				//恢复成初始状态
				dao.setQuotationStatus(StaticUtils.QUOTATION_STATUS);
				
				MainProject mpDao = new MainProject();
				mpDao.setConditionInfoCode("=", infoCode);
				mpDao.setConditionProjectCode("=", projectCode);
				mpDao.setHasSplitPriceTime(new Date());
				mpDao.setHasSplitPrice(false);
				mpDao.conditionalUpdate();
				
				//更新合同状态和合同金额
				Contract ctDao = new Contract();
				ctDao.setConditionInfoCode("=", infoCode);
				ctDao.setConditionProjectCode("=", projectCode);
				ctDao.setSigningMoneySum(BigDecimal.ZERO);
				ctDao.setContractPrice(BigDecimal.ZERO);
				ctDao.setFlowStatus(StaticUtils.FLOW_STATUS_99);
				ctDao.conditionalUpdate();
				
				
				MainProjectBusinessType mpbtDao =new MainProjectBusinessType();
				mpbtDao.setConditionMainProjectId("=", mainProjectId);
				mpbtDao.setConditionOutQuotationId("=", outQuotationId);
				mpbtDao.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_0);
				mpbtDao.conditionalUpdate();
				
			}else if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				//报价成功
				dao.setQuotationStatus(StaticUtils.QUOTATION_STATUS_ONE);
				dao.setMoneySum(moneySum);
				
				//原拆分价操作
				MainProject mpDao = new MainProject();
				mpDao.setConditionMainProjectId("=", mainProjectId);
				mpDao.setConditionInfoCode("=", infoCode);
				mpDao.setConditionProjectCode("=", projectCode);
				mpDao.setHasSplitPriceTime(new Date());
				mpDao.setHasSplitPrice(true);
				mpDao.conditionalUpdate();
				
				//更新合同状态和合同金额
				Contract ctDao = new Contract();
//				ctDao.setConditionInfoCode("=", infoCode);
				ctDao.setConditionProjectCode("=", projectCode);
				
				ctDao.setSigningMoneySum(moneySum);
				ctDao.setContractPrice(moneySum);
				ctDao.setFlowStatus(StaticUtils.FLOW_STATUS_0);
				ctDao.conditionalUpdate();
				
				
				BaseContract executeQueryOneRow = ctDao.executeQueryOneRow();
				if(BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
					throw new SQLException("合同信息获取失败！");
				}
				Integer contractId = executeQueryOneRow.getContractId();
				
				MainProjectBusinessType mpbtDao =new MainProjectBusinessType();
				mpbtDao.setConditionMainProjectId("=", mainProjectId);
				mpbtDao.setConditionOutQuotationId(">", 0);
				mpbtDao.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_3);
				mpbtDao.conditionalUpdate();
				
				mpbtDao.clear();
				mpbtDao.setConditionMainProjectId("=", mainProjectId);
				mpbtDao.setConditionOutQuotationId("=", outQuotationId);

				BigDecimal outputValueSum = BigDecimal.ZERO;
				List<BaseMainProjectBusinessType> conditionalLoad = mpbtDao.conditionalLoad();
				if(conditionalLoad.size()>0) {
					for (BaseMainProjectBusinessType baseMainProjectBusinessType : conditionalLoad) {
						outputValueSum = outputValueSum .add(BaseHelpUtils.getBigDecimalValue(baseMainProjectBusinessType.getOutputValue()));
					}
				}
				
				//按照sub_contracts的每个订单的比例自动计算以及更新
				SubContract scDao =new SubContract();
				scDao.setConditionParentId("=", contractId);
				scDao.setConditionProjectType("=", 16);//管理订单
				List<BaseSubContract> loadProjectType16 = scDao.conditionalLoad();
				if(loadProjectType16.size()==1) {//1条
					BaseSubContract baseSubContract = loadProjectType16.get(0);
					baseSubContract.setSheetTotalIntegral(outputValueSum);
					scDao.clear();
					scDao.setDataFromBase(baseSubContract);
					scDao.update();
				}else if(loadProjectType16.size()>1){//多条
					BigDecimal sheetTotalIntegralSum =BigDecimal.ZERO;
					BigDecimal bigDecimalValueSum =BigDecimal.ZERO;
					for (BaseSubContract baseSubContract : loadProjectType16) {
						sheetTotalIntegralSum = sheetTotalIntegralSum.add(BaseHelpUtils.getBigDecimalValue(baseSubContract.getSheetTotalIntegral()));
					}
					if(sheetTotalIntegralSum.compareTo(BigDecimal.ZERO)>0) {
						for (int i = 0; i < loadProjectType16.size(); i++) {
							BaseSubContract baseSubContract = loadProjectType16.get(i);
							if(i==loadProjectType16.size()-1) {
								baseSubContract.setSheetTotalIntegral(outputValueSum.subtract(bigDecimalValueSum));
							}else {
								BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(baseSubContract.getSheetTotalIntegral());
								bigDecimalValueSum = bigDecimalValueSum.add(bigDecimalValue);
								BigDecimal percentage = bigDecimalValue.divide(sheetTotalIntegralSum, BigDecimal.ROUND_HALF_DOWN);
								BigDecimal sheetTotalIntegral = outputValueSum.multiply(percentage).multiply(new BigDecimal("0.01"));
								baseSubContract.setSheetTotalIntegral(sheetTotalIntegral);
							}
							scDao.clear();
							scDao.setDataFromBase(baseSubContract);
							scDao.update();
						}
					}
				}
				
				scDao.clear();
				scDao.setConditionParentId("=", contractId);
				scDao.setConditionProjectType("!=", 16);
				List<BaseSubContract> load = scDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(load)&&load.size()>0) {
					BigDecimal percentageSum =BigDecimal.ZERO;
					BigDecimal sheetTotalIntegralSum =BigDecimal.ZERO;
					BigDecimal moneySumSum =BigDecimal.ZERO;
					
					for (BaseSubContract baseSubContract : load) {
						BigDecimal percentage = BaseHelpUtils.getBigDecimalValue(baseSubContract.getPercentage());
						percentageSum = percentageSum.add(percentage);
						if(percentageSum.compareTo(new BigDecimal(100))==0) {
							baseSubContract.setSheetTotalIntegral(outputValueSum.subtract(sheetTotalIntegralSum));
							baseSubContract.setSheetIntegral(outputValueSum.subtract(sheetTotalIntegralSum));
							baseSubContract.setMoneySum(moneySum.subtract(moneySumSum));
						}else {
							//订单积分
							BigDecimal sheetTotalIntegral = outputValueSum.multiply(percentage).multiply(new BigDecimal("0.01"));
							sheetTotalIntegralSum = sheetTotalIntegralSum.add(sheetTotalIntegral);
							baseSubContract.setSheetTotalIntegral(sheetTotalIntegral);
							baseSubContract.setSheetIntegral(sheetTotalIntegral);
							
							//合同金额
							BigDecimal money= moneySum.multiply(percentage).multiply(new BigDecimal("0.01"));
							moneySumSum = moneySumSum.add(money);
							baseSubContract.setMoneySum(money);
						}
						
						scDao.clear();
						scDao.setDataFromBase(baseSubContract);
						scDao.update();
					}
					
					if(percentageSum.compareTo(new BigDecimal(100))>=0) {
						mpbtDao.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_3);//已分配完毕的状态
					}else {
						mpbtDao.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_2);
					}
				}else {
					mpbtDao.setStatus(StaticUtils.BUSINESS_TYPE_STATUS_2);
				}
				mpbtDao.conditionalUpdate();
				ProjectStage psDao =new ProjectStage();
				psDao.setConditionMainProjectId("=", mainProjectId);
				List<BaseProjectStage> list = psDao.conditionalLoad();
				if(list.size()>0) {
					if(outputValueSum.compareTo(BigDecimal.ZERO)>0) {
						BigDecimal decimalSum = BigDecimal.ZERO;
						for (int i = 0; i <list.size(); i++) {
							BaseProjectStage baseProjectStage = list.get(i);
							if(i==list.size()-1) {
//								baseProjectStage.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_1);
								baseProjectStage.setProjectAmount(outputValueSum.subtract(decimalSum));
							}else {
								BigDecimal percent = BaseHelpUtils.getBigDecimalValue(baseProjectStage.getPercent());
								BigDecimal multiply = (percent.multiply(new BigDecimal("0.0100"))).setScale(4, BigDecimal.ROUND_HALF_DOWN);
								BigDecimal decimal = outputValueSum.multiply(multiply).setScale(2, BigDecimal.ROUND_HALF_DOWN);
								decimalSum = decimalSum.add(decimal);
								baseProjectStage.setProjectAmount(decimal);
//								baseProjectStage.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_1);
							}
							
							psDao.clear();
							psDao.setDataFromBase(baseProjectStage);
							psDao.update();
						}
					}else {
						throw new SQLException("产值和不能为小于等于0");
					}
				}else {
					throw new SQLException("阶段策划不能为空！");
				}
			}
		}
		
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getOutQuotationId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		
		if (!BaseHelpUtils.isNullOrEmpty(roleId) && roleId == StaticUtils.ROLE_CUSTOM_AUDITOR) {// 项目主管领导 4
			QueryOnLoadMainProjectEmployeeByOutQuotations query = new QueryOnLoadMainProjectEmployeeByOutQuotations();
			ConditionOnLoadMainProjectEmployeeByOutQuotations condition = new ConditionOnLoadMainProjectEmployeeByOutQuotations();
			condition.setProjectCode(bean.getProjectCode());
			condition.setRelation(4);
			condition.setQuotationStatus(3);//报价中
			BaseCollection<BaseOnLoadMainProjectEmployeeByOutQuotations> execute = query.execute(null, condition);
			if (!BaseHelpUtils.isNullOrEmpty(execute) && execute.getCollections().size() > 0) {
				List<BaseOnLoadMainProjectEmployeeByOutQuotations> collections = execute.getCollections();
				int[] activityOwners = new int[collections.size()];
				for (int i = 0; i < collections.size(); i++) {
					activityOwners[i] = BaseHelpUtils.getIntValue(collections.get(i).getEmployeeId());
				}
				return activityOwners;
			} else {
				return new int[0];
			}
		}else {
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		}
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		QueryMoutquotationooor query =new QueryMoutquotationooor();
		ConditionMoutquotationooor condition  = new ConditionMoutquotationooor();
		condition.setOutQuotationId(businessId);
		BaseCollection<BaseMoutquotationooor> execute = query.execute(null, condition);
		if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()==1){
			BaseMoutquotationooor baseMoutquotationooor = execute.getCollections().get(0);
			System.out.println("baseMoutquotationooor.toJSON()================="+baseMoutquotationooor.toJSON());
			return baseMoutquotationooor.toJSON();
		}else {
			return null;
		}
		
		
//		OutQuotationWithO dao = new OutQuotationWithO();
//		dao.setOutQuotationId(businessId);
//		dao.load();
//		String json = dao.generateBaseExt().toJSON();
//		return json;
	}
	
	public static void main(String[] args) throws Exception {
//		OutQuotationApplicationWorker  a = new OutQuotationApplicationWorker();
//		a.getBusinessData(1917);
		OutQuotation dao = new OutQuotation();
//		dao.setConditionOutQuotationId("=", 690);
		dao.setConditionQuotationStatus("=", 1);//只加载报价成功的
		List<BaseOutQuotation> list = dao.conditionalLoad();
		MainProject mDao = new MainProject();
		MainProjectBusinessType mpbtDao =new MainProjectBusinessType();
		ProjectStage psDao =new ProjectStage();
		BaseMainProject mBean = null;
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
			for(BaseOutQuotation e : list) {
				String infoCode = BaseHelpUtils.getString(e.getInfoCode());
				String projectCode = BaseHelpUtils.getString(e.getProjectCode());
				mDao.clear();
				mDao.setConditionInfoCode("=", infoCode);
				mDao.setConditionProjectCode("=", projectCode);
				mBean = mDao.executeQueryOneRow();
				if(BaseHelpUtils.isNullOrEmpty(mBean)) {
					continue;
				}
				int outId = BaseHelpUtils.getIntValue(e.getOutQuotationId());
				int mainId = BaseHelpUtils.getIntValue(mBean.getMainProjectId());
				mpbtDao.clear();
				mpbtDao.setConditionMainProjectId("=", mainId);
				mpbtDao.setConditionOutQuotationId("=", outId);
				BigDecimal outputValueSum = BigDecimal.ZERO;//产值
				List<BaseMainProjectBusinessType> conditionalLoad = mpbtDao.conditionalLoad();
				if(conditionalLoad.size()>0) {
					for (BaseMainProjectBusinessType baseMainProjectBusinessType : conditionalLoad) {
						outputValueSum = outputValueSum .add(BaseHelpUtils.getBigDecimalValue(baseMainProjectBusinessType.getOutputValue()));
					}
				}
				psDao.setConditionMainProjectId("=", mainId);
				List<BaseProjectStage> sList = psDao.conditionalLoad();
				if(outputValueSum.compareTo(BigDecimal.ZERO)>0) {
					BigDecimal decimalSum = BigDecimal.ZERO;
					for (int i = 0; i <sList.size(); i++) {
						BaseProjectStage baseProjectStage = sList.get(i);
						if(i==sList.size()-1) {
//							baseProjectStage.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_1);
							baseProjectStage.setProjectAmount(outputValueSum.subtract(decimalSum));
						}else {
							BigDecimal percent = BaseHelpUtils.getBigDecimalValue(baseProjectStage.getPercent());
							BigDecimal multiply = (percent.multiply(new BigDecimal("0.0100"))).setScale(4, BigDecimal.ROUND_HALF_DOWN);
							BigDecimal decimal = outputValueSum.multiply(multiply).setScale(2, BigDecimal.ROUND_HALF_DOWN);
							decimalSum = decimalSum.add(decimal);
							baseProjectStage.setProjectAmount(decimal);
//							baseProjectStage.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_1);
						}
						psDao.clear();
						psDao.setDataFromBase(baseProjectStage);
						psDao.update();
					}
				}
				
			}
		}
		
	}
	
	private Map<String, Object> updateSubMsg(Map params, int employeeId) throws SQLException {
		
		Map<String, Object> result =new HashMap<>();
		List<Map<String, String>> detailOutDesignConsideration = (List<Map<String, String>>) params.get("detailOutDesignConsideration");
		List<Map<String, String>> businessTypeList = (List<Map<String, String>>) params.get("detailMainProjectBusinessType");
		if(detailOutDesignConsideration.size()<=0||businessTypeList.size()<=0) {
			throw new SQLException("合同报价单和产值单列表不能为空");
		}
		
		bean.setDataFromMap(params);
		int outQuotationId = BaseHelpUtils.getIntValue(bean.getOutQuotationId());
		String projectCode = BaseHelpUtils.getString(bean.getProjectCode());
		String infoCode = BaseHelpUtils.getString(bean.getInfoCode());
		String newCreateQuotationName = BaseHelpUtils.getString(params.get("newCreateQuotationName"));
		
		System.out.println("newCreateQuotationName ======  "+newCreateQuotationName);

		if(outQuotationId<=0) {
			throw new SQLException("报价单数据获取失败");
		}
		if(BaseHelpUtils.isNullOrEmpty(projectCode)) {
			throw new SQLException("项目编号不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(infoCode)) {
			throw new SQLException("信息编号不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(newCreateQuotationName)) {
			throw new SQLException("报价单标题不能为空");
		}
		
		MainProject mDao =new MainProject();
		mDao.setConditionProjectCode("=", projectCode);
		mDao.setConditionInfoCode("=", infoCode);
		BaseMainProject mbean = mDao.executeQueryOneRow();
		if(BaseHelpUtils.isNullOrEmpty(mbean)) {
			throw new SQLException("项目编号("+projectCode+")的立项信息不存在！");
		}
		
		PreProject pDao =new PreProject();
		pDao.setConditionInfoCode("=", infoCode);
		BasePreProject pbean = pDao.executeQueryOneRow();
		if(BaseHelpUtils.isNullOrEmpty(pbean)) {
			throw new SQLException("信息编号("+projectCode+")的前期项目不存在！");
		}
		
		Integer mainProjectId = mbean.getMainProjectId();
		
		BigDecimal moneySum =BigDecimal.ZERO;
		
		// 业务类别
		if (!BaseHelpUtils.isNullOrEmpty(businessTypeList) && businessTypeList.size() > 0) {
			int businessTypeId = 0;
			String businessName = "";
			ProductionValueCoefficientType bdao =new ProductionValueCoefficientType();
			for (Map<String, String> bt : businessTypeList) {
				businessTypeId = BaseHelpUtils.getIntValue(bt.get("businessType"));
				bdao.clear();
				bdao.setProductionValueCoefficientTypeId(businessTypeId);
				if (bdao.load()) {
					if (BaseHelpUtils.isNullOrEmpty(businessName)) {
						businessName = bdao.getCoefficientType();
					} else {
						businessName = businessName + "," + bdao.getCoefficientType();
					}
				}
			}
			pbean.setBusinessType(businessName);
			mbean.setBusinessType(businessName);
			pDao.clear();
			mDao.clear();
			pDao.setDataFromBase(pbean);
			mDao.setDataFromBase(mbean);
			pDao.update();
			mDao.update();
			
			MainProjectBusinessType  mbdao = new MainProjectBusinessType();
			if (mainProjectId > 0) {
				mbdao.setConditionMainProjectId("=", mainProjectId);
				mbdao.setConditionOutQuotationId("=", outQuotationId);
				mbdao.conditionalDelete();
			}
			for (Map<String, String> btt : businessTypeList) {
				mbdao.clear();
				mbdao.setMainProjectId(mainProjectId);
				mbdao.setOutQuotationId(outQuotationId);
				mbdao.setBusinessType(BaseHelpUtils.getIntValue(btt.get("businessType")));
				mbdao.setArea(BaseHelpUtils.getBigDecimalValue(btt.get("area")));
				mbdao.setOutputValue(BaseHelpUtils.getBigDecimalValue(btt.get("outputValue")));
				mbdao.save();
			}
		}
		
		if (!BaseHelpUtils.isNullOrEmpty(detailOutDesignConsideration) && detailOutDesignConsideration.size() > 0) {
			List<BaseOutDesignConsideration> list =new ArrayList<>();
			
			OutDesignConsideration odc = new OutDesignConsideration();
			odc.setConditionProjectCode("=", projectCode);
			odc.setConditionOutQuotationId("=", outQuotationId);
			odc.conditionalDelete();
			
			for (Map<String, String> map : detailOutDesignConsideration) {
				//只有主键为空的才新增
				BaseOutDesignConsideration b = new BaseOutDesignConsideration();
				b.setOutQuotationId(outQuotationId);
				b.setInfoCode(infoCode);// 信息编号
				b.setProjectCode(projectCode);// 项目编号
				b.setMainDesignAreaName(BaseHelpUtils.getString(map.get("mainDesignAreaName")).trim());// 业务类型
				b.setOutQuotationId(outQuotationId);// 报价单id
//				b.setOptionType(cx.getOptionType());// 专项--> 1
//				b.setMainDesignAreaName(cx.getOptionName());// 设计范围
				b.setOutTempletId(BaseHelpUtils.getIntValue(map.get("outTempletId")));//模板id
				b.setDesignArea(BaseHelpUtils.getBigDecimalValue(map.get("designArea")));
				b.setNewCreateQuotationName(newCreateQuotationName);
				b.setDesignUnitPrice(BaseHelpUtils.getBigDecimalValue(map.get("designUnitPrice")));
				b.setMoneySum(BaseHelpUtils.getBigDecimalValue(map.get("moneySum")));
				b.setEmployeeId(employeeId);
				//合同报价之和 = 合同金额
				moneySum = moneySum.add(BaseHelpUtils.getBigDecimalValue(map.get("moneySum")));
//				list.add(b);
				odc.clear();
				System.out.println("b==================="+b);
				odc.setDataFromBase(b);
				odc.save();
			}
			
			if(list.size()>0) {
				odc.clear();
				odc.save(list);
			}
		}
		
		result.put("moneySum", moneySum);
		result.put("mainProjectId", mainProjectId);
		return result;
	}
	
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
 }

}
