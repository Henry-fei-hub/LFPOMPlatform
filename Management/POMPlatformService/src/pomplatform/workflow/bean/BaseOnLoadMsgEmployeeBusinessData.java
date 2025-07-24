package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadMsgEmployeeBusinessData extends GenericBase implements BaseFactory<BaseOnLoadMsgEmployeeBusinessData>, Comparable<BaseOnLoadMsgEmployeeBusinessData> 
{


	public static BaseOnLoadMsgEmployeeBusinessData newInstance(){
		return new BaseOnLoadMsgEmployeeBusinessData();
	}

	@Override
	public BaseOnLoadMsgEmployeeBusinessData make(){
		BaseOnLoadMsgEmployeeBusinessData b = new BaseOnLoadMsgEmployeeBusinessData();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE_NAME = "process_type_name" ;
	public final static java.lang.String CS_PROCESS_POOLED_TASK_ID = "process_pooled_task_id" ;
	public final static java.lang.String CS_TYPE_FLAG = "type_flag" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ACTIVITY_ID = "process_activity_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_NODE_TYPE = "node_type" ;
	public final static java.lang.String CS_ACTIVITY_ID = "activity_id" ;
	public final static java.lang.String CS_NEXT_ACTIVITY_ID = "next_activity_id" ;
	public final static java.lang.String CS_MAIN_ACTIVITY_ID = "main_activity_id" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_CREATE_TIME = "instance_activity_create_time" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_PROCESS_COMMENT = "process_comment" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_ACTIVITY_TYPE = "activity_type" ;
	public final static java.lang.String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static java.lang.String CS_EMPLOYEE_1 = "employee_1" ;
	public final static java.lang.String CS_EMPLOYEE_2 = "employee_2" ;
	public final static java.lang.String CS_EMPLOYEE_STATUS = "employee_status" ;
	public final static java.lang.String CS_COMPANY_WEIXIN = "company_weixin" ;
	public final static java.lang.String CS_ACTIVITY_NAME = "activity_name" ;
	public final static java.lang.String CS_TIME_OUT_ACTION = "time_out_action" ;
	public final static java.lang.String CS_MESSAGE_1 = "message_1" ;
	public final static java.lang.String CS_MESSAGE_2 = "message_2" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型名称,主键编码,,主键编码,业务编码,业务名称,活动编码,流程编码,流程实列编码,附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人,当前流程实例节点的内部编码,下一个流程节点的编码,如果是知会节点，所依附的主节点,流程实例节点创建时间,流程实例节点开始处于活动时间,操作时间,提交意见,状态,节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会,返回数据集,,,,企业微信账号,活动节点名称,活动时限,,";

	public java.lang.String getProcessTypeName() {
		return this.__process_type_name;
	}

	public void setProcessTypeName( java.lang.String value ) {
		this.__process_type_name = value;
	}

	public java.lang.Integer getProcessPooledTaskId() {
		return this.__process_pooled_task_id;
	}

	public void setProcessPooledTaskId( java.lang.Integer value ) {
		this.__process_pooled_task_id = value;
	}

	public java.lang.Integer getTypeFlag() {
		return this.__type_flag;
	}

	public void setTypeFlag( java.lang.Integer value ) {
		this.__type_flag = value;
	}

	public java.lang.Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( java.lang.Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.Integer getProcessActivityId() {
		return this.__process_activity_id;
	}

	public void setProcessActivityId( java.lang.Integer value ) {
		this.__process_activity_id = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getNodeType() {
		return this.__node_type;
	}

	public void setNodeType( java.lang.Integer value ) {
		this.__node_type = value;
	}

	public java.lang.Integer getActivityId() {
		return this.__activity_id;
	}

	public void setActivityId( java.lang.Integer value ) {
		this.__activity_id = value;
	}

	public java.lang.Integer getNextActivityId() {
		return this.__next_activity_id;
	}

	public void setNextActivityId( java.lang.Integer value ) {
		this.__next_activity_id = value;
	}

	public java.lang.Integer getMainActivityId() {
		return this.__main_activity_id;
	}

	public void setMainActivityId( java.lang.Integer value ) {
		this.__main_activity_id = value;
	}

	public java.util.Date getInstanceActivityCreateTime() {
		return this.__instance_activity_create_time;
	}

	public void setInstanceActivityCreateTime( java.util.Date value ) {
		this.__instance_activity_create_time = value;
	}

	public java.util.Date getInstanceActivityStartTime() {
		return this.__instance_activity_start_time;
	}

	public void setInstanceActivityStartTime( java.util.Date value ) {
		this.__instance_activity_start_time = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getProcessComment() {
		return this.__process_comment;
	}

	public void setProcessComment( java.lang.String value ) {
		this.__process_comment = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getActivityType() {
		return this.__activity_type;
	}

	public void setActivityType( java.lang.Integer value ) {
		this.__activity_type = value;
	}

	public java.lang.String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( java.lang.String value ) {
		this.__back_view_name = value;
	}

	public java.lang.Integer getEmployee1() {
		return this.__employee_1;
	}

	public void setEmployee1( java.lang.Integer value ) {
		this.__employee_1 = value;
	}

	public java.lang.Integer getEmployee2() {
		return this.__employee_2;
	}

	public void setEmployee2( java.lang.Integer value ) {
		this.__employee_2 = value;
	}

	public java.lang.Integer getEmployeeStatus() {
		return this.__employee_status;
	}

	public void setEmployeeStatus( java.lang.Integer value ) {
		this.__employee_status = value;
	}

	public java.lang.String getCompanyWeixin() {
		return this.__company_weixin;
	}

	public void setCompanyWeixin( java.lang.String value ) {
		this.__company_weixin = value;
	}

	public java.lang.String getActivityName() {
		return this.__activity_name;
	}

	public void setActivityName( java.lang.String value ) {
		this.__activity_name = value;
	}

	public java.lang.Integer getTimeOutAction() {
		return this.__time_out_action;
	}

	public void setTimeOutAction( java.lang.Integer value ) {
		this.__time_out_action = value;
	}

	public java.lang.Integer getMessage1() {
		return this.__message_1;
	}

	public void setMessage1( java.lang.Integer value ) {
		this.__message_1 = value;
	}

	public java.lang.Integer getMessage2() {
		return this.__message_2;
	}

	public void setMessage2( java.lang.Integer value ) {
		this.__message_2 = value;
	}

	public void cloneCopy(BaseOnLoadMsgEmployeeBusinessData __bean){
		__bean.setProcessTypeName(getProcessTypeName());
		__bean.setProcessPooledTaskId(getProcessPooledTaskId());
		__bean.setTypeFlag(getTypeFlag());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessActivityId(getProcessActivityId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setNodeType(getNodeType());
		__bean.setActivityId(getActivityId());
		__bean.setNextActivityId(getNextActivityId());
		__bean.setMainActivityId(getMainActivityId());
		__bean.setInstanceActivityCreateTime(getInstanceActivityCreateTime());
		__bean.setInstanceActivityStartTime(getInstanceActivityStartTime());
		__bean.setOperateTime(getOperateTime());
		__bean.setProcessComment(getProcessComment());
		__bean.setStatus(getStatus());
		__bean.setActivityType(getActivityType());
		__bean.setBackViewName(getBackViewName());
		__bean.setEmployee1(getEmployee1());
		__bean.setEmployee2(getEmployee2());
		__bean.setEmployeeStatus(getEmployeeStatus());
		__bean.setCompanyWeixin(getCompanyWeixin());
		__bean.setActivityName(getActivityName());
		__bean.setTimeOutAction(getTimeOutAction());
		__bean.setMessage1(getMessage1());
		__bean.setMessage2(getMessage2());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessTypeName() == null ? "" : getProcessTypeName());
		sb.append(",");
		sb.append(getProcessPooledTaskId() == null ? "" : getProcessPooledTaskId());
		sb.append(",");
		sb.append(getTypeFlag() == null ? "" : getTypeFlag());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessActivityId() == null ? "" : getProcessActivityId());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getNodeType() == null ? "" : getNodeType());
		sb.append(",");
		sb.append(getActivityId() == null ? "" : getActivityId());
		sb.append(",");
		sb.append(getNextActivityId() == null ? "" : getNextActivityId());
		sb.append(",");
		sb.append(getMainActivityId() == null ? "" : getMainActivityId());
		sb.append(",");
		sb.append(getInstanceActivityCreateTime() == null ? "" : sdf.format(getInstanceActivityCreateTime()));
		sb.append(",");
		sb.append(getInstanceActivityStartTime() == null ? "" : sdf.format(getInstanceActivityStartTime()));
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getProcessComment() == null ? "" : getProcessComment());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getActivityType() == null ? "" : getActivityType());
		sb.append(",");
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		sb.append(",");
		sb.append(getEmployee1() == null ? "" : getEmployee1());
		sb.append(",");
		sb.append(getEmployee2() == null ? "" : getEmployee2());
		sb.append(",");
		sb.append(getEmployeeStatus() == null ? "" : getEmployeeStatus());
		sb.append(",");
		sb.append(getCompanyWeixin() == null ? "" : getCompanyWeixin());
		sb.append(",");
		sb.append(getActivityName() == null ? "" : getActivityName());
		sb.append(",");
		sb.append(getTimeOutAction() == null ? "" : getTimeOutAction());
		sb.append(",");
		sb.append(getMessage1() == null ? "" : getMessage1());
		sb.append(",");
		sb.append(getMessage2() == null ? "" : getMessage2());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadMsgEmployeeBusinessData o) {
		return __process_pooled_task_id == null ? -1 : __process_pooled_task_id.compareTo(o.getProcessPooledTaskId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type_name);
		hash = 97 * hash + Objects.hashCode(this.__process_pooled_task_id);
		hash = 97 * hash + Objects.hashCode(this.__type_flag);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__node_type);
		hash = 97 * hash + Objects.hashCode(this.__activity_id);
		hash = 97 * hash + Objects.hashCode(this.__next_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__main_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_create_time);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_start_time);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__process_comment);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__activity_type);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_1);
		hash = 97 * hash + Objects.hashCode(this.__employee_2);
		hash = 97 * hash + Objects.hashCode(this.__employee_status);
		hash = 97 * hash + Objects.hashCode(this.__company_weixin);
		hash = 97 * hash + Objects.hashCode(this.__activity_name);
		hash = 97 * hash + Objects.hashCode(this.__time_out_action);
		hash = 97 * hash + Objects.hashCode(this.__message_1);
		hash = 97 * hash + Objects.hashCode(this.__message_2);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadMsgEmployeeBusinessData o = (BaseOnLoadMsgEmployeeBusinessData)obj;
		if(!Objects.equals(this.__process_type_name, o.getProcessTypeName())) return false;
		if(!Objects.equals(this.__process_pooled_task_id, o.getProcessPooledTaskId())) return false;
		if(!Objects.equals(this.__type_flag, o.getTypeFlag())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_activity_id, o.getProcessActivityId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__node_type, o.getNodeType())) return false;
		if(!Objects.equals(this.__activity_id, o.getActivityId())) return false;
		if(!Objects.equals(this.__next_activity_id, o.getNextActivityId())) return false;
		if(!Objects.equals(this.__main_activity_id, o.getMainActivityId())) return false;
		if(!Objects.equals(this.__instance_activity_create_time, o.getInstanceActivityCreateTime())) return false;
		if(!Objects.equals(this.__instance_activity_start_time, o.getInstanceActivityStartTime())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__process_comment, o.getProcessComment())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__activity_type, o.getActivityType())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__employee_1, o.getEmployee1())) return false;
		if(!Objects.equals(this.__employee_2, o.getEmployee2())) return false;
		if(!Objects.equals(this.__employee_status, o.getEmployeeStatus())) return false;
		if(!Objects.equals(this.__company_weixin, o.getCompanyWeixin())) return false;
		if(!Objects.equals(this.__activity_name, o.getActivityName())) return false;
		if(!Objects.equals(this.__time_out_action, o.getTimeOutAction())) return false;
		if(!Objects.equals(this.__message_1, o.getMessage1())) return false;
		if(!Objects.equals(this.__message_2, o.getMessage2())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessTypeName() != null) sb.append(__wrapString(count++, "processTypeName", getProcessTypeName()));
		if(getProcessPooledTaskId() != null) sb.append(__wrapNumber(count++, "processPooledTaskId", getProcessPooledTaskId()));
		if(getTypeFlag() != null) sb.append(__wrapNumber(count++, "typeFlag", getTypeFlag()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessActivityId() != null) sb.append(__wrapNumber(count++, "processActivityId", getProcessActivityId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getNodeType() != null) sb.append(__wrapNumber(count++, "nodeType", getNodeType()));
		if(getActivityId() != null) sb.append(__wrapNumber(count++, "activityId", getActivityId()));
		if(getNextActivityId() != null) sb.append(__wrapNumber(count++, "nextActivityId", getNextActivityId()));
		if(getMainActivityId() != null) sb.append(__wrapNumber(count++, "mainActivityId", getMainActivityId()));
		if(getInstanceActivityCreateTime() != null) sb.append(__wrapDate(count++, "instanceActivityCreateTime", getInstanceActivityCreateTime()));
		if(getInstanceActivityStartTime() != null) sb.append(__wrapDate(count++, "instanceActivityStartTime", getInstanceActivityStartTime()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getProcessComment() != null) sb.append(__wrapString(count++, "processComment", getProcessComment()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getActivityType() != null) sb.append(__wrapNumber(count++, "activityType", getActivityType()));
		if(getBackViewName() != null) sb.append(__wrapString(count++, "backViewName", getBackViewName()));
		if(getEmployee1() != null) sb.append(__wrapNumber(count++, "employee1", getEmployee1()));
		if(getEmployee2() != null) sb.append(__wrapNumber(count++, "employee2", getEmployee2()));
		if(getEmployeeStatus() != null) sb.append(__wrapNumber(count++, "employeeStatus", getEmployeeStatus()));
		if(getCompanyWeixin() != null) sb.append(__wrapString(count++, "companyWeixin", getCompanyWeixin()));
		if(getActivityName() != null) sb.append(__wrapString(count++, "activityName", getActivityName()));
		if(getTimeOutAction() != null) sb.append(__wrapNumber(count++, "timeOutAction", getTimeOutAction()));
		if(getMessage1() != null) sb.append(__wrapNumber(count++, "message1", getMessage1()));
		if(getMessage2() != null) sb.append(__wrapNumber(count++, "message2", getMessage2()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processTypeName")) != null) setProcessTypeName(__getString(val));
		if((val = values.get("processPooledTaskId")) != null) setProcessPooledTaskId(__getInt(val)); 
		if((val = values.get("typeFlag")) != null) setTypeFlag(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processActivityId")) != null) setProcessActivityId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("nodeType")) != null) setNodeType(__getInt(val)); 
		if((val = values.get("activityId")) != null) setActivityId(__getInt(val)); 
		if((val = values.get("nextActivityId")) != null) setNextActivityId(__getInt(val)); 
		if((val = values.get("mainActivityId")) != null) setMainActivityId(__getInt(val)); 
		if((val = values.get("instanceActivityCreateTime")) != null) setInstanceActivityCreateTime(__getDate(val)); 
		if((val = values.get("instanceActivityStartTime")) != null) setInstanceActivityStartTime(__getDate(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("processComment")) != null) setProcessComment(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("activityType")) != null) setActivityType(__getInt(val)); 
		if((val = values.get("backViewName")) != null) setBackViewName(__getString(val));
		if((val = values.get("employee1")) != null) setEmployee1(__getInt(val)); 
		if((val = values.get("employee2")) != null) setEmployee2(__getInt(val)); 
		if((val = values.get("employeeStatus")) != null) setEmployeeStatus(__getInt(val)); 
		if((val = values.get("companyWeixin")) != null) setCompanyWeixin(__getString(val));
		if((val = values.get("activityName")) != null) setActivityName(__getString(val));
		if((val = values.get("timeOutAction")) != null) setTimeOutAction(__getInt(val)); 
		if((val = values.get("message1")) != null) setMessage1(__getInt(val)); 
		if((val = values.get("message2")) != null) setMessage2(__getInt(val)); 
	}

	protected java.lang.String  __process_type_name ;
	protected java.lang.Integer  __process_pooled_task_id ;
	protected java.lang.Integer  __type_flag ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_activity_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __node_type ;
	protected java.lang.Integer  __activity_id ;
	protected java.lang.Integer  __next_activity_id ;
	protected java.lang.Integer  __main_activity_id ;
	protected java.util.Date  __instance_activity_create_time ;
	protected java.util.Date  __instance_activity_start_time ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __process_comment ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __activity_type ;
	protected java.lang.String  __back_view_name ;
	protected java.lang.Integer  __employee_1 ;
	protected java.lang.Integer  __employee_2 ;
	protected java.lang.Integer  __employee_status ;
	protected java.lang.String  __company_weixin ;
	protected java.lang.String  __activity_name ;
	protected java.lang.Integer  __time_out_action ;
	protected java.lang.Integer  __message_1 ;
	protected java.lang.Integer  __message_2 ;
}
