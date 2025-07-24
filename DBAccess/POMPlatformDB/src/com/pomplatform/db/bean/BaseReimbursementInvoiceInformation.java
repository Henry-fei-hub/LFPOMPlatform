package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseReimbursementInvoiceInformation extends GenericBase implements BaseFactory<BaseReimbursementInvoiceInformation>, Comparable<BaseReimbursementInvoiceInformation> 
{


	public static BaseReimbursementInvoiceInformation newInstance(){
		return new BaseReimbursementInvoiceInformation();
	}

	@Override
	public BaseReimbursementInvoiceInformation make(){
		BaseReimbursementInvoiceInformation b = new BaseReimbursementInvoiceInformation();
		return b;
	}

	public final static java.lang.String CS_REIMBURSEMENT_INVOICE_INFORMATION_ID = "reimbursement_invoice_information_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_DETAIL_ID = "detail_id" ;
	public final static java.lang.String CS_INVOICE_TYPE = "invoice_type" ;
	public final static java.lang.String CS_INVOICE_CODE = "invoice_code" ;
	public final static java.lang.String CS_INVOICE_NUMBER = "invoice_number" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_TAX_RATE = "tax_rate" ;
	public final static java.lang.String CS_TAX_AMOUNT = "tax_amount" ;
	public final static java.lang.String CS_SUBTRACT_AMOUNT = "subtract_amount" ;
	public final static java.lang.String CS_SUBTRACT_REMARK = "subtract_remark" ;
	public final static java.lang.String CS_CREATOR = "creator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_INVOICE_QUANTITY = "invoice_quantity" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,流程类型,流程业务主键,父表主键(实际主表),票类,发票代码,发票号码,票面金额(价税合计),税率,税额,扣除金额,扣除,创建人,创建时间,发票数量";

	public java.lang.Integer getReimbursementInvoiceInformationId() {
		return this.__reimbursement_invoice_information_id;
	}

	public void setReimbursementInvoiceInformationId( java.lang.Integer value ) {
		this.__reimbursement_invoice_information_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getDetailId() {
		return this.__detail_id;
	}

	public void setDetailId( java.lang.Integer value ) {
		this.__detail_id = value;
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

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.lang.Integer getTaxRate() {
		return this.__tax_rate;
	}

	public void setTaxRate( java.lang.Integer value ) {
		this.__tax_rate = value;
	}

	public java.math.BigDecimal getTaxAmount() {
		return this.__tax_amount;
	}

	public void setTaxAmount( java.math.BigDecimal value ) {
		this.__tax_amount = value;
	}

	public java.math.BigDecimal getSubtractAmount() {
		return this.__subtract_amount;
	}

	public void setSubtractAmount( java.math.BigDecimal value ) {
		this.__subtract_amount = value;
	}

	public java.lang.String getSubtractRemark() {
		return this.__subtract_remark;
	}

	public void setSubtractRemark( java.lang.String value ) {
		this.__subtract_remark = value;
	}

	public java.lang.Integer getCreator() {
		return this.__creator;
	}

	public void setCreator( java.lang.Integer value ) {
		this.__creator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getInvoiceQuantity() {
		return this.__invoice_quantity;
	}

	public void setInvoiceQuantity( java.lang.Integer value ) {
		this.__invoice_quantity = value;
	}

	public void cloneCopy(BaseReimbursementInvoiceInformation __bean){
		__bean.setReimbursementInvoiceInformationId(getReimbursementInvoiceInformationId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setDetailId(getDetailId());
		__bean.setInvoiceType(getInvoiceType());
		__bean.setInvoiceCode(getInvoiceCode());
		__bean.setInvoiceNumber(getInvoiceNumber());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setTaxRate(getTaxRate());
		__bean.setTaxAmount(getTaxAmount());
		__bean.setSubtractAmount(getSubtractAmount());
		__bean.setSubtractRemark(getSubtractRemark());
		__bean.setCreator(getCreator());
		__bean.setCreateTime(getCreateTime());
		__bean.setInvoiceQuantity(getInvoiceQuantity());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReimbursementInvoiceInformationId() == null ? "" : getReimbursementInvoiceInformationId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getDetailId() == null ? "" : getDetailId());
		sb.append(",");
		sb.append(getInvoiceType() == null ? "" : getInvoiceType());
		sb.append(",");
		sb.append(getInvoiceCode() == null ? "" : getInvoiceCode());
		sb.append(",");
		sb.append(getInvoiceNumber() == null ? "" : getInvoiceNumber());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getTaxRate() == null ? "" : getTaxRate());
		sb.append(",");
		sb.append(getTaxAmount() == null ? "" : getTaxAmount());
		sb.append(",");
		sb.append(getSubtractAmount() == null ? "" : getSubtractAmount());
		sb.append(",");
		sb.append(getSubtractRemark() == null ? "" : getSubtractRemark());
		sb.append(",");
		sb.append(getCreator() == null ? "" : getCreator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getInvoiceQuantity() == null ? "" : getInvoiceQuantity());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReimbursementInvoiceInformation o) {
		return __reimbursement_invoice_information_id == null ? -1 : __reimbursement_invoice_information_id.compareTo(o.getReimbursementInvoiceInformationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_invoice_information_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__detail_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_type);
		hash = 97 * hash + Objects.hashCode(this.__invoice_code);
		hash = 97 * hash + Objects.hashCode(this.__invoice_number);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__tax_rate);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__subtract_amount);
		hash = 97 * hash + Objects.hashCode(this.__subtract_remark);
		hash = 97 * hash + Objects.hashCode(this.__creator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__invoice_quantity);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReimbursementInvoiceInformation o = (BaseReimbursementInvoiceInformation)obj;
		if(!Objects.equals(this.__reimbursement_invoice_information_id, o.getReimbursementInvoiceInformationId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__detail_id, o.getDetailId())) return false;
		if(!Objects.equals(this.__invoice_type, o.getInvoiceType())) return false;
		if(!Objects.equals(this.__invoice_code, o.getInvoiceCode())) return false;
		if(!Objects.equals(this.__invoice_number, o.getInvoiceNumber())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__tax_rate, o.getTaxRate())) return false;
		if(!Objects.equals(this.__tax_amount, o.getTaxAmount())) return false;
		if(!Objects.equals(this.__subtract_amount, o.getSubtractAmount())) return false;
		if(!Objects.equals(this.__subtract_remark, o.getSubtractRemark())) return false;
		if(!Objects.equals(this.__creator, o.getCreator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__invoice_quantity, o.getInvoiceQuantity())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReimbursementInvoiceInformationId() != null) sb.append(__wrapNumber(count++, "reimbursementInvoiceInformationId", getReimbursementInvoiceInformationId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getDetailId() != null) sb.append(__wrapNumber(count++, "detailId", getDetailId()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(count++, "invoiceType", getInvoiceType()));
		if(getInvoiceCode() != null) sb.append(__wrapString(count++, "invoiceCode", getInvoiceCode()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(count++, "invoiceNumber", getInvoiceNumber()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getTaxRate() != null) sb.append(__wrapNumber(count++, "taxRate", getTaxRate()));
		if(getTaxAmount() != null) sb.append(__wrapDecimal(count++, "taxAmount", getTaxAmount()));
		if(getSubtractAmount() != null) sb.append(__wrapDecimal(count++, "subtractAmount", getSubtractAmount()));
		if(getSubtractRemark() != null) sb.append(__wrapString(count++, "subtractRemark", getSubtractRemark()));
		if(getCreator() != null) sb.append(__wrapNumber(count++, "creator", getCreator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getInvoiceQuantity() != null) sb.append(__wrapNumber(count++, "invoiceQuantity", getInvoiceQuantity()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getReimbursementInvoiceInformationId() != null) res.put("reimbursementInvoiceInformationId", getReimbursementInvoiceInformationId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getDetailId() != null) res.put("detailId", getDetailId());
		if(getInvoiceType() != null) res.put("invoiceType", getInvoiceType());
		if(getInvoiceCode() != null) res.put("invoiceCode", getInvoiceCode());
		if(getInvoiceNumber() != null) res.put("invoiceNumber", getInvoiceNumber());
		if(getTotalAmount() != null) res.put("totalAmount", getTotalAmount());
		if(getTaxRate() != null) res.put("taxRate", getTaxRate());
		if(getTaxAmount() != null) res.put("taxAmount", getTaxAmount());
		if(getSubtractAmount() != null) res.put("subtractAmount", getSubtractAmount());
		if(getSubtractRemark() != null) res.put("subtractRemark", getSubtractRemark());
		if(getCreator() != null) res.put("creator", getCreator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getInvoiceQuantity() != null) res.put("invoiceQuantity", getInvoiceQuantity());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("reimbursementInvoiceInformationId")) != null) setReimbursementInvoiceInformationId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("detailId")) != null) setDetailId(__getInt(val)); 
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("invoiceCode")) != null) setInvoiceCode(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("taxRate")) != null) setTaxRate(__getInt(val)); 
		if((val = values.get("taxAmount")) != null) setTaxAmount(__getDecimal(val));  
		if((val = values.get("subtractAmount")) != null) setSubtractAmount(__getDecimal(val));  
		if((val = values.get("subtractRemark")) != null) setSubtractRemark(__getString(val));
		if((val = values.get("creator")) != null) setCreator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("invoiceQuantity")) != null) setInvoiceQuantity(__getInt(val)); 
	}

	protected java.lang.Integer  __reimbursement_invoice_information_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __detail_id ;
	protected java.lang.Integer  __invoice_type ;
	protected java.lang.String  __invoice_code ;
	protected java.lang.String  __invoice_number ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.lang.Integer  __tax_rate ;
	protected java.math.BigDecimal  __tax_amount ;
	protected java.math.BigDecimal  __subtract_amount ;
	protected java.lang.String  __subtract_remark ;
	protected java.lang.Integer  __creator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __invoice_quantity ;
}
