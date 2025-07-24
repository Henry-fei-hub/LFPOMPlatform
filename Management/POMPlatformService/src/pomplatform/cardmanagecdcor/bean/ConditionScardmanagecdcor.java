package pomplatform.cardmanagecdcor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScardmanagecdcor extends GenericCondition{

	public ConditionScardmanagecdcor(){
		setParameterCount(11);
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

	public java.lang.String getBankAccount() {
		return this.__bank_account == null ? null : (this.__bank_account.indexOf("%") >= 0 ? this.__bank_account : "%"+this.__bank_account+"%");
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankAddress() {
		return this.__bank_address == null ? null : (this.__bank_address.indexOf("%") >= 0 ? this.__bank_address : "%"+this.__bank_address+"%");
	}

	public void setBankAddress( java.lang.String value ) {
		this.__bank_address = value;
	}

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

	public java.lang.Boolean getTruePayment() {
		return this.__true_payment;
	}

	public void setTruePayment( java.lang.Boolean value ) {
		this.__true_payment = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCardType() != null) sb.append(__wrapNumber(1, "cardType", getCardType()));
		if(getDefaultCard() != null) sb.append(__wrapBoolean(1, "defaultCard", getDefaultCard()));
		if(getCurrencyType() != null) sb.append(__wrapNumber(1, "currencyType", getCurrencyType()));
		if(getCmbcCodeId() != null) sb.append(__wrapNumber(1, "cmbcCodeId", getCmbcCodeId()));
		if(getBankAccount() != null) sb.append(__wrapString(1, "bankAccount", getBankAccount()));
		if(getBankAddress() != null) sb.append(__wrapString(1, "bankAddress", getBankAddress()));
		if(getCardManageId() != null) sb.append(__wrapNumber(1, "cardManageId", getCardManageId()));
		if(getObjectId() != null) sb.append(__wrapNumber(1, "objectId", getObjectId()));
		if(getObjectType() != null) sb.append(__wrapNumber(1, "objectType", getObjectType()));
		if(getBankId() != null) sb.append(__wrapNumber(1, "bankId", getBankId()));
		if(getTruePayment() != null) sb.append(__wrapBoolean(1, "truePayment", getTruePayment()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("cardType")) != null) setCardType(__getInt(val)); 
		if((val = values.get("defaultCard")) != null) setDefaultCard(__getBoolean(val));
		if((val = values.get("currencyType")) != null) setCurrencyType(__getInt(val)); 
		if((val = values.get("cmbcCodeId")) != null) setCmbcCodeId(__getInt(val)); 
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankAddress")) != null) setBankAddress(__getString(val));
		if((val = values.get("cardManageId")) != null) setCardManageId(__getInt(val)); 
		if((val = values.get("objectId")) != null) setObjectId(__getInt(val)); 
		if((val = values.get("objectType")) != null) setObjectType(__getInt(val)); 
		if((val = values.get("bankId")) != null) setBankId(__getInt(val)); 
		if((val = values.get("truePayment")) != null) setTruePayment(__getBoolean(val));
	}

	private java.lang.Integer __card_type = null;
	private java.lang.Boolean __default_card = null;
	private java.lang.Integer __currency_type = null;
	private java.lang.Integer __cmbc_code_id = null;
	private java.lang.String __bank_account = null;
	private java.lang.String __bank_address = null;
	private java.lang.Integer __card_manage_id = null;
	private java.lang.Integer __object_id = null;
	private java.lang.Integer __object_type = null;
	private java.lang.Integer __bank_id = null;
	private java.lang.Boolean __true_payment = null;
}

