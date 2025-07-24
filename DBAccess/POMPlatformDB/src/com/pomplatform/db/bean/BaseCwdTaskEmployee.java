package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdTaskEmployee extends GenericBase implements BaseFactory<BaseCwdTaskEmployee>, Comparable<BaseCwdTaskEmployee> 
{


	public static BaseCwdTaskEmployee newInstance(){
		return new BaseCwdTaskEmployee();
	}

	@Override
	public BaseCwdTaskEmployee make(){
		BaseCwdTaskEmployee b = new BaseCwdTaskEmployee();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_EMPLOYEE_ID = "cwd_task_employee_id" ;
	public final static java.lang.String CS_CWD_TASK_MANAGE_ID = "cwd_task_manage_id" ;
	public final static java.lang.String CS_TASK_ROLE = "task_role" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,任务主键,任务角色 1负责人 2小组成员,参与人部门,参与人,备注,操作人,创建时间,项目主键";

	public java.lang.Integer getCwdTaskEmployeeId() {
		return this.__cwd_task_employee_id;
	}

	public void setCwdTaskEmployeeId( java.lang.Integer value ) {
		this.__cwd_task_employee_id = value;
	}

	public java.lang.Integer getCwdTaskManageId() {
		return this.__cwd_task_manage_id;
	}

	public void setCwdTaskManageId( java.lang.Integer value ) {
		this.__cwd_task_manage_id = value;
	}

	public java.lang.Integer getTaskRole() {
		return this.__task_role;
	}

	public void setTaskRole( java.lang.Integer value ) {
		this.__task_role = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
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

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public void cloneCopy(BaseCwdTaskEmployee __bean){
		__bean.setCwdTaskEmployeeId(getCwdTaskEmployeeId());
		__bean.setCwdTaskManageId(getCwdTaskManageId());
		__bean.setTaskRole(getTaskRole());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRemark(getRemark());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setMainProjectId(getMainProjectId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskEmployeeId() == null ? "" : getCwdTaskEmployeeId());
		sb.append(",");
		sb.append(getCwdTaskManageId() == null ? "" : getCwdTaskManageId());
		sb.append(",");
		sb.append(getTaskRole() == null ? "" : getTaskRole());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdTaskEmployee o) {
		return __cwd_task_employee_id == null ? -1 : __cwd_task_employee_id.compareTo(o.getCwdTaskEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__task_role);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdTaskEmployee o = (BaseCwdTaskEmployee)obj;
		if(!Objects.equals(this.__cwd_task_employee_id, o.getCwdTaskEmployeeId())) return false;
		if(!Objects.equals(this.__cwd_task_manage_id, o.getCwdTaskManageId())) return false;
		if(!Objects.equals(this.__task_role, o.getTaskRole())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskEmployeeId() != null) sb.append(__wrapNumber(count++, "cwdTaskEmployeeId", getCwdTaskEmployeeId()));
		if(getCwdTaskManageId() != null) sb.append(__wrapNumber(count++, "cwdTaskManageId", getCwdTaskManageId()));
		if(getTaskRole() != null) sb.append(__wrapNumber(count++, "taskRole", getTaskRole()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskEmployeeId")) != null) setCwdTaskEmployeeId(__getInt(val)); 
		if((val = values.get("cwdTaskManageId")) != null) setCwdTaskManageId(__getInt(val)); 
		if((val = values.get("taskRole")) != null) setTaskRole(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_task_employee_id ;
	protected java.lang.Integer  __cwd_task_manage_id ;
	protected java.lang.Integer  __task_role ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __main_project_id ;
}
