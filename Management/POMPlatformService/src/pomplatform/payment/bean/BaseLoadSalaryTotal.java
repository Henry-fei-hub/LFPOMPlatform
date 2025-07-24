package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseLoadSalaryTotal extends GenericBase implements BaseFactory<BaseLoadSalaryTotal>, Comparable<BaseLoadSalaryTotal> 
{


	public static BaseLoadSalaryTotal newInstance(){
		return new BaseLoadSalaryTotal();
	}

	@Override
	public BaseLoadSalaryTotal make(){
		BaseLoadSalaryTotal b = new BaseLoadSalaryTotal();
		return b;
	}

	public final static java.lang.String CS_SALARY_TOTAL_ID = "salary_total_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SPECIAL_ADDITIONAL_DUDUCT = "special_additional_duduct" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE = "should_tax_achieve" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_TOTAL_INSURANCE = "total_insurance" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE_SUM = "should_tax_achieve_sum" ;
	public final static java.lang.String CS_INDIVIDUAL_INCOME_TAX_SUM = "individual_income_tax_sum" ;
	public final static java.lang.String CS_INSURANCE_FUND_SUM = "insurance_fund_sum" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_SUM = "special_duduct_sum" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,专项附加扣除,应纳税所得,公积金,社保,累计应纳税所得,累计个税起征点,累计社保公积金,累计专项附加扣除之和";

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

	public java.lang.String getShouldTaxAchieve() {
		return this.__should_tax_achieve;
	}

	public void setShouldTaxAchieve( java.lang.String value ) {
		this.__should_tax_achieve = value;
	}

	public java.lang.String getTotalFund() {
		return this.__total_fund;
	}

	public void setTotalFund( java.lang.String value ) {
		this.__total_fund = value;
	}

	public java.lang.String getTotalInsurance() {
		return this.__total_insurance;
	}

	public void setTotalInsurance( java.lang.String value ) {
		this.__total_insurance = value;
	}

	public java.lang.String getShouldTaxAchieveSum() {
		return this.__should_tax_achieve_sum;
	}

	public void setShouldTaxAchieveSum( java.lang.String value ) {
		this.__should_tax_achieve_sum = value;
	}

	public java.lang.String getIndividualIncomeTaxSum() {
		return this.__individual_income_tax_sum;
	}

	public void setIndividualIncomeTaxSum( java.lang.String value ) {
		this.__individual_income_tax_sum = value;
	}

	public java.lang.String getInsuranceFundSum() {
		return this.__insurance_fund_sum;
	}

	public void setInsuranceFundSum( java.lang.String value ) {
		this.__insurance_fund_sum = value;
	}

	public java.math.BigDecimal getSpecialDuductSum() {
		return this.__special_duduct_sum;
	}

	public void setSpecialDuductSum( java.math.BigDecimal value ) {
		this.__special_duduct_sum = value;
	}

	public void cloneCopy(BaseLoadSalaryTotal __bean){
		__bean.setSalaryTotalId(getSalaryTotalId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSpecialAdditionalDuduct(getSpecialAdditionalDuduct());
		__bean.setShouldTaxAchieve(getShouldTaxAchieve());
		__bean.setTotalFund(getTotalFund());
		__bean.setTotalInsurance(getTotalInsurance());
		__bean.setShouldTaxAchieveSum(getShouldTaxAchieveSum());
		__bean.setIndividualIncomeTaxSum(getIndividualIncomeTaxSum());
		__bean.setInsuranceFundSum(getInsuranceFundSum());
		__bean.setSpecialDuductSum(getSpecialDuductSum());
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
		sb.append(getShouldTaxAchieve() == null ? "" : getShouldTaxAchieve());
		sb.append(",");
		sb.append(getTotalFund() == null ? "" : getTotalFund());
		sb.append(",");
		sb.append(getTotalInsurance() == null ? "" : getTotalInsurance());
		sb.append(",");
		sb.append(getShouldTaxAchieveSum() == null ? "" : getShouldTaxAchieveSum());
		sb.append(",");
		sb.append(getIndividualIncomeTaxSum() == null ? "" : getIndividualIncomeTaxSum());
		sb.append(",");
		sb.append(getInsuranceFundSum() == null ? "" : getInsuranceFundSum());
		sb.append(",");
		sb.append(getSpecialDuductSum() == null ? "" : getSpecialDuductSum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseLoadSalaryTotal o) {
		return __salary_total_id == null ? -1 : __salary_total_id.compareTo(o.getSalaryTotalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_total_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__special_additional_duduct);
		hash = 97 * hash + Objects.hashCode(this.__should_tax_achieve);
		hash = 97 * hash + Objects.hashCode(this.__total_fund);
		hash = 97 * hash + Objects.hashCode(this.__total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__should_tax_achieve_sum);
		hash = 97 * hash + Objects.hashCode(this.__individual_income_tax_sum);
		hash = 97 * hash + Objects.hashCode(this.__insurance_fund_sum);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseLoadSalaryTotal o = (BaseLoadSalaryTotal)obj;
		if(!Objects.equals(this.__salary_total_id, o.getSalaryTotalId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__special_additional_duduct, o.getSpecialAdditionalDuduct())) return false;
		if(!Objects.equals(this.__should_tax_achieve, o.getShouldTaxAchieve())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
		if(!Objects.equals(this.__should_tax_achieve_sum, o.getShouldTaxAchieveSum())) return false;
		if(!Objects.equals(this.__individual_income_tax_sum, o.getIndividualIncomeTaxSum())) return false;
		if(!Objects.equals(this.__insurance_fund_sum, o.getInsuranceFundSum())) return false;
		if(!Objects.equals(this.__special_duduct_sum, o.getSpecialDuductSum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryTotalId() != null) sb.append(__wrapNumber(count++, "salaryTotalId", getSalaryTotalId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSpecialAdditionalDuduct() != null) sb.append(__wrapDecimal(count++, "specialAdditionalDuduct", getSpecialAdditionalDuduct()));
		if(getShouldTaxAchieve() != null) sb.append(__wrapString(count++, "shouldTaxAchieve", getShouldTaxAchieve()));
		if(getTotalFund() != null) sb.append(__wrapString(count++, "totalFund", getTotalFund()));
		if(getTotalInsurance() != null) sb.append(__wrapString(count++, "totalInsurance", getTotalInsurance()));
		if(getShouldTaxAchieveSum() != null) sb.append(__wrapString(count++, "shouldTaxAchieveSum", getShouldTaxAchieveSum()));
		if(getIndividualIncomeTaxSum() != null) sb.append(__wrapString(count++, "individualIncomeTaxSum", getIndividualIncomeTaxSum()));
		if(getInsuranceFundSum() != null) sb.append(__wrapString(count++, "insuranceFundSum", getInsuranceFundSum()));
		if(getSpecialDuductSum() != null) sb.append(__wrapDecimal(count++, "specialDuductSum", getSpecialDuductSum()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSalaryTotalId() != null) res.put("salaryTotalId", getSalaryTotalId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getSpecialAdditionalDuduct() != null) res.put("specialAdditionalDuduct", getSpecialAdditionalDuduct());
		if(getShouldTaxAchieve() != null) res.put("shouldTaxAchieve", getShouldTaxAchieve());
		if(getTotalFund() != null) res.put("totalFund", getTotalFund());
		if(getTotalInsurance() != null) res.put("totalInsurance", getTotalInsurance());
		if(getShouldTaxAchieveSum() != null) res.put("shouldTaxAchieveSum", getShouldTaxAchieveSum());
		if(getIndividualIncomeTaxSum() != null) res.put("individualIncomeTaxSum", getIndividualIncomeTaxSum());
		if(getInsuranceFundSum() != null) res.put("insuranceFundSum", getInsuranceFundSum());
		if(getSpecialDuductSum() != null) res.put("specialDuductSum", getSpecialDuductSum());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryTotalId")) != null) setSalaryTotalId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("specialAdditionalDuduct")) != null) setSpecialAdditionalDuduct(__getDecimal(val));  
		if((val = values.get("shouldTaxAchieve")) != null) setShouldTaxAchieve(__getString(val));
		if((val = values.get("totalFund")) != null) setTotalFund(__getString(val));
		if((val = values.get("totalInsurance")) != null) setTotalInsurance(__getString(val));
		if((val = values.get("shouldTaxAchieveSum")) != null) setShouldTaxAchieveSum(__getString(val));
		if((val = values.get("individualIncomeTaxSum")) != null) setIndividualIncomeTaxSum(__getString(val));
		if((val = values.get("insuranceFundSum")) != null) setInsuranceFundSum(__getString(val));
		if((val = values.get("specialDuductSum")) != null) setSpecialDuductSum(__getDecimal(val));  
	}

	protected java.lang.Integer  __salary_total_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __special_additional_duduct ;
	protected java.lang.String  __should_tax_achieve ;
	protected java.lang.String  __total_fund ;
	protected java.lang.String  __total_insurance ;
	protected java.lang.String  __should_tax_achieve_sum ;
	protected java.lang.String  __individual_income_tax_sum ;
	protected java.lang.String  __insurance_fund_sum ;
	protected java.math.BigDecimal  __special_duduct_sum ;
}
