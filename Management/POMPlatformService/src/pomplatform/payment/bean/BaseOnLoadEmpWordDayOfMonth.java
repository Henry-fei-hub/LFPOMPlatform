package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadEmpWordDayOfMonth extends GenericBase implements BaseFactory<BaseOnLoadEmpWordDayOfMonth>, Comparable<BaseOnLoadEmpWordDayOfMonth> 
{


	public static BaseOnLoadEmpWordDayOfMonth newInstance(){
		return new BaseOnLoadEmpWordDayOfMonth();
	}

	@Override
	public BaseOnLoadEmpWordDayOfMonth make(){
		BaseOnLoadEmpWordDayOfMonth b = new BaseOnLoadEmpWordDayOfMonth();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_COUNT = "count" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,工作日";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Integer value ) {
		this.__count = value;
	}

	public void cloneCopy(BaseOnLoadEmpWordDayOfMonth __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCount(getCount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadEmpWordDayOfMonth o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__count);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadEmpWordDayOfMonth o = (BaseOnLoadEmpWordDayOfMonth)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __count ;
}
