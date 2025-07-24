package pomplatform.report.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseDepartmentIncomeReport extends GenericBase implements BaseFactory<BaseDepartmentIncomeReport>, Comparable<BaseDepartmentIncomeReport>
{


	public static BaseDepartmentIncomeReport newInstance(){
		return new BaseDepartmentIncomeReport();
	}

	@Override
	public BaseDepartmentIncomeReport make(){
		BaseDepartmentIncomeReport b = new BaseDepartmentIncomeReport();
		return b;
	}

	public final static String CS_PLATE_INCOME_AND_EXPENDITURE_ID = "plate_income_and_expenditure_id" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_YEAR = "year" ;
	public final static String CS_MONTH = "month" ;
	public final static String CS_JANUARY = "january" ;
	public final static String CS_FEBRUARY = "february" ;
	public final static String CS_MARCH = "march" ;
	public final static String CS_APRIL = "april" ;
	public final static String CS_MAY = "may" ;
	public final static String CS_JUNE = "june" ;
	public final static String CS_JULY = "july" ;
	public final static String CS_AGUEST = "aguest" ;
	public final static String CS_SEPTEMBER = "september" ;
	public final static String CS_OCTOBER = "october" ;
	public final static String CS_NOVEMBER = "november" ;
	public final static String CS_DECEMBER = "december" ;
	public final static String CS_TOTAL = "total" ;

	public final static String ALL_CAPTIONS = "部门,年份,月份,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月,总计";

	public Integer getPlateIncomeAndExpenditureId() {
		return this.__plate_income_and_expenditure_id;
	}

	public void setPlateIncomeAndExpenditureId( Integer value ) {
		this.__plate_income_and_expenditure_id = value;
	}

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

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

	public java.math.BigDecimal getAguest() {
		return this.__aguest;
	}

	public void setAguest( java.math.BigDecimal value ) {
		this.__aguest = value;
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

	public java.math.BigDecimal getTotal() {
		return this.__total;
	}

	public void setTotal( java.math.BigDecimal value ) {
		this.__total = value;
	}

	public void cloneCopy(BaseDepartmentIncomeReport __bean){
		__bean.setPlateIncomeAndExpenditureId(getPlateIncomeAndExpenditureId());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setJanuary(getJanuary());
		__bean.setFebruary(getFebruary());
		__bean.setMarch(getMarch());
		__bean.setApril(getApril());
		__bean.setMay(getMay());
		__bean.setJune(getJune());
		__bean.setJuly(getJuly());
		__bean.setAguest(getAguest());
		__bean.setSeptember(getSeptember());
		__bean.setOctober(getOctober());
		__bean.setNovember(getNovember());
		__bean.setDecember(getDecember());
		__bean.setTotal(getTotal());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
//		sb.append(getPlateIncomeAndExpenditureId() == null ? "" : getPlateIncomeAndExpenditureId());
//		sb.append(",");
		sb.append(getPlateId() == null ? "" : delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getPlateId())));
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
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
		sb.append(getAguest() == null ? "" : getAguest());
		sb.append(",");
		sb.append(getSeptember() == null ? "" : getSeptember());
		sb.append(",");
		sb.append(getOctober() == null ? "" : getOctober());
		sb.append(",");
		sb.append(getNovember() == null ? "" : getNovember());
		sb.append(",");
		sb.append(getDecember() == null ? "" : getDecember());
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDepartmentIncomeReport o) {
		return __plate_income_and_expenditure_id == null ? -1 : __plate_income_and_expenditure_id.compareTo(o.getPlateIncomeAndExpenditureId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_income_and_expenditure_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__january);
		hash = 97 * hash + Objects.hashCode(this.__february);
		hash = 97 * hash + Objects.hashCode(this.__march);
		hash = 97 * hash + Objects.hashCode(this.__april);
		hash = 97 * hash + Objects.hashCode(this.__may);
		hash = 97 * hash + Objects.hashCode(this.__june);
		hash = 97 * hash + Objects.hashCode(this.__july);
		hash = 97 * hash + Objects.hashCode(this.__aguest);
		hash = 97 * hash + Objects.hashCode(this.__september);
		hash = 97 * hash + Objects.hashCode(this.__october);
		hash = 97 * hash + Objects.hashCode(this.__november);
		hash = 97 * hash + Objects.hashCode(this.__december);
		hash = 97 * hash + Objects.hashCode(this.__total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDepartmentIncomeReport o = (BaseDepartmentIncomeReport)obj;
		if(!Objects.equals(this.__plate_income_and_expenditure_id, o.getPlateIncomeAndExpenditureId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__january, o.getJanuary())) return false;
		if(!Objects.equals(this.__february, o.getFebruary())) return false;
		if(!Objects.equals(this.__march, o.getMarch())) return false;
		if(!Objects.equals(this.__april, o.getApril())) return false;
		if(!Objects.equals(this.__may, o.getMay())) return false;
		if(!Objects.equals(this.__june, o.getJune())) return false;
		if(!Objects.equals(this.__july, o.getJuly())) return false;
		if(!Objects.equals(this.__aguest, o.getAguest())) return false;
		if(!Objects.equals(this.__september, o.getSeptember())) return false;
		if(!Objects.equals(this.__october, o.getOctober())) return false;
		if(!Objects.equals(this.__november, o.getNovember())) return false;
		if(!Objects.equals(this.__december, o.getDecember())) return false;
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateIncomeAndExpenditureId() != null) sb.append(__wrapNumber(count++, "plateIncomeAndExpenditureId", getPlateIncomeAndExpenditureId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getJanuary() != null) sb.append(__wrapDecimal(count++, "january", getJanuary()));
		if(getFebruary() != null) sb.append(__wrapDecimal(count++, "february", getFebruary()));
		if(getMarch() != null) sb.append(__wrapDecimal(count++, "march", getMarch()));
		if(getApril() != null) sb.append(__wrapDecimal(count++, "april", getApril()));
		if(getMay() != null) sb.append(__wrapDecimal(count++, "may", getMay()));
		if(getJune() != null) sb.append(__wrapDecimal(count++, "june", getJune()));
		if(getJuly() != null) sb.append(__wrapDecimal(count++, "july", getJuly()));
		if(getAguest() != null) sb.append(__wrapDecimal(count++, "aguest", getAguest()));
		if(getSeptember() != null) sb.append(__wrapDecimal(count++, "september", getSeptember()));
		if(getOctober() != null) sb.append(__wrapDecimal(count++, "october", getOctober()));
		if(getNovember() != null) sb.append(__wrapDecimal(count++, "november", getNovember()));
		if(getDecember() != null) sb.append(__wrapDecimal(count++, "december", getDecember()));
		if(getTotal() != null) sb.append(__wrapDecimal(count++, "total", getTotal()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPlateIncomeAndExpenditureId() != null) res.put("plateIncomeAndExpenditureId", getPlateIncomeAndExpenditureId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getJanuary() != null) res.put("january", getJanuary());
		if(getFebruary() != null) res.put("february", getFebruary());
		if(getMarch() != null) res.put("march", getMarch());
		if(getApril() != null) res.put("april", getApril());
		if(getMay() != null) res.put("may", getMay());
		if(getJune() != null) res.put("june", getJune());
		if(getJuly() != null) res.put("july", getJuly());
		if(getAguest() != null) res.put("aguest", getAguest());
		if(getSeptember() != null) res.put("september", getSeptember());
		if(getOctober() != null) res.put("october", getOctober());
		if(getNovember() != null) res.put("november", getNovember());
		if(getDecember() != null) res.put("december", getDecember());
		if(getTotal() != null) res.put("total", getTotal());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateIncomeAndExpenditureId")) != null) setPlateIncomeAndExpenditureId(__getInt(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("year")) != null) setYear(__getDouble(val));
		if((val = values.get("month")) != null) setMonth(__getDouble(val));
		if((val = values.get("january")) != null) setJanuary(__getDecimal(val));
		if((val = values.get("february")) != null) setFebruary(__getDecimal(val));
		if((val = values.get("march")) != null) setMarch(__getDecimal(val));
		if((val = values.get("april")) != null) setApril(__getDecimal(val));
		if((val = values.get("may")) != null) setMay(__getDecimal(val));
		if((val = values.get("june")) != null) setJune(__getDecimal(val));
		if((val = values.get("july")) != null) setJuly(__getDecimal(val));
		if((val = values.get("aguest")) != null) setAguest(__getDecimal(val));
		if((val = values.get("september")) != null) setSeptember(__getDecimal(val));
		if((val = values.get("october")) != null) setOctober(__getDecimal(val));
		if((val = values.get("november")) != null) setNovember(__getDecimal(val));
		if((val = values.get("december")) != null) setDecember(__getDecimal(val));
		if((val = values.get("total")) != null) setTotal(__getDecimal(val));
	}

	protected Integer  __plate_income_and_expenditure_id ;
	protected Integer  __plate_id ;
	protected Double  __year ;
	protected Double  __month ;
	protected java.math.BigDecimal  __january ;
	protected java.math.BigDecimal  __february ;
	protected java.math.BigDecimal  __march ;
	protected java.math.BigDecimal  __april ;
	protected java.math.BigDecimal  __may ;
	protected java.math.BigDecimal  __june ;
	protected java.math.BigDecimal  __july ;
	protected java.math.BigDecimal  __aguest ;
	protected java.math.BigDecimal  __september ;
	protected java.math.BigDecimal  __october ;
	protected java.math.BigDecimal  __november ;
	protected java.math.BigDecimal  __december ;
	protected java.math.BigDecimal  __total ;
}

