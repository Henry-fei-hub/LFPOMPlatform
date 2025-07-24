package pomplatform.company.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseJobManager extends GenericBase implements BaseFactory<BaseJobManager>, Comparable<BaseJobManager> 
{


	public static BaseJobManager newInstance(){
		return new BaseJobManager();
	}

	@Override
	public BaseJobManager make(){
		BaseJobManager b = new BaseJobManager();
		return b;
	}

	public final static java.lang.String CS_DUTY_ID = "duty_id" ;
	public final static java.lang.String CS_DUTY_NAME = "duty_name" ;

	public final static java.lang.String ALL_CAPTIONS = "职位,职位名称";

	public java.lang.Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( java.lang.Integer value ) {
		this.__duty_id = value;
	}

	public java.lang.String getDutyName() {
		return this.__duty_name;
	}

	public void setDutyName( java.lang.String value ) {
		this.__duty_name = value;
	}

	public void cloneCopy(BaseJobManager __bean){
		__bean.setDutyId(getDutyId());
		__bean.setDutyName(getDutyName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDutyId() == null ? "" : getDutyId());
		sb.append(",");
		sb.append(getDutyName() == null ? "" : getDutyName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseJobManager o) {
		return __duty_id == null ? -1 : __duty_id.compareTo(o.getDutyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		hash = 97 * hash + Objects.hashCode(this.__duty_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseJobManager o = (BaseJobManager)obj;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		if(!Objects.equals(this.__duty_name, o.getDutyName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDutyId() != null) sb.append(__wrapNumber(count++, "dutyId", getDutyId()));
		if(getDutyName() != null) sb.append(__wrapString(count++, "dutyName", getDutyName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
		if((val = values.get("dutyName")) != null) setDutyName(__getString(val));
	}

	protected java.lang.Integer  __duty_id ;
	protected java.lang.String  __duty_name ;
}
