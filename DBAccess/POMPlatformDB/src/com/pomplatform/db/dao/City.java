package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCity;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class City extends AbstractTable<BaseCity>
{

	public City() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "cities";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCity.CS_CITY_ID;
		__column_names[1] = BaseCity.CS_CITY_NAME_EN;
		__column_names[2] = BaseCity.CS_CITY_NAME_CN;
		__column_names[3] = BaseCity.CS_PROVINCE_ID;
		__column_names[4] = BaseCity.CS_CITY_IS_ENABLE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCity b) {
		clear();
		setCityIdClear(b.getCityId());
	}

	public boolean isPrimaryKeyNull() {
		return getCityId() == null;
	}

	@Override
	public BaseCity generateBase(){
		BaseCity b = new BaseCity();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCity b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCityId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCityNameEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCityNameCn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProvinceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCityIsEnable(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseCity b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCityId();
		buff[count++] = b.getCityNameEn();
		buff[count++] = b.getCityNameCn();
		buff[count++] = b.getProvinceId();
		buff[count++] = b.getCityIsEnable();
	}

	@Override
	public void setDataFromBase(BaseCity b){
		if(b.getCityId() != null) setCityIdClear(b.getCityId());
		if(b.getCityNameEn() != null) setCityNameEn(b.getCityNameEn());
		if(b.getCityNameCn() != null) setCityNameCn(b.getCityNameCn());
		if(b.getProvinceId() != null) setProvinceId(b.getProvinceId());
		if(b.getCityIsEnable() != null) setCityIsEnable(b.getCityIsEnable());
	}

	@Override
	public BaseCity generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCity b = new BaseCity();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCity __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCityId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCityNameEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCityNameCn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvinceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCityIsEnable(GenericBase.__getBoolean(val));
	}

	public void setCityId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCityId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCityIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCityNameEn(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCityNameEn() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCityNameCn(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCityNameCn() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProvinceId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getProvinceId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCityIsEnable(java.lang.Boolean val) {
		setCurrentData(4, val);
	}

	public java.lang.Boolean getCityIsEnable() {
		return GenericBase.__getBoolean(__current_data[4]);
	}

	public void setConditionCityId(String op, java.lang.Integer val) {
		setConditionCityId(op, val, CONDITION_AND);
	}

	public void setConditionCityId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCityId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCityNameEn(String op, java.lang.String val) {
		setConditionCityNameEn(op, val, CONDITION_AND);
	}

	public void setConditionCityNameEn(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCityNameEn(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCityNameCn(String op, java.lang.String val) {
		setConditionCityNameCn(op, val, CONDITION_AND);
	}

	public void setConditionCityNameCn(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCityNameCn(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProvinceId(String op, java.lang.Integer val) {
		setConditionProvinceId(op, val, CONDITION_AND);
	}

	public void setConditionProvinceId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProvinceId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCityIsEnable(String op, java.lang.Boolean val) {
		setConditionCityIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionCityIsEnable(String op, java.lang.Boolean val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCityIsEnable(boolean val) {
		__select_flags[4] = val;
	}


}

