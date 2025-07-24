package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseShiftTimeManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ShiftTimeManage extends AbstractTable<BaseShiftTimeManage>
{

	public ShiftTimeManage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 17;

		initTables();

		__tableName            = "shift_time_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseShiftTimeManage.CS_SHIFT_TIME_MANAGE_ID;
		__column_names[1] = BaseShiftTimeManage.CS_SHIFT_TIME_NAME;
		__column_names[2] = BaseShiftTimeManage.CS_CHECK_SIGN_IN;
		__column_names[3] = BaseShiftTimeManage.CS_SIGN_IN_TIME;
		__column_names[4] = BaseShiftTimeManage.CS_CHECK_SIGN_OFF;
		__column_names[5] = BaseShiftTimeManage.CS_SIGN_OFF_TIME;
		__column_names[6] = BaseShiftTimeManage.CS_LATE_MINUTES;
		__column_names[7] = BaseShiftTimeManage.CS_LEAVE_EARLY_TIME;
		__column_names[8] = BaseShiftTimeManage.CS_SIGN_IN_START_TIME;
		__column_names[9] = BaseShiftTimeManage.CS_SIGN_IN_END_TIME;
		__column_names[10] = BaseShiftTimeManage.CS_SIGN_OFF_START_TIME;
		__column_names[11] = BaseShiftTimeManage.CS_SIGN_OFF_END_TIME;
		__column_names[12] = BaseShiftTimeManage.CS_DAYS;
		__column_names[13] = BaseShiftTimeManage.CS_MINUTES;
		__column_names[14] = BaseShiftTimeManage.CS_OVERTIME_START_TIME;
		__column_names[15] = BaseShiftTimeManage.CS_CREATE_TIME;
		__column_names[16] = BaseShiftTimeManage.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseShiftTimeManage b) {
		clear();
		setShiftTimeManageIdClear(b.getShiftTimeManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getShiftTimeManageId() == null;
	}

	@Override
	public BaseShiftTimeManage generateBase(){
		BaseShiftTimeManage b = new BaseShiftTimeManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseShiftTimeManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setShiftTimeManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setShiftTimeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCheckSignIn(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setSignInTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCheckSignOff(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setSignOffTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLateMinutes(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLeaveEarlyTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSignInStartTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSignInEndTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSignOffStartTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSignOffEndTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMinutes(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOvertimeStartTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseShiftTimeManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getShiftTimeManageId();
		buff[count++] = b.getShiftTimeName();
		buff[count++] = b.getCheckSignIn();
		buff[count++] = b.getSignInTime();
		buff[count++] = b.getCheckSignOff();
		buff[count++] = b.getSignOffTime();
		buff[count++] = b.getLateMinutes();
		buff[count++] = b.getLeaveEarlyTime();
		buff[count++] = b.getSignInStartTime();
		buff[count++] = b.getSignInEndTime();
		buff[count++] = b.getSignOffStartTime();
		buff[count++] = b.getSignOffEndTime();
		buff[count++] = b.getDays();
		buff[count++] = b.getMinutes();
		buff[count++] = b.getOvertimeStartTime();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseShiftTimeManage b){
		if(b.getShiftTimeManageId() != null) setShiftTimeManageIdClear(b.getShiftTimeManageId());
		if(b.getShiftTimeName() != null) setShiftTimeName(b.getShiftTimeName());
		if(b.getCheckSignIn() != null) setCheckSignIn(b.getCheckSignIn());
		if(b.getSignInTime() != null) setSignInTime(b.getSignInTime());
		if(b.getCheckSignOff() != null) setCheckSignOff(b.getCheckSignOff());
		if(b.getSignOffTime() != null) setSignOffTime(b.getSignOffTime());
		if(b.getLateMinutes() != null) setLateMinutes(b.getLateMinutes());
		if(b.getLeaveEarlyTime() != null) setLeaveEarlyTime(b.getLeaveEarlyTime());
		if(b.getSignInStartTime() != null) setSignInStartTime(b.getSignInStartTime());
		if(b.getSignInEndTime() != null) setSignInEndTime(b.getSignInEndTime());
		if(b.getSignOffStartTime() != null) setSignOffStartTime(b.getSignOffStartTime());
		if(b.getSignOffEndTime() != null) setSignOffEndTime(b.getSignOffEndTime());
		if(b.getDays() != null) setDays(b.getDays());
		if(b.getMinutes() != null) setMinutes(b.getMinutes());
		if(b.getOvertimeStartTime() != null) setOvertimeStartTime(b.getOvertimeStartTime());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseShiftTimeManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseShiftTimeManage b = new BaseShiftTimeManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseShiftTimeManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShiftTimeManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShiftTimeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckSignIn(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignInTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckSignOff(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignOffTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateMinutes(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveEarlyTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignInStartTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignInEndTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignOffStartTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignOffEndTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMinutes(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOvertimeStartTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setShiftTimeManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getShiftTimeManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setShiftTimeManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setShiftTimeName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getShiftTimeName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCheckSignIn(java.lang.Boolean val) {
		setCurrentData(2, val);
	}

	public java.lang.Boolean getCheckSignIn() {
		return GenericBase.__getBoolean(__current_data[2]);
	}

	public void setSignInTime(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getSignInTime() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCheckSignOff(java.lang.Boolean val) {
		setCurrentData(4, val);
	}

	public java.lang.Boolean getCheckSignOff() {
		return GenericBase.__getBoolean(__current_data[4]);
	}

	public void setSignOffTime(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getSignOffTime() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setLateMinutes(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getLateMinutes() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setLeaveEarlyTime(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getLeaveEarlyTime() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setSignInStartTime(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getSignInStartTime() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setSignInEndTime(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getSignInEndTime() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setSignOffStartTime(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getSignOffStartTime() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setSignOffEndTime(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getSignOffEndTime() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setDays(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getDays() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setMinutes(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getMinutes() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setOvertimeStartTime(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getOvertimeStartTime() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setConditionShiftTimeManageId(String op, java.lang.Integer val) {
		setConditionShiftTimeManageId(op, val, CONDITION_AND);
	}

	public void setConditionShiftTimeManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectShiftTimeManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionShiftTimeName(String op, java.lang.String val) {
		setConditionShiftTimeName(op, val, CONDITION_AND);
	}

	public void setConditionShiftTimeName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectShiftTimeName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCheckSignIn(String op, java.lang.Boolean val) {
		setConditionCheckSignIn(op, val, CONDITION_AND);
	}

	public void setConditionCheckSignIn(String op, java.lang.Boolean val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCheckSignIn(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSignInTime(String op, java.lang.String val) {
		setConditionSignInTime(op, val, CONDITION_AND);
	}

	public void setConditionSignInTime(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSignInTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCheckSignOff(String op, java.lang.Boolean val) {
		setConditionCheckSignOff(op, val, CONDITION_AND);
	}

	public void setConditionCheckSignOff(String op, java.lang.Boolean val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCheckSignOff(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSignOffTime(String op, java.lang.String val) {
		setConditionSignOffTime(op, val, CONDITION_AND);
	}

	public void setConditionSignOffTime(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSignOffTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionLateMinutes(String op, java.lang.Integer val) {
		setConditionLateMinutes(op, val, CONDITION_AND);
	}

	public void setConditionLateMinutes(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectLateMinutes(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionLeaveEarlyTime(String op, java.lang.Integer val) {
		setConditionLeaveEarlyTime(op, val, CONDITION_AND);
	}

	public void setConditionLeaveEarlyTime(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectLeaveEarlyTime(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSignInStartTime(String op, java.lang.String val) {
		setConditionSignInStartTime(op, val, CONDITION_AND);
	}

	public void setConditionSignInStartTime(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSignInStartTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionSignInEndTime(String op, java.lang.String val) {
		setConditionSignInEndTime(op, val, CONDITION_AND);
	}

	public void setConditionSignInEndTime(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectSignInEndTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSignOffStartTime(String op, java.lang.String val) {
		setConditionSignOffStartTime(op, val, CONDITION_AND);
	}

	public void setConditionSignOffStartTime(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSignOffStartTime(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSignOffEndTime(String op, java.lang.String val) {
		setConditionSignOffEndTime(op, val, CONDITION_AND);
	}

	public void setConditionSignOffEndTime(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSignOffEndTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionDays(String op, java.math.BigDecimal val) {
		setConditionDays(op, val, CONDITION_AND);
	}

	public void setConditionDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectDays(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionMinutes(String op, java.lang.Integer val) {
		setConditionMinutes(op, val, CONDITION_AND);
	}

	public void setConditionMinutes(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectMinutes(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOvertimeStartTime(String op, java.lang.String val) {
		setConditionOvertimeStartTime(op, val, CONDITION_AND);
	}

	public void setConditionOvertimeStartTime(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOvertimeStartTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[16] = val;
	}


}

