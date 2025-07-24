package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFileBackup extends GenericBase implements BaseFactory<BaseCwdFileBackup>, Comparable<BaseCwdFileBackup> 
{


	public static BaseCwdFileBackup newInstance(){
		return new BaseCwdFileBackup();
	}

	@Override
	public BaseCwdFileBackup make(){
		BaseCwdFileBackup b = new BaseCwdFileBackup();
		return b;
	}

	public final static java.lang.String CS_FILE_BACKUP_ID = "file_backup_id" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_CWD_FILE_VERSION_ID = "cwd_file_version_id" ;
	public final static java.lang.String CS_BACKUP_PATH = "backup_path" ;
	public final static java.lang.String CS_BACKUP_TIME = "backup_time" ;
	public final static java.lang.String CS_WORKPLACE_ID = "workplace_id" ;
	public final static java.lang.String CS_FILE_SIZE = "file_size" ;
	public final static java.lang.String CS_MD5 = "md5" ;
	public final static java.lang.String CS_CURRENT_UPLOAD_PERSON = "current_upload_person" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,文件编码,新文件版本(备份的文件为上一个该版本的上一个版本),备份文件相对路径,备份时间,工作空间编码,文件大小,MD5,当前上传文件操作人,创建时间";

	public java.lang.Integer getFileBackupId() {
		return this.__file_backup_id;
	}

	public void setFileBackupId( java.lang.Integer value ) {
		this.__file_backup_id = value;
	}

	public java.lang.Integer getCwdFileId() {
		return this.__cwd_file_id;
	}

	public void setCwdFileId( java.lang.Integer value ) {
		this.__cwd_file_id = value;
	}

	public java.lang.Integer getCwdFileVersionId() {
		return this.__cwd_file_version_id;
	}

	public void setCwdFileVersionId( java.lang.Integer value ) {
		this.__cwd_file_version_id = value;
	}

	public java.lang.String getBackupPath() {
		return this.__backup_path;
	}

	public void setBackupPath( java.lang.String value ) {
		this.__backup_path = value;
	}

	public java.util.Date getBackupTime() {
		return this.__backup_time;
	}

	public void setBackupTime( java.util.Date value ) {
		this.__backup_time = value;
	}

	public java.lang.Integer getWorkplaceId() {
		return this.__workplace_id;
	}

	public void setWorkplaceId( java.lang.Integer value ) {
		this.__workplace_id = value;
	}

	public java.lang.Long getFileSize() {
		return this.__file_size;
	}

	public void setFileSize( java.lang.Long value ) {
		this.__file_size = value;
	}

	public java.lang.String getMd5() {
		return this.__md5;
	}

	public void setMd5( java.lang.String value ) {
		this.__md5 = value;
	}

	public java.lang.Integer getCurrentUploadPerson() {
		return this.__current_upload_person;
	}

	public void setCurrentUploadPerson( java.lang.Integer value ) {
		this.__current_upload_person = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdFileBackup __bean){
		__bean.setFileBackupId(getFileBackupId());
		__bean.setCwdFileId(getCwdFileId());
		__bean.setCwdFileVersionId(getCwdFileVersionId());
		__bean.setBackupPath(getBackupPath());
		__bean.setBackupTime(getBackupTime());
		__bean.setWorkplaceId(getWorkplaceId());
		__bean.setFileSize(getFileSize());
		__bean.setMd5(getMd5());
		__bean.setCurrentUploadPerson(getCurrentUploadPerson());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFileBackupId() == null ? "" : getFileBackupId());
		sb.append(",");
		sb.append(getCwdFileId() == null ? "" : getCwdFileId());
		sb.append(",");
		sb.append(getCwdFileVersionId() == null ? "" : getCwdFileVersionId());
		sb.append(",");
		sb.append(getBackupPath() == null ? "" : getBackupPath());
		sb.append(",");
		sb.append(getBackupTime() == null ? "" : sdf.format(getBackupTime()));
		sb.append(",");
		sb.append(getWorkplaceId() == null ? "" : getWorkplaceId());
		sb.append(",");
		sb.append(getFileSize() == null ? "" : getFileSize());
		sb.append(",");
		sb.append(getMd5() == null ? "" : getMd5());
		sb.append(",");
		sb.append(getCurrentUploadPerson() == null ? "" : getCurrentUploadPerson());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFileBackup o) {
		return __file_backup_id == null ? -1 : __file_backup_id.compareTo(o.getFileBackupId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__file_backup_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_version_id);
		hash = 97 * hash + Objects.hashCode(this.__backup_path);
		hash = 97 * hash + Objects.hashCode(this.__backup_time);
		hash = 97 * hash + Objects.hashCode(this.__workplace_id);
		hash = 97 * hash + Objects.hashCode(this.__file_size);
		hash = 97 * hash + Objects.hashCode(this.__md5);
		hash = 97 * hash + Objects.hashCode(this.__current_upload_person);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFileBackup o = (BaseCwdFileBackup)obj;
		if(!Objects.equals(this.__file_backup_id, o.getFileBackupId())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__cwd_file_version_id, o.getCwdFileVersionId())) return false;
		if(!Objects.equals(this.__backup_path, o.getBackupPath())) return false;
		if(!Objects.equals(this.__backup_time, o.getBackupTime())) return false;
		if(!Objects.equals(this.__workplace_id, o.getWorkplaceId())) return false;
		if(!Objects.equals(this.__file_size, o.getFileSize())) return false;
		if(!Objects.equals(this.__md5, o.getMd5())) return false;
		if(!Objects.equals(this.__current_upload_person, o.getCurrentUploadPerson())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFileBackupId() != null) sb.append(__wrapNumber(count++, "fileBackupId", getFileBackupId()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getCwdFileVersionId() != null) sb.append(__wrapNumber(count++, "cwdFileVersionId", getCwdFileVersionId()));
		if(getBackupPath() != null) sb.append(__wrapString(count++, "backupPath", getBackupPath()));
		if(getBackupTime() != null) sb.append(__wrapDate(count++, "backupTime", getBackupTime()));
		if(getWorkplaceId() != null) sb.append(__wrapNumber(count++, "workplaceId", getWorkplaceId()));
		if(getFileSize() != null) sb.append(__wrapNumber(count++, "fileSize", getFileSize()));
		if(getMd5() != null) sb.append(__wrapString(count++, "md5", getMd5()));
		if(getCurrentUploadPerson() != null) sb.append(__wrapNumber(count++, "currentUploadPerson", getCurrentUploadPerson()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFileBackupId() != null) res.put("fileBackupId", getFileBackupId());
		if(getCwdFileId() != null) res.put("cwdFileId", getCwdFileId());
		if(getCwdFileVersionId() != null) res.put("cwdFileVersionId", getCwdFileVersionId());
		if(getBackupPath() != null) res.put("backupPath", getBackupPath());
		if(getBackupTime() != null) res.put("backupTime", getBackupTime());
		if(getWorkplaceId() != null) res.put("workplaceId", getWorkplaceId());
		if(getFileSize() != null) res.put("fileSize", getFileSize());
		if(getMd5() != null) res.put("md5", getMd5());
		if(getCurrentUploadPerson() != null) res.put("currentUploadPerson", getCurrentUploadPerson());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fileBackupId")) != null) setFileBackupId(__getInt(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("cwdFileVersionId")) != null) setCwdFileVersionId(__getInt(val)); 
		if((val = values.get("backupPath")) != null) setBackupPath(__getString(val));
		if((val = values.get("backupTime")) != null) setBackupTime(__getDate(val)); 
		if((val = values.get("workplaceId")) != null) setWorkplaceId(__getInt(val)); 
		if((val = values.get("fileSize")) != null) setFileSize(__getLong(val)); 
		if((val = values.get("md5")) != null) setMd5(__getString(val));
		if((val = values.get("currentUploadPerson")) != null) setCurrentUploadPerson(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __file_backup_id ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.lang.Integer  __cwd_file_version_id ;
	protected java.lang.String  __backup_path ;
	protected java.util.Date  __backup_time ;
	protected java.lang.Integer  __workplace_id ;
	protected java.lang.Long  __file_size ;
	protected java.lang.String  __md5 ;
	protected java.lang.Integer  __current_upload_person ;
	protected java.util.Date  __create_time ;
}
