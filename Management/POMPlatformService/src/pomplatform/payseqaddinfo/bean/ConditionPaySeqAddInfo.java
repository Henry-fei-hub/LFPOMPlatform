package pomplatform.payseqaddinfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPaySeqAddInfo extends GenericCondition{

	public ConditionPaySeqAddInfo(){
		setParameterCount(21);
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return this.__budget_attachment_id;
	}

	public void setBudgetAttachmentId( java.lang.Integer value ) {
		this.__budget_attachment_id = value;
	}

	public java.math.BigDecimal getPayAmount() {
		return this.__pay_amount;
	}

	public void setPayAmount( java.math.BigDecimal value ) {
		this.__pay_amount = value;
	}

	public java.util.Date getPayDate() {
		return this.__pay_date;
	}

	public void setPayDate( java.util.Date value ) {
		this.__pay_date = value;
	}

	public java.lang.Integer getPayStatus() {
		return this.__pay_status;
	}

	public void setPayStatus( java.lang.Integer value ) {
		this.__pay_status = value;
	}

	public java.lang.String getPsRemark() {
		return this.__ps_remark;
	}

	public void setPsRemark( java.lang.String value ) {
		this.__ps_remark = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.Integer getProcessBillListId() {
		return this.__process_bill_list_id;
	}

	public void setProcessBillListId( java.lang.Integer value ) {
		this.__process_bill_list_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getBindStatus() {
		return this.__bind_status;
	}

	public void setBindStatus( java.lang.Integer value ) {
		this.__bind_status = value;
	}

	public java.lang.Integer getPayType() {
		return this.__pay_type;
	}

	public void setPayType( java.lang.Integer value ) {
		this.__pay_type = value;
	}

	public java.lang.Boolean getIsLock() {
		return this.__is_lock;
	}

	public void setIsLock( java.lang.Boolean value ) {
		this.__is_lock = value;
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

	public java.util.Date getApplyPayDate() {
		return this.__apply_pay_date;
	}

	public void setApplyPayDate( java.util.Date value ) {
		this.__apply_pay_date = value;
	}

	public java.math.BigDecimal getReturnAmount() {
		return this.__return_amount;
	}

	public void setReturnAmount( java.math.BigDecimal value ) {
		this.__return_amount = value;
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

	public java.lang.String getReimbursementCode() {
		return this.__reimbursement_code;
	}

	public void setReimbursementCode( java.lang.String value ) {
		this.__reimbursement_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(1, "budgetManagementId", getBudgetManagementId()));
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(1, "budgetAttachmentId", getBudgetAttachmentId()));
		if(getPayAmount() != null) sb.append(__wrapNumber(1, "payAmount", getPayAmount()));
		if(getPayDate() != null) sb.append(__wrapDate(1, "payDate", getPayDate()));
		if(getPayStatus() != null) sb.append(__wrapNumber(1, "payStatus", getPayStatus()));
		if(getPsRemark() != null) sb.append(__wrapString(1, "psRemark", getPsRemark()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(1, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getProcessBillListId() != null) sb.append(__wrapNumber(1, "processBillListId", getProcessBillListId()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getBindStatus() != null) sb.append(__wrapNumber(1, "bindStatus", getBindStatus()));
		if(getPayType() != null) sb.append(__wrapNumber(1, "payType", getPayType()));
		if(getIsLock() != null) sb.append(__wrapBoolean(1, "isLock", getIsLock()));
		if(getReimbursementAmount() != null) sb.append(__wrapNumber(1, "reimbursementAmount", getReimbursementAmount()));
		if(getReverseAmount() != null) sb.append(__wrapNumber(1, "reverseAmount", getReverseAmount()));
		if(getApplyPayDate() != null) sb.append(__wrapDate(1, "applyPayDate", getApplyPayDate()));
		if(getReturnAmount() != null) sb.append(__wrapNumber(1, "returnAmount", getReturnAmount()));
		if(getPayFor() != null) sb.append(__wrapNumber(1, "payFor", getPayFor()));
		if(getPayName() != null) sb.append(__wrapString(1, "payName", getPayName()));
		if(getReimbursementCode() != null) sb.append(__wrapString(1, "reimbursementCode", getReimbursementCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
		if((val = values.get("payAmount")) != null) setPayAmount(__getDecimal(val));  
		if((val = values.get("payDate")) != null) setPayDate(__getDate(val)); 
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val)); 
		if((val = values.get("psRemark")) != null) setPsRemark(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("processBillListId")) != null) setProcessBillListId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("bindStatus")) != null) setBindStatus(__getInt(val)); 
		if((val = values.get("payType")) != null) setPayType(__getInt(val)); 
		if((val = values.get("isLock")) != null) setIsLock(__getBoolean(val));
		if((val = values.get("reimbursementAmount")) != null) setReimbursementAmount(__getDecimal(val));  
		if((val = values.get("reverseAmount")) != null) setReverseAmount(__getDecimal(val));  
		if((val = values.get("applyPayDate")) != null) setApplyPayDate(__getDate(val)); 
		if((val = values.get("returnAmount")) != null) setReturnAmount(__getDecimal(val));  
		if((val = values.get("payFor")) != null) setPayFor(__getInt(val)); 
		if((val = values.get("payName")) != null) setPayName(__getString(val));
		if((val = values.get("reimbursementCode")) != null) setReimbursementCode(__getString(val));
	}

	private java.lang.Integer __budget_management_id = null;
	private java.lang.Integer __budget_attachment_id = null;
	private java.math.BigDecimal __pay_amount = null;
	private java.util.Date __pay_date = null;
	private java.lang.Integer __pay_status = null;
	private java.lang.String __ps_remark = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __receive_unit_manage_id = null;
	private java.lang.Integer __process_bill_list_id = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __bind_status = null;
	private java.lang.Integer __pay_type = null;
	private java.lang.Boolean __is_lock = null;
	private java.math.BigDecimal __reimbursement_amount = null;
	private java.math.BigDecimal __reverse_amount = null;
	private java.util.Date __apply_pay_date = null;
	private java.math.BigDecimal __return_amount = null;
	private java.lang.Integer __pay_for = null;
	private java.lang.String __pay_name = null;
	private java.lang.String __reimbursement_code = null;
}

