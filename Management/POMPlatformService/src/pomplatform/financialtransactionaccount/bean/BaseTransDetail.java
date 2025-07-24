package pomplatform.financialtransactionaccount.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;

public class BaseTransDetail extends GenericBase implements BaseFactory<BaseTransDetail>, Comparable<BaseTransDetail> 
{


	public static BaseTransDetail newInstance(){
		return new BaseTransDetail();
	}

	@Override
	public BaseTransDetail make(){
		BaseTransDetail b = new BaseTransDetail();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_TRANSACTION_ACCOUNT_ID = "financial_transaction_account_id" ;
	public final static java.lang.String CS_ACCOUNT_TYPE = "account_type" ;
	public final static java.lang.String CS_FINANCE_NO = "finance_no" ;
	public final static java.lang.String CS_ACCOUNT_NAME = "account_name" ;
	public final static java.lang.String CS_IS_HUMAN_ADD = "is_human_add" ;
	public final static java.lang.String CS_ACCOUNT_STATUS = "account_status" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_SUMMARY = "summary" ;
	public final static java.lang.String CS_ORDER_NO = "order_no" ;
	public final static java.lang.String CS_STANDARD_DEBIT = "standard_debit" ;
	public final static java.lang.String CS_STANDARD_CREDIT = "standard_credit" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,账户类型,财务编号,名称,是否人为添加,账户状态,日期,摘要,,本币借,本币贷,流程是否已完成,归属公司";

	public java.lang.Integer getFinancialTransactionAccountId() {
		return this.__financial_transaction_account_id;
	}

	public void setFinancialTransactionAccountId( java.lang.Integer value ) {
		this.__financial_transaction_account_id = value;
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

	public java.lang.Boolean getIsHumanAdd() {
		return this.__is_human_add;
	}

	public void setIsHumanAdd( java.lang.Boolean value ) {
		this.__is_human_add = value;
	}

	public java.lang.Integer getAccountStatus() {
		return this.__account_status;
	}

	public void setAccountStatus( java.lang.Integer value ) {
		this.__account_status = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.String getSummary() {
		return this.__summary;
	}

	public void setSummary( java.lang.String value ) {
		this.__summary = value;
	}

	public java.lang.Integer getOrderNo() {
		return this.__order_no;
	}

	public void setOrderNo( java.lang.Integer value ) {
		this.__order_no = value;
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

	public java.lang.Boolean getIsCompleted() {
		return __is_completed;
	}

	public void setIsCompleted(java.lang.Boolean __is_completed) {
		this.__is_completed = __is_completed;
	}

	public java.lang.Integer getFinancialTransactionDetailId() {
		return __financial_transaction_detail_id;
	}

	public void setFinancialTransactionDetailId(java.lang.Integer __financial_transaction_detail_id) {
		this.__financial_transaction_detail_id = __financial_transaction_detail_id;
	}
	
	public java.lang.Integer getCompanyId() {
		return __company_id;
	}

	public void setCompanyId(java.lang.Integer value) {
		this.__company_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return __process_instance_id;
	}

	public void setProcessInstanceId(java.lang.Integer value) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getProcessType() {
		return __process_type;
	}

	public void setProcessType(java.lang.Integer value) {
		this.__process_type = value;
	}

	public java.lang.Integer getProcessId() {
		return __process_id;
	}

	public void setProcessId(java.lang.Integer value) {
		this.__process_id = value;
	}

	public void cloneCopy(BaseTransDetail __bean){
		__bean.setFinancialTransactionAccountId(getFinancialTransactionAccountId());
		__bean.setAccountType(getAccountType());
		__bean.setFinanceNo(getFinanceNo());
		__bean.setAccountName(getAccountName());
		__bean.setIsHumanAdd(getIsHumanAdd());
		__bean.setAccountStatus(getAccountStatus());
		__bean.setRecordDate(getRecordDate());
		__bean.setSummary(getSummary());
		__bean.setOrderNo(getOrderNo());
		__bean.setStandardDebit(getStandardDebit());
		__bean.setStandardCredit(getStandardCredit());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setFinancialTransactionDetailId(getFinancialTransactionDetailId());
		__bean.setCompanyId(getCompanyId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessType(getProcessType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialTransactionAccountId() == null ? "" : getFinancialTransactionAccountId());
		sb.append(",");
		String strAccountType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_230", String.valueOf(getAccountType()));
		sb.append(strAccountType == null ? "" : strAccountType);
		sb.append(",");
		sb.append(getFinanceNo() == null ? "" : getFinanceNo());
		sb.append(",");
		sb.append(getAccountName() == null ? "" : getAccountName());
		sb.append(",");
		sb.append(getIsHumanAdd() == null ? "" : getIsHumanAdd());
		sb.append(",");
		String strAccountStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_217", String.valueOf(getAccountStatus()));
		sb.append(strAccountStatus == null ? "" : strAccountStatus);
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getSummary() == null ? "" : getSummary());
		sb.append(",");
		sb.append(getOrderNo() == null ? "" : getOrderNo());
		sb.append(",");
		sb.append(getStandardDebit() == null ? "" : getStandardDebit());
		sb.append(",");
		sb.append(getStandardCredit() == null ? "" : getStandardCredit());
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		String companyStr = SelectValueCache.getSelectValue("company_records", String.valueOf(getCompanyId()));
		sb.append(companyStr == null ? "" : companyStr);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTransDetail o) {
		return __financial_transaction_account_id == null ? -1 : __financial_transaction_account_id.compareTo(o.getFinancialTransactionAccountId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_account_id);
		hash = 97 * hash + Objects.hashCode(this.__account_type);
		hash = 97 * hash + Objects.hashCode(this.__finance_no);
		hash = 97 * hash + Objects.hashCode(this.__account_name);
		hash = 97 * hash + Objects.hashCode(this.__is_human_add);
		hash = 97 * hash + Objects.hashCode(this.__account_status);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__summary);
		hash = 97 * hash + Objects.hashCode(this.__order_no);
		hash = 97 * hash + Objects.hashCode(this.__standard_debit);
		hash = 97 * hash + Objects.hashCode(this.__standard_credit);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTransDetail o = (BaseTransDetail)obj;
		if(!Objects.equals(this.__financial_transaction_account_id, o.getFinancialTransactionAccountId())) return false;
		if(!Objects.equals(this.__account_type, o.getAccountType())) return false;
		if(!Objects.equals(this.__finance_no, o.getFinanceNo())) return false;
		if(!Objects.equals(this.__account_name, o.getAccountName())) return false;
		if(!Objects.equals(this.__is_human_add, o.getIsHumanAdd())) return false;
		if(!Objects.equals(this.__account_status, o.getAccountStatus())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__summary, o.getSummary())) return false;
		if(!Objects.equals(this.__order_no, o.getOrderNo())) return false;
		if(!Objects.equals(this.__standard_debit, o.getStandardDebit())) return false;
		if(!Objects.equals(this.__standard_credit, o.getStandardCredit())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__financial_transaction_detail_id, o.getFinancialTransactionDetailId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialTransactionAccountId() != null) sb.append(__wrapNumber(count++, "financialTransactionAccountId", getFinancialTransactionAccountId()));
		if(getAccountType() != null) sb.append(__wrapNumber(count++, "accountType", getAccountType()));
		if(getFinanceNo() != null) sb.append(__wrapString(count++, "financeNo", getFinanceNo()));
		if(getAccountName() != null) sb.append(__wrapString(count++, "accountName", getAccountName()));
		if(getIsHumanAdd() != null) sb.append(__wrapBoolean(count++, "isHumanAdd", getIsHumanAdd()));
		if(getAccountStatus() != null) sb.append(__wrapNumber(count++, "accountStatus", getAccountStatus()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getSummary() != null) sb.append(__wrapString(count++, "summary", getSummary()));
		if(getOrderNo() != null) sb.append(__wrapNumber(count++, "orderNo", getOrderNo()));
		if(getStandardDebit() != null) sb.append(__wrapDecimal(count++, "standardDebit", getStandardDebit()));
		if(getStandardCredit() != null) sb.append(__wrapDecimal(count++, "standardCredit", getStandardCredit()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getFinancialTransactionDetailId() != null) sb.append(__wrapNumber(count++, "financialTransactionDetailId", getFinancialTransactionDetailId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialTransactionAccountId() != null) res.put("financialTransactionAccountId", getFinancialTransactionAccountId());
		if(getAccountType() != null) res.put("accountType", getAccountType());
		if(getFinanceNo() != null) res.put("financeNo", getFinanceNo());
		if(getAccountName() != null) res.put("accountName", getAccountName());
		if(getIsHumanAdd() != null) res.put("isHumanAdd", getIsHumanAdd());
		if(getAccountStatus() != null) res.put("accountStatus", getAccountStatus());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getSummary() != null) res.put("summary", getSummary());
		if(getOrderNo() != null) res.put("orderNo", getOrderNo());
		if(getStandardDebit() != null) res.put("standardDebit", getStandardDebit());
		if(getStandardCredit() != null) res.put("standardCredit", getStandardCredit());
		if(getIsCompleted() != null) res.put("isCompleted", getIsCompleted());
		if(getFinancialTransactionDetailId() != null) res.put("financialTransactionDetailId", getFinancialTransactionDetailId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialTransactionAccountId")) != null) setFinancialTransactionAccountId(__getInt(val)); 
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("financeNo")) != null) setFinanceNo(__getString(val));
		if((val = values.get("accountName")) != null) setAccountName(__getString(val));
		if((val = values.get("isHumanAdd")) != null) setIsHumanAdd(__getBoolean(val));
		if((val = values.get("accountStatus")) != null) setAccountStatus(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("summary")) != null) setSummary(__getString(val));
		if((val = values.get("orderNo")) != null) setOrderNo(__getInt(val)); 
		if((val = values.get("standardDebit")) != null) setStandardDebit(__getDecimal(val));  
		if((val = values.get("standardCredit")) != null) setStandardCredit(__getDecimal(val));  
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("financialTransactionDetailId")) != null) setFinancialTransactionDetailId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val));
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val));
		if((val = values.get("processType")) != null) setProcessType(__getInt(val));
	}

	protected java.lang.Integer  __financial_transaction_account_id ;
	protected java.lang.Integer  __financial_transaction_detail_id ;
	protected java.lang.Integer  __account_type ;
	protected java.lang.String  __finance_no ;
	protected java.lang.String  __account_name ;
	protected java.lang.Boolean  __is_human_add ;
	protected java.lang.Integer  __account_status ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __summary ;
	protected java.lang.Integer  __order_no ;
	protected java.math.BigDecimal  __standard_debit ;
	protected java.math.BigDecimal  __standard_credit ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __process_id ;
}
