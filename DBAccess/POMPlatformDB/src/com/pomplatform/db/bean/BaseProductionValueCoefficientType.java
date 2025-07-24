package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProductionValueCoefficientType extends GenericBase implements BaseFactory<BaseProductionValueCoefficientType>, Comparable<BaseProductionValueCoefficientType> 
{


	public static BaseProductionValueCoefficientType newInstance(){
		return new BaseProductionValueCoefficientType();
	}

	@Override
	public BaseProductionValueCoefficientType make(){
		BaseProductionValueCoefficientType b = new BaseProductionValueCoefficientType();
		return b;
	}

	public final static java.lang.String CS_PRODUCTION_VALUE_COEFFICIENT_TYPE_ID = "production_value_coefficient_type_id" ;
	public final static java.lang.String CS_COEFFICIENT_TYPE = "coefficient_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键id,产值类型";

	public java.lang.Integer getProductionValueCoefficientTypeId() {
		return this.__production_value_coefficient_type_id;
	}

	public void setProductionValueCoefficientTypeId( java.lang.Integer value ) {
		this.__production_value_coefficient_type_id = value;
	}

	public java.lang.String getCoefficientType() {
		return this.__coefficient_type;
	}

	public void setCoefficientType( java.lang.String value ) {
		this.__coefficient_type = value;
	}

	public void cloneCopy(BaseProductionValueCoefficientType __bean){
		__bean.setProductionValueCoefficientTypeId(getProductionValueCoefficientTypeId());
		__bean.setCoefficientType(getCoefficientType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProductionValueCoefficientTypeId() == null ? "" : getProductionValueCoefficientTypeId());
		sb.append(",");
		sb.append(getCoefficientType() == null ? "" : getCoefficientType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProductionValueCoefficientType o) {
		return __production_value_coefficient_type_id == null ? -1 : __production_value_coefficient_type_id.compareTo(o.getProductionValueCoefficientTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__production_value_coefficient_type_id);
		hash = 97 * hash + Objects.hashCode(this.__coefficient_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProductionValueCoefficientType o = (BaseProductionValueCoefficientType)obj;
		if(!Objects.equals(this.__production_value_coefficient_type_id, o.getProductionValueCoefficientTypeId())) return false;
		if(!Objects.equals(this.__coefficient_type, o.getCoefficientType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProductionValueCoefficientTypeId() != null) sb.append(__wrapNumber(count++, "productionValueCoefficientTypeId", getProductionValueCoefficientTypeId()));
		if(getCoefficientType() != null) sb.append(__wrapString(count++, "coefficientType", getCoefficientType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProductionValueCoefficientTypeId() != null) res.put("productionValueCoefficientTypeId", getProductionValueCoefficientTypeId());
		if(getCoefficientType() != null) res.put("coefficientType", getCoefficientType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("productionValueCoefficientTypeId")) != null) setProductionValueCoefficientTypeId(__getInt(val)); 
		if((val = values.get("coefficientType")) != null) setCoefficientType(__getString(val));
	}

	protected java.lang.Integer  __production_value_coefficient_type_id ;
	protected java.lang.String  __coefficient_type ;
}
