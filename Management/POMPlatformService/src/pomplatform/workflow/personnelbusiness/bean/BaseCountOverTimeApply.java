package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCountOverTimeApply extends GenericBase implements BaseFactory<BaseCountOverTimeApply>, Comparable<BaseCountOverTimeApply> 
{


	public static BaseCountOverTimeApply newInstance(){
		return new BaseCountOverTimeApply();
	}

	@Override
	public BaseCountOverTimeApply make(){
		BaseCountOverTimeApply b = new BaseCountOverTimeApply();
		return b;
	}

	public final static java.lang.String CS_COUNT = "count" ;

	public final static java.lang.String ALL_CAPTIONS = "数量";

	public java.lang.Long getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Long value ) {
		this.__count = value;
	}

	public void cloneCopy(BaseCountOverTimeApply __bean){
		__bean.setCount(getCount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCount() == null ? "" : getCount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCountOverTimeApply o) {
		return __count == null ? -1 : __count.compareTo(o.getCount());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__count);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCountOverTimeApply o = (BaseCountOverTimeApply)obj;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("count")) != null) setCount(__getLong(val)); 
	}

	protected java.lang.Long  __count ;
}
