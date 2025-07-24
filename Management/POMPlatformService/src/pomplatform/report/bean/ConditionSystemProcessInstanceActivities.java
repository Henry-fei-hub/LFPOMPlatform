package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionSystemProcessInstanceActivities extends GenericCondition{

	public ConditionSystemProcessInstanceActivities(){
		setParameterCount(3);
	}

	public Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( Integer value ) {
		this.__process_type = value;
	}

	public Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( Integer value ) {
		this.__business_id = value;
	}

	public Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( Integer value ) {
		this.__process_instance_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(1, "businessId", getBusinessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(1, "processInstanceId", getProcessInstanceId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProcessType() != null) res.add("processType");
		if(getBusinessId() != null) res.add("businessId");
		if(getProcessInstanceId() != null) res.add("processInstanceId");
		return res;
	}

	private Integer __process_type = null;
	private Integer __business_id = null;
	private Integer __process_instance_id = null;
}

