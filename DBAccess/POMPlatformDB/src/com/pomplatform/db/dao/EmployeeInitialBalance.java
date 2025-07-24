package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeInitialBalance;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeInitialBalance extends AbstractTable<BaseEmployeeInitialBalance>
{

	public EmployeeInitialBalance() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "employee_initial_balances";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeInitialBalance.CS_EMPLOYEE_INITIAL_BALANCE_ID;
		__column_names[1] = BaseEmployeeInitialBalance.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeInitialBalance.CS_INITIAL_BALANCE;
		__column_names[3] = BaseEmployeeInitialBalance.CS_HAPPEN_DATE;
		__column_names[4] = BaseEmployeeInitialBalance.CS_OPERATOR;
		__column_names[5] = BaseEmployeeInitialBalance.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeInitialBalance b) {
		clear();
		setEmployeeInitialBalanceIdClear(b.getEmployeeInitialBalanceId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeInitialBalanceId() == null;
	}

	@Override
	public BaseEmployeeInitialBalance generateBase(){
		BaseEmployeeInitialBalance b = new BaseEmployeeInitialBalance();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeInitialBalance b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeInitialBalanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInitialBalance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeInitialBalance b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeInitialBalanceId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getInitialBalance();
		buff[count++] = generateTimestampFromDate(b.getHappenDate());
		buff[count++] = b.getOperator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseEmployeeInitialBalance b){
		if(b.getEmployeeInitialBalanceId() != null) setEmployeeInitialBalanceIdClear(b.getEmployeeInitialBalanceId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getInitialBalance() != null) setInitialBalance(b.getInitialBalance());
		if(b.getHappenDate() != null) setHappenDate(b.getHappenDate());
		if(b.getOperator() != null) setOperator(b.getOperator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseEmployeeInitialBalance generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeInitialBalance b = new BaseEmployeeInitialBalance();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeInitialBalance __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeInitialBalanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInitialBalance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setEmployeeInitialBalanceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeInitialBalanceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeInitialBalanceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setInitialBalance(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getInitialBalance() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setHappenDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getHappenDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setOperator(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperator() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionEmployeeInitialBalanceId(String op, java.lang.Integer val) {
		setConditionEmployeeInitialBalanceId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeInitialBalanceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeInitialBalanceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionInitialBalance(String op, java.math.BigDecimal val) {
		setConditionInitialBalance(op, val, CONDITION_AND);
	}

	public void setConditionInitialBalance(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectInitialBalance(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionHappenDate(String op, java.util.Date val) {
		setConditionHappenDate(op, val, CONDITION_AND);
	}

	public void setConditionHappenDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHappenDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperator(String op, java.lang.Integer val) {
		setConditionOperator(op, val, CONDITION_AND);
	}

	public void setConditionOperator(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperator(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[5] = val;
	}


}

