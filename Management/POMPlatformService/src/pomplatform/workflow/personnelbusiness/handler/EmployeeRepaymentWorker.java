package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseBudgetAttachment;
import com.pomplatform.db.bean.BaseBudgetManagement;
import com.pomplatform.db.bean.BasePaymentSequence;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.*;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;

public class EmployeeRepaymentWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.save();
		params.put("personnelBusinessId", dao.getPersonnelBusinessId());
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		//获取预算管理Id
		int budgetManagementId=BaseHelpUtils.getIntValue(params.get("budgetManagementId"));
		//获取附件id
		int budgetAttachmentId=BaseHelpUtils.getIntValue(params.get("budgetAttachmentId"));
		//获取付款序列id
		int paymentSequenceId=BaseHelpUtils.getIntValue(params.get("paymentSequenceId"));
		if(budgetManagementId>0&&budgetAttachmentId>0&&paymentSequenceId>0) {
			PaymentSequence payseqdao=new PaymentSequence();
			payseqdao.setProcessId(pd.getProcessId());
			payseqdao.setProcessType(pd.getProcessTypeId());
			payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
			payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
			payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
			List<BasePaymentSequence>	list=payseqdao.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
				payseqdao.setIsLock(true);//加锁
				payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_THREE);//付款申请中
				payseqdao.setApplyPayDate(new Date());
				payseqdao.setBindStatus(StaticUtils.BD_BIND_STATUS_ALREADY);//已绑定状态
				payseqdao.conditionalUpdate();
			}
		}
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

			//获取当前审批节点
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			//获取当前节点类型
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			//只有处理节点才可以更改数据
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {//处理节点
				return null;
			}
		}
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dataValidate(dao);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setIsCompleted(Boolean.TRUE);
				Employee eDao = new Employee();
				eDao.setEmployeeId(dao.getParentId());
				eDao.load();
				//往资金表插入员工还款数据
				Capital cDao = new Capital();
				cDao.setHappenDate(dao.getStartDate());
				cDao.setBorrowMoney(dao.getFee());
				cDao.setSelfName(dao.getProjectId());
				cDao.setSelfBankAccount(dao.getProjectCode());
				cDao.setSelfBankName(dao.getProjectName());
				cDao.setOtherName(eDao.getEmployeeName());
				cDao.setMoneyAttribute(3);//个人往来款
				cDao.setOperator(dao.getEmployeeId());
				cDao.setCapitalType(1);//流入资金
				cDao.setProcessType(bean.getProcessType());
				cDao.setBusinessId(bean.getPersonnelBusinessId());
				cDao.setExchangeRate(new BigDecimal("1"));
				cDao.setOriginalCurrency(dao.getFee());
				cDao.save();

				/*Integer processTypeId = pi.getProcessInstance().getProcessType();
				Integer processId = pi.getProcessInstance().getProcessId();
				Integer processInstanceId = pi.getProcessInstance().getProcessInstanceId();
				Integer businessId =BaseHelpUtils.getIntValue(bean.getPersonnelBusinessId());
				int projectId=BaseHelpUtils.getIntValue(bean.getProjectIds());
				//如果项目ID不为null,扣除相应项目积分
				if(!BaseHelpUtils.isNullOrEmpty(projectId)&&projectId>0) {
					Project pDao=new Project();
					pDao.clear();
					pDao.setProjectId(projectId);
					if(pDao.load()) {
						//获取还款金额
						BigDecimal ReturnMoney=BaseHelpUtils.getBigDecimalValue(bean.getFee()).negate();//取相反数
						ProjectCost  costDao=new ProjectCost();
						if(ReturnMoney.compareTo(BigDecimal.ZERO)<0) {
							costDao.setProjectId(projectId);
							costDao.setEmployeeId(bean.getEmployeeId());
							costDao.setAmount(ReturnMoney);
							//设置花费类型为员工还款
							costDao.setCostType(StaticUtils.PROJECT_COST_TYPE_8);
							costDao.setCostDate(new Date());
							costDao.setProcessType(processTypeId);
							costDao.setProcessId(processId);
							costDao.setProcessInstanceId(processInstanceId);
							costDao.setBusinessId(businessId);
							//结算状态为未结算
							costDao.setStatus(StaticUtils.SETTLEMENT_STATUS_NO);
							costDao.save();
						}
					}
				}*/

				//获取付款序列id
				int paymentSequenceId=BaseHelpUtils.getIntValue(bean.getPaymentSequenceId());
				//获取预算管理Id
				int budgetManagementId=BaseHelpUtils.getIntValue(bean.getBudgetManagementId());
				//获取预算附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(dao.getBudgetAttachmentId());
				if(paymentSequenceId>0&&budgetManagementId>0&&budgetAttachmentId>0) {
					PaymentSequence payseqdao=new PaymentSequence();
					payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
					payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
					payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
					List<BasePaymentSequence>	list=payseqdao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
						payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_TWO);//已付款
						payseqdao.setPayDate(new Date());
						payseqdao.setReturnAmount(bean.getFee());;//设置序列付款金额为还款金额
						payseqdao.conditionalUpdate();
						payseqdao.clear();
						BudgetManagement bddao=new BudgetManagement();
						bddao.setBudgetManagementId(budgetManagementId);
						if(bddao.load()) {
							BaseBudgetManagement bdbean=bddao.generateBase();
							//获取还款金额
							BigDecimal returnAmount=BaseHelpUtils.getBigDecimalValue(bean.getFee()); 
							//获取已用金额
							BigDecimal bdUseAmout=BaseHelpUtils.getBigDecimalValue(bdbean.getBdUseAmount());
							//获取剩余金额
							BigDecimal BdRestAmount=BaseHelpUtils.getBigDecimalValue(bdbean.getBdRestAmount());
							bdUseAmout=bdUseAmout.subtract(returnAmount);
							BdRestAmount=BdRestAmount.add(returnAmount);
							bddao.setBdUseAmount(bdUseAmout);
							bddao.setBdRestAmount(BdRestAmount);
							bddao.update();
						}else {
							throw new Exception("找不到预算管理表主键");
						}
						BudgetAttachment bdadao=new BudgetAttachment();
						bdadao.setBudgetAttachmentId(budgetAttachmentId);
						if(bdadao.load()) {
							BaseBudgetAttachment bdabean=bdadao.generateBase();
							//获取附件合同已用金额
							BigDecimal budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountUse());
							//获取附件合同剩余金额
							BigDecimal budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(bdabean.getBudgetContractAmountRest());
							//获取还款金额
							BigDecimal amount=BaseHelpUtils.getBigDecimalValue(bean.getFee()); 
							budgetContractAmountUse=budgetContractAmountUse.subtract(amount);
							budgetContractAmountRest=budgetContractAmountRest.add(amount);
							bdadao.setBudgetContractAmountUse(budgetContractAmountUse);
							bdadao.setBudgetContractAmountRest(budgetContractAmountRest);
							bdadao.update();
						}else {
							throw new Exception("找不到预算附件主键");
						}
					}
				}
			}
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){//被驳回
				
				//流程被驳回则消息通知发起人
//				String code = bean.getCode();
				ProcessInstance processInstance = pi.getProcessInstance();
				Integer processType = processInstance.getProcessType(); 
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
				SendMSGCommon sendMSGCommon =new SendMSGCommon();
				Map map =new HashMap<String, Object>();
//				map.put("code", code);
				map.put("processType", processType);
				map.put("applyEmpId", applyEmpId);
				sendMSGCommon.sendWXMsgToUser(map);
				//获取付款序列id
				int paymentSequenceId=BaseHelpUtils.getIntValue(bean.getPaymentSequenceId());
				//获取预算管理Id
				int budgetManagementId=BaseHelpUtils.getIntValue(bean.getBudgetManagementId());
				//获取预算附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(dao.getBudgetAttachmentId());
				PaymentSequence payseqdao=new PaymentSequence();
				payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
				payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
				payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
				if(paymentSequenceId>0&&budgetManagementId>0&&budgetAttachmentId>0) {
					List<BasePaymentSequence>	list=payseqdao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
						payseqdao.setIsLock(false);//解锁
						payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_ONE);//未付款
						payseqdao.setBindStatus(StaticUtils.BD_BIND_STATUS_NO);//解绑
						payseqdao.conditionalUpdate();
					}
					payseqdao.clear();
					payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
					List<BasePaymentSequence>	lists=payseqdao.conditionalLoad();
					boolean  isLock=false;
					if(!BaseHelpUtils.isNullOrEmpty(lists)&&lists.size()>0) {
						for (BasePaymentSequence basePaymentSequence : lists) {
							isLock=basePaymentSequence.getIsLock();
							if(isLock==true) {
								break;
							}
						}
						if(isLock==false) {
							BudgetAttachment   baDao= new BudgetAttachment();
							baDao.setBudgetAttachmentId(budgetAttachmentId);
							if(baDao.load()) {
								baDao.setIsLock(false);//预算附件解锁
								baDao.update();
							}
						}
					}
				}
			}
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e =OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);
		e.setValue("天数", bean.getDays() == null ? 0.0 : bean.getDays().doubleValue());
		if(expression.contains(OnWrokflowProcess.BUDGET_MANAGEMENT_STATUS)) {
			String budStatus="";//预算状态
			int budgetManagementId=BaseHelpUtils.getIntValue(bean.getBudgetManagementId());
			SystemProcessInstanceActivity sdao=new SystemProcessInstanceActivity();
			sdao.setConditionProcessType("=",StaticUtils.PROCESS_TYPE_52);
			sdao.setConditionBusinessId("=",budgetManagementId);
			sdao.setConditionEmployeeId("=",1);//姜总ID
			sdao.setConditionStatus("=",2);//同意
			if(sdao.isExist()){
				budStatus="是";
				e.setValue(OnWrokflowProcess.BUDGET_MANAGEMENT_STATUS,budStatus);
			}else {
				budStatus="否";
				e.setValue(OnWrokflowProcess.BUDGET_MANAGEMENT_STATUS,budStatus);
			}
		}

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
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

	private void dataValidate(PersonnelBusines dao) throws Exception{
		if(BaseHelpUtils.isNullOrZero(dao.getProcessType())){
			throw new Exception("流程类型错误");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getEmployeeId())){
			throw new Exception("申请人不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())){
			throw new Exception("工号不能为空");
		}
	}
}
