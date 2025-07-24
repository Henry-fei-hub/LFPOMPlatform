package pomplatform.stageinvoiceattachment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseStageInvoiceAttachment extends GenericBase implements BaseFactory<BaseStageInvoiceAttachment>, Comparable<BaseStageInvoiceAttachment> 
{


	public static BaseStageInvoiceAttachment newInstance(){
		return new BaseStageInvoiceAttachment();
	}

	@Override
	public BaseStageInvoiceAttachment make(){
		BaseStageInvoiceAttachment b = new BaseStageInvoiceAttachment();
		return b;
	}

	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_TAX_RATE = "tax_rate" ;
	public final static java.lang.String CS_NO_TAX_AMOUNT = "no_tax_amount" ;
	public final static java.lang.String CS_INVOICE_DATE = "invoice_date" ;
	public final static java.lang.String CS_SIGN = "sign" ;

	public final static java.lang.String ALL_CAPTIONS = "开票金额,税率,不含税金额,开票日期,发票状态";

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

	public java.util.Date getInvoiceDate() {
		return this.__invoice_date;
	}

	public void setInvoiceDate( java.util.Date value ) {
		this.__invoice_date = value;
	}

	public java.lang.Integer getSign() {
		return this.__sign;
	}

	public void setSign( java.lang.Integer value ) {
		this.__sign = value;
	}

	public void cloneCopy(BaseStageInvoiceAttachment __bean){
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setTaxRate(getTaxRate());
		__bean.setNoTaxAmount(getNoTaxAmount());
		__bean.setInvoiceDate(getInvoiceDate());
		__bean.setSign(getSign());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getTaxRate() == null ? "" : getTaxRate());
		sb.append(",");
		sb.append(getNoTaxAmount() == null ? "" : getNoTaxAmount());
		sb.append(",");
		sb.append(getInvoiceDate() == null ? "" : sdf.format(getInvoiceDate()));
		sb.append(",");
		sb.append(getSign() == null ? "" : getSign());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStageInvoiceAttachment o) {
		return __invoice_amount == null ? -1 : __invoice_amount.compareTo(o.getInvoiceAmount());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__tax_rate);
		hash = 97 * hash + Objects.hashCode(this.__no_tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__invoice_date);
		hash = 97 * hash + Objects.hashCode(this.__sign);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStageInvoiceAttachment o = (BaseStageInvoiceAttachment)obj;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__tax_rate, o.getTaxRate())) return false;
		if(!Objects.equals(this.__no_tax_amount, o.getNoTaxAmount())) return false;
		if(!Objects.equals(this.__invoice_date, o.getInvoiceDate())) return false;
		if(!Objects.equals(this.__sign, o.getSign())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getTaxRate() != null) sb.append(__wrapDecimal(count++, "taxRate", getTaxRate()));
		if(getNoTaxAmount() != null) sb.append(__wrapDecimal(count++, "noTaxAmount", getNoTaxAmount()));
		if(getInvoiceDate() != null) sb.append(__wrapDate(count++, "invoiceDate", getInvoiceDate()));
		if(getSign() != null) sb.append(__wrapNumber(count++, "sign", getSign()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("taxRate")) != null) setTaxRate(__getDecimal(val));  
		if((val = values.get("noTaxAmount")) != null) setNoTaxAmount(__getDecimal(val));  
		if((val = values.get("invoiceDate")) != null) setInvoiceDate(__getDate(val)); 
		if((val = values.get("sign")) != null) setSign(__getInt(val)); 
	}

	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __tax_rate ;
	protected java.math.BigDecimal  __no_tax_amount ;
	protected java.util.Date  __invoice_date ;
	protected java.lang.Integer  __sign ;
}
