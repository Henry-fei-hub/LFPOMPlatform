package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFinancialAccountInitLog extends GenericBase implements BaseFactory<BaseFinancialAccountInitLog>, Comparable<BaseFinancialAccountInitLog> 
{


	public static BaseFinancialAccountInitLog newInstance(){
		return new BaseFinancialAccountInitLog();
	}

	@Override
	public BaseFinancialAccountInitLog make(){
		BaseFinancialAccountInitLog b = new BaseFinancialAccountInitLog();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_ACCOUNT_INIT_LOGS_ID = "financial_account_init_logs_id" ;
	public final static java.lang.String CS_CONTENT = "content" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,日志内容,操作人,操作时间";

	public java.lang.Integer getFinancialAccountInitLogsId() {
		return this.__financial_account_init_logs_id;
	}

	public void setFinancialAccountInitLogsId( java.lang.Integer value ) {
		this.__financial_account_init_logs_id = value;
	}

	public java.lang.String getContent() {
		return this.__content;
	}

	public void setContent( java.lang.String value ) {
		this.__content = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public void cloneCopy(BaseFinancialAccountInitLog __bean){
		__bean.setFinancialAccountInitLogsId(getFinancialAccountInitLogsId());
		__bean.setContent(getContent());
		__bean.setOperatorId(getOperatorId());
		__bean.setOperateTime(getOperateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialAccountInitLogsId() == null ? "" : getFinancialAccountInitLogsId());
		sb.append(",");
		sb.append(getContent() == null ? "" : getContent());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialAccountInitLog o) {
		return __financial_account_init_logs_id == null ? -1 : __financial_account_init_logs_id.compareTo(o.getFinancialAccountInitLogsId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_account_init_logs_id);
		hash = 97 * hash + Objects.hashCode(this.__content);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialAccountInitLog o = (BaseFinancialAccountInitLog)obj;
		if(!Objects.equals(this.__financial_account_init_logs_id, o.getFinancialAccountInitLogsId())) return false;
		if(!Objects.equals(this.__content, o.getContent())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialAccountInitLogsId() != null) sb.append(__wrapNumber(count++, "financialAccountInitLogsId", getFinancialAccountInitLogsId()));
		if(getContent() != null) sb.append(__wrapString(count++, "content", getContent()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialAccountInitLogsId() != null) res.put("financialAccountInitLogsId", getFinancialAccountInitLogsId());
		if(getContent() != null) res.put("content", getContent());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialAccountInitLogsId")) != null) setFinancialAccountInitLogsId(__getInt(val)); 
		if((val = values.get("content")) != null) setContent(__getString(val));
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __financial_account_init_logs_id ;
	protected java.lang.String  __content ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __operate_time ;
}
