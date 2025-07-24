package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBusinessLineRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BusinessLineRecord extends AbstractTable<BaseBusinessLineRecord>
{

	public BusinessLineRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "business_line_record";

		__key_columns          = new int[1];
		__key_columns[0] = 3;

		__column_names[0] = BaseBusinessLineRecord.CS_BUSINESS_LINE_ID;
		__column_names[1] = BaseBusinessLineRecord.CS_CONTRACT_ID;
		__column_names[2] = BaseBusinessLineRecord.CS_BUSINESS_AMOUNT;
		__column_names[3] = BaseBusinessLineRecord.CS_BUSINESS_LINE_RECORD_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[3] = false;
		__serial_column = 3;
	}

	public void setPrimaryKeyFromBase(BaseBusinessLineRecord b) {
		clear();
		setBusinessLineRecordIdClear(b.getBusinessLineRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getBusinessLineRecordId() == null;
	}

	@Override
	public BaseBusinessLineRecord generateBase(){
		BaseBusinessLineRecord b = new BaseBusinessLineRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBusinessLineRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBusinessLineId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBusinessLineRecordId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseBusinessLineRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBusinessLineId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getBusinessAmount();
		buff[count++] = b.getBusinessLineRecordId();
	}

	@Override
	public void setDataFromBase(BaseBusinessLineRecord b){
		if(b.getBusinessLineId() != null) setBusinessLineId(b.getBusinessLineId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getBusinessAmount() != null) setBusinessAmount(b.getBusinessAmount());
		if(b.getBusinessLineRecordId() != null) setBusinessLineRecordIdClear(b.getBusinessLineRecordId());
	}

	@Override
	public BaseBusinessLineRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBusinessLineRecord b = new BaseBusinessLineRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBusinessLineRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessLineId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessLineRecordId(GenericBase.__getInt(val));
	}

	public void setBusinessLineId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBusinessLineId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessAmount(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getBusinessAmount() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setBusinessLineRecordId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getBusinessLineRecordId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setBusinessLineRecordIdClear(java.lang.Integer val) {
		__backup_data[3] = __current_data[3] =  val;
		__modified_flags[3] = false;
	}

	public void setConditionBusinessLineId(String op, java.lang.Integer val) {
		setConditionBusinessLineId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessLineId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBusinessLineId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionBusinessAmount(String op, java.math.BigDecimal val) {
		setConditionBusinessAmount(op, val, CONDITION_AND);
	}

	public void setConditionBusinessAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessAmount(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionBusinessLineRecordId(String op, java.lang.Integer val) {
		setConditionBusinessLineRecordId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessLineRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectBusinessLineRecordId(boolean val) {
		__select_flags[3] = val;
	}


}

