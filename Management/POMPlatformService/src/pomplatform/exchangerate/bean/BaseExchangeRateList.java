package pomplatform.exchangerate.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseExchangeRateList extends GenericBase implements BaseFactory<BaseExchangeRateList>, Comparable<BaseExchangeRateList> 
{


	public static BaseExchangeRateList newInstance(){
		return new BaseExchangeRateList();
	}

	@Override
	public BaseExchangeRateList make(){
		BaseExchangeRateList b = new BaseExchangeRateList();
		return b;
	}

	public final static java.lang.String CS_EXCHANGE_RATE_ID = "exchange_rate_id" ;
	public final static java.lang.String CS_CURRENCY_ID = "currency_id" ;
	public final static java.lang.String CS_EXCHANGE_RATE = "exchange_rate" ;
	public final static java.lang.String CS_EXCHANGE_DATE = "exchange_date" ;

	public final static java.lang.String ALL_CAPTIONS = "汇率表编码,货币类型,汇率,兑换日期";

	public java.lang.Integer getExchangeRateId() {
		return this.__exchange_rate_id;
	}

	public void setExchangeRateId( java.lang.Integer value ) {
		this.__exchange_rate_id = value;
	}

	public java.lang.Integer getCurrencyId() {
		return this.__currency_id;
	}

	public void setCurrencyId( java.lang.Integer value ) {
		this.__currency_id = value;
	}

	public java.math.BigDecimal getExchangeRate() {
		return this.__exchange_rate;
	}

	public void setExchangeRate( java.math.BigDecimal value ) {
		this.__exchange_rate = value;
	}

	public java.util.Date getExchangeDate() {
		return this.__exchange_date;
	}

	public void setExchangeDate( java.util.Date value ) {
		this.__exchange_date = value;
	}

	public void cloneCopy(BaseExchangeRateList __bean){
		__bean.setExchangeRateId(getExchangeRateId());
		__bean.setCurrencyId(getCurrencyId());
		__bean.setExchangeRate(getExchangeRate());
		__bean.setExchangeDate(getExchangeDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getExchangeRateId() == null ? "" : getExchangeRateId());
		sb.append(",");
		String strCurrencyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_40", String.valueOf(getCurrencyId()));
		sb.append(strCurrencyId == null ? "" : strCurrencyId);
		sb.append(",");
		sb.append(getExchangeRate() == null ? "" : getExchangeRate());
		sb.append(",");
		sb.append(getExchangeDate() == null ? "" : sdf.format(getExchangeDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseExchangeRateList o) {
		return __exchange_rate_id == null ? -1 : __exchange_rate_id.compareTo(o.getExchangeRateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate_id);
		hash = 97 * hash + Objects.hashCode(this.__currency_id);
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate);
		hash = 97 * hash + Objects.hashCode(this.__exchange_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseExchangeRateList o = (BaseExchangeRateList)obj;
		if(!Objects.equals(this.__exchange_rate_id, o.getExchangeRateId())) return false;
		if(!Objects.equals(this.__currency_id, o.getCurrencyId())) return false;
		if(!Objects.equals(this.__exchange_rate, o.getExchangeRate())) return false;
		if(!Objects.equals(this.__exchange_date, o.getExchangeDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getExchangeRateId() != null) sb.append(__wrapNumber(count++, "exchangeRateId", getExchangeRateId()));
		if(getCurrencyId() != null) sb.append(__wrapNumber(count++, "currencyId", getCurrencyId()));
		if(getExchangeRate() != null) sb.append(__wrapDecimal(count++, "exchangeRate", getExchangeRate()));
		if(getExchangeDate() != null) sb.append(__wrapDate(count++, "exchangeDate", getExchangeDate()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getExchangeRateId() != null) res.put("exchangeRateId", getExchangeRateId());
		if(getCurrencyId() != null) res.put("currencyId", getCurrencyId());
		if(getExchangeRate() != null) res.put("exchangeRate", getExchangeRate());
		if(getExchangeDate() != null) res.put("exchangeDate", getExchangeDate());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("exchangeRateId")) != null) setExchangeRateId(__getInt(val)); 
		if((val = values.get("currencyId")) != null) setCurrencyId(__getInt(val)); 
		if((val = values.get("exchangeRate")) != null) setExchangeRate(__getDecimal(val));  
		if((val = values.get("exchangeDate")) != null) setExchangeDate(__getDate(val)); 
	}

	protected java.lang.Integer  __exchange_rate_id ;
	protected java.lang.Integer  __currency_id ;
	protected java.math.BigDecimal  __exchange_rate ;
	protected java.util.Date  __exchange_date ;
}
