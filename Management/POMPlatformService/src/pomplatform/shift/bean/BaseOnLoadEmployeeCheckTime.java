package pomplatform.shift.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadEmployeeCheckTime extends GenericBase implements BaseFactory<BaseOnLoadEmployeeCheckTime>, Comparable<BaseOnLoadEmployeeCheckTime> 
{


	public static BaseOnLoadEmployeeCheckTime newInstance(){
		return new BaseOnLoadEmployeeCheckTime();
	}

	@Override
	public BaseOnLoadEmployeeCheckTime make(){
		BaseOnLoadEmployeeCheckTime b = new BaseOnLoadEmployeeCheckTime();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CHECKIN_TIME = "checkin_time" ;
	public final static java.lang.String CS_CHECKOUT_TIME = "checkout_time" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,,";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCheckinTime() {
		return this.__checkin_time;
	}

	public void setCheckinTime( java.util.Date value ) {
		this.__checkin_time = value;
	}

	public java.util.Date getCheckoutTime() {
		return this.__checkout_time;
	}

	public void setCheckoutTime( java.util.Date value ) {
		this.__checkout_time = value;
	}

	public void cloneCopy(BaseOnLoadEmployeeCheckTime __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCheckinTime(getCheckinTime());
		__bean.setCheckoutTime(getCheckoutTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCheckinTime() == null ? "" : sdf.format(getCheckinTime()));
		sb.append(",");
		sb.append(getCheckoutTime() == null ? "" : sdf.format(getCheckoutTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadEmployeeCheckTime o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__checkin_time);
		hash = 97 * hash + Objects.hashCode(this.__checkout_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadEmployeeCheckTime o = (BaseOnLoadEmployeeCheckTime)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__checkin_time, o.getCheckinTime())) return false;
		if(!Objects.equals(this.__checkout_time, o.getCheckoutTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCheckinTime() != null) sb.append(__wrapDate(count++, "checkinTime", getCheckinTime()));
		if(getCheckoutTime() != null) sb.append(__wrapDate(count++, "checkoutTime", getCheckoutTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getCheckinTime() != null) res.put("checkinTime", getCheckinTime());
		if(getCheckoutTime() != null) res.put("checkoutTime", getCheckoutTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("checkinTime")) != null) setCheckinTime(__getDate(val)); 
		if((val = values.get("checkoutTime")) != null) setCheckoutTime(__getDate(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __checkin_time ;
	protected java.util.Date  __checkout_time ;
}
