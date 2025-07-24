package pomplatform.preProjects.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttentionListOfPreProjectReport extends GenericBase implements BaseFactory<BaseAttentionListOfPreProjectReport>, Comparable<BaseAttentionListOfPreProjectReport>
{


	public static BaseAttentionListOfPreProjectReport newInstance(){
		return new BaseAttentionListOfPreProjectReport();
	}

	@Override
	public BaseAttentionListOfPreProjectReport make(){
		BaseAttentionListOfPreProjectReport b = new BaseAttentionListOfPreProjectReport();
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
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_PROCESS_COMMENT = "process_comment" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION = "project_origination" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_DETAIL_ADDRESS = "detail_address" ;
	public final static java.lang.String CS_TOTAL_BUILDING_AREAS = "total_building_areas" ;
	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_CUSTOMER_TYPE = "customer_type" ;
	public final static java.lang.String CS_IS_WAREHOUS = "is_warehous" ;
	public final static java.lang.String CS_IS_APPLY_QUOTE = "is_apply_quote" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_NAME_ONE = "project_name_one" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,业务名称,活动编码,流程编码,主键编码,返回数据集,流程实例节点编码,流程实例节点创建时间,流程实例节点开始处于活动时间,状态,流程类型,操作时间,提交意见,项目名称,省份,城市,项目类别,客户名称,项目来源渠道,客户联系人,客户联系人电话,详细地址,建筑总面积,报备人,4接洽过未合作客户)(对应于字典表151),是否入库,是否已提供战略报价,信息编号";

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

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
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

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
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

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
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

	public java.lang.String getProjectNameOne() {
		return this.__project_name_one;
	}

	public void setProjectNameOne( java.lang.String value ) {
		this.__project_name_one = value;
	}

	public void cloneCopy(BaseAttentionListOfPreProjectReport __bean){
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
		__bean.setProcessType(getProcessType());
		__bean.setOperateTime(getOperateTime());
		__bean.setProcessComment(getProcessComment());
		__bean.setProjectName(getProjectName());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setProjectType(getProjectType());
		__bean.setCustomerName(getCustomerName());
		__bean.setProjectOrigination(getProjectOrigination());
		__bean.setContactName(getContactName());
		__bean.setContactPhone(getContactPhone());
		__bean.setDetailAddress(getDetailAddress());
		__bean.setTotalBuildingAreas(getTotalBuildingAreas());
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setCustomerType(getCustomerType());
		__bean.setIsWarehous(getIsWarehous());
		__bean.setIsApplyQuote(getIsApplyQuote());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectNameOne(getProjectNameOne());
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
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getProcessComment() == null ? "" : getProcessComment());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
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
		sb.append(getApplyEmployeeId() == null ? "" : getApplyEmployeeId());
		sb.append(",");
		sb.append(getCustomerType() == null ? "" : getCustomerType());
		sb.append(",");
		sb.append(getIsWarehous() == null ? "" : getIsWarehous());
		sb.append(",");
		sb.append(getIsApplyQuote() == null ? "" : getIsApplyQuote());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectNameOne() == null ? "" : getProjectNameOne());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttentionListOfPreProjectReport o) {
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
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__process_comment);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__project_origination);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__detail_address);
		hash = 97 * hash + Objects.hashCode(this.__total_building_areas);
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_type);
		hash = 97 * hash + Objects.hashCode(this.__is_warehous);
		hash = 97 * hash + Objects.hashCode(this.__is_apply_quote);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name_one);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttentionListOfPreProjectReport o = (BaseAttentionListOfPreProjectReport)obj;
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
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__process_comment, o.getProcessComment())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__project_origination, o.getProjectOrigination())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__detail_address, o.getDetailAddress())) return false;
		if(!Objects.equals(this.__total_building_areas, o.getTotalBuildingAreas())) return false;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__customer_type, o.getCustomerType())) return false;
		if(!Objects.equals(this.__is_warehous, o.getIsWarehous())) return false;
		if(!Objects.equals(this.__is_apply_quote, o.getIsApplyQuote())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_name_one, o.getProjectNameOne())) return false;
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
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getProcessComment() != null) sb.append(__wrapString(count++, "processComment", getProcessComment()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getProjectType() != null) sb.append(__wrapString(count++, "projectType", getProjectType()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getProjectOrigination() != null) sb.append(__wrapString(count++, "projectOrigination", getProjectOrigination()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getDetailAddress() != null) sb.append(__wrapString(count++, "detailAddress", getDetailAddress()));
		if(getTotalBuildingAreas() != null) sb.append(__wrapString(count++, "totalBuildingAreas", getTotalBuildingAreas()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getCustomerType() != null) sb.append(__wrapNumber(count++, "customerType", getCustomerType()));
		if(getIsWarehous() != null) sb.append(__wrapBoolean(count++, "isWarehous", getIsWarehous()));
		if(getIsApplyQuote() != null) sb.append(__wrapBoolean(count++, "isApplyQuote", getIsApplyQuote()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectNameOne() != null) sb.append(__wrapString(count++, "projectNameOne", getProjectNameOne()));
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
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getProcessComment() != null) res.put("processComment", getProcessComment());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getProvince() != null) res.put("province", getProvince());
		if(getCity() != null) res.put("city", getCity());
		if(getProjectType() != null) res.put("projectType", getProjectType());
		if(getCustomerName() != null) res.put("customerName", getCustomerName());
		if(getProjectOrigination() != null) res.put("projectOrigination", getProjectOrigination());
		if(getContactName() != null) res.put("contactName", getContactName());
		if(getContactPhone() != null) res.put("contactPhone", getContactPhone());
		if(getDetailAddress() != null) res.put("detailAddress", getDetailAddress());
		if(getTotalBuildingAreas() != null) res.put("totalBuildingAreas", getTotalBuildingAreas());
		if(getApplyEmployeeId() != null) res.put("applyEmployeeId", getApplyEmployeeId());
		if(getCustomerType() != null) res.put("customerType", getCustomerType());
		if(getIsWarehous() != null) res.put("isWarehous", getIsWarehous());
		if(getIsApplyQuote() != null) res.put("isApplyQuote", getIsApplyQuote());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getProjectNameOne() != null) res.put("projectNameOne", getProjectNameOne());
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
		if((val = values.get("processType")) != null) setProcessType(__getInt(val));
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val));
		if((val = values.get("processComment")) != null) setProcessComment(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("detailAddress")) != null) setDetailAddress(__getString(val));
		if((val = values.get("totalBuildingAreas")) != null) setTotalBuildingAreas(__getString(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val));
		if((val = values.get("customerType")) != null) setCustomerType(__getInt(val));
		if((val = values.get("isWarehous")) != null) setIsWarehous(__getBoolean(val));
		if((val = values.get("isApplyQuote")) != null) setIsApplyQuote(__getBoolean(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectNameOne")) != null) setProjectNameOne(__getString(val));
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
	protected java.lang.Integer  __process_type ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __process_comment ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.String  __project_type ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __project_origination ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.String  __detail_address ;
	protected java.lang.String  __total_building_areas ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.Integer  __customer_type ;
	protected java.lang.Boolean  __is_warehous ;
	protected java.lang.Boolean  __is_apply_quote ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_name_one ;
}
