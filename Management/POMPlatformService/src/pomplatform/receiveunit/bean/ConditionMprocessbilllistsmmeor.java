package pomplatform.receiveunit.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMprocessbilllistsmmeor extends GenericCondition{

	public ConditionMprocessbilllistsmmeor(){
		setParameterCount(6);
	}

	public java.lang.String getPayeeName() {
		return this.__payee_name;
	}

	public void setPayeeName( java.lang.String value ) {
		this.__payee_name = value;
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
		if(getPayeeName() != null) sb.append(__wrapString(1, "payeeName", getPayeeName()));
		if(getMinCompleteTime() != null) sb.append(__wrapDate(1, "minCompleteTime", getMinCompleteTime()));
		if(getMaxCompleteTime() != null) sb.append(__wrapDate(1, "maxCompleteTime", getMaxCompleteTime()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("payeeName")) != null) setPayeeName(__getString(val));
		if((val = values.get("minCompleteTime")) != null) setMinCompleteTime(__getDate(val)); 
		if((val = values.get("maxCompleteTime")) != null) setMaxCompleteTime(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.lang.String __payee_name = null;
	private java.util.Date __min_complete_time = null;
	private java.util.Date __max_complete_time = null;
	private java.lang.Integer __employee_id = null;
}

