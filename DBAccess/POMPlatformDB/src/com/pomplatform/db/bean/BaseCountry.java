package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCountry extends GenericBase implements BaseFactory<BaseCountry>, Comparable<BaseCountry> 
{


	public static BaseCountry newInstance(){
		return new BaseCountry();
	}

	@Override
	public BaseCountry make(){
		BaseCountry b = new BaseCountry();
		return b;
	}

	public final static java.lang.String CS_COUNTRY_ID = "country_id" ;
	public final static java.lang.String CS_COUNTRY_NAME_EN = "country_name_en" ;
	public final static java.lang.String CS_COUNTRY_NAME_CN = "country_name_cn" ;
	public final static java.lang.String CS_LEVEL = "level" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_CODE = "code" ;

	public final static java.lang.String ALL_CAPTIONS = ",国家名称,国家名称,级别顺序0-...,类别，如需要指定的国家 划分为一个类别,";

	public java.lang.Integer getCountryId() {
		return this.__country_id;
	}

	public void setCountryId( java.lang.Integer value ) {
		this.__country_id = value;
	}

	public java.lang.String getCountryNameEn() {
		return this.__country_name_en;
	}

	public void setCountryNameEn( java.lang.String value ) {
		this.__country_name_en = value;
	}

	public java.lang.String getCountryNameCn() {
		return this.__country_name_cn;
	}

	public void setCountryNameCn( java.lang.String value ) {
		this.__country_name_cn = value;
	}

	public java.lang.Integer getLevel() {
		return this.__level;
	}

	public void setLevel( java.lang.Integer value ) {
		this.__level = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public void cloneCopy(BaseCountry __bean){
		__bean.setCountryId(getCountryId());
		__bean.setCountryNameEn(getCountryNameEn());
		__bean.setCountryNameCn(getCountryNameCn());
		__bean.setLevel(getLevel());
		__bean.setType(getType());
		__bean.setCode(getCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strCountryId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getCountryId()));
		sb.append(strCountryId == null ? "" : strCountryId);
		sb.append(",");
		sb.append(getCountryNameEn() == null ? "" : getCountryNameEn());
		sb.append(",");
		sb.append(getCountryNameCn() == null ? "" : getCountryNameCn());
		sb.append(",");
		sb.append(getLevel() == null ? "" : getLevel());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCountry o) {
		return __country_id == null ? -1 : __country_id.compareTo(o.getCountryId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__country_id);
		hash = 97 * hash + Objects.hashCode(this.__country_name_en);
		hash = 97 * hash + Objects.hashCode(this.__country_name_cn);
		hash = 97 * hash + Objects.hashCode(this.__level);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCountry o = (BaseCountry)obj;
		if(!Objects.equals(this.__country_id, o.getCountryId())) return false;
		if(!Objects.equals(this.__country_name_en, o.getCountryNameEn())) return false;
		if(!Objects.equals(this.__country_name_cn, o.getCountryNameCn())) return false;
		if(!Objects.equals(this.__level, o.getLevel())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCountryId() != null) sb.append(__wrapNumber(count++, "countryId", getCountryId()));
		if(getCountryNameEn() != null) sb.append(__wrapString(count++, "countryNameEn", getCountryNameEn()));
		if(getCountryNameCn() != null) sb.append(__wrapString(count++, "countryNameCn", getCountryNameCn()));
		if(getLevel() != null) sb.append(__wrapNumber(count++, "level", getLevel()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("countryId")) != null) setCountryId(__getInt(val)); 
		if((val = values.get("countryNameEn")) != null) setCountryNameEn(__getString(val));
		if((val = values.get("countryNameCn")) != null) setCountryNameCn(__getString(val));
		if((val = values.get("level")) != null) setLevel(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
	}

	protected java.lang.Integer  __country_id ;
	protected java.lang.String  __country_name_en ;
	protected java.lang.String  __country_name_cn ;
	protected java.lang.Integer  __level ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __code ;
}
