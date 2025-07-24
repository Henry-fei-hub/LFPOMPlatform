package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseMainProjectBasicFile extends GenericBase implements BaseFactory<BaseMainProjectBasicFile>, Comparable<BaseMainProjectBasicFile> 
{


	public static BaseMainProjectBasicFile newInstance(){
		return new BaseMainProjectBasicFile();
	}

	@Override
	public BaseMainProjectBasicFile make(){
		BaseMainProjectBasicFile b = new BaseMainProjectBasicFile();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_BASIC_FILE_ID = "main_project_basic_file_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = ",大项目主键,文件主键,操作人主键,创建时间";

	public java.lang.Integer getMainProjectBasicFileId() {
		return this.__main_project_basic_file_id;
	}

	public void setMainProjectBasicFileId( java.lang.Integer value ) {
		this.__main_project_basic_file_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getCwdFileId() {
		return this.__cwd_file_id;
	}

	public void setCwdFileId( java.lang.Integer value ) {
		this.__cwd_file_id = value;
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

	public void cloneCopy(BaseMainProjectBasicFile __bean){
		__bean.setMainProjectBasicFileId(getMainProjectBasicFileId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setCwdFileId(getCwdFileId());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectBasicFileId() == null ? "" : getMainProjectBasicFileId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getCwdFileId() == null ? "" : getCwdFileId());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMainProjectBasicFile o) {
		return __main_project_basic_file_id == null ? -1 : __main_project_basic_file_id.compareTo(o.getMainProjectBasicFileId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_basic_file_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProjectBasicFile o = (BaseMainProjectBasicFile)obj;
		if(!Objects.equals(this.__main_project_basic_file_id, o.getMainProjectBasicFileId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectBasicFileId() != null) sb.append(__wrapNumber(count++, "mainProjectBasicFileId", getMainProjectBasicFileId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectBasicFileId")) != null) setMainProjectBasicFileId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __main_project_basic_file_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __create_time ;
}
