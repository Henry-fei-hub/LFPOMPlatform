package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAccountTransaction extends GenericBase implements BaseFactory<BaseAccountTransaction>, Comparable<BaseAccountTransaction> 
{


	public static BaseAccountTransaction newInstance(){
		return new BaseAccountTransaction();
	}

	@Override
	public BaseAccountTransaction make(){
		BaseAccountTransaction b = new BaseAccountTransaction();
		return b;
	}

	public final static java.lang.String CS_ACCOUNT_TRANSACTION_ID = "account_transaction_id" ;
	public final static java.lang.String CS_ACCOUNT_ID = "account_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE_ID = "business_type_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_DETAIL_BUSINESS_ID = "detail_business_id" ;
	public final static java.lang.String CS_ORIGINAL_CURRENCY_DEBIT = "original_currency_debit" ;
	public final static java.lang.String CS_ORIGINAL_CURRENCY_CREDIT = "original_currency_credit" ;
	public final static java.lang.String CS_EXCHANGE_RATE = "exchange_rate" ;
	public final static java.lang.String CS_STANDARD_CURRENCY_DEBIT = "standard_currency_debit" ;
	public final static java.lang.String CS_STANDARD_CURRENCY_CREDIT = "standard_currency_credit" ;
	public final static java.lang.String CS_BALANCE = "balance" ;
	public final static java.lang.String CS_RECORD_TIME = "record_time" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,关联账户编码,业务类型,业务编码,业务子表编码,原币借,原币贷,汇率,本币借,本币贷,余额,记录时间,操作人,操作时间,备注";

	public java.lang.Integer getAccountTransactionId() {
		return this.__account_transaction_id;
	}

	public void setAccountTransactionId( java.lang.Integer value ) {
		this.__account_transaction_id = value;
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

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getDetailBusinessId() {
		return this.__detail_business_id;
	}

	public void setDetailBusinessId( java.lang.Integer value ) {
		this.__detail_business_id = value;
	}

	public java.math.BigDecimal getOriginalCurrencyDebit() {
		return this.__original_currency_debit;
	}

	public void setOriginalCurrencyDebit( java.math.BigDecimal value ) {
		this.__original_currency_debit = value;
	}

	public java.math.BigDecimal getOriginalCurrencyCredit() {
		return this.__original_currency_credit;
	}

	public void setOriginalCurrencyCredit( java.math.BigDecimal value ) {
		this.__original_currency_credit = value;
	}

	public java.math.BigDecimal getExchangeRate() {
		return this.__exchange_rate;
	}

	public void setExchangeRate( java.math.BigDecimal value ) {
		this.__exchange_rate = value;
	}

	public java.math.BigDecimal getStandardCurrencyDebit() {
		return this.__standard_currency_debit;
	}

	public void setStandardCurrencyDebit( java.math.BigDecimal value ) {
		this.__standard_currency_debit = value;
	}

	public java.math.BigDecimal getStandardCurrencyCredit() {
		return this.__standard_currency_credit;
	}

	public void setStandardCurrencyCredit( java.math.BigDecimal value ) {
		this.__standard_currency_credit = value;
	}

	public java.math.BigDecimal getBalance() {
		return this.__balance;
	}

	public void setBalance( java.math.BigDecimal value ) {
		this.__balance = value;
	}

	public java.util.Date getRecordTime() {
		return this.__record_time;
	}

	public void setRecordTime( java.util.Date value ) {
		this.__record_time = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseAccountTransaction __bean){
		__bean.setAccountTransactionId(getAccountTransactionId());
		__bean.setAccountId(getAccountId());
		__bean.setBusinessTypeId(getBusinessTypeId());
		__bean.setBusinessId(getBusinessId());
		__bean.setDetailBusinessId(getDetailBusinessId());
		__bean.setOriginalCurrencyDebit(getOriginalCurrencyDebit());
		__bean.setOriginalCurrencyCredit(getOriginalCurrencyCredit());
		__bean.setExchangeRate(getExchangeRate());
		__bean.setStandardCurrencyDebit(getStandardCurrencyDebit());
		__bean.setStandardCurrencyCredit(getStandardCurrencyCredit());
		__bean.setBalance(getBalance());
		__bean.setRecordTime(getRecordTime());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAccountTransactionId() == null ? "" : getAccountTransactionId());
		sb.append(",");
		sb.append(getAccountId() == null ? "" : getAccountId());
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		sb.append(",");
		sb.append(getDetailBusinessId() == null ? "" : getDetailBusinessId());
		sb.append(",");
		sb.append(getOriginalCurrencyDebit() == null ? "" : getOriginalCurrencyDebit());
		sb.append(",");
		sb.append(getOriginalCurrencyCredit() == null ? "" : getOriginalCurrencyCredit());
		sb.append(",");
		sb.append(getExchangeRate() == null ? "" : getExchangeRate());
		sb.append(",");
		sb.append(getStandardCurrencyDebit() == null ? "" : getStandardCurrencyDebit());
		sb.append(",");
		sb.append(getStandardCurrencyCredit() == null ? "" : getStandardCurrencyCredit());
		sb.append(",");
		sb.append(getBalance() == null ? "" : getBalance());
		sb.append(",");
		sb.append(getRecordTime() == null ? "" : sdf.format(getRecordTime()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAccountTransaction o) {
		return __account_transaction_id == null ? -1 : __account_transaction_id.compareTo(o.getAccountTransactionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__account_transaction_id);
		hash = 97 * hash + Objects.hashCode(this.__account_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__detail_business_id);
		hash = 97 * hash + Objects.hashCode(this.__original_currency_debit);
		hash = 97 * hash + Objects.hashCode(this.__original_currency_credit);
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate);
		hash = 97 * hash + Objects.hashCode(this.__standard_currency_debit);
		hash = 97 * hash + Objects.hashCode(this.__standard_currency_credit);
		hash = 97 * hash + Objects.hashCode(this.__balance);
		hash = 97 * hash + Objects.hashCode(this.__record_time);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAccountTransaction o = (BaseAccountTransaction)obj;
		if(!Objects.equals(this.__account_transaction_id, o.getAccountTransactionId())) return false;
		if(!Objects.equals(this.__account_id, o.getAccountId())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__detail_business_id, o.getDetailBusinessId())) return false;
		if(!Objects.equals(this.__original_currency_debit, o.getOriginalCurrencyDebit())) return false;
		if(!Objects.equals(this.__original_currency_credit, o.getOriginalCurrencyCredit())) return false;
		if(!Objects.equals(this.__exchange_rate, o.getExchangeRate())) return false;
		if(!Objects.equals(this.__standard_currency_debit, o.getStandardCurrencyDebit())) return false;
		if(!Objects.equals(this.__standard_currency_credit, o.getStandardCurrencyCredit())) return false;
		if(!Objects.equals(this.__balance, o.getBalance())) return false;
		if(!Objects.equals(this.__record_time, o.getRecordTime())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAccountTransactionId() != null) sb.append(__wrapNumber(count++, "accountTransactionId", getAccountTransactionId()));
		if(getAccountId() != null) sb.append(__wrapNumber(count++, "accountId", getAccountId()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getDetailBusinessId() != null) sb.append(__wrapNumber(count++, "detailBusinessId", getDetailBusinessId()));
		if(getOriginalCurrencyDebit() != null) sb.append(__wrapDecimal(count++, "originalCurrencyDebit", getOriginalCurrencyDebit()));
		if(getOriginalCurrencyCredit() != null) sb.append(__wrapDecimal(count++, "originalCurrencyCredit", getOriginalCurrencyCredit()));
		if(getExchangeRate() != null) sb.append(__wrapDecimal(count++, "exchangeRate", getExchangeRate()));
		if(getStandardCurrencyDebit() != null) sb.append(__wrapDecimal(count++, "standardCurrencyDebit", getStandardCurrencyDebit()));
		if(getStandardCurrencyCredit() != null) sb.append(__wrapDecimal(count++, "standardCurrencyCredit", getStandardCurrencyCredit()));
		if(getBalance() != null) sb.append(__wrapDecimal(count++, "balance", getBalance()));
		if(getRecordTime() != null) sb.append(__wrapDate(count++, "recordTime", getRecordTime()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("accountTransactionId")) != null) setAccountTransactionId(__getInt(val)); 
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("detailBusinessId")) != null) setDetailBusinessId(__getInt(val)); 
		if((val = values.get("originalCurrencyDebit")) != null) setOriginalCurrencyDebit(__getDecimal(val));  
		if((val = values.get("originalCurrencyCredit")) != null) setOriginalCurrencyCredit(__getDecimal(val));  
		if((val = values.get("exchangeRate")) != null) setExchangeRate(__getDecimal(val));  
		if((val = values.get("standardCurrencyDebit")) != null) setStandardCurrencyDebit(__getDecimal(val));  
		if((val = values.get("standardCurrencyCredit")) != null) setStandardCurrencyCredit(__getDecimal(val));  
		if((val = values.get("balance")) != null) setBalance(__getDecimal(val));  
		if((val = values.get("recordTime")) != null) setRecordTime(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __account_transaction_id ;
	protected java.lang.Integer  __account_id ;
	protected java.lang.Integer  __business_type_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __detail_business_id ;
	protected java.math.BigDecimal  __original_currency_debit ;
	protected java.math.BigDecimal  __original_currency_credit ;
	protected java.math.BigDecimal  __exchange_rate ;
	protected java.math.BigDecimal  __standard_currency_debit ;
	protected java.math.BigDecimal  __standard_currency_credit ;
	protected java.math.BigDecimal  __balance ;
	protected java.util.Date  __record_time ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
