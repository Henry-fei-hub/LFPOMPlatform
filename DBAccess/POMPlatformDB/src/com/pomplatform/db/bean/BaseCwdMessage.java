package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdMessage extends GenericBase implements BaseFactory<BaseCwdMessage>, Comparable<BaseCwdMessage> 
{


	public static BaseCwdMessage newInstance(){
		return new BaseCwdMessage();
	}

	@Override
	public BaseCwdMessage make(){
		BaseCwdMessage b = new BaseCwdMessage();
		return b;
	}

	public final static java.lang.String CS_MESSAGE_ID = "message_id" ;
	public final static java.lang.String CS_SENDER_ID = "sender_id" ;
	public final static java.lang.String CS_SENDER_TYPE = "sender_type" ;
	public final static java.lang.String CS_CONTENT = "content" ;
	public final static java.lang.String CS_MESSAGE_TYPE = "message_type" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_PRIVACY_TYPE = "privacy_type" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CWD_TASK_MANAGE_ID = "cwd_task_manage_id" ;
	public final static java.lang.String CS_CWD_TASK_PROCESS_ID = "cwd_task_process_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,发送者编码,发送人类型 1内部员工,消息内容,消息类型 0系统消息  1任务相关消息 2流程相关消息 3项目相关消息,创建时间,私密类型 1公开  2指定人员,大项目主键,任务表主键,流程主键";

	public java.lang.Integer getMessageId() {
		return this.__message_id;
	}

	public void setMessageId( java.lang.Integer value ) {
		this.__message_id = value;
	}

	public java.lang.Integer getSenderId() {
		return this.__sender_id;
	}

	public void setSenderId( java.lang.Integer value ) {
		this.__sender_id = value;
	}

	public java.lang.Integer getSenderType() {
		return this.__sender_type;
	}

	public void setSenderType( java.lang.Integer value ) {
		this.__sender_type = value;
	}

	public java.lang.String getContent() {
		return this.__content;
	}

	public void setContent( java.lang.String value ) {
		this.__content = value;
	}

	public java.lang.Integer getMessageType() {
		return this.__message_type;
	}

	public void setMessageType( java.lang.Integer value ) {
		this.__message_type = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getPrivacyType() {
		return this.__privacy_type;
	}

	public void setPrivacyType( java.lang.Integer value ) {
		this.__privacy_type = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getCwdTaskManageId() {
		return this.__cwd_task_manage_id;
	}

	public void setCwdTaskManageId( java.lang.Integer value ) {
		this.__cwd_task_manage_id = value;
	}

	public java.lang.Integer getCwdTaskProcessId() {
		return this.__cwd_task_process_id;
	}

	public void setCwdTaskProcessId( java.lang.Integer value ) {
		this.__cwd_task_process_id = value;
	}

	public void cloneCopy(BaseCwdMessage __bean){
		__bean.setMessageId(getMessageId());
		__bean.setSenderId(getSenderId());
		__bean.setSenderType(getSenderType());
		__bean.setContent(getContent());
		__bean.setMessageType(getMessageType());
		__bean.setCreateTime(getCreateTime());
		__bean.setPrivacyType(getPrivacyType());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setCwdTaskManageId(getCwdTaskManageId());
		__bean.setCwdTaskProcessId(getCwdTaskProcessId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMessageId() == null ? "" : getMessageId());
		sb.append(",");
		sb.append(getSenderId() == null ? "" : getSenderId());
		sb.append(",");
		sb.append(getSenderType() == null ? "" : getSenderType());
		sb.append(",");
		sb.append(getContent() == null ? "" : getContent());
		sb.append(",");
		sb.append(getMessageType() == null ? "" : getMessageType());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getPrivacyType() == null ? "" : getPrivacyType());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getCwdTaskManageId() == null ? "" : getCwdTaskManageId());
		sb.append(",");
		sb.append(getCwdTaskProcessId() == null ? "" : getCwdTaskProcessId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdMessage o) {
		return __message_id == null ? -1 : __message_id.compareTo(o.getMessageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__message_id);
		hash = 97 * hash + Objects.hashCode(this.__sender_id);
		hash = 97 * hash + Objects.hashCode(this.__sender_type);
		hash = 97 * hash + Objects.hashCode(this.__content);
		hash = 97 * hash + Objects.hashCode(this.__message_type);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__privacy_type);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_process_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdMessage o = (BaseCwdMessage)obj;
		if(!Objects.equals(this.__message_id, o.getMessageId())) return false;
		if(!Objects.equals(this.__sender_id, o.getSenderId())) return false;
		if(!Objects.equals(this.__sender_type, o.getSenderType())) return false;
		if(!Objects.equals(this.__content, o.getContent())) return false;
		if(!Objects.equals(this.__message_type, o.getMessageType())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__privacy_type, o.getPrivacyType())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__cwd_task_manage_id, o.getCwdTaskManageId())) return false;
		if(!Objects.equals(this.__cwd_task_process_id, o.getCwdTaskProcessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMessageId() != null) sb.append(__wrapNumber(count++, "messageId", getMessageId()));
		if(getSenderId() != null) sb.append(__wrapNumber(count++, "senderId", getSenderId()));
		if(getSenderType() != null) sb.append(__wrapNumber(count++, "senderType", getSenderType()));
		if(getContent() != null) sb.append(__wrapString(count++, "content", getContent()));
		if(getMessageType() != null) sb.append(__wrapNumber(count++, "messageType", getMessageType()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getPrivacyType() != null) sb.append(__wrapNumber(count++, "privacyType", getPrivacyType()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getCwdTaskManageId() != null) sb.append(__wrapNumber(count++, "cwdTaskManageId", getCwdTaskManageId()));
		if(getCwdTaskProcessId() != null) sb.append(__wrapNumber(count++, "cwdTaskProcessId", getCwdTaskProcessId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("messageId")) != null) setMessageId(__getInt(val)); 
		if((val = values.get("senderId")) != null) setSenderId(__getInt(val)); 
		if((val = values.get("senderType")) != null) setSenderType(__getInt(val)); 
		if((val = values.get("content")) != null) setContent(__getString(val));
		if((val = values.get("messageType")) != null) setMessageType(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("privacyType")) != null) setPrivacyType(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("cwdTaskManageId")) != null) setCwdTaskManageId(__getInt(val)); 
		if((val = values.get("cwdTaskProcessId")) != null) setCwdTaskProcessId(__getInt(val)); 
	}

	protected java.lang.Integer  __message_id ;
	protected java.lang.Integer  __sender_id ;
	protected java.lang.Integer  __sender_type ;
	protected java.lang.String  __content ;
	protected java.lang.Integer  __message_type ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __privacy_type ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __cwd_task_manage_id ;
	protected java.lang.Integer  __cwd_task_process_id ;
}
