package pomplatform.attachment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;
import delicacy.common.BaseFactory;
import delicacy.common.BaseHelpUtils;

public class BaseOnUpdateAttachmentLinkInvoices extends GenericBase implements BaseFactory<BaseOnUpdateAttachmentLinkInvoices>, Comparable<BaseOnUpdateAttachmentLinkInvoices> 
{


	public static BaseOnUpdateAttachmentLinkInvoices newInstance(){
		return new BaseOnUpdateAttachmentLinkInvoices();
	}

	@Override
	public BaseOnUpdateAttachmentLinkInvoices make(){
		BaseOnUpdateAttachmentLinkInvoices b = new BaseOnUpdateAttachmentLinkInvoices();
		return b;
	}

	public final static java.lang.String CS_INVOICE_ID = "invoice_id" ;
	public final static java.lang.String CS_INVOICE_TYPE = "invoice_type" ;
	public final static java.lang.String CS_INVOICE_CODE = "invoice_code" ;
	public final static java.lang.String CS_INVOICE_NUMBER = "invoice_number" ;
	public final static java.lang.String CS_TICKETING_COMPANY = "ticketing_company" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_TAX_RATE = "tax_rate" ;
	public final static java.lang.String CS_NO_TAX_AMOUNT = "no_tax_amount" ;
	public final static java.lang.String CS_OUTPUT_TAX = "output_tax" ;
	public final static java.lang.String CS_INVOICE_DATE = "invoice_date" ;
	public final static java.lang.String CS_FLAG_TYPE = "flag_type" ;
	public final static java.lang.String CS_SIGN = "sign" ;
	public final static java.lang.String CS_BIND_AMOUNT = "bind_amount" ;
	public final static java.lang.String CS_FOR_AMOUNT = "for_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "发票编码,发票类型 1专票，2普票 ，3代开,发票代码(10位 每次批量录入是一样),发票号码(8位 规则+1),购票公司,客户名称,开票金额(如 100),税率(如 6%),no_tax_amount,output_tax,开票日期,,3填开作废。当月发票，当月作废。4.负数作废。做了红字，然后又作废。5.空白作废。尚未开具，就直接作废（往往是不慎污染弄脏了，没法使用）,,";

	public java.lang.Integer getInvoiceId() {
		return this.__invoice_id;
	}

	public void setInvoiceId( java.lang.Integer value ) {
		this.__invoice_id = value;
	}

	public java.lang.Integer getInvoiceType() {
		return this.__invoice_type;
	}

	public void setInvoiceType( java.lang.Integer value ) {
		this.__invoice_type = value;
	}

	public java.lang.String getInvoiceCode() {
		return this.__invoice_code;
	}

	public void setInvoiceCode( java.lang.String value ) {
		this.__invoice_code = value;
	}

	public java.lang.String getInvoiceNumber() {
		return this.__invoice_number;
	}

	public void setInvoiceNumber( java.lang.String value ) {
		this.__invoice_number = value;
	}

	public java.lang.Integer getTicketingCompany() {
		return this.__ticketing_company;
	}

