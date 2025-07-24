package pomplatform.attachmentapprovalapply.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttachmentApprovalApply extends GenericBase implements BaseFactory<BaseAttachmentApprovalApply>, Comparable<BaseAttachmentApprovalApply> 
{


	public static BaseAttachmentApprovalApply newInstance(){
		return new BaseAttachmentApprovalApply();
	}

	@Override
	public BaseAttachmentApprovalApply make(){
		BaseAttachmentApprovalApply b = new BaseAttachmentApprovalApply();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_PAY_PERCENT = "pay_percent" ;
	public final static java.lang.String CS_BUDGET_ATTACHMENT_ID = "budget_attachment_id" ;
	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_UPLOAD_EMPLOYEE_ID = "upload_employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_UPLOAD_TIME = "upload_time" ;
	public final static java.lang.String CS_UPLOAD_REMARK = "upload_remark" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT = "budget_contract_amount" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT_USE = "budget_contract_amount_use" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT_REST = "budget_contract_amount_rest" ;
	public final static java.lang.String CS_RECEIVE_UNIT_MANAGE_ID = "receive_unit_manage_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_INPUT_TAX_INVOICE_ID = "input_tax_invoice_id" ;
	public final static java.lang.String CS_BDD_TYPE = "bdd_type" ;
	public final static java.lang.String CS_IS_APPROVAL = "is_approval" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,业务名称,流程编码,活动实列编码,流程状态,完成时间,流程类型,文件路径,,主键id,预算管理id,附件编码,附件名称,上传人员,上传人员归属部门,上传时间,附件备注,合同金额,合同已付款金额,剩余合同金额,供应商,项目id,发票编码,预算类别  budget_detail_type,是否审批 0.未审批 1.审批进行中,2.已审批";

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
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

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.String getPayPercent() {
		return this.__pay_percent;
	}

	public void setPayPercent( java.lang.String value ) {
		this.__pay_percent = value;
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return this.__budget_attachment_id;
	}

	public void setBudgetAttachmentId( java.lang.Integer value ) {
		this.__budget_attachment_id = value;
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.Integer getUploadEmployeeId() {
		return this.__upload_employee_id;
	}

	public void setUploadEmployeeId( java.lang.Integer value ) {
		this.__upload_employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getUploadTime() {
		return this.__upload_time;
	}

	public void setUploadTime( java.util.Date value ) {
		this.__upload_time = value;
	}

	public java.lang.String getUploadRemark() {
		return this.__upload_remark;
	}

	public void setUploadRemark( java.lang.String value ) {
		this.__upload_remark = value;
	}

	public java.math.BigDecimal getBudgetContractAmount() {
		return this.__budget_contract_amount;
	}

	public void setBudgetContractAmount( java.math.BigDecimal value ) {
		this.__budget_contract_amount = value;
	}

	public java.math.BigDecimal getBudgetContractAmountUse() {
		return this.__budget_contract_amount_use;
	}

	public void setBudgetContractAmountUse( java.math.BigDecimal value ) {
		this.__budget_contract_amount_use = value;
	}

	public java.math.BigDecimal getBudgetContractAmountRest() {
		return this.__budget_contract_amount_rest;
	}

	public void setBudgetContractAmountRest( java.math.BigDecimal value ) {
		this.__budget_contract_amount_rest = value;
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getInputTaxInvoiceId() {
		return this.__input_tax_invoice_id;
	}

	public void setInputTaxInvoiceId( java.lang.Integer value ) {
		this.__input_tax_invoice_id = value;
	}

	public java.lang.String getBddType() {
		return this.__bdd_type;
	}

	public void setBddType( java.lang.String value ) {
		this.__bdd_type = value;
	}

	public java.lang.Integer getIsApproval() {
		return this.__is_approval;
	}

	public void setIsApproval( java.lang.Integer value ) {
		this.__is_approval = value;
	}

	public void cloneCopy(BaseAttachmentApprovalApply __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setProcessType(getProcessType());
		__bean.setFileUrl(getFileUrl());
		__bean.setPayPercent(getPayPercent());
		__bean.setBudgetAttachmentId(getBudgetAttachmentId());
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setFileId(getFileId());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setUploadEmployeeId(getUploadEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setUploadTime(getUploadTime());
		__bean.setUploadRemark(getUploadRemark());
		__bean.setBudgetContractAmount(getBudgetContractAmount());
		__bean.setBudgetContractAmountUse(getBudgetContractAmountUse());
		__bean.setBudgetContractAmountRest(getBudgetContractAmountRest());
		__bean.setReceiveUnitManageId(getReceiveUnitManageId());
		__bean.setProjectId(getProjectId());
		__bean.setInputTaxInvoiceId(getInputTaxInvoiceId());
		__bean.setBddType(getBddType());
		__bean.setIsApproval(getIsApproval());
	}

	public java.lang.String toCSVString() {

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
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getPayPercent() == null ? "" : getPayPercent());
		sb.append(",");
		sb.append(getBudgetAttachmentId() == null ? "" : getBudgetAttachmentId());
		sb.append(",");
		sb.append(getBudgetManagementId() == null ? "" : getBudgetManagementId());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		sb.append(getUploadEmployeeId() == null ? "" : getUploadEmployeeId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getUploadTime() == null ? "" : sdf.format(getUploadTime()));
		sb.append(",");
		sb.append(getUploadRemark() == null ? "" : getUploadRemark());
		sb.append(",");
		sb.append(getBudgetContractAmount() == null ? "" : getBudgetContractAmount());
		sb.append(",");
		sb.append(getBudgetContractAmountUse() == null ? "" : getBudgetContractAmountUse());
		sb.append(",");
		sb.append(getBudgetContractAmountRest() == null ? "" : getBudgetContractAmountRest());
		sb.append(",");
		sb.append(getReceiveUnitManageId() == null ? "" : getReceiveUnitManageId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getInputTaxInvoiceId() == null ? "" : getInputTaxInvoiceId());
		sb.append(",");
		sb.append(getBddType() == null ? "" : getBddType());
		sb.append(",");
		sb.append(getIsApproval() == null ? "" : getIsApproval());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttachmentApprovalApply o) {
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
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__pay_percent);
		hash = 97 * hash + Objects.hashCode(this.__budget_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__upload_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__upload_time);
		hash = 97 * hash + Objects.hashCode(this.__upload_remark);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount_use);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount_rest);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_invoice_id);
		hash = 97 * hash + Objects.hashCode(this.__bdd_type);
		hash = 97 * hash + Objects.hashCode(this.__is_approval);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttachmentApprovalApply o = (BaseAttachmentApprovalApply)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__pay_percent, o.getPayPercent())) return false;
		if(!Objects.equals(this.__budget_attachment_id, o.getBudgetAttachmentId())) return false;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__upload_employee_id, o.getUploadEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__upload_time, o.getUploadTime())) return false;
		if(!Objects.equals(this.__upload_remark, o.getUploadRemark())) return false;
		if(!Objects.equals(this.__budget_contract_amount, o.getBudgetContractAmount())) return false;
		if(!Objects.equals(this.__budget_contract_amount_use, o.getBudgetContractAmountUse())) return false;
		if(!Objects.equals(this.__budget_contract_amount_rest, o.getBudgetContractAmountRest())) return false;
		if(!Objects.equals(this.__receive_unit_manage_id, o.getReceiveUnitManageId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__input_tax_invoice_id, o.getInputTaxInvoiceId())) return false;
		if(!Objects.equals(this.__bdd_type, o.getBddType())) return false;
		if(!Objects.equals(this.__is_approval, o.getIsApproval())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getPayPercent() != null) sb.append(__wrapString(count++, "payPercent", getPayPercent()));
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(count++, "budgetAttachmentId", getBudgetAttachmentId()));
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getUploadEmployeeId() != null) sb.append(__wrapNumber(count++, "uploadEmployeeId", getUploadEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getUploadTime() != null) sb.append(__wrapDate(count++, "uploadTime", getUploadTime()));
		if(getUploadRemark() != null) sb.append(__wrapString(count++, "uploadRemark", getUploadRemark()));
		if(getBudgetContractAmount() != null) sb.append(__wrapDecimal(count++, "budgetContractAmount", getBudgetContractAmount()));
		if(getBudgetContractAmountUse() != null) sb.append(__wrapDecimal(count++, "budgetContractAmountUse", getBudgetContractAmountUse()));
		if(getBudgetContractAmountRest() != null) sb.append(__wrapDecimal(count++, "budgetContractAmountRest", getBudgetContractAmountRest()));
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(count++, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getInputTaxInvoiceId() != null) sb.append(__wrapNumber(count++, "inputTaxInvoiceId", getInputTaxInvoiceId()));
		if(getBddType() != null) sb.append(__wrapString(count++, "bddType", getBddType()));
		if(getIsApproval() != null) sb.append(__wrapNumber(count++, "isApproval", getIsApproval()));
		return sb.toString();
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
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("payPercent")) != null) setPayPercent(__getString(val));
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("uploadEmployeeId")) != null) setUploadEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("uploadTime")) != null) setUploadTime(__getDate(val)); 
		if((val = values.get("uploadRemark")) != null) setUploadRemark(__getString(val));
		if((val = values.get("budgetContractAmount")) != null) setBudgetContractAmount(__getDecimal(val));  
		if((val = values.get("budgetContractAmountUse")) != null) setBudgetContractAmountUse(__getDecimal(val));  
		if((val = values.get("budgetContractAmountRest")) != null) setBudgetContractAmountRest(__getDecimal(val));  
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("inputTaxInvoiceId")) != null) setInputTaxInvoiceId(__getInt(val)); 
		if((val = values.get("bddType")) != null) setBddType(__getString(val));
		if((val = values.get("isApproval")) != null) setIsApproval(__getInt(val)); 
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __process_status ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.String  __file_url ;
	protected java.lang.String  __pay_percent ;
	protected java.lang.Integer  __budget_attachment_id ;
	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.Integer  __upload_employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __upload_time ;
	protected java.lang.String  __upload_remark ;
	protected java.math.BigDecimal  __budget_contract_amount ;
	protected java.math.BigDecimal  __budget_contract_amount_use ;
	protected java.math.BigDecimal  __budget_contract_amount_rest ;
	protected java.lang.Integer  __receive_unit_manage_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __input_tax_invoice_id ;
	protected java.lang.String  __bdd_type ;
	protected java.lang.Integer  __is_approval ;
}
