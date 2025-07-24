package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFiveInsuranceOneGold extends GenericBase implements BaseFactory<BaseFiveInsuranceOneGold>, Comparable<BaseFiveInsuranceOneGold> 
{


	public static BaseFiveInsuranceOneGold newInstance(){
		return new BaseFiveInsuranceOneGold();
	}

	@Override
	public BaseFiveInsuranceOneGold make(){
		BaseFiveInsuranceOneGold b = new BaseFiveInsuranceOneGold();
		return b;
	}

	public final static java.lang.String CS_FIVE_INSURANCE_ONE_GOLD_ID = "five_insurance_one_gold_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_UNIT_TOTAL_FUND = "unit_total_fund" ;
	public final static java.lang.String CS_PERSONAL_TOTAL_FUND = "personal_total_fund" ;
	public final static java.lang.String CS_TOTAL_INSURANCE = "total_insurance" ;
	public final static java.lang.String CS_UNIT_TOTAL_INSURANCE = "unit_total_insurance" ;
	public final static java.lang.String CS_PERSONAL_TOTAL_INSURANCE = "personal_total_insurance" ;
	public final static java.lang.String CS_UNIT_PENSION = "unit_pension" ;
	public final static java.lang.String CS_UNIT_MEDICAL_INSURANCE = "unit_medical_insurance" ;
	public final static java.lang.String CS_UNIT_LARGE_MEDICAL_INSURANCE = "unit_large_medical_insurance" ;
	public final static java.lang.String CS_UNIT_INJURY_INSURANCE = "unit_injury_insurance" ;
	public final static java.lang.String CS_UNIT_UNEMPLOYMENT_INSURANCE = "unit_unemployment_insurance" ;
	public final static java.lang.String CS_UNIT_GIVE_BIRTH_INSURANCE = "unit_give_birth_insurance" ;
	public final static java.lang.String CS_PERSONAL_PENSION = "personal_pension" ;
	public final static java.lang.String CS_PERSONAL_MEDICAL_INSURANCE = "personal_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_LARGE_MEDICAL_INSURANCE = "personal_large_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_SERIOUS_ILL_INSURANCE = "personal_serious_ill_insurance" ;
	public final static java.lang.String CS_PERSONAL_UNEMPLOYMENT_INSURANCE = "personal_unemployment_insurance" ;
	public final static java.lang.String CS_PERSONAL_HEATING = "personal_heating" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_UNIT_DISABILITY_INSURANCE = "unit_disability_insurance" ;
	public final static java.lang.String CS_ACCUMULATION_FUND_GOLE_PAYMENT_BASE = "accumulation_fund_gole_payment_base" ;
	public final static java.lang.String CS_ACCUMULATION_FUND_GOLE_COMPANY_PAYMENT_RATIO = "accumulation_fund_gole_company_payment_ratio" ;
	public final static java.lang.String CS_ACCUMULATION_FUND_GOLE_INDIVIDUAL_PAYMENT_RATIO = "accumulation_fund_gole_individual_payment_ratio" ;
	public final static java.lang.String CS_UNIT_PENSION_PAYMENT_BASE = "unit_pension_payment_base" ;
	public final static java.lang.String CS_UNIT_PENSION_PAYMENT_RATIO = "unit_pension_payment_ratio" ;
	public final static java.lang.String CS_UNIT_MEDICAL_INSURANCE_PAYMENT_BASE = "unit_medical_insurance_payment_base" ;
	public final static java.lang.String CS_UNIT_MEDICAL_INSURANCE_PAYMENT_RATIO = "unit_medical_insurance_payment_ratio" ;
	public final static java.lang.String CS_UNIT_INJURY_INSURANCE_BASE = "unit_injury_insurance_base" ;
	public final static java.lang.String CS_UNIT_INJURY_INSURANCE_RATIO = "unit_injury_insurance_ratio" ;
	public final static java.lang.String CS_UNIT_UNEMPLOYMENT_INSURANCE_PAYMENT_BASE = "unit_unemployment_insurance_payment_base" ;
	public final static java.lang.String CS_UNIT_UNEMPLOYMENT_INSURANCE_PAYMENT_RATIO = "unit_unemployment_insurance_payment_ratio" ;
	public final static java.lang.String CS_UNIT_GIVE_BIRTH_INSURANCE_PAYMENT_BASE = "unit_give_birth_insurance_payment_base" ;
	public final static java.lang.String CS_UNIT_GIVE_BIRTH_INSURANCE_PAYMENT_RATIO = "unit_give_birth_insurance_payment_ratio" ;
	public final static java.lang.String CS_PERSONAL_PENSION_PAYMENT_RATIO = "personal_pension_payment_ratio" ;
	public final static java.lang.String CS_PERSONAL_MEDICAL_INSURANCE_PAYMENT_RATIO = "personal_medical_insurance_payment_ratio" ;
	public final static java.lang.String CS_PERSONAL_UNEMPLOYMENT_INSURANCE_PAYMENT_RATIO = "personal_unemployment_insurance_payment_ratio" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员编码,年份,月份,应缴公积金合计,单位公积金合计,个人公积金合计,应缴社保合计,单位社保合计,个人社保合计,养老保险（单位）,医疗保险（单位）,大额医疗保险（单位）,工伤保险（单位）,失业保险（单位）,生育保险（单位）,养老保险（个人）,医疗保险（个人）,大额医疗保险（个人）,大病医疗保险（个人）,失业保险（个人）,采暖（个人）,操作人,操作时间,备注,,,,,,残障金（单位）,公积金缴费基数,公积金单位缴费比例,公积金个人缴费比例,养老保险缴费基数,养老保险缴费比例（单位）,医疗保险缴费基数,医疗保险缴费比例（单位）,工伤保险缴费基数,工伤保险缴费比例（单位）,失业保险缴费基数,失业保险缴费比例（单位）,生育保险缴费基数,生育保险缴费比例（单位）,养老保险缴费比例（个人）,医疗保险缴费比例（个人）,失业保险缴费比例（个人）";

	public java.lang.Integer getFiveInsuranceOneGoldId() {
		return this.__five_insurance_one_gold_id;
	}

	public void setFiveInsuranceOneGoldId( java.lang.Integer value ) {
		this.__five_insurance_one_gold_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.math.BigDecimal getTotalFund() {
		return this.__total_fund;
	}

	public void setTotalFund( java.math.BigDecimal value ) {
		this.__total_fund = value;
	}

	public java.math.BigDecimal getUnitTotalFund() {
		return this.__unit_total_fund;
	}

	public void setUnitTotalFund( java.math.BigDecimal value ) {
		this.__unit_total_fund = value;
	}

	public java.math.BigDecimal getPersonalTotalFund() {
		return this.__personal_total_fund;
	}

	public void setPersonalTotalFund( java.math.BigDecimal value ) {
		this.__personal_total_fund = value;
	}

	public java.math.BigDecimal getTotalInsurance() {
		return this.__total_insurance;
	}

	public void setTotalInsurance( java.math.BigDecimal value ) {
		this.__total_insurance = value;
	}

	public java.math.BigDecimal getUnitTotalInsurance() {
		return this.__unit_total_insurance;
	}

	public void setUnitTotalInsurance( java.math.BigDecimal value ) {
		this.__unit_total_insurance = value;
	}

	public java.math.BigDecimal getPersonalTotalInsurance() {
		return this.__personal_total_insurance;
	}

	public void setPersonalTotalInsurance( java.math.BigDecimal value ) {
		this.__personal_total_insurance = value;
	}

	public java.math.BigDecimal getUnitPension() {
		return this.__unit_pension;
	}

	public void setUnitPension( java.math.BigDecimal value ) {
		this.__unit_pension = value;
	}

	public java.math.BigDecimal getUnitMedicalInsurance() {
		return this.__unit_medical_insurance;
	}

	public void setUnitMedicalInsurance( java.math.BigDecimal value ) {
		this.__unit_medical_insurance = value;
	}

	public java.math.BigDecimal getUnitLargeMedicalInsurance() {
		return this.__unit_large_medical_insurance;
	}

	public void setUnitLargeMedicalInsurance( java.math.BigDecimal value ) {
		this.__unit_large_medical_insurance = value;
	}

	public java.math.BigDecimal getUnitInjuryInsurance() {
		return this.__unit_injury_insurance;
	}

	public void setUnitInjuryInsurance( java.math.BigDecimal value ) {
		this.__unit_injury_insurance = value;
	}

	public java.math.BigDecimal getUnitUnemploymentInsurance() {
		return this.__unit_unemployment_insurance;
	}

	public void setUnitUnemploymentInsurance( java.math.BigDecimal value ) {
		this.__unit_unemployment_insurance = value;
	}

	public java.math.BigDecimal getUnitGiveBirthInsurance() {
		return this.__unit_give_birth_insurance;
	}

	public void setUnitGiveBirthInsurance( java.math.BigDecimal value ) {
		this.__unit_give_birth_insurance = value;
	}

	public java.math.BigDecimal getPersonalPension() {
		return this.__personal_pension;
	}

	public void setPersonalPension( java.math.BigDecimal value ) {
		this.__personal_pension = value;
	}

	public java.math.BigDecimal getPersonalMedicalInsurance() {
		return this.__personal_medical_insurance;
	}

	public void setPersonalMedicalInsurance( java.math.BigDecimal value ) {
		this.__personal_medical_insurance = value;
	}

	public java.math.BigDecimal getPersonalLargeMedicalInsurance() {
		return this.__personal_large_medical_insurance;
	}

	public void setPersonalLargeMedicalInsurance( java.math.BigDecimal value ) {
		this.__personal_large_medical_insurance = value;
	}

	public java.math.BigDecimal getPersonalSeriousIllInsurance() {
		return this.__personal_serious_ill_insurance;
	}

	public void setPersonalSeriousIllInsurance( java.math.BigDecimal value ) {
		this.__personal_serious_ill_insurance = value;
	}

	public java.math.BigDecimal getPersonalUnemploymentInsurance() {
		return this.__personal_unemployment_insurance;
	}

	public void setPersonalUnemploymentInsurance( java.math.BigDecimal value ) {
		this.__personal_unemployment_insurance = value;
	}

	public java.math.BigDecimal getPersonalHeating() {
		return this.__personal_heating;
	}

	public void setPersonalHeating( java.math.BigDecimal value ) {
		this.__personal_heating = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getUnitDisabilityInsurance() {
		return this.__unit_disability_insurance;
	}

	public void setUnitDisabilityInsurance( java.math.BigDecimal value ) {
		this.__unit_disability_insurance = value;
	}

	public java.math.BigDecimal getAccumulationFundGolePaymentBase() {
		return this.__accumulation_fund_gole_payment_base;
	}

	public void setAccumulationFundGolePaymentBase( java.math.BigDecimal value ) {
		this.__accumulation_fund_gole_payment_base = value;
	}

	public java.math.BigDecimal getAccumulationFundGoleCompanyPaymentRatio() {
		return this.__accumulation_fund_gole_company_payment_ratio;
	}

	public void setAccumulationFundGoleCompanyPaymentRatio( java.math.BigDecimal value ) {
		this.__accumulation_fund_gole_company_payment_ratio = value;
	}

	public java.math.BigDecimal getAccumulationFundGoleIndividualPaymentRatio() {
		return this.__accumulation_fund_gole_individual_payment_ratio;
	}

	public void setAccumulationFundGoleIndividualPaymentRatio( java.math.BigDecimal value ) {
		this.__accumulation_fund_gole_individual_payment_ratio = value;
	}

	public java.math.BigDecimal getUnitPensionPaymentBase() {
		return this.__unit_pension_payment_base;
	}

	public void setUnitPensionPaymentBase( java.math.BigDecimal value ) {
		this.__unit_pension_payment_base = value;
	}

	public java.math.BigDecimal getUnitPensionPaymentRatio() {
		return this.__unit_pension_payment_ratio;
	}

	public void setUnitPensionPaymentRatio( java.math.BigDecimal value ) {
		this.__unit_pension_payment_ratio = value;
	}

	public java.math.BigDecimal getUnitMedicalInsurancePaymentBase() {
		return this.__unit_medical_insurance_payment_base;
	}

	public void setUnitMedicalInsurancePaymentBase( java.math.BigDecimal value ) {
		this.__unit_medical_insurance_payment_base = value;
	}

	public java.math.BigDecimal getUnitMedicalInsurancePaymentRatio() {
		return this.__unit_medical_insurance_payment_ratio;
	}

	public void setUnitMedicalInsurancePaymentRatio( java.math.BigDecimal value ) {
		this.__unit_medical_insurance_payment_ratio = value;
	}

	public java.math.BigDecimal getUnitInjuryInsuranceBase() {
		return this.__unit_injury_insurance_base;
	}

	public void setUnitInjuryInsuranceBase( java.math.BigDecimal value ) {
		this.__unit_injury_insurance_base = value;
	}

	public java.math.BigDecimal getUnitInjuryInsuranceRatio() {
		return this.__unit_injury_insurance_ratio;
	}

	public void setUnitInjuryInsuranceRatio( java.math.BigDecimal value ) {
		this.__unit_injury_insurance_ratio = value;
	}

	public java.math.BigDecimal getUnitUnemploymentInsurancePaymentBase() {
		return this.__unit_unemployment_insurance_payment_base;
	}

	public void setUnitUnemploymentInsurancePaymentBase( java.math.BigDecimal value ) {
		this.__unit_unemployment_insurance_payment_base = value;
	}

	public java.math.BigDecimal getUnitUnemploymentInsurancePaymentRatio() {
		return this.__unit_unemployment_insurance_payment_ratio;
	}

	public void setUnitUnemploymentInsurancePaymentRatio( java.math.BigDecimal value ) {
		this.__unit_unemployment_insurance_payment_ratio = value;
	}

	public java.math.BigDecimal getUnitGiveBirthInsurancePaymentBase() {
		return this.__unit_give_birth_insurance_payment_base;
	}

	public void setUnitGiveBirthInsurancePaymentBase( java.math.BigDecimal value ) {
		this.__unit_give_birth_insurance_payment_base = value;
	}

	public java.math.BigDecimal getUnitGiveBirthInsurancePaymentRatio() {
		return this.__unit_give_birth_insurance_payment_ratio;
	}

	public void setUnitGiveBirthInsurancePaymentRatio( java.math.BigDecimal value ) {
		this.__unit_give_birth_insurance_payment_ratio = value;
	}

	public java.math.BigDecimal getPersonalPensionPaymentRatio() {
		return this.__personal_pension_payment_ratio;
	}

	public void setPersonalPensionPaymentRatio( java.math.BigDecimal value ) {
		this.__personal_pension_payment_ratio = value;
	}

	public java.math.BigDecimal getPersonalMedicalInsurancePaymentRatio() {
		return this.__personal_medical_insurance_payment_ratio;
	}

	public void setPersonalMedicalInsurancePaymentRatio( java.math.BigDecimal value ) {
		this.__personal_medical_insurance_payment_ratio = value;
	}

	public java.math.BigDecimal getPersonalUnemploymentInsurancePaymentRatio() {
		return this.__personal_unemployment_insurance_payment_ratio;
	}

	public void setPersonalUnemploymentInsurancePaymentRatio( java.math.BigDecimal value ) {
		this.__personal_unemployment_insurance_payment_ratio = value;
	}

	public void cloneCopy(BaseFiveInsuranceOneGold __bean){
		__bean.setFiveInsuranceOneGoldId(getFiveInsuranceOneGoldId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setTotalFund(getTotalFund());
		__bean.setUnitTotalFund(getUnitTotalFund());
		__bean.setPersonalTotalFund(getPersonalTotalFund());
		__bean.setTotalInsurance(getTotalInsurance());
		__bean.setUnitTotalInsurance(getUnitTotalInsurance());
		__bean.setPersonalTotalInsurance(getPersonalTotalInsurance());
		__bean.setUnitPension(getUnitPension());
		__bean.setUnitMedicalInsurance(getUnitMedicalInsurance());
		__bean.setUnitLargeMedicalInsurance(getUnitLargeMedicalInsurance());
		__bean.setUnitInjuryInsurance(getUnitInjuryInsurance());
		__bean.setUnitUnemploymentInsurance(getUnitUnemploymentInsurance());
		__bean.setUnitGiveBirthInsurance(getUnitGiveBirthInsurance());
		__bean.setPersonalPension(getPersonalPension());
		__bean.setPersonalMedicalInsurance(getPersonalMedicalInsurance());
		__bean.setPersonalLargeMedicalInsurance(getPersonalLargeMedicalInsurance());
		__bean.setPersonalSeriousIllInsurance(getPersonalSeriousIllInsurance());
		__bean.setPersonalUnemploymentInsurance(getPersonalUnemploymentInsurance());
		__bean.setPersonalHeating(getPersonalHeating());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setPlateId(getPlateId());
		__bean.setUnitDisabilityInsurance(getUnitDisabilityInsurance());
		__bean.setAccumulationFundGolePaymentBase(getAccumulationFundGolePaymentBase());
		__bean.setAccumulationFundGoleCompanyPaymentRatio(getAccumulationFundGoleCompanyPaymentRatio());
		__bean.setAccumulationFundGoleIndividualPaymentRatio(getAccumulationFundGoleIndividualPaymentRatio());
		__bean.setUnitPensionPaymentBase(getUnitPensionPaymentBase());
		__bean.setUnitPensionPaymentRatio(getUnitPensionPaymentRatio());
		__bean.setUnitMedicalInsurancePaymentBase(getUnitMedicalInsurancePaymentBase());
		__bean.setUnitMedicalInsurancePaymentRatio(getUnitMedicalInsurancePaymentRatio());
		__bean.setUnitInjuryInsuranceBase(getUnitInjuryInsuranceBase());
		__bean.setUnitInjuryInsuranceRatio(getUnitInjuryInsuranceRatio());
		__bean.setUnitUnemploymentInsurancePaymentBase(getUnitUnemploymentInsurancePaymentBase());
		__bean.setUnitUnemploymentInsurancePaymentRatio(getUnitUnemploymentInsurancePaymentRatio());
		__bean.setUnitGiveBirthInsurancePaymentBase(getUnitGiveBirthInsurancePaymentBase());
		__bean.setUnitGiveBirthInsurancePaymentRatio(getUnitGiveBirthInsurancePaymentRatio());
		__bean.setPersonalPensionPaymentRatio(getPersonalPensionPaymentRatio());
		__bean.setPersonalMedicalInsurancePaymentRatio(getPersonalMedicalInsurancePaymentRatio());
		__bean.setPersonalUnemploymentInsurancePaymentRatio(getPersonalUnemploymentInsurancePaymentRatio());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFiveInsuranceOneGoldId() == null ? "" : getFiveInsuranceOneGoldId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getTotalFund() == null ? "" : getTotalFund());
		sb.append(",");
		sb.append(getUnitTotalFund() == null ? "" : getUnitTotalFund());
		sb.append(",");
		sb.append(getPersonalTotalFund() == null ? "" : getPersonalTotalFund());
		sb.append(",");
		sb.append(getTotalInsurance() == null ? "" : getTotalInsurance());
		sb.append(",");
		sb.append(getUnitTotalInsurance() == null ? "" : getUnitTotalInsurance());
		sb.append(",");
		sb.append(getPersonalTotalInsurance() == null ? "" : getPersonalTotalInsurance());
		sb.append(",");
		sb.append(getUnitPension() == null ? "" : getUnitPension());
		sb.append(",");
		sb.append(getUnitMedicalInsurance() == null ? "" : getUnitMedicalInsurance());
		sb.append(",");
		sb.append(getUnitLargeMedicalInsurance() == null ? "" : getUnitLargeMedicalInsurance());
		sb.append(",");
		sb.append(getUnitInjuryInsurance() == null ? "" : getUnitInjuryInsurance());
		sb.append(",");
		sb.append(getUnitUnemploymentInsurance() == null ? "" : getUnitUnemploymentInsurance());
		sb.append(",");
		sb.append(getUnitGiveBirthInsurance() == null ? "" : getUnitGiveBirthInsurance());
		sb.append(",");
		sb.append(getPersonalPension() == null ? "" : getPersonalPension());
		sb.append(",");
		sb.append(getPersonalMedicalInsurance() == null ? "" : getPersonalMedicalInsurance());
		sb.append(",");
		sb.append(getPersonalLargeMedicalInsurance() == null ? "" : getPersonalLargeMedicalInsurance());
		sb.append(",");
		sb.append(getPersonalSeriousIllInsurance() == null ? "" : getPersonalSeriousIllInsurance());
		sb.append(",");
		sb.append(getPersonalUnemploymentInsurance() == null ? "" : getPersonalUnemploymentInsurance());
		sb.append(",");
		sb.append(getPersonalHeating() == null ? "" : getPersonalHeating());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		String strEmployeeNo = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getEmployeeNo()));
		sb.append(strEmployeeNo == null ? "" : strEmployeeNo);
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("company_records", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getUnitDisabilityInsurance() == null ? "" : getUnitDisabilityInsurance());
		sb.append(",");
		sb.append(getAccumulationFundGolePaymentBase() == null ? "" : getAccumulationFundGolePaymentBase());
		sb.append(",");
		sb.append(getAccumulationFundGoleCompanyPaymentRatio() == null ? "" : getAccumulationFundGoleCompanyPaymentRatio());
		sb.append(",");
		sb.append(getAccumulationFundGoleIndividualPaymentRatio() == null ? "" : getAccumulationFundGoleIndividualPaymentRatio());
		sb.append(",");
		sb.append(getUnitPensionPaymentBase() == null ? "" : getUnitPensionPaymentBase());
		sb.append(",");
		sb.append(getUnitPensionPaymentRatio() == null ? "" : getUnitPensionPaymentRatio());
		sb.append(",");
		sb.append(getUnitMedicalInsurancePaymentBase() == null ? "" : getUnitMedicalInsurancePaymentBase());
		sb.append(",");
		sb.append(getUnitMedicalInsurancePaymentRatio() == null ? "" : getUnitMedicalInsurancePaymentRatio());
		sb.append(",");
		sb.append(getUnitInjuryInsuranceBase() == null ? "" : getUnitInjuryInsuranceBase());
		sb.append(",");
		sb.append(getUnitInjuryInsuranceRatio() == null ? "" : getUnitInjuryInsuranceRatio());
		sb.append(",");
		sb.append(getUnitUnemploymentInsurancePaymentBase() == null ? "" : getUnitUnemploymentInsurancePaymentBase());
		sb.append(",");
		sb.append(getUnitUnemploymentInsurancePaymentRatio() == null ? "" : getUnitUnemploymentInsurancePaymentRatio());
		sb.append(",");
		sb.append(getUnitGiveBirthInsurancePaymentBase() == null ? "" : getUnitGiveBirthInsurancePaymentBase());
		sb.append(",");
		sb.append(getUnitGiveBirthInsurancePaymentRatio() == null ? "" : getUnitGiveBirthInsurancePaymentRatio());
		sb.append(",");
		sb.append(getPersonalPensionPaymentRatio() == null ? "" : getPersonalPensionPaymentRatio());
		sb.append(",");
		sb.append(getPersonalMedicalInsurancePaymentRatio() == null ? "" : getPersonalMedicalInsurancePaymentRatio());
		sb.append(",");
		sb.append(getPersonalUnemploymentInsurancePaymentRatio() == null ? "" : getPersonalUnemploymentInsurancePaymentRatio());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFiveInsuranceOneGold o) {
		return __five_insurance_one_gold_id == null ? -1 : __five_insurance_one_gold_id.compareTo(o.getFiveInsuranceOneGoldId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__five_insurance_one_gold_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__total_fund);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__personal_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_pension);
		hash = 97 * hash + Objects.hashCode(this.__unit_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_large_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_injury_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_unemployment_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_give_birth_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_pension);
		hash = 97 * hash + Objects.hashCode(this.__personal_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_large_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_serious_ill_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_unemployment_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_heating);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__unit_disability_insurance);
		hash = 97 * hash + Objects.hashCode(this.__accumulation_fund_gole_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__accumulation_fund_gole_company_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__accumulation_fund_gole_individual_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_pension_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_pension_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_medical_insurance_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_medical_insurance_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_injury_insurance_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_injury_insurance_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_unemployment_insurance_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_unemployment_insurance_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_give_birth_insurance_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_give_birth_insurance_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__personal_pension_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__personal_medical_insurance_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__personal_unemployment_insurance_payment_ratio);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFiveInsuranceOneGold o = (BaseFiveInsuranceOneGold)obj;
		if(!Objects.equals(this.__five_insurance_one_gold_id, o.getFiveInsuranceOneGoldId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__unit_total_fund, o.getUnitTotalFund())) return false;
		if(!Objects.equals(this.__personal_total_fund, o.getPersonalTotalFund())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
		if(!Objects.equals(this.__unit_total_insurance, o.getUnitTotalInsurance())) return false;
		if(!Objects.equals(this.__personal_total_insurance, o.getPersonalTotalInsurance())) return false;
		if(!Objects.equals(this.__unit_pension, o.getUnitPension())) return false;
		if(!Objects.equals(this.__unit_medical_insurance, o.getUnitMedicalInsurance())) return false;
		if(!Objects.equals(this.__unit_large_medical_insurance, o.getUnitLargeMedicalInsurance())) return false;
		if(!Objects.equals(this.__unit_injury_insurance, o.getUnitInjuryInsurance())) return false;
		if(!Objects.equals(this.__unit_unemployment_insurance, o.getUnitUnemploymentInsurance())) return false;
		if(!Objects.equals(this.__unit_give_birth_insurance, o.getUnitGiveBirthInsurance())) return false;
		if(!Objects.equals(this.__personal_pension, o.getPersonalPension())) return false;
		if(!Objects.equals(this.__personal_medical_insurance, o.getPersonalMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_large_medical_insurance, o.getPersonalLargeMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_serious_ill_insurance, o.getPersonalSeriousIllInsurance())) return false;
		if(!Objects.equals(this.__personal_unemployment_insurance, o.getPersonalUnemploymentInsurance())) return false;
		if(!Objects.equals(this.__personal_heating, o.getPersonalHeating())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__unit_disability_insurance, o.getUnitDisabilityInsurance())) return false;
		if(!Objects.equals(this.__accumulation_fund_gole_payment_base, o.getAccumulationFundGolePaymentBase())) return false;
		if(!Objects.equals(this.__accumulation_fund_gole_company_payment_ratio, o.getAccumulationFundGoleCompanyPaymentRatio())) return false;
		if(!Objects.equals(this.__accumulation_fund_gole_individual_payment_ratio, o.getAccumulationFundGoleIndividualPaymentRatio())) return false;
		if(!Objects.equals(this.__unit_pension_payment_base, o.getUnitPensionPaymentBase())) return false;
		if(!Objects.equals(this.__unit_pension_payment_ratio, o.getUnitPensionPaymentRatio())) return false;
		if(!Objects.equals(this.__unit_medical_insurance_payment_base, o.getUnitMedicalInsurancePaymentBase())) return false;
		if(!Objects.equals(this.__unit_medical_insurance_payment_ratio, o.getUnitMedicalInsurancePaymentRatio())) return false;
		if(!Objects.equals(this.__unit_injury_insurance_base, o.getUnitInjuryInsuranceBase())) return false;
		if(!Objects.equals(this.__unit_injury_insurance_ratio, o.getUnitInjuryInsuranceRatio())) return false;
		if(!Objects.equals(this.__unit_unemployment_insurance_payment_base, o.getUnitUnemploymentInsurancePaymentBase())) return false;
		if(!Objects.equals(this.__unit_unemployment_insurance_payment_ratio, o.getUnitUnemploymentInsurancePaymentRatio())) return false;
		if(!Objects.equals(this.__unit_give_birth_insurance_payment_base, o.getUnitGiveBirthInsurancePaymentBase())) return false;
		if(!Objects.equals(this.__unit_give_birth_insurance_payment_ratio, o.getUnitGiveBirthInsurancePaymentRatio())) return false;
		if(!Objects.equals(this.__personal_pension_payment_ratio, o.getPersonalPensionPaymentRatio())) return false;
		if(!Objects.equals(this.__personal_medical_insurance_payment_ratio, o.getPersonalMedicalInsurancePaymentRatio())) return false;
		if(!Objects.equals(this.__personal_unemployment_insurance_payment_ratio, o.getPersonalUnemploymentInsurancePaymentRatio())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFiveInsuranceOneGoldId() != null) sb.append(__wrapNumber(count++, "fiveInsuranceOneGoldId", getFiveInsuranceOneGoldId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getTotalFund() != null) sb.append(__wrapDecimal(count++, "totalFund", getTotalFund()));
		if(getUnitTotalFund() != null) sb.append(__wrapDecimal(count++, "unitTotalFund", getUnitTotalFund()));
		if(getPersonalTotalFund() != null) sb.append(__wrapDecimal(count++, "personalTotalFund", getPersonalTotalFund()));
		if(getTotalInsurance() != null) sb.append(__wrapDecimal(count++, "totalInsurance", getTotalInsurance()));
		if(getUnitTotalInsurance() != null) sb.append(__wrapDecimal(count++, "unitTotalInsurance", getUnitTotalInsurance()));
		if(getPersonalTotalInsurance() != null) sb.append(__wrapDecimal(count++, "personalTotalInsurance", getPersonalTotalInsurance()));
		if(getUnitPension() != null) sb.append(__wrapDecimal(count++, "unitPension", getUnitPension()));
		if(getUnitMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "unitMedicalInsurance", getUnitMedicalInsurance()));
		if(getUnitLargeMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "unitLargeMedicalInsurance", getUnitLargeMedicalInsurance()));
		if(getUnitInjuryInsurance() != null) sb.append(__wrapDecimal(count++, "unitInjuryInsurance", getUnitInjuryInsurance()));
		if(getUnitUnemploymentInsurance() != null) sb.append(__wrapDecimal(count++, "unitUnemploymentInsurance", getUnitUnemploymentInsurance()));
		if(getUnitGiveBirthInsurance() != null) sb.append(__wrapDecimal(count++, "unitGiveBirthInsurance", getUnitGiveBirthInsurance()));
		if(getPersonalPension() != null) sb.append(__wrapDecimal(count++, "personalPension", getPersonalPension()));
		if(getPersonalMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalMedicalInsurance", getPersonalMedicalInsurance()));
		if(getPersonalLargeMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalLargeMedicalInsurance", getPersonalLargeMedicalInsurance()));
		if(getPersonalSeriousIllInsurance() != null) sb.append(__wrapDecimal(count++, "personalSeriousIllInsurance", getPersonalSeriousIllInsurance()));
		if(getPersonalUnemploymentInsurance() != null) sb.append(__wrapDecimal(count++, "personalUnemploymentInsurance", getPersonalUnemploymentInsurance()));
		if(getPersonalHeating() != null) sb.append(__wrapDecimal(count++, "personalHeating", getPersonalHeating()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getUnitDisabilityInsurance() != null) sb.append(__wrapDecimal(count++, "unitDisabilityInsurance", getUnitDisabilityInsurance()));
		if(getAccumulationFundGolePaymentBase() != null) sb.append(__wrapDecimal(count++, "accumulationFundGolePaymentBase", getAccumulationFundGolePaymentBase()));
		if(getAccumulationFundGoleCompanyPaymentRatio() != null) sb.append(__wrapDecimal(count++, "accumulationFundGoleCompanyPaymentRatio", getAccumulationFundGoleCompanyPaymentRatio()));
		if(getAccumulationFundGoleIndividualPaymentRatio() != null) sb.append(__wrapDecimal(count++, "accumulationFundGoleIndividualPaymentRatio", getAccumulationFundGoleIndividualPaymentRatio()));
		if(getUnitPensionPaymentBase() != null) sb.append(__wrapDecimal(count++, "unitPensionPaymentBase", getUnitPensionPaymentBase()));
		if(getUnitPensionPaymentRatio() != null) sb.append(__wrapDecimal(count++, "unitPensionPaymentRatio", getUnitPensionPaymentRatio()));
		if(getUnitMedicalInsurancePaymentBase() != null) sb.append(__wrapDecimal(count++, "unitMedicalInsurancePaymentBase", getUnitMedicalInsurancePaymentBase()));
		if(getUnitMedicalInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "unitMedicalInsurancePaymentRatio", getUnitMedicalInsurancePaymentRatio()));
		if(getUnitInjuryInsuranceBase() != null) sb.append(__wrapDecimal(count++, "unitInjuryInsuranceBase", getUnitInjuryInsuranceBase()));
		if(getUnitInjuryInsuranceRatio() != null) sb.append(__wrapDecimal(count++, "unitInjuryInsuranceRatio", getUnitInjuryInsuranceRatio()));
		if(getUnitUnemploymentInsurancePaymentBase() != null) sb.append(__wrapDecimal(count++, "unitUnemploymentInsurancePaymentBase", getUnitUnemploymentInsurancePaymentBase()));
		if(getUnitUnemploymentInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "unitUnemploymentInsurancePaymentRatio", getUnitUnemploymentInsurancePaymentRatio()));
		if(getUnitGiveBirthInsurancePaymentBase() != null) sb.append(__wrapDecimal(count++, "unitGiveBirthInsurancePaymentBase", getUnitGiveBirthInsurancePaymentBase()));
		if(getUnitGiveBirthInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "unitGiveBirthInsurancePaymentRatio", getUnitGiveBirthInsurancePaymentRatio()));
		if(getPersonalPensionPaymentRatio() != null) sb.append(__wrapDecimal(count++, "personalPensionPaymentRatio", getPersonalPensionPaymentRatio()));
		if(getPersonalMedicalInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "personalMedicalInsurancePaymentRatio", getPersonalMedicalInsurancePaymentRatio()));
		if(getPersonalUnemploymentInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "personalUnemploymentInsurancePaymentRatio", getPersonalUnemploymentInsurancePaymentRatio()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFiveInsuranceOneGoldId() != null) res.put("fiveInsuranceOneGoldId", getFiveInsuranceOneGoldId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getTotalFund() != null) res.put("totalFund", getTotalFund());
		if(getUnitTotalFund() != null) res.put("unitTotalFund", getUnitTotalFund());
		if(getPersonalTotalFund() != null) res.put("personalTotalFund", getPersonalTotalFund());
		if(getTotalInsurance() != null) res.put("totalInsurance", getTotalInsurance());
		if(getUnitTotalInsurance() != null) res.put("unitTotalInsurance", getUnitTotalInsurance());
		if(getPersonalTotalInsurance() != null) res.put("personalTotalInsurance", getPersonalTotalInsurance());
		if(getUnitPension() != null) res.put("unitPension", getUnitPension());
		if(getUnitMedicalInsurance() != null) res.put("unitMedicalInsurance", getUnitMedicalInsurance());
		if(getUnitLargeMedicalInsurance() != null) res.put("unitLargeMedicalInsurance", getUnitLargeMedicalInsurance());
		if(getUnitInjuryInsurance() != null) res.put("unitInjuryInsurance", getUnitInjuryInsurance());
		if(getUnitUnemploymentInsurance() != null) res.put("unitUnemploymentInsurance", getUnitUnemploymentInsurance());
		if(getUnitGiveBirthInsurance() != null) res.put("unitGiveBirthInsurance", getUnitGiveBirthInsurance());
		if(getPersonalPension() != null) res.put("personalPension", getPersonalPension());
		if(getPersonalMedicalInsurance() != null) res.put("personalMedicalInsurance", getPersonalMedicalInsurance());
		if(getPersonalLargeMedicalInsurance() != null) res.put("personalLargeMedicalInsurance", getPersonalLargeMedicalInsurance());
		if(getPersonalSeriousIllInsurance() != null) res.put("personalSeriousIllInsurance", getPersonalSeriousIllInsurance());
		if(getPersonalUnemploymentInsurance() != null) res.put("personalUnemploymentInsurance", getPersonalUnemploymentInsurance());
		if(getPersonalHeating() != null) res.put("personalHeating", getPersonalHeating());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getUnitDisabilityInsurance() != null) res.put("unitDisabilityInsurance", getUnitDisabilityInsurance());
		if(getAccumulationFundGolePaymentBase() != null) res.put("accumulationFundGolePaymentBase", getAccumulationFundGolePaymentBase());
		if(getAccumulationFundGoleCompanyPaymentRatio() != null) res.put("accumulationFundGoleCompanyPaymentRatio", getAccumulationFundGoleCompanyPaymentRatio());
		if(getAccumulationFundGoleIndividualPaymentRatio() != null) res.put("accumulationFundGoleIndividualPaymentRatio", getAccumulationFundGoleIndividualPaymentRatio());
		if(getUnitPensionPaymentBase() != null) res.put("unitPensionPaymentBase", getUnitPensionPaymentBase());
		if(getUnitPensionPaymentRatio() != null) res.put("unitPensionPaymentRatio", getUnitPensionPaymentRatio());
		if(getUnitMedicalInsurancePaymentBase() != null) res.put("unitMedicalInsurancePaymentBase", getUnitMedicalInsurancePaymentBase());
		if(getUnitMedicalInsurancePaymentRatio() != null) res.put("unitMedicalInsurancePaymentRatio", getUnitMedicalInsurancePaymentRatio());
		if(getUnitInjuryInsuranceBase() != null) res.put("unitInjuryInsuranceBase", getUnitInjuryInsuranceBase());
		if(getUnitInjuryInsuranceRatio() != null) res.put("unitInjuryInsuranceRatio", getUnitInjuryInsuranceRatio());
		if(getUnitUnemploymentInsurancePaymentBase() != null) res.put("unitUnemploymentInsurancePaymentBase", getUnitUnemploymentInsurancePaymentBase());
		if(getUnitUnemploymentInsurancePaymentRatio() != null) res.put("unitUnemploymentInsurancePaymentRatio", getUnitUnemploymentInsurancePaymentRatio());
		if(getUnitGiveBirthInsurancePaymentBase() != null) res.put("unitGiveBirthInsurancePaymentBase", getUnitGiveBirthInsurancePaymentBase());
		if(getUnitGiveBirthInsurancePaymentRatio() != null) res.put("unitGiveBirthInsurancePaymentRatio", getUnitGiveBirthInsurancePaymentRatio());
		if(getPersonalPensionPaymentRatio() != null) res.put("personalPensionPaymentRatio", getPersonalPensionPaymentRatio());
		if(getPersonalMedicalInsurancePaymentRatio() != null) res.put("personalMedicalInsurancePaymentRatio", getPersonalMedicalInsurancePaymentRatio());
		if(getPersonalUnemploymentInsurancePaymentRatio() != null) res.put("personalUnemploymentInsurancePaymentRatio", getPersonalUnemploymentInsurancePaymentRatio());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fiveInsuranceOneGoldId")) != null) setFiveInsuranceOneGoldId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("totalFund")) != null) setTotalFund(__getDecimal(val));  
		if((val = values.get("unitTotalFund")) != null) setUnitTotalFund(__getDecimal(val));  
		if((val = values.get("personalTotalFund")) != null) setPersonalTotalFund(__getDecimal(val));  
		if((val = values.get("totalInsurance")) != null) setTotalInsurance(__getDecimal(val));  
		if((val = values.get("unitTotalInsurance")) != null) setUnitTotalInsurance(__getDecimal(val));  
		if((val = values.get("personalTotalInsurance")) != null) setPersonalTotalInsurance(__getDecimal(val));  
		if((val = values.get("unitPension")) != null) setUnitPension(__getDecimal(val));  
		if((val = values.get("unitMedicalInsurance")) != null) setUnitMedicalInsurance(__getDecimal(val));  
		if((val = values.get("unitLargeMedicalInsurance")) != null) setUnitLargeMedicalInsurance(__getDecimal(val));  
		if((val = values.get("unitInjuryInsurance")) != null) setUnitInjuryInsurance(__getDecimal(val));  
		if((val = values.get("unitUnemploymentInsurance")) != null) setUnitUnemploymentInsurance(__getDecimal(val));  
		if((val = values.get("unitGiveBirthInsurance")) != null) setUnitGiveBirthInsurance(__getDecimal(val));  
		if((val = values.get("personalPension")) != null) setPersonalPension(__getDecimal(val));  
		if((val = values.get("personalMedicalInsurance")) != null) setPersonalMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalLargeMedicalInsurance")) != null) setPersonalLargeMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalSeriousIllInsurance")) != null) setPersonalSeriousIllInsurance(__getDecimal(val));  
		if((val = values.get("personalUnemploymentInsurance")) != null) setPersonalUnemploymentInsurance(__getDecimal(val));  
		if((val = values.get("personalHeating")) != null) setPersonalHeating(__getDecimal(val));  
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("unitDisabilityInsurance")) != null) setUnitDisabilityInsurance(__getDecimal(val));  
		if((val = values.get("accumulationFundGolePaymentBase")) != null) setAccumulationFundGolePaymentBase(__getDecimal(val));  
		if((val = values.get("accumulationFundGoleCompanyPaymentRatio")) != null) setAccumulationFundGoleCompanyPaymentRatio(__getDecimal(val));  
		if((val = values.get("accumulationFundGoleIndividualPaymentRatio")) != null) setAccumulationFundGoleIndividualPaymentRatio(__getDecimal(val));  
		if((val = values.get("unitPensionPaymentBase")) != null) setUnitPensionPaymentBase(__getDecimal(val));  
		if((val = values.get("unitPensionPaymentRatio")) != null) setUnitPensionPaymentRatio(__getDecimal(val));  
		if((val = values.get("unitMedicalInsurancePaymentBase")) != null) setUnitMedicalInsurancePaymentBase(__getDecimal(val));  
		if((val = values.get("unitMedicalInsurancePaymentRatio")) != null) setUnitMedicalInsurancePaymentRatio(__getDecimal(val));  
		if((val = values.get("unitInjuryInsuranceBase")) != null) setUnitInjuryInsuranceBase(__getDecimal(val));  
		if((val = values.get("unitInjuryInsuranceRatio")) != null) setUnitInjuryInsuranceRatio(__getDecimal(val));  
		if((val = values.get("unitUnemploymentInsurancePaymentBase")) != null) setUnitUnemploymentInsurancePaymentBase(__getDecimal(val));  
		if((val = values.get("unitUnemploymentInsurancePaymentRatio")) != null) setUnitUnemploymentInsurancePaymentRatio(__getDecimal(val));  
		if((val = values.get("unitGiveBirthInsurancePaymentBase")) != null) setUnitGiveBirthInsurancePaymentBase(__getDecimal(val));  
		if((val = values.get("unitGiveBirthInsurancePaymentRatio")) != null) setUnitGiveBirthInsurancePaymentRatio(__getDecimal(val));  
		if((val = values.get("personalPensionPaymentRatio")) != null) setPersonalPensionPaymentRatio(__getDecimal(val));  
		if((val = values.get("personalMedicalInsurancePaymentRatio")) != null) setPersonalMedicalInsurancePaymentRatio(__getDecimal(val));  
		if((val = values.get("personalUnemploymentInsurancePaymentRatio")) != null) setPersonalUnemploymentInsurancePaymentRatio(__getDecimal(val));  
	}

	protected java.lang.Integer  __five_insurance_one_gold_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __total_fund ;
	protected java.math.BigDecimal  __unit_total_fund ;
	protected java.math.BigDecimal  __personal_total_fund ;
	protected java.math.BigDecimal  __total_insurance ;
	protected java.math.BigDecimal  __unit_total_insurance ;
	protected java.math.BigDecimal  __personal_total_insurance ;
	protected java.math.BigDecimal  __unit_pension ;
	protected java.math.BigDecimal  __unit_medical_insurance ;
	protected java.math.BigDecimal  __unit_large_medical_insurance ;
	protected java.math.BigDecimal  __unit_injury_insurance ;
	protected java.math.BigDecimal  __unit_unemployment_insurance ;
	protected java.math.BigDecimal  __unit_give_birth_insurance ;
	protected java.math.BigDecimal  __personal_pension ;
	protected java.math.BigDecimal  __personal_medical_insurance ;
	protected java.math.BigDecimal  __personal_large_medical_insurance ;
	protected java.math.BigDecimal  __personal_serious_ill_insurance ;
	protected java.math.BigDecimal  __personal_unemployment_insurance ;
	protected java.math.BigDecimal  __personal_heating ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __unit_disability_insurance ;
	protected java.math.BigDecimal  __accumulation_fund_gole_payment_base ;
	protected java.math.BigDecimal  __accumulation_fund_gole_company_payment_ratio ;
	protected java.math.BigDecimal  __accumulation_fund_gole_individual_payment_ratio ;
	protected java.math.BigDecimal  __unit_pension_payment_base ;
	protected java.math.BigDecimal  __unit_pension_payment_ratio ;
	protected java.math.BigDecimal  __unit_medical_insurance_payment_base ;
	protected java.math.BigDecimal  __unit_medical_insurance_payment_ratio ;
	protected java.math.BigDecimal  __unit_injury_insurance_base ;
	protected java.math.BigDecimal  __unit_injury_insurance_ratio ;
	protected java.math.BigDecimal  __unit_unemployment_insurance_payment_base ;
	protected java.math.BigDecimal  __unit_unemployment_insurance_payment_ratio ;
	protected java.math.BigDecimal  __unit_give_birth_insurance_payment_base ;
	protected java.math.BigDecimal  __unit_give_birth_insurance_payment_ratio ;
	protected java.math.BigDecimal  __personal_pension_payment_ratio ;
	protected java.math.BigDecimal  __personal_medical_insurance_payment_ratio ;
	protected java.math.BigDecimal  __personal_unemployment_insurance_payment_ratio ;
}
