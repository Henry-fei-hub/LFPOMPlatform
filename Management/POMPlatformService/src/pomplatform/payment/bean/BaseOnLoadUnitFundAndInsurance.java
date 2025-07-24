package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadUnitFundAndInsurance extends GenericBase implements BaseFactory<BaseOnLoadUnitFundAndInsurance>, Comparable<BaseOnLoadUnitFundAndInsurance> 
{


	public static BaseOnLoadUnitFundAndInsurance newInstance(){
		return new BaseOnLoadUnitFundAndInsurance();
	}

	@Override
	public BaseOnLoadUnitFundAndInsurance make(){
		BaseOnLoadUnitFundAndInsurance b = new BaseOnLoadUnitFundAndInsurance();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_UNIT_TOTAL_FUND = "unit_total_fund" ;
	public final static java.lang.String CS_UNIT_TOTAL_INSURANCE = "unit_total_insurance" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_MONTH_PERFORMANCE_PAY = "month_performance_pay" ;
	public final static java.lang.String CS_FOREMAN_PAY = "foreman_pay" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,单位公积金合计,单位社保合计,月基本工资,月绩效工资,工龄工资";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getUnitTotalFund() {
		return this.__unit_total_fund;
	}

	public void setUnitTotalFund( java.math.BigDecimal value ) {
		this.__unit_total_fund = value;
	}

	public java.math.BigDecimal getUnitTotalInsurance() {
		return this.__unit_total_insurance;
	}

	public void setUnitTotalInsurance( java.math.BigDecimal value ) {
		this.__unit_total_insurance = value;
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


	public void cloneCopy(BaseOnLoadUnitFundAndInsurance __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setUnitTotalFund(getUnitTotalFund());
		__bean.setUnitTotalInsurance(getUnitTotalInsurance());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setMonthPerformancePay(getMonthPerformancePay());
		__bean.setForemanPay(getForemanPay());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getUnitTotalFund() == null ? "" : getUnitTotalFund());
		sb.append(",");
		sb.append(getUnitTotalInsurance() == null ? "" : getUnitTotalInsurance());
		sb.append(",");
		sb.append(getMonthBasicPay() == null ? "" : getMonthBasicPay());
		sb.append(",");
		sb.append(getMonthPerformancePay() == null ? "" : getMonthPerformancePay());
		sb.append(",");
		sb.append(getForemanPay() == null ? "" : getForemanPay());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadUnitFundAndInsurance o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__foreman_pay);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadUnitFundAndInsurance o = (BaseOnLoadUnitFundAndInsurance)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__unit_total_fund, o.getUnitTotalFund())) return false;
		if(!Objects.equals(this.__unit_total_insurance, o.getUnitTotalInsurance())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__month_performance_pay, o.getMonthPerformancePay())) return false;
		if(!Objects.equals(this.__foreman_pay, o.getForemanPay())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getUnitTotalFund() != null) sb.append(__wrapDecimal(count++, "unitTotalFund", getUnitTotalFund()));
		if(getUnitTotalInsurance() != null) sb.append(__wrapDecimal(count++, "unitTotalInsurance", getUnitTotalInsurance()));
		if(getMonthBasicPay() != null) sb.append(__wrapDecimal(count++, "monthBasicPay", getMonthBasicPay()));
		if(getMonthPerformancePay() != null) sb.append(__wrapDecimal(count++, "monthPerformancePay", getMonthPerformancePay()));
		if(getForemanPay() != null) sb.append(__wrapDecimal(count++, "foremanPay", getForemanPay()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("unitTotalFund")) != null) setUnitTotalFund(__getDecimal(val));  
		if((val = values.get("unitTotalInsurance")) != null) setUnitTotalInsurance(__getDecimal(val));  
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getDecimal(val));  
		if((val = values.get("monthPerformancePay")) != null) setMonthPerformancePay(__getDecimal(val));  
		if((val = values.get("foremanPay")) != null) setForemanPay(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __unit_total_fund ;
	protected java.math.BigDecimal  __unit_total_insurance ;
	protected java.math.BigDecimal  __month_basic_pay ;
	protected java.math.BigDecimal  __month_performance_pay ;
	protected java.math.BigDecimal  __foreman_pay ;
}
