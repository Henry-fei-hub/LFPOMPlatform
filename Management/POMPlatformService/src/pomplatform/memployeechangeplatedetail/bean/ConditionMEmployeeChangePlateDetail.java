package pomplatform.memployeechangeplatedetail.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMEmployeeChangePlateDetail extends GenericCondition{

	public ConditionMEmployeeChangePlateDetail(){
		setParameterCount(7);
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getStartMonth() {
		return this.__start_month;
	}

	public void setStartMonth( java.lang.Integer value ) {
		this.__start_month = value;
	}

	public java.lang.Integer getEndMonth() {
		return this.__end_month;
	}

	public void setEndMonth( java.lang.Integer value ) {
		this.__end_month = value;
	}

	public java.lang.Integer getInPlateId() {
		return this.__in_plate_id;
	}

	public void setInPlateId( java.lang.Integer value ) {
		this.__in_plate_id = value;
	}

	public java.lang.Integer getOutPlateId() {
		return this.__out_plate_id;
	}

	public void setOutPlateId( java.lang.Integer value ) {
		this.__out_plate_id = value;
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
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getStartMonth() != null) sb.append(__wrapNumber(1, "startMonth", getStartMonth()));
		if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		if(getInPlateId() != null) sb.append(__wrapNumber(1, "inPlateId", getInPlateId()));
		if(getOutPlateId() != null) sb.append(__wrapNumber(1, "outPlateId", getOutPlateId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("startMonth")) != null) setStartMonth(__getInt(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
		if((val = values.get("inPlateId")) != null) setInPlateId(__getInt(val)); 
		if((val = values.get("outPlateId")) != null) setOutPlateId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __year = null;
	private java.lang.Integer __start_month = null;
	private java.lang.Integer __end_month = null;
	private java.lang.Integer __in_plate_id = null;
	private java.lang.Integer __out_plate_id = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __employee_id = null;
}

