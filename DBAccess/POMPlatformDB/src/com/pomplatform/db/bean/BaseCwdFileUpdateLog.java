package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFileUpdateLog extends GenericBase implements BaseFactory<BaseCwdFileUpdateLog>, Comparable<BaseCwdFileUpdateLog> 
{


	public static BaseCwdFileUpdateLog newInstance(){
		return new BaseCwdFileUpdateLog();
	}

	@Override
	public BaseCwdFileUpdateLog make(){
		BaseCwdFileUpdateLog b = new BaseCwdFileUpdateLog();
		return b;
	}

	public final static java.lang.String CS_FILE_UPDATE_LOG_ID = "file_update_log_id" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_BEGIN_TIME = "begin_time" ;
	public final static java.lang.String CS_END_TIME = "end_time" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,关联文件主键,开始时间,结束时间,操作人,创建时间";

	public java.lang.Integer getFileUpdateLogId() {
		return this.__file_update_log_id;
	}

	public void setFileUpdateLogId( java.lang.Integer value ) {
		this.__file_update_log_id = value;
	}

	public java.lang.Integer getCwdFileId() {
		return this.__cwd_file_id;
	}

	public void setCwdFileId( java.lang.Integer value ) {
		this.__cwd_file_id = value;
	}

	public java.util.Date getBeginTime() {
		return this.__begin_time;
	}

	public void setBeginTime( java.util.Date value ) {
		this.__begin_time = value;
	}

	public java.util.Date getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( java.util.Date value ) {
		this.__end_time = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdFileUpdateLog __bean){
		__bean.setFileUpdateLogId(getFileUpdateLogId());
		__bean.setCwdFileId(getCwdFileId());
		__bean.setBeginTime(getBeginTime());
		__bean.setEndTime(getEndTime());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFileUpdateLogId() == null ? "" : getFileUpdateLogId());
		sb.append(",");
		sb.append(getCwdFileId() == null ? "" : getCwdFileId());
		sb.append(",");
		sb.append(getBeginTime() == null ? "" : sdf.format(getBeginTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFileUpdateLog o) {
		return __file_update_log_id == null ? -1 : __file_update_log_id.compareTo(o.getFileUpdateLogId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__file_update_log_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__begin_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFileUpdateLog o = (BaseCwdFileUpdateLog)obj;
		if(!Objects.equals(this.__file_update_log_id, o.getFileUpdateLogId())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__begin_time, o.getBeginTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFileUpdateLogId() != null) sb.append(__wrapNumber(count++, "fileUpdateLogId", getFileUpdateLogId()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getBeginTime() != null) sb.append(__wrapDate(count++, "beginTime", getBeginTime()));
		if(getEndTime() != null) sb.append(__wrapDate(count++, "endTime", getEndTime()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFileUpdateLogId() != null) res.put("fileUpdateLogId", getFileUpdateLogId());
		if(getCwdFileId() != null) res.put("cwdFileId", getCwdFileId());
		if(getBeginTime() != null) res.put("beginTime", getBeginTime());
		if(getEndTime() != null) res.put("endTime", getEndTime());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fileUpdateLogId")) != null) setFileUpdateLogId(__getInt(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("beginTime")) != null) setBeginTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __file_update_log_id ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.util.Date  __begin_time ;
	protected java.util.Date  __end_time ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
}
