package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompanyArea extends GenericBase implements BaseFactory<BaseCompanyArea>, Comparable<BaseCompanyArea> 
{


	public static BaseCompanyArea newInstance(){
		return new BaseCompanyArea();
	}

	@Override
	public BaseCompanyArea make(){
		BaseCompanyArea b = new BaseCompanyArea();
		return b;
	}

	public final static java.lang.String CS_COMPANY_AREA_ID = "company_area_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_AREA_ID = "area_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,公司,区域";

	public java.lang.Integer getCompanyAreaId() {
		return this.__company_area_id;
	}

	public void setCompanyAreaId( java.lang.Integer value ) {
		this.__company_area_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId( java.lang.Integer value ) {
		this.__area_id = value;
	}

	public void cloneCopy(BaseCompanyArea __bean){
		__bean.setCompanyAreaId(getCompanyAreaId());
		__bean.setCompanyId(getCompanyId());
		__bean.setAreaId(getAreaId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyAreaId() == null ? "" : getCompanyAreaId());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getAreaId() == null ? "" : getAreaId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyArea o) {
		return __company_area_id == null ? -1 : __company_area_id.compareTo(o.getCompanyAreaId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_area_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__area_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyArea o = (BaseCompanyArea)obj;
		if(!Objects.equals(this.__company_area_id, o.getCompanyAreaId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__area_id, o.getAreaId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyAreaId() != null) sb.append(__wrapNumber(count++, "companyAreaId", getCompanyAreaId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getAreaId() != null) sb.append(__wrapNumber(count++, "areaId", getAreaId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyAreaId")) != null) setCompanyAreaId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("areaId")) != null) setAreaId(__getInt(val)); 
	}

	protected java.lang.Integer  __company_area_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __area_id ;
}
