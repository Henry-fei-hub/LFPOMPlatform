package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class EmployeeSalaryDetail extends AbstractTable<BaseEmployeeSalaryDetail>
{

	public EmployeeSalaryDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 31;

		initTables();

		__tableName            = "employee_salary_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseEmployeeSalaryDetail.CS_EMPLOYEE_SALARY_DETAIL_ID;
		__column_names[1] = BaseEmployeeSalaryDetail.CS_EMPLOYEE_ID;
		__column_names[2] = BaseEmployeeSalaryDetail.CS_ENTRY_DATE;
		__column_names[3] = BaseEmployeeSalaryDetail.CS_POSITIVE_DATE;
		__column_names[4] = BaseEmployeeSalaryDetail.CS_ALL_SALARY;
		__column_names[5] = BaseEmployeeSalaryDetail.CS_BASIC_PROPORTION;
		__column_names[6] = BaseEmployeeSalaryDetail.CS_PERFORMANCE_BONUS;
		__column_names[7] = BaseEmployeeSalaryDetail.CS_BASIC_SALARY;
		__column_names[8] = BaseEmployeeSalaryDetail.CS_WORK_SUBSIDIES;
		__column_names[9] = BaseEmployeeSalaryDetail.CS_WORK_YEAR_SALARY;
		__column_names[10] = BaseEmployeeSalaryDetail.CS_ANOTHER_PLACE_SUBSIDIES;
		__column_names[11] = BaseEmployeeSalaryDetail.CS_DEDUCT_SALARY;
		__column_names[12] = BaseEmployeeSalaryDetail.CS_POSITIVE_ACCOUNT;
		__column_names[13] = BaseEmployeeSalaryDetail.CS_SHOULD_PAY_SALARY;
		__column_names[14] = BaseEmployeeSalaryDetail.CS_LAST_MONTH_ACHIEVEMENT_EFFECT;
		__column_names[15] = BaseEmployeeSalaryDetail.CS_PROJECT_BONUS;
		__column_names[16] = BaseEmployeeSalaryDetail.CS_TAXABLE_INCOME;
		__column_names[17] = BaseEmployeeSalaryDetail.CS_INCOME_TOTAL;
		__column_names[18] = BaseEmployeeSalaryDetail.CS_DEDUCT_INCOME;
		__column_names[19] = BaseEmployeeSalaryDetail.CS_SHOULD_PAY_INCOME;
		__column_names[20] = BaseEmployeeSalaryDetail.CS_SOCIAL_SECURITY;
		__column_names[21] = BaseEmployeeSalaryDetail.CS_RESERVED_FUNDS;
		__column_names[22] = BaseEmployeeSalaryDetail.CS_WITHHOLD_BORROW;
		__column_names[23] = BaseEmployeeSalaryDetail.CS_LEAVE_SUBSIDIES;
		__column_names[24] = BaseEmployeeSalaryDetail.CS_FACT_PAY_SALARY;
		__column_names[25] = BaseEmployeeSalaryDetail.CS_UNIT_SOCIAL_SECURITY;
		__column_names[26] = BaseEmployeeSalaryDetail.CS_SECRET_KEY;
		__column_names[27] = BaseEmployeeSalaryDetail.CS_BANK_ACCOUNT;
		__column_names[28] = BaseEmployeeSalaryDetail.CS_SALARY_YEAR;
		__column_names[29] = BaseEmployeeSalaryDetail.CS_SALARY_MONTH;
		__column_names[30] = BaseEmployeeSalaryDetail.CS_IS_RETURN;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseEmployeeSalaryDetail b) {
		clear();
		setEmployeeSalaryDetailIdClear(b.getEmployeeSalaryDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getEmployeeSalaryDetailId() == null;
	}

	@Override
	public BaseEmployeeSalaryDetail generateBase(){
		BaseEmployeeSalaryDetail b = new BaseEmployeeSalaryDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseEmployeeSalaryDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setEmployeeSalaryDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEntryDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setPositiveDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAllSalary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBasicProportion(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPerformanceBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBasicSalary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWorkSubsidies(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWorkYearSalary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAnotherPlaceSubsidies(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeductSalary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPositiveAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldPaySalary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLastMonthAchievementEffect(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaxableIncome(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIncomeTotal(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeductIncome(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldPayIncome(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSocialSecurity(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReservedFunds(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWithholdBorrow(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLeaveSubsidies(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFactPaySalary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUnitSocialSecurity(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSecretKey(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSalaryYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSalaryMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsReturn(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseEmployeeSalaryDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getEmployeeSalaryDetailId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getEntryDate());
		buff[count++] = generateTimestampFromDate(b.getPositiveDate());
		buff[count++] = b.getAllSalary();
		buff[count++] = b.getBasicProportion();
		buff[count++] = b.getPerformanceBonus();
		buff[count++] = b.getBasicSalary();
		buff[count++] = b.getWorkSubsidies();
		buff[count++] = b.getWorkYearSalary();
		buff[count++] = b.getAnotherPlaceSubsidies();
		buff[count++] = b.getDeductSalary();
		buff[count++] = b.getPositiveAccount();
		buff[count++] = b.getShouldPaySalary();
		buff[count++] = b.getLastMonthAchievementEffect();
		buff[count++] = b.getProjectBonus();
		buff[count++] = b.getTaxableIncome();
		buff[count++] = b.getIncomeTotal();
		buff[count++] = b.getDeductIncome();
		buff[count++] = b.getShouldPayIncome();
		buff[count++] = b.getSocialSecurity();
		buff[count++] = b.getReservedFunds();
		buff[count++] = b.getWithholdBorrow();
		buff[count++] = b.getLeaveSubsidies();
		buff[count++] = b.getFactPaySalary();
		buff[count++] = b.getUnitSocialSecurity();
		buff[count++] = b.getSecretKey();
		buff[count++] = b.getBankAccount();
		buff[count++] = b.getSalaryYear();
		buff[count++] = b.getSalaryMonth();
		buff[count++] = b.getIsReturn();
	}

	@Override
	public void setDataFromBase(BaseEmployeeSalaryDetail b){
		if(b.getEmployeeSalaryDetailId() != null) setEmployeeSalaryDetailIdClear(b.getEmployeeSalaryDetailId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEntryDate() != null) setEntryDate(b.getEntryDate());
		if(b.getPositiveDate() != null) setPositiveDate(b.getPositiveDate());
		if(b.getAllSalary() != null) setAllSalary(b.getAllSalary());
		if(b.getBasicProportion() != null) setBasicProportion(b.getBasicProportion());
		if(b.getPerformanceBonus() != null) setPerformanceBonus(b.getPerformanceBonus());
		if(b.getBasicSalary() != null) setBasicSalary(b.getBasicSalary());
		if(b.getWorkSubsidies() != null) setWorkSubsidies(b.getWorkSubsidies());
		if(b.getWorkYearSalary() != null) setWorkYearSalary(b.getWorkYearSalary());
		if(b.getAnotherPlaceSubsidies() != null) setAnotherPlaceSubsidies(b.getAnotherPlaceSubsidies());
		if(b.getDeductSalary() != null) setDeductSalary(b.getDeductSalary());
		if(b.getPositiveAccount() != null) setPositiveAccount(b.getPositiveAccount());
		if(b.getShouldPaySalary() != null) setShouldPaySalary(b.getShouldPaySalary());
		if(b.getLastMonthAchievementEffect() != null) setLastMonthAchievementEffect(b.getLastMonthAchievementEffect());
		if(b.getProjectBonus() != null) setProjectBonus(b.getProjectBonus());
		if(b.getTaxableIncome() != null) setTaxableIncome(b.getTaxableIncome());
		if(b.getIncomeTotal() != null) setIncomeTotal(b.getIncomeTotal());
		if(b.getDeductIncome() != null) setDeductIncome(b.getDeductIncome());
		if(b.getShouldPayIncome() != null) setShouldPayIncome(b.getShouldPayIncome());
		if(b.getSocialSecurity() != null) setSocialSecurity(b.getSocialSecurity());
		if(b.getReservedFunds() != null) setReservedFunds(b.getReservedFunds());
		if(b.getWithholdBorrow() != null) setWithholdBorrow(b.getWithholdBorrow());
		if(b.getLeaveSubsidies() != null) setLeaveSubsidies(b.getLeaveSubsidies());
		if(b.getFactPaySalary() != null) setFactPaySalary(b.getFactPaySalary());
		if(b.getUnitSocialSecurity() != null) setUnitSocialSecurity(b.getUnitSocialSecurity());
		if(b.getSecretKey() != null) setSecretKey(b.getSecretKey());
		if(b.getBankAccount() != null) setBankAccount(b.getBankAccount());
		if(b.getSalaryYear() != null) setSalaryYear(b.getSalaryYear());
		if(b.getSalaryMonth() != null) setSalaryMonth(b.getSalaryMonth());
		if(b.getIsReturn() != null) setIsReturn(b.getIsReturn());
	}

	@Override
	public BaseEmployeeSalaryDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseEmployeeSalaryDetail b = new BaseEmployeeSalaryDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseEmployeeSalaryDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeSalaryDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEntryDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPositiveDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAllSalary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicProportion(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerformanceBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBasicSalary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkSubsidies(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkYearSalary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAnotherPlaceSubsidies(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeductSalary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPositiveAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldPaySalary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLastMonthAchievementEffect(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxableIncome(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIncomeTotal(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeductIncome(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldPayIncome(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSocialSecurity(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReservedFunds(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWithholdBorrow(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveSubsidies(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFactPaySalary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitSocialSecurity(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSecretKey(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsReturn(GenericBase.__getBoolean(val));
	}

	public void setEmployeeSalaryDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getEmployeeSalaryDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setEmployeeSalaryDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEntryDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getEntryDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setPositiveDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getPositiveDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setAllSalary(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getAllSalary() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setBasicProportion(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getBasicProportion() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setPerformanceBonus(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getPerformanceBonus() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setBasicSalary(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getBasicSalary() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setWorkSubsidies(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getWorkSubsidies() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setWorkYearSalary(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getWorkYearSalary() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setAnotherPlaceSubsidies(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getAnotherPlaceSubsidies() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setDeductSalary(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getDeductSalary() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setPositiveAccount(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getPositiveAccount() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setShouldPaySalary(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getShouldPaySalary() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setLastMonthAchievementEffect(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getLastMonthAchievementEffect() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setProjectBonus(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getProjectBonus() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setTaxableIncome(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getTaxableIncome() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setIncomeTotal(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getIncomeTotal() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setDeductIncome(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getDeductIncome() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setShouldPayIncome(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getShouldPayIncome() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setSocialSecurity(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getSocialSecurity() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setReservedFunds(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getReservedFunds() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setWithholdBorrow(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getWithholdBorrow() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setLeaveSubsidies(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getLeaveSubsidies() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setFactPaySalary(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getFactPaySalary() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setUnitSocialSecurity(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getUnitSocialSecurity() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setSecretKey(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getSecretKey() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setBankAccount(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getBankAccount() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setSalaryYear(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getSalaryYear() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setSalaryMonth(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getSalaryMonth() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setIsReturn(java.lang.Boolean val) {
		setCurrentData(30, val);
	}

	public java.lang.Boolean getIsReturn() {
		return GenericBase.__getBoolean(__current_data[30]);
	}

	public void setConditionEmployeeSalaryDetailId(String op, java.lang.Integer val) {
		setConditionEmployeeSalaryDetailId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeSalaryDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectEmployeeSalaryDetailId(boolean val) {
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

	public void setConditionEntryDate(String op, java.util.Date val) {
		setConditionEntryDate(op, val, CONDITION_AND);
	}

	public void setConditionEntryDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEntryDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPositiveDate(String op, java.util.Date val) {
		setConditionPositiveDate(op, val, CONDITION_AND);
	}

	public void setConditionPositiveDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPositiveDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAllSalary(String op, java.lang.String val) {
		setConditionAllSalary(op, val, CONDITION_AND);
	}

	public void setConditionAllSalary(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAllSalary(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionBasicProportion(String op, java.lang.String val) {
		setConditionBasicProportion(op, val, CONDITION_AND);
	}

	public void setConditionBasicProportion(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectBasicProportion(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPerformanceBonus(String op, java.lang.String val) {
		setConditionPerformanceBonus(op, val, CONDITION_AND);
	}

	public void setConditionPerformanceBonus(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPerformanceBonus(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionBasicSalary(String op, java.lang.String val) {
		setConditionBasicSalary(op, val, CONDITION_AND);
	}

	public void setConditionBasicSalary(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectBasicSalary(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionWorkSubsidies(String op, java.lang.String val) {
		setConditionWorkSubsidies(op, val, CONDITION_AND);
	}

	public void setConditionWorkSubsidies(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectWorkSubsidies(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionWorkYearSalary(String op, java.lang.String val) {
		setConditionWorkYearSalary(op, val, CONDITION_AND);
	}

	public void setConditionWorkYearSalary(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectWorkYearSalary(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionAnotherPlaceSubsidies(String op, java.lang.String val) {
		setConditionAnotherPlaceSubsidies(op, val, CONDITION_AND);
	}

	public void setConditionAnotherPlaceSubsidies(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectAnotherPlaceSubsidies(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionDeductSalary(String op, java.lang.String val) {
		setConditionDeductSalary(op, val, CONDITION_AND);
	}

	public void setConditionDeductSalary(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDeductSalary(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionPositiveAccount(String op, java.lang.String val) {
		setConditionPositiveAccount(op, val, CONDITION_AND);
	}

	public void setConditionPositiveAccount(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectPositiveAccount(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionShouldPaySalary(String op, java.lang.String val) {
		setConditionShouldPaySalary(op, val, CONDITION_AND);
	}

	public void setConditionShouldPaySalary(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectShouldPaySalary(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionLastMonthAchievementEffect(String op, java.lang.String val) {
		setConditionLastMonthAchievementEffect(op, val, CONDITION_AND);
	}

	public void setConditionLastMonthAchievementEffect(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectLastMonthAchievementEffect(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionProjectBonus(String op, java.lang.String val) {
		setConditionProjectBonus(op, val, CONDITION_AND);
	}

	public void setConditionProjectBonus(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectProjectBonus(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionTaxableIncome(String op, java.lang.String val) {
		setConditionTaxableIncome(op, val, CONDITION_AND);
	}

	public void setConditionTaxableIncome(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectTaxableIncome(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionIncomeTotal(String op, java.lang.String val) {
		setConditionIncomeTotal(op, val, CONDITION_AND);
	}

	public void setConditionIncomeTotal(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectIncomeTotal(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionDeductIncome(String op, java.lang.String val) {
		setConditionDeductIncome(op, val, CONDITION_AND);
	}

	public void setConditionDeductIncome(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectDeductIncome(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionShouldPayIncome(String op, java.lang.String val) {
		setConditionShouldPayIncome(op, val, CONDITION_AND);
	}

	public void setConditionShouldPayIncome(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectShouldPayIncome(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionSocialSecurity(String op, java.lang.String val) {
		setConditionSocialSecurity(op, val, CONDITION_AND);
	}

	public void setConditionSocialSecurity(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectSocialSecurity(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionReservedFunds(String op, java.lang.String val) {
		setConditionReservedFunds(op, val, CONDITION_AND);
	}

	public void setConditionReservedFunds(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectReservedFunds(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionWithholdBorrow(String op, java.lang.String val) {
		setConditionWithholdBorrow(op, val, CONDITION_AND);
	}

	public void setConditionWithholdBorrow(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectWithholdBorrow(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionLeaveSubsidies(String op, java.lang.String val) {
		setConditionLeaveSubsidies(op, val, CONDITION_AND);
	}

	public void setConditionLeaveSubsidies(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectLeaveSubsidies(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionFactPaySalary(String op, java.lang.String val) {
		setConditionFactPaySalary(op, val, CONDITION_AND);
	}

	public void setConditionFactPaySalary(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectFactPaySalary(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionUnitSocialSecurity(String op, java.lang.String val) {
		setConditionUnitSocialSecurity(op, val, CONDITION_AND);
	}

	public void setConditionUnitSocialSecurity(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectUnitSocialSecurity(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionSecretKey(String op, java.lang.String val) {
		setConditionSecretKey(op, val, CONDITION_AND);
	}

	public void setConditionSecretKey(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectSecretKey(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionBankAccount(String op, java.lang.String val) {
		setConditionBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionBankAccount(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectBankAccount(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionSalaryYear(String op, java.lang.Integer val) {
		setConditionSalaryYear(op, val, CONDITION_AND);
	}

	public void setConditionSalaryYear(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectSalaryYear(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionSalaryMonth(String op, java.lang.Integer val) {
		setConditionSalaryMonth(op, val, CONDITION_AND);
	}

	public void setConditionSalaryMonth(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectSalaryMonth(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val) {
		setConditionIsReturn(op, val, CONDITION_AND);
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectIsReturn(boolean val) {
		__select_flags[30] = val;
	}


}

