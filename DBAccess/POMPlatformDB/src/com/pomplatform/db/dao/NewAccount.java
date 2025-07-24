package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseNewAccount;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class NewAccount extends AbstractTable<BaseNewAccount>
{

	public NewAccount() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "new_accounts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseNewAccount.CS_ACCOUNT_ID;
		__column_names[1] = BaseNewAccount.CS_ACCOUNT_TYPE;
		__column_names[2] = BaseNewAccount.CS_ACCOUNT_CODE;
		__column_names[3] = BaseNewAccount.CS_ACCOUNT_NAME;
		__column_names[4] = BaseNewAccount.CS_OWNER_ID;
		__column_names[5] = BaseNewAccount.CS_STATUS;
		__column_names[6] = BaseNewAccount.CS_BALANCE;
		__column_names[7] = BaseNewAccount.CS_FREEZING_BALANCE;
		__column_names[8] = BaseNewAccount.CS_OPERATOR;
		__column_names[9] = BaseNewAccount.CS_CREATE_TIME;
		__column_names[10] = BaseNewAccount.CS_ORDER_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseNewAccount b) {
		clear();
		setAccountIdClear(b.getAccountId());
	}

	public boolean isPrimaryKeyNull() {
		return getAccountId() == null;
	}

	@Override
	public BaseNewAccount generateBase(){
		BaseNewAccount b = new BaseNewAccount();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseNewAccount b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccountName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOwnerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBalance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFreezingBalance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrderId(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseNewAccount b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAccountId();
		buff[count++] = b.getAccountType();
		buff[count++] = b.getAccountCode();
		buff[count++] = b.getAccountName();
		buff[count++] = b.getOwnerId();
		buff[count++] = b.getStatus();
		buff[count++] = b.getBalance();
		buff[count++] = b.getFreezingBalance();
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOrderId();
	}

	@Override
	public void setDataFromBase(BaseNewAccount b){
		if(b.getAccountId() != null) setAccountIdClear(b.getAccountId());
		if(b.getAccountType() != null) setAccountType(b.getAccountType());
		if(b.getAccountCode() != null) setAccountCode(b.getAccountCode());
		if(b.getAccountName() != null) setAccountName(b.getAccountName());
		if(b.getOwnerId() != null) setOwnerId(b.getOwnerId());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getBalance() != null) setBalance(b.getBalance());
		if(b.getFreezingBalance() != null) setFreezingBalance(b.getFreezingBalance());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOrderId() != null) setOrderId(b.getOrderId());
	}

	@Override
	public BaseNewAccount generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseNewAccount b = new BaseNewAccount();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseNewAccount __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOwnerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBalance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFreezingBalance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderId(GenericBase.__getString(val));
	}

	public void setAccountId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAccountId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAccountIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAccountType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAccountType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAccountCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getAccountCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setAccountName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getAccountName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setOwnerId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOwnerId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setBalance(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getBalance() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setFreezingBalance(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getFreezingBalance() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setOrderId(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getOrderId() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setConditionAccountId(String op, java.lang.Integer val) {
		setConditionAccountId(op, val, CONDITION_AND);
	}

	public void setConditionAccountId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAccountId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAccountType(String op, java.lang.Integer val) {
		setConditionAccountType(op, val, CONDITION_AND);
	}

	public void setConditionAccountType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAccountType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAccountCode(String op, java.lang.String val) {
		setConditionAccountCode(op, val, CONDITION_AND);
	}

	public void setConditionAccountCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAccountCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAccountName(String op, java.lang.String val) {
		setConditionAccountName(op, val, CONDITION_AND);
	}

	public void setConditionAccountName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAccountName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOwnerId(String op, java.lang.Integer val) {
		setConditionOwnerId(op, val, CONDITION_AND);
	}

	public void setConditionOwnerId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOwnerId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionBalance(String op, java.math.BigDecimal val) {
		setConditionBalance(op, val, CONDITION_AND);
	}

	public void setConditionBalance(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectBalance(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionFreezingBalance(String op, java.math.BigDecimal val) {
		setConditionFreezingBalance(op, val, CONDITION_AND);
	}

	public void setConditionFreezingBalance(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFreezingBalance(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOrderId(String op, java.lang.String val) {
		setConditionOrderId(op, val, CONDITION_AND);
	}

	public void setConditionOrderId(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOrderId(boolean val) {
		__select_flags[10] = val;
	}


}

