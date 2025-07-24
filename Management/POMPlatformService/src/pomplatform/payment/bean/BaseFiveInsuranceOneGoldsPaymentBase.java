package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFiveInsuranceOneGoldsPaymentBase extends GenericBase implements BaseFactory<BaseFiveInsuranceOneGoldsPaymentBase>, Comparable<BaseFiveInsuranceOneGoldsPaymentBase> 
{


	public static BaseFiveInsuranceOneGoldsPaymentBase newInstance(){
		return new BaseFiveInsuranceOneGoldsPaymentBase();
	}

	@Override
	public BaseFiveInsuranceOneGoldsPaymentBase make(){
		BaseFiveInsuranceOneGoldsPaymentBase b = new BaseFiveInsuranceOneGoldsPaymentBase();
		return b;
	}

	public final static String CS_FIVE_INSURANCE_ONE_GOLD_ID = "five_insurance_one_gold_id" ;
	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_COMPANY_ID = "company_id" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_YEAR = "year" ;
	public final static String CS_MONTH = "month" ;
	public final static String CS_ACCUMULATION_FUND_GOLE_PAYMENT_BASE = "accumulation_fund_gole_payment_base" ;
	public final static String CS_ACCUMULATION_FUND_GOLE_COMPANY_PAYMENT_RATIO = "accumulation_fund_gole_company_payment_ratio" ;
	public final static String CS_ACCUMULATION_FUND_GOLE_INDIVIDUAL_PAYMENT_RATIO = "accumulation_fund_gole_individual_payment_ratio" ;
	public final static String CS_UNIT_PENSION_PAYMENT_BASE = "unit_pension_payment_base" ;
	public final static String CS_UNIT_PENSION_PAYMENT_RATIO = "unit_pension_payment_ratio" ;
	public final static String CS_PERSONAL_PENSION_PAYMENT_RATIO = "personal_pension_payment_ratio" ;
	public final static String CS_UNIT_MEDICAL_INSURANCE_PAYMENT_BASE = "unit_medical_insurance_payment_base" ;
	public final static String CS_UNIT_MEDICAL_INSURANCE_PAYMENT_RATIO = "unit_medical_insurance_payment_ratio" ;
	public final static String CS_PERSONAL_MEDICAL_INSURANCE_PAYMENT_RATIO = "personal_medical_insurance_payment_ratio" ;
	public final static String CS_UNIT_UNEMPLOYMENT_INSURANCE_PAYMENT_BASE = "unit_unemployment_insurance_payment_base" ;
	public final static String CS_UNIT_UNEMPLOYMENT_INSURANCE_PAYMENT_RATIO = "unit_unemployment_insurance_payment_ratio" ;
	public final static String CS_PERSONAL_UNEMPLOYMENT_INSURANCE_PAYMENT_RATIO = "personal_unemployment_insurance_payment_ratio" ;
	public final static String CS_UNIT_INJURY_INSURANCE_BASE = "unit_injury_insurance_base" ;
	public final static String CS_UNIT_INJURY_INSURANCE_RATIO = "unit_injury_insurance_ratio" ;
	public final static String CS_UNIT_GIVE_BIRTH_INSURANCE_PAYMENT_BASE = "unit_give_birth_insurance_payment_base" ;
	public final static String CS_UNIT_GIVE_BIRTH_INSURANCE_PAYMENT_RATIO = "unit_give_birth_insurance_payment_ratio" ;

	public final static String ALL_CAPTIONS = "主键编码,员工工号,职员编码,公司名称,部门名称,组织,年份,月份,公积金缴费基数,公积金单位缴费比例,公积金个人缴费比例,养老保险缴费基数,养老保险缴费比例（单位）,养老保险缴费比例（个人）,医疗保险缴费基数,医疗保险缴费比例（单位）,医疗保险缴费比例（个人）,失业保险缴费基数,失业保险缴费比例（单位）,失业保险缴费比例（个人）,工伤保险缴费基数,工伤保险缴费比例（单位）,生育保险缴费基数,生育保险缴费比例（单位）";

	public Integer getFiveInsuranceOneGoldId() {
		return this.__five_insurance_one_gold_id;
	}

	public void setFiveInsuranceOneGoldId( Integer value ) {
		this.__five_insurance_one_gold_id = value;
	}

	public String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( String value ) {
		this.__employee_no = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( Integer value ) {
		this.__company_id = value;
	}

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
	}

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	public Integer getYear() {
		return this.__year;
	}

	public void setYear( Integer value ) {
		this.__year = value;
	}

	public Integer getMonth() {
		return this.__month;
	}

	public void setMonth( Integer value ) {
		this.__month = value;
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

	public java.math.BigDecimal getPersonalPensionPaymentRatio() {
		return this.__personal_pension_payment_ratio;
	}

	public void setPersonalPensionPaymentRatio( java.math.BigDecimal value ) {
		this.__personal_pension_payment_ratio = value;
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

	public java.math.BigDecimal getPersonalMedicalInsurancePaymentRatio() {
		return this.__personal_medical_insurance_payment_ratio;
	}

	public void setPersonalMedicalInsurancePaymentRatio( java.math.BigDecimal value ) {
		this.__personal_medical_insurance_payment_ratio = value;
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

	public java.math.BigDecimal getPersonalUnemploymentInsurancePaymentRatio() {
		return this.__personal_unemployment_insurance_payment_ratio;
	}

	public void setPersonalUnemploymentInsurancePaymentRatio( java.math.BigDecimal value ) {
		this.__personal_unemployment_insurance_payment_ratio = value;
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

	public void cloneCopy(BaseFiveInsuranceOneGoldsPaymentBase __bean){
		__bean.setFiveInsuranceOneGoldId(getFiveInsuranceOneGoldId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCompanyId(getCompanyId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setAccumulationFundGolePaymentBase(getAccumulationFundGolePaymentBase());
		__bean.setAccumulationFundGoleCompanyPaymentRatio(getAccumulationFundGoleCompanyPaymentRatio());
		__bean.setAccumulationFundGoleIndividualPaymentRatio(getAccumulationFundGoleIndividualPaymentRatio());
		__bean.setUnitPensionPaymentBase(getUnitPensionPaymentBase());
		__bean.setUnitPensionPaymentRatio(getUnitPensionPaymentRatio());
		__bean.setPersonalPensionPaymentRatio(getPersonalPensionPaymentRatio());
		__bean.setUnitMedicalInsurancePaymentBase(getUnitMedicalInsurancePaymentBase());
		__bean.setUnitMedicalInsurancePaymentRatio(getUnitMedicalInsurancePaymentRatio());
		__bean.setPersonalMedicalInsurancePaymentRatio(getPersonalMedicalInsurancePaymentRatio());
		__bean.setUnitUnemploymentInsurancePaymentBase(getUnitUnemploymentInsurancePaymentBase());
		__bean.setUnitUnemploymentInsurancePaymentRatio(getUnitUnemploymentInsurancePaymentRatio());
		__bean.setPersonalUnemploymentInsurancePaymentRatio(getPersonalUnemploymentInsurancePaymentRatio());
		__bean.setUnitInjuryInsuranceBase(getUnitInjuryInsuranceBase());
		__bean.setUnitInjuryInsuranceRatio(getUnitInjuryInsuranceRatio());
		__bean.setUnitGiveBirthInsurancePaymentBase(getUnitGiveBirthInsurancePaymentBase());
		__bean.setUnitGiveBirthInsurancePaymentRatio(getUnitGiveBirthInsurancePaymentRatio());
	}

	public String toCSVString() {

//		public final static String CS_DEPARTMENT_ID = "department_id" ;
//		public final static String CS_PLATE_ID = "plate_id" ;


		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFiveInsuranceOneGoldId() == null ? "" : getFiveInsuranceOneGoldId());
		sb.append(",");
		sb.append(getEmployeeNo());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("company_records", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");

		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");

		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
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
		sb.append(getPersonalPensionPaymentRatio() == null ? "" : getPersonalPensionPaymentRatio());
		sb.append(",");
		sb.append(getUnitMedicalInsurancePaymentBase() == null ? "" : getUnitMedicalInsurancePaymentBase());
		sb.append(",");
		sb.append(getUnitMedicalInsurancePaymentRatio() == null ? "" : getUnitMedicalInsurancePaymentRatio());
		sb.append(",");
		sb.append(getPersonalMedicalInsurancePaymentRatio() == null ? "" : getPersonalMedicalInsurancePaymentRatio());
		sb.append(",");
		sb.append(getUnitUnemploymentInsurancePaymentBase() == null ? "" : getUnitUnemploymentInsurancePaymentBase());
		sb.append(",");
		sb.append(getUnitUnemploymentInsurancePaymentRatio() == null ? "" : getUnitUnemploymentInsurancePaymentRatio());
		sb.append(",");
		sb.append(getPersonalUnemploymentInsurancePaymentRatio() == null ? "" : getPersonalUnemploymentInsurancePaymentRatio());
		sb.append(",");
		sb.append(getUnitInjuryInsuranceBase() == null ? "" : getUnitInjuryInsuranceBase());
		sb.append(",");
		sb.append(getUnitInjuryInsuranceRatio() == null ? "" : getUnitInjuryInsuranceRatio());
		sb.append(",");
		sb.append(getUnitGiveBirthInsurancePaymentBase() == null ? "" : getUnitGiveBirthInsurancePaymentBase());
		sb.append(",");
		sb.append(getUnitGiveBirthInsurancePaymentRatio() == null ? "" : getUnitGiveBirthInsurancePaymentRatio());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFiveInsuranceOneGoldsPaymentBase o) {
		return __five_insurance_one_gold_id == null ? -1 : __five_insurance_one_gold_id.compareTo(o.getFiveInsuranceOneGoldId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__five_insurance_one_gold_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__accumulation_fund_gole_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__accumulation_fund_gole_company_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__accumulation_fund_gole_individual_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_pension_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_pension_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__personal_pension_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_medical_insurance_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_medical_insurance_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__personal_medical_insurance_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_unemployment_insurance_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_unemployment_insurance_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__personal_unemployment_insurance_payment_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_injury_insurance_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_injury_insurance_ratio);
		hash = 97 * hash + Objects.hashCode(this.__unit_give_birth_insurance_payment_base);
		hash = 97 * hash + Objects.hashCode(this.__unit_give_birth_insurance_payment_ratio);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFiveInsuranceOneGoldsPaymentBase o = (BaseFiveInsuranceOneGoldsPaymentBase)obj;
		if(!Objects.equals(this.__five_insurance_one_gold_id, o.getFiveInsuranceOneGoldId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__accumulation_fund_gole_payment_base, o.getAccumulationFundGolePaymentBase())) return false;
		if(!Objects.equals(this.__accumulation_fund_gole_company_payment_ratio, o.getAccumulationFundGoleCompanyPaymentRatio())) return false;
		if(!Objects.equals(this.__accumulation_fund_gole_individual_payment_ratio, o.getAccumulationFundGoleIndividualPaymentRatio())) return false;
		if(!Objects.equals(this.__unit_pension_payment_base, o.getUnitPensionPaymentBase())) return false;
		if(!Objects.equals(this.__unit_pension_payment_ratio, o.getUnitPensionPaymentRatio())) return false;
		if(!Objects.equals(this.__personal_pension_payment_ratio, o.getPersonalPensionPaymentRatio())) return false;
		if(!Objects.equals(this.__unit_medical_insurance_payment_base, o.getUnitMedicalInsurancePaymentBase())) return false;
		if(!Objects.equals(this.__unit_medical_insurance_payment_ratio, o.getUnitMedicalInsurancePaymentRatio())) return false;
		if(!Objects.equals(this.__personal_medical_insurance_payment_ratio, o.getPersonalMedicalInsurancePaymentRatio())) return false;
		if(!Objects.equals(this.__unit_unemployment_insurance_payment_base, o.getUnitUnemploymentInsurancePaymentBase())) return false;
		if(!Objects.equals(this.__unit_unemployment_insurance_payment_ratio, o.getUnitUnemploymentInsurancePaymentRatio())) return false;
		if(!Objects.equals(this.__personal_unemployment_insurance_payment_ratio, o.getPersonalUnemploymentInsurancePaymentRatio())) return false;
		if(!Objects.equals(this.__unit_injury_insurance_base, o.getUnitInjuryInsuranceBase())) return false;
		if(!Objects.equals(this.__unit_injury_insurance_ratio, o.getUnitInjuryInsuranceRatio())) return false;
		if(!Objects.equals(this.__unit_give_birth_insurance_payment_base, o.getUnitGiveBirthInsurancePaymentBase())) return false;
		if(!Objects.equals(this.__unit_give_birth_insurance_payment_ratio, o.getUnitGiveBirthInsurancePaymentRatio())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFiveInsuranceOneGoldId() != null) sb.append(__wrapNumber(count++, "fiveInsuranceOneGoldId", getFiveInsuranceOneGoldId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getAccumulationFundGolePaymentBase() != null) sb.append(__wrapDecimal(count++, "accumulationFundGolePaymentBase", getAccumulationFundGolePaymentBase()));
		if(getAccumulationFundGoleCompanyPaymentRatio() != null) sb.append(__wrapDecimal(count++, "accumulationFundGoleCompanyPaymentRatio", getAccumulationFundGoleCompanyPaymentRatio()));
		if(getAccumulationFundGoleIndividualPaymentRatio() != null) sb.append(__wrapDecimal(count++, "accumulationFundGoleIndividualPaymentRatio", getAccumulationFundGoleIndividualPaymentRatio()));
		if(getUnitPensionPaymentBase() != null) sb.append(__wrapDecimal(count++, "unitPensionPaymentBase", getUnitPensionPaymentBase()));
		if(getUnitPensionPaymentRatio() != null) sb.append(__wrapDecimal(count++, "unitPensionPaymentRatio", getUnitPensionPaymentRatio()));
		if(getPersonalPensionPaymentRatio() != null) sb.append(__wrapDecimal(count++, "personalPensionPaymentRatio", getPersonalPensionPaymentRatio()));
		if(getUnitMedicalInsurancePaymentBase() != null) sb.append(__wrapDecimal(count++, "unitMedicalInsurancePaymentBase", getUnitMedicalInsurancePaymentBase()));
		if(getUnitMedicalInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "unitMedicalInsurancePaymentRatio", getUnitMedicalInsurancePaymentRatio()));
		if(getPersonalMedicalInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "personalMedicalInsurancePaymentRatio", getPersonalMedicalInsurancePaymentRatio()));
		if(getUnitUnemploymentInsurancePaymentBase() != null) sb.append(__wrapDecimal(count++, "unitUnemploymentInsurancePaymentBase", getUnitUnemploymentInsurancePaymentBase()));
		if(getUnitUnemploymentInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "unitUnemploymentInsurancePaymentRatio", getUnitUnemploymentInsurancePaymentRatio()));
		if(getPersonalUnemploymentInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "personalUnemploymentInsurancePaymentRatio", getPersonalUnemploymentInsurancePaymentRatio()));
		if(getUnitInjuryInsuranceBase() != null) sb.append(__wrapDecimal(count++, "unitInjuryInsuranceBase", getUnitInjuryInsuranceBase()));
		if(getUnitInjuryInsuranceRatio() != null) sb.append(__wrapDecimal(count++, "unitInjuryInsuranceRatio", getUnitInjuryInsuranceRatio()));
		if(getUnitGiveBirthInsurancePaymentBase() != null) sb.append(__wrapDecimal(count++, "unitGiveBirthInsurancePaymentBase", getUnitGiveBirthInsurancePaymentBase()));
		if(getUnitGiveBirthInsurancePaymentRatio() != null) sb.append(__wrapDecimal(count++, "unitGiveBirthInsurancePaymentRatio", getUnitGiveBirthInsurancePaymentRatio()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFiveInsuranceOneGoldId() != null) res.put("fiveInsuranceOneGoldId", getFiveInsuranceOneGoldId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getAccumulationFundGolePaymentBase() != null) res.put("accumulationFundGolePaymentBase", getAccumulationFundGolePaymentBase());
		if(getAccumulationFundGoleCompanyPaymentRatio() != null) res.put("accumulationFundGoleCompanyPaymentRatio", getAccumulationFundGoleCompanyPaymentRatio());
		if(getAccumulationFundGoleIndividualPaymentRatio() != null) res.put("accumulationFundGoleIndividualPaymentRatio", getAccumulationFundGoleIndividualPaymentRatio());
		if(getUnitPensionPaymentBase() != null) res.put("unitPensionPaymentBase", getUnitPensionPaymentBase());
		if(getUnitPensionPaymentRatio() != null) res.put("unitPensionPaymentRatio", getUnitPensionPaymentRatio());
		if(getPersonalPensionPaymentRatio() != null) res.put("personalPensionPaymentRatio", getPersonalPensionPaymentRatio());
		if(getUnitMedicalInsurancePaymentBase() != null) res.put("unitMedicalInsurancePaymentBase", getUnitMedicalInsurancePaymentBase());
		if(getUnitMedicalInsurancePaymentRatio() != null) res.put("unitMedicalInsurancePaymentRatio", getUnitMedicalInsurancePaymentRatio());
		if(getPersonalMedicalInsurancePaymentRatio() != null) res.put("personalMedicalInsurancePaymentRatio", getPersonalMedicalInsurancePaymentRatio());
		if(getUnitUnemploymentInsurancePaymentBase() != null) res.put("unitUnemploymentInsurancePaymentBase", getUnitUnemploymentInsurancePaymentBase());
		if(getUnitUnemploymentInsurancePaymentRatio() != null) res.put("unitUnemploymentInsurancePaymentRatio", getUnitUnemploymentInsurancePaymentRatio());
		if(getPersonalUnemploymentInsurancePaymentRatio() != null) res.put("personalUnemploymentInsurancePaymentRatio", getPersonalUnemploymentInsurancePaymentRatio());
		if(getUnitInjuryInsuranceBase() != null) res.put("unitInjuryInsuranceBase", getUnitInjuryInsuranceBase());
		if(getUnitInjuryInsuranceRatio() != null) res.put("unitInjuryInsuranceRatio", getUnitInjuryInsuranceRatio());
		if(getUnitGiveBirthInsurancePaymentBase() != null) res.put("unitGiveBirthInsurancePaymentBase", getUnitGiveBirthInsurancePaymentBase());
		if(getUnitGiveBirthInsurancePaymentRatio() != null) res.put("unitGiveBirthInsurancePaymentRatio", getUnitGiveBirthInsurancePaymentRatio());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fiveInsuranceOneGoldId")) != null) setFiveInsuranceOneGoldId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("accumulationFundGolePaymentBase")) != null) setAccumulationFundGolePaymentBase(__getDecimal(val));  
		if((val = values.get("accumulationFundGoleCompanyPaymentRatio")) != null) setAccumulationFundGoleCompanyPaymentRatio(__getDecimal(val));  
		if((val = values.get("accumulationFundGoleIndividualPaymentRatio")) != null) setAccumulationFundGoleIndividualPaymentRatio(__getDecimal(val));  
		if((val = values.get("unitPensionPaymentBase")) != null) setUnitPensionPaymentBase(__getDecimal(val));  
		if((val = values.get("unitPensionPaymentRatio")) != null) setUnitPensionPaymentRatio(__getDecimal(val));  
		if((val = values.get("personalPensionPaymentRatio")) != null) setPersonalPensionPaymentRatio(__getDecimal(val));  
		if((val = values.get("unitMedicalInsurancePaymentBase")) != null) setUnitMedicalInsurancePaymentBase(__getDecimal(val));  
		if((val = values.get("unitMedicalInsurancePaymentRatio")) != null) setUnitMedicalInsurancePaymentRatio(__getDecimal(val));  
		if((val = values.get("personalMedicalInsurancePaymentRatio")) != null) setPersonalMedicalInsurancePaymentRatio(__getDecimal(val));  
		if((val = values.get("unitUnemploymentInsurancePaymentBase")) != null) setUnitUnemploymentInsurancePaymentBase(__getDecimal(val));  
		if((val = values.get("unitUnemploymentInsurancePaymentRatio")) != null) setUnitUnemploymentInsurancePaymentRatio(__getDecimal(val));  
		if((val = values.get("personalUnemploymentInsurancePaymentRatio")) != null) setPersonalUnemploymentInsurancePaymentRatio(__getDecimal(val));  
		if((val = values.get("unitInjuryInsuranceBase")) != null) setUnitInjuryInsuranceBase(__getDecimal(val));  
		if((val = values.get("unitInjuryInsuranceRatio")) != null) setUnitInjuryInsuranceRatio(__getDecimal(val));  
		if((val = values.get("unitGiveBirthInsurancePaymentBase")) != null) setUnitGiveBirthInsurancePaymentBase(__getDecimal(val));  
		if((val = values.get("unitGiveBirthInsurancePaymentRatio")) != null) setUnitGiveBirthInsurancePaymentRatio(__getDecimal(val));  
	}

	protected Integer  __five_insurance_one_gold_id ;
	protected String  __employee_no ;
	protected Integer  __employee_id ;
	protected Integer  __company_id ;
	protected Integer  __department_id ;
	protected Integer  __plate_id ;
	protected Integer  __year ;
	protected Integer  __month ;
	protected java.math.BigDecimal  __accumulation_fund_gole_payment_base ;
	protected java.math.BigDecimal  __accumulation_fund_gole_company_payment_ratio ;
	protected java.math.BigDecimal  __accumulation_fund_gole_individual_payment_ratio ;
	protected java.math.BigDecimal  __unit_pension_payment_base ;
	protected java.math.BigDecimal  __unit_pension_payment_ratio ;
	protected java.math.BigDecimal  __personal_pension_payment_ratio ;
	protected java.math.BigDecimal  __unit_medical_insurance_payment_base ;
	protected java.math.BigDecimal  __unit_medical_insurance_payment_ratio ;
	protected java.math.BigDecimal  __personal_medical_insurance_payment_ratio ;
	protected java.math.BigDecimal  __unit_unemployment_insurance_payment_base ;
	protected java.math.BigDecimal  __unit_unemployment_insurance_payment_ratio ;
	protected java.math.BigDecimal  __personal_unemployment_insurance_payment_ratio ;
	protected java.math.BigDecimal  __unit_injury_insurance_base ;
	protected java.math.BigDecimal  __unit_injury_insurance_ratio ;
	protected java.math.BigDecimal  __unit_give_birth_insurance_payment_base ;
	protected java.math.BigDecimal  __unit_give_birth_insurance_payment_ratio ;
}
