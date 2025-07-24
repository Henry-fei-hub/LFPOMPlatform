package delicacy.oa.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseMemployeeworkor extends GenericBase implements BaseFactory<BaseMemployeeworkor>, Comparable<BaseMemployeeworkor> 
{


	public static BaseMemployeeworkor newInstance(){
		return new BaseMemployeeworkor();
	}

	@Override
	public BaseMemployeeworkor make(){
		BaseMemployeeworkor b = new BaseMemployeeworkor();
		return b;
	}

	public final static java.lang.String CS_USERNAME = "userName" ;
	public final static java.lang.String CS_USERID = "userId" ;
	public final static java.lang.String CS_CLASSTYPENAME = "classTypeName" ;
	public final static java.lang.String CS_CHECKTYPE = "checkType" ;
	public final static java.lang.String CS_WORKNAME = "workName" ;
	public final static java.lang.String CS_ONDATE = "onDate" ;
	public final static java.lang.String CS_STOPDATE = "stopDate" ;
	public final static java.lang.String CS_CLASSTYPEID = "classTypeId" ;
	public final static java.lang.String CS_EMPLOYEEWORKID = "employeeWorkId" ;
	public final static java.lang.String CS_ORDERID = "orderId" ;
	public final static java.lang.String CS_SUNDAY = "sunday" ;
	public final static java.lang.String CS_MONDAY = "monday" ;
	public final static java.lang.String CS_TUESDAY = "tuesday" ;
	public final static java.lang.String CS_WEDNESDAY = "wednesday" ;
	public final static java.lang.String CS_THURSDAY = "thursday" ;
	public final static java.lang.String CS_FRIDAY = "friday" ;
	public final static java.lang.String CS_SATURDAY = "saturday" ;
	public final static java.lang.String CS_TIMEPARAGRAPHID = "timeParagraphId" ;

	public final static java.lang.String ALL_CAPTIONS = "userName,userId,classTypeName,checkType,workName,onDate,stopDate,classTypeId,employeeWorkId,orderId,sunday,monday,tuesday,wednesday,thursday,friday,saturday,timeParagraphId";

	public java.lang.String getUsername() {
		return this.__username;
	}

	public void setUsername( java.lang.String value ) {
		this.__username = value;
	}

	public java.lang.String getUserid() {
		return this.__userid;
	}

	public void setUserid( java.lang.String value ) {
		this.__userid = value;
	}

	public java.lang.String getClasstypename() {
		return this.__classtypename;
	}

	public void setClasstypename( java.lang.String value ) {
		this.__classtypename = value;
	}

	public java.lang.String getChecktype() {
		return this.__checktype;
	}

	public void setChecktype( java.lang.String value ) {
		this.__checktype = value;
	}

	public java.lang.String getWorkname() {
		return this.__workname;
	}

	public void setWorkname( java.lang.String value ) {
		this.__workname = value;
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

	public java.lang.Long getClasstypeid() {
		return this.__classtypeid;
	}

	public void setClasstypeid( java.lang.Long value ) {
		this.__classtypeid = value;
	}

	public java.lang.Long getEmployeeworkid() {
		return this.__employeeworkid;
	}

	public void setEmployeeworkid( java.lang.Long value ) {
		this.__employeeworkid = value;
	}

	public java.lang.Integer getOrderid() {
		return this.__orderid;
	}

	public void setOrderid( java.lang.Integer value ) {
		this.__orderid = value;
	}

	public java.lang.Byte getSunday() {
		return this.__sunday;
	}

	public void setSunday( java.lang.Byte value ) {
		this.__sunday = value;
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

	public java.lang.Long getTimeparagraphid() {
		return this.__timeparagraphid;
	}

	public void setTimeparagraphid( java.lang.Long value ) {
		this.__timeparagraphid = value;
	}

	public void cloneCopy(BaseMemployeeworkor __bean){
		__bean.setUsername(getUsername());
		__bean.setUserid(getUserid());
		__bean.setClasstypename(getClasstypename());
		__bean.setChecktype(getChecktype());
		__bean.setWorkname(getWorkname());
		__bean.setOndate(getOndate());
		__bean.setStopdate(getStopdate());
		__bean.setClasstypeid(getClasstypeid());
		__bean.setEmployeeworkid(getEmployeeworkid());
		__bean.setOrderid(getOrderid());
		__bean.setSunday(getSunday());
		__bean.setMonday(getMonday());
		__bean.setTuesday(getTuesday());
		__bean.setWednesday(getWednesday());
		__bean.setThursday(getThursday());
		__bean.setFriday(getFriday());
		__bean.setSaturday(getSaturday());
		__bean.setTimeparagraphid(getTimeparagraphid());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getUsername() == null ? "" : getUsername());
		sb.append(",");
		sb.append(getUserid() == null ? "" : getUserid());
		sb.append(",");
		sb.append(getClasstypename() == null ? "" : getClasstypename());
		sb.append(",");
		sb.append(getChecktype() == null ? "" : getChecktype());
		sb.append(",");
		sb.append(getWorkname() == null ? "" : getWorkname());
		sb.append(",");
		sb.append(getOndate() == null ? "" : sdf.format(getOndate()));
		sb.append(",");
		sb.append(getStopdate() == null ? "" : sdf.format(getStopdate()));
		sb.append(",");
		sb.append(getClasstypeid() == null ? "" : getClasstypeid());
		sb.append(",");
		sb.append(getEmployeeworkid() == null ? "" : getEmployeeworkid());
		sb.append(",");
		sb.append(getOrderid() == null ? "" : getOrderid());
		sb.append(",");
		sb.append(getSunday() == null ? "" : getSunday());
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
		sb.append(getTimeparagraphid() == null ? "" : getTimeparagraphid());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeeworkor o) {
		return __username == null ? -1 : __username.compareTo(o.getUsername());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__username);
		hash = 97 * hash + Objects.hashCode(this.__userid);
		hash = 97 * hash + Objects.hashCode(this.__classtypename);
		hash = 97 * hash + Objects.hashCode(this.__checktype);
		hash = 97 * hash + Objects.hashCode(this.__workname);
		hash = 97 * hash + Objects.hashCode(this.__ondate);
		hash = 97 * hash + Objects.hashCode(this.__stopdate);
		hash = 97 * hash + Objects.hashCode(this.__classtypeid);
		hash = 97 * hash + Objects.hashCode(this.__employeeworkid);
		hash = 97 * hash + Objects.hashCode(this.__orderid);
		hash = 97 * hash + Objects.hashCode(this.__sunday);
		hash = 97 * hash + Objects.hashCode(this.__monday);
		hash = 97 * hash + Objects.hashCode(this.__tuesday);
		hash = 97 * hash + Objects.hashCode(this.__wednesday);
		hash = 97 * hash + Objects.hashCode(this.__thursday);
		hash = 97 * hash + Objects.hashCode(this.__friday);
		hash = 97 * hash + Objects.hashCode(this.__saturday);
		hash = 97 * hash + Objects.hashCode(this.__timeparagraphid);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeeworkor o = (BaseMemployeeworkor)obj;
		if(!Objects.equals(this.__username, o.getUsername())) return false;
		if(!Objects.equals(this.__userid, o.getUserid())) return false;
		if(!Objects.equals(this.__classtypename, o.getClasstypename())) return false;
		if(!Objects.equals(this.__checktype, o.getChecktype())) return false;
		if(!Objects.equals(this.__workname, o.getWorkname())) return false;
		if(!Objects.equals(this.__ondate, o.getOndate())) return false;
		if(!Objects.equals(this.__stopdate, o.getStopdate())) return false;
		if(!Objects.equals(this.__classtypeid, o.getClasstypeid())) return false;
		if(!Objects.equals(this.__employeeworkid, o.getEmployeeworkid())) return false;
		if(!Objects.equals(this.__orderid, o.getOrderid())) return false;
		if(!Objects.equals(this.__sunday, o.getSunday())) return false;
		if(!Objects.equals(this.__monday, o.getMonday())) return false;
		if(!Objects.equals(this.__tuesday, o.getTuesday())) return false;
		if(!Objects.equals(this.__wednesday, o.getWednesday())) return false;
		if(!Objects.equals(this.__thursday, o.getThursday())) return false;
		if(!Objects.equals(this.__friday, o.getFriday())) return false;
		if(!Objects.equals(this.__saturday, o.getSaturday())) return false;
		if(!Objects.equals(this.__timeparagraphid, o.getTimeparagraphid())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getUsername() != null) sb.append(__wrapString(count++, "username", getUsername()));
		if(getUserid() != null) sb.append(__wrapString(count++, "userid", getUserid()));
		if(getClasstypename() != null) sb.append(__wrapString(count++, "classtypename", getClasstypename()));
		if(getChecktype() != null) sb.append(__wrapString(count++, "checktype", getChecktype()));
		if(getWorkname() != null) sb.append(__wrapString(count++, "workname", getWorkname()));
		if(getOndate() != null) sb.append(__wrapDate(count++, "ondate", getOndate()));
		if(getStopdate() != null) sb.append(__wrapDate(count++, "stopdate", getStopdate()));
		if(getClasstypeid() != null) sb.append(__wrapNumber(count++, "classtypeid", getClasstypeid()));
		if(getEmployeeworkid() != null) sb.append(__wrapNumber(count++, "employeeworkid", getEmployeeworkid()));
		if(getOrderid() != null) sb.append(__wrapNumber(count++, "orderid", getOrderid()));
		if(getSunday() != null) sb.append(__wrapNumber(count++, "sunday", getSunday()));
		if(getMonday() != null) sb.append(__wrapNumber(count++, "monday", getMonday()));
		if(getTuesday() != null) sb.append(__wrapNumber(count++, "tuesday", getTuesday()));
		if(getWednesday() != null) sb.append(__wrapNumber(count++, "wednesday", getWednesday()));
		if(getThursday() != null) sb.append(__wrapNumber(count++, "thursday", getThursday()));
		if(getFriday() != null) sb.append(__wrapNumber(count++, "friday", getFriday()));
		if(getSaturday() != null) sb.append(__wrapNumber(count++, "saturday", getSaturday()));
		if(getTimeparagraphid() != null) sb.append(__wrapNumber(count++, "timeparagraphid", getTimeparagraphid()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("username")) != null) setUsername(__getString(val));
		if((val = values.get("userid")) != null) setUserid(__getString(val));
		if((val = values.get("classtypename")) != null) setClasstypename(__getString(val));
		if((val = values.get("checktype")) != null) setChecktype(__getString(val));
		if((val = values.get("workname")) != null) setWorkname(__getString(val));
		if((val = values.get("ondate")) != null) setOndate(__getDate(val)); 
		if((val = values.get("stopdate")) != null) setStopdate(__getDate(val)); 
		if((val = values.get("classtypeid")) != null) setClasstypeid(__getLong(val)); 
		if((val = values.get("employeeworkid")) != null) setEmployeeworkid(__getLong(val)); 
		if((val = values.get("orderid")) != null) setOrderid(__getInt(val)); 
		if((val = values.get("sunday")) != null) setSunday(__getByte(val));  
		if((val = values.get("monday")) != null) setMonday(__getByte(val));  
		if((val = values.get("tuesday")) != null) setTuesday(__getByte(val));  
		if((val = values.get("wednesday")) != null) setWednesday(__getByte(val));  
		if((val = values.get("thursday")) != null) setThursday(__getByte(val));  
		if((val = values.get("friday")) != null) setFriday(__getByte(val));  
		if((val = values.get("saturday")) != null) setSaturday(__getByte(val));  
		if((val = values.get("timeparagraphid")) != null) setTimeparagraphid(__getLong(val)); 
	}

	protected java.lang.String  __username ;
	protected java.lang.String  __userid ;
	protected java.lang.String  __classtypename ;
	protected java.lang.String  __checktype ;
	protected java.lang.String  __workname ;
	protected java.util.Date  __ondate ;
	protected java.util.Date  __stopdate ;
	protected java.lang.Long  __classtypeid ;
	protected java.lang.Long  __employeeworkid ;
	protected java.lang.Integer  __orderid ;
	protected java.lang.Byte  __sunday ;
	protected java.lang.Byte  __monday ;
	protected java.lang.Byte  __tuesday ;
	protected java.lang.Byte  __wednesday ;
	protected java.lang.Byte  __thursday ;
	protected java.lang.Byte  __friday ;
	protected java.lang.Byte  __saturday ;
	protected java.lang.Long  __timeparagraphid ;
}
