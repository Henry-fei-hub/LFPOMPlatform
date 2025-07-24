package pomplatform.spaymoneymanagemmcor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSpaymoneymanagemmcor extends GenericCondition{

	public ConditionSpaymoneymanagemmcor(){
		setParameterCount(12);
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

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getVoucherNo() {
		return this.__voucher_no == null ? null : (this.__voucher_no.indexOf("%") >= 0 ? this.__voucher_no : "%"+this.__voucher_no+"%");
	}

	public void setVoucherNo( java.lang.String value ) {
		this.__voucher_no = value;
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

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.lang.String getReason() {
		return this.__reason == null ? null : (this.__reason.indexOf("%") >= 0 ? this.__reason : "%"+this.__reason+"%");
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.String getReceiveUnit() {
		return this.__receive_unit == null ? null : (this.__receive_unit.indexOf("%") >= 0 ? this.__receive_unit : "%"+this.__receive_unit+"%");
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account == null ? null : (this.__bank_account.indexOf("%") >= 0 ? this.__bank_account : "%"+this.__bank_account+"%");
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name == null ? null : (this.__bank_name.indexOf("%") >= 0 ? this.__bank_name : "%"+this.__bank_name+"%");
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getTitleName() {
		return this.__title_name == null ? null : (this.__title_name.indexOf("%") >= 0 ? this.__title_name : "%"+this.__title_name+"%");
	}

	public void setTitleName( java.lang.String value ) {
		this.__title_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinOperateTime() != null) sb.append(__wrapDate(1, "minOperateTime", getMinOperateTime()));
		if(getMaxOperateTime() != null) sb.append(__wrapDate(1, "maxOperateTime", getMaxOperateTime()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getVoucherNo() != null) sb.append(__wrapString(1, "voucherNo", getVoucherNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		if(getReason() != null) sb.append(__wrapString(1, "reason", getReason()));
		if(getReceiveUnit() != null) sb.append(__wrapString(1, "receiveUnit", getReceiveUnit()));
		if(getBankAccount() != null) sb.append(__wrapString(1, "bankAccount", getBankAccount()));
		if(getBankName() != null) sb.append(__wrapString(1, "bankName", getBankName()));
		if(getTitleName() != null) sb.append(__wrapString(1, "titleName", getTitleName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minOperateTime")) != null) setMinOperateTime(__getDate(val)); 
		if((val = values.get("maxOperateTime")) != null) setMaxOperateTime(__getDate(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("voucherNo")) != null) setVoucherNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("titleName")) != null) setTitleName(__getString(val));
	}

	private java.util.Date __min_operate_time = null;
	private java.util.Date __max_operate_time = null;
	private java.lang.String __code = null;
	private java.lang.String __voucher_no = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __operate_employee_id = null;
	private java.lang.String __reason = null;
	private java.lang.String __receive_unit = null;
	private java.lang.String __bank_account = null;
	private java.lang.String __bank_name = null;
	private java.lang.String __title_name = null;
}

