package pomplatform.meeting.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMeetingRoomTimeManagement extends GenericBase implements BaseFactory<BaseMeetingRoomTimeManagement>, Comparable<BaseMeetingRoomTimeManagement> 
{


	public static BaseMeetingRoomTimeManagement newInstance(){
		return new BaseMeetingRoomTimeManagement();
	}

	@Override
	public BaseMeetingRoomTimeManagement make(){
		BaseMeetingRoomTimeManagement b = new BaseMeetingRoomTimeManagement();
		return b;
	}

	public final static java.lang.String CS_MEETING_ROOM_TIME_ID = "meeting_room_time_id" ;
	public final static java.lang.String CS_MEETING_ROOM_TIME = "meeting_room_time" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "id,时间区间,状态,备注,是否删除";

	public java.lang.Integer getMeetingRoomTimeId() {
		return this.__meeting_room_time_id;
	}

	public void setMeetingRoomTimeId( java.lang.Integer value ) {
		this.__meeting_room_time_id = value;
	}

	public java.lang.String getMeetingRoomTime() {
		return this.__meeting_room_time;
	}

	public void setMeetingRoomTime( java.lang.String value ) {
		this.__meeting_room_time = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public void cloneCopy(BaseMeetingRoomTimeManagement __bean){
		__bean.setMeetingRoomTimeId(getMeetingRoomTimeId());
		__bean.setMeetingRoomTime(getMeetingRoomTime());
		__bean.setStatus(getStatus());
		__bean.setRemark(getRemark());
		__bean.setDeleteFlag(getDeleteFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingRoomTimeId() == null ? "" : getMeetingRoomTimeId());
		sb.append(",");
		sb.append(getMeetingRoomTime() == null ? "" : getMeetingRoomTime());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingRoomTimeManagement o) {
		return __meeting_room_time_id == null ? -1 : __meeting_room_time_id.compareTo(o.getMeetingRoomTimeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_time_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingRoomTimeManagement o = (BaseMeetingRoomTimeManagement)obj;
		if(!Objects.equals(this.__meeting_room_time_id, o.getMeetingRoomTimeId())) return false;
		if(!Objects.equals(this.__meeting_room_time, o.getMeetingRoomTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingRoomTimeId() != null) sb.append(__wrapNumber(count++, "meetingRoomTimeId", getMeetingRoomTimeId()));
		if(getMeetingRoomTime() != null) sb.append(__wrapString(count++, "meetingRoomTime", getMeetingRoomTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRoomTimeId() != null) res.put("meetingRoomTimeId", getMeetingRoomTimeId());
		if(getMeetingRoomTime() != null) res.put("meetingRoomTime", getMeetingRoomTime());
		if(getStatus() != null) res.put("status", getStatus());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingRoomTimeId")) != null) setMeetingRoomTimeId(__getInt(val)); 
		if((val = values.get("meetingRoomTime")) != null) setMeetingRoomTime(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __meeting_room_time_id ;
	protected java.lang.String  __meeting_room_time ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __delete_flag ;
}
