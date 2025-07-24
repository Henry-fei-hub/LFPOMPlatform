package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateSalaryAdvanceRecord extends GenericBase implements BaseFactory<BasePlateSalaryAdvanceRecord>, Comparable<BasePlateSalaryAdvanceRecord> 
{


	public static BasePlateSalaryAdvanceRecord newInstance(){
		return new BasePlateSalaryAdvanceRecord();
	}

	@Override
	public BasePlateSalaryAdvanceRecord make(){
		BasePlateSalaryAdvanceRecord b = new BasePlateSalaryAdvanceRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_SALARY_ADVANCE_RECORD_ID = "plate_salary_advance_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_SALARY_RETURN = "salary_return" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_IS_RETURN = "is_return" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,业务部门,员工,姓名,工号,人工成本补偿积分,记录产生时间,积分是否回收的标识，true回收； false不回收";

	public java.lang.Integer getPlateSalaryAdvanceRecordId() {
		return this.__plate_salary_advance_record_id;
	}

	public void setPlateSalaryAdvanceRecordId( java.lang.Integer value ) {
		this.__plate_salary_advance_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.math.BigDecimal getSalaryReturn() {
		return this.__salary_return;
	}

	public void setSalaryReturn( java.math.BigDecimal value ) {
		this.__salary_return = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Boolean getIsReturn() {
		return this.__is_return;
	}

	public void setIsReturn( java.lang.Boolean value ) {
		this.__is_return = value;
	}

	public void cloneCopy(BasePlateSalaryAdvanceRecord __bean){
		__bean.setPlateSalaryAdvanceRecordId(getPlateSalaryAdvanceRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setSalaryReturn(getSalaryReturn());
		__bean.setRecordDate(getRecordDate());
		__bean.setIsReturn(getIsReturn());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateSalaryAdvanceRecordId() == null ? "" : getPlateSalaryAdvanceRecordId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getSalaryReturn() == null ? "" : getSalaryReturn());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getIsReturn() == null ? "" : getIsReturn());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateSalaryAdvanceRecord o) {
		return __plate_salary_advance_record_id == null ? -1 : __plate_salary_advance_record_id.compareTo(o.getPlateSalaryAdvanceRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_salary_advance_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__salary_return);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__is_return);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateSalaryAdvanceRecord o = (BasePlateSalaryAdvanceRecord)obj;
		if(!Objects.equals(this.__plate_salary_advance_record_id, o.getPlateSalaryAdvanceRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__salary_return, o.getSalaryReturn())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__is_return, o.getIsReturn())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateSalaryAdvanceRecordId() != null) sb.append(__wrapNumber(count++, "plateSalaryAdvanceRecordId", getPlateSalaryAdvanceRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getSalaryReturn() != null) sb.append(__wrapDecimal(count++, "salaryReturn", getSalaryReturn()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getIsReturn() != null) sb.append(__wrapBoolean(count++, "isReturn", getIsReturn()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateSalaryAdvanceRecordId")) != null) setPlateSalaryAdvanceRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("salaryReturn")) != null) setSalaryReturn(__getDecimal(val));  
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("isReturn")) != null) setIsReturn(__getBoolean(val));
	}

	protected java.lang.Integer  __plate_salary_advance_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __employee_no ;
	protected java.math.BigDecimal  __salary_return ;
	protected java.util.Date  __record_date ;
	protected java.lang.Boolean  __is_return ;
}
