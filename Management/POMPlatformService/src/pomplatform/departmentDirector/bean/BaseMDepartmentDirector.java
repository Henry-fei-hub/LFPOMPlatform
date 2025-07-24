package pomplatform.departmentDirector.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMDepartmentDirector extends GenericBase implements BaseFactory<BaseMDepartmentDirector>, Comparable<BaseMDepartmentDirector> 
{


	public static BaseMDepartmentDirector newInstance(){
		return new BaseMDepartmentDirector();
	}

	@Override
	public BaseMDepartmentDirector make(){
		BaseMDepartmentDirector b = new BaseMDepartmentDirector();
		return b;
	}

	public final static java.lang.String CS_COMMON_AREA = "common_area" ;
	public final static java.lang.String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static java.lang.String CS_PERCENTAGE = "percentage" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_BUDGET = "budget" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_WORK_HOURS = "work_hours" ;
	public final static java.lang.String CS_PROJECT_SIZE = "project_size" ;
	public final static java.lang.String CS_PLAN_START_DATE = "plan_start_date" ;
	public final static java.lang.String CS_PLAN_END_DATE = "plan_end_date" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PROJECT_FINISH_PERCENT = "project_finish_percent" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_TOTAL_FINISH_PERCENT = "total_finish_percent" ;
	public final static java.lang.String CS_PLATE_MANAGER_ID = "plate_manager_id" ;
	public final static java.lang.String CS_PROJECT_GRADE_TYPE = "project_grade_type" ;
	public final static java.lang.String CS_LAST_PERCENT = "last_percent" ;
	public final static java.lang.String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static java.lang.String CS_PROJECT_FLAG = "project_flag" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_LEFT_SURE_INTEGRAL = "left_sure_integral" ;
	public final static java.lang.String CS_PROGRESS_PERCENTAGE = "progress_percentage" ;
	public final static java.lang.String CS_PROJECT_FINISH_PERCENT_HAVETIME = "project_finish_percent_havetime" ;
	public final static java.lang.String CS_PLATE_SURE_INTEGRAL = "plate_sure_integral" ;
	public final static java.lang.String CS_LEFT_PLATE_SURE_INTEGRAL = "left_plate_sure_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "公区面积,后勤面积,核算比例,项目总积分,预留积分,预算,项目编号,项目名称,部门经理,专业负责人,项目类别,合同编号,,,项目积分,预估工时,项目大小,项目计划开始日期,项目计划结束日期,项目编码,项目状态,归属部门,项目完成百分比,是否为630项目，0是   1不是       默认值为0,项目总完成百分比,事业部负责人,2配合专业项目),上次结算时的百分比,投诉保证金,4投标项目),,,,,,";

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

	public java.math.BigDecimal getPercentage() {
		return this.__percentage;
	}

	public void setPercentage( java.math.BigDecimal value ) {
		this.__percentage = value;
	}

	public java.math.BigDecimal getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.math.BigDecimal value ) {
		this.__total_integral = value;
	}

	public java.math.BigDecimal getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.math.BigDecimal value ) {
		this.__reserve_integral = value;
	}

	public java.math.BigDecimal getBudget() {
		return this.__budget;
	}

	public void setBudget( java.math.BigDecimal value ) {
		this.__budget = value;
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

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
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

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.lang.Integer getWorkHours() {
		return this.__work_hours;
	}

	public void setWorkHours( java.lang.Integer value ) {
		this.__work_hours = value;
	}

	public java.lang.String getProjectSize() {
		return this.__project_size;
	}

	public void setProjectSize( java.lang.String value ) {
		this.__project_size = value;
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

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getProjectFinishPercent() {
		return this.__project_finish_percent;
	}

	public void setProjectFinishPercent( java.math.BigDecimal value ) {
		this.__project_finish_percent = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.math.BigDecimal getTotalFinishPercent() {
		return this.__total_finish_percent;
	}

	public void setTotalFinishPercent( java.math.BigDecimal value ) {
		this.__total_finish_percent = value;
	}

	public java.lang.Integer getPlateManagerId() {
		return this.__plate_manager_id;
	}

	public void setPlateManagerId( java.lang.Integer value ) {
		this.__plate_manager_id = value;
	}

	public java.lang.Integer getProjectGradeType() {
		return this.__project_grade_type;
	}

	public void setProjectGradeType( java.lang.Integer value ) {
		this.__project_grade_type = value;
	}

	public java.math.BigDecimal getLastPercent() {
		return this.__last_percent;
	}

	public void setLastPercent( java.math.BigDecimal value ) {
		this.__last_percent = value;
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return this.__complaint_integral;
	}

	public void setComplaintIntegral( java.math.BigDecimal value ) {
		this.__complaint_integral = value;
	}

	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getLeftSureIntegral() {
		return this.__left_sure_integral;
	}

	public void setLeftSureIntegral( java.math.BigDecimal value ) {
		this.__left_sure_integral = value;
	}

	public java.math.BigDecimal getProgressPercentage() {
		return this.__progress_percentage;
	}

	public void setProgressPercentage( java.math.BigDecimal value ) {
		this.__progress_percentage = value;
	}

	public java.math.BigDecimal getProjectFinishPercentHavetime() {
		return this.__project_finish_percent_havetime;
	}

	public void setProjectFinishPercentHavetime( java.math.BigDecimal value ) {
		this.__project_finish_percent_havetime = value;
	}

	public java.math.BigDecimal getPlateSureIntegral() {
		return this.__plate_sure_integral;
	}

	public void setPlateSureIntegral( java.math.BigDecimal value ) {
		this.__plate_sure_integral = value;
	}

	public java.math.BigDecimal getLeftPlateSureIntegral() {
		return this.__left_plate_sure_integral;
	}

	public void setLeftPlateSureIntegral( java.math.BigDecimal value ) {
		this.__left_plate_sure_integral = value;
	}

	public void cloneCopy(BaseMDepartmentDirector __bean){
		__bean.setCommonArea(getCommonArea());
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setPercentage(getPercentage());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setBudget(getBudget());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setDepartmentManagerId(getDepartmentManagerId());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setProjectType(getProjectType());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCustomerName(getCustomerName());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setWorkHours(getWorkHours());
		__bean.setProjectSize(getProjectSize());
		__bean.setPlanStartDate(getPlanStartDate());
		__bean.setPlanEndDate(getPlanEndDate());
		__bean.setProjectId(getProjectId());
		__bean.setStatus(getStatus());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setProjectFinishPercent(getProjectFinishPercent());
		__bean.setParentId(getParentId());
		__bean.setTotalFinishPercent(getTotalFinishPercent());
		__bean.setPlateManagerId(getPlateManagerId());
		__bean.setProjectGradeType(getProjectGradeType());
		__bean.setLastPercent(getLastPercent());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setProjectFlag(getProjectFlag());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setLeftSureIntegral(getLeftSureIntegral());
		__bean.setProgressPercentage(getProgressPercentage());
		__bean.setProjectFinishPercentHavetime(getProjectFinishPercentHavetime());
		__bean.setPlateSureIntegral(getPlateSureIntegral());
		__bean.setLeftPlateSureIntegral(getLeftPlateSureIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getPercentage() == null ? "" : getPercentage());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getBudget() == null ? "" : getBudget());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getDepartmentManagerId() == null ? "" : getDepartmentManagerId());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getWorkHours() == null ? "" : getWorkHours());
		sb.append(",");
		sb.append(getProjectSize() == null ? "" : getProjectSize());
		sb.append(",");
		sb.append(getPlanStartDate() == null ? "" : sdf.format(getPlanStartDate()));
		sb.append(",");
		sb.append(getPlanEndDate() == null ? "" : sdf.format(getPlanEndDate()));
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getProjectFinishPercent() == null ? "" : getProjectFinishPercent());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getTotalFinishPercent() == null ? "" : getTotalFinishPercent());
		sb.append(",");
		sb.append(getPlateManagerId() == null ? "" : getPlateManagerId());
		sb.append(",");
		sb.append(getProjectGradeType() == null ? "" : getProjectGradeType());
		sb.append(",");
		sb.append(getLastPercent() == null ? "" : getLastPercent());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getProjectFlag() == null ? "" : getProjectFlag());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getLeftSureIntegral() == null ? "" : getLeftSureIntegral());
		sb.append(",");
		sb.append(getProgressPercentage() == null ? "" : getProgressPercentage());
		sb.append(",");
		sb.append(getProjectFinishPercentHavetime() == null ? "" : getProjectFinishPercentHavetime());
		sb.append(",");
		sb.append(getPlateSureIntegral() == null ? "" : getPlateSureIntegral());
		sb.append(",");
		sb.append(getLeftPlateSureIntegral() == null ? "" : getLeftPlateSureIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMDepartmentDirector o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__percentage);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__budget);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__department_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__work_hours);
		hash = 97 * hash + Objects.hashCode(this.__project_size);
		hash = 97 * hash + Objects.hashCode(this.__plan_start_date);
		hash = 97 * hash + Objects.hashCode(this.__plan_end_date);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__project_finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__total_finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__project_grade_type);
		hash = 97 * hash + Objects.hashCode(this.__last_percent);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_flag);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__progress_percentage);
		hash = 97 * hash + Objects.hashCode(this.__project_finish_percent_havetime);
		hash = 97 * hash + Objects.hashCode(this.__plate_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_plate_sure_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMDepartmentDirector o = (BaseMDepartmentDirector)obj;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__percentage, o.getPercentage())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__budget, o.getBudget())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__department_manager_id, o.getDepartmentManagerId())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__work_hours, o.getWorkHours())) return false;
		if(!Objects.equals(this.__project_size, o.getProjectSize())) return false;
		if(!Objects.equals(this.__plan_start_date, o.getPlanStartDate())) return false;
		if(!Objects.equals(this.__plan_end_date, o.getPlanEndDate())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__project_finish_percent, o.getProjectFinishPercent())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__total_finish_percent, o.getTotalFinishPercent())) return false;
		if(!Objects.equals(this.__plate_manager_id, o.getPlateManagerId())) return false;
		if(!Objects.equals(this.__project_grade_type, o.getProjectGradeType())) return false;
		if(!Objects.equals(this.__last_percent, o.getLastPercent())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__project_flag, o.getProjectFlag())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__left_sure_integral, o.getLeftSureIntegral())) return false;
		if(!Objects.equals(this.__progress_percentage, o.getProgressPercentage())) return false;
		if(!Objects.equals(this.__project_finish_percent_havetime, o.getProjectFinishPercentHavetime())) return false;
		if(!Objects.equals(this.__plate_sure_integral, o.getPlateSureIntegral())) return false;
		if(!Objects.equals(this.__left_plate_sure_integral, o.getLeftPlateSureIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, "commonArea", getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, "logisticsArea", getLogisticsArea()));
		if(getPercentage() != null) sb.append(__wrapDecimal(count++, "percentage", getPercentage()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getBudget() != null) sb.append(__wrapDecimal(count++, "budget", getBudget()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, "departmentManagerId", getDepartmentManagerId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getWorkHours() != null) sb.append(__wrapNumber(count++, "workHours", getWorkHours()));
		if(getProjectSize() != null) sb.append(__wrapString(count++, "projectSize", getProjectSize()));
		if(getPlanStartDate() != null) sb.append(__wrapDate(count++, "planStartDate", getPlanStartDate()));
		if(getPlanEndDate() != null) sb.append(__wrapDate(count++, "planEndDate", getPlanEndDate()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getProjectFinishPercent() != null) sb.append(__wrapDecimal(count++, "projectFinishPercent", getProjectFinishPercent()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getTotalFinishPercent() != null) sb.append(__wrapDecimal(count++, "totalFinishPercent", getTotalFinishPercent()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, "plateManagerId", getPlateManagerId()));
		if(getProjectGradeType() != null) sb.append(__wrapNumber(count++, "projectGradeType", getProjectGradeType()));
		if(getLastPercent() != null) sb.append(__wrapDecimal(count++, "lastPercent", getLastPercent()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "complaintIntegral", getComplaintIntegral()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(count++, "projectFlag", getProjectFlag()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getLeftSureIntegral() != null) sb.append(__wrapDecimal(count++, "leftSureIntegral", getLeftSureIntegral()));
		if(getProgressPercentage() != null) sb.append(__wrapDecimal(count++, "progressPercentage", getProgressPercentage()));
		if(getProjectFinishPercentHavetime() != null) sb.append(__wrapDecimal(count++, "projectFinishPercentHavetime", getProjectFinishPercentHavetime()));
		if(getPlateSureIntegral() != null) sb.append(__wrapDecimal(count++, "plateSureIntegral", getPlateSureIntegral()));
		if(getLeftPlateSureIntegral() != null) sb.append(__wrapDecimal(count++, "leftPlateSureIntegral", getLeftPlateSureIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("commonArea")) != null) setCommonArea(__getDecimal(val));  
		if((val = values.get("logisticsArea")) != null) setLogisticsArea(__getDecimal(val));  
		if((val = values.get("percentage")) != null) setPercentage(__getDecimal(val));  
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("budget")) != null) setBudget(__getDecimal(val));  
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("workHours")) != null) setWorkHours(__getInt(val)); 
		if((val = values.get("projectSize")) != null) setProjectSize(__getString(val));
		if((val = values.get("planStartDate")) != null) setPlanStartDate(__getDate(val)); 
		if((val = values.get("planEndDate")) != null) setPlanEndDate(__getDate(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("projectFinishPercent")) != null) setProjectFinishPercent(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("totalFinishPercent")) != null) setTotalFinishPercent(__getDecimal(val));  
		if((val = values.get("plateManagerId")) != null) setPlateManagerId(__getInt(val)); 
		if((val = values.get("projectGradeType")) != null) setProjectGradeType(__getInt(val)); 
		if((val = values.get("lastPercent")) != null) setLastPercent(__getDecimal(val));  
		if((val = values.get("complaintIntegral")) != null) setComplaintIntegral(__getDecimal(val));  
		if((val = values.get("projectFlag")) != null) setProjectFlag(__getInt(val)); 
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("leftSureIntegral")) != null) setLeftSureIntegral(__getDecimal(val));  
		if((val = values.get("progressPercentage")) != null) setProgressPercentage(__getDecimal(val));  
		if((val = values.get("projectFinishPercentHavetime")) != null) setProjectFinishPercentHavetime(__getDecimal(val));  
		if((val = values.get("plateSureIntegral")) != null) setPlateSureIntegral(__getDecimal(val));  
		if((val = values.get("leftPlateSureIntegral")) != null) setLeftPlateSureIntegral(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __percentage ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __budget ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __department_manager_id ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __customer_name ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.lang.Integer  __work_hours ;
	protected java.lang.String  __project_size ;
	protected java.util.Date  __plan_start_date ;
	protected java.util.Date  __plan_end_date ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __project_finish_percent ;
	protected java.lang.Integer  __parent_id ;
	protected java.math.BigDecimal  __total_finish_percent ;
	protected java.lang.Integer  __plate_manager_id ;
	protected java.lang.Integer  __project_grade_type ;
	protected java.math.BigDecimal  __last_percent ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.lang.Integer  __project_flag ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __left_sure_integral ;
	protected java.math.BigDecimal  __progress_percentage ;
	protected java.math.BigDecimal  __project_finish_percent_havetime ;
	protected java.math.BigDecimal  __plate_sure_integral ;
	protected java.math.BigDecimal  __left_plate_sure_integral ;
}
