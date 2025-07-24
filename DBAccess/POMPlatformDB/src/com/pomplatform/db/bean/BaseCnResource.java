package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnResource extends GenericBase implements BaseFactory<BaseCnResource>, Comparable<BaseCnResource> 
{


	public static BaseCnResource newInstance(){
		return new BaseCnResource();
	}

	@Override
	public BaseCnResource make(){
		BaseCnResource b = new BaseCnResource();
		return b;
	}

	public final static java.lang.String CS_RESOURCE_ID = "resource_id" ;
	public final static java.lang.String CS_RESOURCE_PACKAGE_ID = "resource_package_id" ;
	public final static java.lang.String CS_TITLE = "title" ;
	public final static java.lang.String CS_DESCRIPTION = "description" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_EXTERNAL_URL = "external_url" ;
	public final static java.lang.String CS_SOURCE_TYPE = "source_type" ;
	public final static java.lang.String CS_RESOURCE_TYPE = "resource_type" ;
	public final static java.lang.String CS_CREATOR = "creator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_FILE_MANAGE_ID = "file_manage_id" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,资源包主键,标题,描述,备注,外部链接,来源类型 1 手动添加 2 外部网站,资源类型 1 图片 2短视频,创建人,创建时间,关联文件,删除标志 0 未删除 1已删除,组织机构代码";

	public java.lang.Integer getResourceId() {
		return this.__resource_id;
	}

	public void setResourceId( java.lang.Integer value ) {
		this.__resource_id = value;
	}

	public java.lang.Integer getResourcePackageId() {
		return this.__resource_package_id;
	}

	public void setResourcePackageId( java.lang.Integer value ) {
		this.__resource_package_id = value;
	}

	public java.lang.String getTitle() {
		return this.__title;
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.String getDescription() {
		return this.__description;
	}

	public void setDescription( java.lang.String value ) {
		this.__description = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getExternalUrl() {
		return this.__external_url;
	}

	public void setExternalUrl( java.lang.String value ) {
		this.__external_url = value;
	}

	public java.lang.Integer getSourceType() {
		return this.__source_type;
	}

	public void setSourceType( java.lang.Integer value ) {
		this.__source_type = value;
	}

	public java.lang.Integer getResourceType() {
		return this.__resource_type;
	}

	public void setResourceType( java.lang.Integer value ) {
		this.__resource_type = value;
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

	public java.lang.Integer getFileManageId() {
		return this.__file_manage_id;
	}

	public void setFileManageId( java.lang.Integer value ) {
		this.__file_manage_id = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getOrganizationId() {
		return this.__organization_id;
	}

	public void setOrganizationId( java.lang.Integer value ) {
		this.__organization_id = value;
	}

	public void cloneCopy(BaseCnResource __bean){
		__bean.setResourceId(getResourceId());
		__bean.setResourcePackageId(getResourcePackageId());
		__bean.setTitle(getTitle());
		__bean.setDescription(getDescription());
		__bean.setRemark(getRemark());
		__bean.setExternalUrl(getExternalUrl());
		__bean.setSourceType(getSourceType());
		__bean.setResourceType(getResourceType());
		__bean.setCreator(getCreator());
		__bean.setCreateTime(getCreateTime());
		__bean.setFileManageId(getFileManageId());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getResourceId() == null ? "" : getResourceId());
		sb.append(",");
		sb.append(getResourcePackageId() == null ? "" : getResourcePackageId());
		sb.append(",");
		sb.append(getTitle() == null ? "" : getTitle());
		sb.append(",");
		sb.append(getDescription() == null ? "" : getDescription());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getExternalUrl() == null ? "" : getExternalUrl());
		sb.append(",");
		sb.append(getSourceType() == null ? "" : getSourceType());
		sb.append(",");
		sb.append(getResourceType() == null ? "" : getResourceType());
		sb.append(",");
		sb.append(getCreator() == null ? "" : getCreator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getFileManageId() == null ? "" : getFileManageId());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnResource o) {
		return __resource_id == null ? -1 : __resource_id.compareTo(o.getResourceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__resource_id);
		hash = 97 * hash + Objects.hashCode(this.__resource_package_id);
		hash = 97 * hash + Objects.hashCode(this.__title);
		hash = 97 * hash + Objects.hashCode(this.__description);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__external_url);
		hash = 97 * hash + Objects.hashCode(this.__source_type);
		hash = 97 * hash + Objects.hashCode(this.__resource_type);
		hash = 97 * hash + Objects.hashCode(this.__creator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__file_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnResource o = (BaseCnResource)obj;
		if(!Objects.equals(this.__resource_id, o.getResourceId())) return false;
		if(!Objects.equals(this.__resource_package_id, o.getResourcePackageId())) return false;
		if(!Objects.equals(this.__title, o.getTitle())) return false;
		if(!Objects.equals(this.__description, o.getDescription())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__external_url, o.getExternalUrl())) return false;
		if(!Objects.equals(this.__source_type, o.getSourceType())) return false;
		if(!Objects.equals(this.__resource_type, o.getResourceType())) return false;
		if(!Objects.equals(this.__creator, o.getCreator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__file_manage_id, o.getFileManageId())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getResourceId() != null) sb.append(__wrapNumber(count++, "resourceId", getResourceId()));
		if(getResourcePackageId() != null) sb.append(__wrapNumber(count++, "resourcePackageId", getResourcePackageId()));
		if(getTitle() != null) sb.append(__wrapString(count++, "title", getTitle()));
		if(getDescription() != null) sb.append(__wrapString(count++, "description", getDescription()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getExternalUrl() != null) sb.append(__wrapString(count++, "externalUrl", getExternalUrl()));
		if(getSourceType() != null) sb.append(__wrapNumber(count++, "sourceType", getSourceType()));
		if(getResourceType() != null) sb.append(__wrapNumber(count++, "resourceType", getResourceType()));
		if(getCreator() != null) sb.append(__wrapNumber(count++, "creator", getCreator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getFileManageId() != null) sb.append(__wrapNumber(count++, "fileManageId", getFileManageId()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getResourceId() != null) res.put("resourceId", getResourceId());
		if(getResourcePackageId() != null) res.put("resourcePackageId", getResourcePackageId());
		if(getTitle() != null) res.put("title", getTitle());
		if(getDescription() != null) res.put("description", getDescription());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getExternalUrl() != null) res.put("externalUrl", getExternalUrl());
		if(getSourceType() != null) res.put("sourceType", getSourceType());
		if(getResourceType() != null) res.put("resourceType", getResourceType());
		if(getCreator() != null) res.put("creator", getCreator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getFileManageId() != null) res.put("fileManageId", getFileManageId());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("resourceId")) != null) setResourceId(__getInt(val)); 
		if((val = values.get("resourcePackageId")) != null) setResourcePackageId(__getInt(val)); 
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("description")) != null) setDescription(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("externalUrl")) != null) setExternalUrl(__getString(val));
		if((val = values.get("sourceType")) != null) setSourceType(__getInt(val)); 
		if((val = values.get("resourceType")) != null) setResourceType(__getInt(val)); 
		if((val = values.get("creator")) != null) setCreator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("fileManageId")) != null) setFileManageId(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __resource_id ;
	protected java.lang.Integer  __resource_package_id ;
	protected java.lang.String  __title ;
	protected java.lang.String  __description ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __external_url ;
	protected java.lang.Integer  __source_type ;
	protected java.lang.Integer  __resource_type ;
	protected java.lang.Integer  __creator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __file_manage_id ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __organization_id ;
}
