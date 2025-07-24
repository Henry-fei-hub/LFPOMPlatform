package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdTaskTemplateDependence extends GenericBase implements BaseFactory<BaseCwdTaskTemplateDependence>, Comparable<BaseCwdTaskTemplateDependence> 
{


	public static BaseCwdTaskTemplateDependence newInstance(){
		return new BaseCwdTaskTemplateDependence();
	}

	@Override
	public BaseCwdTaskTemplateDependence make(){
		BaseCwdTaskTemplateDependence b = new BaseCwdTaskTemplateDependence();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_TEMPLATE_DEPENDENCE_ID = "cwd_task_template_dependence_id" ;
	public final static java.lang.String CS_CWD_TASK_TEMPLATE_ID = "cwd_task_template_id" ;
	public final static java.lang.String CS_PREDECESSOR_TASK_ID = "predecessor_task_id" ;
	public final static java.lang.String CS_SUCCESSOR_TASK_ID = "successor_task_id" ;

	public final static java.lang.String ALL_CAPTIONS = "前置id,模板主键,前置任务id,后置(继承者)任务id";

	public java.lang.Integer getCwdTaskTemplateDependenceId() {
		return this.__cwd_task_template_dependence_id;
	}

	public void setCwdTaskTemplateDependenceId( java.lang.Integer value ) {
		this.__cwd_task_template_dependence_id = value;
	}

	public java.lang.Integer getCwdTaskTemplateId() {
		return this.__cwd_task_template_id;
	}

	public void setCwdTaskTemplateId( java.lang.Integer value ) {
		this.__cwd_task_template_id = value;
	}

	public java.lang.Integer getPredecessorTaskId() {
		return this.__predecessor_task_id;
	}

	public void setPredecessorTaskId( java.lang.Integer value ) {
		this.__predecessor_task_id = value;
	}

	public java.lang.Integer getSuccessorTaskId() {
		return this.__successor_task_id;
	}

	public void setSuccessorTaskId( java.lang.Integer value ) {
		this.__successor_task_id = value;
	}

	public void cloneCopy(BaseCwdTaskTemplateDependence __bean){
		__bean.setCwdTaskTemplateDependenceId(getCwdTaskTemplateDependenceId());
		__bean.setCwdTaskTemplateId(getCwdTaskTemplateId());
		__bean.setPredecessorTaskId(getPredecessorTaskId());
		__bean.setSuccessorTaskId(getSuccessorTaskId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskTemplateDependenceId() == null ? "" : getCwdTaskTemplateDependenceId());
		sb.append(",");
		sb.append(getCwdTaskTemplateId() == null ? "" : getCwdTaskTemplateId());
		sb.append(",");
		sb.append(getPredecessorTaskId() == null ? "" : getPredecessorTaskId());
		sb.append(",");
		sb.append(getSuccessorTaskId() == null ? "" : getSuccessorTaskId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdTaskTemplateDependence o) {
		return __cwd_task_template_dependence_id == null ? -1 : __cwd_task_template_dependence_id.compareTo(o.getCwdTaskTemplateDependenceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_template_dependence_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_template_id);
		hash = 97 * hash + Objects.hashCode(this.__predecessor_task_id);
		hash = 97 * hash + Objects.hashCode(this.__successor_task_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdTaskTemplateDependence o = (BaseCwdTaskTemplateDependence)obj;
		if(!Objects.equals(this.__cwd_task_template_dependence_id, o.getCwdTaskTemplateDependenceId())) return false;
		if(!Objects.equals(this.__cwd_task_template_id, o.getCwdTaskTemplateId())) return false;
		if(!Objects.equals(this.__predecessor_task_id, o.getPredecessorTaskId())) return false;
		if(!Objects.equals(this.__successor_task_id, o.getSuccessorTaskId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskTemplateDependenceId() != null) sb.append(__wrapNumber(count++, "cwdTaskTemplateDependenceId", getCwdTaskTemplateDependenceId()));
		if(getCwdTaskTemplateId() != null) sb.append(__wrapNumber(count++, "cwdTaskTemplateId", getCwdTaskTemplateId()));
		if(getPredecessorTaskId() != null) sb.append(__wrapNumber(count++, "predecessorTaskId", getPredecessorTaskId()));
		if(getSuccessorTaskId() != null) sb.append(__wrapNumber(count++, "successorTaskId", getSuccessorTaskId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskTemplateDependenceId")) != null) setCwdTaskTemplateDependenceId(__getInt(val)); 
		if((val = values.get("cwdTaskTemplateId")) != null) setCwdTaskTemplateId(__getInt(val)); 
		if((val = values.get("predecessorTaskId")) != null) setPredecessorTaskId(__getInt(val)); 
		if((val = values.get("successorTaskId")) != null) setSuccessorTaskId(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_task_template_dependence_id ;
	protected java.lang.Integer  __cwd_task_template_id ;
	protected java.lang.Integer  __predecessor_task_id ;
	protected java.lang.Integer  __successor_task_id ;
}
