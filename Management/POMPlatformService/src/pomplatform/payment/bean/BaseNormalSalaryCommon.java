package pomplatform.payment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseNormalSalaryCommon extends GenericBase implements BaseFactory<BaseNormalSalaryCommon>, Comparable<BaseNormalSalaryCommon> 
{


	public static BaseNormalSalaryCommon newInstance(){
		return new BaseNormalSalaryCommon();
	}

	@Override
	public BaseNormalSalaryCommon make(){
		BaseNormalSalaryCommon b = new BaseNormalSalaryCommon();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_WORK_MONEY = "work_money" ;
	public final static java.lang.String CS_FILL_SEND_DEDUCT = "fill_send_deduct" ;
	public final static java.lang.String CS_JOB_SUBSIDY = "job_subsidy" ;
	public final static java.lang.String CS_ATTENDANCE_DEDUCT = "attendance_deduct" ;
	public final static java.lang.String CS_PERFORMANCE_PAY = "performance_pay" ;
	public final static java.lang.String CS_SHOULD_BONUS = "should_bonus" ;
	public final static java.lang.String CS_SHOULD_TOTAL = "should_total" ;
	public final static java.lang.String CS_ALREADY_BONUS = "already_bonus" ;
	public final static java.lang.String CS_OTHER_BONUS = "other_bonus" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE = "should_tax_achieve" ;
	public final static java.lang.String CS_TAX_TOTAL = "tax_total" ;
	public final static java.lang.String CS_DEDUCT_TAX = "deduct_tax" ;
	public final static java.lang.String CS_TOTAL_INSURANCE = "total_insurance" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_LEAVE_DEDUCT_TAX = "leave_deduct_tax" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT = "instead_deduct" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT_ILL = "instead_deduct_ill" ;
	public final static java.lang.String CS_UNIT_TOTAL_INSURANCE = "unit_total_insurance" ;
	public final static java.lang.String CS_UNIT_TOTAL_FUND = "unit_total_fund" ;
	public final static java.lang.String CS_REPLACEMENT_TAX = "replacement_tax" ;
	public final static java.lang.String CS_FACT_SALARY = "fact_salary" ;
	public final static java.lang.String CS_LEAVE_NO_DEDUCT_TAX = "leave_no_deduct_tax" ;
	public final static java.lang.String CS_SALARY_TYPE = "salary_type" ;
	public final static java.lang.String CS_FUNDRAISING_PROJECT_TYPE = "fundraising_project_type" ;
	public final static java.lang.String CS_FUNDRAISING_PROJECT_RATE = "fundraising_project_rate" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工id,员工编号,员工姓名,所属公司,业务部门,归属部门,年份,月份,基本工资,工龄工资,补发补扣,岗位补贴,考勤扣款,绩效工资,,应发合计,已发奖金,,应纳税所得,累计应纳税额（个税总额）,已扣个税,社保,公积金,离职补偿扣税,代扣款项,代扣重疾,单位社保,单位公积金,补发个税,实付工资,离职补偿不扣税,类型（1.募投项目 2.研发项目）,募投项目类型,募投比例,流程业务表Id";

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

	public java.lang.String getAttendanceDeduct() {
		return this.__attendance_deduct;
	}

	public void setAttendanceDeduct( java.lang.String value ) {
		this.__attendance_deduct = value;
	}

	public java.lang.String getPerformancePay() {
		return this.__performance_pay;
	}

	public void setPerformancePay( java.lang.String value ) {
		this.__performance_pay = value;
	}

	public java.math.BigDecimal getShouldBonus() {
		return this.__should_bonus;
	}

	public void setShouldBonus( java.math.BigDecimal value ) {
		this.__should_bonus = value;
	}

	public java.lang.String getShouldTotal() {
		return this.__should_total;
	}

	public void setShouldTotal( java.lang.String value ) {
		this.__should_total = value;
	}

	public java.lang.String getAlreadyBonus() {
		return this.__already_bonus;
	}

	public void setAlreadyBonus( java.lang.String value ) {
		this.__already_bonus = value;
	}

	public java.math.BigDecimal getOtherBonus() {
		return this.__other_bonus;
	}

	public void setOtherBonus( java.math.BigDecimal value ) {
		this.__other_bonus = value;
	}

	public java.lang.String getShouldTaxAchieve() {
		return this.__should_tax_achieve;
	}

	public void setShouldTaxAchieve( java.lang.String value ) {
		this.__should_tax_achieve = value;
	}

	public java.lang.String getTaxTotal() {
		return this.__tax_total;
	}

	public void setTaxTotal( java.lang.String value ) {
		this.__tax_total = value;
	}

	public java.lang.String getDeductTax() {
		return this.__deduct_tax;
	}

	public void setDeductTax( java.lang.String value ) {
		this.__deduct_tax = value;
	}

	public java.lang.String getTotalInsurance() {
		return this.__total_insurance;
	}

	public void setTotalInsurance( java.lang.String value ) {
		this.__total_insurance = value;
	}

	public java.lang.String getTotalFund() {
		return this.__total_fund;
	}

	public void setTotalFund( java.lang.String value ) {
		this.__total_fund = value;
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

	public java.lang.String getUnitTotalInsurance() {
		return this.__unit_total_insurance;
	}

	public void setUnitTotalInsurance( java.lang.String value ) {
		this.__unit_total_insurance = value;
	}

	public java.lang.String getUnitTotalFund() {
		return this.__unit_total_fund;
	}

	public void setUnitTotalFund( java.lang.String value ) {
		this.__unit_total_fund = value;
	}

	public java.lang.String getReplacementTax() {
		return this.__replacement_tax;
	}

	public void setReplacementTax( java.lang.String value ) {
		this.__replacement_tax = value;
	}

	public java.lang.String getFactSalary() {
		return this.__fact_salary;
	}

	public void setFactSalary( java.lang.String value ) {
		this.__fact_salary = value;
	}

	public java.lang.String getLeaveNoDeductTax() {
		return this.__leave_no_deduct_tax;
	}

	public void setLeaveNoDeductTax( java.lang.String value ) {
		this.__leave_no_deduct_tax = value;
	}

	public java.lang.Integer getSalaryType() {
		return this.__salary_type;
	}

	public void setSalaryType( java.lang.Integer value ) {
		this.__salary_type = value;
	}

	public java.lang.Integer getFundraisingProjectType() {
		return this.__fundraising_project_type;
	}

	public void setFundraisingProjectType( java.lang.Integer value ) {
		this.__fundraising_project_type = value;
	}

	public java.math.BigDecimal getFundraisingProjectRate() {
		return this.__fundraising_project_rate;
	}

	public void setFundraisingProjectRate( java.math.BigDecimal value ) {
		this.__fundraising_project_rate = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public void cloneCopy(BaseNormalSalaryCommon __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setWorkMoney(getWorkMoney());
		__bean.setFillSendDeduct(getFillSendDeduct());
		__bean.setJobSubsidy(getJobSubsidy());
		__bean.setAttendanceDeduct(getAttendanceDeduct());
		__bean.setPerformancePay(getPerformancePay());
		__bean.setShouldBonus(getShouldBonus());
		__bean.setShouldTotal(getShouldTotal());
		__bean.setAlreadyBonus(getAlreadyBonus());
		__bean.setOtherBonus(getOtherBonus());
		__bean.setShouldTaxAchieve(getShouldTaxAchieve());
		__bean.setTaxTotal(getTaxTotal());
		__bean.setDeductTax(getDeductTax());
		__bean.setTotalInsurance(getTotalInsurance());
		__bean.setTotalFund(getTotalFund());
		__bean.setLeaveDeductTax(getLeaveDeductTax());
		__bean.setInsteadDeduct(getInsteadDeduct());
		__bean.setInsteadDeductIll(getInsteadDeductIll());
		__bean.setUnitTotalInsurance(getUnitTotalInsurance());
		__bean.setUnitTotalFund(getUnitTotalFund());
		__bean.setReplacementTax(getReplacementTax());
		__bean.setFactSalary(getFactSalary());
		__bean.setLeaveNoDeductTax(getLeaveNoDeductTax());
		__bean.setSalaryType(getSalaryType());
		__bean.setFundraisingProjectType(getFundraisingProjectType());
		__bean.setFundraisingProjectRate(getFundraisingProjectRate());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
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
		sb.append(getTotalInsurance() == null ? "" : getTotalInsurance());
		sb.append(",");
		sb.append(getTotalFund() == null ? "" : getTotalFund());
		sb.append(",");
		sb.append(getLeaveDeductTax() == null ? "" : getLeaveDeductTax());
		sb.append(",");
		sb.append(getInsteadDeduct() == null ? "" : getInsteadDeduct());
		sb.append(",");
		sb.append(getInsteadDeductIll() == null ? "" : getInsteadDeductIll());
		sb.append(",");
		sb.append(getUnitTotalInsurance() == null ? "" : getUnitTotalInsurance());
		sb.append(",");
		sb.append(getUnitTotalFund() == null ? "" : getUnitTotalFund());
		sb.append(",");
		sb.append(getReplacementTax() == null ? "" : getReplacementTax());
		sb.append(",");
		sb.append(getFactSalary() == null ? "" : getFactSalary());
		sb.append(",");
		sb.append(getLeaveNoDeductTax() == null ? "" : getLeaveNoDeductTax());
		sb.append(",");
		sb.append(getSalaryType() == null ? "" : getSalaryType());
		sb.append(",");
		sb.append(getFundraisingProjectType() == null ? "" : getFundraisingProjectType());
		sb.append(",");
		sb.append(getFundraisingProjectRate() == null ? "" : getFundraisingProjectRate());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNormalSalaryCommon o) {
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
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__work_money);
		hash = 97 * hash + Objects.hashCode(this.__fill_send_deduct);
		hash = 97 * hash + Objects.hashCode(this.__job_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__attendance_deduct);
		hash = 97 * hash + Objects.hashCode(this.__performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__should_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_total);
		hash = 97 * hash + Objects.hashCode(this.__already_bonus);
		hash = 97 * hash + Objects.hashCode(this.__other_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_tax_achieve);
		hash = 97 * hash + Objects.hashCode(this.__tax_total);
		hash = 97 * hash + Objects.hashCode(this.__deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__total_fund);
		hash = 97 * hash + Objects.hashCode(this.__leave_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct_ill);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__replacement_tax);
		hash = 97 * hash + Objects.hashCode(this.__fact_salary);
		hash = 97 * hash + Objects.hashCode(this.__leave_no_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__salary_type);
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_type);
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_rate);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNormalSalaryCommon o = (BaseNormalSalaryCommon)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__work_money, o.getWorkMoney())) return false;
		if(!Objects.equals(this.__fill_send_deduct, o.getFillSendDeduct())) return false;
		if(!Objects.equals(this.__job_subsidy, o.getJobSubsidy())) return false;
		if(!Objects.equals(this.__attendance_deduct, o.getAttendanceDeduct())) return false;
		if(!Objects.equals(this.__performance_pay, o.getPerformancePay())) return false;
		if(!Objects.equals(this.__should_bonus, o.getShouldBonus())) return false;
		if(!Objects.equals(this.__should_total, o.getShouldTotal())) return false;
		if(!Objects.equals(this.__already_bonus, o.getAlreadyBonus())) return false;
		if(!Objects.equals(this.__other_bonus, o.getOtherBonus())) return false;
		if(!Objects.equals(this.__should_tax_achieve, o.getShouldTaxAchieve())) return false;
		if(!Objects.equals(this.__tax_total, o.getTaxTotal())) return false;
		if(!Objects.equals(this.__deduct_tax, o.getDeductTax())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__leave_deduct_tax, o.getLeaveDeductTax())) return false;
		if(!Objects.equals(this.__instead_deduct, o.getInsteadDeduct())) return false;
		if(!Objects.equals(this.__instead_deduct_ill, o.getInsteadDeductIll())) return false;
		if(!Objects.equals(this.__unit_total_insurance, o.getUnitTotalInsurance())) return false;
		if(!Objects.equals(this.__unit_total_fund, o.getUnitTotalFund())) return false;
		if(!Objects.equals(this.__replacement_tax, o.getReplacementTax())) return false;
		if(!Objects.equals(this.__fact_salary, o.getFactSalary())) return false;
		if(!Objects.equals(this.__leave_no_deduct_tax, o.getLeaveNoDeductTax())) return false;
		if(!Objects.equals(this.__salary_type, o.getSalaryType())) return false;
		if(!Objects.equals(this.__fundraising_project_type, o.getFundraisingProjectType())) return false;
		if(!Objects.equals(this.__fundraising_project_rate, o.getFundraisingProjectRate())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
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
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getMonthBasicPay() != null) sb.append(__wrapString(count++, "monthBasicPay", getMonthBasicPay()));
		if(getWorkMoney() != null) sb.append(__wrapString(count++, "workMoney", getWorkMoney()));
		if(getFillSendDeduct() != null) sb.append(__wrapString(count++, "fillSendDeduct", getFillSendDeduct()));
		if(getJobSubsidy() != null) sb.append(__wrapString(count++, "jobSubsidy", getJobSubsidy()));
		if(getAttendanceDeduct() != null) sb.append(__wrapString(count++, "attendanceDeduct", getAttendanceDeduct()));
		if(getPerformancePay() != null) sb.append(__wrapString(count++, "performancePay", getPerformancePay()));
		if(getShouldBonus() != null) sb.append(__wrapDecimal(count++, "shouldBonus", getShouldBonus()));
		if(getShouldTotal() != null) sb.append(__wrapString(count++, "shouldTotal", getShouldTotal()));
		if(getAlreadyBonus() != null) sb.append(__wrapString(count++, "alreadyBonus", getAlreadyBonus()));
		if(getOtherBonus() != null) sb.append(__wrapDecimal(count++, "otherBonus", getOtherBonus()));
		if(getShouldTaxAchieve() != null) sb.append(__wrapString(count++, "shouldTaxAchieve", getShouldTaxAchieve()));
		if(getTaxTotal() != null) sb.append(__wrapString(count++, "taxTotal", getTaxTotal()));
		if(getDeductTax() != null) sb.append(__wrapString(count++, "deductTax", getDeductTax()));
		if(getTotalInsurance() != null) sb.append(__wrapString(count++, "totalInsurance", getTotalInsurance()));
		if(getTotalFund() != null) sb.append(__wrapString(count++, "totalFund", getTotalFund()));
		if(getLeaveDeductTax() != null) sb.append(__wrapString(count++, "leaveDeductTax", getLeaveDeductTax()));
		if(getInsteadDeduct() != null) sb.append(__wrapString(count++, "insteadDeduct", getInsteadDeduct()));
		if(getInsteadDeductIll() != null) sb.append(__wrapString(count++, "insteadDeductIll", getInsteadDeductIll()));
		if(getUnitTotalInsurance() != null) sb.append(__wrapString(count++, "unitTotalInsurance", getUnitTotalInsurance()));
		if(getUnitTotalFund() != null) sb.append(__wrapString(count++, "unitTotalFund", getUnitTotalFund()));
		if(getReplacementTax() != null) sb.append(__wrapString(count++, "replacementTax", getReplacementTax()));
		if(getFactSalary() != null) sb.append(__wrapString(count++, "factSalary", getFactSalary()));
		if(getLeaveNoDeductTax() != null) sb.append(__wrapString(count++, "leaveNoDeductTax", getLeaveNoDeductTax()));
		if(getSalaryType() != null) sb.append(__wrapNumber(count++, "salaryType", getSalaryType()));
		if(getFundraisingProjectType() != null) sb.append(__wrapNumber(count++, "fundraisingProjectType", getFundraisingProjectType()));
		if(getFundraisingProjectRate() != null) sb.append(__wrapDecimal(count++, "fundraisingProjectRate", getFundraisingProjectRate()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
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
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getMonthBasicPay() != null) res.put("monthBasicPay", getMonthBasicPay());
		if(getWorkMoney() != null) res.put("workMoney", getWorkMoney());
		if(getFillSendDeduct() != null) res.put("fillSendDeduct", getFillSendDeduct());
		if(getJobSubsidy() != null) res.put("jobSubsidy", getJobSubsidy());
		if(getAttendanceDeduct() != null) res.put("attendanceDeduct", getAttendanceDeduct());
		if(getPerformancePay() != null) res.put("performancePay", getPerformancePay());
		if(getShouldBonus() != null) res.put("shouldBonus", getShouldBonus());
		if(getShouldTotal() != null) res.put("shouldTotal", getShouldTotal());
		if(getAlreadyBonus() != null) res.put("alreadyBonus", getAlreadyBonus());
		if(getOtherBonus() != null) res.put("otherBonus", getOtherBonus());
		if(getShouldTaxAchieve() != null) res.put("shouldTaxAchieve", getShouldTaxAchieve());
		if(getTaxTotal() != null) res.put("taxTotal", getTaxTotal());
		if(getDeductTax() != null) res.put("deductTax", getDeductTax());
		if(getTotalInsurance() != null) res.put("totalInsurance", getTotalInsurance());
		if(getTotalFund() != null) res.put("totalFund", getTotalFund());
		if(getLeaveDeductTax() != null) res.put("leaveDeductTax", getLeaveDeductTax());
		if(getInsteadDeduct() != null) res.put("insteadDeduct", getInsteadDeduct());
		if(getInsteadDeductIll() != null) res.put("insteadDeductIll", getInsteadDeductIll());
		if(getUnitTotalInsurance() != null) res.put("unitTotalInsurance", getUnitTotalInsurance());
		if(getUnitTotalFund() != null) res.put("unitTotalFund", getUnitTotalFund());
		if(getReplacementTax() != null) res.put("replacementTax", getReplacementTax());
		if(getFactSalary() != null) res.put("factSalary", getFactSalary());
		if(getLeaveNoDeductTax() != null) res.put("leaveNoDeductTax", getLeaveNoDeductTax());
		if(getSalaryType() != null) res.put("salaryType", getSalaryType());
		if(getFundraisingProjectType() != null) res.put("fundraisingProjectType", getFundraisingProjectType());
		if(getFundraisingProjectRate() != null) res.put("fundraisingProjectRate", getFundraisingProjectRate());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
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
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getString(val));
		if((val = values.get("workMoney")) != null) setWorkMoney(__getString(val));
		if((val = values.get("fillSendDeduct")) != null) setFillSendDeduct(__getString(val));
		if((val = values.get("jobSubsidy")) != null) setJobSubsidy(__getString(val));
		if((val = values.get("attendanceDeduct")) != null) setAttendanceDeduct(__getString(val));
		if((val = values.get("performancePay")) != null) setPerformancePay(__getString(val));
		if((val = values.get("shouldBonus")) != null) setShouldBonus(__getDecimal(val));  
		if((val = values.get("shouldTotal")) != null) setShouldTotal(__getString(val));
		if((val = values.get("alreadyBonus")) != null) setAlreadyBonus(__getString(val));
		if((val = values.get("otherBonus")) != null) setOtherBonus(__getDecimal(val));  
		if((val = values.get("shouldTaxAchieve")) != null) setShouldTaxAchieve(__getString(val));
		if((val = values.get("taxTotal")) != null) setTaxTotal(__getString(val));
		if((val = values.get("deductTax")) != null) setDeductTax(__getString(val));
		if((val = values.get("totalInsurance")) != null) setTotalInsurance(__getString(val));
		if((val = values.get("totalFund")) != null) setTotalFund(__getString(val));
		if((val = values.get("leaveDeductTax")) != null) setLeaveDeductTax(__getString(val));
		if((val = values.get("insteadDeduct")) != null) setInsteadDeduct(__getString(val));
		if((val = values.get("insteadDeductIll")) != null) setInsteadDeductIll(__getString(val));
		if((val = values.get("unitTotalInsurance")) != null) setUnitTotalInsurance(__getString(val));
		if((val = values.get("unitTotalFund")) != null) setUnitTotalFund(__getString(val));
		if((val = values.get("replacementTax")) != null) setReplacementTax(__getString(val));
		if((val = values.get("factSalary")) != null) setFactSalary(__getString(val));
		if((val = values.get("leaveNoDeductTax")) != null) setLeaveNoDeductTax(__getString(val));
		if((val = values.get("salaryType")) != null) setSalaryType(__getInt(val)); 
		if((val = values.get("fundraisingProjectType")) != null) setFundraisingProjectType(__getInt(val)); 
		if((val = values.get("fundraisingProjectRate")) != null) setFundraisingProjectRate(__getDecimal(val));  
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.String  __month_basic_pay ;
	protected java.lang.String  __work_money ;
	protected java.lang.String  __fill_send_deduct ;
	protected java.lang.String  __job_subsidy ;
	protected java.lang.String  __attendance_deduct ;
	protected java.lang.String  __performance_pay ;
	protected java.math.BigDecimal  __should_bonus ;
	protected java.lang.String  __should_total ;
	protected java.lang.String  __already_bonus ;
	protected java.math.BigDecimal  __other_bonus ;
	protected java.lang.String  __should_tax_achieve ;
	protected java.lang.String  __tax_total ;
	protected java.lang.String  __deduct_tax ;
	protected java.lang.String  __total_insurance ;
	protected java.lang.String  __total_fund ;
	protected java.lang.String  __leave_deduct_tax ;
	protected java.lang.String  __instead_deduct ;
	protected java.lang.String  __instead_deduct_ill ;
	protected java.lang.String  __unit_total_insurance ;
	protected java.lang.String  __unit_total_fund ;
	protected java.lang.String  __replacement_tax ;
	protected java.lang.String  __fact_salary ;
	protected java.lang.String  __leave_no_deduct_tax ;
	protected java.lang.Integer  __salary_type ;
	protected java.lang.Integer  __fundraising_project_type ;
	protected java.math.BigDecimal  __fundraising_project_rate ;
	protected java.lang.Integer  __personnel_business_id ;
}
