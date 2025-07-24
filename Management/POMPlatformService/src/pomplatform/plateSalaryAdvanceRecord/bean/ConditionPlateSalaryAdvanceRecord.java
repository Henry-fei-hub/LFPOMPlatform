package pomplatform.plateSalaryAdvanceRecord.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPlateSalaryAdvanceRecord extends GenericCondition{

	public ConditionPlateSalaryAdvanceRecord(){
		setParameterCount(5);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getRecordYear() {
		return this.__record_year;
	}

	public void setRecordYear( java.lang.Integer value ) {
		this.__record_year = value;
	}

	public java.lang.Integer getRecordMonth() {
		return this.__record_month;
	}

	public void setRecordMonth( java.lang.Integer value ) {
		this.__record_month = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
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
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getRecordYear() != null) sb.append(__wrapNumber(1, "recordYear", getRecordYear()));
		if(getRecordMonth() != null) sb.append(__wrapNumber(1, "recordMonth", getRecordMonth()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("recordYear")) != null) setRecordYear(__getInt(val)); 
		if((val = values.get("recordMonth")) != null) setRecordMonth(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __record_year = null;
	private java.lang.Integer __record_month = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __employee_id = null;
}

