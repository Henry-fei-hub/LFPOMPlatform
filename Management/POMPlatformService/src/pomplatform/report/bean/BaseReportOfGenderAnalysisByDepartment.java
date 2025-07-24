package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOfGenderAnalysisByDepartment extends GenericBase implements BaseFactory<BaseReportOfGenderAnalysisByDepartment>, Comparable<BaseReportOfGenderAnalysisByDepartment> 
{


	public static BaseReportOfGenderAnalysisByDepartment newInstance(){
		return new BaseReportOfGenderAnalysisByDepartment();
	}

	@Override
	public BaseReportOfGenderAnalysisByDepartment make(){
		BaseReportOfGenderAnalysisByDepartment b = new BaseReportOfGenderAnalysisByDepartment();
		return b;
	}

	public final static java.lang.String CS_GENDER_PROPORTION_ID = "gender_proportion_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_MALE_PROPORTION_STR = "male_proportion_str" ;
	public final static java.lang.String CS_FEMALE_PROPORTION_STR = "female_proportion_str" ;
	public final static java.lang.String CS_MALE_JANUARY = "male_january" ;
	public final static java.lang.String CS_MALE_JANUARY_PER = "male_january_per" ;
	public final static java.lang.String CS_FEMALE_JANUARY = "female_january" ;
	public final static java.lang.String CS_FEMALE_JANUARY_PER = "female_january_per" ;
	public final static java.lang.String CS_JANUARY_TOTAL = "january_total" ;
	public final static java.lang.String CS_MALE_FEBRUARY = "male_february" ;
	public final static java.lang.String CS_MALE_FEBRUARY_PER = "male_february_per" ;
	public final static java.lang.String CS_FEMALE_FEBRUARY = "female_february" ;
	public final static java.lang.String CS_FEMALE_FEBRUARY_PER = "female_february_per" ;
	public final static java.lang.String CS_FEBRUARY_TOTAL = "february_total" ;
	public final static java.lang.String CS_MALE_MARCH = "male_march" ;
	public final static java.lang.String CS_MALE_MARCH_PER = "male_march_per" ;
	public final static java.lang.String CS_FEMALE_MARCH = "female_march" ;
	public final static java.lang.String CS_FEMALE_MARCH_PER = "female_march_per" ;
	public final static java.lang.String CS_MARCH_TOTAL = "march_total" ;
	public final static java.lang.String CS_MALE_APRIL = "male_april" ;
	public final static java.lang.String CS_MALE_APRIL_PER = "male_april_per" ;
	public final static java.lang.String CS_FEMALE_APRIL = "female_april" ;
	public final static java.lang.String CS_FEMALE_APRIL_PER = "female_april_per" ;
	public final static java.lang.String CS_APRIL_TOTAL = "april_total" ;
	public final static java.lang.String CS_MALE_MAY = "male_may" ;
	public final static java.lang.String CS_MALE_MAY_PER = "male_may_per" ;
	public final static java.lang.String CS_FEMALE_MAY = "female_may" ;
	public final static java.lang.String CS_FEMALE_MAY_PER = "female_may_per" ;
	public final static java.lang.String CS_MAY_TOTAL = "may_total" ;
	public final static java.lang.String CS_MALE_JUNE = "male_june" ;
	public final static java.lang.String CS_MALE_JUNE_PER = "male_june_per" ;
	public final static java.lang.String CS_FEMALE_JUNE = "female_june" ;
	public final static java.lang.String CS_FEMALE_JUNE_PER = "female_june_per" ;
	public final static java.lang.String CS_JUNE_TOTAL = "june_total" ;
	public final static java.lang.String CS_MALE_JULY = "male_july" ;
	public final static java.lang.String CS_MALE_JULY_PER = "male_july_per" ;
	public final static java.lang.String CS_FEMALE_JULY = "female_july" ;
	public final static java.lang.String CS_FEMALE_JULY_PER = "female_july_per" ;
	public final static java.lang.String CS_JULY_TOTAL = "july_total" ;
	public final static java.lang.String CS_MALE_AUGUST = "male_august" ;
	public final static java.lang.String CS_MALE_AUGUST_PER = "male_august_per" ;
	public final static java.lang.String CS_FEMALE_AUGUST = "female_august" ;
	public final static java.lang.String CS_FEMALE_AUGUST_PER = "female_august_per" ;
	public final static java.lang.String CS_AUGUST_TOTAL = "august_total" ;
	public final static java.lang.String CS_MALE_SEPTEMBER = "male_september" ;
	public final static java.lang.String CS_MALE_SEPTEMBER_PER = "male_september_per" ;
	public final static java.lang.String CS_FEMALE_SEPTEMBER = "female_september" ;
	public final static java.lang.String CS_FEMALE_SEPTEMBER_PER = "female_september_per" ;
	public final static java.lang.String CS_SEPTEMBER_TOTAL = "september_total" ;
	public final static java.lang.String CS_MALE_OCTOBER = "male_october" ;
	public final static java.lang.String CS_MALE_OCTOBER_PER = "male_october_per" ;
	public final static java.lang.String CS_FEMALE_OCTOBER = "female_october" ;
	public final static java.lang.String CS_FEMALE_OCTOBER_PER = "female_october_per" ;
	public final static java.lang.String CS_OCTOBER_TOTAL = "october_total" ;
	public final static java.lang.String CS_MALE_NOVEMBER = "male_november" ;
	public final static java.lang.String CS_MALE_NOVEMBER_PER = "male_november_per" ;
	public final static java.lang.String CS_FEMALE_NOVEMBER = "female_november" ;
	public final static java.lang.String CS_FEMALE_NOVEMBER_PER = "female_november_per" ;
	public final static java.lang.String CS_NOVEMBER_TOTAL = "november_total" ;
	public final static java.lang.String CS_MALE_DECEMBER = "male_december" ;
	public final static java.lang.String CS_MALE_DECEMBER_PER = "male_december_per" ;
	public final static java.lang.String CS_FEMALE_DECEMBER = "female_december" ;
	public final static java.lang.String CS_FEMALE_DECEMBER_PER = "female_december_per" ;
	public final static java.lang.String CS_DECEMBER_TOTAL = "december_total" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,归属部门,男性理想比例（显示用）,女性理想比例（显示用）,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";

	public java.lang.Integer getGenderProportionId() {
		return this.__gender_proportion_id;
	}

	public void setGenderProportionId( java.lang.Integer value ) {
		this.__gender_proportion_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getMaleProportionStr() {
		return this.__male_proportion_str;
	}

	public void setMaleProportionStr( java.lang.String value ) {
		this.__male_proportion_str = value;
	}

	public java.lang.String getFemaleProportionStr() {
		return this.__female_proportion_str;
	}

	public void setFemaleProportionStr( java.lang.String value ) {
		this.__female_proportion_str = value;
	}

	public java.math.BigDecimal getMaleJanuary() {
		return this.__male_january;
	}

	public void setMaleJanuary( java.math.BigDecimal value ) {
		this.__male_january = value;
	}

	public java.math.BigDecimal getMaleJanuaryPer() {
		return this.__male_january_per;
	}

	public void setMaleJanuaryPer( java.math.BigDecimal value ) {
		this.__male_january_per = value;
	}

	public java.math.BigDecimal getFemaleJanuary() {
		return this.__female_january;
	}

	public void setFemaleJanuary( java.math.BigDecimal value ) {
		this.__female_january = value;
	}

	public java.math.BigDecimal getFemaleJanuaryPer() {
		return this.__female_january_per;
	}

	public void setFemaleJanuaryPer( java.math.BigDecimal value ) {
		this.__female_january_per = value;
	}

	public java.math.BigDecimal getJanuaryTotal() {
		return this.__january_total;
	}

	public void setJanuaryTotal( java.math.BigDecimal value ) {
		this.__january_total = value;
	}

	public java.math.BigDecimal getMaleFebruary() {
		return this.__male_february;
	}

	public void setMaleFebruary( java.math.BigDecimal value ) {
		this.__male_february = value;
	}

	public java.math.BigDecimal getMaleFebruaryPer() {
		return this.__male_february_per;
	}

	public void setMaleFebruaryPer( java.math.BigDecimal value ) {
		this.__male_february_per = value;
	}

	public java.math.BigDecimal getFemaleFebruary() {
		return this.__female_february;
	}

	public void setFemaleFebruary( java.math.BigDecimal value ) {
		this.__female_february = value;
	}

	public java.math.BigDecimal getFemaleFebruaryPer() {
		return this.__female_february_per;
	}

	public void setFemaleFebruaryPer( java.math.BigDecimal value ) {
		this.__female_february_per = value;
	}

	public java.math.BigDecimal getFebruaryTotal() {
		return this.__february_total;
	}

	public void setFebruaryTotal( java.math.BigDecimal value ) {
		this.__february_total = value;
	}

	public java.math.BigDecimal getMaleMarch() {
		return this.__male_march;
	}

	public void setMaleMarch( java.math.BigDecimal value ) {
		this.__male_march = value;
	}

	public java.math.BigDecimal getMaleMarchPer() {
		return this.__male_march_per;
	}

	public void setMaleMarchPer( java.math.BigDecimal value ) {
		this.__male_march_per = value;
	}

	public java.math.BigDecimal getFemaleMarch() {
		return this.__female_march;
	}

	public void setFemaleMarch( java.math.BigDecimal value ) {
		this.__female_march = value;
	}

	public java.math.BigDecimal getFemaleMarchPer() {
		return this.__female_march_per;
	}

	public void setFemaleMarchPer( java.math.BigDecimal value ) {
		this.__female_march_per = value;
	}

	public java.math.BigDecimal getMarchTotal() {
		return this.__march_total;
	}

	public void setMarchTotal( java.math.BigDecimal value ) {
		this.__march_total = value;
	}

	public java.math.BigDecimal getMaleApril() {
		return this.__male_april;
	}

	public void setMaleApril( java.math.BigDecimal value ) {
		this.__male_april = value;
	}

	public java.math.BigDecimal getMaleAprilPer() {
		return this.__male_april_per;
	}

	public void setMaleAprilPer( java.math.BigDecimal value ) {
		this.__male_april_per = value;
	}

	public java.math.BigDecimal getFemaleApril() {
		return this.__female_april;
	}

	public void setFemaleApril( java.math.BigDecimal value ) {
		this.__female_april = value;
	}

	public java.math.BigDecimal getFemaleAprilPer() {
		return this.__female_april_per;
	}

	public void setFemaleAprilPer( java.math.BigDecimal value ) {
		this.__female_april_per = value;
	}

	public java.math.BigDecimal getAprilTotal() {
		return this.__april_total;
	}

	public void setAprilTotal( java.math.BigDecimal value ) {
		this.__april_total = value;
	}

	public java.math.BigDecimal getMaleMay() {
		return this.__male_may;
	}

	public void setMaleMay( java.math.BigDecimal value ) {
		this.__male_may = value;
	}

	public java.math.BigDecimal getMaleMayPer() {
		return this.__male_may_per;
	}

	public void setMaleMayPer( java.math.BigDecimal value ) {
		this.__male_may_per = value;
	}

	public java.math.BigDecimal getFemaleMay() {
		return this.__female_may;
	}

	public void setFemaleMay( java.math.BigDecimal value ) {
		this.__female_may = value;
	}

	public java.math.BigDecimal getFemaleMayPer() {
		return this.__female_may_per;
	}

	public void setFemaleMayPer( java.math.BigDecimal value ) {
		this.__female_may_per = value;
	}

	public java.math.BigDecimal getMayTotal() {
		return this.__may_total;
	}

	public void setMayTotal( java.math.BigDecimal value ) {
		this.__may_total = value;
	}

	public java.math.BigDecimal getMaleJune() {
		return this.__male_june;
	}

	public void setMaleJune( java.math.BigDecimal value ) {
		this.__male_june = value;
	}

	public java.math.BigDecimal getMaleJunePer() {
		return this.__male_june_per;
	}

	public void setMaleJunePer( java.math.BigDecimal value ) {
		this.__male_june_per = value;
	}

	public java.math.BigDecimal getFemaleJune() {
		return this.__female_june;
	}

	public void setFemaleJune( java.math.BigDecimal value ) {
		this.__female_june = value;
	}

	public java.math.BigDecimal getFemaleJunePer() {
		return this.__female_june_per;
	}

	public void setFemaleJunePer( java.math.BigDecimal value ) {
		this.__female_june_per = value;
	}

	public java.math.BigDecimal getJuneTotal() {
		return this.__june_total;
	}

	public void setJuneTotal( java.math.BigDecimal value ) {
		this.__june_total = value;
	}

	public java.math.BigDecimal getMaleJuly() {
		return this.__male_july;
	}

	public void setMaleJuly( java.math.BigDecimal value ) {
		this.__male_july = value;
	}

	public java.math.BigDecimal getMaleJulyPer() {
		return this.__male_july_per;
	}

	public void setMaleJulyPer( java.math.BigDecimal value ) {
		this.__male_july_per = value;
	}

	public java.math.BigDecimal getFemaleJuly() {
		return this.__female_july;
	}

	public void setFemaleJuly( java.math.BigDecimal value ) {
		this.__female_july = value;
	}

	public java.math.BigDecimal getFemaleJulyPer() {
		return this.__female_july_per;
	}

	public void setFemaleJulyPer( java.math.BigDecimal value ) {
		this.__female_july_per = value;
	}

	public java.math.BigDecimal getJulyTotal() {
		return this.__july_total;
	}

	public void setJulyTotal( java.math.BigDecimal value ) {
		this.__july_total = value;
	}

	public java.math.BigDecimal getMaleAugust() {
		return this.__male_august;
	}

	public void setMaleAugust( java.math.BigDecimal value ) {
		this.__male_august = value;
	}

	public java.math.BigDecimal getMaleAugustPer() {
		return this.__male_august_per;
	}

	public void setMaleAugustPer( java.math.BigDecimal value ) {
		this.__male_august_per = value;
	}

	public java.math.BigDecimal getFemaleAugust() {
		return this.__female_august;
	}

	public void setFemaleAugust( java.math.BigDecimal value ) {
		this.__female_august = value;
	}

	public java.math.BigDecimal getFemaleAugustPer() {
		return this.__female_august_per;
	}

	public void setFemaleAugustPer( java.math.BigDecimal value ) {
		this.__female_august_per = value;
	}

	public java.math.BigDecimal getAugustTotal() {
		return this.__august_total;
	}

	public void setAugustTotal( java.math.BigDecimal value ) {
		this.__august_total = value;
	}

	public java.math.BigDecimal getMaleSeptember() {
		return this.__male_september;
	}

	public void setMaleSeptember( java.math.BigDecimal value ) {
		this.__male_september = value;
	}

	public java.math.BigDecimal getMaleSeptemberPer() {
		return this.__male_september_per;
	}

	public void setMaleSeptemberPer( java.math.BigDecimal value ) {
		this.__male_september_per = value;
	}

	public java.math.BigDecimal getFemaleSeptember() {
		return this.__female_september;
	}

	public void setFemaleSeptember( java.math.BigDecimal value ) {
		this.__female_september = value;
	}

	public java.math.BigDecimal getFemaleSeptemberPer() {
		return this.__female_september_per;
	}

	public void setFemaleSeptemberPer( java.math.BigDecimal value ) {
		this.__female_september_per = value;
	}

	public java.math.BigDecimal getSeptemberTotal() {
		return this.__september_total;
	}

	public void setSeptemberTotal( java.math.BigDecimal value ) {
		this.__september_total = value;
	}

	public java.math.BigDecimal getMaleOctober() {
		return this.__male_october;
	}

	public void setMaleOctober( java.math.BigDecimal value ) {
		this.__male_october = value;
	}

	public java.math.BigDecimal getMaleOctoberPer() {
		return this.__male_october_per;
	}

	public void setMaleOctoberPer( java.math.BigDecimal value ) {
		this.__male_october_per = value;
	}

	public java.math.BigDecimal getFemaleOctober() {
		return this.__female_october;
	}

	public void setFemaleOctober( java.math.BigDecimal value ) {
		this.__female_october = value;
	}

	public java.math.BigDecimal getFemaleOctoberPer() {
		return this.__female_october_per;
	}

	public void setFemaleOctoberPer( java.math.BigDecimal value ) {
		this.__female_october_per = value;
	}

	public java.math.BigDecimal getOctoberTotal() {
		return this.__october_total;
	}

	public void setOctoberTotal( java.math.BigDecimal value ) {
		this.__october_total = value;
	}

	public java.math.BigDecimal getMaleNovember() {
		return this.__male_november;
	}

	public void setMaleNovember( java.math.BigDecimal value ) {
		this.__male_november = value;
	}

	public java.math.BigDecimal getMaleNovemberPer() {
		return this.__male_november_per;
	}

	public void setMaleNovemberPer( java.math.BigDecimal value ) {
		this.__male_november_per = value;
	}

	public java.math.BigDecimal getFemaleNovember() {
		return this.__female_november;
	}

	public void setFemaleNovember( java.math.BigDecimal value ) {
		this.__female_november = value;
	}

	public java.math.BigDecimal getFemaleNovemberPer() {
		return this.__female_november_per;
	}

	public void setFemaleNovemberPer( java.math.BigDecimal value ) {
		this.__female_november_per = value;
	}

	public java.math.BigDecimal getNovemberTotal() {
		return this.__november_total;
	}

	public void setNovemberTotal( java.math.BigDecimal value ) {
		this.__november_total = value;
	}

	public java.math.BigDecimal getMaleDecember() {
		return this.__male_december;
	}

	public void setMaleDecember( java.math.BigDecimal value ) {
		this.__male_december = value;
	}

	public java.math.BigDecimal getMaleDecemberPer() {
		return this.__male_december_per;
	}

	public void setMaleDecemberPer( java.math.BigDecimal value ) {
		this.__male_december_per = value;
	}

	public java.math.BigDecimal getFemaleDecember() {
		return this.__female_december;
	}

	public void setFemaleDecember( java.math.BigDecimal value ) {
		this.__female_december = value;
	}

	public java.math.BigDecimal getFemaleDecemberPer() {
		return this.__female_december_per;
	}

	public void setFemaleDecemberPer( java.math.BigDecimal value ) {
		this.__female_december_per = value;
	}

	public java.math.BigDecimal getDecemberTotal() {
		return this.__december_total;
	}

	public void setDecemberTotal( java.math.BigDecimal value ) {
		this.__december_total = value;
	}

	public void cloneCopy(BaseReportOfGenderAnalysisByDepartment __bean){
		__bean.setGenderProportionId(getGenderProportionId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setMaleProportionStr(getMaleProportionStr());
		__bean.setFemaleProportionStr(getFemaleProportionStr());
		__bean.setMaleJanuary(getMaleJanuary());
		__bean.setMaleJanuaryPer(getMaleJanuaryPer());
		__bean.setFemaleJanuary(getFemaleJanuary());
		__bean.setFemaleJanuaryPer(getFemaleJanuaryPer());
		__bean.setJanuaryTotal(getJanuaryTotal());
		__bean.setMaleFebruary(getMaleFebruary());
		__bean.setMaleFebruaryPer(getMaleFebruaryPer());
		__bean.setFemaleFebruary(getFemaleFebruary());
		__bean.setFemaleFebruaryPer(getFemaleFebruaryPer());
		__bean.setFebruaryTotal(getFebruaryTotal());
		__bean.setMaleMarch(getMaleMarch());
		__bean.setMaleMarchPer(getMaleMarchPer());
		__bean.setFemaleMarch(getFemaleMarch());
		__bean.setFemaleMarchPer(getFemaleMarchPer());
		__bean.setMarchTotal(getMarchTotal());
		__bean.setMaleApril(getMaleApril());
		__bean.setMaleAprilPer(getMaleAprilPer());
		__bean.setFemaleApril(getFemaleApril());
		__bean.setFemaleAprilPer(getFemaleAprilPer());
		__bean.setAprilTotal(getAprilTotal());
		__bean.setMaleMay(getMaleMay());
		__bean.setMaleMayPer(getMaleMayPer());
		__bean.setFemaleMay(getFemaleMay());
		__bean.setFemaleMayPer(getFemaleMayPer());
		__bean.setMayTotal(getMayTotal());
		__bean.setMaleJune(getMaleJune());
		__bean.setMaleJunePer(getMaleJunePer());
		__bean.setFemaleJune(getFemaleJune());
		__bean.setFemaleJunePer(getFemaleJunePer());
		__bean.setJuneTotal(getJuneTotal());
		__bean.setMaleJuly(getMaleJuly());
		__bean.setMaleJulyPer(getMaleJulyPer());
		__bean.setFemaleJuly(getFemaleJuly());
		__bean.setFemaleJulyPer(getFemaleJulyPer());
		__bean.setJulyTotal(getJulyTotal());
		__bean.setMaleAugust(getMaleAugust());
		__bean.setMaleAugustPer(getMaleAugustPer());
		__bean.setFemaleAugust(getFemaleAugust());
		__bean.setFemaleAugustPer(getFemaleAugustPer());
		__bean.setAugustTotal(getAugustTotal());
		__bean.setMaleSeptember(getMaleSeptember());
		__bean.setMaleSeptemberPer(getMaleSeptemberPer());
		__bean.setFemaleSeptember(getFemaleSeptember());
		__bean.setFemaleSeptemberPer(getFemaleSeptemberPer());
		__bean.setSeptemberTotal(getSeptemberTotal());
		__bean.setMaleOctober(getMaleOctober());
		__bean.setMaleOctoberPer(getMaleOctoberPer());
		__bean.setFemaleOctober(getFemaleOctober());
		__bean.setFemaleOctoberPer(getFemaleOctoberPer());
		__bean.setOctoberTotal(getOctoberTotal());
		__bean.setMaleNovember(getMaleNovember());
		__bean.setMaleNovemberPer(getMaleNovemberPer());
		__bean.setFemaleNovember(getFemaleNovember());
		__bean.setFemaleNovemberPer(getFemaleNovemberPer());
		__bean.setNovemberTotal(getNovemberTotal());
		__bean.setMaleDecember(getMaleDecember());
		__bean.setMaleDecemberPer(getMaleDecemberPer());
		__bean.setFemaleDecember(getFemaleDecember());
		__bean.setFemaleDecemberPer(getFemaleDecemberPer());
		__bean.setDecemberTotal(getDecemberTotal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getGenderProportionId() == null ? "" : getGenderProportionId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getMaleProportionStr() == null ? "" : getMaleProportionStr());
		sb.append(",");
		sb.append(getFemaleProportionStr() == null ? "" : getFemaleProportionStr());
		sb.append(",");
		sb.append(getMaleJanuary() == null ? "" : getMaleJanuary());
		sb.append(",");
		sb.append(getMaleJanuaryPer() == null ? "" : getMaleJanuaryPer());
		sb.append(",");
		sb.append(getFemaleJanuary() == null ? "" : getFemaleJanuary());
		sb.append(",");
		sb.append(getFemaleJanuaryPer() == null ? "" : getFemaleJanuaryPer());
		sb.append(",");
		sb.append(getJanuaryTotal() == null ? "" : getJanuaryTotal());
		sb.append(",");
		sb.append(getMaleFebruary() == null ? "" : getMaleFebruary());
		sb.append(",");
		sb.append(getMaleFebruaryPer() == null ? "" : getMaleFebruaryPer());
		sb.append(",");
		sb.append(getFemaleFebruary() == null ? "" : getFemaleFebruary());
		sb.append(",");
		sb.append(getFemaleFebruaryPer() == null ? "" : getFemaleFebruaryPer());
		sb.append(",");
		sb.append(getFebruaryTotal() == null ? "" : getFebruaryTotal());
		sb.append(",");
		sb.append(getMaleMarch() == null ? "" : getMaleMarch());
		sb.append(",");
		sb.append(getMaleMarchPer() == null ? "" : getMaleMarchPer());
		sb.append(",");
		sb.append(getFemaleMarch() == null ? "" : getFemaleMarch());
		sb.append(",");
		sb.append(getFemaleMarchPer() == null ? "" : getFemaleMarchPer());
		sb.append(",");
		sb.append(getMarchTotal() == null ? "" : getMarchTotal());
		sb.append(",");
		sb.append(getMaleApril() == null ? "" : getMaleApril());
		sb.append(",");
		sb.append(getMaleAprilPer() == null ? "" : getMaleAprilPer());
		sb.append(",");
		sb.append(getFemaleApril() == null ? "" : getFemaleApril());
		sb.append(",");
		sb.append(getFemaleAprilPer() == null ? "" : getFemaleAprilPer());
		sb.append(",");
		sb.append(getAprilTotal() == null ? "" : getAprilTotal());
		sb.append(",");
		sb.append(getMaleMay() == null ? "" : getMaleMay());
		sb.append(",");
		sb.append(getMaleMayPer() == null ? "" : getMaleMayPer());
		sb.append(",");
		sb.append(getFemaleMay() == null ? "" : getFemaleMay());
		sb.append(",");
		sb.append(getFemaleMayPer() == null ? "" : getFemaleMayPer());
		sb.append(",");
		sb.append(getMayTotal() == null ? "" : getMayTotal());
		sb.append(",");
		sb.append(getMaleJune() == null ? "" : getMaleJune());
		sb.append(",");
		sb.append(getMaleJunePer() == null ? "" : getMaleJunePer());
		sb.append(",");
		sb.append(getFemaleJune() == null ? "" : getFemaleJune());
		sb.append(",");
		sb.append(getFemaleJunePer() == null ? "" : getFemaleJunePer());
		sb.append(",");
		sb.append(getJuneTotal() == null ? "" : getJuneTotal());
		sb.append(",");
		sb.append(getMaleJuly() == null ? "" : getMaleJuly());
		sb.append(",");
		sb.append(getMaleJulyPer() == null ? "" : getMaleJulyPer());
		sb.append(",");
		sb.append(getFemaleJuly() == null ? "" : getFemaleJuly());
		sb.append(",");
		sb.append(getFemaleJulyPer() == null ? "" : getFemaleJulyPer());
		sb.append(",");
		sb.append(getJulyTotal() == null ? "" : getJulyTotal());
		sb.append(",");
		sb.append(getMaleAugust() == null ? "" : getMaleAugust());
		sb.append(",");
		sb.append(getMaleAugustPer() == null ? "" : getMaleAugustPer());
		sb.append(",");
		sb.append(getFemaleAugust() == null ? "" : getFemaleAugust());
		sb.append(",");
		sb.append(getFemaleAugustPer() == null ? "" : getFemaleAugustPer());
		sb.append(",");
		sb.append(getAugustTotal() == null ? "" : getAugustTotal());
		sb.append(",");
		sb.append(getMaleSeptember() == null ? "" : getMaleSeptember());
		sb.append(",");
		sb.append(getMaleSeptemberPer() == null ? "" : getMaleSeptemberPer());
		sb.append(",");
		sb.append(getFemaleSeptember() == null ? "" : getFemaleSeptember());
		sb.append(",");
		sb.append(getFemaleSeptemberPer() == null ? "" : getFemaleSeptemberPer());
		sb.append(",");
		sb.append(getSeptemberTotal() == null ? "" : getSeptemberTotal());
		sb.append(",");
		sb.append(getMaleOctober() == null ? "" : getMaleOctober());
		sb.append(",");
		sb.append(getMaleOctoberPer() == null ? "" : getMaleOctoberPer());
		sb.append(",");
		sb.append(getFemaleOctober() == null ? "" : getFemaleOctober());
		sb.append(",");
		sb.append(getFemaleOctoberPer() == null ? "" : getFemaleOctoberPer());
		sb.append(",");
		sb.append(getOctoberTotal() == null ? "" : getOctoberTotal());
		sb.append(",");
		sb.append(getMaleNovember() == null ? "" : getMaleNovember());
		sb.append(",");
		sb.append(getMaleNovemberPer() == null ? "" : getMaleNovemberPer());
		sb.append(",");
		sb.append(getFemaleNovember() == null ? "" : getFemaleNovember());
		sb.append(",");
		sb.append(getFemaleNovemberPer() == null ? "" : getFemaleNovemberPer());
		sb.append(",");
		sb.append(getNovemberTotal() == null ? "" : getNovemberTotal());
		sb.append(",");
		sb.append(getMaleDecember() == null ? "" : getMaleDecember());
		sb.append(",");
		sb.append(getMaleDecemberPer() == null ? "" : getMaleDecemberPer());
		sb.append(",");
		sb.append(getFemaleDecember() == null ? "" : getFemaleDecember());
		sb.append(",");
		sb.append(getFemaleDecemberPer() == null ? "" : getFemaleDecemberPer());
		sb.append(",");
		sb.append(getDecemberTotal() == null ? "" : getDecemberTotal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOfGenderAnalysisByDepartment o) {
		return __gender_proportion_id == null ? -1 : __gender_proportion_id.compareTo(o.getGenderProportionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__gender_proportion_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__male_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__female_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__male_january);
		hash = 97 * hash + Objects.hashCode(this.__male_january_per);
		hash = 97 * hash + Objects.hashCode(this.__female_january);
		hash = 97 * hash + Objects.hashCode(this.__female_january_per);
		hash = 97 * hash + Objects.hashCode(this.__january_total);
		hash = 97 * hash + Objects.hashCode(this.__male_february);
		hash = 97 * hash + Objects.hashCode(this.__male_february_per);
		hash = 97 * hash + Objects.hashCode(this.__female_february);
		hash = 97 * hash + Objects.hashCode(this.__female_february_per);
		hash = 97 * hash + Objects.hashCode(this.__february_total);
		hash = 97 * hash + Objects.hashCode(this.__male_march);
		hash = 97 * hash + Objects.hashCode(this.__male_march_per);
		hash = 97 * hash + Objects.hashCode(this.__female_march);
		hash = 97 * hash + Objects.hashCode(this.__female_march_per);
		hash = 97 * hash + Objects.hashCode(this.__march_total);
		hash = 97 * hash + Objects.hashCode(this.__male_april);
		hash = 97 * hash + Objects.hashCode(this.__male_april_per);
		hash = 97 * hash + Objects.hashCode(this.__female_april);
		hash = 97 * hash + Objects.hashCode(this.__female_april_per);
		hash = 97 * hash + Objects.hashCode(this.__april_total);
		hash = 97 * hash + Objects.hashCode(this.__male_may);
		hash = 97 * hash + Objects.hashCode(this.__male_may_per);
		hash = 97 * hash + Objects.hashCode(this.__female_may);
		hash = 97 * hash + Objects.hashCode(this.__female_may_per);
		hash = 97 * hash + Objects.hashCode(this.__may_total);
		hash = 97 * hash + Objects.hashCode(this.__male_june);
		hash = 97 * hash + Objects.hashCode(this.__male_june_per);
		hash = 97 * hash + Objects.hashCode(this.__female_june);
		hash = 97 * hash + Objects.hashCode(this.__female_june_per);
		hash = 97 * hash + Objects.hashCode(this.__june_total);
		hash = 97 * hash + Objects.hashCode(this.__male_july);
		hash = 97 * hash + Objects.hashCode(this.__male_july_per);
		hash = 97 * hash + Objects.hashCode(this.__female_july);
		hash = 97 * hash + Objects.hashCode(this.__female_july_per);
		hash = 97 * hash + Objects.hashCode(this.__july_total);
		hash = 97 * hash + Objects.hashCode(this.__male_august);
		hash = 97 * hash + Objects.hashCode(this.__male_august_per);
		hash = 97 * hash + Objects.hashCode(this.__female_august);
		hash = 97 * hash + Objects.hashCode(this.__female_august_per);
		hash = 97 * hash + Objects.hashCode(this.__august_total);
		hash = 97 * hash + Objects.hashCode(this.__male_september);
		hash = 97 * hash + Objects.hashCode(this.__male_september_per);
		hash = 97 * hash + Objects.hashCode(this.__female_september);
		hash = 97 * hash + Objects.hashCode(this.__female_september_per);
		hash = 97 * hash + Objects.hashCode(this.__september_total);
		hash = 97 * hash + Objects.hashCode(this.__male_october);
		hash = 97 * hash + Objects.hashCode(this.__male_october_per);
		hash = 97 * hash + Objects.hashCode(this.__female_october);
		hash = 97 * hash + Objects.hashCode(this.__female_october_per);
		hash = 97 * hash + Objects.hashCode(this.__october_total);
		hash = 97 * hash + Objects.hashCode(this.__male_november);
		hash = 97 * hash + Objects.hashCode(this.__male_november_per);
		hash = 97 * hash + Objects.hashCode(this.__female_november);
		hash = 97 * hash + Objects.hashCode(this.__female_november_per);
		hash = 97 * hash + Objects.hashCode(this.__november_total);
		hash = 97 * hash + Objects.hashCode(this.__male_december);
		hash = 97 * hash + Objects.hashCode(this.__male_december_per);
		hash = 97 * hash + Objects.hashCode(this.__female_december);
		hash = 97 * hash + Objects.hashCode(this.__female_december_per);
		hash = 97 * hash + Objects.hashCode(this.__december_total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOfGenderAnalysisByDepartment o = (BaseReportOfGenderAnalysisByDepartment)obj;
		if(!Objects.equals(this.__gender_proportion_id, o.getGenderProportionId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__male_proportion_str, o.getMaleProportionStr())) return false;
		if(!Objects.equals(this.__female_proportion_str, o.getFemaleProportionStr())) return false;
		if(!Objects.equals(this.__male_january, o.getMaleJanuary())) return false;
		if(!Objects.equals(this.__male_january_per, o.getMaleJanuaryPer())) return false;
		if(!Objects.equals(this.__female_january, o.getFemaleJanuary())) return false;
		if(!Objects.equals(this.__female_january_per, o.getFemaleJanuaryPer())) return false;
		if(!Objects.equals(this.__january_total, o.getJanuaryTotal())) return false;
		if(!Objects.equals(this.__male_february, o.getMaleFebruary())) return false;
		if(!Objects.equals(this.__male_february_per, o.getMaleFebruaryPer())) return false;
		if(!Objects.equals(this.__female_february, o.getFemaleFebruary())) return false;
		if(!Objects.equals(this.__female_february_per, o.getFemaleFebruaryPer())) return false;
		if(!Objects.equals(this.__february_total, o.getFebruaryTotal())) return false;
		if(!Objects.equals(this.__male_march, o.getMaleMarch())) return false;
		if(!Objects.equals(this.__male_march_per, o.getMaleMarchPer())) return false;
		if(!Objects.equals(this.__female_march, o.getFemaleMarch())) return false;
		if(!Objects.equals(this.__female_march_per, o.getFemaleMarchPer())) return false;
		if(!Objects.equals(this.__march_total, o.getMarchTotal())) return false;
		if(!Objects.equals(this.__male_april, o.getMaleApril())) return false;
		if(!Objects.equals(this.__male_april_per, o.getMaleAprilPer())) return false;
		if(!Objects.equals(this.__female_april, o.getFemaleApril())) return false;
		if(!Objects.equals(this.__female_april_per, o.getFemaleAprilPer())) return false;
		if(!Objects.equals(this.__april_total, o.getAprilTotal())) return false;
		if(!Objects.equals(this.__male_may, o.getMaleMay())) return false;
		if(!Objects.equals(this.__male_may_per, o.getMaleMayPer())) return false;
		if(!Objects.equals(this.__female_may, o.getFemaleMay())) return false;
		if(!Objects.equals(this.__female_may_per, o.getFemaleMayPer())) return false;
		if(!Objects.equals(this.__may_total, o.getMayTotal())) return false;
		if(!Objects.equals(this.__male_june, o.getMaleJune())) return false;
		if(!Objects.equals(this.__male_june_per, o.getMaleJunePer())) return false;
		if(!Objects.equals(this.__female_june, o.getFemaleJune())) return false;
		if(!Objects.equals(this.__female_june_per, o.getFemaleJunePer())) return false;
		if(!Objects.equals(this.__june_total, o.getJuneTotal())) return false;
		if(!Objects.equals(this.__male_july, o.getMaleJuly())) return false;
		if(!Objects.equals(this.__male_july_per, o.getMaleJulyPer())) return false;
		if(!Objects.equals(this.__female_july, o.getFemaleJuly())) return false;
		if(!Objects.equals(this.__female_july_per, o.getFemaleJulyPer())) return false;
		if(!Objects.equals(this.__july_total, o.getJulyTotal())) return false;
		if(!Objects.equals(this.__male_august, o.getMaleAugust())) return false;
		if(!Objects.equals(this.__male_august_per, o.getMaleAugustPer())) return false;
		if(!Objects.equals(this.__female_august, o.getFemaleAugust())) return false;
		if(!Objects.equals(this.__female_august_per, o.getFemaleAugustPer())) return false;
		if(!Objects.equals(this.__august_total, o.getAugustTotal())) return false;
		if(!Objects.equals(this.__male_september, o.getMaleSeptember())) return false;
		if(!Objects.equals(this.__male_september_per, o.getMaleSeptemberPer())) return false;
		if(!Objects.equals(this.__female_september, o.getFemaleSeptember())) return false;
		if(!Objects.equals(this.__female_september_per, o.getFemaleSeptemberPer())) return false;
		if(!Objects.equals(this.__september_total, o.getSeptemberTotal())) return false;
		if(!Objects.equals(this.__male_october, o.getMaleOctober())) return false;
		if(!Objects.equals(this.__male_october_per, o.getMaleOctoberPer())) return false;
		if(!Objects.equals(this.__female_october, o.getFemaleOctober())) return false;
		if(!Objects.equals(this.__female_october_per, o.getFemaleOctoberPer())) return false;
		if(!Objects.equals(this.__october_total, o.getOctoberTotal())) return false;
		if(!Objects.equals(this.__male_november, o.getMaleNovember())) return false;
		if(!Objects.equals(this.__male_november_per, o.getMaleNovemberPer())) return false;
		if(!Objects.equals(this.__female_november, o.getFemaleNovember())) return false;
		if(!Objects.equals(this.__female_november_per, o.getFemaleNovemberPer())) return false;
		if(!Objects.equals(this.__november_total, o.getNovemberTotal())) return false;
		if(!Objects.equals(this.__male_december, o.getMaleDecember())) return false;
		if(!Objects.equals(this.__male_december_per, o.getMaleDecemberPer())) return false;
		if(!Objects.equals(this.__female_december, o.getFemaleDecember())) return false;
		if(!Objects.equals(this.__female_december_per, o.getFemaleDecemberPer())) return false;
		if(!Objects.equals(this.__december_total, o.getDecemberTotal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getGenderProportionId() != null) sb.append(__wrapNumber(count++, "genderProportionId", getGenderProportionId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getMaleProportionStr() != null) sb.append(__wrapString(count++, "maleProportionStr", getMaleProportionStr()));
		if(getFemaleProportionStr() != null) sb.append(__wrapString(count++, "femaleProportionStr", getFemaleProportionStr()));
		if(getMaleJanuary() != null) sb.append(__wrapDecimal(count++, "maleJanuary", getMaleJanuary()));
		if(getMaleJanuaryPer() != null) sb.append(__wrapDecimal(count++, "maleJanuaryPer", getMaleJanuaryPer()));
		if(getFemaleJanuary() != null) sb.append(__wrapDecimal(count++, "femaleJanuary", getFemaleJanuary()));
		if(getFemaleJanuaryPer() != null) sb.append(__wrapDecimal(count++, "femaleJanuaryPer", getFemaleJanuaryPer()));
		if(getJanuaryTotal() != null) sb.append(__wrapDecimal(count++, "januaryTotal", getJanuaryTotal()));
		if(getMaleFebruary() != null) sb.append(__wrapDecimal(count++, "maleFebruary", getMaleFebruary()));
		if(getMaleFebruaryPer() != null) sb.append(__wrapDecimal(count++, "maleFebruaryPer", getMaleFebruaryPer()));
		if(getFemaleFebruary() != null) sb.append(__wrapDecimal(count++, "femaleFebruary", getFemaleFebruary()));
		if(getFemaleFebruaryPer() != null) sb.append(__wrapDecimal(count++, "femaleFebruaryPer", getFemaleFebruaryPer()));
		if(getFebruaryTotal() != null) sb.append(__wrapDecimal(count++, "februaryTotal", getFebruaryTotal()));
		if(getMaleMarch() != null) sb.append(__wrapDecimal(count++, "maleMarch", getMaleMarch()));
		if(getMaleMarchPer() != null) sb.append(__wrapDecimal(count++, "maleMarchPer", getMaleMarchPer()));
		if(getFemaleMarch() != null) sb.append(__wrapDecimal(count++, "femaleMarch", getFemaleMarch()));
		if(getFemaleMarchPer() != null) sb.append(__wrapDecimal(count++, "femaleMarchPer", getFemaleMarchPer()));
		if(getMarchTotal() != null) sb.append(__wrapDecimal(count++, "marchTotal", getMarchTotal()));
		if(getMaleApril() != null) sb.append(__wrapDecimal(count++, "maleApril", getMaleApril()));
		if(getMaleAprilPer() != null) sb.append(__wrapDecimal(count++, "maleAprilPer", getMaleAprilPer()));
		if(getFemaleApril() != null) sb.append(__wrapDecimal(count++, "femaleApril", getFemaleApril()));
		if(getFemaleAprilPer() != null) sb.append(__wrapDecimal(count++, "femaleAprilPer", getFemaleAprilPer()));
		if(getAprilTotal() != null) sb.append(__wrapDecimal(count++, "aprilTotal", getAprilTotal()));
		if(getMaleMay() != null) sb.append(__wrapDecimal(count++, "maleMay", getMaleMay()));
		if(getMaleMayPer() != null) sb.append(__wrapDecimal(count++, "maleMayPer", getMaleMayPer()));
		if(getFemaleMay() != null) sb.append(__wrapDecimal(count++, "femaleMay", getFemaleMay()));
		if(getFemaleMayPer() != null) sb.append(__wrapDecimal(count++, "femaleMayPer", getFemaleMayPer()));
		if(getMayTotal() != null) sb.append(__wrapDecimal(count++, "mayTotal", getMayTotal()));
		if(getMaleJune() != null) sb.append(__wrapDecimal(count++, "maleJune", getMaleJune()));
		if(getMaleJunePer() != null) sb.append(__wrapDecimal(count++, "maleJunePer", getMaleJunePer()));
		if(getFemaleJune() != null) sb.append(__wrapDecimal(count++, "femaleJune", getFemaleJune()));
		if(getFemaleJunePer() != null) sb.append(__wrapDecimal(count++, "femaleJunePer", getFemaleJunePer()));
		if(getJuneTotal() != null) sb.append(__wrapDecimal(count++, "juneTotal", getJuneTotal()));
		if(getMaleJuly() != null) sb.append(__wrapDecimal(count++, "maleJuly", getMaleJuly()));
		if(getMaleJulyPer() != null) sb.append(__wrapDecimal(count++, "maleJulyPer", getMaleJulyPer()));
		if(getFemaleJuly() != null) sb.append(__wrapDecimal(count++, "femaleJuly", getFemaleJuly()));
		if(getFemaleJulyPer() != null) sb.append(__wrapDecimal(count++, "femaleJulyPer", getFemaleJulyPer()));
		if(getJulyTotal() != null) sb.append(__wrapDecimal(count++, "julyTotal", getJulyTotal()));
		if(getMaleAugust() != null) sb.append(__wrapDecimal(count++, "maleAugust", getMaleAugust()));
		if(getMaleAugustPer() != null) sb.append(__wrapDecimal(count++, "maleAugustPer", getMaleAugustPer()));
		if(getFemaleAugust() != null) sb.append(__wrapDecimal(count++, "femaleAugust", getFemaleAugust()));
		if(getFemaleAugustPer() != null) sb.append(__wrapDecimal(count++, "femaleAugustPer", getFemaleAugustPer()));
		if(getAugustTotal() != null) sb.append(__wrapDecimal(count++, "augustTotal", getAugustTotal()));
		if(getMaleSeptember() != null) sb.append(__wrapDecimal(count++, "maleSeptember", getMaleSeptember()));
		if(getMaleSeptemberPer() != null) sb.append(__wrapDecimal(count++, "maleSeptemberPer", getMaleSeptemberPer()));
		if(getFemaleSeptember() != null) sb.append(__wrapDecimal(count++, "femaleSeptember", getFemaleSeptember()));
		if(getFemaleSeptemberPer() != null) sb.append(__wrapDecimal(count++, "femaleSeptemberPer", getFemaleSeptemberPer()));
		if(getSeptemberTotal() != null) sb.append(__wrapDecimal(count++, "septemberTotal", getSeptemberTotal()));
		if(getMaleOctober() != null) sb.append(__wrapDecimal(count++, "maleOctober", getMaleOctober()));
		if(getMaleOctoberPer() != null) sb.append(__wrapDecimal(count++, "maleOctoberPer", getMaleOctoberPer()));
		if(getFemaleOctober() != null) sb.append(__wrapDecimal(count++, "femaleOctober", getFemaleOctober()));
		if(getFemaleOctoberPer() != null) sb.append(__wrapDecimal(count++, "femaleOctoberPer", getFemaleOctoberPer()));
		if(getOctoberTotal() != null) sb.append(__wrapDecimal(count++, "octoberTotal", getOctoberTotal()));
		if(getMaleNovember() != null) sb.append(__wrapDecimal(count++, "maleNovember", getMaleNovember()));
		if(getMaleNovemberPer() != null) sb.append(__wrapDecimal(count++, "maleNovemberPer", getMaleNovemberPer()));
		if(getFemaleNovember() != null) sb.append(__wrapDecimal(count++, "femaleNovember", getFemaleNovember()));
		if(getFemaleNovemberPer() != null) sb.append(__wrapDecimal(count++, "femaleNovemberPer", getFemaleNovemberPer()));
		if(getNovemberTotal() != null) sb.append(__wrapDecimal(count++, "novemberTotal", getNovemberTotal()));
		if(getMaleDecember() != null) sb.append(__wrapDecimal(count++, "maleDecember", getMaleDecember()));
		if(getMaleDecemberPer() != null) sb.append(__wrapDecimal(count++, "maleDecemberPer", getMaleDecemberPer()));
		if(getFemaleDecember() != null) sb.append(__wrapDecimal(count++, "femaleDecember", getFemaleDecember()));
		if(getFemaleDecemberPer() != null) sb.append(__wrapDecimal(count++, "femaleDecemberPer", getFemaleDecemberPer()));
		if(getDecemberTotal() != null) sb.append(__wrapDecimal(count++, "decemberTotal", getDecemberTotal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("genderProportionId")) != null) setGenderProportionId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("maleProportionStr")) != null) setMaleProportionStr(__getString(val));
		if((val = values.get("femaleProportionStr")) != null) setFemaleProportionStr(__getString(val));
		if((val = values.get("maleJanuary")) != null) setMaleJanuary(__getDecimal(val));  
		if((val = values.get("maleJanuaryPer")) != null) setMaleJanuaryPer(__getDecimal(val));  
		if((val = values.get("femaleJanuary")) != null) setFemaleJanuary(__getDecimal(val));  
		if((val = values.get("femaleJanuaryPer")) != null) setFemaleJanuaryPer(__getDecimal(val));  
		if((val = values.get("januaryTotal")) != null) setJanuaryTotal(__getDecimal(val));  
		if((val = values.get("maleFebruary")) != null) setMaleFebruary(__getDecimal(val));  
		if((val = values.get("maleFebruaryPer")) != null) setMaleFebruaryPer(__getDecimal(val));  
		if((val = values.get("femaleFebruary")) != null) setFemaleFebruary(__getDecimal(val));  
		if((val = values.get("femaleFebruaryPer")) != null) setFemaleFebruaryPer(__getDecimal(val));  
		if((val = values.get("februaryTotal")) != null) setFebruaryTotal(__getDecimal(val));  
		if((val = values.get("maleMarch")) != null) setMaleMarch(__getDecimal(val));  
		if((val = values.get("maleMarchPer")) != null) setMaleMarchPer(__getDecimal(val));  
		if((val = values.get("femaleMarch")) != null) setFemaleMarch(__getDecimal(val));  
		if((val = values.get("femaleMarchPer")) != null) setFemaleMarchPer(__getDecimal(val));  
		if((val = values.get("marchTotal")) != null) setMarchTotal(__getDecimal(val));  
		if((val = values.get("maleApril")) != null) setMaleApril(__getDecimal(val));  
		if((val = values.get("maleAprilPer")) != null) setMaleAprilPer(__getDecimal(val));  
		if((val = values.get("femaleApril")) != null) setFemaleApril(__getDecimal(val));  
		if((val = values.get("femaleAprilPer")) != null) setFemaleAprilPer(__getDecimal(val));  
		if((val = values.get("aprilTotal")) != null) setAprilTotal(__getDecimal(val));  
		if((val = values.get("maleMay")) != null) setMaleMay(__getDecimal(val));  
		if((val = values.get("maleMayPer")) != null) setMaleMayPer(__getDecimal(val));  
		if((val = values.get("femaleMay")) != null) setFemaleMay(__getDecimal(val));  
		if((val = values.get("femaleMayPer")) != null) setFemaleMayPer(__getDecimal(val));  
		if((val = values.get("mayTotal")) != null) setMayTotal(__getDecimal(val));  
		if((val = values.get("maleJune")) != null) setMaleJune(__getDecimal(val));  
		if((val = values.get("maleJunePer")) != null) setMaleJunePer(__getDecimal(val));  
		if((val = values.get("femaleJune")) != null) setFemaleJune(__getDecimal(val));  
		if((val = values.get("femaleJunePer")) != null) setFemaleJunePer(__getDecimal(val));  
		if((val = values.get("juneTotal")) != null) setJuneTotal(__getDecimal(val));  
		if((val = values.get("maleJuly")) != null) setMaleJuly(__getDecimal(val));  
		if((val = values.get("maleJulyPer")) != null) setMaleJulyPer(__getDecimal(val));  
		if((val = values.get("femaleJuly")) != null) setFemaleJuly(__getDecimal(val));  
		if((val = values.get("femaleJulyPer")) != null) setFemaleJulyPer(__getDecimal(val));  
		if((val = values.get("julyTotal")) != null) setJulyTotal(__getDecimal(val));  
		if((val = values.get("maleAugust")) != null) setMaleAugust(__getDecimal(val));  
		if((val = values.get("maleAugustPer")) != null) setMaleAugustPer(__getDecimal(val));  
		if((val = values.get("femaleAugust")) != null) setFemaleAugust(__getDecimal(val));  
		if((val = values.get("femaleAugustPer")) != null) setFemaleAugustPer(__getDecimal(val));  
		if((val = values.get("augustTotal")) != null) setAugustTotal(__getDecimal(val));  
		if((val = values.get("maleSeptember")) != null) setMaleSeptember(__getDecimal(val));  
		if((val = values.get("maleSeptemberPer")) != null) setMaleSeptemberPer(__getDecimal(val));  
		if((val = values.get("femaleSeptember")) != null) setFemaleSeptember(__getDecimal(val));  
		if((val = values.get("femaleSeptemberPer")) != null) setFemaleSeptemberPer(__getDecimal(val));  
		if((val = values.get("septemberTotal")) != null) setSeptemberTotal(__getDecimal(val));  
		if((val = values.get("maleOctober")) != null) setMaleOctober(__getDecimal(val));  
		if((val = values.get("maleOctoberPer")) != null) setMaleOctoberPer(__getDecimal(val));  
		if((val = values.get("femaleOctober")) != null) setFemaleOctober(__getDecimal(val));  
		if((val = values.get("femaleOctoberPer")) != null) setFemaleOctoberPer(__getDecimal(val));  
		if((val = values.get("octoberTotal")) != null) setOctoberTotal(__getDecimal(val));  
		if((val = values.get("maleNovember")) != null) setMaleNovember(__getDecimal(val));  
		if((val = values.get("maleNovemberPer")) != null) setMaleNovemberPer(__getDecimal(val));  
		if((val = values.get("femaleNovember")) != null) setFemaleNovember(__getDecimal(val));  
		if((val = values.get("femaleNovemberPer")) != null) setFemaleNovemberPer(__getDecimal(val));  
		if((val = values.get("novemberTotal")) != null) setNovemberTotal(__getDecimal(val));  
		if((val = values.get("maleDecember")) != null) setMaleDecember(__getDecimal(val));  
		if((val = values.get("maleDecemberPer")) != null) setMaleDecemberPer(__getDecimal(val));  
		if((val = values.get("femaleDecember")) != null) setFemaleDecember(__getDecimal(val));  
		if((val = values.get("femaleDecemberPer")) != null) setFemaleDecemberPer(__getDecimal(val));  
		if((val = values.get("decemberTotal")) != null) setDecemberTotal(__getDecimal(val));  
	}

	protected java.lang.Integer  __gender_proportion_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __male_proportion_str ;
	protected java.lang.String  __female_proportion_str ;
	protected java.math.BigDecimal  __male_january ;
	protected java.math.BigDecimal  __male_january_per ;
	protected java.math.BigDecimal  __female_january ;
	protected java.math.BigDecimal  __female_january_per ;
	protected java.math.BigDecimal  __january_total ;
	protected java.math.BigDecimal  __male_february ;
	protected java.math.BigDecimal  __male_february_per ;
	protected java.math.BigDecimal  __female_february ;
	protected java.math.BigDecimal  __female_february_per ;
	protected java.math.BigDecimal  __february_total ;
	protected java.math.BigDecimal  __male_march ;
	protected java.math.BigDecimal  __male_march_per ;
	protected java.math.BigDecimal  __female_march ;
	protected java.math.BigDecimal  __female_march_per ;
	protected java.math.BigDecimal  __march_total ;
	protected java.math.BigDecimal  __male_april ;
	protected java.math.BigDecimal  __male_april_per ;
	protected java.math.BigDecimal  __female_april ;
	protected java.math.BigDecimal  __female_april_per ;
	protected java.math.BigDecimal  __april_total ;
	protected java.math.BigDecimal  __male_may ;
	protected java.math.BigDecimal  __male_may_per ;
	protected java.math.BigDecimal  __female_may ;
	protected java.math.BigDecimal  __female_may_per ;
	protected java.math.BigDecimal  __may_total ;
	protected java.math.BigDecimal  __male_june ;
	protected java.math.BigDecimal  __male_june_per ;
	protected java.math.BigDecimal  __female_june ;
	protected java.math.BigDecimal  __female_june_per ;
	protected java.math.BigDecimal  __june_total ;
	protected java.math.BigDecimal  __male_july ;
	protected java.math.BigDecimal  __male_july_per ;
	protected java.math.BigDecimal  __female_july ;
	protected java.math.BigDecimal  __female_july_per ;
	protected java.math.BigDecimal  __july_total ;
	protected java.math.BigDecimal  __male_august ;
	protected java.math.BigDecimal  __male_august_per ;
	protected java.math.BigDecimal  __female_august ;
	protected java.math.BigDecimal  __female_august_per ;
	protected java.math.BigDecimal  __august_total ;
	protected java.math.BigDecimal  __male_september ;
	protected java.math.BigDecimal  __male_september_per ;
	protected java.math.BigDecimal  __female_september ;
	protected java.math.BigDecimal  __female_september_per ;
	protected java.math.BigDecimal  __september_total ;
	protected java.math.BigDecimal  __male_october ;
	protected java.math.BigDecimal  __male_october_per ;
	protected java.math.BigDecimal  __female_october ;
	protected java.math.BigDecimal  __female_october_per ;
	protected java.math.BigDecimal  __october_total ;
	protected java.math.BigDecimal  __male_november ;
	protected java.math.BigDecimal  __male_november_per ;
	protected java.math.BigDecimal  __female_november ;
	protected java.math.BigDecimal  __female_november_per ;
	protected java.math.BigDecimal  __november_total ;
	protected java.math.BigDecimal  __male_december ;
	protected java.math.BigDecimal  __male_december_per ;
	protected java.math.BigDecimal  __female_december ;
	protected java.math.BigDecimal  __female_december_per ;
	protected java.math.BigDecimal  __december_total ;
}
