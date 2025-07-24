package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSupplierScoreRecord extends GenericBase implements BaseFactory<BaseSupplierScoreRecord>, Comparable<BaseSupplierScoreRecord> 
{


	public static BaseSupplierScoreRecord newInstance(){
		return new BaseSupplierScoreRecord();
	}

	@Override
	public BaseSupplierScoreRecord make(){
		BaseSupplierScoreRecord b = new BaseSupplierScoreRecord();
		return b;
	}

	public final static java.lang.String CS_SCORD_ID = "scord_id" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_SCORD = "scord" ;
	public final static java.lang.String CS_CODE = "code" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,名称,分数,编码";

	public java.lang.Integer getScordId() {
		return this.__scord_id;
	}

	public void setScordId( java.lang.Integer value ) {
		this.__scord_id = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.math.BigDecimal getScord() {
		return this.__scord;
	}

	public void setScord( java.math.BigDecimal value ) {
		this.__scord = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public void cloneCopy(BaseSupplierScoreRecord __bean){
		__bean.setScordId(getScordId());
		__bean.setName(getName());
		__bean.setScord(getScord());
		__bean.setCode(getCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getScordId() == null ? "" : getScordId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getScord() == null ? "" : getScord());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSupplierScoreRecord o) {
		return __scord_id == null ? -1 : __scord_id.compareTo(o.getScordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__scord_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__scord);
		hash = 97 * hash + Objects.hashCode(this.__code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSupplierScoreRecord o = (BaseSupplierScoreRecord)obj;
		if(!Objects.equals(this.__scord_id, o.getScordId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__scord, o.getScord())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getScordId() != null) sb.append(__wrapNumber(count++, "scordId", getScordId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getScord() != null) sb.append(__wrapDecimal(count++, "scord", getScord()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getScordId() != null) res.put("scordId", getScordId());
		if(getName() != null) res.put("name", getName());
		if(getScord() != null) res.put("scord", getScord());
		if(getCode() != null) res.put("code", getCode());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("scordId")) != null) setScordId(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("scord")) != null) setScord(__getDecimal(val));  
		if((val = values.get("code")) != null) setCode(__getString(val));
	}

	protected java.lang.Integer  __scord_id ;
	protected java.lang.String  __name ;
	protected java.math.BigDecimal  __scord ;
	protected java.lang.String  __code ;
}
