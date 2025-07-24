package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnSalaryReportByCompany extends GenericBase implements BaseFactory<BaseOnSalaryReportByCompany>, Comparable<BaseOnSalaryReportByCompany> 
{


	public static BaseOnSalaryReportByCompany newInstance(){
		return new BaseOnSalaryReportByCompany();
	}

	@Override
	public BaseOnSalaryReportByCompany make(){
		BaseOnSalaryReportByCompany b = new BaseOnSalaryReportByCompany();
		return b;
	}

	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_SHOULD_SALARY = "should_salary" ;
	public final static java.lang.String CS_LEAVE_ADVANCE = "leave_advance" ;
	public final static java.lang.String CS_SHOULD_BONUS = "should_bonus" ;
	public final static java.lang.String CS_SHOULD_TOTAL = "should_total" ;
	public final static java.lang.String CS_SHOULD_TAX = "should_tax" ;
	public final static java.lang.String CS_TOTAL_INSURANCE = "total_insurance" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT = "instead_deduct" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT_ILL = "instead_deduct_ill" ;
	public final static java.lang.String CS_FACT_SALARY = "fact_salary" ;
	public final static java.lang.String CS_NUM = "num" ;
	public final static java.lang.String CS_UNIT_TOTAL_INSURANCE = "unit_total_insurance" ;
	public final static java.lang.String CS_UNIT_TOTAL_FUND = "unit_total_fund" ;
	public final static java.lang.String CS_REPLACEMENT_TAX = "replacement_tax" ;
	public final static java.lang.String CS_SUSPEND_BONUS = "suspend_bonus" ;

	public final static java.lang.String ALL_CAPTIONS = "归属公司,年份,月份,应付工资,离职补偿,应付奖金,应付合计,代扣个税,代扣社保,代扣公积金,代扣补贴,代扣重疾险,实发工资,工资发放人数,单位社保,单位公积金,应补退税,暂扣奖金";

	

	public java.math.BigDecimal getSuspendBonus() {
		return this.__suspend_bonus;
	}

	public void setSuspendBonus( java.math.BigDecimal value ) {
		this.__suspend_bonus = value;
	}
	
	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
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

	public java.math.BigDecimal getShouldSalary() {
		return this.__should_salary;
	}

	public void setShouldSalary( java.math.BigDecimal value ) {
		this.__should_salary = value;
	}

	public java.math.BigDecimal getLeaveAdvance() {
		return this.__leave_advance;
	}

	public void setLeaveAdvance( java.math.BigDecimal value ) {
		this.__leave_advance = value;
	}

	public java.math.BigDecimal getShouldBonus() {
		return this.__should_bonus;
	}

	public void setShouldBonus( java.math.BigDecimal value ) {
		this.__should_bonus = value;
	}

	public java.math.BigDecimal getShouldTotal() {
		return this.__should_total;
	}

	public void setShouldTotal( java.math.BigDecimal value ) {
		this.__should_total = value;
	}

	public java.math.BigDecimal getShouldTax() {
		return this.__should_tax;
	}

	public void setShouldTax( java.math.BigDecimal value ) {
		this.__should_tax = value;
	}

	public java.math.BigDecimal getTotalInsurance() {
		return this.__total_insurance;
	}

	public void setTotalInsurance( java.math.BigDecimal value ) {
		this.__total_insurance = value;
	}

	public java.math.BigDecimal getTotalFund() {
		return this.__total_fund;
	}

	public void setTotalFund( java.math.BigDecimal value ) {
		this.__total_fund = value;
	}

	public java.math.BigDecimal getInsteadDeduct() {
		return this.__instead_deduct;
	}

	public void setInsteadDeduct( java.math.BigDecimal value ) {
		this.__instead_deduct = value;
	}

	public java.math.BigDecimal getInsteadDeductIll() {
		return this.__instead_deduct_ill;
	}

	public void setInsteadDeductIll( java.math.BigDecimal value ) {
		this.__instead_deduct_ill = value;
	}

	public java.math.BigDecimal getFactSalary() {
		return this.__fact_salary;
	}

	public void setFactSalary( java.math.BigDecimal value ) {
		this.__fact_salary = value;
	}

	public java.lang.Integer getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Integer value ) {
		this.__num = value;
	}

	public java.math.BigDecimal getUnitTotalInsurance() {
		return this.__unit_total_insurance;
	}

	public void setUnitTotalInsurance( java.math.BigDecimal value ) {
		this.__unit_total_insurance = value;
	}

	public java.math.BigDecimal getUnitTotalFund() {
		return this.__unit_total_fund;
	}

	public void setUnitTotalFund( java.math.BigDecimal value ) {
		this.__unit_total_fund = value;
	}
	public java.math.BigDecimal getReplacementTax() {
		return this.__replacement_tax;
	}
	
	public void setReplacementTax( java.math.BigDecimal value ) {
		this.__replacement_tax = value;
	}

	public void cloneCopy(BaseOnSalaryReportByCompany __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setShouldSalary(getShouldSalary());
		__bean.setLeaveAdvance(getLeaveAdvance());
		__bean.setShouldBonus(getShouldBonus());
		__bean.setShouldTotal(getShouldTotal());
		__bean.setShouldTax(getShouldTax());
		__bean.setTotalInsurance(getTotalInsurance());
		__bean.setTotalFund(getTotalFund());
		__bean.setInsteadDeduct(getInsteadDeduct());
		__bean.setInsteadDeductIll(getInsteadDeductIll());
		__bean.setFactSalary(getFactSalary());
		__bean.setNum(getNum());
		__bean.setUnitTotalInsurance(getUnitTotalInsurance());
		__bean.setUnitTotalFund(getUnitTotalFund());
		__bean.setReplacementTax(getReplacementTax());
		__bean.setSuspendBonus(getSuspendBonus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getShouldSalary() == null ? "" : getShouldSalary());
		sb.append(",");
		sb.append(getLeaveAdvance() == null ? "" : getLeaveAdvance());
		sb.append(",");
		sb.append(getShouldBonus() == null ? "" : getShouldBonus());
		sb.append(",");
		sb.append(getShouldTotal() == null ? "" : getShouldTotal());
		sb.append(",");
		sb.append(getShouldTax() == null ? "" : getShouldTax());
		sb.append(",");
		sb.append(getTotalInsurance() == null ? "" : getTotalInsurance());
		sb.append(",");
		sb.append(getTotalFund() == null ? "" : getTotalFund());
		sb.append(",");
		sb.append(getInsteadDeduct() == null ? "" : getInsteadDeduct());
		sb.append(",");
		sb.append(getInsteadDeductIll() == null ? "" : getInsteadDeductIll());
		sb.append(",");
		sb.append(getFactSalary() == null ? "" : getFactSalary());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		sb.append(",");
		sb.append(getUnitTotalInsurance() == null ? "" : getUnitTotalInsurance());
		sb.append(",");
		sb.append(getUnitTotalFund() == null ? "" : getUnitTotalFund());
		sb.append(",");
		sb.append(getReplacementTax() == null ? "" : getReplacementTax());
		sb.append(",");
		sb.append(getSuspendBonus() == null ? "" : getSuspendBonus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnSalaryReportByCompany o) {
		return __company_id == null ? -1 : __company_id.compareTo(o.getCompanyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__should_salary);
		hash = 97 * hash + Objects.hashCode(this.__leave_advance);
		hash = 97 * hash + Objects.hashCode(this.__should_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_total);
		hash = 97 * hash + Objects.hashCode(this.__should_tax);
		hash = 97 * hash + Objects.hashCode(this.__total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__total_fund);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct_ill);
		hash = 97 * hash + Objects.hashCode(this.__fact_salary);
		hash = 97 * hash + Objects.hashCode(this.__num);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__replacement_tax);
		hash = 97 * hash + Objects.hashCode(this.__suspend_bonus);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnSalaryReportByCompany o = (BaseOnSalaryReportByCompany)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__should_salary, o.getShouldSalary())) return false;
		if(!Objects.equals(this.__leave_advance, o.getLeaveAdvance())) return false;
		if(!Objects.equals(this.__should_bonus, o.getShouldBonus())) return false;
		if(!Objects.equals(this.__should_total, o.getShouldTotal())) return false;
		if(!Objects.equals(this.__should_tax, o.getShouldTax())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__instead_deduct, o.getInsteadDeduct())) return false;
		if(!Objects.equals(this.__instead_deduct_ill, o.getInsteadDeductIll())) return false;
		if(!Objects.equals(this.__fact_salary, o.getFactSalary())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		if(!Objects.equals(this.__unit_total_insurance, o.getUnitTotalInsurance())) return false;
		if(!Objects.equals(this.__unit_total_fund, o.getUnitTotalFund())) return false;
		if(!Objects.equals(this.__replacement_tax, o.getReplacementTax())) return false;
		if(!Objects.equals(this.__suspend_bonus, o.getSuspendBonus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getShouldSalary() != null) sb.append(__wrapDecimal(count++, "shouldSalary", getShouldSalary()));
		if(getLeaveAdvance() != null) sb.append(__wrapDecimal(count++, "leaveAdvance", getLeaveAdvance()));
		if(getShouldBonus() != null) sb.append(__wrapDecimal(count++, "shouldBonus", getShouldBonus()));
		if(getShouldTotal() != null) sb.append(__wrapDecimal(count++, "shouldTotal", getShouldTotal()));
		if(getShouldTax() != null) sb.append(__wrapDecimal(count++, "shouldTax", getShouldTax()));
		if(getTotalInsurance() != null) sb.append(__wrapDecimal(count++, "totalInsurance", getTotalInsurance()));
		if(getTotalFund() != null) sb.append(__wrapDecimal(count++, "totalFund", getTotalFund()));
		if(getInsteadDeduct() != null) sb.append(__wrapDecimal(count++, "insteadDeduct", getInsteadDeduct()));
		if(getInsteadDeductIll() != null) sb.append(__wrapDecimal(count++, "insteadDeductIll", getInsteadDeductIll()));
		if(getFactSalary() != null) sb.append(__wrapDecimal(count++, "factSalary", getFactSalary()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		if(getUnitTotalInsurance() != null) sb.append(__wrapDecimal(count++, "unitTotalInsurance", getUnitTotalInsurance()));
		if(getUnitTotalFund() != null) sb.append(__wrapDecimal(count++, "unitTotalFund", getUnitTotalFund()));
		if(getReplacementTax() != null) sb.append(__wrapDecimal(count++, "replacementTax", getReplacementTax()));
		if(getSuspendBonus() != null) sb.append(__wrapDecimal(count++, "suspendBonus", getSuspendBonus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("shouldSalary")) != null) setShouldSalary(__getDecimal(val));  
		if((val = values.get("leaveAdvance")) != null) setLeaveAdvance(__getDecimal(val));  
		if((val = values.get("shouldBonus")) != null) setShouldBonus(__getDecimal(val));  
		if((val = values.get("shouldTotal")) != null) setShouldTotal(__getDecimal(val));  
		if((val = values.get("shouldTax")) != null) setShouldTax(__getDecimal(val));  
		if((val = values.get("totalInsurance")) != null) setTotalInsurance(__getDecimal(val));  
		if((val = values.get("totalFund")) != null) setTotalFund(__getDecimal(val));  
		if((val = values.get("insteadDeduct")) != null) setInsteadDeduct(__getDecimal(val));  
		if((val = values.get("insteadDeductIll")) != null) setInsteadDeductIll(__getDecimal(val));  
		if((val = values.get("factSalary")) != null) setFactSalary(__getDecimal(val));  
		if((val = values.get("num")) != null) setNum(__getInt(val)); 
		if((val = values.get("unitTotalInsurance")) != null) setUnitTotalInsurance(__getDecimal(val));  
		if((val = values.get("unitTotalFund")) != null) setUnitTotalFund(__getDecimal(val));  
		if((val = values.get("replacementTax")) != null) setReplacementTax(__getDecimal(val));  
		if((val = values.get("suspendBonus")) != null) setSuspendBonus(__getDecimal(val));  
	}

	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __should_salary ;
	protected java.math.BigDecimal  __leave_advance ;
	protected java.math.BigDecimal  __should_bonus ;
	protected java.math.BigDecimal  __should_total ;
	protected java.math.BigDecimal  __should_tax ;
	protected java.math.BigDecimal  __total_insurance ;
	protected java.math.BigDecimal  __total_fund ;
	protected java.math.BigDecimal  __instead_deduct ;
	protected java.math.BigDecimal  __instead_deduct_ill ;
	protected java.math.BigDecimal  __fact_salary ;
	protected java.lang.Integer  __num ;
	protected java.math.BigDecimal  __unit_total_insurance ;
	protected java.math.BigDecimal  __unit_total_fund ;
	protected java.math.BigDecimal  __replacement_tax ;
	protected java.math.BigDecimal  __suspend_bonus ;
}
