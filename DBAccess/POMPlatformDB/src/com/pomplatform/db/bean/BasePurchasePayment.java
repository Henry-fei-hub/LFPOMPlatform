package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePurchasePayment extends GenericBase implements BaseFactory<BasePurchasePayment>, Comparable<BasePurchasePayment> 
{


	public static BasePurchasePayment newInstance(){
		return new BasePurchasePayment();
	}

	@Override
	public BasePurchasePayment make(){
		BasePurchasePayment b = new BasePurchasePayment();
		return b;
	}

	public final static java.lang.String CS_PURCHASE_PAYMENT_ID = "purchase_payment_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_PAYMENT_DATE = "payment_date" ;
	public final static java.lang.String CS_PAYMENT_NAME = "payment_name" ;
	public final static java.lang.String CS_PAYMENT_CONDITION = "payment_condition" ;
	public final static java.lang.String CS_PAYMENT_RATIO = "payment_ratio" ;
	public final static java.lang.String CS_PAYMENT_AMOUNT = "payment_amount" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_PURCHASE_CONTRACT_ID = "purchase_contract_id" ;
	public final static java.lang.String CS_PURCHASE_PAYMENT_STATUS = "purchase_payment_status" ;
	public final static java.lang.String CS_PERSON_IN_CHARGE = "person_in_charge" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_REAL_PAYMENT_DATE = "real_payment_date" ;
	public final static java.lang.String CS_REAL_PAYMENT_AMOUNT = "real_payment_amount" ;
	public final static java.lang.String CS_PROCESS_BUSINESS_ID = "process_business_id" ;
	public final static java.lang.String CS_DEAL_STATUS = "deal_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,流程表主键,计划付款日期,款项名称(预付款、第一次付款),付款条件,付款比例,付款金额,备注,创建时间,采购合同表主键,流程状态 0新建 3通过审批完成,负责人,操作人,真实付款时间,真实付款金额,流程业务表主键,处理状态 0新建 1付款申请中 2付款被驳回 3已付款";

	public java.lang.Integer getPurchasePaymentId() {
		return this.__purchase_payment_id;
	}

	public void setPurchasePaymentId( java.lang.Integer value ) {
		this.__purchase_payment_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.util.Date getPaymentDate() {
		return this.__payment_date;
	}

	public void setPaymentDate( java.util.Date value ) {
		this.__payment_date = value;
	}

	public java.lang.String getPaymentName() {
		return this.__payment_name;
	}

	public void setPaymentName( java.lang.String value ) {
		this.__payment_name = value;
	}

	public java.lang.String getPaymentCondition() {
		return this.__payment_condition;
	}

	public void setPaymentCondition( java.lang.String value ) {
		this.__payment_condition = value;
	}

	public java.math.BigDecimal getPaymentRatio() {
		return this.__payment_ratio;
	}

	public void setPaymentRatio( java.math.BigDecimal value ) {
		this.__payment_ratio = value;
	}

	public java.math.BigDecimal getPaymentAmount() {
		return this.__payment_amount;
	}

	public void setPaymentAmount( java.math.BigDecimal value ) {
		this.__payment_amount = value;
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

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	public java.lang.Integer getPurchasePaymentStatus() {
		return this.__purchase_payment_status;
	}

	public void setPurchasePaymentStatus( java.lang.Integer value ) {
		this.__purchase_payment_status = value;
	}

	public java.lang.Integer getPersonInCharge() {
		return this.__person_in_charge;
	}

	public void setPersonInCharge( java.lang.Integer value ) {
		this.__person_in_charge = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getRealPaymentDate() {
		return this.__real_payment_date;
	}

	public void setRealPaymentDate( java.util.Date value ) {
		this.__real_payment_date = value;
	}

	public java.math.BigDecimal getRealPaymentAmount() {
		return this.__real_payment_amount;
	}

	public void setRealPaymentAmount( java.math.BigDecimal value ) {
		this.__real_payment_amount = value;
	}

	public java.lang.Integer getProcessBusinessId() {
		return this.__process_business_id;
	}

	public void setProcessBusinessId( java.lang.Integer value ) {
		this.__process_business_id = value;
	}

	public java.lang.Integer getDealStatus() {
		return this.__deal_status;
	}

	public void setDealStatus( java.lang.Integer value ) {
		this.__deal_status = value;
	}

	public void cloneCopy(BasePurchasePayment __bean){
		__bean.setPurchasePaymentId(getPurchasePaymentId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setPaymentDate(getPaymentDate());
		__bean.setPaymentName(getPaymentName());
		__bean.setPaymentCondition(getPaymentCondition());
		__bean.setPaymentRatio(getPaymentRatio());
		__bean.setPaymentAmount(getPaymentAmount());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setPurchaseContractId(getPurchaseContractId());
		__bean.setPurchasePaymentStatus(getPurchasePaymentStatus());
		__bean.setPersonInCharge(getPersonInCharge());
		__bean.setOperatorId(getOperatorId());
		__bean.setRealPaymentDate(getRealPaymentDate());
		__bean.setRealPaymentAmount(getRealPaymentAmount());
		__bean.setProcessBusinessId(getProcessBusinessId());
		__bean.setDealStatus(getDealStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPurchasePaymentId() == null ? "" : getPurchasePaymentId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getPaymentDate() == null ? "" : sdf.format(getPaymentDate()));
		sb.append(",");
		sb.append(getPaymentName() == null ? "" : getPaymentName());
		sb.append(",");
		sb.append(getPaymentCondition() == null ? "" : getPaymentCondition());
		sb.append(",");
		sb.append(getPaymentRatio() == null ? "" : getPaymentRatio());
		sb.append(",");
		sb.append(getPaymentAmount() == null ? "" : getPaymentAmount());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getPurchaseContractId() == null ? "" : getPurchaseContractId());
		sb.append(",");
		sb.append(getPurchasePaymentStatus() == null ? "" : getPurchasePaymentStatus());
		sb.append(",");
		sb.append(getPersonInCharge() == null ? "" : getPersonInCharge());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getRealPaymentDate() == null ? "" : sdf.format(getRealPaymentDate()));
		sb.append(",");
		sb.append(getRealPaymentAmount() == null ? "" : getRealPaymentAmount());
		sb.append(",");
		sb.append(getProcessBusinessId() == null ? "" : getProcessBusinessId());
		sb.append(",");
		sb.append(getDealStatus() == null ? "" : getDealStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePurchasePayment o) {
		return __purchase_payment_id == null ? -1 : __purchase_payment_id.compareTo(o.getPurchasePaymentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__purchase_payment_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__payment_date);
		hash = 97 * hash + Objects.hashCode(this.__payment_name);
		hash = 97 * hash + Objects.hashCode(this.__payment_condition);
		hash = 97 * hash + Objects.hashCode(this.__payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__payment_amount);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__purchase_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__purchase_payment_status);
		hash = 97 * hash + Objects.hashCode(this.__person_in_charge);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__real_payment_date);
		hash = 97 * hash + Objects.hashCode(this.__real_payment_amount);
		hash = 97 * hash + Objects.hashCode(this.__process_business_id);
		hash = 97 * hash + Objects.hashCode(this.__deal_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePurchasePayment o = (BasePurchasePayment)obj;
		if(!Objects.equals(this.__purchase_payment_id, o.getPurchasePaymentId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__payment_date, o.getPaymentDate())) return false;
		if(!Objects.equals(this.__payment_name, o.getPaymentName())) return false;
		if(!Objects.equals(this.__payment_condition, o.getPaymentCondition())) return false;
		if(!Objects.equals(this.__payment_ratio, o.getPaymentRatio())) return false;
		if(!Objects.equals(this.__payment_amount, o.getPaymentAmount())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__purchase_contract_id, o.getPurchaseContractId())) return false;
		if(!Objects.equals(this.__purchase_payment_status, o.getPurchasePaymentStatus())) return false;
		if(!Objects.equals(this.__person_in_charge, o.getPersonInCharge())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__real_payment_date, o.getRealPaymentDate())) return false;
		if(!Objects.equals(this.__real_payment_amount, o.getRealPaymentAmount())) return false;
		if(!Objects.equals(this.__process_business_id, o.getProcessBusinessId())) return false;
		if(!Objects.equals(this.__deal_status, o.getDealStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPurchasePaymentId() != null) sb.append(__wrapNumber(count++, "purchasePaymentId", getPurchasePaymentId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getPaymentDate() != null) sb.append(__wrapDate(count++, "paymentDate", getPaymentDate()));
		if(getPaymentName() != null) sb.append(__wrapString(count++, "paymentName", getPaymentName()));
		if(getPaymentCondition() != null) sb.append(__wrapString(count++, "paymentCondition", getPaymentCondition()));
		if(getPaymentRatio() != null) sb.append(__wrapDecimal(count++, "paymentRatio", getPaymentRatio()));
		if(getPaymentAmount() != null) sb.append(__wrapDecimal(count++, "paymentAmount", getPaymentAmount()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(count++, "purchaseContractId", getPurchaseContractId()));
		if(getPurchasePaymentStatus() != null) sb.append(__wrapNumber(count++, "purchasePaymentStatus", getPurchasePaymentStatus()));
		if(getPersonInCharge() != null) sb.append(__wrapNumber(count++, "personInCharge", getPersonInCharge()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getRealPaymentDate() != null) sb.append(__wrapDate(count++, "realPaymentDate", getRealPaymentDate()));
		if(getRealPaymentAmount() != null) sb.append(__wrapDecimal(count++, "realPaymentAmount", getRealPaymentAmount()));
		if(getProcessBusinessId() != null) sb.append(__wrapNumber(count++, "processBusinessId", getProcessBusinessId()));
		if(getDealStatus() != null) sb.append(__wrapNumber(count++, "dealStatus", getDealStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPurchasePaymentId() != null) res.put("purchasePaymentId", getPurchasePaymentId());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getPaymentDate() != null) res.put("paymentDate", getPaymentDate());
		if(getPaymentName() != null) res.put("paymentName", getPaymentName());
		if(getPaymentCondition() != null) res.put("paymentCondition", getPaymentCondition());
		if(getPaymentRatio() != null) res.put("paymentRatio", getPaymentRatio());
		if(getPaymentAmount() != null) res.put("paymentAmount", getPaymentAmount());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getPurchaseContractId() != null) res.put("purchaseContractId", getPurchaseContractId());
		if(getPurchasePaymentStatus() != null) res.put("purchasePaymentStatus", getPurchasePaymentStatus());
		if(getPersonInCharge() != null) res.put("personInCharge", getPersonInCharge());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getRealPaymentDate() != null) res.put("realPaymentDate", getRealPaymentDate());
		if(getRealPaymentAmount() != null) res.put("realPaymentAmount", getRealPaymentAmount());
		if(getProcessBusinessId() != null) res.put("processBusinessId", getProcessBusinessId());
		if(getDealStatus() != null) res.put("dealStatus", getDealStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("purchasePaymentId")) != null) setPurchasePaymentId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("paymentDate")) != null) setPaymentDate(__getDate(val)); 
		if((val = values.get("paymentName")) != null) setPaymentName(__getString(val));
		if((val = values.get("paymentCondition")) != null) setPaymentCondition(__getString(val));
		if((val = values.get("paymentRatio")) != null) setPaymentRatio(__getDecimal(val));  
		if((val = values.get("paymentAmount")) != null) setPaymentAmount(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("purchasePaymentStatus")) != null) setPurchasePaymentStatus(__getInt(val)); 
		if((val = values.get("personInCharge")) != null) setPersonInCharge(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("realPaymentDate")) != null) setRealPaymentDate(__getDate(val)); 
		if((val = values.get("realPaymentAmount")) != null) setRealPaymentAmount(__getDecimal(val));  
		if((val = values.get("processBusinessId")) != null) setProcessBusinessId(__getInt(val)); 
		if((val = values.get("dealStatus")) != null) setDealStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __purchase_payment_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.util.Date  __payment_date ;
	protected java.lang.String  __payment_name ;
	protected java.lang.String  __payment_condition ;
	protected java.math.BigDecimal  __payment_ratio ;
	protected java.math.BigDecimal  __payment_amount ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __purchase_contract_id ;
	protected java.lang.Integer  __purchase_payment_status ;
	protected java.lang.Integer  __person_in_charge ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __real_payment_date ;
	protected java.math.BigDecimal  __real_payment_amount ;
	protected java.lang.Integer  __process_business_id ;
	protected java.lang.Integer  __deal_status ;
}
