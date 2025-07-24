package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCountry;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Country extends AbstractTable<BaseCountry>
{

	public Country() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "countries";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCountry.CS_COUNTRY_ID;
		__column_names[1] = BaseCountry.CS_COUNTRY_NAME_EN;
		__column_names[2] = BaseCountry.CS_COUNTRY_NAME_CN;
		__column_names[3] = BaseCountry.CS_LEVEL;
		__column_names[4] = BaseCountry.CS_TYPE;
		__column_names[5] = BaseCountry.CS_CODE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCountry b) {
		clear();
		setCountryIdClear(b.getCountryId());
	}

	public boolean isPrimaryKeyNull() {
		return getCountryId() == null;
	}

	@Override
	public BaseCountry generateBase(){
		BaseCountry b = new BaseCountry();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCountry b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCountryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCountryNameEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCountryNameCn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCountry b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCountryId();
		buff[count++] = b.getCountryNameEn();
		buff[count++] = b.getCountryNameCn();
		buff[count++] = b.getLevel();
		buff[count++] = b.getType();
		buff[count++] = b.getCode();
	}

	@Override
	public void setDataFromBase(BaseCountry b){
		if(b.getCountryId() != null) setCountryIdClear(b.getCountryId());
		if(b.getCountryNameEn() != null) setCountryNameEn(b.getCountryNameEn());
		if(b.getCountryNameCn() != null) setCountryNameCn(b.getCountryNameCn());
		if(b.getLevel() != null) setLevel(b.getLevel());
		if(b.getType() != null) setType(b.getType());
		if(b.getCode() != null) setCode(b.getCode());
	}

	@Override
	public BaseCountry generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCountry b = new BaseCountry();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCountry __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountryNameEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountryNameCn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
	}

	public void setCountryId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCountryId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCountryIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCountryNameEn(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCountryNameEn() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCountryNameCn(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCountryNameCn() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setLevel(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getLevel() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setConditionCountryId(String op, java.lang.Integer val) {
		setConditionCountryId(op, val, CONDITION_AND);
	}

	public void setConditionCountryId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCountryId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCountryNameEn(String op, java.lang.String val) {
		setConditionCountryNameEn(op, val, CONDITION_AND);
	}

	public void setConditionCountryNameEn(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCountryNameEn(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCountryNameCn(String op, java.lang.String val) {
		setConditionCountryNameCn(op, val, CONDITION_AND);
	}

	public void setConditionCountryNameCn(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCountryNameCn(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionLevel(String op, java.lang.Integer val) {
		setConditionLevel(op, val, CONDITION_AND);
	}

	public void setConditionLevel(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectLevel(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCode(boolean val) {
		__select_flags[5] = val;
	}


}

