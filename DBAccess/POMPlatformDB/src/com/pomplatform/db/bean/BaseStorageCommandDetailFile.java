package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseStorageCommandDetailFile extends GenericBase implements BaseFactory<BaseStorageCommandDetailFile>, Comparable<BaseStorageCommandDetailFile> 
{


	public static BaseStorageCommandDetailFile newInstance(){
		return new BaseStorageCommandDetailFile();
	}

	@Override
	public BaseStorageCommandDetailFile make(){
		BaseStorageCommandDetailFile b = new BaseStorageCommandDetailFile();
		return b;
	}

	public final static java.lang.String CS_STORAGE_COMMAND_DETAIL_ID = "storage_command_detail_id" ;
	public final static java.lang.String CS_STORAGE_COMMAND_ID = "storage_command_id" ;
	public final static java.lang.String CS_CWD_TASK_PROCESS_ID = "cwd_task_process_id" ;
	public final static java.lang.String CS_OPERATION_TYPE = "operation_type" ;
	public final static java.lang.String CS_ORIGINAL_FILE_ID = "original_file_id" ;
	public final static java.lang.String CS_ORIGINAL_FILE_PATH = "original_file_path" ;
	public final static java.lang.String CS_NEW_FILE_ID = "new_file_id" ;
	public final static java.lang.String CS_NEW_FILE_PATH = "new_file_path" ;
	public final static java.lang.String CS_DEAL_STATUS = "deal_status" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,命令主表编码,任务流程编码, 2重命名,原文件编码,原文件路径,新文件编码,新文件路径, 1已处理,创建时间,完成时间,备注";

	public java.lang.Integer getStorageCommandDetailId() {
		return this.__storage_command_detail_id;
	}

	public void setStorageCommandDetailId( java.lang.Integer value ) {
		this.__storage_command_detail_id = value;
	}

	public java.lang.Integer getStorageCommandId() {
		return this.__storage_command_id;
	}

	public void setStorageCommandId( java.lang.Integer value ) {
		this.__storage_command_id = value;
	}

	public java.lang.Integer getCwdTaskProcessId() {
		return this.__cwd_task_process_id;
	}

	public void setCwdTaskProcessId( java.lang.Integer value ) {
		this.__cwd_task_process_id = value;
	}

	public java.lang.Integer getOperationType() {
		return this.__operation_type;
	}

	public void setOperationType( java.lang.Integer value ) {
		this.__operation_type = value;
	}

	public java.lang.Integer getOriginalFileId() {
		return this.__original_file_id;
	}

	public void setOriginalFileId( java.lang.Integer value ) {
		this.__original_file_id = value;
	}

	public java.lang.String getOriginalFilePath() {
		return this.__original_file_path;
	}

	public void setOriginalFilePath( java.lang.String value ) {
		this.__original_file_path = value;
	}

	public java.lang.Integer getNewFileId() {
		return this.__new_file_id;
	}

	public void setNewFileId( java.lang.Integer value ) {
		this.__new_file_id = value;
	}

	public java.lang.String getNewFilePath() {
		return this.__new_file_path;
	}

	public void setNewFilePath( java.lang.String value ) {
		this.__new_file_path = value;
	}

	public java.lang.Integer getDealStatus() {
		return this.__deal_status;
	}

	public void setDealStatus( java.lang.Integer value ) {
		this.__deal_status = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseStorageCommandDetailFile __bean){
		__bean.setStorageCommandDetailId(getStorageCommandDetailId());
		__bean.setStorageCommandId(getStorageCommandId());
		__bean.setCwdTaskProcessId(getCwdTaskProcessId());
		__bean.setOperationType(getOperationType());
		__bean.setOriginalFileId(getOriginalFileId());
		__bean.setOriginalFilePath(getOriginalFilePath());
		__bean.setNewFileId(getNewFileId());
		__bean.setNewFilePath(getNewFilePath());
		__bean.setDealStatus(getDealStatus());
		__bean.setCreateTime(getCreateTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getStorageCommandDetailId() == null ? "" : getStorageCommandDetailId());
		sb.append(",");
		sb.append(getStorageCommandId() == null ? "" : getStorageCommandId());
		sb.append(",");
		sb.append(getCwdTaskProcessId() == null ? "" : getCwdTaskProcessId());
		sb.append(",");
		sb.append(getOperationType() == null ? "" : getOperationType());
		sb.append(",");
		sb.append(getOriginalFileId() == null ? "" : getOriginalFileId());
		sb.append(",");
		sb.append(getOriginalFilePath() == null ? "" : getOriginalFilePath());
		sb.append(",");
		sb.append(getNewFileId() == null ? "" : getNewFileId());
		sb.append(",");
		sb.append(getNewFilePath() == null ? "" : getNewFilePath());
		sb.append(",");
		sb.append(getDealStatus() == null ? "" : getDealStatus());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStorageCommandDetailFile o) {
		return __storage_command_detail_id == null ? -1 : __storage_command_detail_id.compareTo(o.getStorageCommandDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__storage_command_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__storage_command_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_task_process_id);
		hash = 97 * hash + Objects.hashCode(this.__operation_type);
		hash = 97 * hash + Objects.hashCode(this.__original_file_id);
		hash = 97 * hash + Objects.hashCode(this.__original_file_path);
		hash = 97 * hash + Objects.hashCode(this.__new_file_id);
		hash = 97 * hash + Objects.hashCode(this.__new_file_path);
		hash = 97 * hash + Objects.hashCode(this.__deal_status);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStorageCommandDetailFile o = (BaseStorageCommandDetailFile)obj;
		if(!Objects.equals(this.__storage_command_detail_id, o.getStorageCommandDetailId())) return false;
		if(!Objects.equals(this.__storage_command_id, o.getStorageCommandId())) return false;
		if(!Objects.equals(this.__cwd_task_process_id, o.getCwdTaskProcessId())) return false;
		if(!Objects.equals(this.__operation_type, o.getOperationType())) return false;
		if(!Objects.equals(this.__original_file_id, o.getOriginalFileId())) return false;
		if(!Objects.equals(this.__original_file_path, o.getOriginalFilePath())) return false;
		if(!Objects.equals(this.__new_file_id, o.getNewFileId())) return false;
		if(!Objects.equals(this.__new_file_path, o.getNewFilePath())) return false;
		if(!Objects.equals(this.__deal_status, o.getDealStatus())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStorageCommandDetailId() != null) sb.append(__wrapNumber(count++, "storageCommandDetailId", getStorageCommandDetailId()));
		if(getStorageCommandId() != null) sb.append(__wrapNumber(count++, "storageCommandId", getStorageCommandId()));
		if(getCwdTaskProcessId() != null) sb.append(__wrapNumber(count++, "cwdTaskProcessId", getCwdTaskProcessId()));
		if(getOperationType() != null) sb.append(__wrapNumber(count++, "operationType", getOperationType()));
		if(getOriginalFileId() != null) sb.append(__wrapNumber(count++, "originalFileId", getOriginalFileId()));
		if(getOriginalFilePath() != null) sb.append(__wrapString(count++, "originalFilePath", getOriginalFilePath()));
		if(getNewFileId() != null) sb.append(__wrapNumber(count++, "newFileId", getNewFileId()));
		if(getNewFilePath() != null) sb.append(__wrapString(count++, "newFilePath", getNewFilePath()));
		if(getDealStatus() != null) sb.append(__wrapNumber(count++, "dealStatus", getDealStatus()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("storageCommandDetailId")) != null) setStorageCommandDetailId(__getInt(val)); 
		if((val = values.get("storageCommandId")) != null) setStorageCommandId(__getInt(val)); 
		if((val = values.get("cwdTaskProcessId")) != null) setCwdTaskProcessId(__getInt(val)); 
		if((val = values.get("operationType")) != null) setOperationType(__getInt(val)); 
		if((val = values.get("originalFileId")) != null) setOriginalFileId(__getInt(val)); 
		if((val = values.get("originalFilePath")) != null) setOriginalFilePath(__getString(val));
		if((val = values.get("newFileId")) != null) setNewFileId(__getInt(val)); 
		if((val = values.get("newFilePath")) != null) setNewFilePath(__getString(val));
		if((val = values.get("dealStatus")) != null) setDealStatus(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __storage_command_detail_id ;
	protected java.lang.Integer  __storage_command_id ;
	protected java.lang.Integer  __cwd_task_process_id ;
	protected java.lang.Integer  __operation_type ;
	protected java.lang.Integer  __original_file_id ;
	protected java.lang.String  __original_file_path ;
	protected java.lang.Integer  __new_file_id ;
	protected java.lang.String  __new_file_path ;
	protected java.lang.Integer  __deal_status ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.String  __remark ;
}
