package pomplatform.role.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeRoleInfo extends GenericBase implements BaseFactory<BaseEmployeeRoleInfo>, Comparable<BaseEmployeeRoleInfo> 
{


	public static BaseEmployeeRoleInfo newInstance(){
		return new BaseEmployeeRoleInfo();
	}

	@Override
	public BaseEmployeeRoleInfo make(){
		BaseEmployeeRoleInfo b = new BaseEmployeeRoleInfo();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ROLE_ID = "role_id" ;
	public final static java.lang.String CS_ROLE_NAME = "role_name" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,角色编码,角色名称";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( java.lang.Integer value ) {
		this.__role_id = value;
	}

	public java.lang.String getRoleName() {
		return this.__role_name;
	}

	public void setRoleName( java.lang.String value ) {
		this.__role_name = value;
	}

	public void cloneCopy(BaseEmployeeRoleInfo __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRoleId(getRoleId());
		__bean.setRoleName(getRoleName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getRoleId() == null ? "" : getRoleId());
		sb.append(",");
		sb.append(getRoleName() == null ? "" : getRoleName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeRoleInfo o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__role_id);
		hash = 97 * hash + Objects.hashCode(this.__role_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeRoleInfo o = (BaseEmployeeRoleInfo)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__role_id, o.getRoleId())) return false;
		if(!Objects.equals(this.__role_name, o.getRoleName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRoleId() != null) sb.append(__wrapNumber(count++, "roleId", getRoleId()));
		if(getRoleName() != null) sb.append(__wrapString(count++, "roleName", getRoleName()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getRoleId() != null) res.put("roleId", getRoleId());
		if(getRoleName() != null) res.put("roleName", getRoleName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("roleName")) != null) setRoleName(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __role_id ;
	protected java.lang.String  __role_name ;
}
