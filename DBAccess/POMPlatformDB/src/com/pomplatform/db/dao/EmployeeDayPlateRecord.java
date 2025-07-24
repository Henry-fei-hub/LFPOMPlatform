package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeDayPlateRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeDayPlateRecord extends AbstractTable<BaseEmployeeDayPlateRecord>
{

	public EmployeeDayPlateRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "employee_day_plate_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeDayPlateRecord.CS_EMPLOYEE_DAY_PLATE_RECORD_ID;
		__column_names[1] = BaseEmployeeDayPlateRecord.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeDayPlateRecord.CS_EMPLOYEE_NO;
		__column_names[3] = BaseEmployeeDayPlateRecord.CS_EMPLOYEE_NAME;
		__column_names[4] = BaseEmployeeDayPlateRecord.CS_RECORD_DATE;
		__column_names[5] = BaseEmployeeDayPlateRecord.CS_YEAR;
		__column_names[6] = BaseEmployeeDayPlateRecord.CS_MONTH;
		__column_names[7] = BaseEmployeeDayPlateRecord.CS_COMPANY_ID;
		__column_names[8] = BaseEmployeeDayPlateRecord.CS_PLATE_ID;
		__column_names[9] = BaseEmployeeDayPlateRecord.CS_DEPARTMENT_ID;
		__column_names[10] = BaseEmployeeDayPlateRecord.CS_ONBOARD_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeDayPlateRecord b) {
		clear();
		setEmployeeDayPlateRecordIdClear(b.getEmployeeDayPlateRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeDayPlateRecordId() == null;
	}

	@Override
	public BaseEmployeeDayPlateRecord generateBase(){
		BaseEmployeeDayPlateRecord b = new BaseEmployeeDayPlateRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeDayPlateRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeDayPlateRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOnboardStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeDayPlateRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeDayPlateRecordId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeName();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getOnboardStatus();
	}

	@Override
	public void setDataFromBase(BaseEmployeeDayPlateRecord b){
		if(b.getEmployeeDayPlateRecordId() != null) setEmployeeDayPlateRecordIdClear(b.getEmployeeDayPlateRecordId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getOnboardStatus() != null) setOnboardStatus(b.getOnboardStatus());
	}

	@Override
	public BaseEmployeeDayPlateRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeDayPlateRecord b = new BaseEmployeeDayPlateRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeDayPlateRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeDayPlateRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOnboardStatus(GenericBase.__getInt(val));
	}

	public void setEmployeeDayPlateRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeDayPlateRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeDayPlateRecordIdClear(java.lang.Integer val) {
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

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setOnboardStatus(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOnboardStatus() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setConditionEmployeeDayPlateRecordId(String op, java.lang.Integer val) {
		setConditionEmployeeDayPlateRecordId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeDayPlateRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeDayPlateRecordId(boolean val) {
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

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOnboardStatus(String op, java.lang.Integer val) {
		setConditionOnboardStatus(op, val, CONDITION_AND);
	}

	public void setConditionOnboardStatus(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOnboardStatus(boolean val) {
		__select_flags[10] = val;
	}


}

