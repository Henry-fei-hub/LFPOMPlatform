package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOfSalaryTotalByDepartment extends GenericBase implements BaseFactory<BaseReportOfSalaryTotalByDepartment>, Comparable<BaseReportOfSalaryTotalByDepartment> 
{


	public static BaseReportOfSalaryTotalByDepartment newInstance(){
		return new BaseReportOfSalaryTotalByDepartment();
	}

	@Override
	public BaseReportOfSalaryTotalByDepartment make(){
		BaseReportOfSalaryTotalByDepartment b = new BaseReportOfSalaryTotalByDepartment();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
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
	public final static java.lang.String CS_TOTAL = "total" ;

	public final static java.lang.String ALL_CAPTIONS = "归属部门,年份,一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月,合计";

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
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

	public java.math.BigDecimal getTotal() {
		return this.__total;
	}

	public void setTotal( java.math.BigDecimal value ) {
		this.__total = value;
	}

	public void cloneCopy(BaseReportOfSalaryTotalByDepartment __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setYear(getYear());
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
		__bean.setTotal(getTotal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String department = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(getDepartmentId() == null ? "" : department);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
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
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOfSalaryTotalByDepartment o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
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
		hash = 97 * hash + Objects.hashCode(this.__total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOfSalaryTotalByDepartment o = (BaseReportOfSalaryTotalByDepartment)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
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
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
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
		if(getTotal() != null) sb.append(__wrapDecimal(count++, "total", getTotal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
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
		if((val = values.get("total")) != null) setTotal(__getDecimal(val));  
	}

	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __year ;
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
	protected java.math.BigDecimal  __total ;
}
