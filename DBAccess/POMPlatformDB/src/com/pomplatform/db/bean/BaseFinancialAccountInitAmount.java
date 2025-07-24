package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialAccountInitAmount extends GenericBase implements BaseFactory<BaseFinancialAccountInitAmount>, Comparable<BaseFinancialAccountInitAmount> 
{


	public static BaseFinancialAccountInitAmount newInstance(){
		return new BaseFinancialAccountInitAmount();
	}

	@Override
	public BaseFinancialAccountInitAmount make(){
		BaseFinancialAccountInitAmount b = new BaseFinancialAccountInitAmount();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_ACCOUNT_INIT_AMOUNT_ID = "financial_account_init_amount_id" ;
	public final static java.lang.String CS_FINANCIAL_TRANSACTION_ACCOUNT_ID = "financial_transaction_account_id" ;
	public final static java.lang.String CS_CURRENCY_TYPE = "currency_type" ;
	public final static java.lang.String CS_ORIGINAL_DEBIT = "original_debit" ;
	public final static java.lang.String CS_ORIGINAL_CREDIT = "original_credit" ;
	public final static java.lang.String CS_EXCHANGE_RATE = "exchange_rate" ;
	public final static java.lang.String CS_STANDARD_DEBIT = "standard_debit" ;
	public final static java.lang.String CS_STANDARD_CREDIT = "standard_credit" ;
	public final static java.lang.String CS_SUMMARY = "summary" ;
	public final static java.lang.String CS_ATTACHMENT_ID = "attachment_id" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,财务往来账户,货币种类 system_dictionary_40,原币借,原币贷,汇率,本币借,本币贷,摘要,附件编码,操作人,创建时间, 1已删除,归属公司";

	public java.lang.Integer getFinancialAccountInitAmountId() {
		return this.__financial_account_init_amount_id;
	}

	public void setFinancialAccountInitAmountId( java.lang.Integer value ) {
		this.__financial_account_init_amount_id = value;
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return this.__financial_transaction_account_id;
	}

	public void setFinancialTransactionAccountId( java.lang.Integer value ) {
		this.__financial_transaction_account_id = value;
	}

	public java.lang.Integer getCurrencyType() {
		return this.__currency_type;
	}

	public void setCurrencyType( java.lang.Integer value ) {
		this.__currency_type = value;
	}

	public java.math.BigDecimal getOriginalDebit() {
		return this.__original_debit;
	}

	public void setOriginalDebit( java.math.BigDecimal value ) {
		this.__original_debit = value;
	}

	public java.math.BigDecimal getOriginalCredit() {
		return this.__original_credit;
	}

	public void setOriginalCredit( java.math.BigDecimal value ) {
		this.__original_credit = value;
	}

	public java.math.BigDecimal getExchangeRate() {
		return this.__exchange_rate;
	}

	public void setExchangeRate( java.math.BigDecimal value ) {
		this.__exchange_rate = value;
	}

	public java.math.BigDecimal getStandardDebit() {
		return this.__standard_debit;
	}

	public void setStandardDebit( java.math.BigDecimal value ) {
		this.__standard_debit = value;
	}

	public java.math.BigDecimal getStandardCredit() {
		return this.__standard_credit;
	}

	public void setStandardCredit( java.math.BigDecimal value ) {
		this.__standard_credit = value;
	}

	public java.lang.String getSummary() {
		return this.__summary;
	}

	public void setSummary( java.lang.String value ) {
		this.__summary = value;
	}

	public java.lang.Integer getAttachmentId() {
		return this.__attachment_id;
	}

	public void setAttachmentId( java.lang.Integer value ) {
		this.__attachment_id = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public void cloneCopy(BaseFinancialAccountInitAmount __bean){
		__bean.setFinancialAccountInitAmountId(getFinancialAccountInitAmountId());
		__bean.setFinancialTransactionAccountId(getFinancialTransactionAccountId());
		__bean.setCurrencyType(getCurrencyType());
		__bean.setOriginalDebit(getOriginalDebit());
		__bean.setOriginalCredit(getOriginalCredit());
		__bean.setExchangeRate(getExchangeRate());
		__bean.setStandardDebit(getStandardDebit());
		__bean.setStandardCredit(getStandardCredit());
		__bean.setSummary(getSummary());
		__bean.setAttachmentId(getAttachmentId());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialAccountInitAmountId() == null ? "" : getFinancialAccountInitAmountId());
		sb.append(",");
		sb.append(getFinancialTransactionAccountId() == null ? "" : getFinancialTransactionAccountId());
		sb.append(",");
		sb.append(getCurrencyType() == null ? "" : getCurrencyType());
		sb.append(",");
		sb.append(getOriginalDebit() == null ? "" : getOriginalDebit());
		sb.append(",");
		sb.append(getOriginalCredit() == null ? "" : getOriginalCredit());
		sb.append(",");
		sb.append(getExchangeRate() == null ? "" : getExchangeRate());
		sb.append(",");
		sb.append(getStandardDebit() == null ? "" : getStandardDebit());
		sb.append(",");
		sb.append(getStandardCredit() == null ? "" : getStandardCredit());
		sb.append(",");
		sb.append(getSummary() == null ? "" : getSummary());
		sb.append(",");
		sb.append(getAttachmentId() == null ? "" : getAttachmentId());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialAccountInitAmount o) {
		return __financial_account_init_amount_id == null ? -1 : __financial_account_init_amount_id.compareTo(o.getFinancialAccountInitAmountId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_account_init_amount_id);
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_account_id);
		hash = 97 * hash + Objects.hashCode(this.__currency_type);
		hash = 97 * hash + Objects.hashCode(this.__original_debit);
		hash = 97 * hash + Objects.hashCode(this.__original_credit);
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate);
		hash = 97 * hash + Objects.hashCode(this.__standard_debit);
		hash = 97 * hash + Objects.hashCode(this.__standard_credit);
		hash = 97 * hash + Objects.hashCode(this.__summary);
		hash = 97 * hash + Objects.hashCode(this.__attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialAccountInitAmount o = (BaseFinancialAccountInitAmount)obj;
		if(!Objects.equals(this.__financial_account_init_amount_id, o.getFinancialAccountInitAmountId())) return false;
		if(!Objects.equals(this.__financial_transaction_account_id, o.getFinancialTransactionAccountId())) return false;
		if(!Objects.equals(this.__currency_type, o.getCurrencyType())) return false;
		if(!Objects.equals(this.__original_debit, o.getOriginalDebit())) return false;
		if(!Objects.equals(this.__original_credit, o.getOriginalCredit())) return false;
		if(!Objects.equals(this.__exchange_rate, o.getExchangeRate())) return false;
		if(!Objects.equals(this.__standard_debit, o.getStandardDebit())) return false;
		if(!Objects.equals(this.__standard_credit, o.getStandardCredit())) return false;
		if(!Objects.equals(this.__summary, o.getSummary())) return false;
		if(!Objects.equals(this.__attachment_id, o.getAttachmentId())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialAccountInitAmountId() != null) sb.append(__wrapNumber(count++, "financialAccountInitAmountId", getFinancialAccountInitAmountId()));
		if(getFinancialTransactionAccountId() != null) sb.append(__wrapNumber(count++, "financialTransactionAccountId", getFinancialTransactionAccountId()));
		if(getCurrencyType() != null) sb.append(__wrapNumber(count++, "currencyType", getCurrencyType()));
		if(getOriginalDebit() != null) sb.append(__wrapDecimal(count++, "originalDebit", getOriginalDebit()));
		if(getOriginalCredit() != null) sb.append(__wrapDecimal(count++, "originalCredit", getOriginalCredit()));
		if(getExchangeRate() != null) sb.append(__wrapDecimal(count++, "exchangeRate", getExchangeRate()));
		if(getStandardDebit() != null) sb.append(__wrapDecimal(count++, "standardDebit", getStandardDebit()));
		if(getStandardCredit() != null) sb.append(__wrapDecimal(count++, "standardCredit", getStandardCredit()));
		if(getSummary() != null) sb.append(__wrapString(count++, "summary", getSummary()));
		if(getAttachmentId() != null) sb.append(__wrapNumber(count++, "attachmentId", getAttachmentId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialAccountInitAmountId() != null) res.put("financialAccountInitAmountId", getFinancialAccountInitAmountId());
		if(getFinancialTransactionAccountId() != null) res.put("financialTransactionAccountId", getFinancialTransactionAccountId());
		if(getCurrencyType() != null) res.put("currencyType", getCurrencyType());
		if(getOriginalDebit() != null) res.put("originalDebit", getOriginalDebit());
		if(getOriginalCredit() != null) res.put("originalCredit", getOriginalCredit());
		if(getExchangeRate() != null) res.put("exchangeRate", getExchangeRate());
		if(getStandardDebit() != null) res.put("standardDebit", getStandardDebit());
		if(getStandardCredit() != null) res.put("standardCredit", getStandardCredit());
		if(getSummary() != null) res.put("summary", getSummary());
		if(getAttachmentId() != null) res.put("attachmentId", getAttachmentId());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialAccountInitAmountId")) != null) setFinancialAccountInitAmountId(__getInt(val)); 
		if((val = values.get("financialTransactionAccountId")) != null) setFinancialTransactionAccountId(__getInt(val)); 
		if((val = values.get("currencyType")) != null) setCurrencyType(__getInt(val)); 
		if((val = values.get("originalDebit")) != null) setOriginalDebit(__getDecimal(val));  
		if((val = values.get("originalCredit")) != null) setOriginalCredit(__getDecimal(val));  
		if((val = values.get("exchangeRate")) != null) setExchangeRate(__getDecimal(val));  
		if((val = values.get("standardDebit")) != null) setStandardDebit(__getDecimal(val));  
		if((val = values.get("standardCredit")) != null) setStandardCredit(__getDecimal(val));  
		if((val = values.get("summary")) != null) setSummary(__getString(val));
		if((val = values.get("attachmentId")) != null) setAttachmentId(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	protected java.lang.Integer  __financial_account_init_amount_id ;
	protected java.lang.Integer  __financial_transaction_account_id ;
	protected java.lang.Integer  __currency_type ;
	protected java.math.BigDecimal  __original_debit ;
	protected java.math.BigDecimal  __original_credit ;
	protected java.math.BigDecimal  __exchange_rate ;
	protected java.math.BigDecimal  __standard_debit ;
	protected java.math.BigDecimal  __standard_credit ;
	protected java.lang.String  __summary ;
	protected java.lang.Integer  __attachment_id ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __company_id ;
}
