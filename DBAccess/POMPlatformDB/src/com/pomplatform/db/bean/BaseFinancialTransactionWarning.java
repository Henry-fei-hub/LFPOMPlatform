package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFinancialTransactionWarning extends GenericBase implements BaseFactory<BaseFinancialTransactionWarning>, Comparable<BaseFinancialTransactionWarning> 
{


	public static BaseFinancialTransactionWarning newInstance(){
		return new BaseFinancialTransactionWarning();
	}

	@Override
	public BaseFinancialTransactionWarning make(){
		BaseFinancialTransactionWarning b = new BaseFinancialTransactionWarning();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_TRANSACTION_WARNING_ID = "financial_transaction_warning_id" ;
	public final static java.lang.String CS_FINANCIAL_TRANSACTION_ACCOUNT_ID = "financial_transaction_account_id" ;
	public final static java.lang.String CS_WARNING_CONTENT = "warning_content" ;
	public final static java.lang.String CS_IS_ENABLED = "is_enabled" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,财务往来账户,警示内容,是否有效,操作人,创建时间";

	public java.lang.Integer getFinancialTransactionWarningId() {
		return this.__financial_transaction_warning_id;
	}

	public void setFinancialTransactionWarningId( java.lang.Integer value ) {
		this.__financial_transaction_warning_id = value;
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return this.__financial_transaction_account_id;
	}

	public void setFinancialTransactionAccountId( java.lang.Integer value ) {
		this.__financial_transaction_account_id = value;
	}

	public java.lang.String getWarningContent() {
		return this.__warning_content;
	}

	public void setWarningContent( java.lang.String value ) {
		this.__warning_content = value;
	}

	public java.lang.Boolean getIsEnabled() {
		return this.__is_enabled;
	}

	public void setIsEnabled( java.lang.Boolean value ) {
		this.__is_enabled = value;
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

	public void cloneCopy(BaseFinancialTransactionWarning __bean){
		__bean.setFinancialTransactionWarningId(getFinancialTransactionWarningId());
		__bean.setFinancialTransactionAccountId(getFinancialTransactionAccountId());
		__bean.setWarningContent(getWarningContent());
		__bean.setIsEnabled(getIsEnabled());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialTransactionWarningId() == null ? "" : getFinancialTransactionWarningId());
		sb.append(",");
		sb.append(getFinancialTransactionAccountId() == null ? "" : getFinancialTransactionAccountId());
		sb.append(",");
		sb.append(getWarningContent() == null ? "" : getWarningContent());
		sb.append(",");
		sb.append(getIsEnabled() == null ? "" : getIsEnabled());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialTransactionWarning o) {
		return __financial_transaction_warning_id == null ? -1 : __financial_transaction_warning_id.compareTo(o.getFinancialTransactionWarningId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_warning_id);
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_account_id);
		hash = 97 * hash + Objects.hashCode(this.__warning_content);
		hash = 97 * hash + Objects.hashCode(this.__is_enabled);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialTransactionWarning o = (BaseFinancialTransactionWarning)obj;
		if(!Objects.equals(this.__financial_transaction_warning_id, o.getFinancialTransactionWarningId())) return false;
		if(!Objects.equals(this.__financial_transaction_account_id, o.getFinancialTransactionAccountId())) return false;
		if(!Objects.equals(this.__warning_content, o.getWarningContent())) return false;
		if(!Objects.equals(this.__is_enabled, o.getIsEnabled())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialTransactionWarningId() != null) sb.append(__wrapNumber(count++, "financialTransactionWarningId", getFinancialTransactionWarningId()));
		if(getFinancialTransactionAccountId() != null) sb.append(__wrapNumber(count++, "financialTransactionAccountId", getFinancialTransactionAccountId()));
		if(getWarningContent() != null) sb.append(__wrapString(count++, "warningContent", getWarningContent()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(count++, "isEnabled", getIsEnabled()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialTransactionWarningId() != null) res.put("financialTransactionWarningId", getFinancialTransactionWarningId());
		if(getFinancialTransactionAccountId() != null) res.put("financialTransactionAccountId", getFinancialTransactionAccountId());
		if(getWarningContent() != null) res.put("warningContent", getWarningContent());
		if(getIsEnabled() != null) res.put("isEnabled", getIsEnabled());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialTransactionWarningId")) != null) setFinancialTransactionWarningId(__getInt(val)); 
		if((val = values.get("financialTransactionAccountId")) != null) setFinancialTransactionAccountId(__getInt(val)); 
		if((val = values.get("warningContent")) != null) setWarningContent(__getString(val));
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __financial_transaction_warning_id ;
	protected java.lang.Integer  __financial_transaction_account_id ;
	protected java.lang.String  __warning_content ;
	protected java.lang.Boolean  __is_enabled ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __create_time ;
}
