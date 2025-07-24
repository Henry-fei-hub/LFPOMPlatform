package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCity extends GenericBase implements BaseFactory<BaseCity>, Comparable<BaseCity> 
{


	public static BaseCity newInstance(){
		return new BaseCity();
	}

	@Override
	public BaseCity make(){
		BaseCity b = new BaseCity();
		return b;
	}

	public final static java.lang.String CS_CITY_ID = "city_id" ;
	public final static java.lang.String CS_CITY_NAME_EN = "city_name_en" ;
	public final static java.lang.String CS_CITY_NAME_CN = "city_name_cn" ;
	public final static java.lang.String CS_PROVINCE_ID = "province_id" ;
	public final static java.lang.String CS_CITY_IS_ENABLE = "city_is_enable" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,名称,名称,上级省份,城市是否可用";

	public java.lang.Integer getCityId() {
		return this.__city_id;
	}

	public void setCityId( java.lang.Integer value ) {
		this.__city_id = value;
	}

	public java.lang.String getCityNameEn() {
		return this.__city_name_en;
	}

	public void setCityNameEn( java.lang.String value ) {
		this.__city_name_en = value;
	}

	public java.lang.String getCityNameCn() {
		return this.__city_name_cn;
	}

	public void setCityNameCn( java.lang.String value ) {
		this.__city_name_cn = value;
	}

	public java.lang.Integer getProvinceId() {
		return this.__province_id;
	}

	public void setProvinceId( java.lang.Integer value ) {
		this.__province_id = value;
	}

	public java.lang.Boolean getCityIsEnable() {
		return this.__city_is_enable;
	}

	public void setCityIsEnable( java.lang.Boolean value ) {
		this.__city_is_enable = value;
	}

	public void cloneCopy(BaseCity __bean){
		__bean.setCityId(getCityId());
		__bean.setCityNameEn(getCityNameEn());
		__bean.setCityNameCn(getCityNameCn());
		__bean.setProvinceId(getProvinceId());
		__bean.setCityIsEnable(getCityIsEnable());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCityId() == null ? "" : getCityId());
		sb.append(",");
		sb.append(getCityNameEn() == null ? "" : getCityNameEn());
		sb.append(",");
		sb.append(getCityNameCn() == null ? "" : getCityNameCn());
		sb.append(",");
		sb.append(getProvinceId() == null ? "" : getProvinceId());
		sb.append(",");
		sb.append(getCityIsEnable() == null ? "" : getCityIsEnable());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCity o) {
		return __city_id == null ? -1 : __city_id.compareTo(o.getCityId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__city_id);
		hash = 97 * hash + Objects.hashCode(this.__city_name_en);
		hash = 97 * hash + Objects.hashCode(this.__city_name_cn);
		hash = 97 * hash + Objects.hashCode(this.__province_id);
		hash = 97 * hash + Objects.hashCode(this.__city_is_enable);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCity o = (BaseCity)obj;
		if(!Objects.equals(this.__city_id, o.getCityId())) return false;
		if(!Objects.equals(this.__city_name_en, o.getCityNameEn())) return false;
		if(!Objects.equals(this.__city_name_cn, o.getCityNameCn())) return false;
		if(!Objects.equals(this.__province_id, o.getProvinceId())) return false;
		if(!Objects.equals(this.__city_is_enable, o.getCityIsEnable())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCityId() != null) sb.append(__wrapNumber(count++, "cityId", getCityId()));
		if(getCityNameEn() != null) sb.append(__wrapString(count++, "cityNameEn", getCityNameEn()));
		if(getCityNameCn() != null) sb.append(__wrapString(count++, "cityNameCn", getCityNameCn()));
		if(getProvinceId() != null) sb.append(__wrapNumber(count++, "provinceId", getProvinceId()));
		if(getCityIsEnable() != null) sb.append(__wrapBoolean(count++, "cityIsEnable", getCityIsEnable()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cityId")) != null) setCityId(__getInt(val)); 
		if((val = values.get("cityNameEn")) != null) setCityNameEn(__getString(val));
		if((val = values.get("cityNameCn")) != null) setCityNameCn(__getString(val));
		if((val = values.get("provinceId")) != null) setProvinceId(__getInt(val)); 
		if((val = values.get("cityIsEnable")) != null) setCityIsEnable(__getBoolean(val));
	}

	protected java.lang.Integer  __city_id ;
	protected java.lang.String  __city_name_en ;
	protected java.lang.String  __city_name_cn ;
	protected java.lang.Integer  __province_id ;
	protected java.lang.Boolean  __city_is_enable ;
}
