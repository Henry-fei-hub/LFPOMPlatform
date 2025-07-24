package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCommissionSettlementRecord extends GenericBase implements BaseFactory<BaseCommissionSettlementRecord>, Comparable<BaseCommissionSettlementRecord> 
{


	public static BaseCommissionSettlementRecord newInstance(){
		return new BaseCommissionSettlementRecord();
	}

	@Override
	public BaseCommissionSettlementRecord make(){
		BaseCommissionSettlementRecord b = new BaseCommissionSettlementRecord();
		return b;
	}

	public final static java.lang.String CS_COMMISSION_SETTLEMENT_RECORD_ID = "commission_settlement_record_id" ;
	public final static java.lang.String CS_ORDER_ID = "order_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_COUNT_TYPE = "count_type" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_SETTLEMENT_TYPE = "settlement_type" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_SETTLEMENT_TIME = "settlement_time" ;

	public final static java.lang.String ALL_CAPTIONS = "提成结算记录Id,订单编码,项目名,账户类型1个人账户2公司账户3.提成虚拟账户,员工编码,部门编码,结算类型1收入2支出,结算金额,";

	public java.lang.Integer getCommissionSettlementRecordId() {
		return this.__commission_settlement_record_id;
	}

	public void setCommissionSettlementRecordId( java.lang.Integer value ) {
		this.__commission_settlement_record_id = value;
	}

	public java.lang.String getOrderId() {
		return this.__order_id;
	}

	public void setOrderId( java.lang.String value ) {
		this.__order_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getCountType() {
		return this.__count_type;
	}

	public void setCountType( java.lang.Integer value ) {
		this.__count_type = value;
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

	public java.lang.Integer getSettlementType() {
		return this.__settlement_type;
	}

	public void setSettlementType( java.lang.Integer value ) {
		this.__settlement_type = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.util.Date getSettlementTime() {
		return this.__settlement_time;
	}

	public void setSettlementTime( java.util.Date value ) {
		this.__settlement_time = value;
	}

	public void cloneCopy(BaseCommissionSettlementRecord __bean){
		__bean.setCommissionSettlementRecordId(getCommissionSettlementRecordId());
		__bean.setOrderId(getOrderId());
		__bean.setProjectName(getProjectName());
		__bean.setCountType(getCountType());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setSettlementType(getSettlementType());
		__bean.setAmount(getAmount());
		__bean.setSettlementTime(getSettlementTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCommissionSettlementRecordId() == null ? "" : getCommissionSettlementRecordId());
		sb.append(",");
		sb.append(getOrderId() == null ? "" : getOrderId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getCountType() == null ? "" : getCountType());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getSettlementType() == null ? "" : getSettlementType());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getSettlementTime() == null ? "" : sdf.format(getSettlementTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCommissionSettlementRecord o) {
		return __commission_settlement_record_id == null ? -1 : __commission_settlement_record_id.compareTo(o.getCommissionSettlementRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__commission_settlement_record_id);
		hash = 97 * hash + Objects.hashCode(this.__order_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__count_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__settlement_type);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__settlement_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCommissionSettlementRecord o = (BaseCommissionSettlementRecord)obj;
		if(!Objects.equals(this.__commission_settlement_record_id, o.getCommissionSettlementRecordId())) return false;
		if(!Objects.equals(this.__order_id, o.getOrderId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__count_type, o.getCountType())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__settlement_type, o.getSettlementType())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__settlement_time, o.getSettlementTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCommissionSettlementRecordId() != null) sb.append(__wrapNumber(count++, "commissionSettlementRecordId", getCommissionSettlementRecordId()));
		if(getOrderId() != null) sb.append(__wrapString(count++, "orderId", getOrderId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getCountType() != null) sb.append(__wrapNumber(count++, "countType", getCountType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getSettlementType() != null) sb.append(__wrapNumber(count++, "settlementType", getSettlementType()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getSettlementTime() != null) sb.append(__wrapDate(count++, "settlementTime", getSettlementTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("commissionSettlementRecordId")) != null) setCommissionSettlementRecordId(__getInt(val)); 
		if((val = values.get("orderId")) != null) setOrderId(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("countType")) != null) setCountType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("settlementType")) != null) setSettlementType(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("settlementTime")) != null) setSettlementTime(__getDate(val)); 
	}

	protected java.lang.Integer  __commission_settlement_record_id ;
	protected java.lang.String  __order_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __count_type ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __settlement_type ;
	protected java.math.BigDecimal  __amount ;
	protected java.util.Date  __settlement_time ;
}
