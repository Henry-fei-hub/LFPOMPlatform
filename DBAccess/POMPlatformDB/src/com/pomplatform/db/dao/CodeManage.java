package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCodeManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CodeManage extends AbstractTable<BaseCodeManage>
{

	public CodeManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "code_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCodeManage.CS_CODE_MANAGE_ID;
		__column_names[1] = BaseCodeManage.CS_RECORD_DATE;
		__column_names[2] = BaseCodeManage.CS_YEAR;
		__column_names[3] = BaseCodeManage.CS_MONTH;
		__column_names[4] = BaseCodeManage.CS_CODE;
		__column_names[5] = BaseCodeManage.CS_ORDER_NUM;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCodeManage b) {
		clear();
		setCodeManageIdClear(b.getCodeManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getCodeManageId() == null;
	}

	@Override
	public BaseCodeManage generateBase(){
		BaseCodeManage b = new BaseCodeManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCodeManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCodeManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOrderNum(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCodeManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCodeManageId();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getCode();
		buff[count++] = b.getOrderNum();
	}

	@Override
	public void setDataFromBase(BaseCodeManage b){
		if(b.getCodeManageId() != null) setCodeManageIdClear(b.getCodeManageId());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getOrderNum() != null) setOrderNum(b.getOrderNum());
	}

	@Override
	public BaseCodeManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCodeManage b = new BaseCodeManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCodeManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCodeManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNum(GenericBase.__getInt(val));
	}

	public void setCodeManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCodeManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCodeManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(1, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[1]);
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

	public void setCode(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setOrderNum(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOrderNum() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionCodeManageId(String op, java.lang.Integer val) {
		setConditionCodeManageId(op, val, CONDITION_AND);
	}

	public void setConditionCodeManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCodeManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(1, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
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

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOrderNum(String op, java.lang.Integer val) {
		setConditionOrderNum(op, val, CONDITION_AND);
	}

	public void setConditionOrderNum(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOrderNum(boolean val) {
		__select_flags[5] = val;
	}


}

