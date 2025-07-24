package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeCheckinout;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeCheckinout extends AbstractTable<BaseEmployeeCheckinout>
{

	public EmployeeCheckinout() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "employee_checkinouts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeCheckinout.CS_EMPLOYEE_CHECK_ID;
		__column_names[1] = BaseEmployeeCheckinout.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeCheckinout.CS_CHECK_DATE;
		__column_names[3] = BaseEmployeeCheckinout.CS_CHECK_IN_TIME;
		__column_names[4] = BaseEmployeeCheckinout.CS_CHECK_OUT_TIME;
		__column_names[5] = BaseEmployeeCheckinout.CS_STATUS;
		__column_names[6] = BaseEmployeeCheckinout.CS_OA_EMPLOYEE_ID;
		__column_names[7] = BaseEmployeeCheckinout.CS_EMPLOYEE_NO;
		__column_names[8] = BaseEmployeeCheckinout.CS_FINAL_STATUS;
		__column_names[9] = BaseEmployeeCheckinout.CS_DAY_OF_WEEK;
		__column_names[10] = BaseEmployeeCheckinout.CS_WEEK_OF_YEAR;
		__column_names[11] = BaseEmployeeCheckinout.CS_BIG_WEEK;
		__column_names[12] = BaseEmployeeCheckinout.CS_COMMENTS;
		__column_names[13] = BaseEmployeeCheckinout.CS_LATE_TIME;
		__column_names[14] = BaseEmployeeCheckinout.CS_IS_WORK_DAY;
		__column_names[15] = BaseEmployeeCheckinout.CS_OVER_TIME;
		__column_names[16] = BaseEmployeeCheckinout.CS_LEAVE_DAYS;
		__column_names[17] = BaseEmployeeCheckinout.CS_LEAVE_HOURS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeCheckinout b) {
		clear();
		setEmployeeCheckIdClear(b.getEmployeeCheckId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeCheckId() == null;
	}

	@Override
	public BaseEmployeeCheckinout generateBase(){
		BaseEmployeeCheckinout b = new BaseEmployeeCheckinout();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeCheckinout b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeCheckId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCheckDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCheckInTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCheckOutTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOaEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFinalStatus(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setDayOfWeek(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWeekOfYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBigWeek(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setComments(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLateTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsWorkDay(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOverTime(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLeaveDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLeaveHours(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeCheckinout b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeCheckId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCheckDate());
		buff[count++] = generateTimestampFromDate(b.getCheckInTime());
		buff[count++] = generateTimestampFromDate(b.getCheckOutTime());
		buff[count++] = b.getStatus();
		buff[count++] = b.getOaEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getFinalStatus();
		buff[count++] = b.getDayOfWeek();
		buff[count++] = b.getWeekOfYear();
		buff[count++] = b.getBigWeek();
		buff[count++] = b.getComments();
		buff[count++] = b.getLateTime();
		buff[count++] = b.getIsWorkDay();
		buff[count++] = b.getOverTime();
		buff[count++] = b.getLeaveDays();
		buff[count++] = b.getLeaveHours();
	}

	@Override
	public void setDataFromBase(BaseEmployeeCheckinout b){
		if(b.getEmployeeCheckId() != null) setEmployeeCheckIdClear(b.getEmployeeCheckId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCheckDate() != null) setCheckDate(b.getCheckDate());
		if(b.getCheckInTime() != null) setCheckInTime(b.getCheckInTime());
		if(b.getCheckOutTime() != null) setCheckOutTime(b.getCheckOutTime());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getOaEmployeeId() != null) setOaEmployeeId(b.getOaEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getFinalStatus() != null) setFinalStatus(b.getFinalStatus());
		if(b.getDayOfWeek() != null) setDayOfWeek(b.getDayOfWeek());
		if(b.getWeekOfYear() != null) setWeekOfYear(b.getWeekOfYear());
		if(b.getBigWeek() != null) setBigWeek(b.getBigWeek());
		if(b.getComments() != null) setComments(b.getComments());
		if(b.getLateTime() != null) setLateTime(b.getLateTime());
		if(b.getIsWorkDay() != null) setIsWorkDay(b.getIsWorkDay());
		if(b.getOverTime() != null) setOverTime(b.getOverTime());
		if(b.getLeaveDays() != null) setLeaveDays(b.getLeaveDays());
		if(b.getLeaveHours() != null) setLeaveHours(b.getLeaveHours());
	}

	@Override
	public BaseEmployeeCheckinout generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeCheckinout b = new BaseEmployeeCheckinout();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeCheckinout __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeCheckId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckInTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCheckOutTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOaEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalStatus(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDayOfWeek(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWeekOfYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBigWeek(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComments(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsWorkDay(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOverTime(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveHours(GenericBase.__getDecimal(val));
	}

	public void setEmployeeCheckId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeCheckId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeCheckIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCheckDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getCheckDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setCheckInTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCheckInTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setCheckOutTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCheckOutTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setOaEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOaEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setFinalStatus(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getFinalStatus() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setDayOfWeek(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getDayOfWeek() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setWeekOfYear(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getWeekOfYear() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setBigWeek(java.lang.Boolean val) {
		setCurrentData(11, val);
	}

	public java.lang.Boolean getBigWeek() {
		return GenericBase.__getBoolean(__current_data[11]);
	}

	public void setComments(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getComments() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setLateTime(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getLateTime() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setIsWorkDay(java.lang.Boolean val) {
		setCurrentData(14, val);
	}

	public java.lang.Boolean getIsWorkDay() {
		return GenericBase.__getBoolean(__current_data[14]);
	}

	public void setOverTime(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getOverTime() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setLeaveDays(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getLeaveDays() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setLeaveHours(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getLeaveHours() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setConditionEmployeeCheckId(String op, java.lang.Integer val) {
		setConditionEmployeeCheckId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeCheckId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeCheckId(boolean val) {
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

	public void setConditionCheckDate(String op, java.util.Date val) {
		setConditionCheckDate(op, val, CONDITION_AND);
	}

	public void setConditionCheckDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCheckDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCheckInTime(String op, java.util.Date val) {
		setConditionCheckInTime(op, val, CONDITION_AND);
	}

	public void setConditionCheckInTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCheckInTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCheckOutTime(String op, java.util.Date val) {
		setConditionCheckOutTime(op, val, CONDITION_AND);
	}

	public void setConditionCheckOutTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCheckOutTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionOaEmployeeId(String op, java.lang.Integer val) {
		setConditionOaEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOaEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOaEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionFinalStatus(String op, java.lang.Boolean val) {
		setConditionFinalStatus(op, val, CONDITION_AND);
	}

	public void setConditionFinalStatus(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectFinalStatus(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionDayOfWeek(String op, java.lang.Integer val) {
		setConditionDayOfWeek(op, val, CONDITION_AND);
	}

	public void setConditionDayOfWeek(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectDayOfWeek(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionWeekOfYear(String op, java.lang.Integer val) {
		setConditionWeekOfYear(op, val, CONDITION_AND);
	}

	public void setConditionWeekOfYear(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectWeekOfYear(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionBigWeek(String op, java.lang.Boolean val) {
		setConditionBigWeek(op, val, CONDITION_AND);
	}

	public void setConditionBigWeek(String op, java.lang.Boolean val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectBigWeek(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionComments(String op, java.lang.String val) {
		setConditionComments(op, val, CONDITION_AND);
	}

	public void setConditionComments(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectComments(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionLateTime(String op, java.lang.Integer val) {
		setConditionLateTime(op, val, CONDITION_AND);
	}

	public void setConditionLateTime(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectLateTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionIsWorkDay(String op, java.lang.Boolean val) {
		setConditionIsWorkDay(op, val, CONDITION_AND);
	}

	public void setConditionIsWorkDay(String op, java.lang.Boolean val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectIsWorkDay(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOverTime(String op, java.math.BigDecimal val) {
		setConditionOverTime(op, val, CONDITION_AND);
	}

	public void setConditionOverTime(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectOverTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionLeaveDays(String op, java.math.BigDecimal val) {
		setConditionLeaveDays(op, val, CONDITION_AND);
	}

	public void setConditionLeaveDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectLeaveDays(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionLeaveHours(String op, java.math.BigDecimal val) {
		setConditionLeaveHours(op, val, CONDITION_AND);
	}

	public void setConditionLeaveHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectLeaveHours(boolean val) {
		__select_flags[17] = val;
	}


}

