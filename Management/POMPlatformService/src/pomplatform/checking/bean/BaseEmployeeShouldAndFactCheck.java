package pomplatform.checking.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeShouldAndFactCheck extends GenericBase implements BaseFactory<BaseEmployeeShouldAndFactCheck>, Comparable<BaseEmployeeShouldAndFactCheck> 
{


	public static BaseEmployeeShouldAndFactCheck newInstance(){
		return new BaseEmployeeShouldAndFactCheck();
	}

	@Override
	public BaseEmployeeShouldAndFactCheck make(){
		BaseEmployeeShouldAndFactCheck b = new BaseEmployeeShouldAndFactCheck();
		return b;
	}

	public final static java.lang.String CS_SHOULD_DAYS = "should_days" ;
	public final static java.lang.String CS_FACT_DAYS = "fact_days" ;

	public final static java.lang.String ALL_CAPTIONS = "应到天数,实到天数";

	public java.math.BigDecimal getShouldDays() {
		return this.__should_days;
	}

	public void setShouldDays( java.math.BigDecimal value ) {
		this.__should_days = value;
	}

	public java.math.BigDecimal getFactDays() {
		return this.__fact_days;
	}

	public void setFactDays( java.math.BigDecimal value ) {
		this.__fact_days = value;
	}

	public void cloneCopy(BaseEmployeeShouldAndFactCheck __bean){
		__bean.setShouldDays(getShouldDays());
		__bean.setFactDays(getFactDays());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getShouldDays() == null ? "" : getShouldDays());
		sb.append(",");
		sb.append(getFactDays() == null ? "" : getFactDays());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeShouldAndFactCheck o) {
		return __should_days == null ? -1 : __should_days.compareTo(o.getShouldDays());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__should_days);
		hash = 97 * hash + Objects.hashCode(this.__fact_days);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeShouldAndFactCheck o = (BaseEmployeeShouldAndFactCheck)obj;
		if(!Objects.equals(this.__should_days, o.getShouldDays())) return false;
		if(!Objects.equals(this.__fact_days, o.getFactDays())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getShouldDays() != null) sb.append(__wrapDecimal(count++, "shouldDays", getShouldDays()));
		if(getFactDays() != null) sb.append(__wrapDecimal(count++, "factDays", getFactDays()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("shouldDays")) != null) setShouldDays(__getDecimal(val));  
		if((val = values.get("factDays")) != null) setFactDays(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __should_days ;
	protected java.math.BigDecimal  __fact_days ;
}
