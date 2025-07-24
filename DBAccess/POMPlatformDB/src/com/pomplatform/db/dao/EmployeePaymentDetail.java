package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeePaymentDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeePaymentDetail extends AbstractTable<BaseEmployeePaymentDetail>
{

	public EmployeePaymentDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 35;

		initTables();

		__tableName            = "employee_payment_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeePaymentDetail.CS_EMPLOYEE_PAYMENT_DETAIL_ID;
		__column_names[1] = BaseEmployeePaymentDetail.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeePaymentDetail.CS_DETAIL_DATE;
		__column_names[3] = BaseEmployeePaymentDetail.CS_DETAIL_WEEK;
		__column_names[4] = BaseEmployeePaymentDetail.CS_MONTH_PAY;
		__column_names[5] = BaseEmployeePaymentDetail.CS_BASIC_PROPORTION_STR;
		__column_names[6] = BaseEmployeePaymentDetail.CS_BASIC_PROPORTION;
		__column_names[7] = BaseEmployeePaymentDetail.CS_MONTH_BASIC_PAY;
		__column_names[8] = BaseEmployeePaymentDetail.CS_MONTH_PERFORMANCE_PAY;
		__column_names[9] = BaseEmployeePaymentDetail.CS_FOREMAN_PAY;
		__column_names[10] = BaseEmployeePaymentDetail.CS_MONTH_WORK_DAY;
		__column_names[11] = BaseEmployeePaymentDetail.CS_MONTH_TOTAL_DAY;
		__column_names[12] = BaseEmployeePaymentDetail.CS_DAY_WORK_TIME;
		__column_names[13] = BaseEmployeePaymentDetail.CS_DAY_PAY;
		__column_names[14] = BaseEmployeePaymentDetail.CS_DAY_FOREMAN_PAY;
		__column_names[15] = BaseEmployeePaymentDetail.CS_DAY_COST;
		__column_names[16] = BaseEmployeePaymentDetail.CS_UNIT_TOTAL_FUND;
		__column_names[17] = BaseEmployeePaymentDetail.CS_REMARK;
		__column_names[18] = BaseEmployeePaymentDetail.CS_LATE_LEAVE_10M;
		__column_names[19] = BaseEmployeePaymentDetail.CS_LATE_LEAVE_30M;
		__column_names[20] = BaseEmployeePaymentDetail.CS_LATE_LEAVE;
		__column_names[21] = BaseEmployeePaymentDetail.CS_THING_LEAVE_DAYS;
		__column_names[22] = BaseEmployeePaymentDetail.CS_THING_LEAVE_HOURS;
		__column_names[23] = BaseEmployeePaymentDetail.CS_ILL_LEAVE_DAYS;
		__column_names[24] = BaseEmployeePaymentDetail.CS_ILL_PERCENT_STR;
		__column_names[25] = BaseEmployeePaymentDetail.CS_ILL_PERCENT;
		__column_names[26] = BaseEmployeePaymentDetail.CS_LATE_LEAVE_TOTAL;
		__column_names[27] = BaseEmployeePaymentDetail.CS_THING_TOTAL;
		__column_names[28] = BaseEmployeePaymentDetail.CS_ILL_TOTAL;
		__column_names[29] = BaseEmployeePaymentDetail.CS_DEDUCT_TOTAL;
		__column_names[30] = BaseEmployeePaymentDetail.CS_ILL_LEAVE_HOURS;
		__column_names[31] = BaseEmployeePaymentDetail.CS_UNIT_TOTAL_INSURANCE;
		__column_names[32] = BaseEmployeePaymentDetail.CS_ALL_SALARY;
		__column_names[33] = BaseEmployeePaymentDetail.CS_DAY_ATTENDANCE_DEDUCTION;
		__column_names[34] = BaseEmployeePaymentDetail.CS_IS_LOCKED;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeePaymentDetail b) {
		clear();
		setEmployeePaymentDetailIdClear(b.getEmployeePaymentDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeePaymentDetailId() == null;
	}

	@Override
	public BaseEmployeePaymentDetail generateBase(){
		BaseEmployeePaymentDetail b = new BaseEmployeePaymentDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeePaymentDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeePaymentDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDetailDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDetailWeek(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonthPay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBasicProportionStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthBasicPay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthPerformancePay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setForemanPay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthWorkDay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthTotalDay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDayWorkTime(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDayPay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDayForemanPay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDayCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitTotalFund(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLateLeave10m(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLateLeave30m(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLateLeave(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setThingLeaveDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setThingLeaveHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIllLeaveDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIllPercentStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIllPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLateLeaveTotal(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setThingTotal(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIllTotal(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDeductTotal(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIllLeaveHours(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAllSalary(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDayAttendanceDeduction(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsLocked(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeePaymentDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeePaymentDetailId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getDetailDate());
		buff[count++] = b.getDetailWeek();
		buff[count++] = b.getMonthPay();
		buff[count++] = b.getBasicProportionStr();
		buff[count++] = b.getBasicProportion();
		buff[count++] = b.getMonthBasicPay();
		buff[count++] = b.getMonthPerformancePay();
		buff[count++] = b.getForemanPay();
		buff[count++] = b.getMonthWorkDay();
		buff[count++] = b.getMonthTotalDay();
		buff[count++] = b.getDayWorkTime();
		buff[count++] = b.getDayPay();
		buff[count++] = b.getDayForemanPay();
		buff[count++] = b.getDayCost();
		buff[count++] = b.getUnitTotalFund();
		buff[count++] = b.getRemark();
		buff[count++] = b.getLateLeave10m();
		buff[count++] = b.getLateLeave30m();
		buff[count++] = b.getLateLeave();
		buff[count++] = b.getThingLeaveDays();
		buff[count++] = b.getThingLeaveHours();
		buff[count++] = b.getIllLeaveDays();
		buff[count++] = b.getIllPercentStr();
		buff[count++] = b.getIllPercent();
		buff[count++] = b.getLateLeaveTotal();
		buff[count++] = b.getThingTotal();
		buff[count++] = b.getIllTotal();
		buff[count++] = b.getDeductTotal();
		buff[count++] = b.getIllLeaveHours();
		buff[count++] = b.getUnitTotalInsurance();
		buff[count++] = b.getAllSalary();
		buff[count++] = b.getDayAttendanceDeduction();
		buff[count++] = b.getIsLocked();
	}

	@Override
	public void setDataFromBase(BaseEmployeePaymentDetail b){
		if(b.getEmployeePaymentDetailId() != null) setEmployeePaymentDetailIdClear(b.getEmployeePaymentDetailId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getDetailDate() != null) setDetailDate(b.getDetailDate());
		if(b.getDetailWeek() != null) setDetailWeek(b.getDetailWeek());
		if(b.getMonthPay() != null) setMonthPay(b.getMonthPay());
		if(b.getBasicProportionStr() != null) setBasicProportionStr(b.getBasicProportionStr());
		if(b.getBasicProportion() != null) setBasicProportion(b.getBasicProportion());
		if(b.getMonthBasicPay() != null) setMonthBasicPay(b.getMonthBasicPay());
		if(b.getMonthPerformancePay() != null) setMonthPerformancePay(b.getMonthPerformancePay());
		if(b.getForemanPay() != null) setForemanPay(b.getForemanPay());
		if(b.getMonthWorkDay() != null) setMonthWorkDay(b.getMonthWorkDay());
		if(b.getMonthTotalDay() != null) setMonthTotalDay(b.getMonthTotalDay());
		if(b.getDayWorkTime() != null) setDayWorkTime(b.getDayWorkTime());
		if(b.getDayPay() != null) setDayPay(b.getDayPay());
		if(b.getDayForemanPay() != null) setDayForemanPay(b.getDayForemanPay());
		if(b.getDayCost() != null) setDayCost(b.getDayCost());
		if(b.getUnitTotalFund() != null) setUnitTotalFund(b.getUnitTotalFund());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getLateLeave10m() != null) setLateLeave10m(b.getLateLeave10m());
		if(b.getLateLeave30m() != null) setLateLeave30m(b.getLateLeave30m());
		if(b.getLateLeave() != null) setLateLeave(b.getLateLeave());
		if(b.getThingLeaveDays() != null) setThingLeaveDays(b.getThingLeaveDays());
		if(b.getThingLeaveHours() != null) setThingLeaveHours(b.getThingLeaveHours());
		if(b.getIllLeaveDays() != null) setIllLeaveDays(b.getIllLeaveDays());
		if(b.getIllPercentStr() != null) setIllPercentStr(b.getIllPercentStr());
		if(b.getIllPercent() != null) setIllPercent(b.getIllPercent());
		if(b.getLateLeaveTotal() != null) setLateLeaveTotal(b.getLateLeaveTotal());
		if(b.getThingTotal() != null) setThingTotal(b.getThingTotal());
		if(b.getIllTotal() != null) setIllTotal(b.getIllTotal());
		if(b.getDeductTotal() != null) setDeductTotal(b.getDeductTotal());
		if(b.getIllLeaveHours() != null) setIllLeaveHours(b.getIllLeaveHours());
		if(b.getUnitTotalInsurance() != null) setUnitTotalInsurance(b.getUnitTotalInsurance());
		if(b.getAllSalary() != null) setAllSalary(b.getAllSalary());
		if(b.getDayAttendanceDeduction() != null) setDayAttendanceDeduction(b.getDayAttendanceDeduction());
		if(b.getIsLocked() != null) setIsLocked(b.getIsLocked());
	}

	@Override
	public BaseEmployeePaymentDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeePaymentDetail b = new BaseEmployeePaymentDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeePaymentDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeePaymentDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetailDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetailWeek(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthPay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicProportionStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthBasicPay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthPerformancePay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setForemanPay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthWorkDay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthTotalDay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDayWorkTime(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDayPay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDayForemanPay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDayCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateLeave10m(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateLeave30m(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateLeave(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThingLeaveDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThingLeaveHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllLeaveDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllPercentStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLateLeaveTotal(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThingTotal(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllTotal(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeductTotal(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIllLeaveHours(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAllSalary(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDayAttendanceDeduction(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
	}

	public void setEmployeePaymentDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeePaymentDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeePaymentDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDetailDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getDetailDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setDetailWeek(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDetailWeek() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setMonthPay(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getMonthPay() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setBasicProportionStr(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getBasicProportionStr() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setBasicProportion(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getBasicProportion() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setMonthBasicPay(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getMonthBasicPay() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setMonthPerformancePay(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getMonthPerformancePay() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setForemanPay(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getForemanPay() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setMonthWorkDay(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getMonthWorkDay() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setMonthTotalDay(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getMonthTotalDay() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setDayWorkTime(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getDayWorkTime() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setDayPay(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getDayPay() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setDayForemanPay(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getDayForemanPay() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setDayCost(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getDayCost() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setUnitTotalFund(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getUnitTotalFund() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setLateLeave10m(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getLateLeave10m() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setLateLeave30m(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getLateLeave30m() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setLateLeave(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getLateLeave() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setThingLeaveDays(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getThingLeaveDays() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setThingLeaveHours(java.math.BigDecimal val) {
		setCurrentData(22, val);
	}

	public java.math.BigDecimal getThingLeaveHours() {
		return GenericBase.__getDecimal(__current_data[22]);
	}

	public void setIllLeaveDays(java.math.BigDecimal val) {
		setCurrentData(23, val);
	}

	public java.math.BigDecimal getIllLeaveDays() {
		return GenericBase.__getDecimal(__current_data[23]);
	}

	public void setIllPercentStr(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getIllPercentStr() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setIllPercent(java.math.BigDecimal val) {
		setCurrentData(25, val);
	}

	public java.math.BigDecimal getIllPercent() {
		return GenericBase.__getDecimal(__current_data[25]);
	}

	public void setLateLeaveTotal(java.math.BigDecimal val) {
		setCurrentData(26, val);
	}

	public java.math.BigDecimal getLateLeaveTotal() {
		return GenericBase.__getDecimal(__current_data[26]);
	}

	public void setThingTotal(java.math.BigDecimal val) {
		setCurrentData(27, val);
	}

	public java.math.BigDecimal getThingTotal() {
		return GenericBase.__getDecimal(__current_data[27]);
	}

	public void setIllTotal(java.math.BigDecimal val) {
		setCurrentData(28, val);
	}

	public java.math.BigDecimal getIllTotal() {
		return GenericBase.__getDecimal(__current_data[28]);
	}

	public void setDeductTotal(java.math.BigDecimal val) {
		setCurrentData(29, val);
	}

	public java.math.BigDecimal getDeductTotal() {
		return GenericBase.__getDecimal(__current_data[29]);
	}

	public void setIllLeaveHours(java.math.BigDecimal val) {
		setCurrentData(30, val);
	}

	public java.math.BigDecimal getIllLeaveHours() {
		return GenericBase.__getDecimal(__current_data[30]);
	}

	public void setUnitTotalInsurance(java.math.BigDecimal val) {
		setCurrentData(31, val);
	}

	public java.math.BigDecimal getUnitTotalInsurance() {
		return GenericBase.__getDecimal(__current_data[31]);
	}

	public void setAllSalary(java.math.BigDecimal val) {
		setCurrentData(32, val);
	}

	public java.math.BigDecimal getAllSalary() {
		return GenericBase.__getDecimal(__current_data[32]);
	}

	public void setDayAttendanceDeduction(java.math.BigDecimal val) {
		setCurrentData(33, val);
	}

	public java.math.BigDecimal getDayAttendanceDeduction() {
		return GenericBase.__getDecimal(__current_data[33]);
	}

	public void setIsLocked(java.lang.Boolean val) {
		setCurrentData(34, val);
	}

	public java.lang.Boolean getIsLocked() {
		return GenericBase.__getBoolean(__current_data[34]);
	}

	public void setConditionEmployeePaymentDetailId(String op, java.lang.Integer val) {
		setConditionEmployeePaymentDetailId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeePaymentDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeePaymentDetailId(boolean val) {
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

	public void setConditionDetailDate(String op, java.util.Date val) {
		setConditionDetailDate(op, val, CONDITION_AND);
	}

	public void setConditionDetailDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectDetailDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDetailWeek(String op, java.lang.Integer val) {
		setConditionDetailWeek(op, val, CONDITION_AND);
	}

	public void setConditionDetailWeek(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDetailWeek(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMonthPay(String op, java.math.BigDecimal val) {
		setConditionMonthPay(op, val, CONDITION_AND);
	}

	public void setConditionMonthPay(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMonthPay(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionBasicProportionStr(String op, java.lang.String val) {
		setConditionBasicProportionStr(op, val, CONDITION_AND);
	}

	public void setConditionBasicProportionStr(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectBasicProportionStr(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionBasicProportion(String op, java.math.BigDecimal val) {
		setConditionBasicProportion(op, val, CONDITION_AND);
	}

	public void setConditionBasicProportion(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectBasicProportion(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMonthBasicPay(String op, java.math.BigDecimal val) {
		setConditionMonthBasicPay(op, val, CONDITION_AND);
	}

	public void setConditionMonthBasicPay(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMonthBasicPay(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionMonthPerformancePay(String op, java.math.BigDecimal val) {
		setConditionMonthPerformancePay(op, val, CONDITION_AND);
	}

	public void setConditionMonthPerformancePay(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectMonthPerformancePay(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionForemanPay(String op, java.math.BigDecimal val) {
		setConditionForemanPay(op, val, CONDITION_AND);
	}

	public void setConditionForemanPay(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectForemanPay(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionMonthWorkDay(String op, java.math.BigDecimal val) {
		setConditionMonthWorkDay(op, val, CONDITION_AND);
	}

	public void setConditionMonthWorkDay(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectMonthWorkDay(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionMonthTotalDay(String op, java.math.BigDecimal val) {
		setConditionMonthTotalDay(op, val, CONDITION_AND);
	}

	public void setConditionMonthTotalDay(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectMonthTotalDay(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionDayWorkTime(String op, java.math.BigDecimal val) {
		setConditionDayWorkTime(op, val, CONDITION_AND);
	}

	public void setConditionDayWorkTime(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectDayWorkTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionDayPay(String op, java.math.BigDecimal val) {
		setConditionDayPay(op, val, CONDITION_AND);
	}

	public void setConditionDayPay(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDayPay(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionDayForemanPay(String op, java.math.BigDecimal val) {
		setConditionDayForemanPay(op, val, CONDITION_AND);
	}

	public void setConditionDayForemanPay(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectDayForemanPay(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionDayCost(String op, java.math.BigDecimal val) {
		setConditionDayCost(op, val, CONDITION_AND);
	}

	public void setConditionDayCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectDayCost(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionUnitTotalFund(String op, java.math.BigDecimal val) {
		setConditionUnitTotalFund(op, val, CONDITION_AND);
	}

	public void setConditionUnitTotalFund(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectUnitTotalFund(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionLateLeave10m(String op, java.lang.Integer val) {
		setConditionLateLeave10m(op, val, CONDITION_AND);
	}

	public void setConditionLateLeave10m(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectLateLeave10m(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionLateLeave30m(String op, java.lang.Integer val) {
		setConditionLateLeave30m(op, val, CONDITION_AND);
	}

	public void setConditionLateLeave30m(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectLateLeave30m(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionLateLeave(String op, java.lang.Integer val) {
		setConditionLateLeave(op, val, CONDITION_AND);
	}

	public void setConditionLateLeave(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectLateLeave(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionThingLeaveDays(String op, java.math.BigDecimal val) {
		setConditionThingLeaveDays(op, val, CONDITION_AND);
	}

	public void setConditionThingLeaveDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectThingLeaveDays(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionThingLeaveHours(String op, java.math.BigDecimal val) {
		setConditionThingLeaveHours(op, val, CONDITION_AND);
	}

	public void setConditionThingLeaveHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectThingLeaveHours(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionIllLeaveDays(String op, java.math.BigDecimal val) {
		setConditionIllLeaveDays(op, val, CONDITION_AND);
	}

	public void setConditionIllLeaveDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectIllLeaveDays(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionIllPercentStr(String op, java.lang.String val) {
		setConditionIllPercentStr(op, val, CONDITION_AND);
	}

	public void setConditionIllPercentStr(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectIllPercentStr(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionIllPercent(String op, java.math.BigDecimal val) {
		setConditionIllPercent(op, val, CONDITION_AND);
	}

	public void setConditionIllPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectIllPercent(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionLateLeaveTotal(String op, java.math.BigDecimal val) {
		setConditionLateLeaveTotal(op, val, CONDITION_AND);
	}

	public void setConditionLateLeaveTotal(String op, java.math.BigDecimal val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectLateLeaveTotal(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionThingTotal(String op, java.math.BigDecimal val) {
		setConditionThingTotal(op, val, CONDITION_AND);
	}

	public void setConditionThingTotal(String op, java.math.BigDecimal val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectThingTotal(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionIllTotal(String op, java.math.BigDecimal val) {
		setConditionIllTotal(op, val, CONDITION_AND);
	}

	public void setConditionIllTotal(String op, java.math.BigDecimal val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectIllTotal(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionDeductTotal(String op, java.math.BigDecimal val) {
		setConditionDeductTotal(op, val, CONDITION_AND);
	}

	public void setConditionDeductTotal(String op, java.math.BigDecimal val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectDeductTotal(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionIllLeaveHours(String op, java.math.BigDecimal val) {
		setConditionIllLeaveHours(op, val, CONDITION_AND);
	}

	public void setConditionIllLeaveHours(String op, java.math.BigDecimal val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectIllLeaveHours(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionUnitTotalInsurance(String op, java.math.BigDecimal val) {
		setConditionUnitTotalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionUnitTotalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectUnitTotalInsurance(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionAllSalary(String op, java.math.BigDecimal val) {
		setConditionAllSalary(op, val, CONDITION_AND);
	}

	public void setConditionAllSalary(String op, java.math.BigDecimal val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectAllSalary(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionDayAttendanceDeduction(String op, java.math.BigDecimal val) {
		setConditionDayAttendanceDeduction(op, val, CONDITION_AND);
	}

	public void setConditionDayAttendanceDeduction(String op, java.math.BigDecimal val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectDayAttendanceDeduction(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val) {
		setConditionIsLocked(op, val, CONDITION_AND);
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectIsLocked(boolean val) {
		__select_flags[34] = val;
	}


}

