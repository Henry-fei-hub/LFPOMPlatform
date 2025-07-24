package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMeetingDefinition extends GenericBase implements BaseFactory<BaseMeetingDefinition>, Comparable<BaseMeetingDefinition> 
{


	public static BaseMeetingDefinition newInstance(){
		return new BaseMeetingDefinition();
	}

	@Override
	public BaseMeetingDefinition make(){
		BaseMeetingDefinition b = new BaseMeetingDefinition();
		return b;
	}

	public final static java.lang.String CS_MEETING_DEFINE_ID = "meeting_define_id" ;
	public final static java.lang.String CS_MEETING_ROOM_NAME = "meeting_room_name" ;
	public final static java.lang.String CS_SITE = "site" ;
	public final static java.lang.String CS_CONTAIN_NUM = "contain_num" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_COMPANY_RECORD_ID = "company_record_id" ;
	public final static java.lang.String CS_MEETING_ROOM_MASTER = "meeting_room_master" ;
	public final static java.lang.String CS_MIN_APPOINTMENT_TIME = "min_appointment_time" ;
	public final static java.lang.String CS_OVERTIME = "overtime" ;
	public final static java.lang.String CS_REMIND_TIME = "remind_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,会议室名称,会议室位置,容纳人数,状态（0正常使用，1禁止使用）,归属公司,会议室负责人,最少预订时间（1小时）,超时时间（默认5分钟）,提醒时间（会议开始前15分钟）,备注";

	public java.lang.Integer getMeetingDefineId() {
		return this.__meeting_define_id;
	}

	public void setMeetingDefineId( java.lang.Integer value ) {
		this.__meeting_define_id = value;
	}

	public java.lang.String getMeetingRoomName() {
		return this.__meeting_room_name;
	}

	public void setMeetingRoomName( java.lang.String value ) {
		this.__meeting_room_name = value;
	}

	public java.lang.String getSite() {
		return this.__site;
	}

	public void setSite( java.lang.String value ) {
		this.__site = value;
	}

	public java.lang.Integer getContainNum() {
		return this.__contain_num;
	}

	public void setContainNum( java.lang.Integer value ) {
		this.__contain_num = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( java.lang.Integer value ) {
		this.__company_record_id = value;
	}

	public java.lang.String getMeetingRoomMaster() {
		return this.__meeting_room_master;
	}

	public void setMeetingRoomMaster( java.lang.String value ) {
		this.__meeting_room_master = value;
	}

	public java.lang.Integer getMinAppointmentTime() {
		return this.__min_appointment_time;
	}

	public void setMinAppointmentTime( java.lang.Integer value ) {
		this.__min_appointment_time = value;
	}

	public java.lang.Integer getOvertime() {
		return this.__overtime;
	}

	public void setOvertime( java.lang.Integer value ) {
		this.__overtime = value;
	}

	public java.lang.Integer getRemindTime() {
		return this.__remind_time;
	}

	public void setRemindTime( java.lang.Integer value ) {
		this.__remind_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseMeetingDefinition __bean){
		__bean.setMeetingDefineId(getMeetingDefineId());
		__bean.setMeetingRoomName(getMeetingRoomName());
		__bean.setSite(getSite());
		__bean.setContainNum(getContainNum());
		__bean.setStatus(getStatus());
		__bean.setCompanyRecordId(getCompanyRecordId());
		__bean.setMeetingRoomMaster(getMeetingRoomMaster());
		__bean.setMinAppointmentTime(getMinAppointmentTime());
		__bean.setOvertime(getOvertime());
		__bean.setRemindTime(getRemindTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingDefineId() == null ? "" : getMeetingDefineId());
		sb.append(",");
		sb.append(getMeetingRoomName() == null ? "" : getMeetingRoomName());
		sb.append(",");
		sb.append(getSite() == null ? "" : getSite());
		sb.append(",");
		sb.append(getContainNum() == null ? "" : getContainNum());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getCompanyRecordId() == null ? "" : getCompanyRecordId());
		sb.append(",");
		sb.append(getMeetingRoomMaster() == null ? "" : getMeetingRoomMaster());
		sb.append(",");
		sb.append(getMinAppointmentTime() == null ? "" : getMinAppointmentTime());
		sb.append(",");
		sb.append(getOvertime() == null ? "" : getOvertime());
		sb.append(",");
		sb.append(getRemindTime() == null ? "" : getRemindTime());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingDefinition o) {
		return __meeting_define_id == null ? -1 : __meeting_define_id.compareTo(o.getMeetingDefineId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_define_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_name);
		hash = 97 * hash + Objects.hashCode(this.__site);
		hash = 97 * hash + Objects.hashCode(this.__contain_num);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__company_record_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_master);
		hash = 97 * hash + Objects.hashCode(this.__min_appointment_time);
		hash = 97 * hash + Objects.hashCode(this.__overtime);
		hash = 97 * hash + Objects.hashCode(this.__remind_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingDefinition o = (BaseMeetingDefinition)obj;
		if(!Objects.equals(this.__meeting_define_id, o.getMeetingDefineId())) return false;
		if(!Objects.equals(this.__meeting_room_name, o.getMeetingRoomName())) return false;
		if(!Objects.equals(this.__site, o.getSite())) return false;
		if(!Objects.equals(this.__contain_num, o.getContainNum())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__company_record_id, o.getCompanyRecordId())) return false;
		if(!Objects.equals(this.__meeting_room_master, o.getMeetingRoomMaster())) return false;
		if(!Objects.equals(this.__min_appointment_time, o.getMinAppointmentTime())) return false;
		if(!Objects.equals(this.__overtime, o.getOvertime())) return false;
		if(!Objects.equals(this.__remind_time, o.getRemindTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingDefineId() != null) sb.append(__wrapNumber(count++, "meetingDefineId", getMeetingDefineId()));
		if(getMeetingRoomName() != null) sb.append(__wrapString(count++, "meetingRoomName", getMeetingRoomName()));
		if(getSite() != null) sb.append(__wrapString(count++, "site", getSite()));
		if(getContainNum() != null) sb.append(__wrapNumber(count++, "containNum", getContainNum()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(count++, "companyRecordId", getCompanyRecordId()));
		if(getMeetingRoomMaster() != null) sb.append(__wrapString(count++, "meetingRoomMaster", getMeetingRoomMaster()));
		if(getMinAppointmentTime() != null) sb.append(__wrapNumber(count++, "minAppointmentTime", getMinAppointmentTime()));
		if(getOvertime() != null) sb.append(__wrapNumber(count++, "overtime", getOvertime()));
		if(getRemindTime() != null) sb.append(__wrapNumber(count++, "remindTime", getRemindTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingDefineId() != null) res.put("meetingDefineId", getMeetingDefineId());
		if(getMeetingRoomName() != null) res.put("meetingRoomName", getMeetingRoomName());
		if(getSite() != null) res.put("site", getSite());
		if(getContainNum() != null) res.put("containNum", getContainNum());
		if(getStatus() != null) res.put("status", getStatus());
		if(getCompanyRecordId() != null) res.put("companyRecordId", getCompanyRecordId());
		if(getMeetingRoomMaster() != null) res.put("meetingRoomMaster", getMeetingRoomMaster());
		if(getMinAppointmentTime() != null) res.put("minAppointmentTime", getMinAppointmentTime());
		if(getOvertime() != null) res.put("overtime", getOvertime());
		if(getRemindTime() != null) res.put("remindTime", getRemindTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingDefineId")) != null) setMeetingDefineId(__getInt(val)); 
		if((val = values.get("meetingRoomName")) != null) setMeetingRoomName(__getString(val));
		if((val = values.get("site")) != null) setSite(__getString(val));
		if((val = values.get("containNum")) != null) setContainNum(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("companyRecordId")) != null) setCompanyRecordId(__getInt(val)); 
		if((val = values.get("meetingRoomMaster")) != null) setMeetingRoomMaster(__getString(val));
		if((val = values.get("minAppointmentTime")) != null) setMinAppointmentTime(__getInt(val)); 
		if((val = values.get("overtime")) != null) setOvertime(__getInt(val)); 
		if((val = values.get("remindTime")) != null) setRemindTime(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __meeting_define_id ;
	protected java.lang.String  __meeting_room_name ;
	protected java.lang.String  __site ;
	protected java.lang.Integer  __contain_num ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __company_record_id ;
	protected java.lang.String  __meeting_room_master ;
	protected java.lang.Integer  __min_appointment_time ;
	protected java.lang.Integer  __overtime ;
	protected java.lang.Integer  __remind_time ;
	protected java.lang.String  __remark ;
}
