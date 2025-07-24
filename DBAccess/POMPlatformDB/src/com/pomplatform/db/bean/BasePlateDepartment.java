package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateDepartment extends GenericBase implements BaseFactory<BasePlateDepartment>, Comparable<BasePlateDepartment> 
{


	public static BasePlateDepartment newInstance(){
		return new BasePlateDepartment();
	}

	@Override
	public BasePlateDepartment make(){
		BasePlateDepartment b = new BasePlateDepartment();
		return b;
	}

	public final static java.lang.String CS_PLATE_DEPARTMENT_ID = "plate_department_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工功能列表编码,业务部门编码,归属部门编码";

	public java.lang.Integer getPlateDepartmentId() {
		return this.__plate_department_id;
	}

	public void setPlateDepartmentId( java.lang.Integer value ) {
		this.__plate_department_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public void cloneCopy(BasePlateDepartment __bean){
		__bean.setPlateDepartmentId(getPlateDepartmentId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateDepartmentId() == null ? "" : getPlateDepartmentId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateDepartment o) {
		return __plate_department_id == null ? -1 : __plate_department_id.compareTo(o.getPlateDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_department_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateDepartment o = (BasePlateDepartment)obj;
		if(!Objects.equals(this.__plate_department_id, o.getPlateDepartmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateDepartmentId() != null) sb.append(__wrapNumber(count++, "plateDepartmentId", getPlateDepartmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateDepartmentId")) != null) setPlateDepartmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	protected java.lang.Integer  __plate_department_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
}
