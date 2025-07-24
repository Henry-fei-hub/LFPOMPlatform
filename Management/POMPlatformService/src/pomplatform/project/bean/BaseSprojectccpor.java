package pomplatform.project.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectccpor extends GenericBase implements BaseFactory<BaseSprojectccpor>, Comparable<BaseSprojectccpor> 
{


	public static BaseSprojectccpor newInstance(){
		return new BaseSprojectccpor();
	}

	@Override
	public BaseSprojectccpor make(){
		BaseSprojectccpor b = new BaseSprojectccpor();
		return b;
	}

	public final static java.lang.String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static java.lang.String CS_COMMON_AREA = "common_area" ;
	public final static java.lang.String CS_PERCENTAGE = "percentage" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
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
	public final static java.lang.String CS_PROJECT_SIZE = "project_size" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_PROJECT_DESCRIPTION = "project_description" ;
	public final static java.lang.String CS_BUDGET = "budget" ;
	public final static java.lang.String CS_AUDIT_REASON = "audit_reason" ;
	public final static java.lang.String CS_DESIGN_TYPE = "design_type" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_OLD_PROJECT_DISCOUNT = "old_project_discount" ;
	public final static java.lang.String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_FINISH_PERCENT = "project_finish_percent" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_TOTAL_FINISH_PERCENT = "total_finish_percent" ;
	public final static java.lang.String CS_PLATE_MANAGER_ID = "plate_manager_id" ;
	public final static java.lang.String CS_PROJECT_GRADE_TYPE = "project_grade_type" ;
	public final static java.lang.String CS_LAST_PERCENT = "last_percent" ;
	public final static java.lang.String CS_PROJECT_FLAG = "project_flag" ;
	public final static java.lang.String CS_IS_ECMC_PROJECT = "is_ecmc_project" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_IS_LOCK = "is_lock" ;
	public final static java.lang.String CS_PROJECT_PERFORMANCE_ID = "project_performance_id" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_LEFT_SURE_INTEGRAL = "left_sure_integral" ;
	public final static java.lang.String CS_PROGRESS_PERCENTAGE = "progress_percentage" ;
	public final static java.lang.String CS_PROJECT_FINISH_PERCENT_HAVETIME = "project_finish_percent_havetime" ;
	public final static java.lang.String CS_PLATE_SURE_INTEGRAL = "plate_sure_integral" ;
	public final static java.lang.String CS_LEFT_PLATE_SURE_INTEGRAL = "left_plate_sure_integral" ;
	public final static java.lang.String CS_MSG_COUNT = "msg_count" ;
	public final static java.lang.String CS_MSG_STATUS = "msg_status" ;
	public final static java.lang.String CS_EMPLOYEE_NAME_TOSTRING = "employee_name_tostring" ;
	public final static java.lang.String CS_PERCENT_SUM = "percent_sum" ;
	public final static java.lang.String CS_PRE_PROJECT_TYPE = "pre_project_type" ;
	public final static java.lang.String ALL_CAPTIONS = "后勤面积,公区面积,核算比例,项目总积分,预留积分,项目编码,合同编号,预估工时,归属部门,设计阶段,项目类别,项目编号,项目名称,项目计划开始日期,项目计划结束日期,项目开始日期,项目结束日期,结算状态,项目进度,专业负责人,项目大小,项目积分,项目描述,预算,审核意见,设计类别,确认积分,项目等级,遗留项目折算,部门经理,合同编码,业务部门,项目完成百分比,是否为630项目，0是   1不是       默认值为0,项目总完成百分比,板块负责人,2配合专业项目),上次结算时的百分比,2研发项目),true是,合同金额,是否加锁,主键编码,确认积分,剩余确认积分,项目进度百分比(%),项目进度比(%),部门确认积分,部门剩余确认积分,消息推送次数,消息状态,项目经理";

	public java.math.BigDecimal getLogisticsArea() {
		return this.__logistics_area;
	}

	public void setLogisticsArea( java.math.BigDecimal value ) {
		this.__logistics_area = value;
	}

	public java.math.BigDecimal getCommonArea() {
		return this.__common_area;
	}

	public void setCommonArea( java.math.BigDecimal value ) {
		this.__common_area = value;
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

	public java.lang.Integer getWorkHours() {
		return this.__work_hours;
	}

	public void setWorkHours( java.lang.Integer value ) {
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

	public java.lang.String getProjectSize() {
		return this.__project_size;
	}

	public void setProjectSize( java.lang.String value ) {
		this.__project_size = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.lang.String getProjectDescription() {
		return this.__project_description;
	}

	public void setProjectDescription( java.lang.String value ) {
		this.__project_description = value;
	}

	public java.math.BigDecimal getBudget() {
		return this.__budget;
	}

	public void setBudget( java.math.BigDecimal value ) {
		this.__budget = value;
	}

	public java.lang.String getAuditReason() {
		return this.__audit_reason;
	}

	public void setAuditReason( java.lang.String value ) {
		this.__audit_reason = value;
	}

	public java.lang.Integer getDesignType() {
		return this.__design_type;
	}

	public void setDesignType( java.lang.Integer value ) {
		this.__design_type = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.math.BigDecimal getOldProjectDiscount() {
		return this.__old_project_discount;
	}

	public void setOldProjectDiscount( java.math.BigDecimal value ) {
		this.__old_project_discount = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}

	public java.lang.Boolean getIsEcmcProject() {
		return this.__is_ecmc_project;
	}

	public void setIsEcmcProject( java.lang.Boolean value ) {
		this.__is_ecmc_project = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.lang.Boolean getIsLock() {
		return this.__is_lock;
	}

	public void setIsLock( java.lang.Boolean value ) {
		this.__is_lock = value;
	}

	public java.lang.Integer getProjectPerformanceId() {
		return this.__project_performance_id;
	}

	public void setProjectPerformanceId( java.lang.Integer value ) {
		this.__project_performance_id = value;
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
	
	public java.lang.Integer getMsgCount() {
		return this.__msg_count;
	}

	public void setMsgCount( java.lang.Integer value ) {
		this.__msg_count = value;
	}

	public java.lang.Integer getMsgStatus() {
		return this.__msg_status;
	}

	public void setMsgStatus( java.lang.Integer value ) {
		this.__msg_status = value;
	}
	public java.lang.String getEmployeeNameTostring() {
		return this.__employee_name_tostring;
	}

	public void setEmployeeNameTostring( java.lang.String value ) {
		this.__employee_name_tostring = value;
	}
	
	public java.lang.Integer getPreProjectType() {
		return this.__pre_project_type;
	}

	public void setPreProjectType( java.lang.Integer value ) {
		this.__pre_project_type = value;
	}
	
	public java.math.BigDecimal getPercentSum() {
		return this.__percent_sum;
	}

	public void setPercentSum( java.math.BigDecimal value ) {
		this.__percent_sum = value;
	}

	public void cloneCopy(BaseSprojectccpor __bean){
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setCommonArea(getCommonArea());
		__bean.setPercentage(getPercentage());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
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
		__bean.setProjectSize(getProjectSize());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setProjectDescription(getProjectDescription());
		__bean.setBudget(getBudget());
		__bean.setAuditReason(getAuditReason());
		__bean.setDesignType(getDesignType());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setOldProjectDiscount(getOldProjectDiscount());
		__bean.setDepartmentManagerId(getDepartmentManagerId());
		__bean.setContractId(getContractId());
		__bean.setPlateId(getPlateId());
		__bean.setProjectFinishPercent(getProjectFinishPercent());
		__bean.setParentId(getParentId());
		__bean.setTotalFinishPercent(getTotalFinishPercent());
		__bean.setPlateManagerId(getPlateManagerId());
		__bean.setProjectGradeType(getProjectGradeType());
		__bean.setLastPercent(getLastPercent());
		__bean.setProjectFlag(getProjectFlag());
		__bean.setIsEcmcProject(getIsEcmcProject());
		__bean.setMoneySum(getMoneySum());
		__bean.setIsLock(getIsLock());
		__bean.setProjectPerformanceId(getProjectPerformanceId());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setLeftSureIntegral(getLeftSureIntegral());
		__bean.setProgressPercentage(getProgressPercentage());
		__bean.setProjectFinishPercentHavetime(getProjectFinishPercentHavetime());
		__bean.setPlateSureIntegral(getPlateSureIntegral());
		__bean.setLeftPlateSureIntegral(getLeftPlateSureIntegral());
		__bean.setMsgCount(getMsgCount());
		__bean.setMsgStatus(getMsgStatus());
		__bean.setEmployeeNameTostring(getEmployeeNameTostring());
		__bean.setPercentSum(getPercentSum());
		__bean.setPreProjectType(getPreProjectType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getPercentage() == null ? "" : getPercentage());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getWorkHours() == null ? "" : getWorkHours());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getDesignPhase() == null ? "" : getDesignPhase());
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_32", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
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
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_61", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getProjectProgress() == null ? "" : getProjectProgress());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
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
		sb.append(getDesignType() == null ? "" : getDesignType());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		String strProjectLevel = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getProjectLevel()));
		sb.append(strProjectLevel == null ? "" : strProjectLevel);
		sb.append(",");
		sb.append(getOldProjectDiscount() == null ? "" : getOldProjectDiscount());
		sb.append(",");
		sb.append(getDepartmentManagerId() == null ? "" : getDepartmentManagerId());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getProjectFinishPercent() == null ? "" : getProjectFinishPercent());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getTotalFinishPercent() == null ? "" : getTotalFinishPercent());
		sb.append(",");
		sb.append(getPlateManagerId() == null ? "" : getPlateManagerId());
		sb.append(",");
		sb.append(getProjectGradeType() == null ? "" : getProjectGradeType());
		sb.append(",");
		sb.append(getLastPercent() == null ? "" : getLastPercent());
		sb.append(",");
		sb.append(getProjectFlag() == null ? "" : getProjectFlag());
		sb.append(",");
		sb.append(getIsEcmcProject() == null ? "" : getIsEcmcProject());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getIsLock() == null ? "" : getIsLock());
		sb.append(",");
		sb.append(getProjectPerformanceId() == null ? "" : getProjectPerformanceId());
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
		sb.append(",");
		sb.append(getMsgCount() == null ? "" : getMsgCount());
		sb.append(",");
		String msgStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_243", String.valueOf(getMsgStatus()));
		sb.append(msgStatus == null ? "" : msgStatus);
		sb.append(",");
		sb.append(getEmployeeNameTostring() == null ? "" : getEmployeeNameTostring());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectccpor o) {
		return __project_performance_id == null ? -1 : __project_performance_id.compareTo(o.getProjectPerformanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__percentage);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
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
		hash = 97 * hash + Objects.hashCode(this.__project_size);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_description);
		hash = 97 * hash + Objects.hashCode(this.__budget);
		hash = 97 * hash + Objects.hashCode(this.__audit_reason);
		hash = 97 * hash + Objects.hashCode(this.__design_type);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__old_project_discount);
		hash = 97 * hash + Objects.hashCode(this.__department_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__total_finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__project_grade_type);
		hash = 97 * hash + Objects.hashCode(this.__last_percent);
		hash = 97 * hash + Objects.hashCode(this.__project_flag);
		hash = 97 * hash + Objects.hashCode(this.__is_ecmc_project);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__is_lock);
		hash = 97 * hash + Objects.hashCode(this.__project_performance_id);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__progress_percentage);
		hash = 97 * hash + Objects.hashCode(this.__project_finish_percent_havetime);
		hash = 97 * hash + Objects.hashCode(this.__plate_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_plate_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__msg_count);
		hash = 97 * hash + Objects.hashCode(this.__msg_status);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_tostring);
		hash = 97 * hash + Objects.hashCode(this.__percent_sum);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectccpor o = (BaseSprojectccpor)obj;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__percentage, o.getPercentage())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
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
		if(!Objects.equals(this.__project_size, o.getProjectSize())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__project_description, o.getProjectDescription())) return false;
		if(!Objects.equals(this.__budget, o.getBudget())) return false;
		if(!Objects.equals(this.__audit_reason, o.getAuditReason())) return false;
		if(!Objects.equals(this.__design_type, o.getDesignType())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__old_project_discount, o.getOldProjectDiscount())) return false;
		if(!Objects.equals(this.__department_manager_id, o.getDepartmentManagerId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_finish_percent, o.getProjectFinishPercent())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__total_finish_percent, o.getTotalFinishPercent())) return false;
		if(!Objects.equals(this.__plate_manager_id, o.getPlateManagerId())) return false;
		if(!Objects.equals(this.__project_grade_type, o.getProjectGradeType())) return false;
		if(!Objects.equals(this.__last_percent, o.getLastPercent())) return false;
		if(!Objects.equals(this.__project_flag, o.getProjectFlag())) return false;
		if(!Objects.equals(this.__is_ecmc_project, o.getIsEcmcProject())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__is_lock, o.getIsLock())) return false;
		if(!Objects.equals(this.__project_performance_id, o.getProjectPerformanceId())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__left_sure_integral, o.getLeftSureIntegral())) return false;
		if(!Objects.equals(this.__progress_percentage, o.getProgressPercentage())) return false;
		if(!Objects.equals(this.__project_finish_percent_havetime, o.getProjectFinishPercentHavetime())) return false;
		if(!Objects.equals(this.__plate_sure_integral, o.getPlateSureIntegral())) return false;
		if(!Objects.equals(this.__left_plate_sure_integral, o.getLeftPlateSureIntegral())) return false;
		if(!Objects.equals(this.__msg_count, o.getMsgCount())) return false;
		if(!Objects.equals(this.__msg_status, o.getMsgStatus())) return false;
		if(!Objects.equals(this.__employee_name_tostring, o.getEmployeeNameTostring())) return false;
		if(!Objects.equals(this.__percent_sum, o.getPercentSum())) return false;
		if(!Objects.equals(this.__pre_project_type, o.getPreProjectType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, "logisticsArea", getLogisticsArea()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, "commonArea", getCommonArea()));
		if(getPercentage() != null) sb.append(__wrapDecimal(count++, "percentage", getPercentage()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getWorkHours() != null) sb.append(__wrapNumber(count++, "workHours", getWorkHours()));
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
		if(getProjectSize() != null) sb.append(__wrapString(count++, "projectSize", getProjectSize()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getProjectDescription() != null) sb.append(__wrapString(count++, "projectDescription", getProjectDescription()));
		if(getBudget() != null) sb.append(__wrapDecimal(count++, "budget", getBudget()));
		if(getAuditReason() != null) sb.append(__wrapString(count++, "auditReason", getAuditReason()));
		if(getDesignType() != null) sb.append(__wrapNumber(count++, "designType", getDesignType()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getOldProjectDiscount() != null) sb.append(__wrapDecimal(count++, "oldProjectDiscount", getOldProjectDiscount()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, "departmentManagerId", getDepartmentManagerId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectFinishPercent() != null) sb.append(__wrapDecimal(count++, "projectFinishPercent", getProjectFinishPercent()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getTotalFinishPercent() != null) sb.append(__wrapDecimal(count++, "totalFinishPercent", getTotalFinishPercent()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, "plateManagerId", getPlateManagerId()));
		if(getProjectGradeType() != null) sb.append(__wrapNumber(count++, "projectGradeType", getProjectGradeType()));
		if(getLastPercent() != null) sb.append(__wrapDecimal(count++, "lastPercent", getLastPercent()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(count++, "projectFlag", getProjectFlag()));
		if(getIsEcmcProject() != null) sb.append(__wrapBoolean(count++, "isEcmcProject", getIsEcmcProject()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getIsLock() != null) sb.append(__wrapBoolean(count++, "isLock", getIsLock()));
		if(getProjectPerformanceId() != null) sb.append(__wrapNumber(count++, "projectPerformanceId", getProjectPerformanceId()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getLeftSureIntegral() != null) sb.append(__wrapDecimal(count++, "leftSureIntegral", getLeftSureIntegral()));
		if(getProgressPercentage() != null) sb.append(__wrapDecimal(count++, "progressPercentage", getProgressPercentage()));
		if(getProjectFinishPercentHavetime() != null) sb.append(__wrapDecimal(count++, "projectFinishPercentHavetime", getProjectFinishPercentHavetime()));
		if(getPlateSureIntegral() != null) sb.append(__wrapDecimal(count++, "plateSureIntegral", getPlateSureIntegral()));
		if(getLeftPlateSureIntegral() != null) sb.append(__wrapDecimal(count++, "leftPlateSureIntegral", getLeftPlateSureIntegral()));
		if(getMsgCount() != null) sb.append(__wrapNumber(count++, "msgCount", getMsgCount()));
		if(getMsgStatus() != null) sb.append(__wrapNumber(count++, "msgStatus", getMsgStatus()));
		if(getEmployeeNameTostring() != null) sb.append(__wrapString(count++, "employeeNameTostring", getEmployeeNameTostring()));
		if(getPercentSum() != null) sb.append(__wrapDecimal(count++, "percentSum", getPercentSum()));
		if(getPreProjectType() != null) sb.append(__wrapNumber(count++, "preProjectType", getPreProjectType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("logisticsArea")) != null) setLogisticsArea(__getDecimal(val));  
		if((val = values.get("commonArea")) != null) setCommonArea(__getDecimal(val));  
		if((val = values.get("percentage")) != null) setPercentage(__getDecimal(val));  
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("workHours")) != null) setWorkHours(__getInt(val)); 
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
		if((val = values.get("projectSize")) != null) setProjectSize(__getString(val));
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("projectDescription")) != null) setProjectDescription(__getString(val));
		if((val = values.get("budget")) != null) setBudget(__getDecimal(val));  
		if((val = values.get("auditReason")) != null) setAuditReason(__getString(val));
		if((val = values.get("designType")) != null) setDesignType(__getInt(val)); 
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("oldProjectDiscount")) != null) setOldProjectDiscount(__getDecimal(val));  
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectFinishPercent")) != null) setProjectFinishPercent(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("totalFinishPercent")) != null) setTotalFinishPercent(__getDecimal(val));  
		if((val = values.get("plateManagerId")) != null) setPlateManagerId(__getInt(val)); 
		if((val = values.get("projectGradeType")) != null) setProjectGradeType(__getInt(val)); 
		if((val = values.get("lastPercent")) != null) setLastPercent(__getDecimal(val));  
		if((val = values.get("projectFlag")) != null) setProjectFlag(__getInt(val)); 
		if((val = values.get("isEcmcProject")) != null) setIsEcmcProject(__getBoolean(val));
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("isLock")) != null) setIsLock(__getBoolean(val));
		if((val = values.get("projectPerformanceId")) != null) setProjectPerformanceId(__getInt(val)); 
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("leftSureIntegral")) != null) setLeftSureIntegral(__getDecimal(val));  
		if((val = values.get("progressPercentage")) != null) setProgressPercentage(__getDecimal(val));  
		if((val = values.get("projectFinishPercentHavetime")) != null) setProjectFinishPercentHavetime(__getDecimal(val));  
		if((val = values.get("plateSureIntegral")) != null) setPlateSureIntegral(__getDecimal(val));  
		if((val = values.get("leftPlateSureIntegral")) != null) setLeftPlateSureIntegral(__getDecimal(val));  
		if((val = values.get("msgCount")) != null) setMsgCount(__getInt(val)); 
		if((val = values.get("msgStatus")) != null) setMsgStatus(__getInt(val));
		if((val = values.get("employeeNameTostring")) != null) setEmployeeNameTostring(__getString(val));
		if((val = values.get("employeeNameTostring")) != null) setEmployeeNameTostring(__getString(val));
		if((val = values.get("percentSum")) != null) setPercentSum(__getDecimal(val));
	}

	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __percentage ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __work_hours ;
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
	protected java.lang.String  __project_size ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.lang.String  __project_description ;
	protected java.math.BigDecimal  __budget ;
	protected java.lang.String  __audit_reason ;
	protected java.lang.Integer  __design_type ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.lang.Integer  __project_level ;
	protected java.math.BigDecimal  __old_project_discount ;
	protected java.lang.Integer  __department_manager_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __project_finish_percent ;
	protected java.lang.Integer  __parent_id ;
	protected java.math.BigDecimal  __total_finish_percent ;
	protected java.lang.Integer  __plate_manager_id ;
	protected java.lang.Integer  __project_grade_type ;
	protected java.math.BigDecimal  __last_percent ;
	protected java.lang.Integer  __project_flag ;
	protected java.lang.Boolean  __is_ecmc_project ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.lang.Boolean  __is_lock ;
	protected java.lang.Integer  __project_performance_id ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __left_sure_integral ;
	protected java.math.BigDecimal  __progress_percentage ;
	protected java.math.BigDecimal  __project_finish_percent_havetime ;
	protected java.math.BigDecimal  __plate_sure_integral ;
	protected java.math.BigDecimal  __left_plate_sure_integral ;
	protected java.lang.Integer  __msg_count ;
	protected java.lang.Integer  __msg_status ;
	protected java.lang.String  __employee_name_tostring ;
	protected java.math.BigDecimal  __percent_sum ;
	protected java.lang.Integer  __pre_project_type ;
}
