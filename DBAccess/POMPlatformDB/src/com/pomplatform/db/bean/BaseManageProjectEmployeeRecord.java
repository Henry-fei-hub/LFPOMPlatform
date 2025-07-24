package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseManageProjectEmployeeRecord extends GenericBase implements BaseFactory<BaseManageProjectEmployeeRecord>, Comparable<BaseManageProjectEmployeeRecord> 
{


	public static BaseManageProjectEmployeeRecord newInstance(){
		return new BaseManageProjectEmployeeRecord();
	}

	@Override
	public BaseManageProjectEmployeeRecord make(){
		BaseManageProjectEmployeeRecord b = new BaseManageProjectEmployeeRecord();
		return b;
	}

	public final static java.lang.String CS_MANAGE_PROJECT_EMPLOYEE_RECORD_ID = "manage_project_employee_record_id" ;
	public final static java.lang.String CS_MANAGE_PROJECT_ID = "manage_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ASSIGN_INTEGRAL = "assign_integral" ;
	public final static java.lang.String CS_ASSIGNED_INTEGRAL = "assigned_integral" ;
	public final static java.lang.String CS_ASSIGN_DATE = "assign_date" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IS_RETURN = "is_return" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,管理项目,发放成员,发放积分,已发放积分,发放日期,操作人,备注,积分是否回收的标识，true回收； false不回收";

	public java.lang.Integer getManageProjectEmployeeRecordId() {
		return this.__manage_project_employee_record_id;
	}

	public void setManageProjectEmployeeRecordId( java.lang.Integer value ) {
		this.__manage_project_employee_record_id = value;
	}

	public java.lang.Integer getManageProjectId() {
		return this.__manage_project_id;
	}

	public void setManageProjectId( java.lang.Integer value ) {
		this.__manage_project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getAssignIntegral() {
		return this.__assign_integral;
	}

	public void setAssignIntegral( java.math.BigDecimal value ) {
		this.__assign_integral = value;
	}

	public java.math.BigDecimal getAssignedIntegral() {
		return this.__assigned_integral;
	}

	public void setAssignedIntegral( java.math.BigDecimal value ) {
		this.__assigned_integral = value;
	}

	public java.util.Date getAssignDate() {
		return this.__assign_date;
	}

	public void setAssignDate( java.util.Date value ) {
		this.__assign_date = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getIsReturn() {
		return this.__is_return;
	}

	public void setIsReturn( java.lang.Boolean value ) {
		this.__is_return = value;
	}

	public void cloneCopy(BaseManageProjectEmployeeRecord __bean){
		__bean.setManageProjectEmployeeRecordId(getManageProjectEmployeeRecordId());
		__bean.setManageProjectId(getManageProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAssignIntegral(getAssignIntegral());
		__bean.setAssignedIntegral(getAssignedIntegral());
		__bean.setAssignDate(getAssignDate());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setRemark(getRemark());
		__bean.setIsReturn(getIsReturn());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getManageProjectEmployeeRecordId() == null ? "" : getManageProjectEmployeeRecordId());
		sb.append(",");
		sb.append(getManageProjectId() == null ? "" : getManageProjectId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAssignIntegral() == null ? "" : getAssignIntegral());
		sb.append(",");
		sb.append(getAssignedIntegral() == null ? "" : getAssignedIntegral());
		sb.append(",");
		sb.append(getAssignDate() == null ? "" : sdf.format(getAssignDate()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIsReturn() == null ? "" : getIsReturn());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseManageProjectEmployeeRecord o) {
		return __manage_project_employee_record_id == null ? -1 : __manage_project_employee_record_id.compareTo(o.getManageProjectEmployeeRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__manage_project_employee_record_id);
		hash = 97 * hash + Objects.hashCode(this.__manage_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__assign_integral);
		hash = 97 * hash + Objects.hashCode(this.__assigned_integral);
		hash = 97 * hash + Objects.hashCode(this.__assign_date);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__is_return);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseManageProjectEmployeeRecord o = (BaseManageProjectEmployeeRecord)obj;
		if(!Objects.equals(this.__manage_project_employee_record_id, o.getManageProjectEmployeeRecordId())) return false;
		if(!Objects.equals(this.__manage_project_id, o.getManageProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__assign_integral, o.getAssignIntegral())) return false;
		if(!Objects.equals(this.__assigned_integral, o.getAssignedIntegral())) return false;
		if(!Objects.equals(this.__assign_date, o.getAssignDate())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__is_return, o.getIsReturn())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getManageProjectEmployeeRecordId() != null) sb.append(__wrapNumber(count++, "manageProjectEmployeeRecordId", getManageProjectEmployeeRecordId()));
		if(getManageProjectId() != null) sb.append(__wrapNumber(count++, "manageProjectId", getManageProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getAssignIntegral() != null) sb.append(__wrapDecimal(count++, "assignIntegral", getAssignIntegral()));
		if(getAssignedIntegral() != null) sb.append(__wrapDecimal(count++, "assignedIntegral", getAssignedIntegral()));
		if(getAssignDate() != null) sb.append(__wrapDate(count++, "assignDate", getAssignDate()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIsReturn() != null) sb.append(__wrapBoolean(count++, "isReturn", getIsReturn()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("manageProjectEmployeeRecordId")) != null) setManageProjectEmployeeRecordId(__getInt(val)); 
		if((val = values.get("manageProjectId")) != null) setManageProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("assignIntegral")) != null) setAssignIntegral(__getDecimal(val));  
		if((val = values.get("assignedIntegral")) != null) setAssignedIntegral(__getDecimal(val));  
		if((val = values.get("assignDate")) != null) setAssignDate(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("isReturn")) != null) setIsReturn(__getBoolean(val));
	}

	protected java.lang.Integer  __manage_project_employee_record_id ;
	protected java.lang.Integer  __manage_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __assign_integral ;
	protected java.math.BigDecimal  __assigned_integral ;
	protected java.util.Date  __assign_date ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __is_return ;
}
