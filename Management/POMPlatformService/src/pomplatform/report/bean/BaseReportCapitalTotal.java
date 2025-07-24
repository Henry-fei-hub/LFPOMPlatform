package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportCapitalTotal extends GenericBase implements BaseFactory<BaseReportCapitalTotal>, Comparable<BaseReportCapitalTotal> 
{


	public static BaseReportCapitalTotal newInstance(){
		return new BaseReportCapitalTotal();
	}

	@Override
	public BaseReportCapitalTotal make(){
		BaseReportCapitalTotal b = new BaseReportCapitalTotal();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_PLATE_JANUARY_REVENUE = "plate_january_revenue" ;
	public final static java.lang.String CS_PLATE_FEBRUARY_REVENUE = "plate_february_revenue" ;
	public final static java.lang.String CS_PLATE_MARCH_REVENUE = "plate_march_revenue" ;
	public final static java.lang.String CS_PLATE_APRIL_REVENUE = "plate_april_revenue" ;
	public final static java.lang.String CS_PLATE_MAY_REVENUE = "plate_may_revenue" ;
	public final static java.lang.String CS_PLATE_JUNE_REVENUE = "plate_june_revenue" ;
	public final static java.lang.String CS_PLATE_JULY_REVENUE = "plate_july_revenue" ;
	public final static java.lang.String CS_PLATE_AUGUST_REVENUE = "plate_august_revenue" ;
	public final static java.lang.String CS_PLATE_SEPTEMBER_REVENUE = "plate_september_revenue" ;
	public final static java.lang.String CS_PLATE_OCTOBER_REVENUE = "plate_october_revenue" ;
	public final static java.lang.String CS_PLATE_NOVEMBER_REVENUE = "plate_november_revenue" ;
	public final static java.lang.String CS_PLATE_DECEMBER_REVENUE = "plate_december_revenue" ;
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

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,项目组1月,部门1月,项目组2月,部门2月,项目组3月,部门3月,项目组4月,部门4月,项目组5月,部门5月,项目组6月,部门6月,项目组7月,部门7月,项目组8月,部门8月,项目组9月,部门9月,项目组10月,部门10月,项目组11月,部门11月,项目组12月,部门12月";

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

	public java.math.BigDecimal getPlateJanuaryRevenue() {
		return this.__plate_january_revenue;
	}

	public void setPlateJanuaryRevenue( java.math.BigDecimal value ) {
		this.__plate_january_revenue = value;
	}

	public java.math.BigDecimal getPlateFebruaryRevenue() {
		return this.__plate_february_revenue;
	}

	public void setPlateFebruaryRevenue( java.math.BigDecimal value ) {
		this.__plate_february_revenue = value;
	}

	public java.math.BigDecimal getPlateMarchRevenue() {
		return this.__plate_march_revenue;
	}

	public void setPlateMarchRevenue( java.math.BigDecimal value ) {
		this.__plate_march_revenue = value;
	}

	public java.math.BigDecimal getPlateAprilRevenue() {
		return this.__plate_april_revenue;
	}

	public void setPlateAprilRevenue( java.math.BigDecimal value ) {
		this.__plate_april_revenue = value;
	}

	public java.math.BigDecimal getPlateMayRevenue() {
		return this.__plate_may_revenue;
	}

	public void setPlateMayRevenue( java.math.BigDecimal value ) {
		this.__plate_may_revenue = value;
	}

	public java.math.BigDecimal getPlateJuneRevenue() {
		return this.__plate_june_revenue;
	}

	public void setPlateJuneRevenue( java.math.BigDecimal value ) {
		this.__plate_june_revenue = value;
	}

	public java.math.BigDecimal getPlateJulyRevenue() {
		return this.__plate_july_revenue;
	}

	public void setPlateJulyRevenue( java.math.BigDecimal value ) {
		this.__plate_july_revenue = value;
	}

	public java.math.BigDecimal getPlateAugustRevenue() {
		return this.__plate_august_revenue;
	}

	public void setPlateAugustRevenue( java.math.BigDecimal value ) {
		this.__plate_august_revenue = value;
	}

	public java.math.BigDecimal getPlateSeptemberRevenue() {
		return this.__plate_september_revenue;
	}

	public void setPlateSeptemberRevenue( java.math.BigDecimal value ) {
		this.__plate_september_revenue = value;
	}

	public java.math.BigDecimal getPlateOctoberRevenue() {
		return this.__plate_october_revenue;
	}

	public void setPlateOctoberRevenue( java.math.BigDecimal value ) {
		this.__plate_october_revenue = value;
	}

	public java.math.BigDecimal getPlateNovemberRevenue() {
		return this.__plate_november_revenue;
	}

	public void setPlateNovemberRevenue( java.math.BigDecimal value ) {
		this.__plate_november_revenue = value;
	}

	public java.math.BigDecimal getPlateDecemberRevenue() {
		return this.__plate_december_revenue;
	}

	public void setPlateDecemberRevenue( java.math.BigDecimal value ) {
		this.__plate_december_revenue = value;
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

	public void cloneCopy(BaseReportCapitalTotal __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setPlateJanuaryRevenue(getPlateJanuaryRevenue());
		__bean.setPlateFebruaryRevenue(getPlateFebruaryRevenue());
		__bean.setPlateMarchRevenue(getPlateMarchRevenue());
		__bean.setPlateAprilRevenue(getPlateAprilRevenue());
		__bean.setPlateMayRevenue(getPlateMayRevenue());
		__bean.setPlateJuneRevenue(getPlateJuneRevenue());
		__bean.setPlateJulyRevenue(getPlateJulyRevenue());
		__bean.setPlateAugustRevenue(getPlateAugustRevenue());
		__bean.setPlateSeptemberRevenue(getPlateSeptemberRevenue());
		__bean.setPlateOctoberRevenue(getPlateOctoberRevenue());
		__bean.setPlateNovemberRevenue(getPlateNovemberRevenue());
		__bean.setPlateDecemberRevenue(getPlateDecemberRevenue());
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
		sb.append(getPlateJanuaryRevenue() == null ? "" : getPlateJanuaryRevenue());
		sb.append(",");
		sb.append(getFebruaryRevenue() == null ? "" : getFebruaryRevenue());
		sb.append(",");
		sb.append(getPlateFebruaryRevenue() == null ? "" : getPlateFebruaryRevenue());
		sb.append(",");
		sb.append(getMarchRevenue() == null ? "" : getMarchRevenue());
		sb.append(",");
		sb.append(getPlateMarchRevenue() == null ? "" : getPlateMarchRevenue());
		sb.append(",");
		sb.append(getAprilRevenue() == null ? "" : getAprilRevenue());
		sb.append(",");
		sb.append(getPlateAprilRevenue() == null ? "" : getPlateAprilRevenue());
		sb.append(",");
		sb.append(getMayRevenue() == null ? "" : getMayRevenue());
		sb.append(",");
		sb.append(getPlateMayRevenue() == null ? "" : getPlateMayRevenue());
		sb.append(",");
		sb.append(getJuneRevenue() == null ? "" : getJuneRevenue());
		sb.append(",");
		sb.append(getPlateJuneRevenue() == null ? "" : getPlateJuneRevenue());
		sb.append(",");
		sb.append(getJulyRevenue() == null ? "" : getJulyRevenue());
		sb.append(",");
		sb.append(getPlateJulyRevenue() == null ? "" : getPlateJulyRevenue());
		sb.append(",");
		sb.append(getAugustRevenue() == null ? "" : getAugustRevenue());
		sb.append(",");
		sb.append(getPlateAugustRevenue() == null ? "" : getPlateAugustRevenue());
		sb.append(",");
		sb.append(getSeptemberRevenue() == null ? "" : getSeptemberRevenue());
		sb.append(",");
		sb.append(getPlateSeptemberRevenue() == null ? "" : getPlateSeptemberRevenue());
		sb.append(",");
		sb.append(getOctoberRevenue() == null ? "" : getOctoberRevenue());
		sb.append(",");
		sb.append(getPlateOctoberRevenue() == null ? "" : getPlateOctoberRevenue());
		sb.append(",");
		sb.append(getNovemberRevenue() == null ? "" : getNovemberRevenue());
		sb.append(",");
		sb.append(getPlateNovemberRevenue() == null ? "" : getPlateNovemberRevenue());
		sb.append(",");
		sb.append(getDecemberRevenue() == null ? "" : getDecemberRevenue());
		sb.append(",");
		sb.append(getPlateDecemberRevenue() == null ? "" : getPlateDecemberRevenue());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportCapitalTotal o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__plate_january_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_february_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_march_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_april_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_may_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_june_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_july_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_august_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_september_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_october_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_november_revenue);
		hash = 97 * hash + Objects.hashCode(this.__plate_december_revenue);
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportCapitalTotal o = (BaseReportCapitalTotal)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__plate_january_revenue, o.getPlateJanuaryRevenue())) return false;
		if(!Objects.equals(this.__plate_february_revenue, o.getPlateFebruaryRevenue())) return false;
		if(!Objects.equals(this.__plate_march_revenue, o.getPlateMarchRevenue())) return false;
		if(!Objects.equals(this.__plate_april_revenue, o.getPlateAprilRevenue())) return false;
		if(!Objects.equals(this.__plate_may_revenue, o.getPlateMayRevenue())) return false;
		if(!Objects.equals(this.__plate_june_revenue, o.getPlateJuneRevenue())) return false;
		if(!Objects.equals(this.__plate_july_revenue, o.getPlateJulyRevenue())) return false;
		if(!Objects.equals(this.__plate_august_revenue, o.getPlateAugustRevenue())) return false;
		if(!Objects.equals(this.__plate_september_revenue, o.getPlateSeptemberRevenue())) return false;
		if(!Objects.equals(this.__plate_october_revenue, o.getPlateOctoberRevenue())) return false;
		if(!Objects.equals(this.__plate_november_revenue, o.getPlateNovemberRevenue())) return false;
		if(!Objects.equals(this.__plate_december_revenue, o.getPlateDecemberRevenue())) return false;
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
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getPlateJanuaryRevenue() != null) sb.append(__wrapDecimal(count++, "plateJanuaryRevenue", getPlateJanuaryRevenue()));
		if(getPlateFebruaryRevenue() != null) sb.append(__wrapDecimal(count++, "plateFebruaryRevenue", getPlateFebruaryRevenue()));
		if(getPlateMarchRevenue() != null) sb.append(__wrapDecimal(count++, "plateMarchRevenue", getPlateMarchRevenue()));
		if(getPlateAprilRevenue() != null) sb.append(__wrapDecimal(count++, "plateAprilRevenue", getPlateAprilRevenue()));
		if(getPlateMayRevenue() != null) sb.append(__wrapDecimal(count++, "plateMayRevenue", getPlateMayRevenue()));
		if(getPlateJuneRevenue() != null) sb.append(__wrapDecimal(count++, "plateJuneRevenue", getPlateJuneRevenue()));
		if(getPlateJulyRevenue() != null) sb.append(__wrapDecimal(count++, "plateJulyRevenue", getPlateJulyRevenue()));
		if(getPlateAugustRevenue() != null) sb.append(__wrapDecimal(count++, "plateAugustRevenue", getPlateAugustRevenue()));
		if(getPlateSeptemberRevenue() != null) sb.append(__wrapDecimal(count++, "plateSeptemberRevenue", getPlateSeptemberRevenue()));
		if(getPlateOctoberRevenue() != null) sb.append(__wrapDecimal(count++, "plateOctoberRevenue", getPlateOctoberRevenue()));
		if(getPlateNovemberRevenue() != null) sb.append(__wrapDecimal(count++, "plateNovemberRevenue", getPlateNovemberRevenue()));
		if(getPlateDecemberRevenue() != null) sb.append(__wrapDecimal(count++, "plateDecemberRevenue", getPlateDecemberRevenue()));
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
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("plateJanuaryRevenue")) != null) setPlateJanuaryRevenue(__getDecimal(val));  
		if((val = values.get("plateFebruaryRevenue")) != null) setPlateFebruaryRevenue(__getDecimal(val));  
		if((val = values.get("plateMarchRevenue")) != null) setPlateMarchRevenue(__getDecimal(val));  
		if((val = values.get("plateAprilRevenue")) != null) setPlateAprilRevenue(__getDecimal(val));  
		if((val = values.get("plateMayRevenue")) != null) setPlateMayRevenue(__getDecimal(val));  
		if((val = values.get("plateJuneRevenue")) != null) setPlateJuneRevenue(__getDecimal(val));  
		if((val = values.get("plateJulyRevenue")) != null) setPlateJulyRevenue(__getDecimal(val));  
		if((val = values.get("plateAugustRevenue")) != null) setPlateAugustRevenue(__getDecimal(val));  
		if((val = values.get("plateSeptemberRevenue")) != null) setPlateSeptemberRevenue(__getDecimal(val));  
		if((val = values.get("plateOctoberRevenue")) != null) setPlateOctoberRevenue(__getDecimal(val));  
		if((val = values.get("plateNovemberRevenue")) != null) setPlateNovemberRevenue(__getDecimal(val));  
		if((val = values.get("plateDecemberRevenue")) != null) setPlateDecemberRevenue(__getDecimal(val));  
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
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __plate_january_revenue ;
	protected java.math.BigDecimal  __plate_february_revenue ;
	protected java.math.BigDecimal  __plate_march_revenue ;
	protected java.math.BigDecimal  __plate_april_revenue ;
	protected java.math.BigDecimal  __plate_may_revenue ;
	protected java.math.BigDecimal  __plate_june_revenue ;
	protected java.math.BigDecimal  __plate_july_revenue ;
	protected java.math.BigDecimal  __plate_august_revenue ;
	protected java.math.BigDecimal  __plate_september_revenue ;
	protected java.math.BigDecimal  __plate_october_revenue ;
	protected java.math.BigDecimal  __plate_november_revenue ;
	protected java.math.BigDecimal  __plate_december_revenue ;
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
}
