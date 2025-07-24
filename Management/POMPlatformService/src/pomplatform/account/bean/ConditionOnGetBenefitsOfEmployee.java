package pomplatform.account.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnGetBenefitsOfEmployee extends GenericCondition{

	public ConditionOnGetBenefitsOfEmployee(){
		setParameterCount(2);
	}

	public java.lang.Integer getYear() {
		return __year;
	}

	public void setYear(java.lang.Integer year) {
		this.__year = year;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __year = null;
	private java.lang.Integer __employee_id = null;
}

