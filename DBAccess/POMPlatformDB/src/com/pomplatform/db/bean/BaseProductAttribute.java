package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProductAttribute extends GenericBase implements BaseFactory<BaseProductAttribute>, Comparable<BaseProductAttribute> 
{


	public static BaseProductAttribute newInstance(){
		return new BaseProductAttribute();
	}

	@Override
	public BaseProductAttribute make(){
		BaseProductAttribute b = new BaseProductAttribute();
		return b;
	}

	public final static java.lang.String CS_PRODUCT_ATTRIBUTE_ID = "product_attribute_id" ;
	public final static java.lang.String CS_PRODUCT_ID = "product_id" ;
	public final static java.lang.String CS_ATTRIBUTE_TYPE = "attribute_type" ;
	public final static java.lang.String CS_ATTRIBUTE_NAME = "attribute_name" ;
	public final static java.lang.String CS_ATTRIBUTE_VALUE = "attribute_value" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,产品id,属性类型(预留),属性名称,属性值,创建人,创建时间,备注";

	public java.lang.Integer getProductAttributeId() {
		return this.__product_attribute_id;
	}

	public void setProductAttributeId( java.lang.Integer value ) {
		this.__product_attribute_id = value;
	}

	public java.lang.Integer getProductId() {
		return this.__product_id;
	}

	public void setProductId( java.lang.Integer value ) {
		this.__product_id = value;
	}

	public java.lang.Integer getAttributeType() {
		return this.__attribute_type;
	}

	public void setAttributeType( java.lang.Integer value ) {
		this.__attribute_type = value;
	}

	public java.lang.String getAttributeName() {
		return this.__attribute_name;
	}

	public void setAttributeName( java.lang.String value ) {
		this.__attribute_name = value;
	}

	public java.lang.String getAttributeValue() {
		return this.__attribute_value;
	}

	public void setAttributeValue( java.lang.String value ) {
		this.__attribute_value = value;
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

	public void cloneCopy(BaseProductAttribute __bean){
		__bean.setProductAttributeId(getProductAttributeId());
		__bean.setProductId(getProductId());
		__bean.setAttributeType(getAttributeType());
		__bean.setAttributeName(getAttributeName());
		__bean.setAttributeValue(getAttributeValue());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProductAttributeId() == null ? "" : getProductAttributeId());
		sb.append(",");
		sb.append(getProductId() == null ? "" : getProductId());
		sb.append(",");
		sb.append(getAttributeType() == null ? "" : getAttributeType());
		sb.append(",");
		sb.append(getAttributeName() == null ? "" : getAttributeName());
		sb.append(",");
		sb.append(getAttributeValue() == null ? "" : getAttributeValue());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProductAttribute o) {
		return __product_attribute_id == null ? -1 : __product_attribute_id.compareTo(o.getProductAttributeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__product_attribute_id);
		hash = 97 * hash + Objects.hashCode(this.__product_id);
		hash = 97 * hash + Objects.hashCode(this.__attribute_type);
		hash = 97 * hash + Objects.hashCode(this.__attribute_name);
		hash = 97 * hash + Objects.hashCode(this.__attribute_value);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProductAttribute o = (BaseProductAttribute)obj;
		if(!Objects.equals(this.__product_attribute_id, o.getProductAttributeId())) return false;
		if(!Objects.equals(this.__product_id, o.getProductId())) return false;
		if(!Objects.equals(this.__attribute_type, o.getAttributeType())) return false;
		if(!Objects.equals(this.__attribute_name, o.getAttributeName())) return false;
		if(!Objects.equals(this.__attribute_value, o.getAttributeValue())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProductAttributeId() != null) sb.append(__wrapNumber(count++, "productAttributeId", getProductAttributeId()));
		if(getProductId() != null) sb.append(__wrapNumber(count++, "productId", getProductId()));
		if(getAttributeType() != null) sb.append(__wrapNumber(count++, "attributeType", getAttributeType()));
		if(getAttributeName() != null) sb.append(__wrapString(count++, "attributeName", getAttributeName()));
		if(getAttributeValue() != null) sb.append(__wrapString(count++, "attributeValue", getAttributeValue()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProductAttributeId() != null) res.put("productAttributeId", getProductAttributeId());
		if(getProductId() != null) res.put("productId", getProductId());
		if(getAttributeType() != null) res.put("attributeType", getAttributeType());
		if(getAttributeName() != null) res.put("attributeName", getAttributeName());
		if(getAttributeValue() != null) res.put("attributeValue", getAttributeValue());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("productAttributeId")) != null) setProductAttributeId(__getInt(val)); 
		if((val = values.get("productId")) != null) setProductId(__getInt(val)); 
		if((val = values.get("attributeType")) != null) setAttributeType(__getInt(val)); 
		if((val = values.get("attributeName")) != null) setAttributeName(__getString(val));
		if((val = values.get("attributeValue")) != null) setAttributeValue(__getString(val));
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __product_attribute_id ;
	protected java.lang.Integer  __product_id ;
	protected java.lang.Integer  __attribute_type ;
	protected java.lang.String  __attribute_name ;
	protected java.lang.String  __attribute_value ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
