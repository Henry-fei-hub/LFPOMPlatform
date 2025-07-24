package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePreProjectWarnRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PreProjectWarnRecord extends AbstractTable<BasePreProjectWarnRecord>
{

	public PreProjectWarnRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "pre_project_warn_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePreProjectWarnRecord.CS_PRE_PROJECT_WARN_RECORD_ID;
		__column_names[1] = BasePreProjectWarnRecord.CS_PRE_PROJECT_ID;
		__column_names[2] = BasePreProjectWarnRecord.CS_INFO_CODE;
		__column_names[3] = BasePreProjectWarnRecord.CS_PROJECT_CODE;
		__column_names[4] = BasePreProjectWarnRecord.CS_PROJECT_NAME;
		__column_names[5] = BasePreProjectWarnRecord.CS_EMPLOYEE_ID;
		__column_names[6] = BasePreProjectWarnRecord.CS_WARN_DAYS;
		__column_names[7] = BasePreProjectWarnRecord.CS_WARN_CONTENT;
		__column_names[8] = BasePreProjectWarnRecord.CS_RECORD_DATE;
		__column_names[9] = BasePreProjectWarnRecord.CS_RECORD_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePreProjectWarnRecord b) {
		clear();
		setPreProjectWarnRecordIdClear(b.getPreProjectWarnRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPreProjectWarnRecordId() == null;
	}

	@Override
	public BasePreProjectWarnRecord generateBase(){
		BasePreProjectWarnRecord b = new BasePreProjectWarnRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePreProjectWarnRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPreProjectWarnRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPreProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWarnDays(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWarnContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRecordTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BasePreProjectWarnRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPreProjectWarnRecordId();
		buff[count++] = b.getPreProjectId();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getWarnDays();
		buff[count++] = b.getWarnContent();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = generateTimestampFromDate(b.getRecordTime());
	}

	@Override
	public void setDataFromBase(BasePreProjectWarnRecord b){
		if(b.getPreProjectWarnRecordId() != null) setPreProjectWarnRecordIdClear(b.getPreProjectWarnRecordId());
		if(b.getPreProjectId() != null) setPreProjectId(b.getPreProjectId());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getWarnDays() != null) setWarnDays(b.getWarnDays());
		if(b.getWarnContent() != null) setWarnContent(b.getWarnContent());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getRecordTime() != null) setRecordTime(b.getRecordTime());
	}

	@Override
	public BasePreProjectWarnRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePreProjectWarnRecord b = new BasePreProjectWarnRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePreProjectWarnRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectWarnRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWarnDays(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWarnContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordTime(GenericBase.__getDateFromSQL(val));
	}

	public void setPreProjectWarnRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPreProjectWarnRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPreProjectWarnRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPreProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPreProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setWarnDays(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getWarnDays() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setWarnContent(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getWarnContent() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRecordTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setConditionPreProjectWarnRecordId(String op, java.lang.Integer val) {
		setConditionPreProjectWarnRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectWarnRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPreProjectWarnRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val) {
		setConditionPreProjectId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPreProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionWarnDays(String op, java.lang.Integer val) {
		setConditionWarnDays(op, val, CONDITION_AND);
	}

	public void setConditionWarnDays(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectWarnDays(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionWarnContent(String op, java.lang.String val) {
		setConditionWarnContent(op, val, CONDITION_AND);
	}

	public void setConditionWarnContent(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectWarnContent(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRecordTime(String op, java.util.Date val) {
		setConditionRecordTime(op, val, CONDITION_AND);
	}

	public void setConditionRecordTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordTime(boolean val) {
		__select_flags[9] = val;
	}


}

