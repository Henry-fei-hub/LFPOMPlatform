package pomplatform.EmployeeDetail.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseManagerProjectIntegralDetail extends GenericBase implements BaseFactory<BaseManagerProjectIntegralDetail>, Comparable<BaseManagerProjectIntegralDetail> 
{


	public static BaseManagerProjectIntegralDetail newInstance(){
		return new BaseManagerProjectIntegralDetail();
	}

	@Override
	public BaseManagerProjectIntegralDetail make(){
		BaseManagerProjectIntegralDetail b = new BaseManagerProjectIntegralDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_ASSIGNED_INTEGRAL = "assigned_integral" ;
	public final static java.lang.String CS_MANAGE_PROJECT_ID = "manage_project_id" ;

	public final static java.lang.String ALL_CAPTIONS = "发放成员,员工编号,已发放积分,管理项目";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.math.BigDecimal getAssignedIntegral() {
		return this.__assigned_integral;
	}

	public void setAssignedIntegral( java.math.BigDecimal value ) {
		this.__assigned_integral = value;
	}

	public java.lang.Integer getManageProjectId() {
		return this.__manage_project_id;
	}

	public void setManageProjectId( java.lang.Integer value ) {
		this.__manage_project_id = value;
	}

	public void cloneCopy(BaseManagerProjectIntegralDetail __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setAssignedIntegral(getAssignedIntegral());
		__bean.setManageProjectId(getManageProjectId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getAssignedIntegral() == null ? "" : getAssignedIntegral());
		sb.append(",");
		String strManageProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("manage_projects", String.valueOf(getManageProjectId()));
		sb.append(strManageProjectId == null ? "" : strManageProjectId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseManagerProjectIntegralDetail o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__assigned_integral);
		hash = 97 * hash + Objects.hashCode(this.__manage_project_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseManagerProjectIntegralDetail o = (BaseManagerProjectIntegralDetail)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__assigned_integral, o.getAssignedIntegral())) return false;
		if(!Objects.equals(this.__manage_project_id, o.getManageProjectId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getAssignedIntegral() != null) sb.append(__wrapDecimal(count++, "assignedIntegral", getAssignedIntegral()));
		if(getManageProjectId() != null) sb.append(__wrapNumber(count++, "manageProjectId", getManageProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("assignedIntegral")) != null) setAssignedIntegral(__getDecimal(val));  
		if((val = values.get("manageProjectId")) != null) setManageProjectId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.math.BigDecimal  __assigned_integral ;
	protected java.lang.Integer  __manage_project_id ;
}
