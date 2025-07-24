package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePurchasePlan extends GenericBase implements BaseFactory<BasePurchasePlan>, Comparable<BasePurchasePlan> 
{


	public static BasePurchasePlan newInstance(){
		return new BasePurchasePlan();
	}

	@Override
	public BasePurchasePlan make(){
		BasePurchasePlan b = new BasePurchasePlan();
		return b;
	}

	public final static java.lang.String CS_PURCHASE_PLAN_ID = "purchase_plan_id" ;
	public final static java.lang.String CS_PERSON_IN_CHARGE = "person_in_charge" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_ORI_PERSONNEL_BUSINESS_ID = "ori_personnel_business_id" ;
	public final static java.lang.String CS_PURCHASE_DATE = "purchase_date" ;
	public final static java.lang.String CS_PURCHASE_AMOUNT = "purchase_amount" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_TAX_AMOUNT = "tax_amount" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_IS_COMPLETE = "is_complete" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_DEAL_STATUS = "deal_status" ;
	public final static java.lang.String CS_PURCHASE_CONTRACT_ID = "purchase_contract_id" ;
	public final static java.lang.String CS_TO_PERSONNEL_BUSINESS_ID = "to_personnel_business_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,负责人,大项目主键,源流程业务主键,采购日期,采购金额,供应商主键,含税金额,备注,创建时间,是否完成,操作人(指派人),处理状态(0 新建 1采购申请中 2采购被驳回 3已完成采购),采购合同表主键,采购实施业务主键";

	public java.lang.Integer getPurchasePlanId() {
		return this.__purchase_plan_id;
	}

	public void setPurchasePlanId( java.lang.Integer value ) {
		this.__purchase_plan_id = value;
	}

	public java.lang.Integer getPersonInCharge() {
		return this.__person_in_charge;
	}

	public void setPersonInCharge( java.lang.Integer value ) {
		this.__person_in_charge = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getOriPersonnelBusinessId() {
		return this.__ori_personnel_business_id;
	}

	public void setOriPersonnelBusinessId( java.lang.Integer value ) {
		this.__ori_personnel_business_id = value;
	}

	public java.util.Date getPurchaseDate() {
		return this.__purchase_date;
	}

	public void setPurchaseDate( java.util.Date value ) {
		this.__purchase_date = value;
	}

	public java.math.BigDecimal getPurchaseAmount() {
		return this.__purchase_amount;
	}

	public void setPurchaseAmount( java.math.BigDecimal value ) {
		this.__purchase_amount = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.math.BigDecimal getTaxAmount() {
		return this.__tax_amount;
	}

	public void setTaxAmount( java.math.BigDecimal value ) {
		this.__tax_amount = value;
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

	public java.lang.Boolean getIsComplete() {
		return this.__is_complete;
	}

	public void setIsComplete( java.lang.Boolean value ) {
		this.__is_complete = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.Integer getDealStatus() {
		return this.__deal_status;
	}

	public void setDealStatus( java.lang.Integer value ) {
		this.__deal_status = value;
	}

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	public java.lang.Integer getToPersonnelBusinessId() {
		return this.__to_personnel_business_id;
	}

	public void setToPersonnelBusinessId( java.lang.Integer value ) {
		this.__to_personnel_business_id = value;
	}

	public void cloneCopy(BasePurchasePlan __bean){
		__bean.setPurchasePlanId(getPurchasePlanId());
		__bean.setPersonInCharge(getPersonInCharge());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setOriPersonnelBusinessId(getOriPersonnelBusinessId());
		__bean.setPurchaseDate(getPurchaseDate());
		__bean.setPurchaseAmount(getPurchaseAmount());
		__bean.setSupplierId(getSupplierId());
		__bean.setTaxAmount(getTaxAmount());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setIsComplete(getIsComplete());
		__bean.setOperatorId(getOperatorId());
		__bean.setDealStatus(getDealStatus());
		__bean.setPurchaseContractId(getPurchaseContractId());
		__bean.setToPersonnelBusinessId(getToPersonnelBusinessId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPurchasePlanId() == null ? "" : getPurchasePlanId());
		sb.append(",");
		sb.append(getPersonInCharge() == null ? "" : getPersonInCharge());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getOriPersonnelBusinessId() == null ? "" : getOriPersonnelBusinessId());
		sb.append(",");
		sb.append(getPurchaseDate() == null ? "" : sdf.format(getPurchaseDate()));
		sb.append(",");
		sb.append(getPurchaseAmount() == null ? "" : getPurchaseAmount());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getTaxAmount() == null ? "" : getTaxAmount());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getIsComplete() == null ? "" : getIsComplete());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getDealStatus() == null ? "" : getDealStatus());
		sb.append(",");
		sb.append(getPurchaseContractId() == null ? "" : getPurchaseContractId());
		sb.append(",");
		sb.append(getToPersonnelBusinessId() == null ? "" : getToPersonnelBusinessId());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePurchasePlan o) {
		return __purchase_plan_id == null ? -1 : __purchase_plan_id.compareTo(o.getPurchasePlanId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__purchase_plan_id);
		hash = 97 * hash + Objects.hashCode(this.__person_in_charge);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__ori_personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__purchase_date);
		hash = 97 * hash + Objects.hashCode(this.__purchase_amount);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__is_complete);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__deal_status);
		hash = 97 * hash + Objects.hashCode(this.__purchase_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__to_personnel_business_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePurchasePlan o = (BasePurchasePlan)obj;
		if(!Objects.equals(this.__purchase_plan_id, o.getPurchasePlanId())) return false;
		if(!Objects.equals(this.__person_in_charge, o.getPersonInCharge())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__ori_personnel_business_id, o.getOriPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__purchase_date, o.getPurchaseDate())) return false;
		if(!Objects.equals(this.__purchase_amount, o.getPurchaseAmount())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__tax_amount, o.getTaxAmount())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__is_complete, o.getIsComplete())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__deal_status, o.getDealStatus())) return false;
		if(!Objects.equals(this.__purchase_contract_id, o.getPurchaseContractId())) return false;
		if(!Objects.equals(this.__to_personnel_business_id, o.getToPersonnelBusinessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPurchasePlanId() != null) sb.append(__wrapNumber(count++, "purchasePlanId", getPurchasePlanId()));
		if(getPersonInCharge() != null) sb.append(__wrapNumber(count++, "personInCharge", getPersonInCharge()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getOriPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "oriPersonnelBusinessId", getOriPersonnelBusinessId()));
		if(getPurchaseDate() != null) sb.append(__wrapDate(count++, "purchaseDate", getPurchaseDate()));
		if(getPurchaseAmount() != null) sb.append(__wrapDecimal(count++, "purchaseAmount", getPurchaseAmount()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getTaxAmount() != null) sb.append(__wrapDecimal(count++, "taxAmount", getTaxAmount()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getIsComplete() != null) sb.append(__wrapBoolean(count++, "isComplete", getIsComplete()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getDealStatus() != null) sb.append(__wrapNumber(count++, "dealStatus", getDealStatus()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(count++, "purchaseContractId", getPurchaseContractId()));
		if(getToPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "toPersonnelBusinessId", getToPersonnelBusinessId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPurchasePlanId() != null) res.put("purchasePlanId", getPurchasePlanId());
		if(getPersonInCharge() != null) res.put("personInCharge", getPersonInCharge());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getOriPersonnelBusinessId() != null) res.put("oriPersonnelBusinessId", getOriPersonnelBusinessId());
		if(getPurchaseDate() != null) res.put("purchaseDate", getPurchaseDate());
		if(getPurchaseAmount() != null) res.put("purchaseAmount", getPurchaseAmount());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getTaxAmount() != null) res.put("taxAmount", getTaxAmount());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getIsComplete() != null) res.put("isComplete", getIsComplete());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getDealStatus() != null) res.put("dealStatus", getDealStatus());
		if(getPurchaseContractId() != null) res.put("purchaseContractId", getPurchaseContractId());
		if(getToPersonnelBusinessId() != null) res.put("toPersonnelBusinessId", getToPersonnelBusinessId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("purchasePlanId")) != null) setPurchasePlanId(__getInt(val)); 
		if((val = values.get("personInCharge")) != null) setPersonInCharge(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("oriPersonnelBusinessId")) != null) setOriPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("purchaseDate")) != null) setPurchaseDate(__getDate(val)); 
		if((val = values.get("purchaseAmount")) != null) setPurchaseAmount(__getDecimal(val));  
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("taxAmount")) != null) setTaxAmount(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("isComplete")) != null) setIsComplete(__getBoolean(val));
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("dealStatus")) != null) setDealStatus(__getInt(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("toPersonnelBusinessId")) != null) setToPersonnelBusinessId(__getInt(val)); 
	}

	protected java.lang.Integer  __purchase_plan_id ;
	protected java.lang.Integer  __person_in_charge ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __ori_personnel_business_id ;
	protected java.util.Date  __purchase_date ;
	protected java.math.BigDecimal  __purchase_amount ;
	protected java.lang.Integer  __supplier_id ;
	protected java.math.BigDecimal  __tax_amount ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.lang.Boolean  __is_complete ;
	protected java.lang.Integer  __operator_id ;
	protected java.lang.Integer  __deal_status ;
	protected java.lang.Integer  __purchase_contract_id ;
	protected java.lang.Integer  __to_personnel_business_id ;
}
