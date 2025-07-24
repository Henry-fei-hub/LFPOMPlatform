package pomplatform.check.bean;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericCondition;

import java.util.Calendar;
import java.util.Map;

public class ConditionSemployeemonthlycheckymor extends GenericCondition{

	public ConditionSemployeemonthlycheckymor(){
		setParameterCount(6);
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getResignationDate() {
		return __resignation_date;
	}

	public void setResignationDate(java.util.Date value) {
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
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if(values.get("year") != null){
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, BaseHelpUtils.getIntValue(values.get("year")));
			if(values.get("month") != null){
				c.set(Calendar.MONTH, BaseHelpUtils.getIntValue(values.get("month")) - 1);
			}else{
				c.set(Calendar.MONTH, 0);
			}
			c.set(Calendar.DATE, 1);
			setResignationDate(c.getTime());
		}
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.util.Date __resignation_date = null;
}

