package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSystemInitLog extends GenericBase implements BaseFactory<BaseSystemInitLog>, Comparable<BaseSystemInitLog> 
{


	public static BaseSystemInitLog newInstance(){
		return new BaseSystemInitLog();
	}

	@Override
	public BaseSystemInitLog make(){
		BaseSystemInitLog b = new BaseSystemInitLog();
		return b;
	}

	public final static java.lang.String CS_SYSTEM_INIT_LOG_ID = "system_init_log_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_LOG_MSG = "log_msg" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_FLAG = "flag" ;

	public final static java.lang.String ALL_CAPTIONS = ",导入类型  1基础数据 2历史数据,,,1成功  2失败";

	public java.lang.Integer getSystemInitLogId() {
		return this.__system_init_log_id;
	}

	public void setSystemInitLogId( java.lang.Integer value ) {
		this.__system_init_log_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getLogMsg() {
		return this.__log_msg;
	}

	public void setLogMsg( java.lang.String value ) {
		this.__log_msg = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public void cloneCopy(BaseSystemInitLog __bean){
		__bean.setSystemInitLogId(getSystemInitLogId());
		__bean.setType(getType());
		__bean.setLogMsg(getLogMsg());
		__bean.setCreateTime(getCreateTime());
		__bean.setFlag(getFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSystemInitLogId() == null ? "" : getSystemInitLogId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getLogMsg() == null ? "" : getLogMsg());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSystemInitLog o) {
		return __system_init_log_id == null ? -1 : __system_init_log_id.compareTo(o.getSystemInitLogId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__system_init_log_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__log_msg);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSystemInitLog o = (BaseSystemInitLog)obj;
		if(!Objects.equals(this.__system_init_log_id, o.getSystemInitLogId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__log_msg, o.getLogMsg())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSystemInitLogId() != null) sb.append(__wrapNumber(count++, "systemInitLogId", getSystemInitLogId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getLogMsg() != null) sb.append(__wrapString(count++, "logMsg", getLogMsg()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("systemInitLogId")) != null) setSystemInitLogId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("logMsg")) != null) setLogMsg(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __system_init_log_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __log_msg ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __flag ;
}
