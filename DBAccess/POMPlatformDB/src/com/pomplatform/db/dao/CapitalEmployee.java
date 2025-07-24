package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCapitalEmployee;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CapitalEmployee extends AbstractTable<BaseCapitalEmployee>
{

	public CapitalEmployee() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "capital_employees";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCapitalEmployee.CS_CAPITAL_EMPLOYEE_ID;
		__column_names[1] = BaseCapitalEmployee.CS_CAPITAL_ID;
		__column_names[2] = BaseCapitalEmployee.CS_EMPLOYEE_ID;
		__column_names[3] = BaseCapitalEmployee.CS_MONEY;
		__column_names[4] = BaseCapitalEmployee.CS_OPERATOR_ID;
		__column_names[5] = BaseCapitalEmployee.CS_CREAT_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCapitalEmployee b) {
		clear();
		setCapitalEmployeeIdClear(b.getCapitalEmployeeId());
	}

	public boolean isPrimaryKeyNull() {
		return getCapitalEmployeeId() == null;
	}

	@Override
	public BaseCapitalEmployee generateBase(){
		BaseCapitalEmployee b = new BaseCapitalEmployee();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCapitalEmployee b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCapitalEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreatTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCapitalEmployee b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCapitalEmployeeId();
		buff[count++] = b.getCapitalId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getMoney();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreatTime());
	}

	@Override
	public void setDataFromBase(BaseCapitalEmployee b){
		if(b.getCapitalEmployeeId() != null) setCapitalEmployeeIdClear(b.getCapitalEmployeeId());
		if(b.getCapitalId() != null) setCapitalId(b.getCapitalId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getMoney() != null) setMoney(b.getMoney());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreatTime() != null) setCreatTime(b.getCreatTime());
	}

	@Override
	public BaseCapitalEmployee generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCapitalEmployee b = new BaseCapitalEmployee();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCapitalEmployee __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreatTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCapitalEmployeeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCapitalEmployeeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCapitalEmployeeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCapitalId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCapitalId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMoney(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getMoney() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreatTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getCreatTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setConditionCapitalEmployeeId(String op, java.lang.Integer val) {
		setConditionCapitalEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCapitalEmployeeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCapitalId(String op, java.lang.Integer val) {
		setConditionCapitalId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCapitalId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMoney(String op, java.math.BigDecimal val) {
		setConditionMoney(op, val, CONDITION_AND);
	}

	public void setConditionMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMoney(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreatTime(String op, java.util.Date val) {
		setConditionCreatTime(op, val, CONDITION_AND);
	}

	public void setConditionCreatTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreatTime(boolean val) {
		__select_flags[5] = val;
	}


}

