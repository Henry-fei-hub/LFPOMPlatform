package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnCheckEmployeeShiftOfShift extends GenericBase implements BaseFactory<BaseOnCheckEmployeeShiftOfShift>, Comparable<BaseOnCheckEmployeeShiftOfShift> 
{


	public static BaseOnCheckEmployeeShiftOfShift newInstance(){
		return new BaseOnCheckEmployeeShiftOfShift();
	}

	@Override
	public BaseOnCheckEmployeeShiftOfShift make(){
		BaseOnCheckEmployeeShiftOfShift b = new BaseOnCheckEmployeeShiftOfShift();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_SHIFT_MANAGE_ID = "employee_shift_manage_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_GENDER = "gender" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_SHIFT_MANAGE_ID = "shift_manage_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,班次,员工编号,员工姓名,性别,部门,班次编码,年份,月份,记录日期";

	public java.lang.Integer getEmployeeShiftManageId() {
		return this.__employee_shift_manage_id;
	}

	public void setEmployeeShiftManageId( java.lang.Integer value ) {
		this.__employee_shift_manage_id = value;
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

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getShiftManageId() {
		return this.__shift_manage_id;
	}

	public void setShiftManageId( java.lang.Integer value ) {
		this.__shift_manage_id = value;
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

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public void cloneCopy(BaseOnCheckEmployeeShiftOfShift __bean){
		__bean.setEmployeeShiftManageId(getEmployeeShiftManageId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setGender(getGender());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setShiftManageId(getShiftManageId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setRecordDate(getRecordDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeShiftManageId() == null ? "" : getEmployeeShiftManageId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strGender = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_12", String.valueOf(getGender()));
		sb.append(strGender == null ? "" : strGender);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getShiftManageId() == null ? "" : getShiftManageId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnCheckEmployeeShiftOfShift o) {
		return __employee_shift_manage_id == null ? -1 : __employee_shift_manage_id.compareTo(o.getEmployeeShiftManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_shift_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__shift_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnCheckEmployeeShiftOfShift o = (BaseOnCheckEmployeeShiftOfShift)obj;
		if(!Objects.equals(this.__employee_shift_manage_id, o.getEmployeeShiftManageId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__shift_manage_id, o.getShiftManageId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeShiftManageId() != null) sb.append(__wrapNumber(count++, "employeeShiftManageId", getEmployeeShiftManageId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getGender() != null) sb.append(__wrapNumber(count++, "gender", getGender()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getShiftManageId() != null) sb.append(__wrapNumber(count++, "shiftManageId", getShiftManageId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeShiftManageId")) != null) setEmployeeShiftManageId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("gender")) != null) setGender(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("shiftManageId")) != null) setShiftManageId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
	}

	protected java.lang.Integer  __employee_shift_manage_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __gender ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __shift_manage_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.util.Date  __record_date ;
}
