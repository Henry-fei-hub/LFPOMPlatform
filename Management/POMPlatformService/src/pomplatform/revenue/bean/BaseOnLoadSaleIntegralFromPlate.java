package pomplatform.revenue.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadSaleIntegralFromPlate extends GenericBase implements BaseFactory<BaseOnLoadSaleIntegralFromPlate>, Comparable<BaseOnLoadSaleIntegralFromPlate> 
{


	public static BaseOnLoadSaleIntegralFromPlate newInstance(){
		return new BaseOnLoadSaleIntegralFromPlate();
	}

	@Override
	public BaseOnLoadSaleIntegralFromPlate make(){
		BaseOnLoadSaleIntegralFromPlate b = new BaseOnLoadSaleIntegralFromPlate();
		return b;
	}

	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_CURRENT_REVENUE = "current_revenue" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_SALE_INTEGRAL = "sale_integral" ;

	public final static java.lang.String ALL_CAPTIONS = ",年份,月份,本月营收,,";

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.math.BigDecimal getCurrentRevenue() {
		return this.__current_revenue;
	}

	public void setCurrentRevenue( java.math.BigDecimal value ) {
		this.__current_revenue = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.math.BigDecimal getSaleIntegral() {
		return this.__sale_integral;
	}

	public void setSaleIntegral( java.math.BigDecimal value ) {
		this.__sale_integral = value;
	}

	public void cloneCopy(BaseOnLoadSaleIntegralFromPlate __bean){
		__bean.setBusinessName(getBusinessName());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setCurrentRevenue(getCurrentRevenue());
		__bean.setPercent(getPercent());
		__bean.setSaleIntegral(getSaleIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getCurrentRevenue() == null ? "" : getCurrentRevenue());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getSaleIntegral() == null ? "" : getSaleIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadSaleIntegralFromPlate o) {
		return __business_name == null ? -1 : __business_name.compareTo(o.getBusinessName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__sale_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadSaleIntegralFromPlate o = (BaseOnLoadSaleIntegralFromPlate)obj;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__current_revenue, o.getCurrentRevenue())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__sale_integral, o.getSaleIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getCurrentRevenue() != null) sb.append(__wrapDecimal(count++, "currentRevenue", getCurrentRevenue()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getSaleIntegral() != null) sb.append(__wrapDecimal(count++, "saleIntegral", getSaleIntegral()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getCurrentRevenue() != null) res.put("currentRevenue", getCurrentRevenue());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getSaleIntegral() != null) res.put("saleIntegral", getSaleIntegral());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("currentRevenue")) != null) setCurrentRevenue(__getDecimal(val));  
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("saleIntegral")) != null) setSaleIntegral(__getDecimal(val));  
	}

	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __current_revenue ;
	protected java.math.BigDecimal  __percent ;
	protected java.math.BigDecimal  __sale_integral ;
}
