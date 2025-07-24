package pomplatform.client.workflow.specialDeduction.handler;

import com.pomplatform.db.dao.CompanyRecord;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.request.CollectionAdminRequest.BalanceShardUnique;

import com.pomplatform.db.bean.BaseSpecialDeductionDetail;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import delicacy.expression.Expression;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.common.KeyValuePair;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.client.workflow.specialDeduction.bean.BaseSpecialDeductionRecordWithS;
import pomplatform.client.workflow.specialDeduction.dao.SpecialDeductionRecordWithS;
import pomplatform.common.utils.StaticUtils;
import pomplatform.specialDeduction.bean.BaseMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.BaseOnCheckSpecialCountByYear;
import pomplatform.specialDeduction.bean.BaseOnCheckSpecialDeduction;
import pomplatform.specialDeduction.bean.BaseOnLoadSpecialDeductionYear;
import pomplatform.specialDeduction.bean.ConditionMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.ConditionOnCheckSpecialCountByYear;
import pomplatform.specialDeduction.bean.ConditionOnCheckSpecialDeduction;
import pomplatform.specialDeduction.bean.ConditionOnLoadSpecialDeductionYear;
import pomplatform.specialDeduction.query.QueryMspecialdeductionrecordsor;
import pomplatform.specialDeduction.query.QueryOnCheckSpecialCountByYear;
import pomplatform.specialDeduction.query.QueryOnCheckSpecialDeduction;
import pomplatform.specialDeduction.query.QueryOnLoadSpecialDeductionYear;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;
import pomplatform.common.utils.CommonUtils;

public class SpecialDeductionInformationWorker implements GenericWorkflowProcessor {

	protected BaseSpecialDeductionRecordWithS bean = new BaseSpecialDeductionRecordWithS();

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
		bean.setDataFromMap(params);
		
		//获取本年度是有正在进行的专项扣除流程
		QueryOnCheckSpecialDeduction query =new QueryOnCheckSpecialDeduction();
		ConditionOnCheckSpecialDeduction condition =new ConditionOnCheckSpecialDeduction();
		//获取本年度已完成的专项扣除流程
		QueryOnLoadSpecialDeductionYear sdyQuery = new QueryOnLoadSpecialDeductionYear();
    	ConditionOnLoadSpecialDeductionYear sdyCondition = new ConditionOnLoadSpecialDeductionYear();
    	KeyValuePair kv = new KeyValuePair();
    	kv.setKey("EXTRACT ( MONTH FROM sdd.start_date ) <=? AND EXTRACT ( MONTH FROM sdd.end_date ) >=? AND EXTRACT ( MONTH FROM sdd.end_date ) <?");
    	kv.setValue("1=? and 1=? and 1=? ");
    	KeyValuePair[] kvs = {kv};

    	//获取本年度已完成的专项扣除流程
    	QueryOnCheckSpecialCountByYear  queryYear =new QueryOnCheckSpecialCountByYear();
    	ConditionOnCheckSpecialCountByYear conditionYear =new ConditionOnCheckSpecialCountByYear();
    	
    	
		//申请年份
		String year = bean.getEmployeeName();
		//申请人
		Integer applyEmpId =BaseHelpUtils.getIntValue(bean.getEmployeId());
		//专项扣除申请列表
		List<BaseSpecialDeductionDetail> detailSpecialDeductionDetail = bean.getDetailSpecialDeductionDetail();
		if(null==year ) {
			throw new SQLException("申请年度获取失败");
		}else {
			condition.setYear(year);
		  	sdyCondition.setYear(year);
		  	conditionYear.setYear(year);
		}
		
		if(applyEmpId<=0) {
			throw new SQLException("申请人获取失败");
		}else {
			condition.setEmployeeId(applyEmpId);
	    	sdyCondition.setEmployeeId(applyEmpId);
	    	conditionYear.setEmployeeId(applyEmpId);
	    	
	    	
	    	
		}
		
		StringBuffer sb =new StringBuffer();
		//遍历申请的list
		if (null != detailSpecialDeductionDetail && detailSpecialDeductionDetail.size() > 0) {
			for (BaseSpecialDeductionDetail baseSpecialDeductionDetail : detailSpecialDeductionDetail) {
				//专项类型id
				Integer specialDeductionTypeId = baseSpecialDeductionDetail.getSpecialDeductionTypeId();
				sb.append(specialDeductionTypeId);
				sb.append(",");
			
			}
			
			BaseCollection<BaseOnCheckSpecialCountByYear> executeYear = queryYear.executeQuery(null, conditionYear);
			if (null != executeYear && executeYear.getCollections().size() > 0) {
				List<BaseOnCheckSpecialCountByYear> list = executeYear.getCollections();
				for (BaseOnCheckSpecialCountByYear baseOnCheckSpecialCountByYear : list) {
					if(sb.toString().contains(String.valueOf(baseOnCheckSpecialCountByYear.getSpecialDeductionTypeId()))) {
						String specialDeductionTypeName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223",String.valueOf(baseOnCheckSpecialCountByYear.getSpecialDeductionTypeId()));
						throw new SQLException("本年度你已提交申请并通过(" + specialDeductionTypeName + ")两次以上,请联系人资部");
					}
				}
			}
		}else {
			throw new SQLException("申请列表不能为空");
		}
		
