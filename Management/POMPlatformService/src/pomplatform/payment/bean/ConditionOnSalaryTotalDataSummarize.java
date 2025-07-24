package pomplatform.payment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnSalaryTotalDataSummarize extends GenericCondition{

	public ConditionOnSalaryTotalDataSummarize(){
		setParameterCount(10);
	}

	public java.lang.Integer getStartyear() {
		return this.__startyear;
	}

	public void setStartyear( java.lang.Integer value ) {
		this.__startyear = value;
	}

	public java.lang.Integer getEndyear() {
		return this.__endyear;
	}

	public void setEndyear( java.lang.Integer value ) {
		this.__endyear = value;
	}

	public java.lang.Integer getStartmonth() {
		return this.__startmonth;
	}

	public void setStartmonth( java.lang.Integer value ) {
		this.__startmonth = value;
	}

	public java.lang.Integer getEndmonth() {
		return this.__endmonth;
	}

	public void setEndmonth( java.lang.Integer value ) {
		this.__endmonth = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartyear() != null) sb.append(__wrapNumber(1, "startyear", getStartyear()));
		if(getEndyear() != null) sb.append(__wrapNumber(1, "endyear", getEndyear()));
		if(getStartmonth() != null) sb.append(__wrapNumber(1, "startmonth", getStartmonth()));
		if(getEndmonth() != null) sb.append(__wrapNumber(1, "endmonth", getEndmonth()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startyear")) != null) setStartyear(__getInt(val)); 
		if((val = values.get("endyear")) != null) setEndyear(__getInt(val)); 
		if((val = values.get("startmonth")) != null) setStartmonth(__getInt(val)); 
		if((val = values.get("endmonth")) != null) setEndmonth(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	private java.lang.Integer __startyear = null;
	private java.lang.Integer __endyear = null;
	private java.lang.Integer __startmonth = null;
	private java.lang.Integer __endmonth = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_no = null;
	private java.lang.String __employee_name = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __plate_id = null;
}

