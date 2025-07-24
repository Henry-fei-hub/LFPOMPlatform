package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFinancialTransactionWarning;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FinancialTransactionWarning extends AbstractTable<BaseFinancialTransactionWarning>
{

	public FinancialTransactionWarning() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "financial_transaction_warnings";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFinancialTransactionWarning.CS_FINANCIAL_TRANSACTION_WARNING_ID;
		__column_names[1] = BaseFinancialTransactionWarning.CS_FINANCIAL_TRANSACTION_ACCOUNT_ID;
		__column_names[2] = BaseFinancialTransactionWarning.CS_WARNING_CONTENT;
		__column_names[3] = BaseFinancialTransactionWarning.CS_IS_ENABLED;
		__column_names[4] = BaseFinancialTransactionWarning.CS_OPERATOR_ID;
		__column_names[5] = BaseFinancialTransactionWarning.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFinancialTransactionWarning b) {
		clear();
		setFinancialTransactionWarningIdClear(b.getFinancialTransactionWarningId());
	}

	public boolean isPrimaryKeyNull() {
		return getFinancialTransactionWarningId() == null;
	}

	@Override
	public BaseFinancialTransactionWarning generateBase(){
		BaseFinancialTransactionWarning b = new BaseFinancialTransactionWarning();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFinancialTransactionWarning b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFinancialTransactionWarningId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWarningContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseFinancialTransactionWarning b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFinancialTransactionWarningId();
		buff[count++] = b.getFinancialTransactionAccountId();
		buff[count++] = b.getWarningContent();
		buff[count++] = b.getIsEnabled();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseFinancialTransactionWarning b){
		if(b.getFinancialTransactionWarningId() != null) setFinancialTransactionWarningIdClear(b.getFinancialTransactionWarningId());
		if(b.getFinancialTransactionAccountId() != null) setFinancialTransactionAccountId(b.getFinancialTransactionAccountId());
		if(b.getWarningContent() != null) setWarningContent(b.getWarningContent());
		if(b.getIsEnabled() != null) setIsEnabled(b.getIsEnabled());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseFinancialTransactionWarning generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFinancialTransactionWarning b = new BaseFinancialTransactionWarning();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFinancialTransactionWarning __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialTransactionWarningId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWarningContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setFinancialTransactionWarningId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFinancialTransactionWarningId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFinancialTransactionWarningIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFinancialTransactionAccountId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setWarningContent(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getWarningContent() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setIsEnabled(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsEnabled() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionFinancialTransactionWarningId(String op, java.lang.Integer val) {
		setConditionFinancialTransactionWarningId(op, val, CONDITION_AND);
	}

	public void setConditionFinancialTransactionWarningId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFinancialTransactionWarningId(boolean val) {
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

	public void setConditionWarningContent(String op, java.lang.String val) {
		setConditionWarningContent(op, val, CONDITION_AND);
	}

	public void setConditionWarningContent(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectWarningContent(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val) {
		setConditionIsEnabled(op, val, CONDITION_AND);
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIsEnabled(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}


}

