package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFileProject extends GenericBase implements BaseFactory<BaseCwdFileProject>, Comparable<BaseCwdFileProject> 
{


	public static BaseCwdFileProject newInstance(){
		return new BaseCwdFileProject();
	}

	@Override
	public BaseCwdFileProject make(){
		BaseCwdFileProject b = new BaseCwdFileProject();
		return b;
	}

	public final static java.lang.String CS_CWD_FILE_PROJECT_ID = "cwd_file_project_id" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,cwd_files表的主键,main_projects表的主键";

	public java.lang.Integer getCwdFileProjectId() {
		return this.__cwd_file_project_id;
	}

	public void setCwdFileProjectId( java.lang.Integer value ) {
		this.__cwd_file_project_id = value;
	}

	public java.lang.Integer getCwdFileId() {
		return this.__cwd_file_id;
	}

	public void setCwdFileId( java.lang.Integer value ) {
		this.__cwd_file_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public void cloneCopy(BaseCwdFileProject __bean){
		__bean.setCwdFileProjectId(getCwdFileProjectId());
		__bean.setCwdFileId(getCwdFileId());
		__bean.setProjectId(getProjectId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdFileProjectId() == null ? "" : getCwdFileProjectId());
		sb.append(",");
		sb.append(getCwdFileId() == null ? "" : getCwdFileId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFileProject o) {
		return __cwd_file_project_id == null ? -1 : __cwd_file_project_id.compareTo(o.getCwdFileProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_project_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFileProject o = (BaseCwdFileProject)obj;
		if(!Objects.equals(this.__cwd_file_project_id, o.getCwdFileProjectId())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdFileProjectId() != null) sb.append(__wrapNumber(count++, "cwdFileProjectId", getCwdFileProjectId()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdFileProjectId")) != null) setCwdFileProjectId(__getInt(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_file_project_id ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.lang.Integer  __project_id ;
}
