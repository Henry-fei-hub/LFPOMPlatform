package pomplatform.workflow.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRefuseListOfMainProjectReport extends GenericBase implements BaseFactory<BaseRefuseListOfMainProjectReport>, Comparable<BaseRefuseListOfMainProjectReport> 
{


	public static BaseRefuseListOfMainProjectReport newInstance(){
		return new BaseRefuseListOfMainProjectReport();
	}

	@Override
	public BaseRefuseListOfMainProjectReport make(){
		BaseRefuseListOfMainProjectReport b = new BaseRefuseListOfMainProjectReport();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_NAME_ONE = "project_name_one" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION = "project_origination" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_DETAIL_ADDRESS = "detail_address" ;
	public final static java.lang.String CS_TOTAL_BUILDING_AREAS = "total_building_areas" ;
	public final static java.lang.String CS_CUSTOMER_TYPE = "customer_type" ;
	public final static java.lang.String CS_IS_WAREHOUS = "is_warehous" ;
	public final static java.lang.String CS_IS_APPLY_QUOTE = "is_apply_quote" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_IS_MODIFY_PROJECT = "is_modify_project" ;
	public final static java.lang.String CS_MAIN_PROJECT_STAGE_ID = "main_project_stage_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,流程类型,业务编码,业务名称,流程编码,活动实列编码,流程状态 0 发起中  1,创建时间,完成时间,创建人,项目名称,报备申请时项目名称,省份,城市,项目类别,客户名称,项目来源渠道,客户联系人,客户联系人电话,详细地址,建筑总面积,4接洽过未合作客户)(对应于字典表151),是否入库,是否已提供战略报价,信息编号,主键编码,是否修改项目,项目阶段,项目编号";

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
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

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( java.lang.Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectNameOne() {
		return this.__project_name_one;
	}

	public void setProjectNameOne( java.lang.String value ) {
		this.__project_name_one = value;
	}

	public java.lang.String getProvince() {
		return this.__province;
	}

	public void setProvince( java.lang.String value ) {
		this.__province = value;
	}

	public java.lang.String getCity() {
		return this.__city;
	}

	public void setCity( java.lang.String value ) {
		this.__city = value;
	}

	public java.lang.String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.String value ) {
		this.__project_type = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getProjectOrigination() {
		return this.__project_origination;
	}

	public void setProjectOrigination( java.lang.String value ) {
		this.__project_origination = value;
	}

	public java.lang.String getContactName() {
		return this.__contact_name;
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.lang.String getDetailAddress() {
		return this.__detail_address;
	}

	public void setDetailAddress( java.lang.String value ) {
		this.__detail_address = value;
	}

	public java.lang.String getTotalBuildingAreas() {
		return this.__total_building_areas;
	}

	public void setTotalBuildingAreas( java.lang.String value ) {
		this.__total_building_areas = value;
	}

	public java.lang.Integer getCustomerType() {
		return this.__customer_type;
	}

	public void setCustomerType( java.lang.Integer value ) {
		this.__customer_type = value;
	}

	public java.lang.Boolean getIsWarehous() {
		return this.__is_warehous;
	}

	public void setIsWarehous( java.lang.Boolean value ) {
		this.__is_warehous = value;
	}

	public java.lang.Boolean getIsApplyQuote() {
		return this.__is_apply_quote;
	}

	public void setIsApplyQuote( java.lang.Boolean value ) {
		this.__is_apply_quote = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Boolean getIsModifyProject() {
		return this.__is_modify_project;
	}

	public void setIsModifyProject( java.lang.Boolean value ) {
		this.__is_modify_project = value;
	}

	public java.lang.Integer getMainProjectStageId() {
		return this.__main_project_stage_id;
	}

	public void setMainProjectStageId( java.lang.Integer value ) {
		this.__main_project_stage_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public void cloneCopy(BaseRefuseListOfMainProjectReport __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCreateTime(getCreateTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setProjectName(getProjectName());
		__bean.setProjectNameOne(getProjectNameOne());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setProjectType(getProjectType());
		__bean.setCustomerName(getCustomerName());
		__bean.setProjectOrigination(getProjectOrigination());
		__bean.setContactName(getContactName());
		__bean.setContactPhone(getContactPhone());
		__bean.setDetailAddress(getDetailAddress());
		__bean.setTotalBuildingAreas(getTotalBuildingAreas());
		__bean.setCustomerType(getCustomerType());
		__bean.setIsWarehous(getIsWarehous());
		__bean.setIsApplyQuote(getIsApplyQuote());
		__bean.setInfoCode(getInfoCode());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setIsModifyProject(getIsModifyProject());
		__bean.setMainProjectStageId(getMainProjectStageId());
		__bean.setProjectCode(getProjectCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
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
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectNameOne() == null ? "" : getProjectNameOne());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getProjectOrigination() == null ? "" : getProjectOrigination());
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getDetailAddress() == null ? "" : getDetailAddress());
		sb.append(",");
		sb.append(getTotalBuildingAreas() == null ? "" : getTotalBuildingAreas());
		sb.append(",");
		sb.append(getCustomerType() == null ? "" : getCustomerType());
		sb.append(",");
		sb.append(getIsWarehous() == null ? "" : getIsWarehous());
		sb.append(",");
		sb.append(getIsApplyQuote() == null ? "" : getIsApplyQuote());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getIsModifyProject() == null ? "" : getIsModifyProject());
		sb.append(",");
		sb.append(getMainProjectStageId() == null ? "" : getMainProjectStageId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRefuseListOfMainProjectReport o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_name_one);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__project_origination);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__detail_address);
		hash = 97 * hash + Objects.hashCode(this.__total_building_areas);
		hash = 97 * hash + Objects.hashCode(this.__customer_type);
		hash = 97 * hash + Objects.hashCode(this.__is_warehous);
		hash = 97 * hash + Objects.hashCode(this.__is_apply_quote);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__is_modify_project);
		hash = 97 * hash + Objects.hashCode(this.__main_project_stage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRefuseListOfMainProjectReport o = (BaseRefuseListOfMainProjectReport)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_name_one, o.getProjectNameOne())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__project_origination, o.getProjectOrigination())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__detail_address, o.getDetailAddress())) return false;
		if(!Objects.equals(this.__total_building_areas, o.getTotalBuildingAreas())) return false;
		if(!Objects.equals(this.__customer_type, o.getCustomerType())) return false;
		if(!Objects.equals(this.__is_warehous, o.getIsWarehous())) return false;
		if(!Objects.equals(this.__is_apply_quote, o.getIsApplyQuote())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__is_modify_project, o.getIsModifyProject())) return false;
		if(!Objects.equals(this.__main_project_stage_id, o.getMainProjectStageId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectNameOne() != null) sb.append(__wrapString(count++, "projectNameOne", getProjectNameOne()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getProjectType() != null) sb.append(__wrapString(count++, "projectType", getProjectType()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getProjectOrigination() != null) sb.append(__wrapString(count++, "projectOrigination", getProjectOrigination()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getDetailAddress() != null) sb.append(__wrapString(count++, "detailAddress", getDetailAddress()));
		if(getTotalBuildingAreas() != null) sb.append(__wrapString(count++, "totalBuildingAreas", getTotalBuildingAreas()));
		if(getCustomerType() != null) sb.append(__wrapNumber(count++, "customerType", getCustomerType()));
		if(getIsWarehous() != null) sb.append(__wrapBoolean(count++, "isWarehous", getIsWarehous()));
		if(getIsApplyQuote() != null) sb.append(__wrapBoolean(count++, "isApplyQuote", getIsApplyQuote()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getIsModifyProject() != null) sb.append(__wrapBoolean(count++, "isModifyProject", getIsModifyProject()));
		if(getMainProjectStageId() != null) sb.append(__wrapNumber(count++, "mainProjectStageId", getMainProjectStageId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceActivityId() != null) res.put("processInstanceActivityId", getProcessInstanceActivityId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getProjectNameOne() != null) res.put("projectNameOne", getProjectNameOne());
		if(getProvince() != null) res.put("province", getProvince());
		if(getCity() != null) res.put("city", getCity());
		if(getProjectType() != null) res.put("projectType", getProjectType());
		if(getCustomerName() != null) res.put("customerName", getCustomerName());
		if(getProjectOrigination() != null) res.put("projectOrigination", getProjectOrigination());
		if(getContactName() != null) res.put("contactName", getContactName());
		if(getContactPhone() != null) res.put("contactPhone", getContactPhone());
		if(getDetailAddress() != null) res.put("detailAddress", getDetailAddress());
		if(getTotalBuildingAreas() != null) res.put("totalBuildingAreas", getTotalBuildingAreas());
		if(getCustomerType() != null) res.put("customerType", getCustomerType());
		if(getIsWarehous() != null) res.put("isWarehous", getIsWarehous());
		if(getIsApplyQuote() != null) res.put("isApplyQuote", getIsApplyQuote());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getIsModifyProject() != null) res.put("isModifyProject", getIsModifyProject());
		if(getMainProjectStageId() != null) res.put("mainProjectStageId", getMainProjectStageId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectNameOne")) != null) setProjectNameOne(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("detailAddress")) != null) setDetailAddress(__getString(val));
		if((val = values.get("totalBuildingAreas")) != null) setTotalBuildingAreas(__getString(val));
		if((val = values.get("customerType")) != null) setCustomerType(__getInt(val)); 
		if((val = values.get("isWarehous")) != null) setIsWarehous(__getBoolean(val));
		if((val = values.get("isApplyQuote")) != null) setIsApplyQuote(__getBoolean(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("isModifyProject")) != null) setIsModifyProject(__getBoolean(val));
		if((val = values.get("mainProjectStageId")) != null) setMainProjectStageId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __process_status ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_name_one ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.String  __project_type ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __project_origination ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.String  __detail_address ;
	protected java.lang.String  __total_building_areas ;
	protected java.lang.Integer  __customer_type ;
	protected java.lang.Boolean  __is_warehous ;
	protected java.lang.Boolean  __is_apply_quote ;
	protected java.lang.String  __info_code ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Boolean  __is_modify_project ;
	protected java.lang.Integer  __main_project_stage_id ;
	protected java.lang.String  __project_code ;
}
