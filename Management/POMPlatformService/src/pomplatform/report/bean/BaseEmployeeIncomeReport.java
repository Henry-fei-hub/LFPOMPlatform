package pomplatform.report.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseEmployeeIncomeReport extends GenericBase implements BaseFactory<BaseEmployeeIncomeReport>, Comparable<BaseEmployeeIncomeReport>
{


	public static BaseEmployeeIncomeReport newInstance(){
		return new BaseEmployeeIncomeReport();
	}

	@Override
	public BaseEmployeeIncomeReport make(){
		BaseEmployeeIncomeReport b = new BaseEmployeeIncomeReport();
		return b;
	}

	public final static String CS_YEAR = "year" ;
	public final static String CS_MONTH = "month" ;
	public final static String CS_BUSINESS_TYPE_ID = "business_type_id" ;
	public final static String CS_INTEGRAL = "integral" ;

	public final static String ALL_CAPTIONS = ",,10绩效奖金),积分";

	public Double getYear() {
		return this.__year;
	}

	public void setYear( Double value ) {
		this.__year = value;
	}

	public Double getMonth() {
		return this.__month;
	}

	public void setMonth( Double value ) {
		this.__month = value;
	}

	public Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( Integer value ) {
		this.__business_type_id = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public void cloneCopy(BaseEmployeeIncomeReport __bean){
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setBusinessTypeId(getBusinessTypeId());
		__bean.setIntegral(getIntegral());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeIncomeReport o) {
		return __year == null ? -1 : __year.compareTo(o.getYear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeIncomeReport o = (BaseEmployeeIncomeReport)obj;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getBusinessTypeId() != null) res.put("businessTypeId", getBusinessTypeId());
		if(getIntegral() != null) res.put("integral", getIntegral());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("year")) != null) setYear(__getDouble(val));
		if((val = values.get("month")) != null) setMonth(__getDouble(val));
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val));
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));
	}

	protected Double  __year ;
	protected Double  __month ;
	protected Integer  __business_type_id ;
	protected java.math.BigDecimal  __integral ;
}
