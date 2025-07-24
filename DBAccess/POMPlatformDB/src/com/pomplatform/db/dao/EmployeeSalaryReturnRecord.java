package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeSalaryReturnRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeSalaryReturnRecord extends AbstractTable<BaseEmployeeSalaryReturnRecord>
{

	public EmployeeSalaryReturnRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "employee_salary_return_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeSalaryReturnRecord.CS_EMPLOYEE_SALARY_RETURN_RECORD_ID;
		__column_names[1] = BaseEmployeeSalaryReturnRecord.CS_PLATE_ID;
		__column_names[2] = BaseEmployeeSalaryReturnRecord.CS_EMPLOYEE_ID;
		__column_names[3] = BaseEmployeeSalaryReturnRecord.CS_EMPLOYEE_NAME;
		__column_names[4] = BaseEmployeeSalaryReturnRecord.CS_EMPLOYEE_NO;
		__column_names[5] = BaseEmployeeSalaryReturnRecord.CS_SALARY_RETURN;
		__column_names[6] = BaseEmployeeSalaryReturnRecord.CS_RECORD_DATE;
		__column_names[7] = BaseEmployeeSalaryReturnRecord.CS_IS_RETURN;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeSalaryReturnRecord b) {
		clear();
		setEmployeeSalaryReturnRecordIdClear(b.getEmployeeSalaryReturnRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeSalaryReturnRecordId() == null;
	}

	@Override
	public BaseEmployeeSalaryReturnRecord generateBase(){
		BaseEmployeeSalaryReturnRecord b = new BaseEmployeeSalaryReturnRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeSalaryReturnRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeSalaryReturnRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSalaryReturn(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsReturn(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeSalaryReturnRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeSalaryReturnRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getSalaryReturn();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getIsReturn();
	}

	@Override
	public void setDataFromBase(BaseEmployeeSalaryReturnRecord b){
		if(b.getEmployeeSalaryReturnRecordId() != null) setEmployeeSalaryReturnRecordIdClear(b.getEmployeeSalaryReturnRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getSalaryReturn() != null) setSalaryReturn(b.getSalaryReturn());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getIsReturn() != null) setIsReturn(b.getIsReturn());
	}

	@Override
	public BaseEmployeeSalaryReturnRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeSalaryReturnRecord b = new BaseEmployeeSalaryReturnRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeSalaryReturnRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeSalaryReturnRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryReturn(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsReturn(GenericBase.__getBoolean(val));
	}

	public void setEmployeeSalaryReturnRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeSalaryReturnRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeSalaryReturnRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setSalaryReturn(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getSalaryReturn() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setIsReturn(java.lang.Boolean val) {
		setCurrentData(7, val);
	}

	public java.lang.Boolean getIsReturn() {
		return GenericBase.__getBoolean(__current_data[7]);
	}

	public void setConditionEmployeeSalaryReturnRecordId(String op, java.lang.Integer val) {
		setConditionEmployeeSalaryReturnRecordId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeSalaryReturnRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeSalaryReturnRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
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

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSalaryReturn(String op, java.math.BigDecimal val) {
		setConditionSalaryReturn(op, val, CONDITION_AND);
	}

	public void setConditionSalaryReturn(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSalaryReturn(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val) {
		setConditionIsReturn(op, val, CONDITION_AND);
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectIsReturn(boolean val) {
		__select_flags[7] = val;
	}


}

