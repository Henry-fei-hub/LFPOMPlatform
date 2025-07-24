package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeManagerRecord extends GenericBase implements BaseFactory<BaseEmployeeManagerRecord>, Comparable<BaseEmployeeManagerRecord> 
{


	public static BaseEmployeeManagerRecord newInstance(){
		return new BaseEmployeeManagerRecord();
	}

	@Override
	public BaseEmployeeManagerRecord make(){
		BaseEmployeeManagerRecord b = new BaseEmployeeManagerRecord();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_MANAGER_RECORD_ID = "employee_manager_record_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,编码,编码,编号,姓名";

	public java.lang.Integer getEmployeeManagerRecordId() {
		return this.__employee_manager_record_id;
	}

	public void setEmployeeManagerRecordId( java.lang.Integer value ) {
		this.__employee_manager_record_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public void cloneCopy(BaseEmployeeManagerRecord __bean){
		__bean.setEmployeeManagerRecordId(getEmployeeManagerRecordId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeManagerRecordId() == null ? "" : getEmployeeManagerRecordId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeManagerRecord o) {
		return __employee_manager_record_id == null ? -1 : __employee_manager_record_id.compareTo(o.getEmployeeManagerRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_manager_record_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeManagerRecord o = (BaseEmployeeManagerRecord)obj;
		if(!Objects.equals(this.__employee_manager_record_id, o.getEmployeeManagerRecordId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeManagerRecordId() != null) sb.append(__wrapNumber(count++, "employeeManagerRecordId", getEmployeeManagerRecordId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeManagerRecordId")) != null) setEmployeeManagerRecordId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
	}

	protected java.lang.Integer  __employee_manager_record_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
}
