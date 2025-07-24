package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseTransaction extends GenericBase implements BaseFactory<BaseTransaction>, Comparable<BaseTransaction> 
{


	public static BaseTransaction newInstance(){
		return new BaseTransaction();
	}

	@Override
	public BaseTransaction make(){
		BaseTransaction b = new BaseTransaction();
		return b;
	}

	public final static java.lang.String CS_TRANSACTION_ID = "transaction_id" ;
	public final static java.lang.String CS_ACCOUNT = "account" ;
	public final static java.lang.String CS_ACCOUNT_ID = "account_id" ;
	public final static java.lang.String CS_TRANSACTION_TIME = "transaction_time" ;
	public final static java.lang.String CS_VALUE_OF_DATE = "value_of_date" ;
	public final static java.lang.String CS_TRANSACTION_TYPE = "transaction_type" ;
	public final static java.lang.String CS_TRANSACTION_ABSTRACT = "transaction_abstract" ;
	public final static java.lang.String CS_DEBIT_AMOUNT = "debit_amount" ;
	public final static java.lang.String CS_CREDIT_AMOUNT = "credit_amount" ;
	public final static java.lang.String CS_DEBIT_CREDIT_FLAG = "debit_credit_flag" ;
	public final static java.lang.String CS_BALANCE = "balance" ;
	public final static java.lang.String CS_SEQUENCE_NUMBER = "sequence_number" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_USAGE = "usage" ;
	public final static java.lang.String CS_REFERENCE_ID = "reference_id" ;
	public final static java.lang.String CS_BUSINESS_ABSTRACT = "business_abstract" ;
	public final static java.lang.String CS_OTHER_ABSTRACT = "other_abstract" ;
	public final static java.lang.String CS_PAYMENT_ACCOUNT_AREA = "payment_account_area" ;
	public final static java.lang.String CS_PAYMENT_ACCOUNT = "payment_account" ;
	public final static java.lang.String CS_PAYMENT_ACCOUNT_NAME = "payment_account_name" ;
	public final static java.lang.String CS_PAYMENT_ACCOUNT_BRANCH_ID = "payment_account_branch_id" ;
	public final static java.lang.String CS_PAYMENT_ACCOUNT_BRANCH_NAME = "payment_account_branch_name" ;
	public final static java.lang.String CS_PAYMENT_ACCOUNT_BRANCH_ADDRESS = "payment_account_branch_address" ;
	public final static java.lang.String CS_PARENT_ACCOUNT_AREA = "parent_account_area" ;
	public final static java.lang.String CS_PARENT_ACCOUNT = "parent_account" ;
	public final static java.lang.String CS_PARENT_ACCOUNT_NAME = "parent_account_name" ;
	public final static java.lang.String CS_INFORMATION_FLAG = "information_flag" ;
	public final static java.lang.String CS_HAS_ATTACHMENT = "has_attachment" ;
	public final static java.lang.String CS_ATTACHMENT_FLAG = "attachment_flag" ;
	public final static java.lang.String CS_CHECK_NO = "check_no" ;
	public final static java.lang.String CS_REVERSAL_FLAG = "reversal_flag" ;
	public final static java.lang.String CS_EXTEND_ABSTRACT = "extend_abstract" ;
	public final static java.lang.String CS_TRANSACTION_ANALYSIS_CODE = "transaction_analysis_code" ;
	public final static java.lang.String CS_BUSINESS_PAYMENT_ORDER_ID = "business_payment_order_id" ;
	public final static java.lang.String CS_ENTERPRISE_ID = "enterprise_id" ;

	public final static java.lang.String ALL_CAPTIONS = "交易编码,账号,账户编码,交易时间,起始日,交易类型,摘要,借方金额,贷方金额,借贷标志,余额,流水号,流程实例代码,业务名称,用途,业务参考号,业务摘要,其它摘要,收/付方开户地区,收/付方帐号,收/付方名称,收/付方开户行行号,收/付方开户行行号,收/付方开户行名,母/子公司所在地区,母/子公司帐号,母/子公司名称,信息标志,有否附件信息标志,有否附件信息标志,票据号,冲帐标志, *为冲帐，X为补帐,扩展摘要,交易分析码,商务支付订单号,企业识别码";

	public java.lang.Integer getTransactionId() {
		return this.__transaction_id;
	}

	public void setTransactionId( java.lang.Integer value ) {
		this.__transaction_id = value;
	}

	public java.lang.String getAccount() {
		return this.__account;
	}

	public void setAccount( java.lang.String value ) {
		this.__account = value;
	}

	public java.lang.Integer getAccountId() {
		return this.__account_id;
	}

	public void setAccountId( java.lang.Integer value ) {
		this.__account_id = value;
	}

	public java.util.Date getTransactionTime() {
		return this.__transaction_time;
	}

	public void setTransactionTime( java.util.Date value ) {
		this.__transaction_time = value;
	}

	public java.util.Date getValueOfDate() {
		return this.__value_of_date;
	}

	public void setValueOfDate( java.util.Date value ) {
		this.__value_of_date = value;
	}

	public java.lang.Integer getTransactionType() {
		return this.__transaction_type;
	}

	public void setTransactionType( java.lang.Integer value ) {
		this.__transaction_type = value;
	}

	public java.lang.String getTransactionAbstract() {
		return this.__transaction_abstract;
	}

	public void setTransactionAbstract( java.lang.String value ) {
		this.__transaction_abstract = value;
	}

	public java.math.BigDecimal getDebitAmount() {
		return this.__debit_amount;
	}

	public void setDebitAmount( java.math.BigDecimal value ) {
		this.__debit_amount = value;
	}

	public java.math.BigDecimal getCreditAmount() {
		return this.__credit_amount;
	}

	public void setCreditAmount( java.math.BigDecimal value ) {
		this.__credit_amount = value;
	}

	public java.lang.String getDebitCreditFlag() {
		return this.__debit_credit_flag;
	}

	public void setDebitCreditFlag( java.lang.String value ) {
		this.__debit_credit_flag = value;
	}

	public java.math.BigDecimal getBalance() {
		return this.__balance;
	}

	public void setBalance( java.math.BigDecimal value ) {
		this.__balance = value;
	}

	public java.lang.String getSequenceNumber() {
		return this.__sequence_number;
	}

	public void setSequenceNumber( java.lang.String value ) {
		this.__sequence_number = value;
	}

	public java.lang.String getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.String value ) {
		this.__process_instance_id = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.String getUsage() {
		return this.__usage;
	}

	public void setUsage( java.lang.String value ) {
		this.__usage = value;
	}

	public java.lang.String getReferenceId() {
		return this.__reference_id;
	}

	public void setReferenceId( java.lang.String value ) {
		this.__reference_id = value;
	}

	public java.lang.String getBusinessAbstract() {
		return this.__business_abstract;
	}

	public void setBusinessAbstract( java.lang.String value ) {
		this.__business_abstract = value;
	}

	public java.lang.String getOtherAbstract() {
		return this.__other_abstract;
	}

	public void setOtherAbstract( java.lang.String value ) {
		this.__other_abstract = value;
	}

	public java.lang.String getPaymentAccountArea() {
		return this.__payment_account_area;
	}

	public void setPaymentAccountArea( java.lang.String value ) {
		this.__payment_account_area = value;
	}

	public java.lang.String getPaymentAccount() {
		return this.__payment_account;
	}

	public void setPaymentAccount( java.lang.String value ) {
		this.__payment_account = value;
	}

	public java.lang.String getPaymentAccountName() {
		return this.__payment_account_name;
	}

	public void setPaymentAccountName( java.lang.String value ) {
		this.__payment_account_name = value;
	}

	public java.lang.String getPaymentAccountBranchId() {
		return this.__payment_account_branch_id;
	}

	public void setPaymentAccountBranchId( java.lang.String value ) {
		this.__payment_account_branch_id = value;
	}

	public java.lang.String getPaymentAccountBranchName() {
		return this.__payment_account_branch_name;
	}

	public void setPaymentAccountBranchName( java.lang.String value ) {
		this.__payment_account_branch_name = value;
	}

	public java.lang.String getPaymentAccountBranchAddress() {
		return this.__payment_account_branch_address;
	}

	public void setPaymentAccountBranchAddress( java.lang.String value ) {
		this.__payment_account_branch_address = value;
	}

	public java.lang.String getParentAccountArea() {
		return this.__parent_account_area;
	}

	public void setParentAccountArea( java.lang.String value ) {
		this.__parent_account_area = value;
	}

	public java.lang.String getParentAccount() {
		return this.__parent_account;
	}

	public void setParentAccount( java.lang.String value ) {
		this.__parent_account = value;
	}

	public java.lang.String getParentAccountName() {
		return this.__parent_account_name;
	}

	public void setParentAccountName( java.lang.String value ) {
		this.__parent_account_name = value;
	}

	public java.lang.String getInformationFlag() {
		return this.__information_flag;
	}

	public void setInformationFlag( java.lang.String value ) {
		this.__information_flag = value;
	}

	public java.lang.String getHasAttachment() {
		return this.__has_attachment;
	}

	public void setHasAttachment( java.lang.String value ) {
		this.__has_attachment = value;
	}

	public java.lang.String getAttachmentFlag() {
		return this.__attachment_flag;
	}

	public void setAttachmentFlag( java.lang.String value ) {
		this.__attachment_flag = value;
	}

	public java.lang.String getCheckNo() {
		return this.__check_no;
	}

	public void setCheckNo( java.lang.String value ) {
		this.__check_no = value;
	}

	public java.lang.String getReversalFlag() {
		return this.__reversal_flag;
	}

	public void setReversalFlag( java.lang.String value ) {
		this.__reversal_flag = value;
	}

	public java.lang.String getExtendAbstract() {
		return this.__extend_abstract;
	}

	public void setExtendAbstract( java.lang.String value ) {
		this.__extend_abstract = value;
	}

	public java.lang.String getTransactionAnalysisCode() {
		return this.__transaction_analysis_code;
	}

	public void setTransactionAnalysisCode( java.lang.String value ) {
		this.__transaction_analysis_code = value;
	}

	public java.lang.String getBusinessPaymentOrderId() {
		return this.__business_payment_order_id;
	}

	public void setBusinessPaymentOrderId( java.lang.String value ) {
		this.__business_payment_order_id = value;
	}

	public java.lang.String getEnterpriseId() {
		return this.__enterprise_id;
	}

	public void setEnterpriseId( java.lang.String value ) {
		this.__enterprise_id = value;
	}

	public void cloneCopy(BaseTransaction __bean){
		__bean.setTransactionId(getTransactionId());
		__bean.setAccount(getAccount());
		__bean.setAccountId(getAccountId());
		__bean.setTransactionTime(getTransactionTime());
		__bean.setValueOfDate(getValueOfDate());
		__bean.setTransactionType(getTransactionType());
		__bean.setTransactionAbstract(getTransactionAbstract());
		__bean.setDebitAmount(getDebitAmount());
		__bean.setCreditAmount(getCreditAmount());
		__bean.setDebitCreditFlag(getDebitCreditFlag());
		__bean.setBalance(getBalance());
		__bean.setSequenceNumber(getSequenceNumber());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBusinessName(getBusinessName());
		__bean.setUsage(getUsage());
		__bean.setReferenceId(getReferenceId());
		__bean.setBusinessAbstract(getBusinessAbstract());
		__bean.setOtherAbstract(getOtherAbstract());
		__bean.setPaymentAccountArea(getPaymentAccountArea());
		__bean.setPaymentAccount(getPaymentAccount());
		__bean.setPaymentAccountName(getPaymentAccountName());
		__bean.setPaymentAccountBranchId(getPaymentAccountBranchId());
		__bean.setPaymentAccountBranchName(getPaymentAccountBranchName());
		__bean.setPaymentAccountBranchAddress(getPaymentAccountBranchAddress());
		__bean.setParentAccountArea(getParentAccountArea());
		__bean.setParentAccount(getParentAccount());
		__bean.setParentAccountName(getParentAccountName());
		__bean.setInformationFlag(getInformationFlag());
		__bean.setHasAttachment(getHasAttachment());
		__bean.setAttachmentFlag(getAttachmentFlag());
		__bean.setCheckNo(getCheckNo());
		__bean.setReversalFlag(getReversalFlag());
		__bean.setExtendAbstract(getExtendAbstract());
		__bean.setTransactionAnalysisCode(getTransactionAnalysisCode());
		__bean.setBusinessPaymentOrderId(getBusinessPaymentOrderId());
		__bean.setEnterpriseId(getEnterpriseId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getTransactionId() == null ? "" : getTransactionId());
		sb.append(",");
		sb.append(getAccount() == null ? "" : getAccount());
		sb.append(",");
		sb.append(getAccountId() == null ? "" : getAccountId());
		sb.append(",");
		sb.append(getTransactionTime() == null ? "" : sdf.format(getTransactionTime()));
		sb.append(",");
		sb.append(getValueOfDate() == null ? "" : sdf.format(getValueOfDate()));
		sb.append(",");
		sb.append(getTransactionType() == null ? "" : getTransactionType());
		sb.append(",");
		sb.append(getTransactionAbstract() == null ? "" : getTransactionAbstract());
		sb.append(",");
		sb.append(getDebitAmount() == null ? "" : getDebitAmount());
		sb.append(",");
		sb.append(getCreditAmount() == null ? "" : getCreditAmount());
		sb.append(",");
		sb.append(getDebitCreditFlag() == null ? "" : getDebitCreditFlag());
		sb.append(",");
		sb.append(getBalance() == null ? "" : getBalance());
		sb.append(",");
		sb.append(getSequenceNumber() == null ? "" : getSequenceNumber());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getUsage() == null ? "" : getUsage());
		sb.append(",");
		sb.append(getReferenceId() == null ? "" : getReferenceId());
		sb.append(",");
		sb.append(getBusinessAbstract() == null ? "" : getBusinessAbstract());
		sb.append(",");
		sb.append(getOtherAbstract() == null ? "" : getOtherAbstract());
		sb.append(",");
		sb.append(getPaymentAccountArea() == null ? "" : getPaymentAccountArea());
		sb.append(",");
		sb.append(getPaymentAccount() == null ? "" : getPaymentAccount());
		sb.append(",");
		sb.append(getPaymentAccountName() == null ? "" : getPaymentAccountName());
		sb.append(",");
		sb.append(getPaymentAccountBranchId() == null ? "" : getPaymentAccountBranchId());
		sb.append(",");
		sb.append(getPaymentAccountBranchName() == null ? "" : getPaymentAccountBranchName());
		sb.append(",");
		sb.append(getPaymentAccountBranchAddress() == null ? "" : getPaymentAccountBranchAddress());
		sb.append(",");
		sb.append(getParentAccountArea() == null ? "" : getParentAccountArea());
		sb.append(",");
		sb.append(getParentAccount() == null ? "" : getParentAccount());
		sb.append(",");
		sb.append(getParentAccountName() == null ? "" : getParentAccountName());
		sb.append(",");
		sb.append(getInformationFlag() == null ? "" : getInformationFlag());
		sb.append(",");
		sb.append(getHasAttachment() == null ? "" : getHasAttachment());
		sb.append(",");
		sb.append(getAttachmentFlag() == null ? "" : getAttachmentFlag());
		sb.append(",");
		sb.append(getCheckNo() == null ? "" : getCheckNo());
		sb.append(",");
		sb.append(getReversalFlag() == null ? "" : getReversalFlag());
		sb.append(",");
		sb.append(getExtendAbstract() == null ? "" : getExtendAbstract());
		sb.append(",");
		sb.append(getTransactionAnalysisCode() == null ? "" : getTransactionAnalysisCode());
		sb.append(",");
		sb.append(getBusinessPaymentOrderId() == null ? "" : getBusinessPaymentOrderId());
		sb.append(",");
		sb.append(getEnterpriseId() == null ? "" : getEnterpriseId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTransaction o) {
		return __transaction_id == null ? -1 : __transaction_id.compareTo(o.getTransactionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__transaction_id);
		hash = 97 * hash + Objects.hashCode(this.__account);
		hash = 97 * hash + Objects.hashCode(this.__account_id);
		hash = 97 * hash + Objects.hashCode(this.__transaction_time);
		hash = 97 * hash + Objects.hashCode(this.__value_of_date);
		hash = 97 * hash + Objects.hashCode(this.__transaction_type);
		hash = 97 * hash + Objects.hashCode(this.__transaction_abstract);
		hash = 97 * hash + Objects.hashCode(this.__debit_amount);
		hash = 97 * hash + Objects.hashCode(this.__credit_amount);
		hash = 97 * hash + Objects.hashCode(this.__debit_credit_flag);
		hash = 97 * hash + Objects.hashCode(this.__balance);
		hash = 97 * hash + Objects.hashCode(this.__sequence_number);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__usage);
		hash = 97 * hash + Objects.hashCode(this.__reference_id);
		hash = 97 * hash + Objects.hashCode(this.__business_abstract);
		hash = 97 * hash + Objects.hashCode(this.__other_abstract);
		hash = 97 * hash + Objects.hashCode(this.__payment_account_area);
		hash = 97 * hash + Objects.hashCode(this.__payment_account);
		hash = 97 * hash + Objects.hashCode(this.__payment_account_name);
		hash = 97 * hash + Objects.hashCode(this.__payment_account_branch_id);
		hash = 97 * hash + Objects.hashCode(this.__payment_account_branch_name);
		hash = 97 * hash + Objects.hashCode(this.__payment_account_branch_address);
		hash = 97 * hash + Objects.hashCode(this.__parent_account_area);
		hash = 97 * hash + Objects.hashCode(this.__parent_account);
		hash = 97 * hash + Objects.hashCode(this.__parent_account_name);
		hash = 97 * hash + Objects.hashCode(this.__information_flag);
		hash = 97 * hash + Objects.hashCode(this.__has_attachment);
		hash = 97 * hash + Objects.hashCode(this.__attachment_flag);
		hash = 97 * hash + Objects.hashCode(this.__check_no);
		hash = 97 * hash + Objects.hashCode(this.__reversal_flag);
		hash = 97 * hash + Objects.hashCode(this.__extend_abstract);
		hash = 97 * hash + Objects.hashCode(this.__transaction_analysis_code);
		hash = 97 * hash + Objects.hashCode(this.__business_payment_order_id);
		hash = 97 * hash + Objects.hashCode(this.__enterprise_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTransaction o = (BaseTransaction)obj;
		if(!Objects.equals(this.__transaction_id, o.getTransactionId())) return false;
		if(!Objects.equals(this.__account, o.getAccount())) return false;
		if(!Objects.equals(this.__account_id, o.getAccountId())) return false;
		if(!Objects.equals(this.__transaction_time, o.getTransactionTime())) return false;
		if(!Objects.equals(this.__value_of_date, o.getValueOfDate())) return false;
		if(!Objects.equals(this.__transaction_type, o.getTransactionType())) return false;
		if(!Objects.equals(this.__transaction_abstract, o.getTransactionAbstract())) return false;
		if(!Objects.equals(this.__debit_amount, o.getDebitAmount())) return false;
		if(!Objects.equals(this.__credit_amount, o.getCreditAmount())) return false;
		if(!Objects.equals(this.__debit_credit_flag, o.getDebitCreditFlag())) return false;
		if(!Objects.equals(this.__balance, o.getBalance())) return false;
		if(!Objects.equals(this.__sequence_number, o.getSequenceNumber())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__usage, o.getUsage())) return false;
		if(!Objects.equals(this.__reference_id, o.getReferenceId())) return false;
		if(!Objects.equals(this.__business_abstract, o.getBusinessAbstract())) return false;
		if(!Objects.equals(this.__other_abstract, o.getOtherAbstract())) return false;
		if(!Objects.equals(this.__payment_account_area, o.getPaymentAccountArea())) return false;
		if(!Objects.equals(this.__payment_account, o.getPaymentAccount())) return false;
		if(!Objects.equals(this.__payment_account_name, o.getPaymentAccountName())) return false;
		if(!Objects.equals(this.__payment_account_branch_id, o.getPaymentAccountBranchId())) return false;
		if(!Objects.equals(this.__payment_account_branch_name, o.getPaymentAccountBranchName())) return false;
		if(!Objects.equals(this.__payment_account_branch_address, o.getPaymentAccountBranchAddress())) return false;
		if(!Objects.equals(this.__parent_account_area, o.getParentAccountArea())) return false;
		if(!Objects.equals(this.__parent_account, o.getParentAccount())) return false;
		if(!Objects.equals(this.__parent_account_name, o.getParentAccountName())) return false;
		if(!Objects.equals(this.__information_flag, o.getInformationFlag())) return false;
		if(!Objects.equals(this.__has_attachment, o.getHasAttachment())) return false;
		if(!Objects.equals(this.__attachment_flag, o.getAttachmentFlag())) return false;
		if(!Objects.equals(this.__check_no, o.getCheckNo())) return false;
		if(!Objects.equals(this.__reversal_flag, o.getReversalFlag())) return false;
		if(!Objects.equals(this.__extend_abstract, o.getExtendAbstract())) return false;
		if(!Objects.equals(this.__transaction_analysis_code, o.getTransactionAnalysisCode())) return false;
		if(!Objects.equals(this.__business_payment_order_id, o.getBusinessPaymentOrderId())) return false;
		if(!Objects.equals(this.__enterprise_id, o.getEnterpriseId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTransactionId() != null) sb.append(__wrapNumber(count++, "transactionId", getTransactionId()));
		if(getAccount() != null) sb.append(__wrapString(count++, "account", getAccount()));
		if(getAccountId() != null) sb.append(__wrapNumber(count++, "accountId", getAccountId()));
		if(getTransactionTime() != null) sb.append(__wrapDate(count++, "transactionTime", getTransactionTime()));
		if(getValueOfDate() != null) sb.append(__wrapDate(count++, "valueOfDate", getValueOfDate()));
		if(getTransactionType() != null) sb.append(__wrapNumber(count++, "transactionType", getTransactionType()));
		if(getTransactionAbstract() != null) sb.append(__wrapString(count++, "transactionAbstract", getTransactionAbstract()));
		if(getDebitAmount() != null) sb.append(__wrapDecimal(count++, "debitAmount", getDebitAmount()));
		if(getCreditAmount() != null) sb.append(__wrapDecimal(count++, "creditAmount", getCreditAmount()));
		if(getDebitCreditFlag() != null) sb.append(__wrapString(count++, "debitCreditFlag", getDebitCreditFlag()));
		if(getBalance() != null) sb.append(__wrapDecimal(count++, "balance", getBalance()));
		if(getSequenceNumber() != null) sb.append(__wrapString(count++, "sequenceNumber", getSequenceNumber()));
		if(getProcessInstanceId() != null) sb.append(__wrapString(count++, "processInstanceId", getProcessInstanceId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getUsage() != null) sb.append(__wrapString(count++, "usage", getUsage()));
		if(getReferenceId() != null) sb.append(__wrapString(count++, "referenceId", getReferenceId()));
		if(getBusinessAbstract() != null) sb.append(__wrapString(count++, "businessAbstract", getBusinessAbstract()));
		if(getOtherAbstract() != null) sb.append(__wrapString(count++, "otherAbstract", getOtherAbstract()));
		if(getPaymentAccountArea() != null) sb.append(__wrapString(count++, "paymentAccountArea", getPaymentAccountArea()));
		if(getPaymentAccount() != null) sb.append(__wrapString(count++, "paymentAccount", getPaymentAccount()));
		if(getPaymentAccountName() != null) sb.append(__wrapString(count++, "paymentAccountName", getPaymentAccountName()));
		if(getPaymentAccountBranchId() != null) sb.append(__wrapString(count++, "paymentAccountBranchId", getPaymentAccountBranchId()));
		if(getPaymentAccountBranchName() != null) sb.append(__wrapString(count++, "paymentAccountBranchName", getPaymentAccountBranchName()));
		if(getPaymentAccountBranchAddress() != null) sb.append(__wrapString(count++, "paymentAccountBranchAddress", getPaymentAccountBranchAddress()));
		if(getParentAccountArea() != null) sb.append(__wrapString(count++, "parentAccountArea", getParentAccountArea()));
		if(getParentAccount() != null) sb.append(__wrapString(count++, "parentAccount", getParentAccount()));
		if(getParentAccountName() != null) sb.append(__wrapString(count++, "parentAccountName", getParentAccountName()));
		if(getInformationFlag() != null) sb.append(__wrapString(count++, "informationFlag", getInformationFlag()));
		if(getHasAttachment() != null) sb.append(__wrapString(count++, "hasAttachment", getHasAttachment()));
		if(getAttachmentFlag() != null) sb.append(__wrapString(count++, "attachmentFlag", getAttachmentFlag()));
		if(getCheckNo() != null) sb.append(__wrapString(count++, "checkNo", getCheckNo()));
		if(getReversalFlag() != null) sb.append(__wrapString(count++, "reversalFlag", getReversalFlag()));
		if(getExtendAbstract() != null) sb.append(__wrapString(count++, "extendAbstract", getExtendAbstract()));
		if(getTransactionAnalysisCode() != null) sb.append(__wrapString(count++, "transactionAnalysisCode", getTransactionAnalysisCode()));
		if(getBusinessPaymentOrderId() != null) sb.append(__wrapString(count++, "businessPaymentOrderId", getBusinessPaymentOrderId()));
		if(getEnterpriseId() != null) sb.append(__wrapString(count++, "enterpriseId", getEnterpriseId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("transactionId")) != null) setTransactionId(__getInt(val)); 
		if((val = values.get("account")) != null) setAccount(__getString(val));
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
		if((val = values.get("transactionTime")) != null) setTransactionTime(__getDate(val)); 
		if((val = values.get("valueOfDate")) != null) setValueOfDate(__getDate(val)); 
		if((val = values.get("transactionType")) != null) setTransactionType(__getInt(val)); 
		if((val = values.get("transactionAbstract")) != null) setTransactionAbstract(__getString(val));
		if((val = values.get("debitAmount")) != null) setDebitAmount(__getDecimal(val));  
		if((val = values.get("creditAmount")) != null) setCreditAmount(__getDecimal(val));  
		if((val = values.get("debitCreditFlag")) != null) setDebitCreditFlag(__getString(val));
		if((val = values.get("balance")) != null) setBalance(__getDecimal(val));  
		if((val = values.get("sequenceNumber")) != null) setSequenceNumber(__getString(val));
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getString(val));
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("usage")) != null) setUsage(__getString(val));
		if((val = values.get("referenceId")) != null) setReferenceId(__getString(val));
		if((val = values.get("businessAbstract")) != null) setBusinessAbstract(__getString(val));
		if((val = values.get("otherAbstract")) != null) setOtherAbstract(__getString(val));
		if((val = values.get("paymentAccountArea")) != null) setPaymentAccountArea(__getString(val));
		if((val = values.get("paymentAccount")) != null) setPaymentAccount(__getString(val));
		if((val = values.get("paymentAccountName")) != null) setPaymentAccountName(__getString(val));
		if((val = values.get("paymentAccountBranchId")) != null) setPaymentAccountBranchId(__getString(val));
		if((val = values.get("paymentAccountBranchName")) != null) setPaymentAccountBranchName(__getString(val));
		if((val = values.get("paymentAccountBranchAddress")) != null) setPaymentAccountBranchAddress(__getString(val));
		if((val = values.get("parentAccountArea")) != null) setParentAccountArea(__getString(val));
		if((val = values.get("parentAccount")) != null) setParentAccount(__getString(val));
		if((val = values.get("parentAccountName")) != null) setParentAccountName(__getString(val));
		if((val = values.get("informationFlag")) != null) setInformationFlag(__getString(val));
		if((val = values.get("hasAttachment")) != null) setHasAttachment(__getString(val));
		if((val = values.get("attachmentFlag")) != null) setAttachmentFlag(__getString(val));
		if((val = values.get("checkNo")) != null) setCheckNo(__getString(val));
		if((val = values.get("reversalFlag")) != null) setReversalFlag(__getString(val));
		if((val = values.get("extendAbstract")) != null) setExtendAbstract(__getString(val));
		if((val = values.get("transactionAnalysisCode")) != null) setTransactionAnalysisCode(__getString(val));
		if((val = values.get("businessPaymentOrderId")) != null) setBusinessPaymentOrderId(__getString(val));
		if((val = values.get("enterpriseId")) != null) setEnterpriseId(__getString(val));
	}

	protected java.lang.Integer  __transaction_id ;
	protected java.lang.String  __account ;
	protected java.lang.Integer  __account_id ;
	protected java.util.Date  __transaction_time ;
	protected java.util.Date  __value_of_date ;
	protected java.lang.Integer  __transaction_type ;
	protected java.lang.String  __transaction_abstract ;
	protected java.math.BigDecimal  __debit_amount ;
	protected java.math.BigDecimal  __credit_amount ;
	protected java.lang.String  __debit_credit_flag ;
	protected java.math.BigDecimal  __balance ;
	protected java.lang.String  __sequence_number ;
	protected java.lang.String  __process_instance_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.String  __usage ;
	protected java.lang.String  __reference_id ;
	protected java.lang.String  __business_abstract ;
	protected java.lang.String  __other_abstract ;
	protected java.lang.String  __payment_account_area ;
	protected java.lang.String  __payment_account ;
	protected java.lang.String  __payment_account_name ;
	protected java.lang.String  __payment_account_branch_id ;
	protected java.lang.String  __payment_account_branch_name ;
	protected java.lang.String  __payment_account_branch_address ;
	protected java.lang.String  __parent_account_area ;
	protected java.lang.String  __parent_account ;
	protected java.lang.String  __parent_account_name ;
	protected java.lang.String  __information_flag ;
	protected java.lang.String  __has_attachment ;
	protected java.lang.String  __attachment_flag ;
	protected java.lang.String  __check_no ;
	protected java.lang.String  __reversal_flag ;
	protected java.lang.String  __extend_abstract ;
	protected java.lang.String  __transaction_analysis_code ;
	protected java.lang.String  __business_payment_order_id ;
	protected java.lang.String  __enterprise_id ;
}
