package pomplatform.attachmentapprovalalready.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAttachmentApprovalAlready extends GenericCondition{

	public ConditionAttachmentApprovalAlready(){
		setParameterCount(12);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
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

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(1, "budgetManagementId", getBudgetManagementId()));
		if(getAttachmentName() != null) sb.append(__wrapString(1, "attachmentName", getAttachmentName()));
		if(getUploadEmployeeId() != null) sb.append(__wrapNumber(1, "uploadEmployeeId", getUploadEmployeeId()));
		if(getUploadTime() != null) sb.append(__wrapDate(1, "uploadTime", getUploadTime()));
		if(getUploadRemark() != null) sb.append(__wrapString(1, "uploadRemark", getUploadRemark()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getBddType() != null) sb.append(__wrapString(1, "bddType", getBddType()));
		if(getIsApproval() != null) sb.append(__wrapNumber(1, "isApproval", getIsApproval()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("uploadEmployeeId")) != null) setUploadEmployeeId(__getInt(val)); 
		if((val = values.get("uploadTime")) != null) setUploadTime(__getDate(val)); 
		if((val = values.get("uploadRemark")) != null) setUploadRemark(__getString(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("bddType")) != null) setBddType(__getString(val));
		if((val = values.get("isApproval")) != null) setIsApproval(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.Integer __process_type = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __budget_management_id = null;
	private java.lang.String __attachment_name = null;
	private java.lang.Integer __upload_employee_id = null;
	private java.util.Date __upload_time = null;
	private java.lang.String __upload_remark = null;
	private java.lang.Integer __project_id = null;
	private java.lang.String __bdd_type = null;
	private java.lang.Integer __is_approval = null;
	private java.lang.Integer __department_id = null;
}

