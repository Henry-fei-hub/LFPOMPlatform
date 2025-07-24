package pomplatform.workflow.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseBudgetAttachment;
import com.pomplatform.db.bean.BaseBudgetManagement;
import com.pomplatform.db.bean.BaseEmployeeMoneyManage;
import com.pomplatform.db.bean.BasePaymentSequence;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.dao.*;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employeerescord.handler.EmployeeSalaryTypeProcess;
import pomplatform.exchangerate.utils.ExchangeRateUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;

public class EmployeeBorrowMoneyByWorkflowWorker implements GenericWorkflowProcessor {

	protected BaseEmployeeMoneyManage bean = new BaseEmployeeMoneyManage();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		//工资发放表过来的数据需要需要更新子表的状态
		int employeeFundIssuanceId = BaseHelpUtils.getIntValue(params.get("employeeFundIssuanceId"));
		if (employeeFundIssuanceId != 0) {
			EmployeeSalaryTypeProcess employeeSalaryTypeProcess = new EmployeeSalaryTypeProcess();
			employeeSalaryTypeProcess.updateLoanApplication(employeeFundIssuanceId);
		}
		bean.setDataFromMap(params);
		bean.setOperateEmployeeId(employeeId);
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setDataFromBase(bean);
		// 获取最新的编码
		String code = OnWrokflowProcess.getNewCode(BaseHelpUtils.getIntValue(pd.getProcessTypeId()));
		dao.setCode(code);
		dataValidate(dao);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getEmployeeMoneyManageId(), dao.getTitleName());
		//插入账单流水
		params.put("businessId", dao.getEmployeeMoneyManageId());
		params.put("processType", pd.getProcessTypeId());
		params.put("employeeId", employeeId);
		CustomSprocessbilllistppporProcess.deleteAndSaveDetailTables(params);
		//获取预算管理Id
		int budgetManagementId=BaseHelpUtils.getIntValue(params.get("budgetManagementId"));
		//获取附件id
		int budgetAttachmentId=BaseHelpUtils.getIntValue(params.get("budgetAttachmentId"));
		//获取付款序列id
		int paymentSequenceId=BaseHelpUtils.getIntValue(params.get("paymentSequenceId"));
		if(budgetManagementId>0&&budgetAttachmentId>0&&paymentSequenceId>0) {
			PaymentSequence payseqdao=new PaymentSequence();
			payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
			payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
			payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
			List<BasePaymentSequence>	list=payseqdao.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
				payseqdao.setIsLock(true);//加锁
				payseqdao.setReimbursementCode(code);
				payseqdao.setProcessId(pd.getProcessId());
				payseqdao.setProcessType(pd.getProcessTypeId());
				payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_THREE);//付款申请中
				payseqdao.setApplyPayDate(new Date());
				payseqdao.setBindStatus(StaticUtils.BD_BIND_STATUS_ALREADY);//已绑定状态
				payseqdao.conditionalUpdate();
				BudgetAttachment baDao=new BudgetAttachment();
				baDao.setBudgetAttachmentId(budgetAttachmentId);
				if(baDao.load()) {
					baDao.setIsLock(true);//给预算附件加锁
					baDao.update();
				}
			}
		}
		//增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getFileId());
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed)
			throws Exception {
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
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setPrimaryKeyFromBase(bean);
		if (!dao.load())
			throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dataValidate(dao);
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BaseEmployeeMoneyManage.CS_FILE_ID);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		BusinessAbstract ba = new BusinessAbstract(dao.getEmployeeMoneyManageId(), dao.getTitleName());
		//插入与修改账单流水
		params.put("businessId", dao.getEmployeeMoneyManageId());
		params.put("processType", pi.getProcessInstance().getProcessType());
		params.put("employeeId", employeeId);
		//由于财务出纳一般处于最后一个节点  所以还是需要修改数据   所以主数据的修改在最后一个节点还是进行修改的  (财务出纳会改成处理节点)
		CustomSprocessbilllistppporProcess.deleteAndSaveDetailTables(params);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				CustomSprocessbilllistppporProcess.passProcessBillList(params);
				dao.setIsCompleted(Boolean.TRUE);
				Calendar c = Calendar.getInstance();
				BigDecimal rate = ExchangeRateUtils.getTodayExchangeRate(dao.getCurrency());
				if(null == rate) {
					throw new Exception("获取汇率失败");
				}
				dao.setExchangeRate(rate);
				/*Integer processTypeId = pi.getProcessInstance().getProcessType();
				Integer processId = pi.getProcessInstance().getProcessId();
				Integer processInstanceId = pi.getProcessInstance().getProcessInstanceId();
				Integer businessId =BaseHelpUtils.getIntValue(bean.getEmployeeMoneyManageId());
				int projectId=BaseHelpUtils.getIntValue(bean.getProjectId());
				//如果项目ID不为null,扣除相应项目积分
				if(!BaseHelpUtils.isNullOrEmpty(projectId)&&projectId>0) {
					Project pDao=new Project();
					pDao.clear();
					pDao.setProjectId(projectId);
					if(pDao.load()) {
						//获取借款金额
						BigDecimal borrowMoney=BaseHelpUtils.getBigDecimalValue(bean.getBorrowMoney());
						ProjectCost  costDao=new ProjectCost();
						if(borrowMoney.compareTo(BigDecimal.ZERO)>=0) {
							costDao.setProjectId(projectId);
							costDao.setEmployeeId(bean.getEmployeeId());
							costDao.setAmount(borrowMoney);
							//设置花费类型为借款
							costDao.setCostType(StaticUtils.PROJECT_COST_TYPE_7);
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
				Integer processTypeId = pi.getProcessInstance().getProcessType();
				if(paymentSequenceId>0&&budgetManagementId>0&&budgetAttachmentId>0) {
					PaymentSequence payseqdao=new PaymentSequence();
					payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
					payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
					payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
					List<BasePaymentSequence>	list=payseqdao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
						ProcessBillList  biDao=new ProcessBillList();
						biDao.clear();
						biDao.setConditionBusinessId("=",  bean.getEmployeeMoneyManageId());
						biDao.setConditionProcessType("=", processTypeId);
						List<BaseProcessBillList> bilist=biDao.conditionalLoad();
						if(!BaseHelpUtils.isNullOrEmpty(bilist)&&bilist.size()>0) {
							//获取流水报销金额
							BigDecimal payMoney=BigDecimal.ZERO;
							//获取流水冲账金额
							BigDecimal balanceAmount=BigDecimal.ZERO;
							//获取收款方Id
							int employeeOrcompanyId=0;
							int payfor=0;
							//获取收款方名称
							String payName="";
							for (BaseProcessBillList biBean : bilist) {
								payMoney=BaseHelpUtils.getBigDecimalValue(biBean.getPayMoney()).add(payMoney);
								balanceAmount=BaseHelpUtils.getBigDecimalValue(biBean.getBalanceAmount()).add(balanceAmount);
								payfor=BaseHelpUtils.getIntValue(biBean.getPayFor());
								payName=BaseHelpUtils.getString(biBean.getPayeeName());
								employeeOrcompanyId=BaseHelpUtils.getIntValue(biBean.getEmployeeOrCompanyId());
							}

							BudgetManagement bddao=new BudgetManagement();
							bddao.setBudgetManagementId(budgetManagementId);
							if(bddao.load()) {
								BaseBudgetManagement bdbean=bddao.generateBase();
								//获取预付金额
								BigDecimal payAmount=BaseHelpUtils.getBigDecimalValue(bean.getBorrowMoney()); 
								//获取已用金额
								BigDecimal bdUseAmout=BaseHelpUtils.getBigDecimalValue(bdbean.getBdUseAmount());
								//获取剩余金额
								BigDecimal BdRestAmount=BaseHelpUtils.getBigDecimalValue(bdbean.getBdRestAmount());
								bdUseAmout=bdUseAmout.add(payAmount);
								BdRestAmount=BdRestAmount.subtract(payAmount);
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
								//获取借款金额
								BigDecimal amount=BaseHelpUtils.getBigDecimalValue(bean.getBorrowMoney()); 
								budgetContractAmountUse=budgetContractAmountUse.add(amount);
								budgetContractAmountRest=budgetContractAmountRest.subtract(amount);
								bdadao.setBudgetContractAmountUse(budgetContractAmountUse);
								bdadao.setBudgetContractAmountRest(budgetContractAmountRest);
								bdadao.update();
							}else {
								throw new Exception("找不到预算附件主键");
							}

							payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_TWO);//已付款
							payseqdao.setPayDate(new Date());
							payseqdao.setPayAmount(bean.getBorrowMoney());
							payseqdao.setReceiveUnitManageId(employeeOrcompanyId);//设置收款方
							payseqdao.setPayFor(payfor);
							payseqdao.setPayName(payName);
							payseqdao.conditionalUpdate();
							payseqdao.clear();
						}else {
							throw new Exception("找不到报销流水");
						}
					}else {
						throw new Exception("找不到付款序列");
					}
				}
			}
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){//被驳回
				//流程被驳回则消息通知发起人
				String code = bean.getCode();
				ProcessInstance processInstance = pi.getProcessInstance();
				Integer processType = processInstance.getProcessType(); 
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
				SendMSGCommon sendMSGCommon =new SendMSGCommon();
				Map map =new HashMap<String, Object>();
				map.put("code", code);
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

				//流程驳回时更改员工资金子表中的状态为无效
				int employeeFundIssuanceId = BaseHelpUtils.getIntValue(params.get("employeeFundIssuanceId"));
				if (employeeFundIssuanceId != 0) {
					EmployeeSalaryTypeProcess employeeSalaryTypeProcess = new EmployeeSalaryTypeProcess();
					employeeSalaryTypeProcess.deletePrepayment(employeeFundIssuanceId);
				}
			}
		}
		dao.update();
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);

		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e=OnWrokflowProcess.setExpression(expression, e, employeeId, bean.getBorrowMoney() , null, null);
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
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		dao.setEmployeeMoneyManageId(businessId);
		dao.load();
		dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getFileId()));
		return dao.generateBase().toJSON();
	}

	public void dataValidate(EmployeeMoneyManage dao) throws Exception {
		if (BaseHelpUtils.isNullOrZero(dao.getOperateEmployeeId())) {
			throw new Exception("起草人有误");
		}
	}
}
