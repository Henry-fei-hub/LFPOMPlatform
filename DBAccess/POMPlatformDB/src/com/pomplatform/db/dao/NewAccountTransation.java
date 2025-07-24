package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseNewAccountTransation;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class NewAccountTransation extends AbstractTable<BaseNewAccountTransation>
{

	public NewAccountTransation() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "new_account_transations";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseNewAccountTransation.CS_ACCOUNT_TRANSACTION_ID;
		__column_names[1] = BaseNewAccountTransation.CS_ACCOUNT_ID;
		__column_names[2] = BaseNewAccountTransation.CS_ORIGINAL_CURRENCY_DEBIT;
		__column_names[3] = BaseNewAccountTransation.CS_ORIGINAL_CURRENCY_LOAN;
		__column_names[4] = BaseNewAccountTransation.CS_EXCHANGE_RATE;
		__column_names[5] = BaseNewAccountTransation.CS_STANDARD_MONEY_DEBIT;
		__column_names[6] = BaseNewAccountTransation.CS_STANDARD_MONEY_LOAN;
		__column_names[7] = BaseNewAccountTransation.CS_ITEM_CATEGORY;
		__column_names[8] = BaseNewAccountTransation.CS_MAIN_PROJECT_CODE;
		__column_names[9] = BaseNewAccountTransation.CS_CONTRACT_ID;
		__column_names[10] = BaseNewAccountTransation.CS_DEPARTMENT_ID;
		__column_names[11] = BaseNewAccountTransation.CS_PLATE_ID;
		__column_names[12] = BaseNewAccountTransation.CS_EMPLOYEE_ID;
		__column_names[13] = BaseNewAccountTransation.CS_RECORD_DATE;
		__column_names[14] = BaseNewAccountTransation.CS_AFFILIATION_DATE;
		__column_names[15] = BaseNewAccountTransation.CS_REMARK;
		__column_names[16] = BaseNewAccountTransation.CS_ACCOUNT_CODE;
		__column_names[17] = BaseNewAccountTransation.CS_RUNNING_ACCOUNT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseNewAccountTransation b) {
		clear();
		setAccountTransactionIdClear(b.getAccountTransactionId());
	}

	public boolean isPrimaryKeyNull() {
		return getAccountTransactionId() == null;
	}

	@Override
	public BaseNewAccountTransation generateBase(){
		BaseNewAccountTransation b = new BaseNewAccountTransation();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseNewAccountTransation b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAccountTransactionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriginalCurrencyDebit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOriginalCurrencyLoan(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStandardMoneyDebit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStandardMoneyLoan(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setItemCategory(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAffiliationDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccountCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRunningAccount(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseNewAccountTransation b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAccountTransactionId();
		buff[count++] = b.getAccountId();
		buff[count++] = b.getOriginalCurrencyDebit();
		buff[count++] = b.getOriginalCurrencyLoan();
		buff[count++] = b.getExchangeRate();
		buff[count++] = b.getStandardMoneyDebit();
		buff[count++] = b.getStandardMoneyLoan();
		buff[count++] = b.getItemCategory();
		buff[count++] = b.getMainProjectCode();
		buff[count++] = b.getContractId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = generateTimestampFromDate(b.getAffiliationDate());
		buff[count++] = b.getRemark();
		buff[count++] = b.getAccountCode();
		buff[count++] = b.getRunningAccount();
	}

	@Override
	public void setDataFromBase(BaseNewAccountTransation b){
		if(b.getAccountTransactionId() != null) setAccountTransactionIdClear(b.getAccountTransactionId());
		if(b.getAccountId() != null) setAccountId(b.getAccountId());
		if(b.getOriginalCurrencyDebit() != null) setOriginalCurrencyDebit(b.getOriginalCurrencyDebit());
		if(b.getOriginalCurrencyLoan() != null) setOriginalCurrencyLoan(b.getOriginalCurrencyLoan());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getStandardMoneyDebit() != null) setStandardMoneyDebit(b.getStandardMoneyDebit());
		if(b.getStandardMoneyLoan() != null) setStandardMoneyLoan(b.getStandardMoneyLoan());
		if(b.getItemCategory() != null) setItemCategory(b.getItemCategory());
		if(b.getMainProjectCode() != null) setMainProjectCode(b.getMainProjectCode());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getAffiliationDate() != null) setAffiliationDate(b.getAffiliationDate());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getAccountCode() != null) setAccountCode(b.getAccountCode());
		if(b.getRunningAccount() != null) setRunningAccount(b.getRunningAccount());
	}

	@Override
	public BaseNewAccountTransation generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseNewAccountTransation b = new BaseNewAccountTransation();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseNewAccountTransation __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountTransactionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalCurrencyDebit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalCurrencyLoan(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardMoneyDebit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardMoneyLoan(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setItemCategory(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAffiliationDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRunningAccount(GenericBase.__getString(val));
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

	public void setOriginalCurrencyDebit(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getOriginalCurrencyDebit() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setOriginalCurrencyLoan(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getOriginalCurrencyLoan() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setStandardMoneyDebit(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getStandardMoneyDebit() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setStandardMoneyLoan(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getStandardMoneyLoan() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setItemCategory(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getItemCategory() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setMainProjectCode(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getMainProjectCode() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setAffiliationDate(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getAffiliationDate() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setAccountCode(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getAccountCode() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setRunningAccount(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getRunningAccount() {
		return GenericBase.__getString(__current_data[17]);
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

	public void setConditionOriginalCurrencyDebit(String op, java.math.BigDecimal val) {
		setConditionOriginalCurrencyDebit(op, val, CONDITION_AND);
	}

	public void setConditionOriginalCurrencyDebit(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOriginalCurrencyDebit(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOriginalCurrencyLoan(String op, java.math.BigDecimal val) {
		setConditionOriginalCurrencyLoan(op, val, CONDITION_AND);
	}

	public void setConditionOriginalCurrencyLoan(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOriginalCurrencyLoan(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionStandardMoneyDebit(String op, java.math.BigDecimal val) {
		setConditionStandardMoneyDebit(op, val, CONDITION_AND);
	}

	public void setConditionStandardMoneyDebit(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectStandardMoneyDebit(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStandardMoneyLoan(String op, java.math.BigDecimal val) {
		setConditionStandardMoneyLoan(op, val, CONDITION_AND);
	}

	public void setConditionStandardMoneyLoan(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStandardMoneyLoan(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionItemCategory(String op, java.lang.Integer val) {
		setConditionItemCategory(op, val, CONDITION_AND);
	}

	public void setConditionItemCategory(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectItemCategory(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMainProjectCode(String op, java.lang.String val) {
		setConditionMainProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectCode(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMainProjectCode(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionAffiliationDate(String op, java.util.Date val) {
		setConditionAffiliationDate(op, val, CONDITION_AND);
	}

	public void setConditionAffiliationDate(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAffiliationDate(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionAccountCode(String op, java.lang.String val) {
		setConditionAccountCode(op, val, CONDITION_AND);
	}

	public void setConditionAccountCode(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectAccountCode(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionRunningAccount(String op, java.lang.String val) {
		setConditionRunningAccount(op, val, CONDITION_AND);
	}

	public void setConditionRunningAccount(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectRunningAccount(boolean val) {
		__select_flags[17] = val;
	}


}

