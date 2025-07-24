package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseInvoicesToContractReceivable extends GenericBase implements BaseFactory<BaseInvoicesToContractReceivable>, Comparable<BaseInvoicesToContractReceivable> 
{


	public static BaseInvoicesToContractReceivable newInstance(){
		return new BaseInvoicesToContractReceivable();
	}

	@Override
	public BaseInvoicesToContractReceivable make(){
		BaseInvoicesToContractReceivable b = new BaseInvoicesToContractReceivable();
		return b;
	}

	public final static java.lang.String CS_CENTER_ID = "center_id" ;
	public final static java.lang.String CS_CONTRACT_RECEIVABLE_ID = "contract_receivable_id" ;
	public final static java.lang.String CS_INVOICE_ID = "invoice_id" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;

	public final static java.lang.String ALL_CAPTIONS = "中间表id,合同阶段id,发票id,操作人id,创建日期";

	public java.lang.Integer getCenterId() {
		return this.__center_id;
	}

	public void setCenterId( java.lang.Integer value ) {
		this.__center_id = value;
	}

	public java.lang.Integer getContractReceivableId() {
		return this.__contract_receivable_id;
	}

	public void setContractReceivableId( java.lang.Integer value ) {
		this.__contract_receivable_id = value;
	}

	public java.lang.Integer getInvoiceId() {
		return this.__invoice_id;
	}

	public void setInvoiceId( java.lang.Integer value ) {
		this.__invoice_id = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public void cloneCopy(BaseInvoicesToContractReceivable __bean){
		__bean.setCenterId(getCenterId());
		__bean.setContractReceivableId(getContractReceivableId());
		__bean.setInvoiceId(getInvoiceId());
		__bean.setOperator(getOperator());
		__bean.setCreateDate(getCreateDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCenterId() == null ? "" : getCenterId());
		sb.append(",");
		sb.append(getContractReceivableId() == null ? "" : getContractReceivableId());
		sb.append(",");
		sb.append(getInvoiceId() == null ? "" : getInvoiceId());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInvoicesToContractReceivable o) {
		return __center_id == null ? -1 : __center_id.compareTo(o.getCenterId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__center_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_id);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInvoicesToContractReceivable o = (BaseInvoicesToContractReceivable)obj;
		if(!Objects.equals(this.__center_id, o.getCenterId())) return false;
		if(!Objects.equals(this.__contract_receivable_id, o.getContractReceivableId())) return false;
		if(!Objects.equals(this.__invoice_id, o.getInvoiceId())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCenterId() != null) sb.append(__wrapNumber(count++, "centerId", getCenterId()));
		if(getContractReceivableId() != null) sb.append(__wrapNumber(count++, "contractReceivableId", getContractReceivableId()));
		if(getInvoiceId() != null) sb.append(__wrapNumber(count++, "invoiceId", getInvoiceId()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("centerId")) != null) setCenterId(__getInt(val)); 
		if((val = values.get("contractReceivableId")) != null) setContractReceivableId(__getInt(val)); 
		if((val = values.get("invoiceId")) != null) setInvoiceId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
	}

	protected java.lang.Integer  __center_id ;
	protected java.lang.Integer  __contract_receivable_id ;
	protected java.lang.Integer  __invoice_id ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_date ;
}
