package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryOfWorkYear;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryOfWorkYear extends AbstractTable<BaseSalaryOfWorkYear>
{

	public SalaryOfWorkYear() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "salary_of_work_years";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryOfWorkYear.CS_SALARY_OF_WORK_YEAR_ID;
		__column_names[1] = BaseSalaryOfWorkYear.CS_EMPLOYEE_ID;
		__column_names[2] = BaseSalaryOfWorkYear.CS_YEAR;
		__column_names[3] = BaseSalaryOfWorkYear.CS_MONTH;
		__column_names[4] = BaseSalaryOfWorkYear.CS_WORK_YEARS;
		__column_names[5] = BaseSalaryOfWorkYear.CS_WORK_MONEY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryOfWorkYear b) {
		clear();
		setSalaryOfWorkYearIdClear(b.getSalaryOfWorkYearId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryOfWorkYearId() == null;
	}

	@Override
	public BaseSalaryOfWorkYear generateBase(){
		BaseSalaryOfWorkYear b = new BaseSalaryOfWorkYear();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryOfWorkYear b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryOfWorkYearId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkYears(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWorkMoney(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryOfWorkYear b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryOfWorkYearId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getWorkYears();
		buff[count++] = b.getWorkMoney();
	}

	@Override
	public void setDataFromBase(BaseSalaryOfWorkYear b){
		if(b.getSalaryOfWorkYearId() != null) setSalaryOfWorkYearIdClear(b.getSalaryOfWorkYearId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getWorkYears() != null) setWorkYears(b.getWorkYears());
		if(b.getWorkMoney() != null) setWorkMoney(b.getWorkMoney());
	}

	@Override
	public BaseSalaryOfWorkYear generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryOfWorkYear b = new BaseSalaryOfWorkYear();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryOfWorkYear __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryOfWorkYearId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkYears(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkMoney(GenericBase.__getString(val));
	}

	public void setSalaryOfWorkYearId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryOfWorkYearId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryOfWorkYearIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setWorkYears(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getWorkYears() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setWorkMoney(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getWorkMoney() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setConditionSalaryOfWorkYearId(String op, java.lang.Integer val) {
		setConditionSalaryOfWorkYearId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryOfWorkYearId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryOfWorkYearId(boolean val) {
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

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionWorkYears(String op, java.lang.String val) {
		setConditionWorkYears(op, val, CONDITION_AND);
	}

	public void setConditionWorkYears(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectWorkYears(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionWorkMoney(String op, java.lang.String val) {
		setConditionWorkMoney(op, val, CONDITION_AND);
	}

	public void setConditionWorkMoney(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectWorkMoney(boolean val) {
		__select_flags[5] = val;
	}


}

