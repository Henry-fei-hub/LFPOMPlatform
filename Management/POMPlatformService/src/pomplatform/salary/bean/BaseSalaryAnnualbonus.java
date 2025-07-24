package pomplatform.salary.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSalaryAnnualbonus extends GenericBase implements BaseFactory<BaseSalaryAnnualbonus>, Comparable<BaseSalaryAnnualbonus> 
{


	public static BaseSalaryAnnualbonus newInstance(){
		return new BaseSalaryAnnualbonus();
	}

	@Override
	public BaseSalaryAnnualbonus make(){
		BaseSalaryAnnualbonus b = new BaseSalaryAnnualbonus();
		return b;
	}

	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ONBOARD_STATUS = "onboard_status" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_POSITIVE_DATE = "positive_date" ;
	public final static java.lang.String CS_TOTAL_PAY = "total_pay" ;
	public final static java.lang.String CS_YEAR_SHOULD_WORK_DAY = "year_should_work_day" ;
	public final static java.lang.String CS_YEAR_FACT_WORK_DAY = "year_fact_work_day" ;
	public final static java.lang.String CS_YEAR_SERVICE_NUM = "year_service_num" ;
	public final static java.lang.String CS_YEAR_TEST_LEVEL = "year_test_level" ;
	public final static java.lang.String CS_TEST_NUM = "test_num" ;
	public final static java.lang.String CS_THIRTEEN_BONUS = "thirteen_bonus" ;
	public final static java.lang.String CS_YEAR_PERFORMANCE_BONUS = "year_performance_bonus" ;
	public final static java.lang.String CS_PROGRAM_BONUS = "program_bonus" ;
	public final static java.lang.String CS_TRANSFER_ACCOUNT_MONEY = "transfer_account_money" ;
	public final static java.lang.String CS_SHOULD_TOTAL = "should_total" ;
	public final static java.lang.String CS_SHOULD_TAX = "should_tax" ;
	public final static java.lang.String CS_FACT_BONUS = "fact_bonus" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;
	public final static java.lang.String CS_DEPOSIT_DEDUCT = "deposit_deduct" ;
	public final static java.lang.String CS_SALARY_DIFF_DEDUCT = "salary_diff_deduct" ;
	public final static java.lang.String CS_REIMBURSEMENT_DEDUCT = "reimbursement_deduct" ;
	public final static java.lang.String CS_OTHER_DEDUCT = "other_deduct" ;
	public final static java.lang.String CS_ALREADY_BONUS = "already_bonus" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE = "should_tax_achieve" ;
	public final static java.lang.String CS_ONE_TO_THREE_REST = "one_to_three_rest" ;
	public final static java.lang.String CS_HOUSING_SUBSIDY = "housing_subsidy" ;
	public final static java.lang.String CS_DEDUCT_PERFORMANCE_BONUS = "deduct_performance_bonus" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_FLOW_STATUS = "flow_status" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SEND_TIME = "send_time" ;
	public final static java.lang.String CS_CARD = "card" ;
	public final static java.lang.String CS_MOBILE = "mobile" ;
	public final static java.lang.String CS_INSTEADDEDUCT = "instead_deduct" ;

	public final static java.lang.String ALL_CAPTIONS = "所属公司,业务部门,所属部门,员工工号,员工姓名,身份证号码,手机号码,银行卡号,年份,应发合计,已发奖金,应纳税所得,应纳个税";
	
	public final static java.lang.String CAPTIONS = "银行卡号,员工工号,员工姓名,身份证号码,手机号码,年份,所属公司,业务部门,所属部门,属性,入职日期,转正日期,1-3季度剩余奖金,本次应发奖金,年度绩效工资,住房补贴,调户押金返还,汇率工资差额,年度绩效扣除,调户押金扣除,报销扣款,其他扣款,应发合计,已发奖金,应纳税所得,应纳个税,代扣款项,实发奖金,发放时间,是否发放,备注,,";

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
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

	public java.lang.String getTotalPay() {
		return this.__total_pay;
	}

	public void setTotalPay( java.lang.String value ) {
		this.__total_pay = value;
	}

	public java.math.BigDecimal getYearShouldWorkDay() {
		return this.__year_should_work_day;
	}

	public void setYearShouldWorkDay( java.math.BigDecimal value ) {
		this.__year_should_work_day = value;
	}

	public java.math.BigDecimal getYearFactWorkDay() {
		return this.__year_fact_work_day;
	}

	public void setYearFactWorkDay( java.math.BigDecimal value ) {
		this.__year_fact_work_day = value;
	}

	public java.math.BigDecimal getYearServiceNum() {
		return this.__year_service_num;
	}

	public void setYearServiceNum( java.math.BigDecimal value ) {
		this.__year_service_num = value;
	}

	public java.lang.String getYearTestLevel() {
		return this.__year_test_level;
	}

	public void setYearTestLevel( java.lang.String value ) {
		this.__year_test_level = value;
	}

	public java.math.BigDecimal getTestNum() {
		return this.__test_num;
	}

	public void setTestNum( java.math.BigDecimal value ) {
		this.__test_num = value;
	}

	public java.lang.String getThirteenBonus() {
		return this.__thirteen_bonus;
	}

	public void setThirteenBonus( java.lang.String value ) {
		this.__thirteen_bonus = value;
	}

	public java.lang.String getYearPerformanceBonus() {
		return this.__year_performance_bonus;
	}

	public void setYearPerformanceBonus( java.lang.String value ) {
		this.__year_performance_bonus = value;
	}

	public java.lang.String getProgramBonus() {
		return this.__program_bonus;
	}

	public void setProgramBonus( java.lang.String value ) {
		this.__program_bonus = value;
	}

	public java.lang.String getTransferAccountMoney() {
		return this.__transfer_account_money;
	}

	public void setTransferAccountMoney( java.lang.String value ) {
		this.__transfer_account_money = value;
	}

	public java.lang.String getShouldTotal() {
		return this.__should_total;
	}

	public void setShouldTotal( java.lang.String value ) {
		this.__should_total = value;
	}

	public java.lang.String getShouldTax() {
		return this.__should_tax;
	}

	public void setShouldTax( java.lang.String value ) {
		this.__should_tax = value;
	}

	public java.lang.String getFactBonus() {
		return this.__fact_bonus;
	}

	public void setFactBonus( java.lang.String value ) {
		this.__fact_bonus = value;
	}

	public java.lang.Boolean getIsSended() {
		return this.__is_sended;
	}

	public void setIsSended( java.lang.Boolean value ) {
		this.__is_sended = value;
	}

	public java.lang.String getDepositDeduct() {
		return this.__deposit_deduct;
	}

	public void setDepositDeduct( java.lang.String value ) {
		this.__deposit_deduct = value;
	}

	public java.lang.String getSalaryDiffDeduct() {
		return this.__salary_diff_deduct;
	}

	public void setSalaryDiffDeduct( java.lang.String value ) {
		this.__salary_diff_deduct = value;
	}

	public java.lang.String getReimbursementDeduct() {
		return this.__reimbursement_deduct;
	}

	public void setReimbursementDeduct( java.lang.String value ) {
		this.__reimbursement_deduct = value;
	}

	public java.lang.String getOtherDeduct() {
		return this.__other_deduct;
	}

	public void setOtherDeduct( java.lang.String value ) {
		this.__other_deduct = value;
	}

	public java.lang.String getAlreadyBonus() {
		return this.__already_bonus;
	}

	public void setAlreadyBonus( java.lang.String value ) {
		this.__already_bonus = value;
	}

	public java.lang.String getShouldTaxAchieve() {
		return this.__should_tax_achieve;
	}

	public void setShouldTaxAchieve( java.lang.String value ) {
		this.__should_tax_achieve = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getFlowStatus() {
		return this.__flow_status;
	}

	public void setFlowStatus( java.lang.Integer value ) {
		this.__flow_status = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getSendTime() {
		return this.__send_time;
	}

	public void setSendTime( java.util.Date value ) {
		this.__send_time = value;
	}
	
	public java.lang.String getMobile() {
		return this.__mobile;
	}

	public void setMobile( java.lang.String value ) {
		this.__mobile = value;
	}
	
	public java.lang.String getCard() {
		return this.__card;
	}

	public void setCard( java.lang.String value ) {
		this.__card = value;
	}
	
	public java.lang.String getOneToThreeRest() {
		return this.__one_to_three_rest;
	}

	public void setOneToThreeRest( java.lang.String value ) {
		this.__one_to_three_rest = value;
	}

	public java.lang.String getHousingSubsidy() {
		return this.__housing_subsidy;
	}

	public void setHousingSubsidy( java.lang.String value ) {
		this.__housing_subsidy = value;
	}

	public java.lang.String getDeductPerformanceBonus() {
		return this.__deduct_performance_bonus;
	}

	public void setDeductPerformanceBonus( java.lang.String value ) {
		this.__deduct_performance_bonus = value;
	}
	
	
	public java.lang.String getInsteadDeduct() {
		return this.__instead_deduct;
	}
	
	public void setInsteadDeduct( java.lang.String value ) {
		this.__instead_deduct = value;
	}

	public void cloneCopy(BaseSalaryAnnualbonus __bean){
		__bean.setBankAccount(getBankAccount());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setYear(getYear());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOnboardStatus(getOnboardStatus());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setPositiveDate(getPositiveDate());
		__bean.setTotalPay(getTotalPay());
		__bean.setYearShouldWorkDay(getYearShouldWorkDay());
		__bean.setYearFactWorkDay(getYearFactWorkDay());
		__bean.setYearServiceNum(getYearServiceNum());
		__bean.setYearTestLevel(getYearTestLevel());
		__bean.setTestNum(getTestNum());
		__bean.setThirteenBonus(getThirteenBonus());
		__bean.setYearPerformanceBonus(getYearPerformanceBonus());
		__bean.setProgramBonus(getProgramBonus());
		__bean.setTransferAccountMoney(getTransferAccountMoney());
		__bean.setShouldTotal(getShouldTotal());
		__bean.setShouldTax(getShouldTax());
		__bean.setFactBonus(getFactBonus());
		__bean.setIsSended(getIsSended());
		__bean.setDepositDeduct(getDepositDeduct());
		__bean.setSalaryDiffDeduct(getSalaryDiffDeduct());
		__bean.setReimbursementDeduct(getReimbursementDeduct());
		__bean.setOtherDeduct(getOtherDeduct());
		__bean.setAlreadyBonus(getAlreadyBonus());
		__bean.setShouldTaxAchieve(getShouldTaxAchieve());
		__bean.setOneToThreeRest(getOneToThreeRest());
		__bean.setHousingSubsidy(getHousingSubsidy());
		__bean.setDeductPerformanceBonus(getDeductPerformanceBonus());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setFlowStatus(getFlowStatus());
		__bean.setRemark(getRemark());
		__bean.setSendTime(getSendTime());
		__bean.setMobile(getMobile());
		__bean.setCard(getCard());
		__bean.setInsteadDeduct(getInsteadDeduct());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getOnboardStatus() == null ? "" : getOnboardStatus());
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getPositiveDate() == null ? "" : sdf.format(getPositiveDate()));
		sb.append(",");
		sb.append(getTotalPay() == null ? "" : getTotalPay());
		sb.append(",");
		sb.append(getYearShouldWorkDay() == null ? "" : getYearShouldWorkDay());
		sb.append(",");
		sb.append(getYearFactWorkDay() == null ? "" : getYearFactWorkDay());
		sb.append(",");
		sb.append(getYearServiceNum() == null ? "" : getYearServiceNum());
		sb.append(",");
		sb.append(getYearTestLevel() == null ? "" : getYearTestLevel());
		sb.append(",");
		sb.append(getTestNum() == null ? "" : getTestNum());
		sb.append(",");
		sb.append(getThirteenBonus() == null ? "" : getThirteenBonus());
		sb.append(",");
		sb.append(getYearPerformanceBonus() == null ? "" : getYearPerformanceBonus());
		sb.append(",");
		sb.append(getProgramBonus() == null ? "" : getProgramBonus());
		sb.append(",");
		sb.append(getTransferAccountMoney() == null ? "" : getTransferAccountMoney());
		sb.append(",");
		sb.append(getShouldTotal() == null ? "" : getShouldTotal());
		sb.append(",");
		sb.append(getShouldTax() == null ? "" : getShouldTax());
		sb.append(",");
		sb.append(getFactBonus() == null ? "" : getFactBonus());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		sb.append(",");
		sb.append(getDepositDeduct() == null ? "" : getDepositDeduct());
		sb.append(",");
		sb.append(getSalaryDiffDeduct() == null ? "" : getSalaryDiffDeduct());
		sb.append(",");
		sb.append(getReimbursementDeduct() == null ? "" : getReimbursementDeduct());
		sb.append(",");
		sb.append(getOtherDeduct() == null ? "" : getOtherDeduct());
		sb.append(",");
		sb.append(getAlreadyBonus() == null ? "" : getAlreadyBonus());
		sb.append(",");
		sb.append(getShouldTaxAchieve() == null ? "" : getShouldTaxAchieve());
		sb.append(",");
		sb.append(getOneToThreeRest() == null ? "" : getOneToThreeRest());
		sb.append(",");
		sb.append(getHousingSubsidy() == null ? "" : getHousingSubsidy());
		sb.append(",");
		sb.append(getDeductPerformanceBonus() == null ? "" : getDeductPerformanceBonus());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getFlowStatus() == null ? "" : getFlowStatus());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getSendTime() == null ? "" : sdf.format(getSendTime()));
		sb.append(",");
		sb.append(getMobile() == null ? "" : getMobile()+"\t");
		sb.append(",");
		sb.append(getCard() == null ? "" : getCard()+"\t");
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryAnnualbonus o) {
		return __bank_account == null ? -1 : __bank_account.compareTo(o.getBankAccount());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__onboard_status);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__positive_date);
		hash = 97 * hash + Objects.hashCode(this.__total_pay);
		hash = 97 * hash + Objects.hashCode(this.__year_should_work_day);
		hash = 97 * hash + Objects.hashCode(this.__year_fact_work_day);
		hash = 97 * hash + Objects.hashCode(this.__year_service_num);
		hash = 97 * hash + Objects.hashCode(this.__year_test_level);
		hash = 97 * hash + Objects.hashCode(this.__test_num);
		hash = 97 * hash + Objects.hashCode(this.__thirteen_bonus);
		hash = 97 * hash + Objects.hashCode(this.__year_performance_bonus);
		hash = 97 * hash + Objects.hashCode(this.__program_bonus);
		hash = 97 * hash + Objects.hashCode(this.__transfer_account_money);
		hash = 97 * hash + Objects.hashCode(this.__should_total);
		hash = 97 * hash + Objects.hashCode(this.__should_tax);
		hash = 97 * hash + Objects.hashCode(this.__fact_bonus);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		hash = 97 * hash + Objects.hashCode(this.__deposit_deduct);
		hash = 97 * hash + Objects.hashCode(this.__salary_diff_deduct);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_deduct);
		hash = 97 * hash + Objects.hashCode(this.__other_deduct);
		hash = 97 * hash + Objects.hashCode(this.__already_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_tax_achieve);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__flow_status);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__send_time);
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__card);
		hash = 97 * hash + Objects.hashCode(this.__one_to_three_rest);
		hash = 97 * hash + Objects.hashCode(this.__housing_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__deduct_performance_bonus);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryAnnualbonus o = (BaseSalaryAnnualbonus)obj;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__onboard_status, o.getOnboardStatus())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__positive_date, o.getPositiveDate())) return false;
		if(!Objects.equals(this.__total_pay, o.getTotalPay())) return false;
		if(!Objects.equals(this.__year_should_work_day, o.getYearShouldWorkDay())) return false;
		if(!Objects.equals(this.__year_fact_work_day, o.getYearFactWorkDay())) return false;
		if(!Objects.equals(this.__year_service_num, o.getYearServiceNum())) return false;
		if(!Objects.equals(this.__year_test_level, o.getYearTestLevel())) return false;
		if(!Objects.equals(this.__test_num, o.getTestNum())) return false;
		if(!Objects.equals(this.__thirteen_bonus, o.getThirteenBonus())) return false;
		if(!Objects.equals(this.__year_performance_bonus, o.getYearPerformanceBonus())) return false;
		if(!Objects.equals(this.__program_bonus, o.getProgramBonus())) return false;
		if(!Objects.equals(this.__transfer_account_money, o.getTransferAccountMoney())) return false;
		if(!Objects.equals(this.__should_total, o.getShouldTotal())) return false;
		if(!Objects.equals(this.__should_tax, o.getShouldTax())) return false;
		if(!Objects.equals(this.__fact_bonus, o.getFactBonus())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		if(!Objects.equals(this.__deposit_deduct, o.getDepositDeduct())) return false;
		if(!Objects.equals(this.__salary_diff_deduct, o.getSalaryDiffDeduct())) return false;
		if(!Objects.equals(this.__reimbursement_deduct, o.getReimbursementDeduct())) return false;
		if(!Objects.equals(this.__other_deduct, o.getOtherDeduct())) return false;
		if(!Objects.equals(this.__already_bonus, o.getAlreadyBonus())) return false;
		if(!Objects.equals(this.__should_tax_achieve, o.getShouldTaxAchieve())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__flow_status, o.getFlowStatus())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__send_time, o.getSendTime())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__card, o.getCard())) return false;
		if(!Objects.equals(this.__one_to_three_rest, o.getOneToThreeRest())) return false;
		if(!Objects.equals(this.__housing_subsidy, o.getHousingSubsidy())) return false;
		if(!Objects.equals(this.__deduct_performance_bonus, o.getDeductPerformanceBonus())) return false;
		if(!Objects.equals(this.__instead_deduct, o.getInsteadDeduct())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getOnboardStatus() != null) sb.append(__wrapNumber(count++, "onboardStatus", getOnboardStatus()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getPositiveDate() != null) sb.append(__wrapDate(count++, "positiveDate", getPositiveDate()));
		if(getTotalPay() != null) sb.append(__wrapString(count++, "totalPay", getTotalPay()));
		if(getYearShouldWorkDay() != null) sb.append(__wrapDecimal(count++, "yearShouldWorkDay", getYearShouldWorkDay()));
		if(getYearFactWorkDay() != null) sb.append(__wrapDecimal(count++, "yearFactWorkDay", getYearFactWorkDay()));
		if(getYearServiceNum() != null) sb.append(__wrapDecimal(count++, "yearServiceNum", getYearServiceNum()));
		if(getYearTestLevel() != null) sb.append(__wrapString(count++, "yearTestLevel", getYearTestLevel()));
		if(getTestNum() != null) sb.append(__wrapDecimal(count++, "testNum", getTestNum()));
		if(getThirteenBonus() != null) sb.append(__wrapString(count++, "thirteenBonus", getThirteenBonus()));
		if(getYearPerformanceBonus() != null) sb.append(__wrapString(count++, "yearPerformanceBonus", getYearPerformanceBonus()));
		if(getProgramBonus() != null) sb.append(__wrapString(count++, "programBonus", getProgramBonus()));
		if(getTransferAccountMoney() != null) sb.append(__wrapString(count++, "transferAccountMoney", getTransferAccountMoney()));
		if(getShouldTotal() != null) sb.append(__wrapString(count++, "shouldTotal", getShouldTotal()));
		if(getShouldTax() != null) sb.append(__wrapString(count++, "shouldTax", getShouldTax()));
		if(getFactBonus() != null) sb.append(__wrapString(count++, "factBonus", getFactBonus()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		if(getDepositDeduct() != null) sb.append(__wrapString(count++, "depositDeduct", getDepositDeduct()));
		if(getSalaryDiffDeduct() != null) sb.append(__wrapString(count++, "salaryDiffDeduct", getSalaryDiffDeduct()));
		if(getReimbursementDeduct() != null) sb.append(__wrapString(count++, "reimbursementDeduct", getReimbursementDeduct()));
		if(getOtherDeduct() != null) sb.append(__wrapString(count++, "otherDeduct", getOtherDeduct()));
		if(getAlreadyBonus() != null) sb.append(__wrapString(count++, "alreadyBonus", getAlreadyBonus()));
		if(getShouldTaxAchieve() != null) sb.append(__wrapString(count++, "shouldTaxAchieve", getShouldTaxAchieve()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getFlowStatus() != null) sb.append(__wrapNumber(count++, "flowStatus", getFlowStatus()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getSendTime() != null) sb.append(__wrapDate(count++, "sendTime", getSendTime()));
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getCard() != null) sb.append(__wrapString(count++, "card", getCard()));
		if(getOneToThreeRest() != null) sb.append(__wrapString(count++, "oneToThreeRest", getOneToThreeRest()));
		if(getHousingSubsidy() != null) sb.append(__wrapString(count++, "housingSubsidy", getHousingSubsidy()));
		if(getDeductPerformanceBonus() != null) sb.append(__wrapString(count++, "deductPerformanceBonus", getDeductPerformanceBonus()));
		if(getInsteadDeduct() != null) sb.append(__wrapString(count++, "insteadDeduct", getInsteadDeduct()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("onboardStatus")) != null) setOnboardStatus(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("positiveDate")) != null) setPositiveDate(__getDate(val)); 
		if((val = values.get("totalPay")) != null) setTotalPay(__getString(val));
		if((val = values.get("yearShouldWorkDay")) != null) setYearShouldWorkDay(__getDecimal(val));  
		if((val = values.get("yearFactWorkDay")) != null) setYearFactWorkDay(__getDecimal(val));  
		if((val = values.get("yearServiceNum")) != null) setYearServiceNum(__getDecimal(val));  
		if((val = values.get("yearTestLevel")) != null) setYearTestLevel(__getString(val));
		if((val = values.get("testNum")) != null) setTestNum(__getDecimal(val));  
		if((val = values.get("thirteenBonus")) != null) setThirteenBonus(__getString(val));
		if((val = values.get("yearPerformanceBonus")) != null) setYearPerformanceBonus(__getString(val));
		if((val = values.get("programBonus")) != null) setProgramBonus(__getString(val));
		if((val = values.get("transferAccountMoney")) != null) setTransferAccountMoney(__getString(val));
		if((val = values.get("shouldTotal")) != null) setShouldTotal(__getString(val));
		if((val = values.get("shouldTax")) != null) setShouldTax(__getString(val));
		if((val = values.get("factBonus")) != null) setFactBonus(__getString(val));
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
		if((val = values.get("depositDeduct")) != null) setDepositDeduct(__getString(val));
		if((val = values.get("salaryDiffDeduct")) != null) setSalaryDiffDeduct(__getString(val));
		if((val = values.get("reimbursementDeduct")) != null) setReimbursementDeduct(__getString(val));
		if((val = values.get("otherDeduct")) != null) setOtherDeduct(__getString(val));
		if((val = values.get("alreadyBonus")) != null) setAlreadyBonus(__getString(val));
		if((val = values.get("shouldTaxAchieve")) != null) setShouldTaxAchieve(__getString(val));
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("flowStatus")) != null) setFlowStatus(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("sendTime")) != null) setSendTime(__getDate(val)); 
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("card")) != null) setCard(__getString(val));
		if((val = values.get("oneToThreeRest")) != null) setOneToThreeRest(__getString(val));
		if((val = values.get("housingSubsidy")) != null) setHousingSubsidy(__getString(val));
		if((val = values.get("deductPerformanceBonus")) != null) setDeductPerformanceBonus(__getString(val));
		if((val = values.get("deductPerformanceBonus")) != null) setDeductPerformanceBonus(__getString(val));
		if((val = values.get("insteadDeduct")) != null) setInsteadDeduct(__getString(val));
	}

	protected java.lang.String  __bank_account ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __onboard_status ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __positive_date ;
	protected java.lang.String  __total_pay ;
	protected java.math.BigDecimal  __year_should_work_day ;
	protected java.math.BigDecimal  __year_fact_work_day ;
	protected java.math.BigDecimal  __year_service_num ;
	protected java.lang.String  __year_test_level ;
	protected java.math.BigDecimal  __test_num ;
	protected java.lang.String  __thirteen_bonus ;
	protected java.lang.String  __year_performance_bonus ;
	protected java.lang.String  __program_bonus ;
	protected java.lang.String  __transfer_account_money ;
	protected java.lang.String  __should_total ;
	protected java.lang.String  __should_tax ;
	protected java.lang.String  __fact_bonus ;
	protected java.lang.Boolean  __is_sended ;
	protected java.lang.String  __deposit_deduct ;
	protected java.lang.String  __salary_diff_deduct ;
	protected java.lang.String  __reimbursement_deduct ;
	protected java.lang.String  __other_deduct ;
	protected java.lang.String  __already_bonus ;
	protected java.lang.String  __should_tax_achieve ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __flow_status ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __send_time ;
	protected java.lang.String  __mobile ;
	protected java.lang.String  __card ;
	protected java.lang.String  __one_to_three_rest ;
	protected java.lang.String  __housing_subsidy ;
	protected java.lang.String  __deduct_performance_bonus ;
	protected java.lang.String  __instead_deduct ;
}
