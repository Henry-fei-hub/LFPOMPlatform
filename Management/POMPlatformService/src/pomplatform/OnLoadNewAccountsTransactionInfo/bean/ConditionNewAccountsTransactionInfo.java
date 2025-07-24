package pomplatform.OnLoadNewAccountsTransactionInfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionNewAccountsTransactionInfo extends GenericCondition{

	public ConditionNewAccountsTransactionInfo(){
		setParameterCount(17);
	}

	public java.lang.Integer getAccountTransactionId() {
		return this.__account_transaction_id;
	}

	public void setAccountTransactionId( java.lang.Integer value ) {
		this.__account_transaction_id = value;
	}

	public java.lang.Integer getAccountId() {
		return this.__account_id;
	}

	public void setAccountId( java.lang.Integer value ) {
		this.__account_id = value;
	}

	public java.math.BigDecimal getOriginalCurrencyDebit() {
		return this.__original_currency_debit;
	}

	public void setOriginalCurrencyDebit( java.math.BigDecimal value ) {
		this.__original_currency_debit = value;
	}

	public java.math.BigDecimal getOriginalCurrencyLoan() {
		return this.__original_currency_loan;
	}

	public void setOriginalCurrencyLoan( java.math.BigDecimal value ) {
		this.__original_currency_loan = value;
	}

	public java.math.BigDecimal getExchangeRate() {
		return this.__exchange_rate;
	}

	public void setExchangeRate( java.math.BigDecimal value ) {
		this.__exchange_rate = value;
	}

	public java.math.BigDecimal getStandardMoneyDebit() {
		return this.__standard_money_debit;
	}

	public void setStandardMoneyDebit( java.math.BigDecimal value ) {
		this.__standard_money_debit = value;
	}

	public java.math.BigDecimal getStandardMoneyLoan() {
		return this.__standard_money_loan;
	}

	public void setStandardMoneyLoan( java.math.BigDecimal value ) {
		this.__standard_money_loan = value;
	}

	public java.lang.Integer getItemCategory() {
		return this.__item_category;
	}

	public void setItemCategory( java.lang.Integer value ) {
		this.__item_category = value;
	}

	public java.lang.String getMainProjectCode() {
		return this.__main_project_code;
	}

	public void setMainProjectCode( java.lang.String value ) {
		this.__main_project_code = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
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

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.util.Date getAffiliationDate() {
		return this.__affiliation_date;
	}

	public void setAffiliationDate( java.util.Date value ) {
		this.__affiliation_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getAccountCode() {
		return this.__account_code;
	}

	public void setAccountCode( java.lang.String value ) {
		this.__account_code = value;
	}

	public java.lang.String getRunningAccount() {
		return this.__running_account;
	}

	public void setRunningAccount( java.lang.String value ) {
		this.__running_account = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAccountTransactionId() != null) sb.append(__wrapNumber(1, "accountTransactionId", getAccountTransactionId()));
		if(getAccountId() != null) sb.append(__wrapNumber(1, "accountId", getAccountId()));
		if(getOriginalCurrencyDebit() != null) sb.append(__wrapNumber(1, "originalCurrencyDebit", getOriginalCurrencyDebit()));
		if(getOriginalCurrencyLoan() != null) sb.append(__wrapNumber(1, "originalCurrencyLoan", getOriginalCurrencyLoan()));
		if(getExchangeRate() != null) sb.append(__wrapNumber(1, "exchangeRate", getExchangeRate()));
		if(getStandardMoneyDebit() != null) sb.append(__wrapNumber(1, "standardMoneyDebit", getStandardMoneyDebit()));
		if(getStandardMoneyLoan() != null) sb.append(__wrapNumber(1, "standardMoneyLoan", getStandardMoneyLoan()));
		if(getItemCategory() != null) sb.append(__wrapNumber(1, "itemCategory", getItemCategory()));
		if(getMainProjectCode() != null) sb.append(__wrapString(1, "mainProjectCode", getMainProjectCode()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getRecordDate() != null) sb.append(__wrapDate(1, "recordDate", getRecordDate()));
		if(getAffiliationDate() != null) sb.append(__wrapDate(1, "affiliationDate", getAffiliationDate()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getAccountCode() != null) sb.append(__wrapString(1, "accountCode", getAccountCode()));
		if(getRunningAccount() != null) sb.append(__wrapString(1, "runningAccount", getRunningAccount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("accountTransactionId")) != null) setAccountTransactionId(__getInt(val)); 
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
		if((val = values.get("originalCurrencyDebit")) != null) setOriginalCurrencyDebit(__getDecimal(val));  
		if((val = values.get("originalCurrencyLoan")) != null) setOriginalCurrencyLoan(__getDecimal(val));  
		if((val = values.get("exchangeRate")) != null) setExchangeRate(__getDecimal(val));  
		if((val = values.get("standardMoneyDebit")) != null) setStandardMoneyDebit(__getDecimal(val));  
		if((val = values.get("standardMoneyLoan")) != null) setStandardMoneyLoan(__getDecimal(val));  
		if((val = values.get("itemCategory")) != null) setItemCategory(__getInt(val)); 
		if((val = values.get("mainProjectCode")) != null) setMainProjectCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("affiliationDate")) != null) setAffiliationDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("accountCode")) != null) setAccountCode(__getString(val));
		if((val = values.get("runningAccount")) != null) setRunningAccount(__getString(val));
	}

	private java.lang.Integer __account_transaction_id = null;
	private java.lang.Integer __account_id = null;
	private java.math.BigDecimal __original_currency_debit = null;
	private java.math.BigDecimal __original_currency_loan = null;
	private java.math.BigDecimal __exchange_rate = null;
	private java.math.BigDecimal __standard_money_debit = null;
	private java.math.BigDecimal __standard_money_loan = null;
	private java.lang.Integer __item_category = null;
	private java.lang.String __main_project_code = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __employee_id = null;
	private java.util.Date __record_date = null;
	private java.util.Date __affiliation_date = null;
	private java.lang.String __remark = null;
	private java.lang.String __account_code = null;
	private java.lang.String __running_account = null;
}

