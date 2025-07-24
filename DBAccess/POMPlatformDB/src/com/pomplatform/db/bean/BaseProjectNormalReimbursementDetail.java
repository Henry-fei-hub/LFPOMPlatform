package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectNormalReimbursementDetail extends GenericBase implements BaseFactory<BaseProjectNormalReimbursementDetail>, Comparable<BaseProjectNormalReimbursementDetail> 
{


	public static BaseProjectNormalReimbursementDetail newInstance(){
		return new BaseProjectNormalReimbursementDetail();
	}

	@Override
	public BaseProjectNormalReimbursementDetail make(){
		BaseProjectNormalReimbursementDetail b = new BaseProjectNormalReimbursementDetail();
		return b;
	}

	public final static java.lang.String CS_PROJECT_NORMAL_REIMBURSEMENT_DETAIL_ID = "project_normal_reimbursement_detail_id" ;
	public final static java.lang.String CS_PROJECT_NORMAL_REIMBURSEMENT_ID = "project_normal_reimbursement_id" ;
	public final static java.lang.String CS_MAIN_ITEM_ID = "main_item_id" ;
	public final static java.lang.String CS_SUB_ITEM_ID = "sub_item_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_REIMBURSEMENT_TIME = "reimbursement_time" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IDENTIFICATION = "identification" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目报销编码,一级报销科目,二级报销科目,报销金额,报销时间,状态,备注,标识";

	public java.lang.Integer getProjectNormalReimbursementDetailId() {
		return this.__project_normal_reimbursement_detail_id;
	}

	public void setProjectNormalReimbursementDetailId( java.lang.Integer value ) {
		this.__project_normal_reimbursement_detail_id = value;
	}

	public java.lang.Integer getProjectNormalReimbursementId() {
		return this.__project_normal_reimbursement_id;
	}

	public void setProjectNormalReimbursementId( java.lang.Integer value ) {
		this.__project_normal_reimbursement_id = value;
	}

	public java.lang.Integer getMainItemId() {
		return this.__main_item_id;
	}

	public void setMainItemId( java.lang.Integer value ) {
		this.__main_item_id = value;
	}

	public java.lang.Integer getSubItemId() {
		return this.__sub_item_id;
	}

	public void setSubItemId( java.lang.Integer value ) {
		this.__sub_item_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.util.Date getReimbursementTime() {
		return this.__reimbursement_time;
	}

	public void setReimbursementTime( java.util.Date value ) {
		this.__reimbursement_time = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getIdentification() {
		return this.__identification;
	}

	public void setIdentification( java.lang.String value ) {
		this.__identification = value;
	}

	public void cloneCopy(BaseProjectNormalReimbursementDetail __bean){
		__bean.setProjectNormalReimbursementDetailId(getProjectNormalReimbursementDetailId());
		__bean.setProjectNormalReimbursementId(getProjectNormalReimbursementId());
		__bean.setMainItemId(getMainItemId());
		__bean.setSubItemId(getSubItemId());
		__bean.setAmount(getAmount());
		__bean.setReimbursementTime(getReimbursementTime());
		__bean.setStatus(getStatus());
		__bean.setRemark(getRemark());
		__bean.setIdentification(getIdentification());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectNormalReimbursementDetailId() == null ? "" : getProjectNormalReimbursementDetailId());
		sb.append(",");
		sb.append(getProjectNormalReimbursementId() == null ? "" : getProjectNormalReimbursementId());
		sb.append(",");
		sb.append(getMainItemId() == null ? "" : getMainItemId());
		sb.append(",");
		sb.append(getSubItemId() == null ? "" : getSubItemId());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getReimbursementTime() == null ? "" : sdf.format(getReimbursementTime()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIdentification() == null ? "" : getIdentification());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectNormalReimbursementDetail o) {
		return __project_normal_reimbursement_detail_id == null ? -1 : __project_normal_reimbursement_detail_id.compareTo(o.getProjectNormalReimbursementDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_normal_reimbursement_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__project_normal_reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__main_item_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_item_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__identification);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectNormalReimbursementDetail o = (BaseProjectNormalReimbursementDetail)obj;
		if(!Objects.equals(this.__project_normal_reimbursement_detail_id, o.getProjectNormalReimbursementDetailId())) return false;
		if(!Objects.equals(this.__project_normal_reimbursement_id, o.getProjectNormalReimbursementId())) return false;
		if(!Objects.equals(this.__main_item_id, o.getMainItemId())) return false;
		if(!Objects.equals(this.__sub_item_id, o.getSubItemId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__reimbursement_time, o.getReimbursementTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__identification, o.getIdentification())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectNormalReimbursementDetailId() != null) sb.append(__wrapNumber(count++, "projectNormalReimbursementDetailId", getProjectNormalReimbursementDetailId()));
		if(getProjectNormalReimbursementId() != null) sb.append(__wrapNumber(count++, "projectNormalReimbursementId", getProjectNormalReimbursementId()));
		if(getMainItemId() != null) sb.append(__wrapNumber(count++, "mainItemId", getMainItemId()));
		if(getSubItemId() != null) sb.append(__wrapNumber(count++, "subItemId", getSubItemId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getReimbursementTime() != null) sb.append(__wrapDate(count++, "reimbursementTime", getReimbursementTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIdentification() != null) sb.append(__wrapString(count++, "identification", getIdentification()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectNormalReimbursementDetailId")) != null) setProjectNormalReimbursementDetailId(__getInt(val)); 
		if((val = values.get("projectNormalReimbursementId")) != null) setProjectNormalReimbursementId(__getInt(val)); 
		if((val = values.get("mainItemId")) != null) setMainItemId(__getInt(val)); 
		if((val = values.get("subItemId")) != null) setSubItemId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("reimbursementTime")) != null) setReimbursementTime(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("identification")) != null) setIdentification(__getString(val));
	}

	protected java.lang.Integer  __project_normal_reimbursement_detail_id ;
	protected java.lang.Integer  __project_normal_reimbursement_id ;
	protected java.lang.Integer  __main_item_id ;
	protected java.lang.Integer  __sub_item_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.util.Date  __reimbursement_time ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __identification ;
}
