package pomplatform.checking.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeShouldCheckinPersonNum extends GenericBase implements BaseFactory<BaseEmployeeShouldCheckinPersonNum>, Comparable<BaseEmployeeShouldCheckinPersonNum> 
{


	public static BaseEmployeeShouldCheckinPersonNum newInstance(){
		return new BaseEmployeeShouldCheckinPersonNum();
	}

	@Override
	public BaseEmployeeShouldCheckinPersonNum make(){
		BaseEmployeeShouldCheckinPersonNum b = new BaseEmployeeShouldCheckinPersonNum();
		return b;
	}

	public final static java.lang.String CS_SHOULD_CHECKIN_PERSON = "should_checkin_person" ;

	public final static java.lang.String ALL_CAPTIONS = "应出勤人数";

	public java.lang.Long getShouldCheckinPerson() {
		return this.__should_checkin_person;
	}

	public void setShouldCheckinPerson( java.lang.Long value ) {
		this.__should_checkin_person = value;
	}

	public void cloneCopy(BaseEmployeeShouldCheckinPersonNum __bean){
		__bean.setShouldCheckinPerson(getShouldCheckinPerson());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getShouldCheckinPerson() == null ? "" : getShouldCheckinPerson());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeShouldCheckinPersonNum o) {
		return __should_checkin_person == null ? -1 : __should_checkin_person.compareTo(o.getShouldCheckinPerson());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__should_checkin_person);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeShouldCheckinPersonNum o = (BaseEmployeeShouldCheckinPersonNum)obj;
		if(!Objects.equals(this.__should_checkin_person, o.getShouldCheckinPerson())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getShouldCheckinPerson() != null) sb.append(__wrapNumber(count++, "shouldCheckinPerson", getShouldCheckinPerson()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("shouldCheckinPerson")) != null) setShouldCheckinPerson(__getLong(val)); 
	}

	protected java.lang.Long  __should_checkin_person ;
}
