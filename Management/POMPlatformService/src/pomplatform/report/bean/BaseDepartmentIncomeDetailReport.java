package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseDepartmentIncomeDetailReport extends GenericBase implements BaseFactory<BaseDepartmentIncomeDetailReport>, Comparable<BaseDepartmentIncomeDetailReport> 
{


	public static BaseDepartmentIncomeDetailReport newInstance(){
		return new BaseDepartmentIncomeDetailReport();
	}

	@Override
	public BaseDepartmentIncomeDetailReport make(){
		BaseDepartmentIncomeDetailReport b = new BaseDepartmentIncomeDetailReport();
		return b;
	}

	public final static java.lang.String CS_DETAILS = "details" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_JANUARY = "january" ;
	public final static java.lang.String CS_FEBRUARY = "february" ;
	public final static java.lang.String CS_MARCH = "march" ;
	public final static java.lang.String CS_APRIL = "april" ;
	public final static java.lang.String CS_MAY = "may" ;
	public final static java.lang.String CS_JUNE = "june" ;
	public final static java.lang.String CS_JULY = "july" ;
	public final static java.lang.String CS_AUGUST = "august" ;
	public final static java.lang.String CS_SEPTEMBER = "september" ;
	public final static java.lang.String CS_OCTOBER = "october" ;
	public final static java.lang.String CS_NOVEMBER = "november" ;
	public final static java.lang.String CS_DECEMBER = "december" ;

	public final static java.lang.String ALL_CAPTIONS = "详情,部门,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月";

	public java.lang.String getDetails() {
		return this.__details;
	}

	public void setDetails( java.lang.String value ) {
		this.__details = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getJanuary() {
		return this.__january;
	}

	public void setJanuary( java.math.BigDecimal value ) {
		this.__january = value;
	}

	public java.math.BigDecimal getFebruary() {
		return this.__february;
	}

	public void setFebruary( java.math.BigDecimal value ) {
		this.__february = value;
	}

	public java.math.BigDecimal getMarch() {
		return this.__march;
	}

	public void setMarch( java.math.BigDecimal value ) {
		this.__march = value;
	}

	public java.math.BigDecimal getApril() {
		return this.__april;
	}

	public void setApril( java.math.BigDecimal value ) {
		this.__april = value;
	}

	public java.math.BigDecimal getMay() {
		return this.__may;
	}

	public void setMay( java.math.BigDecimal value ) {
		this.__may = value;
	}

	public java.math.BigDecimal getJune() {
		return this.__june;
	}

	public void setJune( java.math.BigDecimal value ) {
		this.__june = value;
	}

	public java.math.BigDecimal getJuly() {
		return this.__july;
	}

	public void setJuly( java.math.BigDecimal value ) {
		this.__july = value;
	}

	public java.math.BigDecimal getAugust() {
		return this.__august;
	}

	public void setAugust( java.math.BigDecimal value ) {
		this.__august = value;
	}

	public java.math.BigDecimal getSeptember() {
		return this.__september;
	}

	public void setSeptember( java.math.BigDecimal value ) {
		this.__september = value;
	}

	public java.math.BigDecimal getOctober() {
		return this.__october;
	}

	public void setOctober( java.math.BigDecimal value ) {
		this.__october = value;
	}

	public java.math.BigDecimal getNovember() {
		return this.__november;
	}

	public void setNovember( java.math.BigDecimal value ) {
		this.__november = value;
	}

	public java.math.BigDecimal getDecember() {
		return this.__december;
	}

	public void setDecember( java.math.BigDecimal value ) {
		this.__december = value;
	}

	public void cloneCopy(BaseDepartmentIncomeDetailReport __bean){
		__bean.setDetails(getDetails());
		__bean.setPlateId(getPlateId());
		__bean.setJanuary(getJanuary());
		__bean.setFebruary(getFebruary());
		__bean.setMarch(getMarch());
		__bean.setApril(getApril());
		__bean.setMay(getMay());
		__bean.setJune(getJune());
		__bean.setJuly(getJuly());
		__bean.setAugust(getAugust());
		__bean.setSeptember(getSeptember());
		__bean.setOctober(getOctober());
		__bean.setNovember(getNovember());
		__bean.setDecember(getDecember());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDetails() == null ? "" : getDetails());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getPlateId())));
		sb.append(",");
		sb.append(getJanuary() == null ? "" : getJanuary());
		sb.append(",");
		sb.append(getFebruary() == null ? "" : getFebruary());
		sb.append(",");
		sb.append(getMarch() == null ? "" : getMarch());
		sb.append(",");
		sb.append(getApril() == null ? "" : getApril());
		sb.append(",");
		sb.append(getMay() == null ? "" : getMay());
		sb.append(",");
		sb.append(getJune() == null ? "" : getJune());
		sb.append(",");
		sb.append(getJuly() == null ? "" : getJuly());
		sb.append(",");
		sb.append(getAugust() == null ? "" : getAugust());
		sb.append(",");
		sb.append(getSeptember() == null ? "" : getSeptember());
		sb.append(",");
		sb.append(getOctober() == null ? "" : getOctober());
		sb.append(",");
		sb.append(getNovember() == null ? "" : getNovember());
		sb.append(",");
		sb.append(getDecember() == null ? "" : getDecember());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDepartmentIncomeDetailReport o) {
		return __details == null ? -1 : __details.compareTo(o.getDetails());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__details);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__january);
		hash = 97 * hash + Objects.hashCode(this.__february);
		hash = 97 * hash + Objects.hashCode(this.__march);
		hash = 97 * hash + Objects.hashCode(this.__april);
		hash = 97 * hash + Objects.hashCode(this.__may);
		hash = 97 * hash + Objects.hashCode(this.__june);
		hash = 97 * hash + Objects.hashCode(this.__july);
		hash = 97 * hash + Objects.hashCode(this.__august);
		hash = 97 * hash + Objects.hashCode(this.__september);
		hash = 97 * hash + Objects.hashCode(this.__october);
		hash = 97 * hash + Objects.hashCode(this.__november);
		hash = 97 * hash + Objects.hashCode(this.__december);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDepartmentIncomeDetailReport o = (BaseDepartmentIncomeDetailReport)obj;
		if(!Objects.equals(this.__details, o.getDetails())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__january, o.getJanuary())) return false;
		if(!Objects.equals(this.__february, o.getFebruary())) return false;
		if(!Objects.equals(this.__march, o.getMarch())) return false;
		if(!Objects.equals(this.__april, o.getApril())) return false;
		if(!Objects.equals(this.__may, o.getMay())) return false;
		if(!Objects.equals(this.__june, o.getJune())) return false;
		if(!Objects.equals(this.__july, o.getJuly())) return false;
		if(!Objects.equals(this.__august, o.getAugust())) return false;
		if(!Objects.equals(this.__september, o.getSeptember())) return false;
		if(!Objects.equals(this.__october, o.getOctober())) return false;
		if(!Objects.equals(this.__november, o.getNovember())) return false;
		if(!Objects.equals(this.__december, o.getDecember())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDetails() != null) sb.append(__wrapString(count++, "details", getDetails()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getJanuary() != null) sb.append(__wrapDecimal(count++, "january", getJanuary()));
		if(getFebruary() != null) sb.append(__wrapDecimal(count++, "february", getFebruary()));
		if(getMarch() != null) sb.append(__wrapDecimal(count++, "march", getMarch()));
		if(getApril() != null) sb.append(__wrapDecimal(count++, "april", getApril()));
		if(getMay() != null) sb.append(__wrapDecimal(count++, "may", getMay()));
		if(getJune() != null) sb.append(__wrapDecimal(count++, "june", getJune()));
		if(getJuly() != null) sb.append(__wrapDecimal(count++, "july", getJuly()));
		if(getAugust() != null) sb.append(__wrapDecimal(count++, "august", getAugust()));
		if(getSeptember() != null) sb.append(__wrapDecimal(count++, "september", getSeptember()));
		if(getOctober() != null) sb.append(__wrapDecimal(count++, "october", getOctober()));
		if(getNovember() != null) sb.append(__wrapDecimal(count++, "november", getNovember()));
		if(getDecember() != null) sb.append(__wrapDecimal(count++, "december", getDecember()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getDetails() != null) res.put("details", getDetails());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getJanuary() != null) res.put("january", getJanuary());
		if(getFebruary() != null) res.put("february", getFebruary());
		if(getMarch() != null) res.put("march", getMarch());
		if(getApril() != null) res.put("april", getApril());
		if(getMay() != null) res.put("may", getMay());
		if(getJune() != null) res.put("june", getJune());
		if(getJuly() != null) res.put("july", getJuly());
		if(getAugust() != null) res.put("august", getAugust());
		if(getSeptember() != null) res.put("september", getSeptember());
		if(getOctober() != null) res.put("october", getOctober());
		if(getNovember() != null) res.put("november", getNovember());
		if(getDecember() != null) res.put("december", getDecember());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("details")) != null) setDetails(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("january")) != null) setJanuary(__getDecimal(val));  
		if((val = values.get("february")) != null) setFebruary(__getDecimal(val));  
		if((val = values.get("march")) != null) setMarch(__getDecimal(val));  
		if((val = values.get("april")) != null) setApril(__getDecimal(val));  
		if((val = values.get("may")) != null) setMay(__getDecimal(val));  
		if((val = values.get("june")) != null) setJune(__getDecimal(val));  
		if((val = values.get("july")) != null) setJuly(__getDecimal(val));  
		if((val = values.get("august")) != null) setAugust(__getDecimal(val));  
		if((val = values.get("september")) != null) setSeptember(__getDecimal(val));  
		if((val = values.get("october")) != null) setOctober(__getDecimal(val));  
		if((val = values.get("november")) != null) setNovember(__getDecimal(val));  
		if((val = values.get("december")) != null) setDecember(__getDecimal(val));  
	}

	protected java.lang.String  __details ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __january ;
	protected java.math.BigDecimal  __february ;
	protected java.math.BigDecimal  __march ;
	protected java.math.BigDecimal  __april ;
	protected java.math.BigDecimal  __may ;
	protected java.math.BigDecimal  __june ;
	protected java.math.BigDecimal  __july ;
	protected java.math.BigDecimal  __august ;
	protected java.math.BigDecimal  __september ;
	protected java.math.BigDecimal  __october ;
	protected java.math.BigDecimal  __november ;
	protected java.math.BigDecimal  __december ;
}