			BaseCollection<BaseOnCheckSpecialDeduction> collection = query.executeQuery(condition.getKeyValues(), condition);
			if(collection.getCollections().size()>0) {
				throw new SQLException("你有已申请未处理的专项扣除流程,请勿重复提交");
			}
			
			
			for (BaseSpecialDeductionDetail baseSpecialDeductionDetail : detailSpecialDeductionDetail) {
				//专项类型id
				Integer specialDeductionTypeId = baseSpecialDeductionDetail.getSpecialDeductionTypeId();
				
				BigDecimal amount = baseSpecialDeductionDetail.getAmount();
				
				cal.clear();
				cal.setTime(baseSpecialDeductionDetail.getStartDate());
				int startMonth = cal.get(Calendar.MONTH)+1;
				
				if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_3) {//申请贷款，则先判断是否已申请住房租房
					sdyCondition.setSpecialDeductionTypeId(StaticUtils.SPECIAL_DEDUCTION_4);
					BaseCollection<BaseOnLoadSpecialDeductionYear> executeQuery = sdyQuery.executeQuery(kvs, sdyCondition);
					if(null!=executeQuery && executeQuery.getCollections().size()>0) {
						String specialDeductionTypeName3 = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(StaticUtils.SPECIAL_DEDUCTION_3));
						String specialDeductionTypeName4 = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(StaticUtils.SPECIAL_DEDUCTION_4));
						throw new SQLException("你已申请过("+specialDeductionTypeName4+"),请勿重复申请("+specialDeductionTypeName3+")");
					}
				}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_4) {//申请住房租房，则先判断是否已申请贷款
					sdyCondition.setSpecialDeductionTypeId(StaticUtils.SPECIAL_DEDUCTION_3);
					BaseCollection<BaseOnLoadSpecialDeductionYear> execute= sdyQuery.executeQuery(kvs, sdyCondition);
					if(null!=execute && execute.getCollections().size()>0) {
						String specialDeductionTypeName3 = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(StaticUtils.SPECIAL_DEDUCTION_3));
						String specialDeductionTypeName4 = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(StaticUtils.SPECIAL_DEDUCTION_4));
						throw new SQLException("你已申请过("+specialDeductionTypeName3+"),请勿重复申请("+specialDeductionTypeName4+")");
					}
				}
				
				sdyCondition.setSpecialDeductionTypeId(specialDeductionTypeId);
				BaseCollection<BaseOnLoadSpecialDeductionYear> executeQuery = sdyQuery.executeQuery(kvs, sdyCondition);
				if(null!=executeQuery && executeQuery.getCollections().size()>0) {
					List<BaseOnLoadSpecialDeductionYear> collections = executeQuery.getCollections();
					for (BaseOnLoadSpecialDeductionYear baseSpecialDeductionDetail2 : collections) {
						BigDecimal amount2 = baseSpecialDeductionDetail2.getAmount();
						Date startDate = baseSpecialDeductionDetail2.getStartDate();
						Date endDate = baseSpecialDeductionDetail2.getEndDate();
						cal.clear();
						cal.setTime(endDate);
						int endMonth = cal.get(Calendar.MONTH)+1;
						
						if(amount.compareTo(amount2)!=0) {
							String specialDeductionTypeName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(specialDeductionTypeId));
							throw new SQLException("你申请得("+specialDeductionTypeName+")专项扣除金额请保持本年度已申请的金额一致("+amount2.setScale(0)+")");
						}
						if(startDate.after(endDate)) {
							String specialDeductionTypeName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(specialDeductionTypeId));
							throw new SQLException("你申请得("+specialDeductionTypeName+")专项扣除申请的开始时间不得比结束时间晚");
						}
						
						if(startMonth<=endMonth&&endMonth!=12) {
							String specialDeductionTypeName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(specialDeductionTypeId));
							throw new SQLException("你申请得("+specialDeductionTypeName+")专项扣除上一次申请的结束时间为"+endMonth+"月,请修改本次申请得开始和结束时间");
						}else if(startMonth<=endMonth&&endMonth==12){
							String specialDeductionTypeName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(specialDeductionTypeId));
							throw new SQLException("你申请得("+specialDeductionTypeName+")专项扣除的结束时间为"+endMonth+"月,请勿重复申请");
						}
					}
				}
			}

		
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getSpecialDeductionRecordId(), "");
		return ba;
	}

