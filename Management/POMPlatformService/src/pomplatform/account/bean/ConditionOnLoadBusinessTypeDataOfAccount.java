package pomplatform.account.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadBusinessTypeDataOfAccount extends GenericCondition{

	public ConditionOnLoadBusinessTypeDataOfAccount(){
		setParameterCount(4);
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

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAccountTypeId() != null) sb.append(__wrapNumber(1, "accountTypeId", getAccountTypeId()));
		if(getAccountId() != null) sb.append(__wrapNumber(1, "accountId", getAccountId()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("accountTypeId")) != null) setAccountTypeId(__getInt(val)); 
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	private java.lang.Integer __account_type_id = null;
	private java.lang.Integer __account_id = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
}

