package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFinancialTransactionAccount;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FinancialTransactionAccount extends AbstractTable<BaseFinancialTransactionAccount>
{

	public FinancialTransactionAccount() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "financial_transaction_accounts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFinancialTransactionAccount.CS_FINANCIAL_TRANSACTION_ACCOUNT_ID;
		__column_names[1] = BaseFinancialTransactionAccount.CS_ACCOUNT_TYPE;
		__column_names[2] = BaseFinancialTransactionAccount.CS_FINANCE_NO;
		__column_names[3] = BaseFinancialTransactionAccount.CS_ACCOUNT_NAME;
		__column_names[4] = BaseFinancialTransactionAccount.CS_REMARK;
		__column_names[5] = BaseFinancialTransactionAccount.CS_REIMBURSABLE;
		__column_names[6] = BaseFinancialTransactionAccount.CS_CREATE_TIME;
		__column_names[7] = BaseFinancialTransactionAccount.CS_ACCOUNT_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFinancialTransactionAccount b) {
		clear();
		setFinancialTransactionAccountIdClear(b.getFinancialTransactionAccountId());
	}

	public boolean isPrimaryKeyNull() {
		return getFinancialTransactionAccountId() == null;
	}

	@Override
	public BaseFinancialTransactionAccount generateBase(){
		BaseFinancialTransactionAccount b = new BaseFinancialTransactionAccount();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFinancialTransactionAccount b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAccountType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFinanceNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccountName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReimbursable(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAccountStatus(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseFinancialTransactionAccount b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFinancialTransactionAccountId();
		buff[count++] = b.getAccountType();
		buff[count++] = b.getFinanceNo();
		buff[count++] = b.getAccountName();
		buff[count++] = b.getRemark();
		buff[count++] = b.getReimbursable();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getAccountStatus();
	}

	@Override
	public void setDataFromBase(BaseFinancialTransactionAccount b){
		if(b.getFinancialTransactionAccountId() != null) setFinancialTransactionAccountIdClear(b.getFinancialTransactionAccountId());
		if(b.getAccountType() != null) setAccountType(b.getAccountType());
		if(b.getFinanceNo() != null) setFinanceNo(b.getFinanceNo());
		if(b.getAccountName() != null) setAccountName(b.getAccountName());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getReimbursable() != null) setReimbursable(b.getReimbursable());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getAccountStatus() != null) setAccountStatus(b.getAccountStatus());
	}

	@Override
	public BaseFinancialTransactionAccount generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFinancialTransactionAccount b = new BaseFinancialTransactionAccount();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFinancialTransactionAccount __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinanceNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursable(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccountStatus(GenericBase.__getInt(val));
	}

	public void setFinancialTransactionAccountId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFinancialTransactionAccountId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFinancialTransactionAccountIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAccountType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAccountType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFinanceNo(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFinanceNo() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setAccountName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getAccountName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setReimbursable(java.lang.Boolean val) {
		setCurrentData(5, val);
	}

	public java.lang.Boolean getReimbursable() {
		return GenericBase.__getBoolean(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setAccountStatus(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getAccountStatus() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionFinancialTransactionAccountId(String op, java.lang.Integer val) {
		setConditionFinancialTransactionAccountId(op, val, CONDITION_AND);
	}

	public void setConditionFinancialTransactionAccountId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFinancialTransactionAccountId(boolean val) {
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

	public void setConditionFinanceNo(String op, java.lang.String val) {
		setConditionFinanceNo(op, val, CONDITION_AND);
	}

	public void setConditionFinanceNo(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFinanceNo(boolean val) {
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

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionReimbursable(String op, java.lang.Boolean val) {
		setConditionReimbursable(op, val, CONDITION_AND);
	}

	public void setConditionReimbursable(String op, java.lang.Boolean val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectReimbursable(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAccountStatus(String op, java.lang.Integer val) {
		setConditionAccountStatus(op, val, CONDITION_AND);
	}

	public void setConditionAccountStatus(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAccountStatus(boolean val) {
		__select_flags[7] = val;
	}


}

