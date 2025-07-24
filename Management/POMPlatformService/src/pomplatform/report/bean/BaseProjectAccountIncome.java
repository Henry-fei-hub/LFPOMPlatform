package pomplatform.report.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseProjectAccountIncome extends GenericBase implements BaseFactory<BaseProjectAccountIncome>, Comparable<BaseProjectAccountIncome>
{


	public static BaseProjectAccountIncome newInstance(){
		return new BaseProjectAccountIncome();
	}

	@Override
	public BaseProjectAccountIncome make(){
		BaseProjectAccountIncome b = new BaseProjectAccountIncome();
		return b;
	}

	public final static String CS_YEAR = "year" ;
	public final static String CS_MONTH = "month" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_SUM = "sum" ;

	public final static String ALL_CAPTIONS = ",,板块,";

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

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getSum() {
		return this.__sum;
	}

	public void setSum( java.math.BigDecimal value ) {
		this.__sum = value;
	}

	public void cloneCopy(BaseProjectAccountIncome __bean){
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setPlateId(getPlateId());
		__bean.setSum(getSum());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getSum() == null ? "" : getSum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectAccountIncome o) {
		return __year == null ? -1 : __year.compareTo(o.getYear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectAccountIncome o = (BaseProjectAccountIncome)obj;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__sum, o.getSum())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSum() != null) sb.append(__wrapDecimal(count++, "sum", getSum()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getSum() != null) res.put("sum", getSum());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("year")) != null) setYear(__getDouble(val));
		if((val = values.get("month")) != null) setMonth(__getDouble(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("sum")) != null) setSum(__getDecimal(val));
	}

	protected Double  __year ;
	protected Double  __month ;
	protected Integer  __plate_id ;
	protected java.math.BigDecimal  __sum ;
}
