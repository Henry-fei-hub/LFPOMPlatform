package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFileUpdateLog;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFileUpdateLog extends AbstractTable<BaseCwdFileUpdateLog>
{

	public CwdFileUpdateLog() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "cwd_file_update_logs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFileUpdateLog.CS_FILE_UPDATE_LOG_ID;
		__column_names[1] = BaseCwdFileUpdateLog.CS_CWD_FILE_ID;
		__column_names[2] = BaseCwdFileUpdateLog.CS_BEGIN_TIME;
		__column_names[3] = BaseCwdFileUpdateLog.CS_END_TIME;
		__column_names[4] = BaseCwdFileUpdateLog.CS_OPERATOR;
		__column_names[5] = BaseCwdFileUpdateLog.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFileUpdateLog b) {
		clear();
		setFileUpdateLogIdClear(b.getFileUpdateLogId());
	}

	public boolean isPrimaryKeyNull() {
		return getFileUpdateLogId() == null;
	}

	@Override
	public BaseCwdFileUpdateLog generateBase(){
		BaseCwdFileUpdateLog b = new BaseCwdFileUpdateLog();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFileUpdateLog b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFileUpdateLogId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBeginTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFileUpdateLog b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFileUpdateLogId();
		buff[count++] = b.getCwdFileId();
		buff[count++] = generateTimestampFromDate(b.getBeginTime());
		buff[count++] = generateTimestampFromDate(b.getEndTime());
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdFileUpdateLog b){
		if(b.getFileUpdateLogId() != null) setFileUpdateLogIdClear(b.getFileUpdateLogId());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getBeginTime() != null) setBeginTime(b.getBeginTime());
		if(b.getEndTime() != null) setEndTime(b.getEndTime());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdFileUpdateLog generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFileUpdateLog b = new BaseCwdFileUpdateLog();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFileUpdateLog __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileUpdateLogId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBeginTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setFileUpdateLogId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFileUpdateLogId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFileUpdateLogIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBeginTime(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getBeginTime() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setEndTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionFileUpdateLogId(String op, java.lang.Integer val) {
		setConditionFileUpdateLogId(op, val, CONDITION_AND);
	}

	public void setConditionFileUpdateLogId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFileUpdateLogId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val) {
		setConditionCwdFileId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCwdFileId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBeginTime(String op, java.util.Date val) {
		setConditionBeginTime(op, val, CONDITION_AND);
	}

	public void setConditionBeginTime(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBeginTime(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEndTime(String op, java.util.Date val) {
		setConditionEndTime(op, val, CONDITION_AND);
	}

	public void setConditionEndTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
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

