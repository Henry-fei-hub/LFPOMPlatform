package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadShiftAndDayPayment extends GenericBase implements BaseFactory<BaseOnLoadShiftAndDayPayment>, Comparable<BaseOnLoadShiftAndDayPayment> 
{


	public static BaseOnLoadShiftAndDayPayment newInstance(){
		return new BaseOnLoadShiftAndDayPayment();
	}

	@Override
	public BaseOnLoadShiftAndDayPayment make(){
		BaseOnLoadShiftAndDayPayment b = new BaseOnLoadShiftAndDayPayment();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PAYMENT_CHANGE_TYPE = "payment_change_type" ;
	public final static java.lang.String CS_BASIC_PROPORTION = "basic_proportion" ;
	public final static java.lang.String CS_CHANGE_DATE = "change_date" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_MONTH_PERFORMANCE_PAY = "month_performance_pay" ;
	public final static java.lang.String CS_OTHER_SUBSIDY = "other_subsidy" ;
	public final static java.lang.String CS_TOTAL_PAY = "total_pay" ;
	public final static java.lang.String CS_ANNUAL_PERFORMANCE = "annual_performance" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,调薪类型(1入职，2转正，3调薪，4调岗),基本比例（计算用）,调薪日期,月薪,月基本工资,月绩效工资,其他补贴,全薪,年度绩效";

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

	public java.math.BigDecimal getBasicProportion() {
		return this.__basic_proportion;
	}

	public void setBasicProportion( java.math.BigDecimal value ) {
		this.__basic_proportion = value;
	}

	public java.util.Date getChangeDate() {
		return this.__change_date;
	}

	public void setChangeDate( java.util.Date value ) {
		this.__change_date = value;
	}

	public java.math.BigDecimal getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.math.BigDecimal value ) {
		this.__month_pay = value;
	}

	public java.math.BigDecimal getMonthBasicPay() {
		return this.__month_basic_pay;
	}

	public void setMonthBasicPay( java.math.BigDecimal value ) {
		this.__month_basic_pay = value;
	}

	public java.math.BigDecimal getMonthPerformancePay() {
		return this.__month_performance_pay;
	}

	public void setMonthPerformancePay( java.math.BigDecimal value ) {
		this.__month_performance_pay = value;
	}

	public java.math.BigDecimal getOtherSubsidy() {
		return this.__other_subsidy;
	}

	public void setOtherSubsidy( java.math.BigDecimal value ) {
		this.__other_subsidy = value;
	}

	public java.math.BigDecimal getTotalPay() {
		return this.__total_pay;
	}

	public void setTotalPay( java.math.BigDecimal value ) {
		this.__total_pay = value;
	}

	public java.math.BigDecimal getAnnualPerformance() {
		return this.__annual_performance;
	}

	public void setAnnualPerformance( java.math.BigDecimal value ) {
		this.__annual_performance = value;
	}

	public void cloneCopy(BaseOnLoadShiftAndDayPayment __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPaymentChangeType(getPaymentChangeType());
		__bean.setBasicProportion(getBasicProportion());
		__bean.setChangeDate(getChangeDate());
		__bean.setMonthPay(getMonthPay());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setMonthPerformancePay(getMonthPerformancePay());
		__bean.setOtherSubsidy(getOtherSubsidy());
		__bean.setTotalPay(getTotalPay());
		__bean.setAnnualPerformance(getAnnualPerformance());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getPaymentChangeType() == null ? "" : getPaymentChangeType());
		sb.append(",");
		sb.append(getBasicProportion() == null ? "" : getBasicProportion());
		sb.append(",");
		sb.append(getChangeDate() == null ? "" : sdf.format(getChangeDate()));
		sb.append(",");
		sb.append(getMonthPay() == null ? "" : getMonthPay());
		sb.append(",");
		sb.append(getMonthBasicPay() == null ? "" : getMonthBasicPay());
		sb.append(",");
		sb.append(getMonthPerformancePay() == null ? "" : getMonthPerformancePay());
		sb.append(",");
		sb.append(getOtherSubsidy() == null ? "" : getOtherSubsidy());
		sb.append(",");
		sb.append(getTotalPay() == null ? "" : getTotalPay());
		sb.append(",");
		sb.append(getAnnualPerformance() == null ? "" : getAnnualPerformance());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadShiftAndDayPayment o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__payment_change_type);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion);
		hash = 97 * hash + Objects.hashCode(this.__change_date);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__other_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__total_pay);
		hash = 97 * hash + Objects.hashCode(this.__annual_performance);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadShiftAndDayPayment o = (BaseOnLoadShiftAndDayPayment)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__payment_change_type, o.getPaymentChangeType())) return false;
		if(!Objects.equals(this.__basic_proportion, o.getBasicProportion())) return false;
		if(!Objects.equals(this.__change_date, o.getChangeDate())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__month_performance_pay, o.getMonthPerformancePay())) return false;
		if(!Objects.equals(this.__other_subsidy, o.getOtherSubsidy())) return false;
		if(!Objects.equals(this.__total_pay, o.getTotalPay())) return false;
		if(!Objects.equals(this.__annual_performance, o.getAnnualPerformance())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPaymentChangeType() != null) sb.append(__wrapNumber(count++, "paymentChangeType", getPaymentChangeType()));
		if(getBasicProportion() != null) sb.append(__wrapDecimal(count++, "basicProportion", getBasicProportion()));
		if(getChangeDate() != null) sb.append(__wrapDate(count++, "changeDate", getChangeDate()));
		if(getMonthPay() != null) sb.append(__wrapDecimal(count++, "monthPay", getMonthPay()));
		if(getMonthBasicPay() != null) sb.append(__wrapDecimal(count++, "monthBasicPay", getMonthBasicPay()));
		if(getMonthPerformancePay() != null) sb.append(__wrapDecimal(count++, "monthPerformancePay", getMonthPerformancePay()));
		if(getOtherSubsidy() != null) sb.append(__wrapDecimal(count++, "otherSubsidy", getOtherSubsidy()));
		if(getTotalPay() != null) sb.append(__wrapDecimal(count++, "totalPay", getTotalPay()));
		if(getAnnualPerformance() != null) sb.append(__wrapDecimal(count++, "annualPerformance", getAnnualPerformance()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("paymentChangeType")) != null) setPaymentChangeType(__getInt(val)); 
		if((val = values.get("basicProportion")) != null) setBasicProportion(__getDecimal(val));  
		if((val = values.get("changeDate")) != null) setChangeDate(__getDate(val)); 
		if((val = values.get("monthPay")) != null) setMonthPay(__getDecimal(val));  
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getDecimal(val));  
		if((val = values.get("monthPerformancePay")) != null) setMonthPerformancePay(__getDecimal(val));  
		if((val = values.get("otherSubsidy")) != null) setOtherSubsidy(__getDecimal(val));  
		if((val = values.get("totalPay")) != null) setTotalPay(__getDecimal(val));  
		if((val = values.get("annualPerformance")) != null) setAnnualPerformance(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __payment_change_type ;
	protected java.math.BigDecimal  __basic_proportion ;
	protected java.util.Date  __change_date ;
	protected java.math.BigDecimal  __month_pay ;
	protected java.math.BigDecimal  __month_basic_pay ;
	protected java.math.BigDecimal  __month_performance_pay ;
	protected java.math.BigDecimal  __other_subsidy ;
	protected java.math.BigDecimal  __total_pay ;
	protected java.math.BigDecimal  __annual_performance ;
}
