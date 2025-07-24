package pomplatform.financialtransactionaccount.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionProcessInstWithoutTransDetails extends GenericCondition{

	public ConditionProcessInstWithoutTransDetails(){
		setParameterCount(2);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.util.Date getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( java.util.Date value ) {
		this.__start_time = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getStartTime() != null) sb.append(__wrapDate(1, "startTime", getStartTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
	}

	private java.lang.Integer __process_type = null;
	private java.util.Date __start_time = null;
}

