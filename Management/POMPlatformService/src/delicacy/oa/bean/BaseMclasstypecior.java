package delicacy.oa.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseMclasstypecior extends GenericBase implements BaseFactory<BaseMclasstypecior>, Comparable<BaseMclasstypecior> 
{


	public static BaseMclasstypecior newInstance(){
		return new BaseMclasstypecior();
	}

	@Override
	public BaseMclasstypecior make(){
		BaseMclasstypecior b = new BaseMclasstypecior();
		return b;
	}

	public final static java.lang.String CS_ID = "id" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_ONDATE = "onDate" ;
	public final static java.lang.String CS_CYCLENUMBER = "cycleNumber" ;
	public final static java.lang.String CS_CYCLEUNIT = "cycleUnit" ;
	public final static java.lang.String CS_ORDERID = "orderId" ;
	public final static java.lang.String CS_SUNDAY = "sunday" ;
	public final static java.lang.String CS_MONDAY = "monday" ;
	public final static java.lang.String CS_TUESDAY = "tuesday" ;
	public final static java.lang.String CS_WEDNESDAY = "wednesday" ;
	public final static java.lang.String CS_THURSDAY = "thursday" ;
	public final static java.lang.String CS_FRIDAY = "friday" ;
	public final static java.lang.String CS_SATURDAY = "saturday" ;
	public final static java.lang.String CS_TIMEPARAGRAPHID = "timeParagraphId" ;

	public final static java.lang.String ALL_CAPTIONS = "id,name,onDate,cycleNumber,cycleUnit,orderId,sunday,monday,tuesday,wednesday,thursday,friday,saturday,timeParagraphId";

	public java.lang.Long getId() {
		return this.__id;
	}

	public void setId( java.lang.Long value ) {
		this.__id = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.util.Date getOndate() {
		return this.__ondate;
	}

	public void setOndate( java.util.Date value ) {
		this.__ondate = value;
	}

	public java.lang.Long getCyclenumber() {
		return this.__cyclenumber;
	}

	public void setCyclenumber( java.lang.Long value ) {
		this.__cyclenumber = value;
	}

	public java.lang.String getCycleunit() {
		return this.__cycleunit;
	}

	public void setCycleunit( java.lang.String value ) {
		this.__cycleunit = value;
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

	public void cloneCopy(BaseMclasstypecior __bean){
		__bean.setId(getId());
		__bean.setName(getName());
		__bean.setOndate(getOndate());
		__bean.setCyclenumber(getCyclenumber());
		__bean.setCycleunit(getCycleunit());
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
		sb.append(getId() == null ? "" : getId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getOndate() == null ? "" : sdf.format(getOndate()));
		sb.append(",");
		sb.append(getCyclenumber() == null ? "" : getCyclenumber());
		sb.append(",");
		sb.append(getCycleunit() == null ? "" : getCycleunit());
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
	public int compareTo(BaseMclasstypecior o) {
		return __id == null ? -1 : __id.compareTo(o.getId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__ondate);
		hash = 97 * hash + Objects.hashCode(this.__cyclenumber);
		hash = 97 * hash + Objects.hashCode(this.__cycleunit);
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
		final BaseMclasstypecior o = (BaseMclasstypecior)obj;
		if(!Objects.equals(this.__id, o.getId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__ondate, o.getOndate())) return false;
		if(!Objects.equals(this.__cyclenumber, o.getCyclenumber())) return false;
		if(!Objects.equals(this.__cycleunit, o.getCycleunit())) return false;
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
		if(getId() != null) sb.append(__wrapNumber(count++, "id", getId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getOndate() != null) sb.append(__wrapDate(count++, "ondate", getOndate()));
		if(getCyclenumber() != null) sb.append(__wrapNumber(count++, "cyclenumber", getCyclenumber()));
		if(getCycleunit() != null) sb.append(__wrapString(count++, "cycleunit", getCycleunit()));
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
		if((val = values.get("id")) != null) setId(__getLong(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("ondate")) != null) setOndate(__getDate(val)); 
		if((val = values.get("cyclenumber")) != null) setCyclenumber(__getLong(val)); 
		if((val = values.get("cycleunit")) != null) setCycleunit(__getString(val));
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

	protected java.lang.Long  __id ;
	protected java.lang.String  __name ;
	protected java.util.Date  __ondate ;
	protected java.lang.Long  __cyclenumber ;
	protected java.lang.String  __cycleunit ;
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
