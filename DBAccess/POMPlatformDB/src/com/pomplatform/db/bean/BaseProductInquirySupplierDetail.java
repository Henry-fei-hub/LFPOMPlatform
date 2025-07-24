package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProductInquirySupplierDetail extends GenericBase implements BaseFactory<BaseProductInquirySupplierDetail>, Comparable<BaseProductInquirySupplierDetail> 
{


	public static BaseProductInquirySupplierDetail newInstance(){
		return new BaseProductInquirySupplierDetail();
	}

	@Override
	public BaseProductInquirySupplierDetail make(){
		BaseProductInquirySupplierDetail b = new BaseProductInquirySupplierDetail();
		return b;
	}

	public final static java.lang.String CS_PRODUCT_INQUIRY_SUPPLIER_DETAIL_ID = "product_inquiry_supplier_detail_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PRODUCT_INQUIRY_DETAIL_ID = "product_inquiry_detail_id" ;
	public final static java.lang.String CS_PRODUCT_PRICE = "product_price" ;
	public final static java.lang.String CS_TOTAL_PRICE = "total_price" ;
	public final static java.lang.String CS_TAX_POINTS = "tax_points" ;
	public final static java.lang.String CS_PRIORITY_LEVEL = "priority_level" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_INQUIRY_DATE = "inquiry_date" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_SUPPLIER_CONTACT_ID = "supplier_contact_id" ;
	public final static java.lang.String CS_IS_SELECT = "is_select" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,供应商主键,询价详情表主键,单价,总价,含税点,优先级别,备注,询价日期,创建日期,操作人,供应商联系人主键,是否选中为最终报价 true 是";

	public java.lang.Integer getProductInquirySupplierDetailId() {
		return this.__product_inquiry_supplier_detail_id;
	}

	public void setProductInquirySupplierDetailId( java.lang.Integer value ) {
		this.__product_inquiry_supplier_detail_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.Integer getProductInquiryDetailId() {
		return this.__product_inquiry_detail_id;
	}

	public void setProductInquiryDetailId( java.lang.Integer value ) {
		this.__product_inquiry_detail_id = value;
	}

	public java.math.BigDecimal getProductPrice() {
		return this.__product_price;
	}

	public void setProductPrice( java.math.BigDecimal value ) {
		this.__product_price = value;
	}

	public java.math.BigDecimal getTotalPrice() {
		return this.__total_price;
	}

	public void setTotalPrice( java.math.BigDecimal value ) {
		this.__total_price = value;
	}

	public java.math.BigDecimal getTaxPoints() {
		return this.__tax_points;
	}

	public void setTaxPoints( java.math.BigDecimal value ) {
		this.__tax_points = value;
	}

	public java.lang.Integer getPriorityLevel() {
		return this.__priority_level;
	}

	public void setPriorityLevel( java.lang.Integer value ) {
		this.__priority_level = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getInquiryDate() {
		return this.__inquiry_date;
	}

	public void setInquiryDate( java.util.Date value ) {
		this.__inquiry_date = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.Integer getSupplierContactId() {
		return this.__supplier_contact_id;
	}

	public void setSupplierContactId( java.lang.Integer value ) {
		this.__supplier_contact_id = value;
	}

	public java.lang.Boolean getIsSelect() {
		return this.__is_select;
	}

	public void setIsSelect( java.lang.Boolean value ) {
		this.__is_select = value;
	}

	public void cloneCopy(BaseProductInquirySupplierDetail __bean){
		__bean.setProductInquirySupplierDetailId(getProductInquirySupplierDetailId());
		__bean.setSupplierId(getSupplierId());
		__bean.setProductInquiryDetailId(getProductInquiryDetailId());
		__bean.setProductPrice(getProductPrice());
		__bean.setTotalPrice(getTotalPrice());
		__bean.setTaxPoints(getTaxPoints());
		__bean.setPriorityLevel(getPriorityLevel());
		__bean.setRemark(getRemark());
		__bean.setInquiryDate(getInquiryDate());
		__bean.setCreateTime(getCreateTime());
		__bean.setOperatorId(getOperatorId());
		__bean.setSupplierContactId(getSupplierContactId());
		__bean.setIsSelect(getIsSelect());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProductInquirySupplierDetailId() == null ? "" : getProductInquirySupplierDetailId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getProductInquiryDetailId() == null ? "" : getProductInquiryDetailId());
		sb.append(",");
		sb.append(getProductPrice() == null ? "" : getProductPrice());
		sb.append(",");
		sb.append(getTotalPrice() == null ? "" : getTotalPrice());
		sb.append(",");
		sb.append(getTaxPoints() == null ? "" : getTaxPoints());
		sb.append(",");
		sb.append(getPriorityLevel() == null ? "" : getPriorityLevel());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getInquiryDate() == null ? "" : sdf.format(getInquiryDate()));
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getSupplierContactId() == null ? "" : getSupplierContactId());
		sb.append(",");
		sb.append(getIsSelect() == null ? "" : getIsSelect());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProductInquirySupplierDetail o) {
		return __product_inquiry_supplier_detail_id == null ? -1 : __product_inquiry_supplier_detail_id.compareTo(o.getProductInquirySupplierDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__product_inquiry_supplier_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__product_inquiry_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__product_price);
		hash = 97 * hash + Objects.hashCode(this.__total_price);
		hash = 97 * hash + Objects.hashCode(this.__tax_points);
		hash = 97 * hash + Objects.hashCode(this.__priority_level);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__inquiry_date);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_contact_id);
		hash = 97 * hash + Objects.hashCode(this.__is_select);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProductInquirySupplierDetail o = (BaseProductInquirySupplierDetail)obj;
		if(!Objects.equals(this.__product_inquiry_supplier_detail_id, o.getProductInquirySupplierDetailId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__product_inquiry_detail_id, o.getProductInquiryDetailId())) return false;
		if(!Objects.equals(this.__product_price, o.getProductPrice())) return false;
		if(!Objects.equals(this.__total_price, o.getTotalPrice())) return false;
		if(!Objects.equals(this.__tax_points, o.getTaxPoints())) return false;
		if(!Objects.equals(this.__priority_level, o.getPriorityLevel())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__inquiry_date, o.getInquiryDate())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__supplier_contact_id, o.getSupplierContactId())) return false;
		if(!Objects.equals(this.__is_select, o.getIsSelect())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProductInquirySupplierDetailId() != null) sb.append(__wrapNumber(count++, "productInquirySupplierDetailId", getProductInquirySupplierDetailId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getProductInquiryDetailId() != null) sb.append(__wrapNumber(count++, "productInquiryDetailId", getProductInquiryDetailId()));
		if(getProductPrice() != null) sb.append(__wrapDecimal(count++, "productPrice", getProductPrice()));
		if(getTotalPrice() != null) sb.append(__wrapDecimal(count++, "totalPrice", getTotalPrice()));
		if(getTaxPoints() != null) sb.append(__wrapDecimal(count++, "taxPoints", getTaxPoints()));
		if(getPriorityLevel() != null) sb.append(__wrapNumber(count++, "priorityLevel", getPriorityLevel()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getInquiryDate() != null) sb.append(__wrapDate(count++, "inquiryDate", getInquiryDate()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getSupplierContactId() != null) sb.append(__wrapNumber(count++, "supplierContactId", getSupplierContactId()));
		if(getIsSelect() != null) sb.append(__wrapBoolean(count++, "isSelect", getIsSelect()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProductInquirySupplierDetailId() != null) res.put("productInquirySupplierDetailId", getProductInquirySupplierDetailId());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getProductInquiryDetailId() != null) res.put("productInquiryDetailId", getProductInquiryDetailId());
		if(getProductPrice() != null) res.put("productPrice", getProductPrice());
		if(getTotalPrice() != null) res.put("totalPrice", getTotalPrice());
		if(getTaxPoints() != null) res.put("taxPoints", getTaxPoints());
		if(getPriorityLevel() != null) res.put("priorityLevel", getPriorityLevel());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getInquiryDate() != null) res.put("inquiryDate", getInquiryDate());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getSupplierContactId() != null) res.put("supplierContactId", getSupplierContactId());
		if(getIsSelect() != null) res.put("isSelect", getIsSelect());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("productInquirySupplierDetailId")) != null) setProductInquirySupplierDetailId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("productInquiryDetailId")) != null) setProductInquiryDetailId(__getInt(val)); 
		if((val = values.get("productPrice")) != null) setProductPrice(__getDecimal(val));  
		if((val = values.get("totalPrice")) != null) setTotalPrice(__getDecimal(val));  
		if((val = values.get("taxPoints")) != null) setTaxPoints(__getDecimal(val));  
		if((val = values.get("priorityLevel")) != null) setPriorityLevel(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("inquiryDate")) != null) setInquiryDate(__getDate(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("supplierContactId")) != null) setSupplierContactId(__getInt(val)); 
		if((val = values.get("isSelect")) != null) setIsSelect(__getBoolean(val));
	}

	protected java.lang.Integer  __product_inquiry_supplier_detail_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.Integer  __product_inquiry_detail_id ;
	protected java.math.BigDecimal  __product_price ;
	protected java.math.BigDecimal  __total_price ;
	protected java.math.BigDecimal  __tax_points ;
	protected java.lang.Integer  __priority_level ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __inquiry_date ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __operator_id ;
	protected java.lang.Integer  __supplier_contact_id ;
	protected java.lang.Boolean  __is_select ;
}
