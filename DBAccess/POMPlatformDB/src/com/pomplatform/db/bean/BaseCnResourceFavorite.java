package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnResourceFavorite extends GenericBase implements BaseFactory<BaseCnResourceFavorite>, Comparable<BaseCnResourceFavorite> 
{


	public static BaseCnResourceFavorite newInstance(){
		return new BaseCnResourceFavorite();
	}

	@Override
	public BaseCnResourceFavorite make(){
		BaseCnResourceFavorite b = new BaseCnResourceFavorite();
		return b;
	}

	public final static java.lang.String CS_RESOURCE_FAVORITE_ID = "resource_favorite_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_DESCRIPTION = "description" ;
	public final static java.lang.String CS_PRIVATE_STATUS = "private_status" ;
	public final static java.lang.String CS_CREATOR = "creator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,收藏夹类别,名称,描述,私密状态 1公开  2私密,创建人,创建时间,组织机构代码";

	public java.lang.Integer getResourceFavoriteId() {
		return this.__resource_favorite_id;
	}

	public void setResourceFavoriteId( java.lang.Integer value ) {
		this.__resource_favorite_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.String getDescription() {
		return this.__description;
	}

	public void setDescription( java.lang.String value ) {
		this.__description = value;
	}

	public java.lang.Integer getPrivateStatus() {
		return this.__private_status;
	}

	public void setPrivateStatus( java.lang.Integer value ) {
		this.__private_status = value;
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

	public void cloneCopy(BaseCnResourceFavorite __bean){
		__bean.setResourceFavoriteId(getResourceFavoriteId());
		__bean.setType(getType());
		__bean.setName(getName());
		__bean.setDescription(getDescription());
		__bean.setPrivateStatus(getPrivateStatus());
		__bean.setCreator(getCreator());
		__bean.setCreateTime(getCreateTime());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getResourceFavoriteId() == null ? "" : getResourceFavoriteId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getDescription() == null ? "" : getDescription());
		sb.append(",");
		sb.append(getPrivateStatus() == null ? "" : getPrivateStatus());
		sb.append(",");
		sb.append(getCreator() == null ? "" : getCreator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnResourceFavorite o) {
		return __resource_favorite_id == null ? -1 : __resource_favorite_id.compareTo(o.getResourceFavoriteId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__resource_favorite_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__description);
		hash = 97 * hash + Objects.hashCode(this.__private_status);
		hash = 97 * hash + Objects.hashCode(this.__creator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnResourceFavorite o = (BaseCnResourceFavorite)obj;
		if(!Objects.equals(this.__resource_favorite_id, o.getResourceFavoriteId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__description, o.getDescription())) return false;
		if(!Objects.equals(this.__private_status, o.getPrivateStatus())) return false;
		if(!Objects.equals(this.__creator, o.getCreator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getResourceFavoriteId() != null) sb.append(__wrapNumber(count++, "resourceFavoriteId", getResourceFavoriteId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getDescription() != null) sb.append(__wrapString(count++, "description", getDescription()));
		if(getPrivateStatus() != null) sb.append(__wrapNumber(count++, "privateStatus", getPrivateStatus()));
		if(getCreator() != null) sb.append(__wrapNumber(count++, "creator", getCreator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getResourceFavoriteId() != null) res.put("resourceFavoriteId", getResourceFavoriteId());
		if(getType() != null) res.put("type", getType());
		if(getName() != null) res.put("name", getName());
		if(getDescription() != null) res.put("description", getDescription());
		if(getPrivateStatus() != null) res.put("privateStatus", getPrivateStatus());
		if(getCreator() != null) res.put("creator", getCreator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("resourceFavoriteId")) != null) setResourceFavoriteId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("description")) != null) setDescription(__getString(val));
		if((val = values.get("privateStatus")) != null) setPrivateStatus(__getInt(val)); 
		if((val = values.get("creator")) != null) setCreator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __resource_favorite_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __name ;
	protected java.lang.String  __description ;
	protected java.lang.Integer  __private_status ;
	protected java.lang.Integer  __creator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __organization_id ;
}
