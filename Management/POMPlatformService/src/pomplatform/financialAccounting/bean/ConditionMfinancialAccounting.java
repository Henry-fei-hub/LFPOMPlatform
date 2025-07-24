package pomplatform.financialAccounting.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMfinancialAccounting extends GenericCondition{

	public ConditionMfinancialAccounting(){
		setParameterCount(14);
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.util.Date getPostingDateBegin() {
		return this.__posting_date_begin;
	}

	public void setPostingDateBegin( java.util.Date value ) {
		this.__posting_date_begin = value;
	}

	public java.util.Date getPostingDateEnd() {
		return this.__posting_date_end;
	}

	public void setPostingDateEnd( java.util.Date value ) {
		this.__posting_date_end = value;
	}

	public java.util.Date getCompleteTimeBegin() {
		return this.__complete_time_begin;
	}

	public void setCompleteTimeBegin( java.util.Date value ) {
		this.__complete_time_begin = value;
	}

	public java.util.Date getCompleteTimeEnd() {
		return this.__complete_time_end;
	}

	public void setCompleteTimeEnd( java.util.Date value ) {
		this.__complete_time_end = value;
	}

	public java.util.Date getApplyTimeBegin() {
		return this.__apply_time_begin;
	}

	public void setApplyTimeBegin( java.util.Date value ) {
		this.__apply_time_begin = value;
	}

	public java.util.Date getApplyTimeEnd() {
		return this.__apply_time_end;
	}

	public void setApplyTimeEnd( java.util.Date value ) {
		this.__apply_time_end = value;
	}

	public java.lang.Boolean getBePacked() {
		return this.__be_packed;
	}

	public void setBePacked( java.lang.Boolean value ) {
		this.__be_packed = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getVoucherNo() != null) sb.append(__wrapString(1, "voucherNo", getVoucherNo()));
		if(getPostingDateBegin() != null) sb.append(__wrapDate(1, "postingDateBegin", getPostingDateBegin()));
		if(getPostingDateEnd() != null) sb.append(__wrapDate(1, "postingDateEnd", getPostingDateEnd()));
		if(getCompleteTimeBegin() != null) sb.append(__wrapDate(1, "completeTimeBegin", getCompleteTimeBegin()));
		if(getCompleteTimeEnd() != null) sb.append(__wrapDate(1, "completeTimeEnd", getCompleteTimeEnd()));
		if(getApplyTimeBegin() != null) sb.append(__wrapDate(1, "applyTimeBegin", getApplyTimeBegin()));
		if(getApplyTimeEnd() != null) sb.append(__wrapDate(1, "applyTimeEnd", getApplyTimeEnd()));
		if(getBePacked() != null) sb.append(__wrapBoolean(1, "bePacked", getBePacked()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("voucherNo")) != null) setVoucherNo(__getString(val));
		if((val = values.get("postingDateBegin")) != null) setPostingDateBegin(__getDate(val)); 
		if((val = values.get("postingDateEnd")) != null) setPostingDateEnd(__getDate(val)); 
		if((val = values.get("completeTimeBegin")) != null) setCompleteTimeBegin(__getDate(val)); 
		if((val = values.get("completeTimeEnd")) != null) setCompleteTimeEnd(__getDate(val)); 
		if((val = values.get("applyTimeBegin")) != null) setApplyTimeBegin(__getDate(val)); 
		if((val = values.get("applyTimeEnd")) != null) setApplyTimeEnd(__getDate(val)); 
		if((val = values.get("bePacked")) != null) setBePacked(__getBoolean(val));
	}

	private java.lang.Integer __process_status = null;
	private java.lang.Integer __process_type = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __code = null;
	private java.lang.String __voucher_no = null;
	private java.util.Date __posting_date_begin = null;
	private java.util.Date __posting_date_end = null;
	private java.util.Date __complete_time_begin = null;
	private java.util.Date __complete_time_end = null;
	private java.util.Date __apply_time_begin = null;
	private java.util.Date __apply_time_end = null;
	private java.lang.Boolean __be_packed = null;
}

