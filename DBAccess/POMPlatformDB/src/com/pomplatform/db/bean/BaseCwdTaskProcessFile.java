package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdTaskProcessFile extends GenericBase implements BaseFactory<BaseCwdTaskProcessFile>, Comparable<BaseCwdTaskProcessFile> 
{


	public static BaseCwdTaskProcessFile newInstance(){
		return new BaseCwdTaskProcessFile();
	}

	@Override
	public BaseCwdTaskProcessFile make(){
		BaseCwdTaskProcessFile b = new BaseCwdTaskProcessFile();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_PROCESS_FILE_ID = "cwd_task_process_file_id" ;
	public final static java.lang.String CS_CWD_TASK_PROCESS_ID = "cwd_task_process_id" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_CWD_FILING_MANAGE_DETAIL_ID = "cwd_filing_manage_detail_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,任务流程编码,文件/文件夹,文件归档详情主键";

	public java.lang.Integer getCwdTaskProcessFileId() {
		return this.__cwd_task_process_file_id;
	}

	public void setCwdTaskProcessFileId( java.lang.Integer value ) {
		this.__cwd_task_process_file_id = value;
	}

	public java.lang.Integer getCwdTaskProcessId() {
		return this.__cwd_task_process_id;
	}

	public void setCwdTaskProcessId( java.lang.Integer value ) {
		this.__cwd_task_process_id = value;
	}

	public java.lang.Integer getCwdFileId() {
		return this.__cwd_file_id;
	}

	public void setCwdFileId( java.lang.Integer value ) {
		this.__cwd_file_id = value;
	}

	public java.lang.Integer getCwdFilingManageDetailId() {
		return this.__cwd_filing_manage_detail_id;
	}

	public void setCwdFilingManageDetailId( java.lang.Integer value ) {
		this.__cwd_filing_manage_detail_id = value;
	}

	public void cloneCopy(BaseCwdTaskProcessFile __bean){
		__bean.setCwdTaskProcessFileId(getCwdTaskProcessFileId());
		__bean.setCwdTaskProcessId(getCwdTaskProcessId());
		__bean.setCwdFileId(getCwdFileId());
		__bean.setCwdFilingManageDetailId(getCwdFilingManageDetailId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskProcessFileId() == null ? "" : getCwdTaskProcessFileId());
		sb.append(",");
		sb.append(getCwdTaskProcessId() == null ? "" : getCwdTaskProcessId());
		sb.append(",");
		sb.append(getCwdFileId() == null ? "" : getCwdFileId());
		sb.append(",");
		sb.append(getCwdFilingManageDetailId() == null ? "" : getCwdFilingManageDetailId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdTaskProcessFile o) {
		return __cwd_task_process_file_id == null ? -1 : __cwd_task_process_file_id.compareTo(o.getCwdTaskProcessFileId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_process_file_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_process_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_manage_detail_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdTaskProcessFile o = (BaseCwdTaskProcessFile)obj;
		if(!Objects.equals(this.__cwd_task_process_file_id, o.getCwdTaskProcessFileId())) return false;
		if(!Objects.equals(this.__cwd_task_process_id, o.getCwdTaskProcessId())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__cwd_filing_manage_detail_id, o.getCwdFilingManageDetailId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskProcessFileId() != null) sb.append(__wrapNumber(count++, "cwdTaskProcessFileId", getCwdTaskProcessFileId()));
		if(getCwdTaskProcessId() != null) sb.append(__wrapNumber(count++, "cwdTaskProcessId", getCwdTaskProcessId()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getCwdFilingManageDetailId() != null) sb.append(__wrapNumber(count++, "cwdFilingManageDetailId", getCwdFilingManageDetailId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskProcessFileId")) != null) setCwdTaskProcessFileId(__getInt(val)); 
		if((val = values.get("cwdTaskProcessId")) != null) setCwdTaskProcessId(__getInt(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("cwdFilingManageDetailId")) != null) setCwdFilingManageDetailId(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_task_process_file_id ;
	protected java.lang.Integer  __cwd_task_process_id ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.lang.Integer  __cwd_filing_manage_detail_id ;
}
