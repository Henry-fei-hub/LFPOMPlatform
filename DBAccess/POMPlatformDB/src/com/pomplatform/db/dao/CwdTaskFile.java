package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskFile;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskFile extends AbstractTable<BaseCwdTaskFile>
{

	public CwdTaskFile() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "cwd_task_files";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskFile.CS_CWD_TASK_FILE_ID;
		__column_names[1] = BaseCwdTaskFile.CS_CWD_TASK_MANAGE_ID;
		__column_names[2] = BaseCwdTaskFile.CS_CWD_FILE_ID;
		__column_names[3] = BaseCwdTaskFile.CS_MAIN_PROJECT_ID;
		__column_names[4] = BaseCwdTaskFile.CS_CREATE_TIME;
		__column_names[5] = BaseCwdTaskFile.CS_OPERATOR_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskFile b) {
		clear();
		setCwdTaskFileIdClear(b.getCwdTaskFileId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskFileId() == null;
	}

	@Override
	public BaseCwdTaskFile generateBase(){
		BaseCwdTaskFile b = new BaseCwdTaskFile();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskFile b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskFile b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskFileId();
		buff[count++] = b.getCwdTaskManageId();
		buff[count++] = b.getCwdFileId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOperatorId();
	}

	@Override
	public void setDataFromBase(BaseCwdTaskFile b){
		if(b.getCwdTaskFileId() != null) setCwdTaskFileIdClear(b.getCwdTaskFileId());
		if(b.getCwdTaskManageId() != null) setCwdTaskManageId(b.getCwdTaskManageId());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
	}

	@Override
	public BaseCwdTaskFile generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskFile b = new BaseCwdTaskFile();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskFile __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
	}

	public void setCwdTaskFileId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskFileId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskFileIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdTaskManageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdTaskManageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionCwdTaskFileId(String op, java.lang.Integer val) {
		setConditionCwdTaskFileId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskFileId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskFileId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val) {
		setConditionCwdTaskManageId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskManageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCwdTaskManageId(boolean val) {
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

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
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

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[5] = val;
	}


}

