package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCapital;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Capital extends AbstractTable<BaseCapital>
{

	public Capital() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 39;

		initTables();

		__tableName            = "capitals";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCapital.CS_CAPITAL_ID;
		__column_names[1] = BaseCapital.CS_INFO_CODE;
		__column_names[2] = BaseCapital.CS_PROJECT_CODE;
		__column_names[3] = BaseCapital.CS_CONTRACT_ID;
		__column_names[4] = BaseCapital.CS_CONTRACT_CODE;
		__column_names[5] = BaseCapital.CS_MONEY_ATTRIBUTE;
		__column_names[6] = BaseCapital.CS_SELF_NAME;
		__column_names[7] = BaseCapital.CS_SELF_BANK_NAME;
		__column_names[8] = BaseCapital.CS_SELF_BANK_ACCOUNT;
		__column_names[9] = BaseCapital.CS_OTHER_NAME;
		__column_names[10] = BaseCapital.CS_OTHER_BANK_NAME;
		__column_names[11] = BaseCapital.CS_OTHER_BANK_ACCOUNT;
		__column_names[12] = BaseCapital.CS_BORROW_MONEY;
		__column_names[13] = BaseCapital.CS_LOAN_MONEY;
		__column_names[14] = BaseCapital.CS_OPERATOR;
		__column_names[15] = BaseCapital.CS_HAPPEN_DATE;
		__column_names[16] = BaseCapital.CS_CREATE_DATE;
		__column_names[17] = BaseCapital.CS_HAS_INVOICES;
		__column_names[18] = BaseCapital.CS_HAS_CONTRACT_RECEIVABLE;
		__column_names[19] = BaseCapital.CS_HAS_DISTRIBUTION_COLLECTION;
		__column_names[20] = BaseCapital.CS_REMARK;
		__column_names[21] = BaseCapital.CS_CAPITAL_TYPE;
		__column_names[22] = BaseCapital.CS_REIMBURSEMENT_PACKAGE_SUMMARY_ID;
		__column_names[23] = BaseCapital.CS_PROCESS_STATUS;
		__column_names[24] = BaseCapital.CS_CAPITAL_DISTRIBUTION_ID;
		__column_names[25] = BaseCapital.CS_HAVE_VOUCHER;
		__column_names[26] = BaseCapital.CS_PROCESS_TYPE;
		__column_names[27] = BaseCapital.CS_BUSINESS_ID;
		__column_names[28] = BaseCapital.CS_RECORD_RECEIVE_CAPITAL;
		__column_names[29] = BaseCapital.CS_EXCHANGE_RATE;
		__column_names[30] = BaseCapital.CS_ORIGINAL_CURRENCY;
		__column_names[31] = BaseCapital.CS_IS_PAYBACK;
		__column_names[32] = BaseCapital.CS_IS_HAVING_INVOICE;
		__column_names[33] = BaseCapital.CS_FILE_ID;
		__column_names[34] = BaseCapital.CS_ISSUE_DATE;
		__column_names[35] = BaseCapital.CS_EXPIRE_DATE;
		__column_names[36] = BaseCapital.CS_RECEIVE_UNIT_ID;
		__column_names[37] = BaseCapital.CS_ACTUAL_AMOUNT;
		__column_names[38] = BaseCapital.CS_ACTUAL_RECEIVE_DATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCapital b) {
		clear();
		setCapitalIdClear(b.getCapitalId());
	}

	public boolean isPrimaryKeyNull() {
		return getCapitalId() == null;
	}

	@Override
	public BaseCapital generateBase(){
		BaseCapital b = new BaseCapital();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCapital b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCapitalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSelfName(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSelfBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLoanMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setHasInvoices(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setHasContractReceivable(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setHasDistributionCollection(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCapitalType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordReceiveCapital(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOriginalCurrency(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsPayback(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsHavingInvoice(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIssueDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setExpireDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setActualAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setActualReceiveDate(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCapital b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCapitalId();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getContractId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getMoneyAttribute();
		buff[count++] = b.getSelfName();
		buff[count++] = b.getSelfBankName();
		buff[count++] = b.getSelfBankAccount();
		buff[count++] = b.getOtherName();
		buff[count++] = b.getOtherBankName();
		buff[count++] = b.getOtherBankAccount();
		buff[count++] = b.getBorrowMoney();
		buff[count++] = b.getLoanMoney();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getHappenDate());
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getHasInvoices();
		buff[count++] = b.getHasContractReceivable();
		buff[count++] = b.getHasDistributionCollection();
		buff[count++] = b.getRemark();
		buff[count++] = b.getCapitalType();
		buff[count++] = b.getReimbursementPackageSummaryId();
		buff[count++] = b.getProcessStatus();
		buff[count++] = b.getCapitalDistributionId();
		buff[count++] = b.getHaveVoucher();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getRecordReceiveCapital();
		buff[count++] = b.getExchangeRate();
		buff[count++] = b.getOriginalCurrency();
		buff[count++] = b.getIsPayback();
		buff[count++] = b.getIsHavingInvoice();
		buff[count++] = b.getFileId();
		buff[count++] = generateTimestampFromDate(b.getIssueDate());
		buff[count++] = generateTimestampFromDate(b.getExpireDate());
		buff[count++] = b.getReceiveUnitId();
		buff[count++] = b.getActualAmount();
		buff[count++] = generateTimestampFromDate(b.getActualReceiveDate());
	}

	@Override
	public void setDataFromBase(BaseCapital b){
		if(b.getCapitalId() != null) setCapitalIdClear(b.getCapitalId());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getMoneyAttribute() != null) setMoneyAttribute(b.getMoneyAttribute());
		if(b.getSelfName() != null) setSelfName(b.getSelfName());
		if(b.getSelfBankName() != null) setSelfBankName(b.getSelfBankName());
		if(b.getSelfBankAccount() != null) setSelfBankAccount(b.getSelfBankAccount());
		if(b.getOtherName() != null) setOtherName(b.getOtherName());
		if(b.getOtherBankName() != null) setOtherBankName(b.getOtherBankName());
		if(b.getOtherBankAccount() != null) setOtherBankAccount(b.getOtherBankAccount());
		if(b.getBorrowMoney() != null) setBorrowMoney(b.getBorrowMoney());
		if(b.getLoanMoney() != null) setLoanMoney(b.getLoanMoney());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getHappenDate() != null) setHappenDate(b.getHappenDate());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getHasInvoices() != null) setHasInvoices(b.getHasInvoices());
		if(b.getHasContractReceivable() != null) setHasContractReceivable(b.getHasContractReceivable());
		if(b.getHasDistributionCollection() != null) setHasDistributionCollection(b.getHasDistributionCollection());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCapitalType() != null) setCapitalType(b.getCapitalType());
		if(b.getReimbursementPackageSummaryId() != null) setReimbursementPackageSummaryId(b.getReimbursementPackageSummaryId());
		if(b.getProcessStatus() != null) setProcessStatus(b.getProcessStatus());
		if(b.getCapitalDistributionId() != null) setCapitalDistributionId(b.getCapitalDistributionId());
		if(b.getHaveVoucher() != null) setHaveVoucher(b.getHaveVoucher());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getRecordReceiveCapital() != null) setRecordReceiveCapital(b.getRecordReceiveCapital());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getOriginalCurrency() != null) setOriginalCurrency(b.getOriginalCurrency());
		if(b.getIsPayback() != null) setIsPayback(b.getIsPayback());
		if(b.getIsHavingInvoice() != null) setIsHavingInvoice(b.getIsHavingInvoice());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getIssueDate() != null) setIssueDate(b.getIssueDate());
		if(b.getExpireDate() != null) setExpireDate(b.getExpireDate());
		if(b.getReceiveUnitId() != null) setReceiveUnitId(b.getReceiveUnitId());
		if(b.getActualAmount() != null) setActualAmount(b.getActualAmount());
		if(b.getActualReceiveDate() != null) setActualReceiveDate(b.getActualReceiveDate());
	}

	@Override
	public BaseCapital generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCapital b = new BaseCapital();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCapital __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSelfName(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLoanMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasInvoices(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasContractReceivable(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasDistributionCollection(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordReceiveCapital(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalCurrency(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsPayback(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHavingInvoice(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIssueDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExpireDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActualAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActualReceiveDate(GenericBase.__getDateFromSQL(val));
	}

	public void setCapitalId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCapitalId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCapitalIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setMoneyAttribute(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getMoneyAttribute() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setSelfName(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getSelfName() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSelfBankName(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getSelfBankName() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setSelfBankAccount(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getSelfBankAccount() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setOtherName(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getOtherName() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setOtherBankName(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getOtherBankName() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setOtherBankAccount(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getOtherBankAccount() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setBorrowMoney(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getBorrowMoney() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setLoanMoney(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getLoanMoney() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setHappenDate(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getHappenDate() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setHasInvoices(java.lang.Boolean val) {
		setCurrentData(17, val);
	}

	public java.lang.Boolean getHasInvoices() {
		return GenericBase.__getBoolean(__current_data[17]);
	}

	public void setHasContractReceivable(java.lang.Boolean val) {
		setCurrentData(18, val);
	}

	public java.lang.Boolean getHasContractReceivable() {
		return GenericBase.__getBoolean(__current_data[18]);
	}

	public void setHasDistributionCollection(java.lang.Boolean val) {
		setCurrentData(19, val);
	}

	public java.lang.Boolean getHasDistributionCollection() {
		return GenericBase.__getBoolean(__current_data[19]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setCapitalType(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getCapitalType() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setReimbursementPackageSummaryId(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setProcessStatus(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getProcessStatus() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setCapitalDistributionId(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getCapitalDistributionId() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setHaveVoucher(java.lang.Boolean val) {
		setCurrentData(25, val);
	}

	public java.lang.Boolean getHaveVoucher() {
		return GenericBase.__getBoolean(__current_data[25]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setRecordReceiveCapital(java.lang.Boolean val) {
		setCurrentData(28, val);
	}

	public java.lang.Boolean getRecordReceiveCapital() {
		return GenericBase.__getBoolean(__current_data[28]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(29, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[29]);
	}

	public void setOriginalCurrency(java.math.BigDecimal val) {
		setCurrentData(30, val);
	}

	public java.math.BigDecimal getOriginalCurrency() {
		return GenericBase.__getDecimal(__current_data[30]);
	}

	public void setIsPayback(java.lang.Integer val) {
		setCurrentData(31, val);
	}

	public java.lang.Integer getIsPayback() {
		return GenericBase.__getInt(__current_data[31]);
	}

	public void setIsHavingInvoice(java.lang.Integer val) {
		setCurrentData(32, val);
	}

	public java.lang.Integer getIsHavingInvoice() {
		return GenericBase.__getInt(__current_data[32]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(33, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[33]);
	}

	public void setIssueDate(java.util.Date val) {
		setCurrentData(34, generateTimestampFromDate(val));
	}

	public java.util.Date getIssueDate() {
		return GenericBase.__getDateFromSQL(__current_data[34]);
	}

	public void setExpireDate(java.util.Date val) {
		setCurrentData(35, generateTimestampFromDate(val));
	}

	public java.util.Date getExpireDate() {
		return GenericBase.__getDateFromSQL(__current_data[35]);
	}

	public void setReceiveUnitId(java.lang.Integer val) {
		setCurrentData(36, val);
	}

	public java.lang.Integer getReceiveUnitId() {
		return GenericBase.__getInt(__current_data[36]);
	}

	public void setActualAmount(java.math.BigDecimal val) {
		setCurrentData(37, val);
	}

	public java.math.BigDecimal getActualAmount() {
		return GenericBase.__getDecimal(__current_data[37]);
	}

	public void setActualReceiveDate(java.util.Date val) {
		setCurrentData(38, generateTimestampFromDate(val));
	}

	public java.util.Date getActualReceiveDate() {
		return GenericBase.__getDateFromSQL(__current_data[38]);
	}

	public void setConditionCapitalId(String op, java.lang.Integer val) {
		setConditionCapitalId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCapitalId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMoneyAttribute(String op, java.lang.Integer val) {
		setConditionMoneyAttribute(op, val, CONDITION_AND);
	}

	public void setConditionMoneyAttribute(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMoneyAttribute(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSelfName(String op, java.lang.Integer val) {
		setConditionSelfName(op, val, CONDITION_AND);
	}

	public void setConditionSelfName(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSelfName(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSelfBankName(String op, java.lang.String val) {
		setConditionSelfBankName(op, val, CONDITION_AND);
	}

	public void setConditionSelfBankName(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSelfBankName(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSelfBankAccount(String op, java.lang.String val) {
		setConditionSelfBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionSelfBankAccount(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSelfBankAccount(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOtherName(String op, java.lang.String val) {
		setConditionOtherName(op, val, CONDITION_AND);
	}

	public void setConditionOtherName(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOtherName(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOtherBankName(String op, java.lang.String val) {
		setConditionOtherBankName(op, val, CONDITION_AND);
	}

	public void setConditionOtherBankName(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOtherBankName(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOtherBankAccount(String op, java.lang.String val) {
		setConditionOtherBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionOtherBankAccount(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectOtherBankAccount(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionBorrowMoney(String op, java.math.BigDecimal val) {
		setConditionBorrowMoney(op, val, CONDITION_AND);
	}

	public void setConditionBorrowMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectBorrowMoney(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionLoanMoney(String op, java.math.BigDecimal val) {
		setConditionLoanMoney(op, val, CONDITION_AND);
	}

	public void setConditionLoanMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectLoanMoney(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionHappenDate(String op, java.util.Date val) {
		setConditionHappenDate(op, val, CONDITION_AND);
	}

	public void setConditionHappenDate(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHappenDate(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionHasInvoices(String op, java.lang.Boolean val) {
		setConditionHasInvoices(op, val, CONDITION_AND);
	}

	public void setConditionHasInvoices(String op, java.lang.Boolean val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectHasInvoices(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionHasContractReceivable(String op, java.lang.Boolean val) {
		setConditionHasContractReceivable(op, val, CONDITION_AND);
	}

	public void setConditionHasContractReceivable(String op, java.lang.Boolean val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectHasContractReceivable(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionHasDistributionCollection(String op, java.lang.Boolean val) {
		setConditionHasDistributionCollection(op, val, CONDITION_AND);
	}

	public void setConditionHasDistributionCollection(String op, java.lang.Boolean val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectHasDistributionCollection(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionCapitalType(String op, java.lang.Integer val) {
		setConditionCapitalType(op, val, CONDITION_AND);
	}

	public void setConditionCapitalType(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectCapitalType(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionReimbursementPackageSummaryId(String op, java.lang.Integer val) {
		setConditionReimbursementPackageSummaryId(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementPackageSummaryId(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectReimbursementPackageSummaryId(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val) {
		setConditionProcessStatus(op, val, CONDITION_AND);
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectProcessStatus(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionCapitalDistributionId(String op, java.lang.Integer val) {
		setConditionCapitalDistributionId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalDistributionId(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectCapitalDistributionId(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionHaveVoucher(String op, java.lang.Boolean val) {
		setConditionHaveVoucher(op, val, CONDITION_AND);
	}

	public void setConditionHaveVoucher(String op, java.lang.Boolean val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectHaveVoucher(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionRecordReceiveCapital(String op, java.lang.Boolean val) {
		setConditionRecordReceiveCapital(op, val, CONDITION_AND);
	}

	public void setConditionRecordReceiveCapital(String op, java.lang.Boolean val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectRecordReceiveCapital(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionOriginalCurrency(String op, java.math.BigDecimal val) {
		setConditionOriginalCurrency(op, val, CONDITION_AND);
	}

	public void setConditionOriginalCurrency(String op, java.math.BigDecimal val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectOriginalCurrency(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionIsPayback(String op, java.lang.Integer val) {
		setConditionIsPayback(op, val, CONDITION_AND);
	}

	public void setConditionIsPayback(String op, java.lang.Integer val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectIsPayback(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionIsHavingInvoice(String op, java.lang.Integer val) {
		setConditionIsHavingInvoice(op, val, CONDITION_AND);
	}

	public void setConditionIsHavingInvoice(String op, java.lang.Integer val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectIsHavingInvoice(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionIssueDate(String op, java.util.Date val) {
		setConditionIssueDate(op, val, CONDITION_AND);
	}

	public void setConditionIssueDate(String op, java.util.Date val, String relation) {
		addCondition(34, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectIssueDate(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionExpireDate(String op, java.util.Date val) {
		setConditionExpireDate(op, val, CONDITION_AND);
	}

	public void setConditionExpireDate(String op, java.util.Date val, String relation) {
		addCondition(35, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectExpireDate(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionReceiveUnitId(String op, java.lang.Integer val) {
		setConditionReceiveUnitId(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitId(String op, java.lang.Integer val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectReceiveUnitId(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionActualAmount(String op, java.math.BigDecimal val) {
		setConditionActualAmount(op, val, CONDITION_AND);
	}

	public void setConditionActualAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectActualAmount(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionActualReceiveDate(String op, java.util.Date val) {
		setConditionActualReceiveDate(op, val, CONDITION_AND);
	}

	public void setConditionActualReceiveDate(String op, java.util.Date val, String relation) {
		addCondition(38, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectActualReceiveDate(boolean val) {
		__select_flags[38] = val;
	}


}

