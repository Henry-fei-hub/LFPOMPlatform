package pomplatform.meeting.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMeetingRoomReservaTionRecordPaymentBase extends GenericBase implements BaseFactory<BaseMeetingRoomReservaTionRecordPaymentBase>, Comparable<BaseMeetingRoomReservaTionRecordPaymentBase> 
{


	public static BaseMeetingRoomReservaTionRecordPaymentBase newInstance(){
		return new BaseMeetingRoomReservaTionRecordPaymentBase();
	}

	@Override
	public BaseMeetingRoomReservaTionRecordPaymentBase make(){
		BaseMeetingRoomReservaTionRecordPaymentBase b = new BaseMeetingRoomReservaTionRecordPaymentBase();
		return b;
	}

	public final static java.lang.String CS_MEETING_ROOM_ID = "meeting_room_id" ;
	public final static java.lang.String CS_MEETING_ROOM_NAME = "meeting_room_name" ;
	public final static java.lang.String CS_SITE = "site" ;
	public final static java.lang.String CS_CONTAIN_NUM = "contain_num" ;
	public final static java.lang.String CS_MEETING_MONTH_DATE = "meeting_month_date" ;
	public final static java.lang.String CS_TIME_2 = "time_2" ;
	public final static java.lang.String CS_TIME_3 = "time_3" ;
	public final static java.lang.String CS_TIME_4 = "time_4" ;
	public final static java.lang.String CS_TIME_5 = "time_5" ;
	public final static java.lang.String CS_TIME_6 = "time_6" ;
	public final static java.lang.String CS_TIME_7 = "time_7" ;
	public final static java.lang.String CS_TIME_8 = "time_8" ;
	public final static java.lang.String CS_TIME_9 = "time_9" ;
	public final static java.lang.String CS_TIME_10 = "time_10" ;
	public final static java.lang.String CS_TIME_11 = "time_11" ;
	public final static java.lang.String CS_TIME_12 = "time_12" ;

	public final static java.lang.String ALL_CAPTIONS = "id,会议室名称,位置,容纳人数,日期时间,,,,,,,,,,,";

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

	public java.util.Date getMeetingMonthDate() {
		return this.__meeting_month_date;
	}

	public void setMeetingMonthDate( java.util.Date value ) {
		this.__meeting_month_date = value;
	}

	public java.lang.String getTime2() {
		return this.__time_2;
	}

	public void setTime2( java.lang.String value ) {
		this.__time_2 = value;
	}

	public java.lang.String getTime3() {
		return this.__time_3;
	}

	public void setTime3( java.lang.String value ) {
		this.__time_3 = value;
	}

	public java.lang.String getTime4() {
		return this.__time_4;
	}

	public void setTime4( java.lang.String value ) {
		this.__time_4 = value;
	}

	public java.lang.String getTime5() {
		return this.__time_5;
	}

	public void setTime5( java.lang.String value ) {
		this.__time_5 = value;
	}

	public java.lang.String getTime6() {
		return this.__time_6;
	}

	public void setTime6( java.lang.String value ) {
		this.__time_6 = value;
	}

	public java.lang.String getTime7() {
		return this.__time_7;
	}

	public void setTime7( java.lang.String value ) {
		this.__time_7 = value;
	}

	public java.lang.String getTime8() {
		return this.__time_8;
	}

	public void setTime8( java.lang.String value ) {
		this.__time_8 = value;
	}

	public java.lang.String getTime9() {
		return this.__time_9;
	}

	public void setTime9( java.lang.String value ) {
		this.__time_9 = value;
	}

	public java.lang.String getTime10() {
		return this.__time_10;
	}

	public void setTime10( java.lang.String value ) {
		this.__time_10 = value;
	}

	public java.lang.String getTime11() {
		return this.__time_11;
	}

	public void setTime11( java.lang.String value ) {
		this.__time_11 = value;
	}

	public java.lang.String getTime12() {
		return this.__time_12;
	}

	public void setTime12( java.lang.String value ) {
		this.__time_12 = value;
	}

	public void cloneCopy(BaseMeetingRoomReservaTionRecordPaymentBase __bean){
		__bean.setMeetingRoomId(getMeetingRoomId());
		__bean.setMeetingRoomName(getMeetingRoomName());
		__bean.setSite(getSite());
		__bean.setContainNum(getContainNum());
		__bean.setMeetingMonthDate(getMeetingMonthDate());
		__bean.setTime2(getTime2());
		__bean.setTime3(getTime3());
		__bean.setTime4(getTime4());
		__bean.setTime5(getTime5());
		__bean.setTime6(getTime6());
		__bean.setTime7(getTime7());
		__bean.setTime8(getTime8());
		__bean.setTime9(getTime9());
		__bean.setTime10(getTime10());
		__bean.setTime11(getTime11());
		__bean.setTime12(getTime12());
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
		sb.append(getMeetingMonthDate() == null ? "" : sdf.format(getMeetingMonthDate()));
		sb.append(",");
		sb.append(getTime2() == null ? "" : getTime2());
		sb.append(",");
		sb.append(getTime3() == null ? "" : getTime3());
		sb.append(",");
		sb.append(getTime4() == null ? "" : getTime4());
		sb.append(",");
		sb.append(getTime5() == null ? "" : getTime5());
		sb.append(",");
		sb.append(getTime6() == null ? "" : getTime6());
		sb.append(",");
		sb.append(getTime7() == null ? "" : getTime7());
		sb.append(",");
		sb.append(getTime8() == null ? "" : getTime8());
		sb.append(",");
		sb.append(getTime9() == null ? "" : getTime9());
		sb.append(",");
		sb.append(getTime10() == null ? "" : getTime10());
		sb.append(",");
		sb.append(getTime11() == null ? "" : getTime11());
		sb.append(",");
		sb.append(getTime12() == null ? "" : getTime12());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingRoomReservaTionRecordPaymentBase o) {
		return __meeting_room_id == null ? -1 : __meeting_room_id.compareTo(o.getMeetingRoomId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_name);
		hash = 97 * hash + Objects.hashCode(this.__site);
		hash = 97 * hash + Objects.hashCode(this.__contain_num);
		hash = 97 * hash + Objects.hashCode(this.__meeting_month_date);
		hash = 97 * hash + Objects.hashCode(this.__time_2);
		hash = 97 * hash + Objects.hashCode(this.__time_3);
		hash = 97 * hash + Objects.hashCode(this.__time_4);
		hash = 97 * hash + Objects.hashCode(this.__time_5);
		hash = 97 * hash + Objects.hashCode(this.__time_6);
		hash = 97 * hash + Objects.hashCode(this.__time_7);
		hash = 97 * hash + Objects.hashCode(this.__time_8);
		hash = 97 * hash + Objects.hashCode(this.__time_9);
		hash = 97 * hash + Objects.hashCode(this.__time_10);
		hash = 97 * hash + Objects.hashCode(this.__time_11);
		hash = 97 * hash + Objects.hashCode(this.__time_12);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingRoomReservaTionRecordPaymentBase o = (BaseMeetingRoomReservaTionRecordPaymentBase)obj;
		if(!Objects.equals(this.__meeting_room_id, o.getMeetingRoomId())) return false;
		if(!Objects.equals(this.__meeting_room_name, o.getMeetingRoomName())) return false;
		if(!Objects.equals(this.__site, o.getSite())) return false;
		if(!Objects.equals(this.__contain_num, o.getContainNum())) return false;
		if(!Objects.equals(this.__meeting_month_date, o.getMeetingMonthDate())) return false;
		if(!Objects.equals(this.__time_2, o.getTime2())) return false;
		if(!Objects.equals(this.__time_3, o.getTime3())) return false;
		if(!Objects.equals(this.__time_4, o.getTime4())) return false;
		if(!Objects.equals(this.__time_5, o.getTime5())) return false;
		if(!Objects.equals(this.__time_6, o.getTime6())) return false;
		if(!Objects.equals(this.__time_7, o.getTime7())) return false;
		if(!Objects.equals(this.__time_8, o.getTime8())) return false;
		if(!Objects.equals(this.__time_9, o.getTime9())) return false;
		if(!Objects.equals(this.__time_10, o.getTime10())) return false;
		if(!Objects.equals(this.__time_11, o.getTime11())) return false;
		if(!Objects.equals(this.__time_12, o.getTime12())) return false;
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
		if(getMeetingMonthDate() != null) sb.append(__wrapDate(count++, "meetingMonthDate", getMeetingMonthDate()));
		if(getTime2() != null) sb.append(__wrapString(count++, "time2", getTime2()));
		if(getTime3() != null) sb.append(__wrapString(count++, "time3", getTime3()));
		if(getTime4() != null) sb.append(__wrapString(count++, "time4", getTime4()));
		if(getTime5() != null) sb.append(__wrapString(count++, "time5", getTime5()));
		if(getTime6() != null) sb.append(__wrapString(count++, "time6", getTime6()));
		if(getTime7() != null) sb.append(__wrapString(count++, "time7", getTime7()));
		if(getTime8() != null) sb.append(__wrapString(count++, "time8", getTime8()));
		if(getTime9() != null) sb.append(__wrapString(count++, "time9", getTime9()));
		if(getTime10() != null) sb.append(__wrapString(count++, "time10", getTime10()));
		if(getTime11() != null) sb.append(__wrapString(count++, "time11", getTime11()));
		if(getTime12() != null) sb.append(__wrapString(count++, "time12", getTime12()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRoomId() != null) res.put("meetingRoomId", getMeetingRoomId());
		if(getMeetingRoomName() != null) res.put("meetingRoomName", getMeetingRoomName());
		if(getSite() != null) res.put("site", getSite());
		if(getContainNum() != null) res.put("containNum", getContainNum());
		if(getMeetingMonthDate() != null) res.put("meetingMonthDate", getMeetingMonthDate());
		if(getTime2() != null) res.put("time2", getTime2());
		if(getTime3() != null) res.put("time3", getTime3());
		if(getTime4() != null) res.put("time4", getTime4());
		if(getTime5() != null) res.put("time5", getTime5());
		if(getTime6() != null) res.put("time6", getTime6());
		if(getTime7() != null) res.put("time7", getTime7());
		if(getTime8() != null) res.put("time8", getTime8());
		if(getTime9() != null) res.put("time9", getTime9());
		if(getTime10() != null) res.put("time10", getTime10());
		if(getTime11() != null) res.put("time11", getTime11());
		if(getTime12() != null) res.put("time12", getTime12());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val)); 
		if((val = values.get("meetingRoomName")) != null) setMeetingRoomName(__getString(val));
		if((val = values.get("site")) != null) setSite(__getString(val));
		if((val = values.get("containNum")) != null) setContainNum(__getInt(val)); 
		if((val = values.get("meetingMonthDate")) != null) setMeetingMonthDate(__getDate(val)); 
		if((val = values.get("time2")) != null) setTime2(__getString(val));
		if((val = values.get("time3")) != null) setTime3(__getString(val));
		if((val = values.get("time4")) != null) setTime4(__getString(val));
		if((val = values.get("time5")) != null) setTime5(__getString(val));
		if((val = values.get("time6")) != null) setTime6(__getString(val));
		if((val = values.get("time7")) != null) setTime7(__getString(val));
		if((val = values.get("time8")) != null) setTime8(__getString(val));
		if((val = values.get("time9")) != null) setTime9(__getString(val));
		if((val = values.get("time10")) != null) setTime10(__getString(val));
		if((val = values.get("time11")) != null) setTime11(__getString(val));
		if((val = values.get("time12")) != null) setTime12(__getString(val));
	}

	protected java.lang.Integer  __meeting_room_id ;
	protected java.lang.String  __meeting_room_name ;
	protected java.lang.String  __site ;
	protected java.lang.Integer  __contain_num ;
	protected java.util.Date  __meeting_month_date ;
	protected java.lang.String  __time_2 ;
	protected java.lang.String  __time_3 ;
	protected java.lang.String  __time_4 ;
	protected java.lang.String  __time_5 ;
	protected java.lang.String  __time_6 ;
	protected java.lang.String  __time_7 ;
	protected java.lang.String  __time_8 ;
	protected java.lang.String  __time_9 ;
	protected java.lang.String  __time_10 ;
	protected java.lang.String  __time_11 ;
	protected java.lang.String  __time_12 ;
}
