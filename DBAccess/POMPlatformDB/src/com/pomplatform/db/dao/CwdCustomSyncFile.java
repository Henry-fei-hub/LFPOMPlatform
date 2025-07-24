package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCwdCustomSyncFile;


public class CwdCustomSyncFile extends AbstractTable<BaseCwdCustomSyncFile>
{

	public CwdCustomSyncFile() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "cwd_custom_sync_files";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdCustomSyncFile.CS_CUSTOM_SYNC_FILE_ID;
		__column_names[1] = BaseCwdCustomSyncFile.CS_CWD_FILE_ID;
		__column_names[2] = BaseCwdCustomSyncFile.CS_MAIN_PROJECT_ID;
		__column_names[3] = BaseCwdCustomSyncFile.CS_EMPLOYEE_ID;
		__column_names[4] = BaseCwdCustomSyncFile.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdCustomSyncFile b) {
		clear();
		setCustomSyncFileIdClear(b.getCustomSyncFileId());
	}

	public boolean isPrimaryKeyNull() {
		return getCustomSyncFileId() == null;
	}

	@Override
	public BaseCwdCustomSyncFile generateBase(){
		BaseCwdCustomSyncFile b = new BaseCwdCustomSyncFile();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdCustomSyncFile b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCustomSyncFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdCustomSyncFile b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCustomSyncFileId();
		buff[count++] = b.getCwdFileId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdCustomSyncFile b){
		if(b.getCustomSyncFileId() != null) setCustomSyncFileIdClear(b.getCustomSyncFileId());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdCustomSyncFile generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdCustomSyncFile b = new BaseCwdCustomSyncFile();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdCustomSyncFile __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomSyncFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCustomSyncFileId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCustomSyncFileId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCustomSyncFileIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setConditionCustomSyncFileId(String op, java.lang.Integer val) {
		setConditionCustomSyncFileId(op, val, CONDITION_AND);
	}

	public void setConditionCustomSyncFileId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCustomSyncFileId(boolean val) {
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

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[4] = val;
	}


}

