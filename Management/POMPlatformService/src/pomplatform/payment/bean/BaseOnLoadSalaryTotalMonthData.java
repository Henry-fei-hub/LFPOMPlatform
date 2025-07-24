package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadSalaryTotalMonthData extends GenericBase implements BaseFactory<BaseOnLoadSalaryTotalMonthData>, Comparable<BaseOnLoadSalaryTotalMonthData> 
{


	public static BaseOnLoadSalaryTotalMonthData newInstance(){
		return new BaseOnLoadSalaryTotalMonthData();
	}

	@Override
	public BaseOnLoadSalaryTotalMonthData make(){
		BaseOnLoadSalaryTotalMonthData b = new BaseOnLoadSalaryTotalMonthData();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_WORK_MONEY = "work_money" ;
	public final static java.lang.String CS_FILL_SEND_DEDUCT = "fill_send_deduct" ;
	public final static java.lang.String CS_JOB_SUBSIDY = "job_subsidy" ;
	public final static java.lang.String CS_ATTENDANCE_DEDUCT = "attendance_deduct" ;
	public final static java.lang.String CS_PERFORMANCE_PAY = "performance_pay" ;
	public final static java.lang.String CS_SHOULD_BONUS = "should_bonus" ;
	public final static java.lang.String CS_ALREADY_BONUS = "already_bonus" ;
	public final static java.lang.String CS_OTHER_BONUS = "other_bonus" ;
	public final static java.lang.String CS_DEDUCT_TAX = "deduct_tax" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_TOTAL_INSURANCE = "total_insurance" ;
	public final static java.lang.String CS_UNIT_TOTAL_FUND = "unit_total_fund" ;
	public final static java.lang.String CS_UNIT_TOTAL_INSURANCE = "unit_total_insurance" ;
	public final static java.lang.String CS_LEAVE_NO_DEDUCT_TAX = "leave_no_deduct_tax" ;
	public final static java.lang.String CS_LEAVE_DEDUCT_TAX = "leave_deduct_tax" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT = "instead_deduct" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT_ILL = "instead_deduct_ill" ;
	public final static java.lang.String CS_COST_ATTRIBUTION = "cost_attribution" ;
	public final static java.lang.String CS_PERSONAL_PENSION = "personal_pension" ;
	public final static java.lang.String CS_PERSONAL_MEDICAL_INSURANCE = "personal_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_LARGE_MEDICAL_INSURANCE = "personal_large_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_UNEMPLOYMENT_INSURANCE = "personal_unemployment_insurance" ;
	public final static java.lang.String CS_PERSONAL_HEATING = "personal_heating" ;
	public final static java.lang.String CS_PERSONAL_SERIOUS_ILL_INSURANCE = "personal_serious_ill_insurance" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_RESIGNATION_DATE = "resignation_date" ;

	public final static java.lang.String ALL_CAPTIONS = "员工id,工号,员工姓名,归属公司,业务部门编码,所属部门,银行账号,月基本工资,工龄工资,,,,,应发奖金,,其他奖金,扣税,应缴公积金合计,应缴社保合计,单位公积金合计,单位社保合计,,,代扣款项,代扣重疾,费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员),养老保险（个人）,医疗保险（个人）,大额医疗保险（个人）,失业保险（个人）,采暖（个人）,大病医疗保险（个人）,员工状态,入职日期,离职日期";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getMonthBasicPay() {
		return this.__month_basic_pay;
	}

	public void setMonthBasicPay( java.lang.String value ) {
		this.__month_basic_pay = value;
	}

	public java.lang.String getWorkMoney() {
		return this.__work_money;
	}

	public void setWorkMoney( java.lang.String value ) {
		this.__work_money = value;
	}

	public java.lang.String getFillSendDeduct() {
		return this.__fill_send_deduct;
	}

	public void setFillSendDeduct( java.lang.String value ) {
		this.__fill_send_deduct = value;
	}

	public java.lang.String getJobSubsidy() {
		return this.__job_subsidy;
	}

	public void setJobSubsidy( java.lang.String value ) {
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

	public java.lang.String getShouldBonus() {
		return this.__should_bonus;
	}

	public void setShouldBonus( java.lang.String value ) {
		this.__should_bonus = value;
	}

	public java.lang.String getAlreadyBonus() {
		return this.__already_bonus;
	}

	public void setAlreadyBonus( java.lang.String value ) {
		this.__already_bonus = value;
	}

	public java.lang.String getOtherBonus() {
		return this.__other_bonus;
	}

	public void setOtherBonus( java.lang.String value ) {
		this.__other_bonus = value;
	}

	public java.lang.String getDeductTax() {
		return this.__deduct_tax;
	}

	public void setDeductTax( java.lang.String value ) {
		this.__deduct_tax = value;
	}

	public java.math.BigDecimal getTotalFund() {
		return this.__total_fund;
	}

	public void setTotalFund( java.math.BigDecimal value ) {
		this.__total_fund = value;
	}

	public java.math.BigDecimal getTotalInsurance() {
		return this.__total_insurance;
	}

	public void setTotalInsurance( java.math.BigDecimal value ) {
		this.__total_insurance = value;
	}

	public java.math.BigDecimal getUnitTotalFund() {
		return this.__unit_total_fund;
	}

	public void setUnitTotalFund( java.math.BigDecimal value ) {
		this.__unit_total_fund = value;
	}

	public java.math.BigDecimal getUnitTotalInsurance() {
		return this.__unit_total_insurance;
	}

	public void setUnitTotalInsurance( java.math.BigDecimal value ) {
		this.__unit_total_insurance = value;
	}

	public java.lang.String getLeaveNoDeductTax() {
		return this.__leave_no_deduct_tax;
	}

	public void setLeaveNoDeductTax( java.lang.String value ) {
		this.__leave_no_deduct_tax = value;
	}

	public java.lang.String getLeaveDeductTax() {
		return this.__leave_deduct_tax;
	}

	public void setLeaveDeductTax( java.lang.String value ) {
		this.__leave_deduct_tax = value;
	}

	public java.lang.String getInsteadDeduct() {
		return this.__instead_deduct;
	}

	public void setInsteadDeduct( java.lang.String value ) {
		this.__instead_deduct = value;
	}

	public java.lang.String getInsteadDeductIll() {
		return this.__instead_deduct_ill;
	}

	public void setInsteadDeductIll( java.lang.String value ) {
		this.__instead_deduct_ill = value;
	}

	public java.lang.Integer getCostAttribution() {
		return this.__cost_attribution;
	}

	public void setCostAttribution( java.lang.Integer value ) {
		this.__cost_attribution = value;
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.util.Date getResignationDate() {
		return this.__resignation_date;
	}

	public void setResignationDate( java.util.Date value ) {
		this.__resignation_date = value;
	}

	public void cloneCopy(BaseOnLoadSalaryTotalMonthData __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setBankAccount(getBankAccount());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setWorkMoney(getWorkMoney());
		__bean.setFillSendDeduct(getFillSendDeduct());
		__bean.setJobSubsidy(getJobSubsidy());
		__bean.setAttendanceDeduct(getAttendanceDeduct());
		__bean.setPerformancePay(getPerformancePay());
		__bean.setShouldBonus(getShouldBonus());
		__bean.setAlreadyBonus(getAlreadyBonus());
		__bean.setOtherBonus(getOtherBonus());
		__bean.setDeductTax(getDeductTax());
		__bean.setTotalFund(getTotalFund());
		__bean.setTotalInsurance(getTotalInsurance());
		__bean.setUnitTotalFund(getUnitTotalFund());
		__bean.setUnitTotalInsurance(getUnitTotalInsurance());
		__bean.setLeaveNoDeductTax(getLeaveNoDeductTax());
		__bean.setLeaveDeductTax(getLeaveDeductTax());
		__bean.setInsteadDeduct(getInsteadDeduct());
		__bean.setInsteadDeductIll(getInsteadDeductIll());
		__bean.setCostAttribution(getCostAttribution());
		__bean.setPersonalPension(getPersonalPension());
		__bean.setPersonalMedicalInsurance(getPersonalMedicalInsurance());
		__bean.setPersonalLargeMedicalInsurance(getPersonalLargeMedicalInsurance());
		__bean.setPersonalUnemploymentInsurance(getPersonalUnemploymentInsurance());
		__bean.setPersonalHeating(getPersonalHeating());
		__bean.setPersonalSeriousIllInsurance(getPersonalSeriousIllInsurance());
		__bean.setStatus(getStatus());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setResignationDate(getResignationDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
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
		sb.append(getBankAccount() == null ? "" : getBankAccount());
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
		sb.append(getShouldBonus() == null ? "" : getShouldBonus());
		sb.append(",");
		sb.append(getAlreadyBonus() == null ? "" : getAlreadyBonus());
		sb.append(",");
		sb.append(getOtherBonus() == null ? "" : getOtherBonus());
		sb.append(",");
		sb.append(getDeductTax() == null ? "" : getDeductTax());
		sb.append(",");
		sb.append(getTotalFund() == null ? "" : getTotalFund());
		sb.append(",");
		sb.append(getTotalInsurance() == null ? "" : getTotalInsurance());
		sb.append(",");
		sb.append(getUnitTotalFund() == null ? "" : getUnitTotalFund());
		sb.append(",");
		sb.append(getUnitTotalInsurance() == null ? "" : getUnitTotalInsurance());
		sb.append(",");
		sb.append(getLeaveNoDeductTax() == null ? "" : getLeaveNoDeductTax());
		sb.append(",");
		sb.append(getLeaveDeductTax() == null ? "" : getLeaveDeductTax());
		sb.append(",");
		sb.append(getInsteadDeduct() == null ? "" : getInsteadDeduct());
		sb.append(",");
		sb.append(getInsteadDeductIll() == null ? "" : getInsteadDeductIll());
		sb.append(",");
		sb.append(getCostAttribution() == null ? "" : getCostAttribution());
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
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getResignationDate() == null ? "" : sdf.format(getResignationDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadSalaryTotalMonthData o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__work_money);
		hash = 97 * hash + Objects.hashCode(this.__fill_send_deduct);
		hash = 97 * hash + Objects.hashCode(this.__job_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__attendance_deduct);
		hash = 97 * hash + Objects.hashCode(this.__performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__should_bonus);
		hash = 97 * hash + Objects.hashCode(this.__already_bonus);
		hash = 97 * hash + Objects.hashCode(this.__other_bonus);
		hash = 97 * hash + Objects.hashCode(this.__deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__total_fund);
		hash = 97 * hash + Objects.hashCode(this.__total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__leave_no_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__leave_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct_ill);
		hash = 97 * hash + Objects.hashCode(this.__cost_attribution);
		hash = 97 * hash + Objects.hashCode(this.__personal_pension);
		hash = 97 * hash + Objects.hashCode(this.__personal_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_large_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_unemployment_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_heating);
		hash = 97 * hash + Objects.hashCode(this.__personal_serious_ill_insurance);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__resignation_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadSalaryTotalMonthData o = (BaseOnLoadSalaryTotalMonthData)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__work_money, o.getWorkMoney())) return false;
		if(!Objects.equals(this.__fill_send_deduct, o.getFillSendDeduct())) return false;
		if(!Objects.equals(this.__job_subsidy, o.getJobSubsidy())) return false;
		if(!Objects.equals(this.__attendance_deduct, o.getAttendanceDeduct())) return false;
		if(!Objects.equals(this.__performance_pay, o.getPerformancePay())) return false;
		if(!Objects.equals(this.__should_bonus, o.getShouldBonus())) return false;
		if(!Objects.equals(this.__already_bonus, o.getAlreadyBonus())) return false;
		if(!Objects.equals(this.__other_bonus, o.getOtherBonus())) return false;
		if(!Objects.equals(this.__deduct_tax, o.getDeductTax())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
		if(!Objects.equals(this.__unit_total_fund, o.getUnitTotalFund())) return false;
		if(!Objects.equals(this.__unit_total_insurance, o.getUnitTotalInsurance())) return false;
		if(!Objects.equals(this.__leave_no_deduct_tax, o.getLeaveNoDeductTax())) return false;
		if(!Objects.equals(this.__leave_deduct_tax, o.getLeaveDeductTax())) return false;
		if(!Objects.equals(this.__instead_deduct, o.getInsteadDeduct())) return false;
		if(!Objects.equals(this.__instead_deduct_ill, o.getInsteadDeductIll())) return false;
		if(!Objects.equals(this.__cost_attribution, o.getCostAttribution())) return false;
		if(!Objects.equals(this.__personal_pension, o.getPersonalPension())) return false;
		if(!Objects.equals(this.__personal_medical_insurance, o.getPersonalMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_large_medical_insurance, o.getPersonalLargeMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_unemployment_insurance, o.getPersonalUnemploymentInsurance())) return false;
		if(!Objects.equals(this.__personal_heating, o.getPersonalHeating())) return false;
		if(!Objects.equals(this.__personal_serious_ill_insurance, o.getPersonalSeriousIllInsurance())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__resignation_date, o.getResignationDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getMonthBasicPay() != null) sb.append(__wrapString(count++, "monthBasicPay", getMonthBasicPay()));
		if(getWorkMoney() != null) sb.append(__wrapString(count++, "workMoney", getWorkMoney()));
		if(getFillSendDeduct() != null) sb.append(__wrapString(count++, "fillSendDeduct", getFillSendDeduct()));
		if(getJobSubsidy() != null) sb.append(__wrapString(count++, "jobSubsidy", getJobSubsidy()));
		if(getAttendanceDeduct() != null) sb.append(__wrapDecimal(count++, "attendanceDeduct", getAttendanceDeduct()));
		if(getPerformancePay() != null) sb.append(__wrapDecimal(count++, "performancePay", getPerformancePay()));
		if(getShouldBonus() != null) sb.append(__wrapString(count++, "shouldBonus", getShouldBonus()));
		if(getAlreadyBonus() != null) sb.append(__wrapString(count++, "alreadyBonus", getAlreadyBonus()));
		if(getOtherBonus() != null) sb.append(__wrapString(count++, "otherBonus", getOtherBonus()));
		if(getDeductTax() != null) sb.append(__wrapString(count++, "deductTax", getDeductTax()));
		if(getTotalFund() != null) sb.append(__wrapDecimal(count++, "totalFund", getTotalFund()));
		if(getTotalInsurance() != null) sb.append(__wrapDecimal(count++, "totalInsurance", getTotalInsurance()));
		if(getUnitTotalFund() != null) sb.append(__wrapDecimal(count++, "unitTotalFund", getUnitTotalFund()));
		if(getUnitTotalInsurance() != null) sb.append(__wrapDecimal(count++, "unitTotalInsurance", getUnitTotalInsurance()));
		if(getLeaveNoDeductTax() != null) sb.append(__wrapString(count++, "leaveNoDeductTax", getLeaveNoDeductTax()));
		if(getLeaveDeductTax() != null) sb.append(__wrapString(count++, "leaveDeductTax", getLeaveDeductTax()));
		if(getInsteadDeduct() != null) sb.append(__wrapString(count++, "insteadDeduct", getInsteadDeduct()));
		if(getInsteadDeductIll() != null) sb.append(__wrapString(count++, "insteadDeductIll", getInsteadDeductIll()));
		if(getCostAttribution() != null) sb.append(__wrapNumber(count++, "costAttribution", getCostAttribution()));
		if(getPersonalPension() != null) sb.append(__wrapDecimal(count++, "personalPension", getPersonalPension()));
		if(getPersonalMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalMedicalInsurance", getPersonalMedicalInsurance()));
		if(getPersonalLargeMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalLargeMedicalInsurance", getPersonalLargeMedicalInsurance()));
		if(getPersonalUnemploymentInsurance() != null) sb.append(__wrapDecimal(count++, "personalUnemploymentInsurance", getPersonalUnemploymentInsurance()));
		if(getPersonalHeating() != null) sb.append(__wrapDecimal(count++, "personalHeating", getPersonalHeating()));
		if(getPersonalSeriousIllInsurance() != null) sb.append(__wrapDecimal(count++, "personalSeriousIllInsurance", getPersonalSeriousIllInsurance()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getResignationDate() != null) sb.append(__wrapDate(count++, "resignationDate", getResignationDate()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getBankAccount() != null) res.put("bankAccount", getBankAccount());
		if(getMonthBasicPay() != null) res.put("monthBasicPay", getMonthBasicPay());
		if(getWorkMoney() != null) res.put("workMoney", getWorkMoney());
		if(getFillSendDeduct() != null) res.put("fillSendDeduct", getFillSendDeduct());
		if(getJobSubsidy() != null) res.put("jobSubsidy", getJobSubsidy());
		if(getAttendanceDeduct() != null) res.put("attendanceDeduct", getAttendanceDeduct());
		if(getPerformancePay() != null) res.put("performancePay", getPerformancePay());
		if(getShouldBonus() != null) res.put("shouldBonus", getShouldBonus());
		if(getAlreadyBonus() != null) res.put("alreadyBonus", getAlreadyBonus());
		if(getOtherBonus() != null) res.put("otherBonus", getOtherBonus());
		if(getDeductTax() != null) res.put("deductTax", getDeductTax());
		if(getTotalFund() != null) res.put("totalFund", getTotalFund());
		if(getTotalInsurance() != null) res.put("totalInsurance", getTotalInsurance());
		if(getUnitTotalFund() != null) res.put("unitTotalFund", getUnitTotalFund());
		if(getUnitTotalInsurance() != null) res.put("unitTotalInsurance", getUnitTotalInsurance());
		if(getLeaveNoDeductTax() != null) res.put("leaveNoDeductTax", getLeaveNoDeductTax());
		if(getLeaveDeductTax() != null) res.put("leaveDeductTax", getLeaveDeductTax());
		if(getInsteadDeduct() != null) res.put("insteadDeduct", getInsteadDeduct());
		if(getInsteadDeductIll() != null) res.put("insteadDeductIll", getInsteadDeductIll());
		if(getCostAttribution() != null) res.put("costAttribution", getCostAttribution());
		if(getPersonalPension() != null) res.put("personalPension", getPersonalPension());
		if(getPersonalMedicalInsurance() != null) res.put("personalMedicalInsurance", getPersonalMedicalInsurance());
		if(getPersonalLargeMedicalInsurance() != null) res.put("personalLargeMedicalInsurance", getPersonalLargeMedicalInsurance());
		if(getPersonalUnemploymentInsurance() != null) res.put("personalUnemploymentInsurance", getPersonalUnemploymentInsurance());
		if(getPersonalHeating() != null) res.put("personalHeating", getPersonalHeating());
		if(getPersonalSeriousIllInsurance() != null) res.put("personalSeriousIllInsurance", getPersonalSeriousIllInsurance());
		if(getStatus() != null) res.put("status", getStatus());
		if(getOnboardDate() != null) res.put("onboardDate", getOnboardDate());
		if(getResignationDate() != null) res.put("resignationDate", getResignationDate());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getString(val));
		if((val = values.get("workMoney")) != null) setWorkMoney(__getString(val));
		if((val = values.get("fillSendDeduct")) != null) setFillSendDeduct(__getString(val));
		if((val = values.get("jobSubsidy")) != null) setJobSubsidy(__getString(val));
		if((val = values.get("attendanceDeduct")) != null) setAttendanceDeduct(__getDecimal(val));  
		if((val = values.get("performancePay")) != null) setPerformancePay(__getDecimal(val));  
		if((val = values.get("shouldBonus")) != null) setShouldBonus(__getString(val));
		if((val = values.get("alreadyBonus")) != null) setAlreadyBonus(__getString(val));
		if((val = values.get("otherBonus")) != null) setOtherBonus(__getString(val));
		if((val = values.get("deductTax")) != null) setDeductTax(__getString(val));
		if((val = values.get("totalFund")) != null) setTotalFund(__getDecimal(val));  
		if((val = values.get("totalInsurance")) != null) setTotalInsurance(__getDecimal(val));  
		if((val = values.get("unitTotalFund")) != null) setUnitTotalFund(__getDecimal(val));  
		if((val = values.get("unitTotalInsurance")) != null) setUnitTotalInsurance(__getDecimal(val));  
		if((val = values.get("leaveNoDeductTax")) != null) setLeaveNoDeductTax(__getString(val));
		if((val = values.get("leaveDeductTax")) != null) setLeaveDeductTax(__getString(val));
		if((val = values.get("insteadDeduct")) != null) setInsteadDeduct(__getString(val));
		if((val = values.get("insteadDeductIll")) != null) setInsteadDeductIll(__getString(val));
		if((val = values.get("costAttribution")) != null) setCostAttribution(__getInt(val)); 
		if((val = values.get("personalPension")) != null) setPersonalPension(__getDecimal(val));  
		if((val = values.get("personalMedicalInsurance")) != null) setPersonalMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalLargeMedicalInsurance")) != null) setPersonalLargeMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalUnemploymentInsurance")) != null) setPersonalUnemploymentInsurance(__getDecimal(val));  
		if((val = values.get("personalHeating")) != null) setPersonalHeating(__getDecimal(val));  
		if((val = values.get("personalSeriousIllInsurance")) != null) setPersonalSeriousIllInsurance(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("resignationDate")) != null) setResignationDate(__getDate(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __month_basic_pay ;
	protected java.lang.String  __work_money ;
	protected java.lang.String  __fill_send_deduct ;
	protected java.lang.String  __job_subsidy ;
	protected java.math.BigDecimal  __attendance_deduct ;
	protected java.math.BigDecimal  __performance_pay ;
	protected java.lang.String  __should_bonus ;
	protected java.lang.String  __already_bonus ;
	protected java.lang.String  __other_bonus ;
	protected java.lang.String  __deduct_tax ;
	protected java.math.BigDecimal  __total_fund ;
	protected java.math.BigDecimal  __total_insurance ;
	protected java.math.BigDecimal  __unit_total_fund ;
	protected java.math.BigDecimal  __unit_total_insurance ;
	protected java.lang.String  __leave_no_deduct_tax ;
	protected java.lang.String  __leave_deduct_tax ;
	protected java.lang.String  __instead_deduct ;
	protected java.lang.String  __instead_deduct_ill ;
	protected java.lang.Integer  __cost_attribution ;
	protected java.math.BigDecimal  __personal_pension ;
	protected java.math.BigDecimal  __personal_medical_insurance ;
	protected java.math.BigDecimal  __personal_large_medical_insurance ;
	protected java.math.BigDecimal  __personal_unemployment_insurance ;
	protected java.math.BigDecimal  __personal_heating ;
	protected java.math.BigDecimal  __personal_serious_ill_insurance ;
	protected java.lang.Integer  __status ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __resignation_date ;
}
