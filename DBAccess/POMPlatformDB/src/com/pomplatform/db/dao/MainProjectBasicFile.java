package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseMainProjectBasicFile;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class MainProjectBasicFile extends AbstractTable<BaseMainProjectBasicFile>
{

	public MainProjectBasicFile() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "main_project_basic_files";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMainProjectBasicFile.CS_MAIN_PROJECT_BASIC_FILE_ID;
		__column_names[1] = BaseMainProjectBasicFile.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseMainProjectBasicFile.CS_CWD_FILE_ID;
		__column_names[3] = BaseMainProjectBasicFile.CS_OPERATOR_ID;
		__column_names[4] = BaseMainProjectBasicFile.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMainProjectBasicFile b) {
		clear();
		setMainProjectBasicFileIdClear(b.getMainProjectBasicFileId());
	}

	public boolean isPrimaryKeyNull() {
		return getMainProjectBasicFileId() == null;
	}

	@Override
	public BaseMainProjectBasicFile generateBase(){
		BaseMainProjectBasicFile b = new BaseMainProjectBasicFile();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMainProjectBasicFile b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMainProjectBasicFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseMainProjectBasicFile b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMainProjectBasicFileId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getCwdFileId();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseMainProjectBasicFile b){
		if(b.getMainProjectBasicFileId() != null) setMainProjectBasicFileIdClear(b.getMainProjectBasicFileId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseMainProjectBasicFile generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMainProjectBasicFile b = new BaseMainProjectBasicFile();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMainProjectBasicFile __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectBasicFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setMainProjectBasicFileId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMainProjectBasicFileId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMainProjectBasicFileIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setConditionMainProjectBasicFileId(String op, java.lang.Integer val) {
		setConditionMainProjectBasicFileId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectBasicFileId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMainProjectBasicFileId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val) {
		setConditionCwdFileId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFileId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCwdFileId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
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

