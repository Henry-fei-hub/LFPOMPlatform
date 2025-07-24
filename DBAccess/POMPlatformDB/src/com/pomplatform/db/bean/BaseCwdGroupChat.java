package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdGroupChat extends GenericBase implements BaseFactory<BaseCwdGroupChat>, Comparable<BaseCwdGroupChat> 
{


	public static BaseCwdGroupChat newInstance(){
		return new BaseCwdGroupChat();
	}

	@Override
	public BaseCwdGroupChat make(){
		BaseCwdGroupChat b = new BaseCwdGroupChat();
		return b;
	}

	public final static java.lang.String CS_GROUP_CHAT_ID = "group_chat_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CHAT_NAME = "chat_name" ;
	public final static java.lang.String CS_GROUP_TYPE = "group_type" ;
	public final static java.lang.String CS_WEIXIN_OWNER = "weixin_owner" ;
	public final static java.lang.String CS_WEIXIN_CHAT_ID = "weixin_chat_id" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_CREATE_APPLICATION_TYPE = "create_application_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,项目主键,群组名称,1 默认群组  2其它(未定),微信端群主账号,微信端群组唯一识别编码,操作人id,创建时间,1 CWD 2 ERP";

	public java.lang.Integer getGroupChatId() {
		return this.__group_chat_id;
	}

	public void setGroupChatId( java.lang.Integer value ) {
		this.__group_chat_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getChatName() {
		return this.__chat_name;
	}

	public void setChatName( java.lang.String value ) {
		this.__chat_name = value;
	}

	public java.lang.Integer getGroupType() {
		return this.__group_type;
	}

	public void setGroupType( java.lang.Integer value ) {
		this.__group_type = value;
	}

	public java.lang.String getWeixinOwner() {
		return this.__weixin_owner;
	}

	public void setWeixinOwner( java.lang.String value ) {
		this.__weixin_owner = value;
	}

	public java.lang.String getWeixinChatId() {
		return this.__weixin_chat_id;
	}

	public void setWeixinChatId( java.lang.String value ) {
		this.__weixin_chat_id = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getCreateApplicationType() {
		return this.__create_application_type;
	}

	public void setCreateApplicationType( java.lang.Integer value ) {
		this.__create_application_type = value;
	}

	public void cloneCopy(BaseCwdGroupChat __bean){
		__bean.setGroupChatId(getGroupChatId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setChatName(getChatName());
		__bean.setGroupType(getGroupType());
		__bean.setWeixinOwner(getWeixinOwner());
		__bean.setWeixinChatId(getWeixinChatId());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreateTime(getCreateTime());
		__bean.setCreateApplicationType(getCreateApplicationType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getGroupChatId() == null ? "" : getGroupChatId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getChatName() == null ? "" : getChatName());
		sb.append(",");
		sb.append(getGroupType() == null ? "" : getGroupType());
		sb.append(",");
		sb.append(getWeixinOwner() == null ? "" : getWeixinOwner());
		sb.append(",");
		sb.append(getWeixinChatId() == null ? "" : getWeixinChatId());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCreateApplicationType() == null ? "" : getCreateApplicationType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdGroupChat o) {
		return __group_chat_id == null ? -1 : __group_chat_id.compareTo(o.getGroupChatId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__group_chat_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__chat_name);
		hash = 97 * hash + Objects.hashCode(this.__group_type);
		hash = 97 * hash + Objects.hashCode(this.__weixin_owner);
		hash = 97 * hash + Objects.hashCode(this.__weixin_chat_id);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__create_application_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdGroupChat o = (BaseCwdGroupChat)obj;
		if(!Objects.equals(this.__group_chat_id, o.getGroupChatId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__chat_name, o.getChatName())) return false;
		if(!Objects.equals(this.__group_type, o.getGroupType())) return false;
		if(!Objects.equals(this.__weixin_owner, o.getWeixinOwner())) return false;
		if(!Objects.equals(this.__weixin_chat_id, o.getWeixinChatId())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__create_application_type, o.getCreateApplicationType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getGroupChatId() != null) sb.append(__wrapNumber(count++, "groupChatId", getGroupChatId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getChatName() != null) sb.append(__wrapString(count++, "chatName", getChatName()));
		if(getGroupType() != null) sb.append(__wrapNumber(count++, "groupType", getGroupType()));
		if(getWeixinOwner() != null) sb.append(__wrapString(count++, "weixinOwner", getWeixinOwner()));
		if(getWeixinChatId() != null) sb.append(__wrapString(count++, "weixinChatId", getWeixinChatId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCreateApplicationType() != null) sb.append(__wrapNumber(count++, "createApplicationType", getCreateApplicationType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getGroupChatId() != null) res.put("groupChatId", getGroupChatId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getChatName() != null) res.put("chatName", getChatName());
		if(getGroupType() != null) res.put("groupType", getGroupType());
		if(getWeixinOwner() != null) res.put("weixinOwner", getWeixinOwner());
		if(getWeixinChatId() != null) res.put("weixinChatId", getWeixinChatId());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getCreateApplicationType() != null) res.put("createApplicationType", getCreateApplicationType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("groupChatId")) != null) setGroupChatId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("chatName")) != null) setChatName(__getString(val));
		if((val = values.get("groupType")) != null) setGroupType(__getInt(val)); 
		if((val = values.get("weixinOwner")) != null) setWeixinOwner(__getString(val));
		if((val = values.get("weixinChatId")) != null) setWeixinChatId(__getString(val));
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("createApplicationType")) != null) setCreateApplicationType(__getInt(val)); 
	}

	protected java.lang.Integer  __group_chat_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __chat_name ;
	protected java.lang.Integer  __group_type ;
	protected java.lang.String  __weixin_owner ;
	protected java.lang.String  __weixin_chat_id ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __create_application_type ;
}
