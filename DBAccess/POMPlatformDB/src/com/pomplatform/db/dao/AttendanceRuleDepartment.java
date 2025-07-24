package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAttendanceRuleDepartment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AttendanceRuleDepartment extends AbstractTable<BaseAttendanceRuleDepartment>
{

	public AttendanceRuleDepartment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "attendance_rule_departments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAttendanceRuleDepartment.CS_ATTENDANCE_RULE_DEPARTMENT_ID;
		__column_names[1] = BaseAttendanceRuleDepartment.CS_ATTENDANCE_RULE_ID;
		__column_names[2] = BaseAttendanceRuleDepartment.CS_DEPARTMENT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAttendanceRuleDepartment b) {
		clear();
		setAttendanceRuleDepartmentIdClear(b.getAttendanceRuleDepartmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getAttendanceRuleDepartmentId() == null;
	}

	@Override
	public BaseAttendanceRuleDepartment generateBase(){
		BaseAttendanceRuleDepartment b = new BaseAttendanceRuleDepartment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAttendanceRuleDepartment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAttendanceRuleDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttendanceRuleId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseAttendanceRuleDepartment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAttendanceRuleDepartmentId();
		buff[count++] = b.getAttendanceRuleId();
		buff[count++] = b.getDepartmentId();
	}

	@Override
	public void setDataFromBase(BaseAttendanceRuleDepartment b){
		if(b.getAttendanceRuleDepartmentId() != null) setAttendanceRuleDepartmentIdClear(b.getAttendanceRuleDepartmentId());
		if(b.getAttendanceRuleId() != null) setAttendanceRuleId(b.getAttendanceRuleId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
	}

	@Override
	public BaseAttendanceRuleDepartment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAttendanceRuleDepartment b = new BaseAttendanceRuleDepartment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAttendanceRuleDepartment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttendanceRuleDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttendanceRuleId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
	}

	public void setAttendanceRuleDepartmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAttendanceRuleDepartmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAttendanceRuleDepartmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAttendanceRuleId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAttendanceRuleId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionAttendanceRuleDepartmentId(String op, java.lang.Integer val) {
		setConditionAttendanceRuleDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionAttendanceRuleDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAttendanceRuleDepartmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionAttendanceRuleId(String op, java.lang.Integer val) {
		setConditionAttendanceRuleId(op, val, CONDITION_AND);
	}

	public void setConditionAttendanceRuleId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectAttendanceRuleId(boolean val) {
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


}

