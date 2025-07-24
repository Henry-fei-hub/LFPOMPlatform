package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlateDepartment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlateDepartment extends AbstractTable<BasePlateDepartment>
{

	public PlateDepartment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 3;

		initTables();

		__tableName            = "plate_departments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateDepartment.CS_PLATE_DEPARTMENT_ID;
		__column_names[1] = BasePlateDepartment.CS_PLATE_ID;
		__column_names[2] = BasePlateDepartment.CS_DEPARTMENT_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateDepartment b) {
		clear();
		setPlateDepartmentIdClear(b.getPlateDepartmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateDepartmentId() == null;
	}

	@Override
	public BasePlateDepartment generateBase(){
		BasePlateDepartment b = new BasePlateDepartment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateDepartment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BasePlateDepartment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateDepartmentId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDepartmentId();
	}

	@Override
	public void setDataFromBase(BasePlateDepartment b){
		if(b.getPlateDepartmentId() != null) setPlateDepartmentIdClear(b.getPlateDepartmentId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
	}

	@Override
	public BasePlateDepartment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateDepartment b = new BasePlateDepartment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateDepartment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
	}

	public void setPlateDepartmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateDepartmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateDepartmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setConditionPlateDepartmentId(String op, java.lang.Integer val) {
		setConditionPlateDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionPlateDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateDepartmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
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

