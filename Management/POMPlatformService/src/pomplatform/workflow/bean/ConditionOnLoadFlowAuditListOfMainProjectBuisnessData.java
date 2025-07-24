package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadFlowAuditListOfMainProjectBuisnessData extends GenericCondition{

	public ConditionOnLoadFlowAuditListOfMainProjectBuisnessData(){
		setParameterCount(15);
	}

	public Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( Integer value ) {
		this.__process_status = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public Integer getStatus() {
		return this.__status;
	}

	public void setStatus( Integer value ) {
		this.__status = value;
	}

	public Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( Integer value ) {
		this.__process_type = value;
	}

	public String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( String value ) {
		this.__project_name = value;
	}

	public Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( Integer value ) {
		this.__project_type = value;
	}

	public String getProjectSalesTeam() {
		return this.__project_sales_team;
	}

	public void setProjectSalesTeam( String value ) {
		this.__project_sales_team = value;
	}

	public String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName( String value ) {
		this.__customer_name = value;
	}

	public String getProvince() {
		return this.__province;
	}

	public void setProvince( String value ) {
		this.__province = value;
	}

	public String getCity() {
		return this.__city;
	}

	public void setCity( String value ) {
		this.__city = value;
	}

	public String getProjectOrigination() {
		return this.__project_origination;
	}

	public void setProjectOrigination( String value ) {
		this.__project_origination = value;
	}

	public Boolean getIsOperationDepartment() {
		return this.__is_operation_department;
	}

	public void setIsOperationDepartment( Boolean value ) {
		this.__is_operation_department = value;
	}

	public Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.util.Date getCreateTimeStart() {
		return this.__create_time_start;
	}

	public void setCreateTimeStart( java.util.Date value ) {
		this.__create_time_start = value;
	}

	public java.util.Date getCreateTimeEnd() {
		return this.__create_time_end;
	}

	public void setCreateTimeEnd( java.util.Date value ) {
		this.__create_time_end = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getProjectType() != null) sb.append(__wrapNumber(1, "projectType", getProjectType()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(1, "projectSalesTeam", getProjectSalesTeam()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getProvince() != null) sb.append(__wrapString(1, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(1, "city", getCity()));
		if(getProjectOrigination() != null) sb.append(__wrapString(1, "projectOrigination", getProjectOrigination()));
		if(getIsOperationDepartment() != null) sb.append(__wrapBoolean(1, "isOperationDepartment", getIsOperationDepartment()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(1, "applyEmployeeId", getApplyEmployeeId()));
		if(getCreateTimeStart() != null) sb.append(__wrapDate(1, "createTimeStart", getCreateTimeStart()));
		if(getCreateTimeEnd() != null) sb.append(__wrapDate(1, "createTimeEnd", getCreateTimeEnd()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("projectSalesTeam")) != null) setProjectSalesTeam(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("isOperationDepartment")) != null) setIsOperationDepartment(__getBoolean(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("createTimeStart")) != null) setCreateTimeStart(__getDate(val)); 
		if((val = values.get("createTimeEnd")) != null) setCreateTimeEnd(__getDate(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProcessStatus() != null) res.add("processStatus");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getStatus() != null) res.add("status");
		if(getProcessType() != null) res.add("processType");
		if(getProjectName() != null) res.add("projectName");
		if(getProjectType() != null) res.add("projectType");
		if(getProjectSalesTeam() != null) res.add("projectSalesTeam");
		if(getCustomerName() != null) res.add("customerName");
		if(getProvince() != null) res.add("province");
		if(getCity() != null) res.add("city");
		if(getProjectOrigination() != null) res.add("projectOrigination");
		if(getIsOperationDepartment() != null) res.add("isOperationDepartment");
		if(getApplyEmployeeId() != null) res.add("applyEmployeeId");
		if(getCreateTimeStart() != null) res.add("createTimeStart");
		if(getCreateTimeEnd() != null) res.add("createTimeEnd");
		return res;
	}

	private Integer __process_status = null;
	private Integer __employee_id = null;
	private Integer __status = null;
	private Integer __process_type = null;
	private String __project_name = null;
	private Integer __project_type = null;
	private String __project_sales_team = null;
	private String __customer_name = null;
	private String __province = null;
	private String __city = null;
	private String __project_origination = null;
	private Boolean __is_operation_department = null;
	private Integer __apply_employee_id = null;
	private java.util.Date __create_time_start = null;
	private java.util.Date __create_time_end = null;
}

