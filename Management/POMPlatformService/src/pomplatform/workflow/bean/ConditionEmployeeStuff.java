package pomplatform.workflow.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionEmployeeStuff extends GenericCondition{

	public ConditionEmployeeStuff(){
		setParameterCount(5);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}
	

	public java.lang.Integer getParentProcessTypeId() {
		return this.__parent_process_type_id;
	}

	public void setParentProcessTypeId(java.lang.Integer value) {
		this.__parent_process_type_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getParentProcessTypeId() != null) sb.append(__wrapNumber(1, "parentProcessTypeId", getParentProcessTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("parentProcessTypeId")) != null) setParentProcessTypeId(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __parent_process_type_id = null;
}

