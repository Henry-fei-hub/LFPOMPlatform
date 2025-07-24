package pomplatform.attachmentapproval.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAttachmentApproval extends GenericCondition{

	public ConditionAttachmentApproval(){
		setParameterCount(15);
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(1, "budgetManagementId", getBudgetManagementId()));
		if(getFileId() != null) sb.append(__wrapNumber(1, "fileId", getFileId()));
		if(getAttachmentName() != null) sb.append(__wrapString(1, "attachmentName", getAttachmentName()));
		if(getUploadEmployeeId() != null) sb.append(__wrapNumber(1, "uploadEmployeeId", getUploadEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getUploadTime() != null) sb.append(__wrapDate(1, "uploadTime", getUploadTime()));
		if(getUploadRemark() != null) sb.append(__wrapString(1, "uploadRemark", getUploadRemark()));
		if(getBudgetContractAmount() != null) sb.append(__wrapNumber(1, "budgetContractAmount", getBudgetContractAmount()));
		if(getBudgetContractAmountUse() != null) sb.append(__wrapNumber(1, "budgetContractAmountUse", getBudgetContractAmountUse()));
		if(getBudgetContractAmountRest() != null) sb.append(__wrapNumber(1, "budgetContractAmountRest", getBudgetContractAmountRest()));
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(1, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getInputTaxInvoiceId() != null) sb.append(__wrapNumber(1, "inputTaxInvoiceId", getInputTaxInvoiceId()));
		if(getBddType() != null) sb.append(__wrapString(1, "bddType", getBddType()));
		if(getIsApproval() != null) sb.append(__wrapNumber(1, "isApproval", getIsApproval()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
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

	private java.lang.Integer __budget_management_id = null;
	private java.lang.Integer __file_id = null;
	private java.lang.String __attachment_name = null;
	private java.lang.Integer __upload_employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.util.Date __upload_time = null;
	private java.lang.String __upload_remark = null;
	private java.math.BigDecimal __budget_contract_amount = null;
	private java.math.BigDecimal __budget_contract_amount_use = null;
	private java.math.BigDecimal __budget_contract_amount_rest = null;
	private java.lang.Integer __receive_unit_manage_id = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __input_tax_invoice_id = null;
	private java.lang.String __bdd_type = null;
	private java.lang.Integer __is_approval = null;
}

