package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTimeOfShiftManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TimeOfShiftManage extends AbstractTable<BaseTimeOfShiftManage>
{

	public TimeOfShiftManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "time_of_shift_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTimeOfShiftManage.CS_TIME_OF_SHIFT_MANAGE_ID;
		__column_names[1] = BaseTimeOfShiftManage.CS_SHIFT_MANAGE_ID;
		__column_names[2] = BaseTimeOfShiftManage.CS_SHIFT_TIME_MANAGE_ID;
		__column_names[3] = BaseTimeOfShiftManage.CS_MONDAY;
		__column_names[4] = BaseTimeOfShiftManage.CS_TUESDAY;
		__column_names[5] = BaseTimeOfShiftManage.CS_WEDNESDAY;
		__column_names[6] = BaseTimeOfShiftManage.CS_THURSDAY;
		__column_names[7] = BaseTimeOfShiftManage.CS_FRIDAY;
		__column_names[8] = BaseTimeOfShiftManage.CS_SATURDAY;
		__column_names[9] = BaseTimeOfShiftManage.CS_SUNDAY;
		__column_names[10] = BaseTimeOfShiftManage.CS_OPERATE_EMPLOYEE_ID;
		__column_names[11] = BaseTimeOfShiftManage.CS_OPERATE_TIME;
		__column_names[12] = BaseTimeOfShiftManage.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTimeOfShiftManage b) {
		clear();
		setTimeOfShiftManageIdClear(b.getTimeOfShiftManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getTimeOfShiftManageId() == null;
	}

	@Override
	public BaseTimeOfShiftManage generateBase(){
		BaseTimeOfShiftManage b = new BaseTimeOfShiftManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTimeOfShiftManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTimeOfShiftManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setShiftManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setShiftTimeManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonday(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setTuesday(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setWednesday(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setThursday(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setFriday(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setSaturday(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setSunday(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseTimeOfShiftManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTimeOfShiftManageId();
		buff[count++] = b.getShiftManageId();
		buff[count++] = b.getShiftTimeManageId();
		buff[count++] = b.getMonday();
		buff[count++] = b.getTuesday();
		buff[count++] = b.getWednesday();
		buff[count++] = b.getThursday();
		buff[count++] = b.getFriday();
		buff[count++] = b.getSaturday();
		buff[count++] = b.getSunday();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseTimeOfShiftManage b){
		if(b.getTimeOfShiftManageId() != null) setTimeOfShiftManageIdClear(b.getTimeOfShiftManageId());
		if(b.getShiftManageId() != null) setShiftManageId(b.getShiftManageId());
		if(b.getShiftTimeManageId() != null) setShiftTimeManageId(b.getShiftTimeManageId());
		if(b.getMonday() != null) setMonday(b.getMonday());
		if(b.getTuesday() != null) setTuesday(b.getTuesday());
		if(b.getWednesday() != null) setWednesday(b.getWednesday());
		if(b.getThursday() != null) setThursday(b.getThursday());
		if(b.getFriday() != null) setFriday(b.getFriday());
		if(b.getSaturday() != null) setSaturday(b.getSaturday());
		if(b.getSunday() != null) setSunday(b.getSunday());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseTimeOfShiftManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTimeOfShiftManage b = new BaseTimeOfShiftManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTimeOfShiftManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTimeOfShiftManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShiftManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShiftTimeManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonday(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTuesday(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWednesday(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThursday(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFriday(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSaturday(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSunday(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setTimeOfShiftManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTimeOfShiftManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTimeOfShiftManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setShiftManageId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getShiftManageId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setShiftTimeManageId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getShiftTimeManageId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonday(java.lang.Boolean val) {
		setCurrentData(3, val);
	}

	public java.lang.Boolean getMonday() {
		return GenericBase.__getBoolean(__current_data[3]);
	}

	public void setTuesday(java.lang.Boolean val) {
		setCurrentData(4, val);
	}

	public java.lang.Boolean getTuesday() {
		return GenericBase.__getBoolean(__current_data[4]);
	}

	public void setWednesday(java.lang.Boolean val) {
		setCurrentData(5, val);
	}

	public java.lang.Boolean getWednesday() {
		return GenericBase.__getBoolean(__current_data[5]);
	}

	public void setThursday(java.lang.Boolean val) {
		setCurrentData(6, val);
	}

	public java.lang.Boolean getThursday() {
		return GenericBase.__getBoolean(__current_data[6]);
	}

	public void setFriday(java.lang.Boolean val) {
		setCurrentData(7, val);
	}

	public java.lang.Boolean getFriday() {
		return GenericBase.__getBoolean(__current_data[7]);
	}

	public void setSaturday(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getSaturday() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setSunday(java.lang.Boolean val) {
		setCurrentData(9, val);
	}

	public java.lang.Boolean getSunday() {
		return GenericBase.__getBoolean(__current_data[9]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setConditionTimeOfShiftManageId(String op, java.lang.Integer val) {
		setConditionTimeOfShiftManageId(op, val, CONDITION_AND);
	}

	public void setConditionTimeOfShiftManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTimeOfShiftManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionShiftManageId(String op, java.lang.Integer val) {
		setConditionShiftManageId(op, val, CONDITION_AND);
	}

	public void setConditionShiftManageId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectShiftManageId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionShiftTimeManageId(String op, java.lang.Integer val) {
		setConditionShiftTimeManageId(op, val, CONDITION_AND);
	}

	public void setConditionShiftTimeManageId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectShiftTimeManageId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMonday(String op, java.lang.Boolean val) {
		setConditionMonday(op, val, CONDITION_AND);
	}

	public void setConditionMonday(String op, java.lang.Boolean val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonday(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTuesday(String op, java.lang.Boolean val) {
		setConditionTuesday(op, val, CONDITION_AND);
	}

	public void setConditionTuesday(String op, java.lang.Boolean val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTuesday(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionWednesday(String op, java.lang.Boolean val) {
		setConditionWednesday(op, val, CONDITION_AND);
	}

	public void setConditionWednesday(String op, java.lang.Boolean val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectWednesday(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionThursday(String op, java.lang.Boolean val) {
		setConditionThursday(op, val, CONDITION_AND);
	}

	public void setConditionThursday(String op, java.lang.Boolean val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectThursday(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionFriday(String op, java.lang.Boolean val) {
		setConditionFriday(op, val, CONDITION_AND);
	}

	public void setConditionFriday(String op, java.lang.Boolean val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFriday(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSaturday(String op, java.lang.Boolean val) {
		setConditionSaturday(op, val, CONDITION_AND);
	}

	public void setConditionSaturday(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSaturday(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionSunday(String op, java.lang.Boolean val) {
		setConditionSunday(op, val, CONDITION_AND);
	}

	public void setConditionSunday(String op, java.lang.Boolean val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectSunday(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[12] = val;
	}


}

