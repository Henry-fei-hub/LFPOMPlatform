package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseClient extends GenericBase implements BaseFactory<BaseClient>, Comparable<BaseClient> 
{


	public static BaseClient newInstance(){
		return new BaseClient();
	}

	@Override
	public BaseClient make(){
		BaseClient b = new BaseClient();
		return b;
	}

	public final static java.lang.String CS_CLIENT_ID = "client_id" ;
	public final static java.lang.String CS_CLIENT_NAME = "client_name" ;
	public final static java.lang.String CS_CLIENT_PHONE = "client_phone" ;
	public final static java.lang.String CS_CLIENT_COMPANY = "client_company" ;
	public final static java.lang.String CS_CLIENT_ADDRESS = "client_address" ;
	public final static java.lang.String CS_CLIENT_JOB = "client_job" ;
	public final static java.lang.String CS_CLIENT_WEIXIN = "client_weixin" ;
	public final static java.lang.String CS_CLIENT_QQ = "client_qq" ;
	public final static java.lang.String CS_CLIENT_EMAIL = "client_email" ;
	public final static java.lang.String CS_CLIENT_ROLE = "client_role" ;

	public final static java.lang.String ALL_CAPTIONS = "客户编码,联系人姓名,联系人手机,单位名称,单位地址,职务,微信,QQ,邮箱,0客户    1建筑设计单位联系人";

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
	}

	public java.lang.String getClientName() {
		return this.__client_name;
	}

	public void setClientName( java.lang.String value ) {
		this.__client_name = value;
	}

	public java.lang.String getClientPhone() {
		return this.__client_phone;
	}

	public void setClientPhone( java.lang.String value ) {
		this.__client_phone = value;
	}

	public java.lang.String getClientCompany() {
		return this.__client_company;
	}

	public void setClientCompany( java.lang.String value ) {
		this.__client_company = value;
	}

	public java.lang.String getClientAddress() {
		return this.__client_address;
	}

	public void setClientAddress( java.lang.String value ) {
		this.__client_address = value;
	}

	public java.lang.String getClientJob() {
		return this.__client_job;
	}

	public void setClientJob( java.lang.String value ) {
		this.__client_job = value;
	}

	public java.lang.String getClientWeixin() {
		return this.__client_weixin;
	}

	public void setClientWeixin( java.lang.String value ) {
		this.__client_weixin = value;
	}

	public java.lang.String getClientQq() {
		return this.__client_qq;
	}

	public void setClientQq( java.lang.String value ) {
		this.__client_qq = value;
	}

	public java.lang.String getClientEmail() {
		return this.__client_email;
	}

	public void setClientEmail( java.lang.String value ) {
		this.__client_email = value;
	}

	public java.lang.Integer getClientRole() {
		return this.__client_role;
	}

	public void setClientRole( java.lang.Integer value ) {
		this.__client_role = value;
	}

	public void cloneCopy(BaseClient __bean){
		__bean.setClientId(getClientId());
		__bean.setClientName(getClientName());
		__bean.setClientPhone(getClientPhone());
		__bean.setClientCompany(getClientCompany());
		__bean.setClientAddress(getClientAddress());
		__bean.setClientJob(getClientJob());
		__bean.setClientWeixin(getClientWeixin());
		__bean.setClientQq(getClientQq());
		__bean.setClientEmail(getClientEmail());
		__bean.setClientRole(getClientRole());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getClientId() == null ? "" : getClientId());
		sb.append(",");
		sb.append(getClientName() == null ? "" : getClientName());
		sb.append(",");
		sb.append(getClientPhone() == null ? "" : getClientPhone());
		sb.append(",");
		sb.append(getClientCompany() == null ? "" : getClientCompany());
		sb.append(",");
		sb.append(getClientAddress() == null ? "" : getClientAddress());
		sb.append(",");
		sb.append(getClientJob() == null ? "" : getClientJob());
		sb.append(",");
		sb.append(getClientWeixin() == null ? "" : getClientWeixin());
		sb.append(",");
		sb.append(getClientQq() == null ? "" : getClientQq());
		sb.append(",");
		sb.append(getClientEmail() == null ? "" : getClientEmail());
		sb.append(",");
		sb.append(getClientRole() == null ? "" : getClientRole());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseClient o) {
		return __client_id == null ? -1 : __client_id.compareTo(o.getClientId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__client_id);
		hash = 97 * hash + Objects.hashCode(this.__client_name);
		hash = 97 * hash + Objects.hashCode(this.__client_phone);
		hash = 97 * hash + Objects.hashCode(this.__client_company);
		hash = 97 * hash + Objects.hashCode(this.__client_address);
		hash = 97 * hash + Objects.hashCode(this.__client_job);
		hash = 97 * hash + Objects.hashCode(this.__client_weixin);
		hash = 97 * hash + Objects.hashCode(this.__client_qq);
		hash = 97 * hash + Objects.hashCode(this.__client_email);
		hash = 97 * hash + Objects.hashCode(this.__client_role);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseClient o = (BaseClient)obj;
		if(!Objects.equals(this.__client_id, o.getClientId())) return false;
		if(!Objects.equals(this.__client_name, o.getClientName())) return false;
		if(!Objects.equals(this.__client_phone, o.getClientPhone())) return false;
		if(!Objects.equals(this.__client_company, o.getClientCompany())) return false;
		if(!Objects.equals(this.__client_address, o.getClientAddress())) return false;
		if(!Objects.equals(this.__client_job, o.getClientJob())) return false;
		if(!Objects.equals(this.__client_weixin, o.getClientWeixin())) return false;
		if(!Objects.equals(this.__client_qq, o.getClientQq())) return false;
		if(!Objects.equals(this.__client_email, o.getClientEmail())) return false;
		if(!Objects.equals(this.__client_role, o.getClientRole())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getClientId() != null) sb.append(__wrapNumber(count++, "clientId", getClientId()));
		if(getClientName() != null) sb.append(__wrapString(count++, "clientName", getClientName()));
		if(getClientPhone() != null) sb.append(__wrapString(count++, "clientPhone", getClientPhone()));
		if(getClientCompany() != null) sb.append(__wrapString(count++, "clientCompany", getClientCompany()));
		if(getClientAddress() != null) sb.append(__wrapString(count++, "clientAddress", getClientAddress()));
		if(getClientJob() != null) sb.append(__wrapString(count++, "clientJob", getClientJob()));
		if(getClientWeixin() != null) sb.append(__wrapString(count++, "clientWeixin", getClientWeixin()));
		if(getClientQq() != null) sb.append(__wrapString(count++, "clientQq", getClientQq()));
		if(getClientEmail() != null) sb.append(__wrapString(count++, "clientEmail", getClientEmail()));
		if(getClientRole() != null) sb.append(__wrapNumber(count++, "clientRole", getClientRole()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("clientId")) != null) setClientId(__getInt(val)); 
		if((val = values.get("clientName")) != null) setClientName(__getString(val));
		if((val = values.get("clientPhone")) != null) setClientPhone(__getString(val));
		if((val = values.get("clientCompany")) != null) setClientCompany(__getString(val));
		if((val = values.get("clientAddress")) != null) setClientAddress(__getString(val));
		if((val = values.get("clientJob")) != null) setClientJob(__getString(val));
		if((val = values.get("clientWeixin")) != null) setClientWeixin(__getString(val));
		if((val = values.get("clientQq")) != null) setClientQq(__getString(val));
		if((val = values.get("clientEmail")) != null) setClientEmail(__getString(val));
		if((val = values.get("clientRole")) != null) setClientRole(__getInt(val)); 
	}

	protected java.lang.Integer  __client_id ;
	protected java.lang.String  __client_name ;
	protected java.lang.String  __client_phone ;
	protected java.lang.String  __client_company ;
	protected java.lang.String  __client_address ;
	protected java.lang.String  __client_job ;
	protected java.lang.String  __client_weixin ;
	protected java.lang.String  __client_qq ;
	protected java.lang.String  __client_email ;
	protected java.lang.Integer  __client_role ;
}
