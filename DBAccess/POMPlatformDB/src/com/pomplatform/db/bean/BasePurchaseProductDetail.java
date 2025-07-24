package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePurchaseProductDetail extends GenericBase implements BaseFactory<BasePurchaseProductDetail>, Comparable<BasePurchaseProductDetail> 
{


	public static BasePurchaseProductDetail newInstance(){
		return new BasePurchaseProductDetail();
	}

	@Override
	public BasePurchaseProductDetail make(){
		BasePurchaseProductDetail b = new BasePurchaseProductDetail();
		return b;
	}

	public final static java.lang.String CS_PURCHASE_PRODUCT_DETAIL_ID = "purchase_product_detail_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PRODUCT_ID = "product_id" ;
	public final static java.lang.String CS_PRODUCT_NUMBER = "product_number" ;
	public final static java.lang.String CS_PRODUCT_UNIT = "product_unit" ;
	public final static java.lang.String CS_PRODUCT_PRICE = "product_price" ;
	public final static java.lang.String CS_TOTAL_PRICE = "total_price" ;
	public final static java.lang.String CS_TAX_POINTS = "tax_points" ;
	public final static java.lang.String CS_TAX_PRICE = "tax_price" ;
	public final static java.lang.String CS_FINAL_PRICE = "final_price" ;
	public final static java.lang.String CS_PLAN_ARRIVAL_DATE = "plan_arrival_date" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PURCHASE_CONTRACT_ID = "purchase_contract_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,人事业务编码,项目id,供应商id,产品id,产品数量,产品单位,产品单价,产品总价,含税点,税费,,,,,,";

	public java.lang.Integer getPurchaseProductDetailId() {
		return this.__purchase_product_detail_id;
	}

	public void setPurchaseProductDetailId( java.lang.Integer value ) {
		this.__purchase_product_detail_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.Integer getProductId() {
		return this.__product_id;
	}

	public void setProductId( java.lang.Integer value ) {
		this.__product_id = value;
	}

	public java.lang.Integer getProductNumber() {
		return this.__product_number;
	}

	public void setProductNumber( java.lang.Integer value ) {
		this.__product_number = value;
	}

	public java.lang.String getProductUnit() {
		return this.__product_unit;
	}

	public void setProductUnit( java.lang.String value ) {
		this.__product_unit = value;
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

	public java.math.BigDecimal getTaxPrice() {
		return this.__tax_price;
	}

	public void setTaxPrice( java.math.BigDecimal value ) {
		this.__tax_price = value;
	}

	public java.math.BigDecimal getFinalPrice() {
		return this.__final_price;
	}

	public void setFinalPrice( java.math.BigDecimal value ) {
		this.__final_price = value;
	}

	public java.util.Date getPlanArrivalDate() {
		return this.__plan_arrival_date;
	}

	public void setPlanArrivalDate( java.util.Date value ) {
		this.__plan_arrival_date = value;
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

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	public void cloneCopy(BasePurchaseProductDetail __bean){
		__bean.setPurchaseProductDetailId(getPurchaseProductDetailId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setSupplierId(getSupplierId());
		__bean.setProductId(getProductId());
		__bean.setProductNumber(getProductNumber());
		__bean.setProductUnit(getProductUnit());
		__bean.setProductPrice(getProductPrice());
		__bean.setTotalPrice(getTotalPrice());
		__bean.setTaxPoints(getTaxPoints());
		__bean.setTaxPrice(getTaxPrice());
		__bean.setFinalPrice(getFinalPrice());
		__bean.setPlanArrivalDate(getPlanArrivalDate());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
		__bean.setPurchaseContractId(getPurchaseContractId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPurchaseProductDetailId() == null ? "" : getPurchaseProductDetailId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getProductId() == null ? "" : getProductId());
		sb.append(",");
		sb.append(getProductNumber() == null ? "" : getProductNumber());
		sb.append(",");
		sb.append(getProductUnit() == null ? "" : getProductUnit());
		sb.append(",");
		sb.append(getProductPrice() == null ? "" : getProductPrice());
		sb.append(",");
		sb.append(getTotalPrice() == null ? "" : getTotalPrice());
		sb.append(",");
		sb.append(getTaxPoints() == null ? "" : getTaxPoints());
		sb.append(",");
		sb.append(getTaxPrice() == null ? "" : getTaxPrice());
		sb.append(",");
		sb.append(getFinalPrice() == null ? "" : getFinalPrice());
		sb.append(",");
		sb.append(getPlanArrivalDate() == null ? "" : sdf.format(getPlanArrivalDate()));
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getPurchaseContractId() == null ? "" : getPurchaseContractId());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePurchaseProductDetail o) {
		return __purchase_product_detail_id == null ? -1 : __purchase_product_detail_id.compareTo(o.getPurchaseProductDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__purchase_product_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__product_id);
		hash = 97 * hash + Objects.hashCode(this.__product_number);
		hash = 97 * hash + Objects.hashCode(this.__product_unit);
		hash = 97 * hash + Objects.hashCode(this.__product_price);
		hash = 97 * hash + Objects.hashCode(this.__total_price);
		hash = 97 * hash + Objects.hashCode(this.__tax_points);
		hash = 97 * hash + Objects.hashCode(this.__tax_price);
		hash = 97 * hash + Objects.hashCode(this.__final_price);
		hash = 97 * hash + Objects.hashCode(this.__plan_arrival_date);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__purchase_contract_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePurchaseProductDetail o = (BasePurchaseProductDetail)obj;
		if(!Objects.equals(this.__purchase_product_detail_id, o.getPurchaseProductDetailId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__product_id, o.getProductId())) return false;
		if(!Objects.equals(this.__product_number, o.getProductNumber())) return false;
		if(!Objects.equals(this.__product_unit, o.getProductUnit())) return false;
		if(!Objects.equals(this.__product_price, o.getProductPrice())) return false;
		if(!Objects.equals(this.__total_price, o.getTotalPrice())) return false;
		if(!Objects.equals(this.__tax_points, o.getTaxPoints())) return false;
		if(!Objects.equals(this.__tax_price, o.getTaxPrice())) return false;
		if(!Objects.equals(this.__final_price, o.getFinalPrice())) return false;
		if(!Objects.equals(this.__plan_arrival_date, o.getPlanArrivalDate())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__purchase_contract_id, o.getPurchaseContractId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPurchaseProductDetailId() != null) sb.append(__wrapNumber(count++, "purchaseProductDetailId", getPurchaseProductDetailId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getProductId() != null) sb.append(__wrapNumber(count++, "productId", getProductId()));
		if(getProductNumber() != null) sb.append(__wrapNumber(count++, "productNumber", getProductNumber()));
		if(getProductUnit() != null) sb.append(__wrapString(count++, "productUnit", getProductUnit()));
		if(getProductPrice() != null) sb.append(__wrapDecimal(count++, "productPrice", getProductPrice()));
		if(getTotalPrice() != null) sb.append(__wrapDecimal(count++, "totalPrice", getTotalPrice()));
		if(getTaxPoints() != null) sb.append(__wrapDecimal(count++, "taxPoints", getTaxPoints()));
		if(getTaxPrice() != null) sb.append(__wrapDecimal(count++, "taxPrice", getTaxPrice()));
		if(getFinalPrice() != null) sb.append(__wrapDecimal(count++, "finalPrice", getFinalPrice()));
		if(getPlanArrivalDate() != null) sb.append(__wrapDate(count++, "planArrivalDate", getPlanArrivalDate()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(count++, "purchaseContractId", getPurchaseContractId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPurchaseProductDetailId() != null) res.put("purchaseProductDetailId", getPurchaseProductDetailId());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getProductId() != null) res.put("productId", getProductId());
		if(getProductNumber() != null) res.put("productNumber", getProductNumber());
		if(getProductUnit() != null) res.put("productUnit", getProductUnit());
		if(getProductPrice() != null) res.put("productPrice", getProductPrice());
		if(getTotalPrice() != null) res.put("totalPrice", getTotalPrice());
		if(getTaxPoints() != null) res.put("taxPoints", getTaxPoints());
		if(getTaxPrice() != null) res.put("taxPrice", getTaxPrice());
		if(getFinalPrice() != null) res.put("finalPrice", getFinalPrice());
		if(getPlanArrivalDate() != null) res.put("planArrivalDate", getPlanArrivalDate());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getPurchaseContractId() != null) res.put("purchaseContractId", getPurchaseContractId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("purchaseProductDetailId")) != null) setPurchaseProductDetailId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("productId")) != null) setProductId(__getInt(val)); 
		if((val = values.get("productNumber")) != null) setProductNumber(__getInt(val)); 
		if((val = values.get("productUnit")) != null) setProductUnit(__getString(val));
		if((val = values.get("productPrice")) != null) setProductPrice(__getDecimal(val));  
		if((val = values.get("totalPrice")) != null) setTotalPrice(__getDecimal(val));  
		if((val = values.get("taxPoints")) != null) setTaxPoints(__getDecimal(val));  
		if((val = values.get("taxPrice")) != null) setTaxPrice(__getDecimal(val));  
		if((val = values.get("finalPrice")) != null) setFinalPrice(__getDecimal(val));  
		if((val = values.get("planArrivalDate")) != null) setPlanArrivalDate(__getDate(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
	}

	protected java.lang.Integer  __purchase_product_detail_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.Integer  __product_id ;
	protected java.lang.Integer  __product_number ;
	protected java.lang.String  __product_unit ;
	protected java.math.BigDecimal  __product_price ;
	protected java.math.BigDecimal  __total_price ;
	protected java.math.BigDecimal  __tax_points ;
	protected java.math.BigDecimal  __tax_price ;
	protected java.math.BigDecimal  __final_price ;
	protected java.util.Date  __plan_arrival_date ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __purchase_contract_id ;
}
