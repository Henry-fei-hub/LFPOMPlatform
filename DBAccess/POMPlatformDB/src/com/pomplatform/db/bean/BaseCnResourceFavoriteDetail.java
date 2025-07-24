package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnResourceFavoriteDetail extends GenericBase implements BaseFactory<BaseCnResourceFavoriteDetail>, Comparable<BaseCnResourceFavoriteDetail> 
{


	public static BaseCnResourceFavoriteDetail newInstance(){
		return new BaseCnResourceFavoriteDetail();
	}

	@Override
	public BaseCnResourceFavoriteDetail make(){
		BaseCnResourceFavoriteDetail b = new BaseCnResourceFavoriteDetail();
		return b;
	}

	public final static java.lang.String CS_RESOURCE_FAVORITE_DETAIL_ID = "resource_favorite_detail_id" ;
	public final static java.lang.String CS_RESOURCE_FAVORITE_ID = "resource_favorite_id" ;
	public final static java.lang.String CS_RESOURCE_ID = "resource_id" ;
	public final static java.lang.String CS_DESCRIPTION = "description" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,收藏夹主键,资源主键,描述,创建时间,组织机构代码";

	public java.lang.Integer getResourceFavoriteDetailId() {
		return this.__resource_favorite_detail_id;
	}

	public void setResourceFavoriteDetailId( java.lang.Integer value ) {
		this.__resource_favorite_detail_id = value;
	}

	public java.lang.Integer getResourceFavoriteId() {
		return this.__resource_favorite_id;
	}

	public void setResourceFavoriteId( java.lang.Integer value ) {
		this.__resource_favorite_id = value;
	}

	public java.lang.Integer getResourceId() {
		return this.__resource_id;
	}

	public void setResourceId( java.lang.Integer value ) {
		this.__resource_id = value;
	}

	public java.lang.String getDescription() {
		return this.__description;
	}

	public void setDescription( java.lang.String value ) {
		this.__description = value;
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

	public void cloneCopy(BaseCnResourceFavoriteDetail __bean){
		__bean.setResourceFavoriteDetailId(getResourceFavoriteDetailId());
		__bean.setResourceFavoriteId(getResourceFavoriteId());
		__bean.setResourceId(getResourceId());
		__bean.setDescription(getDescription());
		__bean.setCreateTime(getCreateTime());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getResourceFavoriteDetailId() == null ? "" : getResourceFavoriteDetailId());
		sb.append(",");
		sb.append(getResourceFavoriteId() == null ? "" : getResourceFavoriteId());
		sb.append(",");
		sb.append(getResourceId() == null ? "" : getResourceId());
		sb.append(",");
		sb.append(getDescription() == null ? "" : getDescription());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnResourceFavoriteDetail o) {
		return __resource_favorite_detail_id == null ? -1 : __resource_favorite_detail_id.compareTo(o.getResourceFavoriteDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__resource_favorite_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__resource_favorite_id);
		hash = 97 * hash + Objects.hashCode(this.__resource_id);
		hash = 97 * hash + Objects.hashCode(this.__description);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnResourceFavoriteDetail o = (BaseCnResourceFavoriteDetail)obj;
		if(!Objects.equals(this.__resource_favorite_detail_id, o.getResourceFavoriteDetailId())) return false;
		if(!Objects.equals(this.__resource_favorite_id, o.getResourceFavoriteId())) return false;
		if(!Objects.equals(this.__resource_id, o.getResourceId())) return false;
		if(!Objects.equals(this.__description, o.getDescription())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getResourceFavoriteDetailId() != null) sb.append(__wrapNumber(count++, "resourceFavoriteDetailId", getResourceFavoriteDetailId()));
		if(getResourceFavoriteId() != null) sb.append(__wrapNumber(count++, "resourceFavoriteId", getResourceFavoriteId()));
		if(getResourceId() != null) sb.append(__wrapNumber(count++, "resourceId", getResourceId()));
		if(getDescription() != null) sb.append(__wrapString(count++, "description", getDescription()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getResourceFavoriteDetailId() != null) res.put("resourceFavoriteDetailId", getResourceFavoriteDetailId());
		if(getResourceFavoriteId() != null) res.put("resourceFavoriteId", getResourceFavoriteId());
		if(getResourceId() != null) res.put("resourceId", getResourceId());
		if(getDescription() != null) res.put("description", getDescription());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("resourceFavoriteDetailId")) != null) setResourceFavoriteDetailId(__getInt(val)); 
		if((val = values.get("resourceFavoriteId")) != null) setResourceFavoriteId(__getInt(val)); 
		if((val = values.get("resourceId")) != null) setResourceId(__getInt(val)); 
		if((val = values.get("description")) != null) setDescription(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __resource_favorite_detail_id ;
	protected java.lang.Integer  __resource_favorite_id ;
	protected java.lang.Integer  __resource_id ;
	protected java.lang.String  __description ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __organization_id ;
}
