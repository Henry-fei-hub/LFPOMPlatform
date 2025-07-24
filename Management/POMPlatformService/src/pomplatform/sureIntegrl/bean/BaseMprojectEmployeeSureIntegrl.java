package pomplatform.sureIntegrl.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectEmployeeSureIntegrl extends GenericBase implements BaseFactory<BaseMprojectEmployeeSureIntegrl>, Comparable<BaseMprojectEmployeeSureIntegrl> 
{


	public static BaseMprojectEmployeeSureIntegrl newInstance(){
		return new BaseMprojectEmployeeSureIntegrl();
	}

	@Override
	public BaseMprojectEmployeeSureIntegrl make(){
		BaseMprojectEmployeeSureIntegrl b = new BaseMprojectEmployeeSureIntegrl();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_ASSIGN_SURE_INTEGRAL = "assign_sure_integral" ;
	public final static java.lang.String CS_STAGE_SURE_INTEGRAL = "stage_sure_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "项目,项目成员,预分配积分,分配确认积分,阶段确认的确认积分,确认的确认积分";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getPlanIntegral() {
		return this.__plan_integral;
	}

	public void setPlanIntegral( java.math.BigDecimal value ) {
		this.__plan_integral = value;
	}

	public java.lang.Integer getAssignSureIntegral() {
		return this.__assign_sure_integral;
	}

	public void setAssignSureIntegral( java.lang.Integer value ) {
		this.__assign_sure_integral = value;
	}

	public java.lang.String getStageSureIntegral() {
		return this.__stage_sure_integral;
	}

	public void setStageSureIntegral( java.lang.String value ) {
		this.__stage_sure_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public void cloneCopy(BaseMprojectEmployeeSureIntegrl __bean){
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setAssignSureIntegral(getAssignSureIntegral());
		__bean.setStageSureIntegral(getStageSureIntegral());
		__bean.setSureIntegral(getSureIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getAssignSureIntegral() == null ? "" : getAssignSureIntegral());
		sb.append(",");
		sb.append(getStageSureIntegral() == null ? "" : getStageSureIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojectEmployeeSureIntegrl o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__assign_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__stage_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectEmployeeSureIntegrl o = (BaseMprojectEmployeeSureIntegrl)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__assign_sure_integral, o.getAssignSureIntegral())) return false;
		if(!Objects.equals(this.__stage_sure_integral, o.getStageSureIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getAssignSureIntegral() != null) sb.append(__wrapNumber(count++, "assignSureIntegral", getAssignSureIntegral()));
		if(getStageSureIntegral() != null) sb.append(__wrapString(count++, "stageSureIntegral", getStageSureIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("assignSureIntegral")) != null) setAssignSureIntegral(__getInt(val)); 
		if((val = values.get("stageSureIntegral")) != null) setStageSureIntegral(__getString(val));
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.lang.Integer  __assign_sure_integral ;
	protected java.lang.String  __stage_sure_integral ;
	protected java.math.BigDecimal  __sure_integral ;
}
