package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseStorageArea extends GenericBase implements BaseFactory<BaseStorageArea>, Comparable<BaseStorageArea> 
{


	public static BaseStorageArea newInstance(){
		return new BaseStorageArea();
	}

	@Override
	public BaseStorageArea make(){
		BaseStorageArea b = new BaseStorageArea();
		return b;
	}

	public final static java.lang.String CS_STORAGE_AREA_ID = "storage_area_id" ;
	public final static java.lang.String CS_AREA_CODE = "area_code" ;
	public final static java.lang.String CS_AREA_NAME = "area_name" ;
	public final static java.lang.String CS_SERIAL_NUMBER = "serial_number" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,地区编号,地区名称,序列号,创建人,创建时间,备注";

	public java.lang.Integer getStorageAreaId() {
		return this.__storage_area_id;
	}

	public void setStorageAreaId( java.lang.Integer value ) {
		this.__storage_area_id = value;
	}

	public java.lang.String getAreaCode() {
		return this.__area_code;
	}

	public void setAreaCode( java.lang.String value ) {
		this.__area_code = value;
	}

	public java.lang.String getAreaName() {
		return this.__area_name;
	}

	public void setAreaName( java.lang.String value ) {
		this.__area_name = value;
	}

	public java.lang.Integer getSerialNumber() {
		return this.__serial_number;
	}

	public void setSerialNumber( java.lang.Integer value ) {
		this.__serial_number = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseStorageArea __bean){
		__bean.setStorageAreaId(getStorageAreaId());
		__bean.setAreaCode(getAreaCode());
		__bean.setAreaName(getAreaName());
		__bean.setSerialNumber(getSerialNumber());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strStorageAreaId = delicacy.system.executor.SelectValueCache.getSelectValue("storage_areas", String.valueOf(getStorageAreaId()));
		sb.append(strStorageAreaId == null ? "" : strStorageAreaId);
		sb.append(",");
		sb.append(getAreaCode() == null ? "" : getAreaCode());
		sb.append(",");
		sb.append(getAreaName() == null ? "" : getAreaName());
		sb.append(",");
		sb.append(getSerialNumber() == null ? "" : getSerialNumber());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStorageArea o) {
		return __storage_area_id == null ? -1 : __storage_area_id.compareTo(o.getStorageAreaId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__storage_area_id);
		hash = 97 * hash + Objects.hashCode(this.__area_code);
		hash = 97 * hash + Objects.hashCode(this.__area_name);
		hash = 97 * hash + Objects.hashCode(this.__serial_number);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStorageArea o = (BaseStorageArea)obj;
		if(!Objects.equals(this.__storage_area_id, o.getStorageAreaId())) return false;
		if(!Objects.equals(this.__area_code, o.getAreaCode())) return false;
		if(!Objects.equals(this.__area_name, o.getAreaName())) return false;
		if(!Objects.equals(this.__serial_number, o.getSerialNumber())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStorageAreaId() != null) sb.append(__wrapNumber(count++, "storageAreaId", getStorageAreaId()));
		if(getAreaCode() != null) sb.append(__wrapString(count++, "areaCode", getAreaCode()));
		if(getAreaName() != null) sb.append(__wrapString(count++, "areaName", getAreaName()));
		if(getSerialNumber() != null) sb.append(__wrapNumber(count++, "serialNumber", getSerialNumber()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getStorageAreaId() != null) res.put("storageAreaId", getStorageAreaId());
		if(getAreaCode() != null) res.put("areaCode", getAreaCode());
		if(getAreaName() != null) res.put("areaName", getAreaName());
		if(getSerialNumber() != null) res.put("serialNumber", getSerialNumber());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("storageAreaId")) != null) setStorageAreaId(__getInt(val)); 
		if((val = values.get("areaCode")) != null) setAreaCode(__getString(val));
		if((val = values.get("areaName")) != null) setAreaName(__getString(val));
		if((val = values.get("serialNumber")) != null) setSerialNumber(__getInt(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __storage_area_id ;
	protected java.lang.String  __area_code ;
	protected java.lang.String  __area_name ;
	protected java.lang.Integer  __serial_number ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
