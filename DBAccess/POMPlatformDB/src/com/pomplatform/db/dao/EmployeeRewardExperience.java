package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeRewardExperience;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeRewardExperience extends AbstractTable<BaseEmployeeRewardExperience>
{

	public EmployeeRewardExperience() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "employee_reward_experiences";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeRewardExperience.CS_EMPLOYEE_REWARD_EXPERIENCE_ID;
		__column_names[1] = BaseEmployeeRewardExperience.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeRewardExperience.CS_REWARD_NAME;
		__column_names[3] = BaseEmployeeRewardExperience.CS_REWARD_DESCRIPTION;
		__column_names[4] = BaseEmployeeRewardExperience.CS_REWARD_DATE;
		__column_names[5] = BaseEmployeeRewardExperience.CS_REWARD_UNIT;
		__column_names[6] = BaseEmployeeRewardExperience.CS_ATTACHMENT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeRewardExperience b) {
		clear();
		setEmployeeRewardExperienceIdClear(b.getEmployeeRewardExperienceId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeRewardExperienceId() == null;
	}

	@Override
	public BaseEmployeeRewardExperience generateBase(){
		BaseEmployeeRewardExperience b = new BaseEmployeeRewardExperience();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeRewardExperience b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeRewardExperienceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRewardName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRewardDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRewardDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRewardUnit(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachment(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeRewardExperience b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeRewardExperienceId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getRewardName();
		buff[count++] = b.getRewardDescription();
		buff[count++] = generateTimestampFromDate(b.getRewardDate());
		buff[count++] = b.getRewardUnit();
		buff[count++] = b.getAttachment();
	}

	@Override
	public void setDataFromBase(BaseEmployeeRewardExperience b){
		if(b.getEmployeeRewardExperienceId() != null) setEmployeeRewardExperienceIdClear(b.getEmployeeRewardExperienceId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getRewardName() != null) setRewardName(b.getRewardName());
		if(b.getRewardDescription() != null) setRewardDescription(b.getRewardDescription());
		if(b.getRewardDate() != null) setRewardDate(b.getRewardDate());
		if(b.getRewardUnit() != null) setRewardUnit(b.getRewardUnit());
		if(b.getAttachment() != null) setAttachment(b.getAttachment());
	}

	@Override
	public BaseEmployeeRewardExperience generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeRewardExperience b = new BaseEmployeeRewardExperience();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeRewardExperience __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeRewardExperienceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRewardName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRewardDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRewardDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRewardUnit(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachment(GenericBase.__getString(val));
	}

	public void setEmployeeRewardExperienceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeRewardExperienceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeRewardExperienceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setRewardName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getRewardName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setRewardDescription(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getRewardDescription() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setRewardDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getRewardDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setRewardUnit(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getRewardUnit() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setAttachment(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getAttachment() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionEmployeeRewardExperienceId(String op, java.lang.Integer val) {
		setConditionEmployeeRewardExperienceId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeRewardExperienceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeRewardExperienceId(boolean val) {
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

	public void setConditionRewardName(String op, java.lang.String val) {
		setConditionRewardName(op, val, CONDITION_AND);
	}

	public void setConditionRewardName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectRewardName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionRewardDescription(String op, java.lang.String val) {
		setConditionRewardDescription(op, val, CONDITION_AND);
	}

	public void setConditionRewardDescription(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectRewardDescription(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionRewardDate(String op, java.util.Date val) {
		setConditionRewardDate(op, val, CONDITION_AND);
	}

	public void setConditionRewardDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRewardDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionRewardUnit(String op, java.lang.String val) {
		setConditionRewardUnit(op, val, CONDITION_AND);
	}

	public void setConditionRewardUnit(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectRewardUnit(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAttachment(String op, java.lang.String val) {
		setConditionAttachment(op, val, CONDITION_AND);
	}

	public void setConditionAttachment(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAttachment(boolean val) {
		__select_flags[6] = val;
	}


}

