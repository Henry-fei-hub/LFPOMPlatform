package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseMainProjectMajorEmployee;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class MainProjectMajorEmployee extends AbstractTable<BaseMainProjectMajorEmployee>
{

	public MainProjectMajorEmployee() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "main_project_major_employees";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMainProjectMajorEmployee.CS_MAIN_PROJECT_MAJOR_EMPLOYEE_ID;
		__column_names[1] = BaseMainProjectMajorEmployee.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseMainProjectMajorEmployee.CS_EMPLOYEE_ID;
		__column_names[3] = BaseMainProjectMajorEmployee.CS_SPECIALTY_ID;
		__column_names[4] = BaseMainProjectMajorEmployee.CS_RELATION;
		__column_names[5] = BaseMainProjectMajorEmployee.CS_OPERATOR_ID;
		__column_names[6] = BaseMainProjectMajorEmployee.CS_CREATE_TIME;
		__column_names[7] = BaseMainProjectMajorEmployee.CS_STAMP_HOLDER;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMainProjectMajorEmployee b) {
		clear();
		setMainProjectMajorEmployeeIdClear(b.getMainProjectMajorEmployeeId());
	}

	public boolean isPrimaryKeyNull() {
		return getMainProjectMajorEmployeeId() == null;
	}

	@Override
	public BaseMainProjectMajorEmployee generateBase(){
		BaseMainProjectMajorEmployee b = new BaseMainProjectMajorEmployee();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMainProjectMajorEmployee b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMainProjectMajorEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSpecialtyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRelation(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStampHolder(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseMainProjectMajorEmployee b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMainProjectMajorEmployeeId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getSpecialtyId();
		buff[count++] = b.getRelation();
		buff[count++] = b.getOperatorId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getStampHolder();
	}

	@Override
	public void setDataFromBase(BaseMainProjectMajorEmployee b){
		if(b.getMainProjectMajorEmployeeId() != null) setMainProjectMajorEmployeeIdClear(b.getMainProjectMajorEmployeeId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getSpecialtyId() != null) setSpecialtyId(b.getSpecialtyId());
		if(b.getRelation() != null) setRelation(b.getRelation());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getStampHolder() != null) setStampHolder(b.getStampHolder());
	}

	@Override
	public BaseMainProjectMajorEmployee generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMainProjectMajorEmployee b = new BaseMainProjectMajorEmployee();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMainProjectMajorEmployee __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectMajorEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialtyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRelation(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStampHolder(GenericBase.__getInt(val));
	}

	public void setMainProjectMajorEmployeeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMainProjectMajorEmployeeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMainProjectMajorEmployeeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setSpecialtyId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSpecialtyId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setRelation(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getRelation() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setStampHolder(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getStampHolder() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionMainProjectMajorEmployeeId(String op, java.lang.Integer val) {
		setConditionMainProjectMajorEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectMajorEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMainProjectMajorEmployeeId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
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

	public void setConditionSpecialtyId(String op, java.lang.Integer val) {
		setConditionSpecialtyId(op, val, CONDITION_AND);
	}

	public void setConditionSpecialtyId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSpecialtyId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRelation(String op, java.lang.Integer val) {
		setConditionRelation(op, val, CONDITION_AND);
	}

	public void setConditionRelation(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectRelation(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
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

	public void setConditionStampHolder(String op, java.lang.Integer val) {
		setConditionStampHolder(op, val, CONDITION_AND);
	}

	public void setConditionStampHolder(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectStampHolder(boolean val) {
		__select_flags[7] = val;
	}


}

