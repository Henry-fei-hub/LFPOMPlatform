package com.pomplatform.db.bean;

import java.util.Map;

public class BaseCwdFileInfo extends BaseCwdFile 
{


	public static BaseCwdFileInfo newInstance(){
		return new BaseCwdFileInfo();
	}

	@Override
	public BaseCwdFileInfo make(){
		BaseCwdFileInfo b = new BaseCwdFileInfo();
		return b;
	}

	public java.lang.Integer getCorrectVersionId() {
		return this.__correct_version_id;
	}

	public void setCorrectVersionId( java.lang.Integer value ) {
		this.__correct_version_id = value;
	}

	public java.util.Date getUploadStartTime() {
		return this.__upload_start_time;
	}

	public void setUploadStartTime( java.util.Date value ) {
		this.__upload_start_time = value;
	}

	public java.lang.String getCorrectKey() {
		return this.__correct_key;
	}

	public void setCorrectKey( java.lang.String value ) {
		this.__correct_key = value;
	}

	public void cloneCopy(BaseCwdFileInfo __bean){
		__bean.setCwdFileId(getCwdFileId());
		__bean.setFileName(getFileName());
		__bean.setFileExtension(getFileExtension());
		__bean.setIsFolder(getIsFolder());
		__bean.setFileType(getFileType());
		__bean.setParentId(getParentId());
		__bean.setFileSize(getFileSize());
		__bean.setCreatePerson(getCreatePerson());
		__bean.setCreateTime(getCreateTime());
		__bean.setModificationPerson(getModificationPerson());
		__bean.setModificationTime(getModificationTime());
		__bean.setFilePath(getFilePath());
		__bean.setBucket(getBucket());
		__bean.setOssKey(getOssKey());
		__bean.setFileVersionId(getFileVersionId());
		__bean.setFileOwner(getFileOwner());
		__bean.setCadVersion(getCadVersion());
		__bean.setFileAttribution(getFileAttribution());
		__bean.setUploadLock(getUploadLock());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setCorrectKey(getCorrectKey());
		__bean.setCorrectVersionId(getCorrectVersionId());
		__bean.setUploadStartTime(getUploadStartTime());
	}

	@Override
	public java.lang.String toJSONString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		int count = 0;
		if(sb.length() > 0){
			count++;
		}
		if(getUploadStartTime() != null) sb.append(__wrapDate(count++, "uploadStartTime", getUploadStartTime()));
		if(getCorrectKey() != null) sb.append(__wrapString(count++, "correctKey", getCorrectKey()));
		if(getCorrectVersionId() != null) sb.append(__wrapNumber(count++, "correctVersionId", getCorrectVersionId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("uploadStartTime")) != null) setUploadStartTime(__getDate(val)); 
		if((val = values.get("correctKey")) != null) setCorrectKey(__getString(val));
		if((val = values.get("correctVersionId")) != null) setCorrectVersionId(__getInt(val)); 
	}

	protected java.lang.Integer  __correct_version_id ;
	protected java.util.Date  __upload_start_time ;
	protected java.lang.String  __correct_key ;
}
