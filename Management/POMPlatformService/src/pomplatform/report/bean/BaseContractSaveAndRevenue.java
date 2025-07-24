package pomplatform.report.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseContractSaveAndRevenue extends GenericBase implements BaseFactory<BaseContractSaveAndRevenue>, Comparable<BaseContractSaveAndRevenue>
{


	public static BaseContractSaveAndRevenue newInstance(){
		return new BaseContractSaveAndRevenue();
	}

	@Override
	public BaseContractSaveAndRevenue make(){
		BaseContractSaveAndRevenue b = new BaseContractSaveAndRevenue();
		return b;
	}

	public final static String CS_YEAR = "year" ;
	public final static String CS_MONTH = "month" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_CURRENT_REVENUE = "current_revenue" ;
	public final static String CS_ACTIVE = "active" ;

	public final static String ALL_CAPTIONS = "年份,月份,板块,本月营收,";

	public Integer getYear() {
		return this.__year;
	}

	public void setYear( Integer value ) {
		this.__year = value;
	}

	public Integer getMonth() {
		return this.__month;
	}

	public void setMonth( Integer value ) {
		this.__month = value;
	}

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getCurrentRevenue() {
		return this.__current_revenue;
	}

	public void setCurrentRevenue( java.math.BigDecimal value ) {
		this.__current_revenue = value;
	}

	public java.math.BigDecimal getActive() {
		return this.__active;
	}

	public void setActive( java.math.BigDecimal value ) {
		this.__active = value;
	}

	public void cloneCopy(BaseContractSaveAndRevenue __bean){
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setPlateId(getPlateId());
		__bean.setCurrentRevenue(getCurrentRevenue());
		__bean.setActive(getActive());
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
		sb.append(getCurrentRevenue() == null ? "" : getCurrentRevenue());
		sb.append(",");
		sb.append(getActive() == null ? "" : getActive());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContractSaveAndRevenue o) {
		return __year == null ? -1 : __year.compareTo(o.getYear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__current_revenue);
		hash = 97 * hash + Objects.hashCode(this.__active);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContractSaveAndRevenue o = (BaseContractSaveAndRevenue)obj;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__current_revenue, o.getCurrentRevenue())) return false;
		if(!Objects.equals(this.__active, o.getActive())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getCurrentRevenue() != null) sb.append(__wrapDecimal(count++, "currentRevenue", getCurrentRevenue()));
		if(getActive() != null) sb.append(__wrapDecimal(count++, "active", getActive()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getCurrentRevenue() != null) res.put("currentRevenue", getCurrentRevenue());
		if(getActive() != null) res.put("active", getActive());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val));
		if((val = values.get("month")) != null) setMonth(__getInt(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("currentRevenue")) != null) setCurrentRevenue(__getDecimal(val));
		if((val = values.get("active")) != null) setActive(__getDecimal(val));
	}

	protected Integer  __year ;
	protected Integer  __month ;
	protected Integer  __plate_id ;
	protected java.math.BigDecimal  __current_revenue ;
	protected java.math.BigDecimal  __active ;
}
