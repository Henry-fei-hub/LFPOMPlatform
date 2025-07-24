package pomplatform.exchangerate.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionExchangeRateList extends GenericCondition{

	public ConditionExchangeRateList(){
		setParameterCount(2);
	}

	public java.lang.Integer getCurrencyId() {
		return this.__currency_id;
	}

	public void setCurrencyId( java.lang.Integer value ) {
		this.__currency_id = value;
	}

	public java.util.Date getExchangeDate() {
		return this.__exchange_date;
	}

	public void setExchangeDate( java.util.Date value ) {
		this.__exchange_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCurrencyId() != null) sb.append(__wrapNumber(1, "currencyId", getCurrencyId()));
		if(getExchangeDate() != null) sb.append(__wrapDate(1, "exchangeDate", getExchangeDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("currencyId")) != null) setCurrencyId(__getInt(val)); 
		if((val = values.get("exchangeDate")) != null) setExchangeDate(__getDate(val)); 
	}

	private java.lang.Integer __currency_id = null;
	private java.util.Date __exchange_date = null;
}

