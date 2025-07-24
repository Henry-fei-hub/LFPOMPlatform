package pomplatform.workflow.projectTravelReimbursement.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pomplatform.db.bean.BaseBudgetAttachment;
import com.pomplatform.db.bean.BaseBudgetManagement;
import com.pomplatform.db.bean.BaseInputTaxRecord;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BasePaymentSequence;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;
import com.pomplatform.db.dao.*;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.CommonUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.exchangerate.utils.ExchangeRateUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.business.ReimbursementInvoiceUtils;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;
import pomplatform.workflow.projectTravelReimbursement.bean.BaseTravelReimbursementWithTt;
import pomplatform.workflow.projectTravelReimbursement.dao.TravelReimbursementWithTt;

public class NewProjectTravelReimbursementWorker implements GenericWorkflowProcessor {

	protected BaseTravelReimbursementWithTt bean = new BaseTravelReimbursementWithTt();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setDrafter(employeeId);
		bean.setIsProject(true);
		String code=OnWrokflowProcess.getNewCode(BaseHelpUtils.getIntValue(pd.getProcessTypeId()));
		bean.setCode(code);
		TravelReimbursementWithTt dao = new TravelReimbursementWithTt();
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getTravelReimbursementId(), dao.getTitle());
		//插入账单流水
		params.put("businessId", dao.getTravelReimbursementId());
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
		TravelReimbursementLinkProject nrldDao = new TravelReimbursementLinkProject();
		nrldDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
		List<BaseTravelReimbursementLinkProject> detailList = nrldDao.conditionalLoad();
		for (BaseTravelReimbursementLinkProject baseNormalReimbursementLinkDepartment : detailList) {
			if((null != baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice()
					&&  baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice().equals(2))
					|| (null != baseNormalReimbursementLinkDepartment.getInputTax() && baseNormalReimbursementLinkDepartment.getInputTax().compareTo(BigDecimal.ZERO) > 0)) {
				Map<String, Integer> tmpMap = new HashMap<>();
				tmpMap.put("invoiceLinkKey", baseNormalReimbursementLinkDepartment.getInvoiceLinkKey());
				tmpMap.put("detailId", baseNormalReimbursementLinkDepartment.getTravelReimbursementLinkProjectId());
				mainListData.add(tmpMap);
			}
		}
		Map<String, Object> invoiceListMap = null;
		if(params.containsKey("invoiceListMap") && null != params.get("invoiceListMap")) {
			invoiceListMap = (Map<String, Object>) params.get("invoiceListMap");
		}
		ReimbursementInvoiceUtils.saveOrUpdateReimbusementInvoiceData(null, dao.getTravelReimbursementId(), pd.getProcessTypeId(), mainListData, invoiceListMap, 1);
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
					int applyEmpId = BaseHelpUtils.getIntValue(bean.getDrafter());
					if(applyEmpId > 0) {
						//获取报销类型
						int processType = BaseHelpUtils.getIntValue(currentActiveActivity.getProcessType());
						//获取报销类型名称
						String processTypeName = SelectValueCache.getSelectValue("system_process_types", processType+"");
						//获取报销编号
						String code = BaseHelpUtils.getString(bean==null?"":bean.getCode());
						ERPWeixinUtils.sendWXMsgToUser(applyEmpId,String.format(WeixinStatics.MSG_REIMBURSEMENT_MSG,code,processTypeName));
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
		TravelReimbursementWithTt dao = new TravelReimbursementWithTt();
		dao.setPrimaryKeyFromBase(bean);
		if (!dao.load())
			throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(null == dao.getDetailTravelReimbursementDetail()){
			TravelReimbursementDetail detailDao = new TravelReimbursementDetail();
			detailDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
			dao.setDetailTravelReimbursementDetail(detailDao.conditionalLoad());
		}
		if(null == dao.getDetailTravelReimbursementLinkProject()){
			TravelReimbursementLinkProject departmentDao = new TravelReimbursementLinkProject();
			departmentDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
			dao.setDetailTravelReimbursementLinkProject(departmentDao.conditionalLoad());
		}
		dataValidate(dao);
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BaseTravelReimbursement.CS_ATTACHMENT_ID);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		BusinessAbstract ba = new BusinessAbstract(dao.getTravelReimbursementId(), dao.getTitle());
		Integer businessId = dao.getTravelReimbursementId();
		Integer processTypeId = pi.getProcessInstance().getProcessType();
		Integer processId = pi.getProcessInstance().getProcessId();
		Integer processInstanceId = pi.getProcessInstance().getProcessInstanceId();
		//插入与修改账单流水
		params.put("businessId", businessId);
		params.put("processType", processTypeId);
		params.put("employeeId", employeeId);
		//由于财务出纳一般处于最后一个节点  所以还是需要修改数据   所以主数据的修改在最后一个节点还是进行修改的  (财务出纳会改成处理节点)
		CustomSprocessbilllistppporProcess.deleteAndSaveDetailTables(params);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				CustomSprocessbilllistppporProcess.passProcessBillList(params);
				dao.setIsCompleted(true);
				//项目成本挂钩到项目上去
				ProjectCost costDao = new ProjectCost();
				costDao.setConditionProcessInstanceId("=", processInstanceId);
				costDao.setConditionProcessType("=", processTypeId);
				if(costDao.countRows() <= 0){
					List<BaseTravelReimbursementLinkProject> list = dao.getDetailTravelReimbursementLinkProject();
					if(null != list && !list.isEmpty()){
						Calendar c = Calendar.getInstance();
						BigDecimal rate = ExchangeRateUtils.getTodayExchangeRate(dao.getCurrency());
						if(null == rate) {
							throw new Exception("获取汇率失败");
						}
						dao.setExchangeRate(rate);
						Integer costEmployeeId = dao.getApplicant();
						List<BaseProjectCost> costList = new ArrayList<>();
//						Project pDao = new Project();
//						int projectManageId = 0;
						for(BaseTravelReimbursementLinkProject obj : list){
							BaseProjectCost cost = new BaseProjectCost();
							int projectId = obj.getProjectId();
							cost.setAmount(obj.getFinalAmount().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN));
							cost.setProjectId(projectId);
							cost.setCostDate(c.getTime());
							cost.setEmployeeId(costEmployeeId);
							cost.setStatus(StaticUtils.SETTLEMENT_STATUS_NO);
							cost.setProcessType(processTypeId);
							cost.setBusinessId(businessId);
							cost.setProcessId(processId);
							cost.setProcessInstanceId(processInstanceId);
							costList.add(cost);
//							pDao.clear();
//							pDao.setProjectId(projectId);
//							if(pDao.load()){
//								//获取项目的专业负责人
//								projectManageId = pDao.getProjectManageId();
//								String projectName = pDao.getProjectName();
//								if(projectManageId > 0){
//									//发送消息提醒专业负责人及时结算积分
//									String content = "您好，目前ERP系统上（"+projectName+"）有一个项目成本待结算，请您尽快登录ERP系统进行分摊成本，谢谢！";
//									ERPWeixinUtils.sendWXMsgToUser(projectManageId, content);
//								}
//							}
						}
						costDao.clear();
						costDao.save(costList);
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
						biDao.setConditionBusinessId("=", bean.getTravelReimbursementId());
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


				int bunessId=BaseHelpUtils.getIntValue(bean.getTravelReimbursementId());
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
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getDrafter());
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
		TravelReimbursementLinkProject nrldDao = new TravelReimbursementLinkProject();
		nrldDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
		List<BaseTravelReimbursementLinkProject> oriDetailList = nrldDao.conditionalLoad();
		Set<Integer> oriDetailSet = new HashSet<>();
		for (BaseTravelReimbursementLinkProject baseNormalReimbursementLinkDepartment : oriDetailList) {
			oriDetailSet.add(baseNormalReimbursementLinkDepartment.getTravelReimbursementLinkProjectId());
		}
		dao.update();

		// 需要报销费用清单相关联的发票数据
		nrldDao.clear();
		List<Map<String, Integer>> mainListData = new ArrayList<>();
		nrldDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
		List<BaseTravelReimbursementLinkProject> detailList = nrldDao.conditionalLoad();
		for (BaseTravelReimbursementLinkProject baseNormalReimbursementLinkDepartment : detailList) {
			if((null != baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice()
					&&  baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice().equals(2))
					|| (null != baseNormalReimbursementLinkDepartment.getInputTax() && baseNormalReimbursementLinkDepartment.getInputTax().compareTo(BigDecimal.ZERO) > 0)) {
				Map<String, Integer> tmpMap = new HashMap<>();
				tmpMap.put("invoiceLinkKey", baseNormalReimbursementLinkDepartment.getInvoiceLinkKey());
				tmpMap.put("detailId", baseNormalReimbursementLinkDepartment.getTravelReimbursementLinkProjectId());
				mainListData.add(tmpMap);
			}
		}
		Map<String, Object> invoiceListMap = null;
		if(params.containsKey("invoiceListMap") && null != params.get("invoiceListMap")) {
			invoiceListMap = (Map<String, Object>) params.get("invoiceListMap");
		}
		ReimbursementInvoiceUtils.saveOrUpdateReimbusementInvoiceData(oriDetailSet, dao.getTravelReimbursementId(),
				pi.getProcessDefinition().getProcessTypeId(), mainListData, invoiceListMap, 2);
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getApplicant());
		e=OnWrokflowProcess.setExpression(expression, e, employeeId, bean.getAmount(), null, null);
		e.setValue(OnWrokflowProcess.LINE_COMPANY_NAME, CommonUtils.getCompanyShortName(bean.getCompanyId()));
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

	@SuppressWarnings("unused")
	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
								   Integer poolType) throws Exception {
		if(BaseHelpUtils.getIntValue(roleId) == StaticUtils.ROLE_MAIN_PROJECT_PERSON_IN_CHARGE || BaseHelpUtils.getIntValue(roleId) == StaticUtils.ROLE_MAIN_PROJECT_MANAGER){//项目负责人或者项目经理
			List<BaseTravelReimbursementLinkProject> list = bean.getDetailTravelReimbursementLinkProject();
			if (list == null || list.isEmpty()) {
				throw new SQLException("请选择一个项目！");
			}
			Set<Integer> ownerSet = new HashSet<>();
			for (BaseTravelReimbursementLinkProject b : list) {
				Integer projectId = BaseHelpUtils.getIntValue(b.getProjectId());
				if (projectId == null) {
					throw new SQLException("请选择一个项目！");
				}
				MainProjectEmployee mpe = new MainProjectEmployee();
				if(BaseHelpUtils.getIntValue(roleId) == StaticUtils.ROLE_MAIN_PROJECT_PERSON_IN_CHARGE){
					mpe.setConditionRelation("=",5);//项目负责人
				}else{
					mpe.setConditionRelation("=",3);//项目经理
				}
				mpe.setConditionMainProjectId("=",projectId);
				List<BaseMainProjectEmployee> BaseList = mpe.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(BaseList)){
					for(BaseMainProjectEmployee e: BaseList){
						ownerSet.add(BaseHelpUtils.getIntValue(e.getEmployeeId()));
					}
				}
			}
			if (!ownerSet.isEmpty()) {
				Employee e = new Employee();
				e.unsetSelectFlags();
				e.setSelectEmployeeId(true);
				e.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
				e.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", ownerSet.toArray());
				List<BaseEmployee> employeeList = e.conditionalLoad();
				int length = employeeList.size();
				int[] activityOwners = new int[length];
				for (int i = 0; i < length; i++) {
					activityOwners[i] = BaseHelpUtils.getIntValue(employeeList.get(i).getEmployeeId());
				}
				return activityOwners;
			} else {
				return new int[0];
			}
		}else{
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		}

	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		TravelReimbursementWithTt dao = new TravelReimbursementWithTt();
		dao.setTravelReimbursementId(businessId);
		dao.load(true);
		dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getAttachmentId()));
		return dao.generateBaseExt().toJSON();
	}

	public void dataValidate(TravelReimbursementWithTt dao) throws Exception {
		if (BaseHelpUtils.isNullOrEmpty(dao.getTitle())) {
			throw new Exception("请填写主题");
		}
		if (BaseHelpUtils.isNullOrZero(dao.getDrafter())) {
			throw new Exception("起草人有误");
		}
		if (BaseHelpUtils.isNullOrZero(dao.getApplicant())) {
			throw new Exception("请选择报销人");
		}
		if(null == dao.getStartDate()){
			throw new Exception("出差开始日期不能为空");
		}
		if(null == dao.getEndDate()){
			throw new Exception("出差结束日期不能为空");
		}
		if (dao.getEndDate().getTime() - dao.getStartDate().getTime() < 0) {
			throw new Exception("出差结束日期必须大于等于开始日期");
		}
		if (null == dao.getAmount() || dao.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("报销金额必须大于0");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getCompanyId())) {
			throw new Exception("请选择归属公司");
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
		List<BaseTravelReimbursementDetail> travelReimbursementDetailList = dao.getDetailTravelReimbursementDetail();
		if (null == travelReimbursementDetailList || travelReimbursementDetailList.isEmpty()) {
			throw new Exception("请填写差旅报销明细");
		}
		List<BaseTravelReimbursementLinkProject> travelReimbursementLinkProjectList = dao
				.getDetailTravelReimbursementLinkProject();
		if (null == travelReimbursementLinkProjectList || travelReimbursementLinkProjectList.isEmpty()) {
			throw new Exception("请添加需要承担本次报销金额的项目");
		}
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal inputTaxAndFinalAmount = BigDecimal.ZERO;
		for (BaseTravelReimbursementLinkProject obj : travelReimbursementLinkProjectList) {
			if (null != obj.getAmount()) {
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
		}
		if (dao.getAmount().compareTo(sum) != 0) {
			throw new Exception("报销金额分拆前后的总数不一致");
		}
		if(sum.compareTo(inputTaxAndFinalAmount) != 0) {
			throw new Exception("进项税 + 成本 - 进项税转出 != 报销金额");
		}
	}
}
