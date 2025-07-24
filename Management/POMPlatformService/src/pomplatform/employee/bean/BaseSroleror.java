package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSroleror extends GenericBase implements BaseFactory<BaseSroleror>, Comparable<BaseSroleror> 
{


	public static BaseSroleror newInstance(){
		return new BaseSroleror();
	}

	@Override
	public BaseSroleror make(){
		BaseSroleror b = new BaseSroleror();
		return b;
	}

	public final static java.lang.String CS_ROLE_ID = "role_id" ;
	public final static java.lang.String CS_ROLE_NAME = "role_name" ;
	public final static java.lang.String CS_APPLICATION_ID = "application_id" ;
	public final static java.lang.String CS_ROLE_TYPE = "role_type" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;

	public final static java.lang.String ALL_CAPTIONS = "角色编码,角色名称,应用系统代码,角色类型,是否有效";

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

	public java.lang.Integer getApplicationId() {
		return this.__application_id;
	}

	public void setApplicationId( java.lang.Integer value ) {
		this.__application_id = value;
	}

	public java.lang.Integer getRoleType() {
		return this.__role_type;
	}

	public void setRoleType( java.lang.Integer value ) {
		this.__role_type = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public void cloneCopy(BaseSroleror __bean){
		__bean.setRoleId(getRoleId());
		__bean.setRoleName(getRoleName());
		__bean.setApplicationId(getApplicationId());
		__bean.setRoleType(getRoleType());
		__bean.setEnabled(getEnabled());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRoleId() == null ? "" : getRoleId());
		sb.append(",");
		sb.append(getRoleName() == null ? "" : getRoleName());
		sb.append(",");
		sb.append(getApplicationId() == null ? "" : getApplicationId());
		sb.append(",");
		sb.append(getRoleType() == null ? "" : getRoleType());
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSroleror o) {
		return __role_id == null ? -1 : __role_id.compareTo(o.getRoleId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__role_id);
		hash = 97 * hash + Objects.hashCode(this.__role_name);
		hash = 97 * hash + Objects.hashCode(this.__application_id);
		hash = 97 * hash + Objects.hashCode(this.__role_type);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSroleror o = (BaseSroleror)obj;
		if(!Objects.equals(this.__role_id, o.getRoleId())) return false;
		if(!Objects.equals(this.__role_name, o.getRoleName())) return false;
		if(!Objects.equals(this.__application_id, o.getApplicationId())) return false;
		if(!Objects.equals(this.__role_type, o.getRoleType())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRoleId() != null) sb.append(__wrapNumber(count++, "roleId", getRoleId()));
		if(getRoleName() != null) sb.append(__wrapString(count++, "roleName", getRoleName()));
		if(getApplicationId() != null) sb.append(__wrapNumber(count++, "applicationId", getApplicationId()));
		if(getRoleType() != null) sb.append(__wrapNumber(count++, "roleType", getRoleType()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("roleName")) != null) setRoleName(__getString(val));
		if((val = values.get("applicationId")) != null) setApplicationId(__getInt(val)); 
		if((val = values.get("roleType")) != null) setRoleType(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
	}

	protected java.lang.Integer  __role_id ;
	protected java.lang.String  __role_name ;
	protected java.lang.Integer  __application_id ;
	protected java.lang.Integer  __role_type ;
	protected java.lang.Boolean  __enabled ;
}
