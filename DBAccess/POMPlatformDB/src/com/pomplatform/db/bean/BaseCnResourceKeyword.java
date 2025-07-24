package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnResourceKeyword extends GenericBase implements BaseFactory<BaseCnResourceKeyword>, Comparable<BaseCnResourceKeyword> 
{


	public static BaseCnResourceKeyword newInstance(){
		return new BaseCnResourceKeyword();
	}

	@Override
	public BaseCnResourceKeyword make(){
		BaseCnResourceKeyword b = new BaseCnResourceKeyword();
		return b;
	}

	public final static java.lang.String CS_RESOURCE_KEYWORD_ID = "resource_keyword_id" ;
	public final static java.lang.String CS_KEY_NAME = "key_name" ;
	public final static java.lang.String CS_RESOURCE_ID = "resource_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,关键字,资源主键,创建时间,组织机构代码";

	public java.lang.Integer getResourceKeywordId() {
		return this.__resource_keyword_id;
	}

	public void setResourceKeywordId( java.lang.Integer value ) {
		this.__resource_keyword_id = value;
	}

	public java.lang.String getKeyName() {
		return this.__key_name;
	}

	public void setKeyName( java.lang.String value ) {
		this.__key_name = value;
	}

	public java.lang.Integer getResourceId() {
		return this.__resource_id;
	}

	public void setResourceId( java.lang.Integer value ) {
		this.__resource_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getOrganizationId() {
		return this.__organization_id;
	}

	public void setOrganizationId( java.lang.Integer value ) {
		this.__organization_id = value;
	}

	public void cloneCopy(BaseCnResourceKeyword __bean){
		__bean.setResourceKeywordId(getResourceKeywordId());
		__bean.setKeyName(getKeyName());
		__bean.setResourceId(getResourceId());
		__bean.setCreateTime(getCreateTime());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getResourceKeywordId() == null ? "" : getResourceKeywordId());
		sb.append(",");
		sb.append(getKeyName() == null ? "" : getKeyName());
		sb.append(",");
		sb.append(getResourceId() == null ? "" : getResourceId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnResourceKeyword o) {
		return __resource_keyword_id == null ? -1 : __resource_keyword_id.compareTo(o.getResourceKeywordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__resource_keyword_id);
		hash = 97 * hash + Objects.hashCode(this.__key_name);
		hash = 97 * hash + Objects.hashCode(this.__resource_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnResourceKeyword o = (BaseCnResourceKeyword)obj;
		if(!Objects.equals(this.__resource_keyword_id, o.getResourceKeywordId())) return false;
		if(!Objects.equals(this.__key_name, o.getKeyName())) return false;
		if(!Objects.equals(this.__resource_id, o.getResourceId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getResourceKeywordId() != null) sb.append(__wrapNumber(count++, "resourceKeywordId", getResourceKeywordId()));
		if(getKeyName() != null) sb.append(__wrapString(count++, "keyName", getKeyName()));
		if(getResourceId() != null) sb.append(__wrapNumber(count++, "resourceId", getResourceId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getResourceKeywordId() != null) res.put("resourceKeywordId", getResourceKeywordId());
		if(getKeyName() != null) res.put("keyName", getKeyName());
		if(getResourceId() != null) res.put("resourceId", getResourceId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("resourceKeywordId")) != null) setResourceKeywordId(__getInt(val)); 
		if((val = values.get("keyName")) != null) setKeyName(__getString(val));
		if((val = values.get("resourceId")) != null) setResourceId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __resource_keyword_id ;
	protected java.lang.String  __key_name ;
	protected java.lang.Integer  __resource_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __organization_id ;
}
