package pomplatform.scapitaldistributionor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCapitalDistributionsAttentionOfWorkflow extends GenericCondition{

	public ConditionCapitalDistributionsAttentionOfWorkflow(){
		setParameterCount(11);
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getTitle() {
		return this.__title == null ? null : (this.__title.indexOf("%") >= 0 ? this.__title : "%"+this.__title+"%");
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.String getOtherName() {
		return this.__other_name == null ? null : (this.__other_name.indexOf("%") >= 0 ? this.__other_name : "%"+this.__other_name+"%");
	}

	public void setOtherName( java.lang.String value ) {
		this.__other_name = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getBorrowMoney() != null) sb.append(__wrapNumber(1, "borrowMoney", getBorrowMoney()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getTitle() != null) sb.append(__wrapString(1, "title", getTitle()));
		if(getOtherName() != null) sb.append(__wrapString(1, "otherName", getOtherName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("otherName")) != null) setOtherName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
	}

	private java.lang.Integer __status = null;
	private java.lang.Integer __process_type = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.String __contract_name = null;
	private java.math.BigDecimal __borrow_money = null;
	private java.lang.String __customer_name = null;
	private java.lang.String __title = null;
	private java.lang.String __other_name = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __code = null;
}

