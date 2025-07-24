package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAccount;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Account extends AbstractTable<BaseAccount>
{

	public Account() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 15;

		initTables();

		__tableName            = "accounts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAccount.CS_ACCOUNT_ID;
		__column_names[1] = BaseAccount.CS_ACCOUNT_TYPE;
		__column_names[2] = BaseAccount.CS_ACCOUNT_CODE;
		__column_names[3] = BaseAccount.CS_ACCOUNT_NAME;
		__column_names[4] = BaseAccount.CS_LEAVEL;
		__column_names[5] = BaseAccount.CS_OWNER_ID;
		__column_names[6] = BaseAccount.CS_STATUS;
		__column_names[7] = BaseAccount.CS_BALANCE;
		__column_names[8] = BaseAccount.CS_FROZEN_AMOUNT;
		__column_names[9] = BaseAccount.CS_OPERATE_EMPLOYEE_ID;
		__column_names[10] = BaseAccount.CS_CREATE_TIME;
		__column_names[11] = BaseAccount.CS_DESTORY_TIME;
		__column_names[12] = BaseAccount.CS_IS_DEFAULT;
		__column_names[13] = BaseAccount.CS_CAN_SUM;
		__column_names[14] = BaseAccount.CS_DESTORY_EMPLOYEE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAccount b) {
		clear();
		setAccountIdClear(b.getAccountId());
	}

	public boolean isPrimaryKeyNull() {
		return getAccountId() == null;
	}

	@Override
	public BaseAccount generateBase(){
		BaseAccount b = new BaseAccount();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAccount b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccountName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLeavel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOwnerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBalance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFrozenAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDestoryTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsDefault(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCanSum(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setDestoryEmployeeId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseAccount b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAccountId();
		buff[count++] = b.getAccountType();
		buff[count++] = b.getAccountCode();
		buff[count++] = b.getAccountName();
		buff[count++] = b.getLeavel();
		buff[count++] = b.getOwnerId();
		buff[count++] = b.getStatus();
		buff[count++] = b.getBalance();
		buff[count++] = b.getFrozenAmount();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getDestoryTime());
		buff[count++] = b.getIsDefault();
		buff[count++] = b.getCanSum();
		buff[count++] = b.getDestoryEmployeeId();
	}

	@Override
	public void setDataFromBase(BaseAccount b){
		if(b.getAccountId() != null) setAccountIdClear(b.getAccountId());
		if(b.getAccountType() != null) setAccountType(b.getAccountType());
		if(b.getAccountCode() != null) setAccountCode(b.getAccountCode());
		if(b.getAccountName() != null) setAccountName(b.getAccountName());
		if(b.getLeavel() != null) setLeavel(b.getLeavel());
		if(b.getOwnerId() != null) setOwnerId(b.getOwnerId());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getBalance() != null) setBalance(b.getBalance());
		if(b.getFrozenAmount() != null) setFrozenAmount(b.getFrozenAmount());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getDestoryTime() != null) setDestoryTime(b.getDestoryTime());
		if(b.getIsDefault() != null) setIsDefault(b.getIsDefault());
		if(b.getCanSum() != null) setCanSum(b.getCanSum());
		if(b.getDestoryEmployeeId() != null) setDestoryEmployeeId(b.getDestoryEmployeeId());
	}

	@Override
	public BaseAccount generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAccount b = new BaseAccount();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAccount __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeavel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOwnerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBalance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFrozenAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDestoryTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsDefault(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCanSum(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDestoryEmployeeId(GenericBase.__getInt(val));
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

	public void setLeavel(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getLeavel() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOwnerId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOwnerId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setBalance(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getBalance() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setFrozenAmount(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getFrozenAmount() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setDestoryTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getDestoryTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setIsDefault(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getIsDefault() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setCanSum(java.lang.Boolean val) {
		setCurrentData(13, val);
	}

	public java.lang.Boolean getCanSum() {
		return GenericBase.__getBoolean(__current_data[13]);
	}

	public void setDestoryEmployeeId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getDestoryEmployeeId() {
		return GenericBase.__getInt(__current_data[14]);
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

	public void setConditionLeavel(String op, java.lang.Integer val) {
		setConditionLeavel(op, val, CONDITION_AND);
	}

	public void setConditionLeavel(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectLeavel(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOwnerId(String op, java.lang.Integer val) {
		setConditionOwnerId(op, val, CONDITION_AND);
	}

	public void setConditionOwnerId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOwnerId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionBalance(String op, java.math.BigDecimal val) {
		setConditionBalance(op, val, CONDITION_AND);
	}

	public void setConditionBalance(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectBalance(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionFrozenAmount(String op, java.math.BigDecimal val) {
		setConditionFrozenAmount(op, val, CONDITION_AND);
	}

	public void setConditionFrozenAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectFrozenAmount(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionDestoryTime(String op, java.util.Date val) {
		setConditionDestoryTime(op, val, CONDITION_AND);
	}

	public void setConditionDestoryTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectDestoryTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionIsDefault(String op, java.lang.Boolean val) {
		setConditionIsDefault(op, val, CONDITION_AND);
	}

	public void setConditionIsDefault(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIsDefault(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCanSum(String op, java.lang.Boolean val) {
		setConditionCanSum(op, val, CONDITION_AND);
	}

	public void setConditionCanSum(String op, java.lang.Boolean val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectCanSum(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionDestoryEmployeeId(String op, java.lang.Integer val) {
		setConditionDestoryEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionDestoryEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectDestoryEmployeeId(boolean val) {
		__select_flags[14] = val;
	}


}

