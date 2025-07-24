package pomplatform.checking.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttendanceManagementPersonNum extends GenericBase implements BaseFactory<BaseAttendanceManagementPersonNum>, Comparable<BaseAttendanceManagementPersonNum> 
{


	public static BaseAttendanceManagementPersonNum newInstance(){
		return new BaseAttendanceManagementPersonNum();
	}

	@Override
	public BaseAttendanceManagementPersonNum make(){
		BaseAttendanceManagementPersonNum b = new BaseAttendanceManagementPersonNum();
		return b;
	}

	public final static java.lang.String CS_ALL = "all" ;
	public final static java.lang.String CS_SHOULD = "should" ;

	public final static java.lang.String ALL_CAPTIONS = "人数,应出勤人数";

	public java.lang.Long getAll() {
		return this.__all;
	}

	public void setAll( java.lang.Long value ) {
		this.__all = value;
	}

	public java.lang.Long getShould() {
		return this.__should;
	}

	public void setShould( java.lang.Long value ) {
		this.__should = value;
	}

	public void cloneCopy(BaseAttendanceManagementPersonNum __bean){
		__bean.setAll(getAll());
		__bean.setShould(getShould());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAll() == null ? "" : getAll());
		sb.append(",");
		sb.append(getShould() == null ? "" : getShould());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttendanceManagementPersonNum o) {
		return __all == null ? -1 : __all.compareTo(o.getAll());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__all);
		hash = 97 * hash + Objects.hashCode(this.__should);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttendanceManagementPersonNum o = (BaseAttendanceManagementPersonNum)obj;
		if(!Objects.equals(this.__all, o.getAll())) return false;
		if(!Objects.equals(this.__should, o.getShould())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAll() != null) sb.append(__wrapNumber(count++, "all", getAll()));
		if(getShould() != null) sb.append(__wrapNumber(count++, "should", getShould()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("all")) != null) setAll(__getLong(val)); 
		if((val = values.get("should")) != null) setShould(__getLong(val)); 
	}

	protected java.lang.Long  __all ;
	protected java.lang.Long  __should ;
}
