package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractLog extends GenericBase implements BaseFactory<BaseContractLog>, Comparable<BaseContractLog> 
{


	public static BaseContractLog newInstance(){
		return new BaseContractLog();
	}

	@Override
	public BaseContractLog make(){
		BaseContractLog b = new BaseContractLog();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_LOG_ID = "contract_log_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_ORIGINAL_STATUS = "original_status" ;
	public final static java.lang.String CS_NEW_STATUS = "new_status" ;
	public final static java.lang.String CS_CONTENT = "content" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_ATTACHMENT_ID = "attachment_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同,原始合同状态,新合同状态,日志,操作人,操作时间,删除状态,附件编码,备注,流程状态";

	public java.lang.Integer getContractLogId() {
		return this.__contract_log_id;
	}

	public void setContractLogId( java.lang.Integer value ) {
		this.__contract_log_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getOriginalStatus() {
		return this.__original_status;
	}

	public void setOriginalStatus( java.lang.Integer value ) {
		this.__original_status = value;
	}

	public java.lang.Integer getNewStatus() {
		return this.__new_status;
	}

	public void setNewStatus( java.lang.Integer value ) {
		this.__new_status = value;
	}

	public java.lang.String getContent() {
		return this.__content;
	}

	public void setContent( java.lang.String value ) {
		this.__content = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getAttachmentId() {
		return this.__attachment_id;
	}

	public void setAttachmentId( java.lang.Integer value ) {
		this.__attachment_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public void cloneCopy(BaseContractLog __bean){
		__bean.setContractLogId(getContractLogId());
		__bean.setContractId(getContractId());
		__bean.setOriginalStatus(getOriginalStatus());
		__bean.setNewStatus(getNewStatus());
		__bean.setContent(getContent());
		__bean.setOperator(getOperator());
		__bean.setOperateTime(getOperateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setAttachmentId(getAttachmentId());
		__bean.setRemark(getRemark());
		__bean.setProcessStatus(getProcessStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractLogId() == null ? "" : getContractLogId());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strOriginalStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_35", String.valueOf(getOriginalStatus()));
		sb.append(strOriginalStatus == null ? "" : strOriginalStatus);
		sb.append(",");
		String strNewStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_35", String.valueOf(getNewStatus()));
		sb.append(strNewStatus == null ? "" : strNewStatus);
		sb.append(",");
		sb.append(getContent() == null ? "" : getContent());
		sb.append(",");
		String strOperator = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperator()));
		sb.append(strOperator == null ? "" : strOperator);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getAttachmentId() == null ? "" : getAttachmentId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		String strProcessStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_120", String.valueOf(getProcessStatus()));
		sb.append(strProcessStatus == null ? "" : strProcessStatus);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractLog o) {
		return __contract_log_id == null ? -1 : __contract_log_id.compareTo(o.getContractLogId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_log_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__original_status);
		hash = 97 * hash + Objects.hashCode(this.__new_status);
		hash = 97 * hash + Objects.hashCode(this.__content);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractLog o = (BaseContractLog)obj;
		if(!Objects.equals(this.__contract_log_id, o.getContractLogId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__original_status, o.getOriginalStatus())) return false;
		if(!Objects.equals(this.__new_status, o.getNewStatus())) return false;
		if(!Objects.equals(this.__content, o.getContent())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__attachment_id, o.getAttachmentId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractLogId() != null) sb.append(__wrapNumber(count++, "contractLogId", getContractLogId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getOriginalStatus() != null) sb.append(__wrapNumber(count++, "originalStatus", getOriginalStatus()));
		if(getNewStatus() != null) sb.append(__wrapNumber(count++, "newStatus", getNewStatus()));
		if(getContent() != null) sb.append(__wrapString(count++, "content", getContent()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getAttachmentId() != null) sb.append(__wrapNumber(count++, "attachmentId", getAttachmentId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractLogId() != null) res.put("contractLogId", getContractLogId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getOriginalStatus() != null) res.put("originalStatus", getOriginalStatus());
		if(getNewStatus() != null) res.put("newStatus", getNewStatus());
		if(getContent() != null) res.put("content", getContent());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getAttachmentId() != null) res.put("attachmentId", getAttachmentId());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractLogId")) != null) setContractLogId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("originalStatus")) != null) setOriginalStatus(__getInt(val)); 
		if((val = values.get("newStatus")) != null) setNewStatus(__getInt(val)); 
		if((val = values.get("content")) != null) setContent(__getString(val));
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("attachmentId")) != null) setAttachmentId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __contract_log_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __original_status ;
	protected java.lang.Integer  __new_status ;
	protected java.lang.String  __content ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __operate_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __attachment_id ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __process_status ;
}
