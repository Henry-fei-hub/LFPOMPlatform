package pomplatform.workflow.professional.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadApplyListOfProfessionalApproval extends GenericBase implements BaseFactory<BaseOnLoadApplyListOfProfessionalApproval>, Comparable<BaseOnLoadApplyListOfProfessionalApproval> 
{


	public static BaseOnLoadApplyListOfProfessionalApproval newInstance(){
		return new BaseOnLoadApplyListOfProfessionalApproval();
	}

	@Override
	public BaseOnLoadApplyListOfProfessionalApproval make(){
		BaseOnLoadApplyListOfProfessionalApproval b = new BaseOnLoadApplyListOfProfessionalApproval();
		return b;
	}

	public final static String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static String CS_BUSINESS_ID = "business_id" ;
	public final static String CS_BUSINESS_NAME = "business_name" ;
	public final static String CS_PROCESS_ID = "process_id" ;
	public final static String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static String CS_PROCESS_STATUS = "process_status" ;
	public final static String CS_COMPLETE_TIME = "complete_time" ;
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

	public final static String ALL_CAPTIONS = "主键编码,业务编码,业务名称,流程编码,活动实列编码,流程状态 0 发起中  1,完成时间,专业负责人审批编码,创建人,工号,开始日期,删除状态  0未删除    1已删除,项目编码,项目编号,项目名称,合同编码,合同编号,合同名称,业务部门,业务类别,项目类别,事业部负责人,项目等级,部门经理,积分管理员,专业负责人名称,专业负责人部门,公区面积,后勤面积,设计面积,项目总积分,项目积分,预留积分,核算比例";

	public Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( Integer value ) {
		this.__process_instance_id = value;
	}

	public Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( Integer value ) {
		this.__business_id = value;
	}

	public String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( String value ) {
		this.__business_name = value;
	}

	public Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( Integer value ) {
		this.__process_id = value;
	}

	public Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( Integer value ) {
		this.__process_status = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public Integer getProfessionalApproval_id() {
		return this.__professional_approval__id;
	}

	public void setProfessionalApproval_id( Integer value ) {
		this.__professional_approval__id = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( String value ) {
		this.__employee_no = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( Integer value ) {
		this.__delete_flag = value;
	}

	public Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( Integer value ) {
		this.__project_id = value;
	}

	public String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( String value ) {
		this.__project_code = value;
	}

	public String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( String value ) {
		this.__project_name = value;
	}

	public Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( Integer value ) {
		this.__contract_id = value;
	}

	public String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( String value ) {
		this.__contract_code = value;
	}

	public String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( String value ) {
		this.__contract_name = value;
	}

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	public Integer getDesignType() {
		return this.__design_type;
	}

	public void setDesignType( Integer value ) {
		this.__design_type = value;
	}

	public Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( Integer value ) {
		this.__project_type = value;
	}

	public Integer getPlateManagerId() {
		return this.__plate_manager_id;
	}

	public void setPlateManagerId( Integer value ) {
		this.__plate_manager_id = value;
	}

	public Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( Integer value ) {
		this.__project_level = value;
	}

	public Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( Integer value ) {
		this.__department_manager_id = value;
	}

	public Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( Integer value ) {
		this.__project_manage_id = value;
	}

	public String getProjectManageName() {
		return this.__project_manage_name;
	}

	public void setProjectManageName( String value ) {
		this.__project_manage_name = value;
	}

	public Integer getProjectManageDepartmentId() {
		return this.__project_manage_department_id;
	}

	public void setProjectManageDepartmentId( Integer value ) {
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

	public void cloneCopy(BaseOnLoadApplyListOfProfessionalApproval __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCompleteTime(getCompleteTime());
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
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getProfessionalApproval_id() == null ? "" : getProfessionalApproval_id());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strEmployeeNo = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getEmployeeNo()));
		sb.append(strEmployeeNo == null ? "" : strEmployeeNo);
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDesignType() == null ? "" : getDesignType());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getPlateManagerId() == null ? "" : getPlateManagerId());
		sb.append(",");
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadApplyListOfProfessionalApproval o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadApplyListOfProfessionalApproval o = (BaseOnLoadApplyListOfProfessionalApproval)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
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
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getProfessionalApproval_id() != null) sb.append(__wrapNumber(count++, "professionalApproval_id", getProfessionalApproval_id()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDesignType() != null) sb.append(__wrapNumber(count++, "designType", getDesignType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, "plateManagerId", getPlateManagerId()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, "departmentManagerId", getDepartmentManagerId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getProjectManageName() != null) sb.append(__wrapString(count++, "projectManageName", getProjectManageName()));
		if(getProjectManageDepartmentId() != null) sb.append(__wrapNumber(count++, "projectManageDepartmentId", getProjectManageDepartmentId()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, "commonArea", getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, "logisticsArea", getLogisticsArea()));
		if(getCadArea() != null) sb.append(__wrapDecimal(count++, "cadArea", getCadArea()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getPercentage() != null) sb.append(__wrapDecimal(count++, "percentage", getPercentage()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceActivityId() != null) res.put("processInstanceActivityId", getProcessInstanceActivityId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getProfessionalApproval_id() != null) res.put("professionalApproval_id", getProfessionalApproval_id());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getDesignType() != null) res.put("designType", getDesignType());
		if(getProjectType() != null) res.put("projectType", getProjectType());
		if(getPlateManagerId() != null) res.put("plateManagerId", getPlateManagerId());
		if(getProjectLevel() != null) res.put("projectLevel", getProjectLevel());
		if(getDepartmentManagerId() != null) res.put("departmentManagerId", getDepartmentManagerId());
		if(getProjectManageId() != null) res.put("projectManageId", getProjectManageId());
		if(getProjectManageName() != null) res.put("projectManageName", getProjectManageName());
		if(getProjectManageDepartmentId() != null) res.put("projectManageDepartmentId", getProjectManageDepartmentId());
		if(getCommonArea() != null) res.put("commonArea", getCommonArea());
		if(getLogisticsArea() != null) res.put("logisticsArea", getLogisticsArea());
		if(getCadArea() != null) res.put("cadArea", getCadArea());
		if(getTotalIntegral() != null) res.put("totalIntegral", getTotalIntegral());
		if(getProjectIntegral() != null) res.put("projectIntegral", getProjectIntegral());
		if(getReserveIntegral() != null) res.put("reserveIntegral", getReserveIntegral());
		if(getPercentage() != null) res.put("percentage", getPercentage());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("professionalApproval_id")) != null) setProfessionalApproval_id(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("designType")) != null) setDesignType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("plateManagerId")) != null) setPlateManagerId(__getInt(val)); 
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("projectManageName")) != null) setProjectManageName(__getString(val));
		if((val = values.get("projectManageDepartmentId")) != null) setProjectManageDepartmentId(__getInt(val)); 
		if((val = values.get("commonArea")) != null) setCommonArea(__getDecimal(val));  
		if((val = values.get("logisticsArea")) != null) setLogisticsArea(__getDecimal(val));  
		if((val = values.get("cadArea")) != null) setCadArea(__getDecimal(val));  
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("percentage")) != null) setPercentage(__getDecimal(val));  
	}

	protected Integer  __process_instance_id ;
	protected Integer  __business_id ;
	protected String  __business_name ;
	protected Integer  __process_id ;
	protected Integer  __process_instance_activity_id ;
	protected Integer  __process_status ;
	protected java.util.Date  __complete_time ;
	protected Integer  __professional_approval__id ;
	protected Integer  __employee_id ;
	protected String  __employee_no ;
	protected java.util.Date  __start_date ;
	protected Integer  __delete_flag ;
	protected Integer  __project_id ;
	protected String  __project_code ;
	protected String  __project_name ;
	protected Integer  __contract_id ;
	protected String  __contract_code ;
	protected String  __contract_name ;
	protected Integer  __plate_id ;
	protected Integer  __design_type ;
	protected Integer  __project_type ;
	protected Integer  __plate_manager_id ;
	protected Integer  __project_level ;
	protected Integer  __department_manager_id ;
	protected Integer  __project_manage_id ;
	protected String  __project_manage_name ;
	protected Integer  __project_manage_department_id ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __cad_area ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __percentage ;
}
