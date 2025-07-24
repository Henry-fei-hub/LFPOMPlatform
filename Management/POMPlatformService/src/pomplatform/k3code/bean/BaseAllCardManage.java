package pomplatform.k3code.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAllCardManage extends GenericBase implements BaseFactory<BaseAllCardManage>, Comparable<BaseAllCardManage> 
{


	public static BaseAllCardManage newInstance(){
		return new BaseAllCardManage();
	}

	@Override
	public BaseAllCardManage make(){
		BaseAllCardManage b = new BaseAllCardManage();
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

	public final static java.lang.String ALL_CAPTIONS = "主键编码,对象编码,2单位),开户行,银行账号,开户行所在地,2报销卡),是否为默认卡,是否启用,currency_type";

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

	public void cloneCopy(BaseAllCardManage __bean){
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAllCardManage o) {
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAllCardManage o = (BaseAllCardManage)obj;
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
}
