package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProvince;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Province extends AbstractTable<BaseProvince>
{

	public Province() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "provinces";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProvince.CS_PROVINCE_ID;
		__column_names[1] = BaseProvince.CS_PROVINCE_NAME_EN;
		__column_names[2] = BaseProvince.CS_PROVINCE_NAME_CN;
		__column_names[3] = BaseProvince.CS_COUNTRY_ID;
		__column_names[4] = BaseProvince.CS_PROVINCE_IS_ENABLE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProvince b) {
		clear();
		setProvinceIdClear(b.getProvinceId());
	}

	public boolean isPrimaryKeyNull() {
		return getProvinceId() == null;
	}

	@Override
	public BaseProvince generateBase(){
		BaseProvince b = new BaseProvince();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProvince b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProvinceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProvinceNameEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProvinceNameCn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCountryId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProvinceIsEnable(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseProvince b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProvinceId();
		buff[count++] = b.getProvinceNameEn();
		buff[count++] = b.getProvinceNameCn();
		buff[count++] = b.getCountryId();
		buff[count++] = b.getProvinceIsEnable();
	}

	@Override
	public void setDataFromBase(BaseProvince b){
		if(b.getProvinceId() != null) setProvinceIdClear(b.getProvinceId());
		if(b.getProvinceNameEn() != null) setProvinceNameEn(b.getProvinceNameEn());
		if(b.getProvinceNameCn() != null) setProvinceNameCn(b.getProvinceNameCn());
		if(b.getCountryId() != null) setCountryId(b.getCountryId());
		if(b.getProvinceIsEnable() != null) setProvinceIsEnable(b.getProvinceIsEnable());
	}

	@Override
	public BaseProvince generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProvince b = new BaseProvince();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProvince __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvinceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvinceNameEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvinceNameCn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCountryId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvinceIsEnable(GenericBase.__getBoolean(val));
	}

	public void setProvinceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProvinceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProvinceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProvinceNameEn(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getProvinceNameEn() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProvinceNameCn(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProvinceNameCn() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setCountryId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCountryId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProvinceIsEnable(java.lang.Boolean val) {
		setCurrentData(4, val);
	}

	public java.lang.Boolean getProvinceIsEnable() {
		return GenericBase.__getBoolean(__current_data[4]);
	}

	public void setConditionProvinceId(String op, java.lang.Integer val) {
		setConditionProvinceId(op, val, CONDITION_AND);
	}

	public void setConditionProvinceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProvinceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProvinceNameEn(String op, java.lang.String val) {
		setConditionProvinceNameEn(op, val, CONDITION_AND);
	}

	public void setConditionProvinceNameEn(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProvinceNameEn(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProvinceNameCn(String op, java.lang.String val) {
		setConditionProvinceNameCn(op, val, CONDITION_AND);
	}

	public void setConditionProvinceNameCn(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProvinceNameCn(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCountryId(String op, java.lang.Integer val) {
		setConditionCountryId(op, val, CONDITION_AND);
	}

	public void setConditionCountryId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCountryId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProvinceIsEnable(String op, java.lang.Boolean val) {
		setConditionProvinceIsEnable(op, val, CONDITION_AND);
	}

	public void setConditionProvinceIsEnable(String op, java.lang.Boolean val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProvinceIsEnable(boolean val) {
		__select_flags[4] = val;
	}


}

