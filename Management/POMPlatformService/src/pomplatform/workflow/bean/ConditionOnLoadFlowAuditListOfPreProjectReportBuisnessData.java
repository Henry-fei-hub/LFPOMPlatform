package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadFlowAuditListOfPreProjectReportBuisnessData extends GenericCondition{

	public ConditionOnLoadFlowAuditListOfPreProjectReportBuisnessData(){
		setParameterCount(19);
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.String value ) {
		this.__project_type = value;
	}
	

	public java.lang.String getProjectSalesTeam() {
		return __project_sales_team;
	}

	public void setProjectSalesTeam(java.lang.String value) {
		this.__project_sales_team = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName(java.lang.String value) {
		this.__customer_name = value;
	}

	public java.lang.String getProvince() {
		return __province;
	}

	public void setProvince(java.lang.String value) {
		this.__province = value;
	}

	public java.lang.String getCity() {
		return __city;
	}

	public void setCity(java.lang.String value) {
		this.__city = value;
	}

	public java.lang.String getProjectOrigination() {
		return __project_origination;
	}

	public void setProjectOrigination(java.lang.String value) {
		this.__project_origination = value;
	}

	public java.lang.Boolean getIsOperationDepartment() {
		return __is_operation_department;
	}

	public void setIsOperationDepartment(java.lang.Boolean value) {
		this.__is_operation_department = value;
	}
	
	public java.lang.Integer getApplyEmployeeId() {
		return __apply_employee_id;
	}

	public void setApplyEmployeeId(java.lang.Integer value) {
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
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getProjectType() != null) sb.append(__wrapString(1, "projectType", getProjectType()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(1, "projectSalesTeam", getProjectSalesTeam()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getProvince() != null) sb.append(__wrapString(1, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(1, "city", getCity()));
		if(getProjectOrigination() != null) sb.append(__wrapString(1, "projectOrigination", getProjectOrigination()));
		if(getIsOperationDepartment() != null)sb.append(__wrapBoolean(1, "isOperationDepartment", getIsOperationDepartment()));
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
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
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

	private java.lang.Integer __process_status = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __process_type = null;
	private java.lang.Integer __company_id = null;
	private java.lang.String __employee_name = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __status = null;
	private java.lang.String __project_name = null;
	private java.lang.String __project_type = null;

	private java.lang.String __project_sales_team = null;
	private java.lang.String __customer_name = null;
	private java.lang.String __province = null;
	private java.lang.String __city = null;
	private java.lang.String __project_origination = null;
	private java.lang.Boolean __is_operation_department = null;
	private java.lang.Integer __apply_employee_id = null;
	private java.util.Date __create_time_start = null;
	private java.util.Date __create_time_end = null;
}

