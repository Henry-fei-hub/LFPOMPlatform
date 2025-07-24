package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCwdCustomSyncFile extends GenericBase implements BaseFactory<BaseCwdCustomSyncFile>, Comparable<BaseCwdCustomSyncFile> 
{


	public static BaseCwdCustomSyncFile newInstance(){
		return new BaseCwdCustomSyncFile();
	}

	@Override
	public BaseCwdCustomSyncFile make(){
		BaseCwdCustomSyncFile b = new BaseCwdCustomSyncFile();
		return b;
	}

	public final static java.lang.String CS_CUSTOM_SYNC_FILE_ID = "custom_sync_file_id" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,文件编码,项目,人员,创建时间";

	public java.lang.Integer getCustomSyncFileId() {
		return this.__custom_sync_file_id;
	}

	public void setCustomSyncFileId( java.lang.Integer value ) {
		this.__custom_sync_file_id = value;
	}

	public java.lang.Integer getCwdFileId() {
		return this.__cwd_file_id;
	}

	public void setCwdFileId( java.lang.Integer value ) {
		this.__cwd_file_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdCustomSyncFile __bean){
		__bean.setCustomSyncFileId(getCustomSyncFileId());
		__bean.setCwdFileId(getCwdFileId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCustomSyncFileId() == null ? "" : getCustomSyncFileId());
		sb.append(",");
		sb.append(getCwdFileId() == null ? "" : getCwdFileId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdCustomSyncFile o) {
		return __custom_sync_file_id == null ? -1 : __custom_sync_file_id.compareTo(o.getCustomSyncFileId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__custom_sync_file_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdCustomSyncFile o = (BaseCwdCustomSyncFile)obj;
		if(!Objects.equals(this.__custom_sync_file_id, o.getCustomSyncFileId())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCustomSyncFileId() != null) sb.append(__wrapNumber(count++, "customSyncFileId", getCustomSyncFileId()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCustomSyncFileId() != null) res.put("customSyncFileId", getCustomSyncFileId());
		if(getCwdFileId() != null) res.put("cwdFileId", getCwdFileId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("customSyncFileId")) != null) setCustomSyncFileId(__getInt(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __custom_sync_file_id ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __create_time ;
}
