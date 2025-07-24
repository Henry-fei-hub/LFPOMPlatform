package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFileNumber;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FileNumber extends AbstractTable<BaseFileNumber>
{

	public FileNumber() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 2;

		initTables();

		__tableName            = "file_numbers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFileNumber.CS_FILE_NUMBER_ID;
		__column_names[1] = BaseFileNumber.CS_FILE_NUMBER_MAX;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFileNumber b) {
		clear();
		setFileNumberIdClear(b.getFileNumberId());
	}

	public boolean isPrimaryKeyNull() {
		return getFileNumberId() == null;
	}

	@Override
	public BaseFileNumber generateBase(){
		BaseFileNumber b = new BaseFileNumber();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFileNumber b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFileNumberId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileNumberMax(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseFileNumber b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFileNumberId();
		buff[count++] = b.getFileNumberMax();
	}

	@Override
	public void setDataFromBase(BaseFileNumber b){
		if(b.getFileNumberId() != null) setFileNumberIdClear(b.getFileNumberId());
		if(b.getFileNumberMax() != null) setFileNumberMax(b.getFileNumberMax());
	}

	@Override
	public BaseFileNumber generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFileNumber b = new BaseFileNumber();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFileNumber __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileNumberId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileNumberMax(GenericBase.__getInt(val));
	}

	public void setFileNumberId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFileNumberId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFileNumberIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFileNumberMax(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFileNumberMax() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setConditionFileNumberId(String op, java.lang.Integer val) {
		setConditionFileNumberId(op, val, CONDITION_AND);
	}

	public void setConditionFileNumberId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFileNumberId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFileNumberMax(String op, java.lang.Integer val) {
		setConditionFileNumberMax(op, val, CONDITION_AND);
	}

	public void setConditionFileNumberMax(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFileNumberMax(boolean val) {
		__select_flags[1] = val;
	}


}

