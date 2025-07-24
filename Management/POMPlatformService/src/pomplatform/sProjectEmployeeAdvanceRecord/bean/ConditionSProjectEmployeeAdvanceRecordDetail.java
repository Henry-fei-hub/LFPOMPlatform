package pomplatform.sProjectEmployeeAdvanceRecord.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSProjectEmployeeAdvanceRecordDetail extends GenericCondition{

	public ConditionSProjectEmployeeAdvanceRecordDetail(){
		setParameterCount(3);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getAdvanceYear() {
		return this.__advance_year;
	}

	public void setAdvanceYear( java.lang.Integer value ) {
		this.__advance_year = value;
	}

	public java.lang.Integer getAdvanceMonth() {
		return this.__advance_month;
	}

	public void setAdvanceMonth( java.lang.Integer value ) {
		this.__advance_month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getAdvanceYear() != null) sb.append(__wrapNumber(1, "advanceYear", getAdvanceYear()));
		if(getAdvanceMonth() != null) sb.append(__wrapNumber(1, "advanceMonth", getAdvanceMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("advanceYear")) != null) setAdvanceYear(__getInt(val)); 
		if((val = values.get("advanceMonth")) != null) setAdvanceMonth(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __advance_year = null;
	private java.lang.Integer __advance_month = null;
}

