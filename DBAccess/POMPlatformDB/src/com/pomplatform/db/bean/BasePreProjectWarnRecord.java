package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePreProjectWarnRecord extends GenericBase implements BaseFactory<BasePreProjectWarnRecord>, Comparable<BasePreProjectWarnRecord> 
{


	public static BasePreProjectWarnRecord newInstance(){
		return new BasePreProjectWarnRecord();
	}

	@Override
	public BasePreProjectWarnRecord make(){
		BasePreProjectWarnRecord b = new BasePreProjectWarnRecord();
		return b;
	}

	public final static java.lang.String CS_PRE_PROJECT_WARN_RECORD_ID = "pre_project_warn_record_id" ;
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_WARN_DAYS = "warn_days" ;
	public final static java.lang.String CS_WARN_CONTENT = "warn_content" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_RECORD_TIME = "record_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,前期项目编码,信息编号,项目编号,项目名称,收到警告人员,报警天数,报警内容,记录日期,记录时间";

	public java.lang.Integer getPreProjectWarnRecordId() {
		return this.__pre_project_warn_record_id;
	}

	public void setPreProjectWarnRecordId( java.lang.Integer value ) {
		this.__pre_project_warn_record_id = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getWarnDays() {
		return this.__warn_days;
	}

	public void setWarnDays( java.lang.Integer value ) {
		this.__warn_days = value;
	}

	public java.lang.String getWarnContent() {
		return this.__warn_content;
	}

	public void setWarnContent( java.lang.String value ) {
		this.__warn_content = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.util.Date getRecordTime() {
		return this.__record_time;
	}

	public void setRecordTime( java.util.Date value ) {
		this.__record_time = value;
	}

	public void cloneCopy(BasePreProjectWarnRecord __bean){
		__bean.setPreProjectWarnRecordId(getPreProjectWarnRecordId());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setWarnDays(getWarnDays());
		__bean.setWarnContent(getWarnContent());
		__bean.setRecordDate(getRecordDate());
		__bean.setRecordTime(getRecordTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPreProjectWarnRecordId() == null ? "" : getPreProjectWarnRecordId());
		sb.append(",");
		sb.append(getPreProjectId() == null ? "" : getPreProjectId());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getWarnDays() == null ? "" : getWarnDays());
		sb.append(",");
		sb.append(getWarnContent() == null ? "" : getWarnContent());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getRecordTime() == null ? "" : sdf.format(getRecordTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BasePreProjectWarnRecord o) {
		return __pre_project_warn_record_id == null ? -1 : __pre_project_warn_record_id.compareTo(o.getPreProjectWarnRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pre_project_warn_record_id);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__warn_days);
		hash = 97 * hash + Objects.hashCode(this.__warn_content);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__record_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePreProjectWarnRecord o = (BasePreProjectWarnRecord)obj;
		if(!Objects.equals(this.__pre_project_warn_record_id, o.getPreProjectWarnRecordId())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__warn_days, o.getWarnDays())) return false;
		if(!Objects.equals(this.__warn_content, o.getWarnContent())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__record_time, o.getRecordTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPreProjectWarnRecordId() != null) sb.append(__wrapNumber(count++, "preProjectWarnRecordId", getPreProjectWarnRecordId()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getWarnDays() != null) sb.append(__wrapNumber(count++, "warnDays", getWarnDays()));
		if(getWarnContent() != null) sb.append(__wrapString(count++, "warnContent", getWarnContent()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getRecordTime() != null) sb.append(__wrapDate(count++, "recordTime", getRecordTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("preProjectWarnRecordId")) != null) setPreProjectWarnRecordId(__getInt(val)); 
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("warnDays")) != null) setWarnDays(__getInt(val)); 
		if((val = values.get("warnContent")) != null) setWarnContent(__getString(val));
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("recordTime")) != null) setRecordTime(__getDate(val)); 
	}

	protected java.lang.Integer  __pre_project_warn_record_id ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __warn_days ;
	protected java.lang.String  __warn_content ;
	protected java.util.Date  __record_date ;
	protected java.util.Date  __record_time ;
}
