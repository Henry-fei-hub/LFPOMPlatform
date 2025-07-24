package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseLocalFile extends GenericBase implements BaseFactory<BaseLocalFile>, Comparable<BaseLocalFile> 
{


	public static BaseLocalFile newInstance(){
		return new BaseLocalFile();
	}

	@Override
	public BaseLocalFile make(){
		BaseLocalFile b = new BaseLocalFile();
		return b;
	}

	public final static java.lang.String CS_LOCAL_FILE_ID = "local_file_id" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_FILE_NAME = "file_name" ;
	public final static java.lang.String CS_FILE_EXTENSION = "file_extension" ;
	public final static java.lang.String CS_IS_FOLDER = "is_folder" ;
	public final static java.lang.String CS_FILE_TYPE = "file_type" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_FILE_SIZE = "file_size" ;
	public final static java.lang.String CS_CREATE_PERSON = "create_person" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_MODIFICATION_PERSON = "modification_person" ;
	public final static java.lang.String CS_MODIFICATION_TIME = "modification_time" ;
	public final static java.lang.String CS_FILE_PATH = "file_path" ;
	public final static java.lang.String CS_BUCKET = "bucket" ;
	public final static java.lang.String CS_OSS_KEY = "oss_key" ;
	public final static java.lang.String CS_LAST_UPLOAD_TIME = "last_upload_time" ;
	public final static java.lang.String CS_LAST_DOWNLOAD_TIME = "last_download_time" ;
	public final static java.lang.String CS_FILE_VERSION_ID = "file_version_id" ;
	public final static java.lang.String CS_FILE_OWNER = "file_owner" ;
	public final static java.lang.String CS_CAD_VERSION = "cad_version" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_VERSION_STATUS = "version_status" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_COMPANY_NO = "company_no" ;
	public final static java.lang.String CS_FILE_ATTRIBUTION = "file_attribution" ;
	public final static java.lang.String CS_MD5 = "md5" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,cwd_files表的主键,文件名,文件后缀,是否是文件夹,文件类型,父级编码，关联cwd_file_id字段,文件大小 B,文件创建者,创建时间,最后一次修改的修改人,最后一次修改的时间,文件路径,OSS存储空间名称,OSS的key,最后一次上传的时间,最后一次下载的时间,最后一次下载时的文件版本,文件拥有者,cad版本,删除状态,文件版本状态 1正常 2修改 3冲突 4删除 5更新 6新增 7下载中 8上传中,项目,公司,公司编号, 5交付区,MD5";

	public java.lang.Integer getLocalFileId() {
		return this.__local_file_id;
	}

	public void setLocalFileId( java.lang.Integer value ) {
		this.__local_file_id = value;
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

	public java.lang.Integer getModificationPerson() {
		return this.__modification_person;
	}

	public void setModificationPerson( java.lang.Integer value ) {
		this.__modification_person = value;
	}

	public java.util.Date getModificationTime() {
		return this.__modification_time;
	}

	public void setModificationTime( java.util.Date value ) {
		this.__modification_time = value;
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

	public java.util.Date getLastUploadTime() {
		return this.__last_upload_time;
	}

	public void setLastUploadTime( java.util.Date value ) {
		this.__last_upload_time = value;
	}

	public java.util.Date getLastDownloadTime() {
		return this.__last_download_time;
	}

	public void setLastDownloadTime( java.util.Date value ) {
		this.__last_download_time = value;
	}

	public java.lang.Integer getFileVersionId() {
		return this.__file_version_id;
	}

	public void setFileVersionId( java.lang.Integer value ) {
		this.__file_version_id = value;
	}

	public java.lang.Integer getFileOwner() {
		return this.__file_owner;
	}

	public void setFileOwner( java.lang.Integer value ) {
		this.__file_owner = value;
	}

	public java.lang.String getCadVersion() {
		return this.__cad_version;
	}

	public void setCadVersion( java.lang.String value ) {
		this.__cad_version = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getVersionStatus() {
		return this.__version_status;
	}

	public void setVersionStatus( java.lang.Integer value ) {
		this.__version_status = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getCompanyNo() {
		return this.__company_no;
	}

	public void setCompanyNo( java.lang.String value ) {
		this.__company_no = value;
	}

	public java.lang.Integer getFileAttribution() {
		return this.__file_attribution;
	}

	public void setFileAttribution( java.lang.Integer value ) {
		this.__file_attribution = value;
	}

	public java.lang.String getMd5() {
		return this.__md5;
	}

	public void setMd5( java.lang.String value ) {
		this.__md5 = value;
	}

	public void cloneCopy(BaseLocalFile __bean){
		__bean.setLocalFileId(getLocalFileId());
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
		__bean.setLastUploadTime(getLastUploadTime());
		__bean.setLastDownloadTime(getLastDownloadTime());
		__bean.setFileVersionId(getFileVersionId());
		__bean.setFileOwner(getFileOwner());
		__bean.setCadVersion(getCadVersion());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setVersionStatus(getVersionStatus());
		__bean.setProjectId(getProjectId());
		__bean.setCompanyId(getCompanyId());
		__bean.setCompanyNo(getCompanyNo());
		__bean.setFileAttribution(getFileAttribution());
		__bean.setMd5(getMd5());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLocalFileId() == null ? "" : getLocalFileId());
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
		sb.append(getModificationPerson() == null ? "" : getModificationPerson());
		sb.append(",");
		sb.append(getModificationTime() == null ? "" : sdf.format(getModificationTime()));
		sb.append(",");
		sb.append(getFilePath() == null ? "" : getFilePath());
		sb.append(",");
		sb.append(getBucket() == null ? "" : getBucket());
		sb.append(",");
		sb.append(getOssKey() == null ? "" : getOssKey());
		sb.append(",");
		sb.append(getLastUploadTime() == null ? "" : sdf.format(getLastUploadTime()));
		sb.append(",");
		sb.append(getLastDownloadTime() == null ? "" : sdf.format(getLastDownloadTime()));
		sb.append(",");
		sb.append(getFileVersionId() == null ? "" : getFileVersionId());
		sb.append(",");
		sb.append(getFileOwner() == null ? "" : getFileOwner());
		sb.append(",");
		sb.append(getCadVersion() == null ? "" : getCadVersion());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getVersionStatus() == null ? "" : getVersionStatus());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getCompanyNo() == null ? "" : getCompanyNo());
		sb.append(",");
		sb.append(getFileAttribution() == null ? "" : getFileAttribution());
		sb.append(",");
		sb.append(getMd5() == null ? "" : getMd5());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseLocalFile o) {
		return __local_file_id == null ? -1 : __local_file_id.compareTo(o.getLocalFileId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__local_file_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		hash = 97 * hash + Objects.hashCode(this.__file_extension);
		hash = 97 * hash + Objects.hashCode(this.__is_folder);
		hash = 97 * hash + Objects.hashCode(this.__file_type);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__file_size);
		hash = 97 * hash + Objects.hashCode(this.__create_person);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__modification_person);
		hash = 97 * hash + Objects.hashCode(this.__modification_time);
		hash = 97 * hash + Objects.hashCode(this.__file_path);
		hash = 97 * hash + Objects.hashCode(this.__bucket);
		hash = 97 * hash + Objects.hashCode(this.__oss_key);
		hash = 97 * hash + Objects.hashCode(this.__last_upload_time);
		hash = 97 * hash + Objects.hashCode(this.__last_download_time);
		hash = 97 * hash + Objects.hashCode(this.__file_version_id);
		hash = 97 * hash + Objects.hashCode(this.__file_owner);
		hash = 97 * hash + Objects.hashCode(this.__cad_version);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__version_status);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__company_no);
		hash = 97 * hash + Objects.hashCode(this.__file_attribution);
		hash = 97 * hash + Objects.hashCode(this.__md5);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseLocalFile o = (BaseLocalFile)obj;
		if(!Objects.equals(this.__local_file_id, o.getLocalFileId())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		if(!Objects.equals(this.__file_extension, o.getFileExtension())) return false;
		if(!Objects.equals(this.__is_folder, o.getIsFolder())) return false;
		if(!Objects.equals(this.__file_type, o.getFileType())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__file_size, o.getFileSize())) return false;
		if(!Objects.equals(this.__create_person, o.getCreatePerson())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__modification_person, o.getModificationPerson())) return false;
		if(!Objects.equals(this.__modification_time, o.getModificationTime())) return false;
		if(!Objects.equals(this.__file_path, o.getFilePath())) return false;
		if(!Objects.equals(this.__bucket, o.getBucket())) return false;
		if(!Objects.equals(this.__oss_key, o.getOssKey())) return false;
		if(!Objects.equals(this.__last_upload_time, o.getLastUploadTime())) return false;
		if(!Objects.equals(this.__last_download_time, o.getLastDownloadTime())) return false;
		if(!Objects.equals(this.__file_version_id, o.getFileVersionId())) return false;
		if(!Objects.equals(this.__file_owner, o.getFileOwner())) return false;
		if(!Objects.equals(this.__cad_version, o.getCadVersion())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__version_status, o.getVersionStatus())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__company_no, o.getCompanyNo())) return false;
		if(!Objects.equals(this.__file_attribution, o.getFileAttribution())) return false;
		if(!Objects.equals(this.__md5, o.getMd5())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLocalFileId() != null) sb.append(__wrapNumber(count++, "localFileId", getLocalFileId()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getFileName() != null) sb.append(__wrapString(count++, "fileName", getFileName()));
		if(getFileExtension() != null) sb.append(__wrapString(count++, "fileExtension", getFileExtension()));
		if(getIsFolder() != null) sb.append(__wrapBoolean(count++, "isFolder", getIsFolder()));
		if(getFileType() != null) sb.append(__wrapNumber(count++, "fileType", getFileType()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getFileSize() != null) sb.append(__wrapNumber(count++, "fileSize", getFileSize()));
		if(getCreatePerson() != null) sb.append(__wrapNumber(count++, "createPerson", getCreatePerson()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getModificationPerson() != null) sb.append(__wrapNumber(count++, "modificationPerson", getModificationPerson()));
		if(getModificationTime() != null) sb.append(__wrapDate(count++, "modificationTime", getModificationTime()));
		if(getFilePath() != null) sb.append(__wrapString(count++, "filePath", getFilePath()));
		if(getBucket() != null) sb.append(__wrapString(count++, "bucket", getBucket()));
		if(getOssKey() != null) sb.append(__wrapString(count++, "ossKey", getOssKey()));
		if(getLastUploadTime() != null) sb.append(__wrapDate(count++, "lastUploadTime", getLastUploadTime()));
		if(getLastDownloadTime() != null) sb.append(__wrapDate(count++, "lastDownloadTime", getLastDownloadTime()));
		if(getFileVersionId() != null) sb.append(__wrapNumber(count++, "fileVersionId", getFileVersionId()));
		if(getFileOwner() != null) sb.append(__wrapNumber(count++, "fileOwner", getFileOwner()));
		if(getCadVersion() != null) sb.append(__wrapString(count++, "cadVersion", getCadVersion()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getVersionStatus() != null) sb.append(__wrapNumber(count++, "versionStatus", getVersionStatus()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCompanyNo() != null) sb.append(__wrapString(count++, "companyNo", getCompanyNo()));
		if(getFileAttribution() != null) sb.append(__wrapNumber(count++, "fileAttribution", getFileAttribution()));
		if(getMd5() != null) sb.append(__wrapString(count++, "md5", getMd5()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("localFileId")) != null) setLocalFileId(__getInt(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
		if((val = values.get("fileExtension")) != null) setFileExtension(__getString(val));
		if((val = values.get("isFolder")) != null) setIsFolder(__getBoolean(val));
		if((val = values.get("fileType")) != null) setFileType(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("fileSize")) != null) setFileSize(__getLong(val)); 
		if((val = values.get("createPerson")) != null) setCreatePerson(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("modificationPerson")) != null) setModificationPerson(__getInt(val)); 
		if((val = values.get("modificationTime")) != null) setModificationTime(__getDate(val)); 
		if((val = values.get("filePath")) != null) setFilePath(__getString(val));
		if((val = values.get("bucket")) != null) setBucket(__getString(val));
		if((val = values.get("ossKey")) != null) setOssKey(__getString(val));
		if((val = values.get("lastUploadTime")) != null) setLastUploadTime(__getDate(val)); 
		if((val = values.get("lastDownloadTime")) != null) setLastDownloadTime(__getDate(val)); 
		if((val = values.get("fileVersionId")) != null) setFileVersionId(__getInt(val)); 
		if((val = values.get("fileOwner")) != null) setFileOwner(__getInt(val)); 
		if((val = values.get("cadVersion")) != null) setCadVersion(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("versionStatus")) != null) setVersionStatus(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("fileAttribution")) != null) setFileAttribution(__getInt(val)); 
		if((val = values.get("md5")) != null) setMd5(__getString(val));
	}

	protected java.lang.Integer  __local_file_id ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.lang.String  __file_name ;
	protected java.lang.String  __file_extension ;
	protected java.lang.Boolean  __is_folder ;
	protected java.lang.Integer  __file_type ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Long  __file_size ;
	protected java.lang.Integer  __create_person ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __modification_person ;
	protected java.util.Date  __modification_time ;
	protected java.lang.String  __file_path ;
	protected java.lang.String  __bucket ;
	protected java.lang.String  __oss_key ;
	protected java.util.Date  __last_upload_time ;
	protected java.util.Date  __last_download_time ;
	protected java.lang.Integer  __file_version_id ;
	protected java.lang.Integer  __file_owner ;
	protected java.lang.String  __cad_version ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __version_status ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __company_no ;
	protected java.lang.Integer  __file_attribution ;
	protected java.lang.String  __md5 ;
}
