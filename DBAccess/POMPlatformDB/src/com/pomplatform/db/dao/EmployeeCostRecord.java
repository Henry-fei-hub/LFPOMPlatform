package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeCostRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeCostRecord extends AbstractTable<BaseEmployeeCostRecord>
{

	public EmployeeCostRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "employee_cost_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeCostRecord.CS_EMPLOYEE_COST_RECORD_ID;
		__column_names[1] = BaseEmployeeCostRecord.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeCostRecord.CS_EMPLOYEE_NO;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeCostRecord b) {
		clear();
		setEmployeeCostRecordIdClear(b.getEmployeeCostRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeCostRecordId() == null;
	}

	@Override
	public BaseEmployeeCostRecord generateBase(){
		BaseEmployeeCostRecord b = new BaseEmployeeCostRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeCostRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeCostRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeCostRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeCostRecordId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
	}

	@Override
	public void setDataFromBase(BaseEmployeeCostRecord b){
		if(b.getEmployeeCostRecordId() != null) setEmployeeCostRecordIdClear(b.getEmployeeCostRecordId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
	}

	@Override
	public BaseEmployeeCostRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeCostRecord b = new BaseEmployeeCostRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeCostRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeCostRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
	}

	public void setEmployeeCostRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeCostRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeCostRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setConditionEmployeeCostRecordId(String op, java.lang.Integer val) {
		setConditionEmployeeCostRecordId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeCostRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeCostRecordId(boolean val) {
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

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[2] = val;
	}


}

