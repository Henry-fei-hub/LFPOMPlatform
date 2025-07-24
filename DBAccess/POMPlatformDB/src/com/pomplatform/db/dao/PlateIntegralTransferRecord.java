package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateIntegralTransferRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateIntegralTransferRecord extends AbstractTable<BasePlateIntegralTransferRecord>
{

	public PlateIntegralTransferRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "plate_integral_transfer_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateIntegralTransferRecord.CS_PLATE_INTEGRAL_TRANSFER_RECORD_ID;
		__column_names[1] = BasePlateIntegralTransferRecord.CS_FROM_PLATE_ID;
		__column_names[2] = BasePlateIntegralTransferRecord.CS_TO_PLATE_ID;
		__column_names[3] = BasePlateIntegralTransferRecord.CS_TRANSFER_INTEGRAL;
		__column_names[4] = BasePlateIntegralTransferRecord.CS_TRANSFER_DATE;
		__column_names[5] = BasePlateIntegralTransferRecord.CS_PLATE_EMPLOYEE_ID;
		__column_names[6] = BasePlateIntegralTransferRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateIntegralTransferRecord b) {
		clear();
		setPlateIntegralTransferRecordIdClear(b.getPlateIntegralTransferRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateIntegralTransferRecordId() == null;
	}

	@Override
	public BasePlateIntegralTransferRecord generateBase(){
		BasePlateIntegralTransferRecord b = new BasePlateIntegralTransferRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateIntegralTransferRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateIntegralTransferRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFromPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setToPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTransferIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTransferDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPlateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateIntegralTransferRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateIntegralTransferRecordId();
		buff[count++] = b.getFromPlateId();
		buff[count++] = b.getToPlateId();
		buff[count++] = b.getTransferIntegral();
		buff[count++] = generateTimestampFromDate(b.getTransferDate());
		buff[count++] = b.getPlateEmployeeId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePlateIntegralTransferRecord b){
		if(b.getPlateIntegralTransferRecordId() != null) setPlateIntegralTransferRecordIdClear(b.getPlateIntegralTransferRecordId());
		if(b.getFromPlateId() != null) setFromPlateId(b.getFromPlateId());
		if(b.getToPlateId() != null) setToPlateId(b.getToPlateId());
		if(b.getTransferIntegral() != null) setTransferIntegral(b.getTransferIntegral());
		if(b.getTransferDate() != null) setTransferDate(b.getTransferDate());
		if(b.getPlateEmployeeId() != null) setPlateEmployeeId(b.getPlateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePlateIntegralTransferRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateIntegralTransferRecord b = new BasePlateIntegralTransferRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateIntegralTransferRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateIntegralTransferRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFromPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setToPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPlateIntegralTransferRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateIntegralTransferRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateIntegralTransferRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFromPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFromPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setToPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getToPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setTransferIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getTransferIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setTransferDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getTransferDate() {
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

	public void setConditionPlateIntegralTransferRecordId(String op, java.lang.Integer val) {
		setConditionPlateIntegralTransferRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateIntegralTransferRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateIntegralTransferRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFromPlateId(String op, java.lang.Integer val) {
		setConditionFromPlateId(op, val, CONDITION_AND);
	}

	public void setConditionFromPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFromPlateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionToPlateId(String op, java.lang.Integer val) {
		setConditionToPlateId(op, val, CONDITION_AND);
	}

	public void setConditionToPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectToPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionTransferIntegral(String op, java.math.BigDecimal val) {
		setConditionTransferIntegral(op, val, CONDITION_AND);
	}

	public void setConditionTransferIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectTransferIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTransferDate(String op, java.util.Date val) {
		setConditionTransferDate(op, val, CONDITION_AND);
	}

	public void setConditionTransferDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectTransferDate(boolean val) {
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

