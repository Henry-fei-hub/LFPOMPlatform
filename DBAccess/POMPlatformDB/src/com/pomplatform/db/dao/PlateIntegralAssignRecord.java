package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateIntegralAssignRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateIntegralAssignRecord extends AbstractTable<BasePlateIntegralAssignRecord>
{

	public PlateIntegralAssignRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "plate_integral_assign_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateIntegralAssignRecord.CS_PLATE_INTEGRAL_ASSIGN_RECORD_ID;
		__column_names[1] = BasePlateIntegralAssignRecord.CS_PLATE_ID;
		__column_names[2] = BasePlateIntegralAssignRecord.CS_EMPLOYEE_ID;
		__column_names[3] = BasePlateIntegralAssignRecord.CS_ASSIGN_INTEGRAL;
		__column_names[4] = BasePlateIntegralAssignRecord.CS_ASSIGN_DATE;
		__column_names[5] = BasePlateIntegralAssignRecord.CS_PLATE_EMPLOYEE_ID;
		__column_names[6] = BasePlateIntegralAssignRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateIntegralAssignRecord b) {
		clear();
		setPlateIntegralAssignRecordIdClear(b.getPlateIntegralAssignRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateIntegralAssignRecordId() == null;
	}

	@Override
	public BasePlateIntegralAssignRecord generateBase(){
		BasePlateIntegralAssignRecord b = new BasePlateIntegralAssignRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateIntegralAssignRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateIntegralAssignRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAssignIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAssignDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPlateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateIntegralAssignRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateIntegralAssignRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getAssignIntegral();
		buff[count++] = generateTimestampFromDate(b.getAssignDate());
		buff[count++] = b.getPlateEmployeeId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePlateIntegralAssignRecord b){
		if(b.getPlateIntegralAssignRecordId() != null) setPlateIntegralAssignRecordIdClear(b.getPlateIntegralAssignRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getAssignIntegral() != null) setAssignIntegral(b.getAssignIntegral());
		if(b.getAssignDate() != null) setAssignDate(b.getAssignDate());
		if(b.getPlateEmployeeId() != null) setPlateEmployeeId(b.getPlateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePlateIntegralAssignRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateIntegralAssignRecord b = new BasePlateIntegralAssignRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateIntegralAssignRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateIntegralAssignRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssignIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAssignDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPlateIntegralAssignRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateIntegralAssignRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateIntegralAssignRecordIdClear(java.lang.Integer val) {
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

	public void setAssignIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAssignIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setAssignDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getAssignDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setPlateEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getPlateEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionPlateIntegralAssignRecordId(String op, java.lang.Integer val) {
		setConditionPlateIntegralAssignRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateIntegralAssignRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateIntegralAssignRecordId(boolean val) {
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

	public void setConditionAssignIntegral(String op, java.math.BigDecimal val) {
		setConditionAssignIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAssignIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAssignIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAssignDate(String op, java.util.Date val) {
		setConditionAssignDate(op, val, CONDITION_AND);
	}

	public void setConditionAssignDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAssignDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPlateEmployeeId(String op, java.lang.Integer val) {
		setConditionPlateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionPlateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPlateEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}


}

