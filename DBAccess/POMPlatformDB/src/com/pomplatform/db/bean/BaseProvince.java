package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProvince extends GenericBase implements BaseFactory<BaseProvince>, Comparable<BaseProvince> 
{


	public static BaseProvince newInstance(){
		return new BaseProvince();
	}

	@Override
	public BaseProvince make(){
		BaseProvince b = new BaseProvince();
		return b;
	}

	public final static java.lang.String CS_PROVINCE_ID = "province_id" ;
	public final static java.lang.String CS_PROVINCE_NAME_EN = "province_name_en" ;
	public final static java.lang.String CS_PROVINCE_NAME_CN = "province_name_cn" ;
	public final static java.lang.String CS_COUNTRY_ID = "country_id" ;
	public final static java.lang.String CS_PROVINCE_IS_ENABLE = "province_is_enable" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,省份英文名称,省份中文名称,上级国家,省份是否可用";

	public java.lang.Integer getProvinceId() {
		return this.__province_id;
	}

	public void setProvinceId( java.lang.Integer value ) {
		this.__province_id = value;
	}

	public java.lang.String getProvinceNameEn() {
		return this.__province_name_en;
	}

	public void setProvinceNameEn( java.lang.String value ) {
		this.__province_name_en = value;
	}

	public java.lang.String getProvinceNameCn() {
		return this.__province_name_cn;
	}

	public void setProvinceNameCn( java.lang.String value ) {
		this.__province_name_cn = value;
	}

	public java.lang.Integer getCountryId() {
		return this.__country_id;
	}

	public void setCountryId( java.lang.Integer value ) {
		this.__country_id = value;
	}

	public java.lang.Boolean getProvinceIsEnable() {
		return this.__province_is_enable;
	}

	public void setProvinceIsEnable( java.lang.Boolean value ) {
		this.__province_is_enable = value;
	}

	public void cloneCopy(BaseProvince __bean){
		__bean.setProvinceId(getProvinceId());
		__bean.setProvinceNameEn(getProvinceNameEn());
		__bean.setProvinceNameCn(getProvinceNameCn());
		__bean.setCountryId(getCountryId());
		__bean.setProvinceIsEnable(getProvinceIsEnable());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProvinceId() == null ? "" : getProvinceId());
		sb.append(",");
		sb.append(getProvinceNameEn() == null ? "" : getProvinceNameEn());
		sb.append(",");
		sb.append(getProvinceNameCn() == null ? "" : getProvinceNameCn());
		sb.append(",");
		sb.append(getCountryId() == null ? "" : getCountryId());
		sb.append(",");
		sb.append(getProvinceIsEnable() == null ? "" : getProvinceIsEnable());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProvince o) {
		return __province_id == null ? -1 : __province_id.compareTo(o.getProvinceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__province_id);
		hash = 97 * hash + Objects.hashCode(this.__province_name_en);
		hash = 97 * hash + Objects.hashCode(this.__province_name_cn);
		hash = 97 * hash + Objects.hashCode(this.__country_id);
		hash = 97 * hash + Objects.hashCode(this.__province_is_enable);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProvince o = (BaseProvince)obj;
		if(!Objects.equals(this.__province_id, o.getProvinceId())) return false;
		if(!Objects.equals(this.__province_name_en, o.getProvinceNameEn())) return false;
		if(!Objects.equals(this.__province_name_cn, o.getProvinceNameCn())) return false;
		if(!Objects.equals(this.__country_id, o.getCountryId())) return false;
		if(!Objects.equals(this.__province_is_enable, o.getProvinceIsEnable())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProvinceId() != null) sb.append(__wrapNumber(count++, "provinceId", getProvinceId()));
		if(getProvinceNameEn() != null) sb.append(__wrapString(count++, "provinceNameEn", getProvinceNameEn()));
		if(getProvinceNameCn() != null) sb.append(__wrapString(count++, "provinceNameCn", getProvinceNameCn()));
		if(getCountryId() != null) sb.append(__wrapNumber(count++, "countryId", getCountryId()));
		if(getProvinceIsEnable() != null) sb.append(__wrapBoolean(count++, "provinceIsEnable", getProvinceIsEnable()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("provinceId")) != null) setProvinceId(__getInt(val)); 
		if((val = values.get("provinceNameEn")) != null) setProvinceNameEn(__getString(val));
		if((val = values.get("provinceNameCn")) != null) setProvinceNameCn(__getString(val));
		if((val = values.get("countryId")) != null) setCountryId(__getInt(val)); 
		if((val = values.get("provinceIsEnable")) != null) setProvinceIsEnable(__getBoolean(val));
	}

	protected java.lang.Integer  __province_id ;
	protected java.lang.String  __province_name_en ;
	protected java.lang.String  __province_name_cn ;
	protected java.lang.Integer  __country_id ;
	protected java.lang.Boolean  __province_is_enable ;
}
