package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAccountTransaction;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AccountTransaction extends AbstractTable<BaseAccountTransaction>
{

	public AccountTransaction() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "account_transactions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAccountTransaction.CS_ACCOUNT_TRANSACTION_ID;
		__column_names[1] = BaseAccountTransaction.CS_ACCOUNT_ID;
		__column_names[2] = BaseAccountTransaction.CS_BUSINESS_TYPE_ID;
		__column_names[3] = BaseAccountTransaction.CS_BUSINESS_ID;
		__column_names[4] = BaseAccountTransaction.CS_DETAIL_BUSINESS_ID;
		__column_names[5] = BaseAccountTransaction.CS_ORIGINAL_CURRENCY_DEBIT;
		__column_names[6] = BaseAccountTransaction.CS_ORIGINAL_CURRENCY_CREDIT;
		__column_names[7] = BaseAccountTransaction.CS_EXCHANGE_RATE;
		__column_names[8] = BaseAccountTransaction.CS_STANDARD_CURRENCY_DEBIT;
		__column_names[9] = BaseAccountTransaction.CS_STANDARD_CURRENCY_CREDIT;
		__column_names[10] = BaseAccountTransaction.CS_BALANCE;
		__column_names[11] = BaseAccountTransaction.CS_RECORD_TIME;
		__column_names[12] = BaseAccountTransaction.CS_OPERATE_EMPLOYEE_ID;
		__column_names[13] = BaseAccountTransaction.CS_OPERATE_TIME;
		__column_names[14] = BaseAccountTransaction.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAccountTransaction b) {
		clear();
		setAccountTransactionIdClear(b.getAccountTransactionId());
	}

	public boolean isPrimaryKeyNull() {
		return getAccountTransactionId() == null;
	}

	@Override
	public BaseAccountTransaction generateBase(){
		BaseAccountTransaction b = new BaseAccountTransaction();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAccountTransaction b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAccountTransactionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDetailBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriginalCurrencyDebit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOriginalCurrencyCredit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStandardCurrencyDebit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStandardCurrencyCredit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBalance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseAccountTransaction b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAccountTransactionId();
		buff[count++] = b.getAccountId();
		buff[count++] = b.getBusinessTypeId();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getDetailBusinessId();
		buff[count++] = b.getOriginalCurrencyDebit();
		buff[count++] = b.getOriginalCurrencyCredit();
		buff[count++] = b.getExchangeRate();
		buff[count++] = b.getStandardCurrencyDebit();
		buff[count++] = b.getStandardCurrencyCredit();
		buff[count++] = b.getBalance();
		buff[count++] = generateTimestampFromDate(b.getRecordTime());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseAccountTransaction b){
		if(b.getAccountTransactionId() != null) setAccountTransactionIdClear(b.getAccountTransactionId());
		if(b.getAccountId() != null) setAccountId(b.getAccountId());
		if(b.getBusinessTypeId() != null) setBusinessTypeId(b.getBusinessTypeId());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getDetailBusinessId() != null) setDetailBusinessId(b.getDetailBusinessId());
		if(b.getOriginalCurrencyDebit() != null) setOriginalCurrencyDebit(b.getOriginalCurrencyDebit());
		if(b.getOriginalCurrencyCredit() != null) setOriginalCurrencyCredit(b.getOriginalCurrencyCredit());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getStandardCurrencyDebit() != null) setStandardCurrencyDebit(b.getStandardCurrencyDebit());
		if(b.getStandardCurrencyCredit() != null) setStandardCurrencyCredit(b.getStandardCurrencyCredit());
		if(b.getBalance() != null) setBalance(b.getBalance());
		if(b.getRecordTime() != null) setRecordTime(b.getRecordTime());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseAccountTransaction generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAccountTransaction b = new BaseAccountTransaction();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAccountTransaction __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountTransactionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetailBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalCurrencyDebit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalCurrencyCredit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardCurrencyDebit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardCurrencyCredit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBalance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setAccountTransactionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAccountTransactionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAccountTransactionIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAccountId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAccountId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessTypeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessTypeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setDetailBusinessId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDetailBusinessId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOriginalCurrencyDebit(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getOriginalCurrencyDebit() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setOriginalCurrencyCredit(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getOriginalCurrencyCredit() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setStandardCurrencyDebit(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getStandardCurrencyDebit() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setStandardCurrencyCredit(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getStandardCurrencyCredit() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setBalance(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getBalance() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setRecordTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setConditionAccountTransactionId(String op, java.lang.Integer val) {
		setConditionAccountTransactionId(op, val, CONDITION_AND);
	}

	public void setConditionAccountTransactionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAccountTransactionId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAccountId(String op, java.lang.Integer val) {
		setConditionAccountId(op, val, CONDITION_AND);
	}

	public void setConditionAccountId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAccountId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessTypeId(String op, java.lang.Integer val) {
		setConditionBusinessTypeId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessTypeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDetailBusinessId(String op, java.lang.Integer val) {
		setConditionDetailBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionDetailBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDetailBusinessId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOriginalCurrencyDebit(String op, java.math.BigDecimal val) {
		setConditionOriginalCurrencyDebit(op, val, CONDITION_AND);
	}

	public void setConditionOriginalCurrencyDebit(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOriginalCurrencyDebit(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOriginalCurrencyCredit(String op, java.math.BigDecimal val) {
		setConditionOriginalCurrencyCredit(op, val, CONDITION_AND);
	}

	public void setConditionOriginalCurrencyCredit(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOriginalCurrencyCredit(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionStandardCurrencyDebit(String op, java.math.BigDecimal val) {
		setConditionStandardCurrencyDebit(op, val, CONDITION_AND);
	}

	public void setConditionStandardCurrencyDebit(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectStandardCurrencyDebit(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionStandardCurrencyCredit(String op, java.math.BigDecimal val) {
		setConditionStandardCurrencyCredit(op, val, CONDITION_AND);
	}

	public void setConditionStandardCurrencyCredit(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectStandardCurrencyCredit(boolean val) {
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

	public void setConditionRecordTime(String op, java.util.Date val) {
		setConditionRecordTime(op, val, CONDITION_AND);
	}

	public void setConditionRecordTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[14] = val;
	}


}

