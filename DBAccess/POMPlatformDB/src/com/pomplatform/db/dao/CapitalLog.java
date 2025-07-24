package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCapitalLog;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CapitalLog extends AbstractTable<BaseCapitalLog>
{

	public CapitalLog() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "capital_logs";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCapitalLog.CS_CAPITAL_LOG_ID;
		__column_names[1] = BaseCapitalLog.CS_OPERATOR;
		__column_names[2] = BaseCapitalLog.CS_LOG_CONTENT;
		__column_names[3] = BaseCapitalLog.CS_CREATE_TIME;
		__column_names[4] = BaseCapitalLog.CS_CAPITAL_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCapitalLog b) {
		clear();
		setCapitalLogIdClear(b.getCapitalLogId());
	}

	public boolean isPrimaryKeyNull() {
		return getCapitalLogId() == null;
	}

	@Override
	public BaseCapitalLog generateBase(){
		BaseCapitalLog b = new BaseCapitalLog();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCapitalLog b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCapitalLogId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLogContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCapitalId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCapitalLog b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCapitalLogId();
		buff[count++] = b.getOperator();
		buff[count++] = b.getLogContent();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getCapitalId();
	}

	@Override
	public void setDataFromBase(BaseCapitalLog b){
		if(b.getCapitalLogId() != null) setCapitalLogIdClear(b.getCapitalLogId());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getLogContent() != null) setLogContent(b.getLogContent());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getCapitalId() != null) setCapitalId(b.getCapitalId());
	}

	@Override
	public BaseCapitalLog generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCapitalLog b = new BaseCapitalLog();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCapitalLog __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalLogId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalId(GenericBase.__getInt(val));
	}

	public void setCapitalLogId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCapitalLogId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCapitalLogIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setLogContent(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getLogContent() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setCapitalId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCapitalId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setConditionCapitalLogId(String op, java.lang.Integer val) {
		setConditionCapitalLogId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalLogId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCapitalLogId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionLogContent(String op, java.lang.String val) {
		setConditionLogContent(op, val, CONDITION_AND);
	}

	public void setConditionLogContent(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectLogContent(boolean val) {
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

	public void setConditionCapitalId(String op, java.lang.Integer val) {
		setConditionCapitalId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCapitalId(boolean val) {
		__select_flags[4] = val;
	}


}

