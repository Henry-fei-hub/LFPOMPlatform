package pomplatform.itemCollection.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMItemCollection extends GenericCondition{

	public ConditionMItemCollection(){
		setParameterCount(9);
	}

	public java.util.Date getMinCreateTime() {
		return this.__min_create_time;
	}

	public void setMinCreateTime( java.util.Date value ) {
		this.__min_create_time = value;
	}

	public java.util.Date getMaxCreateTime() {
		return this.__max_create_time;
	}

	public void setMaxCreateTime( java.util.Date value ) {
		this.__max_create_time = value;
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	public java.lang.String getOtherName() {
		return this.__other_name == null ? null : (this.__other_name.indexOf("%") >= 0 ? this.__other_name : "%"+this.__other_name+"%");
	}

	public void setOtherName( java.lang.String value ) {
		this.__other_name = value;
	}

	public java.lang.String getOtherBankAccount() {
		return this.__other_bank_account == null ? null : (this.__other_bank_account.indexOf("%") >= 0 ? this.__other_bank_account : "%"+this.__other_bank_account+"%");
	}

	public void setOtherBankAccount( java.lang.String value ) {
		this.__other_bank_account = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}
	
	public java.lang.Boolean getHasContractParagraph() {
		return this.__has_contract_paragraph;
	}

	public void setHasContractParagraph( java.lang.Boolean value ) {
		this.__has_contract_paragraph = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getHasContractParagraph() != null) sb.append(__wrapBoolean(1, "hasContractParagraph", getHasContractParagraph()));
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(1, "moneyAttribute", getMoneyAttribute()));
		if(getSelfName() != null) sb.append(__wrapNumber(1, "selfName", getSelfName()));
		if(getOtherName() != null) sb.append(__wrapString(1, "otherName", getOtherName()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(1, "otherBankAccount", getOtherBankAccount()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("hasContractParagraph")) != null) setHasContractParagraph(__getBoolean(val)); 
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
		if((val = values.get("otherName")) != null) setOtherName(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
	}

	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.lang.Integer __money_attribute = null;
	private java.lang.Integer __self_name = null;
	private java.lang.String __other_name = null;
	private java.lang.String __other_bank_account = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Boolean __has_contract_paragraph=null;
}

