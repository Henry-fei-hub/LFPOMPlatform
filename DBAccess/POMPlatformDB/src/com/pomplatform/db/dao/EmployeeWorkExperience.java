package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeWorkExperience;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeWorkExperience extends AbstractTable<BaseEmployeeWorkExperience>
{

	public EmployeeWorkExperience() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "employee_work_experiences";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeWorkExperience.CS_EMPLOYEE_WORK_EXPERIENCE_ID;
		__column_names[1] = BaseEmployeeWorkExperience.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeWorkExperience.CS_WORK_PLACE;
		__column_names[3] = BaseEmployeeWorkExperience.CS_WORKEX_START_DATE;
		__column_names[4] = BaseEmployeeWorkExperience.CS_WORKEX_END_DATE;
		__column_names[5] = BaseEmployeeWorkExperience.CS_POSITION;
		__column_names[6] = BaseEmployeeWorkExperience.CS_REASON_OF_LEAVING;
		__column_names[7] = BaseEmployeeWorkExperience.CS_IS_FOREIGN_COMPANY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeWorkExperience b) {
		clear();
		setEmployeeWorkExperienceIdClear(b.getEmployeeWorkExperienceId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeWorkExperienceId() == null;
	}

	@Override
	public BaseEmployeeWorkExperience generateBase(){
		BaseEmployeeWorkExperience b = new BaseEmployeeWorkExperience();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeWorkExperience b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeWorkExperienceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkPlace(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWorkexStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setWorkexEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPosition(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReasonOfLeaving(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsForeignCompany(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeWorkExperience b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeWorkExperienceId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getWorkPlace();
		buff[count++] = generateTimestampFromDate(b.getWorkexStartDate());
		buff[count++] = generateTimestampFromDate(b.getWorkexEndDate());
		buff[count++] = b.getPosition();
		buff[count++] = b.getReasonOfLeaving();
		buff[count++] = b.getIsForeignCompany();
	}

	@Override
	public void setDataFromBase(BaseEmployeeWorkExperience b){
		if(b.getEmployeeWorkExperienceId() != null) setEmployeeWorkExperienceIdClear(b.getEmployeeWorkExperienceId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getWorkPlace() != null) setWorkPlace(b.getWorkPlace());
		if(b.getWorkexStartDate() != null) setWorkexStartDate(b.getWorkexStartDate());
		if(b.getWorkexEndDate() != null) setWorkexEndDate(b.getWorkexEndDate());
		if(b.getPosition() != null) setPosition(b.getPosition());
		if(b.getReasonOfLeaving() != null) setReasonOfLeaving(b.getReasonOfLeaving());
		if(b.getIsForeignCompany() != null) setIsForeignCompany(b.getIsForeignCompany());
	}

	@Override
	public BaseEmployeeWorkExperience generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeWorkExperience b = new BaseEmployeeWorkExperience();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeWorkExperience __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeWorkExperienceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkPlace(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkexStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkexEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPosition(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReasonOfLeaving(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsForeignCompany(GenericBase.__getBoolean(val));
	}

	public void setEmployeeWorkExperienceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeWorkExperienceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeWorkExperienceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setWorkPlace(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getWorkPlace() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setWorkexStartDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getWorkexStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setWorkexEndDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getWorkexEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setPosition(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getPosition() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setReasonOfLeaving(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getReasonOfLeaving() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setIsForeignCompany(java.lang.Boolean val) {
		setCurrentData(7, val);
	}

	public java.lang.Boolean getIsForeignCompany() {
		return GenericBase.__getBoolean(__current_data[7]);
	}

	public void setConditionEmployeeWorkExperienceId(String op, java.lang.Integer val) {
		setConditionEmployeeWorkExperienceId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeWorkExperienceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeWorkExperienceId(boolean val) {
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

	public void setConditionWorkPlace(String op, java.lang.String val) {
		setConditionWorkPlace(op, val, CONDITION_AND);
	}

	public void setConditionWorkPlace(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectWorkPlace(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionWorkexStartDate(String op, java.util.Date val) {
		setConditionWorkexStartDate(op, val, CONDITION_AND);
	}

	public void setConditionWorkexStartDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectWorkexStartDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionWorkexEndDate(String op, java.util.Date val) {
		setConditionWorkexEndDate(op, val, CONDITION_AND);
	}

	public void setConditionWorkexEndDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectWorkexEndDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPosition(String op, java.lang.String val) {
		setConditionPosition(op, val, CONDITION_AND);
	}

	public void setConditionPosition(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPosition(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionReasonOfLeaving(String op, java.lang.String val) {
		setConditionReasonOfLeaving(op, val, CONDITION_AND);
	}

	public void setConditionReasonOfLeaving(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectReasonOfLeaving(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionIsForeignCompany(String op, java.lang.Boolean val) {
		setConditionIsForeignCompany(op, val, CONDITION_AND);
	}

	public void setConditionIsForeignCompany(String op, java.lang.Boolean val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectIsForeignCompany(boolean val) {
		__select_flags[7] = val;
	}


}

