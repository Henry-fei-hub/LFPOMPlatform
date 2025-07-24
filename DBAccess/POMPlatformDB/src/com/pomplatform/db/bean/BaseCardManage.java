package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCardManage extends GenericBase implements BaseFactory<BaseCardManage>, Comparable<BaseCardManage> 
{


	public static BaseCardManage newInstance(){
		return new BaseCardManage();
	}

	@Override
	public BaseCardManage make(){
		BaseCardManage b = new BaseCardManage();
		return b;
	}

	public final static java.lang.String CS_CARD_MANAGE_ID = "card_manage_id" ;
	public final static java.lang.String CS_OBJECT_ID = "object_id" ;
	public final static java.lang.String CS_OBJECT_TYPE = "object_type" ;
	public final static java.lang.String CS_BANK_ID = "bank_id" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_BANK_ADDRESS = "bank_address" ;
	public final static java.lang.String CS_CARD_TYPE = "card_type" ;
	public final static java.lang.String CS_DEFAULT_CARD = "default_card" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;
	public final static java.lang.String CS_CURRENCY_TYPE = "currency_type" ;
	public final static java.lang.String CS_CMBC_CODE_ID = "cmbc_code_id" ;
	public final static java.lang.String CS_TRUE_PAYMENT = "true_payment" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,对象编码,2单位),开户行,银行账号,开户行所在地,2报销卡),是否为默认卡,是否启用,,招商银行分行代码,真实收付款,开户行(支行)";

	public java.lang.Integer getCardManageId() {
		return this.__card_manage_id;
	}

	public void setCardManageId( java.lang.Integer value ) {
		this.__card_manage_id = value;
	}

	public java.lang.Integer getObjectId() {
		return this.__object_id;
	}

	public void setObjectId( java.lang.Integer value ) {
		this.__object_id = value;
	}

	public java.lang.Integer getObjectType() {
		return this.__object_type;
	}

	public void setObjectType( java.lang.Integer value ) {
		this.__object_type = value;
	}

	public java.lang.Integer getBankId() {
		return this.__bank_id;
	}

	public void setBankId( java.lang.Integer value ) {
		this.__bank_id = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankAddress() {
		return this.__bank_address;
	}

	public void setBankAddress( java.lang.String value ) {
		this.__bank_address = value;
	}

	public java.lang.Integer getCardType() {
		return this.__card_type;
	}

	public void setCardType( java.lang.Integer value ) {
		this.__card_type = value;
	}

	public java.lang.Boolean getDefaultCard() {
		return this.__default_card;
	}

	public void setDefaultCard( java.lang.Boolean value ) {
		this.__default_card = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public java.lang.Integer getCurrencyType() {
		return this.__currency_type;
	}

	public void setCurrencyType( java.lang.Integer value ) {
		this.__currency_type = value;
	}

	public java.lang.Integer getCmbcCodeId() {
		return this.__cmbc_code_id;
	}

	public void setCmbcCodeId( java.lang.Integer value ) {
		this.__cmbc_code_id = value;
	}

	public java.lang.Boolean getTruePayment() {
		return this.__true_payment;
	}

	public void setTruePayment( java.lang.Boolean value ) {
		this.__true_payment = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public void cloneCopy(BaseCardManage __bean){
		__bean.setCardManageId(getCardManageId());
		__bean.setObjectId(getObjectId());
		__bean.setObjectType(getObjectType());
		__bean.setBankId(getBankId());
		__bean.setBankAccount(getBankAccount());
		__bean.setBankAddress(getBankAddress());
		__bean.setCardType(getCardType());
		__bean.setDefaultCard(getDefaultCard());
		__bean.setEnabled(getEnabled());
		__bean.setCurrencyType(getCurrencyType());
		__bean.setCmbcCodeId(getCmbcCodeId());
		__bean.setTruePayment(getTruePayment());
		__bean.setBankName(getBankName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCardManageId() == null ? "" : getCardManageId());
		sb.append(",");
		sb.append(getObjectId() == null ? "" : getObjectId());
		sb.append(",");
		sb.append(getObjectType() == null ? "" : getObjectType());
		sb.append(",");
		sb.append(getBankId() == null ? "" : getBankId());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getBankAddress() == null ? "" : getBankAddress());
		sb.append(",");
		sb.append(getCardType() == null ? "" : getCardType());
		sb.append(",");
		sb.append(getDefaultCard() == null ? "" : getDefaultCard());
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		sb.append(",");
		sb.append(getCurrencyType() == null ? "" : getCurrencyType());
		sb.append(",");
		sb.append(getCmbcCodeId() == null ? "" : getCmbcCodeId());
		sb.append(",");
		sb.append(getTruePayment() == null ? "" : getTruePayment());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCardManage o) {
		return __card_manage_id == null ? -1 : __card_manage_id.compareTo(o.getCardManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__card_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__object_id);
		hash = 97 * hash + Objects.hashCode(this.__object_type);
		hash = 97 * hash + Objects.hashCode(this.__bank_id);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__bank_address);
		hash = 97 * hash + Objects.hashCode(this.__card_type);
		hash = 97 * hash + Objects.hashCode(this.__default_card);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		hash = 97 * hash + Objects.hashCode(this.__currency_type);
		hash = 97 * hash + Objects.hashCode(this.__cmbc_code_id);
		hash = 97 * hash + Objects.hashCode(this.__true_payment);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCardManage o = (BaseCardManage)obj;
		if(!Objects.equals(this.__card_manage_id, o.getCardManageId())) return false;
		if(!Objects.equals(this.__object_id, o.getObjectId())) return false;
		if(!Objects.equals(this.__object_type, o.getObjectType())) return false;
		if(!Objects.equals(this.__bank_id, o.getBankId())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__bank_address, o.getBankAddress())) return false;
		if(!Objects.equals(this.__card_type, o.getCardType())) return false;
		if(!Objects.equals(this.__default_card, o.getDefaultCard())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		if(!Objects.equals(this.__currency_type, o.getCurrencyType())) return false;
		if(!Objects.equals(this.__cmbc_code_id, o.getCmbcCodeId())) return false;
		if(!Objects.equals(this.__true_payment, o.getTruePayment())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCardManageId() != null) sb.append(__wrapNumber(count++, "cardManageId", getCardManageId()));
		if(getObjectId() != null) sb.append(__wrapNumber(count++, "objectId", getObjectId()));
		if(getObjectType() != null) sb.append(__wrapNumber(count++, "objectType", getObjectType()));
		if(getBankId() != null) sb.append(__wrapNumber(count++, "bankId", getBankId()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getBankAddress() != null) sb.append(__wrapString(count++, "bankAddress", getBankAddress()));
		if(getCardType() != null) sb.append(__wrapNumber(count++, "cardType", getCardType()));
		if(getDefaultCard() != null) sb.append(__wrapBoolean(count++, "defaultCard", getDefaultCard()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		if(getCurrencyType() != null) sb.append(__wrapNumber(count++, "currencyType", getCurrencyType()));
		if(getCmbcCodeId() != null) sb.append(__wrapNumber(count++, "cmbcCodeId", getCmbcCodeId()));
		if(getTruePayment() != null) sb.append(__wrapBoolean(count++, "truePayment", getTruePayment()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cardManageId")) != null) setCardManageId(__getInt(val)); 
		if((val = values.get("objectId")) != null) setObjectId(__getInt(val)); 
		if((val = values.get("objectType")) != null) setObjectType(__getInt(val)); 
		if((val = values.get("bankId")) != null) setBankId(__getInt(val)); 
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankAddress")) != null) setBankAddress(__getString(val));
		if((val = values.get("cardType")) != null) setCardType(__getInt(val)); 
		if((val = values.get("defaultCard")) != null) setDefaultCard(__getBoolean(val));
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
		if((val = values.get("currencyType")) != null) setCurrencyType(__getInt(val)); 
		if((val = values.get("cmbcCodeId")) != null) setCmbcCodeId(__getInt(val)); 
		if((val = values.get("truePayment")) != null) setTruePayment(__getBoolean(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
	}

	protected java.lang.Integer  __card_manage_id ;
	protected java.lang.Integer  __object_id ;
	protected java.lang.Integer  __object_type ;
	protected java.lang.Integer  __bank_id ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __bank_address ;
	protected java.lang.Integer  __card_type ;
	protected java.lang.Boolean  __default_card ;
	protected java.lang.Boolean  __enabled ;
	protected java.lang.Integer  __currency_type ;
	protected java.lang.Integer  __cmbc_code_id ;
	protected java.lang.Boolean  __true_payment ;
	protected java.lang.String  __bank_name ;
}
