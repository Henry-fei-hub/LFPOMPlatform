package pomplatform.salarydecrypt.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseDecryptEmployeePaymentMonthDetails extends GenericBase implements BaseFactory<BaseDecryptEmployeePaymentMonthDetails>, Comparable<BaseDecryptEmployeePaymentMonthDetails> 
{


	public static BaseDecryptEmployeePaymentMonthDetails newInstance(){
		return new BaseDecryptEmployeePaymentMonthDetails();
	}

	@Override
	public BaseDecryptEmployeePaymentMonthDetails make(){
		BaseDecryptEmployeePaymentMonthDetails b = new BaseDecryptEmployeePaymentMonthDetails();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_PAYMENT_MONTH_DETAIL_ID = "employee_payment_month_detail_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;
	public final static java.lang.String CS_BASIC_PROPORTION_STR = "basic_proportion_str" ;
	public final static java.lang.String CS_BASIC_PROPORTION = "basic_proportion" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_MONTH_PERFORMANCE_PAY = "month_performance_pay" ;
	public final static java.lang.String CS_FOREMAN_PAY = "foreman_pay" ;
	public final static java.lang.String CS_OTHER_SUBSIDY = "other_subsidy" ;
	public final static java.lang.String CS_TOTAL_PAY = "total_pay" ;
	public final static java.lang.String CS_ANNUAL_PERFORMANCE = "annual_performance" ;
	public final static java.lang.String CS_COST_ATTRIBUTION = "cost_attribution" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;
	public final static java.lang.String CS_MONTH_PAY_DECRYPT = "month_pay_decrypt" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY_DECRYPT = "month_basic_pay_decrypt" ;
	public final static java.lang.String CS_MONTH_PERFORMANCE_PAY_DECRYPT = "month_performance_pay_decrypt" ;
	public final static java.lang.String CS_FOREMAN_PAY_DECRYPT = "foreman_pay_decrypt" ;
	public final static java.lang.String CS_OTHER_SUBSIDY_DECRYPT = "other_subsidy_decrypt" ;
	public final static java.lang.String CS_TOTAL_PAY_DECRYPT = "total_pay_decrypt" ;
	public final static java.lang.String CS_ANNUAL_PERFORMANCE_DECRYPT = "annual_performance_decrypt" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员编码,年份,月份,月薪,基本比例（显示用）,基本比例（计算用）,月基本工资,月绩效工资,工龄工资,其他补贴,全薪,年度绩效,费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员),是否可用,,,,,,,";

	public java.lang.Integer getEmployeePaymentMonthDetailId() {
		return this.__employee_payment_month_detail_id;
	}

	public void setEmployeePaymentMonthDetailId( java.lang.Integer value ) {
		this.__employee_payment_month_detail_id = value;
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

	public java.lang.String getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.lang.String value ) {
		this.__month_pay = value;
	}

	public java.lang.String getBasicProportionStr() {
		return this.__basic_proportion_str;
	}

	public void setBasicProportionStr( java.lang.String value ) {
		this.__basic_proportion_str = value;
	}

	public java.math.BigDecimal getBasicProportion() {
		return this.__basic_proportion;
	}

	public void setBasicProportion( java.math.BigDecimal value ) {
		this.__basic_proportion = value;
	}

	public java.lang.String getMonthBasicPay() {
		return this.__month_basic_pay;
	}

	public void setMonthBasicPay( java.lang.String value ) {
		this.__month_basic_pay = value;
	}

	public java.lang.String getMonthPerformancePay() {
		return this.__month_performance_pay;
	}

	public void setMonthPerformancePay( java.lang.String value ) {
		this.__month_performance_pay = value;
	}

	public java.lang.String getForemanPay() {
		return this.__foreman_pay;
	}

	public void setForemanPay( java.lang.String value ) {
		this.__foreman_pay = value;
	}

	public java.lang.String getOtherSubsidy() {
		return this.__other_subsidy;
	}

	public void setOtherSubsidy( java.lang.String value ) {
		this.__other_subsidy = value;
	}

	public java.lang.String getTotalPay() {
		return this.__total_pay;
	}

	public void setTotalPay( java.lang.String value ) {
		this.__total_pay = value;
	}

	public java.lang.String getAnnualPerformance() {
		return this.__annual_performance;
	}

	public void setAnnualPerformance( java.lang.String value ) {
		this.__annual_performance = value;
	}

	public java.lang.Integer getCostAttribution() {
		return this.__cost_attribution;
	}

	public void setCostAttribution( java.lang.Integer value ) {
		this.__cost_attribution = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public java.math.BigDecimal getMonthPayDecrypt() {
		return this.__month_pay_decrypt;
	}

	public void setMonthPayDecrypt( java.math.BigDecimal value ) {
		this.__month_pay_decrypt = value;
	}

	public java.math.BigDecimal getMonthBasicPayDecrypt() {
		return this.__month_basic_pay_decrypt;
	}

	public void setMonthBasicPayDecrypt( java.math.BigDecimal value ) {
		this.__month_basic_pay_decrypt = value;
	}

	public java.math.BigDecimal getMonthPerformancePayDecrypt() {
		return this.__month_performance_pay_decrypt;
	}

	public void setMonthPerformancePayDecrypt( java.math.BigDecimal value ) {
		this.__month_performance_pay_decrypt = value;
	}

	public java.math.BigDecimal getForemanPayDecrypt() {
		return this.__foreman_pay_decrypt;
	}

	public void setForemanPayDecrypt( java.math.BigDecimal value ) {
		this.__foreman_pay_decrypt = value;
	}

	public java.math.BigDecimal getOtherSubsidyDecrypt() {
		return this.__other_subsidy_decrypt;
	}

	public void setOtherSubsidyDecrypt( java.math.BigDecimal value ) {
		this.__other_subsidy_decrypt = value;
	}

	public java.math.BigDecimal getTotalPayDecrypt() {
		return this.__total_pay_decrypt;
	}

	public void setTotalPayDecrypt( java.math.BigDecimal value ) {
		this.__total_pay_decrypt = value;
	}

	public java.math.BigDecimal getAnnualPerformanceDecrypt() {
		return this.__annual_performance_decrypt;
	}

	public void setAnnualPerformanceDecrypt( java.math.BigDecimal value ) {
		this.__annual_performance_decrypt = value;
	}

	public void cloneCopy(BaseDecryptEmployeePaymentMonthDetails __bean){
		__bean.setEmployeePaymentMonthDetailId(getEmployeePaymentMonthDetailId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
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
		__bean.setEnabled(getEnabled());
		__bean.setMonthPayDecrypt(getMonthPayDecrypt());
		__bean.setMonthBasicPayDecrypt(getMonthBasicPayDecrypt());
		__bean.setMonthPerformancePayDecrypt(getMonthPerformancePayDecrypt());
		__bean.setForemanPayDecrypt(getForemanPayDecrypt());
		__bean.setOtherSubsidyDecrypt(getOtherSubsidyDecrypt());
		__bean.setTotalPayDecrypt(getTotalPayDecrypt());
		__bean.setAnnualPerformanceDecrypt(getAnnualPerformanceDecrypt());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeePaymentMonthDetailId() == null ? "" : getEmployeePaymentMonthDetailId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getMonthPay() == null ? "" : getMonthPay());
		sb.append(",");
		sb.append(getBasicProportionStr() == null ? "" : getBasicProportionStr());
		sb.append(",");
		sb.append(getBasicProportion() == null ? "" : getBasicProportion());
		sb.append(",");
		sb.append(getMonthBasicPay() == null ? "" : getMonthBasicPay());
		sb.append(",");
		sb.append(getMonthPerformancePay() == null ? "" : getMonthPerformancePay());
		sb.append(",");
		sb.append(getForemanPay() == null ? "" : getForemanPay());
		sb.append(",");
		sb.append(getOtherSubsidy() == null ? "" : getOtherSubsidy());
		sb.append(",");
		sb.append(getTotalPay() == null ? "" : getTotalPay());
		sb.append(",");
		sb.append(getAnnualPerformance() == null ? "" : getAnnualPerformance());
		sb.append(",");
		sb.append(getCostAttribution() == null ? "" : getCostAttribution());
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		sb.append(",");
		sb.append(getMonthPayDecrypt() == null ? "" : getMonthPayDecrypt());
		sb.append(",");
		sb.append(getMonthBasicPayDecrypt() == null ? "" : getMonthBasicPayDecrypt());
		sb.append(",");
		sb.append(getMonthPerformancePayDecrypt() == null ? "" : getMonthPerformancePayDecrypt());
		sb.append(",");
		sb.append(getForemanPayDecrypt() == null ? "" : getForemanPayDecrypt());
		sb.append(",");
		sb.append(getOtherSubsidyDecrypt() == null ? "" : getOtherSubsidyDecrypt());
		sb.append(",");
		sb.append(getTotalPayDecrypt() == null ? "" : getTotalPayDecrypt());
		sb.append(",");
		sb.append(getAnnualPerformanceDecrypt() == null ? "" : getAnnualPerformanceDecrypt());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDecryptEmployeePaymentMonthDetails o) {
		return __employee_payment_month_detail_id == null ? -1 : __employee_payment_month_detail_id.compareTo(o.getEmployeePaymentMonthDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_payment_month_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
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
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		hash = 97 * hash + Objects.hashCode(this.__month_pay_decrypt);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay_decrypt);
		hash = 97 * hash + Objects.hashCode(this.__month_performance_pay_decrypt);
		hash = 97 * hash + Objects.hashCode(this.__foreman_pay_decrypt);
		hash = 97 * hash + Objects.hashCode(this.__other_subsidy_decrypt);
		hash = 97 * hash + Objects.hashCode(this.__total_pay_decrypt);
		hash = 97 * hash + Objects.hashCode(this.__annual_performance_decrypt);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDecryptEmployeePaymentMonthDetails o = (BaseDecryptEmployeePaymentMonthDetails)obj;
		if(!Objects.equals(this.__employee_payment_month_detail_id, o.getEmployeePaymentMonthDetailId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
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
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		if(!Objects.equals(this.__month_pay_decrypt, o.getMonthPayDecrypt())) return false;
		if(!Objects.equals(this.__month_basic_pay_decrypt, o.getMonthBasicPayDecrypt())) return false;
		if(!Objects.equals(this.__month_performance_pay_decrypt, o.getMonthPerformancePayDecrypt())) return false;
		if(!Objects.equals(this.__foreman_pay_decrypt, o.getForemanPayDecrypt())) return false;
		if(!Objects.equals(this.__other_subsidy_decrypt, o.getOtherSubsidyDecrypt())) return false;
		if(!Objects.equals(this.__total_pay_decrypt, o.getTotalPayDecrypt())) return false;
		if(!Objects.equals(this.__annual_performance_decrypt, o.getAnnualPerformanceDecrypt())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeePaymentMonthDetailId() != null) sb.append(__wrapNumber(count++, "employeePaymentMonthDetailId", getEmployeePaymentMonthDetailId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
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
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		if(getMonthPayDecrypt() != null) sb.append(__wrapDecimal(count++, "monthPayDecrypt", getMonthPayDecrypt()));
		if(getMonthBasicPayDecrypt() != null) sb.append(__wrapDecimal(count++, "monthBasicPayDecrypt", getMonthBasicPayDecrypt()));
		if(getMonthPerformancePayDecrypt() != null) sb.append(__wrapDecimal(count++, "monthPerformancePayDecrypt", getMonthPerformancePayDecrypt()));
		if(getForemanPayDecrypt() != null) sb.append(__wrapDecimal(count++, "foremanPayDecrypt", getForemanPayDecrypt()));
		if(getOtherSubsidyDecrypt() != null) sb.append(__wrapDecimal(count++, "otherSubsidyDecrypt", getOtherSubsidyDecrypt()));
		if(getTotalPayDecrypt() != null) sb.append(__wrapDecimal(count++, "totalPayDecrypt", getTotalPayDecrypt()));
		if(getAnnualPerformanceDecrypt() != null) sb.append(__wrapDecimal(count++, "annualPerformanceDecrypt", getAnnualPerformanceDecrypt()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeePaymentMonthDetailId")) != null) setEmployeePaymentMonthDetailId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
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
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
		if((val = values.get("monthPayDecrypt")) != null) setMonthPayDecrypt(__getDecimal(val));  
		if((val = values.get("monthBasicPayDecrypt")) != null) setMonthBasicPayDecrypt(__getDecimal(val));  
		if((val = values.get("monthPerformancePayDecrypt")) != null) setMonthPerformancePayDecrypt(__getDecimal(val));  
		if((val = values.get("foremanPayDecrypt")) != null) setForemanPayDecrypt(__getDecimal(val));  
		if((val = values.get("otherSubsidyDecrypt")) != null) setOtherSubsidyDecrypt(__getDecimal(val));  
		if((val = values.get("totalPayDecrypt")) != null) setTotalPayDecrypt(__getDecimal(val));  
		if((val = values.get("annualPerformanceDecrypt")) != null) setAnnualPerformanceDecrypt(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_payment_month_detail_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
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
	protected java.lang.Boolean  __enabled ;
	protected java.math.BigDecimal  __month_pay_decrypt ;
	protected java.math.BigDecimal  __month_basic_pay_decrypt ;
	protected java.math.BigDecimal  __month_performance_pay_decrypt ;
	protected java.math.BigDecimal  __foreman_pay_decrypt ;
	protected java.math.BigDecimal  __other_subsidy_decrypt ;
	protected java.math.BigDecimal  __total_pay_decrypt ;
	protected java.math.BigDecimal  __annual_performance_decrypt ;
}
