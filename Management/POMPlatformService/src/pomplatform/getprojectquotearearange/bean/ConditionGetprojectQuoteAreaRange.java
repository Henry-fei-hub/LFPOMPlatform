package pomplatform.getprojectquotearearange.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetprojectQuoteAreaRange extends GenericCondition{

	public ConditionGetprojectQuoteAreaRange(){
		setParameterCount(3);
	}

	public java.math.BigDecimal getAreaRange() {
		return this.__area_range;
	}

	public void setAreaRange( java.math.BigDecimal value ) {
		this.__area_range = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAreaRange() != null) sb.append(__wrapNumber(1, "areaRange", getAreaRange()));
		if(getProjectQuoteTemplatesParentId() != null) sb.append(__wrapNumber(1, "projectQuoteTemplatesParentId", getProjectQuoteTemplatesParentId()));
		if(getProjectQuoteTemplateId() != null) sb.append(__wrapNumber(1, "projectQuoteTemplateId", getProjectQuoteTemplateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("areaRange")) != null) setAreaRange(__getDecimal(val));  
		if((val = values.get("projectQuoteTemplatesParentId")) != null) setProjectQuoteTemplatesParentId(__getInt(val)); 
		if((val = values.get("projectQuoteTemplateId")) != null) setProjectQuoteTemplateId(__getInt(val)); 
	}

	private java.math.BigDecimal __area_range = null;
	private java.lang.Integer __project_quote_templates_parent_id = null;
	private java.lang.Integer __project_quote_template_id = null;
}

