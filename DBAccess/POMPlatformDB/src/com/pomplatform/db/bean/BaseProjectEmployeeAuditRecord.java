package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectEmployeeAuditRecord extends GenericBase implements BaseFactory<BaseProjectEmployeeAuditRecord>, Comparable<BaseProjectEmployeeAuditRecord> 
{


	public static BaseProjectEmployeeAuditRecord newInstance(){
		return new BaseProjectEmployeeAuditRecord();
	}

	@Override
	public BaseProjectEmployeeAuditRecord make(){
		BaseProjectEmployeeAuditRecord b = new BaseProjectEmployeeAuditRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_EMPLOYEE_AUDIT_RECORDS_ID = "project_employee_audit_records_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CHECK_EMPLOYEE_ID = "check_employee_id" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_OLD_PLAN_INTEGRAL = "old_plan_integral" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目id,阶段id,审核人id,被审核人id,预分配积分,上一次预分配积分,状态,操作人,操作时间,备注,0删除   1使用中";

	public java.lang.Integer getProjectEmployeeAuditRecordsId() {
		return this.__project_employee_audit_records_id;
	}

	public void setProjectEmployeeAuditRecordsId( java.lang.Integer value ) {
		this.__project_employee_audit_records_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getCheckEmployeeId() {
		return this.__check_employee_id;
	}

	public void setCheckEmployeeId( java.lang.Integer value ) {
		this.__check_employee_id = value;
	}

	public java.math.BigDecimal getPlanIntegral() {
		return this.__plan_integral;
	}

	public void setPlanIntegral( java.math.BigDecimal value ) {
		this.__plan_integral = value;
	}

	public java.math.BigDecimal getOldPlanIntegral() {
		return this.__old_plan_integral;
	}

	public void setOldPlanIntegral( java.math.BigDecimal value ) {
		this.__old_plan_integral = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public void cloneCopy(BaseProjectEmployeeAuditRecord __bean){
		__bean.setProjectEmployeeAuditRecordsId(getProjectEmployeeAuditRecordsId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCheckEmployeeId(getCheckEmployeeId());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setOldPlanIntegral(getOldPlanIntegral());
		__bean.setStatus(getStatus());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setDeleteFlag(getDeleteFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectEmployeeAuditRecordsId() == null ? "" : getProjectEmployeeAuditRecordsId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCheckEmployeeId() == null ? "" : getCheckEmployeeId());
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getOldPlanIntegral() == null ? "" : getOldPlanIntegral());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectEmployeeAuditRecord o) {
		return __project_employee_audit_records_id == null ? -1 : __project_employee_audit_records_id.compareTo(o.getProjectEmployeeAuditRecordsId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_employee_audit_records_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__check_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__old_plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectEmployeeAuditRecord o = (BaseProjectEmployeeAuditRecord)obj;
		if(!Objects.equals(this.__project_employee_audit_records_id, o.getProjectEmployeeAuditRecordsId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__check_employee_id, o.getCheckEmployeeId())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__old_plan_integral, o.getOldPlanIntegral())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectEmployeeAuditRecordsId() != null) sb.append(__wrapNumber(count++, "projectEmployeeAuditRecordsId", getProjectEmployeeAuditRecordsId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCheckEmployeeId() != null) sb.append(__wrapNumber(count++, "checkEmployeeId", getCheckEmployeeId()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getOldPlanIntegral() != null) sb.append(__wrapDecimal(count++, "oldPlanIntegral", getOldPlanIntegral()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectEmployeeAuditRecordsId() != null) res.put("projectEmployeeAuditRecordsId", getProjectEmployeeAuditRecordsId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getStageId() != null) res.put("stageId", getStageId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getCheckEmployeeId() != null) res.put("checkEmployeeId", getCheckEmployeeId());
		if(getPlanIntegral() != null) res.put("planIntegral", getPlanIntegral());
		if(getOldPlanIntegral() != null) res.put("oldPlanIntegral", getOldPlanIntegral());
		if(getStatus() != null) res.put("status", getStatus());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectEmployeeAuditRecordsId")) != null) setProjectEmployeeAuditRecordsId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("checkEmployeeId")) != null) setCheckEmployeeId(__getInt(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("oldPlanIntegral")) != null) setOldPlanIntegral(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __project_employee_audit_records_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __check_employee_id ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __old_plan_integral ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __delete_flag ;
}
