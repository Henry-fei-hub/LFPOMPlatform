package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeInitialBalance extends GenericBase implements BaseFactory<BaseEmployeeInitialBalance>, Comparable<BaseEmployeeInitialBalance> 
{


	public static BaseEmployeeInitialBalance newInstance(){
		return new BaseEmployeeInitialBalance();
	}

	@Override
	public BaseEmployeeInitialBalance make(){
		BaseEmployeeInitialBalance b = new BaseEmployeeInitialBalance();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_INITIAL_BALANCE_ID = "employee_initial_balance_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_INITIAL_BALANCE = "initial_balance" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,员工主键,期初余额,发生日期,操作人,创建日期";

	public java.lang.Integer getEmployeeInitialBalanceId() {
		return this.__employee_initial_balance_id;
	}

	public void setEmployeeInitialBalanceId( java.lang.Integer value ) {
		this.__employee_initial_balance_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getInitialBalance() {
		return this.__initial_balance;
	}

	public void setInitialBalance( java.math.BigDecimal value ) {
		this.__initial_balance = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseEmployeeInitialBalance __bean){
		__bean.setEmployeeInitialBalanceId(getEmployeeInitialBalanceId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setInitialBalance(getInitialBalance());
		__bean.setHappenDate(getHappenDate());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeInitialBalanceId() == null ? "" : getEmployeeInitialBalanceId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getInitialBalance() == null ? "" : getInitialBalance());
		sb.append(",");
		sb.append(getHappenDate() == null ? "" : sdf.format(getHappenDate()));
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeInitialBalance o) {
		return __employee_initial_balance_id == null ? -1 : __employee_initial_balance_id.compareTo(o.getEmployeeInitialBalanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_initial_balance_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__initial_balance);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeInitialBalance o = (BaseEmployeeInitialBalance)obj;
		if(!Objects.equals(this.__employee_initial_balance_id, o.getEmployeeInitialBalanceId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__initial_balance, o.getInitialBalance())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeInitialBalanceId() != null) sb.append(__wrapNumber(count++, "employeeInitialBalanceId", getEmployeeInitialBalanceId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getInitialBalance() != null) sb.append(__wrapDecimal(count++, "initialBalance", getInitialBalance()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeInitialBalanceId")) != null) setEmployeeInitialBalanceId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("initialBalance")) != null) setInitialBalance(__getDecimal(val));  
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __employee_initial_balance_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __initial_balance ;
	protected java.util.Date  __happen_date ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
}
