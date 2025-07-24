package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdMessageReceive extends GenericBase implements BaseFactory<BaseCwdMessageReceive>, Comparable<BaseCwdMessageReceive> 
{


	public static BaseCwdMessageReceive newInstance(){
		return new BaseCwdMessageReceive();
	}

	@Override
	public BaseCwdMessageReceive make(){
		BaseCwdMessageReceive b = new BaseCwdMessageReceive();
		return b;
	}

	public final static java.lang.String CS_MESSAGE_RECEIVE_ID = "message_receive_id" ;
	public final static java.lang.String CS_MESSAGE_ID = "message_id" ;
	public final static java.lang.String CS_RECEIVER_ID = "receiver_id" ;
	public final static java.lang.String CS_RECEIVER_TYPE = "receiver_type" ;
	public final static java.lang.String CS_READ_STATUS = "read_status" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,消息表主键,接收人主键,接受人类型 1内部员工,阅读状态 1未读 2已读,创建时间";

	public java.lang.Integer getMessageReceiveId() {
		return this.__message_receive_id;
	}

	public void setMessageReceiveId( java.lang.Integer value ) {
		this.__message_receive_id = value;
	}

	public java.lang.Integer getMessageId() {
		return this.__message_id;
	}

	public void setMessageId( java.lang.Integer value ) {
		this.__message_id = value;
	}

	public java.lang.Integer getReceiverId() {
		return this.__receiver_id;
	}

	public void setReceiverId( java.lang.Integer value ) {
		this.__receiver_id = value;
	}

	public java.lang.Integer getReceiverType() {
		return this.__receiver_type;
	}

	public void setReceiverType( java.lang.Integer value ) {
		this.__receiver_type = value;
	}

	public java.lang.Integer getReadStatus() {
		return this.__read_status;
	}

	public void setReadStatus( java.lang.Integer value ) {
		this.__read_status = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdMessageReceive __bean){
		__bean.setMessageReceiveId(getMessageReceiveId());
		__bean.setMessageId(getMessageId());
		__bean.setReceiverId(getReceiverId());
		__bean.setReceiverType(getReceiverType());
		__bean.setReadStatus(getReadStatus());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMessageReceiveId() == null ? "" : getMessageReceiveId());
		sb.append(",");
		sb.append(getMessageId() == null ? "" : getMessageId());
		sb.append(",");
		sb.append(getReceiverId() == null ? "" : getReceiverId());
		sb.append(",");
		sb.append(getReceiverType() == null ? "" : getReceiverType());
		sb.append(",");
		sb.append(getReadStatus() == null ? "" : getReadStatus());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdMessageReceive o) {
		return __message_receive_id == null ? -1 : __message_receive_id.compareTo(o.getMessageReceiveId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__message_receive_id);
		hash = 97 * hash + Objects.hashCode(this.__message_id);
		hash = 97 * hash + Objects.hashCode(this.__receiver_id);
		hash = 97 * hash + Objects.hashCode(this.__receiver_type);
		hash = 97 * hash + Objects.hashCode(this.__read_status);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdMessageReceive o = (BaseCwdMessageReceive)obj;
		if(!Objects.equals(this.__message_receive_id, o.getMessageReceiveId())) return false;
		if(!Objects.equals(this.__message_id, o.getMessageId())) return false;
		if(!Objects.equals(this.__receiver_id, o.getReceiverId())) return false;
		if(!Objects.equals(this.__receiver_type, o.getReceiverType())) return false;
		if(!Objects.equals(this.__read_status, o.getReadStatus())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMessageReceiveId() != null) sb.append(__wrapNumber(count++, "messageReceiveId", getMessageReceiveId()));
		if(getMessageId() != null) sb.append(__wrapNumber(count++, "messageId", getMessageId()));
		if(getReceiverId() != null) sb.append(__wrapNumber(count++, "receiverId", getReceiverId()));
		if(getReceiverType() != null) sb.append(__wrapNumber(count++, "receiverType", getReceiverType()));
		if(getReadStatus() != null) sb.append(__wrapNumber(count++, "readStatus", getReadStatus()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("messageReceiveId")) != null) setMessageReceiveId(__getInt(val)); 
		if((val = values.get("messageId")) != null) setMessageId(__getInt(val)); 
		if((val = values.get("receiverId")) != null) setReceiverId(__getInt(val)); 
		if((val = values.get("receiverType")) != null) setReceiverType(__getInt(val)); 
		if((val = values.get("readStatus")) != null) setReadStatus(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __message_receive_id ;
	protected java.lang.Integer  __message_id ;
	protected java.lang.Integer  __receiver_id ;
	protected java.lang.Integer  __receiver_type ;
	protected java.lang.Integer  __read_status ;
	protected java.util.Date  __create_time ;
}
