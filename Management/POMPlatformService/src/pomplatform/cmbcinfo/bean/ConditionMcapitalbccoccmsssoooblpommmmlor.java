package pomplatform.cmbcinfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcapitalbccoccmsssoooblpommmmlor extends GenericCondition{

	public ConditionMcapitalbccoccmsssoooblpommmmlor(){
		setParameterCount(22);
	}

	public java.lang.Integer getLinkType() {
		return __link_type;
	}

	public void setLinkType(java.lang.Integer value) {
		this.__link_type = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Integer getCapitalType() {
		return this.__capital_type;
	}

	public void setCapitalType( java.lang.Integer value ) {
		this.__capital_type = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
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

	public java.lang.String getSelfBankName() {
		return this.__self_bank_name == null ? null : (this.__self_bank_name.indexOf("%") >= 0 ? this.__self_bank_name : "%"+this.__self_bank_name+"%");
	}

	public void setSelfBankName( java.lang.String value ) {
		this.__self_bank_name = value;
	}

	public java.lang.String getSelfBankAccount() {
		return this.__self_bank_account == null ? null : (this.__self_bank_account.indexOf("%") >= 0 ? this.__self_bank_account : "%"+this.__self_bank_account+"%");
	}

	public void setSelfBankAccount( java.lang.String value ) {
		this.__self_bank_account = value;
	}

	public java.lang.String getOtherName() {
		return this.__other_name == null ? null : (this.__other_name.indexOf("%") >= 0 ? this.__other_name : "%"+this.__other_name+"%");
	}

	public void setOtherName( java.lang.String value ) {
		this.__other_name = value;
	}

	public java.lang.String getOtherBankName() {
		return this.__other_bank_name == null ? null : (this.__other_bank_name.indexOf("%") >= 0 ? this.__other_bank_name : "%"+this.__other_bank_name+"%");
	}

	public void setOtherBankName( java.lang.String value ) {
		this.__other_bank_name = value;
	}

	public java.lang.String getOtherBankAccount() {
		return this.__other_bank_account == null ? null : (this.__other_bank_account.indexOf("%") >= 0 ? this.__other_bank_account : "%"+this.__other_bank_account+"%");
	}

	public void setOtherBankAccount( java.lang.String value ) {
		this.__other_bank_account = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.math.BigDecimal getLoanMoney() {
		return this.__loan_money;
	}

	public void setLoanMoney( java.math.BigDecimal value ) {
		this.__loan_money = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.math.BigDecimal getOriginalCurrency() {
		return this.__original_currency;
	}

	public void setOriginalCurrency( java.math.BigDecimal value ) {
		this.__original_currency = value;
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

	public java.util.Date getMinCreateDate() {
		return this.__min_create_date;
	}

	public void setMinCreateDate( java.util.Date value ) {
		this.__min_create_date = value;
	}

	public java.util.Date getMaxCreateDate() {
		return this.__max_create_date;
	}

	public void setMaxCreateDate( java.util.Date value ) {
		this.__max_create_date = value;
	}

	public java.lang.Integer getLinkNum() {
		return this.__link_num;
	}

	public void setLinkNum( java.lang.Integer value ) {
		this.__link_num = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getLinkType() != null) sb.append(__wrapNumber(1, "linkType", getLinkType()));
		if(getCapitalId() != null) sb.append(__wrapNumber(1, "capitalId", getCapitalId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getOperator() != null) sb.append(__wrapNumber(1, "operator", getOperator()));
		if(getCapitalType() != null) sb.append(__wrapNumber(1, "capitalType", getCapitalType()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(1, "moneyAttribute", getMoneyAttribute()));
		if(getSelfName() != null) sb.append(__wrapNumber(1, "selfName", getSelfName()));
		if(getSelfBankName() != null) sb.append(__wrapString(1, "selfBankName", getSelfBankName()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(1, "selfBankAccount", getSelfBankAccount()));
		if(getOtherName() != null) sb.append(__wrapString(1, "otherName", getOtherName()));
		if(getOtherBankName() != null) sb.append(__wrapString(1, "otherBankName", getOtherBankName()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(1, "otherBankAccount", getOtherBankAccount()));
		if(getBorrowMoney() != null) sb.append(__wrapNumber(1, "borrowMoney", getBorrowMoney()));
		if(getLoanMoney() != null) sb.append(__wrapNumber(1, "loanMoney", getLoanMoney()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getOriginalCurrency() != null) sb.append(__wrapNumber(1, "originalCurrency", getOriginalCurrency()));
		if(getMinHappenDate() != null) sb.append(__wrapDate(1, "minHappenDate", getMinHappenDate()));
		if(getMaxHappenDate() != null) sb.append(__wrapDate(1, "maxHappenDate", getMaxHappenDate()));
		if(getMinCreateDate() != null) sb.append(__wrapDate(1, "minCreateDate", getMinCreateDate()));
		if(getMaxCreateDate() != null) sb.append(__wrapDate(1, "maxCreateDate", getMaxCreateDate()));
		if(getLinkNum() != null) sb.append(__wrapNumber(1, "linkNum", getLinkNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("linkType")) != null) setLinkType(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("capitalType")) != null) setCapitalType(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
		if((val = values.get("selfBankName")) != null) setSelfBankName(__getString(val));
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("otherName")) != null) setOtherName(__getString(val));
		if((val = values.get("otherBankName")) != null) setOtherBankName(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("loanMoney")) != null) setLoanMoney(__getDecimal(val));  
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("originalCurrency")) != null) setOriginalCurrency(__getDecimal(val));  
		if((val = values.get("minHappenDate")) != null) setMinHappenDate(__getDate(val)); 
		if((val = values.get("maxHappenDate")) != null) setMaxHappenDate(__getDate(val)); 
		if((val = values.get("minCreateDate")) != null) setMinCreateDate(__getDate(val)); 
		if((val = values.get("maxCreateDate")) != null) setMaxCreateDate(__getDate(val)); 
		if((val = values.get("linkNum")) != null) setLinkNum(__getInt(val)); 
	}

	private java.lang.Integer __link_type = null;
	private java.lang.Integer __capital_id = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __operator = null;
	private java.lang.Integer __capital_type = null;
	private java.lang.String __contract_code = null;
	private java.lang.Integer __money_attribute = null;
	private java.lang.Integer __self_name = null;
	private java.lang.String __self_bank_name = null;
	private java.lang.String __self_bank_account = null;
	private java.lang.String __other_name = null;
	private java.lang.String __other_bank_name = null;
	private java.lang.String __other_bank_account = null;
	private java.math.BigDecimal __borrow_money = null;
	private java.math.BigDecimal __loan_money = null;
	private java.lang.Integer __process_status = null;
	private java.math.BigDecimal __original_currency = null;
	private java.util.Date __min_happen_date = null;
	private java.util.Date __max_happen_date = null;
	private java.util.Date __min_create_date = null;
	private java.util.Date __max_create_date = null;
	private java.lang.Integer __link_num = null;
}

