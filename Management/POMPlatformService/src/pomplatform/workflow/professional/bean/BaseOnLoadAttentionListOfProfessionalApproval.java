package pomplatform.workflow.professional.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadAttentionListOfProfessionalApproval extends GenericBase implements BaseFactory<BaseOnLoadAttentionListOfProfessionalApproval>, Comparable<BaseOnLoadAttentionListOfProfessionalApproval> 
{


	public static BaseOnLoadAttentionListOfProfessionalApproval newInstance(){
		return new BaseOnLoadAttentionListOfProfessionalApproval();
	}

	@Override
	public BaseOnLoadAttentionListOfProfessionalApproval make(){
		BaseOnLoadAttentionListOfProfessionalApproval b = new BaseOnLoadAttentionListOfProfessionalApproval();
		return b;
	}

	public final static java.lang.String CS_SYSTEM_PROCESS_ATTENTION_ID = "system_process_attention_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ACTIVITY_ID = "process_activity_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_ID = "instance_activity_id" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_CREATE_TIME = "instance_activity_create_time" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_PROCESS_COMMENT = "process_comment" ;
	public final static java.lang.String CS_PROFESSIONAL_APPROVAL__ID = "professional_approval__id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DESIGN_TYPE = "design_type" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_PLATE_MANAGER_ID = "plate_manager_id" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_NAME = "project_manage_name" ;
	public final static java.lang.String CS_PROJECT_MANAGE_DEPARTMENT_ID = "project_manage_department_id" ;
	public final static java.lang.String CS_COMMON_AREA = "common_area" ;
	public final static java.lang.String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static java.lang.String CS_CAD_AREA = "cad_area" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_PERCENTAGE = "percentage" ;
	public final static java.lang.String CS_EMP_STATUS = "emp_status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,业务名称,活动编码,流程编码,主键编码,返回数据集,流程实例节点编码,流程实例节点创建时间,流程实例节点开始处于活动时间,状态,操作时间,提交意见,专业负责人审批编码,处理人,工号,开始日期,删除状态  0未删除    1已删除,项目编码,项目编号,项目名称,合同编码,合同编号,合同名称,业务部门,业务类别,项目类别,事业部负责人,项目等级,部门经理,积分管理员,专业负责人名称,专业负责人部门,公区面积,后勤面积,设计面积,项目总积分,项目积分,预留积分,核算比例,";

	public java.lang.Integer getSystemProcessAttentionId() {
		return this.__system_process_attention_id;
	}

	public void setSystemProcessAttentionId( java.lang.Integer value ) {
		this.__system_process_attention_id = value;
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

	public java.lang.String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( java.lang.String value ) {
		this.__back_view_name = value;
	}

	public java.lang.Integer getInstanceActivityId() {
		return this.__instance_activity_id;
	}

	public void setInstanceActivityId( java.lang.Integer value ) {
		this.__instance_activity_id = value;
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
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

	public void cloneCopy(BaseOnLoadAttentionListOfProfessionalApproval __bean){
		__bean.setSystemProcessAttentionId(getSystemProcessAttentionId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessActivityId(getProcessActivityId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBackViewName(getBackViewName());
		__bean.setInstanceActivityId(getInstanceActivityId());
		__bean.setInstanceActivityCreateTime(getInstanceActivityCreateTime());
		__bean.setInstanceActivityStartTime(getInstanceActivityStartTime());
		__bean.setStatus(getStatus());
		__bean.setOperateTime(getOperateTime());
		__bean.setProcessComment(getProcessComment());
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
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSystemProcessAttentionId() == null ? "" : getSystemProcessAttentionId());
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
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		sb.append(",");
		sb.append(getInstanceActivityId() == null ? "" : getInstanceActivityId());
		sb.append(",");
		sb.append(getInstanceActivityCreateTime() == null ? "" : sdf.format(getInstanceActivityCreateTime()));
		sb.append(",");
		sb.append(getInstanceActivityStartTime() == null ? "" : sdf.format(getInstanceActivityStartTime()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getProcessComment() == null ? "" : getProcessComment());
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
		sb.append(",");
		sb.append(getEmpStatus() == null ? "" : getEmpStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadAttentionListOfProfessionalApproval o) {
		return __system_process_attention_id == null ? -1 : __system_process_attention_id.compareTo(o.getSystemProcessAttentionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__system_process_attention_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_create_time);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_start_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__process_comment);
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
		final BaseOnLoadAttentionListOfProfessionalApproval o = (BaseOnLoadAttentionListOfProfessionalApproval)obj;
		if(!Objects.equals(this.__system_process_attention_id, o.getSystemProcessAttentionId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_activity_id, o.getProcessActivityId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__instance_activity_id, o.getInstanceActivityId())) return false;
		if(!Objects.equals(this.__instance_activity_create_time, o.getInstanceActivityCreateTime())) return false;
		if(!Objects.equals(this.__instance_activity_start_time, o.getInstanceActivityStartTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__process_comment, o.getProcessComment())) return false;
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
		if(getSystemProcessAttentionId() != null) sb.append(__wrapNumber(count++, "systemProcessAttentionId", getSystemProcessAttentionId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessActivityId() != null) sb.append(__wrapNumber(count++, "processActivityId", getProcessActivityId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBackViewName() != null) sb.append(__wrapString(count++, "backViewName", getBackViewName()));
		if(getInstanceActivityId() != null) sb.append(__wrapNumber(count++, "instanceActivityId", getInstanceActivityId()));
		if(getInstanceActivityCreateTime() != null) sb.append(__wrapDate(count++, "instanceActivityCreateTime", getInstanceActivityCreateTime()));
		if(getInstanceActivityStartTime() != null) sb.append(__wrapDate(count++, "instanceActivityStartTime", getInstanceActivityStartTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getProcessComment() != null) sb.append(__wrapString(count++, "processComment", getProcessComment()));
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
		if(getEmpStatus() != null) sb.append(__wrapNumber(count++, "empStatus", getEmpStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSystemProcessAttentionId() != null) res.put("systemProcessAttentionId", getSystemProcessAttentionId());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getProcessActivityId() != null) res.put("processActivityId", getProcessActivityId());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getBackViewName() != null) res.put("backViewName", getBackViewName());
		if(getInstanceActivityId() != null) res.put("instanceActivityId", getInstanceActivityId());
		if(getInstanceActivityCreateTime() != null) res.put("instanceActivityCreateTime", getInstanceActivityCreateTime());
		if(getInstanceActivityStartTime() != null) res.put("instanceActivityStartTime", getInstanceActivityStartTime());
		if(getStatus() != null) res.put("status", getStatus());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getProcessComment() != null) res.put("processComment", getProcessComment());
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
		if(getEmpStatus() != null) res.put("empStatus", getEmpStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("systemProcessAttentionId")) != null) setSystemProcessAttentionId(__getInt(val));
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val));
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processActivityId")) != null) setProcessActivityId(__getInt(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val));
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val));
		if((val = values.get("backViewName")) != null) setBackViewName(__getString(val));
		if((val = values.get("instanceActivityId")) != null) setInstanceActivityId(__getInt(val));
		if((val = values.get("instanceActivityCreateTime")) != null) setInstanceActivityCreateTime(__getDate(val));
		if((val = values.get("instanceActivityStartTime")) != null) setInstanceActivityStartTime(__getDate(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val));
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val));
		if((val = values.get("processComment")) != null) setProcessComment(__getString(val));
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
		if((val = values.get("empStatus")) != null) setEmpStatus(__getInt(val));
	}

	protected java.lang.Integer  __system_process_attention_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_activity_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.String  __back_view_name ;
	protected java.lang.Integer  __instance_activity_id ;
	protected java.util.Date  __instance_activity_create_time ;
	protected java.util.Date  __instance_activity_start_time ;
	protected java.lang.Integer  __status ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __process_comment ;
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
