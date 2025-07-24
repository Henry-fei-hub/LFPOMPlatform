package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFiveinsuranceSummaryPlate extends GenericBase implements BaseFactory<BaseFiveinsuranceSummaryPlate>, Comparable<BaseFiveinsuranceSummaryPlate> 
{


	public static BaseFiveinsuranceSummaryPlate newInstance(){
		return new BaseFiveinsuranceSummaryPlate();
	}

	@Override
	public BaseFiveinsuranceSummaryPlate make(){
		BaseFiveinsuranceSummaryPlate b = new BaseFiveinsuranceSummaryPlate();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
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

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,月份,应缴公积金合计,单位公积金合计,个人公积金合计,应缴社保合计,单位社保合计,个人社保合计,养老保险（单位）,医疗保险（单位）,大额医疗保险（单位）,工伤保险（单位）,失业保险（单位）,生育保险（单位）,养老保险（个人）,医疗保险（个人）,大额医疗保险（个人）,大病医疗保险（个人）,失业保险（个人）,采暖（个人）";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public void cloneCopy(BaseFiveinsuranceSummaryPlate __bean){
		__bean.setPlateId(getPlateId());
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
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFiveinsuranceSummaryPlate o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFiveinsuranceSummaryPlate o = (BaseFiveinsuranceSummaryPlate)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
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
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
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
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
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
	}

	protected java.lang.Integer  __plate_id ;
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
}
