package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCarCostAllocation extends GenericBase implements BaseFactory<BaseCarCostAllocation>, Comparable<BaseCarCostAllocation> 
{


	public static BaseCarCostAllocation newInstance(){
		return new BaseCarCostAllocation();
	}

	@Override
	public BaseCarCostAllocation make(){
		BaseCarCostAllocation b = new BaseCarCostAllocation();
		return b;
	}

	public final static java.lang.String CS_CAR_COST_ALLOCATION_ID = "car_cost_allocation_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_ID = "id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_COST = "cost" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_COST_ALLOCATION = "cost_allocation" ;

	public final static java.lang.String ALL_CAPTIONS = "用车费用分摊表编码,  3部门用车,个人事务表编码,部门或者项目编码,编号,名称,成本,成本分摊比例,成本分摊";

	public java.lang.Integer getCarCostAllocationId() {
		return this.__car_cost_allocation_id;
	}

	public void setCarCostAllocationId( java.lang.Integer value ) {
		this.__car_cost_allocation_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
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

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.math.BigDecimal getCostAllocation() {
		return this.__cost_allocation;
	}

	public void setCostAllocation( java.math.BigDecimal value ) {
		this.__cost_allocation = value;
	}

	public void cloneCopy(BaseCarCostAllocation __bean){
		__bean.setCarCostAllocationId(getCarCostAllocationId());
		__bean.setType(getType());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setId(getId());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setCost(getCost());
		__bean.setPercent(getPercent());
		__bean.setCostAllocation(getCostAllocation());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCarCostAllocationId() == null ? "" : getCarCostAllocationId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getId() == null ? "" : getId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getCostAllocation() == null ? "" : getCostAllocation());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCarCostAllocation o) {
		return __car_cost_allocation_id == null ? -1 : __car_cost_allocation_id.compareTo(o.getCarCostAllocationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__car_cost_allocation_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__cost_allocation);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCarCostAllocation o = (BaseCarCostAllocation)obj;
		if(!Objects.equals(this.__car_cost_allocation_id, o.getCarCostAllocationId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__id, o.getId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__cost_allocation, o.getCostAllocation())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCarCostAllocationId() != null) sb.append(__wrapNumber(count++, "carCostAllocationId", getCarCostAllocationId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getId() != null) sb.append(__wrapNumber(count++, "id", getId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getCostAllocation() != null) sb.append(__wrapDecimal(count++, "costAllocation", getCostAllocation()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("carCostAllocationId")) != null) setCarCostAllocationId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("id")) != null) setId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("costAllocation")) != null) setCostAllocation(__getDecimal(val));  
	}

	protected java.lang.Integer  __car_cost_allocation_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __id ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.math.BigDecimal  __cost ;
	protected java.math.BigDecimal  __percent ;
	protected java.math.BigDecimal  __cost_allocation ;
}
