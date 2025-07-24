package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCostAllocation extends GenericBase implements BaseFactory<BaseCostAllocation>, Comparable<BaseCostAllocation> 
{


	public static BaseCostAllocation newInstance(){
		return new BaseCostAllocation();
	}

	@Override
	public BaseCostAllocation make(){
		BaseCostAllocation b = new BaseCostAllocation();
		return b;
	}

	public final static java.lang.String CS_COST_ALLOCATION_ID = "cost_allocation_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_RESET_COST_ID = "reset_cost_id" ;
	public final static java.lang.String CS_ID = "id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_COST = "cost" ;

	public final static java.lang.String ALL_CAPTIONS = "报销成本分摊表编码,  3部门成本  system_dictionary_121,（父级）成本重新归集表编码,部门或者项目编码,编号,名称,成本";

	public java.lang.Integer getCostAllocationId() {
		return this.__cost_allocation_id;
	}

	public void setCostAllocationId( java.lang.Integer value ) {
		this.__cost_allocation_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getResetCostId() {
		return this.__reset_cost_id;
	}

	public void setResetCostId( java.lang.Integer value ) {
		this.__reset_cost_id = value;
	}

	public java.lang.Integer getId() {
		return this.__id;
	}

	public void setId( java.lang.Integer value ) {
		this.__id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public void cloneCopy(BaseCostAllocation __bean){
		__bean.setCostAllocationId(getCostAllocationId());
		__bean.setType(getType());
		__bean.setResetCostId(getResetCostId());
		__bean.setId(getId());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setCost(getCost());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCostAllocationId() == null ? "" : getCostAllocationId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getResetCostId() == null ? "" : getResetCostId());
		sb.append(",");
		sb.append(getId() == null ? "" : getId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCostAllocation o) {
		return __cost_allocation_id == null ? -1 : __cost_allocation_id.compareTo(o.getCostAllocationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cost_allocation_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__reset_cost_id);
		hash = 97 * hash + Objects.hashCode(this.__id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCostAllocation o = (BaseCostAllocation)obj;
		if(!Objects.equals(this.__cost_allocation_id, o.getCostAllocationId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__reset_cost_id, o.getResetCostId())) return false;
		if(!Objects.equals(this.__id, o.getId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCostAllocationId() != null) sb.append(__wrapNumber(count++, "costAllocationId", getCostAllocationId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getResetCostId() != null) sb.append(__wrapNumber(count++, "resetCostId", getResetCostId()));
		if(getId() != null) sb.append(__wrapNumber(count++, "id", getId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("costAllocationId")) != null) setCostAllocationId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("resetCostId")) != null) setResetCostId(__getInt(val)); 
		if((val = values.get("id")) != null) setId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
	}

	protected java.lang.Integer  __cost_allocation_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __reset_cost_id ;
	protected java.lang.Integer  __id ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.math.BigDecimal  __cost ;
}
