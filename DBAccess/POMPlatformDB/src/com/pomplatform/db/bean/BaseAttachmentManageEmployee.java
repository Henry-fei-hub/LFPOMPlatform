package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAttachmentManageEmployee extends GenericBase implements BaseFactory<BaseAttachmentManageEmployee>, Comparable<BaseAttachmentManageEmployee> 
{


	public static BaseAttachmentManageEmployee newInstance(){
		return new BaseAttachmentManageEmployee();
	}

	@Override
	public BaseAttachmentManageEmployee make(){
		BaseAttachmentManageEmployee b = new BaseAttachmentManageEmployee();
		return b;
	}

	public final static java.lang.String CS_ATTACHMENT_MANAGE_EMPLOYEE_ID = "attachment_manage_employee_id" ;
	public final static java.lang.String CS_ATTACHMENT_MANAGE_ID = "attachment_manage_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_TYPE = "employee_type" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,确认函主键,人员主键,员工类型 1负责总监,操作人,创建时间";

	public java.lang.Integer getAttachmentManageEmployeeId() {
		return this.__attachment_manage_employee_id;
	}

	public void setAttachmentManageEmployeeId( java.lang.Integer value ) {
		this.__attachment_manage_employee_id = value;
	}

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getEmployeeType() {
		return this.__employee_type;
	}

	public void setEmployeeType( java.lang.Integer value ) {
		this.__employee_type = value;
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

	public void cloneCopy(BaseAttachmentManageEmployee __bean){
		__bean.setAttachmentManageEmployeeId(getAttachmentManageEmployeeId());
		__bean.setAttachmentManageId(getAttachmentManageId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeType(getEmployeeType());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAttachmentManageEmployeeId() == null ? "" : getAttachmentManageEmployeeId());
		sb.append(",");
		sb.append(getAttachmentManageId() == null ? "" : getAttachmentManageId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeType() == null ? "" : getEmployeeType());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttachmentManageEmployee o) {
		return __attachment_manage_employee_id == null ? -1 : __attachment_manage_employee_id.compareTo(o.getAttachmentManageEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__attachment_manage_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_type);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttachmentManageEmployee o = (BaseAttachmentManageEmployee)obj;
		if(!Objects.equals(this.__attachment_manage_employee_id, o.getAttachmentManageEmployeeId())) return false;
		if(!Objects.equals(this.__attachment_manage_id, o.getAttachmentManageId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_type, o.getEmployeeType())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAttachmentManageEmployeeId() != null) sb.append(__wrapNumber(count++, "attachmentManageEmployeeId", getAttachmentManageEmployeeId()));
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(count++, "attachmentManageId", getAttachmentManageId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeType() != null) sb.append(__wrapNumber(count++, "employeeType", getEmployeeType()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("attachmentManageEmployeeId")) != null) setAttachmentManageEmployeeId(__getInt(val)); 
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeType")) != null) setEmployeeType(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __attachment_manage_employee_id ;
	protected java.lang.Integer  __attachment_manage_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __employee_type ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
}
