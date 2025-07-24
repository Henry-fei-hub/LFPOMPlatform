package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAttachmentLinkContractReceivable extends GenericBase implements BaseFactory<BaseAttachmentLinkContractReceivable>, Comparable<BaseAttachmentLinkContractReceivable> 
{


	public static BaseAttachmentLinkContractReceivable newInstance(){
		return new BaseAttachmentLinkContractReceivable();
	}

	@Override
	public BaseAttachmentLinkContractReceivable make(){
		BaseAttachmentLinkContractReceivable b = new BaseAttachmentLinkContractReceivable();
		return b;
	}

	public final static java.lang.String CS_ATTACHMENT_LINK_CONTRACT_RECEIVABLE_ID = "attachment_link_contract_receivable_id" ;
	public final static java.lang.String CS_ATTACHMENT_MANAGE_ID = "attachment_manage_id" ;
	public final static java.lang.String CS_CONTRACT_RECEIVABLE_ID = "contract_receivable_id" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,确认函编码,收款阶段编码,操作人,操作时间,备注,流程主表编码";

	public java.lang.Integer getAttachmentLinkContractReceivableId() {
		return this.__attachment_link_contract_receivable_id;
	}

	public void setAttachmentLinkContractReceivableId( java.lang.Integer value ) {
		this.__attachment_link_contract_receivable_id = value;
	}

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	public java.lang.Integer getContractReceivableId() {
		return this.__contract_receivable_id;
	}

	public void setContractReceivableId( java.lang.Integer value ) {
		this.__contract_receivable_id = value;
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

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public void cloneCopy(BaseAttachmentLinkContractReceivable __bean){
		__bean.setAttachmentLinkContractReceivableId(getAttachmentLinkContractReceivableId());
		__bean.setAttachmentManageId(getAttachmentManageId());
		__bean.setContractReceivableId(getContractReceivableId());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAttachmentLinkContractReceivableId() == null ? "" : getAttachmentLinkContractReceivableId());
		sb.append(",");
		sb.append(getAttachmentManageId() == null ? "" : getAttachmentManageId());
		sb.append(",");
		sb.append(getContractReceivableId() == null ? "" : getContractReceivableId());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttachmentLinkContractReceivable o) {
		return __attachment_link_contract_receivable_id == null ? -1 : __attachment_link_contract_receivable_id.compareTo(o.getAttachmentLinkContractReceivableId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__attachment_link_contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttachmentLinkContractReceivable o = (BaseAttachmentLinkContractReceivable)obj;
		if(!Objects.equals(this.__attachment_link_contract_receivable_id, o.getAttachmentLinkContractReceivableId())) return false;
		if(!Objects.equals(this.__attachment_manage_id, o.getAttachmentManageId())) return false;
		if(!Objects.equals(this.__contract_receivable_id, o.getContractReceivableId())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAttachmentLinkContractReceivableId() != null) sb.append(__wrapNumber(count++, "attachmentLinkContractReceivableId", getAttachmentLinkContractReceivableId()));
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(count++, "attachmentManageId", getAttachmentManageId()));
		if(getContractReceivableId() != null) sb.append(__wrapNumber(count++, "contractReceivableId", getContractReceivableId()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("attachmentLinkContractReceivableId")) != null) setAttachmentLinkContractReceivableId(__getInt(val)); 
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
		if((val = values.get("contractReceivableId")) != null) setContractReceivableId(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
	}

	protected java.lang.Integer  __attachment_link_contract_receivable_id ;
	protected java.lang.Integer  __attachment_manage_id ;
	protected java.lang.Integer  __contract_receivable_id ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __personnel_business_id ;
}
