package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectTemplate extends GenericBase implements BaseFactory<BaseProjectTemplate>, Comparable<BaseProjectTemplate> 
{


	public static BaseProjectTemplate newInstance(){
		return new BaseProjectTemplate();
	}

	@Override
	public BaseProjectTemplate make(){
		BaseProjectTemplate b = new BaseProjectTemplate();
		return b;
	}

	public final static java.lang.String CS_PROJECT_TEMPLATE_ID = "project_template_id" ;
	public final static java.lang.String CS_PROJECT_TEMPLATE_NAME = "project_template_name" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;

	public final static java.lang.String ALL_CAPTIONS = ",,,,";

	public java.lang.Integer getProjectTemplateId() {
		return this.__project_template_id;
	}

	public void setProjectTemplateId( java.lang.Integer value ) {
		this.__project_template_id = value;
	}

	public java.lang.String getProjectTemplateName() {
		return this.__project_template_name;
	}

	public void setProjectTemplateName( java.lang.String value ) {
		this.__project_template_name = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public void cloneCopy(BaseProjectTemplate __bean){
		__bean.setProjectTemplateId(getProjectTemplateId());
		__bean.setProjectTemplateName(getProjectTemplateName());
		__bean.setProjectType(getProjectType());
		__bean.setPlateId(getPlateId());
		__bean.setBusinessType(getBusinessType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectTemplateId() == null ? "" : getProjectTemplateId());
		sb.append(",");
		sb.append(getProjectTemplateName() == null ? "" : getProjectTemplateName());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectTemplate o) {
		return __project_template_id == null ? -1 : __project_template_id.compareTo(o.getProjectTemplateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_template_id);
		hash = 97 * hash + Objects.hashCode(this.__project_template_name);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectTemplate o = (BaseProjectTemplate)obj;
		if(!Objects.equals(this.__project_template_id, o.getProjectTemplateId())) return false;
		if(!Objects.equals(this.__project_template_name, o.getProjectTemplateName())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectTemplateId() != null) sb.append(__wrapNumber(count++, "projectTemplateId", getProjectTemplateId()));
		if(getProjectTemplateName() != null) sb.append(__wrapString(count++, "projectTemplateName", getProjectTemplateName()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectTemplateId")) != null) setProjectTemplateId(__getInt(val)); 
		if((val = values.get("projectTemplateName")) != null) setProjectTemplateName(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
	}

	protected java.lang.Integer  __project_template_id ;
	protected java.lang.String  __project_template_name ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __business_type ;
}
