package pomplatform.addProjectEmpSalary.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMaddProjectEmpSalary extends GenericBase implements BaseFactory<BaseMaddProjectEmpSalary>, Comparable<BaseMaddProjectEmpSalary> 
{


	public static BaseMaddProjectEmpSalary newInstance(){
		return new BaseMaddProjectEmpSalary();
	}

	@Override
	public BaseMaddProjectEmpSalary make(){
		BaseMaddProjectEmpSalary b = new BaseMaddProjectEmpSalary();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SALARY_MONTH = "salary_month" ;
	public final static java.lang.String CS_BASIC_SALARY = "basic_salary" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,员工编码,月份,基本工资";

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

	public void cloneCopy(BaseMaddProjectEmpSalary __bean){
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSalaryMonth(getSalaryMonth());
		__bean.setBasicSalary(getBasicSalary());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getSalaryMonth() == null ? "" : getSalaryMonth());
		sb.append(",");
		sb.append(getBasicSalary() == null ? "" : getBasicSalary());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMaddProjectEmpSalary o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__salary_month);
		hash = 97 * hash + Objects.hashCode(this.__basic_salary);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMaddProjectEmpSalary o = (BaseMaddProjectEmpSalary)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__salary_month, o.getSalaryMonth())) return false;
		if(!Objects.equals(this.__basic_salary, o.getBasicSalary())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSalaryMonth() != null) sb.append(__wrapString(count++, "salaryMonth", getSalaryMonth()));
		if(getBasicSalary() != null) sb.append(__wrapString(count++, "basicSalary", getBasicSalary()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("salaryMonth")) != null) setSalaryMonth(__getString(val));
		if((val = values.get("basicSalary")) != null) setBasicSalary(__getString(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __salary_month ;
	protected java.lang.String  __basic_salary ;
}
