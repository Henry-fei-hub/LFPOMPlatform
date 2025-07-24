package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractSerialNumber;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractSerialNumber extends AbstractTable<BaseContractSerialNumber>
{

	public ContractSerialNumber() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "contract_serial_numbers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseContractSerialNumber.CS_CONTRACT_SERIAL_NUMBER_ID;
		__column_names[1] = BaseContractSerialNumber.CS_PRODUCE_DATE;
		__column_names[2] = BaseContractSerialNumber.CS_SERIAL_NUMBER;
		__column_names[3] = BaseContractSerialNumber.CS_SIGNING_COMPANY_NAME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseContractSerialNumber b) {
		clear();
		setContractSerialNumberIdClear(b.getContractSerialNumberId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractSerialNumberId() == null;
	}

	@Override
	public BaseContractSerialNumber generateBase(){
		BaseContractSerialNumber b = new BaseContractSerialNumber();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractSerialNumber b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractSerialNumberId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProduceDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSerialNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSigningCompanyName(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractSerialNumber b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractSerialNumberId();
		buff[count++] = generateTimestampFromDate(b.getProduceDate());
		buff[count++] = b.getSerialNumber();
		buff[count++] = b.getSigningCompanyName();
	}

	@Override
	public void setDataFromBase(BaseContractSerialNumber b){
		if(b.getContractSerialNumberId() != null) setContractSerialNumberIdClear(b.getContractSerialNumberId());
		if(b.getProduceDate() != null) setProduceDate(b.getProduceDate());
		if(b.getSerialNumber() != null) setSerialNumber(b.getSerialNumber());
		if(b.getSigningCompanyName() != null) setSigningCompanyName(b.getSigningCompanyName());
	}

	@Override
	public BaseContractSerialNumber generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractSerialNumber b = new BaseContractSerialNumber();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractSerialNumber __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSerialNumberId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProduceDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningCompanyName(GenericBase.__getInt(val));
	}

	public void setContractSerialNumberId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractSerialNumberId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractSerialNumberIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProduceDate(java.util.Date val) {
		setCurrentData(1, generateTimestampFromDate(val));
	}

	public java.util.Date getProduceDate() {
		return GenericBase.__getDateFromSQL(__current_data[1]);
	}

	public void setSerialNumber(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getSerialNumber() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSigningCompanyName(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSigningCompanyName() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setConditionContractSerialNumberId(String op, java.lang.Integer val) {
		setConditionContractSerialNumberId(op, val, CONDITION_AND);
	}

	public void setConditionContractSerialNumberId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractSerialNumberId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProduceDate(String op, java.util.Date val) {
		setConditionProduceDate(op, val, CONDITION_AND);
	}

	public void setConditionProduceDate(String op, java.util.Date val, String relation) {
		addCondition(1, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectProduceDate(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val) {
		setConditionSerialNumber(op, val, CONDITION_AND);
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSerialNumber(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSigningCompanyName(String op, java.lang.Integer val) {
		setConditionSigningCompanyName(op, val, CONDITION_AND);
	}

	public void setConditionSigningCompanyName(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSigningCompanyName(boolean val) {
		__select_flags[3] = val;
	}


}

