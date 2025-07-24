package pomplatform.myProject.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectemployeeppedsesor extends GenericBase implements BaseFactory<BaseMprojectemployeeppedsesor>, Comparable<BaseMprojectemployeeppedsesor> 
{


	public static BaseMprojectemployeeppedsesor newInstance(){
		return new BaseMprojectemployeeppedsesor();
	}

	@Override
	public BaseMprojectemployeeppedsesor make(){
		BaseMprojectemployeeppedsesor b = new BaseMprojectemployeeppedsesor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_EMPLOYEE_ID = "project_employee_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DESIGN_PHASE = "design_phase" ;
	public final static java.lang.String CS_PLAN_WORK_HOURS = "plan_work_hours" ;
	public final static java.lang.String CS_REAL_WORK_HOURS = "real_work_hours" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_REAL_INTEGRAL = "real_integral" ;
	public final static java.lang.String CS_PLAN_START_DATE = "plan_start_date" ;
	public final static java.lang.String CS_PLAN_END_DATE = "plan_end_date" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_WORK_CONTENT = "work_content" ;
	public final static java.lang.String CS_ALTERNATE_FIELD1 = "alternate_field1" ;
	public final static java.lang.String CS_ALTERNATE_FIELD2 = "alternate_field2" ;
	public final static java.lang.String CS_ALTERNATE_FIELD3 = "alternate_field3" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_WORK_HOURS = "work_hours" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_PROGRESS = "project_progress" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_NAME = "project_manage_name" ;
	public final static java.lang.String CS_PROJECT_SIZE = "project_size" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_PROJECT_DESCRIPTION = "project_description" ;
	public final static java.lang.String CS_BUDGET = "budget" ;
	public final static java.lang.String CS_AUDIT_REASON = "audit_reason" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;

	public final static java.lang.String ALL_CAPTIONS = "项目组建编码,项目编码,员工编码,设计阶段,预估工时,实际工时,预分配积分,实际获得积分,项目计划开始日期,项目计划结束日期,开始日期,结束日期,工作内容,备用字段1,备用字段2,备用字段3,状态,合同编号,合同名称,客户名称,预估工时,归属部门,项目类型,项目编号,项目名称,项目进度,项目负责人编码,项目负责人姓名,项目大小,项目积分,项目描述,预算,审核意见,项目等级,板块负责人";

	public java.lang.Integer getProjectEmployeeId() {
		return this.__project_employee_id;
	}

	public void setProjectEmployeeId( java.lang.Integer value ) {
		this.__project_employee_id = value;
	}

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

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	public java.lang.String getPlanWorkHours() {
		return this.__plan_work_hours;
	}

	public void setPlanWorkHours( java.lang.String value ) {
		this.__plan_work_hours = value;
	}

	public java.lang.Integer getRealWorkHours() {
		return this.__real_work_hours;
	}

	public void setRealWorkHours( java.lang.Integer value ) {
		this.__real_work_hours = value;
	}

	public java.lang.String getPlanIntegral() {
		return this.__plan_integral;
	}

	public void setPlanIntegral( java.lang.String value ) {
		this.__plan_integral = value;
	}

	public java.math.BigDecimal getRealIntegral() {
		return this.__real_integral;
	}

	public void setRealIntegral( java.math.BigDecimal value ) {
		this.__real_integral = value;
	}

	public java.util.Date getPlanStartDate() {
		return this.__plan_start_date;
	}

	public void setPlanStartDate( java.util.Date value ) {
		this.__plan_start_date = value;
	}

	public java.util.Date getPlanEndDate() {
		return this.__plan_end_date;
	}

	public void setPlanEndDate( java.util.Date value ) {
		this.__plan_end_date = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.String getWorkContent() {
		return this.__work_content;
	}

	public void setWorkContent( java.lang.String value ) {
		this.__work_content = value;
	}

	public java.lang.String getAlternateField1() {
		return this.__alternate_field1;
	}

	public void setAlternateField1( java.lang.String value ) {
		this.__alternate_field1 = value;
	}

	public java.lang.String getAlternateField2() {
		return this.__alternate_field2;
	}

	public void setAlternateField2( java.lang.String value ) {
		this.__alternate_field2 = value;
	}

	public java.lang.String getAlternateField3() {
		return this.__alternate_field3;
	}

	public void setAlternateField3( java.lang.String value ) {
		this.__alternate_field3 = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getWorkHours() {
		return this.__work_hours;
	}

	public void setWorkHours( java.lang.String value ) {
		this.__work_hours = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
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

	public java.lang.String getProjectProgress() {
		return this.__project_progress;
	}

	public void setProjectProgress( java.lang.String value ) {
		this.__project_progress = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.String getProjectManageName() {
		return this.__project_manage_name;
	}

	public void setProjectManageName( java.lang.String value ) {
		this.__project_manage_name = value;
	}

	public java.lang.String getProjectSize() {
		return this.__project_size;
	}

	public void setProjectSize( java.lang.String value ) {
		this.__project_size = value;
	}

	public java.lang.String getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.lang.String value ) {
		this.__project_integral = value;
	}

	public java.lang.String getProjectDescription() {
		return this.__project_description;
	}

	public void setProjectDescription( java.lang.String value ) {
		this.__project_description = value;
	}

	public java.lang.String getBudget() {
		return this.__budget;
	}

	public void setBudget( java.lang.String value ) {
		this.__budget = value;
	}

	public java.lang.String getAuditReason() {
		return this.__audit_reason;
	}

	public void setAuditReason( java.lang.String value ) {
		this.__audit_reason = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public void cloneCopy(BaseMprojectemployeeppedsesor __bean){
		__bean.setProjectEmployeeId(getProjectEmployeeId());
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDesignPhase(getDesignPhase());
		__bean.setPlanWorkHours(getPlanWorkHours());
		__bean.setRealWorkHours(getRealWorkHours());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setRealIntegral(getRealIntegral());
		__bean.setPlanStartDate(getPlanStartDate());
		__bean.setPlanEndDate(getPlanEndDate());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setWorkContent(getWorkContent());
		__bean.setAlternateField1(getAlternateField1());
		__bean.setAlternateField2(getAlternateField2());
		__bean.setAlternateField3(getAlternateField3());
		__bean.setStatus(getStatus());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCustomerName(getCustomerName());
		__bean.setWorkHours(getWorkHours());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setProjectType(getProjectType());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setProjectProgress(getProjectProgress());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setProjectManageName(getProjectManageName());
		__bean.setProjectSize(getProjectSize());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setProjectDescription(getProjectDescription());
		__bean.setBudget(getBudget());
		__bean.setAuditReason(getAuditReason());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setDepartmentManagerId(getDepartmentManagerId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectEmployeeId() == null ? "" : getProjectEmployeeId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getDesignPhase() == null ? "" : getDesignPhase());
		sb.append(",");
		sb.append(getPlanWorkHours() == null ? "" : getPlanWorkHours());
		sb.append(",");
		sb.append(getRealWorkHours() == null ? "" : getRealWorkHours());
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getRealIntegral() == null ? "" : getRealIntegral());
		sb.append(",");
		sb.append(getPlanStartDate() == null ? "" : sdf.format(getPlanStartDate()));
		sb.append(",");
		sb.append(getPlanEndDate() == null ? "" : sdf.format(getPlanEndDate()));
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getWorkContent() == null ? "" : getWorkContent());
		sb.append(",");
		sb.append(getAlternateField1() == null ? "" : getAlternateField1());
		sb.append(",");
		sb.append(getAlternateField2() == null ? "" : getAlternateField2());
		sb.append(",");
		sb.append(getAlternateField3() == null ? "" : getAlternateField3());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getWorkHours() == null ? "" : getWorkHours());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectProgress() == null ? "" : getProjectProgress());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getProjectManageName() == null ? "" : getProjectManageName());
		sb.append(",");
		sb.append(getProjectSize() == null ? "" : getProjectSize());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getProjectDescription() == null ? "" : getProjectDescription());
		sb.append(",");
		sb.append(getBudget() == null ? "" : getBudget());
		sb.append(",");
		sb.append(getAuditReason() == null ? "" : getAuditReason());
		sb.append(",");
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
		sb.append(",");
		sb.append(getDepartmentManagerId() == null ? "" : getDepartmentManagerId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojectemployeeppedsesor o) {
		return __project_employee_id == null ? -1 : __project_employee_id.compareTo(o.getProjectEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__design_phase);
		hash = 97 * hash + Objects.hashCode(this.__plan_work_hours);
		hash = 97 * hash + Objects.hashCode(this.__real_work_hours);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__real_integral);
		hash = 97 * hash + Objects.hashCode(this.__plan_start_date);
		hash = 97 * hash + Objects.hashCode(this.__plan_end_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__work_content);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field1);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field2);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field3);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__work_hours);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_progress);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_name);
		hash = 97 * hash + Objects.hashCode(this.__project_size);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_description);
		hash = 97 * hash + Objects.hashCode(this.__budget);
		hash = 97 * hash + Objects.hashCode(this.__audit_reason);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__department_manager_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectemployeeppedsesor o = (BaseMprojectemployeeppedsesor)obj;
		if(!Objects.equals(this.__project_employee_id, o.getProjectEmployeeId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__design_phase, o.getDesignPhase())) return false;
		if(!Objects.equals(this.__plan_work_hours, o.getPlanWorkHours())) return false;
		if(!Objects.equals(this.__real_work_hours, o.getRealWorkHours())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__real_integral, o.getRealIntegral())) return false;
		if(!Objects.equals(this.__plan_start_date, o.getPlanStartDate())) return false;
		if(!Objects.equals(this.__plan_end_date, o.getPlanEndDate())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__work_content, o.getWorkContent())) return false;
		if(!Objects.equals(this.__alternate_field1, o.getAlternateField1())) return false;
		if(!Objects.equals(this.__alternate_field2, o.getAlternateField2())) return false;
		if(!Objects.equals(this.__alternate_field3, o.getAlternateField3())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__work_hours, o.getWorkHours())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_progress, o.getProjectProgress())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__project_manage_name, o.getProjectManageName())) return false;
		if(!Objects.equals(this.__project_size, o.getProjectSize())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__project_description, o.getProjectDescription())) return false;
		if(!Objects.equals(this.__budget, o.getBudget())) return false;
		if(!Objects.equals(this.__audit_reason, o.getAuditReason())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__department_manager_id, o.getDepartmentManagerId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectEmployeeId() != null) sb.append(__wrapNumber(count++, "projectEmployeeId", getProjectEmployeeId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(count++, "designPhase", getDesignPhase()));
		if(getPlanWorkHours() != null) sb.append(__wrapString(count++, "planWorkHours", getPlanWorkHours()));
		if(getRealWorkHours() != null) sb.append(__wrapNumber(count++, "realWorkHours", getRealWorkHours()));
		if(getPlanIntegral() != null) sb.append(__wrapString(count++, "planIntegral", getPlanIntegral()));
		if(getRealIntegral() != null) sb.append(__wrapDecimal(count++, "realIntegral", getRealIntegral()));
		if(getPlanStartDate() != null) sb.append(__wrapDate(count++, "planStartDate", getPlanStartDate()));
		if(getPlanEndDate() != null) sb.append(__wrapDate(count++, "planEndDate", getPlanEndDate()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getWorkContent() != null) sb.append(__wrapString(count++, "workContent", getWorkContent()));
		if(getAlternateField1() != null) sb.append(__wrapString(count++, "alternateField1", getAlternateField1()));
		if(getAlternateField2() != null) sb.append(__wrapString(count++, "alternateField2", getAlternateField2()));
		if(getAlternateField3() != null) sb.append(__wrapString(count++, "alternateField3", getAlternateField3()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getWorkHours() != null) sb.append(__wrapString(count++, "workHours", getWorkHours()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectProgress() != null) sb.append(__wrapString(count++, "projectProgress", getProjectProgress()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getProjectManageName() != null) sb.append(__wrapString(count++, "projectManageName", getProjectManageName()));
		if(getProjectSize() != null) sb.append(__wrapString(count++, "projectSize", getProjectSize()));
		if(getProjectIntegral() != null) sb.append(__wrapString(count++, "projectIntegral", getProjectIntegral()));
		if(getProjectDescription() != null) sb.append(__wrapString(count++, "projectDescription", getProjectDescription()));
		if(getBudget() != null) sb.append(__wrapString(count++, "budget", getBudget()));
		if(getAuditReason() != null) sb.append(__wrapString(count++, "auditReason", getAuditReason()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, "departmentManagerId", getDepartmentManagerId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectEmployeeId")) != null) setProjectEmployeeId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
		if((val = values.get("planWorkHours")) != null) setPlanWorkHours(__getString(val));
		if((val = values.get("realWorkHours")) != null) setRealWorkHours(__getInt(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getString(val));
		if((val = values.get("realIntegral")) != null) setRealIntegral(__getDecimal(val));  
		if((val = values.get("planStartDate")) != null) setPlanStartDate(__getDate(val)); 
		if((val = values.get("planEndDate")) != null) setPlanEndDate(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("workContent")) != null) setWorkContent(__getString(val));
		if((val = values.get("alternateField1")) != null) setAlternateField1(__getString(val));
		if((val = values.get("alternateField2")) != null) setAlternateField2(__getString(val));
		if((val = values.get("alternateField3")) != null) setAlternateField3(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("workHours")) != null) setWorkHours(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectProgress")) != null) setProjectProgress(__getString(val));
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("projectManageName")) != null) setProjectManageName(__getString(val));
		if((val = values.get("projectSize")) != null) setProjectSize(__getString(val));
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getString(val));
		if((val = values.get("projectDescription")) != null) setProjectDescription(__getString(val));
		if((val = values.get("budget")) != null) setBudget(__getString(val));
		if((val = values.get("auditReason")) != null) setAuditReason(__getString(val));
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_employee_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __design_phase ;
	protected java.lang.String  __plan_work_hours ;
	protected java.lang.Integer  __real_work_hours ;
	protected java.lang.String  __plan_integral ;
	protected java.math.BigDecimal  __real_integral ;
	protected java.util.Date  __plan_start_date ;
	protected java.util.Date  __plan_end_date ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.String  __work_content ;
	protected java.lang.String  __alternate_field1 ;
	protected java.lang.String  __alternate_field2 ;
	protected java.lang.String  __alternate_field3 ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __work_hours ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_progress ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.String  __project_manage_name ;
	protected java.lang.String  __project_size ;
	protected java.lang.String  __project_integral ;
	protected java.lang.String  __project_description ;
	protected java.lang.String  __budget ;
	protected java.lang.String  __audit_reason ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.Integer  __department_manager_id ;
}
