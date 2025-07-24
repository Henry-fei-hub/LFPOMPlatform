package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseWebsiteNew extends GenericBase implements BaseFactory<BaseWebsiteNew>, Comparable<BaseWebsiteNew> 
{


	public static BaseWebsiteNew newInstance(){
		return new BaseWebsiteNew();
	}

	@Override
	public BaseWebsiteNew make(){
		BaseWebsiteNew b = new BaseWebsiteNew();
		return b;
	}

	public final static java.lang.String CS_WEBSITE_NEW_ID = "website_new_id" ;
	public final static java.lang.String CS_TITLE = "title" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_CONTENT = "content" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_NEW_TYPE = "new_type" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_ORDER_NUM = "order_num" ;
	public final static java.lang.String CS_ATTACHMENT_ID = "attachment_id" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,主题,文件路径,内容,创建时间,新闻类型  1公告,删除标志 1 未删除  2已删除,排序标志 值越大越靠前,附件编码,附件名称";

	public java.lang.Integer getWebsiteNewId() {
		return this.__website_new_id;
	}

	public void setWebsiteNewId( java.lang.Integer value ) {
		this.__website_new_id = value;
	}

	public java.lang.String getTitle() {
		return this.__title;
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.String getContent() {
		return this.__content;
	}

	public void setContent( java.lang.String value ) {
		this.__content = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getNewType() {
		return this.__new_type;
	}

	public void setNewType( java.lang.Integer value ) {
		this.__new_type = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getOrderNum() {
		return this.__order_num;
	}

	public void setOrderNum( java.lang.Integer value ) {
		this.__order_num = value;
	}

	public java.lang.Integer getAttachmentId() {
		return this.__attachment_id;
	}

	public void setAttachmentId( java.lang.Integer value ) {
		this.__attachment_id = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public void cloneCopy(BaseWebsiteNew __bean){
		__bean.setWebsiteNewId(getWebsiteNewId());
		__bean.setTitle(getTitle());
		__bean.setFileUrl(getFileUrl());
		__bean.setContent(getContent());
		__bean.setCreateTime(getCreateTime());
		__bean.setNewType(getNewType());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setOrderNum(getOrderNum());
		__bean.setAttachmentId(getAttachmentId());
		__bean.setAttachmentName(getAttachmentName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getWebsiteNewId() == null ? "" : getWebsiteNewId());
		sb.append(",");
		sb.append(getTitle() == null ? "" : getTitle());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getContent() == null ? "" : getContent());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getNewType() == null ? "" : getNewType());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getOrderNum() == null ? "" : getOrderNum());
		sb.append(",");
		sb.append(getAttachmentId() == null ? "" : getAttachmentId());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseWebsiteNew o) {
		return __website_new_id == null ? -1 : __website_new_id.compareTo(o.getWebsiteNewId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__website_new_id);
		hash = 97 * hash + Objects.hashCode(this.__title);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__content);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__new_type);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__order_num);
		hash = 97 * hash + Objects.hashCode(this.__attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseWebsiteNew o = (BaseWebsiteNew)obj;
		if(!Objects.equals(this.__website_new_id, o.getWebsiteNewId())) return false;
		if(!Objects.equals(this.__title, o.getTitle())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__content, o.getContent())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__new_type, o.getNewType())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__order_num, o.getOrderNum())) return false;
		if(!Objects.equals(this.__attachment_id, o.getAttachmentId())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getWebsiteNewId() != null) sb.append(__wrapNumber(count++, "websiteNewId", getWebsiteNewId()));
		if(getTitle() != null) sb.append(__wrapString(count++, "title", getTitle()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getContent() != null) sb.append(__wrapString(count++, "content", getContent()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getNewType() != null) sb.append(__wrapNumber(count++, "newType", getNewType()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getOrderNum() != null) sb.append(__wrapNumber(count++, "orderNum", getOrderNum()));
		if(getAttachmentId() != null) sb.append(__wrapNumber(count++, "attachmentId", getAttachmentId()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("websiteNewId")) != null) setWebsiteNewId(__getInt(val)); 
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("content")) != null) setContent(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("newType")) != null) setNewType(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("orderNum")) != null) setOrderNum(__getInt(val)); 
		if((val = values.get("attachmentId")) != null) setAttachmentId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
	}

	protected java.lang.Integer  __website_new_id ;
	protected java.lang.String  __title ;
	protected java.lang.String  __file_url ;
	protected java.lang.String  __content ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __new_type ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __order_num ;
	protected java.lang.Integer  __attachment_id ;
	protected java.lang.String  __attachment_name ;
}
