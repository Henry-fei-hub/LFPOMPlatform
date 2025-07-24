package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAttendanceRuleDepartment extends GenericBase implements BaseFactory<BaseAttendanceRuleDepartment>, Comparable<BaseAttendanceRuleDepartment> 
{


	public static BaseAttendanceRuleDepartment newInstance(){
		return new BaseAttendanceRuleDepartment();
	}

	@Override
	public BaseAttendanceRuleDepartment make(){
		BaseAttendanceRuleDepartment b = new BaseAttendanceRuleDepartment();
		return b;
	}

	public final static java.lang.String CS_ATTENDANCE_RULE_DEPARTMENT_ID = "attendance_rule_department_id" ;
	public final static java.lang.String CS_ATTENDANCE_RULE_ID = "attendance_rule_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,考勤规则主键id,部门";

	public java.lang.Integer getAttendanceRuleDepartmentId() {
		return this.__attendance_rule_department_id;
	}

	public void setAttendanceRuleDepartmentId( java.lang.Integer value ) {
		this.__attendance_rule_department_id = value;
	}

	public java.lang.Integer getAttendanceRuleId() {
		return this.__attendance_rule_id;
	}

	public void setAttendanceRuleId( java.lang.Integer value ) {
		this.__attendance_rule_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public void cloneCopy(BaseAttendanceRuleDepartment __bean){
		__bean.setAttendanceRuleDepartmentId(getAttendanceRuleDepartmentId());
		__bean.setAttendanceRuleId(getAttendanceRuleId());
		__bean.setDepartmentId(getDepartmentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAttendanceRuleDepartmentId() == null ? "" : getAttendanceRuleDepartmentId());
		sb.append(",");
		sb.append(getAttendanceRuleId() == null ? "" : getAttendanceRuleId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttendanceRuleDepartment o) {
		return __attendance_rule_department_id == null ? -1 : __attendance_rule_department_id.compareTo(o.getAttendanceRuleDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__attendance_rule_department_id);
		hash = 97 * hash + Objects.hashCode(this.__attendance_rule_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttendanceRuleDepartment o = (BaseAttendanceRuleDepartment)obj;
		if(!Objects.equals(this.__attendance_rule_department_id, o.getAttendanceRuleDepartmentId())) return false;
		if(!Objects.equals(this.__attendance_rule_id, o.getAttendanceRuleId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAttendanceRuleDepartmentId() != null) sb.append(__wrapNumber(count++, "attendanceRuleDepartmentId", getAttendanceRuleDepartmentId()));
		if(getAttendanceRuleId() != null) sb.append(__wrapNumber(count++, "attendanceRuleId", getAttendanceRuleId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getAttendanceRuleDepartmentId() != null) res.put("attendanceRuleDepartmentId", getAttendanceRuleDepartmentId());
		if(getAttendanceRuleId() != null) res.put("attendanceRuleId", getAttendanceRuleId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("attendanceRuleDepartmentId")) != null) setAttendanceRuleDepartmentId(__getInt(val)); 
		if((val = values.get("attendanceRuleId")) != null) setAttendanceRuleId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	protected java.lang.Integer  __attendance_rule_department_id ;
	protected java.lang.Integer  __attendance_rule_id ;
	protected java.lang.Integer  __department_id ;
}
