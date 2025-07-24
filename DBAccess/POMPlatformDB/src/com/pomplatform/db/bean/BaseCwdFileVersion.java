package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFileVersion extends GenericBase implements BaseFactory<BaseCwdFileVersion>, Comparable<BaseCwdFileVersion> 
{


	public static BaseCwdFileVersion newInstance(){
		return new BaseCwdFileVersion();
	}

	@Override
	public BaseCwdFileVersion make(){
		BaseCwdFileVersion b = new BaseCwdFileVersion();
		return b;
	}

	public final static java.lang.String CS_CWD_FILE_VERSION_ID = "cwd_file_version_id" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_FILE_NAME = "file_name" ;
	public final static java.lang.String CS_FILE_EXTENSION = "file_extension" ;
	public final static java.lang.String CS_IS_FOLDER = "is_folder" ;
	public final static java.lang.String CS_FILE_TYPE = "file_type" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_FILE_SIZE = "file_size" ;
	public final static java.lang.String CS_CREATE_PERSON = "create_person" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPLOADER = "uploader" ;
	public final static java.lang.String CS_UPLOAD_START_TIME = "upload_start_time" ;
	public final static java.lang.String CS_UPLOAD_COMPLETED_TIME = "upload_completed_time" ;
	public final static java.lang.String CS_UPLOAD_STATUS = "upload_status" ;
	public final static java.lang.String CS_FILE_PATH = "file_path" ;
	public final static java.lang.String CS_BUCKET = "bucket" ;
	public final static java.lang.String CS_OSS_KEY = "oss_key" ;
	public final static java.lang.String CS_CAD_VERSION = "cad_version" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_ACTION = "action" ;
	public final static java.lang.String CS_MAC_ADDRESS = "mac_address" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,cwd_files表的主键,文件名,文件后缀,是否是文件夹,文件类型,父级编码，关联cwd_file_id字段,文件大小 B,文件创建者,创建时间,上传者,开始上传时间,开始上传时间,,文件路径,OSS存储空间名称,OSS的key,cad版本,备注,新增/修改/删除,上传该版本的mac地址";

	public java.lang.Integer getCwdFileVersionId() {
		return this.__cwd_file_version_id;
	}

	public void setCwdFileVersionId( java.lang.Integer value ) {
		this.__cwd_file_version_id = value;
	}

	public java.lang.Integer getCwdFileId() {
		return this.__cwd_file_id;
	}

	public void setCwdFileId( java.lang.Integer value ) {
		this.__cwd_file_id = value;
	}

	public java.lang.String getFileName() {
		return this.__file_name;
	}

	public void setFileName( java.lang.String value ) {
		this.__file_name = value;
	}

	public java.lang.String getFileExtension() {
		return this.__file_extension;
	}

	public void setFileExtension( java.lang.String value ) {
		this.__file_extension = value;
	}

	public java.lang.Boolean getIsFolder() {
		return this.__is_folder;
	}

	public void setIsFolder( java.lang.Boolean value ) {
		this.__is_folder = value;
	}

	public java.lang.Integer getFileType() {
		return this.__file_type;
	}

	public void setFileType( java.lang.Integer value ) {
		this.__file_type = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Long getFileSize() {
		return this.__file_size;
	}

	public void setFileSize( java.lang.Long value ) {
		this.__file_size = value;
	}

	public java.lang.Integer getCreatePerson() {
		return this.__create_person;
	}

	public void setCreatePerson( java.lang.Integer value ) {
		this.__create_person = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getUploader() {
		return this.__uploader;
	}

	public void setUploader( java.lang.Integer value ) {
		this.__uploader = value;
	}

	public java.util.Date getUploadStartTime() {
		return this.__upload_start_time;
	}

	public void setUploadStartTime( java.util.Date value ) {
		this.__upload_start_time = value;
	}

	public java.util.Date getUploadCompletedTime() {
		return this.__upload_completed_time;
	}

	public void setUploadCompletedTime( java.util.Date value ) {
		this.__upload_completed_time = value;
	}

	public java.lang.Integer getUploadStatus() {
		return this.__upload_status;
	}

	public void setUploadStatus( java.lang.Integer value ) {
		this.__upload_status = value;
	}

	public java.lang.String getFilePath() {
		return this.__file_path;
	}

	public void setFilePath( java.lang.String value ) {
		this.__file_path = value;
	}

	public java.lang.String getBucket() {
		return this.__bucket;
	}

	public void setBucket( java.lang.String value ) {
		this.__bucket = value;
	}

	public java.lang.String getOssKey() {
		return this.__oss_key;
	}

	public void setOssKey( java.lang.String value ) {
		this.__oss_key = value;
	}

	public java.lang.String getCadVersion() {
		return this.__cad_version;
	}

	public void setCadVersion( java.lang.String value ) {
		this.__cad_version = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getAction() {
		return this.__action;
	}

	public void setAction( java.lang.Integer value ) {
		this.__action = value;
	}

	public java.lang.String getMacAddress() {
		return this.__mac_address;
	}

	public void setMacAddress( java.lang.String value ) {
		this.__mac_address = value;
	}

	public void cloneCopy(BaseCwdFileVersion __bean){
		__bean.setCwdFileVersionId(getCwdFileVersionId());
		__bean.setCwdFileId(getCwdFileId());
		__bean.setFileName(getFileName());
		__bean.setFileExtension(getFileExtension());
		__bean.setIsFolder(getIsFolder());
		__bean.setFileType(getFileType());
		__bean.setParentId(getParentId());
		__bean.setFileSize(getFileSize());
		__bean.setCreatePerson(getCreatePerson());
		__bean.setCreateTime(getCreateTime());
		__bean.setUploader(getUploader());
		__bean.setUploadStartTime(getUploadStartTime());
		__bean.setUploadCompletedTime(getUploadCompletedTime());
		__bean.setUploadStatus(getUploadStatus());
		__bean.setFilePath(getFilePath());
		__bean.setBucket(getBucket());
		__bean.setOssKey(getOssKey());
		__bean.setCadVersion(getCadVersion());
		__bean.setRemark(getRemark());
		__bean.setAction(getAction());
		__bean.setMacAddress(getMacAddress());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdFileVersionId() == null ? "" : getCwdFileVersionId());
		sb.append(",");
		sb.append(getCwdFileId() == null ? "" : getCwdFileId());
		sb.append(",");
		sb.append(getFileName() == null ? "" : getFileName());
		sb.append(",");
		sb.append(getFileExtension() == null ? "" : getFileExtension());
		sb.append(",");
		sb.append(getIsFolder() == null ? "" : getIsFolder());
		sb.append(",");
		sb.append(getFileType() == null ? "" : getFileType());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getFileSize() == null ? "" : getFileSize());
		sb.append(",");
		sb.append(getCreatePerson() == null ? "" : getCreatePerson());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUploader() == null ? "" : getUploader());
		sb.append(",");
		sb.append(getUploadStartTime() == null ? "" : sdf.format(getUploadStartTime()));
		sb.append(",");
		sb.append(getUploadCompletedTime() == null ? "" : sdf.format(getUploadCompletedTime()));
		sb.append(",");
		sb.append(getUploadStatus() == null ? "" : getUploadStatus());
		sb.append(",");
		sb.append(getFilePath() == null ? "" : getFilePath());
		sb.append(",");
		sb.append(getBucket() == null ? "" : getBucket());
		sb.append(",");
		sb.append(getOssKey() == null ? "" : getOssKey());
		sb.append(",");
		sb.append(getCadVersion() == null ? "" : getCadVersion());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getAction() == null ? "" : getAction());
		sb.append(",");
		sb.append(getMacAddress() == null ? "" : getMacAddress());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFileVersion o) {
		return __cwd_file_version_id == null ? -1 : __cwd_file_version_id.compareTo(o.getCwdFileVersionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_version_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		hash = 97 * hash + Objects.hashCode(this.__file_extension);
		hash = 97 * hash + Objects.hashCode(this.__is_folder);
		hash = 97 * hash + Objects.hashCode(this.__file_type);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__file_size);
		hash = 97 * hash + Objects.hashCode(this.__create_person);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__uploader);
		hash = 97 * hash + Objects.hashCode(this.__upload_start_time);
		hash = 97 * hash + Objects.hashCode(this.__upload_completed_time);
		hash = 97 * hash + Objects.hashCode(this.__upload_status);
		hash = 97 * hash + Objects.hashCode(this.__file_path);
		hash = 97 * hash + Objects.hashCode(this.__bucket);
		hash = 97 * hash + Objects.hashCode(this.__oss_key);
		hash = 97 * hash + Objects.hashCode(this.__cad_version);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__action);
		hash = 97 * hash + Objects.hashCode(this.__mac_address);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFileVersion o = (BaseCwdFileVersion)obj;
		if(!Objects.equals(this.__cwd_file_version_id, o.getCwdFileVersionId())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		if(!Objects.equals(this.__file_extension, o.getFileExtension())) return false;
		if(!Objects.equals(this.__is_folder, o.getIsFolder())) return false;
		if(!Objects.equals(this.__file_type, o.getFileType())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__file_size, o.getFileSize())) return false;
		if(!Objects.equals(this.__create_person, o.getCreatePerson())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__uploader, o.getUploader())) return false;
		if(!Objects.equals(this.__upload_start_time, o.getUploadStartTime())) return false;
		if(!Objects.equals(this.__upload_completed_time, o.getUploadCompletedTime())) return false;
		if(!Objects.equals(this.__upload_status, o.getUploadStatus())) return false;
		if(!Objects.equals(this.__file_path, o.getFilePath())) return false;
		if(!Objects.equals(this.__bucket, o.getBucket())) return false;
		if(!Objects.equals(this.__oss_key, o.getOssKey())) return false;
		if(!Objects.equals(this.__cad_version, o.getCadVersion())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__action, o.getAction())) return false;
		if(!Objects.equals(this.__mac_address, o.getMacAddress())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdFileVersionId() != null) sb.append(__wrapNumber(count++, "cwdFileVersionId", getCwdFileVersionId()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getFileName() != null) sb.append(__wrapString(count++, "fileName", getFileName()));
		if(getFileExtension() != null) sb.append(__wrapString(count++, "fileExtension", getFileExtension()));
		if(getIsFolder() != null) sb.append(__wrapBoolean(count++, "isFolder", getIsFolder()));
		if(getFileType() != null) sb.append(__wrapNumber(count++, "fileType", getFileType()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getFileSize() != null) sb.append(__wrapNumber(count++, "fileSize", getFileSize()));
		if(getCreatePerson() != null) sb.append(__wrapNumber(count++, "createPerson", getCreatePerson()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUploader() != null) sb.append(__wrapNumber(count++, "uploader", getUploader()));
		if(getUploadStartTime() != null) sb.append(__wrapDate(count++, "uploadStartTime", getUploadStartTime()));
		if(getUploadCompletedTime() != null) sb.append(__wrapDate(count++, "uploadCompletedTime", getUploadCompletedTime()));
		if(getUploadStatus() != null) sb.append(__wrapNumber(count++, "uploadStatus", getUploadStatus()));
		if(getFilePath() != null) sb.append(__wrapString(count++, "filePath", getFilePath()));
		if(getBucket() != null) sb.append(__wrapString(count++, "bucket", getBucket()));
		if(getOssKey() != null) sb.append(__wrapString(count++, "ossKey", getOssKey()));
		if(getCadVersion() != null) sb.append(__wrapString(count++, "cadVersion", getCadVersion()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getAction() != null) sb.append(__wrapNumber(count++, "action", getAction()));
		if(getMacAddress() != null) sb.append(__wrapString(count++, "macAddress", getMacAddress()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdFileVersionId")) != null) setCwdFileVersionId(__getInt(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
		if((val = values.get("fileExtension")) != null) setFileExtension(__getString(val));
		if((val = values.get("isFolder")) != null) setIsFolder(__getBoolean(val));
		if((val = values.get("fileType")) != null) setFileType(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("fileSize")) != null) setFileSize(__getLong(val)); 
		if((val = values.get("createPerson")) != null) setCreatePerson(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("uploader")) != null) setUploader(__getInt(val)); 
		if((val = values.get("uploadStartTime")) != null) setUploadStartTime(__getDate(val)); 
		if((val = values.get("uploadCompletedTime")) != null) setUploadCompletedTime(__getDate(val)); 
		if((val = values.get("uploadStatus")) != null) setUploadStatus(__getInt(val)); 
		if((val = values.get("filePath")) != null) setFilePath(__getString(val));
		if((val = values.get("bucket")) != null) setBucket(__getString(val));
		if((val = values.get("ossKey")) != null) setOssKey(__getString(val));
		if((val = values.get("cadVersion")) != null) setCadVersion(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("action")) != null) setAction(__getInt(val)); 
		if((val = values.get("macAddress")) != null) setMacAddress(__getString(val));
	}

	protected java.lang.Integer  __cwd_file_version_id ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.lang.String  __file_name ;
	protected java.lang.String  __file_extension ;
	protected java.lang.Boolean  __is_folder ;
	protected java.lang.Integer  __file_type ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Long  __file_size ;
	protected java.lang.Integer  __create_person ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __uploader ;
	protected java.util.Date  __upload_start_time ;
	protected java.util.Date  __upload_completed_time ;
	protected java.lang.Integer  __upload_status ;
	protected java.lang.String  __file_path ;
	protected java.lang.String  __bucket ;
	protected java.lang.String  __oss_key ;
	protected java.lang.String  __cad_version ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __action ;
	protected java.lang.String  __mac_address ;
}
