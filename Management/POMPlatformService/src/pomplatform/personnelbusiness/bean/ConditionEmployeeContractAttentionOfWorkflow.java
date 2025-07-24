package pomplatform.personnelbusiness.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionEmployeeContractAttentionOfWorkflow extends GenericCondition{

	public ConditionEmployeeContractAttentionOfWorkflow(){
		setParameterCount(2);
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.Integer value ) {
		this.__employee_name = value;
	}


	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapNumber(1, "employeeName", getEmployeeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getInt(val));
	}

	private java.lang.Integer __status = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __employee_name = null;

}

