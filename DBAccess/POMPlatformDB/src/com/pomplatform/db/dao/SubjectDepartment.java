package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSubjectDepartment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SubjectDepartment extends AbstractTable<BaseSubjectDepartment>
{

	public SubjectDepartment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "subject_departments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSubjectDepartment.CS_SUBJECT_DEPARTMENT_ID;
		__column_names[1] = BaseSubjectDepartment.CS_SUBJECT_TYPE_ID;
		__column_names[2] = BaseSubjectDepartment.CS_DEPARTMENT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSubjectDepartment b) {
		clear();
		setSubjectDepartmentIdClear(b.getSubjectDepartmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getSubjectDepartmentId() == null;
	}

	@Override
	public BaseSubjectDepartment generateBase(){
		BaseSubjectDepartment b = new BaseSubjectDepartment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSubjectDepartment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSubjectDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubjectTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseSubjectDepartment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSubjectDepartmentId();
		buff[count++] = b.getSubjectTypeId();
		buff[count++] = b.getDepartmentId();
	}

	@Override
	public void setDataFromBase(BaseSubjectDepartment b){
		if(b.getSubjectDepartmentId() != null) setSubjectDepartmentIdClear(b.getSubjectDepartmentId());
		if(b.getSubjectTypeId() != null) setSubjectTypeId(b.getSubjectTypeId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
	}

	@Override
	public BaseSubjectDepartment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSubjectDepartment b = new BaseSubjectDepartment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSubjectDepartment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubjectDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubjectTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
	}

	public void setSubjectDepartmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSubjectDepartmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSubjectDepartmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSubjectTypeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSubjectTypeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionSubjectDepartmentId(String op, java.lang.Integer val) {
		setConditionSubjectDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionSubjectDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSubjectDepartmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSubjectTypeId(String op, java.lang.Integer val) {
		setConditionSubjectTypeId(op, val, CONDITION_AND);
	}

	public void setConditionSubjectTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSubjectTypeId(boolean val) {
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

