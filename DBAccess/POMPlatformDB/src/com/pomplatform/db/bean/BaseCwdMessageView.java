package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdMessageView extends GenericBase implements BaseFactory<BaseCwdMessageView>, Comparable<BaseCwdMessageView> 
{


	public static BaseCwdMessageView newInstance(){
		return new BaseCwdMessageView();
	}

	@Override
	public BaseCwdMessageView make(){
		BaseCwdMessageView b = new BaseCwdMessageView();
		return b;
	}

	public final static java.lang.String CS_MESSAGE_VIEW_ID = "message_view_id" ;
	public final static java.lang.String CS_MESSAGE_ID = "message_id" ;
	public final static java.lang.String CS_OBSERVER_ID = "observer_id" ;
	public final static java.lang.String CS_OBSERVER_TYPE = "observer_type" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,消息主键,查看人编码,查看人类型 1内部员工,创建时间";

	public java.lang.Integer getMessageViewId() {
		return this.__message_view_id;
	}

	public void setMessageViewId( java.lang.Integer value ) {
		this.__message_view_id = value;
	}

	public java.lang.Integer getMessageId() {
		return this.__message_id;
	}

	public void setMessageId( java.lang.Integer value ) {
		this.__message_id = value;
	}

	public java.lang.Integer getObserverId() {
		return this.__observer_id;
	}

	public void setObserverId( java.lang.Integer value ) {
		this.__observer_id = value;
	}

	public java.lang.Integer getObserverType() {
		return this.__observer_type;
	}

	public void setObserverType( java.lang.Integer value ) {
		this.__observer_type = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdMessageView __bean){
		__bean.setMessageViewId(getMessageViewId());
		__bean.setMessageId(getMessageId());
		__bean.setObserverId(getObserverId());
		__bean.setObserverType(getObserverType());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMessageViewId() == null ? "" : getMessageViewId());
		sb.append(",");
		sb.append(getMessageId() == null ? "" : getMessageId());
		sb.append(",");
		sb.append(getObserverId() == null ? "" : getObserverId());
		sb.append(",");
		sb.append(getObserverType() == null ? "" : getObserverType());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdMessageView o) {
		return __message_view_id == null ? -1 : __message_view_id.compareTo(o.getMessageViewId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__message_view_id);
		hash = 97 * hash + Objects.hashCode(this.__message_id);
		hash = 97 * hash + Objects.hashCode(this.__observer_id);
		hash = 97 * hash + Objects.hashCode(this.__observer_type);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdMessageView o = (BaseCwdMessageView)obj;
		if(!Objects.equals(this.__message_view_id, o.getMessageViewId())) return false;
		if(!Objects.equals(this.__message_id, o.getMessageId())) return false;
		if(!Objects.equals(this.__observer_id, o.getObserverId())) return false;
		if(!Objects.equals(this.__observer_type, o.getObserverType())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMessageViewId() != null) sb.append(__wrapNumber(count++, "messageViewId", getMessageViewId()));
		if(getMessageId() != null) sb.append(__wrapNumber(count++, "messageId", getMessageId()));
		if(getObserverId() != null) sb.append(__wrapNumber(count++, "observerId", getObserverId()));
		if(getObserverType() != null) sb.append(__wrapNumber(count++, "observerType", getObserverType()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("messageViewId")) != null) setMessageViewId(__getInt(val)); 
		if((val = values.get("messageId")) != null) setMessageId(__getInt(val)); 
		if((val = values.get("observerId")) != null) setObserverId(__getInt(val)); 
		if((val = values.get("observerType")) != null) setObserverType(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __message_view_id ;
	protected java.lang.Integer  __message_id ;
	protected java.lang.Integer  __observer_id ;
	protected java.lang.Integer  __observer_type ;
	protected java.util.Date  __create_time ;
}
