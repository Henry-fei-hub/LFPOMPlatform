package pomplatform.checking.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMyAttendanceDetail extends GenericCondition{

	public ConditionMyAttendanceDetail(){
		setParameterCount(2);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCheckDate() {
		return this.__check_date;
	}

	public void setCheckDate( java.util.Date value ) {
		this.__check_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getCheckDate() != null) sb.append(__wrapDate(1, "checkDate", getCheckDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("checkDate")) != null) setCheckDate(__getDate(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.util.Date __check_date = null;
}

