package pomplatform.sreimbursementpackagemmror.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSreimbursementpackagemmror extends GenericCondition{

	public ConditionSreimbursementpackagemmror(){
		setParameterCount(16);
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

	public java.lang.Boolean getIsOnlinePay() {
		return __is_online_pay;
	}

	public void setIsOnlinePay(java.lang.Boolean value) {
		this.__is_online_pay = value;
	}

	public java.lang.Integer getPayStatus() {
		return __pay_status;
	}

	public void setPayStatus(java.lang.Integer value) {
		this.__pay_status = value;
	}

	public java.math.BigDecimal getAmount() {
		return __amount;
	}

	public void setAmount(java.math.BigDecimal value) {
		this.__amount = value;
	}

	public java.math.BigDecimal getPaymentAmount() {
		return __payment_amount;
	}

	public void setPaymentAmount(java.math.BigDecimal value) {
		this.__payment_amount = value;
	}

	public java.math.BigDecimal getStrikeABalanceAmount() {
		return __strike_a_balance_amount;
	}

	public void setStrikeABalanceAmount(java.math.BigDecimal value) {
		this.__strike_a_balance_amount = value;
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
		if(getIsOnlinePay() != null) sb.append(__wrapBoolean(1, "isOnlinePay", getIsOnlinePay()));
		if(getPayStatus() != null) sb.append(__wrapNumber(1, "payStatus", getPayStatus()));
		if(getAmount() != null) sb.append(__wrapNumber(1, "amount", getAmount()));
		if(getPaymentAmount() != null) sb.append(__wrapNumber(1, "paymentAmount", getPaymentAmount()));
		if(getStrikeABalanceAmount() != null) sb.append(__wrapNumber(1, "strikeABalanceAmount", getStrikeABalanceAmount()));
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
		if((val = values.get("isOnlinePay")) != null) setIsOnlinePay(__getBoolean(val));
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));
		if((val = values.get("paymentAmount")) != null) setPaymentAmount(__getDecimal(val));
		if((val = values.get("strikeABalanceAmount")) != null) setStrikeABalanceAmount(__getDecimal(val));
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
	private java.lang.Boolean __is_online_pay = null;
	private java.lang.Integer __pay_status = null;
	private java.math.BigDecimal __amount = null;
	private java.math.BigDecimal __payment_amount = null;
	private java.math.BigDecimal __strike_a_balance_amount = null;
}

