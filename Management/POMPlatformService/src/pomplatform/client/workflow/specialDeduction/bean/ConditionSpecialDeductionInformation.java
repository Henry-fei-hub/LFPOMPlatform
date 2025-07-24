package pomplatform.client.workflow.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSpecialDeductionInformation extends GenericCondition{

	public ConditionSpecialDeductionInformation(){
		setParameterCount(1);
	}

	public java.lang.Integer getEmployeId() {
		return this.__employe_id;
	}

	public void setEmployeId( java.lang.Integer value ) {
		this.__employe_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeId() != null) sb.append(__wrapNumber(1, "employeId", getEmployeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
	}

	private java.lang.Integer __employe_id = null;
}

