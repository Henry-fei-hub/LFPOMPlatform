package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseHolidayManage extends GenericBase implements BaseFactory<BaseHolidayManage>, Comparable<BaseHolidayManage> 
{


	public static BaseHolidayManage newInstance(){
		return new BaseHolidayManage();
	}

	@Override
	public BaseHolidayManage make(){
		BaseHolidayManage b = new BaseHolidayManage();
		return b;
	}

	public final static java.lang.String CS_HOLIDAY_MANAGE_ID = "holiday_manage_id" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_START_TIME = "start_time" ;
	public final static java.lang.String CS_END_TIME = "end_time" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_DESCRIPTION = "description" ;
	public final static java.lang.String CS_IS_WORK_DAY = "is_work_day" ;
	public final static java.lang.String CS_IS_COUNT_OVERTIME = "is_count_overtime" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,节日名称,年份,月份,开始时间,结束时间,记录日期,操作人,操作时间,说明,是否计工作日,是否算加班";

	public java.lang.Integer getHolidayManageId() {
		return this.__holiday_manage_id;
	}

	public void setHolidayManageId( java.lang.Integer value ) {
		this.__holiday_manage_id = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.util.Date getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( java.util.Date value ) {
		this.__start_time = value;
	}

	public java.util.Date getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( java.util.Date value ) {
		this.__end_time = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
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

	public java.lang.String getDescription() {
		return this.__description;
	}

	public void setDescription( java.lang.String value ) {
		this.__description = value;
	}

	public java.lang.Boolean getIsWorkDay() {
		return this.__is_work_day;
	}

	public void setIsWorkDay( java.lang.Boolean value ) {
		this.__is_work_day = value;
	}

	public java.lang.Boolean getIsCountOvertime() {
		return this.__is_count_overtime;
	}

	public void setIsCountOvertime( java.lang.Boolean value ) {
		this.__is_count_overtime = value;
	}

	public void cloneCopy(BaseHolidayManage __bean){
		__bean.setHolidayManageId(getHolidayManageId());
		__bean.setName(getName());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setStartTime(getStartTime());
		__bean.setEndTime(getEndTime());
		__bean.setRecordDate(getRecordDate());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setDescription(getDescription());
		__bean.setIsWorkDay(getIsWorkDay());
		__bean.setIsCountOvertime(getIsCountOvertime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getHolidayManageId() == null ? "" : getHolidayManageId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getStartTime() == null ? "" : sdf.format(getStartTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getDescription() == null ? "" : getDescription());
		sb.append(",");
		sb.append(getIsWorkDay() == null ? "" : getIsWorkDay());
		sb.append(",");
		sb.append(getIsCountOvertime() == null ? "" : getIsCountOvertime());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseHolidayManage o) {
		return __holiday_manage_id == null ? -1 : __holiday_manage_id.compareTo(o.getHolidayManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__holiday_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__description);
		hash = 97 * hash + Objects.hashCode(this.__is_work_day);
		hash = 97 * hash + Objects.hashCode(this.__is_count_overtime);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseHolidayManage o = (BaseHolidayManage)obj;
		if(!Objects.equals(this.__holiday_manage_id, o.getHolidayManageId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__description, o.getDescription())) return false;
		if(!Objects.equals(this.__is_work_day, o.getIsWorkDay())) return false;
		if(!Objects.equals(this.__is_count_overtime, o.getIsCountOvertime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getHolidayManageId() != null) sb.append(__wrapNumber(count++, "holidayManageId", getHolidayManageId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getStartTime() != null) sb.append(__wrapDate(count++, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(count++, "endTime", getEndTime()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getDescription() != null) sb.append(__wrapString(count++, "description", getDescription()));
		if(getIsWorkDay() != null) sb.append(__wrapBoolean(count++, "isWorkDay", getIsWorkDay()));
		if(getIsCountOvertime() != null) sb.append(__wrapBoolean(count++, "isCountOvertime", getIsCountOvertime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getHolidayManageId() != null) res.put("holidayManageId", getHolidayManageId());
		if(getName() != null) res.put("name", getName());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getStartTime() != null) res.put("startTime", getStartTime());
		if(getEndTime() != null) res.put("endTime", getEndTime());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getDescription() != null) res.put("description", getDescription());
		if(getIsWorkDay() != null) res.put("isWorkDay", getIsWorkDay());
		if(getIsCountOvertime() != null) res.put("isCountOvertime", getIsCountOvertime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("holidayManageId")) != null) setHolidayManageId(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("description")) != null) setDescription(__getString(val));
		if((val = values.get("isWorkDay")) != null) setIsWorkDay(__getBoolean(val));
		if((val = values.get("isCountOvertime")) != null) setIsCountOvertime(__getBoolean(val));
	}

	protected java.lang.Integer  __holiday_manage_id ;
	protected java.lang.String  __name ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.util.Date  __start_time ;
	protected java.util.Date  __end_time ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __description ;
	protected java.lang.Boolean  __is_work_day ;
	protected java.lang.Boolean  __is_count_overtime ;
}
