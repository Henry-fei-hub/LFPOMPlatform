package pomplatform.employeeAward.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeeAward extends GenericBase implements BaseFactory<BaseMemployeeAward>, Comparable<BaseMemployeeAward> 
{


	public static BaseMemployeeAward newInstance(){
		return new BaseMemployeeAward();
	}

	@Override
	public BaseMemployeeAward make(){
		BaseMemployeeAward b = new BaseMemployeeAward();
		return b;
	}

	public final static java.lang.String CS_PHOTO = "photo" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEARS = "years" ;
	public final static java.lang.String CS_MONTHS = "months" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_ACHIEVE_AWARD = "achieve_award" ;
	public final static java.lang.String CS_BASE_SALARY = "base_salary" ;

	public final static java.lang.String ALL_CAPTIONS = "头像,职员编码,名称,部门,业务部门,年份,月份,预分配积分,确定积分,项目成本,结算积分,价值积分,基本薪资";

	public java.lang.String getPhoto() {
		return this.__photo;
	}

	public void setPhoto( java.lang.String value ) {
		this.__photo = value;
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

	public java.lang.Integer getYears() {
		return this.__years;
	}

	public void setYears( java.lang.Integer value ) {
		this.__years = value;
	}

	public java.lang.Integer getMonths() {
		return this.__months;
	}

	public void setMonths( java.lang.Integer value ) {
		this.__months = value;
	}

	public java.math.BigDecimal getPlanIntegral() {
		return this.__plan_integral;
	}

	public void setPlanIntegral( java.math.BigDecimal value ) {
		this.__plan_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getAchieveAward() {
		return this.__achieve_award;
	}

	public void setAchieveAward( java.math.BigDecimal value ) {
		this.__achieve_award = value;
	}

	public java.math.BigDecimal getBaseSalary() {
		return this.__base_salary;
	}

	public void setBaseSalary( java.math.BigDecimal value ) {
		this.__base_salary = value;
	}

	public void cloneCopy(BaseMemployeeAward __bean){
		__bean.setPhoto(getPhoto());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setPlateId(getPlateId());
		__bean.setYears(getYears());
		__bean.setMonths(getMonths());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setProjectCost(getProjectCost());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setAchieveAward(getAchieveAward());
		__bean.setBaseSalary(getBaseSalary());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPhoto() == null ? "" : getPhoto());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getYears() == null ? "" : getYears());
		sb.append(",");
		sb.append(getMonths() == null ? "" : getMonths());
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getAchieveAward() == null ? "" : getAchieveAward());
		sb.append(",");
		sb.append(getBaseSalary() == null ? "" : getBaseSalary());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeeAward o) {
		return __photo == null ? -1 : __photo.compareTo(o.getPhoto());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__photo);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__years);
		hash = 97 * hash + Objects.hashCode(this.__months);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__achieve_award);
		hash = 97 * hash + Objects.hashCode(this.__base_salary);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeeAward o = (BaseMemployeeAward)obj;
		if(!Objects.equals(this.__photo, o.getPhoto())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__years, o.getYears())) return false;
		if(!Objects.equals(this.__months, o.getMonths())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__achieve_award, o.getAchieveAward())) return false;
		if(!Objects.equals(this.__base_salary, o.getBaseSalary())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPhoto() != null) sb.append(__wrapString(count++, "photo", getPhoto()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYears() != null) sb.append(__wrapNumber(count++, "years", getYears()));
		if(getMonths() != null) sb.append(__wrapNumber(count++, "months", getMonths()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if(getAchieveAward() != null) sb.append(__wrapDecimal(count++, "achieveAward", getAchieveAward()));
		if(getBaseSalary() != null) sb.append(__wrapDecimal(count++, "baseSalary", getBaseSalary()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("photo")) != null) setPhoto(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("years")) != null) setYears(__getInt(val)); 
		if((val = values.get("months")) != null) setMonths(__getInt(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));  
		if((val = values.get("achieveAward")) != null) setAchieveAward(__getDecimal(val));  
		if((val = values.get("baseSalary")) != null) setBaseSalary(__getDecimal(val));  
	}

	protected java.lang.String  __photo ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __years ;
	protected java.lang.Integer  __months ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.math.BigDecimal  __achieve_integral ;
	protected java.math.BigDecimal  __achieve_award ;
	protected java.math.BigDecimal  __base_salary ;
}
