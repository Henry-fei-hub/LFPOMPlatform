package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryException;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryException extends AbstractTable<BaseSalaryException>
{

	public SalaryException() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "salary_exceptions";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryException.CS_SALARY_EXCEPTION_ID;
		__column_names[1] = BaseSalaryException.CS_YEAR;
		__column_names[2] = BaseSalaryException.CS_MONTH;
		__column_names[3] = BaseSalaryException.CS_PERSONNEL_BUSINESS_ID;
		__column_names[4] = BaseSalaryException.CS_EMPLOYEE_ID;
		__column_names[5] = BaseSalaryException.CS_REASON;
		__column_names[6] = BaseSalaryException.CS_ATTENDANCE_DEDUCTION;
		__column_names[7] = BaseSalaryException.CS_RECORD_DATE;
		__column_names[8] = BaseSalaryException.CS_OPERATE_TIME;
		__column_names[9] = BaseSalaryException.CS_REMARK;
		__column_names[10] = BaseSalaryException.CS_IS_APPLY;
		__column_names[11] = BaseSalaryException.CS_ACTUALLY_DEDUCTION;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryException b) {
		clear();
		setSalaryExceptionIdClear(b.getSalaryExceptionId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryExceptionId() == null;
	}

	@Override
	public BaseSalaryException generateBase(){
		BaseSalaryException b = new BaseSalaryException();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryException b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryExceptionId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttendanceDeduction(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsApply(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setActuallyDeduction(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryException b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryExceptionId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getReason();
		buff[count++] = b.getAttendanceDeduction();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsApply();
		buff[count++] = b.getActuallyDeduction();
	}

	@Override
	public void setDataFromBase(BaseSalaryException b){
		if(b.getSalaryExceptionId() != null) setSalaryExceptionIdClear(b.getSalaryExceptionId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getReason() != null) setReason(b.getReason());
		if(b.getAttendanceDeduction() != null) setAttendanceDeduction(b.getAttendanceDeduction());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsApply() != null) setIsApply(b.getIsApply());
		if(b.getActuallyDeduction() != null) setActuallyDeduction(b.getActuallyDeduction());
	}

	@Override
	public BaseSalaryException generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryException b = new BaseSalaryException();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryException __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryExceptionId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttendanceDeduction(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsApply(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActuallyDeduction(GenericBase.__getDecimal(val));
	}

	public void setSalaryExceptionId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryExceptionId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryExceptionIdClear(java.lang.Integer val) {
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

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setReason(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getReason() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setAttendanceDeduction(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getAttendanceDeduction() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setIsApply(java.lang.Boolean val) {
		setCurrentData(10, val);
	}

	public java.lang.Boolean getIsApply() {
		return GenericBase.__getBoolean(__current_data[10]);
	}

	public void setActuallyDeduction(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getActuallyDeduction() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setConditionSalaryExceptionId(String op, java.lang.Integer val) {
		setConditionSalaryExceptionId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryExceptionId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryExceptionId(boolean val) {
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

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionReason(String op, java.lang.String val) {
		setConditionReason(op, val, CONDITION_AND);
	}

	public void setConditionReason(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectReason(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAttendanceDeduction(String op, java.math.BigDecimal val) {
		setConditionAttendanceDeduction(op, val, CONDITION_AND);
	}

	public void setConditionAttendanceDeduction(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAttendanceDeduction(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionIsApply(String op, java.lang.Boolean val) {
		setConditionIsApply(op, val, CONDITION_AND);
	}

	public void setConditionIsApply(String op, java.lang.Boolean val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectIsApply(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionActuallyDeduction(String op, java.math.BigDecimal val) {
		setConditionActuallyDeduction(op, val, CONDITION_AND);
	}

	public void setConditionActuallyDeduction(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectActuallyDeduction(boolean val) {
		__select_flags[11] = val;
	}


}

