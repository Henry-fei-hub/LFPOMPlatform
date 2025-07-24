package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCapitalLog extends GenericBase implements BaseFactory<BaseCapitalLog>, Comparable<BaseCapitalLog> 
{


	public static BaseCapitalLog newInstance(){
		return new BaseCapitalLog();
	}

	@Override
	public BaseCapitalLog make(){
		BaseCapitalLog b = new BaseCapitalLog();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_LOG_ID = "capital_log_id" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_LOG_CONTENT = "log_content" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;

	public final static java.lang.String ALL_CAPTIONS = "汇率表编码,operator,申请缘由,操作时间,回款编码";

	public java.lang.Integer getCapitalLogId() {
		return this.__capital_log_id;
	}

	public void setCapitalLogId( java.lang.Integer value ) {
		this.__capital_log_id = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.String getLogContent() {
		return this.__log_content;
	}

	public void setLogContent( java.lang.String value ) {
		this.__log_content = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public void cloneCopy(BaseCapitalLog __bean){
		__bean.setCapitalLogId(getCapitalLogId());
		__bean.setOperator(getOperator());
		__bean.setLogContent(getLogContent());
		__bean.setCreateTime(getCreateTime());
		__bean.setCapitalId(getCapitalId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalLogId() == null ? "" : getCapitalLogId());
		sb.append(",");
		String strOperator = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperator()));
		sb.append(strOperator == null ? "" : strOperator);
		sb.append(",");
		sb.append(getLogContent() == null ? "" : getLogContent());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCapitalLog o) {
		return __capital_log_id == null ? -1 : __capital_log_id.compareTo(o.getCapitalLogId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_log_id);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__log_content);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCapitalLog o = (BaseCapitalLog)obj;
		if(!Objects.equals(this.__capital_log_id, o.getCapitalLogId())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__log_content, o.getLogContent())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalLogId() != null) sb.append(__wrapNumber(count++, "capitalLogId", getCapitalLogId()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getLogContent() != null) sb.append(__wrapString(count++, "logContent", getLogContent()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalLogId")) != null) setCapitalLogId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("logContent")) != null) setLogContent(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
	}

	protected java.lang.Integer  __capital_log_id ;
	protected java.lang.Integer  __operator ;
	protected java.lang.String  __log_content ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __capital_id ;
}
