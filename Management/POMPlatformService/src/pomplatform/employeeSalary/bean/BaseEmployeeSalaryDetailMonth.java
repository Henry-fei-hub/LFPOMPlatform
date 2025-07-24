package pomplatform.employeeSalary.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeSalaryDetailMonth extends GenericBase implements BaseFactory<BaseEmployeeSalaryDetailMonth>, Comparable<BaseEmployeeSalaryDetailMonth> 
{


	public static BaseEmployeeSalaryDetailMonth newInstance(){
		return new BaseEmployeeSalaryDetailMonth();
	}

	@Override
	public BaseEmployeeSalaryDetailMonth make(){
		BaseEmployeeSalaryDetailMonth b = new BaseEmployeeSalaryDetailMonth();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SALARY_YEAR = "salary_year" ;
	public final static java.lang.String CS_SALARY_MONTH = "salary_month" ;
	public final static java.lang.String CS_BASIC_SALARY = "basic_salary" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,年份,月份,基本工资";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getSalaryYear() {
		return this.__salary_year;
	}

	public void setSalaryYear( java.lang.Integer value ) {
		this.__salary_year = value;
	}

	public java.lang.Integer getSalaryMonth() {
		return this.__salary_month;
	}

	public void setSalaryMonth( java.lang.Integer value ) {
		this.__salary_month = value;
	}

	public java.lang.String getBasicSalary() {
		return this.__basic_salary;
	}

	public void setBasicSalary( java.lang.String value ) {
		this.__basic_salary = value;
	}

	public void cloneCopy(BaseEmployeeSalaryDetailMonth __bean){
		__bean.setEmployeeId(getEmployeeId());
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
		String strSalaryYear = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getSalaryYear()));
		sb.append(strSalaryYear == null ? "" : strSalaryYear);
		sb.append(",");
		sb.append(getSalaryMonth() == null ? "" : getSalaryMonth());
		sb.append(",");
		sb.append(getBasicSalary() == null ? "" : getBasicSalary());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeSalaryDetailMonth o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__salary_year);
		hash = 97 * hash + Objects.hashCode(this.__salary_month);
		hash = 97 * hash + Objects.hashCode(this.__basic_salary);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeSalaryDetailMonth o = (BaseEmployeeSalaryDetailMonth)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
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
		if(getSalaryYear() != null) sb.append(__wrapNumber(count++, "salaryYear", getSalaryYear()));
		if(getSalaryMonth() != null) sb.append(__wrapNumber(count++, "salaryMonth", getSalaryMonth()));
		if(getBasicSalary() != null) sb.append(__wrapString(count++, "basicSalary", getBasicSalary()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("salaryYear")) != null) setSalaryYear(__getInt(val)); 
		if((val = values.get("salaryMonth")) != null) setSalaryMonth(__getInt(val)); 
		if((val = values.get("basicSalary")) != null) setBasicSalary(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __salary_year ;
	protected java.lang.Integer  __salary_month ;
	protected java.lang.String  __basic_salary ;
}
