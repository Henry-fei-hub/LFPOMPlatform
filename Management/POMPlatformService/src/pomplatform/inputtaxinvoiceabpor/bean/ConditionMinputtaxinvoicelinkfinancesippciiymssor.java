package pomplatform.inputtaxinvoiceabpor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMinputtaxinvoicelinkfinancesippciiymssor extends GenericCondition{

	public ConditionMinputtaxinvoicelinkfinancesippciiymssor(){
		setParameterCount(9);
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
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

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getInvoiceCode() != null) sb.append(__wrapString(1, "invoiceCode", getInvoiceCode()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(1, "invoiceNumber", getInvoiceNumber()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getSalesCode() != null) sb.append(__wrapString(1, "salesCode", getSalesCode()));
		if(getSalesName() != null) sb.append(__wrapString(1, "salesName", getSalesName()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("invoiceCode")) != null) setInvoiceCode(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("salesCode")) != null) setSalesCode(__getString(val));
		if((val = values.get("salesName")) != null) setSalesName(__getString(val));
		if((val = values.get("code")) != null) setCode(__getString(val));
	}

	private java.lang.Integer __process_status = null;
	private java.lang.Integer __company_id = null;
	private java.lang.String __invoice_code = null;
	private java.lang.String __invoice_number = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.String __sales_code = null;
	private java.lang.String __sales_name = null;
	private java.lang.String __code = null;
}

