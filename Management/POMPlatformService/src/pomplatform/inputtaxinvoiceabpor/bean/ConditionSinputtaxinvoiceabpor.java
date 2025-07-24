package pomplatform.inputtaxinvoiceabpor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSinputtaxinvoiceabpor extends GenericCondition{

	public ConditionSinputtaxinvoiceabpor(){
		setParameterCount(13);
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getSalesCode() {
		return this.__sales_code == null ? null : (this.__sales_code.indexOf("%") >= 0 ? this.__sales_code : "%"+this.__sales_code+"%");
	}

	public void setSalesCode( java.lang.String value ) {
		this.__sales_code = value;
	}

	public java.lang.String getSalesName() {
		return this.__sales_name == null ? null : (this.__sales_name.indexOf("%") >= 0 ? this.__sales_name : "%"+this.__sales_name+"%");
	}

	public void setSalesName( java.lang.String value ) {
		this.__sales_name = value;
	}

	public java.lang.Integer getInputTaxInvoiceId() {
		return this.__input_tax_invoice_id;
	}

	public void setInputTaxInvoiceId( java.lang.Integer value ) {
		this.__input_tax_invoice_id = value;
	}

	public java.lang.Integer getInvoiceType() {
		return this.__invoice_type;
	}

	public void setInvoiceType( java.lang.Integer value ) {
		this.__invoice_type = value;
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

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.math.BigDecimal getTaxRate() {
		return this.__tax_rate;
	}

	public void setTaxRate( java.math.BigDecimal value ) {
		this.__tax_rate = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Boolean getHaveCheck() {
		return this.__have_check;
	}

	public void setHaveCheck( java.lang.Boolean value ) {
		this.__have_check = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getSalesCode() != null) sb.append(__wrapString(1, "salesCode", getSalesCode()));
		if(getSalesName() != null) sb.append(__wrapString(1, "salesName", getSalesName()));
		if(getInputTaxInvoiceId() != null) sb.append(__wrapNumber(1, "inputTaxInvoiceId", getInputTaxInvoiceId()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(1, "invoiceType", getInvoiceType()));
		if(getInvoiceCode() != null) sb.append(__wrapString(1, "invoiceCode", getInvoiceCode()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(1, "invoiceNumber", getInvoiceNumber()));
		if(getInvoiceAmount() != null) sb.append(__wrapNumber(1, "invoiceAmount", getInvoiceAmount()));
		if(getTaxRate() != null) sb.append(__wrapNumber(1, "taxRate", getTaxRate()));
		if(getOperator() != null) sb.append(__wrapNumber(1, "operator", getOperator()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getHaveCheck() != null) sb.append(__wrapBoolean(1, "haveCheck", getHaveCheck()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("salesCode")) != null) setSalesCode(__getString(val));
		if((val = values.get("salesName")) != null) setSalesName(__getString(val));
		if((val = values.get("inputTaxInvoiceId")) != null) setInputTaxInvoiceId(__getInt(val)); 
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("invoiceCode")) != null) setInvoiceCode(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("taxRate")) != null) setTaxRate(__getDecimal(val));  
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("haveCheck")) != null) setHaveCheck(__getBoolean(val));
	}

	private java.lang.String __remark = null;
	private java.lang.String __sales_code = null;
	private java.lang.String __sales_name = null;
	private java.lang.Integer __input_tax_invoice_id = null;
	private java.lang.Integer __invoice_type = null;
	private java.lang.String __invoice_code = null;
	private java.lang.String __invoice_number = null;
	private java.math.BigDecimal __invoice_amount = null;
	private java.math.BigDecimal __tax_rate = null;
	private java.lang.Integer __operator = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Boolean __have_check = null;
}