	public void setTicketingCompany( java.lang.Integer value ) {
		this.__ticketing_company = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
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

	public java.math.BigDecimal getNoTaxAmount() {
		return this.__no_tax_amount;
	}

	public void setNoTaxAmount( java.math.BigDecimal value ) {
		this.__no_tax_amount = value;
	}

	public java.math.BigDecimal getOutputTax() {
		return this.__output_tax;
	}

	public void setOutputTax( java.math.BigDecimal value ) {
		this.__output_tax = value;
	}

	public java.util.Date getInvoiceDate() {
		return this.__invoice_date;
	}

	public void setInvoiceDate( java.util.Date value ) {
		this.__invoice_date = value;
	}

	public java.lang.Integer getFlagType() {
		return this.__flag_type;
	}

	public void setFlagType( java.lang.Integer value ) {
		this.__flag_type = value;
	}

	public java.lang.Integer getSign() {
		return this.__sign;
	}

	public void setSign( java.lang.Integer value ) {
		this.__sign = value;
	}

	public java.lang.Long getBindAmount() {
		return this.__bind_amount;
	}

	public void setBindAmount( java.lang.Long value ) {
		this.__bind_amount = value;
	}

	public java.lang.Integer getForAmount() {
		return this.__for_amount;
	}

	public void setForAmount( java.lang.Integer value ) {
		this.__for_amount = value;
	}

	public void cloneCopy(BaseOnUpdateAttachmentLinkInvoices __bean){
		__bean.setInvoiceId(getInvoiceId());
		__bean.setInvoiceType(getInvoiceType());
		__bean.setInvoiceCode(getInvoiceCode());
		__bean.setInvoiceNumber(getInvoiceNumber());
		__bean.setTicketingCompany(getTicketingCompany());
		__bean.setCustomerId(getCustomerId());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setTaxRate(getTaxRate());
		__bean.setNoTaxAmount(getNoTaxAmount());
		__bean.setOutputTax(getOutputTax());
		__bean.setInvoiceDate(getInvoiceDate());
		__bean.setFlagType(getFlagType());
		__bean.setSign(getSign());
		__bean.setBindAmount(getBindAmount());
		__bean.setForAmount(getForAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInvoiceId() == null ? "" : getInvoiceId());
		sb.append(",");
		sb.append(getInvoiceType() == null ? "" : getInvoiceType());
		sb.append(",");
		sb.append(getInvoiceCode() == null ? "" : getInvoiceCode());
		sb.append(",");
		sb.append(getInvoiceNumber() == null ? "" : getInvoiceNumber());
		sb.append(",");
		sb.append(getTicketingCompany() == null ? "" : getTicketingCompany());
		sb.append(",");
		String customer = SelectValueCache.getSelectValue("customers", BaseHelpUtils.getString(getCustomerId()));
		sb.append(customer == null ? "" : customer);
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getTaxRate() == null ? "" : getTaxRate());
		sb.append(",");
		sb.append(getNoTaxAmount() == null ? "" : getNoTaxAmount());
		sb.append(",");
		sb.append(getOutputTax() == null ? "" : getOutputTax());
		sb.append(",");
		sb.append(getInvoiceDate() == null ? "" : sdf.format(getInvoiceDate()));
		sb.append(",");
		String strFlagType = SelectValueCache.getSelectValue("", String.valueOf(getFlagType()));
		sb.append(strFlagType == null ? "" : strFlagType);
		sb.append(",");
		sb.append(getSign() == null ? "" : getSign());
		sb.append(",");
		sb.append(getBindAmount() == null ? "" : getBindAmount());
		sb.append(",");
		sb.append(getForAmount() == null ? "" : getForAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnUpdateAttachmentLinkInvoices o) {
		return __invoice_id == null ? -1 : __invoice_id.compareTo(o.getInvoiceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__invoice_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_type);
		hash = 97 * hash + Objects.hashCode(this.__invoice_code);
		hash = 97 * hash + Objects.hashCode(this.__invoice_number);
		hash = 97 * hash + Objects.hashCode(this.__ticketing_company);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__tax_rate);
		hash = 97 * hash + Objects.hashCode(this.__no_tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__output_tax);
		hash = 97 * hash + Objects.hashCode(this.__invoice_date);
		hash = 97 * hash + Objects.hashCode(this.__flag_type);
		hash = 97 * hash + Objects.hashCode(this.__sign);
		hash = 97 * hash + Objects.hashCode(this.__bind_amount);
		hash = 97 * hash + Objects.hashCode(this.__for_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnUpdateAttachmentLinkInvoices o = (BaseOnUpdateAttachmentLinkInvoices)obj;
		if(!Objects.equals(this.__invoice_id, o.getInvoiceId())) return false;
		if(!Objects.equals(this.__invoice_type, o.getInvoiceType())) return false;
		if(!Objects.equals(this.__invoice_code, o.getInvoiceCode())) return false;
		if(!Objects.equals(this.__invoice_number, o.getInvoiceNumber())) return false;
		if(!Objects.equals(this.__ticketing_company, o.getTicketingCompany())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__tax_rate, o.getTaxRate())) return false;
		if(!Objects.equals(this.__no_tax_amount, o.getNoTaxAmount())) return false;
		if(!Objects.equals(this.__output_tax, o.getOutputTax())) return false;
		if(!Objects.equals(this.__invoice_date, o.getInvoiceDate())) return false;
		if(!Objects.equals(this.__flag_type, o.getFlagType())) return false;
		if(!Objects.equals(this.__sign, o.getSign())) return false;
		if(!Objects.equals(this.__bind_amount, o.getBindAmount())) return false;
		if(!Objects.equals(this.__for_amount, o.getForAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInvoiceId() != null) sb.append(__wrapNumber(count++, "invoiceId", getInvoiceId()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(count++, "invoiceType", getInvoiceType()));
		if(getInvoiceCode() != null) sb.append(__wrapString(count++, "invoiceCode", getInvoiceCode()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(count++, "invoiceNumber", getInvoiceNumber()));
		if(getTicketingCompany() != null) sb.append(__wrapNumber(count++, "ticketingCompany", getTicketingCompany()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getTaxRate() != null) sb.append(__wrapDecimal(count++, "taxRate", getTaxRate()));
		if(getNoTaxAmount() != null) sb.append(__wrapDecimal(count++, "noTaxAmount", getNoTaxAmount()));
		if(getOutputTax() != null) sb.append(__wrapDecimal(count++, "outputTax", getOutputTax()));
		if(getInvoiceDate() != null) sb.append(__wrapDate(count++, "invoiceDate", getInvoiceDate()));
		if(getFlagType() != null) sb.append(__wrapNumber(count++, "flagType", getFlagType()));
		if(getSign() != null) sb.append(__wrapNumber(count++, "sign", getSign()));
		if(getBindAmount() != null) sb.append(__wrapNumber(count++, "bindAmount", getBindAmount()));
		if(getForAmount() != null) sb.append(__wrapNumber(count++, "forAmount", getForAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("invoiceId")) != null) setInvoiceId(__getInt(val)); 
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("invoiceCode")) != null) setInvoiceCode(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("ticketingCompany")) != null) setTicketingCompany(__getInt(val)); 
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val));
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("taxRate")) != null) setTaxRate(__getDecimal(val));  
		if((val = values.get("noTaxAmount")) != null) setNoTaxAmount(__getDecimal(val));  
		if((val = values.get("outputTax")) != null) setOutputTax(__getDecimal(val));  
		if((val = values.get("invoiceDate")) != null) setInvoiceDate(__getDate(val)); 
		if((val = values.get("flagType")) != null) setFlagType(__getInt(val)); 
		if((val = values.get("sign")) != null) setSign(__getInt(val)); 
		if((val = values.get("bindAmount")) != null) setBindAmount(__getLong(val)); 
		if((val = values.get("forAmount")) != null) setForAmount(__getInt(val)); 
	}

	protected java.lang.Integer  __invoice_id ;
	protected java.lang.Integer  __invoice_type ;
	protected java.lang.String  __invoice_code ;
	protected java.lang.String  __invoice_number ;
	protected java.lang.Integer  __ticketing_company ;
	protected java.lang.Integer  __customer_id ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __tax_rate ;
	protected java.math.BigDecimal  __no_tax_amount ;
	protected java.math.BigDecimal  __output_tax ;
	protected java.util.Date  __invoice_date ;
	protected java.lang.Integer  __flag_type ;
	protected java.lang.Integer  __sign ;
	protected java.lang.Long  __bind_amount ;
	protected java.lang.Integer  __for_amount ;
}
