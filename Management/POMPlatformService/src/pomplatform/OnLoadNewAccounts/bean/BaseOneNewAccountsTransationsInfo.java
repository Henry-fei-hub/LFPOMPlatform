package pomplatform.OnLoadNewAccounts.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOneNewAccountsTransationsInfo extends GenericBase implements BaseFactory<BaseOneNewAccountsTransationsInfo>, Comparable<BaseOneNewAccountsTransationsInfo> 
{


	public static BaseOneNewAccountsTransationsInfo newInstance(){
		return new BaseOneNewAccountsTransationsInfo();
	}

	@Override
	public BaseOneNewAccountsTransationsInfo make(){
		BaseOneNewAccountsTransationsInfo b = new BaseOneNewAccountsTransationsInfo();
		return b;
	}

	public final static java.lang.String CS_ACCOUNT_NAME = "account_name" ;
	public final static java.lang.String CS_ACCOUNT_TRANSACTION_ID = "account_transaction_id" ;
	public final static java.lang.String CS_ACCOUNT_ID = "account_id" ;
	public final static java.lang.String CS_ORIGINAL_CURRENCY_DEBIT = "original_currency_debit" ;
	public final static java.lang.String CS_ORIGINAL_CURRENCY_LOAN = "original_currency_loan" ;
	public final static java.lang.String CS_EXCHANGE_RATE = "exchange_rate" ;
	public final static java.lang.String CS_STANDARD_MONEY_DEBIT = "standard_money_debit" ;
	public final static java.lang.String CS_STANDARD_MONEY_LOAN = "standard_money_loan" ;
	public final static java.lang.String CS_ITEM_CATEGORY = "item_category" ;
	public final static java.lang.String CS_MAIN_PROJECT_CODE = "main_project_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_AFFILIATION_DATE = "affiliation_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_ACCOUNT_CODE = "account_code" ;
	public final static java.lang.String CS_RUNNING_ACCOUNT = "running_account" ;

	public final static java.lang.String ALL_CAPTIONS = "账户名称,主键,账户表主键,原币借,原币借,汇率,本位币,本位贷,事项类别,大项目编号,合同,部门编码,业务部门,员工编码,记录时间,归属时间,备注,账户编号（唯一）,交易流水号";

	public java.lang.String getAccountName() {
		return this.__account_name;
	}

	public void setAccountName( java.lang.String value ) {
		this.__account_name = value;
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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public void cloneCopy(BaseOneNewAccountsTransationsInfo __bean){
		__bean.setAccountName(getAccountName());
		__bean.setAccountTransactionId(getAccountTransactionId());
		__bean.setAccountId(getAccountId());
		__bean.setOriginalCurrencyDebit(getOriginalCurrencyDebit());
		__bean.setOriginalCurrencyLoan(getOriginalCurrencyLoan());
		__bean.setExchangeRate(getExchangeRate());
		__bean.setStandardMoneyDebit(getStandardMoneyDebit());
		__bean.setStandardMoneyLoan(getStandardMoneyLoan());
		__bean.setItemCategory(getItemCategory());
		__bean.setMainProjectCode(getMainProjectCode());
		__bean.setContractId(getContractId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRecordDate(getRecordDate());
		__bean.setAffiliationDate(getAffiliationDate());
		__bean.setRemark(getRemark());
		__bean.setAccountCode(getAccountCode());
		__bean.setRunningAccount(getRunningAccount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAccountName() == null ? "" : getAccountName());
		sb.append(",");
		sb.append(getAccountTransactionId() == null ? "" : getAccountTransactionId());
		sb.append(",");
		sb.append(getAccountId() == null ? "" : getAccountId());
		sb.append(",");
		sb.append(getOriginalCurrencyDebit() == null ? "" : getOriginalCurrencyDebit());
		sb.append(",");
		sb.append(getOriginalCurrencyLoan() == null ? "" : getOriginalCurrencyLoan());
		sb.append(",");
		sb.append(getExchangeRate() == null ? "" : getExchangeRate());
		sb.append(",");
		sb.append(getStandardMoneyDebit() == null ? "" : getStandardMoneyDebit());
		sb.append(",");
		sb.append(getStandardMoneyLoan() == null ? "" : getStandardMoneyLoan());
		sb.append(",");
		sb.append(getItemCategory() == null ? "" : getItemCategory());
		sb.append(",");
		sb.append(getMainProjectCode() == null ? "" : getMainProjectCode());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getAffiliationDate() == null ? "" : sdf.format(getAffiliationDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getAccountCode() == null ? "" : getAccountCode());
		sb.append(",");
		sb.append(getRunningAccount() == null ? "" : getRunningAccount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOneNewAccountsTransationsInfo o) {
		return __account_transaction_id == null ? -1 : __account_transaction_id.compareTo(o.getAccountTransactionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__account_name);
		hash = 97 * hash + Objects.hashCode(this.__account_transaction_id);
		hash = 97 * hash + Objects.hashCode(this.__account_id);
		hash = 97 * hash + Objects.hashCode(this.__original_currency_debit);
		hash = 97 * hash + Objects.hashCode(this.__original_currency_loan);
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate);
		hash = 97 * hash + Objects.hashCode(this.__standard_money_debit);
		hash = 97 * hash + Objects.hashCode(this.__standard_money_loan);
		hash = 97 * hash + Objects.hashCode(this.__item_category);
		hash = 97 * hash + Objects.hashCode(this.__main_project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__affiliation_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__account_code);
		hash = 97 * hash + Objects.hashCode(this.__running_account);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOneNewAccountsTransationsInfo o = (BaseOneNewAccountsTransationsInfo)obj;
		if(!Objects.equals(this.__account_name, o.getAccountName())) return false;
		if(!Objects.equals(this.__account_transaction_id, o.getAccountTransactionId())) return false;
		if(!Objects.equals(this.__account_id, o.getAccountId())) return false;
		if(!Objects.equals(this.__original_currency_debit, o.getOriginalCurrencyDebit())) return false;
		if(!Objects.equals(this.__original_currency_loan, o.getOriginalCurrencyLoan())) return false;
		if(!Objects.equals(this.__exchange_rate, o.getExchangeRate())) return false;
		if(!Objects.equals(this.__standard_money_debit, o.getStandardMoneyDebit())) return false;
		if(!Objects.equals(this.__standard_money_loan, o.getStandardMoneyLoan())) return false;
		if(!Objects.equals(this.__item_category, o.getItemCategory())) return false;
		if(!Objects.equals(this.__main_project_code, o.getMainProjectCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__affiliation_date, o.getAffiliationDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__account_code, o.getAccountCode())) return false;
		if(!Objects.equals(this.__running_account, o.getRunningAccount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAccountName() != null) sb.append(__wrapString(count++, "accountName", getAccountName()));
		if(getAccountTransactionId() != null) sb.append(__wrapNumber(count++, "accountTransactionId", getAccountTransactionId()));
		if(getAccountId() != null) sb.append(__wrapNumber(count++, "accountId", getAccountId()));
		if(getOriginalCurrencyDebit() != null) sb.append(__wrapDecimal(count++, "originalCurrencyDebit", getOriginalCurrencyDebit()));
		if(getOriginalCurrencyLoan() != null) sb.append(__wrapDecimal(count++, "originalCurrencyLoan", getOriginalCurrencyLoan()));
		if(getExchangeRate() != null) sb.append(__wrapDecimal(count++, "exchangeRate", getExchangeRate()));
		if(getStandardMoneyDebit() != null) sb.append(__wrapDecimal(count++, "standardMoneyDebit", getStandardMoneyDebit()));
		if(getStandardMoneyLoan() != null) sb.append(__wrapDecimal(count++, "standardMoneyLoan", getStandardMoneyLoan()));
		if(getItemCategory() != null) sb.append(__wrapNumber(count++, "itemCategory", getItemCategory()));
		if(getMainProjectCode() != null) sb.append(__wrapString(count++, "mainProjectCode", getMainProjectCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getAffiliationDate() != null) sb.append(__wrapDate(count++, "affiliationDate", getAffiliationDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getAccountCode() != null) sb.append(__wrapString(count++, "accountCode", getAccountCode()));
		if(getRunningAccount() != null) sb.append(__wrapString(count++, "runningAccount", getRunningAccount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("accountName")) != null) setAccountName(__getString(val));
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
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("affiliationDate")) != null) setAffiliationDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("accountCode")) != null) setAccountCode(__getString(val));
		if((val = values.get("runningAccount")) != null) setRunningAccount(__getString(val));
	}

	protected java.lang.String  __account_name ;
	protected java.lang.Integer  __account_transaction_id ;
	protected java.lang.Integer  __account_id ;
	protected java.math.BigDecimal  __original_currency_debit ;
	protected java.math.BigDecimal  __original_currency_loan ;
	protected java.math.BigDecimal  __exchange_rate ;
	protected java.math.BigDecimal  __standard_money_debit ;
	protected java.math.BigDecimal  __standard_money_loan ;
	protected java.lang.Integer  __item_category ;
	protected java.lang.String  __main_project_code ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __record_date ;
	protected java.util.Date  __affiliation_date ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __account_code ;
	protected java.lang.String  __running_account ;
}
