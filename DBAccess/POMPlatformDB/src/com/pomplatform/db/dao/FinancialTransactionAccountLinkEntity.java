package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFinancialTransactionAccountLinkEntity;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FinancialTransactionAccountLinkEntity extends AbstractTable<BaseFinancialTransactionAccountLinkEntity>
{

	public FinancialTransactionAccountLinkEntity() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "financial_transaction_account_link_entities";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFinancialTransactionAccountLinkEntity.CS_FINANCIAL_TRANSACTION_ACCOUNT_LINK_ENTITY_ID;
		__column_names[1] = BaseFinancialTransactionAccountLinkEntity.CS_FINANCIAL_TRANSACTION_ACCOUNT_ID;
		__column_names[2] = BaseFinancialTransactionAccountLinkEntity.CS_ACCOUNT_TYPE;
		__column_names[3] = BaseFinancialTransactionAccountLinkEntity.CS_ENTITY_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFinancialTransactionAccountLinkEntity b) {
		clear();
		setFinancialTransactionAccountLinkEntityIdClear(b.getFinancialTransactionAccountLinkEntityId());
	}

	public boolean isPrimaryKeyNull() {
		return getFinancialTransactionAccountLinkEntityId() == null;
	}

	@Override
	public BaseFinancialTransactionAccountLinkEntity generateBase(){
		BaseFinancialTransactionAccountLinkEntity b = new BaseFinancialTransactionAccountLinkEntity();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFinancialTransactionAccountLinkEntity b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFinancialTransactionAccountLinkEntityId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEntityId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseFinancialTransactionAccountLinkEntity b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFinancialTransactionAccountLinkEntityId();
		buff[count++] = b.getFinancialTransactionAccountId();
		buff[count++] = b.getAccountType();
		buff[count++] = b.getEntityId();
	}

	@Override
	public void setDataFromBase(BaseFinancialTransactionAccountLinkEntity b){
		if(b.getFinancialTransactionAccountLinkEntityId() != null) setFinancialTransactionAccountLinkEntityIdClear(b.getFinancialTransactionAccountLinkEntityId());
		if(b.getFinancialTransactionAccountId() != null) setFinancialTransactionAccountId(b.getFinancialTransactionAccountId());
		if(b.getAccountType() != null) setAccountType(b.getAccountType());
		if(b.getEntityId() != null) setEntityId(b.getEntityId());
	}

	@Override
	public BaseFinancialTransactionAccountLinkEntity generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFinancialTransactionAccountLinkEntity b = new BaseFinancialTransactionAccountLinkEntity();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFinancialTransactionAccountLinkEntity __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialTransactionAccountLinkEntityId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEntityId(GenericBase.__getInt(val));
	}

	public void setFinancialTransactionAccountLinkEntityId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFinancialTransactionAccountLinkEntityId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFinancialTransactionAccountLinkEntityIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setFinancialTransactionAccountId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAccountType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getAccountType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEntityId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEntityId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setConditionFinancialTransactionAccountLinkEntityId(String op, java.lang.Integer val) {
		setConditionFinancialTransactionAccountLinkEntityId(op, val, CONDITION_AND);
	}

	public void setConditionFinancialTransactionAccountLinkEntityId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFinancialTransactionAccountLinkEntityId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionFinancialTransactionAccountId(String op, java.lang.Integer val) {
		setConditionFinancialTransactionAccountId(op, val, CONDITION_AND);
	}

	public void setConditionFinancialTransactionAccountId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectFinancialTransactionAccountId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAccountType(String op, java.lang.Integer val) {
		setConditionAccountType(op, val, CONDITION_AND);
	}

	public void setConditionAccountType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAccountType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEntityId(String op, java.lang.Integer val) {
		setConditionEntityId(op, val, CONDITION_AND);
	}

	public void setConditionEntityId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEntityId(boolean val) {
		__select_flags[3] = val;
	}


}

