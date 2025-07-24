package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSupplierDetail extends GenericBase implements BaseFactory<BaseSupplierDetail>, Comparable<BaseSupplierDetail> 
{


	public static BaseSupplierDetail newInstance(){
		return new BaseSupplierDetail();
	}

	@Override
	public BaseSupplierDetail make(){
		BaseSupplierDetail b = new BaseSupplierDetail();
		return b;
	}

	public final static java.lang.String CS_SUPPLIER_DETAIL_ID = "supplier_detail_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_ADDRESS = "project_address" ;
	public final static java.lang.String CS_SUPPLIER_DUTY = "supplier_duty" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,供应商编码,供应商项目名称,供应商项目地址,供应商负责内容";

	public java.lang.Integer getSupplierDetailId() {
		return this.__supplier_detail_id;
	}

	public void setSupplierDetailId( java.lang.Integer value ) {
		this.__supplier_detail_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectAddress() {
		return this.__project_address;
	}

	public void setProjectAddress( java.lang.String value ) {
		this.__project_address = value;
	}

	public java.lang.String getSupplierDuty() {
		return this.__supplier_duty;
	}

	public void setSupplierDuty( java.lang.String value ) {
		this.__supplier_duty = value;
	}

	public void cloneCopy(BaseSupplierDetail __bean){
		__bean.setSupplierDetailId(getSupplierDetailId());
		__bean.setSupplierId(getSupplierId());
		__bean.setProjectName(getProjectName());
		__bean.setProjectAddress(getProjectAddress());
		__bean.setSupplierDuty(getSupplierDuty());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSupplierDetailId() == null ? "" : getSupplierDetailId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectAddress() == null ? "" : getProjectAddress());
		sb.append(",");
		sb.append(getSupplierDuty() == null ? "" : getSupplierDuty());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSupplierDetail o) {
		return __supplier_detail_id == null ? -1 : __supplier_detail_id.compareTo(o.getSupplierDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__supplier_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_address);
		hash = 97 * hash + Objects.hashCode(this.__supplier_duty);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSupplierDetail o = (BaseSupplierDetail)obj;
		if(!Objects.equals(this.__supplier_detail_id, o.getSupplierDetailId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_address, o.getProjectAddress())) return false;
		if(!Objects.equals(this.__supplier_duty, o.getSupplierDuty())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSupplierDetailId() != null) sb.append(__wrapNumber(count++, "supplierDetailId", getSupplierDetailId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectAddress() != null) sb.append(__wrapString(count++, "projectAddress", getProjectAddress()));
		if(getSupplierDuty() != null) sb.append(__wrapString(count++, "supplierDuty", getSupplierDuty()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("supplierDetailId")) != null) setSupplierDetailId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectAddress")) != null) setProjectAddress(__getString(val));
		if((val = values.get("supplierDuty")) != null) setSupplierDuty(__getString(val));
	}

	protected java.lang.Integer  __supplier_detail_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_address ;
	protected java.lang.String  __supplier_duty ;
}
