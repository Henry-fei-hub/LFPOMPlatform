package pomplatform.checking.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSemployeecheckinoutupdatetimeor extends GenericBase implements BaseFactory<BaseSemployeecheckinoutupdatetimeor>, Comparable<BaseSemployeecheckinoutupdatetimeor> 
{


	public static BaseSemployeecheckinoutupdatetimeor newInstance(){
		return new BaseSemployeecheckinoutupdatetimeor();
	}

	@Override
	public BaseSemployeecheckinoutupdatetimeor make(){
		BaseSemployeecheckinoutupdatetimeor b = new BaseSemployeecheckinoutupdatetimeor();
		return b;
	}

	public final static java.lang.String CS_NEW_TIME = "new_time" ;

	public final static java.lang.String ALL_CAPTIONS = "最新时间";

	public java.lang.String getNewTime() {
		return this.__new_time;
	}

	public void setNewTime( java.lang.String value ) {
		this.__new_time = value;
	}

	public void cloneCopy(BaseSemployeecheckinoutupdatetimeor __bean){
		__bean.setNewTime(getNewTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getNewTime() == null ? "" : sdf.format(getNewTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSemployeecheckinoutupdatetimeor o) {
		return __new_time == null ? -1 : __new_time.compareTo(o.getNewTime());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__new_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSemployeecheckinoutupdatetimeor o = (BaseSemployeecheckinoutupdatetimeor)obj;
		if(!Objects.equals(this.__new_time, o.getNewTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getNewTime() != null) sb.append(__wrapString(count++, "newTime", getNewTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("newTime")) != null) setNewTime(__getString(val)); 
	}

	protected java.lang.String  __new_time ;
}
