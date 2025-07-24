package pomplatform.threadTask.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSthreadtaskmanagemmmor extends GenericCondition{

	public ConditionSthreadtaskmanagemmmor(){
		setParameterCount(13);
	}

	public java.util.Date getMinBeginTime() {
		return this.__min_begin_time;
	}

	public void setMinBeginTime( java.util.Date value ) {
		this.__min_begin_time = value;
	}

	public java.util.Date getMaxBeginTime() {
		return this.__max_begin_time;
	}

	public void setMaxBeginTime( java.util.Date value ) {
		this.__max_begin_time = value;
	}

	public java.util.Date getMinEndTime() {
		return this.__min_end_time;
	}

	public void setMinEndTime( java.util.Date value ) {
		this.__min_end_time = value;
	}

	public java.util.Date getMaxEndTime() {
		return this.__max_end_time;
	}

	public void setMaxEndTime( java.util.Date value ) {
		this.__max_end_time = value;
	}

	public java.util.Date getMinCreateTime() {
		return this.__min_create_time;
	}

	public void setMinCreateTime( java.util.Date value ) {
		this.__min_create_time = value;
	}

	public java.util.Date getMaxCreateTime() {
		return this.__max_create_time;
	}

	public void setMaxCreateTime( java.util.Date value ) {
		this.__max_create_time = value;
	}

	public java.lang.String getErrorMsg() {
		return this.__error_msg == null ? null : (this.__error_msg.indexOf("%") >= 0 ? this.__error_msg : "%"+this.__error_msg+"%");
	}

	public void setErrorMsg( java.lang.String value ) {
		this.__error_msg = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getThreadTaskManageId() {
		return this.__thread_task_manage_id;
	}

	public void setThreadTaskManageId( java.lang.Integer value ) {
		this.__thread_task_manage_id = value;
	}

	public java.lang.Integer getTaskType() {
		return this.__task_type;
	}

	public void setTaskType( java.lang.Integer value ) {
		this.__task_type = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Integer getOperationType() {
		return this.__operation_type;
	}

	public void setOperationType( java.lang.Integer value ) {
		this.__operation_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinBeginTime() != null) sb.append(__wrapDate(1, "minBeginTime", getMinBeginTime()));
		if(getMaxBeginTime() != null) sb.append(__wrapDate(1, "maxBeginTime", getMaxBeginTime()));
		if(getMinEndTime() != null) sb.append(__wrapDate(1, "minEndTime", getMinEndTime()));
		if(getMaxEndTime() != null) sb.append(__wrapDate(1, "maxEndTime", getMaxEndTime()));
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getErrorMsg() != null) sb.append(__wrapString(1, "errorMsg", getErrorMsg()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getThreadTaskManageId() != null) sb.append(__wrapNumber(1, "threadTaskManageId", getThreadTaskManageId()));
		if(getTaskType() != null) sb.append(__wrapNumber(1, "taskType", getTaskType()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getOperator() != null) sb.append(__wrapNumber(1, "operator", getOperator()));
		if(getOperationType() != null) sb.append(__wrapNumber(1, "operationType", getOperationType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minBeginTime")) != null) setMinBeginTime(__getDate(val)); 
		if((val = values.get("maxBeginTime")) != null) setMaxBeginTime(__getDate(val)); 
		if((val = values.get("minEndTime")) != null) setMinEndTime(__getDate(val)); 
		if((val = values.get("maxEndTime")) != null) setMaxEndTime(__getDate(val)); 
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("errorMsg")) != null) setErrorMsg(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("threadTaskManageId")) != null) setThreadTaskManageId(__getInt(val)); 
		if((val = values.get("taskType")) != null) setTaskType(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("operationType")) != null) setOperationType(__getInt(val)); 
	}

	private java.util.Date __min_begin_time = null;
	private java.util.Date __max_begin_time = null;
	private java.util.Date __min_end_time = null;
	private java.util.Date __max_end_time = null;
	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.lang.String __error_msg = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __thread_task_manage_id = null;
	private java.lang.Integer __task_type = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __operator = null;
	private java.lang.Integer __operation_type = null;
}

