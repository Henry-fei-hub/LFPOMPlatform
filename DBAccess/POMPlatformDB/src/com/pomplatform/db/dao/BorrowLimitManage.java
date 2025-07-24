package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBorrowLimitManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BorrowLimitManage extends AbstractTable<BaseBorrowLimitManage>
{

	public BorrowLimitManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "borrow_limit_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBorrowLimitManage.CS_BORROW_LIMIT_MANAGE_ID;
		__column_names[1] = BaseBorrowLimitManage.CS_EMPLOYEE_ID;
		__column_names[2] = BaseBorrowLimitManage.CS_BORROW_LIMIT_MONEY;
		__column_names[3] = BaseBorrowLimitManage.CS_CREATE_EMPLOYEE_ID;
		__column_names[4] = BaseBorrowLimitManage.CS_CREATE_DATE;
		__column_names[5] = BaseBorrowLimitManage.CS_UPDATE_EMPLOYEE_ID;
		__column_names[6] = BaseBorrowLimitManage.CS_UPDATE_DATE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBorrowLimitManage b) {
		clear();
		setBorrowLimitManageIdClear(b.getBorrowLimitManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getBorrowLimitManageId() == null;
	}

	@Override
	public BaseBorrowLimitManage generateBase(){
		BaseBorrowLimitManage b = new BaseBorrowLimitManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBorrowLimitManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBorrowLimitManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBorrowLimitMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUpdateDate(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseBorrowLimitManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBorrowLimitManageId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getBorrowLimitMoney();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateDate());
		buff[count++] = b.getUpdateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getUpdateDate());
	}

	@Override
	public void setDataFromBase(BaseBorrowLimitManage b){
		if(b.getBorrowLimitManageId() != null) setBorrowLimitManageIdClear(b.getBorrowLimitManageId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getBorrowLimitMoney() != null) setBorrowLimitMoney(b.getBorrowLimitMoney());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateDate() != null) setCreateDate(b.getCreateDate());
		if(b.getUpdateEmployeeId() != null) setUpdateEmployeeId(b.getUpdateEmployeeId());
		if(b.getUpdateDate() != null) setUpdateDate(b.getUpdateDate());
	}

	@Override
	public BaseBorrowLimitManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBorrowLimitManage b = new BaseBorrowLimitManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBorrowLimitManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBorrowLimitManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBorrowLimitMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateDate(GenericBase.__getDateFromSQL(val));
	}

	public void setBorrowLimitManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBorrowLimitManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBorrowLimitManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBorrowLimitMoney(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getBorrowLimitMoney() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCreateDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setUpdateEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getUpdateEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setUpdateDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setConditionBorrowLimitManageId(String op, java.lang.Integer val) {
		setConditionBorrowLimitManageId(op, val, CONDITION_AND);
	}

	public void setConditionBorrowLimitManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBorrowLimitManageId(boolean val) {
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

	public void setConditionBorrowLimitMoney(String op, java.math.BigDecimal val) {
		setConditionBorrowLimitMoney(op, val, CONDITION_AND);
	}

	public void setConditionBorrowLimitMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBorrowLimitMoney(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCreateDate(String op, java.util.Date val) {
		setConditionCreateDate(op, val, CONDITION_AND);
	}

	public void setConditionCreateDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionUpdateEmployeeId(String op, java.lang.Integer val) {
		setConditionUpdateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionUpdateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectUpdateEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionUpdateDate(String op, java.util.Date val) {
		setConditionUpdateDate(op, val, CONDITION_AND);
	}

	public void setConditionUpdateDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateDate(boolean val) {
		__select_flags[6] = val;
	}


}

