package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCashierCompany;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CashierCompany extends AbstractTable<BaseCashierCompany>
{

	public CashierCompany() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 4;

		initTables();

		__tableName            = "cashier_companys";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCashierCompany.CS_CASHIER_COMPANY_ID;
		__column_names[1] = BaseCashierCompany.CS_EMPLOYEE_ID;
		__column_names[2] = BaseCashierCompany.CS_COMPANY_ID;
		__column_names[3] = BaseCashierCompany.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCashierCompany b) {
		clear();
		setCashierCompanyIdClear(b.getCashierCompanyId());
	}

	public boolean isPrimaryKeyNull() {
		return getCashierCompanyId() == null;
	}

	@Override
	public BaseCashierCompany generateBase(){
		BaseCashierCompany b = new BaseCashierCompany();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCashierCompany b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCashierCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCashierCompany b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCashierCompanyId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getCompanyId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseCashierCompany b){
		if(b.getCashierCompanyId() != null) setCashierCompanyIdClear(b.getCashierCompanyId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseCashierCompany generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCashierCompany b = new BaseCashierCompany();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCashierCompany __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCashierCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCashierCompanyId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCashierCompanyId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCashierCompanyIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setConditionCashierCompanyId(String op, java.lang.Integer val) {
		setConditionCashierCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCashierCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCashierCompanyId(boolean val) {
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

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[3] = val;
	}


}

