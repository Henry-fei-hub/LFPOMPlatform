package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnResourcePrais extends GenericBase implements BaseFactory<BaseCnResourcePrais>, Comparable<BaseCnResourcePrais> 
{


	public static BaseCnResourcePrais newInstance(){
		return new BaseCnResourcePrais();
	}

	@Override
	public BaseCnResourcePrais make(){
		BaseCnResourcePrais b = new BaseCnResourcePrais();
		return b;
	}

	public final static java.lang.String CS_RESOURCE_PRAISE_ID = "resource_praise_id" ;
	public final static java.lang.String CS_RESOURCE_ID = "resource_id" ;
	public final static java.lang.String CS_CREATOR = "creator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,资源主键,创建人,创建时间,组织机构代码";

	public java.lang.Integer getResourcePraiseId() {
		return this.__resource_praise_id;
	}

	public void setResourcePraiseId( java.lang.Integer value ) {
		this.__resource_praise_id = value;
	}

	public java.lang.Integer getResourceId() {
		return this.__resource_id;
	}

	public void setResourceId( java.lang.Integer value ) {
		this.__resource_id = value;
	}

	public java.lang.Integer getCreator() {
		return this.__creator;
	}

	public void setCreator( java.lang.Integer value ) {
		this.__creator = value;
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

	public void cloneCopy(BaseCnResourcePrais __bean){
		__bean.setResourcePraiseId(getResourcePraiseId());
		__bean.setResourceId(getResourceId());
		__bean.setCreator(getCreator());
		__bean.setCreateTime(getCreateTime());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getResourcePraiseId() == null ? "" : getResourcePraiseId());
		sb.append(",");
		sb.append(getResourceId() == null ? "" : getResourceId());
		sb.append(",");
		sb.append(getCreator() == null ? "" : getCreator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnResourcePrais o) {
		return __resource_praise_id == null ? -1 : __resource_praise_id.compareTo(o.getResourcePraiseId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__resource_praise_id);
		hash = 97 * hash + Objects.hashCode(this.__resource_id);
		hash = 97 * hash + Objects.hashCode(this.__creator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnResourcePrais o = (BaseCnResourcePrais)obj;
		if(!Objects.equals(this.__resource_praise_id, o.getResourcePraiseId())) return false;
		if(!Objects.equals(this.__resource_id, o.getResourceId())) return false;
		if(!Objects.equals(this.__creator, o.getCreator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getResourcePraiseId() != null) sb.append(__wrapNumber(count++, "resourcePraiseId", getResourcePraiseId()));
		if(getResourceId() != null) sb.append(__wrapNumber(count++, "resourceId", getResourceId()));
		if(getCreator() != null) sb.append(__wrapNumber(count++, "creator", getCreator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getResourcePraiseId() != null) res.put("resourcePraiseId", getResourcePraiseId());
		if(getResourceId() != null) res.put("resourceId", getResourceId());
		if(getCreator() != null) res.put("creator", getCreator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("resourcePraiseId")) != null) setResourcePraiseId(__getInt(val)); 
		if((val = values.get("resourceId")) != null) setResourceId(__getInt(val)); 
		if((val = values.get("creator")) != null) setCreator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __resource_praise_id ;
	protected java.lang.Integer  __resource_id ;
	protected java.lang.Integer  __creator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __organization_id ;
}
