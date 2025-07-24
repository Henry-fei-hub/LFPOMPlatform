package pomplatform.shift.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttendanceCheckinoutData extends GenericBase implements BaseFactory<BaseAttendanceCheckinoutData>, Comparable<BaseAttendanceCheckinoutData> 
{


	public static BaseAttendanceCheckinoutData newInstance(){
		return new BaseAttendanceCheckinoutData();
	}

	@Override
	public BaseAttendanceCheckinoutData make(){
		BaseAttendanceCheckinoutData b = new BaseAttendanceCheckinoutData();
		return b;
	}

	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_CHECK_DATE = "check_date" ;
	public final static String CS_CHECKIN_TIME = "checkin_time" ;
	public final static String CS_CHECKOUT_TIME = "checkout_time" ;
	public final static String CS_LAST_CHECKOUT_TIME = "last_checkout_time" ;

	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_CHECK_DATE = "checkDate" ;
	public final static String NAME_CHECKIN_TIME = "checkinTime" ;
	public final static String NAME_CHECKOUT_TIME = "checkoutTime" ;
	public final static String NAME_LAST_CHECKOUT_TIME = "lastCheckoutTime" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,考勤日期,,,";

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

	public java.util.Date getCheckinTime() {
		return this.__checkin_time;
	}

	public void setCheckinTime( java.util.Date value ) {
		this.__checkin_time = value;
	}

	public java.util.Date getCheckoutTime() {
		return this.__checkout_time;
	}

	public void setCheckoutTime( java.util.Date value ) {
		this.__checkout_time = value;
	}

	public java.util.Date getLastCheckoutTime() {
		return this.__last_checkout_time;
	}

	public void setLastCheckoutTime( java.util.Date value ) {
		this.__last_checkout_time = value;
	}

	public static String getKeyColumnName() {
		String name ="";
		return name;
	}

	public void cloneCopy(BaseAttendanceCheckinoutData __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCheckDate(getCheckDate());
		__bean.setCheckinTime(getCheckinTime());
		__bean.setCheckoutTime(getCheckoutTime());
		__bean.setLastCheckoutTime(getLastCheckoutTime());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCheckDate() == null ? "" : sdf.format(getCheckDate()));
		sb.append(",");
		sb.append(getCheckinTime() == null ? "" : sdf.format(getCheckinTime()));
		sb.append(",");
		sb.append(getCheckoutTime() == null ? "" : sdf.format(getCheckoutTime()));
		sb.append(",");
		sb.append(getLastCheckoutTime() == null ? "" : sdf.format(getLastCheckoutTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttendanceCheckinoutData o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__check_date);
		hash = 97 * hash + Objects.hashCode(this.__checkin_time);
		hash = 97 * hash + Objects.hashCode(this.__checkout_time);
		hash = 97 * hash + Objects.hashCode(this.__last_checkout_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttendanceCheckinoutData o = (BaseAttendanceCheckinoutData)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__check_date, o.getCheckDate())) return false;
		if(!Objects.equals(this.__checkin_time, o.getCheckinTime())) return false;
		if(!Objects.equals(this.__checkout_time, o.getCheckoutTime())) return false;
		if(!Objects.equals(this.__last_checkout_time, o.getLastCheckoutTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		return toJSONString(false);
	}

	@Override
	public java.lang.String toJSONString(boolean outDefault) {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getCheckDate() != null || outDefault) sb.append(__wrapDate(count++, NAME_CHECK_DATE, getCheckDate()));
		if(getCheckinTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_CHECKIN_TIME, getCheckinTime()));
		if(getCheckoutTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_CHECKOUT_TIME, getCheckoutTime()));
		if(getLastCheckoutTime() != null || outDefault) sb.append(__wrapDate(count++, NAME_LAST_CHECKOUT_TIME, getLastCheckoutTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getCheckDate() != null) res.put(NAME_CHECK_DATE, getCheckDate());
		if(getCheckinTime() != null) res.put(NAME_CHECKIN_TIME, getCheckinTime());
		if(getCheckoutTime() != null) res.put(NAME_CHECKOUT_TIME, getCheckoutTime());
		if(getLastCheckoutTime() != null) res.put(NAME_LAST_CHECKOUT_TIME, getLastCheckoutTime());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseAttendanceCheckinoutData> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseAttendanceCheckinoutData b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_CHECK_DATE) && (val = values.get(NAME_CHECK_DATE)) != null) setCheckDate(__getDate(val)); 
		if(values.containsKey(NAME_CHECKIN_TIME) && (val = values.get(NAME_CHECKIN_TIME)) != null) setCheckinTime(__getDate(val)); 
		if(values.containsKey(NAME_CHECKOUT_TIME) && (val = values.get(NAME_CHECKOUT_TIME)) != null) setCheckoutTime(__getDate(val)); 
		if(values.containsKey(NAME_LAST_CHECKOUT_TIME) && (val = values.get(NAME_LAST_CHECKOUT_TIME)) != null) setLastCheckoutTime(__getDate(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __check_date ;
	protected java.util.Date  __checkin_time ;
	protected java.util.Date  __checkout_time ;
	protected java.util.Date  __last_checkout_time ;
}
