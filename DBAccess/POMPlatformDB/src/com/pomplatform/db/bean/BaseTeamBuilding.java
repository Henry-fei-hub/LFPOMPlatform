package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseTeamBuilding extends GenericBase implements BaseFactory<BaseTeamBuilding>, Comparable<BaseTeamBuilding> 
{


	public static BaseTeamBuilding newInstance(){
		return new BaseTeamBuilding();
	}

	@Override
	public BaseTeamBuilding make(){
		BaseTeamBuilding b = new BaseTeamBuilding();
		return b;
	}

	public final static java.lang.String CS_TEAM_BUILDING_ID = "team_building_id" ;
	public final static java.lang.String CS_ORDER_ID = "order_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_RATE = "rate" ;
	public final static java.lang.String CS_SETTLEMENT = "settlement" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,订单Id,员工,部门编码,所占比例,分配的积分,合同Id";

	public java.lang.Integer getTeamBuildingId() {
		return this.__team_building_id;
	}

	public void setTeamBuildingId( java.lang.Integer value ) {
		this.__team_building_id = value;
	}

	public java.lang.String getOrderId() {
		return this.__order_id;
	}

	public void setOrderId( java.lang.String value ) {
		this.__order_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getRate() {
		return this.__rate;
	}

	public void setRate( java.lang.Integer value ) {
		this.__rate = value;
	}

	public java.math.BigDecimal getSettlement() {
		return this.__settlement;
	}

	public void setSettlement( java.math.BigDecimal value ) {
		this.__settlement = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public void cloneCopy(BaseTeamBuilding __bean){
		__bean.setTeamBuildingId(getTeamBuildingId());
		__bean.setOrderId(getOrderId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRate(getRate());
		__bean.setSettlement(getSettlement());
		__bean.setContractId(getContractId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getTeamBuildingId() == null ? "" : getTeamBuildingId());
		sb.append(",");
		sb.append(getOrderId() == null ? "" : getOrderId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getRate() == null ? "" : getRate());
		sb.append(",");
		sb.append(getSettlement() == null ? "" : getSettlement());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTeamBuilding o) {
		return __team_building_id == null ? -1 : __team_building_id.compareTo(o.getTeamBuildingId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__team_building_id);
		hash = 97 * hash + Objects.hashCode(this.__order_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__rate);
		hash = 97 * hash + Objects.hashCode(this.__settlement);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTeamBuilding o = (BaseTeamBuilding)obj;
		if(!Objects.equals(this.__team_building_id, o.getTeamBuildingId())) return false;
		if(!Objects.equals(this.__order_id, o.getOrderId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__rate, o.getRate())) return false;
		if(!Objects.equals(this.__settlement, o.getSettlement())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTeamBuildingId() != null) sb.append(__wrapNumber(count++, "teamBuildingId", getTeamBuildingId()));
		if(getOrderId() != null) sb.append(__wrapString(count++, "orderId", getOrderId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getRate() != null) sb.append(__wrapNumber(count++, "rate", getRate()));
		if(getSettlement() != null) sb.append(__wrapDecimal(count++, "settlement", getSettlement()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getTeamBuildingId() != null) res.put("teamBuildingId", getTeamBuildingId());
		if(getOrderId() != null) res.put("orderId", getOrderId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getRate() != null) res.put("rate", getRate());
		if(getSettlement() != null) res.put("settlement", getSettlement());
		if(getContractId() != null) res.put("contractId", getContractId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("teamBuildingId")) != null) setTeamBuildingId(__getInt(val)); 
		if((val = values.get("orderId")) != null) setOrderId(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("rate")) != null) setRate(__getInt(val)); 
		if((val = values.get("settlement")) != null) setSettlement(__getDecimal(val));  
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
	}

	protected java.lang.Integer  __team_building_id ;
	protected java.lang.String  __order_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __rate ;
	protected java.math.BigDecimal  __settlement ;
	protected java.lang.Integer  __contract_id ;
}
