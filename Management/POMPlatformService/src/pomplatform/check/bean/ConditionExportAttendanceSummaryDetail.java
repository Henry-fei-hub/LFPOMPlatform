package pomplatform.check.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionExportAttendanceSummaryDetail extends GenericCondition{

	public ConditionExportAttendanceSummaryDetail(){
		setParameterCount(9);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getResignationDate() {
		return this.__resignation_date;
	}

	public void setResignationDate( java.util.Date value ) {
		this.__resignation_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getRecordDate() != null) sb.append(__wrapDate(1, "recordDate", getRecordDate()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getResignationDate() != null) sb.append(__wrapDate(1, "resignationDate", getResignationDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("year")) != null) setYear(__getInt(val));
		if((val = values.get("month")) != null) setMonth(__getInt(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val));
		if((val = values.get("resignationDate")) != null) setResignationDate(__getDate(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getPlateId() != null) res.add("plateId");
		if(getYear() != null) res.add("year");
		if(getMonth() != null) res.add("month");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getEmployeeNo() != null) res.add("employeeNo");
		if(getRecordDate() != null) res.add("recordDate");
		if(getEmployeeName() != null) res.add("employeeName");
		if(getDepartmentId() != null) res.add("departmentId");
		if(getResignationDate() != null) res.add("resignationDate");
		return res;
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_no = null;
	private java.util.Date __record_date = null;
	private java.lang.String __employee_name = null;
	private java.lang.Integer __department_id = null;
	private java.util.Date __resignation_date = null;
}

