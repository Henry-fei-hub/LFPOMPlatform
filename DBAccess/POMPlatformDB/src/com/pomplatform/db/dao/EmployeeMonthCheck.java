package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseEmployeeMonthCheck;


public class EmployeeMonthCheck extends AbstractTable<BaseEmployeeMonthCheck>
{

	public EmployeeMonthCheck() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 45;

		initTables();

		__tableName            = "employee_month_checks";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeMonthCheck.CS_EMPLOYEE_MONTH_CHECK_ID;
		__column_names[1] = BaseEmployeeMonthCheck.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeMonthCheck.CS_YEAR;
		__column_names[3] = BaseEmployeeMonthCheck.CS_MONTH;
		__column_names[4] = BaseEmployeeMonthCheck.CS_LATE_LEAVE_5M;
		__column_names[5] = BaseEmployeeMonthCheck.CS_LATE_LEAVE_10M;
		__column_names[6] = BaseEmployeeMonthCheck.CS_LATE_LEAVE_30M;
		__column_names[7] = BaseEmployeeMonthCheck.CS_LATE_LEAVE;
		__column_names[8] = BaseEmployeeMonthCheck.CS_THING_LEAVE_TIMES;
		__column_names[9] = BaseEmployeeMonthCheck.CS_THING_LEAVE_HOURS;
		__column_names[10] = BaseEmployeeMonthCheck.CS_THING_LEAVE_DAYS;
		__column_names[11] = BaseEmployeeMonthCheck.CS_ILL_LEAVE_TIMES;
		__column_names[12] = BaseEmployeeMonthCheck.CS_ILL_LEAVE_HOURS;
		__column_names[13] = BaseEmployeeMonthCheck.CS_ILL_LEAVE_DAYS;
		__column_names[14] = BaseEmployeeMonthCheck.CS_OTHER_LEAVE_TIMES;
		__column_names[15] = BaseEmployeeMonthCheck.CS_OTHER_LEAVE_HOURS;
		__column_names[16] = BaseEmployeeMonthCheck.CS_OTHER_LEAVE_DAYS;
		__column_names[17] = BaseEmployeeMonthCheck.CS_NORNAL_OVERTIME_HOURS;
		__column_names[18] = BaseEmployeeMonthCheck.CS_WEEKEND_OVERTIME_HOURS;
		__column_names[19] = BaseEmployeeMonthCheck.CS_HOLIDAY_OVERTIME_HOURS;
		__column_names[20] = BaseEmployeeMonthCheck.CS_ABSENCE_DAYS;
		__column_names[21] = BaseEmployeeMonthCheck.CS_SHOULD_DAYS;
		__column_names[22] = BaseEmployeeMonthCheck.CS_FACT_DAYS;
		__column_names[23] = BaseEmployeeMonthCheck.CS_OPERATE_EMPLOYEE_ID;
		__column_names[24] = BaseEmployeeMonthCheck.CS_OPERATE_TIME;
		__column_names[25] = BaseEmployeeMonthCheck.CS_REMARK;
		__column_names[26] = BaseEmployeeMonthCheck.CS_IS_LOCKED;
		__column_names[27] = BaseEmployeeMonthCheck.CS_NUMBER_OF_LATE;
		__column_names[28] = BaseEmployeeMonthCheck.CS_LATE_FOR_MINUTES;
		__column_names[29] = BaseEmployeeMonthCheck.CS_NUMBER_OF_LEAVE;
		__column_names[30] = BaseEmployeeMonthCheck.CS_LEAVE_FOR_MINUTES;
		__column_names[31] = BaseEmployeeMonthCheck.CS_LATE_CHARGE;
		__column_names[32] = BaseEmployeeMonthCheck.CS_ADJUST;
		__column_names[33] = BaseEmployeeMonthCheck.CS_ANNUAL_LEAVE;
		__column_names[34] = BaseEmployeeMonthCheck.CS_WEDDING_LEAVE;
		__column_names[35] = BaseEmployeeMonthCheck.CS_MATERNITY_LEAVE;
		__column_names[36] = BaseEmployeeMonthCheck.CS_PRENATAL_CHECK_LEAVE;
		__column_names[37] = BaseEmployeeMonthCheck.CS_MATERNITY_LEAVE_DAYS;
		__column_names[38] = BaseEmployeeMonthCheck.CS_FUNERAL_LEAVE;
		__column_names[39] = BaseEmployeeMonthCheck.CS_OUT_FOR_BUSINESS;
		__column_names[40] = BaseEmployeeMonthCheck.CS_OVERTIME_PAY;
		__column_names[41] = BaseEmployeeMonthCheck.CS_OVERTIME_PAY_SUB;
		__column_names[42] = BaseEmployeeMonthCheck.CS_OVERTIME_PAY_SUB_BEFORE;
		__column_names[43] = BaseEmployeeMonthCheck.CS_OVERTIME_PAY_BEFORE;
		__column_names[44] = BaseEmployeeMonthCheck.CS_IS_FULL_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeMonthCheck b) {
		clear();
		setEmployeeMonthCheckIdClear(b.getEmployeeMonthCheckId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeMonthCheckId() == null;
	}

	@Override
	public BaseEmployeeMonthCheck generateBase(){
		BaseEmployeeMonthCheck b = new BaseEmployeeMonthCheck();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeMonthCheck b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeMonthCheckId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLateLeave5m(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLateLeave10m(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLateLeave30m(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLateLeave(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThingLeaveTimes(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThingLeaveHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setThingLeaveDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIllLeaveTimes(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIllLeaveHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIllLeaveDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOtherLeaveTimes(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOtherLeaveHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOtherLeaveDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setNornalOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setWeekendOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHolidayOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAbsenceDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setShouldDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFactDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsLocked(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setNumberOfLate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLateForMinutes(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setNumberOfLeave(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLeaveForMinutes(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLateCharge(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAdjust(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAnnualLeave(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setWeddingLeave(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMaternityLeave(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPrenatalCheckLeave(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMaternityLeaveDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFuneralLeave(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOutForBusiness(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOvertimePay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOvertimePaySub(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOvertimePaySubBefore(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOvertimePayBefore(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsFullTime(GenericBase.__getBoolean(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeMonthCheckId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setYear(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMonth(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLateLeave5m(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLateLeave10m(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLateLeave30m(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLateLeave(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setThingLeaveTimes(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setThingLeaveHours(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setThingLeaveDays(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIllLeaveTimes(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIllLeaveHours(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIllLeaveDays(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOtherLeaveTimes(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOtherLeaveHours(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOtherLeaveDays(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setNornalOvertimeHours(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWeekendOvertimeHours(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHolidayOvertimeHours(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAbsenceDays(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setShouldDays(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFactDays(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperateEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsLocked(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setNumberOfLate(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLateForMinutes(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setNumberOfLeave(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLeaveForMinutes(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setLateCharge(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAdjust(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAnnualLeave(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWeddingLeave(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMaternityLeave(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPrenatalCheckLeave(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMaternityLeaveDays(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFuneralLeave(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOutForBusiness(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOvertimePay(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOvertimePaySub(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOvertimePaySubBefore(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOvertimePayBefore(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsFullTime(GenericBase.__getBoolean(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeMonthCheck b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeMonthCheckId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getLateLeave5m();
		buff[count++] = b.getLateLeave10m();
		buff[count++] = b.getLateLeave30m();
		buff[count++] = b.getLateLeave();
		buff[count++] = b.getThingLeaveTimes();
		buff[count++] = b.getThingLeaveHours();
		buff[count++] = b.getThingLeaveDays();
		buff[count++] = b.getIllLeaveTimes();
		buff[count++] = b.getIllLeaveHours();
		buff[count++] = b.getIllLeaveDays();
		buff[count++] = b.getOtherLeaveTimes();
		buff[count++] = b.getOtherLeaveHours();
		buff[count++] = b.getOtherLeaveDays();
		buff[count++] = b.getNornalOvertimeHours();
		buff[count++] = b.getWeekendOvertimeHours();
		buff[count++] = b.getHolidayOvertimeHours();
		buff[count++] = b.getAbsenceDays();
		buff[count++] = b.getShouldDays();
		buff[count++] = b.getFactDays();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsLocked();
		buff[count++] = b.getNumberOfLate();
		buff[count++] = b.getLateForMinutes();
		buff[count++] = b.getNumberOfLeave();
		buff[count++] = b.getLeaveForMinutes();
		buff[count++] = b.getLateCharge();
		buff[count++] = b.getAdjust();
		buff[count++] = b.getAnnualLeave();
		buff[count++] = b.getWeddingLeave();
		buff[count++] = b.getMaternityLeave();
		buff[count++] = b.getPrenatalCheckLeave();
		buff[count++] = b.getMaternityLeaveDays();
		buff[count++] = b.getFuneralLeave();
		buff[count++] = b.getOutForBusiness();
		buff[count++] = b.getOvertimePay();
		buff[count++] = b.getOvertimePaySub();
		buff[count++] = b.getOvertimePaySubBefore();
		buff[count++] = b.getOvertimePayBefore();
		buff[count++] = b.getIsFullTime();
	}

	@Override
	public void setDataFromBase(BaseEmployeeMonthCheck b){
		if(b.getEmployeeMonthCheckId() != null) setEmployeeMonthCheckIdClear(b.getEmployeeMonthCheckId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getLateLeave5m() != null) setLateLeave5m(b.getLateLeave5m());
		if(b.getLateLeave10m() != null) setLateLeave10m(b.getLateLeave10m());
		if(b.getLateLeave30m() != null) setLateLeave30m(b.getLateLeave30m());
		if(b.getLateLeave() != null) setLateLeave(b.getLateLeave());
		if(b.getThingLeaveTimes() != null) setThingLeaveTimes(b.getThingLeaveTimes());
		if(b.getThingLeaveHours() != null) setThingLeaveHours(b.getThingLeaveHours());
		if(b.getThingLeaveDays() != null) setThingLeaveDays(b.getThingLeaveDays());
		if(b.getIllLeaveTimes() != null) setIllLeaveTimes(b.getIllLeaveTimes());
		if(b.getIllLeaveHours() != null) setIllLeaveHours(b.getIllLeaveHours());
		if(b.getIllLeaveDays() != null) setIllLeaveDays(b.getIllLeaveDays());
		if(b.getOtherLeaveTimes() != null) setOtherLeaveTimes(b.getOtherLeaveTimes());
		if(b.getOtherLeaveHours() != null) setOtherLeaveHours(b.getOtherLeaveHours());
		if(b.getOtherLeaveDays() != null) setOtherLeaveDays(b.getOtherLeaveDays());
		if(b.getNornalOvertimeHours() != null) setNornalOvertimeHours(b.getNornalOvertimeHours());
		if(b.getWeekendOvertimeHours() != null) setWeekendOvertimeHours(b.getWeekendOvertimeHours());
		if(b.getHolidayOvertimeHours() != null) setHolidayOvertimeHours(b.getHolidayOvertimeHours());
		if(b.getAbsenceDays() != null) setAbsenceDays(b.getAbsenceDays());
		if(b.getShouldDays() != null) setShouldDays(b.getShouldDays());
		if(b.getFactDays() != null) setFactDays(b.getFactDays());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsLocked() != null) setIsLocked(b.getIsLocked());
		if(b.getNumberOfLate() != null) setNumberOfLate(b.getNumberOfLate());
		if(b.getLateForMinutes() != null) setLateForMinutes(b.getLateForMinutes());
		if(b.getNumberOfLeave() != null) setNumberOfLeave(b.getNumberOfLeave());
		if(b.getLeaveForMinutes() != null) setLeaveForMinutes(b.getLeaveForMinutes());
		if(b.getLateCharge() != null) setLateCharge(b.getLateCharge());
		if(b.getAdjust() != null) setAdjust(b.getAdjust());
		if(b.getAnnualLeave() != null) setAnnualLeave(b.getAnnualLeave());
		if(b.getWeddingLeave() != null) setWeddingLeave(b.getWeddingLeave());
		if(b.getMaternityLeave() != null) setMaternityLeave(b.getMaternityLeave());
		if(b.getPrenatalCheckLeave() != null) setPrenatalCheckLeave(b.getPrenatalCheckLeave());
		if(b.getMaternityLeaveDays() != null) setMaternityLeaveDays(b.getMaternityLeaveDays());
		if(b.getFuneralLeave() != null) setFuneralLeave(b.getFuneralLeave());
		if(b.getOutForBusiness() != null) setOutForBusiness(b.getOutForBusiness());
		if(b.getOvertimePay() != null) setOvertimePay(b.getOvertimePay());
		if(b.getOvertimePaySub() != null) setOvertimePaySub(b.getOvertimePaySub());
		if(b.getOvertimePaySubBefore() != null) setOvertimePaySubBefore(b.getOvertimePaySubBefore());
		if(b.getOvertimePayBefore() != null) setOvertimePayBefore(b.getOvertimePayBefore());
		if(b.getIsFullTime() != null) setIsFullTime(b.getIsFullTime());
	}

	@Override
	public BaseEmployeeMonthCheck generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeMonthCheck b = new BaseEmployeeMonthCheck();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeMonthCheck __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeMonthCheckId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateLeave5m(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateLeave10m(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateLeave30m(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateLeave(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThingLeaveTimes(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThingLeaveHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThingLeaveDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllLeaveTimes(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllLeaveHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllLeaveDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherLeaveTimes(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherLeaveHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherLeaveDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNornalOvertimeHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWeekendOvertimeHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHolidayOvertimeHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAbsenceDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFactDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNumberOfLate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateForMinutes(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNumberOfLeave(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveForMinutes(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateCharge(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdjust(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnnualLeave(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWeddingLeave(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaternityLeave(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPrenatalCheckLeave(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaternityLeaveDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFuneralLeave(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOutForBusiness(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOvertimePay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOvertimePaySub(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOvertimePaySubBefore(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOvertimePayBefore(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsFullTime(GenericBase.__getBoolean(val));
	}

	public void setEmployeeMonthCheckId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeMonthCheckId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeMonthCheckIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setLateLeave5m(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getLateLeave5m() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setLateLeave10m(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getLateLeave10m() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setLateLeave30m(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getLateLeave30m() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setLateLeave(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getLateLeave() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setThingLeaveTimes(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getThingLeaveTimes() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setThingLeaveHours(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getThingLeaveHours() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setThingLeaveDays(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getThingLeaveDays() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setIllLeaveTimes(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getIllLeaveTimes() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setIllLeaveHours(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getIllLeaveHours() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setIllLeaveDays(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getIllLeaveDays() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setOtherLeaveTimes(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getOtherLeaveTimes() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setOtherLeaveHours(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getOtherLeaveHours() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setOtherLeaveDays(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getOtherLeaveDays() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setNornalOvertimeHours(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getNornalOvertimeHours() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setWeekendOvertimeHours(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getWeekendOvertimeHours() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setHolidayOvertimeHours(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getHolidayOvertimeHours() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setAbsenceDays(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getAbsenceDays() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setShouldDays(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getShouldDays() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setFactDays(java.math.BigDecimal val) {
		setCurrentData(22, val);
	}

	public java.math.BigDecimal getFactDays() {
		return GenericBase.__getDecimal(__current_data[22]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(24, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[24]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setIsLocked(java.lang.Boolean val) {
		setCurrentData(26, val);
	}

	public java.lang.Boolean getIsLocked() {
		return GenericBase.__getBoolean(__current_data[26]);
	}

	public void setNumberOfLate(java.math.BigDecimal val) {
		setCurrentData(27, val);
	}

	public java.math.BigDecimal getNumberOfLate() {
		return GenericBase.__getDecimal(__current_data[27]);
	}

	public void setLateForMinutes(java.math.BigDecimal val) {
		setCurrentData(28, val);
	}

	public java.math.BigDecimal getLateForMinutes() {
		return GenericBase.__getDecimal(__current_data[28]);
	}

	public void setNumberOfLeave(java.math.BigDecimal val) {
		setCurrentData(29, val);
	}

	public java.math.BigDecimal getNumberOfLeave() {
		return GenericBase.__getDecimal(__current_data[29]);
	}

	public void setLeaveForMinutes(java.math.BigDecimal val) {
		setCurrentData(30, val);
	}

	public java.math.BigDecimal getLeaveForMinutes() {
		return GenericBase.__getDecimal(__current_data[30]);
	}

	public void setLateCharge(java.math.BigDecimal val) {
		setCurrentData(31, val);
	}

	public java.math.BigDecimal getLateCharge() {
		return GenericBase.__getDecimal(__current_data[31]);
	}

	public void setAdjust(java.math.BigDecimal val) {
		setCurrentData(32, val);
	}

	public java.math.BigDecimal getAdjust() {
		return GenericBase.__getDecimal(__current_data[32]);
	}

	public void setAnnualLeave(java.math.BigDecimal val) {
		setCurrentData(33, val);
	}

	public java.math.BigDecimal getAnnualLeave() {
		return GenericBase.__getDecimal(__current_data[33]);
	}

	public void setWeddingLeave(java.math.BigDecimal val) {
		setCurrentData(34, val);
	}

	public java.math.BigDecimal getWeddingLeave() {
		return GenericBase.__getDecimal(__current_data[34]);
	}

	public void setMaternityLeave(java.math.BigDecimal val) {
		setCurrentData(35, val);
	}

	public java.math.BigDecimal getMaternityLeave() {
		return GenericBase.__getDecimal(__current_data[35]);
	}

	public void setPrenatalCheckLeave(java.math.BigDecimal val) {
		setCurrentData(36, val);
	}

	public java.math.BigDecimal getPrenatalCheckLeave() {
		return GenericBase.__getDecimal(__current_data[36]);
	}

	public void setMaternityLeaveDays(java.math.BigDecimal val) {
		setCurrentData(37, val);
	}

	public java.math.BigDecimal getMaternityLeaveDays() {
		return GenericBase.__getDecimal(__current_data[37]);
	}

	public void setFuneralLeave(java.math.BigDecimal val) {
		setCurrentData(38, val);
	}

	public java.math.BigDecimal getFuneralLeave() {
		return GenericBase.__getDecimal(__current_data[38]);
	}

	public void setOutForBusiness(java.math.BigDecimal val) {
		setCurrentData(39, val);
	}

	public java.math.BigDecimal getOutForBusiness() {
		return GenericBase.__getDecimal(__current_data[39]);
	}

	public void setOvertimePay(java.math.BigDecimal val) {
		setCurrentData(40, val);
	}

	public java.math.BigDecimal getOvertimePay() {
		return GenericBase.__getDecimal(__current_data[40]);
	}

	public void setOvertimePaySub(java.math.BigDecimal val) {
		setCurrentData(41, val);
	}

	public java.math.BigDecimal getOvertimePaySub() {
		return GenericBase.__getDecimal(__current_data[41]);
	}

	public void setOvertimePaySubBefore(java.math.BigDecimal val) {
		setCurrentData(42, val);
	}

	public java.math.BigDecimal getOvertimePaySubBefore() {
		return GenericBase.__getDecimal(__current_data[42]);
	}

	public void setOvertimePayBefore(java.math.BigDecimal val) {
		setCurrentData(43, val);
	}

	public java.math.BigDecimal getOvertimePayBefore() {
		return GenericBase.__getDecimal(__current_data[43]);
	}

	public void setIsFullTime(java.lang.Boolean val) {
		setCurrentData(44, val);
	}

	public java.lang.Boolean getIsFullTime() {
		return GenericBase.__getBoolean(__current_data[44]);
	}

	public void setConditionEmployeeMonthCheckId(String op, java.lang.Integer val) {
		setConditionEmployeeMonthCheckId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeMonthCheckId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeMonthCheckId(boolean val) {
		__select_flags[0] = val;
	}

	public void setEmployeeMonthCheckIdExpression(String val) {
		__dataExpressions[0] = val;
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

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setYearExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[3] = val;
	}

	public void setMonthExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionLateLeave5m(String op, java.lang.Integer val) {
		setConditionLateLeave5m(op, val, CONDITION_AND);
	}

	public void setConditionLateLeave5m(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectLateLeave5m(boolean val) {
		__select_flags[4] = val;
	}

	public void setLateLeave5mExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionLateLeave10m(String op, java.lang.Integer val) {
		setConditionLateLeave10m(op, val, CONDITION_AND);
	}

	public void setConditionLateLeave10m(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectLateLeave10m(boolean val) {
		__select_flags[5] = val;
	}

	public void setLateLeave10mExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionLateLeave30m(String op, java.lang.Integer val) {
		setConditionLateLeave30m(op, val, CONDITION_AND);
	}

	public void setConditionLateLeave30m(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectLateLeave30m(boolean val) {
		__select_flags[6] = val;
	}

	public void setLateLeave30mExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionLateLeave(String op, java.lang.Integer val) {
		setConditionLateLeave(op, val, CONDITION_AND);
	}

	public void setConditionLateLeave(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectLateLeave(boolean val) {
		__select_flags[7] = val;
	}

	public void setLateLeaveExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionThingLeaveTimes(String op, java.lang.Integer val) {
		setConditionThingLeaveTimes(op, val, CONDITION_AND);
	}

	public void setConditionThingLeaveTimes(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectThingLeaveTimes(boolean val) {
		__select_flags[8] = val;
	}

	public void setThingLeaveTimesExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionThingLeaveHours(String op, java.math.BigDecimal val) {
		setConditionThingLeaveHours(op, val, CONDITION_AND);
	}

	public void setConditionThingLeaveHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectThingLeaveHours(boolean val) {
		__select_flags[9] = val;
	}

	public void setThingLeaveHoursExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionThingLeaveDays(String op, java.math.BigDecimal val) {
		setConditionThingLeaveDays(op, val, CONDITION_AND);
	}

	public void setConditionThingLeaveDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectThingLeaveDays(boolean val) {
		__select_flags[10] = val;
	}

	public void setThingLeaveDaysExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionIllLeaveTimes(String op, java.lang.Integer val) {
		setConditionIllLeaveTimes(op, val, CONDITION_AND);
	}

	public void setConditionIllLeaveTimes(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectIllLeaveTimes(boolean val) {
		__select_flags[11] = val;
	}

	public void setIllLeaveTimesExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionIllLeaveHours(String op, java.math.BigDecimal val) {
		setConditionIllLeaveHours(op, val, CONDITION_AND);
	}

	public void setConditionIllLeaveHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIllLeaveHours(boolean val) {
		__select_flags[12] = val;
	}

	public void setIllLeaveHoursExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionIllLeaveDays(String op, java.math.BigDecimal val) {
		setConditionIllLeaveDays(op, val, CONDITION_AND);
	}

	public void setConditionIllLeaveDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectIllLeaveDays(boolean val) {
		__select_flags[13] = val;
	}

	public void setIllLeaveDaysExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionOtherLeaveTimes(String op, java.lang.Integer val) {
		setConditionOtherLeaveTimes(op, val, CONDITION_AND);
	}

	public void setConditionOtherLeaveTimes(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOtherLeaveTimes(boolean val) {
		__select_flags[14] = val;
	}

	public void setOtherLeaveTimesExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionOtherLeaveHours(String op, java.math.BigDecimal val) {
		setConditionOtherLeaveHours(op, val, CONDITION_AND);
	}

	public void setConditionOtherLeaveHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectOtherLeaveHours(boolean val) {
		__select_flags[15] = val;
	}

	public void setOtherLeaveHoursExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionOtherLeaveDays(String op, java.math.BigDecimal val) {
		setConditionOtherLeaveDays(op, val, CONDITION_AND);
	}

	public void setConditionOtherLeaveDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectOtherLeaveDays(boolean val) {
		__select_flags[16] = val;
	}

	public void setOtherLeaveDaysExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionNornalOvertimeHours(String op, java.math.BigDecimal val) {
		setConditionNornalOvertimeHours(op, val, CONDITION_AND);
	}

	public void setConditionNornalOvertimeHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectNornalOvertimeHours(boolean val) {
		__select_flags[17] = val;
	}

	public void setNornalOvertimeHoursExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionWeekendOvertimeHours(String op, java.math.BigDecimal val) {
		setConditionWeekendOvertimeHours(op, val, CONDITION_AND);
	}

	public void setConditionWeekendOvertimeHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectWeekendOvertimeHours(boolean val) {
		__select_flags[18] = val;
	}

	public void setWeekendOvertimeHoursExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionHolidayOvertimeHours(String op, java.math.BigDecimal val) {
		setConditionHolidayOvertimeHours(op, val, CONDITION_AND);
	}

	public void setConditionHolidayOvertimeHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectHolidayOvertimeHours(boolean val) {
		__select_flags[19] = val;
	}

	public void setHolidayOvertimeHoursExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionAbsenceDays(String op, java.math.BigDecimal val) {
		setConditionAbsenceDays(op, val, CONDITION_AND);
	}

	public void setConditionAbsenceDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectAbsenceDays(boolean val) {
		__select_flags[20] = val;
	}

	public void setAbsenceDaysExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionShouldDays(String op, java.math.BigDecimal val) {
		setConditionShouldDays(op, val, CONDITION_AND);
	}

	public void setConditionShouldDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectShouldDays(boolean val) {
		__select_flags[21] = val;
	}

	public void setShouldDaysExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionFactDays(String op, java.math.BigDecimal val) {
		setConditionFactDays(op, val, CONDITION_AND);
	}

	public void setConditionFactDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectFactDays(boolean val) {
		__select_flags[22] = val;
	}

	public void setFactDaysExpression(String val) {
		__dataExpressions[22] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[23] = val;
	}

	public void setOperateEmployeeIdExpression(String val) {
		__dataExpressions[23] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(24, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[24] = val;
	}

	public void setOperateTimeExpression(String val) {
		__dataExpressions[24] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[25] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[25] = val;
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val) {
		setConditionIsLocked(op, val, CONDITION_AND);
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectIsLocked(boolean val) {
		__select_flags[26] = val;
	}

	public void setIsLockedExpression(String val) {
		__dataExpressions[26] = val;
	}

	public void setConditionNumberOfLate(String op, java.math.BigDecimal val) {
		setConditionNumberOfLate(op, val, CONDITION_AND);
	}

	public void setConditionNumberOfLate(String op, java.math.BigDecimal val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectNumberOfLate(boolean val) {
		__select_flags[27] = val;
	}

	public void setNumberOfLateExpression(String val) {
		__dataExpressions[27] = val;
	}

	public void setConditionLateForMinutes(String op, java.math.BigDecimal val) {
		setConditionLateForMinutes(op, val, CONDITION_AND);
	}

	public void setConditionLateForMinutes(String op, java.math.BigDecimal val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectLateForMinutes(boolean val) {
		__select_flags[28] = val;
	}

	public void setLateForMinutesExpression(String val) {
		__dataExpressions[28] = val;
	}

	public void setConditionNumberOfLeave(String op, java.math.BigDecimal val) {
		setConditionNumberOfLeave(op, val, CONDITION_AND);
	}

	public void setConditionNumberOfLeave(String op, java.math.BigDecimal val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectNumberOfLeave(boolean val) {
		__select_flags[29] = val;
	}

	public void setNumberOfLeaveExpression(String val) {
		__dataExpressions[29] = val;
	}

	public void setConditionLeaveForMinutes(String op, java.math.BigDecimal val) {
		setConditionLeaveForMinutes(op, val, CONDITION_AND);
	}

	public void setConditionLeaveForMinutes(String op, java.math.BigDecimal val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectLeaveForMinutes(boolean val) {
		__select_flags[30] = val;
	}

	public void setLeaveForMinutesExpression(String val) {
		__dataExpressions[30] = val;
	}

	public void setConditionLateCharge(String op, java.math.BigDecimal val) {
		setConditionLateCharge(op, val, CONDITION_AND);
	}

	public void setConditionLateCharge(String op, java.math.BigDecimal val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectLateCharge(boolean val) {
		__select_flags[31] = val;
	}

	public void setLateChargeExpression(String val) {
		__dataExpressions[31] = val;
	}

	public void setConditionAdjust(String op, java.math.BigDecimal val) {
		setConditionAdjust(op, val, CONDITION_AND);
	}

	public void setConditionAdjust(String op, java.math.BigDecimal val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectAdjust(boolean val) {
		__select_flags[32] = val;
	}

	public void setAdjustExpression(String val) {
		__dataExpressions[32] = val;
	}

	public void setConditionAnnualLeave(String op, java.math.BigDecimal val) {
		setConditionAnnualLeave(op, val, CONDITION_AND);
	}

	public void setConditionAnnualLeave(String op, java.math.BigDecimal val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectAnnualLeave(boolean val) {
		__select_flags[33] = val;
	}

	public void setAnnualLeaveExpression(String val) {
		__dataExpressions[33] = val;
	}

	public void setConditionWeddingLeave(String op, java.math.BigDecimal val) {
		setConditionWeddingLeave(op, val, CONDITION_AND);
	}

	public void setConditionWeddingLeave(String op, java.math.BigDecimal val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectWeddingLeave(boolean val) {
		__select_flags[34] = val;
	}

	public void setWeddingLeaveExpression(String val) {
		__dataExpressions[34] = val;
	}

	public void setConditionMaternityLeave(String op, java.math.BigDecimal val) {
		setConditionMaternityLeave(op, val, CONDITION_AND);
	}

	public void setConditionMaternityLeave(String op, java.math.BigDecimal val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectMaternityLeave(boolean val) {
		__select_flags[35] = val;
	}

	public void setMaternityLeaveExpression(String val) {
		__dataExpressions[35] = val;
	}

	public void setConditionPrenatalCheckLeave(String op, java.math.BigDecimal val) {
		setConditionPrenatalCheckLeave(op, val, CONDITION_AND);
	}

	public void setConditionPrenatalCheckLeave(String op, java.math.BigDecimal val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectPrenatalCheckLeave(boolean val) {
		__select_flags[36] = val;
	}

	public void setPrenatalCheckLeaveExpression(String val) {
		__dataExpressions[36] = val;
	}

	public void setConditionMaternityLeaveDays(String op, java.math.BigDecimal val) {
		setConditionMaternityLeaveDays(op, val, CONDITION_AND);
	}

	public void setConditionMaternityLeaveDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectMaternityLeaveDays(boolean val) {
		__select_flags[37] = val;
	}

	public void setMaternityLeaveDaysExpression(String val) {
		__dataExpressions[37] = val;
	}

	public void setConditionFuneralLeave(String op, java.math.BigDecimal val) {
		setConditionFuneralLeave(op, val, CONDITION_AND);
	}

	public void setConditionFuneralLeave(String op, java.math.BigDecimal val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectFuneralLeave(boolean val) {
		__select_flags[38] = val;
	}

	public void setFuneralLeaveExpression(String val) {
		__dataExpressions[38] = val;
	}

	public void setConditionOutForBusiness(String op, java.math.BigDecimal val) {
		setConditionOutForBusiness(op, val, CONDITION_AND);
	}

	public void setConditionOutForBusiness(String op, java.math.BigDecimal val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectOutForBusiness(boolean val) {
		__select_flags[39] = val;
	}

	public void setOutForBusinessExpression(String val) {
		__dataExpressions[39] = val;
	}

	public void setConditionOvertimePay(String op, java.math.BigDecimal val) {
		setConditionOvertimePay(op, val, CONDITION_AND);
	}

	public void setConditionOvertimePay(String op, java.math.BigDecimal val, String relation) {
		addCondition(40, op, relation, val);
	}

	public void setSelectOvertimePay(boolean val) {
		__select_flags[40] = val;
	}

	public void setOvertimePayExpression(String val) {
		__dataExpressions[40] = val;
	}

	public void setConditionOvertimePaySub(String op, java.math.BigDecimal val) {
		setConditionOvertimePaySub(op, val, CONDITION_AND);
	}

	public void setConditionOvertimePaySub(String op, java.math.BigDecimal val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectOvertimePaySub(boolean val) {
		__select_flags[41] = val;
	}

	public void setOvertimePaySubExpression(String val) {
		__dataExpressions[41] = val;
	}

	public void setConditionOvertimePaySubBefore(String op, java.math.BigDecimal val) {
		setConditionOvertimePaySubBefore(op, val, CONDITION_AND);
	}

	public void setConditionOvertimePaySubBefore(String op, java.math.BigDecimal val, String relation) {
		addCondition(42, op, relation, val);
	}

	public void setSelectOvertimePaySubBefore(boolean val) {
		__select_flags[42] = val;
	}

	public void setOvertimePaySubBeforeExpression(String val) {
		__dataExpressions[42] = val;
	}

	public void setConditionOvertimePayBefore(String op, java.math.BigDecimal val) {
		setConditionOvertimePayBefore(op, val, CONDITION_AND);
	}

	public void setConditionOvertimePayBefore(String op, java.math.BigDecimal val, String relation) {
		addCondition(43, op, relation, val);
	}

	public void setSelectOvertimePayBefore(boolean val) {
		__select_flags[43] = val;
	}

	public void setOvertimePayBeforeExpression(String val) {
		__dataExpressions[43] = val;
	}

	public void setConditionIsFullTime(String op, java.lang.Boolean val) {
		setConditionIsFullTime(op, val, CONDITION_AND);
	}

	public void setConditionIsFullTime(String op, java.lang.Boolean val, String relation) {
		addCondition(44, op, relation, val);
	}

	public void setSelectIsFullTime(boolean val) {
		__select_flags[44] = val;
	}

	public void setIsFullTimeExpression(String val) {
		__dataExpressions[44] = val;
	}


}

