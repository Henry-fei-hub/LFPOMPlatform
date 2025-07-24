package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectQuoteDetail extends GenericBase implements BaseFactory<BaseProjectQuoteDetail>, Comparable<BaseProjectQuoteDetail> 
{


	public static BaseProjectQuoteDetail newInstance(){
		return new BaseProjectQuoteDetail();
	}

	@Override
	public BaseProjectQuoteDetail make(){
		BaseProjectQuoteDetail b = new BaseProjectQuoteDetail();
		return b;
	}

	public final static java.lang.String CS_PROJECT_QUOTE_DETAIL_ID = "project_quote_detail_id" ;
	public final static java.lang.String CS_PROJECT_QUOTE_ID = "project_quote_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_DESIGN_TYPE_NAME = "design_type_name" ;
	public final static java.lang.String CS_DESIGN_CONTENT = "design_content" ;
	public final static java.lang.String CS_DESIGN_STAGE = "design_stage" ;
	public final static java.lang.String CS_AREA_TYPE = "area_type" ;
	public final static java.lang.String CS_AREA = "area" ;
	public final static java.lang.String CS_AREA_PRICE = "area_price" ;
	public final static java.lang.String CS_TOTAL_PRICE = "total_price" ;
	public final static java.lang.String CS_TAX = "tax" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目报价,项目id,业务类别,设计类型名称,设计内容,设计阶段,面积类型,面积,单价,小计,税率,备注,公司编码";

	public java.lang.Integer getProjectQuoteDetailId() {
		return this.__project_quote_detail_id;
	}

	public void setProjectQuoteDetailId( java.lang.Integer value ) {
		this.__project_quote_detail_id = value;
	}

	public java.lang.Integer getProjectQuoteId() {
		return this.__project_quote_id;
	}

	public void setProjectQuoteId( java.lang.Integer value ) {
		this.__project_quote_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.String getDesignTypeName() {
		return this.__design_type_name;
	}

	public void setDesignTypeName( java.lang.String value ) {
		this.__design_type_name = value;
	}

	public java.lang.String getDesignContent() {
		return this.__design_content;
	}

	public void setDesignContent( java.lang.String value ) {
		this.__design_content = value;
	}

	public java.lang.Integer getDesignStage() {
		return this.__design_stage;
	}

	public void setDesignStage( java.lang.Integer value ) {
		this.__design_stage = value;
	}

	public java.lang.Integer getAreaType() {
		return this.__area_type;
	}

	public void setAreaType( java.lang.Integer value ) {
		this.__area_type = value;
	}

	public java.math.BigDecimal getArea() {
		return this.__area;
	}

	public void setArea( java.math.BigDecimal value ) {
		this.__area = value;
	}

	public java.math.BigDecimal getAreaPrice() {
		return this.__area_price;
	}

	public void setAreaPrice( java.math.BigDecimal value ) {
		this.__area_price = value;
	}

	public java.math.BigDecimal getTotalPrice() {
		return this.__total_price;
	}

	public void setTotalPrice( java.math.BigDecimal value ) {
		this.__total_price = value;
	}

	public java.math.BigDecimal getTax() {
		return this.__tax;
	}

	public void setTax( java.math.BigDecimal value ) {
		this.__tax = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public void cloneCopy(BaseProjectQuoteDetail __bean){
		__bean.setProjectQuoteDetailId(getProjectQuoteDetailId());
		__bean.setProjectQuoteId(getProjectQuoteId());
		__bean.setProjectId(getProjectId());
		__bean.setBusinessType(getBusinessType());
		__bean.setDesignTypeName(getDesignTypeName());
		__bean.setDesignContent(getDesignContent());
		__bean.setDesignStage(getDesignStage());
		__bean.setAreaType(getAreaType());
		__bean.setArea(getArea());
		__bean.setAreaPrice(getAreaPrice());
		__bean.setTotalPrice(getTotalPrice());
		__bean.setTax(getTax());
		__bean.setRemark(getRemark());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectQuoteDetailId() == null ? "" : getProjectQuoteDetailId());
		sb.append(",");
		sb.append(getProjectQuoteId() == null ? "" : getProjectQuoteId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getDesignTypeName() == null ? "" : getDesignTypeName());
		sb.append(",");
		sb.append(getDesignContent() == null ? "" : getDesignContent());
		sb.append(",");
		sb.append(getDesignStage() == null ? "" : getDesignStage());
		sb.append(",");
		sb.append(getAreaType() == null ? "" : getAreaType());
		sb.append(",");
		sb.append(getArea() == null ? "" : getArea());
		sb.append(",");
		sb.append(getAreaPrice() == null ? "" : getAreaPrice());
		sb.append(",");
		sb.append(getTotalPrice() == null ? "" : getTotalPrice());
		sb.append(",");
		sb.append(getTax() == null ? "" : getTax());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectQuoteDetail o) {
		return __project_quote_detail_id == null ? -1 : __project_quote_detail_id.compareTo(o.getProjectQuoteDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_quote_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__project_quote_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__design_type_name);
		hash = 97 * hash + Objects.hashCode(this.__design_content);
		hash = 97 * hash + Objects.hashCode(this.__design_stage);
		hash = 97 * hash + Objects.hashCode(this.__area_type);
		hash = 97 * hash + Objects.hashCode(this.__area);
		hash = 97 * hash + Objects.hashCode(this.__area_price);
		hash = 97 * hash + Objects.hashCode(this.__total_price);
		hash = 97 * hash + Objects.hashCode(this.__tax);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectQuoteDetail o = (BaseProjectQuoteDetail)obj;
		if(!Objects.equals(this.__project_quote_detail_id, o.getProjectQuoteDetailId())) return false;
		if(!Objects.equals(this.__project_quote_id, o.getProjectQuoteId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__design_type_name, o.getDesignTypeName())) return false;
		if(!Objects.equals(this.__design_content, o.getDesignContent())) return false;
		if(!Objects.equals(this.__design_stage, o.getDesignStage())) return false;
		if(!Objects.equals(this.__area_type, o.getAreaType())) return false;
		if(!Objects.equals(this.__area, o.getArea())) return false;
		if(!Objects.equals(this.__area_price, o.getAreaPrice())) return false;
		if(!Objects.equals(this.__total_price, o.getTotalPrice())) return false;
		if(!Objects.equals(this.__tax, o.getTax())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectQuoteDetailId() != null) sb.append(__wrapNumber(count++, "projectQuoteDetailId", getProjectQuoteDetailId()));
		if(getProjectQuoteId() != null) sb.append(__wrapNumber(count++, "projectQuoteId", getProjectQuoteId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getDesignTypeName() != null) sb.append(__wrapString(count++, "designTypeName", getDesignTypeName()));
		if(getDesignContent() != null) sb.append(__wrapString(count++, "designContent", getDesignContent()));
		if(getDesignStage() != null) sb.append(__wrapNumber(count++, "designStage", getDesignStage()));
		if(getAreaType() != null) sb.append(__wrapNumber(count++, "areaType", getAreaType()));
		if(getArea() != null) sb.append(__wrapDecimal(count++, "area", getArea()));
		if(getAreaPrice() != null) sb.append(__wrapDecimal(count++, "areaPrice", getAreaPrice()));
		if(getTotalPrice() != null) sb.append(__wrapDecimal(count++, "totalPrice", getTotalPrice()));
		if(getTax() != null) sb.append(__wrapDecimal(count++, "tax", getTax()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectQuoteDetailId")) != null) setProjectQuoteDetailId(__getInt(val)); 
		if((val = values.get("projectQuoteId")) != null) setProjectQuoteId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("designTypeName")) != null) setDesignTypeName(__getString(val));
		if((val = values.get("designContent")) != null) setDesignContent(__getString(val));
		if((val = values.get("designStage")) != null) setDesignStage(__getInt(val)); 
		if((val = values.get("areaType")) != null) setAreaType(__getInt(val)); 
		if((val = values.get("area")) != null) setArea(__getDecimal(val));  
		if((val = values.get("areaPrice")) != null) setAreaPrice(__getDecimal(val));  
		if((val = values.get("totalPrice")) != null) setTotalPrice(__getDecimal(val));  
		if((val = values.get("tax")) != null) setTax(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_quote_detail_id ;
	protected java.lang.Integer  __project_quote_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.String  __design_type_name ;
	protected java.lang.String  __design_content ;
	protected java.lang.Integer  __design_stage ;
	protected java.lang.Integer  __area_type ;
	protected java.math.BigDecimal  __area ;
	protected java.math.BigDecimal  __area_price ;
	protected java.math.BigDecimal  __total_price ;
	protected java.math.BigDecimal  __tax ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __company_id ;
}
