package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeCostRecord extends GenericBase implements BaseFactory<BaseEmployeeCostRecord>, Comparable<BaseEmployeeCostRecord> 
{


	public static BaseEmployeeCostRecord newInstance(){
		return new BaseEmployeeCostRecord();
	}

	@Override
	public BaseEmployeeCostRecord make(){
		BaseEmployeeCostRecord b = new BaseEmployeeCostRecord();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_COST_RECORD_ID = "employee_cost_record_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工编码,员工编号";

	public java.lang.Integer getEmployeeCostRecordId() {
		return this.__employee_cost_record_id;
	}

	public void setEmployeeCostRecordId( java.lang.Integer value ) {
		this.__employee_cost_record_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public void cloneCopy(BaseEmployeeCostRecord __bean){
		__bean.setEmployeeCostRecordId(getEmployeeCostRecordId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeCostRecordId() == null ? "" : getEmployeeCostRecordId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeCostRecord o) {
		return __employee_cost_record_id == null ? -1 : __employee_cost_record_id.compareTo(o.getEmployeeCostRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_cost_record_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeCostRecord o = (BaseEmployeeCostRecord)obj;
		if(!Objects.equals(this.__employee_cost_record_id, o.getEmployeeCostRecordId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeCostRecordId() != null) sb.append(__wrapNumber(count++, "employeeCostRecordId", getEmployeeCostRecordId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeCostRecordId() != null) res.put("employeeCostRecordId", getEmployeeCostRecordId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeCostRecordId")) != null) setEmployeeCostRecordId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
	}

	protected java.lang.Integer  __employee_cost_record_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
}
