package pomplatform.departmentManagerProject.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMDepartmentManagerProject extends GenericBase implements BaseFactory<BaseMDepartmentManagerProject>, Comparable<BaseMDepartmentManagerProject> 
{


	public static BaseMDepartmentManagerProject newInstance(){
		return new BaseMDepartmentManagerProject();
	}

	@Override
	public BaseMDepartmentManagerProject make(){
		BaseMDepartmentManagerProject b = new BaseMDepartmentManagerProject();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_WORK_HOURS = "work_hours" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_DESIGN_PHASE = "design_phase" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PLAN_START_DATE = "plan_start_date" ;
	public final static java.lang.String CS_PLAN_END_DATE = "plan_end_date" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_STATUS = "status" ;
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
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_COMMON_AREA = "common_area" ;
	public final static java.lang.String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static java.lang.String CS_PERCENTAGE = "percentage" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_OLD_PROJECT_DISCOUNT = "old_project_discount" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_ELECTROMECHANICAL_TYPE = "electromechanical_type" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_OFFICE_TYPE = "office_type" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,合同编号,合同名称,客户名称,预估工时,归属部门,设计阶段,项目类型,项目编号,项目名称,项目计划开始日期,项目计划结束日期,项目开始日期,项目结束日期,项目状态,项目进度,项目经理,项目负责人姓名,项目大小,项目积分,项目描述,预算,审核意见,项目等级,板块负责人,板块,公区面积,后勤面积,核算比例,项目总积分,遗留项目折算,预留积分,机电类型,项目总金额,办公类型";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
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

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getCommonArea() {
		return this.__common_area;
	}

	public void setCommonArea( java.math.BigDecimal value ) {
		this.__common_area = value;
	}

	public java.math.BigDecimal getLogisticsArea() {
		return this.__logistics_area;
	}

	public void setLogisticsArea( java.math.BigDecimal value ) {
		this.__logistics_area = value;
	}

	public java.lang.String getPercentage() {
		return this.__percentage;
	}

	public void setPercentage( java.lang.String value ) {
		this.__percentage = value;
	}

	public java.lang.String getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.lang.String value ) {
		this.__total_integral = value;
	}

	public java.lang.Integer getOldProjectDiscount() {
		return this.__old_project_discount;
	}

	public void setOldProjectDiscount( java.lang.Integer value ) {
		this.__old_project_discount = value;
	}

	public java.lang.String getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.lang.String value ) {
		this.__reserve_integral = value;
	}

	public java.lang.Integer getElectromechanicalType() {
		return this.__electromechanical_type;
	}

	public void setElectromechanicalType( java.lang.Integer value ) {
		this.__electromechanical_type = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.lang.Integer getOfficeType() {
		return this.__office_type;
	}

	public void setOfficeType( java.lang.Integer value ) {
		this.__office_type = value;
	}

	public void cloneCopy(BaseMDepartmentManagerProject __bean){
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCustomerName(getCustomerName());
		__bean.setWorkHours(getWorkHours());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDesignPhase(getDesignPhase());
		__bean.setProjectType(getProjectType());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setPlanStartDate(getPlanStartDate());
		__bean.setPlanEndDate(getPlanEndDate());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setStatus(getStatus());
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
		__bean.setPlateId(getPlateId());
		__bean.setCommonArea(getCommonArea());
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setPercentage(getPercentage());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setOldProjectDiscount(getOldProjectDiscount());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setElectromechanicalType(getElectromechanicalType());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setOfficeType(getOfficeType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
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
		sb.append(getDesignPhase() == null ? "" : getDesignPhase());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getPlanStartDate() == null ? "" : sdf.format(getPlanStartDate()));
		sb.append(",");
		sb.append(getPlanEndDate() == null ? "" : sdf.format(getPlanEndDate()));
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
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
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getPercentage() == null ? "" : getPercentage());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getOldProjectDiscount() == null ? "" : getOldProjectDiscount());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getElectromechanicalType() == null ? "" : getElectromechanicalType());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getOfficeType() == null ? "" : getOfficeType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMDepartmentManagerProject o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__work_hours);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__design_phase);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__plan_start_date);
		hash = 97 * hash + Objects.hashCode(this.__plan_end_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__status);
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
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__percentage);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__old_project_discount);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__electromechanical_type);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__office_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMDepartmentManagerProject o = (BaseMDepartmentManagerProject)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__work_hours, o.getWorkHours())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__design_phase, o.getDesignPhase())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__plan_start_date, o.getPlanStartDate())) return false;
		if(!Objects.equals(this.__plan_end_date, o.getPlanEndDate())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
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
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__percentage, o.getPercentage())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__old_project_discount, o.getOldProjectDiscount())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__electromechanical_type, o.getElectromechanicalType())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__office_type, o.getOfficeType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getWorkHours() != null) sb.append(__wrapString(count++, "workHours", getWorkHours()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(count++, "designPhase", getDesignPhase()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getPlanStartDate() != null) sb.append(__wrapDate(count++, "planStartDate", getPlanStartDate()));
		if(getPlanEndDate() != null) sb.append(__wrapDate(count++, "planEndDate", getPlanEndDate()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
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
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, "commonArea", getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, "logisticsArea", getLogisticsArea()));
		if(getPercentage() != null) sb.append(__wrapString(count++, "percentage", getPercentage()));
		if(getTotalIntegral() != null) sb.append(__wrapString(count++, "totalIntegral", getTotalIntegral()));
		if(getOldProjectDiscount() != null) sb.append(__wrapNumber(count++, "oldProjectDiscount", getOldProjectDiscount()));
		if(getReserveIntegral() != null) sb.append(__wrapString(count++, "reserveIntegral", getReserveIntegral()));
		if(getElectromechanicalType() != null) sb.append(__wrapNumber(count++, "electromechanicalType", getElectromechanicalType()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getOfficeType() != null) sb.append(__wrapNumber(count++, "officeType", getOfficeType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("workHours")) != null) setWorkHours(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("planStartDate")) != null) setPlanStartDate(__getDate(val)); 
		if((val = values.get("planEndDate")) != null) setPlanEndDate(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
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
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("commonArea")) != null) setCommonArea(__getDecimal(val));  
		if((val = values.get("logisticsArea")) != null) setLogisticsArea(__getDecimal(val));  
		if((val = values.get("percentage")) != null) setPercentage(__getString(val));
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getString(val));
		if((val = values.get("oldProjectDiscount")) != null) setOldProjectDiscount(__getInt(val)); 
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getString(val));
		if((val = values.get("electromechanicalType")) != null) setElectromechanicalType(__getInt(val)); 
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("officeType")) != null) setOfficeType(__getInt(val)); 
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __work_hours ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __design_phase ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.util.Date  __plan_start_date ;
	protected java.util.Date  __plan_end_date ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __status ;
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
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.lang.String  __percentage ;
	protected java.lang.String  __total_integral ;
	protected java.lang.Integer  __old_project_discount ;
	protected java.lang.String  __reserve_integral ;
	protected java.lang.Integer  __electromechanical_type ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.lang.Integer  __office_type ;
}
