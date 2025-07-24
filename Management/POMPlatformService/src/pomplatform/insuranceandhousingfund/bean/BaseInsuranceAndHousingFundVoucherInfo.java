package pomplatform.insuranceandhousingfund.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseInsuranceAndHousingFundVoucherInfo extends GenericBase implements BaseFactory<BaseInsuranceAndHousingFundVoucherInfo>, Comparable<BaseInsuranceAndHousingFundVoucherInfo> 
{


	public static BaseInsuranceAndHousingFundVoucherInfo newInstance(){
		return new BaseInsuranceAndHousingFundVoucherInfo();
	}

	@Override
	public BaseInsuranceAndHousingFundVoucherInfo make(){
		BaseInsuranceAndHousingFundVoucherInfo b = new BaseInsuranceAndHousingFundVoucherInfo();
		return b;
	}

	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_DEPARTMENT_TYPE = "department_type" ;
	public final static java.lang.String CS_UNIT_PENSION = "unit_pension" ;
	public final static java.lang.String CS_UNIT_MEDICAL_INSURANCE = "unit_medical_insurance" ;
	public final static java.lang.String CS_UNIT_LARGE_MEDICAL_INSURANCE = "unit_large_medical_insurance" ;
	public final static java.lang.String CS_UNIT_INJURY_INSURANCE = "unit_injury_insurance" ;
	public final static java.lang.String CS_UNIT_UNEMPLOYMENT_INSURANCE = "unit_unemployment_insurance" ;
	public final static java.lang.String CS_UNIT_GIVE_BIRTH_INSURANCE = "unit_give_birth_insurance" ;

	public final static java.lang.String ALL_CAPTIONS = "公司,部门类型,养老保险（单位）,医疗保险（单位）,大额医疗保险（单位）,工伤保险（单位）,失业保险（单位）,生育保险（单位）";

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getDepartmentType() {
		return this.__department_type;
	}

	public void setDepartmentType( java.lang.Integer value ) {
		this.__department_type = value;
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
	
	public java.math.BigDecimal getUnitTotalFund() {
		return __unit_total_fund;
	}

	public void setUnitTotalFund(java.math.BigDecimal value) {
		this.__unit_total_fund = value;
	}

	public void cloneCopy(BaseInsuranceAndHousingFundVoucherInfo __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setDepartmentType(getDepartmentType());
		__bean.setUnitPension(getUnitPension());
		__bean.setUnitMedicalInsurance(getUnitMedicalInsurance());
		__bean.setUnitLargeMedicalInsurance(getUnitLargeMedicalInsurance());
		__bean.setUnitInjuryInsurance(getUnitInjuryInsurance());
		__bean.setUnitUnemploymentInsurance(getUnitUnemploymentInsurance());
		__bean.setUnitGiveBirthInsurance(getUnitGiveBirthInsurance());
		__bean.setUnitTotalFund(getUnitTotalFund());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getDepartmentType() == null ? "" : getDepartmentType());
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInsuranceAndHousingFundVoucherInfo o) {
		return __company_id == null ? -1 : __company_id.compareTo(o.getCompanyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__department_type);
		hash = 97 * hash + Objects.hashCode(this.__unit_pension);
		hash = 97 * hash + Objects.hashCode(this.__unit_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_large_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_injury_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_unemployment_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_give_birth_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_fund);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInsuranceAndHousingFundVoucherInfo o = (BaseInsuranceAndHousingFundVoucherInfo)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__department_type, o.getDepartmentType())) return false;
		if(!Objects.equals(this.__unit_pension, o.getUnitPension())) return false;
		if(!Objects.equals(this.__unit_medical_insurance, o.getUnitMedicalInsurance())) return false;
		if(!Objects.equals(this.__unit_large_medical_insurance, o.getUnitLargeMedicalInsurance())) return false;
		if(!Objects.equals(this.__unit_injury_insurance, o.getUnitInjuryInsurance())) return false;
		if(!Objects.equals(this.__unit_unemployment_insurance, o.getUnitUnemploymentInsurance())) return false;
		if(!Objects.equals(this.__unit_give_birth_insurance, o.getUnitGiveBirthInsurance())) return false;
		if(!Objects.equals(this.__unit_total_fund, o.getUnitTotalFund())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getDepartmentType() != null) sb.append(__wrapNumber(count++, "departmentType", getDepartmentType()));
		if(getUnitPension() != null) sb.append(__wrapDecimal(count++, "unitPension", getUnitPension()));
		if(getUnitMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "unitMedicalInsurance", getUnitMedicalInsurance()));
		if(getUnitLargeMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "unitLargeMedicalInsurance", getUnitLargeMedicalInsurance()));
		if(getUnitInjuryInsurance() != null) sb.append(__wrapDecimal(count++, "unitInjuryInsurance", getUnitInjuryInsurance()));
		if(getUnitUnemploymentInsurance() != null) sb.append(__wrapDecimal(count++, "unitUnemploymentInsurance", getUnitUnemploymentInsurance()));
		if(getUnitGiveBirthInsurance() != null) sb.append(__wrapDecimal(count++, "unitGiveBirthInsurance", getUnitGiveBirthInsurance()));
		if(getUnitTotalFund() != null) sb.append(__wrapDecimal(count++, "unitTotalFund", getUnitTotalFund()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("departmentType")) != null) setDepartmentType(__getInt(val)); 
		if((val = values.get("unitPension")) != null) setUnitPension(__getDecimal(val));  
		if((val = values.get("unitMedicalInsurance")) != null) setUnitMedicalInsurance(__getDecimal(val));  
		if((val = values.get("unitLargeMedicalInsurance")) != null) setUnitLargeMedicalInsurance(__getDecimal(val));  
		if((val = values.get("unitInjuryInsurance")) != null) setUnitInjuryInsurance(__getDecimal(val));  
		if((val = values.get("unitUnemploymentInsurance")) != null) setUnitUnemploymentInsurance(__getDecimal(val));  
		if((val = values.get("unitGiveBirthInsurance")) != null) setUnitGiveBirthInsurance(__getDecimal(val));  
		if((val = values.get("unitTotalFund")) != null) setUnitTotalFund(__getDecimal(val));  
	}

	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __department_type ;
	protected java.math.BigDecimal  __unit_pension ;
	protected java.math.BigDecimal  __unit_medical_insurance ;
	protected java.math.BigDecimal  __unit_large_medical_insurance ;
	protected java.math.BigDecimal  __unit_injury_insurance ;
	protected java.math.BigDecimal  __unit_unemployment_insurance ;
	protected java.math.BigDecimal  __unit_give_birth_insurance ;
	protected java.math.BigDecimal  __unit_total_fund;
}
