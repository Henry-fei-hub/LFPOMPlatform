package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseprojectQuoteAreaRange extends GenericBase implements BaseFactory<BaseprojectQuoteAreaRange>, Comparable<BaseprojectQuoteAreaRange> 
{


	public static BaseprojectQuoteAreaRange newInstance(){
		return new BaseprojectQuoteAreaRange();
	}

	@Override
	public BaseprojectQuoteAreaRange make(){
		BaseprojectQuoteAreaRange b = new BaseprojectQuoteAreaRange();
		return b;
	}

	public final static java.lang.String CS_PROJECT_QUOTE_AREA_RANGE_ID = "project_quote_area_range_id" ;
	public final static java.lang.String CS_PROJECT_QUOTE_TEMPLATES_PARENT_ID = "project_quote_templates_parent_id" ;
	public final static java.lang.String CS_PROJECT_QUOTE_TEMPLATE_ID = "project_quote_template_id" ;
	public final static java.lang.String CS_AREA_RANGE_START = "area_range_start" ;
	public final static java.lang.String CS_AREA_RANGE_END = "area_range_end" ;
	public final static java.lang.String CS_AREA_PRICE = "area_price" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目报价模板父级表编码,项目报价模板表主键编码,面积范围起,面积范围止,面积单价,备注";

	public java.lang.Integer getProjectQuoteAreaRangeId() {
		return this.__project_quote_area_range_id;
	}

	public void setProjectQuoteAreaRangeId( java.lang.Integer value ) {
		this.__project_quote_area_range_id = value;
	}

	public java.lang.Integer getProjectQuoteTemplatesParentId() {
		return this.__project_quote_templates_parent_id;
	}

	public void setProjectQuoteTemplatesParentId( java.lang.Integer value ) {
		this.__project_quote_templates_parent_id = value;
	}

	public java.lang.Integer getProjectQuoteTemplateId() {
		return this.__project_quote_template_id;
	}

	public void setProjectQuoteTemplateId( java.lang.Integer value ) {
		this.__project_quote_template_id = value;
	}

	public java.math.BigDecimal getAreaRangeStart() {
		return this.__area_range_start;
	}

	public void setAreaRangeStart( java.math.BigDecimal value ) {
		this.__area_range_start = value;
	}

	public java.math.BigDecimal getAreaRangeEnd() {
		return this.__area_range_end;
	}

	public void setAreaRangeEnd( java.math.BigDecimal value ) {
		this.__area_range_end = value;
	}

	public java.math.BigDecimal getAreaPrice() {
		return this.__area_price;
	}

	public void setAreaPrice( java.math.BigDecimal value ) {
		this.__area_price = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseprojectQuoteAreaRange __bean){
		__bean.setProjectQuoteAreaRangeId(getProjectQuoteAreaRangeId());
		__bean.setProjectQuoteTemplatesParentId(getProjectQuoteTemplatesParentId());
		__bean.setProjectQuoteTemplateId(getProjectQuoteTemplateId());
		__bean.setAreaRangeStart(getAreaRangeStart());
		__bean.setAreaRangeEnd(getAreaRangeEnd());
		__bean.setAreaPrice(getAreaPrice());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectQuoteAreaRangeId() == null ? "" : getProjectQuoteAreaRangeId());
		sb.append(",");
		sb.append(getProjectQuoteTemplatesParentId() == null ? "" : getProjectQuoteTemplatesParentId());
		sb.append(",");
		sb.append(getProjectQuoteTemplateId() == null ? "" : getProjectQuoteTemplateId());
		sb.append(",");
		sb.append(getAreaRangeStart() == null ? "" : getAreaRangeStart());
		sb.append(",");
		sb.append(getAreaRangeEnd() == null ? "" : getAreaRangeEnd());
		sb.append(",");
		sb.append(getAreaPrice() == null ? "" : getAreaPrice());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseprojectQuoteAreaRange o) {
		return __project_quote_area_range_id == null ? -1 : __project_quote_area_range_id.compareTo(o.getProjectQuoteAreaRangeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_quote_area_range_id);
		hash = 97 * hash + Objects.hashCode(this.__project_quote_templates_parent_id);
		hash = 97 * hash + Objects.hashCode(this.__project_quote_template_id);
		hash = 97 * hash + Objects.hashCode(this.__area_range_start);
		hash = 97 * hash + Objects.hashCode(this.__area_range_end);
		hash = 97 * hash + Objects.hashCode(this.__area_price);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseprojectQuoteAreaRange o = (BaseprojectQuoteAreaRange)obj;
		if(!Objects.equals(this.__project_quote_area_range_id, o.getProjectQuoteAreaRangeId())) return false;
		if(!Objects.equals(this.__project_quote_templates_parent_id, o.getProjectQuoteTemplatesParentId())) return false;
		if(!Objects.equals(this.__project_quote_template_id, o.getProjectQuoteTemplateId())) return false;
		if(!Objects.equals(this.__area_range_start, o.getAreaRangeStart())) return false;
		if(!Objects.equals(this.__area_range_end, o.getAreaRangeEnd())) return false;
		if(!Objects.equals(this.__area_price, o.getAreaPrice())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectQuoteAreaRangeId() != null) sb.append(__wrapNumber(count++, "projectQuoteAreaRangeId", getProjectQuoteAreaRangeId()));
		if(getProjectQuoteTemplatesParentId() != null) sb.append(__wrapNumber(count++, "projectQuoteTemplatesParentId", getProjectQuoteTemplatesParentId()));
		if(getProjectQuoteTemplateId() != null) sb.append(__wrapNumber(count++, "projectQuoteTemplateId", getProjectQuoteTemplateId()));
		if(getAreaRangeStart() != null) sb.append(__wrapDecimal(count++, "areaRangeStart", getAreaRangeStart()));
		if(getAreaRangeEnd() != null) sb.append(__wrapDecimal(count++, "areaRangeEnd", getAreaRangeEnd()));
		if(getAreaPrice() != null) sb.append(__wrapDecimal(count++, "areaPrice", getAreaPrice()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectQuoteAreaRangeId")) != null) setProjectQuoteAreaRangeId(__getInt(val)); 
		if((val = values.get("projectQuoteTemplatesParentId")) != null) setProjectQuoteTemplatesParentId(__getInt(val)); 
		if((val = values.get("projectQuoteTemplateId")) != null) setProjectQuoteTemplateId(__getInt(val)); 
		if((val = values.get("areaRangeStart")) != null) setAreaRangeStart(__getDecimal(val));  
		if((val = values.get("areaRangeEnd")) != null) setAreaRangeEnd(__getDecimal(val));  
		if((val = values.get("areaPrice")) != null) setAreaPrice(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_quote_area_range_id ;
	protected java.lang.Integer  __project_quote_templates_parent_id ;
	protected java.lang.Integer  __project_quote_template_id ;
	protected java.math.BigDecimal  __area_range_start ;
	protected java.math.BigDecimal  __area_range_end ;
	protected java.math.BigDecimal  __area_price ;
	protected java.lang.String  __remark ;
}
