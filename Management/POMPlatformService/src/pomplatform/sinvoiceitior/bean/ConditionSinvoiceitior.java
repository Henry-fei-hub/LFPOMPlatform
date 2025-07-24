package pomplatform.sinvoiceitior.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSinvoiceitior extends GenericCondition{

	public ConditionSinvoiceitior(){
		setParameterCount(19);
	}

	public java.lang.Integer getInvoiceId() {
		return this.__invoice_id;
	}

	public void setInvoiceId( java.lang.Integer value ) {
		this.__invoice_id = value;
	}

	public java.lang.Integer getTicketingCompany() {
		return this.__ticketing_company;
	}

	public void setTicketingCompany( java.lang.Integer value ) {
		this.__ticketing_company = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getInvoiceType() {
		return this.__invoice_type;
	}

	public void setInvoiceType( java.lang.Integer value ) {
		this.__invoice_type = value;
	}

	public java.lang.Integer getDisableType() {
		return this.__disable_type;
	}

	public void setDisableType( java.lang.Integer value ) {
		this.__disable_type = value;
	}

	public java.lang.Integer getInvoiceExpressId() {
		return this.__invoice_express_id;
	}

	public void setInvoiceExpressId( java.lang.Integer value ) {
		this.__invoice_express_id = value;
	}

	public java.lang.Integer getSign() {
		return this.__sign;
	}

	public void setSign( java.lang.Integer value ) {
		this.__sign = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public java.lang.String getInvoiceCode() {
		return this.__invoice_code == null ? null : (this.__invoice_code.indexOf("%") >= 0 ? this.__invoice_code : "%"+this.__invoice_code+"%");
	}

	public void setInvoiceCode( java.lang.String value ) {
		this.__invoice_code = value;
	}

	public java.lang.String getInvoiceNumber() {
		return this.__invoice_number == null ? null : (this.__invoice_number.indexOf("%") >= 0 ? this.__invoice_number : "%"+this.__invoice_number+"%");
	}

	public void setInvoiceNumber( java.lang.String value ) {
		this.__invoice_number = value;
	}

	public java.util.Date getMinInStockDate() {
		return this.__min_in_stock_date;
	}

	public void setMinInStockDate( java.util.Date value ) {
		this.__min_in_stock_date = value;
	}

	public java.util.Date getMaxInStockDate() {
		return this.__max_in_stock_date;
	}

	public void setMaxInStockDate( java.util.Date value ) {
		this.__max_in_stock_date = value;
	}

	public java.util.Date getMinInvoiceDate() {
		return this.__min_invoice_date;
	}

	public void setMinInvoiceDate( java.util.Date value ) {
		this.__min_invoice_date = value;
	}

	public java.util.Date getMaxInvoiceDate() {
		return this.__max_invoice_date;
	}

	public void setMaxInvoiceDate( java.util.Date value ) {
		this.__max_invoice_date = value;
	}

	public java.math.BigDecimal getMinInvoiceAmount() {
		return this.__min_invoice_amount;
	}

	public void setMinInvoiceAmount( java.math.BigDecimal value ) {
		this.__min_invoice_amount = value;
	}

	public java.math.BigDecimal getMaxInvoiceAmount() {
		return this.__max_invoice_amount;
	}

	public void setMaxInvoiceAmount( java.math.BigDecimal value ) {
		this.__max_invoice_amount = value;
	}
	
	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}
	
	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getInvoiceId() != null) sb.append(__wrapNumber(1, "invoiceId", getInvoiceId()));
		if(getTicketingCompany() != null) sb.append(__wrapNumber(1, "ticketingCompany", getTicketingCompany()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(1, "invoiceType", getInvoiceType()));
		if(getDisableType() != null) sb.append(__wrapNumber(1, "disableType", getDisableType()));
		if(getInvoiceExpressId() != null) sb.append(__wrapNumber(1, "invoiceExpressId", getInvoiceExpressId()));
		if(getSign() != null) sb.append(__wrapNumber(1, "sign", getSign()));
		if(getCustomerId() != null) sb.append(__wrapNumber(1, "customerId", getCustomerId()));
		if(getInvoiceCode() != null) sb.append(__wrapString(1, "invoiceCode", getInvoiceCode()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(1, "invoiceNumber", getInvoiceNumber()));
		if(getMinInStockDate() != null) sb.append(__wrapDate(1, "minInStockDate", getMinInStockDate()));
		if(getMaxInStockDate() != null) sb.append(__wrapDate(1, "maxInStockDate", getMaxInStockDate()));
		if(getMinInvoiceDate() != null) sb.append(__wrapDate(1, "minInvoiceDate", getMinInvoiceDate()));
		if(getMaxInvoiceDate() != null) sb.append(__wrapDate(1, "maxInvoiceDate", getMaxInvoiceDate()));
		if(getMinInvoiceAmount() != null) sb.append(__wrapNumber(1, "minInvoiceAmount", getMinInvoiceAmount()));
		if(getMaxInvoiceAmount() != null) sb.append(__wrapNumber(1, "maxInvoiceAmount", getMaxInvoiceAmount()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("invoiceId")) != null) setInvoiceId(__getInt(val)); 
		if((val = values.get("ticketingCompany")) != null) setTicketingCompany(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("disableType")) != null) setDisableType(__getInt(val)); 
		if((val = values.get("invoiceExpressId")) != null) setInvoiceExpressId(__getInt(val)); 
		if((val = values.get("sign")) != null) setSign(__getInt(val)); 
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val));
		if((val = values.get("invoiceCode")) != null) setInvoiceCode(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("minInStockDate")) != null) setMinInStockDate(__getDate(val)); 
		if((val = values.get("maxInStockDate")) != null) setMaxInStockDate(__getDate(val)); 
		if((val = values.get("minInvoiceDate")) != null) setMinInvoiceDate(__getDate(val)); 
		if((val = values.get("maxInvoiceDate")) != null) setMaxInvoiceDate(__getDate(val)); 
		if((val = values.get("minInvoiceAmount")) != null) setMinInvoiceAmount(__getDecimal(val));  
		if((val = values.get("maxInvoiceAmount")) != null) setMaxInvoiceAmount(__getDecimal(val));  
		if((val = values.get("contractId")) != null) setContractId(__getInt(val));
	}

	private java.lang.Integer __invoice_id = null;
	private java.lang.Integer __ticketing_company = null;
	private java.lang.String __info_code = null;
	private java.lang.String __project_code = null;
	private java.lang.String __contract_code = null;
	private java.lang.Integer __invoice_type = null;
	private java.lang.Integer __disable_type = null;
	private java.lang.Integer __invoice_express_id = null;
	private java.lang.Integer __sign = null;
	private java.lang.Integer __customer_id = null;
	private java.lang.String __invoice_code = null;
	private java.lang.String __invoice_number = null;
	private java.util.Date __min_in_stock_date = null;
	private java.util.Date __max_in_stock_date = null;
	private java.util.Date __min_invoice_date = null;
	private java.util.Date __max_invoice_date = null;
	private java.math.BigDecimal __min_invoice_amount = null;
	private java.math.BigDecimal __max_invoice_amount = null;
	private java.lang.Integer __contract_id = null;
}

