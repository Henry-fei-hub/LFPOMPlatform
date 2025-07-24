package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeCheckinoutUpdatetime extends GenericBase implements BaseFactory<BaseEmployeeCheckinoutUpdatetime>, Comparable<BaseEmployeeCheckinoutUpdatetime> 
{


	public static BaseEmployeeCheckinoutUpdatetime newInstance(){
		return new BaseEmployeeCheckinoutUpdatetime();
	}

	@Override
	public BaseEmployeeCheckinoutUpdatetime make(){
		BaseEmployeeCheckinoutUpdatetime b = new BaseEmployeeCheckinoutUpdatetime();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_CHECKINOUT_UPDATETIME_ID = "employee_checkinout_updatetime_id" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,更新时间,操作人,操作时间,备注";

	public java.lang.Integer getEmployeeCheckinoutUpdatetimeId() {
		return this.__employee_checkinout_updatetime_id;
	}

	public void setEmployeeCheckinoutUpdatetimeId( java.lang.Integer value ) {
		this.__employee_checkinout_updatetime_id = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
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

	public void cloneCopy(BaseEmployeeCheckinoutUpdatetime __bean){
		__bean.setEmployeeCheckinoutUpdatetimeId(getEmployeeCheckinoutUpdatetimeId());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeCheckinoutUpdatetimeId() == null ? "" : getEmployeeCheckinoutUpdatetimeId());
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeCheckinoutUpdatetime o) {
		return __employee_checkinout_updatetime_id == null ? -1 : __employee_checkinout_updatetime_id.compareTo(o.getEmployeeCheckinoutUpdatetimeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_checkinout_updatetime_id);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeCheckinoutUpdatetime o = (BaseEmployeeCheckinoutUpdatetime)obj;
		if(!Objects.equals(this.__employee_checkinout_updatetime_id, o.getEmployeeCheckinoutUpdatetimeId())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeCheckinoutUpdatetimeId() != null) sb.append(__wrapNumber(count++, "employeeCheckinoutUpdatetimeId", getEmployeeCheckinoutUpdatetimeId()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeCheckinoutUpdatetimeId")) != null) setEmployeeCheckinoutUpdatetimeId(__getInt(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __employee_checkinout_updatetime_id ;
	protected java.util.Date  __update_time ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
