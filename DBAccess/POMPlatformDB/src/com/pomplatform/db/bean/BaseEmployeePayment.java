package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeePayment extends GenericBase implements BaseFactory<BaseEmployeePayment>, Comparable<BaseEmployeePayment> 
{


	public static BaseEmployeePayment newInstance(){
		return new BaseEmployeePayment();
	}

	@Override
	public BaseEmployeePayment make(){
		BaseEmployeePayment b = new BaseEmployeePayment();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_PAYMENT_ID = "employee_payment_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PAYMENT_CHANGE_TYPE = "payment_change_type" ;
	public final static java.lang.String CS_CHANGE_DATE = "change_date" ;
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

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员编码,调薪类型(1入职，2转正，3调薪，4调岗),调薪日期,月薪,基本比例（显示用）,基本比例（计算用）,月基本工资,月绩效工资,工龄工资,其他补贴,全薪,年度绩效,费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员),是否可用";

	public java.lang.Integer getEmployeePaymentId() {
		return this.__employee_payment_id;
	}

	public void setEmployeePaymentId( java.lang.Integer value ) {
		this.__employee_payment_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPaymentChangeType() {
		return this.__payment_change_type;
	}

	public void setPaymentChangeType( java.lang.Integer value ) {
		this.__payment_change_type = value;
	}

	public java.util.Date getChangeDate() {
		return this.__change_date;
	}

	public void setChangeDate( java.util.Date value ) {
		this.__change_date = value;
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

	public void cloneCopy(BaseEmployeePayment __bean){
		__bean.setEmployeePaymentId(getEmployeePaymentId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPaymentChangeType(getPaymentChangeType());
		__bean.setChangeDate(getChangeDate());
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
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeePaymentId() == null ? "" : getEmployeePaymentId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strPaymentChangeType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_95", String.valueOf(getPaymentChangeType()));
		sb.append(strPaymentChangeType == null ? "" : strPaymentChangeType);
		sb.append(",");
		sb.append(getChangeDate() == null ? "" : sdf.format(getChangeDate()));
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeePayment o) {
		return __employee_payment_id == null ? -1 : __employee_payment_id.compareTo(o.getEmployeePaymentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_payment_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__payment_change_type);
		hash = 97 * hash + Objects.hashCode(this.__change_date);
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeePayment o = (BaseEmployeePayment)obj;
		if(!Objects.equals(this.__employee_payment_id, o.getEmployeePaymentId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__payment_change_type, o.getPaymentChangeType())) return false;
		if(!Objects.equals(this.__change_date, o.getChangeDate())) return false;
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
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeePaymentId() != null) sb.append(__wrapNumber(count++, "employeePaymentId", getEmployeePaymentId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPaymentChangeType() != null) sb.append(__wrapNumber(count++, "paymentChangeType", getPaymentChangeType()));
		if(getChangeDate() != null) sb.append(__wrapDate(count++, "changeDate", getChangeDate()));
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
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeePaymentId")) != null) setEmployeePaymentId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("paymentChangeType")) != null) setPaymentChangeType(__getInt(val)); 
		if((val = values.get("changeDate")) != null) setChangeDate(__getDate(val)); 
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
	}

	protected java.lang.Integer  __employee_payment_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __payment_change_type ;
	protected java.util.Date  __change_date ;
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
}
