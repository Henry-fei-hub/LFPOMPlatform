package pomplatform.InspectionReport.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionInspectionReport extends GenericCondition{

	public ConditionInspectionReport(){
		setParameterCount(2);
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
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
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.lang.String __code = null;
	private java.lang.Integer __employee_id = null;
}

