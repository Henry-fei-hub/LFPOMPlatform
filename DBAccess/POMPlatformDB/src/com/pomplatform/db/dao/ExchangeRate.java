package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseExchangeRate;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ExchangeRate extends AbstractTable<BaseExchangeRate>
{

	public ExchangeRate() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "exchange_rate";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseExchangeRate.CS_EXCHANGE_RATE_ID;
		__column_names[1] = BaseExchangeRate.CS_CURRENCY_ID;
		__column_names[2] = BaseExchangeRate.CS_EXCHANGE_RATE;
		__column_names[3] = BaseExchangeRate.CS_EXCHANGE_DATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseExchangeRate b) {
		clear();
		setExchangeRateIdClear(b.getExchangeRateId());
	}

	public boolean isPrimaryKeyNull() {
		return getExchangeRateId() == null;
	}

	@Override
	public BaseExchangeRate generateBase(){
		BaseExchangeRate b = new BaseExchangeRate();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseExchangeRate b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setExchangeRateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCurrencyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setExchangeDate(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseExchangeRate b, Object[] buff){
		int count = 0;
		buff[count++] = b.getExchangeRateId();
		buff[count++] = b.getCurrencyId();
		buff[count++] = b.getExchangeRate();
		buff[count++] = generateTimestampFromDate(b.getExchangeDate());
	}

	@Override
	public void setDataFromBase(BaseExchangeRate b){
		if(b.getExchangeRateId() != null) setExchangeRateIdClear(b.getExchangeRateId());
		if(b.getCurrencyId() != null) setCurrencyId(b.getCurrencyId());
		if(b.getExchangeRate() != null) setExchangeRate(b.getExchangeRate());
		if(b.getExchangeDate() != null) setExchangeDate(b.getExchangeDate());
	}

	@Override
	public BaseExchangeRate generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseExchangeRate b = new BaseExchangeRate();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseExchangeRate __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCurrencyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setExchangeDate(GenericBase.__getDateFromSQL(val));
	}

	public void setExchangeRateId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getExchangeRateId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setExchangeRateIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCurrencyId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCurrencyId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setExchangeRate(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getExchangeRate() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setExchangeDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getExchangeDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setConditionExchangeRateId(String op, java.lang.Integer val) {
		setConditionExchangeRateId(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRateId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectExchangeRateId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCurrencyId(String op, java.lang.Integer val) {
		setConditionCurrencyId(op, val, CONDITION_AND);
	}

	public void setConditionCurrencyId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCurrencyId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val) {
		setConditionExchangeRate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeRate(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectExchangeRate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionExchangeDate(String op, java.util.Date val) {
		setConditionExchangeDate(op, val, CONDITION_AND);
	}

	public void setConditionExchangeDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectExchangeDate(boolean val) {
		__select_flags[3] = val;
	}


}

