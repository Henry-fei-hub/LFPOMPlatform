package pomplatform.meeting.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseMeetingRoomManagement extends GenericBase implements BaseFactory<BaseMeetingRoomManagement>, Comparable<BaseMeetingRoomManagement>
{


	public static BaseMeetingRoomManagement newInstance(){
		return new BaseMeetingRoomManagement();
	}

	@Override
	public BaseMeetingRoomManagement make(){
		BaseMeetingRoomManagement b = new BaseMeetingRoomManagement();
		return b;
	}

	public final static String CS_MEETING_ROOM_ID = "meeting_room_id" ;
	public final static String CS_MEETING_ROOM_NAME = "meeting_room_name" ;
	public final static String CS_SITE = "site" ;
	public final static String CS_CONTAIN_NUM = "contain_num" ;
	public final static String CS_COMPANY_RECORD_ID = "company_record_id" ;
	public final static String CS_MEETING_ROOM_MASTER = "meeting_room_master" ;
	public final static String CS_REMARK = "remark" ;

	public final static String ALL_CAPTIONS = "id,会议室名称,位置,容纳人数,归属公司,会议室负责人,备注";

	public Integer getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( Integer value ) {
		this.__meeting_room_id = value;
	}

	public String getMeetingRoomName() {
		return this.__meeting_room_name;
	}

	public void setMeetingRoomName( String value ) {
		this.__meeting_room_name = value;
	}

	public String getSite() {
		return this.__site;
	}

	public void setSite( String value ) {
		this.__site = value;
	}

	public Integer getContainNum() {
		return this.__contain_num;
	}

	public void setContainNum( Integer value ) {
		this.__contain_num = value;
	}

	public Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( Integer value ) {
		this.__company_record_id = value;
	}

	public String getMeetingRoomMaster() {
		return this.__meeting_room_master;
	}

	public void setMeetingRoomMaster( String value ) {
		this.__meeting_room_master = value;
	}

	public String getRemark() {
		return this.__remark;
	}

	public void setRemark( String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseMeetingRoomManagement __bean){
		__bean.setMeetingRoomId(getMeetingRoomId());
		__bean.setMeetingRoomName(getMeetingRoomName());
		__bean.setSite(getSite());
		__bean.setContainNum(getContainNum());
		__bean.setCompanyRecordId(getCompanyRecordId());
		__bean.setMeetingRoomMaster(getMeetingRoomMaster());
		__bean.setRemark(getRemark());
	}

	public String toCSVString() {

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
		sb.append(getMeetingRoomMaster() == null ? "" : getMeetingRoomMaster());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingRoomManagement o) {
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
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_master);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingRoomManagement o = (BaseMeetingRoomManagement)obj;
		if(!Objects.equals(this.__meeting_room_id, o.getMeetingRoomId())) return false;
		if(!Objects.equals(this.__meeting_room_name, o.getMeetingRoomName())) return false;
		if(!Objects.equals(this.__site, o.getSite())) return false;
		if(!Objects.equals(this.__contain_num, o.getContainNum())) return false;
		if(!Objects.equals(this.__company_record_id, o.getCompanyRecordId())) return false;
		if(!Objects.equals(this.__meeting_room_master, o.getMeetingRoomMaster())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(count++, "meetingRoomId", getMeetingRoomId()));
		if(getMeetingRoomName() != null) sb.append(__wrapString(count++, "meetingRoomName", getMeetingRoomName()));
		if(getSite() != null) sb.append(__wrapString(count++, "site", getSite()));
		if(getContainNum() != null) sb.append(__wrapNumber(count++, "containNum", getContainNum()));
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(count++, "companyRecordId", getCompanyRecordId()));
		if(getMeetingRoomMaster() != null) sb.append(__wrapString(count++, "meetingRoomMaster", getMeetingRoomMaster()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRoomId() != null) res.put("meetingRoomId", getMeetingRoomId());
		if(getMeetingRoomName() != null) res.put("meetingRoomName", getMeetingRoomName());
		if(getSite() != null) res.put("site", getSite());
		if(getContainNum() != null) res.put("containNum", getContainNum());
		if(getCompanyRecordId() != null) res.put("companyRecordId", getCompanyRecordId());
		if(getMeetingRoomMaster() != null) res.put("meetingRoomMaster", getMeetingRoomMaster());
		if(getRemark() != null) res.put("remark", getRemark());
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
		if((val = values.get("meetingRoomMaster")) != null) setMeetingRoomMaster(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected Integer  __meeting_room_id ;
	protected String  __meeting_room_name ;
	protected String  __site ;
	protected Integer  __contain_num ;
	protected Integer  __company_record_id ;
	protected String  __meeting_room_master ;
	protected String  __remark ;
}
