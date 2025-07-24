package pomplatform.OnLoadNewAccounts.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionNewAccountsInfo extends GenericCondition{

	public ConditionNewAccountsInfo(){
		setParameterCount(11);
	}

	public java.lang.Integer getAccountId() {
		return this.__account_id;
	}

	public void setAccountId( java.lang.Integer value ) {
		this.__account_id = value;
	}

	public java.lang.Integer getAccountType() {
		return this.__account_type;
	}

	public void setAccountType( java.lang.Integer value ) {
		this.__account_type = value;
	}

	public java.lang.String getAccountCode() {
		return this.__account_code;
	}

	public void setAccountCode( java.lang.String value ) {
		this.__account_code = value;
	}

	public java.lang.String getAccountName() {
		return this.__account_name;
	}

	public void setAccountName( java.lang.String value ) {
		this.__account_name = value;
	}

	public java.lang.Integer getOwnerId() {
		return this.__owner_id;
	}

	public void setOwnerId( java.lang.Integer value ) {
		this.__owner_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getBalance() {
		return this.__balance;
	}

	public void setBalance( java.math.BigDecimal value ) {
		this.__balance = value;
	}

	public java.math.BigDecimal getFreezingBalance() {
		return this.__freezing_balance;
	}

	public void setFreezingBalance( java.math.BigDecimal value ) {
		this.__freezing_balance = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getOrderId() {
		return this.__order_id;
	}

	public void setOrderId( java.lang.String value ) {
		this.__order_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAccountId() != null) sb.append(__wrapNumber(1, "accountId", getAccountId()));
		if(getAccountType() != null) sb.append(__wrapNumber(1, "accountType", getAccountType()));
		if(getAccountCode() != null) sb.append(__wrapString(1, "accountCode", getAccountCode()));
		if(getAccountName() != null) sb.append(__wrapString(1, "accountName", getAccountName()));
		if(getOwnerId() != null) sb.append(__wrapNumber(1, "ownerId", getOwnerId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getBalance() != null) sb.append(__wrapNumber(1, "balance", getBalance()));
		if(getFreezingBalance() != null) sb.append(__wrapNumber(1, "freezingBalance", getFreezingBalance()));
		if(getOperator() != null) sb.append(__wrapNumber(1, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(1, "createTime", getCreateTime()));
		if(getOrderId() != null) sb.append(__wrapString(1, "orderId", getOrderId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("accountCode")) != null) setAccountCode(__getString(val));
		if((val = values.get("accountName")) != null) setAccountName(__getString(val));
		if((val = values.get("ownerId")) != null) setOwnerId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("balance")) != null) setBalance(__getDecimal(val));  
		if((val = values.get("freezingBalance")) != null) setFreezingBalance(__getDecimal(val));  
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("orderId")) != null) setOrderId(__getString(val));
	}

	private java.lang.Integer __account_id = null;
	private java.lang.Integer __account_type = null;
	private java.lang.String __account_code = null;
	private java.lang.String __account_name = null;
	private java.lang.Integer __owner_id = null;
	private java.lang.Integer __status = null;
	private java.math.BigDecimal __balance = null;
	private java.math.BigDecimal __freezing_balance = null;
	private java.lang.Integer __operator = null;
	private java.util.Date __create_time = null;
	private java.lang.String __order_id = null;
}

