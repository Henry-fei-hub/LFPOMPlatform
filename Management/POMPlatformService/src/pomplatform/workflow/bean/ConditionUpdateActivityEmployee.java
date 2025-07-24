package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionUpdateActivityEmployee extends GenericCondition{

	public ConditionUpdateActivityEmployee(){
		setParameterCount(6);
	}

	public Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( Integer value ) {
		this.__process_type = value;
	}

	public Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( Integer value ) {
		this.__drafter = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getBusinessName() {
		return this.__business_name == null ? null : (this.__business_name.indexOf("%") >= 0 ? this.__business_name : "%"+this.__business_name+"%");
	}

	public void setBusinessName( String value ) {
		this.__business_name = value;
	}

	public java.util.Date getCreateTimeStart() {
		return this.__create_time_start;
	}

	public void setCreateTimeStart( java.util.Date value ) {
		this.__create_time_start = value;
	}

	public java.util.Date getCreateTimeEnd() {
		return this.__create_time_end;
	}

	public void setCreateTimeEnd( java.util.Date value ) {
		this.__create_time_end = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getDrafter() != null) sb.append(__wrapNumber(1, "drafter", getDrafter()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getBusinessName() != null) sb.append(__wrapString(1, "businessName", getBusinessName()));
		if(getCreateTimeStart() != null) sb.append(__wrapDate(1, "createTimeStart", getCreateTimeStart()));
		if(getCreateTimeEnd() != null) sb.append(__wrapDate(1, "createTimeEnd", getCreateTimeEnd()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("createTimeStart")) != null) setCreateTimeStart(__getDate(val)); 
		if((val = values.get("createTimeEnd")) != null) setCreateTimeEnd(__getDate(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProcessType() != null) res.add("processType");
		if(getDrafter() != null) res.add("drafter");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getBusinessName() != null) res.add("businessName");
		if(getCreateTimeStart() != null) res.add("createTimeStart");
		if(getCreateTimeEnd() != null) res.add("createTimeEnd");
		return res;
	}

	private Integer __process_type = null;
	private Integer __drafter = null;
	private Integer __employee_id = null;
	private String __business_name = null;
	private java.util.Date __create_time_start = null;
	private java.util.Date __create_time_end = null;
}

