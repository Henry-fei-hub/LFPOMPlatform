package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseContractClient;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ContractClient extends AbstractTable<BaseContractClient>
{

	public ContractClient() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "contract_clients";

		__key_columns          = new int[2];
		__key_columns[0] = 0;
		__key_columns[1] = 1;

		__column_names[0] = BaseContractClient.CS_CONTRACT_ID;
		__column_names[1] = BaseContractClient.CS_CLIENT_ID;
		__column_names[2] = BaseContractClient.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
	}

	public void setPrimaryKeyFromBase(BaseContractClient b) {
		clear();
		setContractIdClear(b.getContractId());
		setClientIdClear(b.getClientId());
	}

	public boolean isPrimaryKeyNull() {
		return getContractId() == null || getClientId() == null;
	}

	@Override
	public BaseContractClient generateBase(){
		BaseContractClient b = new BaseContractClient();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseContractClient b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setClientId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseContractClient b, Object[] buff){
		int count = 0;
		buff[count++] = b.getContractId();
		buff[count++] = b.getClientId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseContractClient b){
		if(b.getContractId() != null) setContractIdClear(b.getContractId());
		if(b.getClientId() != null) setClientIdClear(b.getClientId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseContractClient generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseContractClient b = new BaseContractClient();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseContractClient __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setContractIdClear(java.lang.Integer val) {
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

	public void setCreateTime(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
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

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[2] = val;
	}


}

