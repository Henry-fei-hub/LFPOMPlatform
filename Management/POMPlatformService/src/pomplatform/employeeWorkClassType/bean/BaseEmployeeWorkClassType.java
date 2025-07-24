package pomplatform.employeeWorkClassType.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeWorkClassType extends GenericBase implements BaseFactory<BaseEmployeeWorkClassType>, Comparable<BaseEmployeeWorkClassType> 
{


	public static BaseEmployeeWorkClassType newInstance(){
		return new BaseEmployeeWorkClassType();
	}

	@Override
	public BaseEmployeeWorkClassType make(){
		BaseEmployeeWorkClassType b = new BaseEmployeeWorkClassType();
		return b;
	}

	public final static java.lang.String CS_USERID = "userId" ;
	public final static java.lang.String CS_CLASSTYPEID = "classTypeId" ;
	public final static java.lang.String CS_ONDATE = "onDate" ;
	public final static java.lang.String CS_STOPDATE = "stopDate" ;
	public final static java.lang.String CS_ONTIME = "onTime" ;
	public final static java.lang.String CS_OFFTIME = "offTime" ;
	public final static java.lang.String CS_MONDAY = "monday" ;
	public final static java.lang.String CS_TUESDAY = "tuesday" ;
	public final static java.lang.String CS_WEDNESDAY = "wednesday" ;
	public final static java.lang.String CS_THURSDAY = "thursday" ;
	public final static java.lang.String CS_FRIDAY = "friday" ;
	public final static java.lang.String CS_SATURDAY = "saturday" ;
	public final static java.lang.String CS_SUNDAY = "sunday" ;

	public final static java.lang.String ALL_CAPTIONS = "userId,classTypeId,onDate,stopDate,onTime,offTime,monday,tuesday,wednesday,thursday,friday,saturday,sunday";

	public java.lang.String getUserid() {
		return this.__userid;
	}

	public void setUserid( java.lang.String value ) {
		this.__userid = value;
	}

	public java.lang.Long getClasstypeid() {
		return this.__classtypeid;
	}

	public void setClasstypeid( java.lang.Long value ) {
		this.__classtypeid = value;
	}

	public java.util.Date getOndate() {
		return this.__ondate;
	}

	public void setOndate( java.util.Date value ) {
		this.__ondate = value;
	}

	public java.util.Date getStopdate() {
		return this.__stopdate;
	}

	public void setStopdate( java.util.Date value ) {
		this.__stopdate = value;
	}

	public java.lang.String getOntime() {
		return this.__ontime;
	}

	public void setOntime( java.lang.String value ) {
		this.__ontime = value;
	}

	public java.lang.String getOfftime() {
		return this.__offtime;
	}

	public void setOfftime( java.lang.String value ) {
		this.__offtime = value;
	}

	public java.lang.Byte getMonday() {
		return this.__monday;
	}

	public void setMonday( java.lang.Byte value ) {
		this.__monday = value;
	}

	public java.lang.Byte getTuesday() {
		return this.__tuesday;
	}

	public void setTuesday( java.lang.Byte value ) {
		this.__tuesday = value;
	}

	public java.lang.Byte getWednesday() {
		return this.__wednesday;
	}

	public void setWednesday( java.lang.Byte value ) {
		this.__wednesday = value;
	}

	public java.lang.Byte getThursday() {
		return this.__thursday;
	}

	public void setThursday( java.lang.Byte value ) {
		this.__thursday = value;
	}

	public java.lang.Byte getFriday() {
		return this.__friday;
	}

	public void setFriday( java.lang.Byte value ) {
		this.__friday = value;
	}

	public java.lang.Byte getSaturday() {
		return this.__saturday;
	}

	public void setSaturday( java.lang.Byte value ) {
		this.__saturday = value;
	}

	public java.lang.Byte getSunday() {
		return this.__sunday;
	}

	public void setSunday( java.lang.Byte value ) {
		this.__sunday = value;
	}

	public void cloneCopy(BaseEmployeeWorkClassType __bean){
		__bean.setUserid(getUserid());
		__bean.setClasstypeid(getClasstypeid());
		__bean.setOndate(getOndate());
		__bean.setStopdate(getStopdate());
		__bean.setOntime(getOntime());
		__bean.setOfftime(getOfftime());
		__bean.setMonday(getMonday());
		__bean.setTuesday(getTuesday());
		__bean.setWednesday(getWednesday());
		__bean.setThursday(getThursday());
		__bean.setFriday(getFriday());
		__bean.setSaturday(getSaturday());
		__bean.setSunday(getSunday());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getUserid() == null ? "" : getUserid());
		sb.append(",");
		sb.append(getClasstypeid() == null ? "" : getClasstypeid());
		sb.append(",");
		sb.append(getOndate() == null ? "" : sdf.format(getOndate()));
		sb.append(",");
		sb.append(getStopdate() == null ? "" : sdf.format(getStopdate()));
		sb.append(",");
		sb.append(getOntime() == null ? "" : getOntime());
		sb.append(",");
		sb.append(getOfftime() == null ? "" : getOfftime());
		sb.append(",");
		sb.append(getMonday() == null ? "" : getMonday());
		sb.append(",");
		sb.append(getTuesday() == null ? "" : getTuesday());
		sb.append(",");
		sb.append(getWednesday() == null ? "" : getWednesday());
		sb.append(",");
		sb.append(getThursday() == null ? "" : getThursday());
		sb.append(",");
		sb.append(getFriday() == null ? "" : getFriday());
		sb.append(",");
		sb.append(getSaturday() == null ? "" : getSaturday());
		sb.append(",");
		sb.append(getSunday() == null ? "" : getSunday());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeWorkClassType o) {
		return __userid == null ? -1 : __userid.compareTo(o.getUserid());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__userid);
		hash = 97 * hash + Objects.hashCode(this.__classtypeid);
		hash = 97 * hash + Objects.hashCode(this.__ondate);
		hash = 97 * hash + Objects.hashCode(this.__stopdate);
		hash = 97 * hash + Objects.hashCode(this.__ontime);
		hash = 97 * hash + Objects.hashCode(this.__offtime);
		hash = 97 * hash + Objects.hashCode(this.__monday);
		hash = 97 * hash + Objects.hashCode(this.__tuesday);
		hash = 97 * hash + Objects.hashCode(this.__wednesday);
		hash = 97 * hash + Objects.hashCode(this.__thursday);
		hash = 97 * hash + Objects.hashCode(this.__friday);
		hash = 97 * hash + Objects.hashCode(this.__saturday);
		hash = 97 * hash + Objects.hashCode(this.__sunday);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeWorkClassType o = (BaseEmployeeWorkClassType)obj;
		if(!Objects.equals(this.__userid, o.getUserid())) return false;
		if(!Objects.equals(this.__classtypeid, o.getClasstypeid())) return false;
		if(!Objects.equals(this.__ondate, o.getOndate())) return false;
		if(!Objects.equals(this.__stopdate, o.getStopdate())) return false;
		if(!Objects.equals(this.__ontime, o.getOntime())) return false;
		if(!Objects.equals(this.__offtime, o.getOfftime())) return false;
		if(!Objects.equals(this.__monday, o.getMonday())) return false;
		if(!Objects.equals(this.__tuesday, o.getTuesday())) return false;
		if(!Objects.equals(this.__wednesday, o.getWednesday())) return false;
		if(!Objects.equals(this.__thursday, o.getThursday())) return false;
		if(!Objects.equals(this.__friday, o.getFriday())) return false;
		if(!Objects.equals(this.__saturday, o.getSaturday())) return false;
		if(!Objects.equals(this.__sunday, o.getSunday())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getUserid() != null) sb.append(__wrapString(count++, "userid", getUserid()));
		if(getClasstypeid() != null) sb.append(__wrapNumber(count++, "classtypeid", getClasstypeid()));
		if(getOndate() != null) sb.append(__wrapDate(count++, "ondate", getOndate()));
		if(getStopdate() != null) sb.append(__wrapDate(count++, "stopdate", getStopdate()));
		if(getOntime() != null) sb.append(__wrapString(count++, "ontime", getOntime()));
		if(getOfftime() != null) sb.append(__wrapString(count++, "offtime", getOfftime()));
		if(getMonday() != null) sb.append(__wrapNumber(count++, "monday", getMonday()));
		if(getTuesday() != null) sb.append(__wrapNumber(count++, "tuesday", getTuesday()));
		if(getWednesday() != null) sb.append(__wrapNumber(count++, "wednesday", getWednesday()));
		if(getThursday() != null) sb.append(__wrapNumber(count++, "thursday", getThursday()));
		if(getFriday() != null) sb.append(__wrapNumber(count++, "friday", getFriday()));
		if(getSaturday() != null) sb.append(__wrapNumber(count++, "saturday", getSaturday()));
		if(getSunday() != null) sb.append(__wrapNumber(count++, "sunday", getSunday()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("userid")) != null) setUserid(__getString(val));
		if((val = values.get("classtypeid")) != null) setClasstypeid(__getLong(val)); 
		if((val = values.get("ondate")) != null) setOndate(__getDate(val)); 
		if((val = values.get("stopdate")) != null) setStopdate(__getDate(val)); 
		if((val = values.get("ontime")) != null) setOntime(__getString(val));
		if((val = values.get("offtime")) != null) setOfftime(__getString(val));
		if((val = values.get("monday")) != null) setMonday(__getByte(val));  
		if((val = values.get("tuesday")) != null) setTuesday(__getByte(val));  
		if((val = values.get("wednesday")) != null) setWednesday(__getByte(val));  
		if((val = values.get("thursday")) != null) setThursday(__getByte(val));  
		if((val = values.get("friday")) != null) setFriday(__getByte(val));  
		if((val = values.get("saturday")) != null) setSaturday(__getByte(val));  
		if((val = values.get("sunday")) != null) setSunday(__getByte(val));  
	}

	protected java.lang.String  __userid ;
	protected java.lang.Long  __classtypeid ;
	protected java.util.Date  __ondate ;
	protected java.util.Date  __stopdate ;
	protected java.lang.String  __ontime ;
	protected java.lang.String  __offtime ;
	protected java.lang.Byte  __monday ;
	protected java.lang.Byte  __tuesday ;
	protected java.lang.Byte  __wednesday ;
	protected java.lang.Byte  __thursday ;
	protected java.lang.Byte  __friday ;
	protected java.lang.Byte  __saturday ;
	protected java.lang.Byte  __sunday ;
}
