package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFunctionBusiness;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FunctionBusiness extends AbstractTable<BaseFunctionBusiness>
{

	public FunctionBusiness() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "function_business";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFunctionBusiness.CS_FUNCTION_BUSINESS_ID;
		__column_names[1] = BaseFunctionBusiness.CS_PERSONNEL_BUSINESS_ID;
		__column_names[2] = BaseFunctionBusiness.CS_EMPLOYEE_ID;
		__column_names[3] = BaseFunctionBusiness.CS_FUNCTION_ID;
		__column_names[4] = BaseFunctionBusiness.CS_FUNCTION_TYPE;
		__column_names[5] = BaseFunctionBusiness.CS_START_DATE;
		__column_names[6] = BaseFunctionBusiness.CS_END_DATE;
		__column_names[7] = BaseFunctionBusiness.CS_DAYS;
		__column_names[8] = BaseFunctionBusiness.CS_IS_COMPLETED;
		__column_names[9] = BaseFunctionBusiness.CS_IS_FOREVER;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFunctionBusiness b) {
		clear();
		setFunctionBusinessIdClear(b.getFunctionBusinessId());
	}

	public boolean isPrimaryKeyNull() {
		return getFunctionBusinessId() == null;
	}

	@Override
	public BaseFunctionBusiness generateBase(){
		BaseFunctionBusiness b = new BaseFunctionBusiness();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFunctionBusiness b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFunctionBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFunctionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFunctionType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsForever(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseFunctionBusiness b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFunctionBusinessId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getFunctionId();
		buff[count++] = b.getFunctionType();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getDays();
		buff[count++] = b.getIsCompleted();
		buff[count++] = b.getIsForever();
	}

	@Override
	public void setDataFromBase(BaseFunctionBusiness b){
		if(b.getFunctionBusinessId() != null) setFunctionBusinessIdClear(b.getFunctionBusinessId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getFunctionId() != null) setFunctionId(b.getFunctionId());
		if(b.getFunctionType() != null) setFunctionType(b.getFunctionType());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getDays() != null) setDays(b.getDays());
		if(b.getIsCompleted() != null) setIsCompleted(b.getIsCompleted());
		if(b.getIsForever() != null) setIsForever(b.getIsForever());
	}

	@Override
	public BaseFunctionBusiness generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFunctionBusiness b = new BaseFunctionBusiness();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFunctionBusiness __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFunctionBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFunctionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFunctionType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsForever(GenericBase.__getBoolean(val));
	}

	public void setFunctionBusinessId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFunctionBusinessId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFunctionBusinessIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setFunctionId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getFunctionId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setFunctionType(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getFunctionType() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setDays(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getDays() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setIsCompleted(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getIsCompleted() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setIsForever(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getIsForever() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setConditionFunctionBusinessId(String op, java.lang.Integer val) {
		setConditionFunctionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionFunctionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFunctionBusinessId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
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

	public void setConditionFunctionId(String op, java.lang.Integer val) {
		setConditionFunctionId(op, val, CONDITION_AND);
	}

	public void setConditionFunctionId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectFunctionId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionFunctionType(String op, java.lang.Integer val) {
		setConditionFunctionType(op, val, CONDITION_AND);
	}

	public void setConditionFunctionType(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectFunctionType(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionDays(String op, java.math.BigDecimal val) {
		setConditionDays(op, val, CONDITION_AND);
	}

	public void setConditionDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectDays(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val) {
		setConditionIsCompleted(op, val, CONDITION_AND);
	}

	public void setConditionIsCompleted(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectIsCompleted(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionIsForever(String op, java.lang.Boolean val) {
		setConditionIsForever(op, val, CONDITION_AND);
	}

	public void setConditionIsForever(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectIsForever(boolean val) {
		__select_flags[9] = val;
	}


}

