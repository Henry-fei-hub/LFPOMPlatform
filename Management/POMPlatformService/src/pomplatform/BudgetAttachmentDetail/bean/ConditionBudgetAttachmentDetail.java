package pomplatform.BudgetAttachmentDetail.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionBudgetAttachmentDetail extends GenericCondition{

	public ConditionBudgetAttachmentDetail(){
		setParameterCount(2);
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(1, "budgetManagementId", getBudgetManagementId()));
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(1, "budgetAttachmentId", getBudgetAttachmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
	}

	private java.lang.Integer __budget_management_id = null;
	private java.lang.Integer __budget_attachment_id = null;
}

