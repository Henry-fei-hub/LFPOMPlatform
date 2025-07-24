package pomplatform.account.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadLeftIntegralOfAccount extends GenericCondition{

	public ConditionOnLoadLeftIntegralOfAccount(){
		setParameterCount(2);
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAccountTypeId() != null) sb.append(__wrapNumber(1, "accountTypeId", getAccountTypeId()));
		if(getAccountId() != null) sb.append(__wrapNumber(1, "accountId", getAccountId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("accountTypeId")) != null) setAccountTypeId(__getInt(val)); 
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
	}

	private java.lang.Integer __account_type_id = null;
	private java.lang.Integer __account_id = null;
}

