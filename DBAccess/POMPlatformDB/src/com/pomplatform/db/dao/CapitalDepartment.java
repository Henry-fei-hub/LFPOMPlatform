package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCapitalDepartment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CapitalDepartment extends AbstractTable<BaseCapitalDepartment>
{

	public CapitalDepartment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "capital_departments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCapitalDepartment.CS_CAPITAL_DEPARTMENT_ID;
		__column_names[1] = BaseCapitalDepartment.CS_CAPITAL_ID;
		__column_names[2] = BaseCapitalDepartment.CS_DEPARTMENT_ID;
		__column_names[3] = BaseCapitalDepartment.CS_MONEY;
		__column_names[4] = BaseCapitalDepartment.CS_OPERATOR_ID;
		__column_names[5] = BaseCapitalDepartment.CS_CREAT_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCapitalDepartment b) {
		clear();
		setCapitalDepartmentIdClear(b.getCapitalDepartmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getCapitalDepartmentId() == null;
	}

	@Override
	public BaseCapitalDepartment generateBase(){
		BaseCapitalDepartment b = new BaseCapitalDepartment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCapitalDepartment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCapitalDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCapitalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreatTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCapitalDepartment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCapitalDepartmentId();
		buff[count++] = b.getCapitalId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getMoney();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreatTime());
	}

	@Override
	public void setDataFromBase(BaseCapitalDepartment b){
		if(b.getCapitalDepartmentId() != null) setCapitalDepartmentIdClear(b.getCapitalDepartmentId());
		if(b.getCapitalId() != null) setCapitalId(b.getCapitalId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getMoney() != null) setMoney(b.getMoney());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreatTime() != null) setCreatTime(b.getCreatTime());
	}

	@Override
	public BaseCapitalDepartment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCapitalDepartment b = new BaseCapitalDepartment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCapitalDepartment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreatTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCapitalDepartmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCapitalDepartmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCapitalDepartmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCapitalId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCapitalId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getDepartmentId() {
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

	public void setConditionCapitalDepartmentId(String op, java.lang.Integer val) {
		setConditionCapitalDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionCapitalDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCapitalDepartmentId(boolean val) {
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

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
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

