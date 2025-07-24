package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseStorageArea;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class StorageArea extends AbstractTable<BaseStorageArea>
{

	public StorageArea() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "storage_areas";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseStorageArea.CS_STORAGE_AREA_ID;
		__column_names[1] = BaseStorageArea.CS_AREA_CODE;
		__column_names[2] = BaseStorageArea.CS_AREA_NAME;
		__column_names[3] = BaseStorageArea.CS_SERIAL_NUMBER;
		__column_names[4] = BaseStorageArea.CS_CREATE_EMPLOYEE_ID;
		__column_names[5] = BaseStorageArea.CS_CREATE_TIME;
		__column_names[6] = BaseStorageArea.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseStorageArea b) {
		clear();
		setStorageAreaIdClear(b.getStorageAreaId());
	}

	public boolean isPrimaryKeyNull() {
		return getStorageAreaId() == null;
	}

	@Override
	public BaseStorageArea generateBase(){
		BaseStorageArea b = new BaseStorageArea();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseStorageArea b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setStorageAreaId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAreaCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAreaName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSerialNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseStorageArea b, Object[] buff){
		int count = 0;
		buff[count++] = b.getStorageAreaId();
		buff[count++] = b.getAreaCode();
		buff[count++] = b.getAreaName();
		buff[count++] = b.getSerialNumber();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseStorageArea b){
		if(b.getStorageAreaId() != null) setStorageAreaIdClear(b.getStorageAreaId());
		if(b.getAreaCode() != null) setAreaCode(b.getAreaCode());
		if(b.getAreaName() != null) setAreaName(b.getAreaName());
		if(b.getSerialNumber() != null) setSerialNumber(b.getSerialNumber());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseStorageArea generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseStorageArea b = new BaseStorageArea();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseStorageArea __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageAreaId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setStorageAreaId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getStorageAreaId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setStorageAreaIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAreaCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getAreaCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setAreaName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getAreaName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setSerialNumber(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSerialNumber() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionStorageAreaId(String op, java.lang.Integer val) {
		setConditionStorageAreaId(op, val, CONDITION_AND);
	}

	public void setConditionStorageAreaId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectStorageAreaId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAreaCode(String op, java.lang.String val) {
		setConditionAreaCode(op, val, CONDITION_AND);
	}

	public void setConditionAreaCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAreaCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAreaName(String op, java.lang.String val) {
		setConditionAreaName(op, val, CONDITION_AND);
	}

	public void setConditionAreaName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAreaName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val) {
		setConditionSerialNumber(op, val, CONDITION_AND);
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSerialNumber(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
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

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}


}

