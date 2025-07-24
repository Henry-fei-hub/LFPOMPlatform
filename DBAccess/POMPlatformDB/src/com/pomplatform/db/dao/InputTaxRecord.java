package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseInputTaxRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class InputTaxRecord extends AbstractTable<BaseInputTaxRecord>
{

	public InputTaxRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "input_tax_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseInputTaxRecord.CS_INPUT_TAX_RECORD_ID;
		__column_names[1] = BaseInputTaxRecord.CS_BUSINESS_ID;
		__column_names[2] = BaseInputTaxRecord.CS_PROCESS_TYPE;
		__column_names[3] = BaseInputTaxRecord.CS_CODE;
		__column_names[4] = BaseInputTaxRecord.CS_INPUT_TAX;
		__column_names[5] = BaseInputTaxRecord.CS_INVOICE_END_NUMBER;
		__column_names[6] = BaseInputTaxRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[7] = BaseInputTaxRecord.CS_OPERATE_TIME;
		__column_names[8] = BaseInputTaxRecord.CS_OVER_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseInputTaxRecord b) {
		clear();
		setInputTaxRecordIdClear(b.getInputTaxRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getInputTaxRecordId() == null;
	}

	@Override
	public BaseInputTaxRecord generateBase(){
		BaseInputTaxRecord b = new BaseInputTaxRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseInputTaxRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setInputTaxRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProcessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInputTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInvoiceEndNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOverTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseInputTaxRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getInputTaxRecordId();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getProcessType();
		buff[count++] = b.getCode();
		buff[count++] = b.getInputTax();
		buff[count++] = b.getInvoiceEndNumber();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = generateTimestampFromDate(b.getOverTime());
	}

	@Override
	public void setDataFromBase(BaseInputTaxRecord b){
		if(b.getInputTaxRecordId() != null) setInputTaxRecordIdClear(b.getInputTaxRecordId());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getProcessType() != null) setProcessType(b.getProcessType());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getInputTax() != null) setInputTax(b.getInputTax());
		if(b.getInvoiceEndNumber() != null) setInvoiceEndNumber(b.getInvoiceEndNumber());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getOverTime() != null) setOverTime(b.getOverTime());
	}

	@Override
	public BaseInputTaxRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseInputTaxRecord b = new BaseInputTaxRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseInputTaxRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceEndNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOverTime(GenericBase.__getDateFromSQL(val));
	}

	public void setInputTaxRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getInputTaxRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setInputTaxRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProcessType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProcessType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setInputTax(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getInputTax() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setInvoiceEndNumber(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getInvoiceEndNumber() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setOverTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getOverTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setConditionInputTaxRecordId(String op, java.lang.Integer val) {
		setConditionInputTaxRecordId(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectInputTaxRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProcessType(String op, java.lang.Integer val) {
		setConditionProcessType(op, val, CONDITION_AND);
	}

	public void setConditionProcessType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProcessType(boolean val) {
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

	public void setConditionInputTax(String op, java.math.BigDecimal val) {
		setConditionInputTax(op, val, CONDITION_AND);
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectInputTax(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionInvoiceEndNumber(String op, java.lang.String val) {
		setConditionInvoiceEndNumber(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceEndNumber(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectInvoiceEndNumber(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOverTime(String op, java.util.Date val) {
		setConditionOverTime(op, val, CONDITION_AND);
	}

	public void setConditionOverTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOverTime(boolean val) {
		__select_flags[8] = val;
	}


}

