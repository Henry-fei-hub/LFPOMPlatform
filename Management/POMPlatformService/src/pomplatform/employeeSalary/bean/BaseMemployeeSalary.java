package pomplatform.employeeSalary.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeeSalary extends GenericBase implements BaseFactory<BaseMemployeeSalary>, Comparable<BaseMemployeeSalary> 
{


	public static BaseMemployeeSalary newInstance(){
		return new BaseMemployeeSalary();
	}

	@Override
	public BaseMemployeeSalary make(){
		BaseMemployeeSalary b = new BaseMemployeeSalary();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PHOTO = "photo" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_SALARY_YEAR = "salary_year" ;
	public final static java.lang.String CS_SALARY_MONTH = "salary_month" ;
	public final static java.lang.String CS_BASIC_SALARY = "basic_salary" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,头像,员工编号,员工姓名,部门,业务部门,年份,月份,基本工资";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getPhoto() {
		return this.__photo;
	}

	public void setPhoto( java.lang.String value ) {
		this.__photo = value;
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

	public java.lang.String getSalaryYear() {
		return this.__salary_year;
	}

	public void setSalaryYear( java.lang.String value ) {
		this.__salary_year = value;
	}

	public java.lang.String getSalaryMonth() {
		return this.__salary_month;
	}

	public void setSalaryMonth( java.lang.String value ) {
		this.__salary_month = value;
	}

	public java.lang.String getBasicSalary() {
		return this.__basic_salary;
	}

	public void setBasicSalary( java.lang.String value ) {
		this.__basic_salary = value;
	}

	public void cloneCopy(BaseMemployeeSalary __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPhoto(getPhoto());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setPlateId(getPlateId());
		__bean.setSalaryYear(getSalaryYear());
		__bean.setSalaryMonth(getSalaryMonth());
		__bean.setBasicSalary(getBasicSalary());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getPhoto() == null ? "" : getPhoto());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getSalaryYear() == null ? "" : getSalaryYear());
		sb.append(",");
		sb.append(getSalaryMonth() == null ? "" : getSalaryMonth());
		sb.append(",");
		sb.append(getBasicSalary() == null ? "" : getBasicSalary());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeeSalary o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__photo);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__salary_year);
		hash = 97 * hash + Objects.hashCode(this.__salary_month);
		hash = 97 * hash + Objects.hashCode(this.__basic_salary);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeeSalary o = (BaseMemployeeSalary)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__photo, o.getPhoto())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__salary_year, o.getSalaryYear())) return false;
		if(!Objects.equals(this.__salary_month, o.getSalaryMonth())) return false;
		if(!Objects.equals(this.__basic_salary, o.getBasicSalary())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPhoto() != null) sb.append(__wrapString(count++, "photo", getPhoto()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSalaryYear() != null) sb.append(__wrapString(count++, "salaryYear", getSalaryYear()));
		if(getSalaryMonth() != null) sb.append(__wrapString(count++, "salaryMonth", getSalaryMonth()));
		if(getBasicSalary() != null) sb.append(__wrapString(count++, "basicSalary", getBasicSalary()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("photo")) != null) setPhoto(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("salaryYear")) != null) setSalaryYear(__getString(val));
		if((val = values.get("salaryMonth")) != null) setSalaryMonth(__getString(val));
		if((val = values.get("basicSalary")) != null) setBasicSalary(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __photo ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __salary_year ;
	protected java.lang.String  __salary_month ;
	protected java.lang.String  __basic_salary ;
}
