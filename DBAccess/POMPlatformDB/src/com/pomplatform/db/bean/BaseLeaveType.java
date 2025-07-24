package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseLeaveType extends GenericBase implements BaseFactory<BaseLeaveType>, Comparable<BaseLeaveType> 
{


	public static BaseLeaveType newInstance(){
		return new BaseLeaveType();
	}

	@Override
	public BaseLeaveType make(){
		BaseLeaveType b = new BaseLeaveType();
		return b;
	}

	public final static java.lang.String CS_LEAVE_TYPE_ID = "leave_type_id" ;
	public final static java.lang.String CS_LEAVE_TYPE_NAME = "leave_type_name" ;
	public final static java.lang.String CS_GENDER = "gender" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;

	public final static java.lang.String ALL_CAPTIONS = "请假类型,请假类型名称,适用性别（0男女通用； 1男； 2女；）,父级编码,是否启用";

	public java.lang.Integer getLeaveTypeId() {
		return this.__leave_type_id;
	}

	public void setLeaveTypeId( java.lang.Integer value ) {
		this.__leave_type_id = value;
	}

	public java.lang.String getLeaveTypeName() {
		return this.__leave_type_name;
	}

	public void setLeaveTypeName( java.lang.String value ) {
		this.__leave_type_name = value;
	}

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public void cloneCopy(BaseLeaveType __bean){
		__bean.setLeaveTypeId(getLeaveTypeId());
		__bean.setLeaveTypeName(getLeaveTypeName());
		__bean.setGender(getGender());
		__bean.setParentId(getParentId());
		__bean.setIsEnable(getIsEnable());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLeaveTypeId() == null ? "" : getLeaveTypeId());
		sb.append(",");
		sb.append(getLeaveTypeName() == null ? "" : getLeaveTypeName());
		sb.append(",");
		sb.append(getGender() == null ? "" : getGender());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseLeaveType o) {
		return __leave_type_id == null ? -1 : __leave_type_id.compareTo(o.getLeaveTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__leave_type_id);
		hash = 97 * hash + Objects.hashCode(this.__leave_type_name);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseLeaveType o = (BaseLeaveType)obj;
		if(!Objects.equals(this.__leave_type_id, o.getLeaveTypeId())) return false;
		if(!Objects.equals(this.__leave_type_name, o.getLeaveTypeName())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLeaveTypeId() != null) sb.append(__wrapNumber(count++, "leaveTypeId", getLeaveTypeId()));
		if(getLeaveTypeName() != null) sb.append(__wrapString(count++, "leaveTypeName", getLeaveTypeName()));
		if(getGender() != null) sb.append(__wrapNumber(count++, "gender", getGender()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("leaveTypeId")) != null) setLeaveTypeId(__getInt(val)); 
		if((val = values.get("leaveTypeName")) != null) setLeaveTypeName(__getString(val));
		if((val = values.get("gender")) != null) setGender(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
	}

	protected java.lang.Integer  __leave_type_id ;
	protected java.lang.String  __leave_type_name ;
	protected java.lang.Integer  __gender ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Boolean  __is_enable ;
}
