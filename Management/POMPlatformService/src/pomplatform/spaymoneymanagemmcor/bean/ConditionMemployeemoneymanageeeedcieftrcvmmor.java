package pomplatform.spaymoneymanagemmcor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMemployeemoneymanageeeedcieftrcvmmor extends GenericCondition{

	public ConditionMemployeemoneymanageeeedcieftrcvmmor(){
		setParameterCount(13);
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
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

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getFalg() {
		return this.__falg;
	}

	public void setFalg( java.lang.Integer value ) {
		this.__falg = value;
	}

	public java.lang.String getTitleName() {
		return this.__title_name == null ? null : (this.__title_name.indexOf("%") >= 0 ? this.__title_name : "%"+this.__title_name+"%");
	}

	public void setTitleName( java.lang.String value ) {
		this.__title_name = value;
	}

	public java.lang.String getReason() {
		return this.__reason == null ? null : (this.__reason.indexOf("%") >= 0 ? this.__reason : "%"+this.__reason+"%");
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getVoucherNo() {
		return this.__voucher_no == null ? null : (this.__voucher_no.indexOf("%") >= 0 ? this.__voucher_no : "%"+this.__voucher_no+"%");
	}

	public void setVoucherNo( java.lang.String value ) {
		this.__voucher_no = value;
	}

	public java.util.Date getMinOperateTime() {
		return this.__min_operate_time;
	}

	public void setMinOperateTime( java.util.Date value ) {
		this.__min_operate_time = value;
	}

	public java.util.Date getMaxOperateTime() {
		return this.__max_operate_time;
	}

	public void setMaxOperateTime( java.util.Date value ) {
		this.__max_operate_time = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(1, "isCompleted", getIsCompleted()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getFalg() != null) sb.append(__wrapNumber(1, "falg", getFalg()));
		if(getTitleName() != null) sb.append(__wrapString(1, "titleName", getTitleName()));
		if(getReason() != null) sb.append(__wrapString(1, "reason", getReason()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getVoucherNo() != null) sb.append(__wrapString(1, "voucherNo", getVoucherNo()));
		if(getMinOperateTime() != null) sb.append(__wrapDate(1, "minOperateTime", getMinOperateTime()));
		if(getMaxOperateTime() != null) sb.append(__wrapDate(1, "maxOperateTime", getMaxOperateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("falg")) != null) setFalg(__getInt(val)); 
		if((val = values.get("titleName")) != null) setTitleName(__getString(val));
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("voucherNo")) != null) setVoucherNo(__getString(val));
		if((val = values.get("minOperateTime")) != null) setMinOperateTime(__getDate(val)); 
		if((val = values.get("maxOperateTime")) != null) setMaxOperateTime(__getDate(val)); 
	}

	private java.lang.String __employee_no = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __code = null;
	private java.lang.Boolean __is_completed = null;
	private java.lang.String __employee_name = null;
	private java.lang.Integer __falg = null;
	private java.lang.String __title_name = null;
	private java.lang.String __reason = null;
	private java.lang.Integer __company_id = null;
	private java.lang.String __voucher_no = null;
	private java.util.Date __min_operate_time = null;
	private java.util.Date __max_operate_time = null;
}

