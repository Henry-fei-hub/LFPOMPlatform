package pomplatform.salarydecrypt.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionDecryptEmployeePaymentMonthDetails extends GenericCondition{

	public ConditionDecryptEmployeePaymentMonthDetails(){
		setParameterCount(6);
	}

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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeePaymentMonthDetailId() != null) sb.append(__wrapNumber(1, "employeePaymentMonthDetailId", getEmployeePaymentMonthDetailId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getCostAttribution() != null) sb.append(__wrapNumber(1, "costAttribution", getCostAttribution()));
		if(getEnabled() != null) sb.append(__wrapBoolean(1, "enabled", getEnabled()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeePaymentMonthDetailId")) != null) setEmployeePaymentMonthDetailId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("costAttribution")) != null) setCostAttribution(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
	}

	private java.lang.Integer __employee_payment_month_detail_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __cost_attribution = null;
	private java.lang.Boolean __enabled = null;
}

