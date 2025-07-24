package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdTaskTemplateDetail extends GenericBase implements BaseFactory<BaseCwdTaskTemplateDetail>, Comparable<BaseCwdTaskTemplateDetail> 
{


	public static BaseCwdTaskTemplateDetail newInstance(){
		return new BaseCwdTaskTemplateDetail();
	}

	@Override
	public BaseCwdTaskTemplateDetail make(){
		BaseCwdTaskTemplateDetail b = new BaseCwdTaskTemplateDetail();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_TEMPLATE_DETAIL_ID = "cwd_task_template_detail_id" ;
	public final static java.lang.String CS_CWD_TASK_TEMPLATE_ID = "cwd_task_template_id" ;
	public final static java.lang.String CS_TASK_NAME = "task_name" ;
	public final static java.lang.String CS_TASK_CONTENT = "task_content" ;
	public final static java.lang.String CS_TASK_DEMAND = "task_demand" ;
	public final static java.lang.String CS_NUMBER_OF_DAY = "number_of_day" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_ORDER_NUM = "order_num" ;
	public final static java.lang.String CS_TASK_TYPE = "task_type" ;
	public final static java.lang.String CS_TASK_LEVEL = "task_level" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,模板主键,任务名称,任务内容,任务要求,天数,父级任务,排序值  升序,任务类型 1业态 2专业 3阶段 4任务,任务级别 1普通 2紧急 3非常紧急";

	public java.lang.Integer getCwdTaskTemplateDetailId() {
		return this.__cwd_task_template_detail_id;
	}

	public void setCwdTaskTemplateDetailId( java.lang.Integer value ) {
		this.__cwd_task_template_detail_id = value;
	}

	public java.lang.Integer getCwdTaskTemplateId() {
		return this.__cwd_task_template_id;
	}

	public void setCwdTaskTemplateId( java.lang.Integer value ) {
		this.__cwd_task_template_id = value;
	}

	public java.lang.String getTaskName() {
		return this.__task_name;
	}

	public void setTaskName( java.lang.String value ) {
		this.__task_name = value;
	}

	public java.lang.String getTaskContent() {
		return this.__task_content;
	}

	public void setTaskContent( java.lang.String value ) {
		this.__task_content = value;
	}

	public java.lang.String getTaskDemand() {
		return this.__task_demand;
	}

	public void setTaskDemand( java.lang.String value ) {
		this.__task_demand = value;
	}

	public java.lang.Integer getNumberOfDay() {
		return this.__number_of_day;
	}

	public void setNumberOfDay( java.lang.Integer value ) {
		this.__number_of_day = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getOrderNum() {
		return this.__order_num;
	}

	public void setOrderNum( java.lang.Integer value ) {
		this.__order_num = value;
	}

	public java.lang.Integer getTaskType() {
		return this.__task_type;
	}

	public void setTaskType( java.lang.Integer value ) {
		this.__task_type = value;
	}

	public java.lang.Integer getTaskLevel() {
		return this.__task_level;
	}

	public void setTaskLevel( java.lang.Integer value ) {
		this.__task_level = value;
	}

	public void cloneCopy(BaseCwdTaskTemplateDetail __bean){
		__bean.setCwdTaskTemplateDetailId(getCwdTaskTemplateDetailId());
		__bean.setCwdTaskTemplateId(getCwdTaskTemplateId());
		__bean.setTaskName(getTaskName());
		__bean.setTaskContent(getTaskContent());
		__bean.setTaskDemand(getTaskDemand());
		__bean.setNumberOfDay(getNumberOfDay());
		__bean.setParentId(getParentId());
		__bean.setOrderNum(getOrderNum());
		__bean.setTaskType(getTaskType());
		__bean.setTaskLevel(getTaskLevel());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskTemplateDetailId() == null ? "" : getCwdTaskTemplateDetailId());
		sb.append(",");
		sb.append(getCwdTaskTemplateId() == null ? "" : getCwdTaskTemplateId());
		sb.append(",");
		sb.append(getTaskName() == null ? "" : getTaskName());
		sb.append(",");
		sb.append(getTaskContent() == null ? "" : getTaskContent());
		sb.append(",");
		sb.append(getTaskDemand() == null ? "" : getTaskDemand());
		sb.append(",");
		sb.append(getNumberOfDay() == null ? "" : getNumberOfDay());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getOrderNum() == null ? "" : getOrderNum());
		sb.append(",");
		sb.append(getTaskType() == null ? "" : getTaskType());
		sb.append(",");
		sb.append(getTaskLevel() == null ? "" : getTaskLevel());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdTaskTemplateDetail o) {
		return __cwd_task_template_detail_id == null ? -1 : __cwd_task_template_detail_id.compareTo(o.getCwdTaskTemplateDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_template_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_template_id);
		hash = 97 * hash + Objects.hashCode(this.__task_name);
		hash = 97 * hash + Objects.hashCode(this.__task_content);
		hash = 97 * hash + Objects.hashCode(this.__task_demand);
		hash = 97 * hash + Objects.hashCode(this.__number_of_day);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__order_num);
		hash = 97 * hash + Objects.hashCode(this.__task_type);
		hash = 97 * hash + Objects.hashCode(this.__task_level);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdTaskTemplateDetail o = (BaseCwdTaskTemplateDetail)obj;
		if(!Objects.equals(this.__cwd_task_template_detail_id, o.getCwdTaskTemplateDetailId())) return false;
		if(!Objects.equals(this.__cwd_task_template_id, o.getCwdTaskTemplateId())) return false;
		if(!Objects.equals(this.__task_name, o.getTaskName())) return false;
		if(!Objects.equals(this.__task_content, o.getTaskContent())) return false;
		if(!Objects.equals(this.__task_demand, o.getTaskDemand())) return false;
		if(!Objects.equals(this.__number_of_day, o.getNumberOfDay())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__order_num, o.getOrderNum())) return false;
		if(!Objects.equals(this.__task_type, o.getTaskType())) return false;
		if(!Objects.equals(this.__task_level, o.getTaskLevel())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskTemplateDetailId() != null) sb.append(__wrapNumber(count++, "cwdTaskTemplateDetailId", getCwdTaskTemplateDetailId()));
		if(getCwdTaskTemplateId() != null) sb.append(__wrapNumber(count++, "cwdTaskTemplateId", getCwdTaskTemplateId()));
		if(getTaskName() != null) sb.append(__wrapString(count++, "taskName", getTaskName()));
		if(getTaskContent() != null) sb.append(__wrapString(count++, "taskContent", getTaskContent()));
		if(getTaskDemand() != null) sb.append(__wrapString(count++, "taskDemand", getTaskDemand()));
		if(getNumberOfDay() != null) sb.append(__wrapNumber(count++, "numberOfDay", getNumberOfDay()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getOrderNum() != null) sb.append(__wrapNumber(count++, "orderNum", getOrderNum()));
		if(getTaskType() != null) sb.append(__wrapNumber(count++, "taskType", getTaskType()));
		if(getTaskLevel() != null) sb.append(__wrapNumber(count++, "taskLevel", getTaskLevel()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskTemplateDetailId")) != null) setCwdTaskTemplateDetailId(__getInt(val)); 
		if((val = values.get("cwdTaskTemplateId")) != null) setCwdTaskTemplateId(__getInt(val)); 
		if((val = values.get("taskName")) != null) setTaskName(__getString(val));
		if((val = values.get("taskContent")) != null) setTaskContent(__getString(val));
		if((val = values.get("taskDemand")) != null) setTaskDemand(__getString(val));
		if((val = values.get("numberOfDay")) != null) setNumberOfDay(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("orderNum")) != null) setOrderNum(__getInt(val)); 
		if((val = values.get("taskType")) != null) setTaskType(__getInt(val)); 
		if((val = values.get("taskLevel")) != null) setTaskLevel(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_task_template_detail_id ;
	protected java.lang.Integer  __cwd_task_template_id ;
	protected java.lang.String  __task_name ;
	protected java.lang.String  __task_content ;
	protected java.lang.String  __task_demand ;
	protected java.lang.Integer  __number_of_day ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __order_num ;
	protected java.lang.Integer  __task_type ;
	protected java.lang.Integer  __task_level ;
}
