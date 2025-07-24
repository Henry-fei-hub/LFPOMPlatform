package pomplatform.buggetdetailinfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionBuggetDetailInfo extends GenericCondition{

	public ConditionBuggetDetailInfo(){
		setParameterCount(1);
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(1, "budgetManagementId", getBudgetManagementId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
	}

	private java.lang.Integer __budget_management_id = null;
}

