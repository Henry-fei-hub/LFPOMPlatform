package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseUseCarPrice extends GenericBase implements BaseFactory<BaseUseCarPrice>, Comparable<BaseUseCarPrice> 
{


	public static BaseUseCarPrice newInstance(){
		return new BaseUseCarPrice();
	}

	@Override
	public BaseUseCarPrice make(){
		BaseUseCarPrice b = new BaseUseCarPrice();
		return b;
	}

	public final static java.lang.String CS_USE_CAR_PRICE_ID = "use_car_price_id" ;
	public final static java.lang.String CS_FROM_AREA = "from_area" ;
	public final static java.lang.String CS_TO_AREA = "to_area" ;
	public final static java.lang.String CS_PRICE = "price" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_CAR_TYPE = "car_type" ;

	public final static java.lang.String ALL_CAPTIONS = "用车费用价格表编码,出发地,目的地,价格,父级编码,车类型 （1 小车  2 商务大车）";

	public java.lang.Integer getUseCarPriceId() {
		return this.__use_car_price_id;
	}

	public void setUseCarPriceId( java.lang.Integer value ) {
		this.__use_car_price_id = value;
	}

	public java.lang.String getFromArea() {
		return this.__from_area;
	}

	public void setFromArea( java.lang.String value ) {
		this.__from_area = value;
	}

	public java.lang.String getToArea() {
		return this.__to_area;
	}

	public void setToArea( java.lang.String value ) {
		this.__to_area = value;
	}

	public java.math.BigDecimal getPrice() {
		return this.__price;
	}

	public void setPrice( java.math.BigDecimal value ) {
		this.__price = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getCarType() {
		return this.__car_type;
	}

	public void setCarType( java.lang.Integer value ) {
		this.__car_type = value;
	}

	public void cloneCopy(BaseUseCarPrice __bean){
		__bean.setUseCarPriceId(getUseCarPriceId());
		__bean.setFromArea(getFromArea());
		__bean.setToArea(getToArea());
		__bean.setPrice(getPrice());
		__bean.setParentId(getParentId());
		__bean.setCarType(getCarType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getUseCarPriceId() == null ? "" : getUseCarPriceId());
		sb.append(",");
		sb.append(getFromArea() == null ? "" : getFromArea());
		sb.append(",");
		sb.append(getToArea() == null ? "" : getToArea());
		sb.append(",");
		sb.append(getPrice() == null ? "" : getPrice());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getCarType() == null ? "" : getCarType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseUseCarPrice o) {
		return __use_car_price_id == null ? -1 : __use_car_price_id.compareTo(o.getUseCarPriceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__use_car_price_id);
		hash = 97 * hash + Objects.hashCode(this.__from_area);
		hash = 97 * hash + Objects.hashCode(this.__to_area);
		hash = 97 * hash + Objects.hashCode(this.__price);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__car_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseUseCarPrice o = (BaseUseCarPrice)obj;
		if(!Objects.equals(this.__use_car_price_id, o.getUseCarPriceId())) return false;
		if(!Objects.equals(this.__from_area, o.getFromArea())) return false;
		if(!Objects.equals(this.__to_area, o.getToArea())) return false;
		if(!Objects.equals(this.__price, o.getPrice())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__car_type, o.getCarType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getUseCarPriceId() != null) sb.append(__wrapNumber(count++, "useCarPriceId", getUseCarPriceId()));
		if(getFromArea() != null) sb.append(__wrapString(count++, "fromArea", getFromArea()));
		if(getToArea() != null) sb.append(__wrapString(count++, "toArea", getToArea()));
		if(getPrice() != null) sb.append(__wrapDecimal(count++, "price", getPrice()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getCarType() != null) sb.append(__wrapNumber(count++, "carType", getCarType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("useCarPriceId")) != null) setUseCarPriceId(__getInt(val)); 
		if((val = values.get("fromArea")) != null) setFromArea(__getString(val));
		if((val = values.get("toArea")) != null) setToArea(__getString(val));
		if((val = values.get("price")) != null) setPrice(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("carType")) != null) setCarType(__getInt(val)); 
	}

	protected java.lang.Integer  __use_car_price_id ;
	protected java.lang.String  __from_area ;
	protected java.lang.String  __to_area ;
	protected java.math.BigDecimal  __price ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __car_type ;
}
