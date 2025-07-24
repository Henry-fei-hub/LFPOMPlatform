package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnSalaryEmpBonusByDepartment extends GenericBase implements BaseFactory<BaseOnSalaryEmpBonusByDepartment>, Comparable<BaseOnSalaryEmpBonusByDepartment> 
{


	public static BaseOnSalaryEmpBonusByDepartment newInstance(){
		return new BaseOnSalaryEmpBonusByDepartment();
	}

	@Override
	public BaseOnSalaryEmpBonusByDepartment make(){
		BaseOnSalaryEmpBonusByDepartment b = new BaseOnSalaryEmpBonusByDepartment();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_SHOULD_BONUS = "should_bonus" ;
	public final static java.lang.String CS_SHOULD_TAX = "should_tax" ;
	public final static java.lang.String CS_FACT_BONUS = "fact_bonus" ;
	public final static java.lang.String CS_OTHER_BONUS = "other_bonus" ;
	public final static java.lang.String CS_PROJECT_BONUS = "project_bonus" ;
	
	public final static java.lang.String ALL_CAPTIONS = "员工编号,员工id,年份,月份,应发奖金,应纳个税,实发奖金,其他奖金,项目奖金";

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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
	
	public void cloneCopy(BaseOnSalaryEmpBonusByDepartment __bean){
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setShouldBonus(getShouldBonus());
		__bean.setShouldTax(getShouldTax());
		__bean.setFactBonus(getFactBonus());
		__bean.setOtherBonus(getOtherBonus());
		__bean.setProjectBonus(getProjectBonus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnSalaryEmpBonusByDepartment o) {
		return __employee_no == null ? -1 : __employee_no.compareTo(o.getEmployeeNo());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__should_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_tax);
		hash = 97 * hash + Objects.hashCode(this.__fact_bonus);
		hash = 97 * hash + Objects.hashCode(this.__other_bonus);
		hash = 97 * hash + Objects.hashCode(this.__project_bonus);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnSalaryEmpBonusByDepartment o = (BaseOnSalaryEmpBonusByDepartment)obj;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__should_bonus, o.getShouldBonus())) return false;
		if(!Objects.equals(this.__should_tax, o.getShouldTax())) return false;
		if(!Objects.equals(this.__fact_bonus, o.getFactBonus())) return false;
		if(!Objects.equals(this.__other_bonus, o.getOtherBonus())) return false;
		if(!Objects.equals(this.__project_bonus, o.getProjectBonus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getShouldBonus() != null) sb.append(__wrapDecimal(count++, "shouldBonus", getShouldBonus()));
		if(getShouldTax() != null) sb.append(__wrapDecimal(count++, "shouldTax", getShouldTax()));
		if(getFactBonus() != null) sb.append(__wrapDecimal(count++, "factBonus", getFactBonus()));
		if(getOtherBonus() != null) sb.append(__wrapDecimal(count++, "otherBonus", getOtherBonus()));
		if(getProjectBonus() != null) sb.append(__wrapDecimal(count++, "projectBonus", getProjectBonus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("shouldBonus")) != null) setShouldBonus(__getDecimal(val));  
		if((val = values.get("shouldTax")) != null) setShouldTax(__getDecimal(val));  
		if((val = values.get("factBonus")) != null) setFactBonus(__getDecimal(val)); 
		if((val = values.get("otherBonus")) != null) setOtherBonus(__getDecimal(val));
		if((val = values.get("projectBonus")) != null) setProjectBonus(__getDecimal(val));
	}

	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __should_bonus ;
	protected java.math.BigDecimal  __should_tax ;
	protected java.math.BigDecimal  __fact_bonus ;
	protected java.math.BigDecimal  __other_bonus ;
	protected java.math.BigDecimal  __project_bonus ;
}
