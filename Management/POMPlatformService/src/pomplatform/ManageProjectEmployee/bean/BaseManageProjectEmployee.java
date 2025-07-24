package pomplatform.ManageProjectEmployee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseManageProjectEmployee extends GenericBase implements BaseFactory<BaseManageProjectEmployee>, Comparable<BaseManageProjectEmployee> 
{


	public static BaseManageProjectEmployee newInstance(){
		return new BaseManageProjectEmployee();
	}

	@Override
	public BaseManageProjectEmployee make(){
		BaseManageProjectEmployee b = new BaseManageProjectEmployee();
		return b;
	}

	public final static java.lang.String CS_MANAGE_PROJECT_ID = "manage_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ASSIGN_INTEGRAL = "assign_integral" ;
	public final static java.lang.String CS_ASSIGNED_INTEGRAL = "assigned_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "管理项目,发放成员,发放积分,已发放积分";

	public java.lang.Integer getManageProjectId() {
		return this.__manage_project_id;
	}

	public void setManageProjectId( java.lang.Integer value ) {
		this.__manage_project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getAssignIntegral() {
		return this.__assign_integral;
	}

	public void setAssignIntegral( java.math.BigDecimal value ) {
		this.__assign_integral = value;
	}

	public java.math.BigDecimal getAssignedIntegral() {
		return this.__assigned_integral;
	}

	public void setAssignedIntegral( java.math.BigDecimal value ) {
		this.__assigned_integral = value;
	}

	public void cloneCopy(BaseManageProjectEmployee __bean){
		__bean.setManageProjectId(getManageProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAssignIntegral(getAssignIntegral());
		__bean.setAssignedIntegral(getAssignedIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strManageProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("manage_projects", String.valueOf(getManageProjectId()));
		sb.append(strManageProjectId == null ? "" : strManageProjectId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAssignIntegral() == null ? "" : getAssignIntegral());
		sb.append(",");
		sb.append(getAssignedIntegral() == null ? "" : getAssignedIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseManageProjectEmployee o) {
		return __manage_project_id == null ? -1 : __manage_project_id.compareTo(o.getManageProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__manage_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__assign_integral);
		hash = 97 * hash + Objects.hashCode(this.__assigned_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseManageProjectEmployee o = (BaseManageProjectEmployee)obj;
		if(!Objects.equals(this.__manage_project_id, o.getManageProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__assign_integral, o.getAssignIntegral())) return false;
		if(!Objects.equals(this.__assigned_integral, o.getAssignedIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getManageProjectId() != null) sb.append(__wrapNumber(count++, "manageProjectId", getManageProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getAssignIntegral() != null) sb.append(__wrapDecimal(count++, "assignIntegral", getAssignIntegral()));
		if(getAssignedIntegral() != null) sb.append(__wrapDecimal(count++, "assignedIntegral", getAssignedIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("manageProjectId")) != null) setManageProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("assignIntegral")) != null) setAssignIntegral(__getDecimal(val));  
		if((val = values.get("assignedIntegral")) != null) setAssignedIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __manage_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __assign_integral ;
	protected java.math.BigDecimal  __assigned_integral ;
}
