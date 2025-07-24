package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdTaskDependence extends GenericBase implements BaseFactory<BaseCwdTaskDependence>, Comparable<BaseCwdTaskDependence> 
{


	public static BaseCwdTaskDependence newInstance(){
		return new BaseCwdTaskDependence();
	}

	@Override
	public BaseCwdTaskDependence make(){
		BaseCwdTaskDependence b = new BaseCwdTaskDependence();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_DEPENDENCE_ID = "cwd_task_dependence_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_PREDECESSOR_TASK_MANAGE_ID = "predecessor_task_manage_id" ;
	public final static java.lang.String CS_SUCCESSOR_TASK_MANAGE_ID = "successor_task_manage_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,大项目主键,前置任务id,后置(继承者)任务id,创建时间";

	public java.lang.Integer getCwdTaskDependenceId() {
		return this.__cwd_task_dependence_id;
	}

	public void setCwdTaskDependenceId( java.lang.Integer value ) {
		this.__cwd_task_dependence_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getPredecessorTaskManageId() {
		return this.__predecessor_task_manage_id;
	}

	public void setPredecessorTaskManageId( java.lang.Integer value ) {
		this.__predecessor_task_manage_id = value;
	}

	public java.lang.Integer getSuccessorTaskManageId() {
		return this.__successor_task_manage_id;
	}

	public void setSuccessorTaskManageId( java.lang.Integer value ) {
		this.__successor_task_manage_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdTaskDependence __bean){
		__bean.setCwdTaskDependenceId(getCwdTaskDependenceId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setPredecessorTaskManageId(getPredecessorTaskManageId());
		__bean.setSuccessorTaskManageId(getSuccessorTaskManageId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskDependenceId() == null ? "" : getCwdTaskDependenceId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getPredecessorTaskManageId() == null ? "" : getPredecessorTaskManageId());
		sb.append(",");
		sb.append(getSuccessorTaskManageId() == null ? "" : getSuccessorTaskManageId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdTaskDependence o) {
		return __cwd_task_dependence_id == null ? -1 : __cwd_task_dependence_id.compareTo(o.getCwdTaskDependenceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_dependence_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__predecessor_task_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__successor_task_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdTaskDependence o = (BaseCwdTaskDependence)obj;
		if(!Objects.equals(this.__cwd_task_dependence_id, o.getCwdTaskDependenceId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__predecessor_task_manage_id, o.getPredecessorTaskManageId())) return false;
		if(!Objects.equals(this.__successor_task_manage_id, o.getSuccessorTaskManageId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskDependenceId() != null) sb.append(__wrapNumber(count++, "cwdTaskDependenceId", getCwdTaskDependenceId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getPredecessorTaskManageId() != null) sb.append(__wrapNumber(count++, "predecessorTaskManageId", getPredecessorTaskManageId()));
		if(getSuccessorTaskManageId() != null) sb.append(__wrapNumber(count++, "successorTaskManageId", getSuccessorTaskManageId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskDependenceId")) != null) setCwdTaskDependenceId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("predecessorTaskManageId")) != null) setPredecessorTaskManageId(__getInt(val)); 
		if((val = values.get("successorTaskManageId")) != null) setSuccessorTaskManageId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __cwd_task_dependence_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __predecessor_task_manage_id ;
	protected java.lang.Integer  __successor_task_manage_id ;
	protected java.util.Date  __create_time ;
}
