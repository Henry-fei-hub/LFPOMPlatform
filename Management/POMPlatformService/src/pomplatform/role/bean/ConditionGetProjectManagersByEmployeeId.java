package pomplatform.role.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetProjectManagersByEmployeeId extends GenericCondition{

	public ConditionGetProjectManagersByEmployeeId(){
		setParameterCount(2);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getExcluder() {
		return this.__excluder;
	}

	public void setExcluder( java.lang.Integer value ) {
		this.__excluder = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getExcluder() != null) sb.append(__wrapNumber(1, "excluder", getExcluder()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("excluder")) != null) setExcluder(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __excluder = null;
}

