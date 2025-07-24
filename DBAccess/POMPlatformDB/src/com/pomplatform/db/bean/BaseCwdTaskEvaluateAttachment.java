package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdTaskEvaluateAttachment extends GenericBase implements BaseFactory<BaseCwdTaskEvaluateAttachment>, Comparable<BaseCwdTaskEvaluateAttachment> 
{


	public static BaseCwdTaskEvaluateAttachment newInstance(){
		return new BaseCwdTaskEvaluateAttachment();
	}

	@Override
	public BaseCwdTaskEvaluateAttachment make(){
		BaseCwdTaskEvaluateAttachment b = new BaseCwdTaskEvaluateAttachment();
		return b;
	}

	public final static java.lang.String CS_CWD_TASK_EVALUATE_ATTACHMENT_ID = "cwd_task_evaluate_attachment_id" ;
	public final static java.lang.String CS_CWD_TASK_EVALUATE_ID = "cwd_task_evaluate_id" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,评审(评价)表主键,文件表主键,创建时间";

	public java.lang.Integer getCwdTaskEvaluateAttachmentId() {
		return this.__cwd_task_evaluate_attachment_id;
	}

	public void setCwdTaskEvaluateAttachmentId( java.lang.Integer value ) {
		this.__cwd_task_evaluate_attachment_id = value;
	}

	public java.lang.Integer getCwdTaskEvaluateId() {
		return this.__cwd_task_evaluate_id;
	}

	public void setCwdTaskEvaluateId( java.lang.Integer value ) {
		this.__cwd_task_evaluate_id = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdTaskEvaluateAttachment __bean){
		__bean.setCwdTaskEvaluateAttachmentId(getCwdTaskEvaluateAttachmentId());
		__bean.setCwdTaskEvaluateId(getCwdTaskEvaluateId());
		__bean.setFileId(getFileId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdTaskEvaluateAttachmentId() == null ? "" : getCwdTaskEvaluateAttachmentId());
		sb.append(",");
		sb.append(getCwdTaskEvaluateId() == null ? "" : getCwdTaskEvaluateId());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdTaskEvaluateAttachment o) {
		return __cwd_task_evaluate_attachment_id == null ? -1 : __cwd_task_evaluate_attachment_id.compareTo(o.getCwdTaskEvaluateAttachmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_evaluate_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_evaluate_id);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdTaskEvaluateAttachment o = (BaseCwdTaskEvaluateAttachment)obj;
		if(!Objects.equals(this.__cwd_task_evaluate_attachment_id, o.getCwdTaskEvaluateAttachmentId())) return false;
		if(!Objects.equals(this.__cwd_task_evaluate_id, o.getCwdTaskEvaluateId())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdTaskEvaluateAttachmentId() != null) sb.append(__wrapNumber(count++, "cwdTaskEvaluateAttachmentId", getCwdTaskEvaluateAttachmentId()));
		if(getCwdTaskEvaluateId() != null) sb.append(__wrapNumber(count++, "cwdTaskEvaluateId", getCwdTaskEvaluateId()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdTaskEvaluateAttachmentId")) != null) setCwdTaskEvaluateAttachmentId(__getInt(val)); 
		if((val = values.get("cwdTaskEvaluateId")) != null) setCwdTaskEvaluateId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __cwd_task_evaluate_attachment_id ;
	protected java.lang.Integer  __cwd_task_evaluate_id ;
	protected java.lang.Integer  __file_id ;
	protected java.util.Date  __create_time ;
}
