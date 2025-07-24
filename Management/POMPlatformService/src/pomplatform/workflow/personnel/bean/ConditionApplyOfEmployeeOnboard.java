package pomplatform.workflow.personnel.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionApplyOfEmployeeOnboard extends GenericCondition{

	public ConditionApplyOfEmployeeOnboard(){
		setParameterCount(8);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.lang.String getOwnedCompany() {
		return this.__owned_company;
	}

	public void setOwnedCompany( java.lang.String value ) {
		this.__owned_company = value;
	}

	public java.lang.Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( java.lang.Integer value ) {
		this.__duty_id = value;
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

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getOnboardDate() != null) sb.append(__wrapDate(1, "onboardDate", getOnboardDate()));
		if(getOwnedCompany() != null) sb.append(__wrapString(1, "ownedCompany", getOwnedCompany()));
		if(getDutyId() != null) sb.append(__wrapNumber(1, "dutyId", getDutyId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(1, "applyEmployeeId", getApplyEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("ownedCompany")) != null) setOwnedCompany(__getString(val));
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __process_type = null;
	private java.util.Date __onboard_date = null;
	private java.lang.String __owned_company = null;
	private java.lang.Integer __duty_id = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __employee_name = null;
	private java.lang.Integer __apply_employee_id = null;
}

