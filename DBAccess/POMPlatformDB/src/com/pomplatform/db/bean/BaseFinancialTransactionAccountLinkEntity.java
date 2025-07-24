package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFinancialTransactionAccountLinkEntity extends GenericBase implements BaseFactory<BaseFinancialTransactionAccountLinkEntity>, Comparable<BaseFinancialTransactionAccountLinkEntity> 
{


	public static BaseFinancialTransactionAccountLinkEntity newInstance(){
		return new BaseFinancialTransactionAccountLinkEntity();
	}

	@Override
	public BaseFinancialTransactionAccountLinkEntity make(){
		BaseFinancialTransactionAccountLinkEntity b = new BaseFinancialTransactionAccountLinkEntity();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_TRANSACTION_ACCOUNT_LINK_ENTITY_ID = "financial_transaction_account_link_entity_id" ;
	public final static java.lang.String CS_FINANCIAL_TRANSACTION_ACCOUNT_ID = "financial_transaction_account_id" ;
	public final static java.lang.String CS_ACCOUNT_TYPE = "account_type" ;
	public final static java.lang.String CS_ENTITY_ID = "entity_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,财务往来账户编码, 2收款单位,实体编码";

	public java.lang.Integer getFinancialTransactionAccountLinkEntityId() {
		return this.__financial_transaction_account_link_entity_id;
	}

	public void setFinancialTransactionAccountLinkEntityId( java.lang.Integer value ) {
		this.__financial_transaction_account_link_entity_id = value;
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return this.__financial_transaction_account_id;
	}

	public void setFinancialTransactionAccountId( java.lang.Integer value ) {
		this.__financial_transaction_account_id = value;
	}

	public java.lang.Integer getAccountType() {
		return this.__account_type;
	}

	public void setAccountType( java.lang.Integer value ) {
		this.__account_type = value;
	}

	public java.lang.Integer getEntityId() {
		return this.__entity_id;
	}

	public void setEntityId( java.lang.Integer value ) {
		this.__entity_id = value;
	}

	public void cloneCopy(BaseFinancialTransactionAccountLinkEntity __bean){
		__bean.setFinancialTransactionAccountLinkEntityId(getFinancialTransactionAccountLinkEntityId());
		__bean.setFinancialTransactionAccountId(getFinancialTransactionAccountId());
		__bean.setAccountType(getAccountType());
		__bean.setEntityId(getEntityId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialTransactionAccountLinkEntityId() == null ? "" : getFinancialTransactionAccountLinkEntityId());
		sb.append(",");
		sb.append(getFinancialTransactionAccountId() == null ? "" : getFinancialTransactionAccountId());
		sb.append(",");
		sb.append(getAccountType() == null ? "" : getAccountType());
		sb.append(",");
		sb.append(getEntityId() == null ? "" : getEntityId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialTransactionAccountLinkEntity o) {
		return __financial_transaction_account_link_entity_id == null ? -1 : __financial_transaction_account_link_entity_id.compareTo(o.getFinancialTransactionAccountLinkEntityId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_account_link_entity_id);
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_account_id);
		hash = 97 * hash + Objects.hashCode(this.__account_type);
		hash = 97 * hash + Objects.hashCode(this.__entity_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialTransactionAccountLinkEntity o = (BaseFinancialTransactionAccountLinkEntity)obj;
		if(!Objects.equals(this.__financial_transaction_account_link_entity_id, o.getFinancialTransactionAccountLinkEntityId())) return false;
		if(!Objects.equals(this.__financial_transaction_account_id, o.getFinancialTransactionAccountId())) return false;
		if(!Objects.equals(this.__account_type, o.getAccountType())) return false;
		if(!Objects.equals(this.__entity_id, o.getEntityId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialTransactionAccountLinkEntityId() != null) sb.append(__wrapNumber(count++, "financialTransactionAccountLinkEntityId", getFinancialTransactionAccountLinkEntityId()));
		if(getFinancialTransactionAccountId() != null) sb.append(__wrapNumber(count++, "financialTransactionAccountId", getFinancialTransactionAccountId()));
		if(getAccountType() != null) sb.append(__wrapNumber(count++, "accountType", getAccountType()));
		if(getEntityId() != null) sb.append(__wrapNumber(count++, "entityId", getEntityId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialTransactionAccountLinkEntityId() != null) res.put("financialTransactionAccountLinkEntityId", getFinancialTransactionAccountLinkEntityId());
		if(getFinancialTransactionAccountId() != null) res.put("financialTransactionAccountId", getFinancialTransactionAccountId());
		if(getAccountType() != null) res.put("accountType", getAccountType());
		if(getEntityId() != null) res.put("entityId", getEntityId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialTransactionAccountLinkEntityId")) != null) setFinancialTransactionAccountLinkEntityId(__getInt(val)); 
		if((val = values.get("financialTransactionAccountId")) != null) setFinancialTransactionAccountId(__getInt(val)); 
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("entityId")) != null) setEntityId(__getInt(val)); 
	}

	protected java.lang.Integer  __financial_transaction_account_link_entity_id ;
	protected java.lang.Integer  __financial_transaction_account_id ;
	protected java.lang.Integer  __account_type ;
	protected java.lang.Integer  __entity_id ;
}
