package pomplatform.project.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.bean.BaseProjectPerformance;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAdvanceRecord;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.ProjectPerformance;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.project.bean.BaseGetProjectAndSettlementIntegralByContract;
import pomplatform.project.bean.BaseGetRunningReimbursementAmountByContract;
import pomplatform.project.bean.BaseGetRunningReimbursementAmountByProject;
import pomplatform.project.bean.BaseOnLoadProjectStageSettlement;
import pomplatform.project.bean.ConditionGetProjectAndSettlementIntegralByContract;
import pomplatform.project.bean.ConditionGetRunningReimbursementAmountByContract;
import pomplatform.project.bean.ConditionGetRunningReimbursementAmountByProject;
import pomplatform.project.bean.ConditionOnLoadProjectStageSettlement;
import pomplatform.project.query.QueryGetProjectAndSettlementIntegralByContract;
import pomplatform.project.query.QueryGetRunningReimbursementAmountByContract;
import pomplatform.project.query.QueryGetRunningReimbursementAmountByProject;
import pomplatform.project.query.QueryOnLoadProjectStageSettlement;

public class ProjectProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		String optType = BaseHelpUtils.getString(params.get("optType"));
		switch(optType){
		case "changeProjectStatus":
			return changeProjectStatus(params);
		case "changeProjectStatusByContractId":
			return changeProjectStatusByContractId(params);
		case "settlementProjectCost":
			return settlementProjectCost(params);
		case "PurchaseProjectCost":  //采买项目成本结算
			return PurchaseProjectCost(params);
		default:
			return null;
		}
	}

	public String changeProjectStatus(Map<String, Object> params) throws Exception{
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int projectId = BaseHelpUtils.getIntValue(params.get("projectId"));
		int status = BaseHelpUtils.getIntValue(params.get("status"));
		Project dao = new Project();
		dao.setProjectId(projectId);
		if(dao.load()){
			int contractStatus = 0;
			if(BaseHelpUtils.getIntValue(dao.getContractId()) > 0) {
				Contract cDao = new Contract();
				cDao.setContractId(dao.getContractId());
				if(cDao.load()) {
					contractStatus = BaseHelpUtils.getIntValue(cDao.getContractStatus());
				}
			}
			if(status == StaticUtils.PROJECT_STATUS_2 || status == StaticUtils.PROJECT_STATUS_10) {
				//变为订单运行/订单暂停
				Set<Integer> disagreeSet = new HashSet<>();
				disagreeSet.add(StaticUtils.CONTRACT_STATUS_4);
				disagreeSet.add(StaticUtils.CONTRACT_STATUS_6);
				disagreeSet.add(StaticUtils.CONTRACT_STATUS_7);
				disagreeSet.add(StaticUtils.CONTRACT_STATUS_8);
				if(!disagreeSet.contains(contractStatus)) {
					return bc.toJSON(-1, "只有处于项目缓慢、合同运行、合同运行收尾或合同缓慢状态的合同下的订单才可以执行本操作");
				}
			}else if(status == StaticUtils.PROJECT_STATUS_11){
				//检查积分是否结算完了,如果该项目最后一个阶段已上传确认函，就已结算完
				ConditionOnLoadProjectStageSettlement condition1 = new ConditionOnLoadProjectStageSettlement();
				condition1.setProjectId(projectId);
				QueryOnLoadProjectStageSettlement query1 = new QueryOnLoadProjectStageSettlement();
				BaseCollection<BaseOnLoadProjectStageSettlement> bc1 = query1.executeQuery(null, condition1);
				if(null != bc1){
					List<BaseOnLoadProjectStageSettlement> list1 = bc1.getCollections();
					if(!BaseHelpUtils.isNullOrEmpty(list1) && list1.size() > 0){
						//取最后一个阶段的记录
						BaseOnLoadProjectStageSettlement obj = list1.get(list1.size()-1);
						int attachmentNum = BaseHelpUtils.getIntValue(obj.getAttachmentNum());
						if(attachmentNum == 0){
							return bc.toJSON(-1, "该订单未上传最后一个阶段的确认函，无法结项");
						}
//						for(BaseOnLoadProjectStageSettlement obj : list1){
//							if((null == obj.getProjectIntegral() && null == obj.getSettlementIntegral()) || (null != obj.getProjectIntegral() && null != obj.getSettlementIntegral() && obj.getProjectIntegral().compareTo(obj.getSettlementIntegral()) == 0) || (null == obj.getProjectIntegral() || (null != obj.getProjectIntegral() && obj.getProjectIntegral().compareTo(BigDecimal.ZERO) == 0)) && (null == obj.getSettlementIntegral() || (null != obj.getSettlementIntegral() && obj.getSettlementIntegral().compareTo(BigDecimal.ZERO) == 0))){
//								continue;
//							}else{
//								return bc.toJSON(-1, "订单积分没有结算完，无法结项");
//							}
//						}
					}
				}
				//检查项目成本
				ProjectCost costDao = new ProjectCost();
				costDao.setConditionProjectId("=", projectId);
				costDao.setConditionStatus("=", StaticUtils.SETTLEMENT_STATUS_NO);
				if(costDao.countRows() > 0){
					return bc.toJSON(-1, "该订单还有项目成本没有分摊，无法结项");
				}
				//检查是否有未走完的成本报销
				ConditionGetRunningReimbursementAmountByProject condition2 = new ConditionGetRunningReimbursementAmountByProject();
				condition2.setProjectId(projectId);
				QueryGetRunningReimbursementAmountByProject query2 = new QueryGetRunningReimbursementAmountByProject();
				BaseCollection<BaseGetRunningReimbursementAmountByProject> bc2 = query2.executeQuery(null, condition2);
				if(null != bc2){
					List<BaseGetRunningReimbursementAmountByProject> list2 = bc2.getCollections();
					if(null != list2 && !list2.isEmpty() && list2.get(0).getAmount() > 0){
						return bc.toJSON(-1, "该订单还有正在流程中的成本报销，无法结项");
					}
				}
				//检查是否有项目补贴积分没有下发
				ProjectAdvanceRecord advanceDao = new ProjectAdvanceRecord();
				advanceDao.setConditionProjectId("=", projectId);
				advanceDao.setConditionLeftIntegral(">", BigDecimal.ZERO);
				if(advanceDao.countRows() > 0){
					return bc.toJSON(-1, "该订单还有项目补贴积分没有发放，无法结项");
				}
				if(null != dao.getComplaintIntegral() && dao.getComplaintIntegral().compareTo(BigDecimal.ZERO) != 0){
					BigDecimal integral = dao.getComplaintIntegral();
					ProjectPerformance ppDao = new ProjectPerformance();
					ppDao.setConditionProjectId("=", dao.getProjectId());
					ppDao.setConditionBusinessType("=", StaticUtils.PERFORMANCE_BUSINESS_TYPE_2);
					List<BaseProjectPerformance> ppList = ppDao.conditionalLoad();
					if(null != ppList && !ppList.isEmpty()){
						for(BaseProjectPerformance pp : ppList){
							if(null != pp.getIntegral() && pp.getIntegral().compareTo(BigDecimal.ZERO) != 0){
								switch(pp.getPerformanceFlag()){
								case StaticUtils.PERFORMANCE_FLAG_1:
									integral = integral.subtract(pp.getIntegral());
									break;
								case StaticUtils.PERFORMANCE_FLAG_2:
									integral = integral.add(pp.getIntegral());
									break;
								default:
									break;
								}
							}
						}
					}
					PlateAccountRecord accountDao = new PlateAccountRecord();
					accountDao.setPlateId(dao.getPlateId());
					accountDao.setIntegral(integral);
					accountDao.setBusinessTypeId(StaticUtils.PLATE_ACCOUNT_BUSINESS_TYPE_20);
					accountDao.setRecordDate(new Date());
					accountDao.setOperateTime(new Date());
					accountDao.setOperateEmployeeId(BaseHelpUtils.getIntValue(params.get("operator")));
					accountDao.setRemark(dao.getContractCode() + " 项目名称：" + dao.getProjectName()+ "的结项积分");
					accountDao.save();
				}
			}
			dao.setStatus(status);
			dao.update();
			
			return bc.toJSON();
		}
		return bc.toJSON(-1, "");
	}
	
	public String changeProjectStatusByContractId(Map<String, Object> params) throws Exception{
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
		if(contractId > 0){
			int status = BaseHelpUtils.getIntValue(params.get("status"));
			Project dao = new Project();
			dao.setConditionContractId("=", contractId);
			if(dao.countRows() > 0){
				ThreadConnection.beginTransaction();
				if(status == StaticUtils.PROJECT_STATUS_2 || status == StaticUtils.PROJECT_STATUS_10) {
					//订单暂停和订单运行只有合同处于项目缓慢、合同运行、合同运行收尾或合同缓慢状态才可以点
					Contract cDao = new Contract();
					cDao.setContractId(contractId);
					if(!cDao.load()) {
						return bc.toJSON(-1, "无法获取合同信息");
					}
					Set<Integer> disagreeSet = new HashSet<>();
					disagreeSet.add(StaticUtils.CONTRACT_STATUS_4);
					disagreeSet.add(StaticUtils.CONTRACT_STATUS_6);
					disagreeSet.add(StaticUtils.CONTRACT_STATUS_7);
					disagreeSet.add(StaticUtils.CONTRACT_STATUS_8);
					if(!disagreeSet.contains(cDao.getContractStatus())) {
						return bc.toJSON(-1, "只有处于项目缓慢、合同运行、合同运行收尾或合同缓慢状态的合同下的订单才可以执行本操作");
					}
				}else if(status == StaticUtils.PROJECT_STATUS_11){
					//检查积分是否结算完了
					ConditionGetProjectAndSettlementIntegralByContract condition1 = new ConditionGetProjectAndSettlementIntegralByContract();
					condition1.setContractId(contractId);
					QueryGetProjectAndSettlementIntegralByContract query1 = new QueryGetProjectAndSettlementIntegralByContract();
					BaseCollection<BaseGetProjectAndSettlementIntegralByContract> bc1 = query1.executeQuery(null, condition1);
					if(null != bc1){
						List<BaseGetProjectAndSettlementIntegralByContract> list1 = bc1.getCollections();
						if(null != list1){
							for(BaseGetProjectAndSettlementIntegralByContract obj : list1){
								if((null == obj.getProjectIntegral() && null == obj.getSettlementIntegral()) || (null != obj.getProjectIntegral() && null != obj.getSettlementIntegral() && obj.getProjectIntegral().compareTo(obj.getSettlementIntegral()) == 0) || (null == obj.getProjectIntegral() && (null != obj.getSettlementIntegral() && obj.getSettlementIntegral().compareTo(BigDecimal.ZERO) == 0)) || ((null != obj.getProjectIntegral() && obj.getProjectIntegral().compareTo(BigDecimal.ZERO) == 0) && null == obj.getSettlementIntegral())){
									continue;
								}else{
									return bc.toJSON(-1, "该合同有订单积分没有结算完，无法结项");
								}
							}
						}
					}
					//检查是否有未走完的成本报销
					ConditionGetRunningReimbursementAmountByContract condition2 = new ConditionGetRunningReimbursementAmountByContract();
					condition2.setContractId(contractId);
					QueryGetRunningReimbursementAmountByContract query2 = new QueryGetRunningReimbursementAmountByContract();
					BaseCollection<BaseGetRunningReimbursementAmountByContract> bc2 = query2.executeQuery(null, condition2);
					if(null != bc2){
						List<BaseGetRunningReimbursementAmountByContract> list2 = bc2.getCollections();
						if(null != list2 && !list2.isEmpty() && list2.get(0).getAmount() > 0){
							return bc.toJSON(-1, "该合同下的订单还有正在流程中的成本报销，无法结项");
						}
					}
					List<BaseProject> list = dao.conditionalLoad();
					Object[] arr = new Object[list.size()];
					int i = 0;
					for(BaseProject obj : list){
						arr[i] = obj.getProjectId();
					}
					//检查项目成本
					ProjectCost costDao = new ProjectCost();
					costDao.addCondition(BaseProjectCost.CS_PROJECT_ID, "in", arr);
					costDao.setConditionStatus("=", StaticUtils.SETTLEMENT_STATUS_NO);
					if(costDao.countRows() > 0){
						return bc.toJSON(-1, "该合同下的订单还有项目成本没有分摊，无法结项");
					}
					//检查是否有项目补贴积分没有下发
					ProjectAdvanceRecord advanceDao = new ProjectAdvanceRecord();
					advanceDao.addCondition(BaseProjectAdvanceRecord.CS_PROJECT_ID, "in", arr);
					advanceDao.setConditionLeftIntegral(">", BigDecimal.ZERO);
					if(advanceDao.countRows() > 0){
						return bc.toJSON(-1, "该合同下的订单还有项目补贴积分没有发放，无法结项");
					}
					List<BaseProject> projectList = dao.conditionalLoad();
					if(null != projectList && !projectList.isEmpty()){
						for(BaseProject obj : projectList){
							if(null != obj.getReserveIntegral() && obj.getReserveIntegral().compareTo(BigDecimal.ZERO) != 0){
								BigDecimal integral = obj.getComplaintIntegral();
								ProjectPerformance ppDao = new ProjectPerformance();
								ppDao.setConditionProjectId("=", obj.getProjectId());
								ppDao.setConditionBusinessType("=", StaticUtils.PERFORMANCE_BUSINESS_TYPE_2);
								List<BaseProjectPerformance> ppList = ppDao.conditionalLoad();
								if(null != ppList && !ppList.isEmpty()){
									for(BaseProjectPerformance pp : ppList){
										if(null != pp.getIntegral() && pp.getIntegral().compareTo(BigDecimal.ZERO) != 0){
											switch(pp.getPerformanceFlag()){
											case StaticUtils.PERFORMANCE_FLAG_1:
												integral = integral.subtract(pp.getIntegral());
												break;
											case StaticUtils.PERFORMANCE_FLAG_2:
												integral = integral.add(pp.getIntegral());
												break;
											default:
												break;
											}
										}
									}
								}
								//往部门账户表中插入数据
								String remark = obj.getContractCode() + " 项目名称：" + obj.getProjectName()+ "的结项积分";
								int operator = BaseHelpUtils.getIntValue(params.get("operator"));
								AccountManageProcess.onSavePlateAccount(obj.getPlateId(), obj.getProjectId(), AccountManageProcess.PLATE_BT_END_PROJECT, integral, new Date(), remark, operator);
							}
						}
					}
				}
				dao.setStatus(status);
				dao.conditionalUpdate();
				ThreadConnection.commit();
				return bc.toJSON();
			}else{
				return bc.toJSON(-1, "该合同没有订单");
			}
		}else{
			return bc.toJSON(-1, "该合同不存在");
		}
	}
	
	public String settlementProjectCost(Map<String, Object> params) throws Exception{
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String ids = BaseHelpUtils.getString(params.get("ids"));
		if(BaseHelpUtils.isNullOrEmpty(ids)) {
			return bc.toJSON(-1, "请选择需要正负抵消的成本");
		}
		String[] idStrArr = ids.split(",");
		int length = idStrArr.length;
		Integer[] idArr = new Integer[length];
		for(int i = 0; i < length; i++) {
			idArr[i] = BaseHelpUtils.getIntValue(idStrArr[i]);
		}
		ProjectCost dao = new ProjectCost();
		dao.addCondition(BaseProjectCost.CS_PROJECT_COST_ID, "in", (Object[])idArr);
		List<BaseProjectCost> list = dao.conditionalLoad();
		if(list.isEmpty()) {
			return bc.toJSON(-1, "没有需要抵消的成本");
		}
		Integer projectId = list.get(0).getProjectId();
		BigDecimal sum = BigDecimal.ZERO;
		for(BaseProjectCost bean : list) {
			if(!Objects.equals(bean.getProjectId(), projectId)) {
				return bc.toJSON(-1, "不是同一个项目的成本，无法抵消");
			}
			sum = sum.add(bean.getAmount());
		}
		if(sum.compareTo(BigDecimal.ZERO) != 0) {
			return bc.toJSON(-1, "您选中的成本之和不为0，无法抵消");
		}
		dao.clear();
		dao.addCondition(BaseProjectCost.CS_PROJECT_COST_ID, "in", (Object[])idArr);
		dao.setStatus(StaticUtils.SETTLEMENT_STATUS_YES);
		dao.conditionalUpdate();
		return bc.toJSON();
	}
	
	
	
	public String PurchaseProjectCost(Map<String, Object> params) throws Exception{
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String ids = BaseHelpUtils.getString(params.get("ids"));
		if(BaseHelpUtils.isNullOrEmpty(ids)) {
			return bc.toJSON(-1, "请选择需要结算的采买项目成本");
		}
		String[] idStrArr = ids.split(",");
		int length = idStrArr.length;
		Integer[] idArr = new Integer[length];
		for(int i = 0; i < length; i++) {
			idArr[i] = BaseHelpUtils.getIntValue(idStrArr[i]);
		}
		//更改projec_cost的status状态   0->1
		ProjectCost pcDao =new ProjectCost();
		pcDao.addCondition(BaseProjectCost.CS_PROJECT_COST_ID, "in", (Object[])idArr);
		pcDao.setStatus(StaticUtils.SETTLEMENT_STATUS_YES);
		pcDao.conditionalUpdate();
		return bc.toJSON();
	}
	
}