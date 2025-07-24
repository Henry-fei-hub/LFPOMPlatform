package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetShiftInfoByEmployeeId extends GenericBase implements BaseFactory<BaseGetShiftInfoByEmployeeId>, Comparable<BaseGetShiftInfoByEmployeeId> 
{


	public static BaseGetShiftInfoByEmployeeId newInstance(){
		return new BaseGetShiftInfoByEmployeeId();
	}

	@Override
	public BaseGetShiftInfoByEmployeeId make(){
		BaseGetShiftInfoByEmployeeId b = new BaseGetShiftInfoByEmployeeId();
		return b;
	}

	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_SHIFT_TIME_MANAGE_ID = "shift_time_manage_id" ;
	public final static java.lang.String CS_WEEK_DAY = "week_day" ;
	public final static java.lang.String CS_SIGN_IN_TIME = "sign_in_time" ;
	public final static java.lang.String CS_SIGN_OFF_TIME = "sign_off_time" ;

	public final static java.lang.String ALL_CAPTIONS = "已排班日期,时段id,星期几,上班时间,下班时间";

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getShiftTimeManageId() {
		return this.__shift_time_manage_id;
	}

	public void setShiftTimeManageId( java.lang.Integer value ) {
		this.__shift_time_manage_id = value;
	}

	public java.lang.Integer getWeekDay() {
		return this.__week_day;
	}

	public void setWeekDay( java.lang.Integer value ) {
		this.__week_day = value;
	}

	public java.lang.String getSignInTime() {
		return this.__sign_in_time;
	}

	public void setSignInTime( java.lang.String value ) {
		this.__sign_in_time = value;
	}

	public java.lang.String getSignOffTime() {
		return this.__sign_off_time;
	}

	public void setSignOffTime( java.lang.String value ) {
		this.__sign_off_time = value;
	}

	public void cloneCopy(BaseGetShiftInfoByEmployeeId __bean){
		__bean.setRecordDate(getRecordDate());
		__bean.setShiftTimeManageId(getShiftTimeManageId());
		__bean.setWeekDay(getWeekDay());
		__bean.setSignInTime(getSignInTime());
		__bean.setSignOffTime(getSignOffTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getShiftTimeManageId() == null ? "" : getShiftTimeManageId());
		sb.append(",");
		sb.append(getWeekDay() == null ? "" : getWeekDay());
		sb.append(",");
		sb.append(getSignInTime() == null ? "" : getSignInTime());
		sb.append(",");
		sb.append(getSignOffTime() == null ? "" : getSignOffTime());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetShiftInfoByEmployeeId o) {
		return __record_date == null ? -1 : __record_date.compareTo(o.getRecordDate());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__shift_time_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__week_day);
		hash = 97 * hash + Objects.hashCode(this.__sign_in_time);
		hash = 97 * hash + Objects.hashCode(this.__sign_off_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetShiftInfoByEmployeeId o = (BaseGetShiftInfoByEmployeeId)obj;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__shift_time_manage_id, o.getShiftTimeManageId())) return false;
		if(!Objects.equals(this.__week_day, o.getWeekDay())) return false;
		if(!Objects.equals(this.__sign_in_time, o.getSignInTime())) return false;
		if(!Objects.equals(this.__sign_off_time, o.getSignOffTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getShiftTimeManageId() != null) sb.append(__wrapNumber(count++, "shiftTimeManageId", getShiftTimeManageId()));
		if(getWeekDay() != null) sb.append(__wrapNumber(count++, "weekDay", getWeekDay()));
		if(getSignInTime() != null) sb.append(__wrapString(count++, "signInTime", getSignInTime()));
		if(getSignOffTime() != null) sb.append(__wrapString(count++, "signOffTime", getSignOffTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("shiftTimeManageId")) != null) setShiftTimeManageId(__getInt(val)); 
		if((val = values.get("weekDay")) != null) setWeekDay(__getInt(val)); 
		if((val = values.get("signInTime")) != null) setSignInTime(__getString(val));
		if((val = values.get("signOffTime")) != null) setSignOffTime(__getString(val));
	}

	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __shift_time_manage_id ;
	protected java.lang.Integer  __week_day ;
	protected java.lang.String  __sign_in_time ;
	protected java.lang.String  __sign_off_time ;
}
