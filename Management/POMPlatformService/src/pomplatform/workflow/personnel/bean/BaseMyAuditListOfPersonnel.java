package pomplatform.workflow.personnel.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMyAuditListOfPersonnel extends GenericBase implements BaseFactory<BaseMyAuditListOfPersonnel>, Comparable<BaseMyAuditListOfPersonnel> 
{


	public static BaseMyAuditListOfPersonnel newInstance(){
		return new BaseMyAuditListOfPersonnel();
	}

	@Override
	public BaseMyAuditListOfPersonnel make(){
		BaseMyAuditListOfPersonnel b = new BaseMyAuditListOfPersonnel();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ACTIVITY_ID = "process_activity_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_NODE_TYPE = "node_type" ;
	public final static java.lang.String CS_ACTIVITY_ID = "activity_id" ;
	public final static java.lang.String CS_NEXT_ACTIVITY_ID = "next_activity_id" ;
	public final static java.lang.String CS_MAIN_ACTIVITY_ID = "main_activity_id" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_CREATE_TIME = "instance_activity_create_time" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_PROCESS_COMMENT = "process_comment" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_START_DATE_DETAIL = "start_date_detail" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_END_DATE_DETAIL = "end_date_detail" ;
	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_PLAN = "plan" ;
	public final static java.lang.String CS_TRANSPORTATION = "transportation" ;
	public final static java.lang.String CS_FEE = "fee" ;
	public final static java.lang.String CS_UNIT = "unit" ;
	public final static java.lang.String CS_CONTACT_PERSON = "contact_person" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_NEXT_AUDITOR = "next_auditor" ;
	public final static java.lang.String CS_SUB_TYPE = "sub_type" ;
	public final static java.lang.String CS_HOURS = "hours" ;
	public final static java.lang.String CS_COMPANY_PROVINCE = "company_province" ;
	public final static java.lang.String CS_TARGET_PROVINCE = "target_province" ;
	public final static java.lang.String CS_NUMBER_OF_BABY = "number_of_baby" ;
	public final static java.lang.String CS_ATTACHMENT = "attachment" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_SUB_TYPE_STR = "sub_type_str" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_IS_REMOTE_CITY = "is_remote_city" ;
	public final static java.lang.String CS_PROVIDE_ACCOMMODATION = "provide_accommodation" ;
	public final static java.lang.String CS_LIVING_EXPENSES = "living_expenses" ;
	public final static java.lang.String CS_HOUSING_FINANCE = "housing_finance" ;
	public final static java.lang.String CS_EMP_STATUS = "emp_status" ;
	public final static java.lang.String CS_BACK_VIEW_NAME = "back_view_name" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,业务名称,活动编码,流程编码,流程实列编码,附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人,当前流程实例节点的内部编码,下一个流程节点的编码,如果是知会节点，所依附的主节点,流程实例节点创建时间,流程实例节点开始处于活动时间,操作时间,提交意见,状态,人事业务编码,流程类型,处理人,工号,部门,归属公司,假期类型,开始日期,0上午   1下午,截止日期,0上午   1下午,天数,申请缘由,备注,地址,计划安排,交通工具,预计费用,外访单位,联系人,起草时间,删除状态  0未删除    1已删除,自定义的审核人,";

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

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.Integer getStartDateDetail() {
		return this.__start_date_detail;
	}

	public void setStartDateDetail( java.lang.Integer value ) {
		this.__start_date_detail = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getEndDateDetail() {
		return this.__end_date_detail;
	}

	public void setEndDateDetail( java.lang.Integer value ) {
		this.__end_date_detail = value;
	}

	public java.math.BigDecimal getDays() {
		return this.__days;
	}

	public void setDays( java.math.BigDecimal value ) {
		this.__days = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.String getPlan() {
		return this.__plan;
	}

	public void setPlan( java.lang.String value ) {
		this.__plan = value;
	}

	public java.lang.String getTransportation() {
		return this.__transportation;
	}

	public void setTransportation( java.lang.String value ) {
		this.__transportation = value;
	}

	public java.math.BigDecimal getFee() {
		return this.__fee;
	}

	public void setFee( java.math.BigDecimal value ) {
		this.__fee = value;
	}

	public java.lang.String getUnit() {
		return this.__unit;
	}

	public void setUnit( java.lang.String value ) {
		this.__unit = value;
	}

	public java.lang.String getContactPerson() {
		return this.__contact_person;
	}

	public void setContactPerson( java.lang.String value ) {
		this.__contact_person = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getEmpStatus() {
		return this.__emp_status;
	}

	public void setEmpStatus( java.lang.Integer value ) {
		this.__emp_status = value;
	}
	
	public java.lang.Integer getNextAuditor() {
		return __next_auditor;
	}

	public void setNextAuditor(java.lang.Integer value) {
		this.__next_auditor = value;
	}

	public java.lang.String getSubType() {
		return __sub_type;
	}

	public void setSubType(java.lang.String value) {
		this.__sub_type = value;
	}

	public java.lang.Integer getHours() {
		return __hours;
	}

	public void setHours(java.lang.Integer value) {
		this.__hours = value;
	}

	public java.lang.Integer getCompanyProvince() {
		return __company_province;
	}

	public void setCompanyProvince(java.lang.Integer value) {
		this.__company_province = value;
	}

	public java.lang.Integer getTargetProvince() {
		return __target_province;
	}

	public void setTargetProvince(java.lang.Integer value) {
		this.__target_province = value;
	}

	public java.lang.Integer getNumberOfBaby() {
		return __number_of_baby;
	}

	public void setNumberOfBaby(java.lang.Integer value) {
		this.__number_of_baby = value;
	}

	public java.lang.String getAttachment() {
		return __attachment;
	}

	public void setAttachment(java.lang.String value) {
		this.__attachment = value;
	}
	
	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.String getSubTypeStr() {
		return this.__sub_type_str;
	}

	public void setSubTypeStr( java.lang.String value ) {
		this.__sub_type_str = value;
	}
	
	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Boolean getIsRemoteCity() {
		return this.__is_remote_city;
	}

	public void setIsRemoteCity( java.lang.Boolean value ) {
		this.__is_remote_city = value;
	}

	public java.lang.Boolean getProvideAccommodation() {
		return this.__provide_accommodation;
	}

	public void setProvideAccommodation( java.lang.Boolean value ) {
		this.__provide_accommodation = value;
	}

	public java.math.BigDecimal getLivingExpenses() {
		return this.__living_expenses;
	}

	public void setLivingExpenses( java.math.BigDecimal value ) {
		this.__living_expenses = value;
	}

	public java.math.BigDecimal getHousingFinance() {
		return this.__housing_finance;
	}

	public void setHousingFinance( java.math.BigDecimal value ) {
		this.__housing_finance = value;
	}
	
	public java.lang.String getBackViewName() {
		return __back_view_name;
	}

	public void setBackViewName(java.lang.String value) {
		this.__back_view_name = value;
	}

	public void cloneCopy(BaseMyAuditListOfPersonnel __bean){
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
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCompanyId(getCompanyId());
		__bean.setType(getType());
		__bean.setStartDate(getStartDate());
		__bean.setStartDateDetail(getStartDateDetail());
		__bean.setEndDate(getEndDate());
		__bean.setEndDateDetail(getEndDateDetail());
		__bean.setDays(getDays());
		__bean.setReason(getReason());
		__bean.setRemark(getRemark());
		__bean.setAddress(getAddress());
		__bean.setPlan(getPlan());
		__bean.setTransportation(getTransportation());
		__bean.setFee(getFee());
		__bean.setUnit(getUnit());
		__bean.setContactPerson(getContactPerson());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setNextAuditor(getNextAuditor());
		__bean.setSubType(getSubType());
		__bean.setHours(getHours());
		__bean.setCompanyProvince(getCompanyProvince());
		__bean.setTargetProvince(getTargetProvince());
		__bean.setNumberOfBaby(getNumberOfBaby());
		__bean.setAttachment(getAttachment());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setSubTypeStr(getSubTypeStr());
		__bean.setProjectType(getProjectType());
		__bean.setProjectId(getProjectId());
		__bean.setProjectName(getProjectName());
		__bean.setProjectCode(getProjectCode());
		__bean.setParentId(getParentId());
		__bean.setIsRemoteCity(getIsRemoteCity());
		__bean.setProvideAccommodation(getProvideAccommodation());
		__bean.setLivingExpenses(getLivingExpenses());
		__bean.setHousingFinance(getHousingFinance());
		__bean.setEmpStatus(getEmpStatus());
		__bean.setBackViewName(getBackViewName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
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
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_16", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getStartDateDetail() == null ? "" : getStartDateDetail());
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getEndDateDetail() == null ? "" : getEndDateDetail());
		sb.append(",");
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getPlan() == null ? "" : getPlan());
		sb.append(",");
		sb.append(getTransportation() == null ? "" : getTransportation());
		sb.append(",");
		sb.append(getFee() == null ? "" : getFee());
		sb.append(",");
		sb.append(getUnit() == null ? "" : getUnit());
		sb.append(",");
		sb.append(getContactPerson() == null ? "" : getContactPerson());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getNextAuditor() == null ? "" : getNextAuditor());
		sb.append(",");
		String strEmpStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_11", String.valueOf(getEmpStatus()));
		sb.append(strEmpStatus == null ? "" : strEmpStatus);
		sb.append(",");
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMyAuditListOfPersonnel o) {
		return __process_instance_activity_id == null ? -1 : __process_instance_activity_id.compareTo(o.getProcessInstanceActivityId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
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
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__plan);
		hash = 97 * hash + Objects.hashCode(this.__transportation);
		hash = 97 * hash + Objects.hashCode(this.__fee);
		hash = 97 * hash + Objects.hashCode(this.__unit);
		hash = 97 * hash + Objects.hashCode(this.__contact_person);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__next_auditor);
		hash = 97 * hash + Objects.hashCode(this.__sub_type);
		hash = 97 * hash + Objects.hashCode(this.__hours);
		hash = 97 * hash + Objects.hashCode(this.__company_province);
		hash = 97 * hash + Objects.hashCode(this.__target_province);
		hash = 97 * hash + Objects.hashCode(this.__number_of_baby);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__sub_type_str);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__is_remote_city);
		hash = 97 * hash + Objects.hashCode(this.__provide_accommodation);
		hash = 97 * hash + Objects.hashCode(this.__living_expenses);
		hash = 97 * hash + Objects.hashCode(this.__housing_finance);
		hash = 97 * hash + Objects.hashCode(this.__emp_status);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMyAuditListOfPersonnel o = (BaseMyAuditListOfPersonnel)obj;
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
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__start_date_detail, o.getStartDateDetail())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__end_date_detail, o.getEndDateDetail())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__plan, o.getPlan())) return false;
		if(!Objects.equals(this.__transportation, o.getTransportation())) return false;
		if(!Objects.equals(this.__fee, o.getFee())) return false;
		if(!Objects.equals(this.__unit, o.getUnit())) return false;
		if(!Objects.equals(this.__contact_person, o.getContactPerson())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__next_auditor, o.getNextAuditor())) return false;
		if(!Objects.equals(this.__sub_type, o.getSubType())) return false;
		if(!Objects.equals(this.__hours, o.getHours())) return false;
		if(!Objects.equals(this.__company_province, o.getCompanyProvince())) return false;
		if(!Objects.equals(this.__target_province, o.getTargetProvince())) return false;
		if(!Objects.equals(this.__number_of_baby, o.getNumberOfBaby())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__sub_type_str, o.getSubTypeStr())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__is_remote_city, o.getIsRemoteCity())) return false;
		if(!Objects.equals(this.__provide_accommodation, o.getProvideAccommodation())) return false;
		if(!Objects.equals(this.__living_expenses, o.getLivingExpenses())) return false;
		if(!Objects.equals(this.__housing_finance, o.getHousingFinance())) return false;
		if(!Objects.equals(this.__emp_status, o.getEmpStatus())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessActivityId() != null) sb.append(__wrapNumber(count++, "processActivityId", getProcessActivityId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getNodeType() != null) sb.append(__wrapNumber(count++, "nodeType", getNodeType()));
		if(getActivityId() != null) sb.append(__wrapNumber(count++, "activityId", getActivityId()));
		if(getNextActivityId() != null) sb.append(__wrapNumber(count++, "nextActivityId", getNextActivityId()));
		if(getMainActivityId() != null) sb.append(__wrapNumber(count++, "mainActivityId", getMainActivityId()));
		if(getInstanceActivityCreateTime() != null) sb.append(__wrapDate(count++, "instanceActivityCreateTime", getInstanceActivityCreateTime()));
		if(getInstanceActivityStartTime() != null) sb.append(__wrapDate(count++, "instanceActivityStartTime", getInstanceActivityStartTime()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getProcessComment() != null) sb.append(__wrapString(count++, "processComment", getProcessComment()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getStartDateDetail() != null) sb.append(__wrapNumber(count++, "startDateDetail", getStartDateDetail()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getEndDateDetail() != null) sb.append(__wrapNumber(count++, "endDateDetail", getEndDateDetail()));
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getPlan() != null) sb.append(__wrapString(count++, "plan", getPlan()));
		if(getTransportation() != null) sb.append(__wrapString(count++, "transportation", getTransportation()));
		if(getFee() != null) sb.append(__wrapDecimal(count++, "fee", getFee()));
		if(getUnit() != null) sb.append(__wrapString(count++, "unit", getUnit()));
		if(getContactPerson() != null) sb.append(__wrapString(count++, "contactPerson", getContactPerson()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getNextAuditor() != null) sb.append(__wrapNumber(count++, "nextAuditor", getNextAuditor()));
		if(getSubType() != null) sb.append(__wrapString(count++, "subType", getSubType()));
		if(getHours() != null) sb.append(__wrapNumber(count++, "hours", getHours()));
		if(getCompanyProvince() != null) sb.append(__wrapNumber(count++, "companyProvince", getCompanyProvince()));
		if(getTargetProvince() != null) sb.append(__wrapNumber(count++, "targetProvince", getTargetProvince()));
		if(getNumberOfBaby() != null) sb.append(__wrapNumber(count++, "numberOfBaby", getNumberOfBaby()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getSubTypeStr() != null) sb.append(__wrapString(count++, "subTypeStr", getSubTypeStr()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getIsRemoteCity() != null) sb.append(__wrapBoolean(count++, "isRemoteCity", getIsRemoteCity()));
		if(getProvideAccommodation() != null) sb.append(__wrapBoolean(count++, "provideAccommodation", getProvideAccommodation()));
		if(getLivingExpenses() != null) sb.append(__wrapDecimal(count++, "livingExpenses", getLivingExpenses()));
		if(getHousingFinance() != null) sb.append(__wrapDecimal(count++, "housingFinance", getHousingFinance()));
		if(getEmpStatus() != null) sb.append(__wrapNumber(count++, "empStatus", getEmpStatus()));
		if(getBackViewName() != null) sb.append(__wrapString(count++, "backViewName", getBackViewName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processActivityId")) != null) setProcessActivityId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("nodeType")) != null) setNodeType(__getInt(val)); 
		if((val = values.get("activityId")) != null) setActivityId(__getInt(val)); 
		if((val = values.get("nextActivityId")) != null) setNextActivityId(__getInt(val)); 
		if((val = values.get("mainActivityId")) != null) setMainActivityId(__getInt(val)); 
		if((val = values.get("instanceActivityCreateTime")) != null) setInstanceActivityCreateTime(__getDate(val)); 
		if((val = values.get("instanceActivityStartTime")) != null) setInstanceActivityStartTime(__getDate(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("processComment")) != null) setProcessComment(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("startDateDetail")) != null) setStartDateDetail(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("endDateDetail")) != null) setEndDateDetail(__getInt(val)); 
		if((val = values.get("days")) != null) setDays(__getDecimal(val));  
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("plan")) != null) setPlan(__getString(val));
		if((val = values.get("transportation")) != null) setTransportation(__getString(val));
		if((val = values.get("fee")) != null) setFee(__getDecimal(val));  
		if((val = values.get("unit")) != null) setUnit(__getString(val));
		if((val = values.get("contactPerson")) != null) setContactPerson(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("nextAuditor")) != null) setNextAuditor(__getInt(val)); 
		if((val = values.get("subType")) != null) setSubType(__getString(val));
		if((val = values.get("hours")) != null) setHours(__getInt(val)); 
		if((val = values.get("companyProvince")) != null) setCompanyProvince(__getInt(val)); 
		if((val = values.get("targetProvince")) != null) setTargetProvince(__getInt(val)); 
		if((val = values.get("numberOfBaby")) != null) setNumberOfBaby(__getInt(val)); 
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("subTypeStr")) != null) setSubTypeStr(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("isRemoteCity")) != null) setIsRemoteCity(__getBoolean(val));
		if((val = values.get("provideAccommodation")) != null) setProvideAccommodation(__getBoolean(val));
		if((val = values.get("livingExpenses")) != null) setLivingExpenses(__getDecimal(val));  
		if((val = values.get("housingFinance")) != null) setHousingFinance(__getDecimal(val));  
		if((val = values.get("empStatus")) != null) setEmpStatus(__getInt(val)); 
		if((val = values.get("backViewName")) != null) setBackViewName(__getString(val));
	}

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
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __type ;
	protected java.util.Date  __start_date ;
	protected java.lang.Integer  __start_date_detail ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __end_date_detail ;
	protected java.math.BigDecimal  __days ;
	protected java.lang.String  __reason ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __address ;
	protected java.lang.String  __plan ;
	protected java.lang.String  __transportation ;
	protected java.math.BigDecimal  __fee ;
	protected java.lang.String  __unit ;
	protected java.lang.String  __contact_person ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __next_auditor ;
	protected java.lang.String  __sub_type ;
	protected java.lang.Integer  __hours ;
	protected java.lang.Integer  __company_province ;
	protected java.lang.Integer  __target_province ;
	protected java.lang.Integer  __number_of_baby ;
	protected java.lang.String  __attachment ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.String  __sub_type_str ;
	protected java.lang.Integer  __emp_status ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Boolean  __is_remote_city ;
	protected java.lang.Boolean  __provide_accommodation ;
	protected java.math.BigDecimal  __living_expenses ;
	protected java.math.BigDecimal  __housing_finance ;
	protected java.lang.String  __back_view_name;
}
