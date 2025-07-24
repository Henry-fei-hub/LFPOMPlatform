package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFileBackup;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFileBackup extends AbstractTable<BaseCwdFileBackup>
{

	public CwdFileBackup() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "cwd_file_backups";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFileBackup.CS_FILE_BACKUP_ID;
		__column_names[1] = BaseCwdFileBackup.CS_CWD_FILE_ID;
		__column_names[2] = BaseCwdFileBackup.CS_CWD_FILE_VERSION_ID;
		__column_names[3] = BaseCwdFileBackup.CS_BACKUP_PATH;
		__column_names[4] = BaseCwdFileBackup.CS_BACKUP_TIME;
		__column_names[5] = BaseCwdFileBackup.CS_WORKPLACE_ID;
		__column_names[6] = BaseCwdFileBackup.CS_FILE_SIZE;
		__column_names[7] = BaseCwdFileBackup.CS_MD5;
		__column_names[8] = BaseCwdFileBackup.CS_CURRENT_UPLOAD_PERSON;
		__column_names[9] = BaseCwdFileBackup.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFileBackup b) {
		clear();
		setFileBackupIdClear(b.getFileBackupId());
	}

	public boolean isPrimaryKeyNull() {
		return getFileBackupId() == null;
	}

	@Override
	public BaseCwdFileBackup generateBase(){
		BaseCwdFileBackup b = new BaseCwdFileBackup();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFileBackup b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFileBackupId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileVersionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBackupPath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBackupTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setWorkplaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFileSize(GenericBase.__getLong(val));
		if((val = __current_data[count++]) != null) b.setMd5(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCurrentUploadPerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFileBackup b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFileBackupId();
		buff[count++] = b.getCwdFileId();
		buff[count++] = b.getCwdFileVersionId();
		buff[count++] = b.getBackupPath();
		buff[count++] = generateTimestampFromDate(b.getBackupTime());
		buff[count++] = b.getWorkplaceId();
		buff[count++] = b.getFileSize();
		buff[count++] = b.getMd5();
		buff[count++] = b.getCurrentUploadPerson();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCwdFileBackup b){
		if(b.getFileBackupId() != null) setFileBackupIdClear(b.getFileBackupId());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getCwdFileVersionId() != null) setCwdFileVersionId(b.getCwdFileVersionId());
		if(b.getBackupPath() != null) setBackupPath(b.getBackupPath());
		if(b.getBackupTime() != null) setBackupTime(b.getBackupTime());
		if(b.getWorkplaceId() != null) setWorkplaceId(b.getWorkplaceId());
		if(b.getFileSize() != null) setFileSize(b.getFileSize());
		if(b.getMd5() != null) setMd5(b.getMd5());
		if(b.getCurrentUploadPerson() != null) setCurrentUploadPerson(b.getCurrentUploadPerson());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCwdFileBackup generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFileBackup b = new BaseCwdFileBackup();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFileBackup __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileBackupId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileVersionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBackupPath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBackupTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkplaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileSize(GenericBase.__getLong(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMd5(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrentUploadPerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setFileBackupId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFileBackupId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFileBackupIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCwdFileVersionId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCwdFileVersionId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setBackupPath(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getBackupPath() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setBackupTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getBackupTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setWorkplaceId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getWorkplaceId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setFileSize(java.lang.Long val) {
		setCurrentData(6, val);
	}

	public java.lang.Long getFileSize() {
		return GenericBase.__getLong(__current_data[6]);
	}

	public void setMd5(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getMd5() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setCurrentUploadPerson(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getCurrentUploadPerson() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setConditionFileBackupId(String op, java.lang.Integer val) {
		setConditionFileBackupId(op, val, CONDITION_AND);
	}

	public void setConditionFileBackupId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFileBackupId(boolean val) {
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

	public void setConditionCwdFileVersionId(String op, java.lang.Integer val) {
		setConditionCwdFileVersionId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFileVersionId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCwdFileVersionId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBackupPath(String op, java.lang.String val) {
		setConditionBackupPath(op, val, CONDITION_AND);
	}

	public void setConditionBackupPath(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBackupPath(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBackupTime(String op, java.util.Date val) {
		setConditionBackupTime(op, val, CONDITION_AND);
	}

	public void setConditionBackupTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBackupTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val) {
		setConditionWorkplaceId(op, val, CONDITION_AND);
	}

	public void setConditionWorkplaceId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectWorkplaceId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionFileSize(String op, java.lang.Long val) {
		setConditionFileSize(op, val, CONDITION_AND);
	}

	public void setConditionFileSize(String op, java.lang.Long val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFileSize(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMd5(String op, java.lang.String val) {
		setConditionMd5(op, val, CONDITION_AND);
	}

	public void setConditionMd5(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMd5(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCurrentUploadPerson(String op, java.lang.Integer val) {
		setConditionCurrentUploadPerson(op, val, CONDITION_AND);
	}

	public void setConditionCurrentUploadPerson(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCurrentUploadPerson(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[9] = val;
	}


}

