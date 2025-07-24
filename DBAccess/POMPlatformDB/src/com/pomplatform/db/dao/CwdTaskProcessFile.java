package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdTaskProcessFile;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdTaskProcessFile extends AbstractTable<BaseCwdTaskProcessFile>
{

	public CwdTaskProcessFile() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "cwd_task_process_files";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdTaskProcessFile.CS_CWD_TASK_PROCESS_FILE_ID;
		__column_names[1] = BaseCwdTaskProcessFile.CS_CWD_TASK_PROCESS_ID;
		__column_names[2] = BaseCwdTaskProcessFile.CS_CWD_FILE_ID;
		__column_names[3] = BaseCwdTaskProcessFile.CS_CWD_FILING_MANAGE_DETAIL_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdTaskProcessFile b) {
		clear();
		setCwdTaskProcessFileIdClear(b.getCwdTaskProcessFileId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdTaskProcessFileId() == null;
	}

	@Override
	public BaseCwdTaskProcessFile generateBase(){
		BaseCwdTaskProcessFile b = new BaseCwdTaskProcessFile();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdTaskProcessFile b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdTaskProcessFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdTaskProcessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFilingManageDetailId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdTaskProcessFile b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdTaskProcessFileId();
		buff[count++] = b.getCwdTaskProcessId();
		buff[count++] = b.getCwdFileId();
		buff[count++] = b.getCwdFilingManageDetailId();
	}

	@Override
	public void setDataFromBase(BaseCwdTaskProcessFile b){
		if(b.getCwdTaskProcessFileId() != null) setCwdTaskProcessFileIdClear(b.getCwdTaskProcessFileId());
		if(b.getCwdTaskProcessId() != null) setCwdTaskProcessId(b.getCwdTaskProcessId());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getCwdFilingManageDetailId() != null) setCwdFilingManageDetailId(b.getCwdFilingManageDetailId());
	}

	@Override
	public BaseCwdTaskProcessFile generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdTaskProcessFile b = new BaseCwdTaskProcessFile();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdTaskProcessFile __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskProcessFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdTaskProcessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFilingManageDetailId(GenericBase.__getInt(val));
	}

	public void setCwdTaskProcessFileId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdTaskProcessFileId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdTaskProcessFileIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdTaskProcessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdTaskProcessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCwdFilingManageDetailId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCwdFilingManageDetailId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setConditionCwdTaskProcessFileId(String op, java.lang.Integer val) {
		setConditionCwdTaskProcessFileId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskProcessFileId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdTaskProcessFileId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val) {
		setConditionCwdTaskProcessId(op, val, CONDITION_AND);
	}

	public void setConditionCwdTaskProcessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCwdTaskProcessId(boolean val) {
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

	public void setConditionCwdFilingManageDetailId(String op, java.lang.Integer val) {
		setConditionCwdFilingManageDetailId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFilingManageDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCwdFilingManageDetailId(boolean val) {
		__select_flags[3] = val;
	}


}

