package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSupplierInfoChangeRecord extends GenericBase implements BaseFactory<BaseSupplierInfoChangeRecord>, Comparable<BaseSupplierInfoChangeRecord> 
{


	public static BaseSupplierInfoChangeRecord newInstance(){
		return new BaseSupplierInfoChangeRecord();
	}

	@Override
	public BaseSupplierInfoChangeRecord make(){
		BaseSupplierInfoChangeRecord b = new BaseSupplierInfoChangeRecord();
		return b;
	}

	public final static java.lang.String CS_SUPPLIER_INFO_CHANGE_RECORD_ID = "supplier_info_change_record_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_CHANGE_CONTENT = "change_content" ;
	public final static java.lang.String CS_CHANGE_EMPLOYEE_ID = "change_employee_id" ;
	public final static java.lang.String CS_CHANGE_DATE = "change_date" ;
	public final static java.lang.String CS_CHANGE_TIME = "change_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,供应商id,变更内容,变更人,变更日期,变更时间,备注";

	public java.lang.Integer getSupplierInfoChangeRecordId() {
		return this.__supplier_info_change_record_id;
	}

	public void setSupplierInfoChangeRecordId( java.lang.Integer value ) {
		this.__supplier_info_change_record_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.String getChangeContent() {
		return this.__change_content;
	}

	public void setChangeContent( java.lang.String value ) {
		this.__change_content = value;
	}

	public java.lang.Integer getChangeEmployeeId() {
		return this.__change_employee_id;
	}

	public void setChangeEmployeeId( java.lang.Integer value ) {
		this.__change_employee_id = value;
	}

	public java.util.Date getChangeDate() {
		return this.__change_date;
	}

	public void setChangeDate( java.util.Date value ) {
		this.__change_date = value;
	}

	public java.util.Date getChangeTime() {
		return this.__change_time;
	}

	public void setChangeTime( java.util.Date value ) {
		this.__change_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSupplierInfoChangeRecord __bean){
		__bean.setSupplierInfoChangeRecordId(getSupplierInfoChangeRecordId());
		__bean.setSupplierId(getSupplierId());
		__bean.setChangeContent(getChangeContent());
		__bean.setChangeEmployeeId(getChangeEmployeeId());
		__bean.setChangeDate(getChangeDate());
		__bean.setChangeTime(getChangeTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSupplierInfoChangeRecordId() == null ? "" : getSupplierInfoChangeRecordId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getChangeContent() == null ? "" : getChangeContent());
		sb.append(",");
		sb.append(getChangeEmployeeId() == null ? "" : getChangeEmployeeId());
		sb.append(",");
		sb.append(getChangeDate() == null ? "" : sdf.format(getChangeDate()));
		sb.append(",");
		sb.append(getChangeTime() == null ? "" : sdf.format(getChangeTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSupplierInfoChangeRecord o) {
		return __supplier_info_change_record_id == null ? -1 : __supplier_info_change_record_id.compareTo(o.getSupplierInfoChangeRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__supplier_info_change_record_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__change_content);
		hash = 97 * hash + Objects.hashCode(this.__change_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__change_date);
		hash = 97 * hash + Objects.hashCode(this.__change_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSupplierInfoChangeRecord o = (BaseSupplierInfoChangeRecord)obj;
		if(!Objects.equals(this.__supplier_info_change_record_id, o.getSupplierInfoChangeRecordId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__change_content, o.getChangeContent())) return false;
		if(!Objects.equals(this.__change_employee_id, o.getChangeEmployeeId())) return false;
		if(!Objects.equals(this.__change_date, o.getChangeDate())) return false;
		if(!Objects.equals(this.__change_time, o.getChangeTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSupplierInfoChangeRecordId() != null) sb.append(__wrapNumber(count++, "supplierInfoChangeRecordId", getSupplierInfoChangeRecordId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getChangeContent() != null) sb.append(__wrapString(count++, "changeContent", getChangeContent()));
		if(getChangeEmployeeId() != null) sb.append(__wrapNumber(count++, "changeEmployeeId", getChangeEmployeeId()));
		if(getChangeDate() != null) sb.append(__wrapDate(count++, "changeDate", getChangeDate()));
		if(getChangeTime() != null) sb.append(__wrapDate(count++, "changeTime", getChangeTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSupplierInfoChangeRecordId() != null) res.put("supplierInfoChangeRecordId", getSupplierInfoChangeRecordId());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getChangeContent() != null) res.put("changeContent", getChangeContent());
		if(getChangeEmployeeId() != null) res.put("changeEmployeeId", getChangeEmployeeId());
		if(getChangeDate() != null) res.put("changeDate", getChangeDate());
		if(getChangeTime() != null) res.put("changeTime", getChangeTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("supplierInfoChangeRecordId")) != null) setSupplierInfoChangeRecordId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("changeContent")) != null) setChangeContent(__getString(val));
		if((val = values.get("changeEmployeeId")) != null) setChangeEmployeeId(__getInt(val)); 
		if((val = values.get("changeDate")) != null) setChangeDate(__getDate(val)); 
		if((val = values.get("changeTime")) != null) setChangeTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __supplier_info_change_record_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __change_content ;
	protected java.lang.Integer  __change_employee_id ;
	protected java.util.Date  __change_date ;
	protected java.util.Date  __change_time ;
	protected java.lang.String  __remark ;
}
