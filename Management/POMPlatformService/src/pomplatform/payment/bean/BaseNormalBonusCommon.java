package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseNormalBonusCommon extends GenericBase implements BaseFactory<BaseNormalBonusCommon>, Comparable<BaseNormalBonusCommon> 
{


	public static BaseNormalBonusCommon newInstance(){
		return new BaseNormalBonusCommon();
	}

	@Override
	public BaseNormalBonusCommon make(){
		BaseNormalBonusCommon b = new BaseNormalBonusCommon();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_SHOULD_BONUS = "should_bonus" ;
	public final static java.lang.String CS_SHOULD_TAX = "should_tax" ;
	public final static java.lang.String CS_FACT_BONUS = "fact_bonus" ;
	public final static java.lang.String CS_OTHER_BONUS = "other_bonus" ;
	public final static java.lang.String CS_PROJECT_BONUS = "project_bonus" ;
	public final static java.lang.String CS_SALARY_TYPE = "salary_type" ;
	public final static java.lang.String CS_FUNDRAISING_PROJECT_TYPE = "fundraising_project_type" ;
	public final static java.lang.String CS_FUNDRAISING_PROJECT_RATE = "fundraising_project_rate" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工id,员工编号,业务部门,年份,月份,,,,,,类型（1.募投项目 2.研发项目）,募投项目类型,募投比例,流程业务表Id,所属公司";

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

	public java.math.BigDecimal getShouldBonus() {
		return this.__should_bonus;
	}

	public void setShouldBonus( java.math.BigDecimal value ) {
		this.__should_bonus = value;
	}

	public java.math.BigDecimal getShouldTax() {
		return this.__should_tax;
	}

	public void setShouldTax( java.math.BigDecimal value ) {
		this.__should_tax = value;
	}

	public java.math.BigDecimal getFactBonus() {
		return this.__fact_bonus;
	}

	public void setFactBonus( java.math.BigDecimal value ) {
		this.__fact_bonus = value;
	}

	public java.math.BigDecimal getOtherBonus() {
		return this.__other_bonus;
	}

	public void setOtherBonus( java.math.BigDecimal value ) {
		this.__other_bonus = value;
	}

	public java.math.BigDecimal getProjectBonus() {
		return this.__project_bonus;
	}

	public void setProjectBonus( java.math.BigDecimal value ) {
		this.__project_bonus = value;
	}

	public java.lang.Integer getSalaryType() {
		return this.__salary_type;
	}

	public void setSalaryType( java.lang.Integer value ) {
		this.__salary_type = value;
	}

	public java.lang.Integer getFundraisingProjectType() {
		return this.__fundraising_project_type;
	}

	public void setFundraisingProjectType( java.lang.Integer value ) {
		this.__fundraising_project_type = value;
	}

	public java.math.BigDecimal getFundraisingProjectRate() {
		return this.__fundraising_project_rate;
	}

	public void setFundraisingProjectRate( java.math.BigDecimal value ) {
		this.__fundraising_project_rate = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public void cloneCopy(BaseNormalBonusCommon __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setShouldBonus(getShouldBonus());
		__bean.setShouldTax(getShouldTax());
		__bean.setFactBonus(getFactBonus());
		__bean.setOtherBonus(getOtherBonus());
		__bean.setProjectBonus(getProjectBonus());
		__bean.setSalaryType(getSalaryType());
		__bean.setFundraisingProjectType(getFundraisingProjectType());
		__bean.setFundraisingProjectRate(getFundraisingProjectRate());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getShouldBonus() == null ? "" : getShouldBonus());
		sb.append(",");
		sb.append(getShouldTax() == null ? "" : getShouldTax());
		sb.append(",");
		sb.append(getFactBonus() == null ? "" : getFactBonus());
		sb.append(",");
		sb.append(getOtherBonus() == null ? "" : getOtherBonus());
		sb.append(",");
		sb.append(getProjectBonus() == null ? "" : getProjectBonus());
		sb.append(",");
		sb.append(getSalaryType() == null ? "" : getSalaryType());
		sb.append(",");
		sb.append(getFundraisingProjectType() == null ? "" : getFundraisingProjectType());
		sb.append(",");
		sb.append(getFundraisingProjectRate() == null ? "" : getFundraisingProjectRate());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNormalBonusCommon o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__should_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_tax);
		hash = 97 * hash + Objects.hashCode(this.__fact_bonus);
		hash = 97 * hash + Objects.hashCode(this.__other_bonus);
		hash = 97 * hash + Objects.hashCode(this.__project_bonus);
		hash = 97 * hash + Objects.hashCode(this.__salary_type);
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_type);
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_rate);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNormalBonusCommon o = (BaseNormalBonusCommon)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__should_bonus, o.getShouldBonus())) return false;
		if(!Objects.equals(this.__should_tax, o.getShouldTax())) return false;
		if(!Objects.equals(this.__fact_bonus, o.getFactBonus())) return false;
		if(!Objects.equals(this.__other_bonus, o.getOtherBonus())) return false;
		if(!Objects.equals(this.__project_bonus, o.getProjectBonus())) return false;
		if(!Objects.equals(this.__salary_type, o.getSalaryType())) return false;
		if(!Objects.equals(this.__fundraising_project_type, o.getFundraisingProjectType())) return false;
		if(!Objects.equals(this.__fundraising_project_rate, o.getFundraisingProjectRate())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getShouldBonus() != null) sb.append(__wrapDecimal(count++, "shouldBonus", getShouldBonus()));
		if(getShouldTax() != null) sb.append(__wrapDecimal(count++, "shouldTax", getShouldTax()));
		if(getFactBonus() != null) sb.append(__wrapDecimal(count++, "factBonus", getFactBonus()));
		if(getOtherBonus() != null) sb.append(__wrapDecimal(count++, "otherBonus", getOtherBonus()));
		if(getProjectBonus() != null) sb.append(__wrapDecimal(count++, "projectBonus", getProjectBonus()));
		if(getSalaryType() != null) sb.append(__wrapNumber(count++, "salaryType", getSalaryType()));
		if(getFundraisingProjectType() != null) sb.append(__wrapNumber(count++, "fundraisingProjectType", getFundraisingProjectType()));
		if(getFundraisingProjectRate() != null) sb.append(__wrapDecimal(count++, "fundraisingProjectRate", getFundraisingProjectRate()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getShouldBonus() != null) res.put("shouldBonus", getShouldBonus());
		if(getShouldTax() != null) res.put("shouldTax", getShouldTax());
		if(getFactBonus() != null) res.put("factBonus", getFactBonus());
		if(getOtherBonus() != null) res.put("otherBonus", getOtherBonus());
		if(getProjectBonus() != null) res.put("projectBonus", getProjectBonus());
		if(getSalaryType() != null) res.put("salaryType", getSalaryType());
		if(getFundraisingProjectType() != null) res.put("fundraisingProjectType", getFundraisingProjectType());
		if(getFundraisingProjectRate() != null) res.put("fundraisingProjectRate", getFundraisingProjectRate());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("shouldBonus")) != null) setShouldBonus(__getDecimal(val));  
		if((val = values.get("shouldTax")) != null) setShouldTax(__getDecimal(val));  
		if((val = values.get("factBonus")) != null) setFactBonus(__getDecimal(val));  
		if((val = values.get("otherBonus")) != null) setOtherBonus(__getDecimal(val));  
		if((val = values.get("projectBonus")) != null) setProjectBonus(__getDecimal(val));  
		if((val = values.get("salaryType")) != null) setSalaryType(__getInt(val)); 
		if((val = values.get("fundraisingProjectType")) != null) setFundraisingProjectType(__getInt(val)); 
		if((val = values.get("fundraisingProjectRate")) != null) setFundraisingProjectRate(__getDecimal(val));  
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __should_bonus ;
	protected java.math.BigDecimal  __should_tax ;
	protected java.math.BigDecimal  __fact_bonus ;
	protected java.math.BigDecimal  __other_bonus ;
	protected java.math.BigDecimal  __project_bonus ;
	protected java.lang.Integer  __salary_type ;
	protected java.lang.Integer  __fundraising_project_type ;
	protected java.math.BigDecimal  __fundraising_project_rate ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __company_id ;
}
