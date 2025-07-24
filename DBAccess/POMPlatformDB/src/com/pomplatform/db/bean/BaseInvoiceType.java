package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseInvoiceType extends GenericBase implements BaseFactory<BaseInvoiceType>, Comparable<BaseInvoiceType> 
{


	public static BaseInvoiceType newInstance(){
		return new BaseInvoiceType();
	}

	@Override
	public BaseInvoiceType make(){
		BaseInvoiceType b = new BaseInvoiceType();
		return b;
	}

	public final static java.lang.String CS_INVOICE_TYPE_ID = "invoice_type_id" ;
	public final static java.lang.String CS_TYPE_NAME = "type_name" ;
	public final static java.lang.String CS_SUBTRACT_REMARK = "subtract_remark" ;
	public final static java.lang.String CS_TAX_RATE = "tax_rate" ;
	public final static java.lang.String CS_CREATOR = "creator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,类型名称,扣除,税率,创建人,创建时间";

	public java.lang.Integer getInvoiceTypeId() {
		return this.__invoice_type_id;
	}

	public void setInvoiceTypeId( java.lang.Integer value ) {
		this.__invoice_type_id = value;
	}

	public java.lang.String getTypeName() {
		return this.__type_name;
	}

	public void setTypeName( java.lang.String value ) {
		this.__type_name = value;
	}

	public java.lang.String getSubtractRemark() {
		return this.__subtract_remark;
	}

	public void setSubtractRemark( java.lang.String value ) {
		this.__subtract_remark = value;
	}

	public java.lang.Integer getTaxRate() {
		return this.__tax_rate;
	}

	public void setTaxRate( java.lang.Integer value ) {
		this.__tax_rate = value;
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

	public void cloneCopy(BaseInvoiceType __bean){
		__bean.setInvoiceTypeId(getInvoiceTypeId());
		__bean.setTypeName(getTypeName());
		__bean.setSubtractRemark(getSubtractRemark());
		__bean.setTaxRate(getTaxRate());
		__bean.setCreator(getCreator());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInvoiceTypeId() == null ? "" : getInvoiceTypeId());
		sb.append(",");
		sb.append(getTypeName() == null ? "" : getTypeName());
		sb.append(",");
		sb.append(getSubtractRemark() == null ? "" : getSubtractRemark());
		sb.append(",");
		sb.append(getTaxRate() == null ? "" : getTaxRate());
		sb.append(",");
		sb.append(getCreator() == null ? "" : getCreator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInvoiceType o) {
		return __invoice_type_id == null ? -1 : __invoice_type_id.compareTo(o.getInvoiceTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__invoice_type_id);
		hash = 97 * hash + Objects.hashCode(this.__type_name);
		hash = 97 * hash + Objects.hashCode(this.__subtract_remark);
		hash = 97 * hash + Objects.hashCode(this.__tax_rate);
		hash = 97 * hash + Objects.hashCode(this.__creator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInvoiceType o = (BaseInvoiceType)obj;
		if(!Objects.equals(this.__invoice_type_id, o.getInvoiceTypeId())) return false;
		if(!Objects.equals(this.__type_name, o.getTypeName())) return false;
		if(!Objects.equals(this.__subtract_remark, o.getSubtractRemark())) return false;
		if(!Objects.equals(this.__tax_rate, o.getTaxRate())) return false;
		if(!Objects.equals(this.__creator, o.getCreator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInvoiceTypeId() != null) sb.append(__wrapNumber(count++, "invoiceTypeId", getInvoiceTypeId()));
		if(getTypeName() != null) sb.append(__wrapString(count++, "typeName", getTypeName()));
		if(getSubtractRemark() != null) sb.append(__wrapString(count++, "subtractRemark", getSubtractRemark()));
		if(getTaxRate() != null) sb.append(__wrapNumber(count++, "taxRate", getTaxRate()));
		if(getCreator() != null) sb.append(__wrapNumber(count++, "creator", getCreator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getInvoiceTypeId() != null) res.put("invoiceTypeId", getInvoiceTypeId());
		if(getTypeName() != null) res.put("typeName", getTypeName());
		if(getSubtractRemark() != null) res.put("subtractRemark", getSubtractRemark());
		if(getTaxRate() != null) res.put("taxRate", getTaxRate());
		if(getCreator() != null) res.put("creator", getCreator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("invoiceTypeId")) != null) setInvoiceTypeId(__getInt(val)); 
		if((val = values.get("typeName")) != null) setTypeName(__getString(val));
		if((val = values.get("subtractRemark")) != null) setSubtractRemark(__getString(val));
		if((val = values.get("taxRate")) != null) setTaxRate(__getInt(val)); 
		if((val = values.get("creator")) != null) setCreator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __invoice_type_id ;
	protected java.lang.String  __type_name ;
	protected java.lang.String  __subtract_remark ;
	protected java.lang.Integer  __tax_rate ;
	protected java.lang.Integer  __creator ;
	protected java.util.Date  __create_time ;
}
