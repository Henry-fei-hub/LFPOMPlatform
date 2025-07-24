package pomplatform.account.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadMonthDetailOfAccount extends GenericCondition{

	public ConditionOnLoadMonthDetailOfAccount(){
		setParameterCount(5);
	}

	public java.lang.Integer getAccountTypeId() {
		return this.__account_type_id;
	}

	public void setAccountTypeId( java.lang.Integer value ) {
		this.__account_type_id = value;
	}

	public java.lang.Integer getAccountId() {
		return this.__account_id;
	}

	public void setAccountId( java.lang.Integer value ) {
		this.__account_id = value;
	}

	public java.lang.Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( java.lang.Integer value ) {
		this.__business_type_id = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAccountTypeId() != null) sb.append(__wrapNumber(1, "accountTypeId", getAccountTypeId()));
		if(getAccountId() != null) sb.append(__wrapNumber(1, "accountId", getAccountId()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(1, "businessTypeId", getBusinessTypeId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("accountTypeId")) != null) setAccountTypeId(__getInt(val)); 
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
	}

	private java.lang.Integer __account_type_id = null;
	private java.lang.Integer __account_id = null;
	private java.lang.Integer __business_type_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
}

