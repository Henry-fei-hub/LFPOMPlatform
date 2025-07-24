package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTransaction;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Transaction extends AbstractTable<BaseTransaction>
{

	public Transaction() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 36;

		initTables();

		__tableName            = "transactions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTransaction.CS_TRANSACTION_ID;
		__column_names[1] = BaseTransaction.CS_ACCOUNT;
		__column_names[2] = BaseTransaction.CS_ACCOUNT_ID;
		__column_names[3] = BaseTransaction.CS_TRANSACTION_TIME;
		__column_names[4] = BaseTransaction.CS_VALUE_OF_DATE;
		__column_names[5] = BaseTransaction.CS_TRANSACTION_TYPE;
		__column_names[6] = BaseTransaction.CS_TRANSACTION_ABSTRACT;
		__column_names[7] = BaseTransaction.CS_DEBIT_AMOUNT;
		__column_names[8] = BaseTransaction.CS_CREDIT_AMOUNT;
		__column_names[9] = BaseTransaction.CS_DEBIT_CREDIT_FLAG;
		__column_names[10] = BaseTransaction.CS_BALANCE;
		__column_names[11] = BaseTransaction.CS_SEQUENCE_NUMBER;
		__column_names[12] = BaseTransaction.CS_PROCESS_INSTANCE_ID;
		__column_names[13] = BaseTransaction.CS_BUSINESS_NAME;
		__column_names[14] = BaseTransaction.CS_USAGE;
		__column_names[15] = BaseTransaction.CS_REFERENCE_ID;
		__column_names[16] = BaseTransaction.CS_BUSINESS_ABSTRACT;
		__column_names[17] = BaseTransaction.CS_OTHER_ABSTRACT;
		__column_names[18] = BaseTransaction.CS_PAYMENT_ACCOUNT_AREA;
		__column_names[19] = BaseTransaction.CS_PAYMENT_ACCOUNT;
		__column_names[20] = BaseTransaction.CS_PAYMENT_ACCOUNT_NAME;
		__column_names[21] = BaseTransaction.CS_PAYMENT_ACCOUNT_BRANCH_ID;
		__column_names[22] = BaseTransaction.CS_PAYMENT_ACCOUNT_BRANCH_NAME;
		__column_names[23] = BaseTransaction.CS_PAYMENT_ACCOUNT_BRANCH_ADDRESS;
		__column_names[24] = BaseTransaction.CS_PARENT_ACCOUNT_AREA;
		__column_names[25] = BaseTransaction.CS_PARENT_ACCOUNT;
		__column_names[26] = BaseTransaction.CS_PARENT_ACCOUNT_NAME;
		__column_names[27] = BaseTransaction.CS_INFORMATION_FLAG;
		__column_names[28] = BaseTransaction.CS_HAS_ATTACHMENT;
		__column_names[29] = BaseTransaction.CS_ATTACHMENT_FLAG;
		__column_names[30] = BaseTransaction.CS_CHECK_NO;
		__column_names[31] = BaseTransaction.CS_REVERSAL_FLAG;
		__column_names[32] = BaseTransaction.CS_EXTEND_ABSTRACT;
		__column_names[33] = BaseTransaction.CS_TRANSACTION_ANALYSIS_CODE;
		__column_names[34] = BaseTransaction.CS_BUSINESS_PAYMENT_ORDER_ID;
		__column_names[35] = BaseTransaction.CS_ENTERPRISE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTransaction b) {
		clear();
		setTransactionIdClear(b.getTransactionId());
	}

	public boolean isPrimaryKeyNull() {
		return getTransactionId() == null;
	}

	@Override
	public BaseTransaction generateBase(){
		BaseTransaction b = new BaseTransaction();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTransaction b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTransactionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTransactionTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setValueOfDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTransactionType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTransactionAbstract(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDebitAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreditAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDebitCreditFlag(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBalance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSequenceNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUsage(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReferenceId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessAbstract(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherAbstract(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentAccountArea(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentAccountName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentAccountBranchId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentAccountBranchName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPaymentAccountBranchAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentAccountArea(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setParentAccountName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInformationFlag(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setHasAttachment(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentFlag(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCheckNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReversalFlag(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setExtendAbstract(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTransactionAnalysisCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessPaymentOrderId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEnterpriseId(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseTransaction b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTransactionId();
		buff[count++] = b.getAccount();
		buff[count++] = b.getAccountId();
		buff[count++] = generateTimestampFromDate(b.getTransactionTime());
		buff[count++] = generateTimestampFromDate(b.getValueOfDate());
		buff[count++] = b.getTransactionType();
		buff[count++] = b.getTransactionAbstract();
		buff[count++] = b.getDebitAmount();
		buff[count++] = b.getCreditAmount();
		buff[count++] = b.getDebitCreditFlag();
		buff[count++] = b.getBalance();
		buff[count++] = b.getSequenceNumber();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getBusinessName();
		buff[count++] = b.getUsage();
		buff[count++] = b.getReferenceId();
		buff[count++] = b.getBusinessAbstract();
		buff[count++] = b.getOtherAbstract();
		buff[count++] = b.getPaymentAccountArea();
		buff[count++] = b.getPaymentAccount();
		buff[count++] = b.getPaymentAccountName();
		buff[count++] = b.getPaymentAccountBranchId();
		buff[count++] = b.getPaymentAccountBranchName();
		buff[count++] = b.getPaymentAccountBranchAddress();
		buff[count++] = b.getParentAccountArea();
		buff[count++] = b.getParentAccount();
		buff[count++] = b.getParentAccountName();
		buff[count++] = b.getInformationFlag();
		buff[count++] = b.getHasAttachment();
		buff[count++] = b.getAttachmentFlag();
		buff[count++] = b.getCheckNo();
		buff[count++] = b.getReversalFlag();
		buff[count++] = b.getExtendAbstract();
		buff[count++] = b.getTransactionAnalysisCode();
		buff[count++] = b.getBusinessPaymentOrderId();
		buff[count++] = b.getEnterpriseId();
	}

	@Override
	public void setDataFromBase(BaseTransaction b){
		if(b.getTransactionId() != null) setTransactionIdClear(b.getTransactionId());
		if(b.getAccount() != null) setAccount(b.getAccount());
		if(b.getAccountId() != null) setAccountId(b.getAccountId());
		if(b.getTransactionTime() != null) setTransactionTime(b.getTransactionTime());
		if(b.getValueOfDate() != null) setValueOfDate(b.getValueOfDate());
		if(b.getTransactionType() != null) setTransactionType(b.getTransactionType());
		if(b.getTransactionAbstract() != null) setTransactionAbstract(b.getTransactionAbstract());
		if(b.getDebitAmount() != null) setDebitAmount(b.getDebitAmount());
		if(b.getCreditAmount() != null) setCreditAmount(b.getCreditAmount());
		if(b.getDebitCreditFlag() != null) setDebitCreditFlag(b.getDebitCreditFlag());
		if(b.getBalance() != null) setBalance(b.getBalance());
		if(b.getSequenceNumber() != null) setSequenceNumber(b.getSequenceNumber());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getBusinessName() != null) setBusinessName(b.getBusinessName());
		if(b.getUsage() != null) setUsage(b.getUsage());
		if(b.getReferenceId() != null) setReferenceId(b.getReferenceId());
		if(b.getBusinessAbstract() != null) setBusinessAbstract(b.getBusinessAbstract());
		if(b.getOtherAbstract() != null) setOtherAbstract(b.getOtherAbstract());
		if(b.getPaymentAccountArea() != null) setPaymentAccountArea(b.getPaymentAccountArea());
		if(b.getPaymentAccount() != null) setPaymentAccount(b.getPaymentAccount());
		if(b.getPaymentAccountName() != null) setPaymentAccountName(b.getPaymentAccountName());
		if(b.getPaymentAccountBranchId() != null) setPaymentAccountBranchId(b.getPaymentAccountBranchId());
		if(b.getPaymentAccountBranchName() != null) setPaymentAccountBranchName(b.getPaymentAccountBranchName());
		if(b.getPaymentAccountBranchAddress() != null) setPaymentAccountBranchAddress(b.getPaymentAccountBranchAddress());
		if(b.getParentAccountArea() != null) setParentAccountArea(b.getParentAccountArea());
		if(b.getParentAccount() != null) setParentAccount(b.getParentAccount());
		if(b.getParentAccountName() != null) setParentAccountName(b.getParentAccountName());
		if(b.getInformationFlag() != null) setInformationFlag(b.getInformationFlag());
		if(b.getHasAttachment() != null) setHasAttachment(b.getHasAttachment());
		if(b.getAttachmentFlag() != null) setAttachmentFlag(b.getAttachmentFlag());
		if(b.getCheckNo() != null) setCheckNo(b.getCheckNo());
		if(b.getReversalFlag() != null) setReversalFlag(b.getReversalFlag());
		if(b.getExtendAbstract() != null) setExtendAbstract(b.getExtendAbstract());
		if(b.getTransactionAnalysisCode() != null) setTransactionAnalysisCode(b.getTransactionAnalysisCode());
		if(b.getBusinessPaymentOrderId() != null) setBusinessPaymentOrderId(b.getBusinessPaymentOrderId());
		if(b.getEnterpriseId() != null) setEnterpriseId(b.getEnterpriseId());
	}

	@Override
	public BaseTransaction generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTransaction b = new BaseTransaction();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTransaction __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransactionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransactionTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setValueOfDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransactionType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransactionAbstract(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDebitAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreditAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDebitCreditFlag(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBalance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSequenceNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUsage(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReferenceId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessAbstract(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherAbstract(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentAccountArea(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentAccountName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentAccountBranchId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentAccountBranchName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentAccountBranchAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentAccountArea(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentAccountName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInformationFlag(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasAttachment(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentFlag(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReversalFlag(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExtendAbstract(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransactionAnalysisCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessPaymentOrderId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEnterpriseId(GenericBase.__getString(val));
	}

	public void setTransactionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTransactionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTransactionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAccount(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getAccount() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setAccountId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getAccountId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setTransactionTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getTransactionTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setValueOfDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getValueOfDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setTransactionType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getTransactionType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setTransactionAbstract(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getTransactionAbstract() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setDebitAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getDebitAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setCreditAmount(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getCreditAmount() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setDebitCreditFlag(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getDebitCreditFlag() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setBalance(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getBalance() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setSequenceNumber(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getSequenceNumber() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setProcessInstanceId(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getProcessInstanceId() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setBusinessName(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getBusinessName() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setUsage(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getUsage() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setReferenceId(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getReferenceId() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setBusinessAbstract(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getBusinessAbstract() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setOtherAbstract(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getOtherAbstract() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setPaymentAccountArea(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getPaymentAccountArea() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setPaymentAccount(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getPaymentAccount() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setPaymentAccountName(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getPaymentAccountName() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setPaymentAccountBranchId(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getPaymentAccountBranchId() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setPaymentAccountBranchName(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getPaymentAccountBranchName() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setPaymentAccountBranchAddress(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getPaymentAccountBranchAddress() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setParentAccountArea(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getParentAccountArea() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setParentAccount(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getParentAccount() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setParentAccountName(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getParentAccountName() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setInformationFlag(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getInformationFlag() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setHasAttachment(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getHasAttachment() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setAttachmentFlag(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getAttachmentFlag() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setCheckNo(java.lang.String val) {
		setCurrentData(30, val);
	}

	public java.lang.String getCheckNo() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setReversalFlag(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getReversalFlag() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setExtendAbstract(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getExtendAbstract() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setTransactionAnalysisCode(java.lang.String val) {
		setCurrentData(33, val);
	}

	public java.lang.String getTransactionAnalysisCode() {
		return GenericBase.__getString(__current_data[33]);
	}

	public void setBusinessPaymentOrderId(java.lang.String val) {
		setCurrentData(34, val);
	}

	public java.lang.String getBusinessPaymentOrderId() {
		return GenericBase.__getString(__current_data[34]);
	}

	public void setEnterpriseId(java.lang.String val) {
		setCurrentData(35, val);
	}

	public java.lang.String getEnterpriseId() {
		return GenericBase.__getString(__current_data[35]);
	}

	public void setConditionTransactionId(String op, java.lang.Integer val) {
		setConditionTransactionId(op, val, CONDITION_AND);
	}

	public void setConditionTransactionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTransactionId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAccount(String op, java.lang.String val) {
		setConditionAccount(op, val, CONDITION_AND);
	}

	public void setConditionAccount(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAccount(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAccountId(String op, java.lang.Integer val) {
		setConditionAccountId(op, val, CONDITION_AND);
	}

	public void setConditionAccountId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAccountId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTransactionTime(String op, java.util.Date val) {
		setConditionTransactionTime(op, val, CONDITION_AND);
	}

	public void setConditionTransactionTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectTransactionTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionValueOfDate(String op, java.util.Date val) {
		setConditionValueOfDate(op, val, CONDITION_AND);
	}

	public void setConditionValueOfDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectValueOfDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionTransactionType(String op, java.lang.Integer val) {
		setConditionTransactionType(op, val, CONDITION_AND);
	}

	public void setConditionTransactionType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTransactionType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionTransactionAbstract(String op, java.lang.String val) {
		setConditionTransactionAbstract(op, val, CONDITION_AND);
	}

	public void setConditionTransactionAbstract(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectTransactionAbstract(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDebitAmount(String op, java.math.BigDecimal val) {
		setConditionDebitAmount(op, val, CONDITION_AND);
	}

	public void setConditionDebitAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDebitAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreditAmount(String op, java.math.BigDecimal val) {
		setConditionCreditAmount(op, val, CONDITION_AND);
	}

	public void setConditionCreditAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCreditAmount(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionDebitCreditFlag(String op, java.lang.String val) {
		setConditionDebitCreditFlag(op, val, CONDITION_AND);
	}

	public void setConditionDebitCreditFlag(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectDebitCreditFlag(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionBalance(String op, java.math.BigDecimal val) {
		setConditionBalance(op, val, CONDITION_AND);
	}

	public void setConditionBalance(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectBalance(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSequenceNumber(String op, java.lang.String val) {
		setConditionSequenceNumber(op, val, CONDITION_AND);
	}

	public void setConditionSequenceNumber(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSequenceNumber(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.String val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionBusinessName(String op, java.lang.String val) {
		setConditionBusinessName(op, val, CONDITION_AND);
	}

	public void setConditionBusinessName(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectBusinessName(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionUsage(String op, java.lang.String val) {
		setConditionUsage(op, val, CONDITION_AND);
	}

	public void setConditionUsage(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectUsage(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionReferenceId(String op, java.lang.String val) {
		setConditionReferenceId(op, val, CONDITION_AND);
	}

	public void setConditionReferenceId(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectReferenceId(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionBusinessAbstract(String op, java.lang.String val) {
		setConditionBusinessAbstract(op, val, CONDITION_AND);
	}

	public void setConditionBusinessAbstract(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectBusinessAbstract(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionOtherAbstract(String op, java.lang.String val) {
		setConditionOtherAbstract(op, val, CONDITION_AND);
	}

	public void setConditionOtherAbstract(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectOtherAbstract(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionPaymentAccountArea(String op, java.lang.String val) {
		setConditionPaymentAccountArea(op, val, CONDITION_AND);
	}

	public void setConditionPaymentAccountArea(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectPaymentAccountArea(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionPaymentAccount(String op, java.lang.String val) {
		setConditionPaymentAccount(op, val, CONDITION_AND);
	}

	public void setConditionPaymentAccount(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectPaymentAccount(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionPaymentAccountName(String op, java.lang.String val) {
		setConditionPaymentAccountName(op, val, CONDITION_AND);
	}

	public void setConditionPaymentAccountName(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectPaymentAccountName(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionPaymentAccountBranchId(String op, java.lang.String val) {
		setConditionPaymentAccountBranchId(op, val, CONDITION_AND);
	}

	public void setConditionPaymentAccountBranchId(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectPaymentAccountBranchId(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionPaymentAccountBranchName(String op, java.lang.String val) {
		setConditionPaymentAccountBranchName(op, val, CONDITION_AND);
	}

	public void setConditionPaymentAccountBranchName(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectPaymentAccountBranchName(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionPaymentAccountBranchAddress(String op, java.lang.String val) {
		setConditionPaymentAccountBranchAddress(op, val, CONDITION_AND);
	}

	public void setConditionPaymentAccountBranchAddress(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectPaymentAccountBranchAddress(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionParentAccountArea(String op, java.lang.String val) {
		setConditionParentAccountArea(op, val, CONDITION_AND);
	}

	public void setConditionParentAccountArea(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectParentAccountArea(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionParentAccount(String op, java.lang.String val) {
		setConditionParentAccount(op, val, CONDITION_AND);
	}

	public void setConditionParentAccount(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectParentAccount(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionParentAccountName(String op, java.lang.String val) {
		setConditionParentAccountName(op, val, CONDITION_AND);
	}

	public void setConditionParentAccountName(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectParentAccountName(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionInformationFlag(String op, java.lang.String val) {
		setConditionInformationFlag(op, val, CONDITION_AND);
	}

	public void setConditionInformationFlag(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectInformationFlag(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionHasAttachment(String op, java.lang.String val) {
		setConditionHasAttachment(op, val, CONDITION_AND);
	}

	public void setConditionHasAttachment(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectHasAttachment(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionAttachmentFlag(String op, java.lang.String val) {
		setConditionAttachmentFlag(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentFlag(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectAttachmentFlag(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionCheckNo(String op, java.lang.String val) {
		setConditionCheckNo(op, val, CONDITION_AND);
	}

	public void setConditionCheckNo(String op, java.lang.String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectCheckNo(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionReversalFlag(String op, java.lang.String val) {
		setConditionReversalFlag(op, val, CONDITION_AND);
	}

	public void setConditionReversalFlag(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectReversalFlag(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionExtendAbstract(String op, java.lang.String val) {
		setConditionExtendAbstract(op, val, CONDITION_AND);
	}

	public void setConditionExtendAbstract(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectExtendAbstract(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionTransactionAnalysisCode(String op, java.lang.String val) {
		setConditionTransactionAnalysisCode(op, val, CONDITION_AND);
	}

	public void setConditionTransactionAnalysisCode(String op, java.lang.String val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectTransactionAnalysisCode(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionBusinessPaymentOrderId(String op, java.lang.String val) {
		setConditionBusinessPaymentOrderId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessPaymentOrderId(String op, java.lang.String val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectBusinessPaymentOrderId(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionEnterpriseId(String op, java.lang.String val) {
		setConditionEnterpriseId(op, val, CONDITION_AND);
	}

	public void setConditionEnterpriseId(String op, java.lang.String val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectEnterpriseId(boolean val) {
		__select_flags[35] = val;
	}


}

