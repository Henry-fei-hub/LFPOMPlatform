package pomplatform.getEmployeeIdByRoleId.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasegetEmployeeByRoleIdAndDepartmentId extends GenericBase implements BaseFactory<BasegetEmployeeByRoleIdAndDepartmentId>, Comparable<BasegetEmployeeByRoleIdAndDepartmentId> 
{


	public static BasegetEmployeeByRoleIdAndDepartmentId newInstance(){
		return new BasegetEmployeeByRoleIdAndDepartmentId();
	}

	@Override
	public BasegetEmployeeByRoleIdAndDepartmentId make(){
		BasegetEmployeeByRoleIdAndDepartmentId b = new BasegetEmployeeByRoleIdAndDepartmentId();
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

	public void cloneCopy(BasegetEmployeeByRoleIdAndDepartmentId __bean){
		__bean.setEmployeeId(getEmployeeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		return sb.toString();
	}

	@Override
	public int compareTo(BasegetEmployeeByRoleIdAndDepartmentId o) {
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
		final BasegetEmployeeByRoleIdAndDepartmentId o = (BasegetEmployeeByRoleIdAndDepartmentId)obj;
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

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
}
