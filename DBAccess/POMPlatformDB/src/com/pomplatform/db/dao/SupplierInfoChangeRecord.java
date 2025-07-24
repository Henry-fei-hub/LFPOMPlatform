package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSupplierInfoChangeRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SupplierInfoChangeRecord extends AbstractTable<BaseSupplierInfoChangeRecord>
{

	public SupplierInfoChangeRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "supplier_info_change_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSupplierInfoChangeRecord.CS_SUPPLIER_INFO_CHANGE_RECORD_ID;
		__column_names[1] = BaseSupplierInfoChangeRecord.CS_SUPPLIER_ID;
		__column_names[2] = BaseSupplierInfoChangeRecord.CS_CHANGE_CONTENT;
		__column_names[3] = BaseSupplierInfoChangeRecord.CS_CHANGE_EMPLOYEE_ID;
		__column_names[4] = BaseSupplierInfoChangeRecord.CS_CHANGE_DATE;
		__column_names[5] = BaseSupplierInfoChangeRecord.CS_CHANGE_TIME;
		__column_names[6] = BaseSupplierInfoChangeRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSupplierInfoChangeRecord b) {
		clear();
		setSupplierInfoChangeRecordIdClear(b.getSupplierInfoChangeRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getSupplierInfoChangeRecordId() == null;
	}

	@Override
	public BaseSupplierInfoChangeRecord generateBase(){
		BaseSupplierInfoChangeRecord b = new BaseSupplierInfoChangeRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSupplierInfoChangeRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSupplierInfoChangeRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setChangeContent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setChangeEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setChangeDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setChangeTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSupplierInfoChangeRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSupplierInfoChangeRecordId();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getChangeContent();
		buff[count++] = b.getChangeEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getChangeDate());
		buff[count++] = generateTimestampFromDate(b.getChangeTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSupplierInfoChangeRecord b){
		if(b.getSupplierInfoChangeRecordId() != null) setSupplierInfoChangeRecordIdClear(b.getSupplierInfoChangeRecordId());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getChangeContent() != null) setChangeContent(b.getChangeContent());
		if(b.getChangeEmployeeId() != null) setChangeEmployeeId(b.getChangeEmployeeId());
		if(b.getChangeDate() != null) setChangeDate(b.getChangeDate());
		if(b.getChangeTime() != null) setChangeTime(b.getChangeTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSupplierInfoChangeRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSupplierInfoChangeRecord b = new BaseSupplierInfoChangeRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSupplierInfoChangeRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierInfoChangeRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChangeContent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChangeEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChangeDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setChangeTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSupplierInfoChangeRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSupplierInfoChangeRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSupplierInfoChangeRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setChangeContent(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getChangeContent() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setChangeEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getChangeEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setChangeDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getChangeDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setChangeTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getChangeTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionSupplierInfoChangeRecordId(String op, java.lang.Integer val) {
		setConditionSupplierInfoChangeRecordId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierInfoChangeRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSupplierInfoChangeRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionChangeContent(String op, java.lang.String val) {
		setConditionChangeContent(op, val, CONDITION_AND);
	}

	public void setConditionChangeContent(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectChangeContent(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionChangeEmployeeId(String op, java.lang.Integer val) {
		setConditionChangeEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionChangeEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectChangeEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionChangeDate(String op, java.util.Date val) {
		setConditionChangeDate(op, val, CONDITION_AND);
	}

	public void setConditionChangeDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectChangeDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionChangeTime(String op, java.util.Date val) {
		setConditionChangeTime(op, val, CONDITION_AND);
	}

	public void setConditionChangeTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectChangeTime(boolean val) {
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

