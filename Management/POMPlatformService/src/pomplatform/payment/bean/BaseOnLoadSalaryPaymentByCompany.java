package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadSalaryPaymentByCompany extends GenericBase implements BaseFactory<BaseOnLoadSalaryPaymentByCompany>, Comparable<BaseOnLoadSalaryPaymentByCompany> 
{


	public static BaseOnLoadSalaryPaymentByCompany newInstance(){
		return new BaseOnLoadSalaryPaymentByCompany();
	}

	@Override
	public BaseOnLoadSalaryPaymentByCompany make(){
		BaseOnLoadSalaryPaymentByCompany b = new BaseOnLoadSalaryPaymentByCompany();
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
	public final static java.lang.String CS_PERSONAL_PENSION = "personal_pension" ;
	public final static java.lang.String CS_PERSONAL_MEDICAL_INSURANCE = "personal_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_UNEMPLOYMENT_INSURANCE = "personal_unemployment_insurance" ;
	public final static java.lang.String CS_PERSONAL_LARGE_MEDICAL_INSURANCE = "personal_large_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_HEATING = "personal_heating" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT = "instead_deduct" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT_ILL = "instead_deduct_ill" ;
	public final static java.lang.String CS_FACT_SALARY = "fact_salary" ;
	public final static java.lang.String CS_NUM = "num" ;
	public final static java.lang.String CS_TYPE = "type" ;

	public final static java.lang.String ALL_CAPTIONS = "归属公司,年份,月份,应发工资,离职补偿,应付奖金,应付合计,代扣个税,代扣社保,代扣养老,代扣医疗,代扣失业,代扣大额,代扣采暖,代扣公积金,代扣其他,重疾险,实发工资,工资发放人数,类型";

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

	public java.math.BigDecimal getPersonalPension() {
		return this.__personal_pension;
	}

	public void setPersonalPension( java.math.BigDecimal value ) {
		this.__personal_pension = value;
	}

	public java.math.BigDecimal getPersonalMedicalInsurance() {
		return this.__personal_medical_insurance;
	}

	public void setPersonalMedicalInsurance( java.math.BigDecimal value ) {
		this.__personal_medical_insurance = value;
	}

	public java.math.BigDecimal getPersonalUnemploymentInsurance() {
		return this.__personal_unemployment_insurance;
	}

	public void setPersonalUnemploymentInsurance( java.math.BigDecimal value ) {
		this.__personal_unemployment_insurance = value;
	}

	public java.math.BigDecimal getPersonalLargeMedicalInsurance() {
		return this.__personal_large_medical_insurance;
	}

	public void setPersonalLargeMedicalInsurance( java.math.BigDecimal value ) {
		this.__personal_large_medical_insurance = value;
	}

	public java.math.BigDecimal getPersonalHeating() {
		return this.__personal_heating;
	}

	public void setPersonalHeating( java.math.BigDecimal value ) {
		this.__personal_heating = value;
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

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public void cloneCopy(BaseOnLoadSalaryPaymentByCompany __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setShouldSalary(getShouldSalary());
		__bean.setLeaveAdvance(getLeaveAdvance());
		__bean.setShouldBonus(getShouldBonus());
		__bean.setShouldTotal(getShouldTotal());
		__bean.setShouldTax(getShouldTax());
		__bean.setTotalInsurance(getTotalInsurance());
		__bean.setPersonalPension(getPersonalPension());
		__bean.setPersonalMedicalInsurance(getPersonalMedicalInsurance());
		__bean.setPersonalUnemploymentInsurance(getPersonalUnemploymentInsurance());
		__bean.setPersonalLargeMedicalInsurance(getPersonalLargeMedicalInsurance());
		__bean.setPersonalHeating(getPersonalHeating());
		__bean.setTotalFund(getTotalFund());
		__bean.setInsteadDeduct(getInsteadDeduct());
		__bean.setInsteadDeductIll(getInsteadDeductIll());
		__bean.setFactSalary(getFactSalary());
		__bean.setNum(getNum());
		__bean.setType(getType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyId() == null ? "" : getCompanyId());
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
		sb.append(getPersonalPension() == null ? "" : getPersonalPension());
		sb.append(",");
		sb.append(getPersonalMedicalInsurance() == null ? "" : getPersonalMedicalInsurance());
		sb.append(",");
		sb.append(getPersonalUnemploymentInsurance() == null ? "" : getPersonalUnemploymentInsurance());
		sb.append(",");
		sb.append(getPersonalLargeMedicalInsurance() == null ? "" : getPersonalLargeMedicalInsurance());
		sb.append(",");
		sb.append(getPersonalHeating() == null ? "" : getPersonalHeating());
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
		String strType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_124", String.valueOf(getType()));
		sb.append(strType == null ? "" : strType);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadSalaryPaymentByCompany o) {
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
		hash = 97 * hash + Objects.hashCode(this.__personal_pension);
		hash = 97 * hash + Objects.hashCode(this.__personal_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_unemployment_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_large_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_heating);
		hash = 97 * hash + Objects.hashCode(this.__total_fund);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct_ill);
		hash = 97 * hash + Objects.hashCode(this.__fact_salary);
		hash = 97 * hash + Objects.hashCode(this.__num);
		hash = 97 * hash + Objects.hashCode(this.__type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadSalaryPaymentByCompany o = (BaseOnLoadSalaryPaymentByCompany)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__should_salary, o.getShouldSalary())) return false;
		if(!Objects.equals(this.__leave_advance, o.getLeaveAdvance())) return false;
		if(!Objects.equals(this.__should_bonus, o.getShouldBonus())) return false;
		if(!Objects.equals(this.__should_total, o.getShouldTotal())) return false;
		if(!Objects.equals(this.__should_tax, o.getShouldTax())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
		if(!Objects.equals(this.__personal_pension, o.getPersonalPension())) return false;
		if(!Objects.equals(this.__personal_medical_insurance, o.getPersonalMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_unemployment_insurance, o.getPersonalUnemploymentInsurance())) return false;
		if(!Objects.equals(this.__personal_large_medical_insurance, o.getPersonalLargeMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_heating, o.getPersonalHeating())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__instead_deduct, o.getInsteadDeduct())) return false;
		if(!Objects.equals(this.__instead_deduct_ill, o.getInsteadDeductIll())) return false;
		if(!Objects.equals(this.__fact_salary, o.getFactSalary())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
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
		if(getPersonalPension() != null) sb.append(__wrapDecimal(count++, "personalPension", getPersonalPension()));
		if(getPersonalMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalMedicalInsurance", getPersonalMedicalInsurance()));
		if(getPersonalUnemploymentInsurance() != null) sb.append(__wrapDecimal(count++, "personalUnemploymentInsurance", getPersonalUnemploymentInsurance()));
		if(getPersonalLargeMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalLargeMedicalInsurance", getPersonalLargeMedicalInsurance()));
		if(getPersonalHeating() != null) sb.append(__wrapDecimal(count++, "personalHeating", getPersonalHeating()));
		if(getTotalFund() != null) sb.append(__wrapDecimal(count++, "totalFund", getTotalFund()));
		if(getInsteadDeduct() != null) sb.append(__wrapDecimal(count++, "insteadDeduct", getInsteadDeduct()));
		if(getInsteadDeductIll() != null) sb.append(__wrapDecimal(count++, "insteadDeductIll", getInsteadDeductIll()));
		if(getFactSalary() != null) sb.append(__wrapDecimal(count++, "factSalary", getFactSalary()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
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
		if((val = values.get("personalPension")) != null) setPersonalPension(__getDecimal(val));  
		if((val = values.get("personalMedicalInsurance")) != null) setPersonalMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalUnemploymentInsurance")) != null) setPersonalUnemploymentInsurance(__getDecimal(val));  
		if((val = values.get("personalLargeMedicalInsurance")) != null) setPersonalLargeMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalHeating")) != null) setPersonalHeating(__getDecimal(val));  
		if((val = values.get("totalFund")) != null) setTotalFund(__getDecimal(val));  
		if((val = values.get("insteadDeduct")) != null) setInsteadDeduct(__getDecimal(val));  
		if((val = values.get("insteadDeductIll")) != null) setInsteadDeductIll(__getDecimal(val));  
		if((val = values.get("factSalary")) != null) setFactSalary(__getDecimal(val));  
		if((val = values.get("num")) != null) setNum(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
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
	protected java.math.BigDecimal  __personal_pension ;
	protected java.math.BigDecimal  __personal_medical_insurance ;
	protected java.math.BigDecimal  __personal_unemployment_insurance ;
	protected java.math.BigDecimal  __personal_large_medical_insurance ;
	protected java.math.BigDecimal  __personal_heating ;
	protected java.math.BigDecimal  __total_fund ;
	protected java.math.BigDecimal  __instead_deduct ;
	protected java.math.BigDecimal  __instead_deduct_ill ;
	protected java.math.BigDecimal  __fact_salary ;
	protected java.lang.Integer  __num ;
	protected java.lang.Integer  __type ;
}
