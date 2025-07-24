package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProjectStageRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProjectStageRecord extends AbstractTable<BaseProjectStageRecord>
{

	public ProjectStageRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "project_stage_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProjectStageRecord.CS_PROJECT_STAGE_RECORD_ID;
		__column_names[1] = BaseProjectStageRecord.CS_PROJECT_ID;
		__column_names[2] = BaseProjectStageRecord.CS_STAGE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProjectStageRecord b) {
		clear();
		setProjectStageRecordIdClear(b.getProjectStageRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getProjectStageRecordId() == null;
	}

	@Override
	public BaseProjectStageRecord generateBase(){
		BaseProjectStageRecord b = new BaseProjectStageRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProjectStageRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProjectStageRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStageId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseProjectStageRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProjectStageRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getStageId();
	}

	@Override
	public void setDataFromBase(BaseProjectStageRecord b){
		if(b.getProjectStageRecordId() != null) setProjectStageRecordIdClear(b.getProjectStageRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getStageId() != null) setStageId(b.getStageId());
	}

	@Override
	public BaseProjectStageRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProjectStageRecord b = new BaseProjectStageRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProjectStageRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStageRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStageId(GenericBase.__getInt(val));
	}

	public void setProjectStageRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProjectStageRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProjectStageRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setStageId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getStageId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionProjectStageRecordId(String op, java.lang.Integer val) {
		setConditionProjectStageRecordId(op, val, CONDITION_AND);
	}

	public void setConditionProjectStageRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProjectStageRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionStageId(String op, java.lang.Integer val) {
		setConditionStageId(op, val, CONDITION_AND);
	}

	public void setConditionStageId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectStageId(boolean val) {
		__select_flags[2] = val;
	}


}

