package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFile extends GenericBase implements BaseFactory<BaseCwdFile>, Comparable<BaseCwdFile> 
{


	public static BaseCwdFile newInstance(){
		return new BaseCwdFile();
	}

	@Override
	public BaseCwdFile make(){
		BaseCwdFile b = new BaseCwdFile();
		return b;
	}

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
	public final static java.lang.String CS_FILE_VERSION_ID = "file_version_id" ;
	public final static java.lang.String CS_FILE_OWNER = "file_owner" ;
	public final static java.lang.String CS_CAD_VERSION = "cad_version" ;
	public final static java.lang.String CS_UPLOAD_LOCK = "upload_lock" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_COMPANY_NO = "company_no" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_FILE_ATTRIBUTION = "file_attribution" ;
	public final static java.lang.String CS_MD5 = "md5" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_ORIGINAL_FILE_ID = "original_file_id" ;
	public final static java.lang.String CS_ORIGINAL_FILE_PATH = "original_file_path" ;
	public final static java.lang.String CS_FOLDER_TYPE = "folder_type" ;
	public final static java.lang.String CS_BASIC_FILE_TYPE = "basic_file_type" ;
	public final static java.lang.String CS_INIT_FILE_PATH = "init_file_path" ;
	public final static java.lang.String CS_DELETE_PERSON = "delete_person" ;
	public final static java.lang.String CS_DELETE_TIME = "delete_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,文件名,文件后缀,是否是文件夹,文件类型,父级编码，关联cwd_file_id字段,文件大小 B,文件创建者,创建时间,最后一次修改的修改人,最后一次修改的时间,OSS的key,OSS存储空间名称,,文件版本,文件拥有者,cad版本,上传锁,删除状态,公司,公司编码,项目, 5交付区,MD5,文件的访问url,源文件编码,源文件路径,文件夹类型 0其他  1设计区个人文件夹根目录 2公用的基础资料文件根目录,基础文档类型 0非基础文件  1公用基础文件 2可选基础文件,初始文件路径(主要用于同路径文件记录),删除人,删除时间";

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

	public java.lang.Boolean getUploadLock() {
		return this.__upload_lock;
	}

	public void setUploadLock( java.lang.Boolean value ) {
		this.__upload_lock = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
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

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
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

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.Integer getOriginalFileId() {
		return this.__original_file_id;
	}

	public void setOriginalFileId( java.lang.Integer value ) {
		this.__original_file_id = value;
	}

	public java.lang.String getOriginalFilePath() {
		return this.__original_file_path;
	}

	public void setOriginalFilePath( java.lang.String value ) {
		this.__original_file_path = value;
	}

	public java.lang.Integer getFolderType() {
		return this.__folder_type;
	}

	public void setFolderType( java.lang.Integer value ) {
		this.__folder_type = value;
	}

	public java.lang.Integer getBasicFileType() {
		return this.__basic_file_type;
	}

	public void setBasicFileType( java.lang.Integer value ) {
		this.__basic_file_type = value;
	}

	public java.lang.String getInitFilePath() {
		return this.__init_file_path;
	}

	public void setInitFilePath( java.lang.String value ) {
		this.__init_file_path = value;
	}

	public java.lang.Integer getDeletePerson() {
		return this.__delete_person;
	}

	public void setDeletePerson( java.lang.Integer value ) {
		this.__delete_person = value;
	}

	public java.util.Date getDeleteTime() {
		return this.__delete_time;
	}

	public void setDeleteTime( java.util.Date value ) {
		this.__delete_time = value;
	}

	public void cloneCopy(BaseCwdFile __bean){
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
		__bean.setUploadLock(getUploadLock());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setCompanyId(getCompanyId());
		__bean.setCompanyNo(getCompanyNo());
		__bean.setProjectId(getProjectId());
		__bean.setFileAttribution(getFileAttribution());
		__bean.setMd5(getMd5());
		__bean.setFileUrl(getFileUrl());
		__bean.setOriginalFileId(getOriginalFileId());
		__bean.setOriginalFilePath(getOriginalFilePath());
		__bean.setFolderType(getFolderType());
		__bean.setBasicFileType(getBasicFileType());
		__bean.setInitFilePath(getInitFilePath());
		__bean.setDeletePerson(getDeletePerson());
		__bean.setDeleteTime(getDeleteTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
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
		sb.append(getParentId() == null ? "" : getParentId());
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
		sb.append(getFileVersionId() == null ? "" : getFileVersionId());
		sb.append(",");
		sb.append(getFileOwner() == null ? "" : getFileOwner());
		sb.append(",");
		sb.append(getCadVersion() == null ? "" : getCadVersion());
		sb.append(",");
		sb.append(getUploadLock() == null ? "" : getUploadLock());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getCompanyNo() == null ? "" : getCompanyNo());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getFileAttribution() == null ? "" : getFileAttribution());
		sb.append(",");
		sb.append(getMd5() == null ? "" : getMd5());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getOriginalFileId() == null ? "" : getOriginalFileId());
		sb.append(",");
		sb.append(getOriginalFilePath() == null ? "" : getOriginalFilePath());
		sb.append(",");
		sb.append(getFolderType() == null ? "" : getFolderType());
		sb.append(",");
		sb.append(getBasicFileType() == null ? "" : getBasicFileType());
		sb.append(",");
		sb.append(getInitFilePath() == null ? "" : getInitFilePath());
		sb.append(",");
		sb.append(getDeletePerson() == null ? "" : getDeletePerson());
		sb.append(",");
		sb.append(getDeleteTime() == null ? "" : sdf.format(getDeleteTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFile o) {
		return __cwd_file_id == null ? -1 : __cwd_file_id.compareTo(o.getCwdFileId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
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
		hash = 97 * hash + Objects.hashCode(this.__file_version_id);
		hash = 97 * hash + Objects.hashCode(this.__file_owner);
		hash = 97 * hash + Objects.hashCode(this.__cad_version);
		hash = 97 * hash + Objects.hashCode(this.__upload_lock);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__company_no);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__file_attribution);
		hash = 97 * hash + Objects.hashCode(this.__md5);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__original_file_id);
		hash = 97 * hash + Objects.hashCode(this.__original_file_path);
		hash = 97 * hash + Objects.hashCode(this.__folder_type);
		hash = 97 * hash + Objects.hashCode(this.__basic_file_type);
		hash = 97 * hash + Objects.hashCode(this.__init_file_path);
		hash = 97 * hash + Objects.hashCode(this.__delete_person);
		hash = 97 * hash + Objects.hashCode(this.__delete_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFile o = (BaseCwdFile)obj;
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
		if(!Objects.equals(this.__file_version_id, o.getFileVersionId())) return false;
		if(!Objects.equals(this.__file_owner, o.getFileOwner())) return false;
		if(!Objects.equals(this.__cad_version, o.getCadVersion())) return false;
		if(!Objects.equals(this.__upload_lock, o.getUploadLock())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__company_no, o.getCompanyNo())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__file_attribution, o.getFileAttribution())) return false;
		if(!Objects.equals(this.__md5, o.getMd5())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__original_file_id, o.getOriginalFileId())) return false;
		if(!Objects.equals(this.__original_file_path, o.getOriginalFilePath())) return false;
		if(!Objects.equals(this.__folder_type, o.getFolderType())) return false;
		if(!Objects.equals(this.__basic_file_type, o.getBasicFileType())) return false;
		if(!Objects.equals(this.__init_file_path, o.getInitFilePath())) return false;
		if(!Objects.equals(this.__delete_person, o.getDeletePerson())) return false;
		if(!Objects.equals(this.__delete_time, o.getDeleteTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
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
		if(getFileVersionId() != null) sb.append(__wrapNumber(count++, "fileVersionId", getFileVersionId()));
		if(getFileOwner() != null) sb.append(__wrapNumber(count++, "fileOwner", getFileOwner()));
		if(getCadVersion() != null) sb.append(__wrapString(count++, "cadVersion", getCadVersion()));
		if(getUploadLock() != null) sb.append(__wrapBoolean(count++, "uploadLock", getUploadLock()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCompanyNo() != null) sb.append(__wrapString(count++, "companyNo", getCompanyNo()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getFileAttribution() != null) sb.append(__wrapNumber(count++, "fileAttribution", getFileAttribution()));
		if(getMd5() != null) sb.append(__wrapString(count++, "md5", getMd5()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getOriginalFileId() != null) sb.append(__wrapNumber(count++, "originalFileId", getOriginalFileId()));
		if(getOriginalFilePath() != null) sb.append(__wrapString(count++, "originalFilePath", getOriginalFilePath()));
		if(getFolderType() != null) sb.append(__wrapNumber(count++, "folderType", getFolderType()));
		if(getBasicFileType() != null) sb.append(__wrapNumber(count++, "basicFileType", getBasicFileType()));
		if(getInitFilePath() != null) sb.append(__wrapString(count++, "initFilePath", getInitFilePath()));
		if(getDeletePerson() != null) sb.append(__wrapNumber(count++, "deletePerson", getDeletePerson()));
		if(getDeleteTime() != null) sb.append(__wrapDate(count++, "deleteTime", getDeleteTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCwdFileId() != null) res.put("cwdFileId", getCwdFileId());
		if(getFileName() != null) res.put("fileName", getFileName());
		if(getFileExtension() != null) res.put("fileExtension", getFileExtension());
		if(getIsFolder() != null) res.put("isFolder", getIsFolder());
		if(getFileType() != null) res.put("fileType", getFileType());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getFileSize() != null) res.put("fileSize", getFileSize());
		if(getCreatePerson() != null) res.put("createPerson", getCreatePerson());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getModificationPerson() != null) res.put("modificationPerson", getModificationPerson());
		if(getModificationTime() != null) res.put("modificationTime", getModificationTime());
		if(getFilePath() != null) res.put("filePath", getFilePath());
		if(getBucket() != null) res.put("bucket", getBucket());
		if(getOssKey() != null) res.put("ossKey", getOssKey());
		if(getFileVersionId() != null) res.put("fileVersionId", getFileVersionId());
		if(getFileOwner() != null) res.put("fileOwner", getFileOwner());
		if(getCadVersion() != null) res.put("cadVersion", getCadVersion());
		if(getUploadLock() != null) res.put("uploadLock", getUploadLock());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getCompanyNo() != null) res.put("companyNo", getCompanyNo());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getFileAttribution() != null) res.put("fileAttribution", getFileAttribution());
		if(getMd5() != null) res.put("md5", getMd5());
		if(getFileUrl() != null) res.put("fileUrl", getFileUrl());
		if(getOriginalFileId() != null) res.put("originalFileId", getOriginalFileId());
		if(getOriginalFilePath() != null) res.put("originalFilePath", getOriginalFilePath());
		if(getFolderType() != null) res.put("folderType", getFolderType());
		if(getBasicFileType() != null) res.put("basicFileType", getBasicFileType());
		if(getInitFilePath() != null) res.put("initFilePath", getInitFilePath());
		if(getDeletePerson() != null) res.put("deletePerson", getDeletePerson());
		if(getDeleteTime() != null) res.put("deleteTime", getDeleteTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
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
		if((val = values.get("fileVersionId")) != null) setFileVersionId(__getInt(val)); 
		if((val = values.get("fileOwner")) != null) setFileOwner(__getInt(val)); 
		if((val = values.get("cadVersion")) != null) setCadVersion(__getString(val));
		if((val = values.get("uploadLock")) != null) setUploadLock(__getBoolean(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("fileAttribution")) != null) setFileAttribution(__getInt(val)); 
		if((val = values.get("md5")) != null) setMd5(__getString(val));
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("originalFileId")) != null) setOriginalFileId(__getInt(val)); 
		if((val = values.get("originalFilePath")) != null) setOriginalFilePath(__getString(val));
		if((val = values.get("folderType")) != null) setFolderType(__getInt(val)); 
		if((val = values.get("basicFileType")) != null) setBasicFileType(__getInt(val)); 
		if((val = values.get("initFilePath")) != null) setInitFilePath(__getString(val));
		if((val = values.get("deletePerson")) != null) setDeletePerson(__getInt(val)); 
		if((val = values.get("deleteTime")) != null) setDeleteTime(__getDate(val)); 
	}

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
	protected java.lang.Integer  __file_version_id ;
	protected java.lang.Integer  __file_owner ;
	protected java.lang.String  __cad_version ;
	protected java.lang.Boolean  __upload_lock ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __company_no ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __file_attribution ;
	protected java.lang.String  __md5 ;
	protected java.lang.String  __file_url ;
	protected java.lang.Integer  __original_file_id ;
	protected java.lang.String  __original_file_path ;
	protected java.lang.Integer  __folder_type ;
	protected java.lang.Integer  __basic_file_type ;
	protected java.lang.String  __init_file_path ;
	protected java.lang.Integer  __delete_person ;
	protected java.util.Date  __delete_time ;
}
