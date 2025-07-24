package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialTransactionDetail extends GenericBase implements BaseFactory<BaseFinancialTransactionDetail>, Comparable<BaseFinancialTransactionDetail> 
{


	public static BaseFinancialTransactionDetail newInstance(){
		return new BaseFinancialTransactionDetail();
	}

	@Override
	public BaseFinancialTransactionDetail make(){
		BaseFinancialTransactionDetail b = new BaseFinancialTransactionDetail();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_TRANSACTION_DETAIL_ID = "financial_transaction_detail_id" ;
	public final static java.lang.String CS_FINANCIAL_TRANSACTION_ACCOUNT_ID = "financial_transaction_account_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_SUMMARY = "summary" ;
	public final static java.lang.String CS_CURRENCY_TYPE = "currency_type" ;
	public final static java.lang.String CS_ORIGINAL_DEBIT = "original_debit" ;
	public final static java.lang.String CS_ORIGINAL_CREDIT = "original_credit" ;
	public final static java.lang.String CS_EXCHANGE_RATE = "exchange_rate" ;
	public final static java.lang.String CS_STANDARD_DEBIT = "standard_debit" ;
	public final static java.lang.String CS_STANDARD_CREDIT = "standard_credit" ;
	public final static java.lang.String CS_OPERATOR_ACCOUNT_ID = "operator_account_id" ;
	public final static java.lang.String CS_IS_LOCKED = "is_locked" ;
	public final static java.lang.String CS_IS_HUMAN_ADD = "is_human_add" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_BILL_LIST_ID = "process_bill_list_id" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,财务往来账户,日期,摘要,货币种类 system_dictionary_40,原币借,原币贷,汇率,本币借,本币贷,经办人,是否锁定,是否人为添加,流程类型,流程业务数据编码,流程实例编码,报销收款信息编码,是否完成,创建时间, 1已删除,归属公司";

	public java.lang.Integer getFinancialTransactionDetailId() {
		return this.__financial_transaction_detail_id;
	}

	public void setFinancialTransactionDetailId( java.lang.Integer value ) {
		this.__financial_transaction_detail_id = value;
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return this.__financial_transaction_account_id;
	}

	public void setFinancialTransactionAccountId( java.lang.Integer value ) {
		this.__financial_transaction_account_id = value;
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

	public java.lang.Integer getCurrencyType() {
		return this.__currency_type;
	}

	public void setCurrencyType( java.lang.Integer value ) {
		this.__currency_type = value;
	}

	public java.math.BigDecimal getOriginalDebit() {
		return this.__original_debit;
	}

	public void setOriginalDebit( java.math.BigDecimal value ) {
		this.__original_debit = value;
	}

	public java.math.BigDecimal getOriginalCredit() {
		return this.__original_credit;
	}

	public void setOriginalCredit( java.math.BigDecimal value ) {
		this.__original_credit = value;
	}

	public java.math.BigDecimal getExchangeRate() {
		return this.__exchange_rate;
	}

	public void setExchangeRate( java.math.BigDecimal value ) {
		this.__exchange_rate = value;
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

	public java.lang.Integer getOperatorAccountId() {
		return this.__operator_account_id;
	}

	public void setOperatorAccountId( java.lang.Integer value ) {
		this.__operator_account_id = value;
	}

	public java.lang.Boolean getIsLocked() {
		return this.__is_locked;
	}

	public void setIsLocked( java.lang.Boolean value ) {
		this.__is_locked = value;
	}

	public java.lang.Boolean getIsHumanAdd() {
		return this.__is_human_add;
	}

	public void setIsHumanAdd( java.lang.Boolean value ) {
		this.__is_human_add = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getProcessBillListId() {
		return this.__process_bill_list_id;
	}

	public void setProcessBillListId( java.lang.Integer value ) {
		this.__process_bill_list_id = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public void cloneCopy(BaseFinancialTransactionDetail __bean){
		__bean.setFinancialTransactionDetailId(getFinancialTransactionDetailId());
		__bean.setFinancialTransactionAccountId(getFinancialTransactionAccountId());
		__bean.setRecordDate(getRecordDate());
		__bean.setSummary(getSummary());
		__bean.setCurrencyType(getCurrencyType());
		__bean.setOriginalDebit(getOriginalDebit());
		__bean.setOriginalCredit(getOriginalCredit());
		__bean.setExchangeRate(getExchangeRate());
		__bean.setStandardDebit(getStandardDebit());
		__bean.setStandardCredit(getStandardCredit());
		__bean.setOperatorAccountId(getOperatorAccountId());
		__bean.setIsLocked(getIsLocked());
		__bean.setIsHumanAdd(getIsHumanAdd());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessBillListId(getProcessBillListId());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialTransactionDetailId() == null ? "" : getFinancialTransactionDetailId());
		sb.append(",");
		sb.append(getFinancialTransactionAccountId() == null ? "" : getFinancialTransactionAccountId());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getSummary() == null ? "" : getSummary());
		sb.append(",");
		sb.append(getCurrencyType() == null ? "" : getCurrencyType());
		sb.append(",");
		sb.append(getOriginalDebit() == null ? "" : getOriginalDebit());
		sb.append(",");
		sb.append(getOriginalCredit() == null ? "" : getOriginalCredit());
		sb.append(",");
		sb.append(getExchangeRate() == null ? "" : getExchangeRate());
		sb.append(",");
		sb.append(getStandardDebit() == null ? "" : getStandardDebit());
		sb.append(",");
		sb.append(getStandardCredit() == null ? "" : getStandardCredit());
		sb.append(",");
		sb.append(getOperatorAccountId() == null ? "" : getOperatorAccountId());
		sb.append(",");
		sb.append(getIsLocked() == null ? "" : getIsLocked());
		sb.append(",");
		sb.append(getIsHumanAdd() == null ? "" : getIsHumanAdd());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getProcessBillListId() == null ? "" : getProcessBillListId());
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialTransactionDetail o) {
		return __financial_transaction_detail_id == null ? -1 : __financial_transaction_detail_id.compareTo(o.getFinancialTransactionDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_account_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__summary);
		hash = 97 * hash + Objects.hashCode(this.__currency_type);
		hash = 97 * hash + Objects.hashCode(this.__original_debit);
		hash = 97 * hash + Objects.hashCode(this.__original_credit);
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate);
		hash = 97 * hash + Objects.hashCode(this.__standard_debit);
		hash = 97 * hash + Objects.hashCode(this.__standard_credit);
		hash = 97 * hash + Objects.hashCode(this.__operator_account_id);
		hash = 97 * hash + Objects.hashCode(this.__is_locked);
		hash = 97 * hash + Objects.hashCode(this.__is_human_add);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_bill_list_id);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialTransactionDetail o = (BaseFinancialTransactionDetail)obj;
		if(!Objects.equals(this.__financial_transaction_detail_id, o.getFinancialTransactionDetailId())) return false;
		if(!Objects.equals(this.__financial_transaction_account_id, o.getFinancialTransactionAccountId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__summary, o.getSummary())) return false;
		if(!Objects.equals(this.__currency_type, o.getCurrencyType())) return false;
		if(!Objects.equals(this.__original_debit, o.getOriginalDebit())) return false;
		if(!Objects.equals(this.__original_credit, o.getOriginalCredit())) return false;
		if(!Objects.equals(this.__exchange_rate, o.getExchangeRate())) return false;
		if(!Objects.equals(this.__standard_debit, o.getStandardDebit())) return false;
		if(!Objects.equals(this.__standard_credit, o.getStandardCredit())) return false;
		if(!Objects.equals(this.__operator_account_id, o.getOperatorAccountId())) return false;
		if(!Objects.equals(this.__is_locked, o.getIsLocked())) return false;
		if(!Objects.equals(this.__is_human_add, o.getIsHumanAdd())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_bill_list_id, o.getProcessBillListId())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialTransactionDetailId() != null) sb.append(__wrapNumber(count++, "financialTransactionDetailId", getFinancialTransactionDetailId()));
		if(getFinancialTransactionAccountId() != null) sb.append(__wrapNumber(count++, "financialTransactionAccountId", getFinancialTransactionAccountId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getSummary() != null) sb.append(__wrapString(count++, "summary", getSummary()));
		if(getCurrencyType() != null) sb.append(__wrapNumber(count++, "currencyType", getCurrencyType()));
		if(getOriginalDebit() != null) sb.append(__wrapDecimal(count++, "originalDebit", getOriginalDebit()));
		if(getOriginalCredit() != null) sb.append(__wrapDecimal(count++, "originalCredit", getOriginalCredit()));
		if(getExchangeRate() != null) sb.append(__wrapDecimal(count++, "exchangeRate", getExchangeRate()));
		if(getStandardDebit() != null) sb.append(__wrapDecimal(count++, "standardDebit", getStandardDebit()));
		if(getStandardCredit() != null) sb.append(__wrapDecimal(count++, "standardCredit", getStandardCredit()));
		if(getOperatorAccountId() != null) sb.append(__wrapNumber(count++, "operatorAccountId", getOperatorAccountId()));
		if(getIsLocked() != null) sb.append(__wrapBoolean(count++, "isLocked", getIsLocked()));
		if(getIsHumanAdd() != null) sb.append(__wrapBoolean(count++, "isHumanAdd", getIsHumanAdd()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessBillListId() != null) sb.append(__wrapNumber(count++, "processBillListId", getProcessBillListId()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialTransactionDetailId() != null) res.put("financialTransactionDetailId", getFinancialTransactionDetailId());
		if(getFinancialTransactionAccountId() != null) res.put("financialTransactionAccountId", getFinancialTransactionAccountId());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getSummary() != null) res.put("summary", getSummary());
		if(getCurrencyType() != null) res.put("currencyType", getCurrencyType());
		if(getOriginalDebit() != null) res.put("originalDebit", getOriginalDebit());
		if(getOriginalCredit() != null) res.put("originalCredit", getOriginalCredit());
		if(getExchangeRate() != null) res.put("exchangeRate", getExchangeRate());
		if(getStandardDebit() != null) res.put("standardDebit", getStandardDebit());
		if(getStandardCredit() != null) res.put("standardCredit", getStandardCredit());
		if(getOperatorAccountId() != null) res.put("operatorAccountId", getOperatorAccountId());
		if(getIsLocked() != null) res.put("isLocked", getIsLocked());
		if(getIsHumanAdd() != null) res.put("isHumanAdd", getIsHumanAdd());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProcessBillListId() != null) res.put("processBillListId", getProcessBillListId());
		if(getIsCompleted() != null) res.put("isCompleted", getIsCompleted());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialTransactionDetailId")) != null) setFinancialTransactionDetailId(__getInt(val)); 
		if((val = values.get("financialTransactionAccountId")) != null) setFinancialTransactionAccountId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("summary")) != null) setSummary(__getString(val));
		if((val = values.get("currencyType")) != null) setCurrencyType(__getInt(val)); 
		if((val = values.get("originalDebit")) != null) setOriginalDebit(__getDecimal(val));  
		if((val = values.get("originalCredit")) != null) setOriginalCredit(__getDecimal(val));  
		if((val = values.get("exchangeRate")) != null) setExchangeRate(__getDecimal(val));  
		if((val = values.get("standardDebit")) != null) setStandardDebit(__getDecimal(val));  
		if((val = values.get("standardCredit")) != null) setStandardCredit(__getDecimal(val));  
		if((val = values.get("operatorAccountId")) != null) setOperatorAccountId(__getInt(val)); 
		if((val = values.get("isLocked")) != null) setIsLocked(__getBoolean(val));
		if((val = values.get("isHumanAdd")) != null) setIsHumanAdd(__getBoolean(val));
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processBillListId")) != null) setProcessBillListId(__getInt(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	protected java.lang.Integer  __financial_transaction_detail_id ;
	protected java.lang.Integer  __financial_transaction_account_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __summary ;
	protected java.lang.Integer  __currency_type ;
	protected java.math.BigDecimal  __original_debit ;
	protected java.math.BigDecimal  __original_credit ;
	protected java.math.BigDecimal  __exchange_rate ;
	protected java.math.BigDecimal  __standard_debit ;
	protected java.math.BigDecimal  __standard_credit ;
	protected java.lang.Integer  __operator_account_id ;
	protected java.lang.Boolean  __is_locked ;
	protected java.lang.Boolean  __is_human_add ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_bill_list_id ;
	protected java.lang.Boolean  __is_completed ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __company_id ;
}
