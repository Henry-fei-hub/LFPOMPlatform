package pomplatform.usecarprices.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetUseCarPrice extends GenericCondition{

	public ConditionGetUseCarPrice(){
		setParameterCount(5);
	}

	public java.lang.Integer getUseCarPriceId() {
		return this.__use_car_price_id;
	}

	public void setUseCarPriceId( java.lang.Integer value ) {
		this.__use_car_price_id = value;
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

	public java.lang.String getToArea() {
		return this.__to_area == null ? null : (this.__to_area.indexOf("%") >= 0 ? this.__to_area : "%"+this.__to_area+"%");
	}

	public void setToArea( java.lang.String value ) {
		this.__to_area = value;
	}

	public java.lang.String getFromArea() {
		return this.__from_area == null ? null : (this.__from_area.indexOf("%") >= 0 ? this.__from_area : "%"+this.__from_area+"%");
	}

	public void setFromArea( java.lang.String value ) {
		this.__from_area = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getUseCarPriceId() != null) sb.append(__wrapNumber(1, "useCarPriceId", getUseCarPriceId()));
		if(getPrice() != null) sb.append(__wrapNumber(1, "price", getPrice()));
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		if(getToArea() != null) sb.append(__wrapString(1, "toArea", getToArea()));
		if(getFromArea() != null) sb.append(__wrapString(1, "fromArea", getFromArea()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("useCarPriceId")) != null) setUseCarPriceId(__getInt(val)); 
		if((val = values.get("price")) != null) setPrice(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("toArea")) != null) setToArea(__getString(val));
		if((val = values.get("fromArea")) != null) setFromArea(__getString(val));
	}

	private java.lang.Integer __use_car_price_id = null;
	private java.math.BigDecimal __price = null;
	private java.lang.Integer __parent_id = null;
	private java.lang.String __to_area = null;
	private java.lang.String __from_area = null;
}

