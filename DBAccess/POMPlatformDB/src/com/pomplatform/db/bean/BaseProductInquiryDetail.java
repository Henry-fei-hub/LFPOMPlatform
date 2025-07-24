package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProductInquiryDetail extends GenericBase implements BaseFactory<BaseProductInquiryDetail>, Comparable<BaseProductInquiryDetail> 
{


	public static BaseProductInquiryDetail newInstance(){
		return new BaseProductInquiryDetail();
	}

	@Override
	public BaseProductInquiryDetail make(){
		BaseProductInquiryDetail b = new BaseProductInquiryDetail();
		return b;
	}

	public final static java.lang.String CS_PRODUCT_INQUIRY_DETAIL_ID = "product_inquiry_detail_id" ;
	public final static java.lang.String CS_PRODUCT_INQUIRY_TOTAL_ID = "product_inquiry_total_id" ;
	public final static java.lang.String CS_PRODUCT_ID = "product_id" ;
	public final static java.lang.String CS_PRODUCT_NAME = "product_name" ;
	public final static java.lang.String CS_PRODUCT_MODEL = "product_model" ;
	public final static java.lang.String CS_PRODUCT_NUMBER = "product_number" ;
	public final static java.lang.String CS_PRODUCT_UNIT = "product_unit" ;
	public final static java.lang.String CS_PRE_TECHNICAL_INDICATOR = "pre_technical_indicator" ;
	public final static java.lang.String CS_PRODUCT_SPECIFICATION = "product_specification" ;
	public final static java.lang.String CS_INQUIRY_TECHNICAL_INDICATOR = "inquiry_technical_indicator" ;
	public final static java.lang.String CS_PERSON_IN_CHARGE = "person_in_charge" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PRODUCT_PRICE = "product_price" ;
	public final static java.lang.String CS_TOTAL_PRICE = "total_price" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_IS_PASS = "is_pass" ;
	public final static java.lang.String CS_TAX_POINTS = "tax_points" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,总表id,产品id,产品名称,产品型号,产品数量,产品单位,改造前关键技术指标,询价产品规格,询价产品关键技术指标,负责人,创建人,创建时间,备注,最终单价,最终总价,选定的供应商id,流程表主键,大项目主键,是否通过 true 通过,含税点";

	public java.lang.Integer getProductInquiryDetailId() {
		return this.__product_inquiry_detail_id;
	}

	public void setProductInquiryDetailId( java.lang.Integer value ) {
		this.__product_inquiry_detail_id = value;
	}

	public java.lang.Integer getProductInquiryTotalId() {
		return this.__product_inquiry_total_id;
	}

	public void setProductInquiryTotalId( java.lang.Integer value ) {
		this.__product_inquiry_total_id = value;
	}

	public java.lang.Integer getProductId() {
		return this.__product_id;
	}

	public void setProductId( java.lang.Integer value ) {
		this.__product_id = value;
	}

	public java.lang.String getProductName() {
		return this.__product_name;
	}

	public void setProductName( java.lang.String value ) {
		this.__product_name = value;
	}

	public java.lang.String getProductModel() {
		return this.__product_model;
	}

	public void setProductModel( java.lang.String value ) {
		this.__product_model = value;
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

	public java.lang.String getPreTechnicalIndicator() {
		return this.__pre_technical_indicator;
	}

	public void setPreTechnicalIndicator( java.lang.String value ) {
		this.__pre_technical_indicator = value;
	}

	public java.lang.String getProductSpecification() {
		return this.__product_specification;
	}

	public void setProductSpecification( java.lang.String value ) {
		this.__product_specification = value;
	}

	public java.lang.String getInquiryTechnicalIndicator() {
		return this.__inquiry_technical_indicator;
	}

	public void setInquiryTechnicalIndicator( java.lang.String value ) {
		this.__inquiry_technical_indicator = value;
	}

	public java.lang.Integer getPersonInCharge() {
		return this.__person_in_charge;
	}

	public void setPersonInCharge( java.lang.Integer value ) {
		this.__person_in_charge = value;
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

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
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

	public java.lang.Boolean getIsPass() {
		return this.__is_pass;
	}

	public void setIsPass( java.lang.Boolean value ) {
		this.__is_pass = value;
	}

	public java.math.BigDecimal getTaxPoints() {
		return this.__tax_points;
	}

	public void setTaxPoints( java.math.BigDecimal value ) {
		this.__tax_points = value;
	}

	public void cloneCopy(BaseProductInquiryDetail __bean){
		__bean.setProductInquiryDetailId(getProductInquiryDetailId());
		__bean.setProductInquiryTotalId(getProductInquiryTotalId());
		__bean.setProductId(getProductId());
		__bean.setProductName(getProductName());
		__bean.setProductModel(getProductModel());
		__bean.setProductNumber(getProductNumber());
		__bean.setProductUnit(getProductUnit());
		__bean.setPreTechnicalIndicator(getPreTechnicalIndicator());
		__bean.setProductSpecification(getProductSpecification());
		__bean.setInquiryTechnicalIndicator(getInquiryTechnicalIndicator());
		__bean.setPersonInCharge(getPersonInCharge());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
		__bean.setProductPrice(getProductPrice());
		__bean.setTotalPrice(getTotalPrice());
		__bean.setSupplierId(getSupplierId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setIsPass(getIsPass());
		__bean.setTaxPoints(getTaxPoints());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProductInquiryDetailId() == null ? "" : getProductInquiryDetailId());
		sb.append(",");
		sb.append(getProductInquiryTotalId() == null ? "" : getProductInquiryTotalId());
		sb.append(",");
		sb.append(getProductId() == null ? "" : getProductId());
		sb.append(",");
		sb.append(getProductName() == null ? "" : getProductName());
		sb.append(",");
		sb.append(getProductModel() == null ? "" : getProductModel());
		sb.append(",");
		sb.append(getProductNumber() == null ? "" : getProductNumber());
		sb.append(",");
		sb.append(getProductUnit() == null ? "" : getProductUnit());
		sb.append(",");
		sb.append(getPreTechnicalIndicator() == null ? "" : getPreTechnicalIndicator());
		sb.append(",");
		sb.append(getProductSpecification() == null ? "" : getProductSpecification());
		sb.append(",");
		sb.append(getInquiryTechnicalIndicator() == null ? "" : getInquiryTechnicalIndicator());
		sb.append(",");
		sb.append(getPersonInCharge() == null ? "" : getPersonInCharge());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getProductPrice() == null ? "" : getProductPrice());
		sb.append(",");
		sb.append(getTotalPrice() == null ? "" : getTotalPrice());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getIsPass() == null ? "" : getIsPass());
		sb.append(",");
		sb.append(getTaxPoints() == null ? "" : getTaxPoints());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProductInquiryDetail o) {
		return __product_inquiry_detail_id == null ? -1 : __product_inquiry_detail_id.compareTo(o.getProductInquiryDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__product_inquiry_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__product_inquiry_total_id);
		hash = 97 * hash + Objects.hashCode(this.__product_id);
		hash = 97 * hash + Objects.hashCode(this.__product_name);
		hash = 97 * hash + Objects.hashCode(this.__product_model);
		hash = 97 * hash + Objects.hashCode(this.__product_number);
		hash = 97 * hash + Objects.hashCode(this.__product_unit);
		hash = 97 * hash + Objects.hashCode(this.__pre_technical_indicator);
		hash = 97 * hash + Objects.hashCode(this.__product_specification);
		hash = 97 * hash + Objects.hashCode(this.__inquiry_technical_indicator);
		hash = 97 * hash + Objects.hashCode(this.__person_in_charge);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__product_price);
		hash = 97 * hash + Objects.hashCode(this.__total_price);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__is_pass);
		hash = 97 * hash + Objects.hashCode(this.__tax_points);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProductInquiryDetail o = (BaseProductInquiryDetail)obj;
		if(!Objects.equals(this.__product_inquiry_detail_id, o.getProductInquiryDetailId())) return false;
		if(!Objects.equals(this.__product_inquiry_total_id, o.getProductInquiryTotalId())) return false;
		if(!Objects.equals(this.__product_id, o.getProductId())) return false;
		if(!Objects.equals(this.__product_name, o.getProductName())) return false;
		if(!Objects.equals(this.__product_model, o.getProductModel())) return false;
		if(!Objects.equals(this.__product_number, o.getProductNumber())) return false;
		if(!Objects.equals(this.__product_unit, o.getProductUnit())) return false;
		if(!Objects.equals(this.__pre_technical_indicator, o.getPreTechnicalIndicator())) return false;
		if(!Objects.equals(this.__product_specification, o.getProductSpecification())) return false;
		if(!Objects.equals(this.__inquiry_technical_indicator, o.getInquiryTechnicalIndicator())) return false;
		if(!Objects.equals(this.__person_in_charge, o.getPersonInCharge())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__product_price, o.getProductPrice())) return false;
		if(!Objects.equals(this.__total_price, o.getTotalPrice())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__is_pass, o.getIsPass())) return false;
		if(!Objects.equals(this.__tax_points, o.getTaxPoints())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProductInquiryDetailId() != null) sb.append(__wrapNumber(count++, "productInquiryDetailId", getProductInquiryDetailId()));
		if(getProductInquiryTotalId() != null) sb.append(__wrapNumber(count++, "productInquiryTotalId", getProductInquiryTotalId()));
		if(getProductId() != null) sb.append(__wrapNumber(count++, "productId", getProductId()));
		if(getProductName() != null) sb.append(__wrapString(count++, "productName", getProductName()));
		if(getProductModel() != null) sb.append(__wrapString(count++, "productModel", getProductModel()));
		if(getProductNumber() != null) sb.append(__wrapNumber(count++, "productNumber", getProductNumber()));
		if(getProductUnit() != null) sb.append(__wrapString(count++, "productUnit", getProductUnit()));
		if(getPreTechnicalIndicator() != null) sb.append(__wrapString(count++, "preTechnicalIndicator", getPreTechnicalIndicator()));
		if(getProductSpecification() != null) sb.append(__wrapString(count++, "productSpecification", getProductSpecification()));
		if(getInquiryTechnicalIndicator() != null) sb.append(__wrapString(count++, "inquiryTechnicalIndicator", getInquiryTechnicalIndicator()));
		if(getPersonInCharge() != null) sb.append(__wrapNumber(count++, "personInCharge", getPersonInCharge()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProductPrice() != null) sb.append(__wrapDecimal(count++, "productPrice", getProductPrice()));
		if(getTotalPrice() != null) sb.append(__wrapDecimal(count++, "totalPrice", getTotalPrice()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getIsPass() != null) sb.append(__wrapBoolean(count++, "isPass", getIsPass()));
		if(getTaxPoints() != null) sb.append(__wrapDecimal(count++, "taxPoints", getTaxPoints()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProductInquiryDetailId() != null) res.put("productInquiryDetailId", getProductInquiryDetailId());
		if(getProductInquiryTotalId() != null) res.put("productInquiryTotalId", getProductInquiryTotalId());
		if(getProductId() != null) res.put("productId", getProductId());
		if(getProductName() != null) res.put("productName", getProductName());
		if(getProductModel() != null) res.put("productModel", getProductModel());
		if(getProductNumber() != null) res.put("productNumber", getProductNumber());
		if(getProductUnit() != null) res.put("productUnit", getProductUnit());
		if(getPreTechnicalIndicator() != null) res.put("preTechnicalIndicator", getPreTechnicalIndicator());
		if(getProductSpecification() != null) res.put("productSpecification", getProductSpecification());
		if(getInquiryTechnicalIndicator() != null) res.put("inquiryTechnicalIndicator", getInquiryTechnicalIndicator());
		if(getPersonInCharge() != null) res.put("personInCharge", getPersonInCharge());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getProductPrice() != null) res.put("productPrice", getProductPrice());
		if(getTotalPrice() != null) res.put("totalPrice", getTotalPrice());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getIsPass() != null) res.put("isPass", getIsPass());
		if(getTaxPoints() != null) res.put("taxPoints", getTaxPoints());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("productInquiryDetailId")) != null) setProductInquiryDetailId(__getInt(val)); 
		if((val = values.get("productInquiryTotalId")) != null) setProductInquiryTotalId(__getInt(val)); 
		if((val = values.get("productId")) != null) setProductId(__getInt(val)); 
		if((val = values.get("productName")) != null) setProductName(__getString(val));
		if((val = values.get("productModel")) != null) setProductModel(__getString(val));
		if((val = values.get("productNumber")) != null) setProductNumber(__getInt(val)); 
		if((val = values.get("productUnit")) != null) setProductUnit(__getString(val));
		if((val = values.get("preTechnicalIndicator")) != null) setPreTechnicalIndicator(__getString(val));
		if((val = values.get("productSpecification")) != null) setProductSpecification(__getString(val));
		if((val = values.get("inquiryTechnicalIndicator")) != null) setInquiryTechnicalIndicator(__getString(val));
		if((val = values.get("personInCharge")) != null) setPersonInCharge(__getInt(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("productPrice")) != null) setProductPrice(__getDecimal(val));  
		if((val = values.get("totalPrice")) != null) setTotalPrice(__getDecimal(val));  
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("isPass")) != null) setIsPass(__getBoolean(val));
		if((val = values.get("taxPoints")) != null) setTaxPoints(__getDecimal(val));  
	}

	protected java.lang.Integer  __product_inquiry_detail_id ;
	protected java.lang.Integer  __product_inquiry_total_id ;
	protected java.lang.Integer  __product_id ;
	protected java.lang.String  __product_name ;
	protected java.lang.String  __product_model ;
	protected java.lang.Integer  __product_number ;
	protected java.lang.String  __product_unit ;
	protected java.lang.String  __pre_technical_indicator ;
	protected java.lang.String  __product_specification ;
	protected java.lang.String  __inquiry_technical_indicator ;
	protected java.lang.Integer  __person_in_charge ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
	protected java.math.BigDecimal  __product_price ;
	protected java.math.BigDecimal  __total_price ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Boolean  __is_pass ;
	protected java.math.BigDecimal  __tax_points ;
}
