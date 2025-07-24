package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSupplierCooperation extends GenericBase implements BaseFactory<BaseSupplierCooperation>, Comparable<BaseSupplierCooperation> 
{


	public static BaseSupplierCooperation newInstance(){
		return new BaseSupplierCooperation();
	}

	@Override
	public BaseSupplierCooperation make(){
		BaseSupplierCooperation b = new BaseSupplierCooperation();
		return b;
	}

	public final static java.lang.String CS_SUPPLIER_COOPERATION_ID = "supplier_cooperation_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_LEADER = "project_leader" ;
	public final static java.lang.String CS_SUPPLIER_EVALUATE = "supplier_evaluate" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,供应商编码,合作项目名称,项目负责人,供应商评价";

	public java.lang.Integer getSupplierCooperationId() {
		return this.__supplier_cooperation_id;
	}

	public void setSupplierCooperationId( java.lang.Integer value ) {
		this.__supplier_cooperation_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectLeader() {
		return this.__project_leader;
	}

	public void setProjectLeader( java.lang.String value ) {
		this.__project_leader = value;
	}

	public java.lang.String getSupplierEvaluate() {
		return this.__supplier_evaluate;
	}

	public void setSupplierEvaluate( java.lang.String value ) {
		this.__supplier_evaluate = value;
	}

	public void cloneCopy(BaseSupplierCooperation __bean){
		__bean.setSupplierCooperationId(getSupplierCooperationId());
		__bean.setSupplierId(getSupplierId());
		__bean.setProjectName(getProjectName());
		__bean.setProjectLeader(getProjectLeader());
		__bean.setSupplierEvaluate(getSupplierEvaluate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSupplierCooperationId() == null ? "" : getSupplierCooperationId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectLeader() == null ? "" : getProjectLeader());
		sb.append(",");
		sb.append(getSupplierEvaluate() == null ? "" : getSupplierEvaluate());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSupplierCooperation o) {
		return __supplier_cooperation_id == null ? -1 : __supplier_cooperation_id.compareTo(o.getSupplierCooperationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__supplier_cooperation_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_leader);
		hash = 97 * hash + Objects.hashCode(this.__supplier_evaluate);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSupplierCooperation o = (BaseSupplierCooperation)obj;
		if(!Objects.equals(this.__supplier_cooperation_id, o.getSupplierCooperationId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_leader, o.getProjectLeader())) return false;
		if(!Objects.equals(this.__supplier_evaluate, o.getSupplierEvaluate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSupplierCooperationId() != null) sb.append(__wrapNumber(count++, "supplierCooperationId", getSupplierCooperationId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectLeader() != null) sb.append(__wrapString(count++, "projectLeader", getProjectLeader()));
		if(getSupplierEvaluate() != null) sb.append(__wrapString(count++, "supplierEvaluate", getSupplierEvaluate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("supplierCooperationId")) != null) setSupplierCooperationId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectLeader")) != null) setProjectLeader(__getString(val));
		if((val = values.get("supplierEvaluate")) != null) setSupplierEvaluate(__getString(val));
	}

	protected java.lang.Integer  __supplier_cooperation_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_leader ;
	protected java.lang.String  __supplier_evaluate ;
}
