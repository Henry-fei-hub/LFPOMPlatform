package pomplatform.finance.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionInvoiceAndPayment extends GenericCondition{

	public ConditionInvoiceAndPayment(){
		setParameterCount(16);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getHappenYear() {
		return this.__happen_year;
	}

	public void setHappenYear( java.lang.Integer value ) {
		this.__happen_year = value;
	}

	public java.lang.Integer getHappenMonth() {
		return this.__happen_month;
	}

	public void setHappenMonth( java.lang.Integer value ) {
		this.__happen_month = value;
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

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Boolean getHasInvoices() {
		return this.__has_invoices;
	}

	public void setHasInvoices( java.lang.Boolean value ) {
		this.__has_invoices = value;
	}

	public java.lang.Boolean getHasContractReceivable() {
		return this.__has_contract_receivable;
	}

	public void setHasContractReceivable( java.lang.Boolean value ) {
		this.__has_contract_receivable = value;
	}

	public java.lang.Boolean getHasDistributionCollection() {
		return this.__has_distribution_collection;
	}

	public void setHasDistributionCollection( java.lang.Boolean value ) {
		this.__has_distribution_collection = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
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

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.lang.Boolean getHaveVoucher() {
		return this.__have_voucher;
	}

	public void setHaveVoucher( java.lang.Boolean value ) {
		this.__have_voucher = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getOtherName() != null) sb.append(__wrapString(1, "otherName", getOtherName()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(1, "otherBankAccount", getOtherBankAccount()));
		if(getSelfName() != null) sb.append(__wrapNumber(1, "selfName", getSelfName()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(1, "moneyAttribute", getMoneyAttribute()));
		if(getHasInvoices() != null) sb.append(__wrapBoolean(1, "hasInvoices", getHasInvoices()));
		if(getHasContractReceivable() != null) sb.append(__wrapBoolean(1, "hasContractReceivable", getHasContractReceivable()));
		if(getHasDistributionCollection() != null) sb.append(__wrapBoolean(1, "hasDistributionCollection", getHasDistributionCollection()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getBorrowMoney() != null) sb.append(__wrapNumber(1, "borrowMoney", getBorrowMoney()));
		if(getHaveVoucher() != null) sb.append(__wrapBoolean(1, "haveVoucher", getHaveVoucher()));
		if (getHappenYear() != null) sb.append((__wrapNumber(1, "happenYear", getHappenYear())));
		if (getHappenMonth() != null) sb.append((__wrapNumber(1, "happenMonth", getHappenMonth())));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("otherName")) != null) setOtherName(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("hasInvoices")) != null) setHasInvoices(__getBoolean(val));
		if((val = values.get("hasContractReceivable")) != null) setHasContractReceivable(__getBoolean(val));
		if((val = values.get("hasDistributionCollection")) != null) setHasDistributionCollection(__getBoolean(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("haveVoucher")) != null) setHaveVoucher(__getBoolean(val));
		if ((val = values.get("happenYear")) != null) setHappenYear(__getInt(val));
		if ((val = values.get("happenMonth")) != null) setHappenMonth(__getInt(val));
	}

	private java.lang.Integer __contract_id = null;
	private java.lang.String __other_name = null;
	private java.lang.String __other_bank_account = null;
	private java.lang.Integer __self_name = null;
	private java.lang.Integer __money_attribute = null;
	private java.lang.Boolean __has_invoices = null;
	private java.lang.Boolean __has_contract_receivable = null;
	private java.lang.Boolean __has_distribution_collection = null;
	private java.lang.Integer __process_status = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.math.BigDecimal __borrow_money = null;
	private java.lang.Boolean __have_voucher = null;
	private java.lang.Integer __happen_year = null;
	private java.lang.Integer __happen_month = null;
}

