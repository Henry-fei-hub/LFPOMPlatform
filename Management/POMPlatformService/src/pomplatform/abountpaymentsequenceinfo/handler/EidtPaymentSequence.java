package pomplatform.abountpaymentsequenceinfo.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeMoneyManage;
import com.pomplatform.db.bean.BasePayMoneyManage;
import com.pomplatform.db.bean.BasePaymentSequence;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.dao.BudgetAttachment;
import com.pomplatform.db.dao.BudgetManagement;
import com.pomplatform.db.dao.EmployeeMoneyManage;
import com.pomplatform.db.dao.PayMoneyManage;
import com.pomplatform.db.dao.PaymentSequence;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.TravelReimbursement;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;

public class EidtPaymentSequence implements GenericProcessor {

	//操作类型
	private static final String OPT_TYPE = "optType";
	//保存或删除付款序列
	private static final String SAVE_OR_UPDATE = "savaOrUpdate";
	//序列收款方类型
	private static final String  PAY_FOR_UPDATE = "payForUpdate";
	//报销信息录入预算
	private static final String  BUDGET_INTO = "budgetInto";
	//查询付款流程进度
	private static final String  PAY_STATUS_INTO = "payStatusInfo";
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		//获取操作类型
		String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
		if(SAVE_OR_UPDATE.equals(optType)){
			return savaOrUpdate(param);
		}else if(PAY_FOR_UPDATE.equals(optType)){
			return payForUpdate(param);
		}else if(BUDGET_INTO.equals(optType)){
			return budgetInfo(param);
		}else if(PAY_STATUS_INTO.equals(optType)){
			return payStatusInfo(param);
		}
		return null;
	}


	public String payForUpdate(Map<String, Object> params) throws Exception {
		//BaseCollection bc = new BaseCollection<>();
		int paymentSequenceId=BaseHelpUtils.getIntValue(params.get("paymentSequenceId"));
		int payFor=BaseHelpUtils.getIntValue(params.get("payFor"));
		PaymentSequence dao=new PaymentSequence();
		dao.clear();
		dao.setPaymentSequenceId(paymentSequenceId);
		if(dao.load()) {
			dao.setPayFor(payFor);
			dao.setReceiveUnitManageId(null);
			dao.setPayName(null);
			dao.update();
			return dao.generateBase().toOneLineJSON(0, null);
		}else {
			return dao.generateBase().toOneLineJSON(0, null);
		}
	}


	public String budgetInfo(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		PaymentSequence paydao=new PaymentSequence();
		BasePaymentSequence bean=new BasePaymentSequence();
		bean.setDataFromMap(params);
		paydao.setDataFromBase(bean);
		paydao.update();
		int paymentSequenceId=BaseHelpUtils.getIntValue(bean.getPaymentSequenceId());
		BigDecimal payMoney=bean.getPayAmount();
		int payStatus=BaseHelpUtils.getIntValue(bean.getPayStatus());
		if(payStatus==2) {
			if(paymentSequenceId>0) {
				if(paydao.load()) {
					bean=paydao.generateBase();
					//获取预算管理Id
					int budgetManagementId=BaseHelpUtils.getIntValue(bean.getBudgetManagementId());
					//获取附件id
					int budgetAttachmentId=BaseHelpUtils.getIntValue(bean.getBudgetAttachmentId());
					BudgetAttachment  bdadao=new BudgetAttachment();
					BudgetManagement  bddao=new BudgetManagement();
					bdadao.setBudgetAttachmentId(budgetAttachmentId);
					if(bdadao.load()) {
						//获取附件合同已用金额
						BigDecimal budgetContractAmountUse=BaseHelpUtils.getBigDecimalValue(bdadao.getBudgetContractAmountUse());
						//获取附件合同剩余金额
						BigDecimal budgetContractAmountRest=BaseHelpUtils.getBigDecimalValue(bdadao.getBudgetContractAmountRest());
						budgetContractAmountUse=budgetContractAmountUse.add(payMoney);
						budgetContractAmountRest=budgetContractAmountRest.subtract(payMoney);
						bdadao.setBudgetContractAmountUse(budgetContractAmountUse);
						bdadao.setBudgetContractAmountRest(budgetContractAmountRest);
						bdadao.update();
					}
					bddao.setBudgetManagementId(budgetManagementId);
					if(bddao.load()) {
						//获取预算已用金额
						BigDecimal bdUseAmout=BaseHelpUtils.getBigDecimalValue(bddao.getBdUseAmount());
						//获取预算剩余金额
						BigDecimal BdRestAmount=BaseHelpUtils.getBigDecimalValue(bddao.getBdRestAmount());
						bdUseAmout=bdUseAmout.add(payMoney);
						BdRestAmount=BdRestAmount.subtract(payMoney);
						bddao.setBdUseAmount(bdUseAmout);
						bddao.setBdRestAmount(BdRestAmount);
						bddao.update();
					}
				}
			}else {
				throw new Exception("找不到付款序列编号");
			}
		}
		return bc.toJSON(0,"");
	}
	public String savaOrUpdate(Map<String, Object> params) throws Exception {
		//BaseCollection bc = new BaseCollection<>();
		Date currentDate = new Date();
		int budgetManagementId=BaseHelpUtils.getIntValue(params.get("budgetManagementId"));
		if(budgetManagementId<=0) {
			throw new Exception("获取预算主键失败");
		}
		int budgetAttachmentId=BaseHelpUtils.getIntValue(params.get("budgetAttachmentId"));
		if(budgetAttachmentId<=0) {
			throw new Exception("获取预算附件主键失败");
		}
		int paymentSequenceId=BaseHelpUtils.getIntValue(params.get("paymentSequenceId"));
		int payType=BaseHelpUtils.getIntValue(params.get("payType"));
		PaymentSequence dao=new PaymentSequence();
		BasePaymentSequence bean=new BasePaymentSequence();
		BigDecimal amountZero=BigDecimal.ZERO;
		//获取报销金额
		BigDecimal reimbursementAmount=BaseHelpUtils.getBigDecimalValue(params.get("reimbursementAmount"));
		//获取冲账金额
		BigDecimal reverseAmount=BaseHelpUtils.getBigDecimalValue(params.get("reverseAmount"));
		//付款金额
		BigDecimal payAmount=BigDecimal.ZERO;
		int  year = DateUtil.getYear(currentDate);
		int month = DateUtil.getMonth(currentDate);
		if(paymentSequenceId>0) {
			switch (payType) {
			case 1://项目日常报销
				dao.setConditionPaymentSequenceId("=", paymentSequenceId);
				dao.setPayAmount(amountZero);
				dao.setReturnAmount(amountZero);
				dao.setReverseAmount(amountZero);
				dao.setReimbursementAmount(amountZero);
				dao.conditionalUpdate();
				dao.clear();
				params.put("returnAmount", amountZero);
				params.put("applyPayDate",new Date());
				payAmount=reimbursementAmount.subtract(reverseAmount);
				params.put("payAmount",payAmount);
				params.put("year",year);
				params.put("month",month);
				bean.setDataFromMap(params);
				dao.setDataFromBase(bean);
				dao.setReimbursementCode(null);
				dao.update();
				dao.clear();
				break;
			case 2://普通日常报销
				dao.setConditionPaymentSequenceId("=", paymentSequenceId);
				dao.setPayAmount(amountZero);
				dao.setReturnAmount(amountZero);
				dao.setReverseAmount(amountZero);
				dao.setReimbursementAmount(amountZero);
				dao.conditionalUpdate();
				dao.clear();
				params.put("returnAmount", amountZero);
				params.put("applyPayDate",new Date());
				payAmount=reimbursementAmount.subtract(reverseAmount);
				params.put("payAmount",payAmount);
				params.put("year",year);
				params.put("month",month);
				bean.setDataFromMap(params);
				dao.setDataFromBase(bean);
				dao.setReimbursementCode(null);
				dao.update();
				dao.clear();
				break;
			case 3://项目差旅报销
				dao.setConditionPaymentSequenceId("=", paymentSequenceId);
				dao.setPayAmount(amountZero);
				dao.setReturnAmount(amountZero);
				dao.setReverseAmount(amountZero);
				dao.setReimbursementAmount(amountZero);
				dao.conditionalUpdate();
				dao.clear();
				params.put("returnAmount", amountZero);
				params.put("applyPayDate",new Date());
				payAmount=reimbursementAmount.subtract(reverseAmount);
				params.put("payAmount",payAmount);
				params.put("year",year);
				params.put("month",month);
				bean.setDataFromMap(params);
				dao.setDataFromBase(bean);
				dao.setReimbursementCode(null);
				dao.update();
				dao.clear();
				break;
			case 4://借款申请 
				dao.setConditionPaymentSequenceId("=", paymentSequenceId);
				dao.setPayAmount(amountZero);
				dao.setReturnAmount(amountZero);
				dao.setReverseAmount(amountZero);
				dao.setReimbursementAmount(amountZero);
				dao.conditionalUpdate();
				dao.clear();
				params.put("reverseAmount", amountZero);
				params.put("reimbursementAmount", amountZero);
				params.put("returnAmount", amountZero);
				params.put("applyPayDate",new Date());
				params.put("year",year);
				params.put("month",month);
				bean.setDataFromMap(params);
				dao.setDataFromBase(bean);
				dao.setReimbursementCode(null);
				dao.update();
				dao.clear();
				break;
			case 5://预付款申请
				dao.setConditionPaymentSequenceId("=", paymentSequenceId);
				dao.setPayAmount(amountZero);
				dao.setReturnAmount(amountZero);
				dao.setReverseAmount(amountZero);
				dao.setReimbursementAmount(amountZero);
				dao.conditionalUpdate();
				dao.clear();
				params.put("reverseAmount", amountZero);
				params.put("reimbursementAmount", amountZero);
				params.put("returnAmount", amountZero);
				params.put("applyPayDate",new Date());
				params.put("year",year);
				params.put("month",month);
				bean.setDataFromMap(params);
				dao.setDataFromBase(bean);
				dao.setReimbursementCode(null);
				dao.update();
				dao.clear();
				break;
			case 6://还款申请
				dao.setConditionPaymentSequenceId("=", paymentSequenceId);
				dao.setPayAmount(amountZero);
				dao.setReturnAmount(amountZero);
				dao.setReverseAmount(amountZero);
				dao.setReimbursementAmount(amountZero);
				dao.conditionalUpdate();
				dao.clear();
				params.put("reverseAmount", amountZero);
				params.put("reimbursementAmount", amountZero);
				params.put("payAmount", amountZero);
				params.put("applyPayDate",new Date());
				params.put("year",year);
				params.put("month",month);
				bean.setDataFromMap(params);
				dao.setDataFromBase(bean);
				dao.setReimbursementCode(null);
				dao.update();
				dao.clear();
				break;
			}
			return dao.generateBase().toOneLineJSON(0,null);
		}else {
			params.put("year",year);
			params.put("month",month);
			bean.setDataFromMap(params);
			dao.setDataFromBase(bean);
			dao.save();
			return dao.generateBase().toOneLineJSON(0,null);
		}
	}
	
	public String payStatusInfo(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		Map<String,Object>  map=new HashMap<>();
		int paymentSequenceId=BaseHelpUtils.getIntValue(params.get("paymentSequenceId"));
		int budgetAttachmentId=BaseHelpUtils.getIntValue(params.get("budgetAttachmentId"));
		int budgetManagementId=BaseHelpUtils.getIntValue(params.get("budgetManagementId"));
		int payType=BaseHelpUtils.getIntValue(params.get("payType"));
		int processId=BaseHelpUtils.getIntValue(params.get("processId"));
		int processType=BaseHelpUtils.getIntValue(params.get("processType"));
		switch (payType) {
		case 1://项目日常报销
			ProjectNormalReimbursement pnrDao=new ProjectNormalReimbursement();
			pnrDao.clear();
			pnrDao.setConditionPaymentSequenceId("=", paymentSequenceId);
			pnrDao.setConditionBudgetManagementId("=", budgetManagementId);
			pnrDao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
			List<BaseProjectNormalReimbursement> list=pnrDao.conditionalLoad("ORDER BY project_normal_reimbursement_id desc");
			if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
				//获取主表主键ID
				int projectNormalReimbursementId=list.get(0).getProjectNormalReimbursementId();
				SystemProcessInstance sysDao=new SystemProcessInstance();
				sysDao.clear();
				sysDao.setConditionBusinessId("=", projectNormalReimbursementId);
				sysDao.setConditionProcessId("=", processId);
				sysDao.setConditionProcessType("=", processType);
				BaseSystemProcessInstance sysBean=sysDao.executeQueryOneRow();
				int processInstanceId=sysBean.getProcessInstanceId();
				map.put("processInstanceId", processInstanceId);
			}else {
				throw new Exception("找不到绑定的付款流程");
			}
			break;
		case 2://普通日常报销
			ProjectNormalReimbursement normalDao=new ProjectNormalReimbursement();
			normalDao.clear();
			normalDao.setConditionPaymentSequenceId("=", paymentSequenceId);
			normalDao.setConditionBudgetManagementId("=", budgetManagementId);
			normalDao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
			List<BaseProjectNormalReimbursement> normalList=normalDao.conditionalLoad("ORDER BY project_normal_reimbursement_id desc");
			if(!BaseHelpUtils.isNullOrEmpty(normalList)&&normalList.size()>0) {
				//获取主表主键ID
				int projectNormalReimbursementId=normalList.get(0).getProjectNormalReimbursementId();
				SystemProcessInstance sysDao=new SystemProcessInstance();
				sysDao.clear();
				sysDao.setConditionBusinessId("=", projectNormalReimbursementId);
				sysDao.setConditionProcessId("=", processId);
				sysDao.setConditionProcessType("=", processType);
				BaseSystemProcessInstance sysBean=sysDao.executeQueryOneRow();
				int processInstanceId=sysBean.getProcessInstanceId();
				map.put("processInstanceId", processInstanceId);
			}else {
				throw new Exception("找不到绑定的付款流程");
			}
			break;
		case 3://项目差旅报销
			TravelReimbursement travelDao=new TravelReimbursement();
			travelDao.clear();
			travelDao.setConditionPaymentSequenceId("=", paymentSequenceId);
			travelDao.setConditionBudgetManagementId("=", budgetManagementId);
			travelDao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
			List<BaseTravelReimbursement> travelList=travelDao.conditionalLoad("ORDER BY travel_reimbursement_id desc");
			if(!BaseHelpUtils.isNullOrEmpty(travelList)&&travelList.size()>0) {
				//获取主表主键ID
				int travelReimbursementId=travelList.get(0).getTravelReimbursementId();
				SystemProcessInstance sysDao=new SystemProcessInstance();
				sysDao.clear();
				sysDao.setConditionBusinessId("=", travelReimbursementId);
				sysDao.setConditionProcessId("=", processId);
				sysDao.setConditionProcessType("=", processType);
				BaseSystemProcessInstance sysBean=sysDao.executeQueryOneRow();
				int processInstanceId=sysBean.getProcessInstanceId();
				map.put("processInstanceId", processInstanceId);
			}else {
				throw new Exception("找不到绑定的付款流程");
			}
			break;
		case 4://借款申请
			EmployeeMoneyManage employeeDao=new EmployeeMoneyManage();
			employeeDao.clear();
			employeeDao.setConditionPaymentSequenceId("=", paymentSequenceId);
			employeeDao.setConditionBudgetManagementId("=", budgetManagementId);
			employeeDao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
			List<BaseEmployeeMoneyManage> employeelList=employeeDao.conditionalLoad("ORDER BY employee_money_manage_id desc");
			if(!BaseHelpUtils.isNullOrEmpty(employeelList)&&employeelList.size()>0) {
				//获取主表主键ID
				int employeeMoneyManageId=employeelList.get(0).getEmployeeMoneyManageId();
				SystemProcessInstance sysDao=new SystemProcessInstance();
				sysDao.clear();
				sysDao.setConditionBusinessId("=", employeeMoneyManageId);
				sysDao.setConditionProcessId("=", processId);
				sysDao.setConditionProcessType("=", processType);
				BaseSystemProcessInstance sysBean=sysDao.executeQueryOneRow();
				int processInstanceId=sysBean.getProcessInstanceId();
				map.put("processInstanceId", processInstanceId);
			}else {
				throw new Exception("找不到绑定的付款流程");
			}
			break;
		case 5://预付款申请
			PayMoneyManage payMoneyMDao=new PayMoneyManage();
			payMoneyMDao.clear();
			payMoneyMDao.setConditionPaymentSequenceId("=", paymentSequenceId);
			payMoneyMDao.setConditionBudgetManagementId("=", budgetManagementId);
			payMoneyMDao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
			List<BasePayMoneyManage> payMoneylList=payMoneyMDao.conditionalLoad("ORDER BY  pay_money_manage_id desc");
			if(!BaseHelpUtils.isNullOrEmpty(payMoneylList)&&payMoneylList.size()>0) {
				//获取主表主键ID
				int payMoneyManageId=payMoneylList.get(0).getPayMoneyManageId();
				SystemProcessInstance sysDao=new SystemProcessInstance();
				sysDao.clear();
				sysDao.setConditionBusinessId("=", payMoneyManageId);
				sysDao.setConditionProcessId("=", processId);
				sysDao.setConditionProcessType("=", processType);
				BaseSystemProcessInstance sysBean=sysDao.executeQueryOneRow();
				int processInstanceId=sysBean.getProcessInstanceId();
				map.put("processInstanceId", processInstanceId);
			}else {
				throw new Exception("找不到绑定的付款流程");
			}
			break;
		case 6://还款申请
			PersonnelBusines PersonneDao=new PersonnelBusines();
			PersonneDao.clear();
			PersonneDao.setConditionPaymentSequenceId("=", paymentSequenceId);
			PersonneDao.setConditionBudgetManagementId("=", budgetManagementId);
			PersonneDao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
			List<BasePersonnelBusines> PersonnelList=PersonneDao.conditionalLoad("ORDER BY  personnel_business_id desc");
			if(!BaseHelpUtils.isNullOrEmpty(PersonnelList)&&PersonnelList.size()>0) {
				//获取主表主键ID
				int personnelBusinessId=PersonnelList.get(0).getPersonnelBusinessId();
				SystemProcessInstance sysDao=new SystemProcessInstance();
				sysDao.clear();
				sysDao.setConditionBusinessId("=", personnelBusinessId);
				sysDao.setConditionProcessId("=", processId);
				sysDao.setConditionProcessType("=", processType);
				BaseSystemProcessInstance sysBean=sysDao.executeQueryOneRow();
				int processInstanceId=sysBean.getProcessInstanceId();
				map.put("processInstanceId", processInstanceId);
			}else {
				throw new Exception("找不到绑定的付款流程");
			}
			break; 
		}
		bc.setUserData(map);
		return bc.toJSON(0,"");
	}
}
