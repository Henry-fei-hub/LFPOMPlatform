package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnResourceAttachment extends GenericBase implements BaseFactory<BaseCnResourceAttachment>, Comparable<BaseCnResourceAttachment> 
{


	public static BaseCnResourceAttachment newInstance(){
		return new BaseCnResourceAttachment();
	}

	@Override
	public BaseCnResourceAttachment make(){
		BaseCnResourceAttachment b = new BaseCnResourceAttachment();
		return b;
	}

	public final static java.lang.String CS_RESOURCE_ATTACHMENT_ID = "resource_attachment_id" ;
	public final static java.lang.String CS_ATTACHMENT_TYPE = "attachment_type" ;
	public final static java.lang.String CS_RESOURCE_ID = "resource_id" ;
	public final static java.lang.String CS_FILE_MANAGE_ID = "file_manage_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,附件类型 1 原资源  2CAD 3SU 4BIM 5word 6音频视频,资源主键,文件,创建时间,删除标志 0未删除 1已删除,组织机构代码";

	public java.lang.Integer getResourceAttachmentId() {
		return this.__resource_attachment_id;
	}

	public void setResourceAttachmentId( java.lang.Integer value ) {
		this.__resource_attachment_id = value;
	}

	public java.lang.Integer getAttachmentType() {
		return this.__attachment_type;
	}

	public void setAttachmentType( java.lang.Integer value ) {
		this.__attachment_type = value;
	}

	public java.lang.Integer getResourceId() {
		return this.__resource_id;
	}

	public void setResourceId( java.lang.Integer value ) {
		this.__resource_id = value;
	}

	public java.lang.Integer getFileManageId() {
		return this.__file_manage_id;
	}

	public void setFileManageId( java.lang.Integer value ) {
		this.__file_manage_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
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

	public void cloneCopy(BaseCnResourceAttachment __bean){
		__bean.setResourceAttachmentId(getResourceAttachmentId());
		__bean.setAttachmentType(getAttachmentType());
		__bean.setResourceId(getResourceId());
		__bean.setFileManageId(getFileManageId());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getResourceAttachmentId() == null ? "" : getResourceAttachmentId());
		sb.append(",");
		sb.append(getAttachmentType() == null ? "" : getAttachmentType());
		sb.append(",");
		sb.append(getResourceId() == null ? "" : getResourceId());
		sb.append(",");
		sb.append(getFileManageId() == null ? "" : getFileManageId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnResourceAttachment o) {
		return __resource_attachment_id == null ? -1 : __resource_attachment_id.compareTo(o.getResourceAttachmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__resource_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_type);
		hash = 97 * hash + Objects.hashCode(this.__resource_id);
		hash = 97 * hash + Objects.hashCode(this.__file_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnResourceAttachment o = (BaseCnResourceAttachment)obj;
		if(!Objects.equals(this.__resource_attachment_id, o.getResourceAttachmentId())) return false;
		if(!Objects.equals(this.__attachment_type, o.getAttachmentType())) return false;
		if(!Objects.equals(this.__resource_id, o.getResourceId())) return false;
		if(!Objects.equals(this.__file_manage_id, o.getFileManageId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getResourceAttachmentId() != null) sb.append(__wrapNumber(count++, "resourceAttachmentId", getResourceAttachmentId()));
		if(getAttachmentType() != null) sb.append(__wrapNumber(count++, "attachmentType", getAttachmentType()));
		if(getResourceId() != null) sb.append(__wrapNumber(count++, "resourceId", getResourceId()));
		if(getFileManageId() != null) sb.append(__wrapNumber(count++, "fileManageId", getFileManageId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getResourceAttachmentId() != null) res.put("resourceAttachmentId", getResourceAttachmentId());
		if(getAttachmentType() != null) res.put("attachmentType", getAttachmentType());
		if(getResourceId() != null) res.put("resourceId", getResourceId());
		if(getFileManageId() != null) res.put("fileManageId", getFileManageId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("resourceAttachmentId")) != null) setResourceAttachmentId(__getInt(val)); 
		if((val = values.get("attachmentType")) != null) setAttachmentType(__getInt(val)); 
		if((val = values.get("resourceId")) != null) setResourceId(__getInt(val)); 
		if((val = values.get("fileManageId")) != null) setFileManageId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __resource_attachment_id ;
	protected java.lang.Integer  __attachment_type ;
	protected java.lang.Integer  __resource_id ;
	protected java.lang.Integer  __file_manage_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __organization_id ;
}
