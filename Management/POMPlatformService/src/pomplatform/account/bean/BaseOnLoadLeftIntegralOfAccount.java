package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadLeftIntegralOfAccount extends GenericBase implements BaseFactory<BaseOnLoadLeftIntegralOfAccount>, Comparable<BaseOnLoadLeftIntegralOfAccount> 
{


	public static BaseOnLoadLeftIntegralOfAccount newInstance(){
		return new BaseOnLoadLeftIntegralOfAccount();
	}

	@Override
	public BaseOnLoadLeftIntegralOfAccount make(){
		BaseOnLoadLeftIntegralOfAccount b = new BaseOnLoadLeftIntegralOfAccount();
		return b;
	}

	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "实时余额";

	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral( java.math.BigDecimal value ) {
		this.__left_integral = value;
	}

	public void cloneCopy(BaseOnLoadLeftIntegralOfAccount __bean){
		__bean.setLeftIntegral(getLeftIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadLeftIntegralOfAccount o) {
		return __left_integral == null ? -1 : __left_integral.compareTo(o.getLeftIntegral());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadLeftIntegralOfAccount o = (BaseOnLoadLeftIntegralOfAccount)obj;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __left_integral ;
}
