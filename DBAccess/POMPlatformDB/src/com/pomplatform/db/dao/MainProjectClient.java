package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseMainProjectClient;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class MainProjectClient extends AbstractTable<BaseMainProjectClient>
{

	public MainProjectClient() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 2;

		initTables();

		__tableName            = "main_project_clients";

		__key_columns          = new int[2];
		__key_columns[0] = 0;
		__key_columns[1] = 1;

		__column_names[0] = BaseMainProjectClient.CS_MAIN_PROJECT_ID;
		__column_names[1] = BaseMainProjectClient.CS_CLIENT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
	}

	public void setPrimaryKeyFromBase(BaseMainProjectClient b) {
		clear();
		setMainProjectIdClear(b.getMainProjectId());
		setClientIdClear(b.getClientId());
	}

	public boolean isPrimaryKeyNull() {
		return getMainProjectId() == null || getClientId() == null;
	}

	@Override
	public BaseMainProjectClient generateBase(){
		BaseMainProjectClient b = new BaseMainProjectClient();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMainProjectClient b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setClientId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseMainProjectClient b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getClientId();
	}

	@Override
	public void setDataFromBase(BaseMainProjectClient b){
		if(b.getMainProjectId() != null) setMainProjectIdClear(b.getMainProjectId());
		if(b.getClientId() != null) setClientIdClear(b.getClientId());
	}

	@Override
	public BaseMainProjectClient generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMainProjectClient b = new BaseMainProjectClient();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMainProjectClient __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientId(GenericBase.__getInt(val));
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMainProjectIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setClientId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getClientId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setClientIdClear(java.lang.Integer val) {
		__backup_data[1] = __current_data[1] =  val;
		__modified_flags[1] = false;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionClientId(String op, java.lang.Integer val) {
		setConditionClientId(op, val, CONDITION_AND);
	}

	public void setConditionClientId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectClientId(boolean val) {
		__select_flags[1] = val;
	}


}

