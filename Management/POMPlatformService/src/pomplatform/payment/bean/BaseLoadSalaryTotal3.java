package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseLoadSalaryTotal3 extends GenericBase implements BaseFactory<BaseLoadSalaryTotal3>, Comparable<BaseLoadSalaryTotal3> 
{


	public static BaseLoadSalaryTotal3 newInstance(){
		return new BaseLoadSalaryTotal3();
	}

	@Override
	public BaseLoadSalaryTotal3 make(){
		BaseLoadSalaryTotal3 b = new BaseLoadSalaryTotal3();
		return b;
	}

	public final static java.lang.String CS_SALARY_TOTAL_ID = "salary_total_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SPECIAL_ADDITIONAL_DUDUCT = "special_additional_duduct" ;
	public final static java.lang.String CS_TAX_BEGIN = "tax_begin" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE = "should_tax_achieve" ;
	public final static java.lang.String CS_SHOULD_TOTAL = "should_total" ;
	public final static java.lang.String CS_ALREADY_BONUS = "already_bonus" ;
	public final static java.lang.String CS_OTHER_BONUS = "other_bonus" ;
	public final static java.lang.String CS_LEAVE_DEDUCT_TAX = "leave_deduct_tax" ;
	public final static java.lang.String CS_TOTAL_INSURANCE = "total_insurance" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT_ILL = "instead_deduct_ill" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE_SUM = "should_tax_achieve_sum" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,专项附加扣除,个税起征点,应纳税所得,应发合计,已发奖金,其他奖金,离职补偿扣税,社保,公积金,代扣重疾,should_tax_achieve_sum";

	public java.lang.Integer getSalaryTotalId() {
		return this.__salary_total_id;
	}

	public void setSalaryTotalId( java.lang.Integer value ) {
		this.__salary_total_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getSpecialAdditionalDuduct() {
		return this.__special_additional_duduct;
	}

	public void setSpecialAdditionalDuduct( java.math.BigDecimal value ) {
		this.__special_additional_duduct = value;
	}

	public java.math.BigDecimal getTaxBegin() {
		return this.__tax_begin;
	}

	public void setTaxBegin( java.math.BigDecimal value ) {
		this.__tax_begin = value;
	}

	public java.lang.String getShouldTaxAchieve() {
		return this.__should_tax_achieve;
	}

	public void setShouldTaxAchieve( java.lang.String value ) {
		this.__should_tax_achieve = value;
	}

	public java.lang.String getShouldTotal() {
		return this.__should_total;
	}

	public void setShouldTotal( java.lang.String value ) {
		this.__should_total = value;
	}

	public java.lang.String getAlreadyBonus() {
		return this.__already_bonus;
	}

	public void setAlreadyBonus( java.lang.String value ) {
		this.__already_bonus = value;
	}

	public java.lang.String getOtherBonus() {
		return this.__other_bonus;
	}

	public void setOtherBonus( java.lang.String value ) {
		this.__other_bonus = value;
	}

	public java.lang.String getLeaveDeductTax() {
		return this.__leave_deduct_tax;
	}

	public void setLeaveDeductTax( java.lang.String value ) {
		this.__leave_deduct_tax = value;
	}

	public java.lang.String getTotalInsurance() {
		return this.__total_insurance;
	}

	public void setTotalInsurance( java.lang.String value ) {
		this.__total_insurance = value;
	}

	public java.lang.String getTotalFund() {
		return this.__total_fund;
	}

	public void setTotalFund( java.lang.String value ) {
		this.__total_fund = value;
	}

	public java.lang.String getInsteadDeductIll() {
		return this.__instead_deduct_ill;
	}

	public void setInsteadDeductIll( java.lang.String value ) {
		this.__instead_deduct_ill = value;
	}

	public java.lang.String getShouldTaxAchieveSum() {
		return this.__should_tax_achieve_sum;
	}

	public void setShouldTaxAchieveSum( java.lang.String value ) {
		this.__should_tax_achieve_sum = value;
	}

	public void cloneCopy(BaseLoadSalaryTotal3 __bean){
		__bean.setSalaryTotalId(getSalaryTotalId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSpecialAdditionalDuduct(getSpecialAdditionalDuduct());
		__bean.setTaxBegin(getTaxBegin());
		__bean.setShouldTaxAchieve(getShouldTaxAchieve());
		__bean.setShouldTotal(getShouldTotal());
		__bean.setAlreadyBonus(getAlreadyBonus());
		__bean.setOtherBonus(getOtherBonus());
		__bean.setLeaveDeductTax(getLeaveDeductTax());
		__bean.setTotalInsurance(getTotalInsurance());
		__bean.setTotalFund(getTotalFund());
		__bean.setInsteadDeductIll(getInsteadDeductIll());
		__bean.setShouldTaxAchieveSum(getShouldTaxAchieveSum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryTotalId() == null ? "" : getSalaryTotalId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getSpecialAdditionalDuduct() == null ? "" : getSpecialAdditionalDuduct());
		sb.append(",");
		sb.append(getTaxBegin() == null ? "" : getTaxBegin());
		sb.append(",");
		sb.append(getShouldTaxAchieve() == null ? "" : getShouldTaxAchieve());
		sb.append(",");
		sb.append(getShouldTotal() == null ? "" : getShouldTotal());
		sb.append(",");
		sb.append(getAlreadyBonus() == null ? "" : getAlreadyBonus());
		sb.append(",");
		sb.append(getOtherBonus() == null ? "" : getOtherBonus());
		sb.append(",");
		sb.append(getLeaveDeductTax() == null ? "" : getLeaveDeductTax());
		sb.append(",");
		sb.append(getTotalInsurance() == null ? "" : getTotalInsurance());
		sb.append(",");
		sb.append(getTotalFund() == null ? "" : getTotalFund());
		sb.append(",");
		sb.append(getInsteadDeductIll() == null ? "" : getInsteadDeductIll());
		sb.append(",");
		sb.append(getShouldTaxAchieveSum() == null ? "" : getShouldTaxAchieveSum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseLoadSalaryTotal3 o) {
		return __salary_total_id == null ? -1 : __salary_total_id.compareTo(o.getSalaryTotalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_total_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__special_additional_duduct);
		hash = 97 * hash + Objects.hashCode(this.__tax_begin);
		hash = 97 * hash + Objects.hashCode(this.__should_tax_achieve);
		hash = 97 * hash + Objects.hashCode(this.__should_total);
		hash = 97 * hash + Objects.hashCode(this.__already_bonus);
		hash = 97 * hash + Objects.hashCode(this.__other_bonus);
		hash = 97 * hash + Objects.hashCode(this.__leave_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__total_fund);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct_ill);
		hash = 97 * hash + Objects.hashCode(this.__should_tax_achieve_sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseLoadSalaryTotal3 o = (BaseLoadSalaryTotal3)obj;
		if(!Objects.equals(this.__salary_total_id, o.getSalaryTotalId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__special_additional_duduct, o.getSpecialAdditionalDuduct())) return false;
		if(!Objects.equals(this.__tax_begin, o.getTaxBegin())) return false;
		if(!Objects.equals(this.__should_tax_achieve, o.getShouldTaxAchieve())) return false;
		if(!Objects.equals(this.__should_total, o.getShouldTotal())) return false;
		if(!Objects.equals(this.__already_bonus, o.getAlreadyBonus())) return false;
		if(!Objects.equals(this.__other_bonus, o.getOtherBonus())) return false;
		if(!Objects.equals(this.__leave_deduct_tax, o.getLeaveDeductTax())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__instead_deduct_ill, o.getInsteadDeductIll())) return false;
		if(!Objects.equals(this.__should_tax_achieve_sum, o.getShouldTaxAchieveSum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryTotalId() != null) sb.append(__wrapNumber(count++, "salaryTotalId", getSalaryTotalId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSpecialAdditionalDuduct() != null) sb.append(__wrapDecimal(count++, "specialAdditionalDuduct", getSpecialAdditionalDuduct()));
		if(getTaxBegin() != null) sb.append(__wrapDecimal(count++, "taxBegin", getTaxBegin()));
		if(getShouldTaxAchieve() != null) sb.append(__wrapString(count++, "shouldTaxAchieve", getShouldTaxAchieve()));
		if(getShouldTotal() != null) sb.append(__wrapString(count++, "shouldTotal", getShouldTotal()));
		if(getAlreadyBonus() != null) sb.append(__wrapString(count++, "alreadyBonus", getAlreadyBonus()));
		if(getOtherBonus() != null) sb.append(__wrapString(count++, "otherBonus", getOtherBonus()));
		if(getLeaveDeductTax() != null) sb.append(__wrapString(count++, "leaveDeductTax", getLeaveDeductTax()));
		if(getTotalInsurance() != null) sb.append(__wrapString(count++, "totalInsurance", getTotalInsurance()));
		if(getTotalFund() != null) sb.append(__wrapString(count++, "totalFund", getTotalFund()));
		if(getInsteadDeductIll() != null) sb.append(__wrapString(count++, "insteadDeductIll", getInsteadDeductIll()));
		if(getShouldTaxAchieveSum() != null) sb.append(__wrapString(count++, "shouldTaxAchieveSum", getShouldTaxAchieveSum()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSalaryTotalId() != null) res.put("salaryTotalId", getSalaryTotalId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getSpecialAdditionalDuduct() != null) res.put("specialAdditionalDuduct", getSpecialAdditionalDuduct());
		if(getTaxBegin() != null) res.put("taxBegin", getTaxBegin());
		if(getShouldTaxAchieve() != null) res.put("shouldTaxAchieve", getShouldTaxAchieve());
		if(getShouldTotal() != null) res.put("shouldTotal", getShouldTotal());
		if(getAlreadyBonus() != null) res.put("alreadyBonus", getAlreadyBonus());
		if(getOtherBonus() != null) res.put("otherBonus", getOtherBonus());
		if(getLeaveDeductTax() != null) res.put("leaveDeductTax", getLeaveDeductTax());
		if(getTotalInsurance() != null) res.put("totalInsurance", getTotalInsurance());
		if(getTotalFund() != null) res.put("totalFund", getTotalFund());
		if(getInsteadDeductIll() != null) res.put("insteadDeductIll", getInsteadDeductIll());
		if(getShouldTaxAchieveSum() != null) res.put("shouldTaxAchieveSum", getShouldTaxAchieveSum());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryTotalId")) != null) setSalaryTotalId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("specialAdditionalDuduct")) != null) setSpecialAdditionalDuduct(__getDecimal(val));  
		if((val = values.get("taxBegin")) != null) setTaxBegin(__getDecimal(val));  
		if((val = values.get("shouldTaxAchieve")) != null) setShouldTaxAchieve(__getString(val));
		if((val = values.get("shouldTotal")) != null) setShouldTotal(__getString(val));
		if((val = values.get("alreadyBonus")) != null) setAlreadyBonus(__getString(val));
		if((val = values.get("otherBonus")) != null) setOtherBonus(__getString(val));
		if((val = values.get("leaveDeductTax")) != null) setLeaveDeductTax(__getString(val));
		if((val = values.get("totalInsurance")) != null) setTotalInsurance(__getString(val));
		if((val = values.get("totalFund")) != null) setTotalFund(__getString(val));
		if((val = values.get("insteadDeductIll")) != null) setInsteadDeductIll(__getString(val));
		if((val = values.get("shouldTaxAchieveSum")) != null) setShouldTaxAchieveSum(__getString(val));
	}

	protected java.lang.Integer  __salary_total_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __special_additional_duduct ;
	protected java.math.BigDecimal  __tax_begin ;
	protected java.lang.String  __should_tax_achieve ;
	protected java.lang.String  __should_total ;
	protected java.lang.String  __already_bonus ;
	protected java.lang.String  __other_bonus ;
	protected java.lang.String  __leave_deduct_tax ;
	protected java.lang.String  __total_insurance ;
	protected java.lang.String  __total_fund ;
	protected java.lang.String  __instead_deduct_ill ;
	protected java.lang.String  __should_tax_achieve_sum ;
}
