package pomplatform.k3voucher.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionIncomeVoucher extends GenericCondition{

	public ConditionIncomeVoucher(){
		setParameterCount(12);
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getInvoiceNumber() {
		return this.__invoice_number == null ? null : (this.__invoice_number.indexOf("%") >= 0 ? this.__invoice_number : "%"+this.__invoice_number+"%");
	}

	public void setInvoiceNumber( java.lang.String value ) {
		this.__invoice_number = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name == null ? null : (this.__name.indexOf("%") >= 0 ? this.__name : "%"+this.__name+"%");
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.math.BigDecimal getDebitSide() {
		return this.__debit_side;
	}

	public void setDebitSide( java.math.BigDecimal value ) {
		this.__debit_side = value;
	}

	public java.math.BigDecimal getCreditSide() {
		return this.__credit_side;
	}

	public void setCreditSide( java.math.BigDecimal value ) {
		this.__credit_side = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
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

	public java.lang.Boolean getLocked() {
		return __locked;
	}

	public void setLocked(java.lang.Boolean __locked) {
		this.__locked = __locked;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(1, "invoiceNumber", getInvoiceNumber()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(1, "name", getName()));
		if(getDebitSide() != null) sb.append(__wrapNumber(1, "debitSide", getDebitSide()));
		if(getCreditSide() != null) sb.append(__wrapNumber(1, "creditSide", getCreditSide()));
		if(getCustomerId() != null) sb.append(__wrapNumber(1, "customerId", getCustomerId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getLocked() != null) sb.append(__wrapBoolean(1, "locked", getLocked()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("debitSide")) != null) setDebitSide(__getDecimal(val));  
		if((val = values.get("creditSide")) != null) setCreditSide(__getDecimal(val));  
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("locked")) != null) setLocked(__getBoolean(val));
	}

	private java.lang.Integer __company_id = null;
	private java.lang.String __invoice_number = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.String __code = null;
	private java.lang.String __name = null;
	private java.math.BigDecimal __debit_side = null;
	private java.math.BigDecimal __credit_side = null;
	private java.lang.Integer __customer_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Boolean __locked = null;
}

