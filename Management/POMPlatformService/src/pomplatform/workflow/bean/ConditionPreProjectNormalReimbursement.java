package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPreProjectNormalReimbursement extends GenericCondition{

	public ConditionPreProjectNormalReimbursement(){
		setParameterCount(10);
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getReimbursementName() {
		return this.__reimbursement_name;
	}

	public void setReimbursementName( java.lang.String value ) {
		this.__reimbursement_name = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getProjectNormalReimbursementId() {
		return __project_normal_reimbursement_id;
	}

	public void setProjectNormalReimbursementId(java.lang.Integer value ) {
		this.__project_normal_reimbursement_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(1, "processInstanceId", getProcessInstanceId()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(1, "applyEmployeeId", getApplyEmployeeId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getReimbursementName() != null) sb.append(__wrapString(1, "reimbursementName", getReimbursementName()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getAmount() != null) sb.append(__wrapNumber(1, "amount", getAmount()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getProjectNormalReimbursementId() != null) sb.append(__wrapNumber(1, "projectNormalReimbursementId", getProjectNormalReimbursementId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("reimbursementName")) != null) setReimbursementName(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("projectNormalReimbursementId")) != null) setProjectNormalReimbursementId(__getInt(val)); 
	}

	private java.lang.Integer __process_instance_id = null;
	private java.lang.Integer __apply_employee_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __reimbursement_name = null;
	private java.lang.Integer __status = null;
	private java.math.BigDecimal __amount = null;
	private java.lang.String __remark = null;
	private java.lang.String __code = null;
	private java.lang.Integer __project_normal_reimbursement_id = null;
}

