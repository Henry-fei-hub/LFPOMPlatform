package pomplatform.funciton.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMyAuthorityApplication extends GenericBase implements BaseFactory<BaseMyAuthorityApplication>, Comparable<BaseMyAuthorityApplication> 
{


	public static BaseMyAuthorityApplication newInstance(){
		return new BaseMyAuthorityApplication();
	}

	@Override
	public BaseMyAuthorityApplication make(){
		BaseMyAuthorityApplication b = new BaseMyAuthorityApplication();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_FUNCTION_ID = "function_id" ;
	public final static java.lang.String CS_FUNCTION_CODE = "function_code" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_FUNCTION_NAME = "function_name" ;
	public final static java.lang.String CS_APPLICATION_ID = "application_id" ;

	public final static java.lang.String ALL_CAPTIONS = "人员id,权限id,功能编号,上级功能,功能名称,应用系统代码";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

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

	public void cloneCopy(BaseMyAuthorityApplication __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setFunctionId(getFunctionId());
		__bean.setFunctionCode(getFunctionCode());
		__bean.setParentId(getParentId());
		__bean.setFunctionName(getFunctionName());
		__bean.setApplicationId(getApplicationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getFunctionId() == null ? "" : getFunctionId());
		sb.append(",");
		sb.append(getFunctionCode() == null ? "" : getFunctionCode());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getFunctionName() == null ? "" : getFunctionName());
		sb.append(",");
		sb.append(getApplicationId() == null ? "" : getApplicationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMyAuthorityApplication o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__function_id);
		hash = 97 * hash + Objects.hashCode(this.__function_code);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__function_name);
		hash = 97 * hash + Objects.hashCode(this.__application_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMyAuthorityApplication o = (BaseMyAuthorityApplication)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__function_id, o.getFunctionId())) return false;
		if(!Objects.equals(this.__function_code, o.getFunctionCode())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__function_name, o.getFunctionName())) return false;
		if(!Objects.equals(this.__application_id, o.getApplicationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getFunctionId() != null) sb.append(__wrapNumber(count++, "functionId", getFunctionId()));
		if(getFunctionCode() != null) sb.append(__wrapString(count++, "functionCode", getFunctionCode()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getFunctionName() != null) sb.append(__wrapString(count++, "functionName", getFunctionName()));
		if(getApplicationId() != null) sb.append(__wrapNumber(count++, "applicationId", getApplicationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getFunctionId() != null) res.put("functionId", getFunctionId());
		if(getFunctionCode() != null) res.put("functionCode", getFunctionCode());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getFunctionName() != null) res.put("functionName", getFunctionName());
		if(getApplicationId() != null) res.put("applicationId", getApplicationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("functionId")) != null) setFunctionId(__getInt(val)); 
		if((val = values.get("functionCode")) != null) setFunctionCode(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("functionName")) != null) setFunctionName(__getString(val));
		if((val = values.get("applicationId")) != null) setApplicationId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __function_id ;
	protected java.lang.String  __function_code ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __function_name ;
	protected java.lang.Integer  __application_id ;
}
