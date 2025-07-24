package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSupplierAppraiseDetail extends GenericBase implements BaseFactory<BaseSupplierAppraiseDetail>, Comparable<BaseSupplierAppraiseDetail> 
{


	public static BaseSupplierAppraiseDetail newInstance(){
		return new BaseSupplierAppraiseDetail();
	}

	@Override
	public BaseSupplierAppraiseDetail make(){
		BaseSupplierAppraiseDetail b = new BaseSupplierAppraiseDetail();
		return b;
	}

	public final static java.lang.String CS_SUPPLIER_APPRAISE_DETAIL_ID = "supplier_appraise_detail_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_SUPPLIER_APPRAISE_ID = "supplier_appraise_id" ;
	public final static java.lang.String CS_APPRAISE_TYPE = "appraise_type" ;
	public final static java.lang.String CS_SCORE_TYPE = "score_type" ;
	public final static java.lang.String CS_SCORE = "score" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,供应商id,评价表主键id,评价类型(对应字典表system_dictionary_190),类型(对应表supplier_score_records),分数,创建人,创建时间,备注";

	public java.lang.Integer getSupplierAppraiseDetailId() {
		return this.__supplier_appraise_detail_id;
	}

	public void setSupplierAppraiseDetailId( java.lang.Integer value ) {
		this.__supplier_appraise_detail_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.Integer getSupplierAppraiseId() {
		return this.__supplier_appraise_id;
	}

	public void setSupplierAppraiseId( java.lang.Integer value ) {
		this.__supplier_appraise_id = value;
	}

	public java.lang.Integer getAppraiseType() {
		return this.__appraise_type;
	}

	public void setAppraiseType( java.lang.Integer value ) {
		this.__appraise_type = value;
	}

	public java.lang.Integer getScoreType() {
		return this.__score_type;
	}

	public void setScoreType( java.lang.Integer value ) {
		this.__score_type = value;
	}

	public java.math.BigDecimal getScore() {
		return this.__score;
	}

	public void setScore( java.math.BigDecimal value ) {
		this.__score = value;
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

	public void cloneCopy(BaseSupplierAppraiseDetail __bean){
		__bean.setSupplierAppraiseDetailId(getSupplierAppraiseDetailId());
		__bean.setSupplierId(getSupplierId());
		__bean.setSupplierAppraiseId(getSupplierAppraiseId());
		__bean.setAppraiseType(getAppraiseType());
		__bean.setScoreType(getScoreType());
		__bean.setScore(getScore());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSupplierAppraiseDetailId() == null ? "" : getSupplierAppraiseDetailId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getSupplierAppraiseId() == null ? "" : getSupplierAppraiseId());
		sb.append(",");
		sb.append(getAppraiseType() == null ? "" : getAppraiseType());
		sb.append(",");
		sb.append(getScoreType() == null ? "" : getScoreType());
		sb.append(",");
		sb.append(getScore() == null ? "" : getScore());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSupplierAppraiseDetail o) {
		return __supplier_appraise_detail_id == null ? -1 : __supplier_appraise_detail_id.compareTo(o.getSupplierAppraiseDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__supplier_appraise_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_appraise_id);
		hash = 97 * hash + Objects.hashCode(this.__appraise_type);
		hash = 97 * hash + Objects.hashCode(this.__score_type);
		hash = 97 * hash + Objects.hashCode(this.__score);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSupplierAppraiseDetail o = (BaseSupplierAppraiseDetail)obj;
		if(!Objects.equals(this.__supplier_appraise_detail_id, o.getSupplierAppraiseDetailId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__supplier_appraise_id, o.getSupplierAppraiseId())) return false;
		if(!Objects.equals(this.__appraise_type, o.getAppraiseType())) return false;
		if(!Objects.equals(this.__score_type, o.getScoreType())) return false;
		if(!Objects.equals(this.__score, o.getScore())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSupplierAppraiseDetailId() != null) sb.append(__wrapNumber(count++, "supplierAppraiseDetailId", getSupplierAppraiseDetailId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getSupplierAppraiseId() != null) sb.append(__wrapNumber(count++, "supplierAppraiseId", getSupplierAppraiseId()));
		if(getAppraiseType() != null) sb.append(__wrapNumber(count++, "appraiseType", getAppraiseType()));
		if(getScoreType() != null) sb.append(__wrapNumber(count++, "scoreType", getScoreType()));
		if(getScore() != null) sb.append(__wrapDecimal(count++, "score", getScore()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSupplierAppraiseDetailId() != null) res.put("supplierAppraiseDetailId", getSupplierAppraiseDetailId());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getSupplierAppraiseId() != null) res.put("supplierAppraiseId", getSupplierAppraiseId());
		if(getAppraiseType() != null) res.put("appraiseType", getAppraiseType());
		if(getScoreType() != null) res.put("scoreType", getScoreType());
		if(getScore() != null) res.put("score", getScore());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("supplierAppraiseDetailId")) != null) setSupplierAppraiseDetailId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("supplierAppraiseId")) != null) setSupplierAppraiseId(__getInt(val)); 
		if((val = values.get("appraiseType")) != null) setAppraiseType(__getInt(val)); 
		if((val = values.get("scoreType")) != null) setScoreType(__getInt(val)); 
		if((val = values.get("score")) != null) setScore(__getDecimal(val));  
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __supplier_appraise_detail_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.Integer  __supplier_appraise_id ;
	protected java.lang.Integer  __appraise_type ;
	protected java.lang.Integer  __score_type ;
	protected java.math.BigDecimal  __score ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
