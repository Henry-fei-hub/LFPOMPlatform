package pomplatform.workflow.commonNormalReimbursement.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

import com.pomplatform.db.dao.*;
import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBudgetAttachment;
import com.pomplatform.db.bean.BaseBudgetManagement;
import com.pomplatform.db.bean.BaseInputTaxRecord;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;
import com.pomplatform.db.bean.BasePaymentSequence;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Department;
import delicacy.system.dao.Employee;
import delicacy.system.dao.EmployeeRole;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.exchangerate.utils.ExchangeRateUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.business.ReimbursementInvoiceUtils;
import pomplatform.workflow.commonNormalReimbursement.bean.BaseProjectNormalReimbursementWithPn;
import pomplatform.workflow.commonNormalReimbursement.dao.ProjectNormalReimbursementWithPn;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;

public class NormalReimbursementWithDepartmentWorker implements GenericWorkflowProcessor {

	private Logger logger = Logger.getLogger(NormalReimbursementWithDepartmentWorker.class);

	protected BaseProjectNormalReimbursementWithPn bean = new BaseProjectNormalReimbursementWithPn();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		//普通日常报销（薪资发放以及奖金发放排除重复流程）
//		BaseHelpUtils.getIntValue(params.get(""))


		bean.setDataFromMap(params);
		bean.setApplyEmployeeId(employeeId);
		bean.setIsProject(false);
		String code=OnWrokflowProcess.getNewCode(BaseHelpUtils.getIntValue(pd.getProcessTypeId()));
		bean.setCode(code);
		ProjectNormalReimbursementWithPn dao = new ProjectNormalReimbursementWithPn();
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getProjectNormalReimbursementId(), dao.getReimbursementName());
		//插入账单流水
		params.put("businessId", dao.getProjectNormalReimbursementId());
		params.put("processType", pd.getProcessTypeId());
		params.put("employeeId", employeeId);
		CustomSprocessbilllistppporProcess.deleteAndSaveDetailTables(params);

		//获取预算管理Id
		int budgetManagementId=BaseHelpUtils.getIntValue(params.get("budgetManagementId"));
		//获取附件id
		int budgetAttachmentId=BaseHelpUtils.getIntValue(params.get("budgetAttachmentId"));
		//获取付款序列id
		int paymentSequenceId=BaseHelpUtils.getIntValue(params.get("paymentSequenceId"));
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
		//增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getAttachmentId());
		
		// 费用分担关联发票处理
		List<Map<String, Integer>> mainListData = new ArrayList<>();
		NormalReimbursementLinkDepartment nrldDao = new NormalReimbursementLinkDepartment();
		nrldDao.setConditionProjectNormalReimbursementId("=", dao.getProjectNormalReimbursementId());
		List<BaseNormalReimbursementLinkDepartment> detailList = nrldDao.conditionalLoad();
		for (BaseNormalReimbursementLinkDepartment baseNormalReimbursementLinkDepartment : detailList) {
			if((null != baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice() 
					&&  baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice().equals(2)) 
					|| (null != baseNormalReimbursementLinkDepartment.getInputTax() && baseNormalReimbursementLinkDepartment.getInputTax().compareTo(BigDecimal.ZERO) > 0)) {
				Map<String, Integer> tmpMap = new HashMap<>();
				tmpMap.put("invoiceLinkKey", baseNormalReimbursementLinkDepartment.getInvoiceLinkKey());
				tmpMap.put("detailId", baseNormalReimbursementLinkDepartment.getNormalReimbursementLinkDepartmentId());
				mainListData.add(tmpMap);
			}
		}
		Map<String, Object> invoiceListMap = null;
		if(params.containsKey("invoiceListMap") && null != params.get("invoiceListMap")) {
			invoiceListMap = (Map<String, Object>) params.get("invoiceListMap");
		}
		ReimbursementInvoiceUtils.saveOrUpdateReimbusementInvoiceData(null, dao.getProjectNormalReimbursementId(), pd.getProcessTypeId(), mainListData, invoiceListMap, 1);
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
			//获取当前活动节点
			ProcessInstanceActivity currentActiveActivity = pIns.getActiveActivity();
			if(!BaseHelpUtils.isNullOrEmpty(currentActiveActivity)) {
				//获取当前活动节点名称
				String nodeName = BaseHelpUtils.getString(currentActiveActivity.getBackViewName());
				if(nodeName.equals(StaticUtils.NODE_NAME_ONE)) {//如果是财务会计节点，则推送提醒消息给到发起人，提醒打印报销单和贴发票
					//获取发起人，而不是报销人
					int applyEmpId = BaseHelpUtils.getIntValue(bean.getApplyEmployeeId());
					if(applyEmpId > 0) {
						//获取报销类型
						int processType = BaseHelpUtils.getIntValue(currentActiveActivity.getProcessType());
						//获取报销类型名称
						String processTypeName = SelectValueCache.getSelectValue("system_process_types", processType+"");
						//获取报销编号
						String code = BaseHelpUtils.getString(bean==null?"":bean.getCode());
						ERPWeixinUtils.sendWXMsgToUser(applyEmpId, String.format(WeixinStatics.MSG_REIMBURSEMENT_MSG,code,processTypeName));
					}
				}
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
		ProjectNormalReimbursementWithPn dao = new ProjectNormalReimbursementWithPn();
		dao.setPrimaryKeyFromBase(bean);
		if (!dao.load())
			throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(null == dao.getDetailProjectNormalReimbursementDetail()){
			ProjectNormalReimbursementDetail detailDao = new ProjectNormalReimbursementDetail();
			detailDao.setConditionProjectNormalReimbursementId("=", dao.getProjectNormalReimbursementId());
			dao.setDetailProjectNormalReimbursementDetail(detailDao.conditionalLoad());
		}
		if(null == dao.getDetailNormalReimbursementLinkDepartment()){
			NormalReimbursementLinkDepartment linkDao = new NormalReimbursementLinkDepartment();
			linkDao.setConditionProjectNormalReimbursementId("=", dao.getProjectNormalReimbursementId());
			dao.setDetailNormalReimbursementLinkDepartment(linkDao.conditionalLoad());
		}
		dataValidate(dao);
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BaseProjectNormalReimbursement.CS_ATTACHMENT_ID);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		BusinessAbstract ba = new BusinessAbstract(dao.getProjectNormalReimbursementId(), dao.getReimbursementName());
		//插入与修改账单流水
		params.put("businessId", dao.getProjectNormalReimbursementId());
		params.put("processType", pi.getProcessInstance().getProcessType());
		params.put("employeeId", employeeId);
		//由于财务出纳一般处于最后一个节点  所以还是需要修改数据   所以主数据的修改在最后一个节点还是进行修改的  (财务出纳会改成处理节点)
		CustomSprocessbilllistppporProcess.deleteAndSaveDetailTables(params);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				CustomSprocessbilllistppporProcess.passProcessBillList(params);
				dao.setIsCompleted(true);
				//部门成本记录下来
				Integer processTypeId = pi.getProcessInstance().getProcessType();
				Integer businessId = dao.getProjectNormalReimbursementId();
				String remark = dao.getReimbursementName();
				Integer processId = pi.getProcessInstance().getProcessId();
				Integer processInstanceId = pi.getProcessInstance().getProcessInstanceId();
				PlateCostRecord pcrDao = new PlateCostRecord();
				pcrDao.setConditionProcessInstanceId("=", processInstanceId);
				pcrDao.setConditionProcessType("=", processTypeId);
				if(pcrDao.countRows() <= 0){
					List<BaseNormalReimbursementLinkDepartment> list=dao.getDetailNormalReimbursementLinkDepartment();
					if(list.size()>0){
						Calendar c = Calendar.getInstance();
						BigDecimal rate = ExchangeRateUtils.getTodayExchangeRate(dao.getCurrency());
						if(null == rate) {
							throw new Exception("获取汇率失败");
						}
						dao.setExchangeRate(rate);
						for(BaseNormalReimbursementLinkDepartment baseNormal:list){
							//保存部门成本
							PlateCostRecord plateCostRecord=new PlateCostRecord();
							Department department=new Department();
							department.setDepartmentId(baseNormal.getDepartmentId());
							if(department.load()){
								plateCostRecord.setPlateId(department.getPlateId());
							}
							plateCostRecord.setCostIntegral(baseNormal.getFinalAmount().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN));
							plateCostRecord.setSalaryIntegral(new BigDecimal("0"));
							plateCostRecord.setIsSettlement(false);
							//获取当前的年月
							plateCostRecord.setYear(c.get(Calendar.YEAR));
							plateCostRecord.setMonth(c.get(Calendar.MONTH)+1);
							plateCostRecord.setCostDate(c.getTime());
							plateCostRecord.setProcessType(processTypeId);
							plateCostRecord.setBusinessId(businessId);
							plateCostRecord.setProcessId(processId);
							plateCostRecord.setProcessInstanceId(processInstanceId);
							plateCostRecord.setRemark(remark);
							plateCostRecord.save();
							//同时更新数据到部门积分汇总表中
							PlateAccountRecord plateAccountRecordDao = new PlateAccountRecord();
							plateAccountRecordDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_PLATE_COST);
							plateAccountRecordDao.setBusinessId(plateCostRecord.getPlateCostRecordId());
							plateAccountRecordDao.setPlateId(plateCostRecord.getPlateId());
							plateAccountRecordDao.setIntegral(plateCostRecord.getCostIntegral());
							plateAccountRecordDao.setRecordDate(plateCostRecord.getCostDate());
							plateAccountRecordDao.setOperateEmployeeId(employeeId);
							plateAccountRecordDao.setOperateTime(c.getTime());
							plateAccountRecordDao.setRemark(remark);
							plateAccountRecordDao.save();
						}
					}
				}


				//获取付款序列id
				int paymentSequenceId=BaseHelpUtils.getIntValue(bean.getPaymentSequenceId());
				//获取预算管理Id
				int budgetManagementId=BaseHelpUtils.getIntValue(bean.getBudgetManagementId());
				//获取预算附件id
				int budgetAttachmentId=BaseHelpUtils.getIntValue(bean.getBudgetAttachmentId());
				if(paymentSequenceId>0&&budgetManagementId>0&&budgetAttachmentId>0) {
					PaymentSequence payseqdao=new PaymentSequence();
					payseqdao.setConditionPaymentSequenceId("=", paymentSequenceId);
					payseqdao.setConditionBudgetManagementId("=", budgetManagementId);
					payseqdao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
					List<BasePaymentSequence>	list=payseqdao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
						ProcessBillList  biDao=new ProcessBillList();
						biDao.clear();
						biDao.setConditionBusinessId("=", bean.getProjectNormalReimbursementId());
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
								//获取预算已用金额
								BigDecimal bdUseAmout=BaseHelpUtils.getBigDecimalValue(bdbean.getBdUseAmount());
								//获取预算剩余金额
								BigDecimal BdRestAmount=BaseHelpUtils.getBigDecimalValue(bdbean.getBdRestAmount());
								//获取报销金额
								//BigDecimal amount=BaseHelpUtils.getBigDecimalValue(bean.getAmount()); 
								bdUseAmout=bdUseAmout.add(payMoney);
								BdRestAmount=BdRestAmount.subtract(payMoney);
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
								budgetContractAmountUse=budgetContractAmountUse.add(payMoney);
								budgetContractAmountRest=budgetContractAmountRest.subtract(payMoney);
								bdadao.setBudgetContractAmountUse(budgetContractAmountUse);
								bdadao.setBudgetContractAmountRest(budgetContractAmountRest);
								bdadao.update();
							}else {
								throw new Exception("找不到预算附件主键");
							}
							
							payseqdao.setPayStatus(StaticUtils.BD_PAY_STATUS_TWO);//已付款
							payseqdao.setReimbursementAmount(payMoney);//设置序列报销金额为流水付款金额
							payseqdao.setPayAmount(payMoney);//设置付款序列付款金额为流水付款金额
							payseqdao.setReverseAmount(balanceAmount);//设置付款序列冲账金额为流水冲账金额
							payseqdao.setReceiveUnitManageId(employeeOrcompanyId);//设置收款方
							payseqdao.setPayDate(new Date());
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
				
				int bunessId=BaseHelpUtils.getIntValue(bean.getProjectNormalReimbursementId());
				InputTaxRecord rdao=new InputTaxRecord();
				rdao.setConditionBusinessId("=", bunessId);
				List<BaseInputTaxRecord> rlist=rdao.conditionalLoad();
                if(!BaseHelpUtils.isNullOrEmpty(rlist)&&rlist.size()>0) {
                	rdao.setOverTime(new Date());
                	rdao.conditionalUpdate();
                }
				
			}
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){//被驳回
				//流程被驳回则消息通知发起人
				String code = bean.getCode();
				ProcessInstance processInstance = pi.getProcessInstance();
				Integer processType = processInstance.getProcessType(); 
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getApplyEmployeeId());
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
			}
		}
		// 查询出原有报销费用清单详情数据
		NormalReimbursementLinkDepartment nrldDao = new NormalReimbursementLinkDepartment();
		nrldDao.setConditionProjectNormalReimbursementId("=", dao.getProjectNormalReimbursementId());
		List<BaseNormalReimbursementLinkDepartment> oriDetailList = nrldDao.conditionalLoad();
		Set<Integer> oriDetailSet = new HashSet<>();
		for (BaseNormalReimbursementLinkDepartment baseNormalReimbursementLinkDepartment : oriDetailList) {
			oriDetailSet.add(baseNormalReimbursementLinkDepartment.getNormalReimbursementLinkDepartmentId());
		}
		
		dao.update();
		
		// 需要报销费用清单相关联的发票数据
		nrldDao.clear();
		List<Map<String, Integer>> mainListData = new ArrayList<>();
		nrldDao.setConditionProjectNormalReimbursementId("=", dao.getProjectNormalReimbursementId());
		List<BaseNormalReimbursementLinkDepartment> detailList = nrldDao.conditionalLoad();
		for (BaseNormalReimbursementLinkDepartment baseNormalReimbursementLinkDepartment : detailList) {
			if((null != baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice() 
					&&  baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice().equals(2)) 
					|| (null != baseNormalReimbursementLinkDepartment.getInputTax() && baseNormalReimbursementLinkDepartment.getInputTax().compareTo(BigDecimal.ZERO) > 0)) {
				Map<String, Integer> tmpMap = new HashMap<>();
				tmpMap.put("invoiceLinkKey", baseNormalReimbursementLinkDepartment.getInvoiceLinkKey());
				tmpMap.put("detailId", baseNormalReimbursementLinkDepartment.getNormalReimbursementLinkDepartmentId());
				mainListData.add(tmpMap);
			}
		}
		Map<String, Object> invoiceListMap = null;
		if(params.containsKey("invoiceListMap") && null != params.get("invoiceListMap")) {
			invoiceListMap = (Map<String, Object>) params.get("invoiceListMap");
		}
		ReimbursementInvoiceUtils.saveOrUpdateReimbusementInvoiceData(oriDetailSet, dao.getProjectNormalReimbursementId(), 
				pi.getProcessDefinition().getProcessTypeId(), mainListData, invoiceListMap, 2);
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		int feeType = BaseHelpUtils.getIntValue(bean.getFeeType());
		BigDecimal amount= BaseHelpUtils.getBigDecimalValue(bean.getAmount());
		int reimbursementType=  BaseHelpUtils.getIntValue(bean.getReimbursementType());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,amount,feeType,null);
		if(expression.contains(StaticUtils.REIMBURSEMENT_TYPE)){
			if(reimbursementType==StaticUtils.REIMBURSEMENT_TYPE_1){
				e.setValue(StaticUtils.REIMBURSEMENT_TYPE,StaticUtils.REIMBURSEMENT_TYPE_6_NAME);
			}else if(reimbursementType==StaticUtils.REIMBURSEMENT_TYPE_2){
				e.setValue(StaticUtils.REIMBURSEMENT_TYPE,StaticUtils.REIMBURSEMENT_TYPE_7_NAME);
			}else if(reimbursementType==StaticUtils.REIMBURSEMENT_TYPE_3){
				e.setValue(StaticUtils.REIMBURSEMENT_TYPE,StaticUtils.REIMBURSEMENT_TYPE_8_NAME);
			}else if(reimbursementType==StaticUtils.REIMBURSEMENT_TYPE_4){
				e.setValue(StaticUtils.REIMBURSEMENT_TYPE,StaticUtils.REIMBURSEMENT_TYPE_9_NAME);
			}else if(reimbursementType==StaticUtils.REIMBURSEMENT_TYPE_5){
				e.setValue(StaticUtils.REIMBURSEMENT_TYPE,StaticUtils.REIMBURSEMENT_TYPE_10_NAME);
			}else if(reimbursementType==StaticUtils.REIMBURSEMENT_TYPE_6){
				e.setValue(StaticUtils.REIMBURSEMENT_TYPE,StaticUtils.REIMBURSEMENT_TYPE_11_NAME);
			}else if(reimbursementType==StaticUtils.REIMBURSEMENT_TYPE_7){
				e.setValue(StaticUtils.REIMBURSEMENT_TYPE,StaticUtils.REIMBURSEMENT_TYPE_12_NAME);
			}else if(reimbursementType==StaticUtils.REIMBURSEMENT_TYPE_8){
				e.setValue(StaticUtils.REIMBURSEMENT_TYPE,StaticUtils.REIMBURSEMENT_TYPE_13_NAME);
			}else {
				e.setValue(StaticUtils.REIMBURSEMENT_TYPE,"");
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
		Boolean ex = delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
		return ex;
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		if(!BaseHelpUtils.isNullOrEmpty(roleId) && roleId==3 && BaseHelpUtils.isNullOrZero(departmentId)){
			List<BaseNormalReimbursementLinkDepartment> list = bean.getDetailNormalReimbursementLinkDepartment();
			if (list == null || list.isEmpty()) {
				throw new SQLException("请选择一个部门！");
			}
			Set<Integer> ownerSet = new HashSet<>();
			for (BaseNormalReimbursementLinkDepartment b : list) {
				Integer id = b.getDepartmentId();
				if(id == null || id.equals(0)){
					throw new Exception("请选择一个部门！");
				}
				do{
					int[] tempArr = NormalReimbursementWithDepartmentWorker.findNextOwner(id, roleId);
					if (null != tempArr && tempArr.length > 0) {
						for (int userId : tempArr) {
							ownerSet.add(userId);
						}
						break;
					}else{
						Department departmentDao = new Department();
						departmentDao.unsetSelectFlags();
						departmentDao.setSelectParentId(true);
						departmentDao.setConditionDepartmentId("=", id);
						id = departmentDao.executeQueryOneRow().getParentId();
					}
				}while(BaseHelpUtils.getIntValue(id) > 1);
			}
			if (!ownerSet.isEmpty()) {
				int length = ownerSet.size();
				int[] activityOwners = new int[length];
				int i = 0;
				for (Integer obj : ownerSet) {
					activityOwners[i] = BaseHelpUtils.getIntValue(obj);
					i++;
				}
				return activityOwners;
			} else {
				return new int[0];
			}
		}else{
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		}

		//		List<BaseNormalReimbursementLinkDepartment> list = bean.getDetailNormalReimbursementLinkDepartment();
		//		if (null != list && !list.isEmpty()) {
		//			int size = list.size();
		//			Map<Integer, Object> ownerMap = new HashMap<>();
		//			if (null != roleId && poolType != null && poolType != 0) {
		//				for (int i = 0; i < size; i++) {
		//					Integer id = list.get(i).getDepartmentId();
		//					if (null != id) {
		//						int[] tempArr = ProcessUtil.findNextOwner(processCreator, employeeId, id, roleId);
		//						if (null != tempArr) {
		//							for (int userId : tempArr) {
		//								ownerMap.put(userId, null);
		//							}
		//						}
		//					} else {
		//						throw new Exception("请选择一个部门！");
		//					}
		//				}
		//				if (!ownerMap.isEmpty()) {
		//					int length = ownerMap.size();
		//					int[] activityOwners = new int[length];
		//					int i = 0;
		//					for (Integer obj : ownerMap.keySet()) {
		//						activityOwners[i] = BaseHelpUtils.getIntValue(obj);
		//						i++;
		//					}
		//					return activityOwners;
		//				} else {
		//					return new int[0];
		//				}
		//			} else {
		//				return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		//			}
		//		} else {
		//			throw new SQLException("请选择一个部门！");
		//		}
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		ProjectNormalReimbursementWithPn dao = new ProjectNormalReimbursementWithPn();
		dao.setProjectNormalReimbursementId(businessId);
		dao.load(true);
		dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getAttachmentId()));
		return dao.generateBaseExt().toJSON();
	}

	public static int[] findNextOwner(Integer departmentId, Integer roleId) throws Exception {
		if (departmentId != null && roleId != null && departmentId != 0 && roleId != 0) {
			EmployeeRole er = new EmployeeRole();
			er.unsetSelectFlags();
			er.setSelectEmployeeId(true);
			er.setConditionDepartmentId("=", departmentId);
			er.setConditionRoleId("=", roleId);
			List<BaseEmployeeRole> bers = er.conditionalLoad();
			if (bers.size() > 0) {
				Object[] arr = new Object[bers.size()];
				int idx = 0;
				for (BaseEmployeeRole ber : bers) {
					arr[idx++] = ber.getEmployeeId();
				}
				Employee employeeDao = new Employee();
				employeeDao.unsetSelectFlags();
				employeeDao.setSelectEmployeeId(true);
				employeeDao.setConditionStatus("=", 0);// 在职人员
				employeeDao.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", arr);
				List<BaseEmployee> list = employeeDao.conditionalLoad();
				if (null != list && !list.isEmpty()) {
					int size = list.size();
					int[] res = new int[size];
					for (int i = 0; i < size; i++) {
						res[i] = list.get(i).getEmployeeId();
					}
					return res;
				}
			}
		}
		return new int[0];
	}

	public void dataValidate(ProjectNormalReimbursementWithPn dao) throws Exception {
		if (BaseHelpUtils.isNullOrEmpty(dao.getReimbursementName())) {
			throw new Exception("请填写主题");
		}
		if (BaseHelpUtils.isNullOrZero(dao.getApplyEmployeeId())) {
			throw new Exception("起草人有误");
		}
		if (BaseHelpUtils.isNullOrZero(dao.getEmployeeId())) {
			throw new Exception("请选择报销人");
		}
		if (null == dao.getAmount() || dao.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("报销金额必须大于0");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getCompanyId())) {
			throw new Exception("请选择归属公司");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getReimbursementType())) {
			throw new Exception("请选择报销类型");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getRemark())) {
			throw new Exception("请填写备注");
		}
		if(BaseHelpUtils.getBoolean(dao.getRelatedToContract())) {
			if(BaseHelpUtils.isNullOrEmpty(dao.getContractAmount())) {
				throw new Exception("请填写合同金额");
			}
			if(BaseHelpUtils.isNullOrEmpty(dao.getReceiveUnitId())) {
				throw new Exception("请选择供应商");
			}
			if(BaseHelpUtils.isNullOrEmpty(dao.getPurchaserDepartment())) {
				throw new Exception("请选择采购人归属部门");
			}
			if(BaseHelpUtils.isNullOrEmpty(dao.getPurchaser())) {
				throw new Exception("请选择采购人");
			}
			if(BaseHelpUtils.isNullOrEmpty(dao.getPurchasingCategory())) {
				throw new Exception("请填写采购类别");
			}
		}else {
			dao.setContractAmount(null);
			dao.setReceiveUnitId(null);
			dao.setPurchaserDepartment(null);
			dao.setPurchaser(null);
			dao.setPurchasingCategory(null);
		}
		List<BaseProjectNormalReimbursementDetail> commonNormalReimbursementDetailList = dao
				.getDetailProjectNormalReimbursementDetail();
		if (null == commonNormalReimbursementDetailList || commonNormalReimbursementDetailList.isEmpty()) {
			throw new Exception("请填写日常报销明细");
		}
		List<BaseNormalReimbursementLinkDepartment> commonReimbursementLinkDepartmentList = dao
				.getDetailNormalReimbursementLinkDepartment();
		if (null == commonReimbursementLinkDepartmentList || commonReimbursementLinkDepartmentList.isEmpty()) {
			throw new Exception("请添加需要承担本次报销金额的部门");
		}
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal inputTaxAndFinalAmount = BigDecimal.ZERO;
		for (BaseNormalReimbursementLinkDepartment obj : commonReimbursementLinkDepartmentList) {
			if (null != obj.getAmount()) {
				sum = sum.add(obj.getAmount());
			}
			if(null != obj.getInputTax()) {
				inputTaxAndFinalAmount = inputTaxAndFinalAmount.add(obj.getInputTax());
			}
			if(null != obj.getFinalAmount()) {
				inputTaxAndFinalAmount = inputTaxAndFinalAmount.add(obj.getFinalAmount());
			}
			if(null != obj.getInputTaxRebate()) {
				inputTaxAndFinalAmount = inputTaxAndFinalAmount.subtract(obj.getInputTaxRebate());
			}
		}
		if (dao.getAmount().compareTo(sum) != 0) {
			throw new Exception("报销金额分拆前后的总数不一致");
		}
		if(sum.compareTo(inputTaxAndFinalAmount) != 0) {
			throw new Exception("进项税 + 成本 - 进项税转出 != 报销金额");
		}
		BigDecimal detailAmount = BigDecimal.ZERO;
        for(BaseProjectNormalReimbursementDetail obj : commonNormalReimbursementDetailList) {
        	if(null != obj.getAmount()) {
        		detailAmount = detailAmount.add(obj.getAmount());
        	}
        }
        if (dao.getAmount().compareTo(detailAmount) != 0) {
            throw new Exception("报销明细的金额之和与报销总金额不一致");
        }
	}
	public static void main(String[] args) {
		try {
			/*String expression = "时间 > '2017-01-01'";
			Expression e = new Expression(expression);
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, 2017);
			c.set(Calendar.MONTH, 0);
			c.set(Calendar.DATE, 1);
			c.set(Calendar.HOUR_OF_DAY, 1);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = c.getTime();
			System.out.println(format.format(date));
//			e.setValue("时间", format.format(date));
			Object a = null;
			e.setValue("时间", "");*/

//			System.out.println(delicacy.system.executor.ProcessUtil.executeExpression(e, expression));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
