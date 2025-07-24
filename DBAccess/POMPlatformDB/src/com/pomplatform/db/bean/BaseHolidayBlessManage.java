package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseHolidayBlessManage extends GenericBase implements BaseFactory<BaseHolidayBlessManage>, Comparable<BaseHolidayBlessManage> 
{


	public static BaseHolidayBlessManage newInstance(){
		return new BaseHolidayBlessManage();
	}

	@Override
	public BaseHolidayBlessManage make(){
		BaseHolidayBlessManage b = new BaseHolidayBlessManage();
		return b;
	}

	public final static java.lang.String CS_HOLIDAY_BLESS_MANAGE_ID = "holiday_bless_manage_id" ;
	public final static java.lang.String CS_HOLIDAY_NAME = "holiday_name" ;
	public final static java.lang.String CS_HOLIDAY_DATE = "holiday_date" ;
	public final static java.lang.String CS_HOLIDAY_TYPE = "holiday_type" ;
	public final static java.lang.String CS_SEND_OBJECT = "send_object" ;
	public final static java.lang.String CS_OBJECT_TYPE = "object_type" ;
	public final static java.lang.String CS_BLESS_WORDS = "bless_words" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,节日名称,节日日期,节日类型(对应字典表125),推送对象(对应字典表126),对象类型(对应字典表75),祝福语,操作人,操作时间,备注";

	public java.lang.Integer getHolidayBlessManageId() {
		return this.__holiday_bless_manage_id;
	}

	public void setHolidayBlessManageId( java.lang.Integer value ) {
		this.__holiday_bless_manage_id = value;
	}

	public java.lang.String getHolidayName() {
		return this.__holiday_name;
	}

	public void setHolidayName( java.lang.String value ) {
		this.__holiday_name = value;
	}

	public java.util.Date getHolidayDate() {
		return this.__holiday_date;
	}

	public void setHolidayDate( java.util.Date value ) {
		this.__holiday_date = value;
	}

	public java.lang.Integer getHolidayType() {
		return this.__holiday_type;
	}

	public void setHolidayType( java.lang.Integer value ) {
		this.__holiday_type = value;
	}

	public java.lang.Integer getSendObject() {
		return this.__send_object;
	}

	public void setSendObject( java.lang.Integer value ) {
		this.__send_object = value;
	}

	public java.lang.Integer getObjectType() {
		return this.__object_type;
	}

	public void setObjectType( java.lang.Integer value ) {
		this.__object_type = value;
	}

	public java.lang.String getBlessWords() {
		return this.__bless_words;
	}

	public void setBlessWords( java.lang.String value ) {
		this.__bless_words = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
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

	public void cloneCopy(BaseHolidayBlessManage __bean){
		__bean.setHolidayBlessManageId(getHolidayBlessManageId());
		__bean.setHolidayName(getHolidayName());
		__bean.setHolidayDate(getHolidayDate());
		__bean.setHolidayType(getHolidayType());
		__bean.setSendObject(getSendObject());
		__bean.setObjectType(getObjectType());
		__bean.setBlessWords(getBlessWords());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getHolidayBlessManageId() == null ? "" : getHolidayBlessManageId());
		sb.append(",");
		sb.append(getHolidayName() == null ? "" : getHolidayName());
		sb.append(",");
		sb.append(getHolidayDate() == null ? "" : sdf.format(getHolidayDate()));
		sb.append(",");
		sb.append(getHolidayType() == null ? "" : getHolidayType());
		sb.append(",");
		sb.append(getSendObject() == null ? "" : getSendObject());
		sb.append(",");
		sb.append(getObjectType() == null ? "" : getObjectType());
		sb.append(",");
		sb.append(getBlessWords() == null ? "" : getBlessWords());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseHolidayBlessManage o) {
		return __holiday_bless_manage_id == null ? -1 : __holiday_bless_manage_id.compareTo(o.getHolidayBlessManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__holiday_bless_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__holiday_name);
		hash = 97 * hash + Objects.hashCode(this.__holiday_date);
		hash = 97 * hash + Objects.hashCode(this.__holiday_type);
		hash = 97 * hash + Objects.hashCode(this.__send_object);
		hash = 97 * hash + Objects.hashCode(this.__object_type);
		hash = 97 * hash + Objects.hashCode(this.__bless_words);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseHolidayBlessManage o = (BaseHolidayBlessManage)obj;
		if(!Objects.equals(this.__holiday_bless_manage_id, o.getHolidayBlessManageId())) return false;
		if(!Objects.equals(this.__holiday_name, o.getHolidayName())) return false;
		if(!Objects.equals(this.__holiday_date, o.getHolidayDate())) return false;
		if(!Objects.equals(this.__holiday_type, o.getHolidayType())) return false;
		if(!Objects.equals(this.__send_object, o.getSendObject())) return false;
		if(!Objects.equals(this.__object_type, o.getObjectType())) return false;
		if(!Objects.equals(this.__bless_words, o.getBlessWords())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getHolidayBlessManageId() != null) sb.append(__wrapNumber(count++, "holidayBlessManageId", getHolidayBlessManageId()));
		if(getHolidayName() != null) sb.append(__wrapString(count++, "holidayName", getHolidayName()));
		if(getHolidayDate() != null) sb.append(__wrapDate(count++, "holidayDate", getHolidayDate()));
		if(getHolidayType() != null) sb.append(__wrapNumber(count++, "holidayType", getHolidayType()));
		if(getSendObject() != null) sb.append(__wrapNumber(count++, "sendObject", getSendObject()));
		if(getObjectType() != null) sb.append(__wrapNumber(count++, "objectType", getObjectType()));
		if(getBlessWords() != null) sb.append(__wrapString(count++, "blessWords", getBlessWords()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("holidayBlessManageId")) != null) setHolidayBlessManageId(__getInt(val)); 
		if((val = values.get("holidayName")) != null) setHolidayName(__getString(val));
		if((val = values.get("holidayDate")) != null) setHolidayDate(__getDate(val)); 
		if((val = values.get("holidayType")) != null) setHolidayType(__getInt(val)); 
		if((val = values.get("sendObject")) != null) setSendObject(__getInt(val)); 
		if((val = values.get("objectType")) != null) setObjectType(__getInt(val)); 
		if((val = values.get("blessWords")) != null) setBlessWords(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __holiday_bless_manage_id ;
	protected java.lang.String  __holiday_name ;
	protected java.util.Date  __holiday_date ;
	protected java.lang.Integer  __holiday_type ;
	protected java.lang.Integer  __send_object ;
	protected java.lang.Integer  __object_type ;
	protected java.lang.String  __bless_words ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
