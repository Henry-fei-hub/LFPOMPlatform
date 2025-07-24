package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBank;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Bank extends AbstractTable<BaseBank>
{

	public Bank() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "banks";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBank.CS_BANK_ID;
		__column_names[1] = BaseBank.CS_BANK_NAME;
		__column_names[2] = BaseBank.CS_ORDER_NUM;
		__column_names[3] = BaseBank.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBank b) {
		clear();
		setBankIdClear(b.getBankId());
	}

	public boolean isPrimaryKeyNull() {
		return getBankId() == null;
	}

	@Override
	public BaseBank generateBase(){
		BaseBank b = new BaseBank();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBank b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBankId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBankName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOrderNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseBank b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBankId();
		buff[count++] = b.getBankName();
		buff[count++] = b.getOrderNum();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseBank b){
		if(b.getBankId() != null) setBankIdClear(b.getBankId());
		if(b.getBankName() != null) setBankName(b.getBankName());
		if(b.getOrderNum() != null) setOrderNum(b.getOrderNum());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseBank generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBank b = new BaseBank();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBank __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setBankId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBankId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBankIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBankName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getBankName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setOrderNum(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getOrderNum() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setConditionBankId(String op, java.lang.Integer val) {
		setConditionBankId(op, val, CONDITION_AND);
	}

	public void setConditionBankId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBankId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBankName(String op, java.lang.String val) {
		setConditionBankName(op, val, CONDITION_AND);
	}

	public void setConditionBankName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBankName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionOrderNum(String op, java.lang.Integer val) {
		setConditionOrderNum(op, val, CONDITION_AND);
	}

	public void setConditionOrderNum(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectOrderNum(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[3] = val;
	}


}

