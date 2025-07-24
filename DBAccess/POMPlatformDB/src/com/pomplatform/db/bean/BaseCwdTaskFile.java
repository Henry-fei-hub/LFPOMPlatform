package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdTaskFile extends GenericBase implements BaseFactory<BaseCwdTaskFile>, Comparable<BaseCwdTaskFile> 
{


	public static BaseCwdTaskFile newInstance(){
		return new BaseCwdTaskFile();
	}

	@Override
	public BaseCwdTaskFile make(){
		BaseCwdTaskFile b = new BaseCwdTaskFile();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_FILE_ID = "cwd_task_file_id" ;
	public final static java.lang.String CS_CWD_TASK_MANAGE_ID = "cwd_task_manage_id" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,任务主键,文件主键,项目主键,创建时间,操作人";

	public java.lang.Integer getCwdTaskFileId() {
		return this.__cwd_task_file_id;
	}

	public void setCwdTaskFileId( java.lang.Integer value ) {
		this.__cwd_task_file_id = value;
	}

	public java.lang.Integer getCwdTaskManageId() {
		return this.__cwd_task_manage_id;
	}

	public void setCwdTaskManageId( java.lang.Integer value ) {
		this.__cwd_task_manage_id = value;
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

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public void cloneCopy(BaseCwdTaskFile __bean){
		__bean.setCwdTaskFileId(getCwdTaskFileId());
		__bean.setCwdTaskManageId(getCwdTaskManageId());
		__bean.setCwdFileId(getCwdFileId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setCreateTime(getCreateTime());
		__bean.setOperatorId(getOperatorId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskFileId() == null ? "" : getCwdTaskFileId());
		sb.append(",");
		sb.append(getCwdTaskManageId() == null ? "" : getCwdTaskManageId());
		sb.append(",");
		sb.append(getCwdFileId() == null ? "" : getCwdFileId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdTaskFile o) {
		return __cwd_task_file_id == null ? -1 : __cwd_task_file_id.compareTo(o.getCwdTaskFileId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_file_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdTaskFile o = (BaseCwdTaskFile)obj;
		if(!Objects.equals(this.__cwd_task_file_id, o.getCwdTaskFileId())) return false;
		if(!Objects.equals(this.__cwd_task_manage_id, o.getCwdTaskManageId())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskFileId() != null) sb.append(__wrapNumber(count++, "cwdTaskFileId", getCwdTaskFileId()));
		if(getCwdTaskManageId() != null) sb.append(__wrapNumber(count++, "cwdTaskManageId", getCwdTaskManageId()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskFileId")) != null) setCwdTaskFileId(__getInt(val)); 
		if((val = values.get("cwdTaskManageId")) != null) setCwdTaskManageId(__getInt(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_task_file_id ;
	protected java.lang.Integer  __cwd_task_manage_id ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __operator_id ;
}
