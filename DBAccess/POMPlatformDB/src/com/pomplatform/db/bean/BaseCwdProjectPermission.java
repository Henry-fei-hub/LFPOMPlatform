package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCwdProjectPermission extends GenericBase implements BaseFactory<BaseCwdProjectPermission>, Comparable<BaseCwdProjectPermission> 
{


	public static BaseCwdProjectPermission newInstance(){
		return new BaseCwdProjectPermission();
	}

	@Override
	public BaseCwdProjectPermission make(){
		BaseCwdProjectPermission b = new BaseCwdProjectPermission();
		return b;
	}

	public final static java.lang.String CS_CWD_PROJECT_PERMISSION_ID = "cwd_project_permission_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PERMISSION_TYPE = "permission_type" ;
	public final static java.lang.String CS_OPERATE_PERSON = "operate_person" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员,CDC项目查看权限，对应system_dictionary_238,操作人,创建时间,删除状态";

	public java.lang.Integer getCwdProjectPermissionId() {
		return this.__cwd_project_permission_id;
	}

	public void setCwdProjectPermissionId( java.lang.Integer value ) {
		this.__cwd_project_permission_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPermissionType() {
		return this.__permission_type;
	}

	public void setPermissionType( java.lang.Integer value ) {
		this.__permission_type = value;
	}

	public java.lang.Integer getOperatePerson() {
		return this.__operate_person;
	}

	public void setOperatePerson( java.lang.Integer value ) {
		this.__operate_person = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public void cloneCopy(BaseCwdProjectPermission __bean){
		__bean.setCwdProjectPermissionId(getCwdProjectPermissionId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPermissionType(getPermissionType());
		__bean.setOperatePerson(getOperatePerson());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdProjectPermissionId() == null ? "" : getCwdProjectPermissionId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getPermissionType() == null ? "" : getPermissionType());
		sb.append(",");
		sb.append(getOperatePerson() == null ? "" : getOperatePerson());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdProjectPermission o) {
		return __cwd_project_permission_id == null ? -1 : __cwd_project_permission_id.compareTo(o.getCwdProjectPermissionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_project_permission_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__permission_type);
		hash = 97 * hash + Objects.hashCode(this.__operate_person);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdProjectPermission o = (BaseCwdProjectPermission)obj;
		if(!Objects.equals(this.__cwd_project_permission_id, o.getCwdProjectPermissionId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__permission_type, o.getPermissionType())) return false;
		if(!Objects.equals(this.__operate_person, o.getOperatePerson())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdProjectPermissionId() != null) sb.append(__wrapNumber(count++, "cwdProjectPermissionId", getCwdProjectPermissionId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPermissionType() != null) sb.append(__wrapNumber(count++, "permissionType", getPermissionType()));
		if(getOperatePerson() != null) sb.append(__wrapNumber(count++, "operatePerson", getOperatePerson()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCwdProjectPermissionId() != null) res.put("cwdProjectPermissionId", getCwdProjectPermissionId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getPermissionType() != null) res.put("permissionType", getPermissionType());
		if(getOperatePerson() != null) res.put("operatePerson", getOperatePerson());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdProjectPermissionId")) != null) setCwdProjectPermissionId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("permissionType")) != null) setPermissionType(__getInt(val)); 
		if((val = values.get("operatePerson")) != null) setOperatePerson(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_project_permission_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __permission_type ;
	protected java.lang.Integer  __operate_person ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
}
