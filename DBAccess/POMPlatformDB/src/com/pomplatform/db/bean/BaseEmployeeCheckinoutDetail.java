package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeCheckinoutDetail extends GenericBase implements BaseFactory<BaseEmployeeCheckinoutDetail>, Comparable<BaseEmployeeCheckinoutDetail> 
{


	public static BaseEmployeeCheckinoutDetail newInstance(){
		return new BaseEmployeeCheckinoutDetail();
	}

	@Override
	public BaseEmployeeCheckinoutDetail make(){
		BaseEmployeeCheckinoutDetail b = new BaseEmployeeCheckinoutDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_CHECKINOUT_DETAIL_ID = "employee_checkinout_detail_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CHECK_DATE = "check_date" ;
	public final static java.lang.String CS_CHECK_TIME = "check_time" ;
	public final static java.lang.String CS_OA_EMPLOYEE_ID = "oa_employee_id" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员编码,考勤日期,打卡时间,员工OAid,操作人,操作时间,备注";

	public java.lang.Integer getEmployeeCheckinoutDetailId() {
		return this.__employee_checkinout_detail_id;
	}

	public void setEmployeeCheckinoutDetailId( java.lang.Integer value ) {
		this.__employee_checkinout_detail_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCheckDate() {
		return this.__check_date;
	}

	public void setCheckDate( java.util.Date value ) {
		this.__check_date = value;
	}

	public java.util.Date getCheckTime() {
		return this.__check_time;
	}

	public void setCheckTime( java.util.Date value ) {
		this.__check_time = value;
	}

	public java.lang.Integer getOaEmployeeId() {
		return this.__oa_employee_id;
	}

	public void setOaEmployeeId( java.lang.Integer value ) {
		this.__oa_employee_id = value;
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

	public void cloneCopy(BaseEmployeeCheckinoutDetail __bean){
		__bean.setEmployeeCheckinoutDetailId(getEmployeeCheckinoutDetailId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCheckDate(getCheckDate());
		__bean.setCheckTime(getCheckTime());
		__bean.setOaEmployeeId(getOaEmployeeId());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeCheckinoutDetailId() == null ? "" : getEmployeeCheckinoutDetailId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getCheckDate() == null ? "" : sdf.format(getCheckDate()));
		sb.append(",");
		sb.append(getCheckTime() == null ? "" : sdf.format(getCheckTime()));
		sb.append(",");
		sb.append(getOaEmployeeId() == null ? "" : getOaEmployeeId());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeCheckinoutDetail o) {
		return __employee_checkinout_detail_id == null ? -1 : __employee_checkinout_detail_id.compareTo(o.getEmployeeCheckinoutDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_checkinout_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__check_date);
		hash = 97 * hash + Objects.hashCode(this.__check_time);
		hash = 97 * hash + Objects.hashCode(this.__oa_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeCheckinoutDetail o = (BaseEmployeeCheckinoutDetail)obj;
		if(!Objects.equals(this.__employee_checkinout_detail_id, o.getEmployeeCheckinoutDetailId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__check_date, o.getCheckDate())) return false;
		if(!Objects.equals(this.__check_time, o.getCheckTime())) return false;
		if(!Objects.equals(this.__oa_employee_id, o.getOaEmployeeId())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeCheckinoutDetailId() != null) sb.append(__wrapNumber(count++, "employeeCheckinoutDetailId", getEmployeeCheckinoutDetailId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCheckDate() != null) sb.append(__wrapDate(count++, "checkDate", getCheckDate()));
		if(getCheckTime() != null) sb.append(__wrapDate(count++, "checkTime", getCheckTime()));
		if(getOaEmployeeId() != null) sb.append(__wrapNumber(count++, "oaEmployeeId", getOaEmployeeId()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeCheckinoutDetailId")) != null) setEmployeeCheckinoutDetailId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("checkDate")) != null) setCheckDate(__getDate(val)); 
		if((val = values.get("checkTime")) != null) setCheckTime(__getDate(val)); 
		if((val = values.get("oaEmployeeId")) != null) setOaEmployeeId(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __employee_checkinout_detail_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __check_date ;
	protected java.util.Date  __check_time ;
	protected java.lang.Integer  __oa_employee_id ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
