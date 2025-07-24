package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFiveInsuranceOneGold;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FiveInsuranceOneGold extends AbstractTable<BaseFiveInsuranceOneGold>
{

	public FiveInsuranceOneGold() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 47;

		initTables();

		__tableName            = "five_insurance_one_golds";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFiveInsuranceOneGold.CS_FIVE_INSURANCE_ONE_GOLD_ID;
		__column_names[1] = BaseFiveInsuranceOneGold.CS_EMPLOYEE_ID;
		__column_names[2] = BaseFiveInsuranceOneGold.CS_YEAR;
		__column_names[3] = BaseFiveInsuranceOneGold.CS_MONTH;
		__column_names[4] = BaseFiveInsuranceOneGold.CS_TOTAL_FUND;
		__column_names[5] = BaseFiveInsuranceOneGold.CS_UNIT_TOTAL_FUND;
		__column_names[6] = BaseFiveInsuranceOneGold.CS_PERSONAL_TOTAL_FUND;
		__column_names[7] = BaseFiveInsuranceOneGold.CS_TOTAL_INSURANCE;
		__column_names[8] = BaseFiveInsuranceOneGold.CS_UNIT_TOTAL_INSURANCE;
		__column_names[9] = BaseFiveInsuranceOneGold.CS_PERSONAL_TOTAL_INSURANCE;
		__column_names[10] = BaseFiveInsuranceOneGold.CS_UNIT_PENSION;
		__column_names[11] = BaseFiveInsuranceOneGold.CS_UNIT_MEDICAL_INSURANCE;
		__column_names[12] = BaseFiveInsuranceOneGold.CS_UNIT_LARGE_MEDICAL_INSURANCE;
		__column_names[13] = BaseFiveInsuranceOneGold.CS_UNIT_INJURY_INSURANCE;
		__column_names[14] = BaseFiveInsuranceOneGold.CS_UNIT_UNEMPLOYMENT_INSURANCE;
		__column_names[15] = BaseFiveInsuranceOneGold.CS_UNIT_GIVE_BIRTH_INSURANCE;
		__column_names[16] = BaseFiveInsuranceOneGold.CS_PERSONAL_PENSION;
		__column_names[17] = BaseFiveInsuranceOneGold.CS_PERSONAL_MEDICAL_INSURANCE;
		__column_names[18] = BaseFiveInsuranceOneGold.CS_PERSONAL_LARGE_MEDICAL_INSURANCE;
		__column_names[19] = BaseFiveInsuranceOneGold.CS_PERSONAL_SERIOUS_ILL_INSURANCE;
		__column_names[20] = BaseFiveInsuranceOneGold.CS_PERSONAL_UNEMPLOYMENT_INSURANCE;
		__column_names[21] = BaseFiveInsuranceOneGold.CS_PERSONAL_HEATING;
		__column_names[22] = BaseFiveInsuranceOneGold.CS_OPERATE_EMPLOYEE_ID;
		__column_names[23] = BaseFiveInsuranceOneGold.CS_OPERATE_TIME;
		__column_names[24] = BaseFiveInsuranceOneGold.CS_REMARK;
		__column_names[25] = BaseFiveInsuranceOneGold.CS_EMPLOYEE_NO;
		__column_names[26] = BaseFiveInsuranceOneGold.CS_EMPLOYEE_NAME;
		__column_names[27] = BaseFiveInsuranceOneGold.CS_COMPANY_ID;
		__column_names[28] = BaseFiveInsuranceOneGold.CS_DEPARTMENT_ID;
		__column_names[29] = BaseFiveInsuranceOneGold.CS_PLATE_ID;
		__column_names[30] = BaseFiveInsuranceOneGold.CS_UNIT_DISABILITY_INSURANCE;
		__column_names[31] = BaseFiveInsuranceOneGold.CS_ACCUMULATION_FUND_GOLE_PAYMENT_BASE;
		__column_names[32] = BaseFiveInsuranceOneGold.CS_ACCUMULATION_FUND_GOLE_COMPANY_PAYMENT_RATIO;
		__column_names[33] = BaseFiveInsuranceOneGold.CS_ACCUMULATION_FUND_GOLE_INDIVIDUAL_PAYMENT_RATIO;
		__column_names[34] = BaseFiveInsuranceOneGold.CS_UNIT_PENSION_PAYMENT_BASE;
		__column_names[35] = BaseFiveInsuranceOneGold.CS_UNIT_PENSION_PAYMENT_RATIO;
		__column_names[36] = BaseFiveInsuranceOneGold.CS_UNIT_MEDICAL_INSURANCE_PAYMENT_BASE;
		__column_names[37] = BaseFiveInsuranceOneGold.CS_UNIT_MEDICAL_INSURANCE_PAYMENT_RATIO;
		__column_names[38] = BaseFiveInsuranceOneGold.CS_UNIT_INJURY_INSURANCE_BASE;
		__column_names[39] = BaseFiveInsuranceOneGold.CS_UNIT_INJURY_INSURANCE_RATIO;
		__column_names[40] = BaseFiveInsuranceOneGold.CS_UNIT_UNEMPLOYMENT_INSURANCE_PAYMENT_BASE;
		__column_names[41] = BaseFiveInsuranceOneGold.CS_UNIT_UNEMPLOYMENT_INSURANCE_PAYMENT_RATIO;
		__column_names[42] = BaseFiveInsuranceOneGold.CS_UNIT_GIVE_BIRTH_INSURANCE_PAYMENT_BASE;
		__column_names[43] = BaseFiveInsuranceOneGold.CS_UNIT_GIVE_BIRTH_INSURANCE_PAYMENT_RATIO;
		__column_names[44] = BaseFiveInsuranceOneGold.CS_PERSONAL_PENSION_PAYMENT_RATIO;
		__column_names[45] = BaseFiveInsuranceOneGold.CS_PERSONAL_MEDICAL_INSURANCE_PAYMENT_RATIO;
		__column_names[46] = BaseFiveInsuranceOneGold.CS_PERSONAL_UNEMPLOYMENT_INSURANCE_PAYMENT_RATIO;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFiveInsuranceOneGold b) {
		clear();
		setFiveInsuranceOneGoldIdClear(b.getFiveInsuranceOneGoldId());
	}

	public boolean isPrimaryKeyNull() {
		return getFiveInsuranceOneGoldId() == null;
	}

	@Override
	public BaseFiveInsuranceOneGold generateBase(){
		BaseFiveInsuranceOneGold b = new BaseFiveInsuranceOneGold();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFiveInsuranceOneGold b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFiveInsuranceOneGoldId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMonth(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalFund(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitTotalFund(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalTotalFund(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitPension(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitInjuryInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitGiveBirthInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalPension(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalSeriousIllInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalHeating(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUnitDisabilityInsurance(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAccumulationFundGolePaymentBase(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAccumulationFundGoleCompanyPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAccumulationFundGoleIndividualPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitPensionPaymentBase(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitPensionPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitMedicalInsurancePaymentBase(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitMedicalInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitInjuryInsuranceBase(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitInjuryInsuranceRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitUnemploymentInsurancePaymentBase(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitUnemploymentInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitGiveBirthInsurancePaymentBase(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setUnitGiveBirthInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalPensionPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalMedicalInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPersonalUnemploymentInsurancePaymentRatio(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseFiveInsuranceOneGold b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFiveInsuranceOneGoldId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getYear();
		buff[count++] = b.getMonth();
		buff[count++] = b.getTotalFund();
		buff[count++] = b.getUnitTotalFund();
		buff[count++] = b.getPersonalTotalFund();
		buff[count++] = b.getTotalInsurance();
		buff[count++] = b.getUnitTotalInsurance();
		buff[count++] = b.getPersonalTotalInsurance();
		buff[count++] = b.getUnitPension();
		buff[count++] = b.getUnitMedicalInsurance();
		buff[count++] = b.getUnitLargeMedicalInsurance();
		buff[count++] = b.getUnitInjuryInsurance();
		buff[count++] = b.getUnitUnemploymentInsurance();
		buff[count++] = b.getUnitGiveBirthInsurance();
		buff[count++] = b.getPersonalPension();
		buff[count++] = b.getPersonalMedicalInsurance();
		buff[count++] = b.getPersonalLargeMedicalInsurance();
		buff[count++] = b.getPersonalSeriousIllInsurance();
		buff[count++] = b.getPersonalUnemploymentInsurance();
		buff[count++] = b.getPersonalHeating();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getUnitDisabilityInsurance();
		buff[count++] = b.getAccumulationFundGolePaymentBase();
		buff[count++] = b.getAccumulationFundGoleCompanyPaymentRatio();
		buff[count++] = b.getAccumulationFundGoleIndividualPaymentRatio();
		buff[count++] = b.getUnitPensionPaymentBase();
		buff[count++] = b.getUnitPensionPaymentRatio();
		buff[count++] = b.getUnitMedicalInsurancePaymentBase();
		buff[count++] = b.getUnitMedicalInsurancePaymentRatio();
		buff[count++] = b.getUnitInjuryInsuranceBase();
		buff[count++] = b.getUnitInjuryInsuranceRatio();
		buff[count++] = b.getUnitUnemploymentInsurancePaymentBase();
		buff[count++] = b.getUnitUnemploymentInsurancePaymentRatio();
		buff[count++] = b.getUnitGiveBirthInsurancePaymentBase();
		buff[count++] = b.getUnitGiveBirthInsurancePaymentRatio();
		buff[count++] = b.getPersonalPensionPaymentRatio();
		buff[count++] = b.getPersonalMedicalInsurancePaymentRatio();
		buff[count++] = b.getPersonalUnemploymentInsurancePaymentRatio();
	}

	@Override
	public void setDataFromBase(BaseFiveInsuranceOneGold b){
		if(b.getFiveInsuranceOneGoldId() != null) setFiveInsuranceOneGoldIdClear(b.getFiveInsuranceOneGoldId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getYear() != null) setYear(b.getYear());
		if(b.getMonth() != null) setMonth(b.getMonth());
		if(b.getTotalFund() != null) setTotalFund(b.getTotalFund());
		if(b.getUnitTotalFund() != null) setUnitTotalFund(b.getUnitTotalFund());
		if(b.getPersonalTotalFund() != null) setPersonalTotalFund(b.getPersonalTotalFund());
		if(b.getTotalInsurance() != null) setTotalInsurance(b.getTotalInsurance());
		if(b.getUnitTotalInsurance() != null) setUnitTotalInsurance(b.getUnitTotalInsurance());
		if(b.getPersonalTotalInsurance() != null) setPersonalTotalInsurance(b.getPersonalTotalInsurance());
		if(b.getUnitPension() != null) setUnitPension(b.getUnitPension());
		if(b.getUnitMedicalInsurance() != null) setUnitMedicalInsurance(b.getUnitMedicalInsurance());
		if(b.getUnitLargeMedicalInsurance() != null) setUnitLargeMedicalInsurance(b.getUnitLargeMedicalInsurance());
		if(b.getUnitInjuryInsurance() != null) setUnitInjuryInsurance(b.getUnitInjuryInsurance());
		if(b.getUnitUnemploymentInsurance() != null) setUnitUnemploymentInsurance(b.getUnitUnemploymentInsurance());
		if(b.getUnitGiveBirthInsurance() != null) setUnitGiveBirthInsurance(b.getUnitGiveBirthInsurance());
		if(b.getPersonalPension() != null) setPersonalPension(b.getPersonalPension());
		if(b.getPersonalMedicalInsurance() != null) setPersonalMedicalInsurance(b.getPersonalMedicalInsurance());
		if(b.getPersonalLargeMedicalInsurance() != null) setPersonalLargeMedicalInsurance(b.getPersonalLargeMedicalInsurance());
		if(b.getPersonalSeriousIllInsurance() != null) setPersonalSeriousIllInsurance(b.getPersonalSeriousIllInsurance());
		if(b.getPersonalUnemploymentInsurance() != null) setPersonalUnemploymentInsurance(b.getPersonalUnemploymentInsurance());
		if(b.getPersonalHeating() != null) setPersonalHeating(b.getPersonalHeating());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getUnitDisabilityInsurance() != null) setUnitDisabilityInsurance(b.getUnitDisabilityInsurance());
		if(b.getAccumulationFundGolePaymentBase() != null) setAccumulationFundGolePaymentBase(b.getAccumulationFundGolePaymentBase());
		if(b.getAccumulationFundGoleCompanyPaymentRatio() != null) setAccumulationFundGoleCompanyPaymentRatio(b.getAccumulationFundGoleCompanyPaymentRatio());
		if(b.getAccumulationFundGoleIndividualPaymentRatio() != null) setAccumulationFundGoleIndividualPaymentRatio(b.getAccumulationFundGoleIndividualPaymentRatio());
		if(b.getUnitPensionPaymentBase() != null) setUnitPensionPaymentBase(b.getUnitPensionPaymentBase());
		if(b.getUnitPensionPaymentRatio() != null) setUnitPensionPaymentRatio(b.getUnitPensionPaymentRatio());
		if(b.getUnitMedicalInsurancePaymentBase() != null) setUnitMedicalInsurancePaymentBase(b.getUnitMedicalInsurancePaymentBase());
		if(b.getUnitMedicalInsurancePaymentRatio() != null) setUnitMedicalInsurancePaymentRatio(b.getUnitMedicalInsurancePaymentRatio());
		if(b.getUnitInjuryInsuranceBase() != null) setUnitInjuryInsuranceBase(b.getUnitInjuryInsuranceBase());
		if(b.getUnitInjuryInsuranceRatio() != null) setUnitInjuryInsuranceRatio(b.getUnitInjuryInsuranceRatio());
		if(b.getUnitUnemploymentInsurancePaymentBase() != null) setUnitUnemploymentInsurancePaymentBase(b.getUnitUnemploymentInsurancePaymentBase());
		if(b.getUnitUnemploymentInsurancePaymentRatio() != null) setUnitUnemploymentInsurancePaymentRatio(b.getUnitUnemploymentInsurancePaymentRatio());
		if(b.getUnitGiveBirthInsurancePaymentBase() != null) setUnitGiveBirthInsurancePaymentBase(b.getUnitGiveBirthInsurancePaymentBase());
		if(b.getUnitGiveBirthInsurancePaymentRatio() != null) setUnitGiveBirthInsurancePaymentRatio(b.getUnitGiveBirthInsurancePaymentRatio());
		if(b.getPersonalPensionPaymentRatio() != null) setPersonalPensionPaymentRatio(b.getPersonalPensionPaymentRatio());
		if(b.getPersonalMedicalInsurancePaymentRatio() != null) setPersonalMedicalInsurancePaymentRatio(b.getPersonalMedicalInsurancePaymentRatio());
		if(b.getPersonalUnemploymentInsurancePaymentRatio() != null) setPersonalUnemploymentInsurancePaymentRatio(b.getPersonalUnemploymentInsurancePaymentRatio());
	}

	@Override
	public BaseFiveInsuranceOneGold generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFiveInsuranceOneGold b = new BaseFiveInsuranceOneGold();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFiveInsuranceOneGold __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFiveInsuranceOneGoldId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMonth(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalFund(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalTotalFund(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalTotalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitPension(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitMedicalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitInjuryInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitUnemploymentInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitGiveBirthInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalPension(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalSeriousIllInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalHeating(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitDisabilityInsurance(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccumulationFundGolePaymentBase(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccumulationFundGoleCompanyPaymentRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccumulationFundGoleIndividualPaymentRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitPensionPaymentBase(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitPensionPaymentRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitMedicalInsurancePaymentBase(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitMedicalInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitInjuryInsuranceBase(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitInjuryInsuranceRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitUnemploymentInsurancePaymentBase(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitUnemploymentInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitGiveBirthInsurancePaymentBase(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUnitGiveBirthInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalPensionPaymentRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalMedicalInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalUnemploymentInsurancePaymentRatio(GenericBase.__getDecimal(val));
	}

	public void setFiveInsuranceOneGoldId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFiveInsuranceOneGoldId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFiveInsuranceOneGoldIdClear(java.lang.Integer val) {
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

	public void setTotalFund(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getTotalFund() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setUnitTotalFund(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getUnitTotalFund() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setPersonalTotalFund(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getPersonalTotalFund() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setTotalInsurance(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getTotalInsurance() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setUnitTotalInsurance(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getUnitTotalInsurance() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setPersonalTotalInsurance(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getPersonalTotalInsurance() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setUnitPension(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getUnitPension() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setUnitMedicalInsurance(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getUnitMedicalInsurance() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setUnitLargeMedicalInsurance(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getUnitLargeMedicalInsurance() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setUnitInjuryInsurance(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getUnitInjuryInsurance() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setUnitUnemploymentInsurance(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getUnitUnemploymentInsurance() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setUnitGiveBirthInsurance(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getUnitGiveBirthInsurance() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setPersonalPension(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getPersonalPension() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setPersonalMedicalInsurance(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getPersonalMedicalInsurance() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setPersonalLargeMedicalInsurance(java.math.BigDecimal val) {
		setCurrentData(18, val);
	}

	public java.math.BigDecimal getPersonalLargeMedicalInsurance() {
		return GenericBase.__getDecimal(__current_data[18]);
	}

	public void setPersonalSeriousIllInsurance(java.math.BigDecimal val) {
		setCurrentData(19, val);
	}

	public java.math.BigDecimal getPersonalSeriousIllInsurance() {
		return GenericBase.__getDecimal(__current_data[19]);
	}

	public void setPersonalUnemploymentInsurance(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getPersonalUnemploymentInsurance() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setPersonalHeating(java.math.BigDecimal val) {
		setCurrentData(21, val);
	}

	public java.math.BigDecimal getPersonalHeating() {
		return GenericBase.__getDecimal(__current_data[21]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(22, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[22]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(23, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[23]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setUnitDisabilityInsurance(java.math.BigDecimal val) {
		setCurrentData(30, val);
	}

	public java.math.BigDecimal getUnitDisabilityInsurance() {
		return GenericBase.__getDecimal(__current_data[30]);
	}

	public void setAccumulationFundGolePaymentBase(java.math.BigDecimal val) {
		setCurrentData(31, val);
	}

	public java.math.BigDecimal getAccumulationFundGolePaymentBase() {
		return GenericBase.__getDecimal(__current_data[31]);
	}

	public void setAccumulationFundGoleCompanyPaymentRatio(java.math.BigDecimal val) {
		setCurrentData(32, val);
	}

	public java.math.BigDecimal getAccumulationFundGoleCompanyPaymentRatio() {
		return GenericBase.__getDecimal(__current_data[32]);
	}

	public void setAccumulationFundGoleIndividualPaymentRatio(java.math.BigDecimal val) {
		setCurrentData(33, val);
	}

	public java.math.BigDecimal getAccumulationFundGoleIndividualPaymentRatio() {
		return GenericBase.__getDecimal(__current_data[33]);
	}

	public void setUnitPensionPaymentBase(java.math.BigDecimal val) {
		setCurrentData(34, val);
	}

	public java.math.BigDecimal getUnitPensionPaymentBase() {
		return GenericBase.__getDecimal(__current_data[34]);
	}

	public void setUnitPensionPaymentRatio(java.math.BigDecimal val) {
		setCurrentData(35, val);
	}

	public java.math.BigDecimal getUnitPensionPaymentRatio() {
		return GenericBase.__getDecimal(__current_data[35]);
	}

	public void setUnitMedicalInsurancePaymentBase(java.math.BigDecimal val) {
		setCurrentData(36, val);
	}

	public java.math.BigDecimal getUnitMedicalInsurancePaymentBase() {
		return GenericBase.__getDecimal(__current_data[36]);
	}

	public void setUnitMedicalInsurancePaymentRatio(java.math.BigDecimal val) {
		setCurrentData(37, val);
	}

	public java.math.BigDecimal getUnitMedicalInsurancePaymentRatio() {
		return GenericBase.__getDecimal(__current_data[37]);
	}

	public void setUnitInjuryInsuranceBase(java.math.BigDecimal val) {
		setCurrentData(38, val);
	}

	public java.math.BigDecimal getUnitInjuryInsuranceBase() {
		return GenericBase.__getDecimal(__current_data[38]);
	}

	public void setUnitInjuryInsuranceRatio(java.math.BigDecimal val) {
		setCurrentData(39, val);
	}

	public java.math.BigDecimal getUnitInjuryInsuranceRatio() {
		return GenericBase.__getDecimal(__current_data[39]);
	}

	public void setUnitUnemploymentInsurancePaymentBase(java.math.BigDecimal val) {
		setCurrentData(40, val);
	}

	public java.math.BigDecimal getUnitUnemploymentInsurancePaymentBase() {
		return GenericBase.__getDecimal(__current_data[40]);
	}

	public void setUnitUnemploymentInsurancePaymentRatio(java.math.BigDecimal val) {
		setCurrentData(41, val);
	}

	public java.math.BigDecimal getUnitUnemploymentInsurancePaymentRatio() {
		return GenericBase.__getDecimal(__current_data[41]);
	}

	public void setUnitGiveBirthInsurancePaymentBase(java.math.BigDecimal val) {
		setCurrentData(42, val);
	}

	public java.math.BigDecimal getUnitGiveBirthInsurancePaymentBase() {
		return GenericBase.__getDecimal(__current_data[42]);
	}

	public void setUnitGiveBirthInsurancePaymentRatio(java.math.BigDecimal val) {
		setCurrentData(43, val);
	}

	public java.math.BigDecimal getUnitGiveBirthInsurancePaymentRatio() {
		return GenericBase.__getDecimal(__current_data[43]);
	}

	public void setPersonalPensionPaymentRatio(java.math.BigDecimal val) {
		setCurrentData(44, val);
	}

	public java.math.BigDecimal getPersonalPensionPaymentRatio() {
		return GenericBase.__getDecimal(__current_data[44]);
	}

	public void setPersonalMedicalInsurancePaymentRatio(java.math.BigDecimal val) {
		setCurrentData(45, val);
	}

	public java.math.BigDecimal getPersonalMedicalInsurancePaymentRatio() {
		return GenericBase.__getDecimal(__current_data[45]);
	}

	public void setPersonalUnemploymentInsurancePaymentRatio(java.math.BigDecimal val) {
		setCurrentData(46, val);
	}

	public java.math.BigDecimal getPersonalUnemploymentInsurancePaymentRatio() {
		return GenericBase.__getDecimal(__current_data[46]);
	}

	public void setConditionFiveInsuranceOneGoldId(String op, java.lang.Integer val) {
		setConditionFiveInsuranceOneGoldId(op, val, CONDITION_AND);
	}

	public void setConditionFiveInsuranceOneGoldId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFiveInsuranceOneGoldId(boolean val) {
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

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
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

	public void setConditionTotalFund(String op, java.math.BigDecimal val) {
		setConditionTotalFund(op, val, CONDITION_AND);
	}

	public void setConditionTotalFund(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTotalFund(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionUnitTotalFund(String op, java.math.BigDecimal val) {
		setConditionUnitTotalFund(op, val, CONDITION_AND);
	}

	public void setConditionUnitTotalFund(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectUnitTotalFund(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPersonalTotalFund(String op, java.math.BigDecimal val) {
		setConditionPersonalTotalFund(op, val, CONDITION_AND);
	}

	public void setConditionPersonalTotalFund(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPersonalTotalFund(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionTotalInsurance(String op, java.math.BigDecimal val) {
		setConditionTotalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionTotalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectTotalInsurance(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionUnitTotalInsurance(String op, java.math.BigDecimal val) {
		setConditionUnitTotalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionUnitTotalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectUnitTotalInsurance(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionPersonalTotalInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalTotalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalTotalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectPersonalTotalInsurance(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionUnitPension(String op, java.math.BigDecimal val) {
		setConditionUnitPension(op, val, CONDITION_AND);
	}

	public void setConditionUnitPension(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectUnitPension(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionUnitMedicalInsurance(String op, java.math.BigDecimal val) {
		setConditionUnitMedicalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionUnitMedicalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectUnitMedicalInsurance(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionUnitLargeMedicalInsurance(String op, java.math.BigDecimal val) {
		setConditionUnitLargeMedicalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionUnitLargeMedicalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectUnitLargeMedicalInsurance(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionUnitInjuryInsurance(String op, java.math.BigDecimal val) {
		setConditionUnitInjuryInsurance(op, val, CONDITION_AND);
	}

	public void setConditionUnitInjuryInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectUnitInjuryInsurance(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionUnitUnemploymentInsurance(String op, java.math.BigDecimal val) {
		setConditionUnitUnemploymentInsurance(op, val, CONDITION_AND);
	}

	public void setConditionUnitUnemploymentInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectUnitUnemploymentInsurance(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionUnitGiveBirthInsurance(String op, java.math.BigDecimal val) {
		setConditionUnitGiveBirthInsurance(op, val, CONDITION_AND);
	}

	public void setConditionUnitGiveBirthInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectUnitGiveBirthInsurance(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionPersonalPension(String op, java.math.BigDecimal val) {
		setConditionPersonalPension(op, val, CONDITION_AND);
	}

	public void setConditionPersonalPension(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectPersonalPension(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionPersonalMedicalInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalMedicalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalMedicalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectPersonalMedicalInsurance(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionPersonalLargeMedicalInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalLargeMedicalInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalLargeMedicalInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectPersonalLargeMedicalInsurance(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionPersonalSeriousIllInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalSeriousIllInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalSeriousIllInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectPersonalSeriousIllInsurance(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionPersonalUnemploymentInsurance(String op, java.math.BigDecimal val) {
		setConditionPersonalUnemploymentInsurance(op, val, CONDITION_AND);
	}

	public void setConditionPersonalUnemploymentInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectPersonalUnemploymentInsurance(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionPersonalHeating(String op, java.math.BigDecimal val) {
		setConditionPersonalHeating(op, val, CONDITION_AND);
	}

	public void setConditionPersonalHeating(String op, java.math.BigDecimal val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectPersonalHeating(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(23, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionUnitDisabilityInsurance(String op, java.math.BigDecimal val) {
		setConditionUnitDisabilityInsurance(op, val, CONDITION_AND);
	}

	public void setConditionUnitDisabilityInsurance(String op, java.math.BigDecimal val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectUnitDisabilityInsurance(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionAccumulationFundGolePaymentBase(String op, java.math.BigDecimal val) {
		setConditionAccumulationFundGolePaymentBase(op, val, CONDITION_AND);
	}

	public void setConditionAccumulationFundGolePaymentBase(String op, java.math.BigDecimal val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectAccumulationFundGolePaymentBase(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionAccumulationFundGoleCompanyPaymentRatio(String op, java.math.BigDecimal val) {
		setConditionAccumulationFundGoleCompanyPaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionAccumulationFundGoleCompanyPaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectAccumulationFundGoleCompanyPaymentRatio(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionAccumulationFundGoleIndividualPaymentRatio(String op, java.math.BigDecimal val) {
		setConditionAccumulationFundGoleIndividualPaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionAccumulationFundGoleIndividualPaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectAccumulationFundGoleIndividualPaymentRatio(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionUnitPensionPaymentBase(String op, java.math.BigDecimal val) {
		setConditionUnitPensionPaymentBase(op, val, CONDITION_AND);
	}

	public void setConditionUnitPensionPaymentBase(String op, java.math.BigDecimal val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectUnitPensionPaymentBase(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionUnitPensionPaymentRatio(String op, java.math.BigDecimal val) {
		setConditionUnitPensionPaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionUnitPensionPaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectUnitPensionPaymentRatio(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionUnitMedicalInsurancePaymentBase(String op, java.math.BigDecimal val) {
		setConditionUnitMedicalInsurancePaymentBase(op, val, CONDITION_AND);
	}

	public void setConditionUnitMedicalInsurancePaymentBase(String op, java.math.BigDecimal val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectUnitMedicalInsurancePaymentBase(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionUnitMedicalInsurancePaymentRatio(String op, java.math.BigDecimal val) {
		setConditionUnitMedicalInsurancePaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionUnitMedicalInsurancePaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectUnitMedicalInsurancePaymentRatio(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionUnitInjuryInsuranceBase(String op, java.math.BigDecimal val) {
		setConditionUnitInjuryInsuranceBase(op, val, CONDITION_AND);
	}

	public void setConditionUnitInjuryInsuranceBase(String op, java.math.BigDecimal val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectUnitInjuryInsuranceBase(boolean val) {
		__select_flags[38] = val;
	}

	public void setConditionUnitInjuryInsuranceRatio(String op, java.math.BigDecimal val) {
		setConditionUnitInjuryInsuranceRatio(op, val, CONDITION_AND);
	}

	public void setConditionUnitInjuryInsuranceRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectUnitInjuryInsuranceRatio(boolean val) {
		__select_flags[39] = val;
	}

	public void setConditionUnitUnemploymentInsurancePaymentBase(String op, java.math.BigDecimal val) {
		setConditionUnitUnemploymentInsurancePaymentBase(op, val, CONDITION_AND);
	}

	public void setConditionUnitUnemploymentInsurancePaymentBase(String op, java.math.BigDecimal val, String relation) {
		addCondition(40, op, relation, val);
	}

	public void setSelectUnitUnemploymentInsurancePaymentBase(boolean val) {
		__select_flags[40] = val;
	}

	public void setConditionUnitUnemploymentInsurancePaymentRatio(String op, java.math.BigDecimal val) {
		setConditionUnitUnemploymentInsurancePaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionUnitUnemploymentInsurancePaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectUnitUnemploymentInsurancePaymentRatio(boolean val) {
		__select_flags[41] = val;
	}

	public void setConditionUnitGiveBirthInsurancePaymentBase(String op, java.math.BigDecimal val) {
		setConditionUnitGiveBirthInsurancePaymentBase(op, val, CONDITION_AND);
	}

	public void setConditionUnitGiveBirthInsurancePaymentBase(String op, java.math.BigDecimal val, String relation) {
		addCondition(42, op, relation, val);
	}

	public void setSelectUnitGiveBirthInsurancePaymentBase(boolean val) {
		__select_flags[42] = val;
	}

	public void setConditionUnitGiveBirthInsurancePaymentRatio(String op, java.math.BigDecimal val) {
		setConditionUnitGiveBirthInsurancePaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionUnitGiveBirthInsurancePaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(43, op, relation, val);
	}

	public void setSelectUnitGiveBirthInsurancePaymentRatio(boolean val) {
		__select_flags[43] = val;
	}

	public void setConditionPersonalPensionPaymentRatio(String op, java.math.BigDecimal val) {
		setConditionPersonalPensionPaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionPersonalPensionPaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(44, op, relation, val);
	}

	public void setSelectPersonalPensionPaymentRatio(boolean val) {
		__select_flags[44] = val;
	}

	public void setConditionPersonalMedicalInsurancePaymentRatio(String op, java.math.BigDecimal val) {
		setConditionPersonalMedicalInsurancePaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionPersonalMedicalInsurancePaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(45, op, relation, val);
	}

	public void setSelectPersonalMedicalInsurancePaymentRatio(boolean val) {
		__select_flags[45] = val;
	}

	public void setConditionPersonalUnemploymentInsurancePaymentRatio(String op, java.math.BigDecimal val) {
		setConditionPersonalUnemploymentInsurancePaymentRatio(op, val, CONDITION_AND);
	}

	public void setConditionPersonalUnemploymentInsurancePaymentRatio(String op, java.math.BigDecimal val, String relation) {
		addCondition(46, op, relation, val);
	}

	public void setSelectPersonalUnemploymentInsurancePaymentRatio(boolean val) {
		__select_flags[46] = val;
	}


}

