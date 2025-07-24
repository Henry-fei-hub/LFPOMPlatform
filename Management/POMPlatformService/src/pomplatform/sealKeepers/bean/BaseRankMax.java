package pomplatform.sealKeepers.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRankMax extends GenericBase implements BaseFactory<BaseRankMax>, Comparable<BaseRankMax> 
{


	public static BaseRankMax newInstance(){
		return new BaseRankMax();
	}

	@Override
	public BaseRankMax make(){
		BaseRankMax b = new BaseRankMax();
		return b;
	}

	public final static java.lang.String CS_MAX = "max" ;

	public final static java.lang.String ALL_CAPTIONS = "";

	public java.lang.Integer getMax() {
		return this.__max;
	}

	public void setMax( java.lang.Integer value ) {
		this.__max = value;
	}

	public void cloneCopy(BaseRankMax __bean){
		__bean.setMax(getMax());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMax() == null ? "" : getMax());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRankMax o) {
		return __max == null ? -1 : __max.compareTo(o.getMax());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__max);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRankMax o = (BaseRankMax)obj;
		if(!Objects.equals(this.__max, o.getMax())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMax() != null) sb.append(__wrapNumber(count++, "max", getMax()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMax() != null) res.put("max", getMax());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("max")) != null) setMax(__getInt(val)); 
	}

	protected java.lang.Integer  __max ;
}
