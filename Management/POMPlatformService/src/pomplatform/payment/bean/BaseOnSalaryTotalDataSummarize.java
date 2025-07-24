package pomplatform.payment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnSalaryTotalDataSummarize extends GenericBase implements BaseFactory<BaseOnSalaryTotalDataSummarize>, Comparable<BaseOnSalaryTotalDataSummarize> 
{


	public static BaseOnSalaryTotalDataSummarize newInstance(){
		return new BaseOnSalaryTotalDataSummarize();
	}

	@Override
	public BaseOnSalaryTotalDataSummarize make(){
		BaseOnSalaryTotalDataSummarize b = new BaseOnSalaryTotalDataSummarize();
		return b;
	}

	public final static java.lang.String CS_STARTYEAR = "startyear" ;
	public final static java.lang.String CS_STARTMONTH = "startmonth" ;
	public final static java.lang.String CS_ENDYEAR = "endyear" ;
	public final static java.lang.String CS_ENDMONTH = "endmonth" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_MOBILE = "mobile" ;
	public final static java.lang.String CS_ONBOARD_STATUS = "onboard_status" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_POSITIVE_DATE = "positive_date" ;
	public final static java.lang.String CS_RESIGNATION_DATE = "resignation_date" ;
	public final static java.lang.String CS_CARD = "card" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_WORK_MONEY = "work_money" ;
	public final static java.lang.String CS_FILL_SEND_DEDUCT = "fill_send_deduct" ;
	public final static java.lang.String CS_JOB_SUBSIDY = "job_subsidy" ;
	public final static java.lang.String CS_ATTENDANCE_DEDUCT = "attendance_deduct" ;
	public final static java.lang.String CS_PERFORMANCE_PAY = "performance_pay" ;
	public final static java.lang.String CS_SHOULD_SALARY = "should_salary" ;
	public final static java.lang.String CS_SHOULD_BONUS = "should_bonus" ;
	public final static java.lang.String CS_SHOULD_TOTAL = "should_total" ;
	public final static java.lang.String CS_ALREADY_BONUS = "already_bonus" ;
	public final static java.lang.String CS_OTHER_BONUS = "other_bonus" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE = "should_tax_achieve" ;
	public final static java.lang.String CS_TAX_TOTAL = "tax_total" ;
	public final static java.lang.String CS_DEDUCT_TAX = "deduct_tax" ;
	public final static java.lang.String CS_SHOULD_TAX = "should_tax" ;
	public final static java.lang.String CS_TOTAL_INSURANCE = "total_insurance" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_UNIT_TOTAL_INSURANCE = "unit_total_insurance" ;
	public final static java.lang.String CS_UNIT_TOTAL_FUND = "unit_total_fund" ;
	public final static java.lang.String CS_LEAVE_NO_DEDUCT_TAX = "leave_no_deduct_tax" ;
	public final static java.lang.String CS_LEAVE_DEDUCT_TAX = "leave_deduct_tax" ;
	public final static java.lang.String CS_FACT_SALARY = "fact_salary" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT = "instead_deduct" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT_ILL = "instead_deduct_ill" ;
	public final static java.lang.String CS_PERSONAL_PENSION = "personal_pension" ;
	public final static java.lang.String CS_PERSONAL_MEDICAL_INSURANCE = "personal_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_LARGE_MEDICAL_INSURANCE = "personal_large_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_UNEMPLOYMENT_INSURANCE = "personal_unemployment_insurance" ;
	public final static java.lang.String CS_PERSONAL_HEATING = "personal_heating" ;
	public final static java.lang.String CS_PERSONAL_SERIOUS_ILL_INSURANCE = "personal_serious_ill_insurance" ;
	public final static java.lang.String CS_SPECIAL_ADDITIONAL_DUDUCT = "special_additional_duduct" ;

	public final static java.lang.String ALL_CAPTIONS = ",,,,员工编号,员工姓名,归属公司,业务部门,归属部门,手机,入职职员状态(0实习生，1试用期，2正式员工),入职日期,转正日期,离职日期,身份证号,员工id,,,,,,,,,,,,,,,,,,,,,,,,,养老保险（个人）,医疗保险（个人）,大额医疗保险（个人）,失业保险（个人）,采暖（个人）,大病医疗保险（个人）,专项附加扣除";

	public java.lang.Integer getStartyear() {
		return this.__startyear;
	}

	public void setStartyear( java.lang.Integer value ) {
		this.__startyear = value;
	}

	public java.lang.Integer getStartmonth() {
		return this.__startmonth;
	}

	public void setStartmonth( java.lang.Integer value ) {
		this.__startmonth = value;
	}

	public java.lang.Integer getEndyear() {
		return this.__endyear;
	}

	public void setEndyear( java.lang.Integer value ) {
		this.__endyear = value;
	}

	public java.lang.Integer getEndmonth() {
		return this.__endmonth;
	}

	public void setEndmonth( java.lang.Integer value ) {
		this.__endmonth = value;
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

	public java.lang.String getMobile() {
		return this.__mobile;
	}

	public void setMobile( java.lang.String value ) {
		this.__mobile = value;
	}

	public java.lang.Integer getOnboardStatus() {
		return this.__onboard_status;
	}

	public void setOnboardStatus( java.lang.Integer value ) {
		this.__onboard_status = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.util.Date getPositiveDate() {
		return this.__positive_date;
	}

	public void setPositiveDate( java.util.Date value ) {
		this.__positive_date = value;
	}

	public java.util.Date getResignationDate() {
		return this.__resignation_date;
	}

	public void setResignationDate( java.util.Date value ) {
		this.__resignation_date = value;
	}

	public java.lang.String getCard() {
		return this.__card;
	}

	public void setCard( java.lang.String value ) {
		this.__card = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getMonthBasicPay() {
		return this.__month_basic_pay;
	}

	public void setMonthBasicPay( java.math.BigDecimal value ) {
		this.__month_basic_pay = value;
	}

	public java.math.BigDecimal getWorkMoney() {
		return this.__work_money;
	}

	public void setWorkMoney( java.math.BigDecimal value ) {
		this.__work_money = value;
	}

	public java.math.BigDecimal getFillSendDeduct() {
		return this.__fill_send_deduct;
	}

	public void setFillSendDeduct( java.math.BigDecimal value ) {
		this.__fill_send_deduct = value;
	}

	public java.math.BigDecimal getJobSubsidy() {
		return this.__job_subsidy;
	}

	public void setJobSubsidy( java.math.BigDecimal value ) {
		this.__job_subsidy = value;
	}

	public java.math.BigDecimal getAttendanceDeduct() {
		return this.__attendance_deduct;
	}

	public void setAttendanceDeduct( java.math.BigDecimal value ) {
		this.__attendance_deduct = value;
	}

	public java.math.BigDecimal getPerformancePay() {
		return this.__performance_pay;
	}

	public void setPerformancePay( java.math.BigDecimal value ) {
		this.__performance_pay = value;
	}

	public java.math.BigDecimal getShouldSalary() {
		return this.__should_salary;
	}

	public void setShouldSalary( java.math.BigDecimal value ) {
		this.__should_salary = value;
	}

	public java.math.BigDecimal getShouldBonus() {
		return this.__should_bonus;
	}

	public void setShouldBonus( java.math.BigDecimal value ) {
		this.__should_bonus = value;
	}

	public java.math.BigDecimal getShouldTotal() {
		return this.__should_total;
	}

	public void setShouldTotal( java.math.BigDecimal value ) {
		this.__should_total = value;
	}

	public java.math.BigDecimal getAlreadyBonus() {
		return this.__already_bonus;
	}

	public void setAlreadyBonus( java.math.BigDecimal value ) {
		this.__already_bonus = value;
	}

	public java.math.BigDecimal getOtherBonus() {
		return this.__other_bonus;
	}

	public void setOtherBonus( java.math.BigDecimal value ) {
		this.__other_bonus = value;
	}

	public java.math.BigDecimal getShouldTaxAchieve() {
		return this.__should_tax_achieve;
	}

	public void setShouldTaxAchieve( java.math.BigDecimal value ) {
		this.__should_tax_achieve = value;
	}

	public java.math.BigDecimal getTaxTotal() {
		return this.__tax_total;
	}

	public void setTaxTotal( java.math.BigDecimal value ) {
		this.__tax_total = value;
	}

	public java.math.BigDecimal getDeductTax() {
		return this.__deduct_tax;
	}

	public void setDeductTax( java.math.BigDecimal value ) {
		this.__deduct_tax = value;
	}

	public java.math.BigDecimal getShouldTax() {
		return this.__should_tax;
	}

	public void setShouldTax( java.math.BigDecimal value ) {
		this.__should_tax = value;
	}

	public java.math.BigDecimal getTotalInsurance() {
		return this.__total_insurance;
	}

	public void setTotalInsurance( java.math.BigDecimal value ) {
		this.__total_insurance = value;
	}

	public java.math.BigDecimal getTotalFund() {
		return this.__total_fund;
	}

	public void setTotalFund( java.math.BigDecimal value ) {
		this.__total_fund = value;
	}

	public java.math.BigDecimal getUnitTotalInsurance() {
		return this.__unit_total_insurance;
	}

	public void setUnitTotalInsurance( java.math.BigDecimal value ) {
		this.__unit_total_insurance = value;
	}

	public java.math.BigDecimal getUnitTotalFund() {
		return this.__unit_total_fund;
	}

	public void setUnitTotalFund( java.math.BigDecimal value ) {
		this.__unit_total_fund = value;
	}

	public java.math.BigDecimal getLeaveNoDeductTax() {
		return this.__leave_no_deduct_tax;
	}

	public void setLeaveNoDeductTax( java.math.BigDecimal value ) {
		this.__leave_no_deduct_tax = value;
	}

	public java.math.BigDecimal getLeaveDeductTax() {
		return this.__leave_deduct_tax;
	}

	public void setLeaveDeductTax( java.math.BigDecimal value ) {
		this.__leave_deduct_tax = value;
	}

	public java.math.BigDecimal getFactSalary() {
		return this.__fact_salary;
	}

	public void setFactSalary( java.math.BigDecimal value ) {
		this.__fact_salary = value;
	}

	public java.math.BigDecimal getInsteadDeduct() {
		return this.__instead_deduct;
	}

	public void setInsteadDeduct( java.math.BigDecimal value ) {
		this.__instead_deduct = value;
	}

	public java.math.BigDecimal getInsteadDeductIll() {
		return this.__instead_deduct_ill;
	}

	public void setInsteadDeductIll( java.math.BigDecimal value ) {
		this.__instead_deduct_ill = value;
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

	public java.math.BigDecimal getPersonalSeriousIllInsurance() {
		return this.__personal_serious_ill_insurance;
	}

	public void setPersonalSeriousIllInsurance( java.math.BigDecimal value ) {
		this.__personal_serious_ill_insurance = value;
	}

	public java.math.BigDecimal getSpecialAdditionalDuduct() {
		return this.__special_additional_duduct;
	}

	public void setSpecialAdditionalDuduct( java.math.BigDecimal value ) {
		this.__special_additional_duduct = value;
	}

	public void cloneCopy(BaseOnSalaryTotalDataSummarize __bean){
		__bean.setStartyear(getStartyear());
		__bean.setStartmonth(getStartmonth());
		__bean.setEndyear(getEndyear());
		__bean.setEndmonth(getEndmonth());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setMobile(getMobile());
		__bean.setOnboardStatus(getOnboardStatus());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setPositiveDate(getPositiveDate());
		__bean.setResignationDate(getResignationDate());
		__bean.setCard(getCard());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setWorkMoney(getWorkMoney());
		__bean.setFillSendDeduct(getFillSendDeduct());
		__bean.setJobSubsidy(getJobSubsidy());
		__bean.setAttendanceDeduct(getAttendanceDeduct());
		__bean.setPerformancePay(getPerformancePay());
		__bean.setShouldSalary(getShouldSalary());
		__bean.setShouldBonus(getShouldBonus());
		__bean.setShouldTotal(getShouldTotal());
		__bean.setAlreadyBonus(getAlreadyBonus());
		__bean.setOtherBonus(getOtherBonus());
		__bean.setShouldTaxAchieve(getShouldTaxAchieve());
		__bean.setTaxTotal(getTaxTotal());
		__bean.setDeductTax(getDeductTax());
		__bean.setShouldTax(getShouldTax());
		__bean.setTotalInsurance(getTotalInsurance());
		__bean.setTotalFund(getTotalFund());
		__bean.setUnitTotalInsurance(getUnitTotalInsurance());
		__bean.setUnitTotalFund(getUnitTotalFund());
		__bean.setLeaveNoDeductTax(getLeaveNoDeductTax());
		__bean.setLeaveDeductTax(getLeaveDeductTax());
		__bean.setFactSalary(getFactSalary());
		__bean.setInsteadDeduct(getInsteadDeduct());
		__bean.setInsteadDeductIll(getInsteadDeductIll());
		__bean.setPersonalPension(getPersonalPension());
		__bean.setPersonalMedicalInsurance(getPersonalMedicalInsurance());
		__bean.setPersonalLargeMedicalInsurance(getPersonalLargeMedicalInsurance());
		__bean.setPersonalUnemploymentInsurance(getPersonalUnemploymentInsurance());
		__bean.setPersonalHeating(getPersonalHeating());
		__bean.setPersonalSeriousIllInsurance(getPersonalSeriousIllInsurance());
		__bean.setSpecialAdditionalDuduct(getSpecialAdditionalDuduct());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getStartyear() == null ? "" : getStartyear());
		sb.append(",");
		sb.append(getStartmonth() == null ? "" : getStartmonth());
		sb.append(",");
		sb.append(getEndyear() == null ? "" : getEndyear());
		sb.append(",");
		sb.append(getEndmonth() == null ? "" : getEndmonth());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getMobile() == null ? "" : getMobile());
		sb.append(",");
		sb.append(getOnboardStatus() == null ? "" : getOnboardStatus());
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getPositiveDate() == null ? "" : sdf.format(getPositiveDate()));
		sb.append(",");
		sb.append(getResignationDate() == null ? "" : sdf.format(getResignationDate()));
		sb.append(",");
		sb.append(getCard() == null ? "" : getCard());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getMonthBasicPay() == null ? "" : getMonthBasicPay());
		sb.append(",");
		sb.append(getWorkMoney() == null ? "" : getWorkMoney());
		sb.append(",");
		sb.append(getFillSendDeduct() == null ? "" : getFillSendDeduct());
		sb.append(",");
		sb.append(getJobSubsidy() == null ? "" : getJobSubsidy());
		sb.append(",");
		sb.append(getAttendanceDeduct() == null ? "" : getAttendanceDeduct());
		sb.append(",");
		sb.append(getPerformancePay() == null ? "" : getPerformancePay());
		sb.append(",");
		sb.append(getShouldSalary() == null ? "" : getShouldSalary());
		sb.append(",");
		sb.append(getShouldBonus() == null ? "" : getShouldBonus());
		sb.append(",");
		sb.append(getShouldTotal() == null ? "" : getShouldTotal());
		sb.append(",");
		sb.append(getAlreadyBonus() == null ? "" : getAlreadyBonus());
		sb.append(",");
		sb.append(getOtherBonus() == null ? "" : getOtherBonus());
		sb.append(",");
		sb.append(getShouldTaxAchieve() == null ? "" : getShouldTaxAchieve());
		sb.append(",");
		sb.append(getTaxTotal() == null ? "" : getTaxTotal());
		sb.append(",");
		sb.append(getDeductTax() == null ? "" : getDeductTax());
		sb.append(",");
		sb.append(getShouldTax() == null ? "" : getShouldTax());
		sb.append(",");
		sb.append(getTotalInsurance() == null ? "" : getTotalInsurance());
		sb.append(",");
		sb.append(getTotalFund() == null ? "" : getTotalFund());
		sb.append(",");
		sb.append(getUnitTotalInsurance() == null ? "" : getUnitTotalInsurance());
		sb.append(",");
		sb.append(getUnitTotalFund() == null ? "" : getUnitTotalFund());
		sb.append(",");
		sb.append(getLeaveNoDeductTax() == null ? "" : getLeaveNoDeductTax());
		sb.append(",");
		sb.append(getLeaveDeductTax() == null ? "" : getLeaveDeductTax());
		sb.append(",");
		sb.append(getFactSalary() == null ? "" : getFactSalary());
		sb.append(",");
		sb.append(getInsteadDeduct() == null ? "" : getInsteadDeduct());
		sb.append(",");
		sb.append(getInsteadDeductIll() == null ? "" : getInsteadDeductIll());
		sb.append(",");
		sb.append(getPersonalPension() == null ? "" : getPersonalPension());
		sb.append(",");
		sb.append(getPersonalMedicalInsurance() == null ? "" : getPersonalMedicalInsurance());
		sb.append(",");
		sb.append(getPersonalLargeMedicalInsurance() == null ? "" : getPersonalLargeMedicalInsurance());
		sb.append(",");
		sb.append(getPersonalUnemploymentInsurance() == null ? "" : getPersonalUnemploymentInsurance());
		sb.append(",");
		sb.append(getPersonalHeating() == null ? "" : getPersonalHeating());
		sb.append(",");
		sb.append(getPersonalSeriousIllInsurance() == null ? "" : getPersonalSeriousIllInsurance());
		sb.append(",");
		sb.append(getSpecialAdditionalDuduct() == null ? "" : getSpecialAdditionalDuduct());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnSalaryTotalDataSummarize o) {
		return __startyear == null ? -1 : __startyear.compareTo(o.getStartyear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__startyear);
		hash = 97 * hash + Objects.hashCode(this.__startmonth);
		hash = 97 * hash + Objects.hashCode(this.__endyear);
		hash = 97 * hash + Objects.hashCode(this.__endmonth);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__onboard_status);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__positive_date);
		hash = 97 * hash + Objects.hashCode(this.__resignation_date);
		hash = 97 * hash + Objects.hashCode(this.__card);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__work_money);
		hash = 97 * hash + Objects.hashCode(this.__fill_send_deduct);
		hash = 97 * hash + Objects.hashCode(this.__job_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__attendance_deduct);
		hash = 97 * hash + Objects.hashCode(this.__performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__should_salary);
		hash = 97 * hash + Objects.hashCode(this.__should_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_total);
		hash = 97 * hash + Objects.hashCode(this.__already_bonus);
		hash = 97 * hash + Objects.hashCode(this.__other_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_tax_achieve);
		hash = 97 * hash + Objects.hashCode(this.__tax_total);
		hash = 97 * hash + Objects.hashCode(this.__deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__should_tax);
		hash = 97 * hash + Objects.hashCode(this.__total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__total_fund);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__leave_no_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__leave_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__fact_salary);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct_ill);
		hash = 97 * hash + Objects.hashCode(this.__personal_pension);
		hash = 97 * hash + Objects.hashCode(this.__personal_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_large_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_unemployment_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_heating);
		hash = 97 * hash + Objects.hashCode(this.__personal_serious_ill_insurance);
		hash = 97 * hash + Objects.hashCode(this.__special_additional_duduct);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnSalaryTotalDataSummarize o = (BaseOnSalaryTotalDataSummarize)obj;
		if(!Objects.equals(this.__startyear, o.getStartyear())) return false;
		if(!Objects.equals(this.__startmonth, o.getStartmonth())) return false;
		if(!Objects.equals(this.__endyear, o.getEndyear())) return false;
		if(!Objects.equals(this.__endmonth, o.getEndmonth())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__onboard_status, o.getOnboardStatus())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__positive_date, o.getPositiveDate())) return false;
		if(!Objects.equals(this.__resignation_date, o.getResignationDate())) return false;
		if(!Objects.equals(this.__card, o.getCard())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__work_money, o.getWorkMoney())) return false;
		if(!Objects.equals(this.__fill_send_deduct, o.getFillSendDeduct())) return false;
		if(!Objects.equals(this.__job_subsidy, o.getJobSubsidy())) return false;
		if(!Objects.equals(this.__attendance_deduct, o.getAttendanceDeduct())) return false;
		if(!Objects.equals(this.__performance_pay, o.getPerformancePay())) return false;
		if(!Objects.equals(this.__should_salary, o.getShouldSalary())) return false;
		if(!Objects.equals(this.__should_bonus, o.getShouldBonus())) return false;
		if(!Objects.equals(this.__should_total, o.getShouldTotal())) return false;
		if(!Objects.equals(this.__already_bonus, o.getAlreadyBonus())) return false;
		if(!Objects.equals(this.__other_bonus, o.getOtherBonus())) return false;
		if(!Objects.equals(this.__should_tax_achieve, o.getShouldTaxAchieve())) return false;
		if(!Objects.equals(this.__tax_total, o.getTaxTotal())) return false;
		if(!Objects.equals(this.__deduct_tax, o.getDeductTax())) return false;
		if(!Objects.equals(this.__should_tax, o.getShouldTax())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__unit_total_insurance, o.getUnitTotalInsurance())) return false;
		if(!Objects.equals(this.__unit_total_fund, o.getUnitTotalFund())) return false;
		if(!Objects.equals(this.__leave_no_deduct_tax, o.getLeaveNoDeductTax())) return false;
		if(!Objects.equals(this.__leave_deduct_tax, o.getLeaveDeductTax())) return false;
		if(!Objects.equals(this.__fact_salary, o.getFactSalary())) return false;
		if(!Objects.equals(this.__instead_deduct, o.getInsteadDeduct())) return false;
		if(!Objects.equals(this.__instead_deduct_ill, o.getInsteadDeductIll())) return false;
		if(!Objects.equals(this.__personal_pension, o.getPersonalPension())) return false;
		if(!Objects.equals(this.__personal_medical_insurance, o.getPersonalMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_large_medical_insurance, o.getPersonalLargeMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_unemployment_insurance, o.getPersonalUnemploymentInsurance())) return false;
		if(!Objects.equals(this.__personal_heating, o.getPersonalHeating())) return false;
		if(!Objects.equals(this.__personal_serious_ill_insurance, o.getPersonalSeriousIllInsurance())) return false;
		if(!Objects.equals(this.__special_additional_duduct, o.getSpecialAdditionalDuduct())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStartyear() != null) sb.append(__wrapNumber(count++, "startyear", getStartyear()));
		if(getStartmonth() != null) sb.append(__wrapNumber(count++, "startmonth", getStartmonth()));
		if(getEndyear() != null) sb.append(__wrapNumber(count++, "endyear", getEndyear()));
		if(getEndmonth() != null) sb.append(__wrapNumber(count++, "endmonth", getEndmonth()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getOnboardStatus() != null) sb.append(__wrapNumber(count++, "onboardStatus", getOnboardStatus()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getPositiveDate() != null) sb.append(__wrapDate(count++, "positiveDate", getPositiveDate()));
		if(getResignationDate() != null) sb.append(__wrapDate(count++, "resignationDate", getResignationDate()));
		if(getCard() != null) sb.append(__wrapString(count++, "card", getCard()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getMonthBasicPay() != null) sb.append(__wrapDecimal(count++, "monthBasicPay", getMonthBasicPay()));
		if(getWorkMoney() != null) sb.append(__wrapDecimal(count++, "workMoney", getWorkMoney()));
		if(getFillSendDeduct() != null) sb.append(__wrapDecimal(count++, "fillSendDeduct", getFillSendDeduct()));
		if(getJobSubsidy() != null) sb.append(__wrapDecimal(count++, "jobSubsidy", getJobSubsidy()));
		if(getAttendanceDeduct() != null) sb.append(__wrapDecimal(count++, "attendanceDeduct", getAttendanceDeduct()));
		if(getPerformancePay() != null) sb.append(__wrapDecimal(count++, "performancePay", getPerformancePay()));
		if(getShouldSalary() != null) sb.append(__wrapDecimal(count++, "shouldSalary", getShouldSalary()));
		if(getShouldBonus() != null) sb.append(__wrapDecimal(count++, "shouldBonus", getShouldBonus()));
		if(getShouldTotal() != null) sb.append(__wrapDecimal(count++, "shouldTotal", getShouldTotal()));
		if(getAlreadyBonus() != null) sb.append(__wrapDecimal(count++, "alreadyBonus", getAlreadyBonus()));
		if(getOtherBonus() != null) sb.append(__wrapDecimal(count++, "otherBonus", getOtherBonus()));
		if(getShouldTaxAchieve() != null) sb.append(__wrapDecimal(count++, "shouldTaxAchieve", getShouldTaxAchieve()));
		if(getTaxTotal() != null) sb.append(__wrapDecimal(count++, "taxTotal", getTaxTotal()));
		if(getDeductTax() != null) sb.append(__wrapDecimal(count++, "deductTax", getDeductTax()));
		if(getShouldTax() != null) sb.append(__wrapDecimal(count++, "shouldTax", getShouldTax()));
		if(getTotalInsurance() != null) sb.append(__wrapDecimal(count++, "totalInsurance", getTotalInsurance()));
		if(getTotalFund() != null) sb.append(__wrapDecimal(count++, "totalFund", getTotalFund()));
		if(getUnitTotalInsurance() != null) sb.append(__wrapDecimal(count++, "unitTotalInsurance", getUnitTotalInsurance()));
		if(getUnitTotalFund() != null) sb.append(__wrapDecimal(count++, "unitTotalFund", getUnitTotalFund()));
		if(getLeaveNoDeductTax() != null) sb.append(__wrapDecimal(count++, "leaveNoDeductTax", getLeaveNoDeductTax()));
		if(getLeaveDeductTax() != null) sb.append(__wrapDecimal(count++, "leaveDeductTax", getLeaveDeductTax()));
		if(getFactSalary() != null) sb.append(__wrapDecimal(count++, "factSalary", getFactSalary()));
		if(getInsteadDeduct() != null) sb.append(__wrapDecimal(count++, "insteadDeduct", getInsteadDeduct()));
		if(getInsteadDeductIll() != null) sb.append(__wrapDecimal(count++, "insteadDeductIll", getInsteadDeductIll()));
		if(getPersonalPension() != null) sb.append(__wrapDecimal(count++, "personalPension", getPersonalPension()));
		if(getPersonalMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalMedicalInsurance", getPersonalMedicalInsurance()));
		if(getPersonalLargeMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalLargeMedicalInsurance", getPersonalLargeMedicalInsurance()));
		if(getPersonalUnemploymentInsurance() != null) sb.append(__wrapDecimal(count++, "personalUnemploymentInsurance", getPersonalUnemploymentInsurance()));
		if(getPersonalHeating() != null) sb.append(__wrapDecimal(count++, "personalHeating", getPersonalHeating()));
		if(getPersonalSeriousIllInsurance() != null) sb.append(__wrapDecimal(count++, "personalSeriousIllInsurance", getPersonalSeriousIllInsurance()));
		if(getSpecialAdditionalDuduct() != null) sb.append(__wrapDecimal(count++, "specialAdditionalDuduct", getSpecialAdditionalDuduct()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("startyear")) != null) setStartyear(__getInt(val)); 
		if((val = values.get("startmonth")) != null) setStartmonth(__getInt(val)); 
		if((val = values.get("endyear")) != null) setEndyear(__getInt(val)); 
		if((val = values.get("endmonth")) != null) setEndmonth(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("onboardStatus")) != null) setOnboardStatus(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("positiveDate")) != null) setPositiveDate(__getDate(val)); 
		if((val = values.get("resignationDate")) != null) setResignationDate(__getDate(val)); 
		if((val = values.get("card")) != null) setCard(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getDecimal(val));  
		if((val = values.get("workMoney")) != null) setWorkMoney(__getDecimal(val));  
		if((val = values.get("fillSendDeduct")) != null) setFillSendDeduct(__getDecimal(val));  
		if((val = values.get("jobSubsidy")) != null) setJobSubsidy(__getDecimal(val));  
		if((val = values.get("attendanceDeduct")) != null) setAttendanceDeduct(__getDecimal(val));  
		if((val = values.get("performancePay")) != null) setPerformancePay(__getDecimal(val));  
		if((val = values.get("shouldSalary")) != null) setShouldSalary(__getDecimal(val));  
		if((val = values.get("shouldBonus")) != null) setShouldBonus(__getDecimal(val));  
		if((val = values.get("shouldTotal")) != null) setShouldTotal(__getDecimal(val));  
		if((val = values.get("alreadyBonus")) != null) setAlreadyBonus(__getDecimal(val));  
		if((val = values.get("otherBonus")) != null) setOtherBonus(__getDecimal(val));  
		if((val = values.get("shouldTaxAchieve")) != null) setShouldTaxAchieve(__getDecimal(val));  
		if((val = values.get("taxTotal")) != null) setTaxTotal(__getDecimal(val));  
		if((val = values.get("deductTax")) != null) setDeductTax(__getDecimal(val));  
		if((val = values.get("shouldTax")) != null) setShouldTax(__getDecimal(val));  
		if((val = values.get("totalInsurance")) != null) setTotalInsurance(__getDecimal(val));  
		if((val = values.get("totalFund")) != null) setTotalFund(__getDecimal(val));  
		if((val = values.get("unitTotalInsurance")) != null) setUnitTotalInsurance(__getDecimal(val));  
		if((val = values.get("unitTotalFund")) != null) setUnitTotalFund(__getDecimal(val));  
		if((val = values.get("leaveNoDeductTax")) != null) setLeaveNoDeductTax(__getDecimal(val));  
		if((val = values.get("leaveDeductTax")) != null) setLeaveDeductTax(__getDecimal(val));  
		if((val = values.get("factSalary")) != null) setFactSalary(__getDecimal(val));  
		if((val = values.get("insteadDeduct")) != null) setInsteadDeduct(__getDecimal(val));  
		if((val = values.get("insteadDeductIll")) != null) setInsteadDeductIll(__getDecimal(val));  
		if((val = values.get("personalPension")) != null) setPersonalPension(__getDecimal(val));  
		if((val = values.get("personalMedicalInsurance")) != null) setPersonalMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalLargeMedicalInsurance")) != null) setPersonalLargeMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalUnemploymentInsurance")) != null) setPersonalUnemploymentInsurance(__getDecimal(val));  
		if((val = values.get("personalHeating")) != null) setPersonalHeating(__getDecimal(val));  
		if((val = values.get("personalSeriousIllInsurance")) != null) setPersonalSeriousIllInsurance(__getDecimal(val));  
		if((val = values.get("specialAdditionalDuduct")) != null) setSpecialAdditionalDuduct(__getDecimal(val));  
	}

	protected java.lang.Integer  __startyear ;
	protected java.lang.Integer  __startmonth ;
	protected java.lang.Integer  __endyear ;
	protected java.lang.Integer  __endmonth ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __mobile ;
	protected java.lang.Integer  __onboard_status ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __positive_date ;
	protected java.util.Date  __resignation_date ;
	protected java.lang.String  __card ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __month_basic_pay ;
	protected java.math.BigDecimal  __work_money ;
	protected java.math.BigDecimal  __fill_send_deduct ;
	protected java.math.BigDecimal  __job_subsidy ;
	protected java.math.BigDecimal  __attendance_deduct ;
	protected java.math.BigDecimal  __performance_pay ;
	protected java.math.BigDecimal  __should_salary ;
	protected java.math.BigDecimal  __should_bonus ;
	protected java.math.BigDecimal  __should_total ;
	protected java.math.BigDecimal  __already_bonus ;
	protected java.math.BigDecimal  __other_bonus ;
	protected java.math.BigDecimal  __should_tax_achieve ;
	protected java.math.BigDecimal  __tax_total ;
	protected java.math.BigDecimal  __deduct_tax ;
	protected java.math.BigDecimal  __should_tax ;
	protected java.math.BigDecimal  __total_insurance ;
	protected java.math.BigDecimal  __total_fund ;
	protected java.math.BigDecimal  __unit_total_insurance ;
	protected java.math.BigDecimal  __unit_total_fund ;
	protected java.math.BigDecimal  __leave_no_deduct_tax ;
	protected java.math.BigDecimal  __leave_deduct_tax ;
	protected java.math.BigDecimal  __fact_salary ;
	protected java.math.BigDecimal  __instead_deduct ;
	protected java.math.BigDecimal  __instead_deduct_ill ;
	protected java.math.BigDecimal  __personal_pension ;
	protected java.math.BigDecimal  __personal_medical_insurance ;
	protected java.math.BigDecimal  __personal_large_medical_insurance ;
	protected java.math.BigDecimal  __personal_unemployment_insurance ;
	protected java.math.BigDecimal  __personal_heating ;
	protected java.math.BigDecimal  __personal_serious_ill_insurance ;
	protected java.math.BigDecimal  __special_additional_duduct ;
}
