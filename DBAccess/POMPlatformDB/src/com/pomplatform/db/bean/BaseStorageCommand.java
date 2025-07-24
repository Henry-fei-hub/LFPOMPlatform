package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseStorageCommand extends GenericBase implements BaseFactory<BaseStorageCommand>, Comparable<BaseStorageCommand> 
{


	public static BaseStorageCommand newInstance(){
		return new BaseStorageCommand();
	}

	@Override
	public BaseStorageCommand make(){
		BaseStorageCommand b = new BaseStorageCommand();
		return b;
	}

	public final static java.lang.String CS_STORAGE_COMMAND_ID = "storage_command_id" ;
	public final static java.lang.String CS_COMMAND_TYPE = "command_type" ;
	public final static java.lang.String CS_WORKPLACE_ID = "workplace_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_COPY_TYPE = "copy_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,命令类型 1文件操作,工作场所,备注,创建时间,完成时间, 1已删除,0 通用拷贝 1拷贝到审核区 2由审核区拷贝到指定归属区域";

	public java.lang.Integer getStorageCommandId() {
		return this.__storage_command_id;
	}

	public void setStorageCommandId( java.lang.Integer value ) {
		this.__storage_command_id = value;
	}

	public java.lang.Integer getCommandType() {
		return this.__command_type;
	}

	public void setCommandType( java.lang.Integer value ) {
		this.__command_type = value;
	}

	public java.lang.Integer getWorkplaceId() {
		return this.__workplace_id;
	}

	public void setWorkplaceId( java.lang.Integer value ) {
		this.__workplace_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
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

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getCopyType() {
		return this.__copy_type;
	}

	public void setCopyType( java.lang.Integer value ) {
		this.__copy_type = value;
	}

	public void cloneCopy(BaseStorageCommand __bean){
		__bean.setStorageCommandId(getStorageCommandId());
		__bean.setCommandType(getCommandType());
		__bean.setWorkplaceId(getWorkplaceId());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setCopyType(getCopyType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getStorageCommandId() == null ? "" : getStorageCommandId());
		sb.append(",");
		sb.append(getCommandType() == null ? "" : getCommandType());
		sb.append(",");
		sb.append(getWorkplaceId() == null ? "" : getWorkplaceId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getCopyType() == null ? "" : getCopyType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStorageCommand o) {
		return __storage_command_id == null ? -1 : __storage_command_id.compareTo(o.getStorageCommandId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__storage_command_id);
		hash = 97 * hash + Objects.hashCode(this.__command_type);
		hash = 97 * hash + Objects.hashCode(this.__workplace_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__copy_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStorageCommand o = (BaseStorageCommand)obj;
		if(!Objects.equals(this.__storage_command_id, o.getStorageCommandId())) return false;
		if(!Objects.equals(this.__command_type, o.getCommandType())) return false;
		if(!Objects.equals(this.__workplace_id, o.getWorkplaceId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__copy_type, o.getCopyType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStorageCommandId() != null) sb.append(__wrapNumber(count++, "storageCommandId", getStorageCommandId()));
		if(getCommandType() != null) sb.append(__wrapNumber(count++, "commandType", getCommandType()));
		if(getWorkplaceId() != null) sb.append(__wrapNumber(count++, "workplaceId", getWorkplaceId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getCopyType() != null) sb.append(__wrapNumber(count++, "copyType", getCopyType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("storageCommandId")) != null) setStorageCommandId(__getInt(val)); 
		if((val = values.get("commandType")) != null) setCommandType(__getInt(val)); 
		if((val = values.get("workplaceId")) != null) setWorkplaceId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("copyType")) != null) setCopyType(__getInt(val)); 
	}

	protected java.lang.Integer  __storage_command_id ;
	protected java.lang.Integer  __command_type ;
	protected java.lang.Integer  __workplace_id ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __copy_type ;
}
