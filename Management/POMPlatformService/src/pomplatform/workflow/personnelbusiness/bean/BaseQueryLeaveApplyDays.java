package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseQueryLeaveApplyDays extends GenericBase implements BaseFactory<BaseQueryLeaveApplyDays>, Comparable<BaseQueryLeaveApplyDays> 
{


	public static BaseQueryLeaveApplyDays newInstance(){
		return new BaseQueryLeaveApplyDays();
	}

	@Override
	public BaseQueryLeaveApplyDays make(){
		BaseQueryLeaveApplyDays b = new BaseQueryLeaveApplyDays();
		return b;
	}

	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_HOURS = "hours" ;

	public final static java.lang.String ALL_CAPTIONS = "天数,小时";

	public java.math.BigDecimal getDays() {
		return this.__days;
	}

	public void setDays( java.math.BigDecimal value ) {
		this.__days = value;
	}

	public java.math.BigDecimal getHours() {
		return this.__hours;
	}

	public void setHours( java.math.BigDecimal value ) {
		this.__hours = value;
	}

	public void cloneCopy(BaseQueryLeaveApplyDays __bean){
		__bean.setDays(getDays());
		__bean.setHours(getHours());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getHours() == null ? "" : getHours());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseQueryLeaveApplyDays o) {
		return __days == null ? -1 : __days.compareTo(o.getDays());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__hours);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseQueryLeaveApplyDays o = (BaseQueryLeaveApplyDays)obj;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__hours, o.getHours())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
		if(getHours() != null) sb.append(__wrapDecimal(count++, "hours", getHours()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("days")) != null) setDays(__getDecimal(val));  
		if((val = values.get("hours")) != null) setHours(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __days ;
	protected java.math.BigDecimal  __hours ;
}
