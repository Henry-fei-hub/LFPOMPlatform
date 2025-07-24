package pomplatform.financialtransactionaccount.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;

public class BaseHandingTransDetailSummary extends GenericBase implements BaseFactory<BaseHandingTransDetailSummary>, Comparable<BaseHandingTransDetailSummary> 
{


	public static BaseHandingTransDetailSummary newInstance(){
		return new BaseHandingTransDetailSummary();
	}

	@Override
	public BaseHandingTransDetailSummary make(){
		BaseHandingTransDetailSummary b = new BaseHandingTransDetailSummary();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_TRANSACTION_ACCOUNT_ID = "financial_transaction_account_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_ACCOUNT_TYPE = "account_type" ;
	public final static java.lang.String CS_FINANCE_NO = "finance_no" ;
	public final static java.lang.String CS_ACCOUNT_NAME = "account_name" ;
	public final static java.lang.String CS_REIMBURSABLE = "reimbursable" ;
	public final static java.lang.String CS_ACCOUNT_STATUS = "account_status" ;
	public final static java.lang.String CS_INIT_STANDARD_DEBIT = "init_standard_debit" ;
	public final static java.lang.String CS_INIT_STANDARD_CREDIT = "init_standard_credit" ;
	public final static java.lang.String CS_STANDARD_DEBIT = "standard_debit" ;
	public final static java.lang.String CS_STANDARD_CREDIT = "standard_credit" ;
	public final static java.lang.String CS_END_STANDARD_DEBIT = "end_standard_debit" ;
	public final static java.lang.String CS_END_STANDARD_CREDIT = "end_standard_credit" ;
	
	public final static java.lang.String ALL_CAPTIONS = "归属公司,账户类型,财务编号,名称,账户状态,能否报销,期初借,期初贷,借方发生额,贷方发生额,期末借,期末贷";

	public java.lang.Integer getFinancialTransactionAccountId() {
		return this.__financial_transaction_account_id;
	}

	public void setFinancialTransactionAccountId( java.lang.Integer value ) {
		this.__financial_transaction_account_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return __company_id;
	}

	public void setCompanyId(java.lang.Integer value) {
		this.__company_id = value;
	}
	
	public java.lang.Integer getAccountType() {
		return this.__account_type;
	}

	public void setAccountType( java.lang.Integer value ) {
		this.__account_type = value;
	}

	public java.lang.String getFinanceNo() {
		return this.__finance_no;
	}

	public void setFinanceNo( java.lang.String value ) {
		this.__finance_no = value;
	}

	public java.lang.String getAccountName() {
		return this.__account_name;
	}

	public void setAccountName( java.lang.String value ) {
		this.__account_name = value;
	}

	public java.lang.Boolean getReimbursable() {
		return this.__reimbursable;
	}

	public void setReimbursable( java.lang.Boolean value ) {
		this.__reimbursable = value;
	}

	public java.lang.Integer getAccountStatus() {
		return this.__account_status;
	}

	public void setAccountStatus( java.lang.Integer value ) {
		this.__account_status = value;
	}

	public java.math.BigDecimal getInitStandardDebit() {
		return this.__init_standard_debit;
	}

	public void setInitStandardDebit( java.math.BigDecimal value ) {
		this.__init_standard_debit = value;
	}

	public java.math.BigDecimal getInitStandardCredit() {
		return this.__init_standard_credit;
	}

	public void setInitStandardCredit( java.math.BigDecimal value ) {
		this.__init_standard_credit = value;
	}

	public java.math.BigDecimal getStandardDebit() {
		return this.__standard_debit;
	}

	public void setStandardDebit( java.math.BigDecimal value ) {
		this.__standard_debit = value;
	}

	public java.math.BigDecimal getStandardCredit() {
		return this.__standard_credit;
	}

	public void setStandardCredit( java.math.BigDecimal value ) {
		this.__standard_credit = value;
	}

	public java.math.BigDecimal getEndStandardDebit() {
		return this.__end_standard_debit;
	}

	public void setEndStandardDebit( java.math.BigDecimal value ) {
		this.__end_standard_debit = value;
	}

	public java.math.BigDecimal getEndStandardCredit() {
		return this.__end_standard_credit;
	}

	public void setEndStandardCredit( java.math.BigDecimal value ) {
		this.__end_standard_credit = value;
	}

	public void cloneCopy(BaseHandingTransDetailSummary __bean){
		__bean.setFinancialTransactionAccountId(getFinancialTransactionAccountId());
		__bean.setCompanyId(getCompanyId());
		__bean.setAccountType(getAccountType());
		__bean.setFinanceNo(getFinanceNo());
		__bean.setAccountName(getAccountName());
		__bean.setReimbursable(getReimbursable());
		__bean.setAccountStatus(getAccountStatus());
		__bean.setInitStandardDebit(getInitStandardDebit());
		__bean.setInitStandardCredit(getInitStandardCredit());
		__bean.setStandardDebit(getStandardDebit());
		__bean.setStandardCredit(getStandardCredit());
		__bean.setEndStandardDebit(getEndStandardDebit());
		__bean.setEndStandardCredit(getEndStandardCredit());
	}

	public java.lang.String toCSVString() {
		StringBuilder sb = new StringBuilder();
		String companyStr = SelectValueCache.getSelectValue("company_records", String.valueOf(getCompanyId()));
		sb.append(companyStr == null ? "" : companyStr);
		sb.append(",");
		String strAccountType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_230", String.valueOf(getAccountType()));
		sb.append(strAccountType == null ? "" : strAccountType);
		sb.append(",");
		sb.append(getFinanceNo() == null ? "" : getFinanceNo());
		sb.append(",");
		sb.append(getAccountName() == null ? "" : getAccountName());
		sb.append(",");
		String strAccountStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_217", String.valueOf(getAccountStatus()));
		sb.append(strAccountStatus == null ? "" : strAccountStatus);
		sb.append(",");
		sb.append(getReimbursable() == null ? "" : getReimbursable());
		sb.append(",");
		sb.append(getInitStandardDebit() == null ? "" : getInitStandardDebit());
		sb.append(",");
		sb.append(getInitStandardCredit() == null ? "" : getInitStandardCredit());
		sb.append(",");
		sb.append(getStandardDebit() == null ? "" : getStandardDebit());
		sb.append(",");
		sb.append(getStandardCredit() == null ? "" : getStandardCredit());
		sb.append(",");
		sb.append(getEndStandardDebit() == null ? "" : getEndStandardDebit());
		sb.append(",");
		sb.append(getEndStandardCredit() == null ? "" : getEndStandardCredit());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseHandingTransDetailSummary o) {
		return __financial_transaction_account_id == null ? -1 : __financial_transaction_account_id.compareTo(o.getFinancialTransactionAccountId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_account_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__account_type);
		hash = 97 * hash + Objects.hashCode(this.__finance_no);
		hash = 97 * hash + Objects.hashCode(this.__account_name);
		hash = 97 * hash + Objects.hashCode(this.__reimbursable);
		hash = 97 * hash + Objects.hashCode(this.__account_status);
		hash = 97 * hash + Objects.hashCode(this.__init_standard_debit);
		hash = 97 * hash + Objects.hashCode(this.__init_standard_credit);
		hash = 97 * hash + Objects.hashCode(this.__standard_debit);
		hash = 97 * hash + Objects.hashCode(this.__standard_credit);
		hash = 97 * hash + Objects.hashCode(this.__end_standard_debit);
		hash = 97 * hash + Objects.hashCode(this.__end_standard_credit);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseHandingTransDetailSummary o = (BaseHandingTransDetailSummary)obj;
		if(!Objects.equals(this.__financial_transaction_account_id, o.getFinancialTransactionAccountId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__account_type, o.getAccountType())) return false;
		if(!Objects.equals(this.__finance_no, o.getFinanceNo())) return false;
		if(!Objects.equals(this.__account_name, o.getAccountName())) return false;
		if(!Objects.equals(this.__reimbursable, o.getReimbursable())) return false;
		if(!Objects.equals(this.__account_status, o.getAccountStatus())) return false;
		if(!Objects.equals(this.__init_standard_debit, o.getInitStandardDebit())) return false;
		if(!Objects.equals(this.__init_standard_credit, o.getInitStandardCredit())) return false;
		if(!Objects.equals(this.__standard_debit, o.getStandardDebit())) return false;
		if(!Objects.equals(this.__standard_credit, o.getStandardCredit())) return false;
		if(!Objects.equals(this.__end_standard_debit, o.getEndStandardDebit())) return false;
		if(!Objects.equals(this.__end_standard_credit, o.getEndStandardCredit())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialTransactionAccountId() != null) sb.append(__wrapNumber(count++, "financialTransactionAccountId", getFinancialTransactionAccountId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getAccountType() != null) sb.append(__wrapNumber(count++, "accountType", getAccountType()));
		if(getFinanceNo() != null) sb.append(__wrapString(count++, "financeNo", getFinanceNo()));
		if(getAccountName() != null) sb.append(__wrapString(count++, "accountName", getAccountName()));
		if(getReimbursable() != null) sb.append(__wrapBoolean(count++, "reimbursable", getReimbursable()));
		if(getAccountStatus() != null) sb.append(__wrapNumber(count++, "accountStatus", getAccountStatus()));
		if(getInitStandardDebit() != null) sb.append(__wrapDecimal(count++, "initStandardDebit", getInitStandardDebit()));
		if(getInitStandardCredit() != null) sb.append(__wrapDecimal(count++, "initStandardCredit", getInitStandardCredit()));
		if(getStandardDebit() != null) sb.append(__wrapDecimal(count++, "standardDebit", getStandardDebit()));
		if(getStandardCredit() != null) sb.append(__wrapDecimal(count++, "standardCredit", getStandardCredit()));
		if(getEndStandardDebit() != null) sb.append(__wrapDecimal(count++, "endStandardDebit", getEndStandardDebit()));
		if(getEndStandardCredit() != null) sb.append(__wrapDecimal(count++, "endStandardCredit", getEndStandardCredit()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialTransactionAccountId() != null) res.put("financialTransactionAccountId", getFinancialTransactionAccountId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getAccountType() != null) res.put("accountType", getAccountType());
		if(getFinanceNo() != null) res.put("financeNo", getFinanceNo());
		if(getAccountName() != null) res.put("accountName", getAccountName());
		if(getReimbursable() != null) res.put("reimbursable", getReimbursable());
		if(getAccountStatus() != null) res.put("accountStatus", getAccountStatus());
		if(getInitStandardDebit() != null) res.put("initStandardDebit", getInitStandardDebit());
		if(getInitStandardCredit() != null) res.put("initStandardCredit", getInitStandardCredit());
		if(getStandardDebit() != null) res.put("standardDebit", getStandardDebit());
		if(getStandardCredit() != null) res.put("standardCredit", getStandardCredit());
		if(getEndStandardDebit() != null) res.put("endStandardDebit", getEndStandardDebit());
		if(getEndStandardCredit() != null) res.put("endStandardCredit", getEndStandardCredit());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialTransactionAccountId")) != null) setFinancialTransactionAccountId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val));
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("financeNo")) != null) setFinanceNo(__getString(val));
		if((val = values.get("accountName")) != null) setAccountName(__getString(val));
		if((val = values.get("reimbursable")) != null) setReimbursable(__getBoolean(val));
		if((val = values.get("accountStatus")) != null) setAccountStatus(__getInt(val)); 
		if((val = values.get("initStandardDebit")) != null) setInitStandardDebit(__getDecimal(val));  
		if((val = values.get("initStandardCredit")) != null) setInitStandardCredit(__getDecimal(val));  
		if((val = values.get("standardDebit")) != null) setStandardDebit(__getDecimal(val));  
		if((val = values.get("standardCredit")) != null) setStandardCredit(__getDecimal(val));  
		if((val = values.get("endStandardDebit")) != null) setEndStandardDebit(__getDecimal(val));  
		if((val = values.get("endStandardCredit")) != null) setEndStandardCredit(__getDecimal(val));  
	}

	protected java.lang.Integer  __financial_transaction_account_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __account_type ;
	protected java.lang.String  __finance_no ;
	protected java.lang.String  __account_name ;
	protected java.lang.Boolean  __reimbursable ;
	protected java.lang.Integer  __account_status ;
	protected java.math.BigDecimal  __init_standard_debit ;
	protected java.math.BigDecimal  __init_standard_credit ;
	protected java.math.BigDecimal  __standard_debit ;
	protected java.math.BigDecimal  __standard_credit ;
	protected java.math.BigDecimal  __end_standard_debit ;
	protected java.math.BigDecimal  __end_standard_credit ;
}
