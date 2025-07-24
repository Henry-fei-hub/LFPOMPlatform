package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCwdFileProject;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CwdFileProject extends AbstractTable<BaseCwdFileProject>
{

	public CwdFileProject() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "cwd_file_projects";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCwdFileProject.CS_CWD_FILE_PROJECT_ID;
		__column_names[1] = BaseCwdFileProject.CS_CWD_FILE_ID;
		__column_names[2] = BaseCwdFileProject.CS_PROJECT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCwdFileProject b) {
		clear();
		setCwdFileProjectIdClear(b.getCwdFileProjectId());
	}

	public boolean isPrimaryKeyNull() {
		return getCwdFileProjectId() == null;
	}

	@Override
	public BaseCwdFileProject generateBase(){
		BaseCwdFileProject b = new BaseCwdFileProject();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCwdFileProject b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCwdFileProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCwdFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCwdFileProject b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCwdFileProjectId();
		buff[count++] = b.getCwdFileId();
		buff[count++] = b.getProjectId();
	}

	@Override
	public void setDataFromBase(BaseCwdFileProject b){
		if(b.getCwdFileProjectId() != null) setCwdFileProjectIdClear(b.getCwdFileProjectId());
		if(b.getCwdFileId() != null) setCwdFileId(b.getCwdFileId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
	}

	@Override
	public BaseCwdFileProject generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCwdFileProject b = new BaseCwdFileProject();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCwdFileProject __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCwdFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
	}

	public void setCwdFileProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCwdFileProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCwdFileProjectIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCwdFileId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCwdFileId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionCwdFileProjectId(String op, java.lang.Integer val) {
		setConditionCwdFileProjectId(op, val, CONDITION_AND);
	}

	public void setConditionCwdFileProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCwdFileProjectId(boolean val) {
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

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[2] = val;
	}


}

