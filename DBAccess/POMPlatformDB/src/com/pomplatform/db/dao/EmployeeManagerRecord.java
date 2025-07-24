package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeManagerRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeManagerRecord extends AbstractTable<BaseEmployeeManagerRecord>
{

	public EmployeeManagerRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "employee_manager_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeManagerRecord.CS_EMPLOYEE_MANAGER_RECORD_ID;
		__column_names[1] = BaseEmployeeManagerRecord.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeManagerRecord.CS_PLATE_ID;
		__column_names[3] = BaseEmployeeManagerRecord.CS_EMPLOYEE_NO;
		__column_names[4] = BaseEmployeeManagerRecord.CS_EMPLOYEE_NAME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeManagerRecord b) {
		clear();
		setEmployeeManagerRecordIdClear(b.getEmployeeManagerRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeManagerRecordId() == null;
	}

	@Override
	public BaseEmployeeManagerRecord generateBase(){
		BaseEmployeeManagerRecord b = new BaseEmployeeManagerRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeManagerRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeManagerRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeManagerRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeManagerRecordId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeName();
	}

	@Override
	public void setDataFromBase(BaseEmployeeManagerRecord b){
		if(b.getEmployeeManagerRecordId() != null) setEmployeeManagerRecordIdClear(b.getEmployeeManagerRecordId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
	}

	@Override
	public BaseEmployeeManagerRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeManagerRecord b = new BaseEmployeeManagerRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeManagerRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeManagerRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
	}

	public void setEmployeeManagerRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeManagerRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeManagerRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionEmployeeManagerRecordId(String op, java.lang.Integer val) {
		setConditionEmployeeManagerRecordId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeManagerRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeManagerRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[4] = val;
	}


}

