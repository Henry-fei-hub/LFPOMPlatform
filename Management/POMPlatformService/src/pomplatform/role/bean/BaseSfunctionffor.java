package pomplatform.role.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSfunctionffor extends GenericBase implements BaseFactory<BaseSfunctionffor>, Comparable<BaseSfunctionffor> 
{


	public static BaseSfunctionffor newInstance(){
		return new BaseSfunctionffor();
	}

	@Override
	public BaseSfunctionffor make(){
		BaseSfunctionffor b = new BaseSfunctionffor();
		return b;
	}

	public final static java.lang.String CS_FUNCTION_ID = "function_id" ;
	public final static java.lang.String CS_FUNCTION_CODE = "function_code" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_FUNCTION_NAME = "function_name" ;
	public final static java.lang.String CS_APPLICATION_ID = "application_id" ;
	public final static java.lang.String CS_FUNCTION_TYPE = "function_type" ;
	public final static java.lang.String CS_PRIVILEGE_TYPE = "privilege_type" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;

	public final static java.lang.String ALL_CAPTIONS = "功能编码,功能编号,上级功能,功能名称,应用系统代码,功能类型,数据权限类型,是否有效";

	public java.lang.Integer getFunctionId() {
		return this.__function_id;
	}

	public void setFunctionId( java.lang.Integer value ) {
		this.__function_id = value;
	}

	public java.lang.String getFunctionCode() {
		return this.__function_code;
	}

	public void setFunctionCode( java.lang.String value ) {
		this.__function_code = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getFunctionName() {
		return this.__function_name;
	}

	public void setFunctionName( java.lang.String value ) {
		this.__function_name = value;
	}

	public java.lang.Integer getApplicationId() {
		return this.__application_id;
	}

	public void setApplicationId( java.lang.Integer value ) {
		this.__application_id = value;
	}

	public java.lang.Integer getFunctionType() {
		return this.__function_type;
	}

	public void setFunctionType( java.lang.Integer value ) {
		this.__function_type = value;
	}

	public java.lang.Integer getPrivilegeType() {
		return this.__privilege_type;
	}

	public void setPrivilegeType( java.lang.Integer value ) {
		this.__privilege_type = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public void cloneCopy(BaseSfunctionffor __bean){
		__bean.setFunctionId(getFunctionId());
		__bean.setFunctionCode(getFunctionCode());
		__bean.setParentId(getParentId());
		__bean.setFunctionName(getFunctionName());
		__bean.setApplicationId(getApplicationId());
		__bean.setFunctionType(getFunctionType());
		__bean.setPrivilegeType(getPrivilegeType());
		__bean.setEnabled(getEnabled());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFunctionId() == null ? "" : getFunctionId());
		sb.append(",");
		sb.append(getFunctionCode() == null ? "" : getFunctionCode());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getFunctionName() == null ? "" : getFunctionName());
		sb.append(",");
		sb.append(getApplicationId() == null ? "" : getApplicationId());
		sb.append(",");
		sb.append(getFunctionType() == null ? "" : getFunctionType());
		sb.append(",");
		sb.append(getPrivilegeType() == null ? "" : getPrivilegeType());
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSfunctionffor o) {
		return __function_id == null ? -1 : __function_id.compareTo(o.getFunctionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__function_id);
		hash = 97 * hash + Objects.hashCode(this.__function_code);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__function_name);
		hash = 97 * hash + Objects.hashCode(this.__application_id);
		hash = 97 * hash + Objects.hashCode(this.__function_type);
		hash = 97 * hash + Objects.hashCode(this.__privilege_type);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSfunctionffor o = (BaseSfunctionffor)obj;
		if(!Objects.equals(this.__function_id, o.getFunctionId())) return false;
		if(!Objects.equals(this.__function_code, o.getFunctionCode())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__function_name, o.getFunctionName())) return false;
		if(!Objects.equals(this.__application_id, o.getApplicationId())) return false;
		if(!Objects.equals(this.__function_type, o.getFunctionType())) return false;
		if(!Objects.equals(this.__privilege_type, o.getPrivilegeType())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFunctionId() != null) sb.append(__wrapNumber(count++, "functionId", getFunctionId()));
		if(getFunctionCode() != null) sb.append(__wrapString(count++, "functionCode", getFunctionCode()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getFunctionName() != null) sb.append(__wrapString(count++, "functionName", getFunctionName()));
		if(getApplicationId() != null) sb.append(__wrapNumber(count++, "applicationId", getApplicationId()));
		if(getFunctionType() != null) sb.append(__wrapNumber(count++, "functionType", getFunctionType()));
		if(getPrivilegeType() != null) sb.append(__wrapNumber(count++, "privilegeType", getPrivilegeType()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("functionId")) != null) setFunctionId(__getInt(val)); 
		if((val = values.get("functionCode")) != null) setFunctionCode(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("functionName")) != null) setFunctionName(__getString(val));
		if((val = values.get("applicationId")) != null) setApplicationId(__getInt(val)); 
		if((val = values.get("functionType")) != null) setFunctionType(__getInt(val)); 
		if((val = values.get("privilegeType")) != null) setPrivilegeType(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
	}

	protected java.lang.Integer  __function_id ;
	protected java.lang.String  __function_code ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __function_name ;
	protected java.lang.Integer  __application_id ;
	protected java.lang.Integer  __function_type ;
	protected java.lang.Integer  __privilege_type ;
	protected java.lang.Boolean  __enabled ;
}
