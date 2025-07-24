package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadEmployeePayment extends GenericBase implements BaseFactory<BaseOnLoadEmployeePayment>, Comparable<BaseOnLoadEmployeePayment> 
{


	public static BaseOnLoadEmployeePayment newInstance(){
		return new BaseOnLoadEmployeePayment();
	}

	@Override
	public BaseOnLoadEmployeePayment make(){
		BaseOnLoadEmployeePayment b = new BaseOnLoadEmployeePayment();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PAYMENT_CHANGE_TYPE = "payment_change_type" ;
	public final static java.lang.String CS_CHANGE_DATE = "change_date" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;
	public final static java.lang.String CS_BASIC_PROPORTION_STR = "basic_proportion_str" ;
	public final static java.lang.String CS_BASIC_PROPORTION = "basic_proportion" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_MONTH_PERFORMANCE_PAY = "month_performance_pay" ;
	public final static java.lang.String CS_FOREMAN_PAY = "foreman_pay" ;
	public final static java.lang.String CS_TOTAL_PAY = "total_pay" ;
	public final static java.lang.String CS_ANNUAL_PERFORMANCE = "annual_performance" ;
	public final static java.lang.String CS_OTHER_SUBSIDY = "other_subsidy" ;
	public final static java.lang.String CS_COST_ATTRIBUTION = "cost_attribution";

	public final static java.lang.String ALL_CAPTIONS = "职员编码,员工编号,员工姓名,业务部门,归属部门,调薪类型,调薪日期,月薪,基本比例,基本比例,月基本工资,月绩效工资,工龄工资,全薪,年度绩效,其他补贴,费用类型";
	public final static java.lang.String EXPORT_CAPTIONS = "员工编号,员工姓名,业务部门,归属部门,调薪类型,调薪日期,月薪,基本比例,月基本工资,月绩效工资,全薪,年度绩效";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
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

	public java.math.BigDecimal getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.math.BigDecimal value ) {
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

	public java.math.BigDecimal getForemanPay() {
		return this.__foreman_pay;
	}

	public void setForemanPay( java.math.BigDecimal value ) {
		this.__foreman_pay = value;
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

	public java.math.BigDecimal getOtherSubsidy() {
		return this.__other_subsidy;
	}

	public void setOtherSubsidy( java.math.BigDecimal value ) {
		this.__other_subsidy = value;
	}
	
	public java.lang.Integer getCostAttribution() {
		return this.__cost_attribution;
	}

	public void setCostAttribution( java.lang.Integer value ) {
		this.__cost_attribution = value;
	}

	public void cloneCopy(BaseOnLoadEmployeePayment __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setPaymentChangeType(getPaymentChangeType());
		__bean.setChangeDate(getChangeDate());
		__bean.setMonthPay(getMonthPay());
		__bean.setBasicProportionStr(getBasicProportionStr());
		__bean.setBasicProportion(getBasicProportion());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setMonthPerformancePay(getMonthPerformancePay());
		__bean.setForemanPay(getForemanPay());
		__bean.setTotalPay(getTotalPay());
		__bean.setAnnualPerformance(getAnnualPerformance());
		__bean.setOtherSubsidy(getOtherSubsidy());
		__bean.setCostAttribution(getCostAttribution());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		/*String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");*/
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
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
		/*sb.append(getBasicProportion() == null ? "" : getBasicProportion());
		sb.append(",");*/
		sb.append(getMonthBasicPay() == null ? "" : getMonthBasicPay());
		sb.append(",");
		sb.append(getMonthPerformancePay() == null ? "" : getMonthPerformancePay());
		sb.append(",");
		sb.append(getTotalPay() == null ? "" : getTotalPay());
		sb.append(",");
		sb.append(getAnnualPerformance() == null ? "" : getAnnualPerformance());
		/*
		sb.append(",");
		sb.append(getOtherSubsidy() == null ? "" : getOtherSubsidy());*/
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadEmployeePayment o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__payment_change_type);
		hash = 97 * hash + Objects.hashCode(this.__change_date);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__foreman_pay);
		hash = 97 * hash + Objects.hashCode(this.__total_pay);
		hash = 97 * hash + Objects.hashCode(this.__annual_performance);
		hash = 97 * hash + Objects.hashCode(this.__other_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__cost_attribution);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadEmployeePayment o = (BaseOnLoadEmployeePayment)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__payment_change_type, o.getPaymentChangeType())) return false;
		if(!Objects.equals(this.__change_date, o.getChangeDate())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__basic_proportion_str, o.getBasicProportionStr())) return false;
		if(!Objects.equals(this.__basic_proportion, o.getBasicProportion())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__month_performance_pay, o.getMonthPerformancePay())) return false;
		if(!Objects.equals(this.__foreman_pay, o.getForemanPay())) return false;
		if(!Objects.equals(this.__total_pay, o.getTotalPay())) return false;
		if(!Objects.equals(this.__annual_performance, o.getAnnualPerformance())) return false;
		if(!Objects.equals(this.__other_subsidy, o.getOtherSubsidy())) return false;
		if(!Objects.equals(this.__cost_attribution, o.getCostAttribution())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getPaymentChangeType() != null) sb.append(__wrapNumber(count++, "paymentChangeType", getPaymentChangeType()));
		if(getChangeDate() != null) sb.append(__wrapDate(count++, "changeDate", getChangeDate()));
		if(getMonthPay() != null) sb.append(__wrapDecimal(count++, "monthPay", getMonthPay()));
		if(getBasicProportionStr() != null) sb.append(__wrapString(count++, "basicProportionStr", getBasicProportionStr()));
		if(getBasicProportion() != null) sb.append(__wrapDecimal(count++, "basicProportion", getBasicProportion()));
		if(getMonthBasicPay() != null) sb.append(__wrapDecimal(count++, "monthBasicPay", getMonthBasicPay()));
		if(getMonthPerformancePay() != null) sb.append(__wrapDecimal(count++, "monthPerformancePay", getMonthPerformancePay()));
		if(getForemanPay() != null) sb.append(__wrapDecimal(count++, "foremanPay", getForemanPay()));
		if(getTotalPay() != null) sb.append(__wrapDecimal(count++, "totalPay", getTotalPay()));
		if(getAnnualPerformance() != null) sb.append(__wrapDecimal(count++, "annualPerformance", getAnnualPerformance()));
		if(getOtherSubsidy() != null) sb.append(__wrapDecimal(count++, "otherSubsidy", getOtherSubsidy()));
		if(getCostAttribution() != null) sb.append(__wrapNumber(count++, "costAttribution", getCostAttribution()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("paymentChangeType")) != null) setPaymentChangeType(__getInt(val)); 
		if((val = values.get("changeDate")) != null) setChangeDate(__getDate(val)); 
		if((val = values.get("monthPay")) != null) setMonthPay(__getDecimal(val));  
		if((val = values.get("basicProportionStr")) != null) setBasicProportionStr(__getString(val));
		if((val = values.get("basicProportion")) != null) setBasicProportion(__getDecimal(val));  
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getDecimal(val));  
		if((val = values.get("monthPerformancePay")) != null) setMonthPerformancePay(__getDecimal(val));  
		if((val = values.get("foremanPay")) != null) setForemanPay(__getDecimal(val));  
		if((val = values.get("totalPay")) != null) setTotalPay(__getDecimal(val));  
		if((val = values.get("annualPerformance")) != null) setAnnualPerformance(__getDecimal(val));  
		if((val = values.get("otherSubsidy")) != null) setOtherSubsidy(__getDecimal(val)); 
		if((val = values.get("costAttribution")) != null) setCostAttribution(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __payment_change_type ;
	protected java.util.Date  __change_date ;
	protected java.math.BigDecimal  __month_pay ;
	protected java.lang.String  __basic_proportion_str ;
	protected java.math.BigDecimal  __basic_proportion ;
	protected java.math.BigDecimal  __month_basic_pay ;
	protected java.math.BigDecimal  __month_performance_pay ;
	protected java.math.BigDecimal  __foreman_pay ;
	protected java.math.BigDecimal  __total_pay ;
	protected java.math.BigDecimal  __annual_performance ;
	protected java.math.BigDecimal  __other_subsidy ;
	protected java.lang.Integer __cost_attribution ;
}
