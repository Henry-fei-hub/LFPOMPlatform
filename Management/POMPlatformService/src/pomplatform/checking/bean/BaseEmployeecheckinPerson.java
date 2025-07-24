package pomplatform.checking.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeecheckinPerson extends GenericBase implements BaseFactory<BaseEmployeecheckinPerson>, Comparable<BaseEmployeecheckinPerson> 
{


	public static BaseEmployeecheckinPerson newInstance(){
		return new BaseEmployeecheckinPerson();
	}

	@Override
	public BaseEmployeecheckinPerson make(){
		BaseEmployeecheckinPerson b = new BaseEmployeecheckinPerson();
		return b;
	}

	public final static java.lang.String CS_CHECKIN_PERSON = "checkin_person" ;

	public final static java.lang.String ALL_CAPTIONS = "已出勤人数";

	public java.lang.Long getCheckinPerson() {
		return this.__checkin_person;
	}

	public void setCheckinPerson( java.lang.Long value ) {
		this.__checkin_person = value;
	}

	public void cloneCopy(BaseEmployeecheckinPerson __bean){
		__bean.setCheckinPerson(getCheckinPerson());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCheckinPerson() == null ? "" : getCheckinPerson());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeecheckinPerson o) {
		return __checkin_person == null ? -1 : __checkin_person.compareTo(o.getCheckinPerson());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__checkin_person);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeecheckinPerson o = (BaseEmployeecheckinPerson)obj;
		if(!Objects.equals(this.__checkin_person, o.getCheckinPerson())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCheckinPerson() != null) sb.append(__wrapNumber(count++, "checkinPerson", getCheckinPerson()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("checkinPerson")) != null) setCheckinPerson(__getLong(val)); 
	}

	protected java.lang.Long  __checkin_person ;
}
