package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePreProjectTransferRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PreProjectTransferRecord extends AbstractTable<BasePreProjectTransferRecord>
{

	public PreProjectTransferRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "pre_project_transfer_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePreProjectTransferRecord.CS_PRE_PROJECT_TRANSFER_RECORD_ID;
		__column_names[1] = BasePreProjectTransferRecord.CS_PRE_PROJECT_ID;
		__column_names[2] = BasePreProjectTransferRecord.CS_EMPLOYEE_ID;
		__column_names[3] = BasePreProjectTransferRecord.CS_TRANSFER_EMPLOYEE_ID;
		__column_names[4] = BasePreProjectTransferRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[5] = BasePreProjectTransferRecord.CS_OPERATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePreProjectTransferRecord b) {
		clear();
		setPreProjectTransferRecordIdClear(b.getPreProjectTransferRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPreProjectTransferRecordId() == null;
	}

	@Override
	public BasePreProjectTransferRecord generateBase(){
		BasePreProjectTransferRecord b = new BasePreProjectTransferRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePreProjectTransferRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPreProjectTransferRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPreProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTransferEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BasePreProjectTransferRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPreProjectTransferRecordId();
		buff[count++] = b.getPreProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getTransferEmployeeId();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
	}

	@Override
	public void setDataFromBase(BasePreProjectTransferRecord b){
		if(b.getPreProjectTransferRecordId() != null) setPreProjectTransferRecordIdClear(b.getPreProjectTransferRecordId());
		if(b.getPreProjectId() != null) setPreProjectId(b.getPreProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getTransferEmployeeId() != null) setTransferEmployeeId(b.getTransferEmployeeId());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
	}

	@Override
	public BasePreProjectTransferRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePreProjectTransferRecord b = new BasePreProjectTransferRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePreProjectTransferRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectTransferRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setPreProjectTransferRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPreProjectTransferRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPreProjectTransferRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPreProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPreProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setTransferEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getTransferEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionPreProjectTransferRecordId(String op, java.lang.Integer val) {
		setConditionPreProjectTransferRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectTransferRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPreProjectTransferRecordId(boolean val) {
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

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTransferEmployeeId(String op, java.lang.Integer val) {
		setConditionTransferEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionTransferEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTransferEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[5] = val;
	}


}

