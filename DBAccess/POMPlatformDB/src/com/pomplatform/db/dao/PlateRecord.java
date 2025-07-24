package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateRecord extends AbstractTable<BasePlateRecord>
{

	public PlateRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "plate_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateRecord.CS_PLATE_RECORD_ID;
		__column_names[1] = BasePlateRecord.CS_PLATE_ID;
		__column_names[2] = BasePlateRecord.CS_PLATE_CODE;
		__column_names[3] = BasePlateRecord.CS_PLATE_NAME;
		__column_names[4] = BasePlateRecord.CS_ENABLED;
		__column_names[5] = BasePlateRecord.CS_PARENT_ID;
		__column_names[6] = BasePlateRecord.CS_PLATE_TYPE;
		__column_names[7] = BasePlateRecord.CS_PLATE_MANAGER_ID;
		__column_names[8] = BasePlateRecord.CS_HR_CODE;
		__column_names[9] = BasePlateRecord.CS_PLATE_VOUCHER_TYPE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateRecord b) {
		clear();
		setPlateRecordIdClear(b.getPlateRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateRecordId() == null;
	}

	@Override
	public BasePlateRecord generateBase(){
		BasePlateRecord b = new BasePlateRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHrCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPlateVoucherType(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getPlateCode();
		buff[count++] = b.getPlateName();
		buff[count++] = b.getEnabled();
		buff[count++] = b.getParentId();
		buff[count++] = b.getPlateType();
		buff[count++] = b.getPlateManagerId();
		buff[count++] = b.getHrCode();
		buff[count++] = b.getPlateVoucherType();
	}

	@Override
	public void setDataFromBase(BasePlateRecord b){
		if(b.getPlateRecordId() != null) setPlateRecordIdClear(b.getPlateRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getPlateCode() != null) setPlateCode(b.getPlateCode());
		if(b.getPlateName() != null) setPlateName(b.getPlateName());
		if(b.getEnabled() != null) setEnabled(b.getEnabled());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getPlateType() != null) setPlateType(b.getPlateType());
		if(b.getPlateManagerId() != null) setPlateManagerId(b.getPlateManagerId());
		if(b.getHrCode() != null) setHrCode(b.getHrCode());
		if(b.getPlateVoucherType() != null) setPlateVoucherType(b.getPlateVoucherType());
	}

	@Override
	public BasePlateRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateRecord b = new BasePlateRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHrCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateVoucherType(GenericBase.__getInt(val));
	}

	public void setPlateRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getPlateCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setPlateName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getPlateName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setEnabled(java.lang.Boolean val) {
		setCurrentData(4, val);
	}

	public java.lang.Boolean getEnabled() {
		return GenericBase.__getBoolean(__current_data[4]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setPlateType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getPlateType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setPlateManagerId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getPlateManagerId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setHrCode(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getHrCode() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setPlateVoucherType(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getPlateVoucherType() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setConditionPlateRecordId(String op, java.lang.Integer val) {
		setConditionPlateRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateRecordId(boolean val) {
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

	public void setConditionPlateCode(String op, java.lang.String val) {
		setConditionPlateCode(op, val, CONDITION_AND);
	}

	public void setConditionPlateCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPlateCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPlateName(String op, java.lang.String val) {
		setConditionPlateName(op, val, CONDITION_AND);
	}

	public void setConditionPlateName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPlateName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEnabled(String op, java.lang.Boolean val) {
		setConditionEnabled(op, val, CONDITION_AND);
	}

	public void setConditionEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEnabled(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPlateType(String op, java.lang.Integer val) {
		setConditionPlateType(op, val, CONDITION_AND);
	}

	public void setConditionPlateType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPlateType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPlateManagerId(String op, java.lang.Integer val) {
		setConditionPlateManagerId(op, val, CONDITION_AND);
	}

	public void setConditionPlateManagerId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPlateManagerId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionHrCode(String op, java.lang.String val) {
		setConditionHrCode(op, val, CONDITION_AND);
	}

	public void setConditionHrCode(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectHrCode(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionPlateVoucherType(String op, java.lang.Integer val) {
		setConditionPlateVoucherType(op, val, CONDITION_AND);
	}

	public void setConditionPlateVoucherType(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectPlateVoucherType(boolean val) {
		__select_flags[9] = val;
	}


}

