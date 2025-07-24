package pomplatform.projectCost.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectCostRecord extends GenericBase implements BaseFactory<BaseProjectCostRecord>, Comparable<BaseProjectCostRecord> 
{


	public static BaseProjectCostRecord newInstance(){
		return new BaseProjectCostRecord();
	}

	@Override
	public BaseProjectCostRecord make(){
		BaseProjectCostRecord b = new BaseProjectCostRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_COST_ID = "project_cost_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_COST_TYPE = "cost_type" ;
	public final static java.lang.String CS_COST_DATE = "cost_date" ;
	public final static java.lang.String CS_SETTLEMENT_ID = "settlement_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_DESIGN_TEAM = "design_team" ;
	public final static java.lang.String CS_MAIN_PROJECT_STAGE_ID = "main_project_stage_id" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_EMPLOYEE_NAME_TO_STRING = "employee_name_to_string" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编号,项目名称,主办设计团队,立项类型,项目经理,报销人,报销部门,费用类型,金额,报销完成时间";

	public java.lang.Integer getProjectCostId() {
		return this.__project_cost_id;
	}

	public void setProjectCostId( java.lang.Integer value ) {
		this.__project_cost_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getCostType() {
		return this.__cost_type;
	}

	public void setCostType( java.lang.Integer value ) {
		this.__cost_type = value;
	}

	public java.util.Date getCostDate() {
		return this.__cost_date;
	}

	public void setCostDate( java.util.Date value ) {
		this.__cost_date = value;
	}

	public java.lang.Integer getSettlementId() {
		return this.__settlement_id;
	}

	public void setSettlementId( java.lang.Integer value ) {
		this.__settlement_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public java.lang.Integer getMainProjectStageId() {
		return this.__main_project_stage_id;
	}

	public void setMainProjectStageId( java.lang.Integer value ) {
		this.__main_project_stage_id = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.String getEmployeeNameToString() {
		return this.__employee_name_to_string;
	}

	public void setEmployeeNameToString( java.lang.String value ) {
		this.__employee_name_to_string = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public void cloneCopy(BaseProjectCostRecord __bean){
		__bean.setProjectCostId(getProjectCostId());
		__bean.setProjectId(getProjectId());
		__bean.setCostType(getCostType());
		__bean.setCostDate(getCostDate());
		__bean.setSettlementId(getSettlementId());
		__bean.setAmount(getAmount());
		__bean.setStatus(getStatus());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setDesignTeam(getDesignTeam());
		__bean.setMainProjectStageId(getMainProjectStageId());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setEmployeeNameToString(getEmployeeNameToString());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strDesignTeam= delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getDesignTeam()));
		sb.append(strDesignTeam == null ? "" : strDesignTeam);
		sb.append(",");
		String strMainProjectStageId = delicacy.system.executor.SelectValueCache.getSelectValue("main_project_stages", String.valueOf(getMainProjectStageId()));
		sb.append(strMainProjectStageId == null ? "" : strMainProjectStageId);
		sb.append(",");
		sb.append(getEmployeeNameToString() == null ? "" : ""+getEmployeeNameToString());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType== null ? "" : strProcessType);
		sb.append(",");
		sb.append(getAmount() ==null ? "" :getAmount());
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectCostRecord o) {
		return __project_cost_id == null ? -1 : __project_cost_id.compareTo(o.getProjectCostId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_cost_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__cost_type);
		hash = 97 * hash + Objects.hashCode(this.__cost_date);
		hash = 97 * hash + Objects.hashCode(this.__settlement_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__design_team);
		hash = 97 * hash + Objects.hashCode(this.__main_project_stage_id);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_to_string);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectCostRecord o = (BaseProjectCostRecord)obj;
		if(!Objects.equals(this.__project_cost_id, o.getProjectCostId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__cost_type, o.getCostType())) return false;
		if(!Objects.equals(this.__cost_date, o.getCostDate())) return false;
		if(!Objects.equals(this.__settlement_id, o.getSettlementId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__design_team, o.getDesignTeam())) return false;
		if(!Objects.equals(this.__main_project_stage_id, o.getMainProjectStageId())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__employee_name_to_string, o.getEmployeeNameToString())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectCostId() != null) sb.append(__wrapNumber(count++, "projectCostId", getProjectCostId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getCostType() != null) sb.append(__wrapNumber(count++, "costType", getCostType()));
		if(getCostDate() != null) sb.append(__wrapDate(count++, "costDate", getCostDate()));
		if(getSettlementId() != null) sb.append(__wrapNumber(count++, "settlementId", getSettlementId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(count++, "designTeam", getDesignTeam()));
		if(getMainProjectStageId() != null) sb.append(__wrapNumber(count++, "mainProjectStageId", getMainProjectStageId()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getEmployeeNameToString() != null) sb.append(__wrapString(count++, "employeeNameToString", getEmployeeNameToString()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectCostId() != null) res.put("projectCostId", getProjectCostId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getCostType() != null) res.put("costType", getCostType());
		if(getCostDate() != null) res.put("costDate", getCostDate());
		if(getSettlementId() != null) res.put("settlementId", getSettlementId());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getStatus() != null) res.put("status", getStatus());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getDesignTeam() != null) res.put("designTeam", getDesignTeam());
		if(getMainProjectStageId() != null) res.put("mainProjectStageId", getMainProjectStageId());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getEmployeeNameToString() != null) res.put("employeeNameToString", getEmployeeNameToString());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectCostId")) != null) setProjectCostId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("costType")) != null) setCostType(__getInt(val)); 
		if((val = values.get("costDate")) != null) setCostDate(__getDate(val)); 
		if((val = values.get("settlementId")) != null) setSettlementId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val)); 
		if((val = values.get("mainProjectStageId")) != null) setMainProjectStageId(__getInt(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("employeeNameToString")) != null) setEmployeeNameToString(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_cost_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __cost_type ;
	protected java.util.Date  __cost_date ;
	protected java.lang.Integer  __settlement_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __design_team ;
	protected java.lang.Integer  __main_project_stage_id ;
	protected java.util.Date  __complete_time ;
	protected java.lang.String  __employee_name_to_string ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
}
