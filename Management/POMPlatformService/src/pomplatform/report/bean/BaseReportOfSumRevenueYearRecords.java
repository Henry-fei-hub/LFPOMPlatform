package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOfSumRevenueYearRecords extends GenericBase implements BaseFactory<BaseReportOfSumRevenueYearRecords>, Comparable<BaseReportOfSumRevenueYearRecords> 
{


	public static BaseReportOfSumRevenueYearRecords newInstance(){
		return new BaseReportOfSumRevenueYearRecords();
	}

	@Override
	public BaseReportOfSumRevenueYearRecords make(){
		BaseReportOfSumRevenueYearRecords b = new BaseReportOfSumRevenueYearRecords();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_JANUARY_REVENUE = "january_revenue" ;
	public final static java.lang.String CS_FEBRUARY_REVENUE = "february_revenue" ;
	public final static java.lang.String CS_MARCH_REVENUE = "march_revenue" ;
	public final static java.lang.String CS_APRIL_REVENUE = "april_revenue" ;
	public final static java.lang.String CS_MAY_REVENUE = "may_revenue" ;
	public final static java.lang.String CS_JUNE_REVENUE = "june_revenue" ;
	public final static java.lang.String CS_JULY_REVENUE = "july_revenue" ;
	public final static java.lang.String CS_AUGUST_REVENUE = "august_revenue" ;
	public final static java.lang.String CS_SEPTEMBER_REVENUE = "september_revenue" ;
	public final static java.lang.String CS_OCTOBER_REVENUE = "october_revenue" ;
	public final static java.lang.String CS_NOVEMBER_REVENUE = "november_revenue" ;
	public final static java.lang.String CS_DECEMBER_REVENUE = "december_revenue" ;
	public final static java.lang.String CS_TOTAL = "total" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,1月,2月,3月,4月,5月,6月,7月,8月,9月,10月,11月,12月,合计";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.math.BigDecimal getJanuaryRevenue() {
		return this.__january_revenue;
	}

	public void setJanuaryRevenue( java.math.BigDecimal value ) {
		this.__january_revenue = value;
	}

	public java.math.BigDecimal getFebruaryRevenue() {
		return this.__february_revenue;
	}

	public void setFebruaryRevenue( java.math.BigDecimal value ) {
		this.__february_revenue = value;
	}

	public java.math.BigDecimal getMarchRevenue() {
		return this.__march_revenue;
	}

	public void setMarchRevenue( java.math.BigDecimal value ) {
		this.__march_revenue = value;
	}

	public java.math.BigDecimal getAprilRevenue() {
		return this.__april_revenue;
	}

	public void setAprilRevenue( java.math.BigDecimal value ) {
		this.__april_revenue = value;
	}

	public java.math.BigDecimal getMayRevenue() {
		return this.__may_revenue;
	}

	public void setMayRevenue( java.math.BigDecimal value ) {
		this.__may_revenue = value;
	}

	public java.math.BigDecimal getJuneRevenue() {
		return this.__june_revenue;
	}

	public void setJuneRevenue( java.math.BigDecimal value ) {
		this.__june_revenue = value;
	}

	public java.math.BigDecimal getJulyRevenue() {
		return this.__july_revenue;
	}

	public void setJulyRevenue( java.math.BigDecimal value ) {
		this.__july_revenue = value;
	}

	public java.math.BigDecimal getAugustRevenue() {
		return this.__august_revenue;
	}

	public void setAugustRevenue( java.math.BigDecimal value ) {
		this.__august_revenue = value;
	}

	public java.math.BigDecimal getSeptemberRevenue() {
		return this.__september_revenue;
	}

	public void setSeptemberRevenue( java.math.BigDecimal value ) {
		this.__september_revenue = value;
	}

	public java.math.BigDecimal getOctoberRevenue() {
		return this.__october_revenue;
	}

	public void setOctoberRevenue( java.math.BigDecimal value ) {
		this.__october_revenue = value;
	}

	public java.math.BigDecimal getNovemberRevenue() {
		return this.__november_revenue;
	}

	public void setNovemberRevenue( java.math.BigDecimal value ) {
		this.__november_revenue = value;
	}

	public java.math.BigDecimal getDecemberRevenue() {
		return this.__december_revenue;
	}

	public void setDecemberRevenue( java.math.BigDecimal value ) {
		this.__december_revenue = value;
	}

	public java.math.BigDecimal getTotal() {
		return this.__total;
	}

	public void setTotal( java.math.BigDecimal value ) {
		this.__total = value;
	}

	public void cloneCopy(BaseReportOfSumRevenueYearRecords __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setJanuaryRevenue(getJanuaryRevenue());
		__bean.setFebruaryRevenue(getFebruaryRevenue());
		__bean.setMarchRevenue(getMarchRevenue());
		__bean.setAprilRevenue(getAprilRevenue());
		__bean.setMayRevenue(getMayRevenue());
		__bean.setJuneRevenue(getJuneRevenue());
		__bean.setJulyRevenue(getJulyRevenue());
		__bean.setAugustRevenue(getAugustRevenue());
		__bean.setSeptemberRevenue(getSeptemberRevenue());
		__bean.setOctoberRevenue(getOctoberRevenue());
		__bean.setNovemberRevenue(getNovemberRevenue());
		__bean.setDecemberRevenue(getDecemberRevenue());
		__bean.setTotal(getTotal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getJanuaryRevenue() == null ? "" : getJanuaryRevenue());
		sb.append(",");
		sb.append(getFebruaryRevenue() == null ? "" : getFebruaryRevenue());
		sb.append(",");
		sb.append(getMarchRevenue() == null ? "" : getMarchRevenue());
		sb.append(",");
		sb.append(getAprilRevenue() == null ? "" : getAprilRevenue());
		sb.append(",");
		sb.append(getMayRevenue() == null ? "" : getMayRevenue());
		sb.append(",");
		sb.append(getJuneRevenue() == null ? "" : getJuneRevenue());
		sb.append(",");
		sb.append(getJulyRevenue() == null ? "" : getJulyRevenue());
		sb.append(",");
		sb.append(getAugustRevenue() == null ? "" : getAugustRevenue());
		sb.append(",");
		sb.append(getSeptemberRevenue() == null ? "" : getSeptemberRevenue());
		sb.append(",");
		sb.append(getOctoberRevenue() == null ? "" : getOctoberRevenue());
		sb.append(",");
		sb.append(getNovemberRevenue() == null ? "" : getNovemberRevenue());
		sb.append(",");
		sb.append(getDecemberRevenue() == null ? "" : getDecemberRevenue());
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOfSumRevenueYearRecords o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__january_revenue);
		hash = 97 * hash + Objects.hashCode(this.__february_revenue);
		hash = 97 * hash + Objects.hashCode(this.__march_revenue);
		hash = 97 * hash + Objects.hashCode(this.__april_revenue);
		hash = 97 * hash + Objects.hashCode(this.__may_revenue);
		hash = 97 * hash + Objects.hashCode(this.__june_revenue);
		hash = 97 * hash + Objects.hashCode(this.__july_revenue);
		hash = 97 * hash + Objects.hashCode(this.__august_revenue);
		hash = 97 * hash + Objects.hashCode(this.__september_revenue);
		hash = 97 * hash + Objects.hashCode(this.__october_revenue);
		hash = 97 * hash + Objects.hashCode(this.__november_revenue);
		hash = 97 * hash + Objects.hashCode(this.__december_revenue);
		hash = 97 * hash + Objects.hashCode(this.__total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOfSumRevenueYearRecords o = (BaseReportOfSumRevenueYearRecords)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__january_revenue, o.getJanuaryRevenue())) return false;
		if(!Objects.equals(this.__february_revenue, o.getFebruaryRevenue())) return false;
		if(!Objects.equals(this.__march_revenue, o.getMarchRevenue())) return false;
		if(!Objects.equals(this.__april_revenue, o.getAprilRevenue())) return false;
		if(!Objects.equals(this.__may_revenue, o.getMayRevenue())) return false;
		if(!Objects.equals(this.__june_revenue, o.getJuneRevenue())) return false;
		if(!Objects.equals(this.__july_revenue, o.getJulyRevenue())) return false;
		if(!Objects.equals(this.__august_revenue, o.getAugustRevenue())) return false;
		if(!Objects.equals(this.__september_revenue, o.getSeptemberRevenue())) return false;
		if(!Objects.equals(this.__october_revenue, o.getOctoberRevenue())) return false;
		if(!Objects.equals(this.__november_revenue, o.getNovemberRevenue())) return false;
		if(!Objects.equals(this.__december_revenue, o.getDecemberRevenue())) return false;
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getJanuaryRevenue() != null) sb.append(__wrapDecimal(count++, "januaryRevenue", getJanuaryRevenue()));
		if(getFebruaryRevenue() != null) sb.append(__wrapDecimal(count++, "februaryRevenue", getFebruaryRevenue()));
		if(getMarchRevenue() != null) sb.append(__wrapDecimal(count++, "marchRevenue", getMarchRevenue()));
		if(getAprilRevenue() != null) sb.append(__wrapDecimal(count++, "aprilRevenue", getAprilRevenue()));
		if(getMayRevenue() != null) sb.append(__wrapDecimal(count++, "mayRevenue", getMayRevenue()));
		if(getJuneRevenue() != null) sb.append(__wrapDecimal(count++, "juneRevenue", getJuneRevenue()));
		if(getJulyRevenue() != null) sb.append(__wrapDecimal(count++, "julyRevenue", getJulyRevenue()));
		if(getAugustRevenue() != null) sb.append(__wrapDecimal(count++, "augustRevenue", getAugustRevenue()));
		if(getSeptemberRevenue() != null) sb.append(__wrapDecimal(count++, "septemberRevenue", getSeptemberRevenue()));
		if(getOctoberRevenue() != null) sb.append(__wrapDecimal(count++, "octoberRevenue", getOctoberRevenue()));
		if(getNovemberRevenue() != null) sb.append(__wrapDecimal(count++, "novemberRevenue", getNovemberRevenue()));
		if(getDecemberRevenue() != null) sb.append(__wrapDecimal(count++, "decemberRevenue", getDecemberRevenue()));
		if(getTotal() != null) sb.append(__wrapDecimal(count++, "total", getTotal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("januaryRevenue")) != null) setJanuaryRevenue(__getDecimal(val));  
		if((val = values.get("februaryRevenue")) != null) setFebruaryRevenue(__getDecimal(val));  
		if((val = values.get("marchRevenue")) != null) setMarchRevenue(__getDecimal(val));  
		if((val = values.get("aprilRevenue")) != null) setAprilRevenue(__getDecimal(val));  
		if((val = values.get("mayRevenue")) != null) setMayRevenue(__getDecimal(val));  
		if((val = values.get("juneRevenue")) != null) setJuneRevenue(__getDecimal(val));  
		if((val = values.get("julyRevenue")) != null) setJulyRevenue(__getDecimal(val));  
		if((val = values.get("augustRevenue")) != null) setAugustRevenue(__getDecimal(val));  
		if((val = values.get("septemberRevenue")) != null) setSeptemberRevenue(__getDecimal(val));  
		if((val = values.get("octoberRevenue")) != null) setOctoberRevenue(__getDecimal(val));  
		if((val = values.get("novemberRevenue")) != null) setNovemberRevenue(__getDecimal(val));  
		if((val = values.get("decemberRevenue")) != null) setDecemberRevenue(__getDecimal(val));  
		if((val = values.get("total")) != null) setTotal(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __january_revenue ;
	protected java.math.BigDecimal  __february_revenue ;
	protected java.math.BigDecimal  __march_revenue ;
	protected java.math.BigDecimal  __april_revenue ;
	protected java.math.BigDecimal  __may_revenue ;
	protected java.math.BigDecimal  __june_revenue ;
	protected java.math.BigDecimal  __july_revenue ;
	protected java.math.BigDecimal  __august_revenue ;
	protected java.math.BigDecimal  __september_revenue ;
	protected java.math.BigDecimal  __october_revenue ;
	protected java.math.BigDecimal  __november_revenue ;
	protected java.math.BigDecimal  __december_revenue ;
	protected java.math.BigDecimal  __total ;
}
