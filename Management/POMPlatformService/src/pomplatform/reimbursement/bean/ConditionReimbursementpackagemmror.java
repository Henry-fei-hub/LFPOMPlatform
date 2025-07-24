package pomplatform.reimbursement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionReimbursementpackagemmror extends GenericCondition{

	public ConditionReimbursementpackagemmror(){
		setParameterCount(12);
	}

	public java.util.Date getMinCreateTime() {
		return this.__min_create_time;
	}

	public void setMinCreateTime( java.util.Date value ) {
		this.__min_create_time = value;
	}

	public java.util.Date getMaxCreateTime() {
		return this.__max_create_time;
	}

	public void setMaxCreateTime( java.util.Date value ) {
		this.__max_create_time = value;
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( java.lang.Integer value ) {
		this.__role_id = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getOrderCode() {
		return this.__order_code == null ? null : (this.__order_code.indexOf("%") >= 0 ? this.__order_code : "%"+this.__order_code+"%");
	}

	public void setOrderCode( java.lang.String value ) {
		this.__order_code = value;
	}

	public java.lang.Integer getPayStatus() {
		return __pay_status;
	}

	public void setPayStatus(java.lang.Integer value) {
		this.__pay_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(1, "reimbursementPackageId", getReimbursementPackageId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(1, "isCompleted", getIsCompleted()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getRoleId() != null) sb.append(__wrapNumber(1, "roleId", getRoleId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(1, "operatorId", getOperatorId()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getOrderCode() != null) sb.append(__wrapString(1, "orderCode", getOrderCode()));
		if(getPayStatus() != null) sb.append(__wrapNumber(1, "payStatus", getPayStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("orderCode")) != null) setOrderCode(__getString(val));
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val)); 
	}

	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.lang.Integer __reimbursement_package_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Boolean __is_completed = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __role_id = null;
	private java.lang.Integer __operator_id = null;
	private java.lang.String __code = null;
	private java.lang.String __order_code = null;
	private java.lang.Integer __pay_status = null;
}

