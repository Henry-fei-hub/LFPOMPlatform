package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCapital extends GenericBase implements BaseFactory<BaseCapital>, Comparable<BaseCapital> 
{


	public static BaseCapital newInstance(){
		return new BaseCapital();
	}

	@Override
	public BaseCapital make(){
		BaseCapital b = new BaseCapital();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_MONEY_ATTRIBUTE = "money_attribute" ;
	public final static java.lang.String CS_SELF_NAME = "self_name" ;
	public final static java.lang.String CS_SELF_BANK_NAME = "self_bank_name" ;
	public final static java.lang.String CS_SELF_BANK_ACCOUNT = "self_bank_account" ;
	public final static java.lang.String CS_OTHER_NAME = "other_name" ;
	public final static java.lang.String CS_OTHER_BANK_NAME = "other_bank_name" ;
	public final static java.lang.String CS_OTHER_BANK_ACCOUNT = "other_bank_account" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_LOAN_MONEY = "loan_money" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_HAS_INVOICES = "has_invoices" ;
	public final static java.lang.String CS_HAS_CONTRACT_RECEIVABLE = "has_contract_receivable" ;
	public final static java.lang.String CS_HAS_DISTRIBUTION_COLLECTION = "has_distribution_collection" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CAPITAL_TYPE = "capital_type" ;
	public final static java.lang.String CS_REIMBURSEMENT_PACKAGE_SUMMARY_ID = "reimbursement_package_summary_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_CAPITAL_DISTRIBUTION_ID = "capital_distribution_id" ;
	public final static java.lang.String CS_HAVE_VOUCHER = "have_voucher" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_RECORD_RECEIVE_CAPITAL = "record_receive_capital" ;
	public final static java.lang.String CS_EXCHANGE_RATE = "exchange_rate" ;
	public final static java.lang.String CS_ORIGINAL_CURRENCY = "original_currency" ;
	public final static java.lang.String CS_IS_PAYBACK = "is_payback" ;
	public final static java.lang.String CS_IS_HAVING_INVOICE = "is_having_invoice" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_ISSUE_DATE = "issue_date" ;
	public final static java.lang.String CS_EXPIRE_DATE = "expire_date" ;
	public final static java.lang.String CS_RECEIVE_UNIT_ID = "receive_unit_id" ;
	public final static java.lang.String CS_ACTUAL_AMOUNT = "actual_amount" ;
	public final static java.lang.String CS_ACTUAL_RECEIVE_DATE = "actual_receive_date" ;

	public final static java.lang.String ALL_CAPTIONS = "资金表id,信息编号,项目编号,合同id,合同主编号,款项属性,内部公司(收款方),银行名称(收款方),银行账号(收款方),对方名称(付款方),银行名称(付款方),银行账号(付款方),借（增加）,贷（减少）,操作人id,发生日期,登记日期,是否绑定了发票,是否绑定了合同阶段付款,有分配回款,备注,资金类型  1 流入  2 流出,打包汇总的流水编码,流程状态 0 未处于流程  1审批中 2审批完成,回款分配编码,是否有凭证,流程类型,流程中的业务主键,是否记录回款金  用作资金统计用 ture记录(进行统计),汇率,原币金额,是否回款,是否对应发票,上传的附件的编码,出票日期,到期日期,实际客户名称,实际到账金额,实际到账日期";

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	public java.lang.String getSelfBankName() {
		return this.__self_bank_name;
	}

	public void setSelfBankName( java.lang.String value ) {
		this.__self_bank_name = value;
	}

	public java.lang.String getSelfBankAccount() {
		return this.__self_bank_account;
	}

	public void setSelfBankAccount( java.lang.String value ) {
		this.__self_bank_account = value;
	}

	public java.lang.String getOtherName() {
		return this.__other_name;
	}

	public void setOtherName( java.lang.String value ) {
		this.__other_name = value;
	}

	public java.lang.String getOtherBankName() {
		return this.__other_bank_name;
	}

	public void setOtherBankName( java.lang.String value ) {
		this.__other_bank_name = value;
	}

	public java.lang.String getOtherBankAccount() {
		return this.__other_bank_account;
	}

	public void setOtherBankAccount( java.lang.String value ) {
		this.__other_bank_account = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.math.BigDecimal getLoanMoney() {
		return this.__loan_money;
	}

	public void setLoanMoney( java.math.BigDecimal value ) {
		this.__loan_money = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.Boolean getHasInvoices() {
		return this.__has_invoices;
	}

	public void setHasInvoices( java.lang.Boolean value ) {
		this.__has_invoices = value;
	}

	public java.lang.Boolean getHasContractReceivable() {
		return this.__has_contract_receivable;
	}

	public void setHasContractReceivable( java.lang.Boolean value ) {
		this.__has_contract_receivable = value;
	}

	public java.lang.Boolean getHasDistributionCollection() {
		return this.__has_distribution_collection;
	}

	public void setHasDistributionCollection( java.lang.Boolean value ) {
		this.__has_distribution_collection = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getCapitalType() {
		return this.__capital_type;
	}

	public void setCapitalType( java.lang.Integer value ) {
		this.__capital_type = value;
	}

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return this.__reimbursement_package_summary_id;
	}

	public void setReimbursementPackageSummaryId( java.lang.Integer value ) {
		this.__reimbursement_package_summary_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getCapitalDistributionId() {
		return this.__capital_distribution_id;
	}

	public void setCapitalDistributionId( java.lang.Integer value ) {
		this.__capital_distribution_id = value;
	}

	public java.lang.Boolean getHaveVoucher() {
		return this.__have_voucher;
	}

	public void setHaveVoucher( java.lang.Boolean value ) {
		this.__have_voucher = value;
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

	public java.lang.Boolean getRecordReceiveCapital() {
		return this.__record_receive_capital;
	}

	public void setRecordReceiveCapital( java.lang.Boolean value ) {
		this.__record_receive_capital = value;
	}

	public java.math.BigDecimal getExchangeRate() {
		return this.__exchange_rate;
	}

	public void setExchangeRate( java.math.BigDecimal value ) {
		this.__exchange_rate = value;
	}

	public java.math.BigDecimal getOriginalCurrency() {
		return this.__original_currency;
	}

	public void setOriginalCurrency( java.math.BigDecimal value ) {
		this.__original_currency = value;
	}

	public java.lang.Integer getIsPayback() {
		return this.__is_payback;
	}

	public void setIsPayback( java.lang.Integer value ) {
		this.__is_payback = value;
	}

	public java.lang.Integer getIsHavingInvoice() {
		return this.__is_having_invoice;
	}

	public void setIsHavingInvoice( java.lang.Integer value ) {
		this.__is_having_invoice = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.util.Date getIssueDate() {
		return this.__issue_date;
	}

	public void setIssueDate( java.util.Date value ) {
		this.__issue_date = value;
	}

	public java.util.Date getExpireDate() {
		return this.__expire_date;
	}

	public void setExpireDate( java.util.Date value ) {
		this.__expire_date = value;
	}

	public java.lang.Integer getReceiveUnitId() {
		return this.__receive_unit_id;
	}

	public void setReceiveUnitId( java.lang.Integer value ) {
		this.__receive_unit_id = value;
	}

	public java.math.BigDecimal getActualAmount() {
		return this.__actual_amount;
	}

	public void setActualAmount( java.math.BigDecimal value ) {
		this.__actual_amount = value;
	}

	public java.util.Date getActualReceiveDate() {
		return this.__actual_receive_date;
	}

	public void setActualReceiveDate( java.util.Date value ) {
		this.__actual_receive_date = value;
	}

	public void cloneCopy(BaseCapital __bean){
		__bean.setCapitalId(getCapitalId());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setMoneyAttribute(getMoneyAttribute());
		__bean.setSelfName(getSelfName());
		__bean.setSelfBankName(getSelfBankName());
		__bean.setSelfBankAccount(getSelfBankAccount());
		__bean.setOtherName(getOtherName());
		__bean.setOtherBankName(getOtherBankName());
		__bean.setOtherBankAccount(getOtherBankAccount());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setLoanMoney(getLoanMoney());
		__bean.setOperator(getOperator());
		__bean.setHappenDate(getHappenDate());
		__bean.setCreateDate(getCreateDate());
		__bean.setHasInvoices(getHasInvoices());
		__bean.setHasContractReceivable(getHasContractReceivable());
		__bean.setHasDistributionCollection(getHasDistributionCollection());
		__bean.setRemark(getRemark());
		__bean.setCapitalType(getCapitalType());
		__bean.setReimbursementPackageSummaryId(getReimbursementPackageSummaryId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCapitalDistributionId(getCapitalDistributionId());
		__bean.setHaveVoucher(getHaveVoucher());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setRecordReceiveCapital(getRecordReceiveCapital());
		__bean.setExchangeRate(getExchangeRate());
		__bean.setOriginalCurrency(getOriginalCurrency());
		__bean.setIsPayback(getIsPayback());
		__bean.setIsHavingInvoice(getIsHavingInvoice());
		__bean.setFileId(getFileId());
		__bean.setIssueDate(getIssueDate());
		__bean.setExpireDate(getExpireDate());
		__bean.setReceiveUnitId(getReceiveUnitId());
		__bean.setActualAmount(getActualAmount());
		__bean.setActualReceiveDate(getActualReceiveDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		String strProjectCode = delicacy.system.executor.SelectValueCache.getSelectValue("main_projects", String.valueOf(getProjectCode()));
		sb.append(strProjectCode == null ? "" : strProjectCode);
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getMoneyAttribute() == null ? "" : getMoneyAttribute());
		sb.append(",");
		String strSelfName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSelfName()));
		sb.append(strSelfName == null ? "" : strSelfName);
		sb.append(",");
		sb.append(getSelfBankName() == null ? "" : getSelfBankName());
		sb.append(",");
		sb.append(getSelfBankAccount() == null ? "" : getSelfBankAccount());
		sb.append(",");
		sb.append(getOtherName() == null ? "" : getOtherName());
		sb.append(",");
		sb.append(getOtherBankName() == null ? "" : getOtherBankName());
		sb.append(",");
		sb.append(getOtherBankAccount() == null ? "" : getOtherBankAccount());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getLoanMoney() == null ? "" : getLoanMoney());
		sb.append(",");
		String strOperator = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperator()));
		sb.append(strOperator == null ? "" : strOperator);
		sb.append(",");
		sb.append(getHappenDate() == null ? "" : sdf.format(getHappenDate()));
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getHasInvoices() == null ? "" : getHasInvoices());
		sb.append(",");
		sb.append(getHasContractReceivable() == null ? "" : getHasContractReceivable());
		sb.append(",");
		sb.append(getHasDistributionCollection() == null ? "" : getHasDistributionCollection());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCapitalType() == null ? "" : getCapitalType());
		sb.append(",");
		sb.append(getReimbursementPackageSummaryId() == null ? "" : getReimbursementPackageSummaryId());
		sb.append(",");
		String strProcessStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_120", String.valueOf(getProcessStatus()));
		sb.append(strProcessStatus == null ? "" : strProcessStatus);
		sb.append(",");
		sb.append(getCapitalDistributionId() == null ? "" : getCapitalDistributionId());
		sb.append(",");
		sb.append(getHaveVoucher() == null ? "" : getHaveVoucher());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		sb.append(",");
		sb.append(getRecordReceiveCapital() == null ? "" : getRecordReceiveCapital());
		sb.append(",");
		sb.append(getExchangeRate() == null ? "" : getExchangeRate());
		sb.append(",");
		sb.append(getOriginalCurrency() == null ? "" : getOriginalCurrency());
		sb.append(",");
		sb.append(getIsPayback() == null ? "" : getIsPayback());
		sb.append(",");
		sb.append(getIsHavingInvoice() == null ? "" : getIsHavingInvoice());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getIssueDate() == null ? "" : sdf.format(getIssueDate()));
		sb.append(",");
		sb.append(getExpireDate() == null ? "" : sdf.format(getExpireDate()));
		sb.append(",");
		sb.append(getReceiveUnitId() == null ? "" : getReceiveUnitId());
		sb.append(",");
		sb.append(getActualAmount() == null ? "" : getActualAmount());
		sb.append(",");
		sb.append(getActualReceiveDate() == null ? "" : sdf.format(getActualReceiveDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCapital o) {
		return __capital_id == null ? -1 : __capital_id.compareTo(o.getCapitalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__money_attribute);
		hash = 97 * hash + Objects.hashCode(this.__self_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__other_name);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__loan_money);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__has_invoices);
		hash = 97 * hash + Objects.hashCode(this.__has_contract_receivable);
		hash = 97 * hash + Objects.hashCode(this.__has_distribution_collection);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__capital_type);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_package_summary_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__capital_distribution_id);
		hash = 97 * hash + Objects.hashCode(this.__have_voucher);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__record_receive_capital);
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate);
		hash = 97 * hash + Objects.hashCode(this.__original_currency);
		hash = 97 * hash + Objects.hashCode(this.__is_payback);
		hash = 97 * hash + Objects.hashCode(this.__is_having_invoice);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__issue_date);
		hash = 97 * hash + Objects.hashCode(this.__expire_date);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_id);
		hash = 97 * hash + Objects.hashCode(this.__actual_amount);
		hash = 97 * hash + Objects.hashCode(this.__actual_receive_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCapital o = (BaseCapital)obj;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__money_attribute, o.getMoneyAttribute())) return false;
		if(!Objects.equals(this.__self_name, o.getSelfName())) return false;
		if(!Objects.equals(this.__self_bank_name, o.getSelfBankName())) return false;
		if(!Objects.equals(this.__self_bank_account, o.getSelfBankAccount())) return false;
		if(!Objects.equals(this.__other_name, o.getOtherName())) return false;
		if(!Objects.equals(this.__other_bank_name, o.getOtherBankName())) return false;
		if(!Objects.equals(this.__other_bank_account, o.getOtherBankAccount())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__loan_money, o.getLoanMoney())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__has_invoices, o.getHasInvoices())) return false;
		if(!Objects.equals(this.__has_contract_receivable, o.getHasContractReceivable())) return false;
		if(!Objects.equals(this.__has_distribution_collection, o.getHasDistributionCollection())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__capital_type, o.getCapitalType())) return false;
		if(!Objects.equals(this.__reimbursement_package_summary_id, o.getReimbursementPackageSummaryId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__capital_distribution_id, o.getCapitalDistributionId())) return false;
		if(!Objects.equals(this.__have_voucher, o.getHaveVoucher())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__record_receive_capital, o.getRecordReceiveCapital())) return false;
		if(!Objects.equals(this.__exchange_rate, o.getExchangeRate())) return false;
		if(!Objects.equals(this.__original_currency, o.getOriginalCurrency())) return false;
		if(!Objects.equals(this.__is_payback, o.getIsPayback())) return false;
		if(!Objects.equals(this.__is_having_invoice, o.getIsHavingInvoice())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__issue_date, o.getIssueDate())) return false;
		if(!Objects.equals(this.__expire_date, o.getExpireDate())) return false;
		if(!Objects.equals(this.__receive_unit_id, o.getReceiveUnitId())) return false;
		if(!Objects.equals(this.__actual_amount, o.getActualAmount())) return false;
		if(!Objects.equals(this.__actual_receive_date, o.getActualReceiveDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(count++, "moneyAttribute", getMoneyAttribute()));
		if(getSelfName() != null) sb.append(__wrapNumber(count++, "selfName", getSelfName()));
		if(getSelfBankName() != null) sb.append(__wrapString(count++, "selfBankName", getSelfBankName()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(count++, "selfBankAccount", getSelfBankAccount()));
		if(getOtherName() != null) sb.append(__wrapString(count++, "otherName", getOtherName()));
		if(getOtherBankName() != null) sb.append(__wrapString(count++, "otherBankName", getOtherBankName()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(count++, "otherBankAccount", getOtherBankAccount()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getLoanMoney() != null) sb.append(__wrapDecimal(count++, "loanMoney", getLoanMoney()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getHasInvoices() != null) sb.append(__wrapBoolean(count++, "hasInvoices", getHasInvoices()));
		if(getHasContractReceivable() != null) sb.append(__wrapBoolean(count++, "hasContractReceivable", getHasContractReceivable()));
		if(getHasDistributionCollection() != null) sb.append(__wrapBoolean(count++, "hasDistributionCollection", getHasDistributionCollection()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCapitalType() != null) sb.append(__wrapNumber(count++, "capitalType", getCapitalType()));
		if(getReimbursementPackageSummaryId() != null) sb.append(__wrapNumber(count++, "reimbursementPackageSummaryId", getReimbursementPackageSummaryId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCapitalDistributionId() != null) sb.append(__wrapNumber(count++, "capitalDistributionId", getCapitalDistributionId()));
		if(getHaveVoucher() != null) sb.append(__wrapBoolean(count++, "haveVoucher", getHaveVoucher()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getRecordReceiveCapital() != null) sb.append(__wrapBoolean(count++, "recordReceiveCapital", getRecordReceiveCapital()));
		if(getExchangeRate() != null) sb.append(__wrapDecimal(count++, "exchangeRate", getExchangeRate()));
		if(getOriginalCurrency() != null) sb.append(__wrapDecimal(count++, "originalCurrency", getOriginalCurrency()));
		if(getIsPayback() != null) sb.append(__wrapNumber(count++, "isPayback", getIsPayback()));
		if(getIsHavingInvoice() != null) sb.append(__wrapNumber(count++, "isHavingInvoice", getIsHavingInvoice()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getIssueDate() != null) sb.append(__wrapDate(count++, "issueDate", getIssueDate()));
		if(getExpireDate() != null) sb.append(__wrapDate(count++, "expireDate", getExpireDate()));
		if(getReceiveUnitId() != null) sb.append(__wrapNumber(count++, "receiveUnitId", getReceiveUnitId()));
		if(getActualAmount() != null) sb.append(__wrapDecimal(count++, "actualAmount", getActualAmount()));
		if(getActualReceiveDate() != null) sb.append(__wrapDate(count++, "actualReceiveDate", getActualReceiveDate()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCapitalId() != null) res.put("capitalId", getCapitalId());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getMoneyAttribute() != null) res.put("moneyAttribute", getMoneyAttribute());
		if(getSelfName() != null) res.put("selfName", getSelfName());
		if(getSelfBankName() != null) res.put("selfBankName", getSelfBankName());
		if(getSelfBankAccount() != null) res.put("selfBankAccount", getSelfBankAccount());
		if(getOtherName() != null) res.put("otherName", getOtherName());
		if(getOtherBankName() != null) res.put("otherBankName", getOtherBankName());
		if(getOtherBankAccount() != null) res.put("otherBankAccount", getOtherBankAccount());
		if(getBorrowMoney() != null) res.put("borrowMoney", getBorrowMoney());
		if(getLoanMoney() != null) res.put("loanMoney", getLoanMoney());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getHappenDate() != null) res.put("happenDate", getHappenDate());
		if(getCreateDate() != null) res.put("createDate", getCreateDate());
		if(getHasInvoices() != null) res.put("hasInvoices", getHasInvoices());
		if(getHasContractReceivable() != null) res.put("hasContractReceivable", getHasContractReceivable());
		if(getHasDistributionCollection() != null) res.put("hasDistributionCollection", getHasDistributionCollection());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getCapitalType() != null) res.put("capitalType", getCapitalType());
		if(getReimbursementPackageSummaryId() != null) res.put("reimbursementPackageSummaryId", getReimbursementPackageSummaryId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getCapitalDistributionId() != null) res.put("capitalDistributionId", getCapitalDistributionId());
		if(getHaveVoucher() != null) res.put("haveVoucher", getHaveVoucher());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getRecordReceiveCapital() != null) res.put("recordReceiveCapital", getRecordReceiveCapital());
		if(getExchangeRate() != null) res.put("exchangeRate", getExchangeRate());
		if(getOriginalCurrency() != null) res.put("originalCurrency", getOriginalCurrency());
		if(getIsPayback() != null) res.put("isPayback", getIsPayback());
		if(getIsHavingInvoice() != null) res.put("isHavingInvoice", getIsHavingInvoice());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getIssueDate() != null) res.put("issueDate", getIssueDate());
		if(getExpireDate() != null) res.put("expireDate", getExpireDate());
		if(getReceiveUnitId() != null) res.put("receiveUnitId", getReceiveUnitId());
		if(getActualAmount() != null) res.put("actualAmount", getActualAmount());
		if(getActualReceiveDate() != null) res.put("actualReceiveDate", getActualReceiveDate());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
		if((val = values.get("selfBankName")) != null) setSelfBankName(__getString(val));
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("otherName")) != null) setOtherName(__getString(val));
		if((val = values.get("otherBankName")) != null) setOtherBankName(__getString(val));
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("loanMoney")) != null) setLoanMoney(__getDecimal(val));  
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("hasInvoices")) != null) setHasInvoices(__getBoolean(val));
		if((val = values.get("hasContractReceivable")) != null) setHasContractReceivable(__getBoolean(val));
		if((val = values.get("hasDistributionCollection")) != null) setHasDistributionCollection(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("capitalType")) != null) setCapitalType(__getInt(val)); 
		if((val = values.get("reimbursementPackageSummaryId")) != null) setReimbursementPackageSummaryId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("capitalDistributionId")) != null) setCapitalDistributionId(__getInt(val)); 
		if((val = values.get("haveVoucher")) != null) setHaveVoucher(__getBoolean(val));
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("recordReceiveCapital")) != null) setRecordReceiveCapital(__getBoolean(val));
		if((val = values.get("exchangeRate")) != null) setExchangeRate(__getDecimal(val));  
		if((val = values.get("originalCurrency")) != null) setOriginalCurrency(__getDecimal(val));  
		if((val = values.get("isPayback")) != null) setIsPayback(__getInt(val)); 
		if((val = values.get("isHavingInvoice")) != null) setIsHavingInvoice(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("issueDate")) != null) setIssueDate(__getDate(val)); 
		if((val = values.get("expireDate")) != null) setExpireDate(__getDate(val)); 
		if((val = values.get("receiveUnitId")) != null) setReceiveUnitId(__getInt(val)); 
		if((val = values.get("actualAmount")) != null) setActualAmount(__getDecimal(val));  
		if((val = values.get("actualReceiveDate")) != null) setActualReceiveDate(__getDate(val)); 
	}

	protected java.lang.Integer  __capital_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __money_attribute ;
	protected java.lang.Integer  __self_name ;
	protected java.lang.String  __self_bank_name ;
	protected java.lang.String  __self_bank_account ;
	protected java.lang.String  __other_name ;
	protected java.lang.String  __other_bank_name ;
	protected java.lang.String  __other_bank_account ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.math.BigDecimal  __loan_money ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __happen_date ;
	protected java.util.Date  __create_date ;
	protected java.lang.Boolean  __has_invoices ;
	protected java.lang.Boolean  __has_contract_receivable ;
	protected java.lang.Boolean  __has_distribution_collection ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __capital_type ;
	protected java.lang.Integer  __reimbursement_package_summary_id ;
	protected java.lang.Integer  __process_status ;
	protected java.lang.Integer  __capital_distribution_id ;
	protected java.lang.Boolean  __have_voucher ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Boolean  __record_receive_capital ;
	protected java.math.BigDecimal  __exchange_rate ;
	protected java.math.BigDecimal  __original_currency ;
	protected java.lang.Integer  __is_payback ;
	protected java.lang.Integer  __is_having_invoice ;
	protected java.lang.Integer  __file_id ;
	protected java.util.Date  __issue_date ;
	protected java.util.Date  __expire_date ;
	protected java.lang.Integer  __receive_unit_id ;
	protected java.math.BigDecimal  __actual_amount ;
	protected java.util.Date  __actual_receive_date ;
}
