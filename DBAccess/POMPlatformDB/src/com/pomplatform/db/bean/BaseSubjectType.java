package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSubjectType extends GenericBase implements BaseFactory<BaseSubjectType>, Comparable<BaseSubjectType> 
{


	public static BaseSubjectType newInstance(){
		return new BaseSubjectType();
	}

	@Override
	public BaseSubjectType make(){
		BaseSubjectType b = new BaseSubjectType();
		return b;
	}

	public final static java.lang.String CS_SUBJECT_TYPE_ID = "subject_type_id" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_SUBJECT_NAME = "subject_name" ;
	public final static java.lang.String CS_IS_ENABLED = "is_enabled" ;

	public final static java.lang.String ALL_CAPTIONS = ",父级编码,科目名称,是否启用";

	public java.lang.Integer getSubjectTypeId() {
		return this.__subject_type_id;
	}

	public void setSubjectTypeId( java.lang.Integer value ) {
		this.__subject_type_id = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getSubjectName() {
		return this.__subject_name;
	}

	public void setSubjectName( java.lang.String value ) {
		this.__subject_name = value;
	}

	public java.lang.Boolean getIsEnabled() {
		return this.__is_enabled;
	}

	public void setIsEnabled( java.lang.Boolean value ) {
		this.__is_enabled = value;
	}

	public void cloneCopy(BaseSubjectType __bean){
		__bean.setSubjectTypeId(getSubjectTypeId());
		__bean.setParentId(getParentId());
		__bean.setSubjectName(getSubjectName());
		__bean.setIsEnabled(getIsEnabled());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSubjectTypeId() == null ? "" : getSubjectTypeId());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getSubjectName() == null ? "" : getSubjectName());
		sb.append(",");
		sb.append(getIsEnabled() == null ? "" : getIsEnabled());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSubjectType o) {
		return __subject_type_id == null ? -1 : __subject_type_id.compareTo(o.getSubjectTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__subject_type_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__subject_name);
		hash = 97 * hash + Objects.hashCode(this.__is_enabled);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSubjectType o = (BaseSubjectType)obj;
		if(!Objects.equals(this.__subject_type_id, o.getSubjectTypeId())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__subject_name, o.getSubjectName())) return false;
		if(!Objects.equals(this.__is_enabled, o.getIsEnabled())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSubjectTypeId() != null) sb.append(__wrapNumber(count++, "subjectTypeId", getSubjectTypeId()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getSubjectName() != null) sb.append(__wrapString(count++, "subjectName", getSubjectName()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(count++, "isEnabled", getIsEnabled()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("subjectTypeId")) != null) setSubjectTypeId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("subjectName")) != null) setSubjectName(__getString(val));
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
	}

	protected java.lang.Integer  __subject_type_id ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __subject_name ;
	protected java.lang.Boolean  __is_enabled ;
}
