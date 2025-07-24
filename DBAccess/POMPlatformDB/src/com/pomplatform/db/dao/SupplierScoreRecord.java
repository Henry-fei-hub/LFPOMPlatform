package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSupplierScoreRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SupplierScoreRecord extends AbstractTable<BaseSupplierScoreRecord>
{

	public SupplierScoreRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "supplier_score_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSupplierScoreRecord.CS_SCORD_ID;
		__column_names[1] = BaseSupplierScoreRecord.CS_NAME;
		__column_names[2] = BaseSupplierScoreRecord.CS_SCORD;
		__column_names[3] = BaseSupplierScoreRecord.CS_CODE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSupplierScoreRecord b) {
		clear();
		setScordIdClear(b.getScordId());
	}

	public boolean isPrimaryKeyNull() {
		return getScordId() == null;
	}

	@Override
	public BaseSupplierScoreRecord generateBase(){
		BaseSupplierScoreRecord b = new BaseSupplierScoreRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSupplierScoreRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setScordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setScord(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSupplierScoreRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getScordId();
		buff[count++] = b.getName();
		buff[count++] = b.getScord();
		buff[count++] = b.getCode();
	}

	@Override
	public void setDataFromBase(BaseSupplierScoreRecord b){
		if(b.getScordId() != null) setScordIdClear(b.getScordId());
		if(b.getName() != null) setName(b.getName());
		if(b.getScord() != null) setScord(b.getScord());
		if(b.getCode() != null) setCode(b.getCode());
	}

	@Override
	public BaseSupplierScoreRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSupplierScoreRecord b = new BaseSupplierScoreRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSupplierScoreRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setScordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setScord(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
	}

	public void setScordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getScordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setScordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setScord(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getScord() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setConditionScordId(String op, java.lang.Integer val) {
		setConditionScordId(op, val, CONDITION_AND);
	}

	public void setConditionScordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectScordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionScord(String op, java.math.BigDecimal val) {
		setConditionScord(op, val, CONDITION_AND);
	}

	public void setConditionScord(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectScord(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[3] = val;
	}


}

