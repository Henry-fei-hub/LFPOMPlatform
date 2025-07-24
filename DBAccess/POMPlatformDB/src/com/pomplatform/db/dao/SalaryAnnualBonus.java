package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryAnnualBonus;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryAnnualBonus extends AbstractTable<BaseSalaryAnnualBonus>
{

	public SalaryAnnualBonus() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 40;

		initTables();

		__tableName            = "salary_annual_bonus";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryAnnualBonus.CS_SALARY_ANNUAL_BONUS_ID;
		__column_names[1] = BaseSalaryAnnualBonus.CS_BANK_ACCOUNT;
		__column_names[2] = BaseSalaryAnnualBonus.CS_EMPLOYEE_NO;
		__column_names[3] = BaseSalaryAnnualBonus.CS_EMPLOYEE_ID;
		__column_names[4] = BaseSalaryAnnualBonus.CS_EMPLOYEE_NAME;
		__column_names[5] = BaseSalaryAnnualBonus.CS_YEAR;
		__column_names[6] = BaseSalaryAnnualBonus.CS_COMPANY_ID;
		__column_names[7] = BaseSalaryAnnualBonus.CS_PLATE_ID;
		__column_names[8] = BaseSalaryAnnualBonus.CS_DEPARTMENT_ID;
		__column_names[9] = BaseSalaryAnnualBonus.CS_TOTAL_PAY;
		__column_names[10] = BaseSalaryAnnualBonus.CS_YEAR_SHOULD_WORK_DAY;
		__column_names[11] = BaseSalaryAnnualBonus.CS_YEAR_FACT_WORK_DAY;
		__column_names[12] = BaseSalaryAnnualBonus.CS_YEAR_SERVICE_NUM;
		__column_names[13] = BaseSalaryAnnualBonus.CS_YEAR_TEST_LEVEL;
		__column_names[14] = BaseSalaryAnnualBonus.CS_TEST_NUM;
		__column_names[15] = BaseSalaryAnnualBonus.CS_THIRTEEN_BONUS;
		__column_names[16] = BaseSalaryAnnualBonus.CS_YEAR_PERFORMANCE_BONUS;
		__column_names[17] = BaseSalaryAnnualBonus.CS_PROGRAM_BONUS;
		__column_names[18] = BaseSalaryAnnualBonus.CS_TRANSFER_ACCOUNT_MONEY;
		__column_names[19] = BaseSalaryAnnualBonus.CS_SHOULD_TOTAL;
		__column_names[20] = BaseSalaryAnnualBonus.CS_SHOULD_TAX;
		__column_names[21] = BaseSalaryAnnualBonus.CS_FACT_BONUS;
		__column_names[22] = BaseSalaryAnnualBonus.CS_IS_SENDED;
		__column_names[23] = BaseSalaryAnnualBonus.CS_OPERATE_EMPLOYEE_ID;
		__column_names[24] = BaseSalaryAnnualBonus.CS_OPERATE_TIME;
		__column_names[25] = BaseSalaryAnnualBonus.CS_REMARK;
		__column_names[26] = BaseSalaryAnnualBonus.CS_DEPOSIT_DEDUCT;
		__column_names[27] = BaseSalaryAnnualBonus.CS_PERSONNEL_BUSINESS_ID;
		__column_names[28] = BaseSalaryAnnualBonus.CS_FLOW_STATUS;
		__column_names[29] = BaseSalaryAnnualBonus.CS_SALARY_DIFF_DEDUCT;
		__column_names[30] = BaseSalaryAnnualBonus.CS_REIMBURSEMENT_DEDUCT;
		__column_names[31] = BaseSalaryAnnualBonus.CS_OTHER_DEDUCT;
		__column_names[32] = BaseSalaryAnnualBonus.CS_ALREADY_BONUS;
		__column_names[33] = BaseSalaryAnnualBonus.CS_SHOULD_TAX_ACHIEVE;
		__column_names[34] = BaseSalaryAnnualBonus.CS_SEND_TIME;
		__column_names[35] = BaseSalaryAnnualBonus.CS_FINISH_TIME;
		__column_names[36] = BaseSalaryAnnualBonus.CS_ONE_TO_THREE_REST;
		__column_names[37] = BaseSalaryAnnualBonus.CS_HOUSING_SUBSIDY;
		__column_names[38] = BaseSalaryAnnualBonus.CS_DEDUCT_PERFORMANCE_BONUS;
		__column_names[39] = BaseSalaryAnnualBonus.CS_INSTEAD_DEDUCT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryAnnualBonus b) {
		clear();
		setSalaryAnnualBonusIdClear(b.getSalaryAnnualBonusId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryAnnualBonusId() == null;
	}

	@Override
	public BaseSalaryAnnualBonus generateBase(){
		BaseSalaryAnnualBonus b = new BaseSalaryAnnualBonus();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryAnnualBonus b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryAnnualBonusId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYearShouldWorkDay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setYearFactWorkDay(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setYearServiceNum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setYearTestLevel(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTestNum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setThirteenBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYearPerformanceBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProgramBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTransferAccountMoney(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldTotal(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFactBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsSended(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepositDeduct(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFlowStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSalaryDiffDeduct(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReimbursementDeduct(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherDeduct(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlreadyBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldTaxAchieve(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSendTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFinishTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOneToThreeRest(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setHousingSubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeductPerformanceBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInsteadDeduct(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryAnnualBonus b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryAnnualBonusId();
		buff[count++] = b.getBankAccount();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getYear();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getTotalPay();
		buff[count++] = b.getYearShouldWorkDay();
		buff[count++] = b.getYearFactWorkDay();
		buff[count++] = b.getYearServiceNum();
		buff[count++] = b.getYearTestLevel();
		buff[count++] = b.getTestNum();
		buff[count++] = b.getThirteenBonus();
		buff[count++] = b.getYearPerformanceBonus();
		buff[count++] = b.getProgramBonus();
		buff[count++] = b.getTransferAccountMoney();
		buff[count++] = b.getShouldTotal();
		buff[count++] = b.getShouldTax();
		buff[count++] = b.getFactBonus();
		buff[count++] = b.getIsSended();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getDepositDeduct();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getFlowStatus();
		buff[count++] = b.getSalaryDiffDeduct();
		buff[count++] = b.getReimbursementDeduct();
		buff[count++] = b.getOtherDeduct();
		buff[count++] = b.getAlreadyBonus();
		buff[count++] = b.getShouldTaxAchieve();
		buff[count++] = generateTimestampFromDate(b.getSendTime());
		buff[count++] = generateTimestampFromDate(b.getFinishTime());
		buff[count++] = b.getOneToThreeRest();
		buff[count++] = b.getHousingSubsidy();
		buff[count++] = b.getDeductPerformanceBonus();
		buff[count++] = b.getInsteadDeduct();
	}

	@Override
	public void setDataFromBase(BaseSalaryAnnualBonus b){
		if(b.getSalaryAnnualBonusId() != null) setSalaryAnnualBonusIdClear(b.getSalaryAnnualBonusId());
		if(b.getBankAccount() != null) setBankAccount(b.getBankAccount());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getTotalPay() != null) setTotalPay(b.getTotalPay());
		if(b.getYearShouldWorkDay() != null) setYearShouldWorkDay(b.getYearShouldWorkDay());
		if(b.getYearFactWorkDay() != null) setYearFactWorkDay(b.getYearFactWorkDay());
		if(b.getYearServiceNum() != null) setYearServiceNum(b.getYearServiceNum());
		if(b.getYearTestLevel() != null) setYearTestLevel(b.getYearTestLevel());
		if(b.getTestNum() != null) setTestNum(b.getTestNum());
		if(b.getThirteenBonus() != null) setThirteenBonus(b.getThirteenBonus());
		if(b.getYearPerformanceBonus() != null) setYearPerformanceBonus(b.getYearPerformanceBonus());
		if(b.getProgramBonus() != null) setProgramBonus(b.getProgramBonus());
		if(b.getTransferAccountMoney() != null) setTransferAccountMoney(b.getTransferAccountMoney());
		if(b.getShouldTotal() != null) setShouldTotal(b.getShouldTotal());
		if(b.getShouldTax() != null) setShouldTax(b.getShouldTax());
		if(b.getFactBonus() != null) setFactBonus(b.getFactBonus());
		if(b.getIsSended() != null) setIsSended(b.getIsSended());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getDepositDeduct() != null) setDepositDeduct(b.getDepositDeduct());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getFlowStatus() != null) setFlowStatus(b.getFlowStatus());
		if(b.getSalaryDiffDeduct() != null) setSalaryDiffDeduct(b.getSalaryDiffDeduct());
		if(b.getReimbursementDeduct() != null) setReimbursementDeduct(b.getReimbursementDeduct());
		if(b.getOtherDeduct() != null) setOtherDeduct(b.getOtherDeduct());
		if(b.getAlreadyBonus() != null) setAlreadyBonus(b.getAlreadyBonus());
		if(b.getShouldTaxAchieve() != null) setShouldTaxAchieve(b.getShouldTaxAchieve());
		if(b.getSendTime() != null) setSendTime(b.getSendTime());
		if(b.getFinishTime() != null) setFinishTime(b.getFinishTime());
		if(b.getOneToThreeRest() != null) setOneToThreeRest(b.getOneToThreeRest());
		if(b.getHousingSubsidy() != null) setHousingSubsidy(b.getHousingSubsidy());
		if(b.getDeductPerformanceBonus() != null) setDeductPerformanceBonus(b.getDeductPerformanceBonus());
		if(b.getInsteadDeduct() != null) setInsteadDeduct(b.getInsteadDeduct());
	}

	@Override
	public BaseSalaryAnnualBonus generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryAnnualBonus b = new BaseSalaryAnnualBonus();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryAnnualBonus __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryAnnualBonusId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYearShouldWorkDay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYearFactWorkDay(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYearServiceNum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYearTestLevel(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTestNum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThirteenBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYearPerformanceBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProgramBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTransferAccountMoney(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTotal(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFactBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSended(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepositDeduct(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlowStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryDiffDeduct(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReimbursementDeduct(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherDeduct(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlreadyBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTaxAchieve(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOneToThreeRest(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHousingSubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeductPerformanceBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInsteadDeduct(GenericBase.__getString(val));
	}

	public void setSalaryAnnualBonusId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryAnnualBonusId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryAnnualBonusIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBankAccount(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getBankAccount() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setTotalPay(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getTotalPay() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setYearShouldWorkDay(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getYearShouldWorkDay() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setYearFactWorkDay(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getYearFactWorkDay() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setYearServiceNum(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getYearServiceNum() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setYearTestLevel(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getYearTestLevel() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setTestNum(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getTestNum() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setThirteenBonus(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getThirteenBonus() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setYearPerformanceBonus(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getYearPerformanceBonus() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setProgramBonus(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getProgramBonus() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setTransferAccountMoney(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getTransferAccountMoney() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setShouldTotal(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getShouldTotal() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setShouldTax(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getShouldTax() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setFactBonus(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getFactBonus() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setIsSended(java.lang.Boolean val) {
		setCurrentData(22, val);
	}

	public java.lang.Boolean getIsSended() {
		return GenericBase.__getBoolean(__current_data[22]);
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

	public void setDepositDeduct(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getDepositDeduct() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setFlowStatus(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getFlowStatus() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setSalaryDiffDeduct(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getSalaryDiffDeduct() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setReimbursementDeduct(java.lang.String val) {
		setCurrentData(30, val);
	}

	public java.lang.String getReimbursementDeduct() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setOtherDeduct(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getOtherDeduct() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setAlreadyBonus(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getAlreadyBonus() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setShouldTaxAchieve(java.lang.String val) {
		setCurrentData(33, val);
	}

	public java.lang.String getShouldTaxAchieve() {
		return GenericBase.__getString(__current_data[33]);
	}

	public void setSendTime(java.util.Date val) {
		setCurrentData(34, generateTimestampFromDate(val));
	}

	public java.util.Date getSendTime() {
		return GenericBase.__getDateFromSQL(__current_data[34]);
	}

	public void setFinishTime(java.util.Date val) {
		setCurrentData(35, generateTimestampFromDate(val));
	}

	public java.util.Date getFinishTime() {
		return GenericBase.__getDateFromSQL(__current_data[35]);
	}

	public void setOneToThreeRest(java.lang.String val) {
		setCurrentData(36, val);
	}

	public java.lang.String getOneToThreeRest() {
		return GenericBase.__getString(__current_data[36]);
	}

	public void setHousingSubsidy(java.lang.String val) {
		setCurrentData(37, val);
	}

	public java.lang.String getHousingSubsidy() {
		return GenericBase.__getString(__current_data[37]);
	}

	public void setDeductPerformanceBonus(java.lang.String val) {
		setCurrentData(38, val);
	}

	public java.lang.String getDeductPerformanceBonus() {
		return GenericBase.__getString(__current_data[38]);
	}

	public void setInsteadDeduct(java.lang.String val) {
		setCurrentData(39, val);
	}

	public java.lang.String getInsteadDeduct() {
		return GenericBase.__getString(__current_data[39]);
	}

	public void setConditionSalaryAnnualBonusId(String op, java.lang.Integer val) {
		setConditionSalaryAnnualBonusId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryAnnualBonusId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryAnnualBonusId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBankAccount(String op, java.lang.String val) {
		setConditionBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionBankAccount(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBankAccount(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
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

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionTotalPay(String op, java.lang.String val) {
		setConditionTotalPay(op, val, CONDITION_AND);
	}

	public void setConditionTotalPay(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectTotalPay(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionYearShouldWorkDay(String op, java.math.BigDecimal val) {
		setConditionYearShouldWorkDay(op, val, CONDITION_AND);
	}

	public void setConditionYearShouldWorkDay(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectYearShouldWorkDay(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionYearFactWorkDay(String op, java.math.BigDecimal val) {
		setConditionYearFactWorkDay(op, val, CONDITION_AND);
	}

	public void setConditionYearFactWorkDay(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectYearFactWorkDay(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionYearServiceNum(String op, java.math.BigDecimal val) {
		setConditionYearServiceNum(op, val, CONDITION_AND);
	}

	public void setConditionYearServiceNum(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectYearServiceNum(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionYearTestLevel(String op, java.lang.String val) {
		setConditionYearTestLevel(op, val, CONDITION_AND);
	}

	public void setConditionYearTestLevel(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectYearTestLevel(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionTestNum(String op, java.math.BigDecimal val) {
		setConditionTestNum(op, val, CONDITION_AND);
	}

	public void setConditionTestNum(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectTestNum(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionThirteenBonus(String op, java.lang.String val) {
		setConditionThirteenBonus(op, val, CONDITION_AND);
	}

	public void setConditionThirteenBonus(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectThirteenBonus(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionYearPerformanceBonus(String op, java.lang.String val) {
		setConditionYearPerformanceBonus(op, val, CONDITION_AND);
	}

	public void setConditionYearPerformanceBonus(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectYearPerformanceBonus(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionProgramBonus(String op, java.lang.String val) {
		setConditionProgramBonus(op, val, CONDITION_AND);
	}

	public void setConditionProgramBonus(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectProgramBonus(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionTransferAccountMoney(String op, java.lang.String val) {
		setConditionTransferAccountMoney(op, val, CONDITION_AND);
	}

	public void setConditionTransferAccountMoney(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectTransferAccountMoney(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionShouldTotal(String op, java.lang.String val) {
		setConditionShouldTotal(op, val, CONDITION_AND);
	}

	public void setConditionShouldTotal(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectShouldTotal(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionShouldTax(String op, java.lang.String val) {
		setConditionShouldTax(op, val, CONDITION_AND);
	}

	public void setConditionShouldTax(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectShouldTax(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionFactBonus(String op, java.lang.String val) {
		setConditionFactBonus(op, val, CONDITION_AND);
	}

	public void setConditionFactBonus(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectFactBonus(boolean val) {
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

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[23] = val;
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

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionDepositDeduct(String op, java.lang.String val) {
		setConditionDepositDeduct(op, val, CONDITION_AND);
	}

	public void setConditionDepositDeduct(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectDepositDeduct(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionFlowStatus(String op, java.lang.Integer val) {
		setConditionFlowStatus(op, val, CONDITION_AND);
	}

	public void setConditionFlowStatus(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectFlowStatus(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionSalaryDiffDeduct(String op, java.lang.String val) {
		setConditionSalaryDiffDeduct(op, val, CONDITION_AND);
	}

	public void setConditionSalaryDiffDeduct(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectSalaryDiffDeduct(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionReimbursementDeduct(String op, java.lang.String val) {
		setConditionReimbursementDeduct(op, val, CONDITION_AND);
	}

	public void setConditionReimbursementDeduct(String op, java.lang.String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectReimbursementDeduct(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionOtherDeduct(String op, java.lang.String val) {
		setConditionOtherDeduct(op, val, CONDITION_AND);
	}

	public void setConditionOtherDeduct(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectOtherDeduct(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionAlreadyBonus(String op, java.lang.String val) {
		setConditionAlreadyBonus(op, val, CONDITION_AND);
	}

	public void setConditionAlreadyBonus(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectAlreadyBonus(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionShouldTaxAchieve(String op, java.lang.String val) {
		setConditionShouldTaxAchieve(op, val, CONDITION_AND);
	}

	public void setConditionShouldTaxAchieve(String op, java.lang.String val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectShouldTaxAchieve(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionSendTime(String op, java.util.Date val) {
		setConditionSendTime(op, val, CONDITION_AND);
	}

	public void setConditionSendTime(String op, java.util.Date val, String relation) {
		addCondition(34, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSendTime(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionFinishTime(String op, java.util.Date val) {
		setConditionFinishTime(op, val, CONDITION_AND);
	}

	public void setConditionFinishTime(String op, java.util.Date val, String relation) {
		addCondition(35, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectFinishTime(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionOneToThreeRest(String op, java.lang.String val) {
		setConditionOneToThreeRest(op, val, CONDITION_AND);
	}

	public void setConditionOneToThreeRest(String op, java.lang.String val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectOneToThreeRest(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionHousingSubsidy(String op, java.lang.String val) {
		setConditionHousingSubsidy(op, val, CONDITION_AND);
	}

	public void setConditionHousingSubsidy(String op, java.lang.String val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectHousingSubsidy(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionDeductPerformanceBonus(String op, java.lang.String val) {
		setConditionDeductPerformanceBonus(op, val, CONDITION_AND);
	}

	public void setConditionDeductPerformanceBonus(String op, java.lang.String val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectDeductPerformanceBonus(boolean val) {
		__select_flags[38] = val;
	}

	public void setConditionInsteadDeduct(String op, java.lang.String val) {
		setConditionInsteadDeduct(op, val, CONDITION_AND);
	}

	public void setConditionInsteadDeduct(String op, java.lang.String val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectInsteadDeduct(boolean val) {
		__select_flags[39] = val;
	}


}

