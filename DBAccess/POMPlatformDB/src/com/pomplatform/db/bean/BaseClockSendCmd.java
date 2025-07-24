package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseClockSendCmd extends GenericBase implements BaseFactory<BaseClockSendCmd>, Comparable<BaseClockSendCmd> 
{


	public static BaseClockSendCmd newInstance(){
		return new BaseClockSendCmd();
	}

	@Override
	public BaseClockSendCmd make(){
		BaseClockSendCmd b = new BaseClockSendCmd();
		return b;
	}

	public final static java.lang.String CS_CLOCK_SEND_CMD_ID = "clock_send_cmd_id" ;
	public final static java.lang.String CS_SN = "sn" ;
	public final static java.lang.String CS_COUNT = "count" ;
	public final static java.lang.String CS_TRANS_CONTEXT = "trans_context" ;
	public final static java.lang.String CS_TRANSTIME = "transtime" ;
	public final static java.lang.String CS_FLAG = "flag" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,序列号,记录数,内容,传送时间,数据";

	public java.lang.Integer getClockSendCmdId() {
		return this.__clock_send_cmd_id;
	}

	public void setClockSendCmdId( java.lang.Integer value ) {
		this.__clock_send_cmd_id = value;
	}

	public java.lang.String getSn() {
		return this.__sn;
	}

	public void setSn( java.lang.String value ) {
		this.__sn = value;
	}

	public java.lang.Integer getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Integer value ) {
		this.__count = value;
	}

	public java.lang.String getTransContext() {
		return this.__trans_context;
	}

	public void setTransContext( java.lang.String value ) {
		this.__trans_context = value;
	}

	public java.util.Date getTranstime() {
		return this.__transtime;
	}

	public void setTranstime( java.util.Date value ) {
		this.__transtime = value;
	}

	public java.lang.String getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.String value ) {
		this.__flag = value;
	}

	public void cloneCopy(BaseClockSendCmd __bean){
		__bean.setClockSendCmdId(getClockSendCmdId());
		__bean.setSn(getSn());
		__bean.setCount(getCount());
		__bean.setTransContext(getTransContext());
		__bean.setTranstime(getTranstime());
		__bean.setFlag(getFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getClockSendCmdId() == null ? "" : getClockSendCmdId());
		sb.append(",");
		sb.append(getSn() == null ? "" : getSn());
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		sb.append(",");
		sb.append(getTransContext() == null ? "" : getTransContext());
		sb.append(",");
		sb.append(getTranstime() == null ? "" : sdf.format(getTranstime()));
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseClockSendCmd o) {
		return __clock_send_cmd_id == null ? -1 : __clock_send_cmd_id.compareTo(o.getClockSendCmdId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__clock_send_cmd_id);
		hash = 97 * hash + Objects.hashCode(this.__sn);
		hash = 97 * hash + Objects.hashCode(this.__count);
		hash = 97 * hash + Objects.hashCode(this.__trans_context);
		hash = 97 * hash + Objects.hashCode(this.__transtime);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseClockSendCmd o = (BaseClockSendCmd)obj;
		if(!Objects.equals(this.__clock_send_cmd_id, o.getClockSendCmdId())) return false;
		if(!Objects.equals(this.__sn, o.getSn())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		if(!Objects.equals(this.__trans_context, o.getTransContext())) return false;
		if(!Objects.equals(this.__transtime, o.getTranstime())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getClockSendCmdId() != null) sb.append(__wrapNumber(count++, "clockSendCmdId", getClockSendCmdId()));
		if(getSn() != null) sb.append(__wrapString(count++, "sn", getSn()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		if(getTransContext() != null) sb.append(__wrapString(count++, "transContext", getTransContext()));
		if(getTranstime() != null) sb.append(__wrapDate(count++, "transtime", getTranstime()));
		if(getFlag() != null) sb.append(__wrapString(count++, "flag", getFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("clockSendCmdId")) != null) setClockSendCmdId(__getInt(val)); 
		if((val = values.get("sn")) != null) setSn(__getString(val));
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
		if((val = values.get("transContext")) != null) setTransContext(__getString(val));
		if((val = values.get("transtime")) != null) setTranstime(__getDate(val)); 
		if((val = values.get("flag")) != null) setFlag(__getString(val));
	}

	protected java.lang.Integer  __clock_send_cmd_id ;
	protected java.lang.String  __sn ;
	protected java.lang.Integer  __count ;
	protected java.lang.String  __trans_context ;
	protected java.util.Date  __transtime ;
	protected java.lang.String  __flag ;
}
