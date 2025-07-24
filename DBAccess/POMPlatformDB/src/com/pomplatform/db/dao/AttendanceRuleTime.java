package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAttendanceRuleTime;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AttendanceRuleTime extends AbstractTable<BaseAttendanceRuleTime>
{

	public AttendanceRuleTime() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "attendance_rule_times";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAttendanceRuleTime.CS_ATTENDANCE_RULE_TIME_ID;
		__column_names[1] = BaseAttendanceRuleTime.CS_ATTENDANCE_RULE_ID;
		__column_names[2] = BaseAttendanceRuleTime.CS_FROM_TIME;
		__column_names[3] = BaseAttendanceRuleTime.CS_IS_CROSS_FROM;
		__column_names[4] = BaseAttendanceRuleTime.CS_TO_TIME;
		__column_names[5] = BaseAttendanceRuleTime.CS_IS_CROSS_TO;
		__column_names[6] = BaseAttendanceRuleTime.CS_MINUTES;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAttendanceRuleTime b) {
		clear();
		setAttendanceRuleTimeIdClear(b.getAttendanceRuleTimeId());
	}

	public boolean isPrimaryKeyNull() {
		return getAttendanceRuleTimeId() == null;
	}

	@Override
	public BaseAttendanceRuleTime generateBase(){
		BaseAttendanceRuleTime b = new BaseAttendanceRuleTime();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAttendanceRuleTime b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAttendanceRuleTimeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttendanceRuleId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFromTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsCrossFrom(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setToTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsCrossTo(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setMinutes(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseAttendanceRuleTime b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAttendanceRuleTimeId();
		buff[count++] = b.getAttendanceRuleId();
		buff[count++] = b.getFromTime();
		buff[count++] = b.getIsCrossFrom();
		buff[count++] = b.getToTime();
		buff[count++] = b.getIsCrossTo();
		buff[count++] = b.getMinutes();
	}

	@Override
	public void setDataFromBase(BaseAttendanceRuleTime b){
		if(b.getAttendanceRuleTimeId() != null) setAttendanceRuleTimeIdClear(b.getAttendanceRuleTimeId());
		if(b.getAttendanceRuleId() != null) setAttendanceRuleId(b.getAttendanceRuleId());
		if(b.getFromTime() != null) setFromTime(b.getFromTime());
		if(b.getIsCrossFrom() != null) setIsCrossFrom(b.getIsCrossFrom());
		if(b.getToTime() != null) setToTime(b.getToTime());
		if(b.getIsCrossTo() != null) setIsCrossTo(b.getIsCrossTo());
		if(b.getMinutes() != null) setMinutes(b.getMinutes());
	}

	@Override
	public BaseAttendanceRuleTime generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAttendanceRuleTime b = new BaseAttendanceRuleTime();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAttendanceRuleTime __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttendanceRuleTimeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttendanceRuleId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFromTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCrossFrom(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setToTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsCrossTo(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMinutes(GenericBase.__getInt(val));
	}

	public void setAttendanceRuleTimeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAttendanceRuleTimeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAttendanceRuleTimeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setAttendanceRuleId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getAttendanceRuleId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setFromTime(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getFromTime() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setIsCrossFrom(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getIsCrossFrom() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setToTime(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getToTime() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setIsCrossTo(java.lang.Boolean val) {
		setCurrentData(5, val);
	}

	public java.lang.Boolean getIsCrossTo() {
		return GenericBase.__getBoolean(__current_data[5]);
	}

	public void setMinutes(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMinutes() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setConditionAttendanceRuleTimeId(String op, java.lang.Integer val) {
		setConditionAttendanceRuleTimeId(op, val, CONDITION_AND);
	}

	public void setConditionAttendanceRuleTimeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAttendanceRuleTimeId(boolean val) {
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

	public void setConditionFromTime(String op, java.lang.String val) {
		setConditionFromTime(op, val, CONDITION_AND);
	}

	public void setConditionFromTime(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectFromTime(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionIsCrossFrom(String op, java.lang.Boolean val) {
		setConditionIsCrossFrom(op, val, CONDITION_AND);
	}

	public void setConditionIsCrossFrom(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectIsCrossFrom(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionToTime(String op, java.lang.String val) {
		setConditionToTime(op, val, CONDITION_AND);
	}

	public void setConditionToTime(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectToTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionIsCrossTo(String op, java.lang.Boolean val) {
		setConditionIsCrossTo(op, val, CONDITION_AND);
	}

	public void setConditionIsCrossTo(String op, java.lang.Boolean val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectIsCrossTo(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMinutes(String op, java.lang.Integer val) {
		setConditionMinutes(op, val, CONDITION_AND);
	}

	public void setConditionMinutes(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMinutes(boolean val) {
		__select_flags[6] = val;
	}


}

