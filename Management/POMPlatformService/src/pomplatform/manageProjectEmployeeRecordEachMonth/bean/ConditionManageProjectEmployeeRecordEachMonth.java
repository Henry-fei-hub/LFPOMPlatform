package pomplatform.manageProjectEmployeeRecordEachMonth.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionManageProjectEmployeeRecordEachMonth extends GenericCondition{

	public ConditionManageProjectEmployeeRecordEachMonth(){
		setParameterCount(3);
	}

	public java.util.Date getStartdate() {
		return this.__startdate;
	}

	public void setStartdate( java.util.Date value ) {
		this.__startdate = value;
	}

	public java.util.Date getEnddate() {
		return this.__enddate;
	}

	public void setEnddate( java.util.Date value ) {
		this.__enddate = value;
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
		if(getStartdate() != null) sb.append(__wrapDate(1, "startdate", getStartdate()));
		if(getEnddate() != null) sb.append(__wrapDate(1, "enddate", getEnddate()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startdate")) != null) setStartdate(__getDate(val)); 
		if((val = values.get("enddate")) != null) setEnddate(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.util.Date __startdate = null;
	private java.util.Date __enddate = null;
	private java.lang.Integer __employee_id = null;
}

