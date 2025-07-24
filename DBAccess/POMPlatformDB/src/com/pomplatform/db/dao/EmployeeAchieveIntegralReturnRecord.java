package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeAchieveIntegralReturnRecord extends AbstractTable<BaseEmployeeAchieveIntegralReturnRecord>
{

	public EmployeeAchieveIntegralReturnRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "employee_achieve_integral_return_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeAchieveIntegralReturnRecord.CS_EMPLOYEE_ACHIEVE_INTEGRAL_RETURN_RECORD_ID;
		__column_names[1] = BaseEmployeeAchieveIntegralReturnRecord.CS_PLATE_ID;
		__column_names[2] = BaseEmployeeAchieveIntegralReturnRecord.CS_EMPLOYEE_ID;
		__column_names[3] = BaseEmployeeAchieveIntegralReturnRecord.CS_EMPLOYEE_NAME;
		__column_names[4] = BaseEmployeeAchieveIntegralReturnRecord.CS_EMPLOYEE_NO;
		__column_names[5] = BaseEmployeeAchieveIntegralReturnRecord.CS_ACHIEVE_INTEGRAL;
		__column_names[6] = BaseEmployeeAchieveIntegralReturnRecord.CS_RECORD_DATE;
		__column_names[7] = BaseEmployeeAchieveIntegralReturnRecord.CS_STATUS;
		__column_names[8] = BaseEmployeeAchieveIntegralReturnRecord.CS_CREATE_TIME;
		__column_names[9] = BaseEmployeeAchieveIntegralReturnRecord.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeAchieveIntegralReturnRecord b) {
		clear();
		setEmployeeAchieveIntegralReturnRecordIdClear(b.getEmployeeAchieveIntegralReturnRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeAchieveIntegralReturnRecordId() == null;
	}

	@Override
	public BaseEmployeeAchieveIntegralReturnRecord generateBase(){
		BaseEmployeeAchieveIntegralReturnRecord b = new BaseEmployeeAchieveIntegralReturnRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeAchieveIntegralReturnRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeAchieveIntegralReturnRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeAchieveIntegralReturnRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeAchieveIntegralReturnRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getAchieveIntegral();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getStatus();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseEmployeeAchieveIntegralReturnRecord b){
		if(b.getEmployeeAchieveIntegralReturnRecordId() != null) setEmployeeAchieveIntegralReturnRecordIdClear(b.getEmployeeAchieveIntegralReturnRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getAchieveIntegral() != null) setAchieveIntegral(b.getAchieveIntegral());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseEmployeeAchieveIntegralReturnRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeAchieveIntegralReturnRecord b = new BaseEmployeeAchieveIntegralReturnRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeAchieveIntegralReturnRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeAchieveIntegralReturnRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setEmployeeAchieveIntegralReturnRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeAchieveIntegralReturnRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeAchieveIntegralReturnRecordIdClear(java.lang.Integer val) {
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

	public void setAchieveIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setConditionEmployeeAchieveIntegralReturnRecordId(String op, java.lang.Integer val) {
		setConditionEmployeeAchieveIntegralReturnRecordId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeAchieveIntegralReturnRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeAchieveIntegralReturnRecordId(boolean val) {
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

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val) {
		setConditionAchieveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAchieveIntegral(boolean val) {
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

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[9] = val;
	}


}

