package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSystemInitLog;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SystemInitLog extends AbstractTable<BaseSystemInitLog>
{

	public SystemInitLog() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "system_init_logs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSystemInitLog.CS_SYSTEM_INIT_LOG_ID;
		__column_names[1] = BaseSystemInitLog.CS_TYPE;
		__column_names[2] = BaseSystemInitLog.CS_LOG_MSG;
		__column_names[3] = BaseSystemInitLog.CS_CREATE_TIME;
		__column_names[4] = BaseSystemInitLog.CS_FLAG;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSystemInitLog b) {
		clear();
		setSystemInitLogIdClear(b.getSystemInitLogId());
	}

	public boolean isPrimaryKeyNull() {
		return getSystemInitLogId() == null;
	}

	@Override
	public BaseSystemInitLog generateBase(){
		BaseSystemInitLog b = new BaseSystemInitLog();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSystemInitLog b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSystemInitLogId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLogMsg(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseSystemInitLog b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSystemInitLogId();
		buff[count++] = b.getType();
		buff[count++] = b.getLogMsg();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getFlag();
	}

	@Override
	public void setDataFromBase(BaseSystemInitLog b){
		if(b.getSystemInitLogId() != null) setSystemInitLogIdClear(b.getSystemInitLogId());
		if(b.getType() != null) setType(b.getType());
		if(b.getLogMsg() != null) setLogMsg(b.getLogMsg());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getFlag() != null) setFlag(b.getFlag());
	}

	@Override
	public BaseSystemInitLog generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSystemInitLog b = new BaseSystemInitLog();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSystemInitLog __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSystemInitLogId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogMsg(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
	}

	public void setSystemInitLogId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSystemInitLogId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSystemInitLogIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setLogMsg(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getLogMsg() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setConditionSystemInitLogId(String op, java.lang.Integer val) {
		setConditionSystemInitLogId(op, val, CONDITION_AND);
	}

	public void setConditionSystemInitLogId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSystemInitLogId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionLogMsg(String op, java.lang.String val) {
		setConditionLogMsg(op, val, CONDITION_AND);
	}

	public void setConditionLogMsg(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectLogMsg(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[4] = val;
	}


}

