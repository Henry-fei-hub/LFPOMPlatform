package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSalaryTotal;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class SalaryTotal extends AbstractTable<BaseSalaryTotal>
{

	public SalaryTotal() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 66;

		initTables();

		__tableName            = "salary_totals";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSalaryTotal.CS_SALARY_TOTAL_ID;
		__column_names[1] = BaseSalaryTotal.CS_EMPLOYEE_ID;
		__column_names[2] = BaseSalaryTotal.CS_EMPLOYEE_NO;
		__column_names[3] = BaseSalaryTotal.CS_EMPLOYEE_NAME;
		__column_names[4] = BaseSalaryTotal.CS_COMPANY_ID;
		__column_names[5] = BaseSalaryTotal.CS_PLATE_ID;
		__column_names[6] = BaseSalaryTotal.CS_DEPARTMENT_ID;
		__column_names[7] = BaseSalaryTotal.CS_BANK_ACCOUNT;
		__column_names[8] = BaseSalaryTotal.CS_YEAR;
		__column_names[9] = BaseSalaryTotal.CS_MONTH;
		__column_names[10] = BaseSalaryTotal.CS_MONTH_BASIC_PAY;
		__column_names[11] = BaseSalaryTotal.CS_WORK_MONEY;
		__column_names[12] = BaseSalaryTotal.CS_FILL_SEND_DEDUCT;
		__column_names[13] = BaseSalaryTotal.CS_JOB_SUBSIDY;
		__column_names[14] = BaseSalaryTotal.CS_ATTENDANCE_DEDUCT;
		__column_names[15] = BaseSalaryTotal.CS_PERFORMANCE_PAY;
		__column_names[16] = BaseSalaryTotal.CS_SHOULD_SALARY;
		__column_names[17] = BaseSalaryTotal.CS_SHOULD_BONUS;
		__column_names[18] = BaseSalaryTotal.CS_SHOULD_TOTAL;
		__column_names[19] = BaseSalaryTotal.CS_ALREADY_BONUS;
		__column_names[20] = BaseSalaryTotal.CS_OTHER_BONUS;
		__column_names[21] = BaseSalaryTotal.CS_TAX_BEGIN;
		__column_names[22] = BaseSalaryTotal.CS_SHOULD_TAX_ACHIEVE;
		__column_names[23] = BaseSalaryTotal.CS_TAX_TOTAL;
		__column_names[24] = BaseSalaryTotal.CS_DEDUCT_TAX;
		__column_names[25] = BaseSalaryTotal.CS_SHOULD_TAX;
		__column_names[26] = BaseSalaryTotal.CS_TOTAL_INSURANCE;
		__column_names[27] = BaseSalaryTotal.CS_TOTAL_FUND;
		__column_names[28] = BaseSalaryTotal.CS_UNIT_TOTAL_INSURANCE;
		__column_names[29] = BaseSalaryTotal.CS_UNIT_TOTAL_FUND;
		__column_names[30] = BaseSalaryTotal.CS_LEAVE_NO_DEDUCT_TAX;
		__column_names[31] = BaseSalaryTotal.CS_LEAVE_DEDUCT_TAX;
		__column_names[32] = BaseSalaryTotal.CS_FACT_SALARY;
		__column_names[33] = BaseSalaryTotal.CS_AFFILIATED;
		__column_names[34] = BaseSalaryTotal.CS_VOTE_PROJECT;
		__column_names[35] = BaseSalaryTotal.CS_VOTE_PERCENT;
		__column_names[36] = BaseSalaryTotal.CS_INSTEAD_DEDUCT;
		__column_names[37] = BaseSalaryTotal.CS_INSTEAD_DEDUCT_ILL;
		__column_names[38] = BaseSalaryTotal.CS_IS_SENDED;
		__column_names[39] = BaseSalaryTotal.CS_OPERATE_EMPLOYEE_ID;
		__column_names[40] = BaseSalaryTotal.CS_OPERATE_TIME;
		__column_names[41] = BaseSalaryTotal.CS_REMARK;
		__column_names[42] = BaseSalaryTotal.CS_COST_ATTRIBUTION;
		__column_names[43] = BaseSalaryTotal.CS_DEVELOPMENT_PROJECT;
		__column_names[44] = BaseSalaryTotal.CS_PERSONAL_PENSION;
		__column_names[45] = BaseSalaryTotal.CS_PERSONAL_MEDICAL_INSURANCE;
		__column_names[46] = BaseSalaryTotal.CS_PERSONAL_LARGE_MEDICAL_INSURANCE;
		__column_names[47] = BaseSalaryTotal.CS_PERSONAL_UNEMPLOYMENT_INSURANCE;
		__column_names[48] = BaseSalaryTotal.CS_PERSONAL_HEATING;
		__column_names[49] = BaseSalaryTotal.CS_PERSONAL_SERIOUS_ILL_INSURANCE;
		__column_names[50] = BaseSalaryTotal.CS_SALARY_TYPE_NAME;
		__column_names[51] = BaseSalaryTotal.CS_SPECIAL_ADDITIONAL_DUDUCT;
		__column_names[52] = BaseSalaryTotal.CS_SPECIAL_DUDUCT_1;
		__column_names[53] = BaseSalaryTotal.CS_SPECIAL_DUDUCT_2;
		__column_names[54] = BaseSalaryTotal.CS_SPECIAL_DUDUCT_3;
		__column_names[55] = BaseSalaryTotal.CS_SPECIAL_DUDUCT_4;
		__column_names[56] = BaseSalaryTotal.CS_SPECIAL_DUDUCT_5;
		__column_names[57] = BaseSalaryTotal.CS_SPECIAL_DUDUCT_6;
		__column_names[58] = BaseSalaryTotal.CS_SPECIAL_DUDUCT_SUM;
		__column_names[59] = BaseSalaryTotal.CS_SHOULD_TAX_ACHIEVE_SUM;
		__column_names[60] = BaseSalaryTotal.CS_INDIVIDUAL_INCOME_TAX_SUM;
		__column_names[61] = BaseSalaryTotal.CS_INSURANCE_FUND_SUM;
		__column_names[62] = BaseSalaryTotal.CS_WITHHOLDING_TAX;
		__column_names[63] = BaseSalaryTotal.CS_REPLACEMENT_TAX;
		__column_names[64] = BaseSalaryTotal.CS_SUSPEND_BONUS;
		__column_names[65] = BaseSalaryTotal.CS_OTHER_DEDUCTION;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSalaryTotal b) {
		clear();
		setSalaryTotalIdClear(b.getSalaryTotalId());
	}

	public boolean isPrimaryKeyNull() {
		return getSalaryTotalId() == null;
	}

	@Override
	public BaseSalaryTotal generateBase(){
		BaseSalaryTotal b = new BaseSalaryTotal();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSalaryTotal b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSalaryTotalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBankAccount(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonthBasicPay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWorkMoney(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFillSendDeduct(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setJobSubsidy(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttendanceDeduct(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPerformancePay(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldSalary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldTotal(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAlreadyBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaxBegin(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setShouldTaxAchieve(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTaxTotal(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeductTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setShouldTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalInsurance(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalFund(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUnitTotalInsurance(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setUnitTotalFund(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLeaveNoDeductTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setLeaveDeductTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFactSalary(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAffiliated(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setVoteProject(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setVotePercent(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInsteadDeduct(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInsteadDeductIll(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsSended(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCostAttribution(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDevelopmentProject(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPersonalPension(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalHeating(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalSeriousIllInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSalaryTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSpecialAdditionalDuduct(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct1(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct2(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct3(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct4(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct5(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuduct6(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialDuductSum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setShouldTaxAchieveSum(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIndividualIncomeTaxSum(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInsuranceFundSum(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWithholdingTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReplacementTax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSuspendBonus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOtherDeduction(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSalaryTotal b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSalaryTotalId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getBankAccount();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getMonthBasicPay();
		buff[count++] = b.getWorkMoney();
		buff[count++] = b.getFillSendDeduct();
		buff[count++] = b.getJobSubsidy();
		buff[count++] = b.getAttendanceDeduct();
		buff[count++] = b.getPerformancePay();
		buff[count++] = b.getShouldSalary();
		buff[count++] = b.getShouldBonus();
		buff[count++] = b.getShouldTotal();
		buff[count++] = b.getAlreadyBonus();
		buff[count++] = b.getOtherBonus();
		buff[count++] = b.getTaxBegin();
		buff[count++] = b.getShouldTaxAchieve();
		buff[count++] = b.getTaxTotal();
		buff[count++] = b.getDeductTax();
		buff[count++] = b.getShouldTax();
		buff[count++] = b.getTotalInsurance();
		buff[count++] = b.getTotalFund();
		buff[count++] = b.getUnitTotalInsurance();
		buff[count++] = b.getUnitTotalFund();
		buff[count++] = b.getLeaveNoDeductTax();
		buff[count++] = b.getLeaveDeductTax();
		buff[count++] = b.getFactSalary();
		buff[count++] = b.getAffiliated();
		buff[count++] = b.getVoteProject();
		buff[count++] = b.getVotePercent();
		buff[count++] = b.getInsteadDeduct();
		buff[count++] = b.getInsteadDeductIll();
		buff[count++] = b.getIsSended();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getCostAttribution();
		buff[count++] = b.getDevelopmentProject();
		buff[count++] = b.getPersonalPension();
		buff[count++] = b.getPersonalMedicalInsurance();
		buff[count++] = b.getPersonalLargeMedicalInsurance();
		buff[count++] = b.getPersonalUnemploymentInsurance();
		buff[count++] = b.getPersonalHeating();
		buff[count++] = b.getPersonalSeriousIllInsurance();
		buff[count++] = b.getSalaryTypeName();
		buff[count++] = b.getSpecialAdditionalDuduct();
		buff[count++] = b.getSpecialDuduct1();
		buff[count++] = b.getSpecialDuduct2();
		buff[count++] = b.getSpecialDuduct3();
		buff[count++] = b.getSpecialDuduct4();
		buff[count++] = b.getSpecialDuduct5();
		buff[count++] = b.getSpecialDuduct6();
		buff[count++] = b.getSpecialDuductSum();
		buff[count++] = b.getShouldTaxAchieveSum();
		buff[count++] = b.getIndividualIncomeTaxSum();
		buff[count++] = b.getInsuranceFundSum();
		buff[count++] = b.getWithholdingTax();
		buff[count++] = b.getReplacementTax();
		buff[count++] = b.getSuspendBonus();
		buff[count++] = b.getOtherDeduction();
	}

	@Override
	public void setDataFromBase(BaseSalaryTotal b){
		if(b.getSalaryTotalId() != null) setSalaryTotalIdClear(b.getSalaryTotalId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getBankAccount() != null) setBankAccount(b.getBankAccount());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getMonthBasicPay() != null) setMonthBasicPay(b.getMonthBasicPay());
		if(b.getWorkMoney() != null) setWorkMoney(b.getWorkMoney());
		if(b.getFillSendDeduct() != null) setFillSendDeduct(b.getFillSendDeduct());
		if(b.getJobSubsidy() != null) setJobSubsidy(b.getJobSubsidy());
		if(b.getAttendanceDeduct() != null) setAttendanceDeduct(b.getAttendanceDeduct());
		if(b.getPerformancePay() != null) setPerformancePay(b.getPerformancePay());
		if(b.getShouldSalary() != null) setShouldSalary(b.getShouldSalary());
		if(b.getShouldBonus() != null) setShouldBonus(b.getShouldBonus());
		if(b.getShouldTotal() != null) setShouldTotal(b.getShouldTotal());
		if(b.getAlreadyBonus() != null) setAlreadyBonus(b.getAlreadyBonus());
		if(b.getOtherBonus() != null) setOtherBonus(b.getOtherBonus());
		if(b.getTaxBegin() != null) setTaxBegin(b.getTaxBegin());
		if(b.getShouldTaxAchieve() != null) setShouldTaxAchieve(b.getShouldTaxAchieve());
		if(b.getTaxTotal() != null) setTaxTotal(b.getTaxTotal());
		if(b.getDeductTax() != null) setDeductTax(b.getDeductTax());
		if(b.getShouldTax() != null) setShouldTax(b.getShouldTax());
		if(b.getTotalInsurance() != null) setTotalInsurance(b.getTotalInsurance());
		if(b.getTotalFund() != null) setTotalFund(b.getTotalFund());
		if(b.getUnitTotalInsurance() != null) setUnitTotalInsurance(b.getUnitTotalInsurance());
		if(b.getUnitTotalFund() != null) setUnitTotalFund(b.getUnitTotalFund());
		if(b.getLeaveNoDeductTax() != null) setLeaveNoDeductTax(b.getLeaveNoDeductTax());
		if(b.getLeaveDeductTax() != null) setLeaveDeductTax(b.getLeaveDeductTax());
		if(b.getFactSalary() != null) setFactSalary(b.getFactSalary());
		if(b.getAffiliated() != null) setAffiliated(b.getAffiliated());
		if(b.getVoteProject() != null) setVoteProject(b.getVoteProject());
		if(b.getVotePercent() != null) setVotePercent(b.getVotePercent());
		if(b.getInsteadDeduct() != null) setInsteadDeduct(b.getInsteadDeduct());
		if(b.getInsteadDeductIll() != null) setInsteadDeductIll(b.getInsteadDeductIll());
		if(b.getIsSended() != null) setIsSended(b.getIsSended());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCostAttribution() != null) setCostAttribution(b.getCostAttribution());
		if(b.getDevelopmentProject() != null) setDevelopmentProject(b.getDevelopmentProject());
		if(b.getPersonalPension() != null) setPersonalPension(b.getPersonalPension());
		if(b.getPersonalMedicalInsurance() != null) setPersonalMedicalInsurance(b.getPersonalMedicalInsurance());
		if(b.getPersonalLargeMedicalInsurance() != null) setPersonalLargeMedicalInsurance(b.getPersonalLargeMedicalInsurance());
		if(b.getPersonalUnemploymentInsurance() != null) setPersonalUnemploymentInsurance(b.getPersonalUnemploymentInsurance());
		if(b.getPersonalHeating() != null) setPersonalHeating(b.getPersonalHeating());
		if(b.getPersonalSeriousIllInsurance() != null) setPersonalSeriousIllInsurance(b.getPersonalSeriousIllInsurance());
		if(b.getSalaryTypeName() != null) setSalaryTypeName(b.getSalaryTypeName());
		if(b.getSpecialAdditionalDuduct() != null) setSpecialAdditionalDuduct(b.getSpecialAdditionalDuduct());
		if(b.getSpecialDuduct1() != null) setSpecialDuduct1(b.getSpecialDuduct1());
		if(b.getSpecialDuduct2() != null) setSpecialDuduct2(b.getSpecialDuduct2());
		if(b.getSpecialDuduct3() != null) setSpecialDuduct3(b.getSpecialDuduct3());
		if(b.getSpecialDuduct4() != null) setSpecialDuduct4(b.getSpecialDuduct4());
		if(b.getSpecialDuduct5() != null) setSpecialDuduct5(b.getSpecialDuduct5());
		if(b.getSpecialDuduct6() != null) setSpecialDuduct6(b.getSpecialDuduct6());
		if(b.getSpecialDuductSum() != null) setSpecialDuductSum(b.getSpecialDuductSum());
		if(b.getShouldTaxAchieveSum() != null) setShouldTaxAchieveSum(b.getShouldTaxAchieveSum());
		if(b.getIndividualIncomeTaxSum() != null) setIndividualIncomeTaxSum(b.getIndividualIncomeTaxSum());
		if(b.getInsuranceFundSum() != null) setInsuranceFundSum(b.getInsuranceFundSum());
		if(b.getWithholdingTax() != null) setWithholdingTax(b.getWithholdingTax());
		if(b.getReplacementTax() != null) setReplacementTax(b.getReplacementTax());
		if(b.getSuspendBonus() != null) setSuspendBonus(b.getSuspendBonus());
		if(b.getOtherDeduction() != null) setOtherDeduction(b.getOtherDeduction());
	}

	@Override
	public BaseSalaryTotal generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSalaryTotal b = new BaseSalaryTotal();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSalaryTotal __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryTotalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBankAccount(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonthBasicPay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkMoney(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFillSendDeduct(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setJobSubsidy(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttendanceDeduct(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerformancePay(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldSalary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTotal(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAlreadyBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxBegin(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTaxAchieve(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxTotal(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeductTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalInsurance(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalFund(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitTotalInsurance(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitTotalFund(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveNoDeductTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeaveDeductTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFactSalary(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAffiliated(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVoteProject(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setVotePercent(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInsteadDeduct(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInsteadDeductIll(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSended(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCostAttribution(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDevelopmentProject(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalPension(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalHeating(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalSeriousIllInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSalaryTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialAdditionalDuduct(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct1(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct2(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct3(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct4(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct5(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuduct6(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialDuductSum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setShouldTaxAchieveSum(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIndividualIncomeTaxSum(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInsuranceFundSum(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWithholdingTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReplacementTax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSuspendBonus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOtherDeduction(GenericBase.__getString(val));
	}

	public void setSalaryTotalId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSalaryTotalId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSalaryTotalIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setBankAccount(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getBankAccount() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setMonth(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getMonth() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setMonthBasicPay(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getMonthBasicPay() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setWorkMoney(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getWorkMoney() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setFillSendDeduct(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getFillSendDeduct() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setJobSubsidy(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getJobSubsidy() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setAttendanceDeduct(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getAttendanceDeduct() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setPerformancePay(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getPerformancePay() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setShouldSalary(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getShouldSalary() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setShouldBonus(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getShouldBonus() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setShouldTotal(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getShouldTotal() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setAlreadyBonus(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getAlreadyBonus() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setOtherBonus(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getOtherBonus() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setTaxBegin(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getTaxBegin() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setShouldTaxAchieve(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getShouldTaxAchieve() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setTaxTotal(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getTaxTotal() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setDeductTax(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getDeductTax() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setShouldTax(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getShouldTax() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setTotalInsurance(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getTotalInsurance() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setTotalFund(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getTotalFund() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setUnitTotalInsurance(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getUnitTotalInsurance() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setUnitTotalFund(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getUnitTotalFund() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setLeaveNoDeductTax(java.lang.String val) {
		setCurrentData(30, val);
	}

	public java.lang.String getLeaveNoDeductTax() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setLeaveDeductTax(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getLeaveDeductTax() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setFactSalary(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getFactSalary() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setAffiliated(java.lang.Integer val) {
		setCurrentData(33, val);
	}

	public java.lang.Integer getAffiliated() {
		return GenericBase.__getInt(__current_data[33]);
	}

	public void setVoteProject(java.lang.String val) {
		setCurrentData(34, val);
	}

	public java.lang.String getVoteProject() {
		return GenericBase.__getString(__current_data[34]);
	}

	public void setVotePercent(java.lang.String val) {
		setCurrentData(35, val);
	}

	public java.lang.String getVotePercent() {
		return GenericBase.__getString(__current_data[35]);
	}

	public void setInsteadDeduct(java.lang.String val) {
		setCurrentData(36, val);
	}

	public java.lang.String getInsteadDeduct() {
		return GenericBase.__getString(__current_data[36]);
	}

	public void setInsteadDeductIll(java.lang.String val) {
		setCurrentData(37, val);
	}

	public java.lang.String getInsteadDeductIll() {
		return GenericBase.__getString(__current_data[37]);
	}

	public void setIsSended(java.lang.Boolean val) {
		setCurrentData(38, val);
	}

	public java.lang.Boolean getIsSended() {
		return GenericBase.__getBoolean(__current_data[38]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(39, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[39]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(40, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[40]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(41, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[41]);
	}

	public void setCostAttribution(java.lang.Integer val) {
		setCurrentData(42, val);
	}

	public java.lang.Integer getCostAttribution() {
		return GenericBase.__getInt(__current_data[42]);
	}

	public void setDevelopmentProject(java.lang.String val) {
		setCurrentData(43, val);
	}

	public java.lang.String getDevelopmentProject() {
		return GenericBase.__getString(__current_data[43]);
	}

	public void setPersonalPension(java.math.BigDecimal val) {
		setCurrentData(44, val);
	}

	public java.math.BigDecimal getPersonalPension() {
		return GenericBase.__getDecimal(__current_data[44]);
	}

	public void setPersonalMedicalInsurance(java.math.BigDecimal val) {
		setCurrentData(45, val);
	}

	public java.math.BigDecimal getPersonalMedicalInsurance() {
		return GenericBase.__getDecimal(__current_data[45]);
	}

	public void setPersonalLargeMedicalInsurance(java.math.BigDecimal val) {
		setCurrentData(46, val);
	}

	public java.math.BigDecimal getPersonalLargeMedicalInsurance() {
		return GenericBase.__getDecimal(__current_data[46]);
	}

	public void setPersonalUnemploymentInsurance(java.math.BigDecimal val) {
		setCurrentData(47, val);
	}

	public java.math.BigDecimal getPersonalUnemploymentInsurance() {
		return GenericBase.__getDecimal(__current_data[47]);
	}

	public void setPersonalHeating(java.math.BigDecimal val) {
		setCurrentData(48, val);
	}

	public java.math.BigDecimal getPersonalHeating() {
		return GenericBase.__getDecimal(__current_data[48]);
	}

	public void setPersonalSeriousIllInsurance(java.math.BigDecimal val) {
		setCurrentData(49, val);
	}

	public java.math.BigDecimal getPersonalSeriousIllInsurance() {
		return GenericBase.__getDecimal(__current_data[49]);
	}

	public void setSalaryTypeName(java.lang.String val) {
		setCurrentData(50, val);
	}

	public java.lang.String getSalaryTypeName() {
		return GenericBase.__getString(__current_data[50]);
	}

	public void setSpecialAdditionalDuduct(java.math.BigDecimal val) {
		setCurrentData(51, val);
	}

	public java.math.BigDecimal getSpecialAdditionalDuduct() {
		return GenericBase.__getDecimal(__current_data[51]);
	}

	public void setSpecialDuduct1(java.math.BigDecimal val) {
		setCurrentData(52, val);
	}

	public java.math.BigDecimal getSpecialDuduct1() {
		return GenericBase.__getDecimal(__current_data[52]);
	}

	public void setSpecialDuduct2(java.math.BigDecimal val) {
		setCurrentData(53, val);
	}

	public java.math.BigDecimal getSpecialDuduct2() {
		return GenericBase.__getDecimal(__current_data[53]);
	}

	public void setSpecialDuduct3(java.math.BigDecimal val) {
		setCurrentData(54, val);
	}

	public java.math.BigDecimal getSpecialDuduct3() {
		return GenericBase.__getDecimal(__current_data[54]);
	}

	public void setSpecialDuduct4(java.math.BigDecimal val) {
		setCurrentData(55, val);
	}

	public java.math.BigDecimal getSpecialDuduct4() {
		return GenericBase.__getDecimal(__current_data[55]);
	}

	public void setSpecialDuduct5(java.math.BigDecimal val) {
		setCurrentData(56, val);
	}

	public java.math.BigDecimal getSpecialDuduct5() {
		return GenericBase.__getDecimal(__current_data[56]);
	}

	public void setSpecialDuduct6(java.math.BigDecimal val) {
		setCurrentData(57, val);
	}

	public java.math.BigDecimal getSpecialDuduct6() {
		return GenericBase.__getDecimal(__current_data[57]);
	}

	public void setSpecialDuductSum(java.math.BigDecimal val) {
		setCurrentData(58, val);
	}

	public java.math.BigDecimal getSpecialDuductSum() {
		return GenericBase.__getDecimal(__current_data[58]);
	}

	public void setShouldTaxAchieveSum(java.lang.String val) {
		setCurrentData(59, val);
	}

	public java.lang.String getShouldTaxAchieveSum() {
		return GenericBase.__getString(__current_data[59]);
	}

	public void setIndividualIncomeTaxSum(java.lang.String val) {
		setCurrentData(60, val);
	}

	public java.lang.String getIndividualIncomeTaxSum() {
		return GenericBase.__getString(__current_data[60]);
	}

	public void setInsuranceFundSum(java.lang.String val) {
		setCurrentData(61, val);
	}

	public java.lang.String getInsuranceFundSum() {
		return GenericBase.__getString(__current_data[61]);
	}

	public void setWithholdingTax(java.lang.String val) {
		setCurrentData(62, val);
	}

	public java.lang.String getWithholdingTax() {
		return GenericBase.__getString(__current_data[62]);
	}

	public void setReplacementTax(java.lang.String val) {
		setCurrentData(63, val);
	}

	public java.lang.String getReplacementTax() {
		return GenericBase.__getString(__current_data[63]);
	}

	public void setSuspendBonus(java.lang.String val) {
		setCurrentData(64, val);
	}

	public java.lang.String getSuspendBonus() {
		return GenericBase.__getString(__current_data[64]);
	}

	public void setOtherDeduction(java.lang.String val) {
		setCurrentData(65, val);
	}

	public java.lang.String getOtherDeduction() {
		return GenericBase.__getString(__current_data[65]);
	}

	public void setConditionSalaryTotalId(String op, java.lang.Integer val) {
		setConditionSalaryTotalId(op, val, CONDITION_AND);
	}

	public void setConditionSalaryTotalId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSalaryTotalId(boolean val) {
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

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
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

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionBankAccount(String op, java.lang.String val) {
		setConditionBankAccount(op, val, CONDITION_AND);
	}

	public void setConditionBankAccount(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectBankAccount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMonth(String op, java.lang.Integer val) {
		setConditionMonth(op, val, CONDITION_AND);
	}

	public void setConditionMonth(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMonth(boolean val) {
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

	public void setConditionWorkMoney(String op, java.lang.String val) {
		setConditionWorkMoney(op, val, CONDITION_AND);
	}

	public void setConditionWorkMoney(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectWorkMoney(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionFillSendDeduct(String op, java.lang.String val) {
		setConditionFillSendDeduct(op, val, CONDITION_AND);
	}

	public void setConditionFillSendDeduct(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectFillSendDeduct(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionJobSubsidy(String op, java.lang.String val) {
		setConditionJobSubsidy(op, val, CONDITION_AND);
	}

	public void setConditionJobSubsidy(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectJobSubsidy(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionAttendanceDeduct(String op, java.lang.String val) {
		setConditionAttendanceDeduct(op, val, CONDITION_AND);
	}

	public void setConditionAttendanceDeduct(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectAttendanceDeduct(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionPerformancePay(String op, java.lang.String val) {
		setConditionPerformancePay(op, val, CONDITION_AND);
	}

	public void setConditionPerformancePay(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectPerformancePay(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionShouldSalary(String op, java.lang.String val) {
		setConditionShouldSalary(op, val, CONDITION_AND);
	}

	public void setConditionShouldSalary(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectShouldSalary(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionShouldBonus(String op, java.lang.String val) {
		setConditionShouldBonus(op, val, CONDITION_AND);
	}

	public void setConditionShouldBonus(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectShouldBonus(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionShouldTotal(String op, java.lang.String val) {
		setConditionShouldTotal(op, val, CONDITION_AND);
	}

	public void setConditionShouldTotal(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectShouldTotal(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionAlreadyBonus(String op, java.lang.String val) {
		setConditionAlreadyBonus(op, val, CONDITION_AND);
	}

	public void setConditionAlreadyBonus(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectAlreadyBonus(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionOtherBonus(String op, java.lang.String val) {
		setConditionOtherBonus(op, val, CONDITION_AND);
	}

	public void setConditionOtherBonus(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectOtherBonus(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionTaxBegin(String op, java.math.BigDecimal val) {
		setConditionTaxBegin(op, val, CONDITION_AND);
	}

	public void setConditionTaxBegin(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectTaxBegin(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionShouldTaxAchieve(String op, java.lang.String val) {
		setConditionShouldTaxAchieve(op, val, CONDITION_AND);
	}

	public void setConditionShouldTaxAchieve(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectShouldTaxAchieve(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionTaxTotal(String op, java.lang.String val) {
		setConditionTaxTotal(op, val, CONDITION_AND);
	}

	public void setConditionTaxTotal(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectTaxTotal(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionDeductTax(String op, java.lang.String val) {
		setConditionDeductTax(op, val, CONDITION_AND);
	}

	public void setConditionDeductTax(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectDeductTax(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionShouldTax(String op, java.lang.String val) {
		setConditionShouldTax(op, val, CONDITION_AND);
	}

	public void setConditionShouldTax(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectShouldTax(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionTotalInsurance(String op, java.lang.String val) {
		setConditionTotalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionTotalInsurance(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectTotalInsurance(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionTotalFund(String op, java.lang.String val) {
		setConditionTotalFund(op, val, CONDITION_AND);
	}

	public void setConditionTotalFund(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectTotalFund(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionUnitTotalInsurance(String op, java.lang.String val) {
		setConditionUnitTotalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionUnitTotalInsurance(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectUnitTotalInsurance(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionUnitTotalFund(String op, java.lang.String val) {
		setConditionUnitTotalFund(op, val, CONDITION_AND);
	}

	public void setConditionUnitTotalFund(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectUnitTotalFund(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionLeaveNoDeductTax(String op, java.lang.String val) {
		setConditionLeaveNoDeductTax(op, val, CONDITION_AND);
	}

	public void setConditionLeaveNoDeductTax(String op, java.lang.String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectLeaveNoDeductTax(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionLeaveDeductTax(String op, java.lang.String val) {
		setConditionLeaveDeductTax(op, val, CONDITION_AND);
	}

	public void setConditionLeaveDeductTax(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectLeaveDeductTax(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionFactSalary(String op, java.lang.String val) {
		setConditionFactSalary(op, val, CONDITION_AND);
	}

	public void setConditionFactSalary(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectFactSalary(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionAffiliated(String op, java.lang.Integer val) {
		setConditionAffiliated(op, val, CONDITION_AND);
	}

	public void setConditionAffiliated(String op, java.lang.Integer val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectAffiliated(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionVoteProject(String op, java.lang.String val) {
		setConditionVoteProject(op, val, CONDITION_AND);
	}

	public void setConditionVoteProject(String op, java.lang.String val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectVoteProject(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionVotePercent(String op, java.lang.String val) {
		setConditionVotePercent(op, val, CONDITION_AND);
	}

	public void setConditionVotePercent(String op, java.lang.String val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectVotePercent(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionInsteadDeduct(String op, java.lang.String val) {
		setConditionInsteadDeduct(op, val, CONDITION_AND);
	}

	public void setConditionInsteadDeduct(String op, java.lang.String val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectInsteadDeduct(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionInsteadDeductIll(String op, java.lang.String val) {
		setConditionInsteadDeductIll(op, val, CONDITION_AND);
	}

	public void setConditionInsteadDeductIll(String op, java.lang.String val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectInsteadDeductIll(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionIsSended(String op, java.lang.Boolean val) {
		setConditionIsSended(op, val, CONDITION_AND);
	}

	public void setConditionIsSended(String op, java.lang.Boolean val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectIsSended(boolean val) {
		__select_flags[38] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[39] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(40, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[40] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[41] = val;
	}

	public void setConditionCostAttribution(String op, java.lang.Integer val) {
		setConditionCostAttribution(op, val, CONDITION_AND);
	}

	public void setConditionCostAttribution(String op, java.lang.Integer val, String relation) {
		addCondition(42, op, relation, val);
	}

	public void setSelectCostAttribution(boolean val) {
		__select_flags[42] = val;
	}

	public void setConditionDevelopmentProject(String op, java.lang.String val) {
		setConditionDevelopmentProject(op, val, CONDITION_AND);
	}

	public void setConditionDevelopmentProject(String op, java.lang.String val, String relation) {
		addCondition(43, op, relation, val);
	}

	public void setSelectDevelopmentProject(boolean val) {
		__select_flags[43] = val;
	}

	public void setConditionPersonalPension(String op, java.math.BigDecimal val) {
		setConditionPersonalPension(op, val, CONDITION_AND);
	}

	public void setConditionPersonalPension(String op, java.math.BigDecimal val, String relation) {
		addCondition(44, op, relation, val);
	}

	public void setSelectPersonalPension(boolean val) {
		__select_flags[44] = val;
	}

	public void setConditionPersonalMedicalInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalMedicalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalMedicalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(45, op, relation, val);
	}

	public void setSelectPersonalMedicalInsurance(boolean val) {
		__select_flags[45] = val;
	}

	public void setConditionPersonalLargeMedicalInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalLargeMedicalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalLargeMedicalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(46, op, relation, val);
	}

	public void setSelectPersonalLargeMedicalInsurance(boolean val) {
		__select_flags[46] = val;
	}

	public void setConditionPersonalUnemploymentInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalUnemploymentInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalUnemploymentInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(47, op, relation, val);
	}

	public void setSelectPersonalUnemploymentInsurance(boolean val) {
		__select_flags[47] = val;
	}

	public void setConditionPersonalHeating(String op, java.math.BigDecimal val) {
		setConditionPersonalHeating(op, val, CONDITION_AND);
	}

	public void setConditionPersonalHeating(String op, java.math.BigDecimal val, String relation) {
		addCondition(48, op, relation, val);
	}

	public void setSelectPersonalHeating(boolean val) {
		__select_flags[48] = val;
	}

	public void setConditionPersonalSeriousIllInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalSeriousIllInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalSeriousIllInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(49, op, relation, val);
	}

	public void setSelectPersonalSeriousIllInsurance(boolean val) {
		__select_flags[49] = val;
	}

	public void setConditionSalaryTypeName(String op, java.lang.String val) {
		setConditionSalaryTypeName(op, val, CONDITION_AND);
	}

	public void setConditionSalaryTypeName(String op, java.lang.String val, String relation) {
		addCondition(50, op, relation, val);
	}

	public void setSelectSalaryTypeName(boolean val) {
		__select_flags[50] = val;
	}

	public void setConditionSpecialAdditionalDuduct(String op, java.math.BigDecimal val) {
		setConditionSpecialAdditionalDuduct(op, val, CONDITION_AND);
	}

	public void setConditionSpecialAdditionalDuduct(String op, java.math.BigDecimal val, String relation) {
		addCondition(51, op, relation, val);
	}

	public void setSelectSpecialAdditionalDuduct(boolean val) {
		__select_flags[51] = val;
	}

	public void setConditionSpecialDuduct1(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct1(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct1(String op, java.math.BigDecimal val, String relation) {
		addCondition(52, op, relation, val);
	}

	public void setSelectSpecialDuduct1(boolean val) {
		__select_flags[52] = val;
	}

	public void setConditionSpecialDuduct2(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct2(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct2(String op, java.math.BigDecimal val, String relation) {
		addCondition(53, op, relation, val);
	}

	public void setSelectSpecialDuduct2(boolean val) {
		__select_flags[53] = val;
	}

	public void setConditionSpecialDuduct3(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct3(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct3(String op, java.math.BigDecimal val, String relation) {
		addCondition(54, op, relation, val);
	}

	public void setSelectSpecialDuduct3(boolean val) {
		__select_flags[54] = val;
	}

	public void setConditionSpecialDuduct4(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct4(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct4(String op, java.math.BigDecimal val, String relation) {
		addCondition(55, op, relation, val);
	}

	public void setSelectSpecialDuduct4(boolean val) {
		__select_flags[55] = val;
	}

	public void setConditionSpecialDuduct5(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct5(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct5(String op, java.math.BigDecimal val, String relation) {
		addCondition(56, op, relation, val);
	}

	public void setSelectSpecialDuduct5(boolean val) {
		__select_flags[56] = val;
	}

	public void setConditionSpecialDuduct6(String op, java.math.BigDecimal val) {
		setConditionSpecialDuduct6(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuduct6(String op, java.math.BigDecimal val, String relation) {
		addCondition(57, op, relation, val);
	}

	public void setSelectSpecialDuduct6(boolean val) {
		__select_flags[57] = val;
	}

	public void setConditionSpecialDuductSum(String op, java.math.BigDecimal val) {
		setConditionSpecialDuductSum(op, val, CONDITION_AND);
	}

	public void setConditionSpecialDuductSum(String op, java.math.BigDecimal val, String relation) {
		addCondition(58, op, relation, val);
	}

	public void setSelectSpecialDuductSum(boolean val) {
		__select_flags[58] = val;
	}

	public void setConditionShouldTaxAchieveSum(String op, java.lang.String val) {
		setConditionShouldTaxAchieveSum(op, val, CONDITION_AND);
	}

	public void setConditionShouldTaxAchieveSum(String op, java.lang.String val, String relation) {
		addCondition(59, op, relation, val);
	}

	public void setSelectShouldTaxAchieveSum(boolean val) {
		__select_flags[59] = val;
	}

	public void setConditionIndividualIncomeTaxSum(String op, java.lang.String val) {
		setConditionIndividualIncomeTaxSum(op, val, CONDITION_AND);
	}

	public void setConditionIndividualIncomeTaxSum(String op, java.lang.String val, String relation) {
		addCondition(60, op, relation, val);
	}

	public void setSelectIndividualIncomeTaxSum(boolean val) {
		__select_flags[60] = val;
	}

	public void setConditionInsuranceFundSum(String op, java.lang.String val) {
		setConditionInsuranceFundSum(op, val, CONDITION_AND);
	}

	public void setConditionInsuranceFundSum(String op, java.lang.String val, String relation) {
		addCondition(61, op, relation, val);
	}

	public void setSelectInsuranceFundSum(boolean val) {
		__select_flags[61] = val;
	}

	public void setConditionWithholdingTax(String op, java.lang.String val) {
		setConditionWithholdingTax(op, val, CONDITION_AND);
	}

	public void setConditionWithholdingTax(String op, java.lang.String val, String relation) {
		addCondition(62, op, relation, val);
	}

	public void setSelectWithholdingTax(boolean val) {
		__select_flags[62] = val;
	}

	public void setConditionReplacementTax(String op, java.lang.String val) {
		setConditionReplacementTax(op, val, CONDITION_AND);
	}

	public void setConditionReplacementTax(String op, java.lang.String val, String relation) {
		addCondition(63, op, relation, val);
	}

	public void setSelectReplacementTax(boolean val) {
		__select_flags[63] = val;
	}

	public void setConditionSuspendBonus(String op, java.lang.String val) {
		setConditionSuspendBonus(op, val, CONDITION_AND);
	}

	public void setConditionSuspendBonus(String op, java.lang.String val, String relation) {
		addCondition(64, op, relation, val);
	}

	public void setSelectSuspendBonus(boolean val) {
		__select_flags[64] = val;
	}

	public void setConditionOtherDeduction(String op, java.lang.String val) {
		setConditionOtherDeduction(op, val, CONDITION_AND);
	}

	public void setConditionOtherDeduction(String op, java.lang.String val, String relation) {
		addCondition(65, op, relation, val);
	}

	public void setSelectOtherDeduction(boolean val) {
		__select_flags[65] = val;
	}


}

