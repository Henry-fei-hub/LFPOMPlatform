package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSerialNumber extends GenericBase implements BaseFactory<BaseSerialNumber>, Comparable<BaseSerialNumber> 
{


	public static BaseSerialNumber newInstance(){
		return new BaseSerialNumber();
	}

	@Override
	public BaseSerialNumber make(){
		BaseSerialNumber b = new BaseSerialNumber();
		return b;
	}

	public final static java.lang.String CS_SERIAL_NUMBER_ID = "serial_number_id" ;
	public final static java.lang.String CS_SERIAL_TYPE = "serial_type" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_DAY = "day" ;
	public final static java.lang.String CS_SERIAL_NUMBER = "serial_number" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,类型1项目和合同编号模块,年份,月份,日,序列值,操作时间,备注";

	public java.lang.Integer getSerialNumberId() {
		return this.__serial_number_id;
	}

	public void setSerialNumberId( java.lang.Integer value ) {
		this.__serial_number_id = value;
	}

	public java.lang.Integer getSerialType() {
		return this.__serial_type;
	}

	public void setSerialType( java.lang.Integer value ) {
		this.__serial_type = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getDay() {
		return this.__day;
	}

	public void setDay( java.lang.Integer value ) {
		this.__day = value;
	}

	public java.lang.Integer getSerialNumber() {
		return this.__serial_number;
	}

	public void setSerialNumber( java.lang.Integer value ) {
		this.__serial_number = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSerialNumber __bean){
		__bean.setSerialNumberId(getSerialNumberId());
		__bean.setSerialType(getSerialType());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setDay(getDay());
		__bean.setSerialNumber(getSerialNumber());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSerialNumberId() == null ? "" : getSerialNumberId());
		sb.append(",");
		sb.append(getSerialType() == null ? "" : getSerialType());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getDay() == null ? "" : getDay());
		sb.append(",");
		sb.append(getSerialNumber() == null ? "" : getSerialNumber());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSerialNumber o) {
		return __serial_number_id == null ? -1 : __serial_number_id.compareTo(o.getSerialNumberId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__serial_number_id);
		hash = 97 * hash + Objects.hashCode(this.__serial_type);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__day);
		hash = 97 * hash + Objects.hashCode(this.__serial_number);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSerialNumber o = (BaseSerialNumber)obj;
		if(!Objects.equals(this.__serial_number_id, o.getSerialNumberId())) return false;
		if(!Objects.equals(this.__serial_type, o.getSerialType())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__day, o.getDay())) return false;
		if(!Objects.equals(this.__serial_number, o.getSerialNumber())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSerialNumberId() != null) sb.append(__wrapNumber(count++, "serialNumberId", getSerialNumberId()));
		if(getSerialType() != null) sb.append(__wrapNumber(count++, "serialType", getSerialType()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getDay() != null) sb.append(__wrapNumber(count++, "day", getDay()));
		if(getSerialNumber() != null) sb.append(__wrapNumber(count++, "serialNumber", getSerialNumber()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("serialNumberId")) != null) setSerialNumberId(__getInt(val)); 
		if((val = values.get("serialType")) != null) setSerialType(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("day")) != null) setDay(__getInt(val)); 
		if((val = values.get("serialNumber")) != null) setSerialNumber(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __serial_number_id ;
	protected java.lang.Integer  __serial_type ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __day ;
	protected java.lang.Integer  __serial_number ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
