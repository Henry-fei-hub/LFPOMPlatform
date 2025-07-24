package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeMonthlyCheck;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeMonthlyCheck extends AbstractTable<BaseEmployeeMonthlyCheck>
{

	public EmployeeMonthlyCheck() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 30;

		initTables();

		__tableName            = "employee_monthly_check";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeMonthlyCheck.CS_MONTH_CHECK_ID;
		__column_names[1] = BaseEmployeeMonthlyCheck.CS_YEAR;
		__column_names[2] = BaseEmployeeMonthlyCheck.CS_MONTH;
		__column_names[3] = BaseEmployeeMonthlyCheck.CS_EMPLOYEE_ID;
		__column_names[4] = BaseEmployeeMonthlyCheck.CS_EMPLOYEE_NO;
		__column_names[5] = BaseEmployeeMonthlyCheck.CS_DEPARTMENT_ID;
		__column_names[6] = BaseEmployeeMonthlyCheck.CS_EMPLOYEE_TYPE;
		__column_names[7] = BaseEmployeeMonthlyCheck.CS_ON_BOARD;
		__column_names[8] = BaseEmployeeMonthlyCheck.CS_DUTY_DATE;
		__column_names[9] = BaseEmployeeMonthlyCheck.CS_LATE_5M;
		__column_names[10] = BaseEmployeeMonthlyCheck.CS_LATE_10M;
		__column_names[11] = BaseEmployeeMonthlyCheck.CS_LATE_30M;
		__column_names[12] = BaseEmployeeMonthlyCheck.CS_LATE;
		__column_names[13] = BaseEmployeeMonthlyCheck.CS_THING_LEAVE;
		__column_names[14] = BaseEmployeeMonthlyCheck.CS_THING_HOURS;
		__column_names[15] = BaseEmployeeMonthlyCheck.CS_ILL_LEAVE;
		__column_names[16] = BaseEmployeeMonthlyCheck.CS_OTHER_LEAVE;
		__column_names[17] = BaseEmployeeMonthlyCheck.CS_WORK_DAYS;
		__column_names[18] = BaseEmployeeMonthlyCheck.CS_NORMAL_OVERTIME;
		__column_names[19] = BaseEmployeeMonthlyCheck.CS_WEEKEND_OVERTIME;
		__column_names[20] = BaseEmployeeMonthlyCheck.CS_HOLIDAY_OVERTIME;
		__column_names[21] = BaseEmployeeMonthlyCheck.CS_NORNAL_OVERTIME_HOURS;
		__column_names[22] = BaseEmployeeMonthlyCheck.CS_WEEKEND_OVERTIME_HOURS;
		__column_names[23] = BaseEmployeeMonthlyCheck.CS_HOLIDAY_OVERTIME_HOURS;
		__column_names[24] = BaseEmployeeMonthlyCheck.CS_ABSENCE_DAYS;
		__column_names[25] = BaseEmployeeMonthlyCheck.CS_THING_DAYS;
		__column_names[26] = BaseEmployeeMonthlyCheck.CS_ILL_HOURS;
		__column_names[27] = BaseEmployeeMonthlyCheck.CS_ILL_DAYS;
		__column_names[28] = BaseEmployeeMonthlyCheck.CS_OTHER_HOURS;
		__column_names[29] = BaseEmployeeMonthlyCheck.CS_OTHER_DAYS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeMonthlyCheck b) {
		clear();
		setMonthCheckIdClear(b.getMonthCheckId());
	}

	public boolean isPrimaryKeyNull() {
		return getMonthCheckId() == null;
	}

	@Override
	public BaseEmployeeMonthlyCheck generateBase(){
		BaseEmployeeMonthlyCheck b = new BaseEmployeeMonthlyCheck();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeMonthlyCheck b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMonthCheckId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOnBoard(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDutyDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setLate5m(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLate10m(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLate30m(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLate(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThingLeave(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThingHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIllLeave(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOtherLeave(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkDays(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNormalOvertime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWeekendOvertime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHolidayOvertime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNornalOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setWeekendOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHolidayOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAbsenceDays(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThingDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIllHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIllDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOtherHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOtherDays(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeMonthlyCheck b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMonthCheckId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getEmployeeType();
		buff[count++] = generateTimestampFromDate(b.getOnBoard());
		buff[count++] = generateTimestampFromDate(b.getDutyDate());
		buff[count++] = b.getLate5m();
		buff[count++] = b.getLate10m();
		buff[count++] = b.getLate30m();
		buff[count++] = b.getLate();
		buff[count++] = b.getThingLeave();
		buff[count++] = b.getThingHours();
		buff[count++] = b.getIllLeave();
		buff[count++] = b.getOtherLeave();
		buff[count++] = b.getWorkDays();
		buff[count++] = b.getNormalOvertime();
		buff[count++] = b.getWeekendOvertime();
		buff[count++] = b.getHolidayOvertime();
		buff[count++] = b.getNornalOvertimeHours();
		buff[count++] = b.getWeekendOvertimeHours();
		buff[count++] = b.getHolidayOvertimeHours();
		buff[count++] = b.getAbsenceDays();
		buff[count++] = b.getThingDays();
		buff[count++] = b.getIllHours();
		buff[count++] = b.getIllDays();
		buff[count++] = b.getOtherHours();
		buff[count++] = b.getOtherDays();
	}

	@Override
	public void setDataFromBase(BaseEmployeeMonthlyCheck b){
		if(b.getMonthCheckId() != null) setMonthCheckIdClear(b.getMonthCheckId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getEmployeeType() != null) setEmployeeType(b.getEmployeeType());
		if(b.getOnBoard() != null) setOnBoard(b.getOnBoard());
		if(b.getDutyDate() != null) setDutyDate(b.getDutyDate());
		if(b.getLate5m() != null) setLate5m(b.getLate5m());
		if(b.getLate10m() != null) setLate10m(b.getLate10m());
		if(b.getLate30m() != null) setLate30m(b.getLate30m());
		if(b.getLate() != null) setLate(b.getLate());
		if(b.getThingLeave() != null) setThingLeave(b.getThingLeave());
		if(b.getThingHours() != null) setThingHours(b.getThingHours());
		if(b.getIllLeave() != null) setIllLeave(b.getIllLeave());
		if(b.getOtherLeave() != null) setOtherLeave(b.getOtherLeave());
		if(b.getWorkDays() != null) setWorkDays(b.getWorkDays());
		if(b.getNormalOvertime() != null) setNormalOvertime(b.getNormalOvertime());
		if(b.getWeekendOvertime() != null) setWeekendOvertime(b.getWeekendOvertime());
		if(b.getHolidayOvertime() != null) setHolidayOvertime(b.getHolidayOvertime());
		if(b.getNornalOvertimeHours() != null) setNornalOvertimeHours(b.getNornalOvertimeHours());
		if(b.getWeekendOvertimeHours() != null) setWeekendOvertimeHours(b.getWeekendOvertimeHours());
		if(b.getHolidayOvertimeHours() != null) setHolidayOvertimeHours(b.getHolidayOvertimeHours());
		if(b.getAbsenceDays() != null) setAbsenceDays(b.getAbsenceDays());
		if(b.getThingDays() != null) setThingDays(b.getThingDays());
		if(b.getIllHours() != null) setIllHours(b.getIllHours());
		if(b.getIllDays() != null) setIllDays(b.getIllDays());
		if(b.getOtherHours() != null) setOtherHours(b.getOtherHours());
		if(b.getOtherDays() != null) setOtherDays(b.getOtherDays());
	}

	@Override
	public BaseEmployeeMonthlyCheck generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeMonthlyCheck b = new BaseEmployeeMonthlyCheck();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeMonthlyCheck __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthCheckId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOnBoard(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDutyDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLate5m(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLate10m(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLate30m(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLate(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThingLeave(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThingHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllLeave(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherLeave(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkDays(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNormalOvertime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWeekendOvertime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHolidayOvertime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNornalOvertimeHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWeekendOvertimeHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHolidayOvertimeHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAbsenceDays(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThingDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherDays(GenericBase.__getDecimal(val));
	}

	public void setMonthCheckId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMonthCheckId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMonthCheckIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setEmployeeType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getEmployeeType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOnBoard(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getOnBoard() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setDutyDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getDutyDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setLate5m(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getLate5m() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setLate10m(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getLate10m() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setLate30m(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getLate30m() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setLate(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getLate() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setThingLeave(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getThingLeave() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setThingHours(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getThingHours() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setIllLeave(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getIllLeave() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setOtherLeave(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getOtherLeave() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setWorkDays(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getWorkDays() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setNormalOvertime(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getNormalOvertime() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setWeekendOvertime(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getWeekendOvertime() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setHolidayOvertime(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getHolidayOvertime() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setNornalOvertimeHours(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getNornalOvertimeHours() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setWeekendOvertimeHours(java.math.BigDecimal val) {
		setCurrentData(22, val);
	}

	public java.math.BigDecimal getWeekendOvertimeHours() {
		return GenericBase.__getDecimal(__current_data[22]);
	}

	public void setHolidayOvertimeHours(java.math.BigDecimal val) {
		setCurrentData(23, val);
	}

	public java.math.BigDecimal getHolidayOvertimeHours() {
		return GenericBase.__getDecimal(__current_data[23]);
	}

	public void setAbsenceDays(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getAbsenceDays() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setThingDays(java.math.BigDecimal val) {
		setCurrentData(25, val);
	}

	public java.math.BigDecimal getThingDays() {
		return GenericBase.__getDecimal(__current_data[25]);
	}

	public void setIllHours(java.math.BigDecimal val) {
		setCurrentData(26, val);
	}

	public java.math.BigDecimal getIllHours() {
		return GenericBase.__getDecimal(__current_data[26]);
	}

	public void setIllDays(java.math.BigDecimal val) {
		setCurrentData(27, val);
	}

	public java.math.BigDecimal getIllDays() {
		return GenericBase.__getDecimal(__current_data[27]);
	}

	public void setOtherHours(java.math.BigDecimal val) {
		setCurrentData(28, val);
	}

	public java.math.BigDecimal getOtherHours() {
		return GenericBase.__getDecimal(__current_data[28]);
	}

	public void setOtherDays(java.math.BigDecimal val) {
		setCurrentData(29, val);
	}

	public java.math.BigDecimal getOtherDays() {
		return GenericBase.__getDecimal(__current_data[29]);
	}

	public void setConditionMonthCheckId(String op, java.lang.Integer val) {
		setConditionMonthCheckId(op, val, CONDITION_AND);
	}

	public void setConditionMonthCheckId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMonthCheckId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionEmployeeType(String op, java.lang.Integer val) {
		setConditionEmployeeType(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEmployeeType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOnBoard(String op, java.util.Date val) {
		setConditionOnBoard(op, val, CONDITION_AND);
	}

	public void setConditionOnBoard(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOnBoard(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionDutyDate(String op, java.util.Date val) {
		setConditionDutyDate(op, val, CONDITION_AND);
	}

	public void setConditionDutyDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectDutyDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionLate5m(String op, java.lang.Integer val) {
		setConditionLate5m(op, val, CONDITION_AND);
	}

	public void setConditionLate5m(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectLate5m(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionLate10m(String op, java.lang.Integer val) {
		setConditionLate10m(op, val, CONDITION_AND);
	}

	public void setConditionLate10m(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectLate10m(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionLate30m(String op, java.lang.Integer val) {
		setConditionLate30m(op, val, CONDITION_AND);
	}

	public void setConditionLate30m(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectLate30m(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionLate(String op, java.lang.Integer val) {
		setConditionLate(op, val, CONDITION_AND);
	}

	public void setConditionLate(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectLate(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionThingLeave(String op, java.lang.Integer val) {
		setConditionThingLeave(op, val, CONDITION_AND);
	}

	public void setConditionThingLeave(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectThingLeave(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionThingHours(String op, java.math.BigDecimal val) {
		setConditionThingHours(op, val, CONDITION_AND);
	}

	public void setConditionThingHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectThingHours(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionIllLeave(String op, java.lang.Integer val) {
		setConditionIllLeave(op, val, CONDITION_AND);
	}

	public void setConditionIllLeave(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectIllLeave(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOtherLeave(String op, java.lang.Integer val) {
		setConditionOtherLeave(op, val, CONDITION_AND);
	}

	public void setConditionOtherLeave(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectOtherLeave(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionWorkDays(String op, java.lang.Integer val) {
		setConditionWorkDays(op, val, CONDITION_AND);
	}

	public void setConditionWorkDays(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectWorkDays(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionNormalOvertime(String op, java.lang.Integer val) {
		setConditionNormalOvertime(op, val, CONDITION_AND);
	}

	public void setConditionNormalOvertime(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectNormalOvertime(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionWeekendOvertime(String op, java.lang.Integer val) {
		setConditionWeekendOvertime(op, val, CONDITION_AND);
	}

	public void setConditionWeekendOvertime(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectWeekendOvertime(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionHolidayOvertime(String op, java.lang.Integer val) {
		setConditionHolidayOvertime(op, val, CONDITION_AND);
	}

	public void setConditionHolidayOvertime(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectHolidayOvertime(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionNornalOvertimeHours(String op, java.math.BigDecimal val) {
		setConditionNornalOvertimeHours(op, val, CONDITION_AND);
	}

	public void setConditionNornalOvertimeHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectNornalOvertimeHours(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionWeekendOvertimeHours(String op, java.math.BigDecimal val) {
		setConditionWeekendOvertimeHours(op, val, CONDITION_AND);
	}

	public void setConditionWeekendOvertimeHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectWeekendOvertimeHours(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionHolidayOvertimeHours(String op, java.math.BigDecimal val) {
		setConditionHolidayOvertimeHours(op, val, CONDITION_AND);
	}

	public void setConditionHolidayOvertimeHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectHolidayOvertimeHours(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionAbsenceDays(String op, java.lang.Integer val) {
		setConditionAbsenceDays(op, val, CONDITION_AND);
	}

	public void setConditionAbsenceDays(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectAbsenceDays(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionThingDays(String op, java.math.BigDecimal val) {
		setConditionThingDays(op, val, CONDITION_AND);
	}

	public void setConditionThingDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectThingDays(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionIllHours(String op, java.math.BigDecimal val) {
		setConditionIllHours(op, val, CONDITION_AND);
	}

	public void setConditionIllHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectIllHours(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionIllDays(String op, java.math.BigDecimal val) {
		setConditionIllDays(op, val, CONDITION_AND);
	}

	public void setConditionIllDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectIllDays(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionOtherHours(String op, java.math.BigDecimal val) {
		setConditionOtherHours(op, val, CONDITION_AND);
	}

	public void setConditionOtherHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectOtherHours(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionOtherDays(String op, java.math.BigDecimal val) {
		setConditionOtherDays(op, val, CONDITION_AND);
	}

	public void setConditionOtherDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectOtherDays(boolean val) {
		__select_flags[29] = val;
	}


}

