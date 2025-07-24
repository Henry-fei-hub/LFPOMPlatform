package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompanyArea;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompanyArea extends AbstractTable<BaseCompanyArea>
{

	public CompanyArea() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "company_areas";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompanyArea.CS_COMPANY_AREA_ID;
		__column_names[1] = BaseCompanyArea.CS_COMPANY_ID;
		__column_names[2] = BaseCompanyArea.CS_AREA_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompanyArea b) {
		clear();
		setCompanyAreaIdClear(b.getCompanyAreaId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompanyAreaId() == null;
	}

	@Override
	public BaseCompanyArea generateBase(){
		BaseCompanyArea b = new BaseCompanyArea();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompanyArea b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompanyAreaId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAreaId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompanyArea b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompanyAreaId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getAreaId();
	}

	@Override
	public void setDataFromBase(BaseCompanyArea b){
		if(b.getCompanyAreaId() != null) setCompanyAreaIdClear(b.getCompanyAreaId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getAreaId() != null) setAreaId(b.getAreaId());
	}

	@Override
	public BaseCompanyArea generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompanyArea b = new BaseCompanyArea();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompanyArea __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyAreaId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaId(GenericBase.__getInt(val));
	}

	public void setCompanyAreaId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompanyAreaId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompanyAreaIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAreaId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getAreaId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionCompanyAreaId(String op, java.lang.Integer val) {
		setConditionCompanyAreaId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyAreaId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompanyAreaId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAreaId(String op, java.lang.Integer val) {
		setConditionAreaId(op, val, CONDITION_AND);
	}

	public void setConditionAreaId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAreaId(boolean val) {
		__select_flags[2] = val;
	}


}

