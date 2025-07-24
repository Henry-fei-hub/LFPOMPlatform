package pomplatform.abountpaymentsequenceinfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;
import delicacy.common.BaseFactory;
import delicacy.common.BaseHelpUtils;

public class BaseAbountPaymentSequenceinfo extends GenericBase implements BaseFactory<BaseAbountPaymentSequenceinfo>, Comparable<BaseAbountPaymentSequenceinfo> 
{


	public static BaseAbountPaymentSequenceinfo newInstance(){
		return new BaseAbountPaymentSequenceinfo();
	}

	@Override
	public BaseAbountPaymentSequenceinfo make(){
		BaseAbountPaymentSequenceinfo b = new BaseAbountPaymentSequenceinfo();
		return b;
	}

	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_PAY_AMOUNT = "pay_amount" ;
	public final static java.lang.String CS_REIMBURSEMENT_AMOUNT = "reimbursement_amount" ;
	public final static java.lang.String CS_REVERSE_AMOUNT = "reverse_amount" ;
	public final static java.lang.String CS_PAY_DATE = "pay_date" ;
	public final static java.lang.String CS_RECEIVE_UNIT_MANAGE_ID = "receive_unit_manage_id" ;
	public final static java.lang.String CS_PAY_TYPE = "pay_type" ;
	public final static java.lang.String CS_PS_REMARK = "ps_remark" ;
	public final static java.lang.String CS_PAY_STATUS = "pay_status" ;
	public final static java.lang.String CS_APPLY_PAY_DATE = "apply_pay_date" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT = "budget_contract_amount" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT_USE = "budget_contract_amount_use" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT_REST = "budget_contract_amount_rest" ;
	public final static java.lang.String CS_PAY_PERCENT = "pay_percent" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PAY_FOR = "pay_for" ;
	public final static java.lang.String CS_PAY_NAME = "pay_name" ;
	public final static java.lang.String CS_PAYMENT_SEQUENCE_ID = "payment_sequence_id" ;
	public final static java.lang.String CS_BUDGET_ATTACHMENT_ID = "budget_attachment_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;

	public final static java.lang.String ALL_CAPTIONS = "预算管理id,附件名称,文件路径,付款金额,报销金额,冲账金额,付款日期,收款单位编码,付款类型,付款序列备注,付款状态,付款申请日期,合同金额,合同已付款金额,剩余合同金额,付款比例,关联的项目名称,收款方类型 1个人，2公司,收款人名称,主键id,预算附件id,流程类型,process_id";
	public final static java.lang.String EXPORT_CAPTIONS = "附件名称,付款类型,报销金额,付款金额,冲账金额,还款金额,付款申请日期,收款方类型,收款方名称,供应商,付款序列备注,付款状态,付款日期,合同金额,合同已付款金额,剩余合同金额,付款比例,关联的项目名称";

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.math.BigDecimal getPayAmount() {
		return this.__pay_amount;
	}

	public void setPayAmount( java.math.BigDecimal value ) {
		this.__pay_amount = value;
	}

	public java.math.BigDecimal getReimbursementAmount() {
		return this.__reimbursement_amount;
	}

	public void setReimbursementAmount( java.math.BigDecimal value ) {
		this.__reimbursement_amount = value;
	}

	public java.math.BigDecimal getReverseAmount() {
		return this.__reverse_amount;
	}

	public void setReverseAmount( java.math.BigDecimal value ) {
		this.__reverse_amount = value;
	}

	public java.util.Date getPayDate() {
		return this.__pay_date;
	}

