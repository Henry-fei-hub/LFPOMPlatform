package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSupplierContact extends GenericBase implements BaseFactory<BaseSupplierContact>, Comparable<BaseSupplierContact> 
{


	public static BaseSupplierContact newInstance(){
		return new BaseSupplierContact();
	}

	@Override
	public BaseSupplierContact make(){
		BaseSupplierContact b = new BaseSupplierContact();
		return b;
	}

	public final static java.lang.String CS_SUPPLIER_CONTACT_ID = "supplier_contact_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_CONTACT_POSITION = "contact_position" ;
	public final static java.lang.String CS_CONTACT_GENDER = "contact_gender" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_CONTACT_EMAIL = "contact_email" ;
	public final static java.lang.String CS_CONTACT_FAX = "contact_fax" ;
	public final static java.lang.String CS_CONTACT_TYPE = "contact_type" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,供应商id,联系人姓名,联系人职位,2女),联系人电话,联系人邮箱,联系人传真,2其他),是否可用,创建人,创建时间,备注";

	public java.lang.Integer getSupplierContactId() {
		return this.__supplier_contact_id;
	}

	public void setSupplierContactId( java.lang.Integer value ) {
		this.__supplier_contact_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.String getContactName() {
		return this.__contact_name;
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getContactPosition() {
		return this.__contact_position;
	}

	public void setContactPosition( java.lang.String value ) {
		this.__contact_position = value;
	}

	public java.lang.Integer getContactGender() {
		return this.__contact_gender;
	}

	public void setContactGender( java.lang.Integer value ) {
		this.__contact_gender = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.lang.String getContactEmail() {
		return this.__contact_email;
	}

	public void setContactEmail( java.lang.String value ) {
		this.__contact_email = value;
	}

	public java.lang.String getContactFax() {
		return this.__contact_fax;
	}

	public void setContactFax( java.lang.String value ) {
		this.__contact_fax = value;
	}

	public java.lang.Integer getContactType() {
		return this.__contact_type;
	}

	public void setContactType( java.lang.Integer value ) {
		this.__contact_type = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSupplierContact __bean){
		__bean.setSupplierContactId(getSupplierContactId());
		__bean.setSupplierId(getSupplierId());
		__bean.setContactName(getContactName());
		__bean.setContactPosition(getContactPosition());
		__bean.setContactGender(getContactGender());
		__bean.setContactPhone(getContactPhone());
		__bean.setContactEmail(getContactEmail());
		__bean.setContactFax(getContactFax());
		__bean.setContactType(getContactType());
		__bean.setEnabled(getEnabled());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSupplierContactId() == null ? "" : getSupplierContactId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getContactPosition() == null ? "" : getContactPosition());
		sb.append(",");
		sb.append(getContactGender() == null ? "" : getContactGender());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getContactEmail() == null ? "" : getContactEmail());
		sb.append(",");
		sb.append(getContactFax() == null ? "" : getContactFax());
		sb.append(",");
		sb.append(getContactType() == null ? "" : getContactType());
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSupplierContact o) {
		return __supplier_contact_id == null ? -1 : __supplier_contact_id.compareTo(o.getSupplierContactId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__supplier_contact_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__contact_position);
		hash = 97 * hash + Objects.hashCode(this.__contact_gender);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__contact_email);
		hash = 97 * hash + Objects.hashCode(this.__contact_fax);
		hash = 97 * hash + Objects.hashCode(this.__contact_type);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSupplierContact o = (BaseSupplierContact)obj;
		if(!Objects.equals(this.__supplier_contact_id, o.getSupplierContactId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__contact_position, o.getContactPosition())) return false;
		if(!Objects.equals(this.__contact_gender, o.getContactGender())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__contact_email, o.getContactEmail())) return false;
		if(!Objects.equals(this.__contact_fax, o.getContactFax())) return false;
		if(!Objects.equals(this.__contact_type, o.getContactType())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSupplierContactId() != null) sb.append(__wrapNumber(count++, "supplierContactId", getSupplierContactId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getContactPosition() != null) sb.append(__wrapString(count++, "contactPosition", getContactPosition()));
		if(getContactGender() != null) sb.append(__wrapNumber(count++, "contactGender", getContactGender()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getContactEmail() != null) sb.append(__wrapString(count++, "contactEmail", getContactEmail()));
		if(getContactFax() != null) sb.append(__wrapString(count++, "contactFax", getContactFax()));
		if(getContactType() != null) sb.append(__wrapNumber(count++, "contactType", getContactType()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSupplierContactId() != null) res.put("supplierContactId", getSupplierContactId());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getContactName() != null) res.put("contactName", getContactName());
		if(getContactPosition() != null) res.put("contactPosition", getContactPosition());
		if(getContactGender() != null) res.put("contactGender", getContactGender());
		if(getContactPhone() != null) res.put("contactPhone", getContactPhone());
		if(getContactEmail() != null) res.put("contactEmail", getContactEmail());
		if(getContactFax() != null) res.put("contactFax", getContactFax());
		if(getContactType() != null) res.put("contactType", getContactType());
		if(getEnabled() != null) res.put("enabled", getEnabled());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("supplierContactId")) != null) setSupplierContactId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("contactPosition")) != null) setContactPosition(__getString(val));
		if((val = values.get("contactGender")) != null) setContactGender(__getInt(val)); 
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("contactEmail")) != null) setContactEmail(__getString(val));
		if((val = values.get("contactFax")) != null) setContactFax(__getString(val));
		if((val = values.get("contactType")) != null) setContactType(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __supplier_contact_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __contact_position ;
	protected java.lang.Integer  __contact_gender ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.String  __contact_email ;
	protected java.lang.String  __contact_fax ;
	protected java.lang.Integer  __contact_type ;
	protected java.lang.Boolean  __enabled ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
