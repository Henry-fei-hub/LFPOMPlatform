package pomplatform.mcapitalcmmssmssbor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcapitalcmmssmssbor extends GenericCondition{

	public ConditionMcapitalcmmssmssbor(){
		setParameterCount(5);
	}

	public java.util.Date getMinHappenDate() {
		return this.__min_happen_date;
	}

	public void setMinHappenDate( java.util.Date value ) {
		this.__min_happen_date = value;
	}

	public java.util.Date getMaxHappenDate() {
		return this.__max_happen_date;
	}

	public void setMaxHappenDate( java.util.Date value ) {
		this.__max_happen_date = value;
	}

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	public java.lang.String getSelfBankAccount() {
		return this.__self_bank_account == null ? null : (this.__self_bank_account.indexOf("%") >= 0 ? this.__self_bank_account : "%"+this.__self_bank_account+"%");
	}

	public void setSelfBankAccount( java.lang.String value ) {
		this.__self_bank_account = value;
	}

	public java.lang.String getBankAddress() {
		return this.__bank_address == null ? null : (this.__bank_address.indexOf("%") >= 0 ? this.__bank_address : "%"+this.__bank_address+"%");
	}

	public void setBankAddress( java.lang.String value ) {
		this.__bank_address = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinHappenDate() != null) sb.append(__wrapDate(1, "minHappenDate", getMinHappenDate()));
		if(getMaxHappenDate() != null) sb.append(__wrapDate(1, "maxHappenDate", getMaxHappenDate()));
		if(getSelfName() != null) sb.append(__wrapNumber(1, "selfName", getSelfName()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(1, "selfBankAccount", getSelfBankAccount()));
		if(getBankAddress() != null) sb.append(__wrapString(1, "bankAddress", getBankAddress()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minHappenDate")) != null) setMinHappenDate(__getDate(val)); 
		if((val = values.get("maxHappenDate")) != null) setMaxHappenDate(__getDate(val)); 
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("bankAddress")) != null) setBankAddress(__getString(val));
	}

	private java.util.Date __min_happen_date = null;
	private java.util.Date __max_happen_date = null;
	private java.lang.Integer __self_name = null;
	private java.lang.String __self_bank_account = null;
	private java.lang.String __bank_address = null;
}

