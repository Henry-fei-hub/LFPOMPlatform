package pomplatform.sinvoiceitior.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSinvoiceorusecount extends GenericBase implements BaseFactory<BaseSinvoiceorusecount>, Comparable<BaseSinvoiceorusecount> 
{


	public static BaseSinvoiceorusecount newInstance(){
		return new BaseSinvoiceorusecount();
	}

	@Override
	public BaseSinvoiceorusecount make(){
		BaseSinvoiceorusecount b = new BaseSinvoiceorusecount();
		return b;
	}

	public final static java.lang.String CS_IN_NAME = "in_name" ;
	public final static java.lang.String CS_ALL_SUM = "all_sum" ;
	public final static java.lang.String CS_SEVENTEEN = "seventeen" ;
	public final static java.lang.String CS_SIX = "six" ;
	public final static java.lang.String CS_FIVE = "five" ;
	public final static java.lang.String CS_OTHER = "other" ;
	public final static java.lang.String CS_RESERVE_ONE = "reserve_one" ;
	public final static java.lang.String CS_RESERVE_TWO = "reserve_two" ;
	public final static java.lang.String CS_RESERVE_THREE = "reserve_three" ;

	public final static java.lang.String ALL_CAPTIONS = "类型名称,合计,17%,6%,5%,其它,备用,备用,备用";

	public java.lang.String getInName() {
		return this.__in_name;
	}

	public void setInName( java.lang.String value ) {
		this.__in_name = value;
	}

	public java.math.BigDecimal getAllSum() {
		return this.__all_sum;
	}

	public void setAllSum( java.math.BigDecimal value ) {
		this.__all_sum = value;
	}

	public java.math.BigDecimal getSeventeen() {
		return this.__seventeen;
	}

	public void setSeventeen( java.math.BigDecimal value ) {
		this.__seventeen = value;
	}

	public java.math.BigDecimal getSix() {
		return this.__six;
	}

	public void setSix( java.math.BigDecimal value ) {
		this.__six = value;
	}

	public java.math.BigDecimal getFive() {
		return this.__five;
	}

	public void setFive( java.math.BigDecimal value ) {
		this.__five = value;
	}

	public java.math.BigDecimal getOther() {
		return this.__other;
	}

	public void setOther( java.math.BigDecimal value ) {
		this.__other = value;
	}

	public java.math.BigDecimal getReserveOne() {
		return this.__reserve_one;
	}

	public void setReserveOne( java.math.BigDecimal value ) {
		this.__reserve_one = value;
	}

	public java.math.BigDecimal getReserveTwo() {
		return this.__reserve_two;
	}

	public void setReserveTwo( java.math.BigDecimal value ) {
		this.__reserve_two = value;
	}

	public java.lang.String getReserveThree() {
		return this.__reserve_three;
	}

	public void setReserveThree( java.lang.String value ) {
		this.__reserve_three = value;
	}

	public void cloneCopy(BaseSinvoiceorusecount __bean){
		__bean.setInName(getInName());
		__bean.setAllSum(getAllSum());
		__bean.setSeventeen(getSeventeen());
		__bean.setSix(getSix());
		__bean.setFive(getFive());
		__bean.setOther(getOther());
		__bean.setReserveOne(getReserveOne());
		__bean.setReserveTwo(getReserveTwo());
		__bean.setReserveThree(getReserveThree());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInName() == null ? "" : getInName());
		sb.append(",");
		sb.append(getAllSum() == null ? "" : getAllSum());
		sb.append(",");
		sb.append(getSeventeen() == null ? "" : getSeventeen());
		sb.append(",");
		sb.append(getSix() == null ? "" : getSix());
		sb.append(",");
		sb.append(getFive() == null ? "" : getFive());
		sb.append(",");
		sb.append(getOther() == null ? "" : getOther());
		sb.append(",");
		sb.append(getReserveOne() == null ? "" : getReserveOne());
		sb.append(",");
		sb.append(getReserveTwo() == null ? "" : getReserveTwo());
		sb.append(",");
		sb.append(getReserveThree() == null ? "" : getReserveThree());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSinvoiceorusecount o) {
		return __in_name == null ? -1 : __in_name.compareTo(o.getInName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__in_name);
		hash = 97 * hash + Objects.hashCode(this.__all_sum);
		hash = 97 * hash + Objects.hashCode(this.__seventeen);
		hash = 97 * hash + Objects.hashCode(this.__six);
		hash = 97 * hash + Objects.hashCode(this.__five);
		hash = 97 * hash + Objects.hashCode(this.__other);
		hash = 97 * hash + Objects.hashCode(this.__reserve_one);
		hash = 97 * hash + Objects.hashCode(this.__reserve_two);
		hash = 97 * hash + Objects.hashCode(this.__reserve_three);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSinvoiceorusecount o = (BaseSinvoiceorusecount)obj;
		if(!Objects.equals(this.__in_name, o.getInName())) return false;
		if(!Objects.equals(this.__all_sum, o.getAllSum())) return false;
		if(!Objects.equals(this.__seventeen, o.getSeventeen())) return false;
		if(!Objects.equals(this.__six, o.getSix())) return false;
		if(!Objects.equals(this.__five, o.getFive())) return false;
		if(!Objects.equals(this.__other, o.getOther())) return false;
		if(!Objects.equals(this.__reserve_one, o.getReserveOne())) return false;
		if(!Objects.equals(this.__reserve_two, o.getReserveTwo())) return false;
		if(!Objects.equals(this.__reserve_three, o.getReserveThree())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInName() != null) sb.append(__wrapString(count++, "inName", getInName()));
		if(getAllSum() != null) sb.append(__wrapDecimal(count++, "allSum", getAllSum()));
		if(getSeventeen() != null) sb.append(__wrapDecimal(count++, "seventeen", getSeventeen()));
		if(getSix() != null) sb.append(__wrapDecimal(count++, "six", getSix()));
		if(getFive() != null) sb.append(__wrapDecimal(count++, "five", getFive()));
		if(getOther() != null) sb.append(__wrapDecimal(count++, "other", getOther()));
		if(getReserveOne() != null) sb.append(__wrapDecimal(count++, "reserveOne", getReserveOne()));
		if(getReserveTwo() != null) sb.append(__wrapDecimal(count++, "reserveTwo", getReserveTwo()));
		if(getReserveThree() != null) sb.append(__wrapString(count++, "reserveThree", getReserveThree()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("inName")) != null) setInName(__getString(val));
		if((val = values.get("allSum")) != null) setAllSum(__getDecimal(val));  
		if((val = values.get("seventeen")) != null) setSeventeen(__getDecimal(val));  
		if((val = values.get("six")) != null) setSix(__getDecimal(val));  
		if((val = values.get("five")) != null) setFive(__getDecimal(val));  
		if((val = values.get("other")) != null) setOther(__getDecimal(val));  
		if((val = values.get("reserveOne")) != null) setReserveOne(__getDecimal(val));  
		if((val = values.get("reserveTwo")) != null) setReserveTwo(__getDecimal(val));  
		if((val = values.get("reserveThree")) != null) setReserveThree(__getString(val));
	}

	protected java.lang.String  __in_name ;
	protected java.math.BigDecimal  __all_sum ;
	protected java.math.BigDecimal  __seventeen ;
	protected java.math.BigDecimal  __six ;
	protected java.math.BigDecimal  __five ;
	protected java.math.BigDecimal  __other ;
	protected java.math.BigDecimal  __reserve_one ;
	protected java.math.BigDecimal  __reserve_two ;
	protected java.lang.String  __reserve_three ;
}
