package pomplatform.aboutreimbursementpayseq.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAboutReimbursementPayseq extends GenericCondition{

	public ConditionAboutReimbursementPayseq(){
		setParameterCount(3);
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

	public java.lang.Integer getPaymentSequenceId() {
		return this.__payment_sequence_id;
	}

	public void setPaymentSequenceId( java.lang.Integer value ) {
		this.__payment_sequence_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(1, "budgetManagementId", getBudgetManagementId()));
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(1, "budgetAttachmentId", getBudgetAttachmentId()));
		if(getPaymentSequenceId() != null) sb.append(__wrapNumber(1, "paymentSequenceId", getPaymentSequenceId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
		if((val = values.get("paymentSequenceId")) != null) setPaymentSequenceId(__getInt(val)); 
	}

	private java.lang.Integer __budget_management_id = null;
	private java.lang.Integer __budget_attachment_id = null;
	private java.lang.Integer __payment_sequence_id = null;
}

