package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdTaskManage extends GenericBase implements BaseFactory<BaseCwdTaskManage>, Comparable<BaseCwdTaskManage> 
{


	public static BaseCwdTaskManage newInstance(){
		return new BaseCwdTaskManage();
	}

	@Override
	public BaseCwdTaskManage make(){
		BaseCwdTaskManage b = new BaseCwdTaskManage();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_MANAGE_ID = "cwd_task_manage_id" ;
	public final static java.lang.String CS_TASK_NAME = "task_name" ;
	public final static java.lang.String CS_TASK_STATUS = "task_status" ;
	public final static java.lang.String CS_TASK_TYPE = "task_type" ;
	public final static java.lang.String CS_TASK_LEVEL = "task_level" ;
	public final static java.lang.String CS_TASK_CONTENT = "task_content" ;
	public final static java.lang.String CS_TASK_DEMAND = "task_demand" ;
	public final static java.lang.String CS_ASSIGNMENT_TYPE = "assignment_type" ;
	public final static java.lang.String CS_ASSIGNMENT_LINK_ID = "assignment_link_id" ;
	public final static java.lang.String CS_START_TIME = "start_time" ;
	public final static java.lang.String CS_END_TIME = "end_time" ;
	public final static java.lang.String CS_ACTUAL_START_TIME = "actual_start_time" ;
	public final static java.lang.String CS_ACTUAL_END_TIME = "actual_end_time" ;
	public final static java.lang.String CS_DEGREE_OF_COMPLETION = "degree_of_completion" ;
	public final static java.lang.String CS_REVIEW_THE_WAY = "review_the_way" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_ORDER_NUM = "order_num" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_TASK_LEADER = "task_leader" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_COMPANY_NO = "company_no" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PLAN_STATUS = "plan_status" ;
	public final static java.lang.String CS_COMPLETION_STATUS = "completion_status" ;
	public final static java.lang.String CS_TASK_INTEGRAL = "task_integral" ;
	public final static java.lang.String CS_TASK_INTEGRAL_PERCENT = "task_integral_percent" ;
	public final static java.lang.String CS_SPECIALTY_ID = "specialty_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,任务名称,任务状态 0新建 1进行中 2完成 3 评审中,任务类型 1业态 2专业 3阶段 4任务,任务级别 1普通 2紧急 3非常紧急,任务内容,任务要求,指派类型 1个人 2项目组(人员组) 3部门,根据分配类型关联employees或cwd_project_groups或departments表主键,开始时间,结束时间,实际开始时间,实际结束时间,完成度,审查方式 1线下核对 2流程审批,大项目,合同主键,父级任务id,排序值 越大排越后,审批流程主键,操作人,创建时间,任务负责人,归属公司id,归属公司编号,订单,策划状态 1 未策划 2 已策划,完工状态0 未动工 1 刚开始做 2做了一半了 3 做的差不多了 4 做完了,任务积分,任务积分占比,专业";

	public java.lang.Integer getCwdTaskManageId() {
		return this.__cwd_task_manage_id;
	}

	public void setCwdTaskManageId( java.lang.Integer value ) {
		this.__cwd_task_manage_id = value;
	}

	public java.lang.String getTaskName() {
		return this.__task_name;
	}

	public void setTaskName( java.lang.String value ) {
		this.__task_name = value;
	}

	public java.lang.Integer getTaskStatus() {
		return this.__task_status;
	}

	public void setTaskStatus( java.lang.Integer value ) {
		this.__task_status = value;
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

	public java.lang.Integer getAssignmentType() {
		return this.__assignment_type;
	}

	public void setAssignmentType( java.lang.Integer value ) {
		this.__assignment_type = value;
	}

	public java.lang.Integer getAssignmentLinkId() {
		return this.__assignment_link_id;
	}

	public void setAssignmentLinkId( java.lang.Integer value ) {
		this.__assignment_link_id = value;
	}

	public java.util.Date getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( java.util.Date value ) {
		this.__start_time = value;
	}

	public java.util.Date getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( java.util.Date value ) {
		this.__end_time = value;
	}

	public java.util.Date getActualStartTime() {
		return this.__actual_start_time;
	}

	public void setActualStartTime( java.util.Date value ) {
		this.__actual_start_time = value;
	}

	public java.util.Date getActualEndTime() {
		return this.__actual_end_time;
	}

	public void setActualEndTime( java.util.Date value ) {
		this.__actual_end_time = value;
	}

	public java.math.BigDecimal getDegreeOfCompletion() {
		return this.__degree_of_completion;
	}

	public void setDegreeOfCompletion( java.math.BigDecimal value ) {
		this.__degree_of_completion = value;
	}

	public java.lang.Integer getReviewTheWay() {
		return this.__review_the_way;
	}

	public void setReviewTheWay( java.lang.Integer value ) {
		this.__review_the_way = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
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

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getTaskLeader() {
		return this.__task_leader;
	}

	public void setTaskLeader( java.lang.Integer value ) {
		this.__task_leader = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getCompanyNo() {
		return this.__company_no;
	}

	public void setCompanyNo( java.lang.String value ) {
		this.__company_no = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlanStatus() {
		return this.__plan_status;
	}

	public void setPlanStatus( java.lang.Integer value ) {
		this.__plan_status = value;
	}

	public java.lang.Integer getCompletionStatus() {
		return this.__completion_status;
	}

	public void setCompletionStatus( java.lang.Integer value ) {
		this.__completion_status = value;
	}

	public java.math.BigDecimal getTaskIntegral() {
		return this.__task_integral;
	}

	public void setTaskIntegral( java.math.BigDecimal value ) {
		this.__task_integral = value;
	}

	public java.math.BigDecimal getTaskIntegralPercent() {
		return this.__task_integral_percent;
	}

	public void setTaskIntegralPercent( java.math.BigDecimal value ) {
		this.__task_integral_percent = value;
	}

	public java.lang.Integer getSpecialtyId() {
		return this.__specialty_id;
	}

	public void setSpecialtyId( java.lang.Integer value ) {
		this.__specialty_id = value;
	}

	public void cloneCopy(BaseCwdTaskManage __bean){
		__bean.setCwdTaskManageId(getCwdTaskManageId());
		__bean.setTaskName(getTaskName());
		__bean.setTaskStatus(getTaskStatus());
		__bean.setTaskType(getTaskType());
		__bean.setTaskLevel(getTaskLevel());
		__bean.setTaskContent(getTaskContent());
		__bean.setTaskDemand(getTaskDemand());
		__bean.setAssignmentType(getAssignmentType());
		__bean.setAssignmentLinkId(getAssignmentLinkId());
		__bean.setStartTime(getStartTime());
		__bean.setEndTime(getEndTime());
		__bean.setActualStartTime(getActualStartTime());
		__bean.setActualEndTime(getActualEndTime());
		__bean.setDegreeOfCompletion(getDegreeOfCompletion());
		__bean.setReviewTheWay(getReviewTheWay());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setContractId(getContractId());
		__bean.setParentId(getParentId());
		__bean.setOrderNum(getOrderNum());
		__bean.setProcessId(getProcessId());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setTaskLeader(getTaskLeader());
		__bean.setCompanyId(getCompanyId());
		__bean.setCompanyNo(getCompanyNo());
		__bean.setProjectId(getProjectId());
		__bean.setPlanStatus(getPlanStatus());
		__bean.setCompletionStatus(getCompletionStatus());
		__bean.setTaskIntegral(getTaskIntegral());
		__bean.setTaskIntegralPercent(getTaskIntegralPercent());
		__bean.setSpecialtyId(getSpecialtyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskManageId() == null ? "" : getCwdTaskManageId());
		sb.append(",");
		sb.append(getTaskName() == null ? "" : getTaskName());
		sb.append(",");
		sb.append(getTaskStatus() == null ? "" : getTaskStatus());
		sb.append(",");
		sb.append(getTaskType() == null ? "" : getTaskType());
		sb.append(",");
		sb.append(getTaskLevel() == null ? "" : getTaskLevel());
		sb.append(",");
		sb.append(getTaskContent() == null ? "" : getTaskContent());
		sb.append(",");
		sb.append(getTaskDemand() == null ? "" : getTaskDemand());
		sb.append(",");
		sb.append(getAssignmentType() == null ? "" : getAssignmentType());
		sb.append(",");
		sb.append(getAssignmentLinkId() == null ? "" : getAssignmentLinkId());
		sb.append(",");
		sb.append(getStartTime() == null ? "" : sdf.format(getStartTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		sb.append(getActualStartTime() == null ? "" : sdf.format(getActualStartTime()));
		sb.append(",");
		sb.append(getActualEndTime() == null ? "" : sdf.format(getActualEndTime()));
		sb.append(",");
		sb.append(getDegreeOfCompletion() == null ? "" : getDegreeOfCompletion());
		sb.append(",");
		sb.append(getReviewTheWay() == null ? "" : getReviewTheWay());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getOrderNum() == null ? "" : getOrderNum());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getTaskLeader() == null ? "" : getTaskLeader());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getCompanyNo() == null ? "" : getCompanyNo());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getPlanStatus() == null ? "" : getPlanStatus());
		sb.append(",");
		sb.append(getCompletionStatus() == null ? "" : getCompletionStatus());
		sb.append(",");
		sb.append(getTaskIntegral() == null ? "" : getTaskIntegral());
		sb.append(",");
		sb.append(getTaskIntegralPercent() == null ? "" : getTaskIntegralPercent());
		sb.append(",");
		sb.append(getSpecialtyId() == null ? "" : getSpecialtyId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdTaskManage o) {
		return __cwd_task_manage_id == null ? -1 : __cwd_task_manage_id.compareTo(o.getCwdTaskManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__task_name);
		hash = 97 * hash + Objects.hashCode(this.__task_status);
		hash = 97 * hash + Objects.hashCode(this.__task_type);
		hash = 97 * hash + Objects.hashCode(this.__task_level);
		hash = 97 * hash + Objects.hashCode(this.__task_content);
		hash = 97 * hash + Objects.hashCode(this.__task_demand);
		hash = 97 * hash + Objects.hashCode(this.__assignment_type);
		hash = 97 * hash + Objects.hashCode(this.__assignment_link_id);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__actual_start_time);
		hash = 97 * hash + Objects.hashCode(this.__actual_end_time);
		hash = 97 * hash + Objects.hashCode(this.__degree_of_completion);
		hash = 97 * hash + Objects.hashCode(this.__review_the_way);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__order_num);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__task_leader);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__company_no);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__plan_status);
		hash = 97 * hash + Objects.hashCode(this.__completion_status);
		hash = 97 * hash + Objects.hashCode(this.__task_integral);
		hash = 97 * hash + Objects.hashCode(this.__task_integral_percent);
		hash = 97 * hash + Objects.hashCode(this.__specialty_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdTaskManage o = (BaseCwdTaskManage)obj;
		if(!Objects.equals(this.__cwd_task_manage_id, o.getCwdTaskManageId())) return false;
		if(!Objects.equals(this.__task_name, o.getTaskName())) return false;
		if(!Objects.equals(this.__task_status, o.getTaskStatus())) return false;
		if(!Objects.equals(this.__task_type, o.getTaskType())) return false;
		if(!Objects.equals(this.__task_level, o.getTaskLevel())) return false;
		if(!Objects.equals(this.__task_content, o.getTaskContent())) return false;
		if(!Objects.equals(this.__task_demand, o.getTaskDemand())) return false;
		if(!Objects.equals(this.__assignment_type, o.getAssignmentType())) return false;
		if(!Objects.equals(this.__assignment_link_id, o.getAssignmentLinkId())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__actual_start_time, o.getActualStartTime())) return false;
		if(!Objects.equals(this.__actual_end_time, o.getActualEndTime())) return false;
		if(!Objects.equals(this.__degree_of_completion, o.getDegreeOfCompletion())) return false;
		if(!Objects.equals(this.__review_the_way, o.getReviewTheWay())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__order_num, o.getOrderNum())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__task_leader, o.getTaskLeader())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__company_no, o.getCompanyNo())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__plan_status, o.getPlanStatus())) return false;
		if(!Objects.equals(this.__completion_status, o.getCompletionStatus())) return false;
		if(!Objects.equals(this.__task_integral, o.getTaskIntegral())) return false;
		if(!Objects.equals(this.__task_integral_percent, o.getTaskIntegralPercent())) return false;
		if(!Objects.equals(this.__specialty_id, o.getSpecialtyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskManageId() != null) sb.append(__wrapNumber(count++, "cwdTaskManageId", getCwdTaskManageId()));
		if(getTaskName() != null) sb.append(__wrapString(count++, "taskName", getTaskName()));
		if(getTaskStatus() != null) sb.append(__wrapNumber(count++, "taskStatus", getTaskStatus()));
		if(getTaskType() != null) sb.append(__wrapNumber(count++, "taskType", getTaskType()));
		if(getTaskLevel() != null) sb.append(__wrapNumber(count++, "taskLevel", getTaskLevel()));
		if(getTaskContent() != null) sb.append(__wrapString(count++, "taskContent", getTaskContent()));
		if(getTaskDemand() != null) sb.append(__wrapString(count++, "taskDemand", getTaskDemand()));
		if(getAssignmentType() != null) sb.append(__wrapNumber(count++, "assignmentType", getAssignmentType()));
		if(getAssignmentLinkId() != null) sb.append(__wrapNumber(count++, "assignmentLinkId", getAssignmentLinkId()));
		if(getStartTime() != null) sb.append(__wrapDate(count++, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(count++, "endTime", getEndTime()));
		if(getActualStartTime() != null) sb.append(__wrapDate(count++, "actualStartTime", getActualStartTime()));
		if(getActualEndTime() != null) sb.append(__wrapDate(count++, "actualEndTime", getActualEndTime()));
		if(getDegreeOfCompletion() != null) sb.append(__wrapDecimal(count++, "degreeOfCompletion", getDegreeOfCompletion()));
		if(getReviewTheWay() != null) sb.append(__wrapNumber(count++, "reviewTheWay", getReviewTheWay()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getOrderNum() != null) sb.append(__wrapNumber(count++, "orderNum", getOrderNum()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getTaskLeader() != null) sb.append(__wrapNumber(count++, "taskLeader", getTaskLeader()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCompanyNo() != null) sb.append(__wrapString(count++, "companyNo", getCompanyNo()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPlanStatus() != null) sb.append(__wrapNumber(count++, "planStatus", getPlanStatus()));
		if(getCompletionStatus() != null) sb.append(__wrapNumber(count++, "completionStatus", getCompletionStatus()));
		if(getTaskIntegral() != null) sb.append(__wrapDecimal(count++, "taskIntegral", getTaskIntegral()));
		if(getTaskIntegralPercent() != null) sb.append(__wrapDecimal(count++, "taskIntegralPercent", getTaskIntegralPercent()));
		if(getSpecialtyId() != null) sb.append(__wrapNumber(count++, "specialtyId", getSpecialtyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskManageId")) != null) setCwdTaskManageId(__getInt(val)); 
		if((val = values.get("taskName")) != null) setTaskName(__getString(val));
		if((val = values.get("taskStatus")) != null) setTaskStatus(__getInt(val)); 
		if((val = values.get("taskType")) != null) setTaskType(__getInt(val)); 
		if((val = values.get("taskLevel")) != null) setTaskLevel(__getInt(val)); 
		if((val = values.get("taskContent")) != null) setTaskContent(__getString(val));
		if((val = values.get("taskDemand")) != null) setTaskDemand(__getString(val));
		if((val = values.get("assignmentType")) != null) setAssignmentType(__getInt(val)); 
		if((val = values.get("assignmentLinkId")) != null) setAssignmentLinkId(__getInt(val)); 
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
		if((val = values.get("actualStartTime")) != null) setActualStartTime(__getDate(val)); 
		if((val = values.get("actualEndTime")) != null) setActualEndTime(__getDate(val)); 
		if((val = values.get("degreeOfCompletion")) != null) setDegreeOfCompletion(__getDecimal(val));  
		if((val = values.get("reviewTheWay")) != null) setReviewTheWay(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("orderNum")) != null) setOrderNum(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("taskLeader")) != null) setTaskLeader(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("planStatus")) != null) setPlanStatus(__getInt(val)); 
		if((val = values.get("completionStatus")) != null) setCompletionStatus(__getInt(val)); 
		if((val = values.get("taskIntegral")) != null) setTaskIntegral(__getDecimal(val));  
		if((val = values.get("taskIntegralPercent")) != null) setTaskIntegralPercent(__getDecimal(val));  
		if((val = values.get("specialtyId")) != null) setSpecialtyId(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_task_manage_id ;
	protected java.lang.String  __task_name ;
	protected java.lang.Integer  __task_status ;
	protected java.lang.Integer  __task_type ;
	protected java.lang.Integer  __task_level ;
	protected java.lang.String  __task_content ;
	protected java.lang.String  __task_demand ;
	protected java.lang.Integer  __assignment_type ;
	protected java.lang.Integer  __assignment_link_id ;
	protected java.util.Date  __start_time ;
	protected java.util.Date  __end_time ;
	protected java.util.Date  __actual_start_time ;
	protected java.util.Date  __actual_end_time ;
	protected java.math.BigDecimal  __degree_of_completion ;
	protected java.lang.Integer  __review_the_way ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __order_num ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __task_leader ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __company_no ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __plan_status ;
	protected java.lang.Integer  __completion_status ;
	protected java.math.BigDecimal  __task_integral ;
	protected java.math.BigDecimal  __task_integral_percent ;
	protected java.lang.Integer  __specialty_id ;
}
