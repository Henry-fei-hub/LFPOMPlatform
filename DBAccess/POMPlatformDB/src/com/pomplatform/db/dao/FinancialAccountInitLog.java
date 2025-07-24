package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFinancialAccountInitLog;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FinancialAccountInitLog extends AbstractTable<BaseFinancialAccountInitLog>
{

	public FinancialAccountInitLog() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "financial_account_init_logs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFinancialAccountInitLog.CS_FINANCIAL_ACCOUNT_INIT_LOGS_ID;
		__column_names[1] = BaseFinancialAccountInitLog.CS_CONTENT;
		__column_names[2] = BaseFinancialAccountInitLog.CS_OPERATOR_ID;
		__column_names[3] = BaseFinancialAccountInitLog.CS_OPERATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFinancialAccountInitLog b) {
		clear();
		setFinancialAccountInitLogsIdClear(b.getFinancialAccountInitLogsId());
	}

	public boolean isPrimaryKeyNull() {
		return getFinancialAccountInitLogsId() == null;
	}

	@Override
	public BaseFinancialAccountInitLog generateBase(){
		BaseFinancialAccountInitLog b = new BaseFinancialAccountInitLog();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFinancialAccountInitLog b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFinancialAccountInitLogsId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseFinancialAccountInitLog b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFinancialAccountInitLogsId();
		buff[count++] = b.getContent();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
	}

	@Override
	public void setDataFromBase(BaseFinancialAccountInitLog b){
		if(b.getFinancialAccountInitLogsId() != null) setFinancialAccountInitLogsIdClear(b.getFinancialAccountInitLogsId());
		if(b.getContent() != null) setContent(b.getContent());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
	}

	@Override
	public BaseFinancialAccountInitLog generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFinancialAccountInitLog b = new BaseFinancialAccountInitLog();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFinancialAccountInitLog __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialAccountInitLogsId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setFinancialAccountInitLogsId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFinancialAccountInitLogsId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFinancialAccountInitLogsIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContent(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getContent() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setConditionFinancialAccountInitLogsId(String op, java.lang.Integer val) {
		setConditionFinancialAccountInitLogsId(op, val, CONDITION_AND);
	}

	public void setConditionFinancialAccountInitLogsId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFinancialAccountInitLogsId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContent(String op, java.lang.String val) {
		setConditionContent(op, val, CONDITION_AND);
	}

	public void setConditionContent(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContent(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[3] = val;
	}


}

