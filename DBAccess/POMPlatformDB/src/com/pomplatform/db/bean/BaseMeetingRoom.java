package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMeetingRoom extends GenericBase implements BaseFactory<BaseMeetingRoom>, Comparable<BaseMeetingRoom> 
{


	public static BaseMeetingRoom newInstance(){
		return new BaseMeetingRoom();
	}

	@Override
	public BaseMeetingRoom make(){
		BaseMeetingRoom b = new BaseMeetingRoom();
		return b;
	}

	public final static java.lang.String CS_MEETING_ROOM_ID = "meeting_room_id" ;
	public final static java.lang.String CS_MEETING_ROOM_NAME = "meeting_room_name" ;
	public final static java.lang.String CS_SITE = "site" ;
	public final static java.lang.String CS_CONTAIN_NUM = "contain_num" ;
	public final static java.lang.String CS_COMPANY_RECORD_ID = "company_record_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_MEETING_ROOM_MASTER = "meeting_room_master" ;

	public final static java.lang.String ALL_CAPTIONS = "id,会议室名称,位置,容纳人数,归属公司,备注,会议室负责人";

	public java.lang.Integer getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( java.lang.Integer value ) {
		this.__meeting_room_id = value;
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

	public java.lang.Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( java.lang.Integer value ) {
		this.__company_record_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getMeetingRoomMaster() {
		return this.__meeting_room_master;
	}

	public void setMeetingRoomMaster( java.lang.String value ) {
		this.__meeting_room_master = value;
	}

	public void cloneCopy(BaseMeetingRoom __bean){
		__bean.setMeetingRoomId(getMeetingRoomId());
		__bean.setMeetingRoomName(getMeetingRoomName());
		__bean.setSite(getSite());
		__bean.setContainNum(getContainNum());
		__bean.setCompanyRecordId(getCompanyRecordId());
		__bean.setRemark(getRemark());
		__bean.setMeetingRoomMaster(getMeetingRoomMaster());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingRoomId() == null ? "" : getMeetingRoomId());
		sb.append(",");
		sb.append(getMeetingRoomName() == null ? "" : getMeetingRoomName());
		sb.append(",");
		sb.append(getSite() == null ? "" : getSite());
		sb.append(",");
		sb.append(getContainNum() == null ? "" : getContainNum());
		sb.append(",");
		sb.append(getCompanyRecordId() == null ? "" : getCompanyRecordId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getMeetingRoomMaster() == null ? "" : getMeetingRoomMaster());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingRoom o) {
		return __meeting_room_id == null ? -1 : __meeting_room_id.compareTo(o.getMeetingRoomId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_name);
		hash = 97 * hash + Objects.hashCode(this.__site);
		hash = 97 * hash + Objects.hashCode(this.__contain_num);
		hash = 97 * hash + Objects.hashCode(this.__company_record_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_master);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingRoom o = (BaseMeetingRoom)obj;
		if(!Objects.equals(this.__meeting_room_id, o.getMeetingRoomId())) return false;
		if(!Objects.equals(this.__meeting_room_name, o.getMeetingRoomName())) return false;
		if(!Objects.equals(this.__site, o.getSite())) return false;
		if(!Objects.equals(this.__contain_num, o.getContainNum())) return false;
		if(!Objects.equals(this.__company_record_id, o.getCompanyRecordId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__meeting_room_master, o.getMeetingRoomMaster())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(count++, "meetingRoomId", getMeetingRoomId()));
		if(getMeetingRoomName() != null) sb.append(__wrapString(count++, "meetingRoomName", getMeetingRoomName()));
		if(getSite() != null) sb.append(__wrapString(count++, "site", getSite()));
		if(getContainNum() != null) sb.append(__wrapNumber(count++, "containNum", getContainNum()));
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(count++, "companyRecordId", getCompanyRecordId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getMeetingRoomMaster() != null) sb.append(__wrapString(count++, "meetingRoomMaster", getMeetingRoomMaster()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRoomId() != null) res.put("meetingRoomId", getMeetingRoomId());
		if(getMeetingRoomName() != null) res.put("meetingRoomName", getMeetingRoomName());
		if(getSite() != null) res.put("site", getSite());
		if(getContainNum() != null) res.put("containNum", getContainNum());
		if(getCompanyRecordId() != null) res.put("companyRecordId", getCompanyRecordId());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getMeetingRoomMaster() != null) res.put("meetingRoomMaster", getMeetingRoomMaster());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val)); 
		if((val = values.get("meetingRoomName")) != null) setMeetingRoomName(__getString(val));
		if((val = values.get("site")) != null) setSite(__getString(val));
		if((val = values.get("containNum")) != null) setContainNum(__getInt(val)); 
		if((val = values.get("companyRecordId")) != null) setCompanyRecordId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("meetingRoomMaster")) != null) setMeetingRoomMaster(__getString(val));
	}

	protected java.lang.Integer  __meeting_room_id ;
	protected java.lang.String  __meeting_room_name ;
	protected java.lang.String  __site ;
	protected java.lang.Integer  __contain_num ;
	protected java.lang.Integer  __company_record_id ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __meeting_room_master ;
}
