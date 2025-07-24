package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseBorrowLimitManage extends GenericBase implements BaseFactory<BaseBorrowLimitManage>, Comparable<BaseBorrowLimitManage> 
{


	public static BaseBorrowLimitManage newInstance(){
		return new BaseBorrowLimitManage();
	}

	@Override
	public BaseBorrowLimitManage make(){
		BaseBorrowLimitManage b = new BaseBorrowLimitManage();
		return b;
	}

	public final static java.lang.String CS_BORROW_LIMIT_MANAGE_ID = "borrow_limit_manage_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_BORROW_LIMIT_MONEY = "borrow_limit_money" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_UPDATE_EMPLOYEE_ID = "update_employee_id" ;
	public final static java.lang.String CS_UPDATE_DATE = "update_date" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员编码,借款额度,创建人,创建日期,更新人,更新日期";

	public java.lang.Integer getBorrowLimitManageId() {
		return this.__borrow_limit_manage_id;
	}

	public void setBorrowLimitManageId( java.lang.Integer value ) {
		this.__borrow_limit_manage_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getBorrowLimitMoney() {
		return this.__borrow_limit_money;
	}

	public void setBorrowLimitMoney( java.math.BigDecimal value ) {
		this.__borrow_limit_money = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.Integer getUpdateEmployeeId() {
		return this.__update_employee_id;
	}

	public void setUpdateEmployeeId( java.lang.Integer value ) {
		this.__update_employee_id = value;
	}

	public java.util.Date getUpdateDate() {
		return this.__update_date;
	}

	public void setUpdateDate( java.util.Date value ) {
		this.__update_date = value;
	}

	public void cloneCopy(BaseBorrowLimitManage __bean){
		__bean.setBorrowLimitManageId(getBorrowLimitManageId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setBorrowLimitMoney(getBorrowLimitMoney());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateDate(getCreateDate());
		__bean.setUpdateEmployeeId(getUpdateEmployeeId());
		__bean.setUpdateDate(getUpdateDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBorrowLimitManageId() == null ? "" : getBorrowLimitManageId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getBorrowLimitMoney() == null ? "" : getBorrowLimitMoney());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getUpdateEmployeeId() == null ? "" : getUpdateEmployeeId());
		sb.append(",");
		sb.append(getUpdateDate() == null ? "" : sdf.format(getUpdateDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBorrowLimitManage o) {
		return __borrow_limit_manage_id == null ? -1 : __borrow_limit_manage_id.compareTo(o.getBorrowLimitManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__borrow_limit_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__borrow_limit_money);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__update_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__update_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBorrowLimitManage o = (BaseBorrowLimitManage)obj;
		if(!Objects.equals(this.__borrow_limit_manage_id, o.getBorrowLimitManageId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__borrow_limit_money, o.getBorrowLimitMoney())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__update_employee_id, o.getUpdateEmployeeId())) return false;
		if(!Objects.equals(this.__update_date, o.getUpdateDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBorrowLimitManageId() != null) sb.append(__wrapNumber(count++, "borrowLimitManageId", getBorrowLimitManageId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getBorrowLimitMoney() != null) sb.append(__wrapDecimal(count++, "borrowLimitMoney", getBorrowLimitMoney()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getUpdateEmployeeId() != null) sb.append(__wrapNumber(count++, "updateEmployeeId", getUpdateEmployeeId()));
		if(getUpdateDate() != null) sb.append(__wrapDate(count++, "updateDate", getUpdateDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("borrowLimitManageId")) != null) setBorrowLimitManageId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("borrowLimitMoney")) != null) setBorrowLimitMoney(__getDecimal(val));  
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("updateEmployeeId")) != null) setUpdateEmployeeId(__getInt(val)); 
		if((val = values.get("updateDate")) != null) setUpdateDate(__getDate(val)); 
	}

	protected java.lang.Integer  __borrow_limit_manage_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __borrow_limit_money ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_date ;
	protected java.lang.Integer  __update_employee_id ;
	protected java.util.Date  __update_date ;
}
