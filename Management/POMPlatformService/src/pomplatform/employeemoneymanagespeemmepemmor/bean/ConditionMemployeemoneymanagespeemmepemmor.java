package pomplatform.employeemoneymanagespeemmepemmor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMemployeemoneymanagespeemmepemmor extends GenericCondition{

	public ConditionMemployeemoneymanagespeemmepemmor(){
		setParameterCount(5);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEquivalentNumber() {
		return this.__equivalent_number;
	}

	public void setEquivalentNumber( java.lang.String value ) {
		this.__equivalent_number = value;
	}

	public java.util.Date getMinCompleteTime() {
		return this.__min_complete_time;
	}

	public void setMinCompleteTime( java.util.Date value ) {
		this.__min_complete_time = value;
	}

	public java.util.Date getMaxCompleteTime() {
		return this.__max_complete_time;
	}

	public void setMaxCompleteTime( java.util.Date value ) {
		this.__max_complete_time = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEquivalentNumber() != null) sb.append(__wrapString(1, "equivalentNumber", getEquivalentNumber()));
		if(getMinCompleteTime() != null) sb.append(__wrapDate(1, "minCompleteTime", getMinCompleteTime()));
		if(getMaxCompleteTime() != null) sb.append(__wrapDate(1, "maxCompleteTime", getMaxCompleteTime()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("equivalentNumber")) != null) setEquivalentNumber(__getString(val));
		if((val = values.get("minCompleteTime")) != null) setMinCompleteTime(__getDate(val)); 
		if((val = values.get("maxCompleteTime")) != null) setMaxCompleteTime(__getDate(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.String __equivalent_number = null;
	private java.util.Date __min_complete_time = null;
	private java.util.Date __max_complete_time = null;
	private java.lang.Integer __process_status = null;
}

