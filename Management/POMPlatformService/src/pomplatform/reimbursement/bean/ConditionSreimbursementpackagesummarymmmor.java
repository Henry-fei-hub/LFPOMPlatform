package pomplatform.reimbursement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSreimbursementpackagesummarymmmor extends GenericCondition{

	public ConditionSreimbursementpackagesummarymmmor(){
		setParameterCount(19);
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

	public java.util.Date getMinUpdateTime() {
		return this.__min_update_time;
	}

	public void setMinUpdateTime( java.util.Date value ) {
		this.__min_update_time = value;
	}

	public java.util.Date getMaxUpdateTime() {
		return this.__max_update_time;
	}

	public void setMaxUpdateTime( java.util.Date value ) {
		this.__max_update_time = value;
	}

	public java.lang.Integer getOtherName() {
		return this.__other_name;
	}

	public void setOtherName( java.lang.Integer value ) {
		this.__other_name = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getPaymentAmount() {
		return this.__payment_amount;
	}

	public void setPaymentAmount( java.math.BigDecimal value ) {
		this.__payment_amount = value;
	}

	public java.math.BigDecimal getStrikeABalanceAmount() {
		return this.__strike_a_balance_amount;
	}

	public void setStrikeABalanceAmount( java.math.BigDecimal value ) {
		this.__strike_a_balance_amount = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.String getPayeeName() {
		return this.__payee_name == null ? null : (this.__payee_name.indexOf("%") >= 0 ? this.__payee_name : "%"+this.__payee_name+"%");
	}

	public void setPayeeName( java.lang.String value ) {
		this.__payee_name = value;
	}

	public java.lang.String getSelfBankName() {
		return this.__self_bank_name == null ? null : (this.__self_bank_name.indexOf("%") >= 0 ? this.__self_bank_name : "%"+this.__self_bank_name+"%");
	}

	public void setSelfBankName( java.lang.String value ) {
		this.__self_bank_name = value;
	}

	public java.lang.String getSelfBankAccount() {
		return this.__self_bank_account == null ? null : (this.__self_bank_account.indexOf("%") >= 0 ? this.__self_bank_account : "%"+this.__self_bank_account+"%");
	}

	public void setSelfBankAccount( java.lang.String value ) {
		this.__self_bank_account = value;
	}

	public java.lang.String getOtherBankName() {
		return this.__other_bank_name == null ? null : (this.__other_bank_name.indexOf("%") >= 0 ? this.__other_bank_name : "%"+this.__other_bank_name+"%");
	}

	public void setOtherBankName( java.lang.String value ) {
		this.__other_bank_name = value;
	}

	public java.lang.String getOtherBankAccount() {
		return this.__other_bank_account == null ? null : (this.__other_bank_account.indexOf("%") >= 0 ? this.__other_bank_account : "%"+this.__other_bank_account+"%");
	}

	public void setOtherBankAccount( java.lang.String value ) {
		this.__other_bank_account = value;
	}

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return this.__reimbursement_package_summary_id;
	}

	public void setReimbursementPackageSummaryId( java.lang.Integer value ) {
		this.__reimbursement_package_summary_id = value;
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Integer getPayFor() {
		return this.__pay_for;
	}

	public void setPayFor( java.lang.Integer value ) {
		this.__pay_for = value;
	}

	public java.lang.Integer getEmployeeOrCompanyId() {
		return this.__employee_or_company_id;
	}

	public void setEmployeeOrCompanyId( java.lang.Integer value ) {
		this.__employee_or_company_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getMinUpdateTime() != null) sb.append(__wrapDate(1, "minUpdateTime", getMinUpdateTime()));
		if(getMaxUpdateTime() != null) sb.append(__wrapDate(1, "maxUpdateTime", getMaxUpdateTime()));
		if(getOtherName() != null) sb.append(__wrapNumber(1, "otherName", getOtherName()));
		if(getAmount() != null) sb.append(__wrapNumber(1, "amount", getAmount()));
		if(getPaymentAmount() != null) sb.append(__wrapNumber(1, "paymentAmount", getPaymentAmount()));
		if(getStrikeABalanceAmount() != null) sb.append(__wrapNumber(1, "strikeABalanceAmount", getStrikeABalanceAmount()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(1, "isCompleted", getIsCompleted()));
		if(getPayeeName() != null) sb.append(__wrapString(1, "payeeName", getPayeeName()));
		if(getSelfBankName() != null) sb.append(__wrapString(1, "selfBankName", getSelfBankName()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(1, "selfBankAccount", getSelfBankAccount()));
		if(getOtherBankName() != null) sb.append(__wrapString(1, "otherBankName", getOtherBankName()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(1, "otherBankAccount", getOtherBankAccount()));
		if(getReimbursementPackageSummaryId() != null) sb.append(__wrapNumber(1, "reimbursementPackageSummaryId", getReimbursementPackageSummaryId()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(1, "reimbursementPackageId", getReimbursementPackageId()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(1, "moneyAttribute", getMoneyAttribute()));
		if(getPayFor() != null) sb.append(__wrapNumber(1, "payFor", getPayFor()));
		if(getEmployeeOrCompanyId() != null) sb.append(__wrapNumber(1, "employeeOrCompanyId", getEmployeeOrCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("minUpdateTime")) != null) setMinUpdateTime(__getDate(val)); 
		if((val = values.get("maxUpdateTime")) != null) setMaxUpdateTime(__getDate(val)); 
		if((val = values.get("otherName")) != null) setOtherName(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("paymentAmount")) != null) setPaymentAmount(__getDecimal(val));  
		if((val = values.get("strikeABalanceAmount")) != null) setStrikeABalanceAmount(__getDecimal(val));  
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("payeeName")) != null) setPayeeName(__getString(val));
		if((val = values.get("selfBankName")) != null) setSelfBankName(__getString(val));
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("otherBankName")) != null) setOtherBankName(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("reimbursementPackageSummaryId")) != null) setReimbursementPackageSummaryId(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("payFor")) != null) setPayFor(__getInt(val)); 
		if((val = values.get("employeeOrCompanyId")) != null) setEmployeeOrCompanyId(__getInt(val)); 
	}

	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.util.Date __min_update_time = null;
	private java.util.Date __max_update_time = null;
	private java.lang.Integer __other_name = null;
	private java.math.BigDecimal __amount = null;
	private java.math.BigDecimal __payment_amount = null;
	private java.math.BigDecimal __strike_a_balance_amount = null;
	private java.lang.Boolean __is_completed = null;
	private java.lang.String __payee_name = null;
	private java.lang.String __self_bank_name = null;
	private java.lang.String __self_bank_account = null;
	private java.lang.String __other_bank_name = null;
	private java.lang.String __other_bank_account = null;
	private java.lang.Integer __reimbursement_package_summary_id = null;
	private java.lang.Integer __reimbursement_package_id = null;
	private java.lang.Integer __money_attribute = null;
	private java.lang.Integer __pay_for = null;
	private java.lang.Integer __employee_or_company_id = null;
}

