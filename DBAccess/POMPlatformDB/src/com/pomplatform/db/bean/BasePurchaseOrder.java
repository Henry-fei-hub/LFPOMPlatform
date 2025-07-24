package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePurchaseOrder extends GenericBase implements BaseFactory<BasePurchaseOrder>, Comparable<BasePurchaseOrder> 
{


	public static BasePurchaseOrder newInstance(){
		return new BasePurchaseOrder();
	}

	@Override
	public BasePurchaseOrder make(){
		BasePurchaseOrder b = new BasePurchaseOrder();
		return b;
	}

	public final static java.lang.String CS_PURCHASE_ORDER_ID = "purchase_order_id" ;
	public final static java.lang.String CS_ORDER_CODE = "order_code" ;
	public final static java.lang.String CS_ORDER_NAME = "order_name" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_ORDER_REQUIREMENT = "order_requirement" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_CONTACT_GENDER = "contact_gender" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_ORDER_EMPLOYEE_ID = "order_employee_id" ;
	public final static java.lang.String CS_ORDER_TIME = "order_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,订单编号,订单名称,供应商id,采购要求,联系人姓名,联系人电话,2女),状态,采购人员,采购时间,备注";

	public java.lang.Integer getPurchaseOrderId() {
		return this.__purchase_order_id;
	}

	public void setPurchaseOrderId( java.lang.Integer value ) {
		this.__purchase_order_id = value;
	}

	public java.lang.String getOrderCode() {
		return this.__order_code;
	}

	public void setOrderCode( java.lang.String value ) {
		this.__order_code = value;
	}

	public java.lang.String getOrderName() {
		return this.__order_name;
	}

	public void setOrderName( java.lang.String value ) {
		this.__order_name = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.String getOrderRequirement() {
		return this.__order_requirement;
	}

	public void setOrderRequirement( java.lang.String value ) {
		this.__order_requirement = value;
	}

	public java.lang.String getContactName() {
		return this.__contact_name;
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.lang.Integer getContactGender() {
		return this.__contact_gender;
	}

	public void setContactGender( java.lang.Integer value ) {
		this.__contact_gender = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getOrderEmployeeId() {
		return this.__order_employee_id;
	}

	public void setOrderEmployeeId( java.lang.Integer value ) {
		this.__order_employee_id = value;
	}

	public java.util.Date getOrderTime() {
		return this.__order_time;
	}

	public void setOrderTime( java.util.Date value ) {
		this.__order_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BasePurchaseOrder __bean){
		__bean.setPurchaseOrderId(getPurchaseOrderId());
		__bean.setOrderCode(getOrderCode());
		__bean.setOrderName(getOrderName());
		__bean.setSupplierId(getSupplierId());
		__bean.setOrderRequirement(getOrderRequirement());
		__bean.setContactName(getContactName());
		__bean.setContactPhone(getContactPhone());
		__bean.setContactGender(getContactGender());
		__bean.setStatus(getStatus());
		__bean.setOrderEmployeeId(getOrderEmployeeId());
		__bean.setOrderTime(getOrderTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPurchaseOrderId() == null ? "" : getPurchaseOrderId());
		sb.append(",");
		sb.append(getOrderCode() == null ? "" : getOrderCode());
		sb.append(",");
		sb.append(getOrderName() == null ? "" : getOrderName());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getOrderRequirement() == null ? "" : getOrderRequirement());
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getContactGender() == null ? "" : getContactGender());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getOrderEmployeeId() == null ? "" : getOrderEmployeeId());
		sb.append(",");
		sb.append(getOrderTime() == null ? "" : sdf.format(getOrderTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePurchaseOrder o) {
		return __purchase_order_id == null ? -1 : __purchase_order_id.compareTo(o.getPurchaseOrderId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__purchase_order_id);
		hash = 97 * hash + Objects.hashCode(this.__order_code);
		hash = 97 * hash + Objects.hashCode(this.__order_name);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__order_requirement);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__contact_gender);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__order_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__order_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePurchaseOrder o = (BasePurchaseOrder)obj;
		if(!Objects.equals(this.__purchase_order_id, o.getPurchaseOrderId())) return false;
		if(!Objects.equals(this.__order_code, o.getOrderCode())) return false;
		if(!Objects.equals(this.__order_name, o.getOrderName())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__order_requirement, o.getOrderRequirement())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__contact_gender, o.getContactGender())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__order_employee_id, o.getOrderEmployeeId())) return false;
		if(!Objects.equals(this.__order_time, o.getOrderTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPurchaseOrderId() != null) sb.append(__wrapNumber(count++, "purchaseOrderId", getPurchaseOrderId()));
		if(getOrderCode() != null) sb.append(__wrapString(count++, "orderCode", getOrderCode()));
		if(getOrderName() != null) sb.append(__wrapString(count++, "orderName", getOrderName()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getOrderRequirement() != null) sb.append(__wrapString(count++, "orderRequirement", getOrderRequirement()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getContactGender() != null) sb.append(__wrapNumber(count++, "contactGender", getContactGender()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getOrderEmployeeId() != null) sb.append(__wrapNumber(count++, "orderEmployeeId", getOrderEmployeeId()));
		if(getOrderTime() != null) sb.append(__wrapDate(count++, "orderTime", getOrderTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPurchaseOrderId() != null) res.put("purchaseOrderId", getPurchaseOrderId());
		if(getOrderCode() != null) res.put("orderCode", getOrderCode());
		if(getOrderName() != null) res.put("orderName", getOrderName());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getOrderRequirement() != null) res.put("orderRequirement", getOrderRequirement());
		if(getContactName() != null) res.put("contactName", getContactName());
		if(getContactPhone() != null) res.put("contactPhone", getContactPhone());
		if(getContactGender() != null) res.put("contactGender", getContactGender());
		if(getStatus() != null) res.put("status", getStatus());
		if(getOrderEmployeeId() != null) res.put("orderEmployeeId", getOrderEmployeeId());
		if(getOrderTime() != null) res.put("orderTime", getOrderTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("purchaseOrderId")) != null) setPurchaseOrderId(__getInt(val)); 
		if((val = values.get("orderCode")) != null) setOrderCode(__getString(val));
		if((val = values.get("orderName")) != null) setOrderName(__getString(val));
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("orderRequirement")) != null) setOrderRequirement(__getString(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("contactGender")) != null) setContactGender(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("orderEmployeeId")) != null) setOrderEmployeeId(__getInt(val)); 
		if((val = values.get("orderTime")) != null) setOrderTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __purchase_order_id ;
	protected java.lang.String  __order_code ;
	protected java.lang.String  __order_name ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __order_requirement ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.Integer  __contact_gender ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __order_employee_id ;
	protected java.util.Date  __order_time ;
	protected java.lang.String  __remark ;
}
