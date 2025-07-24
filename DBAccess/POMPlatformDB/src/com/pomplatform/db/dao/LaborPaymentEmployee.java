package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseLaborPaymentEmployee;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class LaborPaymentEmployee extends AbstractTable<BaseLaborPaymentEmployee>
{

	public LaborPaymentEmployee() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "labor_payment_employees";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseLaborPaymentEmployee.CS_LABOR_PAYMENT_EMPLOYEE_ID;
		__column_names[1] = BaseLaborPaymentEmployee.CS_EMPLOYEE_ID;
		__column_names[2] = BaseLaborPaymentEmployee.CS_YEAR;
		__column_names[3] = BaseLaborPaymentEmployee.CS_MONTH;
		__column_names[4] = BaseLaborPaymentEmployee.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseLaborPaymentEmployee b) {
		clear();
		setLaborPaymentEmployeeIdClear(b.getLaborPaymentEmployeeId());
	}

	public boolean isPrimaryKeyNull() {
		return getLaborPaymentEmployeeId() == null;
	}

	@Override
	public BaseLaborPaymentEmployee generateBase(){
		BaseLaborPaymentEmployee b = new BaseLaborPaymentEmployee();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseLaborPaymentEmployee b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setLaborPaymentEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseLaborPaymentEmployee b, Object[] buff){
		int count = 0;
		buff[count++] = b.getLaborPaymentEmployeeId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseLaborPaymentEmployee b){
		if(b.getLaborPaymentEmployeeId() != null) setLaborPaymentEmployeeIdClear(b.getLaborPaymentEmployeeId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseLaborPaymentEmployee generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseLaborPaymentEmployee b = new BaseLaborPaymentEmployee();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseLaborPaymentEmployee __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLaborPaymentEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setLaborPaymentEmployeeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getLaborPaymentEmployeeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setLaborPaymentEmployeeIdClear(java.lang.Integer val) {
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

	public void setRemark(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionLaborPaymentEmployeeId(String op, java.lang.Integer val) {
		setConditionLaborPaymentEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionLaborPaymentEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectLaborPaymentEmployeeId(boolean val) {
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

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[4] = val;
	}


}

