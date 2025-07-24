package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFundraisingProjectType extends GenericBase implements BaseFactory<BaseFundraisingProjectType>, Comparable<BaseFundraisingProjectType> 
{


	public static BaseFundraisingProjectType newInstance(){
		return new BaseFundraisingProjectType();
	}

	@Override
	public BaseFundraisingProjectType make(){
		BaseFundraisingProjectType b = new BaseFundraisingProjectType();
		return b;
	}

	public final static java.lang.String CS_FUNDRAISING_PROJECT_TYPE_ID = "fundraising_project_type_id" ;
	public final static java.lang.String CS_FUNDRAISING_PROJECT_TYPE_NAME = "fundraising_project_type_name" ;

	public final static java.lang.String ALL_CAPTIONS = "募投项目的编码,募投项目名称";

	public java.lang.Integer getFundraisingProjectTypeId() {
		return this.__fundraising_project_type_id;
	}

	public void setFundraisingProjectTypeId( java.lang.Integer value ) {
		this.__fundraising_project_type_id = value;
	}

	public java.lang.String getFundraisingProjectTypeName() {
		return this.__fundraising_project_type_name;
	}

	public void setFundraisingProjectTypeName( java.lang.String value ) {
		this.__fundraising_project_type_name = value;
	}

	public void cloneCopy(BaseFundraisingProjectType __bean){
		__bean.setFundraisingProjectTypeId(getFundraisingProjectTypeId());
		__bean.setFundraisingProjectTypeName(getFundraisingProjectTypeName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFundraisingProjectTypeId() == null ? "" : getFundraisingProjectTypeId());
		sb.append(",");
		sb.append(getFundraisingProjectTypeName() == null ? "" : getFundraisingProjectTypeName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFundraisingProjectType o) {
		return __fundraising_project_type_id == null ? -1 : __fundraising_project_type_id.compareTo(o.getFundraisingProjectTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_type_id);
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_type_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFundraisingProjectType o = (BaseFundraisingProjectType)obj;
		if(!Objects.equals(this.__fundraising_project_type_id, o.getFundraisingProjectTypeId())) return false;
		if(!Objects.equals(this.__fundraising_project_type_name, o.getFundraisingProjectTypeName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFundraisingProjectTypeId() != null) sb.append(__wrapNumber(count++, "fundraisingProjectTypeId", getFundraisingProjectTypeId()));
		if(getFundraisingProjectTypeName() != null) sb.append(__wrapString(count++, "fundraisingProjectTypeName", getFundraisingProjectTypeName()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFundraisingProjectTypeId() != null) res.put("fundraisingProjectTypeId", getFundraisingProjectTypeId());
		if(getFundraisingProjectTypeName() != null) res.put("fundraisingProjectTypeName", getFundraisingProjectTypeName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fundraisingProjectTypeId")) != null) setFundraisingProjectTypeId(__getInt(val)); 
		if((val = values.get("fundraisingProjectTypeName")) != null) setFundraisingProjectTypeName(__getString(val));
	}

	protected java.lang.Integer  __fundraising_project_type_id ;
	protected java.lang.String  __fundraising_project_type_name ;
}
