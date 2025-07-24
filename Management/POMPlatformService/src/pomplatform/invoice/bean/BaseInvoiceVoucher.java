package pomplatform.invoice.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseInvoiceVoucher extends GenericBase implements BaseFactory<BaseInvoiceVoucher>, Comparable<BaseInvoiceVoucher> 
{


	public static BaseInvoiceVoucher newInstance(){
		return new BaseInvoiceVoucher();
	}

	@Override
	public BaseInvoiceVoucher make(){
		BaseInvoiceVoucher b = new BaseInvoiceVoucher();
		return b;
	}

	public final static java.lang.String CS_INVOICE_ID = "invoice_id" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_TAX_RATE = "tax_rate" ;
	public final static java.lang.String CS_NO_TAX_AMOUNT = "no_tax_amount" ;
	public final static java.lang.String CS_OUTPUT_TAX = "output_tax" ;
	public final static java.lang.String CS_INVOICE_DATE = "invoice_date" ;
	public final static java.lang.String CS_INVALID_REMARK = "invalid_remark" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "开发票 编码,主订单名称,客户编码,客户名称,开票金额,税率,不含税金额,销项税,开票日期,备注,购票公司";
	
	public java.lang.Integer getInvoiceId() {
		return this.__invoice_id;
	}

	public void setInvoiceId( java.lang.Integer value ) {
		this.__invoice_id = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
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

	public java.lang.String getInvalidRemark() {
		return this.__invalid_remark;
	}

	public void setInvalidRemark( java.lang.String value ) {
		this.__invalid_remark = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getInvoiceNumber() {
		return __invoice_number;
	}

	public void setInvoiceNumber(java.lang.String __invoice_number) {
		this.__invoice_number = __invoice_number;
	}

	public void cloneCopy(BaseInvoiceVoucher __bean){
		__bean.setInvoiceId(getInvoiceId());
		__bean.setContractName(getContractName());
		__bean.setCustomerId(getCustomerId());
		__bean.setCustomerName(getCustomerName());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setTaxRate(getTaxRate());
		__bean.setNoTaxAmount(getNoTaxAmount());
		__bean.setOutputTax(getOutputTax());
		__bean.setInvoiceDate(getInvoiceDate());
		__bean.setInvalidRemark(getInvalidRemark());
		__bean.setCompanyId(getCompanyId());
		__bean.setInvoiceNumber(getInvoiceNumber());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInvoiceId() == null ? "" : getInvoiceId());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getCustomerId() == null ? "" : getCustomerId());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
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
		sb.append(getInvalidRemark() == null ? "" : getInvalidRemark());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInvoiceVoucher o) {
		return __invoice_id == null ? -1 : __invoice_id.compareTo(o.getInvoiceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__invoice_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__tax_rate);
		hash = 97 * hash + Objects.hashCode(this.__no_tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__output_tax);
		hash = 97 * hash + Objects.hashCode(this.__invoice_date);
		hash = 97 * hash + Objects.hashCode(this.__invalid_remark);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_number);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInvoiceVoucher o = (BaseInvoiceVoucher)obj;
		if(!Objects.equals(this.__invoice_id, o.getInvoiceId())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__tax_rate, o.getTaxRate())) return false;
		if(!Objects.equals(this.__no_tax_amount, o.getNoTaxAmount())) return false;
		if(!Objects.equals(this.__output_tax, o.getOutputTax())) return false;
		if(!Objects.equals(this.__invoice_date, o.getInvoiceDate())) return false;
		if(!Objects.equals(this.__invalid_remark, o.getInvalidRemark())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__invoice_number, o.getInvoiceNumber())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInvoiceId() != null) sb.append(__wrapNumber(count++, "invoiceId", getInvoiceId()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getTaxRate() != null) sb.append(__wrapDecimal(count++, "taxRate", getTaxRate()));
		if(getNoTaxAmount() != null) sb.append(__wrapDecimal(count++, "noTaxAmount", getNoTaxAmount()));
		if(getOutputTax() != null) sb.append(__wrapDecimal(count++, "outputTax", getOutputTax()));
		if(getInvoiceDate() != null) sb.append(__wrapDate(count++, "invoiceDate", getInvoiceDate()));
		if(getInvalidRemark() != null) sb.append(__wrapString(count++, "invalidRemark", getInvalidRemark()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(count++, "invoiceNumber", getInvoiceNumber()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("invoiceId")) != null) setInvoiceId(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("taxRate")) != null) setTaxRate(__getDecimal(val));  
		if((val = values.get("noTaxAmount")) != null) setNoTaxAmount(__getDecimal(val));  
		if((val = values.get("outputTax")) != null) setOutputTax(__getDecimal(val));  
		if((val = values.get("invoiceDate")) != null) setInvoiceDate(__getDate(val)); 
		if((val = values.get("invalidRemark")) != null) setInvalidRemark(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
	}

	protected java.lang.Integer  __invoice_id ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __customer_id ;
	protected java.lang.String  __customer_name ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __tax_rate ;
	protected java.math.BigDecimal  __no_tax_amount ;
	protected java.math.BigDecimal  __output_tax ;
	protected java.util.Date  __invoice_date ;
	protected java.lang.String  __invalid_remark ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String __invoice_number;
}
