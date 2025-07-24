package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseLeaveTypeLinkArea extends GenericBase implements BaseFactory<BaseLeaveTypeLinkArea>, Comparable<BaseLeaveTypeLinkArea> 
{


	public static BaseLeaveTypeLinkArea newInstance(){
		return new BaseLeaveTypeLinkArea();
	}

	@Override
	public BaseLeaveTypeLinkArea make(){
		BaseLeaveTypeLinkArea b = new BaseLeaveTypeLinkArea();
		return b;
	}

	public final static java.lang.String CS_LEAVE_TYPE_LINK_AREA_ID = "leave_type_link_area_id" ;
	public final static java.lang.String CS_LEAVE_TYPE_ID = "leave_type_id" ;
	public final static java.lang.String CS_AREA_ID = "area_id" ;
	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;

	public final static java.lang.String ALL_CAPTIONS = "请假类型区域关联表,请假类型编码,适用区域,天数,备注,是否启用";

	public java.lang.Integer getLeaveTypeLinkAreaId() {
		return this.__leave_type_link_area_id;
	}

	public void setLeaveTypeLinkAreaId( java.lang.Integer value ) {
		this.__leave_type_link_area_id = value;
	}

	public java.lang.Integer getLeaveTypeId() {
		return this.__leave_type_id;
	}

	public void setLeaveTypeId( java.lang.Integer value ) {
		this.__leave_type_id = value;
	}

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId( java.lang.Integer value ) {
		this.__area_id = value;
	}

	public java.math.BigDecimal getDays() {
		return this.__days;
	}

	public void setDays( java.math.BigDecimal value ) {
		this.__days = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public void cloneCopy(BaseLeaveTypeLinkArea __bean){
		__bean.setLeaveTypeLinkAreaId(getLeaveTypeLinkAreaId());
		__bean.setLeaveTypeId(getLeaveTypeId());
		__bean.setAreaId(getAreaId());
		__bean.setDays(getDays());
		__bean.setRemark(getRemark());
		__bean.setIsEnable(getIsEnable());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLeaveTypeLinkAreaId() == null ? "" : getLeaveTypeLinkAreaId());
		sb.append(",");
		sb.append(getLeaveTypeId() == null ? "" : getLeaveTypeId());
		sb.append(",");
		sb.append(getAreaId() == null ? "" : getAreaId());
		sb.append(",");
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseLeaveTypeLinkArea o) {
		return __leave_type_link_area_id == null ? -1 : __leave_type_link_area_id.compareTo(o.getLeaveTypeLinkAreaId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__leave_type_link_area_id);
		hash = 97 * hash + Objects.hashCode(this.__leave_type_id);
		hash = 97 * hash + Objects.hashCode(this.__area_id);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseLeaveTypeLinkArea o = (BaseLeaveTypeLinkArea)obj;
		if(!Objects.equals(this.__leave_type_link_area_id, o.getLeaveTypeLinkAreaId())) return false;
		if(!Objects.equals(this.__leave_type_id, o.getLeaveTypeId())) return false;
		if(!Objects.equals(this.__area_id, o.getAreaId())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLeaveTypeLinkAreaId() != null) sb.append(__wrapNumber(count++, "leaveTypeLinkAreaId", getLeaveTypeLinkAreaId()));
		if(getLeaveTypeId() != null) sb.append(__wrapNumber(count++, "leaveTypeId", getLeaveTypeId()));
		if(getAreaId() != null) sb.append(__wrapNumber(count++, "areaId", getAreaId()));
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("leaveTypeLinkAreaId")) != null) setLeaveTypeLinkAreaId(__getInt(val)); 
		if((val = values.get("leaveTypeId")) != null) setLeaveTypeId(__getInt(val)); 
		if((val = values.get("areaId")) != null) setAreaId(__getInt(val)); 
		if((val = values.get("days")) != null) setDays(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
	}

	protected java.lang.Integer  __leave_type_link_area_id ;
	protected java.lang.Integer  __leave_type_id ;
	protected java.lang.Integer  __area_id ;
	protected java.math.BigDecimal  __days ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __is_enable ;
}
