package pomplatform.operation.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectManager extends GenericBase implements BaseFactory<BaseProjectManager>, Comparable<BaseProjectManager> 
{


	public static BaseProjectManager newInstance(){
		return new BaseProjectManager();
	}

	@Override
	public BaseProjectManager make(){
		BaseProjectManager b = new BaseProjectManager();
		return b;
	}

	public final static String CS_SUB_CONTRACT_NAME = "sub_contract_name" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;
	public final static String CS_EMPLOYEE_NAME_TOSTRING_3 = "employee_name_tostring_3" ;
	public final static String CS_PROJECT_NAME = "project_name" ;
	public final static String CS_PROJECT_ID = "project_id" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_PROJECT_TYPE = "project_type" ;
	public final static String CS_DESIGN_TYPE = "design_type" ;
	public final static String CS_PROJECT_LEVEL = "project_level" ;
	public final static String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static String CS_COMMON_AREA = "common_area" ;
	public final static String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static String CS_BIM_AREA = "bim_area" ;
	public final static String CS_CAD_AREA = "cad_area" ;
	public final static String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static String CS_PERCENTAGE = "percentage" ;
	public final static String CS_OLD_PROJECT_DISCOUNT = "old_project_discount" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_CONTRACT_CODE = "contract_code" ;
	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_DESIGN_PHASE = "design_phase" ;
	public final static String CS_WORK_HOURS = "work_hours" ;
	public final static String CS_PLAN_START_DATE = "plan_start_date" ;
	public final static String CS_PLAN_END_DATE = "plan_end_date" ;
	public final static String CS_START_DATE = "start_date" ;
	public final static String CS_END_DATE = "end_date" ;
	public final static String CS_BUDGET = "budget" ;
	public final static String CS_PROJECT_PROGRESS = "project_progress" ;
	public final static String CS_PROJECT_SIZE = "project_size" ;
	public final static String CS_PROJECT_DESCRIPTION = "project_description" ;
	public final static String CS_AUDIT_REASON = "audit_reason" ;
	public final static String CS_APPEND_TOTAL_INTEGRAL = "append_total_integral" ;
	public final static String CS_APPEND_INTEGRAL = "append_integral" ;
	public final static String CS_REMARK = "remark" ;
	public final static String CS_PROJECT_FINISH_PERCENT = "project_finish_percent" ;
	public final static String CS_PARENT_ID = "parent_id" ;
	public final static String CS_TOTAL_FINISH_PERCENT = "total_finish_percent" ;
	public final static String CS_PLATE_MANAGER_ID = "plate_manager_id" ;
	public final static String CS_PROJECT_GRADE_TYPE = "project_grade_type" ;
	public final static String CS_LAST_PERCENT = "last_percent" ;
	public final static String CS_HUMAN_AMOUNT = "human_amount" ;
	public final static String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static String CS_COMPLAINT_PERCENTAGE = "complaint_percentage" ;
	public final static String CS_PROJECT_FLAG = "project_flag" ;
	public final static String CS_LEFT_SURE_INTEGRAL = "left_sure_integral" ;
	public final static String CS_PLATE_SURE_INTEGRAL = "plate_sure_integral" ;
	public final static String CS_LEFT_PLATE_SURE_INTEGRAL = "left_plate_sure_integral" ;
	public final static String CS_PROGRESS_PERCENTAGE = "progress_percentage" ;
	public final static String CS_IS_AUTO = "is_auto" ;
	public final static String CS_TIME_CYCLE = "time_cycle" ;
	public final static String CS_CREATE_TIME = "create_time" ;
	public final static String CS_MSG_COUNT = "msg_count" ;
	public final static String CS_MSG_STATUS = "msg_status" ;
	public final static String CS_EMPLOYEE_NAME_TOSTRING_5 = "employee_name_tostring_5" ;
	public final static String CS_PERCENT_SUM = "percent_sum" ;
	public final static String CS_PRE_PROJECT_TYPE = "pre_project_type" ;

	public final static String NAME_SUB_CONTRACT_NAME = "subContractName" ;
	public final static String NAME_DEPARTMENT_ID = "departmentId" ;
	public final static String NAME_DEPARTMENT_MANAGER_ID = "departmentManagerId" ;
	public final static String NAME_EMPLOYEE_NAME_TOSTRING_3 = "employeeNameTostring3" ;
	public final static String NAME_PROJECT_NAME = "projectName" ;
	public final static String NAME_PROJECT_ID = "projectId" ;
	public final static String NAME_PLATE_ID = "plateId" ;
	public final static String NAME_PROJECT_TYPE = "projectType" ;
	public final static String NAME_DESIGN_TYPE = "designType" ;
	public final static String NAME_PROJECT_LEVEL = "projectLevel" ;
	public final static String NAME_PROJECT_MANAGE_ID = "projectManageId" ;
	public final static String NAME_COMMON_AREA = "commonArea" ;
	public final static String NAME_LOGISTICS_AREA = "logisticsArea" ;
	public final static String NAME_TOTAL_INTEGRAL = "totalIntegral" ;
	public final static String NAME_RESERVE_INTEGRAL = "reserveIntegral" ;
	public final static String NAME_PROJECT_INTEGRAL = "projectIntegral" ;
	public final static String NAME_BIM_AREA = "bimArea" ;
	public final static String NAME_CAD_AREA = "cadArea" ;
	public final static String NAME_TOTAL_AMOUNT = "totalAmount" ;
	public final static String NAME_PERCENTAGE = "percentage" ;
	public final static String NAME_OLD_PROJECT_DISCOUNT = "oldProjectDiscount" ;
	public final static String NAME_STATUS = "status" ;
	public final static String NAME_CONTRACT_CODE = "contractCode" ;
	public final static String NAME_PROJECT_CODE = "projectCode" ;
	public final static String NAME_DESIGN_PHASE = "designPhase" ;
	public final static String NAME_WORK_HOURS = "workHours" ;
	public final static String NAME_PLAN_START_DATE = "planStartDate" ;
	public final static String NAME_PLAN_END_DATE = "planEndDate" ;
	public final static String NAME_START_DATE = "startDate" ;
	public final static String NAME_END_DATE = "endDate" ;
	public final static String NAME_BUDGET = "budget" ;
	public final static String NAME_PROJECT_PROGRESS = "projectProgress" ;
	public final static String NAME_PROJECT_SIZE = "projectSize" ;
	public final static String NAME_PROJECT_DESCRIPTION = "projectDescription" ;
	public final static String NAME_AUDIT_REASON = "auditReason" ;
	public final static String NAME_APPEND_TOTAL_INTEGRAL = "appendTotalIntegral" ;
	public final static String NAME_APPEND_INTEGRAL = "appendIntegral" ;
	public final static String NAME_REMARK = "remark" ;
	public final static String NAME_PROJECT_FINISH_PERCENT = "projectFinishPercent" ;
	public final static String NAME_PARENT_ID = "parentId" ;
	public final static String NAME_TOTAL_FINISH_PERCENT = "totalFinishPercent" ;
	public final static String NAME_PLATE_MANAGER_ID = "plateManagerId" ;
	public final static String NAME_PROJECT_GRADE_TYPE = "projectGradeType" ;
	public final static String NAME_LAST_PERCENT = "lastPercent" ;
	public final static String NAME_HUMAN_AMOUNT = "humanAmount" ;
	public final static String NAME_SURE_INTEGRAL = "sureIntegral" ;
	public final static String NAME_COMPLAINT_INTEGRAL = "complaintIntegral" ;
	public final static String NAME_COMPLAINT_PERCENTAGE = "complaintPercentage" ;
	public final static String NAME_PROJECT_FLAG = "projectFlag" ;
	public final static String NAME_LEFT_SURE_INTEGRAL = "leftSureIntegral" ;
	public final static String NAME_PLATE_SURE_INTEGRAL = "plateSureIntegral" ;
	public final static String NAME_LEFT_PLATE_SURE_INTEGRAL = "leftPlateSureIntegral" ;
	public final static String NAME_PROGRESS_PERCENTAGE = "progressPercentage" ;
	public final static String NAME_IS_AUTO = "isAuto" ;
	public final static String NAME_TIME_CYCLE = "timeCycle" ;
	public final static String NAME_CREATE_TIME = "createTime" ;
	public final static String NAME_MSG_COUNT = "msgCount" ;
	public final static String NAME_MSG_STATUS = "msgStatus" ;
	public final static String NAME_EMPLOYEE_NAME_TOSTRING_5 = "employeeNameTostring5" ;
	public final static String NAME_PERCENT_SUM = "percentSum" ;
	public final static String NAME_PRE_PROJECT_TYPE = "preProjectType" ;

	public final static java.lang.String ALL_CAPTIONS = "子合同名称  充当了区域,归属部门,运营管理员,,项目名称,项目编码,板块,项目类别,设计类别,项目等级,积分管理员,公区面积,后勤面积,项目总积分,预留积分,项目积分,BIM面积,设计面积,项目总金额,核算比例,遗留项目折算,项目状态,合同编号,项目编号,设计阶段,预估工时,项目计划开始日期,项目计划结束日期,项目开始日期,项目结束日期,预算,项目进度,项目大小,项目描述,审核意见,追加总积分,追加积分,备注,项目完成百分比,是否为630项目，0是   1不是       默认值为0,项目总完成百分比,事业部负责人,2配合专业项目),上次结算时的百分比,手工计算积分,,投诉保证金,投诉折算比例,4投标项目),,,,,是否自动结算,时间周期(月),创建时间,消息推送次数,消息状态   0 无意义 ，1 需要进行消息推送   2 已完成，不需要进行消息推送   3 已失效,,,";

	public java.lang.String getSubContractName() {
		return this.__sub_contract_name;
	}

	public void setSubContractName( java.lang.String value ) {
		this.__sub_contract_name = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public java.lang.String getEmployeeNameTostring3() {
		return this.__employee_name_tostring_3;
	}

	public void setEmployeeNameTostring3( java.lang.String value ) {
		this.__employee_name_tostring_3 = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getDesignType() {
		return this.__design_type;
	}

	public void setDesignType( java.lang.Integer value ) {
		this.__design_type = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
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

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getBimArea() {
		return this.__bim_area;
	}

	public void setBimArea( java.math.BigDecimal value ) {
		this.__bim_area = value;
	}

	public java.math.BigDecimal getCadArea() {
		return this.__cad_area;
	}

	public void setCadArea( java.math.BigDecimal value ) {
		this.__cad_area = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.math.BigDecimal getPercentage() {
		return this.__percentage;
	}

	public void setPercentage( java.math.BigDecimal value ) {
		this.__percentage = value;
	}

	public java.math.BigDecimal getOldProjectDiscount() {
		return this.__old_project_discount;
	}

	public void setOldProjectDiscount( java.math.BigDecimal value ) {
		this.__old_project_discount = value;
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

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	public java.lang.Integer getWorkHours() {
		return this.__work_hours;
	}

	public void setWorkHours( java.lang.Integer value ) {
		this.__work_hours = value;
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

	public java.math.BigDecimal getBudget() {
		return this.__budget;
	}

	public void setBudget( java.math.BigDecimal value ) {
		this.__budget = value;
	}

	public java.lang.String getProjectProgress() {
		return this.__project_progress;
	}

	public void setProjectProgress( java.lang.String value ) {
		this.__project_progress = value;
	}

	public java.lang.String getProjectSize() {
		return this.__project_size;
	}

	public void setProjectSize( java.lang.String value ) {
		this.__project_size = value;
	}

	public java.lang.String getProjectDescription() {
		return this.__project_description;
	}

	public void setProjectDescription( java.lang.String value ) {
		this.__project_description = value;
	}

	public java.lang.String getAuditReason() {
		return this.__audit_reason;
	}

	public void setAuditReason( java.lang.String value ) {
		this.__audit_reason = value;
	}

	public java.math.BigDecimal getAppendTotalIntegral() {
		return this.__append_total_integral;
	}

	public void setAppendTotalIntegral( java.math.BigDecimal value ) {
		this.__append_total_integral = value;
	}

	public java.math.BigDecimal getAppendIntegral() {
		return this.__append_integral;
	}

	public void setAppendIntegral( java.math.BigDecimal value ) {
		this.__append_integral = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
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

	public java.math.BigDecimal getHumanAmount() {
		return this.__human_amount;
	}

	public void setHumanAmount( java.math.BigDecimal value ) {
		this.__human_amount = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return this.__complaint_integral;
	}

	public void setComplaintIntegral( java.math.BigDecimal value ) {
		this.__complaint_integral = value;
	}

	public java.math.BigDecimal getComplaintPercentage() {
		return this.__complaint_percentage;
	}

	public void setComplaintPercentage( java.math.BigDecimal value ) {
		this.__complaint_percentage = value;
	}

	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}

	public java.math.BigDecimal getLeftSureIntegral() {
		return this.__left_sure_integral;
	}

	public void setLeftSureIntegral( java.math.BigDecimal value ) {
		this.__left_sure_integral = value;
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

	public java.math.BigDecimal getProgressPercentage() {
		return this.__progress_percentage;
	}

	public void setProgressPercentage( java.math.BigDecimal value ) {
		this.__progress_percentage = value;
	}

	public java.lang.Boolean getIsAuto() {
		return this.__is_auto;
	}

	public void setIsAuto( java.lang.Boolean value ) {
		this.__is_auto = value;
	}

	public java.lang.Integer getTimeCycle() {
		return this.__time_cycle;
	}

	public void setTimeCycle( java.lang.Integer value ) {
		this.__time_cycle = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
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

	public java.lang.String getEmployeeNameTostring5() {
		return this.__employee_name_tostring_5;
	}

	public void setEmployeeNameTostring5( java.lang.String value ) {
		this.__employee_name_tostring_5 = value;
	}

	public java.math.BigDecimal getPercentSum() {
		return this.__percent_sum;
	}

	public void setPercentSum( java.math.BigDecimal value ) {
		this.__percent_sum = value;
	}

	public java.lang.Integer getPreProjectType() {
		return this.__pre_project_type;
	}

	public void setPreProjectType( java.lang.Integer value ) {
		this.__pre_project_type = value;
	}

	public static String getKeyColumnName() {
		String name ="";
		name = CS_PROJECT_ID;
		return name;
	}

	public void cloneCopy(BaseProjectManager __bean){
		__bean.setSubContractName(getSubContractName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDepartmentManagerId(getDepartmentManagerId());
		__bean.setEmployeeNameTostring3(getEmployeeNameTostring3());
		__bean.setProjectName(getProjectName());
		__bean.setProjectId(getProjectId());
		__bean.setPlateId(getPlateId());
		__bean.setProjectType(getProjectType());
		__bean.setDesignType(getDesignType());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setCommonArea(getCommonArea());
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setBimArea(getBimArea());
		__bean.setCadArea(getCadArea());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setPercentage(getPercentage());
		__bean.setOldProjectDiscount(getOldProjectDiscount());
		__bean.setStatus(getStatus());
		__bean.setContractCode(getContractCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setDesignPhase(getDesignPhase());
		__bean.setWorkHours(getWorkHours());
		__bean.setPlanStartDate(getPlanStartDate());
		__bean.setPlanEndDate(getPlanEndDate());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setBudget(getBudget());
		__bean.setProjectProgress(getProjectProgress());
		__bean.setProjectSize(getProjectSize());
		__bean.setProjectDescription(getProjectDescription());
		__bean.setAuditReason(getAuditReason());
		__bean.setAppendTotalIntegral(getAppendTotalIntegral());
		__bean.setAppendIntegral(getAppendIntegral());
		__bean.setRemark(getRemark());
		__bean.setProjectFinishPercent(getProjectFinishPercent());
		__bean.setParentId(getParentId());
		__bean.setTotalFinishPercent(getTotalFinishPercent());
		__bean.setPlateManagerId(getPlateManagerId());
		__bean.setProjectGradeType(getProjectGradeType());
		__bean.setLastPercent(getLastPercent());
		__bean.setHumanAmount(getHumanAmount());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setComplaintPercentage(getComplaintPercentage());
		__bean.setProjectFlag(getProjectFlag());
		__bean.setLeftSureIntegral(getLeftSureIntegral());
		__bean.setPlateSureIntegral(getPlateSureIntegral());
		__bean.setLeftPlateSureIntegral(getLeftPlateSureIntegral());
		__bean.setProgressPercentage(getProgressPercentage());
		__bean.setIsAuto(getIsAuto());
		__bean.setTimeCycle(getTimeCycle());
		__bean.setCreateTime(getCreateTime());
		__bean.setMsgCount(getMsgCount());
		__bean.setMsgStatus(getMsgStatus());
		__bean.setEmployeeNameTostring5(getEmployeeNameTostring5());
		__bean.setPercentSum(getPercentSum());
		__bean.setPreProjectType(getPreProjectType());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSubContractName() == null ? "" : getSubContractName());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getDepartmentManagerId() == null ? "" : getDepartmentManagerId());
		sb.append(",");
		sb.append(getEmployeeNameTostring3() == null ? "" : getEmployeeNameTostring3());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getDesignType() == null ? "" : getDesignType());
		sb.append(",");
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getBimArea() == null ? "" : getBimArea());
		sb.append(",");
		sb.append(getCadArea() == null ? "" : getCadArea());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getPercentage() == null ? "" : getPercentage());
		sb.append(",");
		sb.append(getOldProjectDiscount() == null ? "" : getOldProjectDiscount());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getDesignPhase() == null ? "" : getDesignPhase());
		sb.append(",");
		sb.append(getWorkHours() == null ? "" : getWorkHours());
		sb.append(",");
		sb.append(getPlanStartDate() == null ? "" : sdf.format(getPlanStartDate()));
		sb.append(",");
		sb.append(getPlanEndDate() == null ? "" : sdf.format(getPlanEndDate()));
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getBudget() == null ? "" : getBudget());
		sb.append(",");
		sb.append(getProjectProgress() == null ? "" : getProjectProgress());
		sb.append(",");
		sb.append(getProjectSize() == null ? "" : getProjectSize());
		sb.append(",");
		sb.append(getProjectDescription() == null ? "" : getProjectDescription());
		sb.append(",");
		sb.append(getAuditReason() == null ? "" : getAuditReason());
		sb.append(",");
		sb.append(getAppendTotalIntegral() == null ? "" : getAppendTotalIntegral());
		sb.append(",");
		sb.append(getAppendIntegral() == null ? "" : getAppendIntegral());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
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
		sb.append(getHumanAmount() == null ? "" : getHumanAmount());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getComplaintPercentage() == null ? "" : getComplaintPercentage());
		sb.append(",");
		sb.append(getProjectFlag() == null ? "" : getProjectFlag());
		sb.append(",");
		sb.append(getLeftSureIntegral() == null ? "" : getLeftSureIntegral());
		sb.append(",");
		sb.append(getPlateSureIntegral() == null ? "" : getPlateSureIntegral());
		sb.append(",");
		sb.append(getLeftPlateSureIntegral() == null ? "" : getLeftPlateSureIntegral());
		sb.append(",");
		sb.append(getProgressPercentage() == null ? "" : getProgressPercentage());
		sb.append(",");
		sb.append(getIsAuto() == null ? "" : getIsAuto());
		sb.append(",");
		sb.append(getTimeCycle() == null ? "" : getTimeCycle());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getMsgCount() == null ? "" : getMsgCount());
		sb.append(",");
		sb.append(getMsgStatus() == null ? "" : getMsgStatus());
		sb.append(",");
		sb.append(getEmployeeNameTostring5() == null ? "" : getEmployeeNameTostring5());
		sb.append(",");
		sb.append(getPercentSum() == null ? "" : getPercentSum());
		sb.append(",");
		sb.append(getPreProjectType() == null ? "" : getPreProjectType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectManager o) {
		return __project_id == null || o.getProjectId() == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__sub_contract_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__department_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_tostring_3);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__design_type);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__bim_area);
		hash = 97 * hash + Objects.hashCode(this.__cad_area);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__percentage);
		hash = 97 * hash + Objects.hashCode(this.__old_project_discount);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__design_phase);
		hash = 97 * hash + Objects.hashCode(this.__work_hours);
		hash = 97 * hash + Objects.hashCode(this.__plan_start_date);
		hash = 97 * hash + Objects.hashCode(this.__plan_end_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__budget);
		hash = 97 * hash + Objects.hashCode(this.__project_progress);
		hash = 97 * hash + Objects.hashCode(this.__project_size);
		hash = 97 * hash + Objects.hashCode(this.__project_description);
		hash = 97 * hash + Objects.hashCode(this.__audit_reason);
		hash = 97 * hash + Objects.hashCode(this.__append_total_integral);
		hash = 97 * hash + Objects.hashCode(this.__append_integral);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__project_finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__total_finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__project_grade_type);
		hash = 97 * hash + Objects.hashCode(this.__last_percent);
		hash = 97 * hash + Objects.hashCode(this.__human_amount);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_percentage);
		hash = 97 * hash + Objects.hashCode(this.__project_flag);
		hash = 97 * hash + Objects.hashCode(this.__left_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__plate_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_plate_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__progress_percentage);
		hash = 97 * hash + Objects.hashCode(this.__is_auto);
		hash = 97 * hash + Objects.hashCode(this.__time_cycle);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__msg_count);
		hash = 97 * hash + Objects.hashCode(this.__msg_status);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_tostring_5);
		hash = 97 * hash + Objects.hashCode(this.__percent_sum);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectManager o = (BaseProjectManager)obj;
		if(!Objects.equals(this.__sub_contract_name, o.getSubContractName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__department_manager_id, o.getDepartmentManagerId())) return false;
		if(!Objects.equals(this.__employee_name_tostring_3, o.getEmployeeNameTostring3())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__design_type, o.getDesignType())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__bim_area, o.getBimArea())) return false;
		if(!Objects.equals(this.__cad_area, o.getCadArea())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__percentage, o.getPercentage())) return false;
		if(!Objects.equals(this.__old_project_discount, o.getOldProjectDiscount())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__design_phase, o.getDesignPhase())) return false;
		if(!Objects.equals(this.__work_hours, o.getWorkHours())) return false;
		if(!Objects.equals(this.__plan_start_date, o.getPlanStartDate())) return false;
		if(!Objects.equals(this.__plan_end_date, o.getPlanEndDate())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__budget, o.getBudget())) return false;
		if(!Objects.equals(this.__project_progress, o.getProjectProgress())) return false;
		if(!Objects.equals(this.__project_size, o.getProjectSize())) return false;
		if(!Objects.equals(this.__project_description, o.getProjectDescription())) return false;
		if(!Objects.equals(this.__audit_reason, o.getAuditReason())) return false;
		if(!Objects.equals(this.__append_total_integral, o.getAppendTotalIntegral())) return false;
		if(!Objects.equals(this.__append_integral, o.getAppendIntegral())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__project_finish_percent, o.getProjectFinishPercent())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__total_finish_percent, o.getTotalFinishPercent())) return false;
		if(!Objects.equals(this.__plate_manager_id, o.getPlateManagerId())) return false;
		if(!Objects.equals(this.__project_grade_type, o.getProjectGradeType())) return false;
		if(!Objects.equals(this.__last_percent, o.getLastPercent())) return false;
		if(!Objects.equals(this.__human_amount, o.getHumanAmount())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__complaint_percentage, o.getComplaintPercentage())) return false;
		if(!Objects.equals(this.__project_flag, o.getProjectFlag())) return false;
		if(!Objects.equals(this.__left_sure_integral, o.getLeftSureIntegral())) return false;
		if(!Objects.equals(this.__plate_sure_integral, o.getPlateSureIntegral())) return false;
		if(!Objects.equals(this.__left_plate_sure_integral, o.getLeftPlateSureIntegral())) return false;
		if(!Objects.equals(this.__progress_percentage, o.getProgressPercentage())) return false;
		if(!Objects.equals(this.__is_auto, o.getIsAuto())) return false;
		if(!Objects.equals(this.__time_cycle, o.getTimeCycle())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__msg_count, o.getMsgCount())) return false;
		if(!Objects.equals(this.__msg_status, o.getMsgStatus())) return false;
		if(!Objects.equals(this.__employee_name_tostring_5, o.getEmployeeNameTostring5())) return false;
		if(!Objects.equals(this.__percent_sum, o.getPercentSum())) return false;
		if(!Objects.equals(this.__pre_project_type, o.getPreProjectType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSubContractName() != null) sb.append(__wrapString(count++, NAME_SUB_CONTRACT_NAME, getSubContractName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, NAME_DEPARTMENT_ID, getDepartmentId()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, NAME_DEPARTMENT_MANAGER_ID, getDepartmentManagerId()));
		if(getEmployeeNameTostring3() != null) sb.append(__wrapString(count++, NAME_EMPLOYEE_NAME_TOSTRING_3, getEmployeeNameTostring3()));
		if(getProjectName() != null) sb.append(__wrapString(count++, NAME_PROJECT_NAME, getProjectName()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_ID, getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, NAME_PLATE_ID, getPlateId()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_TYPE, getProjectType()));
		if(getDesignType() != null) sb.append(__wrapNumber(count++, NAME_DESIGN_TYPE, getDesignType()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_LEVEL, getProjectLevel()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_MANAGE_ID, getProjectManageId()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, NAME_COMMON_AREA, getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, NAME_LOGISTICS_AREA, getLogisticsArea()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, NAME_TOTAL_INTEGRAL, getTotalIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, NAME_RESERVE_INTEGRAL, getReserveIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, NAME_PROJECT_INTEGRAL, getProjectIntegral()));
		if(getBimArea() != null) sb.append(__wrapDecimal(count++, NAME_BIM_AREA, getBimArea()));
		if(getCadArea() != null) sb.append(__wrapDecimal(count++, NAME_CAD_AREA, getCadArea()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, NAME_TOTAL_AMOUNT, getTotalAmount()));
		if(getPercentage() != null) sb.append(__wrapDecimal(count++, NAME_PERCENTAGE, getPercentage()));
		if(getOldProjectDiscount() != null) sb.append(__wrapDecimal(count++, NAME_OLD_PROJECT_DISCOUNT, getOldProjectDiscount()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, NAME_STATUS, getStatus()));
		if(getContractCode() != null) sb.append(__wrapString(count++, NAME_CONTRACT_CODE, getContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, NAME_PROJECT_CODE, getProjectCode()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(count++, NAME_DESIGN_PHASE, getDesignPhase()));
		if(getWorkHours() != null) sb.append(__wrapNumber(count++, NAME_WORK_HOURS, getWorkHours()));
		if(getPlanStartDate() != null) sb.append(__wrapDate(count++, NAME_PLAN_START_DATE, getPlanStartDate()));
		if(getPlanEndDate() != null) sb.append(__wrapDate(count++, NAME_PLAN_END_DATE, getPlanEndDate()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, NAME_START_DATE, getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, NAME_END_DATE, getEndDate()));
		if(getBudget() != null) sb.append(__wrapDecimal(count++, NAME_BUDGET, getBudget()));
		if(getProjectProgress() != null) sb.append(__wrapString(count++, NAME_PROJECT_PROGRESS, getProjectProgress()));
		if(getProjectSize() != null) sb.append(__wrapString(count++, NAME_PROJECT_SIZE, getProjectSize()));
		if(getProjectDescription() != null) sb.append(__wrapString(count++, NAME_PROJECT_DESCRIPTION, getProjectDescription()));
		if(getAuditReason() != null) sb.append(__wrapString(count++, NAME_AUDIT_REASON, getAuditReason()));
		if(getAppendTotalIntegral() != null) sb.append(__wrapDecimal(count++, NAME_APPEND_TOTAL_INTEGRAL, getAppendTotalIntegral()));
		if(getAppendIntegral() != null) sb.append(__wrapDecimal(count++, NAME_APPEND_INTEGRAL, getAppendIntegral()));
		if(getRemark() != null) sb.append(__wrapString(count++, NAME_REMARK, getRemark()));
		if(getProjectFinishPercent() != null) sb.append(__wrapDecimal(count++, NAME_PROJECT_FINISH_PERCENT, getProjectFinishPercent()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, NAME_PARENT_ID, getParentId()));
		if(getTotalFinishPercent() != null) sb.append(__wrapDecimal(count++, NAME_TOTAL_FINISH_PERCENT, getTotalFinishPercent()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, NAME_PLATE_MANAGER_ID, getPlateManagerId()));
		if(getProjectGradeType() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_GRADE_TYPE, getProjectGradeType()));
		if(getLastPercent() != null) sb.append(__wrapDecimal(count++, NAME_LAST_PERCENT, getLastPercent()));
		if(getHumanAmount() != null) sb.append(__wrapDecimal(count++, NAME_HUMAN_AMOUNT, getHumanAmount()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, NAME_SURE_INTEGRAL, getSureIntegral()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, NAME_COMPLAINT_INTEGRAL, getComplaintIntegral()));
		if(getComplaintPercentage() != null) sb.append(__wrapDecimal(count++, NAME_COMPLAINT_PERCENTAGE, getComplaintPercentage()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_FLAG, getProjectFlag()));
		if(getLeftSureIntegral() != null) sb.append(__wrapDecimal(count++, NAME_LEFT_SURE_INTEGRAL, getLeftSureIntegral()));
		if(getPlateSureIntegral() != null) sb.append(__wrapDecimal(count++, NAME_PLATE_SURE_INTEGRAL, getPlateSureIntegral()));
		if(getLeftPlateSureIntegral() != null) sb.append(__wrapDecimal(count++, NAME_LEFT_PLATE_SURE_INTEGRAL, getLeftPlateSureIntegral()));
		if(getProgressPercentage() != null) sb.append(__wrapDecimal(count++, NAME_PROGRESS_PERCENTAGE, getProgressPercentage()));
		if(getIsAuto() != null) sb.append(__wrapBoolean(count++, NAME_IS_AUTO, getIsAuto()));
		if(getTimeCycle() != null) sb.append(__wrapNumber(count++, NAME_TIME_CYCLE, getTimeCycle()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, NAME_CREATE_TIME, getCreateTime()));
		if(getMsgCount() != null) sb.append(__wrapNumber(count++, NAME_MSG_COUNT, getMsgCount()));
		if(getMsgStatus() != null) sb.append(__wrapNumber(count++, NAME_MSG_STATUS, getMsgStatus()));
		if(getEmployeeNameTostring5() != null) sb.append(__wrapString(count++, NAME_EMPLOYEE_NAME_TOSTRING_5, getEmployeeNameTostring5()));
		if(getPercentSum() != null) sb.append(__wrapDecimal(count++, NAME_PERCENT_SUM, getPercentSum()));
		if(getPreProjectType() != null) sb.append(__wrapNumber(count++, NAME_PRE_PROJECT_TYPE, getPreProjectType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSubContractName() != null) res.put(NAME_SUB_CONTRACT_NAME, getSubContractName());
		if(getDepartmentId() != null) res.put(NAME_DEPARTMENT_ID, getDepartmentId());
		if(getDepartmentManagerId() != null) res.put(NAME_DEPARTMENT_MANAGER_ID, getDepartmentManagerId());
		if(getEmployeeNameTostring3() != null) res.put(NAME_EMPLOYEE_NAME_TOSTRING_3, getEmployeeNameTostring3());
		if(getProjectName() != null) res.put(NAME_PROJECT_NAME, getProjectName());
		if(getProjectId() != null) res.put(NAME_PROJECT_ID, getProjectId());
		if(getPlateId() != null) res.put(NAME_PLATE_ID, getPlateId());
		if(getProjectType() != null) res.put(NAME_PROJECT_TYPE, getProjectType());
		if(getDesignType() != null) res.put(NAME_DESIGN_TYPE, getDesignType());
		if(getProjectLevel() != null) res.put(NAME_PROJECT_LEVEL, getProjectLevel());
		if(getProjectManageId() != null) res.put(NAME_PROJECT_MANAGE_ID, getProjectManageId());
		if(getCommonArea() != null) res.put(NAME_COMMON_AREA, getCommonArea());
		if(getLogisticsArea() != null) res.put(NAME_LOGISTICS_AREA, getLogisticsArea());
		if(getTotalIntegral() != null) res.put(NAME_TOTAL_INTEGRAL, getTotalIntegral());
		if(getReserveIntegral() != null) res.put(NAME_RESERVE_INTEGRAL, getReserveIntegral());
		if(getProjectIntegral() != null) res.put(NAME_PROJECT_INTEGRAL, getProjectIntegral());
		if(getBimArea() != null) res.put(NAME_BIM_AREA, getBimArea());
		if(getCadArea() != null) res.put(NAME_CAD_AREA, getCadArea());
		if(getTotalAmount() != null) res.put(NAME_TOTAL_AMOUNT, getTotalAmount());
		if(getPercentage() != null) res.put(NAME_PERCENTAGE, getPercentage());
		if(getOldProjectDiscount() != null) res.put(NAME_OLD_PROJECT_DISCOUNT, getOldProjectDiscount());
		if(getStatus() != null) res.put(NAME_STATUS, getStatus());
		if(getContractCode() != null) res.put(NAME_CONTRACT_CODE, getContractCode());
		if(getProjectCode() != null) res.put(NAME_PROJECT_CODE, getProjectCode());
		if(getDesignPhase() != null) res.put(NAME_DESIGN_PHASE, getDesignPhase());
		if(getWorkHours() != null) res.put(NAME_WORK_HOURS, getWorkHours());
		if(getPlanStartDate() != null) res.put(NAME_PLAN_START_DATE, getPlanStartDate());
		if(getPlanEndDate() != null) res.put(NAME_PLAN_END_DATE, getPlanEndDate());
		if(getStartDate() != null) res.put(NAME_START_DATE, getStartDate());
		if(getEndDate() != null) res.put(NAME_END_DATE, getEndDate());
		if(getBudget() != null) res.put(NAME_BUDGET, getBudget());
		if(getProjectProgress() != null) res.put(NAME_PROJECT_PROGRESS, getProjectProgress());
		if(getProjectSize() != null) res.put(NAME_PROJECT_SIZE, getProjectSize());
		if(getProjectDescription() != null) res.put(NAME_PROJECT_DESCRIPTION, getProjectDescription());
		if(getAuditReason() != null) res.put(NAME_AUDIT_REASON, getAuditReason());
		if(getAppendTotalIntegral() != null) res.put(NAME_APPEND_TOTAL_INTEGRAL, getAppendTotalIntegral());
		if(getAppendIntegral() != null) res.put(NAME_APPEND_INTEGRAL, getAppendIntegral());
		if(getRemark() != null) res.put(NAME_REMARK, getRemark());
		if(getProjectFinishPercent() != null) res.put(NAME_PROJECT_FINISH_PERCENT, getProjectFinishPercent());
		if(getParentId() != null) res.put(NAME_PARENT_ID, getParentId());
		if(getTotalFinishPercent() != null) res.put(NAME_TOTAL_FINISH_PERCENT, getTotalFinishPercent());
		if(getPlateManagerId() != null) res.put(NAME_PLATE_MANAGER_ID, getPlateManagerId());
		if(getProjectGradeType() != null) res.put(NAME_PROJECT_GRADE_TYPE, getProjectGradeType());
		if(getLastPercent() != null) res.put(NAME_LAST_PERCENT, getLastPercent());
		if(getHumanAmount() != null) res.put(NAME_HUMAN_AMOUNT, getHumanAmount());
		if(getSureIntegral() != null) res.put(NAME_SURE_INTEGRAL, getSureIntegral());
		if(getComplaintIntegral() != null) res.put(NAME_COMPLAINT_INTEGRAL, getComplaintIntegral());
		if(getComplaintPercentage() != null) res.put(NAME_COMPLAINT_PERCENTAGE, getComplaintPercentage());
		if(getProjectFlag() != null) res.put(NAME_PROJECT_FLAG, getProjectFlag());
		if(getLeftSureIntegral() != null) res.put(NAME_LEFT_SURE_INTEGRAL, getLeftSureIntegral());
		if(getPlateSureIntegral() != null) res.put(NAME_PLATE_SURE_INTEGRAL, getPlateSureIntegral());
		if(getLeftPlateSureIntegral() != null) res.put(NAME_LEFT_PLATE_SURE_INTEGRAL, getLeftPlateSureIntegral());
		if(getProgressPercentage() != null) res.put(NAME_PROGRESS_PERCENTAGE, getProgressPercentage());
		if(getIsAuto() != null) res.put(NAME_IS_AUTO, getIsAuto());
		if(getTimeCycle() != null) res.put(NAME_TIME_CYCLE, getTimeCycle());
		if(getCreateTime() != null) res.put(NAME_CREATE_TIME, getCreateTime());
		if(getMsgCount() != null) res.put(NAME_MSG_COUNT, getMsgCount());
		if(getMsgStatus() != null) res.put(NAME_MSG_STATUS, getMsgStatus());
		if(getEmployeeNameTostring5() != null) res.put(NAME_EMPLOYEE_NAME_TOSTRING_5, getEmployeeNameTostring5());
		if(getPercentSum() != null) res.put(NAME_PERCENT_SUM, getPercentSum());
		if(getPreProjectType() != null) res.put(NAME_PRE_PROJECT_TYPE, getPreProjectType());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseProjectManager> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseProjectManager b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_SUB_CONTRACT_NAME) && (val = values.get(NAME_SUB_CONTRACT_NAME)) != null) setSubContractName(__getString(val));
		if(values.containsKey(NAME_DEPARTMENT_ID) && (val = values.get(NAME_DEPARTMENT_ID)) != null) setDepartmentId(__getInt(val)); 
		if(values.containsKey(NAME_DEPARTMENT_MANAGER_ID) && (val = values.get(NAME_DEPARTMENT_MANAGER_ID)) != null) setDepartmentManagerId(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_NAME_TOSTRING_3) && (val = values.get(NAME_EMPLOYEE_NAME_TOSTRING_3)) != null) setEmployeeNameTostring3(__getString(val));
		if(values.containsKey(NAME_PROJECT_NAME) && (val = values.get(NAME_PROJECT_NAME)) != null) setProjectName(__getString(val));
		if(values.containsKey(NAME_PROJECT_ID) && (val = values.get(NAME_PROJECT_ID)) != null) setProjectId(__getInt(val)); 
		if(values.containsKey(NAME_PLATE_ID) && (val = values.get(NAME_PLATE_ID)) != null) setPlateId(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_TYPE) && (val = values.get(NAME_PROJECT_TYPE)) != null) setProjectType(__getInt(val)); 
		if(values.containsKey(NAME_DESIGN_TYPE) && (val = values.get(NAME_DESIGN_TYPE)) != null) setDesignType(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_LEVEL) && (val = values.get(NAME_PROJECT_LEVEL)) != null) setProjectLevel(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_MANAGE_ID) && (val = values.get(NAME_PROJECT_MANAGE_ID)) != null) setProjectManageId(__getInt(val)); 
		if(values.containsKey(NAME_COMMON_AREA) && (val = values.get(NAME_COMMON_AREA)) != null) setCommonArea(__getDecimal(val));  
		if(values.containsKey(NAME_LOGISTICS_AREA) && (val = values.get(NAME_LOGISTICS_AREA)) != null) setLogisticsArea(__getDecimal(val));  
		if(values.containsKey(NAME_TOTAL_INTEGRAL) && (val = values.get(NAME_TOTAL_INTEGRAL)) != null) setTotalIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_RESERVE_INTEGRAL) && (val = values.get(NAME_RESERVE_INTEGRAL)) != null) setReserveIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_PROJECT_INTEGRAL) && (val = values.get(NAME_PROJECT_INTEGRAL)) != null) setProjectIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_BIM_AREA) && (val = values.get(NAME_BIM_AREA)) != null) setBimArea(__getDecimal(val));  
		if(values.containsKey(NAME_CAD_AREA) && (val = values.get(NAME_CAD_AREA)) != null) setCadArea(__getDecimal(val));  
		if(values.containsKey(NAME_TOTAL_AMOUNT) && (val = values.get(NAME_TOTAL_AMOUNT)) != null) setTotalAmount(__getDecimal(val));  
		if(values.containsKey(NAME_PERCENTAGE) && (val = values.get(NAME_PERCENTAGE)) != null) setPercentage(__getDecimal(val));  
		if(values.containsKey(NAME_OLD_PROJECT_DISCOUNT) && (val = values.get(NAME_OLD_PROJECT_DISCOUNT)) != null) setOldProjectDiscount(__getDecimal(val));  
		if(values.containsKey(NAME_STATUS) && (val = values.get(NAME_STATUS)) != null) setStatus(__getInt(val)); 
		if(values.containsKey(NAME_CONTRACT_CODE) && (val = values.get(NAME_CONTRACT_CODE)) != null) setContractCode(__getString(val));
		if(values.containsKey(NAME_PROJECT_CODE) && (val = values.get(NAME_PROJECT_CODE)) != null) setProjectCode(__getString(val));
		if(values.containsKey(NAME_DESIGN_PHASE) && (val = values.get(NAME_DESIGN_PHASE)) != null) setDesignPhase(__getInt(val)); 
		if(values.containsKey(NAME_WORK_HOURS) && (val = values.get(NAME_WORK_HOURS)) != null) setWorkHours(__getInt(val)); 
		if(values.containsKey(NAME_PLAN_START_DATE) && (val = values.get(NAME_PLAN_START_DATE)) != null) setPlanStartDate(__getDate(val)); 
		if(values.containsKey(NAME_PLAN_END_DATE) && (val = values.get(NAME_PLAN_END_DATE)) != null) setPlanEndDate(__getDate(val)); 
		if(values.containsKey(NAME_START_DATE) && (val = values.get(NAME_START_DATE)) != null) setStartDate(__getDate(val)); 
		if(values.containsKey(NAME_END_DATE) && (val = values.get(NAME_END_DATE)) != null) setEndDate(__getDate(val)); 
		if(values.containsKey(NAME_BUDGET) && (val = values.get(NAME_BUDGET)) != null) setBudget(__getDecimal(val));  
		if(values.containsKey(NAME_PROJECT_PROGRESS) && (val = values.get(NAME_PROJECT_PROGRESS)) != null) setProjectProgress(__getString(val));
		if(values.containsKey(NAME_PROJECT_SIZE) && (val = values.get(NAME_PROJECT_SIZE)) != null) setProjectSize(__getString(val));
		if(values.containsKey(NAME_PROJECT_DESCRIPTION) && (val = values.get(NAME_PROJECT_DESCRIPTION)) != null) setProjectDescription(__getString(val));
		if(values.containsKey(NAME_AUDIT_REASON) && (val = values.get(NAME_AUDIT_REASON)) != null) setAuditReason(__getString(val));
		if(values.containsKey(NAME_APPEND_TOTAL_INTEGRAL) && (val = values.get(NAME_APPEND_TOTAL_INTEGRAL)) != null) setAppendTotalIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_APPEND_INTEGRAL) && (val = values.get(NAME_APPEND_INTEGRAL)) != null) setAppendIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_REMARK) && (val = values.get(NAME_REMARK)) != null) setRemark(__getString(val));
		if(values.containsKey(NAME_PROJECT_FINISH_PERCENT) && (val = values.get(NAME_PROJECT_FINISH_PERCENT)) != null) setProjectFinishPercent(__getDecimal(val));  
		if(values.containsKey(NAME_PARENT_ID) && (val = values.get(NAME_PARENT_ID)) != null) setParentId(__getInt(val)); 
		if(values.containsKey(NAME_TOTAL_FINISH_PERCENT) && (val = values.get(NAME_TOTAL_FINISH_PERCENT)) != null) setTotalFinishPercent(__getDecimal(val));  
		if(values.containsKey(NAME_PLATE_MANAGER_ID) && (val = values.get(NAME_PLATE_MANAGER_ID)) != null) setPlateManagerId(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_GRADE_TYPE) && (val = values.get(NAME_PROJECT_GRADE_TYPE)) != null) setProjectGradeType(__getInt(val)); 
		if(values.containsKey(NAME_LAST_PERCENT) && (val = values.get(NAME_LAST_PERCENT)) != null) setLastPercent(__getDecimal(val));  
		if(values.containsKey(NAME_HUMAN_AMOUNT) && (val = values.get(NAME_HUMAN_AMOUNT)) != null) setHumanAmount(__getDecimal(val));  
		if(values.containsKey(NAME_SURE_INTEGRAL) && (val = values.get(NAME_SURE_INTEGRAL)) != null) setSureIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_COMPLAINT_INTEGRAL) && (val = values.get(NAME_COMPLAINT_INTEGRAL)) != null) setComplaintIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_COMPLAINT_PERCENTAGE) && (val = values.get(NAME_COMPLAINT_PERCENTAGE)) != null) setComplaintPercentage(__getDecimal(val));  
		if(values.containsKey(NAME_PROJECT_FLAG) && (val = values.get(NAME_PROJECT_FLAG)) != null) setProjectFlag(__getInt(val)); 
		if(values.containsKey(NAME_LEFT_SURE_INTEGRAL) && (val = values.get(NAME_LEFT_SURE_INTEGRAL)) != null) setLeftSureIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_PLATE_SURE_INTEGRAL) && (val = values.get(NAME_PLATE_SURE_INTEGRAL)) != null) setPlateSureIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_LEFT_PLATE_SURE_INTEGRAL) && (val = values.get(NAME_LEFT_PLATE_SURE_INTEGRAL)) != null) setLeftPlateSureIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_PROGRESS_PERCENTAGE) && (val = values.get(NAME_PROGRESS_PERCENTAGE)) != null) setProgressPercentage(__getDecimal(val));  
		if(values.containsKey(NAME_IS_AUTO) && (val = values.get(NAME_IS_AUTO)) != null) setIsAuto(__getBoolean(val));
		if(values.containsKey(NAME_TIME_CYCLE) && (val = values.get(NAME_TIME_CYCLE)) != null) setTimeCycle(__getInt(val)); 
		if(values.containsKey(NAME_CREATE_TIME) && (val = values.get(NAME_CREATE_TIME)) != null) setCreateTime(__getDate(val)); 
		if(values.containsKey(NAME_MSG_COUNT) && (val = values.get(NAME_MSG_COUNT)) != null) setMsgCount(__getInt(val)); 
		if(values.containsKey(NAME_MSG_STATUS) && (val = values.get(NAME_MSG_STATUS)) != null) setMsgStatus(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_NAME_TOSTRING_5) && (val = values.get(NAME_EMPLOYEE_NAME_TOSTRING_5)) != null) setEmployeeNameTostring5(__getString(val));
		if(values.containsKey(NAME_PERCENT_SUM) && (val = values.get(NAME_PERCENT_SUM)) != null) setPercentSum(__getDecimal(val));  
		if(values.containsKey(NAME_PRE_PROJECT_TYPE) && (val = values.get(NAME_PRE_PROJECT_TYPE)) != null) setPreProjectType(__getInt(val)); 
	}

	protected java.lang.String  __sub_contract_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __department_manager_id ;
	protected java.lang.String  __employee_name_tostring_3 ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __design_type ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __bim_area ;
	protected java.math.BigDecimal  __cad_area ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.math.BigDecimal  __percentage ;
	protected java.math.BigDecimal  __old_project_discount ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __design_phase ;
	protected java.lang.Integer  __work_hours ;
	protected java.util.Date  __plan_start_date ;
	protected java.util.Date  __plan_end_date ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __budget ;
	protected java.lang.String  __project_progress ;
	protected java.lang.String  __project_size ;
	protected java.lang.String  __project_description ;
	protected java.lang.String  __audit_reason ;
	protected java.math.BigDecimal  __append_total_integral ;
	protected java.math.BigDecimal  __append_integral ;
	protected java.lang.String  __remark ;
	protected java.math.BigDecimal  __project_finish_percent ;
	protected java.lang.Integer  __parent_id ;
	protected java.math.BigDecimal  __total_finish_percent ;
	protected java.lang.Integer  __plate_manager_id ;
	protected java.lang.Integer  __project_grade_type ;
	protected java.math.BigDecimal  __last_percent ;
	protected java.math.BigDecimal  __human_amount ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.math.BigDecimal  __complaint_percentage ;
	protected java.lang.Integer  __project_flag ;
	protected java.math.BigDecimal  __left_sure_integral ;
	protected java.math.BigDecimal  __plate_sure_integral ;
	protected java.math.BigDecimal  __left_plate_sure_integral ;
	protected java.math.BigDecimal  __progress_percentage ;
	protected java.lang.Boolean  __is_auto ;
	protected java.lang.Integer  __time_cycle ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __msg_count ;
	protected java.lang.Integer  __msg_status ;
	protected java.lang.String  __employee_name_tostring_5 ;
	protected java.math.BigDecimal  __percent_sum ;
	protected java.lang.Integer  __pre_project_type ;
}
