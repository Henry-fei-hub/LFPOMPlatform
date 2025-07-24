package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSupplierApprais extends GenericBase implements BaseFactory<BaseSupplierApprais>, Comparable<BaseSupplierApprais> 
{


	public static BaseSupplierApprais newInstance(){
		return new BaseSupplierApprais();
	}

	@Override
	public BaseSupplierApprais make(){
		BaseSupplierApprais b = new BaseSupplierApprais();
		return b;
	}

	public final static java.lang.String CS_SUPPLIER_APPRAISE_ID = "supplier_appraise_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_TITLE = "title" ;
	public final static java.lang.String CS_PROVIDE_PRODUCT = "provide_product" ;
	public final static java.lang.String CS_SCORE = "score" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_APPRAISE_STATUS = "appraise_status" ;
	public final static java.lang.String CS_ADVICE = "advice" ;
	public final static java.lang.String CS_FINISH_TIME = "finish_time" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,供应商id,主题,提供产品,评价合计得分,事由,3已取消),确认或取消意见,确认或取消完成时间,创建人,创建时间,备注";

	public java.lang.Integer getSupplierAppraiseId() {
		return this.__supplier_appraise_id;
	}

	public void setSupplierAppraiseId( java.lang.Integer value ) {
		this.__supplier_appraise_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.String getTitle() {
		return this.__title;
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.String getProvideProduct() {
		return this.__provide_product;
	}

	public void setProvideProduct( java.lang.String value ) {
		this.__provide_product = value;
	}

	public java.math.BigDecimal getScore() {
		return this.__score;
	}

	public void setScore( java.math.BigDecimal value ) {
		this.__score = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.Integer getAppraiseStatus() {
		return this.__appraise_status;
	}

	public void setAppraiseStatus( java.lang.Integer value ) {
		this.__appraise_status = value;
	}

	public java.lang.String getAdvice() {
		return this.__advice;
	}

	public void setAdvice( java.lang.String value ) {
		this.__advice = value;
	}

	public java.util.Date getFinishTime() {
		return this.__finish_time;
	}

	public void setFinishTime( java.util.Date value ) {
		this.__finish_time = value;
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

	public void cloneCopy(BaseSupplierApprais __bean){
		__bean.setSupplierAppraiseId(getSupplierAppraiseId());
		__bean.setSupplierId(getSupplierId());
		__bean.setTitle(getTitle());
		__bean.setProvideProduct(getProvideProduct());
		__bean.setScore(getScore());
		__bean.setReason(getReason());
		__bean.setAppraiseStatus(getAppraiseStatus());
		__bean.setAdvice(getAdvice());
		__bean.setFinishTime(getFinishTime());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSupplierAppraiseId() == null ? "" : getSupplierAppraiseId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getTitle() == null ? "" : getTitle());
		sb.append(",");
		sb.append(getProvideProduct() == null ? "" : getProvideProduct());
		sb.append(",");
		sb.append(getScore() == null ? "" : getScore());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getAppraiseStatus() == null ? "" : getAppraiseStatus());
		sb.append(",");
		sb.append(getAdvice() == null ? "" : getAdvice());
		sb.append(",");
		sb.append(getFinishTime() == null ? "" : sdf.format(getFinishTime()));
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSupplierApprais o) {
		return __supplier_appraise_id == null ? -1 : __supplier_appraise_id.compareTo(o.getSupplierAppraiseId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__supplier_appraise_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__title);
		hash = 97 * hash + Objects.hashCode(this.__provide_product);
		hash = 97 * hash + Objects.hashCode(this.__score);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__appraise_status);
		hash = 97 * hash + Objects.hashCode(this.__advice);
		hash = 97 * hash + Objects.hashCode(this.__finish_time);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSupplierApprais o = (BaseSupplierApprais)obj;
		if(!Objects.equals(this.__supplier_appraise_id, o.getSupplierAppraiseId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__title, o.getTitle())) return false;
		if(!Objects.equals(this.__provide_product, o.getProvideProduct())) return false;
		if(!Objects.equals(this.__score, o.getScore())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__appraise_status, o.getAppraiseStatus())) return false;
		if(!Objects.equals(this.__advice, o.getAdvice())) return false;
		if(!Objects.equals(this.__finish_time, o.getFinishTime())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSupplierAppraiseId() != null) sb.append(__wrapNumber(count++, "supplierAppraiseId", getSupplierAppraiseId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getTitle() != null) sb.append(__wrapString(count++, "title", getTitle()));
		if(getProvideProduct() != null) sb.append(__wrapString(count++, "provideProduct", getProvideProduct()));
		if(getScore() != null) sb.append(__wrapDecimal(count++, "score", getScore()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getAppraiseStatus() != null) sb.append(__wrapNumber(count++, "appraiseStatus", getAppraiseStatus()));
		if(getAdvice() != null) sb.append(__wrapString(count++, "advice", getAdvice()));
		if(getFinishTime() != null) sb.append(__wrapDate(count++, "finishTime", getFinishTime()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSupplierAppraiseId() != null) res.put("supplierAppraiseId", getSupplierAppraiseId());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getTitle() != null) res.put("title", getTitle());
		if(getProvideProduct() != null) res.put("provideProduct", getProvideProduct());
		if(getScore() != null) res.put("score", getScore());
		if(getReason() != null) res.put("reason", getReason());
		if(getAppraiseStatus() != null) res.put("appraiseStatus", getAppraiseStatus());
		if(getAdvice() != null) res.put("advice", getAdvice());
		if(getFinishTime() != null) res.put("finishTime", getFinishTime());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("supplierAppraiseId")) != null) setSupplierAppraiseId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("provideProduct")) != null) setProvideProduct(__getString(val));
		if((val = values.get("score")) != null) setScore(__getDecimal(val));  
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("appraiseStatus")) != null) setAppraiseStatus(__getInt(val)); 
		if((val = values.get("advice")) != null) setAdvice(__getString(val));
		if((val = values.get("finishTime")) != null) setFinishTime(__getDate(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __supplier_appraise_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __title ;
	protected java.lang.String  __provide_product ;
	protected java.math.BigDecimal  __score ;
	protected java.lang.String  __reason ;
	protected java.lang.Integer  __appraise_status ;
	protected java.lang.String  __advice ;
	protected java.util.Date  __finish_time ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