//	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		Integer applyEmployeId = bean.getEmployeId();
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
		SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		
		
		
		if(completed){
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {// 被驳回
				// 流程被驳回则消息通知发起人
				// String code = bean.getCode();
				ProcessInstance processInstance = pi.getProcessInstance();
				Integer processType = processInstance.getProcessType();
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getEmployeId());
				SendMSGCommon sendMSGCommon = new SendMSGCommon();
				Map map = new HashMap<String, Object>();
				// map.put("code", code);
				map.put("processType", processType);
				map.put("applyEmpId", applyEmpId);
				sendMSGCommon.sendWXMsgToUser(map);
			}else if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				Calendar cal =Calendar.getInstance();
				QueryOnCheckSpecialDeduction query =new QueryOnCheckSpecialDeduction();
				ConditionOnCheckSpecialDeduction condition =new ConditionOnCheckSpecialDeduction();
				
				QueryOnLoadSpecialDeductionYear sdyQuery = new QueryOnLoadSpecialDeductionYear();
		    	ConditionOnLoadSpecialDeductionYear sdyCondition = new ConditionOnLoadSpecialDeductionYear();
		    	KeyValuePair kv = new KeyValuePair();
		    	kv.setKey("EXTRACT ( MONTH FROM sdd.start_date ) <=? AND EXTRACT ( MONTH FROM sdd.end_date ) >=? AND EXTRACT ( MONTH FROM sdd.end_date ) <?");
		    	kv.setValue("1=? and 1=? and 1=? ");
		    	KeyValuePair[] kvs = {kv};

				//申请年份
				String year = bean.getEmployeeName();
				//申请人
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getEmployeId());
				//专项扣除申请列表
				List<BaseSpecialDeductionDetail> detailSpecialDeductionDetail = bean.getDetailSpecialDeductionDetail();
				if(null==year ) {
					throw new SQLException("申请年度获取失败");
				}else {
					condition.setYear(year);
				  	sdyCondition.setYear(year);
				}
				
				if(applyEmpId<=0) {
					throw new SQLException("申请人获取失败");
				}else {
					condition.setEmployeeId(applyEmpId);
			    	sdyCondition.setEmployeeId(applyEmpId);
				}
				
				if(null!=detailSpecialDeductionDetail && detailSpecialDeductionDetail.size()>0) {
					for (BaseSpecialDeductionDetail baseSpecialDeductionDetail : detailSpecialDeductionDetail) {
						int parentId = baseSpecialDeductionDetail.getParentId();
						//专项类型id
						Integer specialDeductionTypeId = baseSpecialDeductionDetail.getSpecialDeductionTypeId();
						
						BigDecimal amount = baseSpecialDeductionDetail.getAmount();
						
						cal.clear();
						cal.setTime(baseSpecialDeductionDetail.getStartDate());
						int startMonth = cal.get(Calendar.MONTH)+1;
						
						if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_3) {//申请贷款，则先判断是否已申请住房租房
							sdyCondition.setSpecialDeductionTypeId(StaticUtils.SPECIAL_DEDUCTION_4);
							BaseCollection<BaseOnLoadSpecialDeductionYear> executeQuery = sdyQuery.executeQuery(kvs, sdyCondition);
							if(null!=executeQuery && executeQuery.getCollections().size()>0) {
								String specialDeductionTypeName3 = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(StaticUtils.SPECIAL_DEDUCTION_3));
								String specialDeductionTypeName4 = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(StaticUtils.SPECIAL_DEDUCTION_4));
								throw new SQLException("你已申请过("+specialDeductionTypeName4+"),请勿重复申请("+specialDeductionTypeName3+")");
							}
						}else if(specialDeductionTypeId==StaticUtils.SPECIAL_DEDUCTION_4) {//申请住房租房，则先判断是否已申请贷款
							sdyCondition.setSpecialDeductionTypeId(StaticUtils.SPECIAL_DEDUCTION_3);
							BaseCollection<BaseOnLoadSpecialDeductionYear> executeQuery = sdyQuery.executeQuery(kvs, sdyCondition);
							if(null!=executeQuery && executeQuery.getCollections().size()>0) {
								String specialDeductionTypeName3 = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(StaticUtils.SPECIAL_DEDUCTION_3));
								String specialDeductionTypeName4 = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(StaticUtils.SPECIAL_DEDUCTION_4));
								throw new SQLException("你已申请过("+specialDeductionTypeName3+"),请勿重复申请("+specialDeductionTypeName4+")");
							}
						}
						
						sdyCondition.setSpecialDeductionTypeId(specialDeductionTypeId);
						BaseCollection<BaseOnLoadSpecialDeductionYear> executeQuery = sdyQuery.executeQuery(kvs, sdyCondition);
						if(null!=executeQuery && executeQuery.getCollections().size()>0) {
							List<BaseOnLoadSpecialDeductionYear> collections = executeQuery.getCollections();
							for (BaseOnLoadSpecialDeductionYear baseSpecialDeductionDetail2 : collections) {
								int businessId = baseSpecialDeductionDetail2.getBusinessId();
								
								System.out.println("businessId==="+businessId);
								System.out.println("parentId==="+parentId);
								if(businessId!=parentId) {
									BigDecimal amount2 = baseSpecialDeductionDetail2.getAmount();
									Date startDate = baseSpecialDeductionDetail2.getStartDate();
									Date endDate = baseSpecialDeductionDetail2.getEndDate();
									cal.clear();
									cal.setTime(endDate);
									int endMonth = cal.get(Calendar.MONTH)+1;
									
									if(amount.compareTo(amount2)!=0) {
										String specialDeductionTypeName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(specialDeductionTypeId));
										throw new SQLException("你申请得("+specialDeductionTypeName+")专项扣除金额请保持本年度已申请的金额一致("+amount2.setScale(0)+")");
									}
									if(startDate.after(endDate)) {
										String specialDeductionTypeName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(specialDeductionTypeId));
										throw new SQLException("你申请得("+specialDeductionTypeName+")专项扣除申请的开始时间不得比结束时间晚");
									}
									if(startMonth<=endMonth&&endMonth!=12) {
										String specialDeductionTypeName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(specialDeductionTypeId));
										throw new SQLException("你申请得("+specialDeductionTypeName+")专项扣除上一次申请的结束时间为"+endMonth+"月,请修改本次申请得开始和结束时间");
									}else if(startMonth<=endMonth&&endMonth==12){
										String specialDeductionTypeName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_223", String.valueOf(specialDeductionTypeId));
										throw new SQLException("你申请得("+specialDeductionTypeName+")专项扣除的结束时间为"+endMonth+"月,请勿重复申请");
									}
								}
							}
						}
					}
				}else {
					throw new SQLException("申请列表不能为空");
				}
				
				
			}
		}
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getSpecialDeductionRecordId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		e.setValue(OnWrokflowProcess.LINE_COMPANY_NAME, CommonUtils.getCompanyShortName(bean.getCompanyId()));
		CompanyRecord cr = new CompanyRecord();
		if(bean.getCompanyId()>0){
			cr.setCompanyRecordId(bean.getCompanyId());
			cr.load();
		}
		if(expression.contains(StaticUtils.BELONGING_COMPANY)){
			if(BaseHelpUtils.isNullOrEmpty(cr)){
				e.setValue(StaticUtils.BELONGING_COMPANY,"");
			}else{
				e.setValue(StaticUtils.BELONGING_COMPANY,cr.getCompanyName());
			}
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		SpecialDeductionRecordWithS dao = new SpecialDeductionRecordWithS();
		dao.setSpecialDeductionRecordId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}
	
	public static void main(String[] args) throws Exception {
		Calendar cal =Calendar.getInstance();
		cal.set(2019, 11, 31);
		
		List<BaseSpecialDeductionDetail> detailSpecialDeductionDetail = new ArrayList<>();
		BaseSpecialDeductionDetail base =new BaseSpecialDeductionDetail();
		base.setSpecialDeductionTypeId(1);
		base.setStartDate(new Date());
		base.setEndDate(cal.getTime());
		base.setDeductionPercentage(new BigDecimal(100));
		base.setAmount(new BigDecimal(1000));
		base.setCity("3");
		detailSpecialDeductionDetail.add(base);
		
		Map<String,Object> map =new HashMap<>();
		Map<String,Object> map2 =new HashMap<>();
		map.put("employeId", 2415);
		map.put("companyId", 0);
		map.put("plateId", 19);
		map.put("deparmentId", 66);
		map.put("employeeName", "2019");
		
		SystemProcessDefinition pd =new SystemProcessDefinition();
		pd.setProcessId(195);
		
		SpecialDeductionInformationWorker work =new SpecialDeductionInformationWorker();
		work.startNewWorkflow(pd, map, 2415);
		
		
		
	}
	
	

}
