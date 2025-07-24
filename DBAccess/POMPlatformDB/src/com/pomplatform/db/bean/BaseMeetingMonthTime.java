package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMeetingMonthTime extends GenericBase implements BaseFactory<BaseMeetingMonthTime>, Comparable<BaseMeetingMonthTime> 
{


	public static BaseMeetingMonthTime newInstance(){
		return new BaseMeetingMonthTime();
	}

	@Override
	public BaseMeetingMonthTime make(){
		BaseMeetingMonthTime b = new BaseMeetingMonthTime();
		return b;
	}

	public final static java.lang.String CS_MEETING_MONTH_TIME_ID = "meeting_month_time_id" ;
	public final static java.lang.String CS_MEETING_MONTH_DATE = "meeting_month_date" ;

	public final static java.lang.String ALL_CAPTIONS = "主键id,日期时间";

	public java.lang.Integer getMeetingMonthTimeId() {
		return this.__meeting_month_time_id;
	}

	public void setMeetingMonthTimeId( java.lang.Integer value ) {
		this.__meeting_month_time_id = value;
	}

	public java.util.Date getMeetingMonthDate() {
		return this.__meeting_month_date;
	}

	public void setMeetingMonthDate( java.util.Date value ) {
		this.__meeting_month_date = value;
	}

	public void cloneCopy(BaseMeetingMonthTime __bean){
		__bean.setMeetingMonthTimeId(getMeetingMonthTimeId());
		__bean.setMeetingMonthDate(getMeetingMonthDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingMonthTimeId() == null ? "" : getMeetingMonthTimeId());
		sb.append(",");
		sb.append(getMeetingMonthDate() == null ? "" : sdf.format(getMeetingMonthDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingMonthTime o) {
		return __meeting_month_time_id == null ? -1 : __meeting_month_time_id.compareTo(o.getMeetingMonthTimeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_month_time_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_month_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingMonthTime o = (BaseMeetingMonthTime)obj;
		if(!Objects.equals(this.__meeting_month_time_id, o.getMeetingMonthTimeId())) return false;
		if(!Objects.equals(this.__meeting_month_date, o.getMeetingMonthDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingMonthTimeId() != null) sb.append(__wrapNumber(count++, "meetingMonthTimeId", getMeetingMonthTimeId()));
		if(getMeetingMonthDate() != null) sb.append(__wrapDate(count++, "meetingMonthDate", getMeetingMonthDate()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingMonthTimeId() != null) res.put("meetingMonthTimeId", getMeetingMonthTimeId());
		if(getMeetingMonthDate() != null) res.put("meetingMonthDate", getMeetingMonthDate());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingMonthTimeId")) != null) setMeetingMonthTimeId(__getInt(val)); 
		if((val = values.get("meetingMonthDate")) != null) setMeetingMonthDate(__getDate(val)); 
	}

	protected java.lang.Integer  __meeting_month_time_id ;
	protected java.util.Date  __meeting_month_date ;
}
