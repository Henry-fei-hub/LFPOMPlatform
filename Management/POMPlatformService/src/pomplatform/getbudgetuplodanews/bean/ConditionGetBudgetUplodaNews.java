package pomplatform.getbudgetuplodanews.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetBudgetUplodaNews extends GenericCondition{

	public ConditionGetBudgetUplodaNews(){
		setParameterCount(2);
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(1, "budgetManagementId", getBudgetManagementId()));
		if(getFileId() != null) sb.append(__wrapNumber(1, "fileId", getFileId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
	}

	private java.lang.Integer __budget_management_id = null;
	private java.lang.Integer __file_id = null;
}

