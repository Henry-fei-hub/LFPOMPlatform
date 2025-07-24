package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdTaskEvaluate extends GenericBase implements BaseFactory<BaseCwdTaskEvaluate>, Comparable<BaseCwdTaskEvaluate> 
{


	public static BaseCwdTaskEvaluate newInstance(){
		return new BaseCwdTaskEvaluate();
	}

	@Override
	public BaseCwdTaskEvaluate make(){
		BaseCwdTaskEvaluate b = new BaseCwdTaskEvaluate();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_EVALUATE_ID = "cwd_task_evaluate_id" ;
	public final static java.lang.String CS_CWD_TASK_PROCESS_ID = "cwd_task_process_id" ;
	public final static java.lang.String CS_CWD_TASK_MANAGE_ID = "cwd_task_manage_id" ;
	public final static java.lang.String CS_EVALUATE_CONTENT = "evaluate_content" ;
	public final static java.lang.String CS_TASK_GRADE = "task_grade" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,评审流程业务表主键,任务主键,评价内容,任务评分,操作人主键,创建时间";

	public java.lang.Integer getCwdTaskEvaluateId() {
		return this.__cwd_task_evaluate_id;
	}

	public void setCwdTaskEvaluateId( java.lang.Integer value ) {
		this.__cwd_task_evaluate_id = value;
	}

	public java.lang.Integer getCwdTaskProcessId() {
		return this.__cwd_task_process_id;
	}

	public void setCwdTaskProcessId( java.lang.Integer value ) {
		this.__cwd_task_process_id = value;
	}

	public java.lang.Integer getCwdTaskManageId() {
		return this.__cwd_task_manage_id;
	}

	public void setCwdTaskManageId( java.lang.Integer value ) {
		this.__cwd_task_manage_id = value;
	}

	public java.lang.String getEvaluateContent() {
		return this.__evaluate_content;
	}

	public void setEvaluateContent( java.lang.String value ) {
		this.__evaluate_content = value;
	}

	public java.lang.Integer getTaskGrade() {
		return this.__task_grade;
	}

	public void setTaskGrade( java.lang.Integer value ) {
		this.__task_grade = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdTaskEvaluate __bean){
		__bean.setCwdTaskEvaluateId(getCwdTaskEvaluateId());
		__bean.setCwdTaskProcessId(getCwdTaskProcessId());
		__bean.setCwdTaskManageId(getCwdTaskManageId());
		__bean.setEvaluateContent(getEvaluateContent());
		__bean.setTaskGrade(getTaskGrade());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskEvaluateId() == null ? "" : getCwdTaskEvaluateId());
		sb.append(",");
		sb.append(getCwdTaskProcessId() == null ? "" : getCwdTaskProcessId());
		sb.append(",");
		sb.append(getCwdTaskManageId() == null ? "" : getCwdTaskManageId());
		sb.append(",");
		sb.append(getEvaluateContent() == null ? "" : getEvaluateContent());
		sb.append(",");
		sb.append(getTaskGrade() == null ? "" : getTaskGrade());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdTaskEvaluate o) {
		return __cwd_task_evaluate_id == null ? -1 : __cwd_task_evaluate_id.compareTo(o.getCwdTaskEvaluateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_evaluate_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_process_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__evaluate_content);
		hash = 97 * hash + Objects.hashCode(this.__task_grade);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdTaskEvaluate o = (BaseCwdTaskEvaluate)obj;
		if(!Objects.equals(this.__cwd_task_evaluate_id, o.getCwdTaskEvaluateId())) return false;
		if(!Objects.equals(this.__cwd_task_process_id, o.getCwdTaskProcessId())) return false;
		if(!Objects.equals(this.__cwd_task_manage_id, o.getCwdTaskManageId())) return false;
		if(!Objects.equals(this.__evaluate_content, o.getEvaluateContent())) return false;
		if(!Objects.equals(this.__task_grade, o.getTaskGrade())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskEvaluateId() != null) sb.append(__wrapNumber(count++, "cwdTaskEvaluateId", getCwdTaskEvaluateId()));
		if(getCwdTaskProcessId() != null) sb.append(__wrapNumber(count++, "cwdTaskProcessId", getCwdTaskProcessId()));
		if(getCwdTaskManageId() != null) sb.append(__wrapNumber(count++, "cwdTaskManageId", getCwdTaskManageId()));
		if(getEvaluateContent() != null) sb.append(__wrapString(count++, "evaluateContent", getEvaluateContent()));
		if(getTaskGrade() != null) sb.append(__wrapNumber(count++, "taskGrade", getTaskGrade()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskEvaluateId")) != null) setCwdTaskEvaluateId(__getInt(val)); 
		if((val = values.get("cwdTaskProcessId")) != null) setCwdTaskProcessId(__getInt(val)); 
		if((val = values.get("cwdTaskManageId")) != null) setCwdTaskManageId(__getInt(val)); 
		if((val = values.get("evaluateContent")) != null) setEvaluateContent(__getString(val));
		if((val = values.get("taskGrade")) != null) setTaskGrade(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __cwd_task_evaluate_id ;
	protected java.lang.Integer  __cwd_task_process_id ;
	protected java.lang.Integer  __cwd_task_manage_id ;
	protected java.lang.String  __evaluate_content ;
	protected java.lang.Integer  __task_grade ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __create_time ;
}
