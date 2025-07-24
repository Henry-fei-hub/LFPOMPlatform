package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetOvertimeApplyHours extends GenericBase implements BaseFactory<BaseGetOvertimeApplyHours>, Comparable<BaseGetOvertimeApplyHours> 
{


	public static BaseGetOvertimeApplyHours newInstance(){
		return new BaseGetOvertimeApplyHours();
	}

	@Override
	public BaseGetOvertimeApplyHours make(){
		BaseGetOvertimeApplyHours b = new BaseGetOvertimeApplyHours();
		return b;
	}

	public final static java.lang.String CS_HOURS = "hours" ;

	public final static java.lang.String ALL_CAPTIONS = "小时";

	public java.math.BigDecimal getHours() {
		return this.__hours;
	}

	public void setHours( java.math.BigDecimal value ) {
		this.__hours = value;
	}

	public void cloneCopy(BaseGetOvertimeApplyHours __bean){
		__bean.setHours(getHours());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getHours() == null ? "" : getHours());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetOvertimeApplyHours o) {
		return __hours == null ? -1 : __hours.compareTo(o.getHours());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__hours);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetOvertimeApplyHours o = (BaseGetOvertimeApplyHours)obj;
		if(!Objects.equals(this.__hours, o.getHours())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getHours() != null) sb.append(__wrapDecimal(count++, "hours", getHours()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("hours")) != null) setHours(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __hours ;
}
