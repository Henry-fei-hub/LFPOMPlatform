package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseQueryLoadSalaryTotal2 extends GenericBase implements BaseFactory<BaseQueryLoadSalaryTotal2>, Comparable<BaseQueryLoadSalaryTotal2> 
{


	public static BaseQueryLoadSalaryTotal2 newInstance(){
		return new BaseQueryLoadSalaryTotal2();
	}

	@Override
	public BaseQueryLoadSalaryTotal2 make(){
		BaseQueryLoadSalaryTotal2 b = new BaseQueryLoadSalaryTotal2();
		return b;
	}

	public final static java.lang.String CS_SALARY_TOTAL_ID = "salary_total_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SPECIAL_ADDITIONAL_DUDUCT = "special_additional_duduct" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE = "should_tax_achieve" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_TOTAL_INSURANCE = "total_insurance" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,专项附加扣除,应纳税所得,公积金,社保";

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

	public void cloneCopy(BaseQueryLoadSalaryTotal2 __bean){
		__bean.setSalaryTotalId(getSalaryTotalId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSpecialAdditionalDuduct(getSpecialAdditionalDuduct());
		__bean.setShouldTaxAchieve(getShouldTaxAchieve());
		__bean.setTotalFund(getTotalFund());
		__bean.setTotalInsurance(getTotalInsurance());
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseQueryLoadSalaryTotal2 o) {
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseQueryLoadSalaryTotal2 o = (BaseQueryLoadSalaryTotal2)obj;
		if(!Objects.equals(this.__salary_total_id, o.getSalaryTotalId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__special_additional_duduct, o.getSpecialAdditionalDuduct())) return false;
		if(!Objects.equals(this.__should_tax_achieve, o.getShouldTaxAchieve())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
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
	}

	protected java.lang.Integer  __salary_total_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __special_additional_duduct ;
	protected java.lang.String  __should_tax_achieve ;
	protected java.lang.String  __total_fund ;
	protected java.lang.String  __total_insurance ;
}
