package pomplatform.workflow.professional.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadAuditListOfProfessionalApproval extends GenericBase implements BaseFactory<BaseOnLoadAuditListOfProfessionalApproval>, Comparable<BaseOnLoadAuditListOfProfessionalApproval> 
{


	public static BaseOnLoadAuditListOfProfessionalApproval newInstance(){
		return new BaseOnLoadAuditListOfProfessionalApproval();
	}

	@Override
	public BaseOnLoadAuditListOfProfessionalApproval make(){
		BaseOnLoadAuditListOfProfessionalApproval b = new BaseOnLoadAuditListOfProfessionalApproval();
		return b;
	}

	public final static String CS_PROCESS_TYPE_NAME = "process_type_name" ;
	public final static String CS_PROCESS_POOLED_TASK_ID = "process_pooled_task_id" ;
	public final static String CS_TYPE_FLAG = "type_flag" ;
	public final static String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static String CS_BUSINESS_ID = "business_id" ;
	public final static String CS_BUSINESS_NAME = "business_name" ;
	public final static String CS_PROCESS_ACTIVITY_ID = "process_activity_id" ;
	public final static String CS_PROCESS_ID = "process_id" ;
	public final static String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static String CS_NODE_TYPE = "node_type" ;
	public final static String CS_ACTIVITY_ID = "activity_id" ;
	public final static String CS_NEXT_ACTIVITY_ID = "next_activity_id" ;
	public final static String CS_MAIN_ACTIVITY_ID = "main_activity_id" ;
	public final static String CS_INSTANCE_ACTIVITY_CREATE_TIME = "instance_activity_create_time" ;
	public final static String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static String CS_OPERATE_TIME = "operate_time" ;
	public final static String CS_PROCESS_COMMENT = "process_comment" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_ACTIVITY_TYPE = "activity_type" ;
	public final static String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static String CS_PROFESSIONAL_APPROVAL__ID = "professional_approval__id" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_START_DATE = "start_date" ;
	public final static String CS_DELETE_FLAG = "delete_flag" ;
	public final static String CS_PROJECT_ID = "project_id" ;
	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_PROJECT_NAME = "project_name" ;
	public final static String CS_CONTRACT_ID = "contract_id" ;
	public final static String CS_CONTRACT_CODE = "contract_code" ;
	public final static String CS_CONTRACT_NAME = "contract_name" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_DESIGN_TYPE = "design_type" ;
	public final static String CS_PROJECT_TYPE = "project_type" ;
	public final static String CS_PLATE_MANAGER_ID = "plate_manager_id" ;
	public final static String CS_PROJECT_LEVEL = "project_level" ;
	public final static String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;
	public final static String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static String CS_PROJECT_MANAGE_NAME = "project_manage_name" ;
	public final static String CS_PROJECT_MANAGE_DEPARTMENT_ID = "project_manage_department_id" ;
	public final static String CS_COMMON_AREA = "common_area" ;
	public final static String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static String CS_CAD_AREA = "cad_area" ;
	public final static String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static String CS_PERCENTAGE = "percentage" ;
	public final static String CS_EMP_STATUS = "emp_status" ;

	public final static String NAME_PROCESS_TYPE_NAME = "processTypeName" ;
	public final static String NAME_PROCESS_POOLED_TASK_ID = "processPooledTaskId" ;
	public final static String NAME_TYPE_FLAG = "typeFlag" ;
	public final static String NAME_PROCESS_INSTANCE_ACTIVITY_ID = "processInstanceActivityId" ;
	public final static String NAME_BUSINESS_ID = "businessId" ;
	public final static String NAME_BUSINESS_NAME = "businessName" ;
	public final static String NAME_PROCESS_ACTIVITY_ID = "processActivityId" ;
	public final static String NAME_PROCESS_ID = "processId" ;
	public final static String NAME_PROCESS_INSTANCE_ID = "processInstanceId" ;
	public final static String NAME_NODE_TYPE = "nodeType" ;
	public final static String NAME_ACTIVITY_ID = "activityId" ;
	public final static String NAME_NEXT_ACTIVITY_ID = "nextActivityId" ;
	public final static String NAME_MAIN_ACTIVITY_ID = "mainActivityId" ;
	public final static String NAME_INSTANCE_ACTIVITY_CREATE_TIME = "instanceActivityCreateTime" ;
	public final static String NAME_INSTANCE_ACTIVITY_START_TIME = "instanceActivityStartTime" ;
	public final static String NAME_OPERATE_TIME = "operateTime" ;
	public final static String NAME_PROCESS_COMMENT = "processComment" ;
	public final static String NAME_STATUS = "status" ;
	public final static String NAME_ACTIVITY_TYPE = "activityType" ;
	public final static String NAME_BACK_VIEW_NAME = "backViewName" ;
	public final static String NAME_PROFESSIONAL_APPROVAL__ID = "professionalApproval_id" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_EMPLOYEE_NO = "employeeNo" ;
	public final static String NAME_START_DATE = "startDate" ;
	public final static String NAME_DELETE_FLAG = "deleteFlag" ;
	public final static String NAME_PROJECT_ID = "projectId" ;
	public final static String NAME_PROJECT_CODE = "projectCode" ;
	public final static String NAME_PROJECT_NAME = "projectName" ;
	public final static String NAME_CONTRACT_ID = "contractId" ;
	public final static String NAME_CONTRACT_CODE = "contractCode" ;
	public final static String NAME_CONTRACT_NAME = "contractName" ;
	public final static String NAME_PLATE_ID = "plateId" ;
	public final static String NAME_DESIGN_TYPE = "designType" ;
	public final static String NAME_PROJECT_TYPE = "projectType" ;
	public final static String NAME_PLATE_MANAGER_ID = "plateManagerId" ;
	public final static String NAME_PROJECT_LEVEL = "projectLevel" ;
	public final static String NAME_DEPARTMENT_MANAGER_ID = "departmentManagerId" ;
	public final static String NAME_PROJECT_MANAGE_ID = "projectManageId" ;
	public final static String NAME_PROJECT_MANAGE_NAME = "projectManageName" ;
	public final static String NAME_PROJECT_MANAGE_DEPARTMENT_ID = "projectManageDepartmentId" ;
	public final static String NAME_COMMON_AREA = "commonArea" ;
	public final static String NAME_LOGISTICS_AREA = "logisticsArea" ;
	public final static String NAME_CAD_AREA = "cadArea" ;
	public final static String NAME_TOTAL_INTEGRAL = "totalIntegral" ;
	public final static String NAME_PROJECT_INTEGRAL = "projectIntegral" ;
	public final static String NAME_RESERVE_INTEGRAL = "reserveIntegral" ;
	public final static String NAME_PERCENTAGE = "percentage" ;
	public final static String NAME_EMP_STATUS = "empStatus" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型名称,主键编码,,主键编码,业务编码,业务名称,活动编码,流程编码,流程实列编码,附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人,当前流程实例节点的内部编码,下一个流程节点的编码,如果是知会节点，所依附的主节点,流程实例节点创建时间,流程实例节点开始处于活动时间,操作时间,提交意见,状态,节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会,返回数据集,专业负责人审批编码,处理人,工号,开始日期,删除状态  0未删除    1已删除,项目编码,项目编号,项目名称,合同编码,合同编号,合同名称,业务部门,业务类别,项目类别,事业部负责人,项目等级,部门经理,积分管理员,专业负责人名称,专业负责人部门,公区面积,后勤面积,设计面积,项目总积分,项目积分,预留积分,核算比例,";

	public java.lang.String getProcessTypeName() {
		return this.__process_type_name;
	}

	public void setProcessTypeName( java.lang.String value ) {
		this.__process_type_name = value;
	}

	public java.lang.Integer getProcessPooledTaskId() {
		return this.__process_pooled_task_id;
	}

	public void setProcessPooledTaskId( java.lang.Integer value ) {
		this.__process_pooled_task_id = value;
	}

	public java.lang.Integer getTypeFlag() {
		return this.__type_flag;
	}

	public void setTypeFlag( java.lang.Integer value ) {
		this.__type_flag = value;
	}

	public java.lang.Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( java.lang.Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.Integer getProcessActivityId() {
		return this.__process_activity_id;
	}

	public void setProcessActivityId( java.lang.Integer value ) {
		this.__process_activity_id = value;
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

	public java.lang.Integer getNodeType() {
		return this.__node_type;
	}

	public void setNodeType( java.lang.Integer value ) {
		this.__node_type = value;
	}

	public java.lang.Integer getActivityId() {
		return this.__activity_id;
	}

	public void setActivityId( java.lang.Integer value ) {
		this.__activity_id = value;
	}

	public java.lang.Integer getNextActivityId() {
		return this.__next_activity_id;
	}

	public void setNextActivityId( java.lang.Integer value ) {
		this.__next_activity_id = value;
	}

	public java.lang.Integer getMainActivityId() {
		return this.__main_activity_id;
	}

	public void setMainActivityId( java.lang.Integer value ) {
		this.__main_activity_id = value;
	}

	public java.util.Date getInstanceActivityCreateTime() {
		return this.__instance_activity_create_time;
	}

	public void setInstanceActivityCreateTime( java.util.Date value ) {
		this.__instance_activity_create_time = value;
	}

	public java.util.Date getInstanceActivityStartTime() {
		return this.__instance_activity_start_time;
	}

	public void setInstanceActivityStartTime( java.util.Date value ) {
		this.__instance_activity_start_time = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getProcessComment() {
		return this.__process_comment;
	}

	public void setProcessComment( java.lang.String value ) {
		this.__process_comment = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getActivityType() {
		return this.__activity_type;
	}

	public void setActivityType( java.lang.Integer value ) {
		this.__activity_type = value;
	}

	public java.lang.String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( java.lang.String value ) {
		this.__back_view_name = value;
	}

	public java.lang.Integer getProfessionalApproval_id() {
		return this.__professional_approval__id;
	}

	public void setProfessionalApproval_id( java.lang.Integer value ) {
		this.__professional_approval__id = value;
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

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
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

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDesignType() {
		return this.__design_type;
	}

	public void setDesignType( java.lang.Integer value ) {
		this.__design_type = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getPlateManagerId() {
		return this.__plate_manager_id;
	}

	public void setPlateManagerId( java.lang.Integer value ) {
		this.__plate_manager_id = value;
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

	public java.lang.Integer getProjectManageDepartmentId() {
		return this.__project_manage_department_id;
	}

	public void setProjectManageDepartmentId( java.lang.Integer value ) {
		this.__project_manage_department_id = value;
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

	public java.math.BigDecimal getCadArea() {
		return this.__cad_area;
	}

	public void setCadArea( java.math.BigDecimal value ) {
		this.__cad_area = value;
	}

	public java.math.BigDecimal getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.math.BigDecimal value ) {
		this.__total_integral = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.math.BigDecimal value ) {
		this.__reserve_integral = value;
	}

	public java.math.BigDecimal getPercentage() {
		return this.__percentage;
	}

	public void setPercentage( java.math.BigDecimal value ) {
		this.__percentage = value;
	}

	public java.lang.Integer getEmpStatus() {
		return this.__emp_status;
	}

	public void setEmpStatus( java.lang.Integer value ) {
		this.__emp_status = value;
	}

	public static String getKeyColumnName() {
		String name ="";
		name = CS_PROCESS_POOLED_TASK_ID;
		name = CS_PROCESS_INSTANCE_ACTIVITY_ID;
		name = CS_PROFESSIONAL_APPROVAL__ID;
		return name;
	}

	public void cloneCopy(BaseOnLoadAuditListOfProfessionalApproval __bean){
		__bean.setProcessTypeName(getProcessTypeName());
		__bean.setProcessPooledTaskId(getProcessPooledTaskId());
		__bean.setTypeFlag(getTypeFlag());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessActivityId(getProcessActivityId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setNodeType(getNodeType());
		__bean.setActivityId(getActivityId());
		__bean.setNextActivityId(getNextActivityId());
		__bean.setMainActivityId(getMainActivityId());
		__bean.setInstanceActivityCreateTime(getInstanceActivityCreateTime());
		__bean.setInstanceActivityStartTime(getInstanceActivityStartTime());
		__bean.setOperateTime(getOperateTime());
		__bean.setProcessComment(getProcessComment());
		__bean.setStatus(getStatus());
		__bean.setActivityType(getActivityType());
		__bean.setBackViewName(getBackViewName());
		__bean.setProfessionalApproval_id(getProfessionalApproval_id());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setStartDate(getStartDate());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setProjectId(getProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setPlateId(getPlateId());
		__bean.setDesignType(getDesignType());
		__bean.setProjectType(getProjectType());
		__bean.setPlateManagerId(getPlateManagerId());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setDepartmentManagerId(getDepartmentManagerId());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setProjectManageName(getProjectManageName());
		__bean.setProjectManageDepartmentId(getProjectManageDepartmentId());
		__bean.setCommonArea(getCommonArea());
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setCadArea(getCadArea());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setPercentage(getPercentage());
		__bean.setEmpStatus(getEmpStatus());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessTypeName() == null ? "" : getProcessTypeName());
		sb.append(",");
		sb.append(getProcessPooledTaskId() == null ? "" : getProcessPooledTaskId());
		sb.append(",");
		sb.append(getTypeFlag() == null ? "" : getTypeFlag());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessActivityId() == null ? "" : getProcessActivityId());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getNodeType() == null ? "" : getNodeType());
		sb.append(",");
		sb.append(getActivityId() == null ? "" : getActivityId());
		sb.append(",");
		sb.append(getNextActivityId() == null ? "" : getNextActivityId());
		sb.append(",");
		sb.append(getMainActivityId() == null ? "" : getMainActivityId());
		sb.append(",");
		sb.append(getInstanceActivityCreateTime() == null ? "" : sdf.format(getInstanceActivityCreateTime()));
		sb.append(",");
		sb.append(getInstanceActivityStartTime() == null ? "" : sdf.format(getInstanceActivityStartTime()));
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getProcessComment() == null ? "" : getProcessComment());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_11", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getActivityType() == null ? "" : getActivityType());
		sb.append(",");
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		sb.append(",");
		sb.append(getProfessionalApproval_id() == null ? "" : getProfessionalApproval_id());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_6", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getDesignType() == null ? "" : getDesignType());
		sb.append(",");
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_32", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		sb.append(getPlateManagerId() == null ? "" : getPlateManagerId());
		sb.append(",");
		String strProjectLevel = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getProjectLevel()));
		sb.append(strProjectLevel == null ? "" : strProjectLevel);
		sb.append(",");
		sb.append(getDepartmentManagerId() == null ? "" : getDepartmentManagerId());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getProjectManageName() == null ? "" : getProjectManageName());
		sb.append(",");
		sb.append(getProjectManageDepartmentId() == null ? "" : getProjectManageDepartmentId());
		sb.append(",");
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getCadArea() == null ? "" : getCadArea());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getPercentage() == null ? "" : getPercentage());
		sb.append(",");
		sb.append(getEmpStatus() == null ? "" : getEmpStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadAuditListOfProfessionalApproval o) {
		return __process_pooled_task_id == null || o.getProcessPooledTaskId() == null ? -1 : __process_pooled_task_id.compareTo(o.getProcessPooledTaskId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type_name);
		hash = 97 * hash + Objects.hashCode(this.__process_pooled_task_id);
		hash = 97 * hash + Objects.hashCode(this.__type_flag);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__node_type);
		hash = 97 * hash + Objects.hashCode(this.__activity_id);
		hash = 97 * hash + Objects.hashCode(this.__next_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__main_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_create_time);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_start_time);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__process_comment);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__activity_type);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__professional_approval__id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__design_type);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__department_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_name);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_department_id);
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__cad_area);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__percentage);
		hash = 97 * hash + Objects.hashCode(this.__emp_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadAuditListOfProfessionalApproval o = (BaseOnLoadAuditListOfProfessionalApproval)obj;
		if(!Objects.equals(this.__process_type_name, o.getProcessTypeName())) return false;
		if(!Objects.equals(this.__process_pooled_task_id, o.getProcessPooledTaskId())) return false;
		if(!Objects.equals(this.__type_flag, o.getTypeFlag())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_activity_id, o.getProcessActivityId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__node_type, o.getNodeType())) return false;
		if(!Objects.equals(this.__activity_id, o.getActivityId())) return false;
		if(!Objects.equals(this.__next_activity_id, o.getNextActivityId())) return false;
		if(!Objects.equals(this.__main_activity_id, o.getMainActivityId())) return false;
		if(!Objects.equals(this.__instance_activity_create_time, o.getInstanceActivityCreateTime())) return false;
		if(!Objects.equals(this.__instance_activity_start_time, o.getInstanceActivityStartTime())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__process_comment, o.getProcessComment())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__activity_type, o.getActivityType())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__professional_approval__id, o.getProfessionalApproval_id())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__design_type, o.getDesignType())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__plate_manager_id, o.getPlateManagerId())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__department_manager_id, o.getDepartmentManagerId())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__project_manage_name, o.getProjectManageName())) return false;
		if(!Objects.equals(this.__project_manage_department_id, o.getProjectManageDepartmentId())) return false;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__cad_area, o.getCadArea())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__percentage, o.getPercentage())) return false;
		if(!Objects.equals(this.__emp_status, o.getEmpStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessTypeName() != null) sb.append(__wrapString(count++, NAME_PROCESS_TYPE_NAME, getProcessTypeName()));
		if(getProcessPooledTaskId() != null) sb.append(__wrapNumber(count++, NAME_PROCESS_POOLED_TASK_ID, getProcessPooledTaskId()));
		if(getTypeFlag() != null) sb.append(__wrapNumber(count++, NAME_TYPE_FLAG, getTypeFlag()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, NAME_PROCESS_INSTANCE_ACTIVITY_ID, getProcessInstanceActivityId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, NAME_BUSINESS_ID, getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, NAME_BUSINESS_NAME, getBusinessName()));
		if(getProcessActivityId() != null) sb.append(__wrapNumber(count++, NAME_PROCESS_ACTIVITY_ID, getProcessActivityId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, NAME_PROCESS_ID, getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, NAME_PROCESS_INSTANCE_ID, getProcessInstanceId()));
		if(getNodeType() != null) sb.append(__wrapNumber(count++, NAME_NODE_TYPE, getNodeType()));
		if(getActivityId() != null) sb.append(__wrapNumber(count++, NAME_ACTIVITY_ID, getActivityId()));
		if(getNextActivityId() != null) sb.append(__wrapNumber(count++, NAME_NEXT_ACTIVITY_ID, getNextActivityId()));
		if(getMainActivityId() != null) sb.append(__wrapNumber(count++, NAME_MAIN_ACTIVITY_ID, getMainActivityId()));
		if(getInstanceActivityCreateTime() != null) sb.append(__wrapDate(count++, NAME_INSTANCE_ACTIVITY_CREATE_TIME, getInstanceActivityCreateTime()));
		if(getInstanceActivityStartTime() != null) sb.append(__wrapDate(count++, NAME_INSTANCE_ACTIVITY_START_TIME, getInstanceActivityStartTime()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, NAME_OPERATE_TIME, getOperateTime()));
		if(getProcessComment() != null) sb.append(__wrapString(count++, NAME_PROCESS_COMMENT, getProcessComment()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, NAME_STATUS, getStatus()));
		if(getActivityType() != null) sb.append(__wrapNumber(count++, NAME_ACTIVITY_TYPE, getActivityType()));
		if(getBackViewName() != null) sb.append(__wrapString(count++, NAME_BACK_VIEW_NAME, getBackViewName()));
		if(getProfessionalApproval_id() != null) sb.append(__wrapNumber(count++, NAME_PROFESSIONAL_APPROVAL__ID, getProfessionalApproval_id()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, NAME_EMPLOYEE_NO, getEmployeeNo()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, NAME_START_DATE, getStartDate()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, NAME_DELETE_FLAG, getDeleteFlag()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_ID, getProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, NAME_PROJECT_CODE, getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, NAME_PROJECT_NAME, getProjectName()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, NAME_CONTRACT_ID, getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, NAME_CONTRACT_CODE, getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, NAME_CONTRACT_NAME, getContractName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, NAME_PLATE_ID, getPlateId()));
		if(getDesignType() != null) sb.append(__wrapNumber(count++, NAME_DESIGN_TYPE, getDesignType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_TYPE, getProjectType()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, NAME_PLATE_MANAGER_ID, getPlateManagerId()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_LEVEL, getProjectLevel()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, NAME_DEPARTMENT_MANAGER_ID, getDepartmentManagerId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_MANAGE_ID, getProjectManageId()));
		if(getProjectManageName() != null) sb.append(__wrapString(count++, NAME_PROJECT_MANAGE_NAME, getProjectManageName()));
		if(getProjectManageDepartmentId() != null) sb.append(__wrapNumber(count++, NAME_PROJECT_MANAGE_DEPARTMENT_ID, getProjectManageDepartmentId()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, NAME_COMMON_AREA, getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, NAME_LOGISTICS_AREA, getLogisticsArea()));
		if(getCadArea() != null) sb.append(__wrapDecimal(count++, NAME_CAD_AREA, getCadArea()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, NAME_TOTAL_INTEGRAL, getTotalIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, NAME_PROJECT_INTEGRAL, getProjectIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, NAME_RESERVE_INTEGRAL, getReserveIntegral()));
		if(getPercentage() != null) sb.append(__wrapDecimal(count++, NAME_PERCENTAGE, getPercentage()));
		if(getEmpStatus() != null) sb.append(__wrapNumber(count++, NAME_EMP_STATUS, getEmpStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessTypeName() != null) res.put(NAME_PROCESS_TYPE_NAME, getProcessTypeName());
		if(getProcessPooledTaskId() != null) res.put(NAME_PROCESS_POOLED_TASK_ID, getProcessPooledTaskId());
		if(getTypeFlag() != null) res.put(NAME_TYPE_FLAG, getTypeFlag());
		if(getProcessInstanceActivityId() != null) res.put(NAME_PROCESS_INSTANCE_ACTIVITY_ID, getProcessInstanceActivityId());
		if(getBusinessId() != null) res.put(NAME_BUSINESS_ID, getBusinessId());
		if(getBusinessName() != null) res.put(NAME_BUSINESS_NAME, getBusinessName());
		if(getProcessActivityId() != null) res.put(NAME_PROCESS_ACTIVITY_ID, getProcessActivityId());
		if(getProcessId() != null) res.put(NAME_PROCESS_ID, getProcessId());
		if(getProcessInstanceId() != null) res.put(NAME_PROCESS_INSTANCE_ID, getProcessInstanceId());
		if(getNodeType() != null) res.put(NAME_NODE_TYPE, getNodeType());
		if(getActivityId() != null) res.put(NAME_ACTIVITY_ID, getActivityId());
		if(getNextActivityId() != null) res.put(NAME_NEXT_ACTIVITY_ID, getNextActivityId());
		if(getMainActivityId() != null) res.put(NAME_MAIN_ACTIVITY_ID, getMainActivityId());
		if(getInstanceActivityCreateTime() != null) res.put(NAME_INSTANCE_ACTIVITY_CREATE_TIME, getInstanceActivityCreateTime());
		if(getInstanceActivityStartTime() != null) res.put(NAME_INSTANCE_ACTIVITY_START_TIME, getInstanceActivityStartTime());
		if(getOperateTime() != null) res.put(NAME_OPERATE_TIME, getOperateTime());
		if(getProcessComment() != null) res.put(NAME_PROCESS_COMMENT, getProcessComment());
		if(getStatus() != null) res.put(NAME_STATUS, getStatus());
		if(getActivityType() != null) res.put(NAME_ACTIVITY_TYPE, getActivityType());
		if(getBackViewName() != null) res.put(NAME_BACK_VIEW_NAME, getBackViewName());
		if(getProfessionalApproval_id() != null) res.put(NAME_PROFESSIONAL_APPROVAL__ID, getProfessionalApproval_id());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getEmployeeNo() != null) res.put(NAME_EMPLOYEE_NO, getEmployeeNo());
		if(getStartDate() != null) res.put(NAME_START_DATE, getStartDate());
		if(getDeleteFlag() != null) res.put(NAME_DELETE_FLAG, getDeleteFlag());
		if(getProjectId() != null) res.put(NAME_PROJECT_ID, getProjectId());
		if(getProjectCode() != null) res.put(NAME_PROJECT_CODE, getProjectCode());
		if(getProjectName() != null) res.put(NAME_PROJECT_NAME, getProjectName());
		if(getContractId() != null) res.put(NAME_CONTRACT_ID, getContractId());
		if(getContractCode() != null) res.put(NAME_CONTRACT_CODE, getContractCode());
		if(getContractName() != null) res.put(NAME_CONTRACT_NAME, getContractName());
		if(getPlateId() != null) res.put(NAME_PLATE_ID, getPlateId());
		if(getDesignType() != null) res.put(NAME_DESIGN_TYPE, getDesignType());
		if(getProjectType() != null) res.put(NAME_PROJECT_TYPE, getProjectType());
		if(getPlateManagerId() != null) res.put(NAME_PLATE_MANAGER_ID, getPlateManagerId());
		if(getProjectLevel() != null) res.put(NAME_PROJECT_LEVEL, getProjectLevel());
		if(getDepartmentManagerId() != null) res.put(NAME_DEPARTMENT_MANAGER_ID, getDepartmentManagerId());
		if(getProjectManageId() != null) res.put(NAME_PROJECT_MANAGE_ID, getProjectManageId());
		if(getProjectManageName() != null) res.put(NAME_PROJECT_MANAGE_NAME, getProjectManageName());
		if(getProjectManageDepartmentId() != null) res.put(NAME_PROJECT_MANAGE_DEPARTMENT_ID, getProjectManageDepartmentId());
		if(getCommonArea() != null) res.put(NAME_COMMON_AREA, getCommonArea());
		if(getLogisticsArea() != null) res.put(NAME_LOGISTICS_AREA, getLogisticsArea());
		if(getCadArea() != null) res.put(NAME_CAD_AREA, getCadArea());
		if(getTotalIntegral() != null) res.put(NAME_TOTAL_INTEGRAL, getTotalIntegral());
		if(getProjectIntegral() != null) res.put(NAME_PROJECT_INTEGRAL, getProjectIntegral());
		if(getReserveIntegral() != null) res.put(NAME_RESERVE_INTEGRAL, getReserveIntegral());
		if(getPercentage() != null) res.put(NAME_PERCENTAGE, getPercentage());
		if(getEmpStatus() != null) res.put(NAME_EMP_STATUS, getEmpStatus());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseOnLoadAuditListOfProfessionalApproval> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseOnLoadAuditListOfProfessionalApproval b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_PROCESS_TYPE_NAME) && (val = values.get(NAME_PROCESS_TYPE_NAME)) != null) setProcessTypeName(__getString(val));
		if(values.containsKey(NAME_PROCESS_POOLED_TASK_ID) && (val = values.get(NAME_PROCESS_POOLED_TASK_ID)) != null) setProcessPooledTaskId(__getInt(val)); 
		if(values.containsKey(NAME_TYPE_FLAG) && (val = values.get(NAME_TYPE_FLAG)) != null) setTypeFlag(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_INSTANCE_ACTIVITY_ID) && (val = values.get(NAME_PROCESS_INSTANCE_ACTIVITY_ID)) != null) setProcessInstanceActivityId(__getInt(val)); 
		if(values.containsKey(NAME_BUSINESS_ID) && (val = values.get(NAME_BUSINESS_ID)) != null) setBusinessId(__getInt(val)); 
		if(values.containsKey(NAME_BUSINESS_NAME) && (val = values.get(NAME_BUSINESS_NAME)) != null) setBusinessName(__getString(val));
		if(values.containsKey(NAME_PROCESS_ACTIVITY_ID) && (val = values.get(NAME_PROCESS_ACTIVITY_ID)) != null) setProcessActivityId(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_ID) && (val = values.get(NAME_PROCESS_ID)) != null) setProcessId(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_INSTANCE_ID) && (val = values.get(NAME_PROCESS_INSTANCE_ID)) != null) setProcessInstanceId(__getInt(val)); 
		if(values.containsKey(NAME_NODE_TYPE) && (val = values.get(NAME_NODE_TYPE)) != null) setNodeType(__getInt(val)); 
		if(values.containsKey(NAME_ACTIVITY_ID) && (val = values.get(NAME_ACTIVITY_ID)) != null) setActivityId(__getInt(val)); 
		if(values.containsKey(NAME_NEXT_ACTIVITY_ID) && (val = values.get(NAME_NEXT_ACTIVITY_ID)) != null) setNextActivityId(__getInt(val)); 
		if(values.containsKey(NAME_MAIN_ACTIVITY_ID) && (val = values.get(NAME_MAIN_ACTIVITY_ID)) != null) setMainActivityId(__getInt(val)); 
		if(values.containsKey(NAME_INSTANCE_ACTIVITY_CREATE_TIME) && (val = values.get(NAME_INSTANCE_ACTIVITY_CREATE_TIME)) != null) setInstanceActivityCreateTime(__getDate(val)); 
		if(values.containsKey(NAME_INSTANCE_ACTIVITY_START_TIME) && (val = values.get(NAME_INSTANCE_ACTIVITY_START_TIME)) != null) setInstanceActivityStartTime(__getDate(val)); 
		if(values.containsKey(NAME_OPERATE_TIME) && (val = values.get(NAME_OPERATE_TIME)) != null) setOperateTime(__getDate(val)); 
		if(values.containsKey(NAME_PROCESS_COMMENT) && (val = values.get(NAME_PROCESS_COMMENT)) != null) setProcessComment(__getString(val));
		if(values.containsKey(NAME_STATUS) && (val = values.get(NAME_STATUS)) != null) setStatus(__getInt(val)); 
		if(values.containsKey(NAME_ACTIVITY_TYPE) && (val = values.get(NAME_ACTIVITY_TYPE)) != null) setActivityType(__getInt(val)); 
		if(values.containsKey(NAME_BACK_VIEW_NAME) && (val = values.get(NAME_BACK_VIEW_NAME)) != null) setBackViewName(__getString(val));
		if(values.containsKey(NAME_PROFESSIONAL_APPROVAL__ID) && (val = values.get(NAME_PROFESSIONAL_APPROVAL__ID)) != null) setProfessionalApproval_id(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_NO) && (val = values.get(NAME_EMPLOYEE_NO)) != null) setEmployeeNo(__getString(val));
		if(values.containsKey(NAME_START_DATE) && (val = values.get(NAME_START_DATE)) != null) setStartDate(__getDate(val)); 
		if(values.containsKey(NAME_DELETE_FLAG) && (val = values.get(NAME_DELETE_FLAG)) != null) setDeleteFlag(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_ID) && (val = values.get(NAME_PROJECT_ID)) != null) setProjectId(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_CODE) && (val = values.get(NAME_PROJECT_CODE)) != null) setProjectCode(__getString(val));
		if(values.containsKey(NAME_PROJECT_NAME) && (val = values.get(NAME_PROJECT_NAME)) != null) setProjectName(__getString(val));
		if(values.containsKey(NAME_CONTRACT_ID) && (val = values.get(NAME_CONTRACT_ID)) != null) setContractId(__getInt(val)); 
		if(values.containsKey(NAME_CONTRACT_CODE) && (val = values.get(NAME_CONTRACT_CODE)) != null) setContractCode(__getString(val));
		if(values.containsKey(NAME_CONTRACT_NAME) && (val = values.get(NAME_CONTRACT_NAME)) != null) setContractName(__getString(val));
		if(values.containsKey(NAME_PLATE_ID) && (val = values.get(NAME_PLATE_ID)) != null) setPlateId(__getInt(val)); 
		if(values.containsKey(NAME_DESIGN_TYPE) && (val = values.get(NAME_DESIGN_TYPE)) != null) setDesignType(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_TYPE) && (val = values.get(NAME_PROJECT_TYPE)) != null) setProjectType(__getInt(val)); 
		if(values.containsKey(NAME_PLATE_MANAGER_ID) && (val = values.get(NAME_PLATE_MANAGER_ID)) != null) setPlateManagerId(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_LEVEL) && (val = values.get(NAME_PROJECT_LEVEL)) != null) setProjectLevel(__getInt(val)); 
		if(values.containsKey(NAME_DEPARTMENT_MANAGER_ID) && (val = values.get(NAME_DEPARTMENT_MANAGER_ID)) != null) setDepartmentManagerId(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_MANAGE_ID) && (val = values.get(NAME_PROJECT_MANAGE_ID)) != null) setProjectManageId(__getInt(val)); 
		if(values.containsKey(NAME_PROJECT_MANAGE_NAME) && (val = values.get(NAME_PROJECT_MANAGE_NAME)) != null) setProjectManageName(__getString(val));
		if(values.containsKey(NAME_PROJECT_MANAGE_DEPARTMENT_ID) && (val = values.get(NAME_PROJECT_MANAGE_DEPARTMENT_ID)) != null) setProjectManageDepartmentId(__getInt(val)); 
		if(values.containsKey(NAME_COMMON_AREA) && (val = values.get(NAME_COMMON_AREA)) != null) setCommonArea(__getDecimal(val));  
		if(values.containsKey(NAME_LOGISTICS_AREA) && (val = values.get(NAME_LOGISTICS_AREA)) != null) setLogisticsArea(__getDecimal(val));  
		if(values.containsKey(NAME_CAD_AREA) && (val = values.get(NAME_CAD_AREA)) != null) setCadArea(__getDecimal(val));  
		if(values.containsKey(NAME_TOTAL_INTEGRAL) && (val = values.get(NAME_TOTAL_INTEGRAL)) != null) setTotalIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_PROJECT_INTEGRAL) && (val = values.get(NAME_PROJECT_INTEGRAL)) != null) setProjectIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_RESERVE_INTEGRAL) && (val = values.get(NAME_RESERVE_INTEGRAL)) != null) setReserveIntegral(__getDecimal(val));  
		if(values.containsKey(NAME_PERCENTAGE) && (val = values.get(NAME_PERCENTAGE)) != null) setPercentage(__getDecimal(val));  
		if(values.containsKey(NAME_EMP_STATUS) && (val = values.get(NAME_EMP_STATUS)) != null) setEmpStatus(__getInt(val)); 
	}

	protected java.lang.String  __process_type_name ;
	protected java.lang.Integer  __process_pooled_task_id ;
	protected java.lang.Integer  __type_flag ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_activity_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __node_type ;
	protected java.lang.Integer  __activity_id ;
	protected java.lang.Integer  __next_activity_id ;
	protected java.lang.Integer  __main_activity_id ;
	protected java.util.Date  __instance_activity_create_time ;
	protected java.util.Date  __instance_activity_start_time ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __process_comment ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __activity_type ;
	protected java.lang.String  __back_view_name ;
	protected java.lang.Integer  __professional_approval__id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.util.Date  __start_date ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __design_type ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __plate_manager_id ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.Integer  __department_manager_id ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.String  __project_manage_name ;
	protected java.lang.Integer  __project_manage_department_id ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __cad_area ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __percentage ;
	protected java.lang.Integer  __emp_status ;
}
