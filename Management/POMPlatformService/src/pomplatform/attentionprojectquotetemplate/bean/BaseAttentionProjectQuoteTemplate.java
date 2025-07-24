package pomplatform.attentionprojectquotetemplate.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttentionProjectQuoteTemplate extends GenericBase implements BaseFactory<BaseAttentionProjectQuoteTemplate>, Comparable<BaseAttentionProjectQuoteTemplate> 
{


	public static BaseAttentionProjectQuoteTemplate newInstance(){
		return new BaseAttentionProjectQuoteTemplate();
	}

	@Override
	public BaseAttentionProjectQuoteTemplate make(){
		BaseAttentionProjectQuoteTemplate b = new BaseAttentionProjectQuoteTemplate();
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
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_QUOTE_ID = "project_quote_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_QUOTE_STATUS = "quote_status" ;
	public final static java.lang.String CS_BASIC_AMOUNT = "basic_amount" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_UP_AMOUNT = "up_amount" ;
	public final static java.lang.String CS_UP_PERCENT = "up_percent" ;
	public final static java.lang.String CS_PREFERENTIAL_AMOUNT = "preferential_amount" ;
	public final static java.lang.String CS_PERFERENTIAL_PERCENT = "perferential_percent" ;
	public final static java.lang.String CS_TAX_AMOUNT = "tax_amount" ;
	public final static java.lang.String CS_OTHER_TAX_AMOUNT = "other_tax_amount" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_FINAL_PERCENT = "final_percent" ;
	public final static java.lang.String CS_TAX_FINAL_AMOUNT = "tax_final_amount" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,业务名称,活动编码,流程编码,流程实列编码,返回数据集,流程实例节点编码,流程实例节点创建时间,流程实例节点开始处于活动时间,状态,流程类型,操作时间,提交意见,项目名称,项目地址（省）,项目地址（市）,项目类别,开发商名称,项目来源渠道,联系人,联系电话,详细地址,项目面积,报备人,信息编号,主键编码,项目id,报价状态,基准总额,小计总额,上浮金额,上浮系数,优惠金额,优惠系数,税金,其它税金（采买）,不含税合计,最终系数,含税合计,操作人,备注,公司id,业务类别";

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

	public java.math.BigDecimal getTotalBuildingAreas() {
		return this.__total_building_areas;
	}

	public void setTotalBuildingAreas( java.math.BigDecimal value ) {
		this.__total_building_areas = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getProjectQuoteId() {
		return this.__project_quote_id;
	}

	public void setProjectQuoteId( java.lang.Integer value ) {
		this.__project_quote_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getQuoteStatus() {
		return this.__quote_status;
	}

	public void setQuoteStatus( java.lang.Integer value ) {
		this.__quote_status = value;
	}

	public java.math.BigDecimal getBasicAmount() {
		return this.__basic_amount;
	}

	public void setBasicAmount( java.math.BigDecimal value ) {
		this.__basic_amount = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.math.BigDecimal getUpAmount() {
		return this.__up_amount;
	}

	public void setUpAmount( java.math.BigDecimal value ) {
		this.__up_amount = value;
	}

	public java.math.BigDecimal getUpPercent() {
		return this.__up_percent;
	}

	public void setUpPercent( java.math.BigDecimal value ) {
		this.__up_percent = value;
	}

	public java.math.BigDecimal getPreferentialAmount() {
		return this.__preferential_amount;
	}

	public void setPreferentialAmount( java.math.BigDecimal value ) {
		this.__preferential_amount = value;
	}

	public java.math.BigDecimal getPerferentialPercent() {
		return this.__perferential_percent;
	}

	public void setPerferentialPercent( java.math.BigDecimal value ) {
		this.__perferential_percent = value;
	}

	public java.math.BigDecimal getTaxAmount() {
		return this.__tax_amount;
	}

	public void setTaxAmount( java.math.BigDecimal value ) {
		this.__tax_amount = value;
	}

	public java.math.BigDecimal getOtherTaxAmount() {
		return this.__other_tax_amount;
	}

	public void setOtherTaxAmount( java.math.BigDecimal value ) {
		this.__other_tax_amount = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.math.BigDecimal getFinalPercent() {
		return this.__final_percent;
	}

	public void setFinalPercent( java.math.BigDecimal value ) {
		this.__final_percent = value;
	}

	public java.math.BigDecimal getTaxFinalAmount() {
		return this.__tax_final_amount;
	}

	public void setTaxFinalAmount( java.math.BigDecimal value ) {
		this.__tax_final_amount = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}


	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public void cloneCopy(BaseAttentionProjectQuoteTemplate __bean){
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
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectQuoteId(getProjectQuoteId());
		__bean.setProjectId(getProjectId());
		__bean.setQuoteStatus(getQuoteStatus());
		__bean.setBasicAmount(getBasicAmount());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setUpAmount(getUpAmount());
		__bean.setUpPercent(getUpPercent());
		__bean.setPreferentialAmount(getPreferentialAmount());
		__bean.setPerferentialPercent(getPerferentialPercent());
		__bean.setTaxAmount(getTaxAmount());
		__bean.setOtherTaxAmount(getOtherTaxAmount());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setFinalPercent(getFinalPercent());
		__bean.setTaxFinalAmount(getTaxFinalAmount());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setRemark(getRemark());
		__bean.setBusinessType(getBusinessType());
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
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectQuoteId() == null ? "" : getProjectQuoteId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getQuoteStatus() == null ? "" : getQuoteStatus());
		sb.append(",");
		sb.append(getBasicAmount() == null ? "" : getBasicAmount());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getUpAmount() == null ? "" : getUpAmount());
		sb.append(",");
		sb.append(getUpPercent() == null ? "" : getUpPercent());
		sb.append(",");
		sb.append(getPreferentialAmount() == null ? "" : getPreferentialAmount());
		sb.append(",");
		sb.append(getPerferentialPercent() == null ? "" : getPerferentialPercent());
		sb.append(",");
		sb.append(getTaxAmount() == null ? "" : getTaxAmount());
		sb.append(",");
		sb.append(getOtherTaxAmount() == null ? "" : getOtherTaxAmount());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		sb.append(getFinalPercent() == null ? "" : getFinalPercent());
		sb.append(",");
		sb.append(getTaxFinalAmount() == null ? "" : getTaxFinalAmount());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttentionProjectQuoteTemplate o) {
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
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_quote_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__quote_status);
		hash = 97 * hash + Objects.hashCode(this.__basic_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__up_amount);
		hash = 97 * hash + Objects.hashCode(this.__up_percent);
		hash = 97 * hash + Objects.hashCode(this.__preferential_amount);
		hash = 97 * hash + Objects.hashCode(this.__perferential_percent);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__other_tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__final_percent);
		hash = 97 * hash + Objects.hashCode(this.__tax_final_amount);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttentionProjectQuoteTemplate o = (BaseAttentionProjectQuoteTemplate)obj;
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
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_quote_id, o.getProjectQuoteId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__quote_status, o.getQuoteStatus())) return false;
		if(!Objects.equals(this.__basic_amount, o.getBasicAmount())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__up_amount, o.getUpAmount())) return false;
		if(!Objects.equals(this.__up_percent, o.getUpPercent())) return false;
		if(!Objects.equals(this.__preferential_amount, o.getPreferentialAmount())) return false;
		if(!Objects.equals(this.__perferential_percent, o.getPerferentialPercent())) return false;
		if(!Objects.equals(this.__tax_amount, o.getTaxAmount())) return false;
		if(!Objects.equals(this.__other_tax_amount, o.getOtherTaxAmount())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__final_percent, o.getFinalPercent())) return false;
		if(!Objects.equals(this.__tax_final_amount, o.getTaxFinalAmount())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
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
		if(getTotalBuildingAreas() != null) sb.append(__wrapDecimal(count++, "totalBuildingAreas", getTotalBuildingAreas()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectQuoteId() != null) sb.append(__wrapNumber(count++, "projectQuoteId", getProjectQuoteId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getQuoteStatus() != null) sb.append(__wrapNumber(count++, "quoteStatus", getQuoteStatus()));
		if(getBasicAmount() != null) sb.append(__wrapDecimal(count++, "basicAmount", getBasicAmount()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getUpAmount() != null) sb.append(__wrapDecimal(count++, "upAmount", getUpAmount()));
		if(getUpPercent() != null) sb.append(__wrapDecimal(count++, "upPercent", getUpPercent()));
		if(getPreferentialAmount() != null) sb.append(__wrapDecimal(count++, "preferentialAmount", getPreferentialAmount()));
		if(getPerferentialPercent() != null) sb.append(__wrapDecimal(count++, "perferentialPercent", getPerferentialPercent()));
		if(getTaxAmount() != null) sb.append(__wrapDecimal(count++, "taxAmount", getTaxAmount()));
		if(getOtherTaxAmount() != null) sb.append(__wrapDecimal(count++, "otherTaxAmount", getOtherTaxAmount()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getFinalPercent() != null) sb.append(__wrapDecimal(count++, "finalPercent", getFinalPercent()));
		if(getTaxFinalAmount() != null) sb.append(__wrapDecimal(count++, "taxFinalAmount", getTaxFinalAmount()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		return sb.toString();
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
		if((val = values.get("totalBuildingAreas")) != null) setTotalBuildingAreas(__getDecimal(val));  
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectQuoteId")) != null) setProjectQuoteId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("quoteStatus")) != null) setQuoteStatus(__getInt(val)); 
		if((val = values.get("basicAmount")) != null) setBasicAmount(__getDecimal(val));  
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("upAmount")) != null) setUpAmount(__getDecimal(val));  
		if((val = values.get("upPercent")) != null) setUpPercent(__getDecimal(val));  
		if((val = values.get("preferentialAmount")) != null) setPreferentialAmount(__getDecimal(val));  
		if((val = values.get("perferentialPercent")) != null) setPerferentialPercent(__getDecimal(val));  
		if((val = values.get("taxAmount")) != null) setTaxAmount(__getDecimal(val));  
		if((val = values.get("otherTaxAmount")) != null) setOtherTaxAmount(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("finalPercent")) != null) setFinalPercent(__getDecimal(val));  
		if((val = values.get("taxFinalAmount")) != null) setTaxFinalAmount(__getDecimal(val));  
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
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
	protected java.math.BigDecimal  __total_building_areas ;
	protected java.lang.Integer  __apply_employee_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.Integer  __project_quote_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __quote_status ;
	protected java.math.BigDecimal  __basic_amount ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.math.BigDecimal  __up_amount ;
	protected java.math.BigDecimal  __up_percent ;
	protected java.math.BigDecimal  __preferential_amount ;
	protected java.math.BigDecimal  __perferential_percent ;
	protected java.math.BigDecimal  __tax_amount ;
	protected java.math.BigDecimal  __other_tax_amount ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.math.BigDecimal  __final_percent ;
	protected java.math.BigDecimal  __tax_final_amount ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __business_type ;
}
