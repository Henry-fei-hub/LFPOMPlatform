package pomplatform.OnLoadNewAccounts.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOneNewAccountsTransationsInfo extends GenericCondition{

	public ConditionOneNewAccountsTransationsInfo(){
		setParameterCount(1);
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
		if(getAccountId() != null) sb.append(__wrapNumber(1, "accountId", getAccountId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
	}

	private java.lang.Integer __account_id = null;
}

