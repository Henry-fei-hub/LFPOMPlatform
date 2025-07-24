package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnResourceDownload extends GenericBase implements BaseFactory<BaseCnResourceDownload>, Comparable<BaseCnResourceDownload> 
{


	public static BaseCnResourceDownload newInstance(){
		return new BaseCnResourceDownload();
	}

	@Override
	public BaseCnResourceDownload make(){
		BaseCnResourceDownload b = new BaseCnResourceDownload();
		return b;
	}

	public final static java.lang.String CS_RESOURCE_DOWNLOAD_ID = "resource_download_id" ;
	public final static java.lang.String CS_RESOURCE_ID = "resource_id" ;
	public final static java.lang.String CS_RESOURCE_ATTACHMENT_ID = "resource_attachment_id" ;
	public final static java.lang.String CS_DOWNLOADER = "downloader" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,资源主键,资源附件主键,下载人,创建时间,组织机构代码";

	public java.lang.Integer getResourceDownloadId() {
		return this.__resource_download_id;
	}

	public void setResourceDownloadId( java.lang.Integer value ) {
		this.__resource_download_id = value;
	}

	public java.lang.Integer getResourceId() {
		return this.__resource_id;
	}

	public void setResourceId( java.lang.Integer value ) {
		this.__resource_id = value;
	}

	public java.lang.Integer getResourceAttachmentId() {
		return this.__resource_attachment_id;
	}

	public void setResourceAttachmentId( java.lang.Integer value ) {
		this.__resource_attachment_id = value;
	}

	public java.lang.Integer getDownloader() {
		return this.__downloader;
	}

	public void setDownloader( java.lang.Integer value ) {
		this.__downloader = value;
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

	public void cloneCopy(BaseCnResourceDownload __bean){
		__bean.setResourceDownloadId(getResourceDownloadId());
		__bean.setResourceId(getResourceId());
		__bean.setResourceAttachmentId(getResourceAttachmentId());
		__bean.setDownloader(getDownloader());
		__bean.setCreateTime(getCreateTime());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getResourceDownloadId() == null ? "" : getResourceDownloadId());
		sb.append(",");
		sb.append(getResourceId() == null ? "" : getResourceId());
		sb.append(",");
		sb.append(getResourceAttachmentId() == null ? "" : getResourceAttachmentId());
		sb.append(",");
		sb.append(getDownloader() == null ? "" : getDownloader());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnResourceDownload o) {
		return __resource_download_id == null ? -1 : __resource_download_id.compareTo(o.getResourceDownloadId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__resource_download_id);
		hash = 97 * hash + Objects.hashCode(this.__resource_id);
		hash = 97 * hash + Objects.hashCode(this.__resource_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__downloader);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnResourceDownload o = (BaseCnResourceDownload)obj;
		if(!Objects.equals(this.__resource_download_id, o.getResourceDownloadId())) return false;
		if(!Objects.equals(this.__resource_id, o.getResourceId())) return false;
		if(!Objects.equals(this.__resource_attachment_id, o.getResourceAttachmentId())) return false;
		if(!Objects.equals(this.__downloader, o.getDownloader())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getResourceDownloadId() != null) sb.append(__wrapNumber(count++, "resourceDownloadId", getResourceDownloadId()));
		if(getResourceId() != null) sb.append(__wrapNumber(count++, "resourceId", getResourceId()));
		if(getResourceAttachmentId() != null) sb.append(__wrapNumber(count++, "resourceAttachmentId", getResourceAttachmentId()));
		if(getDownloader() != null) sb.append(__wrapNumber(count++, "downloader", getDownloader()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getResourceDownloadId() != null) res.put("resourceDownloadId", getResourceDownloadId());
		if(getResourceId() != null) res.put("resourceId", getResourceId());
		if(getResourceAttachmentId() != null) res.put("resourceAttachmentId", getResourceAttachmentId());
		if(getDownloader() != null) res.put("downloader", getDownloader());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("resourceDownloadId")) != null) setResourceDownloadId(__getInt(val)); 
		if((val = values.get("resourceId")) != null) setResourceId(__getInt(val)); 
		if((val = values.get("resourceAttachmentId")) != null) setResourceAttachmentId(__getInt(val)); 
		if((val = values.get("downloader")) != null) setDownloader(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __resource_download_id ;
	protected java.lang.Integer  __resource_id ;
	protected java.lang.Integer  __resource_attachment_id ;
	protected java.lang.Integer  __downloader ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __organization_id ;
}
