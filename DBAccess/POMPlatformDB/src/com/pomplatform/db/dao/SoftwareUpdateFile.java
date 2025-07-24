package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSoftwareUpdateFile;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SoftwareUpdateFile extends AbstractTable<BaseSoftwareUpdateFile>
{

	public SoftwareUpdateFile() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "software_update_files";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSoftwareUpdateFile.CS_SOFTWARE_UPDATE_FILE_ID;
		__column_names[1] = BaseSoftwareUpdateFile.CS_TO_FILE_PATH;
		__column_names[2] = BaseSoftwareUpdateFile.CS_FILE_ID;
		__column_names[3] = BaseSoftwareUpdateFile.CS_REMARK;
		__column_names[4] = BaseSoftwareUpdateFile.CS_SOFTWARE_UPDATE_VERSION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSoftwareUpdateFile b) {
		clear();
		setSoftwareUpdateFileIdClear(b.getSoftwareUpdateFileId());
	}

	public boolean isPrimaryKeyNull() {
		return getSoftwareUpdateFileId() == null;
	}

	@Override
	public BaseSoftwareUpdateFile generateBase(){
		BaseSoftwareUpdateFile b = new BaseSoftwareUpdateFile();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSoftwareUpdateFile b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSoftwareUpdateFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setToFilePath(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSoftwareUpdateVersionId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseSoftwareUpdateFile b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSoftwareUpdateFileId();
		buff[count++] = b.getToFilePath();
		buff[count++] = b.getFileId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getSoftwareUpdateVersionId();
	}

	@Override
	public void setDataFromBase(BaseSoftwareUpdateFile b){
		if(b.getSoftwareUpdateFileId() != null) setSoftwareUpdateFileIdClear(b.getSoftwareUpdateFileId());
		if(b.getToFilePath() != null) setToFilePath(b.getToFilePath());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getSoftwareUpdateVersionId() != null) setSoftwareUpdateVersionId(b.getSoftwareUpdateVersionId());
	}

	@Override
	public BaseSoftwareUpdateFile generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSoftwareUpdateFile b = new BaseSoftwareUpdateFile();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSoftwareUpdateFile __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSoftwareUpdateFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setToFilePath(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSoftwareUpdateVersionId(GenericBase.__getInt(val));
	}

	public void setSoftwareUpdateFileId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSoftwareUpdateFileId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSoftwareUpdateFileIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setToFilePath(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getToFilePath() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setSoftwareUpdateVersionId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getSoftwareUpdateVersionId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setConditionSoftwareUpdateFileId(String op, java.lang.Integer val) {
		setConditionSoftwareUpdateFileId(op, val, CONDITION_AND);
	}

	public void setConditionSoftwareUpdateFileId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSoftwareUpdateFileId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionToFilePath(String op, java.lang.String val) {
		setConditionToFilePath(op, val, CONDITION_AND);
	}

	public void setConditionToFilePath(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectToFilePath(boolean val) {
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

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSoftwareUpdateVersionId(String op, java.lang.Integer val) {
		setConditionSoftwareUpdateVersionId(op, val, CONDITION_AND);
	}

	public void setConditionSoftwareUpdateVersionId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSoftwareUpdateVersionId(boolean val) {
		__select_flags[4] = val;
	}


}

