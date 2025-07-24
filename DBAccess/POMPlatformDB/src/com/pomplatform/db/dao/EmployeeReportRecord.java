package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeReportRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeReportRecord extends AbstractTable<BaseEmployeeReportRecord>
{

	public EmployeeReportRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "employee_report_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeReportRecord.CS_EMPLOYEE_REPORT_RECORD_ID;
		__column_names[1] = BaseEmployeeReportRecord.CS_PLATE_ID;
		__column_names[2] = BaseEmployeeReportRecord.CS_EMPLOYEE_ID;
		__column_names[3] = BaseEmployeeReportRecord.CS_EMPLOYEE_NAME;
		__column_names[4] = BaseEmployeeReportRecord.CS_EMPLOYEE_NO;
		__column_names[5] = BaseEmployeeReportRecord.CS_ACHIEVE_INTEGRAL;
		__column_names[6] = BaseEmployeeReportRecord.CS_SURE_INTEGRAL;
		__column_names[7] = BaseEmployeeReportRecord.CS_MANAGER_PROJECT_INTEGRAL;
		__column_names[8] = BaseEmployeeReportRecord.CS_SALARY_ADVANCE;
		__column_names[9] = BaseEmployeeReportRecord.CS_SALARY_RETURN;
		__column_names[10] = BaseEmployeeReportRecord.CS_SALARY;
		__column_names[11] = BaseEmployeeReportRecord.CS_PROJECT_COST;
		__column_names[12] = BaseEmployeeReportRecord.CS_RECORD_DATE;
		__column_names[13] = BaseEmployeeReportRecord.CS_IS_LOCK;
		__column_names[14] = BaseEmployeeReportRecord.CS_PROJECT_ADVANCE;
		__column_names[15] = BaseEmployeeReportRecord.CS_BONUS_PAYMENT;
		__column_names[16] = BaseEmployeeReportRecord.CS_INTEGRAL_RETURN;
		__column_names[17] = BaseEmployeeReportRecord.CS_VIOLATION_CHARGES;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeReportRecord b) {
		clear();
		setEmployeeReportRecordIdClear(b.getEmployeeReportRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeReportRecordId() == null;
	}

	@Override
	public BaseEmployeeReportRecord generateBase(){
		BaseEmployeeReportRecord b = new BaseEmployeeReportRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeReportRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeReportRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setManagerProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalaryAdvance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalaryReturn(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalary(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsLock(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setProjectAdvance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBonusPayment(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIntegralReturn(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setViolationCharges(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeReportRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeReportRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getAchieveIntegral();
		buff[count++] = b.getSureIntegral();
		buff[count++] = b.getManagerProjectIntegral();
		buff[count++] = b.getSalaryAdvance();
		buff[count++] = b.getSalaryReturn();
		buff[count++] = b.getSalary();
		buff[count++] = b.getProjectCost();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getIsLock();
		buff[count++] = b.getProjectAdvance();
		buff[count++] = b.getBonusPayment();
		buff[count++] = b.getIntegralReturn();
		buff[count++] = b.getViolationCharges();
	}

	@Override
	public void setDataFromBase(BaseEmployeeReportRecord b){
		if(b.getEmployeeReportRecordId() != null) setEmployeeReportRecordIdClear(b.getEmployeeReportRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getAchieveIntegral() != null) setAchieveIntegral(b.getAchieveIntegral());
		if(b.getSureIntegral() != null) setSureIntegral(b.getSureIntegral());
		if(b.getManagerProjectIntegral() != null) setManagerProjectIntegral(b.getManagerProjectIntegral());
		if(b.getSalaryAdvance() != null) setSalaryAdvance(b.getSalaryAdvance());
		if(b.getSalaryReturn() != null) setSalaryReturn(b.getSalaryReturn());
		if(b.getSalary() != null) setSalary(b.getSalary());
		if(b.getProjectCost() != null) setProjectCost(b.getProjectCost());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getIsLock() != null) setIsLock(b.getIsLock());
		if(b.getProjectAdvance() != null) setProjectAdvance(b.getProjectAdvance());
		if(b.getBonusPayment() != null) setBonusPayment(b.getBonusPayment());
		if(b.getIntegralReturn() != null) setIntegralReturn(b.getIntegralReturn());
		if(b.getViolationCharges() != null) setViolationCharges(b.getViolationCharges());
	}

	@Override
	public BaseEmployeeReportRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeReportRecord b = new BaseEmployeeReportRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeReportRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeReportRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setManagerProjectIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryAdvance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryReturn(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalary(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLock(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAdvance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBonusPayment(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntegralReturn(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setViolationCharges(GenericBase.__getDecimal(val));
	}

	public void setEmployeeReportRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeReportRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeReportRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setAchieveIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setSureIntegral(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getSureIntegral() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setManagerProjectIntegral(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getManagerProjectIntegral() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setSalaryAdvance(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getSalaryAdvance() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setSalaryReturn(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getSalaryReturn() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setSalary(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getSalary() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setProjectCost(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getProjectCost() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setIsLock(java.lang.Boolean val) {
		setCurrentData(13, val);
	}

	public java.lang.Boolean getIsLock() {
		return GenericBase.__getBoolean(__current_data[13]);
	}

	public void setProjectAdvance(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getProjectAdvance() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setBonusPayment(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getBonusPayment() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setIntegralReturn(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getIntegralReturn() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setViolationCharges(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getViolationCharges() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setConditionEmployeeReportRecordId(String op, java.lang.Integer val) {
		setConditionEmployeeReportRecordId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeReportRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeReportRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
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

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val) {
		setConditionAchieveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAchieveIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val) {
		setConditionSureIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSureIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSureIntegral(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionManagerProjectIntegral(String op, java.math.BigDecimal val) {
		setConditionManagerProjectIntegral(op, val, CONDITION_AND);
	}

	public void setConditionManagerProjectIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectManagerProjectIntegral(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSalaryAdvance(String op, java.math.BigDecimal val) {
		setConditionSalaryAdvance(op, val, CONDITION_AND);
	}

	public void setConditionSalaryAdvance(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSalaryAdvance(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionSalaryReturn(String op, java.math.BigDecimal val) {
		setConditionSalaryReturn(op, val, CONDITION_AND);
	}

	public void setConditionSalaryReturn(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectSalaryReturn(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSalary(String op, java.math.BigDecimal val) {
		setConditionSalary(op, val, CONDITION_AND);
	}

	public void setConditionSalary(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSalary(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val) {
		setConditionProjectCost(op, val, CONDITION_AND);
	}

	public void setConditionProjectCost(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectProjectCost(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionIsLock(String op, java.lang.Boolean val) {
		setConditionIsLock(op, val, CONDITION_AND);
	}

	public void setConditionIsLock(String op, java.lang.Boolean val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectIsLock(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionProjectAdvance(String op, java.math.BigDecimal val) {
		setConditionProjectAdvance(op, val, CONDITION_AND);
	}

	public void setConditionProjectAdvance(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectProjectAdvance(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionBonusPayment(String op, java.math.BigDecimal val) {
		setConditionBonusPayment(op, val, CONDITION_AND);
	}

	public void setConditionBonusPayment(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectBonusPayment(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionIntegralReturn(String op, java.math.BigDecimal val) {
		setConditionIntegralReturn(op, val, CONDITION_AND);
	}

	public void setConditionIntegralReturn(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectIntegralReturn(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionViolationCharges(String op, java.math.BigDecimal val) {
		setConditionViolationCharges(op, val, CONDITION_AND);
	}

	public void setConditionViolationCharges(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectViolationCharges(boolean val) {
		__select_flags[17] = val;
	}


}

