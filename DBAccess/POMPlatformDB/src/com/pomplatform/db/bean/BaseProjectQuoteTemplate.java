package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectQuoteTemplate extends GenericBase implements BaseFactory<BaseProjectQuoteTemplate>, Comparable<BaseProjectQuoteTemplate> 
{


	public static BaseProjectQuoteTemplate newInstance(){
		return new BaseProjectQuoteTemplate();
	}

	@Override
	public BaseProjectQuoteTemplate make(){
		BaseProjectQuoteTemplate b = new BaseProjectQuoteTemplate();
		return b;
	}

	public final static java.lang.String CS_PROJECT_QUOTE_TEMPLATE_ID = "project_quote_template_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_DESIGN_TYPE_NAME = "design_type_name" ;
	public final static java.lang.String CS_DESIGN_CONTENT = "design_content" ;
	public final static java.lang.String CS_DESIGN_STAGE = "design_stage" ;
	public final static java.lang.String CS_AREA_TYPE = "area_type" ;
	public final static java.lang.String CS_TAX = "tax" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PROJECT_QUOTE_TEMPLATES_PARENT_ID = "project_quote_templates_parent_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务类别id,父级id,设计类型名称,设计内容,设计阶段,面积类型,税率,公司id,操作时间,备注,项目报价模板父级表编码";

	public java.lang.Integer getProjectQuoteTemplateId() {
		return this.__project_quote_template_id;
	}

	public void setProjectQuoteTemplateId( java.lang.Integer value ) {
		this.__project_quote_template_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
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

	public java.math.BigDecimal getTax() {
		return this.__tax;
	}

	public void setTax( java.math.BigDecimal value ) {
		this.__tax = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getProjectQuoteTemplatesParentId() {
		return this.__project_quote_templates_parent_id;
	}

	public void setProjectQuoteTemplatesParentId( java.lang.Integer value ) {
		this.__project_quote_templates_parent_id = value;
	}

	public void cloneCopy(BaseProjectQuoteTemplate __bean){
		__bean.setProjectQuoteTemplateId(getProjectQuoteTemplateId());
		__bean.setBusinessType(getBusinessType());
		__bean.setParentId(getParentId());
		__bean.setDesignTypeName(getDesignTypeName());
		__bean.setDesignContent(getDesignContent());
		__bean.setDesignStage(getDesignStage());
		__bean.setAreaType(getAreaType());
		__bean.setTax(getTax());
		__bean.setCompanyId(getCompanyId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setProjectQuoteTemplatesParentId(getProjectQuoteTemplatesParentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectQuoteTemplateId() == null ? "" : getProjectQuoteTemplateId());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getDesignTypeName() == null ? "" : getDesignTypeName());
		sb.append(",");
		sb.append(getDesignContent() == null ? "" : getDesignContent());
		sb.append(",");
		sb.append(getDesignStage() == null ? "" : getDesignStage());
		sb.append(",");
		sb.append(getAreaType() == null ? "" : getAreaType());
		sb.append(",");
		sb.append(getTax() == null ? "" : getTax());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getProjectQuoteTemplatesParentId() == null ? "" : getProjectQuoteTemplatesParentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectQuoteTemplate o) {
		return __project_quote_template_id == null ? -1 : __project_quote_template_id.compareTo(o.getProjectQuoteTemplateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_quote_template_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__design_type_name);
		hash = 97 * hash + Objects.hashCode(this.__design_content);
		hash = 97 * hash + Objects.hashCode(this.__design_stage);
		hash = 97 * hash + Objects.hashCode(this.__area_type);
		hash = 97 * hash + Objects.hashCode(this.__tax);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__project_quote_templates_parent_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectQuoteTemplate o = (BaseProjectQuoteTemplate)obj;
		if(!Objects.equals(this.__project_quote_template_id, o.getProjectQuoteTemplateId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__design_type_name, o.getDesignTypeName())) return false;
		if(!Objects.equals(this.__design_content, o.getDesignContent())) return false;
		if(!Objects.equals(this.__design_stage, o.getDesignStage())) return false;
		if(!Objects.equals(this.__area_type, o.getAreaType())) return false;
		if(!Objects.equals(this.__tax, o.getTax())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__project_quote_templates_parent_id, o.getProjectQuoteTemplatesParentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectQuoteTemplateId() != null) sb.append(__wrapNumber(count++, "projectQuoteTemplateId", getProjectQuoteTemplateId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getDesignTypeName() != null) sb.append(__wrapString(count++, "designTypeName", getDesignTypeName()));
		if(getDesignContent() != null) sb.append(__wrapString(count++, "designContent", getDesignContent()));
		if(getDesignStage() != null) sb.append(__wrapNumber(count++, "designStage", getDesignStage()));
		if(getAreaType() != null) sb.append(__wrapNumber(count++, "areaType", getAreaType()));
		if(getTax() != null) sb.append(__wrapDecimal(count++, "tax", getTax()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProjectQuoteTemplatesParentId() != null) sb.append(__wrapNumber(count++, "projectQuoteTemplatesParentId", getProjectQuoteTemplatesParentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectQuoteTemplateId")) != null) setProjectQuoteTemplateId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("designTypeName")) != null) setDesignTypeName(__getString(val));
		if((val = values.get("designContent")) != null) setDesignContent(__getString(val));
		if((val = values.get("designStage")) != null) setDesignStage(__getInt(val)); 
		if((val = values.get("areaType")) != null) setAreaType(__getInt(val)); 
		if((val = values.get("tax")) != null) setTax(__getDecimal(val));  
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("projectQuoteTemplatesParentId")) != null) setProjectQuoteTemplatesParentId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_quote_template_id ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __design_type_name ;
	protected java.lang.String  __design_content ;
	protected java.lang.Integer  __design_stage ;
	protected java.lang.Integer  __area_type ;
	protected java.math.BigDecimal  __tax ;
	protected java.lang.Integer  __company_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __project_quote_templates_parent_id ;
}
