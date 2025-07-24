package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseFinancialTransactionDetail;


public class FinancialTransactionDetail extends AbstractTable<BaseFinancialTransactionDetail>
{

	public FinancialTransactionDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 21;

		initTables();

		__tableName            = "financial_transaction_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFinancialTransactionDetail.CS_FINANCIAL_TRANSACTION_DETAIL_ID;
		__column_names[1] = BaseFinancialTransactionDetail.CS_FINANCIAL_TRANSACTION_ACCOUNT_ID;
		__column_names[2] = BaseFinancialTransactionDetail.CS_RECORD_DATE;
		__column_names[3] = BaseFinancialTransactionDetail.CS_SUMMARY;
		__column_names[4] = BaseFinancialTransactionDetail.CS_CURRENCY_TYPE;
		__column_names[5] = BaseFinancialTransactionDetail.CS_ORIGINAL_DEBIT;
		__column_names[6] = BaseFinancialTransactionDetail.CS_ORIGINAL_CREDIT;
		__column_names[7] = BaseFinancialTransactionDetail.CS_EXCHANGE_RATE;
		__column_names[8] = BaseFinancialTransactionDetail.CS_STANDARD_DEBIT;
		__column_names[9] = BaseFinancialTransactionDetail.CS_STANDARD_CREDIT;
		__column_names[10] = BaseFinancialTransactionDetail.CS_OPERATOR_ACCOUNT_ID;
		__column_names[11] = BaseFinancialTransactionDetail.CS_IS_LOCKED;
		__column_names[12] = BaseFinancialTransactionDetail.CS_IS_HUMAN_ADD;
		__column_names[13] = BaseFinancialTransactionDetail.CS_PROCESS_TYPE;
		__column_names[14] = BaseFinancialTransactionDetail.CS_BUSINESS_ID;
		__column_names[15] = BaseFinancialTransactionDetail.CS_PROCESS_INSTANCE_ID;
		__column_names[16] = BaseFinancialTransactionDetail.CS_PROCESS_BILL_LIST_ID;
		__column_names[17] = BaseFinancialTransactionDetail.CS_IS_COMPLETED;
		__column_names[18] = BaseFinancialTransactionDetail.CS_CREATE_TIME;
		__column_names[19] = BaseFinancialTransactionDetail.CS_DELETE_FLAG;
		__column_names[20] = BaseFinancialTransactionDetail.CS_COMPANY_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFinancialTransactionDetail b) {
		clear();
		setFinancialTransactionDetailIdClear(b.getFinancialTransactionDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getFinancialTransactionDetailId() == null;
	}

	@Override
	public BaseFinancialTransactionDetail generateBase(){
		BaseFinancialTransactionDetail b = new BaseFinancialTransactionDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFinancialTransactionDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFinancialTransactionDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSummary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCurrencyType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOriginalDebit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOriginalCredit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStandardDebit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStandardCredit(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperatorAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsLocked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsHumanAdd(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessBillListId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseFinancialTransactionDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFinancialTransactionDetailId();
		buff[count++] = b.getFinancialTransactionAccountId();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getSummary();
		buff[count++] = b.getCurrencyType();
		buff[count++] = b.getOriginalDebit();
		buff[count++] = b.getOriginalCredit();
		buff[count++] = b.getExchangeRate();
		buff[count++] = b.getStandardDebit();
		buff[count++] = b.getStandardCredit();
		buff[count++] = b.getOperatorAccountId();
		buff[count++] = b.getIsLocked();
		buff[count++] = b.getIsHumanAdd();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getProcessInstanceId();
		buff[count++] = b.getProcessBillListId();
		buff[count++] = b.getIsCompleted();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getCompanyId();
	}

	@Override
	public void setDataFromBase(BaseFinancialTransactionDetail b){
		if(b.getFinancialTransactionDetailId() != null) setFinancialTransactionDetailIdClear(b.getFinancialTransactionDetailId());
		if(b.getFinancialTransactionAccountId() != null) setFinancialTransactionAccountId(b.getFinancialTransactionAccountId());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getSummary() != null) setSummary(b.getSummary());
		if(b.getCurrencyType() != null) setCurrencyType(b.getCurrencyType());
		if(b.getOriginalDebit() != null) setOriginalDebit(b.getOriginalDebit());
		if(b.getOriginalCredit() != null) setOriginalCredit(b.getOriginalCredit());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getStandardDebit() != null) setStandardDebit(b.getStandardDebit());
		if(b.getStandardCredit() != null) setStandardCredit(b.getStandardCredit());
		if(b.getOperatorAccountId() != null) setOperatorAccountId(b.getOperatorAccountId());
		if(b.getIsLocked() != null) setIsLocked(b.getIsLocked());
		if(b.getIsHumanAdd() != null) setIsHumanAdd(b.getIsHumanAdd());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getProcessInstanceId() != null) setProcessInstanceId(b.getProcessInstanceId());
		if(b.getProcessBillListId() != null) setProcessBillListId(b.getProcessBillListId());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
	}

	@Override
	public BaseFinancialTransactionDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFinancialTransactionDetail b = new BaseFinancialTransactionDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFinancialTransactionDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialTransactionDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSummary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrencyType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalDebit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOriginalCredit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardDebit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStandardCredit(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHumanAdd(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessBillListId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
	}

	public void setFinancialTransactionDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFinancialTransactionDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFinancialTransactionDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFinancialTransactionAccountId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setSummary(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getSummary() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCurrencyType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCurrencyType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOriginalDebit(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getOriginalDebit() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setOriginalCredit(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getOriginalCredit() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setStandardDebit(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getStandardDebit() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setStandardCredit(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getStandardCredit() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setOperatorAccountId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOperatorAccountId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setIsLocked(java.lang.Boolean val) {
		setCurrentData(11, val);
	}

	public java.lang.Boolean getIsLocked() {
		return GenericBase.__getBoolean(__current_data[11]);
	}

	public void setIsHumanAdd(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getIsHumanAdd() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setProcessInstanceId(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getProcessInstanceId() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setProcessBillListId(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getProcessBillListId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(17, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[17]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setConditionFinancialTransactionDetailId(String op, java.lang.Integer val) {
		setConditionFinancialTransactionDetailId(op, val, CONDITION_AND);
	}

	public void setConditionFinancialTransactionDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFinancialTransactionDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFinancialTransactionAccountId(String op, java.lang.Integer val) {
		setConditionFinancialTransactionAccountId(op, val, CONDITION_AND);
	}

	public void setConditionFinancialTransactionAccountId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFinancialTransactionAccountId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSummary(String op, java.lang.String val) {
		setConditionSummary(op, val, CONDITION_AND);
	}

	public void setConditionSummary(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSummary(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCurrencyType(String op, java.lang.Integer val) {
		setConditionCurrencyType(op, val, CONDITION_AND);
	}

	public void setConditionCurrencyType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCurrencyType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOriginalDebit(String op, java.math.BigDecimal val) {
		setConditionOriginalDebit(op, val, CONDITION_AND);
	}

	public void setConditionOriginalDebit(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOriginalDebit(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOriginalCredit(String op, java.math.BigDecimal val) {
		setConditionOriginalCredit(op, val, CONDITION_AND);
	}

	public void setConditionOriginalCredit(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOriginalCredit(boolean val) {
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

	public void setConditionStandardDebit(String op, java.math.BigDecimal val) {
		setConditionStandardDebit(op, val, CONDITION_AND);
	}

	public void setConditionStandardDebit(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectStandardDebit(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionStandardCredit(String op, java.math.BigDecimal val) {
		setConditionStandardCredit(op, val, CONDITION_AND);
	}

	public void setConditionStandardCredit(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectStandardCredit(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperatorAccountId(String op, java.lang.Integer val) {
		setConditionOperatorAccountId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorAccountId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOperatorAccountId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val) {
		setConditionIsLocked(op, val, CONDITION_AND);
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectIsLocked(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionIsHumanAdd(String op, java.lang.Boolean val) {
		setConditionIsHumanAdd(op, val, CONDITION_AND);
	}

	public void setConditionIsHumanAdd(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIsHumanAdd(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val) {
		setConditionProcessInstanceId(op, val, CONDITION_AND);
	}

	public void setConditionProcessInstanceId(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectProcessInstanceId(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionProcessBillListId(String op, java.lang.Integer val) {
		setConditionProcessBillListId(op, val, CONDITION_AND);
	}

	public void setConditionProcessBillListId(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectProcessBillListId(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[20] = val;
	}


}

