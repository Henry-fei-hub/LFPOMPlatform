package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadProductInquirySupplierDetail extends GenericCondition{

	public ConditionOnLoadProductInquirySupplierDetail(){
		setParameterCount(7);
	}

	public java.lang.Integer getPriorityLevel() {
		return this.__priority_level;
	}

	public void setPriorityLevel( java.lang.Integer value ) {
		this.__priority_level = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getSupplierContactId() {
		return this.__supplier_contact_id;
	}

	public void setSupplierContactId( java.lang.Integer value ) {
		this.__supplier_contact_id = value;
	}

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

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPriorityLevel() != null) sb.append(__wrapNumber(1, "priorityLevel", getPriorityLevel()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getSupplierContactId() != null) sb.append(__wrapNumber(1, "supplierContactId", getSupplierContactId()));
		if(getProductInquirySupplierDetailId() != null) sb.append(__wrapNumber(1, "productInquirySupplierDetailId", getProductInquirySupplierDetailId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(1, "supplierId", getSupplierId()));
		if(getProductInquiryDetailId() != null) sb.append(__wrapNumber(1, "productInquiryDetailId", getProductInquiryDetailId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(1, "operatorId", getOperatorId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("priorityLevel")) != null) setPriorityLevel(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("supplierContactId")) != null) setSupplierContactId(__getInt(val)); 
		if((val = values.get("productInquirySupplierDetailId")) != null) setProductInquirySupplierDetailId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("productInquiryDetailId")) != null) setProductInquiryDetailId(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
	}

	private java.lang.Integer __priority_level = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __supplier_contact_id = null;
	private java.lang.Integer __product_inquiry_supplier_detail_id = null;
	private java.lang.Integer __supplier_id = null;
	private java.lang.Integer __product_inquiry_detail_id = null;
	private java.lang.Integer __operator_id = null;
}

