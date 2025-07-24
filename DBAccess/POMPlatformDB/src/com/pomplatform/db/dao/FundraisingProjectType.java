package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFundraisingProjectType;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FundraisingProjectType extends AbstractTable<BaseFundraisingProjectType>
{

	public FundraisingProjectType() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 2;

		initTables();

		__tableName            = "fundraising_project_types";

		__key_columns          = new int[0];

		__column_names[0] = BaseFundraisingProjectType.CS_FUNDRAISING_PROJECT_TYPE_ID;
		__column_names[1] = BaseFundraisingProjectType.CS_FUNDRAISING_PROJECT_TYPE_NAME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFundraisingProjectType b) {
		clear();
	}

	public boolean isPrimaryKeyNull() {
		return true;
	}

	@Override
	public BaseFundraisingProjectType generateBase(){
		BaseFundraisingProjectType b = new BaseFundraisingProjectType();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFundraisingProjectType b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFundraisingProjectTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFundraisingProjectTypeName(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseFundraisingProjectType b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFundraisingProjectTypeId();
		buff[count++] = b.getFundraisingProjectTypeName();
	}

	@Override
	public void setDataFromBase(BaseFundraisingProjectType b){
		if(b.getFundraisingProjectTypeId() != null) setFundraisingProjectTypeId(b.getFundraisingProjectTypeId());
		if(b.getFundraisingProjectTypeName() != null) setFundraisingProjectTypeName(b.getFundraisingProjectTypeName());
	}

	@Override
	public BaseFundraisingProjectType generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFundraisingProjectType b = new BaseFundraisingProjectType();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFundraisingProjectType __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundraisingProjectTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFundraisingProjectTypeName(GenericBase.__getString(val));
	}

	public void setFundraisingProjectTypeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFundraisingProjectTypeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFundraisingProjectTypeName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getFundraisingProjectTypeName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setConditionFundraisingProjectTypeId(String op, java.lang.Integer val) {
		setConditionFundraisingProjectTypeId(op, val, CONDITION_AND);
	}

	public void setConditionFundraisingProjectTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFundraisingProjectTypeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFundraisingProjectTypeName(String op, java.lang.String val) {
		setConditionFundraisingProjectTypeName(op, val, CONDITION_AND);
	}

	public void setConditionFundraisingProjectTypeName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFundraisingProjectTypeName(boolean val) {
		__select_flags[1] = val;
	}


}

