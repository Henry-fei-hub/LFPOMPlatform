package pomplatform.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRegularEmployeeInfo extends GenericBase implements BaseFactory<BaseRegularEmployeeInfo>, Comparable<BaseRegularEmployeeInfo> 
{


	public static BaseRegularEmployeeInfo newInstance(){
		return new BaseRegularEmployeeInfo();
	}

	@Override
	public BaseRegularEmployeeInfo make(){
		BaseRegularEmployeeInfo b = new BaseRegularEmployeeInfo();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_SALARY_2 = "salary_2" ;

	public final static java.lang.String ALL_CAPTIONS = "申请人,截止日期,薪资2";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.String getOriginalPay() {
		return __original_pay;
	}

	public void setOriginalPay(java.lang.String __original_pay) {
		this.__original_pay = __original_pay;
	}

	public java.lang.String getMonthPay() {
		return __month_pay;
	}

	public void setMonthPay(java.lang.String __month_pay) {
		this.__month_pay = __month_pay;
	}

	public java.lang.String getBasicProportionStr() {
		return __basic_proportion_str;
	}

	public void setBasicProportionStr(java.lang.String __basic_proportion_str) {
		this.__basic_proportion_str = __basic_proportion_str;
	}

	public java.math.BigDecimal getBasicProportion() {
		return __basic_proportion;
	}

	public void setBasicProportion(java.math.BigDecimal __basic_proportion) {
		this.__basic_proportion = __basic_proportion;
	}

	public java.lang.String getMonthBasicPay() {
		return __month_basic_pay;
	}

	public void setMonthBasicPay(java.lang.String __month_basic_pay) {
		this.__month_basic_pay = __month_basic_pay;
	}

	public java.lang.String getMonthPerformancePay() {
		return __month_performance_pay;
	}

	public void setMonthPerformancePay(java.lang.String __month_performance_pay) {
		this.__month_performance_pay = __month_performance_pay;
	}

	public java.lang.String getForemanPay() {
		return __foreman_pay;
	}

	public void setForemanPay(java.lang.String __foreman_pay) {
		this.__foreman_pay = __foreman_pay;
	}

	public java.lang.String getOtherSubsidy() {
		return __other_subsidy;
	}

	public void setOtherSubsidy(java.lang.String __other_subsidy) {
		this.__other_subsidy = __other_subsidy;
	}

	public java.lang.String getTotalPay() {
		return __total_pay;
	}

	public void setTotalPay(java.lang.String __total_pay) {
		this.__total_pay = __total_pay;
	}

	public java.lang.String getAnnualPerformance() {
		return __annual_performance;
	}

	public void setAnnualPerformance(java.lang.String __annual_performance) {
		this.__annual_performance = __annual_performance;
	}

	public java.lang.Integer getCostAttribution() {
		return __cost_attribution;
	}

	public void setCostAttribution(java.lang.Integer __cost_attribution) {
		this.__cost_attribution = __cost_attribution;
	}

	public void cloneCopy(BaseRegularEmployeeInfo __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEndDate(getEndDate());
		__bean.setOriginalPay(getOriginalPay());
		__bean.setMonthPay(getMonthPay());
		__bean.setBasicProportionStr(getBasicProportionStr());
		__bean.setBasicProportion(getBasicProportion());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setMonthPerformancePay(getMonthPerformancePay());
		__bean.setForemanPay(getForemanPay());
		__bean.setOtherSubsidy(getOtherSubsidy());
		__bean.setTotalPay(getTotalPay());
		__bean.setAnnualPerformance(getAnnualPerformance());
		__bean.setCostAttribution(getCostAttribution());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRegularEmployeeInfo o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__original_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__foreman_pay);
		hash = 97 * hash + Objects.hashCode(this.__other_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__total_pay);
		hash = 97 * hash + Objects.hashCode(this.__annual_performance);
		hash = 97 * hash + Objects.hashCode(this.__cost_attribution);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRegularEmployeeInfo o = (BaseRegularEmployeeInfo)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__original_pay, o.getOriginalPay())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__basic_proportion_str, o.getBasicProportionStr())) return false;
		if(!Objects.equals(this.__basic_proportion, o.getBasicProportion())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__month_performance_pay, o.getMonthPerformancePay())) return false;
		if(!Objects.equals(this.__foreman_pay, o.getForemanPay())) return false;
		if(!Objects.equals(this.__other_subsidy, o.getOtherSubsidy())) return false;
		if(!Objects.equals(this.__total_pay, o.getTotalPay())) return false;
		if(!Objects.equals(this.__annual_performance, o.getAnnualPerformance())) return false;
		if(!Objects.equals(this.__cost_attribution, o.getCostAttribution())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getOriginalPay() != null) sb.append(__wrapString(count++, "originalPay", getOriginalPay()));
		if(getMonthPay() != null) sb.append(__wrapString(count++, "monthPay", getMonthPay()));
		if(getBasicProportionStr() != null) sb.append(__wrapString(count++, "basicProportionStr", getBasicProportionStr()));
		if(getBasicProportion() != null) sb.append(__wrapDecimal(count++, "basicProportion", getBasicProportion()));
		if(getMonthBasicPay() != null) sb.append(__wrapString(count++, "monthBasicPay", getMonthBasicPay()));
		if(getMonthPerformancePay() != null) sb.append(__wrapString(count++, "monthPerformancePay", getMonthPerformancePay()));
		if(getForemanPay() != null) sb.append(__wrapString(count++, "foremanPay", getForemanPay()));
		if(getOtherSubsidy() != null) sb.append(__wrapString(count++, "otherSubsidy", getOtherSubsidy()));
		if(getTotalPay() != null) sb.append(__wrapString(count++, "totalPay", getTotalPay()));
		if(getAnnualPerformance() != null) sb.append(__wrapString(count++, "annualPerformance", getAnnualPerformance()));
		if(getCostAttribution() != null) sb.append(__wrapNumber(count++, "costAttribution", getCostAttribution()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("originalPay")) != null) setOriginalPay(__getString(val));
		if((val = values.get("monthPay")) != null) setMonthPay(__getString(val));
		if((val = values.get("basicProportionStr")) != null) setBasicProportionStr(__getString(val));
		if((val = values.get("basicProportion")) != null) setBasicProportion(__getDecimal(val));  
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getString(val));
		if((val = values.get("monthPerformancePay")) != null) setMonthPerformancePay(__getString(val));
		if((val = values.get("foremanPay")) != null) setForemanPay(__getString(val));
		if((val = values.get("otherSubsidy")) != null) setOtherSubsidy(__getString(val));
		if((val = values.get("totalPay")) != null) setTotalPay(__getString(val));
		if((val = values.get("annualPerformance")) != null) setAnnualPerformance(__getString(val));
		if((val = values.get("costAttribution")) != null) setCostAttribution(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __end_date ;
	protected java.lang.String  __original_pay ;
	protected java.lang.String  __month_pay ;
	protected java.lang.String  __basic_proportion_str ;
	protected java.math.BigDecimal  __basic_proportion ;
	protected java.lang.String  __month_basic_pay ;
	protected java.lang.String  __month_performance_pay ;
	protected java.lang.String  __foreman_pay ;
	protected java.lang.String  __other_subsidy ;
	protected java.lang.String  __total_pay ;
	protected java.lang.String  __annual_performance ;
	protected java.lang.Integer  __cost_attribution ;
}
