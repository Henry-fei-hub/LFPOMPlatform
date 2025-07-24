package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePurchaseApplication extends GenericBase implements BaseFactory<BasePurchaseApplication>, Comparable<BasePurchaseApplication> 
{


	public static BasePurchaseApplication newInstance(){
		return new BasePurchaseApplication();
	}

	@Override
	public BasePurchaseApplication make(){
		BasePurchaseApplication b = new BasePurchaseApplication();
		return b;
	}

	public final static java.lang.String CS_PURCHASE_APPLICATION_ID = "purchase_application_id" ;
	public final static java.lang.String CS_MAJOR_TITLE = "major_title" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_APPLY_DEPARTMENT_ID = "apply_department_id" ;
	public final static java.lang.String CS_PURCHASE_AMOUNT = "purchase_amount" ;
	public final static java.lang.String CS_APPLY_REASON = "apply_reason" ;
	public final static java.lang.String CS_PLAN_ARRIVAL_DATE = "plan_arrival_date" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,主题,申请人id,申请部门,预估采购金额,申请原因,计划到货日期,创建人,创建时间,备注";

	public java.lang.Integer getPurchaseApplicationId() {
		return this.__purchase_application_id;
	}

	public void setPurchaseApplicationId( java.lang.Integer value ) {
		this.__purchase_application_id = value;
	}

	public java.lang.String getMajorTitle() {
		return this.__major_title;
	}

	public void setMajorTitle( java.lang.String value ) {
		this.__major_title = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.lang.Integer getApplyDepartmentId() {
		return this.__apply_department_id;
	}

	public void setApplyDepartmentId( java.lang.Integer value ) {
		this.__apply_department_id = value;
	}

	public java.math.BigDecimal getPurchaseAmount() {
		return this.__purchase_amount;
	}

	public void setPurchaseAmount( java.math.BigDecimal value ) {
		this.__purchase_amount = value;
	}

	public java.lang.String getApplyReason() {
		return this.__apply_reason;
	}

	public void setApplyReason( java.lang.String value ) {
		this.__apply_reason = value;
	}

	public java.util.Date getPlanArrivalDate() {
		return this.__plan_arrival_date;
	}

	public void setPlanArrivalDate( java.util.Date value ) {
		this.__plan_arrival_date = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BasePurchaseApplication __bean){
		__bean.setPurchaseApplicationId(getPurchaseApplicationId());
		__bean.setMajorTitle(getMajorTitle());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setApplyDepartmentId(getApplyDepartmentId());
		__bean.setPurchaseAmount(getPurchaseAmount());
		__bean.setApplyReason(getApplyReason());
		__bean.setPlanArrivalDate(getPlanArrivalDate());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPurchaseApplicationId() == null ? "" : getPurchaseApplicationId());
		sb.append(",");
		sb.append(getMajorTitle() == null ? "" : getMajorTitle());
		sb.append(",");
		sb.append(getApplyEmployeeId() == null ? "" : getApplyEmployeeId());
		sb.append(",");
		sb.append(getApplyDepartmentId() == null ? "" : getApplyDepartmentId());
		sb.append(",");
		sb.append(getPurchaseAmount() == null ? "" : getPurchaseAmount());
		sb.append(",");
		sb.append(getApplyReason() == null ? "" : getApplyReason());
		sb.append(",");
		sb.append(getPlanArrivalDate() == null ? "" : sdf.format(getPlanArrivalDate()));
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePurchaseApplication o) {
		return __purchase_application_id == null ? -1 : __purchase_application_id.compareTo(o.getPurchaseApplicationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__purchase_application_id);
		hash = 97 * hash + Objects.hashCode(this.__major_title);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__apply_department_id);
		hash = 97 * hash + Objects.hashCode(this.__purchase_amount);
		hash = 97 * hash + Objects.hashCode(this.__apply_reason);
		hash = 97 * hash + Objects.hashCode(this.__plan_arrival_date);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePurchaseApplication o = (BasePurchaseApplication)obj;
		if(!Objects.equals(this.__purchase_application_id, o.getPurchaseApplicationId())) return false;
		if(!Objects.equals(this.__major_title, o.getMajorTitle())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__apply_department_id, o.getApplyDepartmentId())) return false;
		if(!Objects.equals(this.__purchase_amount, o.getPurchaseAmount())) return false;
		if(!Objects.equals(this.__apply_reason, o.getApplyReason())) return false;
		if(!Objects.equals(this.__plan_arrival_date, o.getPlanArrivalDate())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPurchaseApplicationId() != null) sb.append(__wrapNumber(count++, "purchaseApplicationId", getPurchaseApplicationId()));
		if(getMajorTitle() != null) sb.append(__wrapString(count++, "majorTitle", getMajorTitle()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getApplyDepartmentId() != null) sb.append(__wrapNumber(count++, "applyDepartmentId", getApplyDepartmentId()));
		if(getPurchaseAmount() != null) sb.append(__wrapDecimal(count++, "purchaseAmount", getPurchaseAmount()));
		if(getApplyReason() != null) sb.append(__wrapString(count++, "applyReason", getApplyReason()));
		if(getPlanArrivalDate() != null) sb.append(__wrapDate(count++, "planArrivalDate", getPlanArrivalDate()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPurchaseApplicationId() != null) res.put("purchaseApplicationId", getPurchaseApplicationId());
		if(getMajorTitle() != null) res.put("majorTitle", getMajorTitle());
		if(getApplyEmployeeId() != null) res.put("applyEmployeeId", getApplyEmployeeId());
		if(getApplyDepartmentId() != null) res.put("applyDepartmentId", getApplyDepartmentId());
		if(getPurchaseAmount() != null) res.put("purchaseAmount", getPurchaseAmount());
		if(getApplyReason() != null) res.put("applyReason", getApplyReason());
		if(getPlanArrivalDate() != null) res.put("planArrivalDate", getPlanArrivalDate());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("purchaseApplicationId")) != null) setPurchaseApplicationId(__getInt(val)); 
		if((val = values.get("majorTitle")) != null) setMajorTitle(__getString(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("applyDepartmentId")) != null) setApplyDepartmentId(__getInt(val)); 
		if((val = values.get("purchaseAmount")) != null) setPurchaseAmount(__getDecimal(val));  
		if((val = values.get("applyReason")) != null) setApplyReason(__getString(val));
		if((val = values.get("planArrivalDate")) != null) setPlanArrivalDate(__getDate(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __purchase_application_id ;
	protected java.lang.String  __major_title ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.Integer  __apply_department_id ;
	protected java.math.BigDecimal  __purchase_amount ;
	protected java.lang.String  __apply_reason ;
	protected java.util.Date  __plan_arrival_date ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
