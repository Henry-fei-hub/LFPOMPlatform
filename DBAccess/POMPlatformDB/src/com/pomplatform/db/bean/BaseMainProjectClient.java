package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseMainProjectClient extends GenericBase implements BaseFactory<BaseMainProjectClient>, Comparable<BaseMainProjectClient> 
{


	public static BaseMainProjectClient newInstance(){
		return new BaseMainProjectClient();
	}

	@Override
	public BaseMainProjectClient make(){
		BaseMainProjectClient b = new BaseMainProjectClient();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CLIENT_ID = "client_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主项目编码,客户编码";

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getClientId() {
		return this.__client_id;
	}

	public void setClientId( java.lang.Integer value ) {
		this.__client_id = value;
	}

	public void cloneCopy(BaseMainProjectClient __bean){
		__bean.setMainProjectId(getMainProjectId());
		__bean.setClientId(getClientId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getClientId() == null ? "" : getClientId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMainProjectClient o) {
		return __main_project_id == null ? -1 : __main_project_id.compareTo(o.getMainProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__client_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProjectClient o = (BaseMainProjectClient)obj;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__client_id, o.getClientId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getClientId() != null) sb.append(__wrapNumber(count++, "clientId", getClientId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("clientId")) != null) setClientId(__getInt(val)); 
	}

	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __client_id ;
}
