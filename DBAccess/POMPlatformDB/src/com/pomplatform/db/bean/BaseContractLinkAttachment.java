package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContractLinkAttachment extends GenericBase implements BaseFactory<BaseContractLinkAttachment>, Comparable<BaseContractLinkAttachment> 
{


	public static BaseContractLinkAttachment newInstance(){
		return new BaseContractLinkAttachment();
	}

	@Override
	public BaseContractLinkAttachment make(){
		BaseContractLinkAttachment b = new BaseContractLinkAttachment();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_LINK_ATTACHMENT_ID = "contract_link_attachment_id" ;
	public final static java.lang.String CS_CONTRACT_ATTACHMENT_ID = "contract_attachment_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同附件Id,合同编码,附件编码,操作人员,操作时间,备注";

	public java.lang.Integer getContractLinkAttachmentId() {
		return this.__contract_link_attachment_id;
	}

	public void setContractLinkAttachmentId( java.lang.Integer value ) {
		this.__contract_link_attachment_id = value;
	}

	public java.lang.Integer getContractAttachmentId() {
		return this.__contract_attachment_id;
	}

	public void setContractAttachmentId( java.lang.Integer value ) {
		this.__contract_attachment_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseContractLinkAttachment __bean){
		__bean.setContractLinkAttachmentId(getContractLinkAttachmentId());
		__bean.setContractAttachmentId(getContractAttachmentId());
		__bean.setContractId(getContractId());
		__bean.setFileId(getFileId());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractLinkAttachmentId() == null ? "" : getContractLinkAttachmentId());
		sb.append(",");
		sb.append(getContractAttachmentId() == null ? "" : getContractAttachmentId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractLinkAttachment o) {
		return __contract_link_attachment_id == null ? -1 : __contract_link_attachment_id.compareTo(o.getContractLinkAttachmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_link_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractLinkAttachment o = (BaseContractLinkAttachment)obj;
		if(!Objects.equals(this.__contract_link_attachment_id, o.getContractLinkAttachmentId())) return false;
		if(!Objects.equals(this.__contract_attachment_id, o.getContractAttachmentId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractLinkAttachmentId() != null) sb.append(__wrapNumber(count++, "contractLinkAttachmentId", getContractLinkAttachmentId()));
		if(getContractAttachmentId() != null) sb.append(__wrapNumber(count++, "contractAttachmentId", getContractAttachmentId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractLinkAttachmentId")) != null) setContractLinkAttachmentId(__getInt(val)); 
		if((val = values.get("contractAttachmentId")) != null) setContractAttachmentId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __contract_link_attachment_id ;
	protected java.lang.Integer  __contract_attachment_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
