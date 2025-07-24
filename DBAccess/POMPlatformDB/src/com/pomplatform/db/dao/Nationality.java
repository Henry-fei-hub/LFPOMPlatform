package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseNationality;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Nationality extends AbstractTable<BaseNationality>
{

	public Nationality() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "nationalities";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseNationality.CS_NATIONALITY_ID;
		__column_names[1] = BaseNationality.CS_NATIONALITY_NAME;
		__column_names[2] = BaseNationality.CS_IS_ENABLED;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseNationality b) {
		clear();
		setNationalityIdClear(b.getNationalityId());
	}

	public boolean isPrimaryKeyNull() {
		return getNationalityId() == null;
	}

	@Override
	public BaseNationality generateBase(){
		BaseNationality b = new BaseNationality();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseNationality b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setNationalityId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNationalityName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsEnabled(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseNationality b, Object[] buff){
		int count = 0;
		buff[count++] = b.getNationalityId();
		buff[count++] = b.getNationalityName();
		buff[count++] = b.getIsEnabled();
	}

	@Override
	public void setDataFromBase(BaseNationality b){
		if(b.getNationalityId() != null) setNationalityIdClear(b.getNationalityId());
		if(b.getNationalityName() != null) setNationalityName(b.getNationalityName());
		if(b.getIsEnabled() != null) setIsEnabled(b.getIsEnabled());
	}

	@Override
	public BaseNationality generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseNationality b = new BaseNationality();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseNationality __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNationalityId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNationalityName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
	}

	public void setNationalityId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getNationalityId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setNationalityIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setNationalityName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getNationalityName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setIsEnabled(java.lang.Boolean val) {
		setCurrentData(2, val);
	}

	public java.lang.Boolean getIsEnabled() {
		return GenericBase.__getBoolean(__current_data[2]);
	}

	public void setConditionNationalityId(String op, java.lang.Integer val) {
		setConditionNationalityId(op, val, CONDITION_AND);
	}

	public void setConditionNationalityId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectNationalityId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionNationalityName(String op, java.lang.String val) {
		setConditionNationalityName(op, val, CONDITION_AND);
	}

	public void setConditionNationalityName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectNationalityName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val) {
		setConditionIsEnabled(op, val, CONDITION_AND);
	}

	public void setConditionIsEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectIsEnabled(boolean val) {
		__select_flags[2] = val;
	}


}

