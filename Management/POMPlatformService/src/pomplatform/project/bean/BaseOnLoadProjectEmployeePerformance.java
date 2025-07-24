package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadProjectEmployeePerformance extends GenericBase implements BaseFactory<BaseOnLoadProjectEmployeePerformance>, Comparable<BaseOnLoadProjectEmployeePerformance> 
{


	public static BaseOnLoadProjectEmployeePerformance newInstance(){
		return new BaseOnLoadProjectEmployeePerformance();
	}

	@Override
	public BaseOnLoadProjectEmployeePerformance make(){
		BaseOnLoadProjectEmployeePerformance b = new BaseOnLoadProjectEmployeePerformance();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;
	public final static java.lang.String CS_TOTAL_PERFORMANCE_INTEGRAL = "total_performance_integral" ;
	public final static java.lang.String CS_TOTAL_SURE_INTEGRAL = "total_sure_integral" ;
	public final static java.lang.String CS_TOTAL_COST = "total_cost" ;
	public final static java.lang.String CS_TOTAL_SETTLEMENT_INTEGRAL = "total_settlement_integral" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;

	public final static java.lang.String ALL_CAPTIONS = "项目id,项目成员,员工编号,员工姓名,预分配积分,绩效积分,历史结算绩效积分,历史确认积分,历史分摊成本,历史结算积分,状态,是否可用";

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

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.math.BigDecimal getPlanIntegral() {
		return this.__plan_integral;
	}

	public void setPlanIntegral( java.math.BigDecimal value ) {
		this.__plan_integral = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public java.math.BigDecimal getTotalPerformanceIntegral() {
		return this.__total_performance_integral;
	}

	public void setTotalPerformanceIntegral( java.math.BigDecimal value ) {
		this.__total_performance_integral = value;
	}

	public java.math.BigDecimal getTotalSureIntegral() {
		return this.__total_sure_integral;
	}

	public void setTotalSureIntegral( java.math.BigDecimal value ) {
		this.__total_sure_integral = value;
	}

	public java.math.BigDecimal getTotalCost() {
		return this.__total_cost;
	}

	public void setTotalCost( java.math.BigDecimal value ) {
		this.__total_cost = value;
	}

	public java.math.BigDecimal getTotalSettlementIntegral() {
		return this.__total_settlement_integral;
	}

	public void setTotalSettlementIntegral( java.math.BigDecimal value ) {
		this.__total_settlement_integral = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public void cloneCopy(BaseOnLoadProjectEmployeePerformance __bean){
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setIntegral(getIntegral());
		__bean.setTotalPerformanceIntegral(getTotalPerformanceIntegral());
		__bean.setTotalSureIntegral(getTotalSureIntegral());
		__bean.setTotalCost(getTotalCost());
		__bean.setTotalSettlementIntegral(getTotalSettlementIntegral());
		__bean.setStatus(getStatus());
		__bean.setEnabled(getEnabled());
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
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		sb.append(",");
		sb.append(getTotalPerformanceIntegral() == null ? "" : getTotalPerformanceIntegral());
		sb.append(",");
		sb.append(getTotalSureIntegral() == null ? "" : getTotalSureIntegral());
		sb.append(",");
		sb.append(getTotalCost() == null ? "" : getTotalCost());
		sb.append(",");
		sb.append(getTotalSettlementIntegral() == null ? "" : getTotalSettlementIntegral());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_39", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadProjectEmployeePerformance o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		hash = 97 * hash + Objects.hashCode(this.__total_performance_integral);
		hash = 97 * hash + Objects.hashCode(this.__total_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__total_cost);
		hash = 97 * hash + Objects.hashCode(this.__total_settlement_integral);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadProjectEmployeePerformance o = (BaseOnLoadProjectEmployeePerformance)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		if(!Objects.equals(this.__total_performance_integral, o.getTotalPerformanceIntegral())) return false;
		if(!Objects.equals(this.__total_sure_integral, o.getTotalSureIntegral())) return false;
		if(!Objects.equals(this.__total_cost, o.getTotalCost())) return false;
		if(!Objects.equals(this.__total_settlement_integral, o.getTotalSettlementIntegral())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		if(getTotalPerformanceIntegral() != null) sb.append(__wrapDecimal(count++, "totalPerformanceIntegral", getTotalPerformanceIntegral()));
		if(getTotalSureIntegral() != null) sb.append(__wrapDecimal(count++, "totalSureIntegral", getTotalSureIntegral()));
		if(getTotalCost() != null) sb.append(__wrapDecimal(count++, "totalCost", getTotalCost()));
		if(getTotalSettlementIntegral() != null) sb.append(__wrapDecimal(count++, "totalSettlementIntegral", getTotalSettlementIntegral()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
		if((val = values.get("totalPerformanceIntegral")) != null) setTotalPerformanceIntegral(__getDecimal(val));  
		if((val = values.get("totalSureIntegral")) != null) setTotalSureIntegral(__getDecimal(val));  
		if((val = values.get("totalCost")) != null) setTotalCost(__getDecimal(val));  
		if((val = values.get("totalSettlementIntegral")) != null) setTotalSettlementIntegral(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __integral ;
	protected java.math.BigDecimal  __total_performance_integral ;
	protected java.math.BigDecimal  __total_sure_integral ;
	protected java.math.BigDecimal  __total_cost ;
	protected java.math.BigDecimal  __total_settlement_integral ;
	protected java.lang.Integer  __status ;
	protected java.lang.Boolean  __enabled ;
}
