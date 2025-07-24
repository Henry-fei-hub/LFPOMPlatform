package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSerialNumber;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SerialNumber extends AbstractTable<BaseSerialNumber>
{

	public SerialNumber() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "serial_numbers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSerialNumber.CS_SERIAL_NUMBER_ID;
		__column_names[1] = BaseSerialNumber.CS_SERIAL_TYPE;
		__column_names[2] = BaseSerialNumber.CS_YEAR;
		__column_names[3] = BaseSerialNumber.CS_MONTH;
		__column_names[4] = BaseSerialNumber.CS_DAY;
		__column_names[5] = BaseSerialNumber.CS_SERIAL_NUMBER;
		__column_names[6] = BaseSerialNumber.CS_OPERATE_TIME;
		__column_names[7] = BaseSerialNumber.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSerialNumber b) {
		clear();
		setSerialNumberIdClear(b.getSerialNumberId());
	}

	public boolean isPrimaryKeyNull() {
		return getSerialNumberId() == null;
	}

	@Override
	public BaseSerialNumber generateBase(){
		BaseSerialNumber b = new BaseSerialNumber();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSerialNumber b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSerialNumberId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSerialType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDay(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSerialNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSerialNumber b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSerialNumberId();
		buff[count++] = b.getSerialType();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getDay();
		buff[count++] = b.getSerialNumber();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseSerialNumber b){
		if(b.getSerialNumberId() != null) setSerialNumberIdClear(b.getSerialNumberId());
		if(b.getSerialType() != null) setSerialType(b.getSerialType());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getDay() != null) setDay(b.getDay());
		if(b.getSerialNumber() != null) setSerialNumber(b.getSerialNumber());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseSerialNumber generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSerialNumber b = new BaseSerialNumber();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSerialNumber __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialNumberId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDay(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setSerialNumberId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSerialNumberId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSerialNumberIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSerialType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSerialType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setDay(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDay() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setSerialNumber(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getSerialNumber() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionSerialNumberId(String op, java.lang.Integer val) {
		setConditionSerialNumberId(op, val, CONDITION_AND);
	}

	public void setConditionSerialNumberId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSerialNumberId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSerialType(String op, java.lang.Integer val) {
		setConditionSerialType(op, val, CONDITION_AND);
	}

	public void setConditionSerialType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSerialType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDay(String op, java.lang.Integer val) {
		setConditionDay(op, val, CONDITION_AND);
	}

	public void setConditionDay(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDay(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val) {
		setConditionSerialNumber(op, val, CONDITION_AND);
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSerialNumber(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}


}