	public void setPayDate( java.util.Date value ) {
		this.__pay_date = value;
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.Integer getPayType() {
		return this.__pay_type;
	}

	public void setPayType( java.lang.Integer value ) {
		this.__pay_type = value;
	}

	public java.lang.String getPsRemark() {
		return this.__ps_remark;
	}

	public void setPsRemark( java.lang.String value ) {
		this.__ps_remark = value;
	}

	public java.lang.Integer getPayStatus() {
		return this.__pay_status;
	}

	public void setPayStatus( java.lang.Integer value ) {
		this.__pay_status = value;
	}

	public java.util.Date getApplyPayDate() {
		return this.__apply_pay_date;
	}

	public void setApplyPayDate( java.util.Date value ) {
		this.__apply_pay_date = value;
	}

	public java.math.BigDecimal getBudgetContractAmount() {
		return this.__budget_contract_amount;
	}

	public void setBudgetContractAmount( java.math.BigDecimal value ) {
		this.__budget_contract_amount = value;
	}

	public java.math.BigDecimal getBudgetContractAmountUse() {
		return this.__budget_contract_amount_use;
	}

	public void setBudgetContractAmountUse( java.math.BigDecimal value ) {
		this.__budget_contract_amount_use = value;
	}

	public java.math.BigDecimal getBudgetContractAmountRest() {
		return this.__budget_contract_amount_rest;
	}

	public void setBudgetContractAmountRest( java.math.BigDecimal value ) {
		this.__budget_contract_amount_rest = value;
	}

	public java.lang.String getPayPercent() {
		return this.__pay_percent;
	}

	public void setPayPercent( java.lang.String value ) {
		this.__pay_percent = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPayFor() {
		return this.__pay_for;
	}

	public void setPayFor( java.lang.Integer value ) {
		this.__pay_for = value;
	}

	public java.lang.String getPayName() {
		return this.__pay_name;
	}

	public void setPayName( java.lang.String value ) {
		this.__pay_name = value;
	}

	public java.lang.Integer getPaymentSequenceId() {
		return this.__payment_sequence_id;
	}

	public void setPaymentSequenceId( java.lang.Integer value ) {
		this.__payment_sequence_id = value;
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return this.__budget_attachment_id;
	}

	public void setBudgetAttachmentId( java.lang.Integer value ) {
		this.__budget_attachment_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.math.BigDecimal getReturnAmount() {
		return this.__return_amount;
	}

	public void SetReturnAmount( java.math.BigDecimal value ) {
		this.__return_amount = value;
	}
	
	
	public void cloneCopy(BaseAbountPaymentSequenceinfo __bean){
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setFileUrl(getFileUrl());
		__bean.setPayAmount(getPayAmount());
		__bean.setReimbursementAmount(getReimbursementAmount());
		__bean.setReverseAmount(getReverseAmount());
		__bean.setPayDate(getPayDate());
		__bean.setReceiveUnitManageId(getReceiveUnitManageId());
		__bean.setPayType(getPayType());
		__bean.setPsRemark(getPsRemark());
		__bean.setPayStatus(getPayStatus());
		__bean.setApplyPayDate(getApplyPayDate());
		__bean.setBudgetContractAmount(getBudgetContractAmount());
		__bean.setBudgetContractAmountUse(getBudgetContractAmountUse());
		__bean.setBudgetContractAmountRest(getBudgetContractAmountRest());
		__bean.setPayPercent(getPayPercent());
		__bean.setProjectId(getProjectId());
		__bean.setPayFor(getPayFor());
		__bean.setPayName(getPayName());
		__bean.setPaymentSequenceId(getPaymentSequenceId());
		__bean.setBudgetAttachmentId(getBudgetAttachmentId());
		__bean.setProcessType(getProcessType());
		__bean.setProcessId(getProcessId());
		__bean.SetReturnAmount(getReturnAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		String strPayType = SelectValueCache.getSelectValue("system_dictionary_193", BaseHelpUtils.getString(getPayType()));
		sb.append(strPayType == null ? "" : strPayType);
		sb.append(",");
		sb.append(getReimbursementAmount() == null ? "" : getReimbursementAmount());
		sb.append(",");
		sb.append(getPayAmount() == null ? "" : getPayAmount());
		sb.append(",");
		sb.append(getReverseAmount() == null ? "" : getReverseAmount());
		sb.append(",");
		sb.append(getReturnAmount() == null ? "" : getReturnAmount());
		sb.append(",");
		sb.append(getApplyPayDate() == null ? "" : sdf.format(getApplyPayDate()));
		sb.append(",");
		String strPayFor = SelectValueCache.getSelectValue("system_dictionary_196", BaseHelpUtils.getString(getPayFor()));
		sb.append(strPayFor == null ? "" : strPayFor);
		sb.append(",");
		sb.append(getPayName() == null ? "" : getPayName());
		sb.append(",");
		String strReceiveUnitManageId = SelectValueCache.getSelectValue("receive_unit_manages_company", BaseHelpUtils.getString(getReceiveUnitManageId()));
		sb.append(strReceiveUnitManageId == null ? "" : strReceiveUnitManageId);
		sb.append(",");
		sb.append(getPsRemark() == null ? "" : getPsRemark());
		sb.append(",");
		String strPayStatus = SelectValueCache.getSelectValue("system_dictionary_194", BaseHelpUtils.getString(getPayStatus()));
		sb.append(strPayStatus == null ? "" : strPayStatus);
		sb.append(",");
		sb.append(getPayDate() == null ? "" : sdf.format(getPayDate()));
		sb.append(",");
		sb.append(getBudgetContractAmount() == null ? "" : getBudgetContractAmount());
		sb.append(",");
		sb.append(getBudgetContractAmountUse() == null ? "" : getBudgetContractAmountUse());
		sb.append(",");
		sb.append(getBudgetContractAmountRest() == null ? "" : getBudgetContractAmountRest());
		sb.append(",");
		sb.append(getPayPercent() == null ? "" : getPayPercent());
		sb.append(",");
		String strProject = SelectValueCache.getSelectValue("projects", BaseHelpUtils.getString(getProjectId()));
		sb.append(strProject == null ? "" : strProject);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAbountPaymentSequenceinfo o) {
		return __payment_sequence_id == null ? -1 : __payment_sequence_id.compareTo(o.getPaymentSequenceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__pay_amount);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_amount);
		hash = 97 * hash + Objects.hashCode(this.__reverse_amount);
		hash = 97 * hash + Objects.hashCode(this.__pay_date);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_type);
		hash = 97 * hash + Objects.hashCode(this.__ps_remark);
		hash = 97 * hash + Objects.hashCode(this.__pay_status);
		hash = 97 * hash + Objects.hashCode(this.__apply_pay_date);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount_use);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount_rest);
		hash = 97 * hash + Objects.hashCode(this.__pay_percent);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_for);
		hash = 97 * hash + Objects.hashCode(this.__pay_name);
		hash = 97 * hash + Objects.hashCode(this.__payment_sequence_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__return_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAbountPaymentSequenceinfo o = (BaseAbountPaymentSequenceinfo)obj;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__pay_amount, o.getPayAmount())) return false;
		if(!Objects.equals(this.__reimbursement_amount, o.getReimbursementAmount())) return false;
		if(!Objects.equals(this.__reverse_amount, o.getReverseAmount())) return false;
		if(!Objects.equals(this.__pay_date, o.getPayDate())) return false;
		if(!Objects.equals(this.__receive_unit_manage_id, o.getReceiveUnitManageId())) return false;
		if(!Objects.equals(this.__pay_type, o.getPayType())) return false;
		if(!Objects.equals(this.__ps_remark, o.getPsRemark())) return false;
		if(!Objects.equals(this.__pay_status, o.getPayStatus())) return false;
		if(!Objects.equals(this.__apply_pay_date, o.getApplyPayDate())) return false;
		if(!Objects.equals(this.__budget_contract_amount, o.getBudgetContractAmount())) return false;
		if(!Objects.equals(this.__budget_contract_amount_use, o.getBudgetContractAmountUse())) return false;
		if(!Objects.equals(this.__budget_contract_amount_rest, o.getBudgetContractAmountRest())) return false;
		if(!Objects.equals(this.__pay_percent, o.getPayPercent())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__pay_for, o.getPayFor())) return false;
		if(!Objects.equals(this.__pay_name, o.getPayName())) return false;
		if(!Objects.equals(this.__payment_sequence_id, o.getPaymentSequenceId())) return false;
		if(!Objects.equals(this.__budget_attachment_id, o.getBudgetAttachmentId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__return_amount, o.getReturnAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getPayAmount() != null) sb.append(__wrapDecimal(count++, "payAmount", getPayAmount()));
		if(getReimbursementAmount() != null) sb.append(__wrapDecimal(count++, "reimbursementAmount", getReimbursementAmount()));
		if(getReverseAmount() != null) sb.append(__wrapDecimal(count++, "reverseAmount", getReverseAmount()));
		if(getPayDate() != null) sb.append(__wrapDate(count++, "payDate", getPayDate()));
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(count++, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getPayType() != null) sb.append(__wrapNumber(count++, "payType", getPayType()));
		if(getPsRemark() != null) sb.append(__wrapString(count++, "psRemark", getPsRemark()));
		if(getPayStatus() != null) sb.append(__wrapNumber(count++, "payStatus", getPayStatus()));
		if(getApplyPayDate() != null) sb.append(__wrapDate(count++, "applyPayDate", getApplyPayDate()));
		if(getBudgetContractAmount() != null) sb.append(__wrapDecimal(count++, "budgetContractAmount", getBudgetContractAmount()));
		if(getBudgetContractAmountUse() != null) sb.append(__wrapDecimal(count++, "budgetContractAmountUse", getBudgetContractAmountUse()));
		if(getBudgetContractAmountRest() != null) sb.append(__wrapDecimal(count++, "budgetContractAmountRest", getBudgetContractAmountRest()));
		if(getPayPercent() != null) sb.append(__wrapString(count++, "payPercent", getPayPercent()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPayFor() != null) sb.append(__wrapNumber(count++, "payFor", getPayFor()));
		if(getPayName() != null) sb.append(__wrapString(count++, "payName", getPayName()));
		if(getPaymentSequenceId() != null) sb.append(__wrapNumber(count++, "paymentSequenceId", getPaymentSequenceId()));
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(count++, "budgetAttachmentId", getBudgetAttachmentId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getReturnAmount() != null) sb.append(__wrapDecimal(count++, "returnAmount", getReturnAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("payAmount")) != null) setPayAmount(__getDecimal(val));  
		if((val = values.get("reimbursementAmount")) != null) setReimbursementAmount(__getDecimal(val));  
		if((val = values.get("reverseAmount")) != null) setReverseAmount(__getDecimal(val));  
		if((val = values.get("payDate")) != null) setPayDate(__getDate(val)); 
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("payType")) != null) setPayType(__getInt(val)); 
		if((val = values.get("psRemark")) != null) setPsRemark(__getString(val));
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val)); 
		if((val = values.get("applyPayDate")) != null) setApplyPayDate(__getDate(val)); 
		if((val = values.get("budgetContractAmount")) != null) setBudgetContractAmount(__getDecimal(val));  
		if((val = values.get("budgetContractAmountUse")) != null) setBudgetContractAmountUse(__getDecimal(val));  
		if((val = values.get("budgetContractAmountRest")) != null) setBudgetContractAmountRest(__getDecimal(val));  
		if((val = values.get("payPercent")) != null) setPayPercent(__getString(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("payFor")) != null) setPayFor(__getInt(val)); 
		if((val = values.get("payName")) != null) setPayName(__getString(val));
		if((val = values.get("paymentSequenceId")) != null) setPaymentSequenceId(__getInt(val)); 
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("returnAmount")) != null) SetReturnAmount((__getDecimal(val)));
	}

	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.String  __file_url ;
	protected java.math.BigDecimal  __pay_amount ;
	protected java.math.BigDecimal  __reimbursement_amount ;
	protected java.math.BigDecimal  __reverse_amount ;
	protected java.util.Date  __pay_date ;
	protected java.lang.Integer  __receive_unit_manage_id ;
	protected java.lang.Integer  __pay_type ;
	protected java.lang.String  __ps_remark ;
	protected java.lang.Integer  __pay_status ;
	protected java.util.Date  __apply_pay_date ;
	protected java.math.BigDecimal  __budget_contract_amount ;
	protected java.math.BigDecimal  __budget_contract_amount_use ;
	protected java.math.BigDecimal  __budget_contract_amount_rest ;
	protected java.lang.String  __pay_percent ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __pay_for ;
	protected java.lang.String  __pay_name ;
	protected java.lang.Integer  __payment_sequence_id ;
	protected java.lang.Integer  __budget_attachment_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __process_id ;
	protected java.math.BigDecimal  __return_amount ;
}
