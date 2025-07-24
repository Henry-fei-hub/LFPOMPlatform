package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFileManagesWatermark;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FileManagesWatermark extends AbstractTable<BaseFileManagesWatermark>
{

	public FileManagesWatermark() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "file_manages_watermark";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFileManagesWatermark.CS_WATERMARK_ID;
		__column_names[1] = BaseFileManagesWatermark.CS_EMPLOYEE_ID;
		__column_names[2] = BaseFileManagesWatermark.CS_FILE_ID;
		__column_names[3] = BaseFileManagesWatermark.CS_FILE_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFileManagesWatermark b) {
		clear();
		setWatermarkIdClear(b.getWatermarkId());
	}

	public boolean isPrimaryKeyNull() {
		return getWatermarkId() == null;
	}

	@Override
	public BaseFileManagesWatermark generateBase(){
		BaseFileManagesWatermark b = new BaseFileManagesWatermark();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFileManagesWatermark b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setWatermarkId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseFileManagesWatermark b, Object[] buff){
		int count = 0;
		buff[count++] = b.getWatermarkId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getFileId();
		buff[count++] = b.getFileType();
	}

	@Override
	public void setDataFromBase(BaseFileManagesWatermark b){
		if(b.getWatermarkId() != null) setWatermarkIdClear(b.getWatermarkId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getFileType() != null) setFileType(b.getFileType());
	}

	@Override
	public BaseFileManagesWatermark generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFileManagesWatermark b = new BaseFileManagesWatermark();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFileManagesWatermark __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWatermarkId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileType(GenericBase.__getInt(val));
	}

	public void setWatermarkId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getWatermarkId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setWatermarkIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setFileType(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getFileType() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setConditionWatermarkId(String op, java.lang.Integer val) {
		setConditionWatermarkId(op, val, CONDITION_AND);
	}

	public void setConditionWatermarkId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectWatermarkId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionFileType(String op, java.lang.Integer val) {
		setConditionFileType(op, val, CONDITION_AND);
	}

	public void setConditionFileType(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFileType(boolean val) {
		__select_flags[3] = val;
	}


}

