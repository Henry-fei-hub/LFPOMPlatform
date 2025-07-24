package pomplatform.getprojectreserveintegral.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetProjectReserveIntegral extends GenericBase implements BaseFactory<BaseGetProjectReserveIntegral>, Comparable<BaseGetProjectReserveIntegral> 
{


	public static BaseGetProjectReserveIntegral newInstance(){
		return new BaseGetProjectReserveIntegral();
	}

	@Override
	public BaseGetProjectReserveIntegral make(){
		BaseGetProjectReserveIntegral b = new BaseGetProjectReserveIntegral();
		return b;
	}

	public final static java.lang.String CS_INTEGRAL = "integral" ;

	public final static java.lang.String ALL_CAPTIONS = "";

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public void cloneCopy(BaseGetProjectReserveIntegral __bean){
		__bean.setIntegral(getIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getIntegral() == null ? "" : getIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetProjectReserveIntegral o) {
		return __integral == null ? -1 : __integral.compareTo(o.getIntegral());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetProjectReserveIntegral o = (BaseGetProjectReserveIntegral)obj;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __integral ;
}
