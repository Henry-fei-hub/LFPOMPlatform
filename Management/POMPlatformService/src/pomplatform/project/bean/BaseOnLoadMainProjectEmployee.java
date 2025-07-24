package pomplatform.project.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadMainProjectEmployee extends GenericBase implements BaseFactory<BaseOnLoadMainProjectEmployee>, Comparable<BaseOnLoadMainProjectEmployee> 
{


	public static BaseOnLoadMainProjectEmployee newInstance(){
		return new BaseOnLoadMainProjectEmployee();
	}

	@Override
	public BaseOnLoadMainProjectEmployee make(){
		BaseOnLoadMainProjectEmployee b = new BaseOnLoadMainProjectEmployee();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public void cloneCopy(BaseOnLoadMainProjectEmployee __bean){
		__bean.setEmployeeId(getEmployeeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadMainProjectEmployee o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadMainProjectEmployee o = (BaseOnLoadMainProjectEmployee)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
}
