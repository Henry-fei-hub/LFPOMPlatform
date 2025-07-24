package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCarTypePrice extends GenericBase implements BaseFactory<BaseCarTypePrice>, Comparable<BaseCarTypePrice> 
{


	public static BaseCarTypePrice newInstance(){
		return new BaseCarTypePrice();
	}

	@Override
	public BaseCarTypePrice make(){
		BaseCarTypePrice b = new BaseCarTypePrice();
		return b;
	}

	public final static java.lang.String CS_CAR_TYPE_PRICE_ID = "car_type_price_id" ;
	public final static java.lang.String CS_FROM_AREA = "from_area" ;
	public final static java.lang.String CS_TO_AREA = "to_area" ;
	public final static java.lang.String CS_PRICE = "price" ;
	public final static java.lang.String CS_CAR_TYPE = "car_type" ;
	public final static java.lang.String CS_USE_CAR_PRICE_ID = "use_car_price_id" ;

	public final static java.lang.String ALL_CAPTIONS = "用车价格表id,出发地,目的地,价格,用车类型（1小车  2大车）,区域表id（use_car_prices）";

	public java.lang.Integer getCarTypePriceId() {
		return this.__car_type_price_id;
	}

	public void setCarTypePriceId( java.lang.Integer value ) {
		this.__car_type_price_id = value;
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

	public java.lang.Integer getCarType() {
		return this.__car_type;
	}

	public void setCarType( java.lang.Integer value ) {
		this.__car_type = value;
	}

	public java.lang.Integer getUseCarPriceId() {
		return this.__use_car_price_id;
	}

	public void setUseCarPriceId( java.lang.Integer value ) {
		this.__use_car_price_id = value;
	}

	public void cloneCopy(BaseCarTypePrice __bean){
		__bean.setCarTypePriceId(getCarTypePriceId());
		__bean.setFromArea(getFromArea());
		__bean.setToArea(getToArea());
		__bean.setPrice(getPrice());
		__bean.setCarType(getCarType());
		__bean.setUseCarPriceId(getUseCarPriceId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCarTypePriceId() == null ? "" : getCarTypePriceId());
		sb.append(",");
		sb.append(getFromArea() == null ? "" : getFromArea());
		sb.append(",");
		sb.append(getToArea() == null ? "" : getToArea());
		sb.append(",");
		sb.append(getPrice() == null ? "" : getPrice());
		sb.append(",");
		sb.append(getCarType() == null ? "" : getCarType());
		sb.append(",");
		sb.append(getUseCarPriceId() == null ? "" : getUseCarPriceId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCarTypePrice o) {
		return __car_type_price_id == null ? -1 : __car_type_price_id.compareTo(o.getCarTypePriceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__car_type_price_id);
		hash = 97 * hash + Objects.hashCode(this.__from_area);
		hash = 97 * hash + Objects.hashCode(this.__to_area);
		hash = 97 * hash + Objects.hashCode(this.__price);
		hash = 97 * hash + Objects.hashCode(this.__car_type);
		hash = 97 * hash + Objects.hashCode(this.__use_car_price_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCarTypePrice o = (BaseCarTypePrice)obj;
		if(!Objects.equals(this.__car_type_price_id, o.getCarTypePriceId())) return false;
		if(!Objects.equals(this.__from_area, o.getFromArea())) return false;
		if(!Objects.equals(this.__to_area, o.getToArea())) return false;
		if(!Objects.equals(this.__price, o.getPrice())) return false;
		if(!Objects.equals(this.__car_type, o.getCarType())) return false;
		if(!Objects.equals(this.__use_car_price_id, o.getUseCarPriceId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCarTypePriceId() != null) sb.append(__wrapNumber(count++, "carTypePriceId", getCarTypePriceId()));
		if(getFromArea() != null) sb.append(__wrapString(count++, "fromArea", getFromArea()));
		if(getToArea() != null) sb.append(__wrapString(count++, "toArea", getToArea()));
		if(getPrice() != null) sb.append(__wrapDecimal(count++, "price", getPrice()));
		if(getCarType() != null) sb.append(__wrapNumber(count++, "carType", getCarType()));
		if(getUseCarPriceId() != null) sb.append(__wrapNumber(count++, "useCarPriceId", getUseCarPriceId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("carTypePriceId")) != null) setCarTypePriceId(__getInt(val)); 
		if((val = values.get("fromArea")) != null) setFromArea(__getString(val));
		if((val = values.get("toArea")) != null) setToArea(__getString(val));
		if((val = values.get("price")) != null) setPrice(__getDecimal(val));  
		if((val = values.get("carType")) != null) setCarType(__getInt(val)); 
		if((val = values.get("useCarPriceId")) != null) setUseCarPriceId(__getInt(val)); 
	}

	protected java.lang.Integer  __car_type_price_id ;
	protected java.lang.String  __from_area ;
	protected java.lang.String  __to_area ;
	protected java.math.BigDecimal  __price ;
	protected java.lang.Integer  __car_type ;
	protected java.lang.Integer  __use_car_price_id ;
}
