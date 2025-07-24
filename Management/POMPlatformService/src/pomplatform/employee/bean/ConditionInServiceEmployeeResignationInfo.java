package pomplatform.employee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionInServiceEmployeeResignationInfo extends GenericCondition{

	public ConditionInServiceEmployeeResignationInfo(){
		setParameterCount(2);
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
	}

	private java.lang.Integer __process_status = null;
	private java.lang.Integer __status = null;
}

