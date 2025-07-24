package pomplatform.budgetmanagement.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionOnBudgetManagement extends GenericCondition{

	public ConditionOnBudgetManagement(){
		setParameterCount(12);
	}

	public java.lang.String getBdCode() {
		return this.__bd_code;
	}

	public void setBdCode( java.lang.String value ) {
		this.__bd_code = value;
	}

	public java.lang.Integer getBdType() {
		return this.__bd_type;
	}

	public void setBdType( java.lang.Integer value ) {
		this.__bd_type = value;
	}

	public java.math.BigDecimal getBdTotalAmount() {
		return this.__bd_total_amount;
	}

	public void setBdTotalAmount( java.math.BigDecimal value ) {
		this.__bd_total_amount = value;
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

	public java.util.Date getBdEstimatecloseTime() {
		return this.__bd_estimateclose_time;
	}

	public void setBdEstimatecloseTime( java.util.Date value ) {
		this.__bd_estimateclose_time = value;
	}

	public java.lang.Integer getBdStatus() {
		return this.__bd_status;
	}

	public void setBdStatus( java.lang.Integer value ) {
		this.__bd_status = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getBdRemark() {
		return this.__bd_remark;
	}

	public void setBdRemark( java.lang.String value ) {
		this.__bd_remark = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}
	
	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
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
		if(getBdCode() != null) sb.append(__wrapString(1, "bdCode", getBdCode()));
		if(getBdType() != null) sb.append(__wrapNumber(1, "bdType", getBdType()));
		if(getBdTotalAmount() != null) sb.append(__wrapNumber(1, "bdTotalAmount", getBdTotalAmount()));
		if(getBdApplyEmployeeId() != null) sb.append(__wrapNumber(1, "bdApplyEmployeeId", getBdApplyEmployeeId()));
		if(getBdApplyTime() != null) sb.append(__wrapDate(1, "bdApplyTime", getBdApplyTime()));
		if(getBdEstimatecloseTime() != null) sb.append(__wrapDate(1, "bdEstimatecloseTime", getBdEstimatecloseTime()));
		if(getBdStatus() != null) sb.append(__wrapNumber(1, "bdStatus", getBdStatus()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getBdRemark() != null) sb.append(__wrapString(1, "bdRemark", getBdRemark()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("bdCode")) != null) setBdCode(__getString(val));
		if((val = values.get("bdType")) != null) setBdType(__getInt(val)); 
		if((val = values.get("bdTotalAmount")) != null) setBdTotalAmount(__getDecimal(val));  
		if((val = values.get("bdApplyEmployeeId")) != null) setBdApplyEmployeeId(__getInt(val)); 
		if((val = values.get("bdApplyTime")) != null) setBdApplyTime(__getDate(val)); 
		if((val = values.get("bdEstimatecloseTime")) != null) setBdEstimatecloseTime(__getDate(val)); 
		if((val = values.get("bdStatus")) != null) setBdStatus(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("bdRemark")) != null) setBdRemark(__getString(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val));
	}

	private java.lang.String __bd_code = null;
	private java.lang.Integer __bd_type = null;
	private java.math.BigDecimal __bd_total_amount = null;
	private java.lang.Integer __bd_apply_employee_id = null;
	private java.util.Date __bd_apply_time = null;
	private java.util.Date __bd_estimateclose_time = null;
	private java.lang.Integer __bd_status = null;
	private java.lang.Integer __project_id = null;
	private java.lang.String __bd_remark = null;
	private java.lang.Integer __process_status = null;
	private java.lang.String __project_name = null;
	private java.lang.Integer __department_id=null;
	
}

