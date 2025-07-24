package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompanyWorkplaceServer extends GenericBase implements BaseFactory<BaseCompanyWorkplaceServer>, Comparable<BaseCompanyWorkplaceServer> 
{


	public static BaseCompanyWorkplaceServer newInstance(){
		return new BaseCompanyWorkplaceServer();
	}

	@Override
	public BaseCompanyWorkplaceServer make(){
		BaseCompanyWorkplaceServer b = new BaseCompanyWorkplaceServer();
		return b;
	}

	public final static java.lang.String CS_WORKPLACE_SERVER_ID = "workplace_server_id" ;
	public final static java.lang.String CS_WORKPLACE_ID = "workplace_id" ;
	public final static java.lang.String CS_INTRANET_SERVER_ADDRESS = "intranet_server_address" ;
	public final static java.lang.String CS_INTRANET_SERVER_PORT = "intranet_server_port" ;
	public final static java.lang.String CS_EXTERNAL_SERVER_ADDRESS = "external_server_address" ;
	public final static java.lang.String CS_EXTERNAL_SERVER_PORT = "external_server_port" ;
	public final static java.lang.String CS_EXTERNAL_SERVER_USEABLE = "external_server_useable" ;
	public final static java.lang.String CS_URL = "url" ;
	public final static java.lang.String CS_ACTIVE = "active" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,工作场所编码,服务器内网地址,服务器内网端口号,服务器外网地址,服务器外网端口号,外网服务器是否可用,URL地址,是否有效";

	public java.lang.Integer getWorkplaceServerId() {
		return this.__workplace_server_id;
	}

	public void setWorkplaceServerId( java.lang.Integer value ) {
		this.__workplace_server_id = value;
	}

	public java.lang.Integer getWorkplaceId() {
		return this.__workplace_id;
	}

	public void setWorkplaceId( java.lang.Integer value ) {
		this.__workplace_id = value;
	}

	public java.lang.String getIntranetServerAddress() {
		return this.__intranet_server_address;
	}

	public void setIntranetServerAddress( java.lang.String value ) {
		this.__intranet_server_address = value;
	}

	public java.lang.Integer getIntranetServerPort() {
		return this.__intranet_server_port;
	}

	public void setIntranetServerPort( java.lang.Integer value ) {
		this.__intranet_server_port = value;
	}

	public java.lang.String getExternalServerAddress() {
		return this.__external_server_address;
	}

	public void setExternalServerAddress( java.lang.String value ) {
		this.__external_server_address = value;
	}

	public java.lang.Integer getExternalServerPort() {
		return this.__external_server_port;
	}

	public void setExternalServerPort( java.lang.Integer value ) {
		this.__external_server_port = value;
	}

	public java.lang.Boolean getExternalServerUseable() {
		return this.__external_server_useable;
	}

	public void setExternalServerUseable( java.lang.Boolean value ) {
		this.__external_server_useable = value;
	}

	public java.lang.String getUrl() {
		return this.__url;
	}

	public void setUrl( java.lang.String value ) {
		this.__url = value;
	}

	public java.lang.Boolean getActive() {
		return this.__active;
	}

	public void setActive( java.lang.Boolean value ) {
		this.__active = value;
	}

	public void cloneCopy(BaseCompanyWorkplaceServer __bean){
		__bean.setWorkplaceServerId(getWorkplaceServerId());
		__bean.setWorkplaceId(getWorkplaceId());
		__bean.setIntranetServerAddress(getIntranetServerAddress());
		__bean.setIntranetServerPort(getIntranetServerPort());
		__bean.setExternalServerAddress(getExternalServerAddress());
		__bean.setExternalServerPort(getExternalServerPort());
		__bean.setExternalServerUseable(getExternalServerUseable());
		__bean.setUrl(getUrl());
		__bean.setActive(getActive());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getWorkplaceServerId() == null ? "" : getWorkplaceServerId());
		sb.append(",");
		sb.append(getWorkplaceId() == null ? "" : getWorkplaceId());
		sb.append(",");
		sb.append(getIntranetServerAddress() == null ? "" : getIntranetServerAddress());
		sb.append(",");
		sb.append(getIntranetServerPort() == null ? "" : getIntranetServerPort());
		sb.append(",");
		sb.append(getExternalServerAddress() == null ? "" : getExternalServerAddress());
		sb.append(",");
		sb.append(getExternalServerPort() == null ? "" : getExternalServerPort());
		sb.append(",");
		sb.append(getExternalServerUseable() == null ? "" : getExternalServerUseable());
		sb.append(",");
		sb.append(getUrl() == null ? "" : getUrl());
		sb.append(",");
		sb.append(getActive() == null ? "" : getActive());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyWorkplaceServer o) {
		return __workplace_server_id == null ? -1 : __workplace_server_id.compareTo(o.getWorkplaceServerId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__workplace_server_id);
		hash = 97 * hash + Objects.hashCode(this.__workplace_id);
		hash = 97 * hash + Objects.hashCode(this.__intranet_server_address);
		hash = 97 * hash + Objects.hashCode(this.__intranet_server_port);
		hash = 97 * hash + Objects.hashCode(this.__external_server_address);
		hash = 97 * hash + Objects.hashCode(this.__external_server_port);
		hash = 97 * hash + Objects.hashCode(this.__external_server_useable);
		hash = 97 * hash + Objects.hashCode(this.__url);
		hash = 97 * hash + Objects.hashCode(this.__active);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyWorkplaceServer o = (BaseCompanyWorkplaceServer)obj;
		if(!Objects.equals(this.__workplace_server_id, o.getWorkplaceServerId())) return false;
		if(!Objects.equals(this.__workplace_id, o.getWorkplaceId())) return false;
		if(!Objects.equals(this.__intranet_server_address, o.getIntranetServerAddress())) return false;
		if(!Objects.equals(this.__intranet_server_port, o.getIntranetServerPort())) return false;
		if(!Objects.equals(this.__external_server_address, o.getExternalServerAddress())) return false;
		if(!Objects.equals(this.__external_server_port, o.getExternalServerPort())) return false;
		if(!Objects.equals(this.__external_server_useable, o.getExternalServerUseable())) return false;
		if(!Objects.equals(this.__url, o.getUrl())) return false;
		if(!Objects.equals(this.__active, o.getActive())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getWorkplaceServerId() != null) sb.append(__wrapNumber(count++, "workplaceServerId", getWorkplaceServerId()));
		if(getWorkplaceId() != null) sb.append(__wrapNumber(count++, "workplaceId", getWorkplaceId()));
		if(getIntranetServerAddress() != null) sb.append(__wrapString(count++, "intranetServerAddress", getIntranetServerAddress()));
		if(getIntranetServerPort() != null) sb.append(__wrapNumber(count++, "intranetServerPort", getIntranetServerPort()));
		if(getExternalServerAddress() != null) sb.append(__wrapString(count++, "externalServerAddress", getExternalServerAddress()));
		if(getExternalServerPort() != null) sb.append(__wrapNumber(count++, "externalServerPort", getExternalServerPort()));
		if(getExternalServerUseable() != null) sb.append(__wrapBoolean(count++, "externalServerUseable", getExternalServerUseable()));
		if(getUrl() != null) sb.append(__wrapString(count++, "url", getUrl()));
		if(getActive() != null) sb.append(__wrapBoolean(count++, "active", getActive()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("workplaceServerId")) != null) setWorkplaceServerId(__getInt(val)); 
		if((val = values.get("workplaceId")) != null) setWorkplaceId(__getInt(val)); 
		if((val = values.get("intranetServerAddress")) != null) setIntranetServerAddress(__getString(val));
		if((val = values.get("intranetServerPort")) != null) setIntranetServerPort(__getInt(val)); 
		if((val = values.get("externalServerAddress")) != null) setExternalServerAddress(__getString(val));
		if((val = values.get("externalServerPort")) != null) setExternalServerPort(__getInt(val)); 
		if((val = values.get("externalServerUseable")) != null) setExternalServerUseable(__getBoolean(val));
		if((val = values.get("url")) != null) setUrl(__getString(val));
		if((val = values.get("active")) != null) setActive(__getBoolean(val));
	}

	protected java.lang.Integer  __workplace_server_id ;
	protected java.lang.Integer  __workplace_id ;
	protected java.lang.String  __intranet_server_address ;
	protected java.lang.Integer  __intranet_server_port ;
	protected java.lang.String  __external_server_address ;
	protected java.lang.Integer  __external_server_port ;
	protected java.lang.Boolean  __external_server_useable ;
	protected java.lang.String  __url ;
	protected java.lang.Boolean  __active ;
}
