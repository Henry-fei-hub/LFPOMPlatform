package pomplatform.financialtransactionaccount.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionTransDetail extends GenericCondition{

	public ConditionTransDetail(){
		setParameterCount(11);
	}

	public java.lang.Integer getAccountType() {
		return this.__account_type;
	}

	public void setAccountType( java.lang.Integer value ) {
		this.__account_type = value;
	}

	public java.lang.String getFinanceNo() {
		return this.__finance_no == null ? null : (this.__finance_no.indexOf("%") >= 0 ? this.__finance_no : "%"+this.__finance_no+"%");
	}

	public void setFinanceNo( java.lang.String value ) {
		this.__finance_no = value;
	}

	public java.lang.String getAccountName() {
		return this.__account_name == null ? null : (this.__account_name.indexOf("%") >= 0 ? this.__account_name : "%"+this.__account_name+"%");
	}

	public void setAccountName( java.lang.String value ) {
		this.__account_name = value;
	}

	public java.lang.Integer getAccountStatus() {
		return this.__account_status;
	}

	public void setAccountStatus( java.lang.Integer value ) {
		this.__account_status = value;
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return this.__financial_transaction_account_id;
	}

	public void setFinancialTransactionAccountId( java.lang.Integer value ) {
		this.__financial_transaction_account_id = value;
	}

	public java.lang.Integer getInitDeleteFlag() {
		return this.__init_delete_flag;
	}

	public void setInitDeleteFlag( java.lang.Integer value ) {
		this.__init_delete_flag = value;
	}

	public java.util.Date getInitEndDate() {
		return this.__init_end_date;
	}

	public void setInitEndDate( java.util.Date value ) {
		this.__init_end_date = value;
	}

	public java.lang.Integer getDetailDeleteFlag() {
		return this.__detail_delete_flag;
	}

	public void setDetailDeleteFlag( java.lang.Integer value ) {
		this.__detail_delete_flag = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}
	
	public java.lang.Integer getCompanyId() {
		return __company_id;
	}

	public void setCompanyId(java.lang.Integer value) {
		this.__company_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAccountType() != null) sb.append(__wrapNumber(1, "accountType", getAccountType()));
		if(getFinanceNo() != null) sb.append(__wrapString(1, "financeNo", getFinanceNo()));
		if(getAccountName() != null) sb.append(__wrapString(1, "accountName", getAccountName()));
		if(getAccountStatus() != null) sb.append(__wrapNumber(1, "accountStatus", getAccountStatus()));
		if(getFinancialTransactionAccountId() != null) sb.append(__wrapNumber(1, "financialTransactionAccountId", getFinancialTransactionAccountId()));
		if(getInitDeleteFlag() != null) sb.append(__wrapNumber(1, "initDeleteFlag", getInitDeleteFlag()));
		if(getInitEndDate() != null) sb.append(__wrapDate(1, "initEndDate", getInitEndDate()));
		if(getDetailDeleteFlag() != null) sb.append(__wrapNumber(1, "detailDeleteFlag", getDetailDeleteFlag()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("financeNo")) != null) setFinanceNo(__getString(val));
		if((val = values.get("accountName")) != null) setAccountName(__getString(val));
		if((val = values.get("accountStatus")) != null) setAccountStatus(__getInt(val)); 
		if((val = values.get("financialTransactionAccountId")) != null) setFinancialTransactionAccountId(__getInt(val)); 
		if((val = values.get("initDeleteFlag")) != null) setInitDeleteFlag(__getInt(val)); 
		if((val = values.get("initEndDate")) != null) setInitEndDate(__getDate(val)); 
		if((val = values.get("detailDeleteFlag")) != null) setDetailDeleteFlag(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val));
	}

	private java.lang.Integer __account_type = null;
	private java.lang.String __finance_no = null;
	private java.lang.String __account_name = null;
	private java.lang.Integer __account_status = null;
	private java.lang.Integer __financial_transaction_account_id = null;
	private java.lang.Integer __init_delete_flag = null;
	private java.util.Date __init_end_date = null;
	private java.lang.Integer __detail_delete_flag = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer  __company_id ;
}

