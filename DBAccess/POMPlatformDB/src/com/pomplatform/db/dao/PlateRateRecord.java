package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateRateRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateRateRecord extends AbstractTable<BasePlateRateRecord>
{

	public PlateRateRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "plate_rate_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateRateRecord.CS_PLATE_RATE_RECORD_ID;
		__column_names[1] = BasePlateRateRecord.CS_PLATE_ID;
		__column_names[2] = BasePlateRateRecord.CS_MODIFY_RATE_PERCENT;
		__column_names[3] = BasePlateRateRecord.CS_RATE_PERCENT;
		__column_names[4] = BasePlateRateRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[5] = BasePlateRateRecord.CS_OPERATE_TIME;
		__column_names[6] = BasePlateRateRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateRateRecord b) {
		clear();
		setPlateRateRecordIdClear(b.getPlateRateRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateRateRecordId() == null;
	}

	@Override
	public BasePlateRateRecord generateBase(){
		BasePlateRateRecord b = new BasePlateRateRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateRateRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateRateRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setModifyRatePercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRatePercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateRateRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateRateRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getModifyRatePercent();
		buff[count++] = b.getRatePercent();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePlateRateRecord b){
		if(b.getPlateRateRecordId() != null) setPlateRateRecordIdClear(b.getPlateRateRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getModifyRatePercent() != null) setModifyRatePercent(b.getModifyRatePercent());
		if(b.getRatePercent() != null) setRatePercent(b.getRatePercent());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePlateRateRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateRateRecord b = new BasePlateRateRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateRateRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateRateRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setModifyRatePercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRatePercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPlateRateRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateRateRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateRateRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setModifyRatePercent(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getModifyRatePercent() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setRatePercent(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getRatePercent() {
		return GenericBase.__getDecimal(__current_data[3]);
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

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionPlateRateRecordId(String op, java.lang.Integer val) {
		setConditionPlateRateRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateRateRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateRateRecordId(boolean val) {
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

	public void setConditionModifyRatePercent(String op, java.math.BigDecimal val) {
		setConditionModifyRatePercent(op, val, CONDITION_AND);
	}

	public void setConditionModifyRatePercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectModifyRatePercent(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRatePercent(String op, java.math.BigDecimal val) {
		setConditionRatePercent(op, val, CONDITION_AND);
	}

	public void setConditionRatePercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRatePercent(boolean val) {
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

