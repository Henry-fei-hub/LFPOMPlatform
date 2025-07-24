package pomplatform.approvalbudgetmanagementapplywork.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionApprovalBudgetManagementApplyWork extends GenericCondition{

	public ConditionApprovalBudgetManagementApplyWork(){
		setParameterCount(10);
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

	public java.lang.Integer getBdType() {
		return this.__bd_type;
	}

	public void setBdType( java.lang.Integer value ) {
		this.__bd_type = value;
	}

	public java.lang.String getBdCode() {
		return this.__bd_code;
	}

	public void setBdCode( java.lang.String value ) {
		this.__bd_code = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getBdApplyEmployeeId() {
		return this.__bd_apply_employee_id;
	}

	public void setBdApplyEmployeeId( java.lang.Integer value ) {
		this.__bd_apply_employee_id = value;
	}

	public java.util.Date getBdApplyTime() {
		return this.__bd_apply_time;
	}

	public void setBdApplyTime( java.util.Date value ) {
		this.__bd_apply_time = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getBdType() != null) sb.append(__wrapNumber(1, "bdType", getBdType()));
		if(getBdCode() != null) sb.append(__wrapString(1, "bdCode", getBdCode()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getBdApplyEmployeeId() != null) sb.append(__wrapNumber(1, "bdApplyEmployeeId", getBdApplyEmployeeId()));
		if(getBdApplyTime() != null) sb.append(__wrapDate(1, "bdApplyTime", getBdApplyTime()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("bdType")) != null) setBdType(__getInt(val)); 
		if((val = values.get("bdCode")) != null) setBdCode(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("bdApplyEmployeeId")) != null) setBdApplyEmployeeId(__getInt(val)); 
		if((val = values.get("bdApplyTime")) != null) setBdApplyTime(__getDate(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	private java.lang.Integer __process_type = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __bd_type = null;
	private java.lang.String __bd_code = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __bd_apply_employee_id = null;
	private java.util.Date __bd_apply_time = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __plate_id = null;
}

