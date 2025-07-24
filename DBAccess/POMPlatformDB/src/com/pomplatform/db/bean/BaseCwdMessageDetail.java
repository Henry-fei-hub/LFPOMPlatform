package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdMessageDetail extends GenericBase implements BaseFactory<BaseCwdMessageDetail>, Comparable<BaseCwdMessageDetail> 
{


	public static BaseCwdMessageDetail newInstance(){
		return new BaseCwdMessageDetail();
	}

	@Override
	public BaseCwdMessageDetail make(){
		BaseCwdMessageDetail b = new BaseCwdMessageDetail();
		return b;
	}

	public final static java.lang.String CS_MESSAGE_DETAIL_ID = "message_detail_id" ;
	public final static java.lang.String CS_MESSAGE_ID = "message_id" ;
	public final static java.lang.String CS_CONTENT = "content" ;
	public final static java.lang.String CS_SENDER_ID = "sender_id" ;
	public final static java.lang.String CS_RECEIVER_ID = "receiver_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,消息表主键,内容,发送者编码,接收人主键,创建时间";

	public java.lang.Integer getMessageDetailId() {
		return this.__message_detail_id;
	}

	public void setMessageDetailId( java.lang.Integer value ) {
		this.__message_detail_id = value;
	}

	public java.lang.Integer getMessageId() {
		return this.__message_id;
	}

	public void setMessageId( java.lang.Integer value ) {
		this.__message_id = value;
	}

	public java.lang.String getContent() {
		return this.__content;
	}

	public void setContent( java.lang.String value ) {
		this.__content = value;
	}

	public java.lang.Integer getSenderId() {
		return this.__sender_id;
	}

	public void setSenderId( java.lang.Integer value ) {
		this.__sender_id = value;
	}

	public java.lang.Integer getReceiverId() {
		return this.__receiver_id;
	}

	public void setReceiverId( java.lang.Integer value ) {
		this.__receiver_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdMessageDetail __bean){
		__bean.setMessageDetailId(getMessageDetailId());
		__bean.setMessageId(getMessageId());
		__bean.setContent(getContent());
		__bean.setSenderId(getSenderId());
		__bean.setReceiverId(getReceiverId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMessageDetailId() == null ? "" : getMessageDetailId());
		sb.append(",");
		sb.append(getMessageId() == null ? "" : getMessageId());
		sb.append(",");
		sb.append(getContent() == null ? "" : getContent());
		sb.append(",");
		sb.append(getSenderId() == null ? "" : getSenderId());
		sb.append(",");
		sb.append(getReceiverId() == null ? "" : getReceiverId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdMessageDetail o) {
		return __message_detail_id == null ? -1 : __message_detail_id.compareTo(o.getMessageDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__message_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__message_id);
		hash = 97 * hash + Objects.hashCode(this.__content);
		hash = 97 * hash + Objects.hashCode(this.__sender_id);
		hash = 97 * hash + Objects.hashCode(this.__receiver_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdMessageDetail o = (BaseCwdMessageDetail)obj;
		if(!Objects.equals(this.__message_detail_id, o.getMessageDetailId())) return false;
		if(!Objects.equals(this.__message_id, o.getMessageId())) return false;
		if(!Objects.equals(this.__content, o.getContent())) return false;
		if(!Objects.equals(this.__sender_id, o.getSenderId())) return false;
		if(!Objects.equals(this.__receiver_id, o.getReceiverId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMessageDetailId() != null) sb.append(__wrapNumber(count++, "messageDetailId", getMessageDetailId()));
		if(getMessageId() != null) sb.append(__wrapNumber(count++, "messageId", getMessageId()));
		if(getContent() != null) sb.append(__wrapString(count++, "content", getContent()));
		if(getSenderId() != null) sb.append(__wrapNumber(count++, "senderId", getSenderId()));
		if(getReceiverId() != null) sb.append(__wrapNumber(count++, "receiverId", getReceiverId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("messageDetailId")) != null) setMessageDetailId(__getInt(val)); 
		if((val = values.get("messageId")) != null) setMessageId(__getInt(val)); 
		if((val = values.get("content")) != null) setContent(__getString(val));
		if((val = values.get("senderId")) != null) setSenderId(__getInt(val)); 
		if((val = values.get("receiverId")) != null) setReceiverId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __message_detail_id ;
	protected java.lang.Integer  __message_id ;
	protected java.lang.String  __content ;
	protected java.lang.Integer  __sender_id ;
	protected java.lang.Integer  __receiver_id ;
	protected java.util.Date  __create_time ;
}
