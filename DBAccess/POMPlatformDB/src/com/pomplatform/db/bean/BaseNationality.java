package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseNationality extends GenericBase implements BaseFactory<BaseNationality>, Comparable<BaseNationality> 
{


	public static BaseNationality newInstance(){
		return new BaseNationality();
	}

	@Override
	public BaseNationality make(){
		BaseNationality b = new BaseNationality();
		return b;
	}

	public final static java.lang.String CS_NATIONALITY_ID = "nationality_id" ;
	public final static java.lang.String CS_NATIONALITY_NAME = "nationality_name" ;
	public final static java.lang.String CS_IS_ENABLED = "is_enabled" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,民族,是否启用";

	public java.lang.Integer getNationalityId() {
		return this.__nationality_id;
	}

	public void setNationalityId( java.lang.Integer value ) {
		this.__nationality_id = value;
	}

	public java.lang.String getNationalityName() {
		return this.__nationality_name;
	}

	public void setNationalityName( java.lang.String value ) {
		this.__nationality_name = value;
	}

	public java.lang.Boolean getIsEnabled() {
		return this.__is_enabled;
	}

	public void setIsEnabled( java.lang.Boolean value ) {
		this.__is_enabled = value;
	}

	public void cloneCopy(BaseNationality __bean){
		__bean.setNationalityId(getNationalityId());
		__bean.setNationalityName(getNationalityName());
		__bean.setIsEnabled(getIsEnabled());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getNationalityId() == null ? "" : getNationalityId());
		sb.append(",");
		sb.append(getNationalityName() == null ? "" : getNationalityName());
		sb.append(",");
		sb.append(getIsEnabled() == null ? "" : getIsEnabled());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNationality o) {
		return __nationality_id == null ? -1 : __nationality_id.compareTo(o.getNationalityId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__nationality_id);
		hash = 97 * hash + Objects.hashCode(this.__nationality_name);
		hash = 97 * hash + Objects.hashCode(this.__is_enabled);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNationality o = (BaseNationality)obj;
		if(!Objects.equals(this.__nationality_id, o.getNationalityId())) return false;
		if(!Objects.equals(this.__nationality_name, o.getNationalityName())) return false;
		if(!Objects.equals(this.__is_enabled, o.getIsEnabled())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getNationalityId() != null) sb.append(__wrapNumber(count++, "nationalityId", getNationalityId()));
		if(getNationalityName() != null) sb.append(__wrapString(count++, "nationalityName", getNationalityName()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(count++, "isEnabled", getIsEnabled()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("nationalityId")) != null) setNationalityId(__getInt(val)); 
		if((val = values.get("nationalityName")) != null) setNationalityName(__getString(val));
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
	}

	protected java.lang.Integer  __nationality_id ;
	protected java.lang.String  __nationality_name ;
	protected java.lang.Boolean  __is_enabled ;
}
