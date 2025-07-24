package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryEmployeePerformance;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryEmployeePerformance extends AbstractTable<BaseSalaryEmployeePerformance>
{

	public SalaryEmployeePerformance() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 23;

		initTables();

		__tableName            = "salary_employee_performance";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryEmployeePerformance.CS_SALARY_EMPLOYEE_PERFORMANCE_ID;
		__column_names[1] = BaseSalaryEmployeePerformance.CS_EMPLOYEE_NO;
		__column_names[2] = BaseSalaryEmployeePerformance.CS_EMPLOYEE_ID;
		__column_names[3] = BaseSalaryEmployeePerformance.CS_PLATE_ID;
		__column_names[4] = BaseSalaryEmployeePerformance.CS_DEPARTMENT_ID;
		__column_names[5] = BaseSalaryEmployeePerformance.CS_COMPANY_ID;
		__column_names[6] = BaseSalaryEmployeePerformance.CS_STATUS;
		__column_names[7] = BaseSalaryEmployeePerformance.CS_MONTH_PAY;
		__column_names[8] = BaseSalaryEmployeePerformance.CS_BASIC_PROPORTION_STR;
		__column_names[9] = BaseSalaryEmployeePerformance.CS_BASIC_PROPORTION;
		__column_names[10] = BaseSalaryEmployeePerformance.CS_MONTH_BASIC_PAY;
		__column_names[11] = BaseSalaryEmployeePerformance.CS_MONTH_PERFORMANCE_PAY;
		__column_names[12] = BaseSalaryEmployeePerformance.CS_SHOULD_DAYS;
		__column_names[13] = BaseSalaryEmployeePerformance.CS_FACT_DAYS;
		__column_names[14] = BaseSalaryEmployeePerformance.CS_YEAR;
		__column_names[15] = BaseSalaryEmployeePerformance.CS_MONTH;
		__column_names[16] = BaseSalaryEmployeePerformance.CS_HAPPEN_DATE;
		__column_names[17] = BaseSalaryEmployeePerformance.CS_CREATE_TIME;
		__column_names[18] = BaseSalaryEmployeePerformance.CS_GRADE;
		__column_names[19] = BaseSalaryEmployeePerformance.CS_PROPORTION;
		__column_names[20] = BaseSalaryEmployeePerformance.CS_WORKING_COEFFICIENT;
		__column_names[21] = BaseSalaryEmployeePerformance.CS_ACTUAL_PERFORMANCE_PAY;
		__column_names[22] = BaseSalaryEmployeePerformance.CS_IS_SENDED;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryEmployeePerformance b) {
		clear();
		setSalaryEmployeePerformanceIdClear(b.getSalaryEmployeePerformanceId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryEmployeePerformanceId() == null;
	}

	@Override
	public BaseSalaryEmployeePerformance generateBase(){
		BaseSalaryEmployeePerformance b = new BaseSalaryEmployeePerformance();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryEmployeePerformance b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryEmployeePerformanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonthPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBasicProportionStr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMonthBasicPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMonthPerformancePay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFactDays(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setGrade(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProportion(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setWorkingCoefficient(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setActualPerformancePay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setIsSended(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryEmployeePerformance b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryEmployeePerformanceId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getStatus();
		buff[count++] = b.getMonthPay();
		buff[count++] = b.getBasicProportionStr();
		buff[count++] = b.getBasicProportion();
		buff[count++] = b.getMonthBasicPay();
		buff[count++] = b.getMonthPerformancePay();
		buff[count++] = b.getShouldDays();
		buff[count++] = b.getFactDays();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = generateTimestampFromDate(b.getHappenDate());
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getGrade();
		buff[count++] = b.getProportion();
		buff[count++] = b.getWorkingCoefficient();
		buff[count++] = b.getActualPerformancePay();
		buff[count++] = b.getIsSended();
	}

	@Override
	public void setDataFromBase(BaseSalaryEmployeePerformance b){
		if(b.getSalaryEmployeePerformanceId() != null) setSalaryEmployeePerformanceIdClear(b.getSalaryEmployeePerformanceId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getMonthPay() != null) setMonthPay(b.getMonthPay());
		if(b.getBasicProportionStr() != null) setBasicProportionStr(b.getBasicProportionStr());
		if(b.getBasicProportion() != null) setBasicProportion(b.getBasicProportion());
		if(b.getMonthBasicPay() != null) setMonthBasicPay(b.getMonthBasicPay());
		if(b.getMonthPerformancePay() != null) setMonthPerformancePay(b.getMonthPerformancePay());
		if(b.getShouldDays() != null) setShouldDays(b.getShouldDays());
		if(b.getFactDays() != null) setFactDays(b.getFactDays());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getHappenDate() != null) setHappenDate(b.getHappenDate());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getGrade() != null) setGrade(b.getGrade());
		if(b.getProportion() != null) setProportion(b.getProportion());
		if(b.getWorkingCoefficient() != null) setWorkingCoefficient(b.getWorkingCoefficient());
		if(b.getActualPerformancePay() != null) setActualPerformancePay(b.getActualPerformancePay());
		if(b.getIsSended() != null) setIsSended(b.getIsSended());
	}

	@Override
	public BaseSalaryEmployeePerformance generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryEmployeePerformance b = new BaseSalaryEmployeePerformance();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryEmployeePerformance __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryEmployeePerformanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicProportionStr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthBasicPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthPerformancePay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFactDays(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGrade(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProportion(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkingCoefficient(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActualPerformancePay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSended(GenericBase.__getBoolean(val));
	}

	public void setSalaryEmployeePerformanceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryEmployeePerformanceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryEmployeePerformanceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setMonthPay(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getMonthPay() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setBasicProportionStr(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getBasicProportionStr() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setBasicProportion(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getBasicProportion() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setMonthBasicPay(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getMonthBasicPay() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setMonthPerformancePay(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getMonthPerformancePay() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setShouldDays(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getShouldDays() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setFactDays(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getFactDays() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setHappenDate(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getHappenDate() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setGrade(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getGrade() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setProportion(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getProportion() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setWorkingCoefficient(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getWorkingCoefficient() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setActualPerformancePay(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getActualPerformancePay() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setIsSended(java.lang.Boolean val) {
		setCurrentData(22, val);
	}

	public java.lang.Boolean getIsSended() {
		return GenericBase.__getBoolean(__current_data[22]);
	}

	public void setConditionSalaryEmployeePerformanceId(String op, java.lang.Integer val) {
		setConditionSalaryEmployeePerformanceId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryEmployeePerformanceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryEmployeePerformanceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
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

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMonthPay(String op, java.lang.String val) {
		setConditionMonthPay(op, val, CONDITION_AND);
	}

	public void setConditionMonthPay(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMonthPay(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionBasicProportionStr(String op, java.lang.String val) {
		setConditionBasicProportionStr(op, val, CONDITION_AND);
	}

	public void setConditionBasicProportionStr(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectBasicProportionStr(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionBasicProportion(String op, java.math.BigDecimal val) {
		setConditionBasicProportion(op, val, CONDITION_AND);
	}

	public void setConditionBasicProportion(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectBasicProportion(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionMonthBasicPay(String op, java.lang.String val) {
		setConditionMonthBasicPay(op, val, CONDITION_AND);
	}

	public void setConditionMonthBasicPay(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectMonthBasicPay(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionMonthPerformancePay(String op, java.lang.String val) {
		setConditionMonthPerformancePay(op, val, CONDITION_AND);
	}

	public void setConditionMonthPerformancePay(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectMonthPerformancePay(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionShouldDays(String op, java.math.BigDecimal val) {
		setConditionShouldDays(op, val, CONDITION_AND);
	}

	public void setConditionShouldDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectShouldDays(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionFactDays(String op, java.math.BigDecimal val) {
		setConditionFactDays(op, val, CONDITION_AND);
	}

	public void setConditionFactDays(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectFactDays(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionHappenDate(String op, java.util.Date val) {
		setConditionHappenDate(op, val, CONDITION_AND);
	}

	public void setConditionHappenDate(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHappenDate(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionGrade(String op, java.lang.String val) {
		setConditionGrade(op, val, CONDITION_AND);
	}

	public void setConditionGrade(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectGrade(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionProportion(String op, java.math.BigDecimal val) {
		setConditionProportion(op, val, CONDITION_AND);
	}

	public void setConditionProportion(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectProportion(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionWorkingCoefficient(String op, java.math.BigDecimal val) {
		setConditionWorkingCoefficient(op, val, CONDITION_AND);
	}

	public void setConditionWorkingCoefficient(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectWorkingCoefficient(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionActualPerformancePay(String op, java.math.BigDecimal val) {
		setConditionActualPerformancePay(op, val, CONDITION_AND);
	}

	public void setConditionActualPerformancePay(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectActualPerformancePay(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionIsSended(String op, java.lang.Boolean val) {
		setConditionIsSended(op, val, CONDITION_AND);
	}

	public void setConditionIsSended(String op, java.lang.Boolean val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectIsSended(boolean val) {
		__select_flags[22] = val;
	}


}

