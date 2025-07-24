package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCustomEmployeeAccount extends GenericBase implements BaseFactory<BaseCustomEmployeeAccount>, Comparable<BaseCustomEmployeeAccount> 
{


	public static BaseCustomEmployeeAccount newInstance(){
		return new BaseCustomEmployeeAccount();
	}

	@Override
	public BaseCustomEmployeeAccount make(){
		BaseCustomEmployeeAccount b = new BaseCustomEmployeeAccount();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_REPORT_RECORD_ID = "employee_report_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral";
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_MANAGER_PROJECT_INTEGRAL = "manager_project_integral" ;
	public final static java.lang.String CS_SALARY_ADVANCE = "salary_advance" ;
	public final static java.lang.String CS_SALARY_RETURN = "salary_return" ;
	public final static java.lang.String CS_SALARY = "salary" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_IS_LOCK = "is_lock" ;
	public final static java.lang.String CS_PROJECT_ADVANCE = "project_advance" ;
	public final static java.lang.String CS_BONUS_PAYMENT = "bonus_payment" ;
	public final static java.lang.String CS_INTEGRAL_RETURN = "integral_return" ;
	public final static java.lang.String CS_VIOLATION_CHARGES = "violation_charges" ;
	public final static java.lang.String CS_BENEFITS = "benefits" ;
	public final static java.lang.String CS_BENEFITS_YEAR = "benefits_year" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_GRADE_ID = "grade_id" ;
	public final static java.lang.String CS_PERFORMANCE_BONUS = "performance_bonus";//绩效奖金
	public final static java.lang.String CS_ATTENDANCE_DEDUCT = "attendance_deduct";//考勤扣款
	public final static java.lang.String CS_PM_PERFORMANCE_AWARD = "pm_performance_award";//项目经理绩效奖励
	public final static java.lang.String CS_PM_PERFORMANCE_DEDUCT = "pm_performance_deduct";//项目经理绩效扣除
	public final static java.lang.String CS_PROJECT_PERFORMANCE = "project_performance";//项目绩效
	public final static java.lang.String CS_CONTRACT_CHANGE = "contract_change";//合同变更
	public final static java.lang.String CS_PLATE_CHANGE_ACHIEVE = "plate_change_achieve";//转岗结算收入
	public final static java.lang.String CS_PLATE_CHANGE_PAY = "plate_change_pay";//转岗结算支出
	public final static java.lang.String CS_PROJECT_PERFORMANCE_PAY = "project_performance_pay";//项目绩效支出
	public final static java.lang.String CS_CONTRACT_DISTRIBUTION_INCOME = "contract_distribution_income";//提成收入
	public final static java.lang.String CS_CONTRACT_DISTRIBUTION_EXPENDITURE = "contract_distribution_expenditure";//提成支出
	public final static java.lang.String CS_DEP_DEPLOY = "dep_deploy";//部门调配
	public final static java.lang.String CS_OUTPUT_ACCOUNT = "output_account";//产值结算

	public final static java.lang.String ALL_CAPTIONS = "编码,业务部门,员工,姓名,工号,实时余额,价值积分,确认积分,积分发放,人工成本补贴,人工成本回流,人工成本,项目成本,记录产生时间,是否锁定,项目补贴,奖金发放,积分回收,资源绩效,个人效益指数,年度效益指数,职级,绩效奖金,项目经理绩效奖励,项目经理绩效扣除,项目绩效,合同变更,项目绩效支出,部门调配,产值结算";
	public final static java.lang.String ALL_CAPTIONS_CUSTOM = "工号,姓名,在职状态,职级,业务部门,实时余额,积分余额,个人效益指数,年度效益指数,确认积分,奖金补贴,积分借款,项目补贴,绩效奖金,项目经理绩效奖励,项目绩效收入,转岗结算收入,提成收入,部门调配,积分还款,人工成本,项目成本,奖金发放,积分回收,资源绩效,考勤扣款,项目经理绩效扣除,合同变更,转岗结算支出,项目绩效支出,提成支出,产值结算";

	public java.lang.Integer getEmployeeReportRecordId() {
		return this.__employee_report_record_id;
	}

	public void setEmployeeReportRecordId( java.lang.Integer value ) {
		this.__employee_report_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}
	
	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral(java.math.BigDecimal value) {
		this.__left_integral = value;
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getManagerProjectIntegral() {
		return this.__manager_project_integral;
	}

	public void setManagerProjectIntegral( java.math.BigDecimal value ) {
		this.__manager_project_integral = value;
	}

	public java.math.BigDecimal getSalaryAdvance() {
		return this.__salary_advance;
	}

	public void setSalaryAdvance( java.math.BigDecimal value ) {
		this.__salary_advance = value;
	}

	public java.math.BigDecimal getSalaryReturn() {
		return this.__salary_return;
	}

	public void setSalaryReturn( java.math.BigDecimal value ) {
		this.__salary_return = value;
	}

	public java.math.BigDecimal getSalary() {
		return this.__salary;
	}

	public void setSalary( java.math.BigDecimal value ) {
		this.__salary = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Boolean getIsLock() {
		return this.__is_lock;
	}

	public void setIsLock( java.lang.Boolean value ) {
		this.__is_lock = value;
	}

	public java.math.BigDecimal getProjectAdvance() {
		return this.__project_advance;
	}

	public void setProjectAdvance( java.math.BigDecimal value ) {
		this.__project_advance = value;
	}

	public java.math.BigDecimal getBonusPayment() {
		return this.__bonus_payment;
	}

	public void setBonusPayment( java.math.BigDecimal value ) {
		this.__bonus_payment = value;
	}

	public java.math.BigDecimal getIntegralReturn() {
		return this.__integral_return;
	}

	public void setIntegralReturn( java.math.BigDecimal value ) {
		this.__integral_return = value;
	}

	public java.math.BigDecimal getViolationCharges() {
		return this.__violation_charges;
	}

	public void setViolationCharges( java.math.BigDecimal value ) {
		this.__violation_charges = value;
	}
	
	public java.math.BigDecimal getBenefits() {
		return this.__benefits;
	}

	public void setBenefits( java.math.BigDecimal value ) {
		this.__benefits = value;
	}
	
	public java.math.BigDecimal getBenefitsYear() {
		return this.__benefits_year;
	}
	
	public void setBenefitsYear( java.math.BigDecimal value ) {
		this.__benefits_year = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}
	
	public java.lang.Integer getGradeId() {
		return this.__grade_id;
	}

	public void setGradeId( java.lang.Integer value ) {
		this.__grade_id = value;
	}
	
	public java.math.BigDecimal getPerformanceBonus() {
		return __performance_bonus;
	}
	
	public void setPerformanceBonus(java.math.BigDecimal value) {
		this.__performance_bonus = value;
	}
	
	public java.math.BigDecimal getAttendanceDeduct() {
		return __attendance_deduct;
	}
	
	public void setAttendanceDeduct(java.math.BigDecimal value) {
		this.__attendance_deduct = value;
	}
	
	public java.math.BigDecimal getPmPerformanceAward() {
		return __pm_performance_award;
	}
	
	public void setPmPerformanceAward(java.math.BigDecimal value) {
		this.__pm_performance_award = value;
	}
	
	public java.math.BigDecimal getPmPerformanceDeduct() {
		return __pm_performance_deduct;
	}
	
	public void setPmPerformanceDeduct(java.math.BigDecimal value) {
		this.__pm_performance_deduct = value;
	}
	
	public java.math.BigDecimal getProjectPerformance() {
		return __project_performance;
	}
	
	public void setProjectPerformance(java.math.BigDecimal value) {
		this.__project_performance = value;
	}
	
	public java.math.BigDecimal getContractChange() {
		return __contract_change;
	}
	
	public void setContractChange(java.math.BigDecimal value) {
		this.__contract_change = value;
	}
	
	public java.math.BigDecimal getPlateChangeAchieve() {
		return __plate_change_achieve;
	}
	
	public void setPlateChangeAchieve(java.math.BigDecimal value) {
		this.__plate_change_achieve = value;
	}
	
	public java.math.BigDecimal getPlateChangePay() {
		return __plate_change_pay;
	}
	
	public void setPlateChangePay(java.math.BigDecimal value) {
		this.__plate_change_pay = value;
	}
	
	public java.math.BigDecimal getProjectPerformancePay() {
		return __project_performance_pay;
	}
	
	public void setProjectPerformancePay(java.math.BigDecimal value) {
		this.__project_performance_pay = value;
	}
	
	public java.math.BigDecimal getContractDistributionIncome() {
		return __contract_distribution_income;
	}

	public void setContractDistributionIncome(java.math.BigDecimal __contract_distribution_income) {
		this.__contract_distribution_income = __contract_distribution_income;
	}

	public java.math.BigDecimal getContractDistributionExpenditure() {
		return __contract_distribution_expenditure;
	}

	public void setContractDistributionExpenditure(java.math.BigDecimal __contract_distribution_expenditure) {
		this.__contract_distribution_expenditure = __contract_distribution_expenditure;
	}

	public java.math.BigDecimal getDepDeploy() {
		return __dep_deploy;
	}

	public void setDepDeploy(java.math.BigDecimal __dep_deploy) {
		this.__dep_deploy = __dep_deploy;
	}

	public java.math.BigDecimal getOutputAccount() {
		return __output_account;
	}

	public void setOutputAccount(java.math.BigDecimal __output_account) {
		this.__output_account = __output_account;
	}

	public void cloneCopy(BaseCustomEmployeeAccount __bean){
		__bean.setEmployeeReportRecordId(getEmployeeReportRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setLeftIntegral(getLeftIntegral());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setManagerProjectIntegral(getManagerProjectIntegral());
		__bean.setSalaryAdvance(getSalaryAdvance());
		__bean.setSalaryReturn(getSalaryReturn());
		__bean.setSalary(getSalary());
		__bean.setProjectCost(getProjectCost());
		__bean.setRecordDate(getRecordDate());
		__bean.setIsLock(getIsLock());
		__bean.setProjectAdvance(getProjectAdvance());
		__bean.setBonusPayment(getBonusPayment());
		__bean.setIntegralReturn(getIntegralReturn());
		__bean.setViolationCharges(getViolationCharges());
		__bean.setBenefits(getBenefits());
		__bean.setBenefitsYear(getBenefitsYear());
		__bean.setStatus(getStatus());
		__bean.setGradeId(getGradeId());
		__bean.setPerformanceBonus(getPerformanceBonus());
		__bean.setAttendanceDeduct(getAttendanceDeduct());
		__bean.setPmPerformanceAward(getPmPerformanceAward());
		__bean.setPmPerformanceDeduct(getPmPerformanceDeduct());
		__bean.setProjectPerformance(getProjectPerformance());
		__bean.setContractChange(getContractChange());
		__bean.setPlateChangeAchieve(getPlateChangeAchieve());
		__bean.setPlateChangePay(getPlateChangePay());
		__bean.setProjectPerformancePay(getProjectPerformancePay());
		__bean.setContractDistributionExpenditure(getContractDistributionExpenditure());
		__bean.setContractDistributionIncome(getContractDistributionIncome());
		__bean.setDepDeploy(getDepDeploy());
		__bean.setOutputAccount(getOutputAccount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_11", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		String strGradeId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_3", String.valueOf(getGradeId()));
		sb.append(strGradeId == null ? "" : strGradeId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getBenefits() == null ? "" : getBenefits());
		sb.append(",");
		sb.append(getBenefitsYear() == null ? "" : getBenefitsYear());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getManagerProjectIntegral() == null ? "" : getManagerProjectIntegral());
		sb.append(",");
		sb.append(getSalaryAdvance() == null ? "" : getSalaryAdvance());
		sb.append(",");
		sb.append(getProjectAdvance() == null ? "" : getProjectAdvance());
		sb.append(",");
		sb.append(getPerformanceBonus() == null ? "" : getPerformanceBonus());
		sb.append(",");
		sb.append(getPmPerformanceAward() == null ? "" : getPmPerformanceAward());
		sb.append(",");
		sb.append(getProjectPerformance() == null ? "" : getProjectPerformance());
		sb.append(",");
		sb.append(getPlateChangeAchieve() == null ? "" : getPlateChangeAchieve());
		sb.append(",");
		sb.append(getContractDistributionIncome() == null ? "" : getContractDistributionIncome());
		sb.append(",");
		sb.append(getDepDeploy() == null ? "" : getDepDeploy());
		sb.append(",");
		sb.append(getSalaryReturn() == null ? "" : getSalaryReturn());
		sb.append(",");
		sb.append(getSalary() == null ? "" : getSalary());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getBonusPayment() == null ? "" : getBonusPayment());
		sb.append(",");
		sb.append(getIntegralReturn() == null ? "" : getIntegralReturn());
		sb.append(",");
		sb.append(getViolationCharges() == null ? "" : getViolationCharges());
		sb.append(",");
		sb.append(getAttendanceDeduct() == null ? "" : getAttendanceDeduct());
		sb.append(",");
		sb.append(getPmPerformanceDeduct() == null ? "" : getPmPerformanceDeduct());
		sb.append(",");
		sb.append(getContractChange() == null ? "" : getContractChange());
		sb.append(",");
		sb.append(getPlateChangePay() == null ? "" : getPlateChangePay());
		sb.append(",");
		sb.append(getProjectPerformancePay() == null ? "" : getProjectPerformancePay());
		sb.append(",");
		sb.append(getContractDistributionExpenditure() == null ? "" : getContractDistributionExpenditure());
		sb.append(",");
		sb.append(getOutputAccount() == null ? "" : getOutputAccount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCustomEmployeeAccount o) {
		return __employee_report_record_id == null ? -1 : __employee_report_record_id.compareTo(o.getEmployeeReportRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_report_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__manager_project_integral);
		hash = 97 * hash + Objects.hashCode(this.__salary_advance);
		hash = 97 * hash + Objects.hashCode(this.__salary_return);
		hash = 97 * hash + Objects.hashCode(this.__salary);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__is_lock);
		hash = 97 * hash + Objects.hashCode(this.__project_advance);
		hash = 97 * hash + Objects.hashCode(this.__bonus_payment);
		hash = 97 * hash + Objects.hashCode(this.__integral_return);
		hash = 97 * hash + Objects.hashCode(this.__violation_charges);
		hash = 97 * hash + Objects.hashCode(this.__benefits);
		hash = 97 * hash + Objects.hashCode(this.__benefits_year);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__grade_id);
		hash = 97 * hash + Objects.hashCode(this.__performance_bonus);
		hash = 97 * hash + Objects.hashCode(this.__attendance_deduct);
		hash = 97 * hash + Objects.hashCode(this.__pm_performance_award);
		hash = 97 * hash + Objects.hashCode(this.__pm_performance_deduct);
		hash = 97 * hash + Objects.hashCode(this.__project_performance);
		hash = 97 * hash + Objects.hashCode(this.__contract_change);
		hash = 97 * hash + Objects.hashCode(this.__plate_change_achieve);
		hash = 97 * hash + Objects.hashCode(this.__plate_change_pay);
		hash = 97 * hash + Objects.hashCode(this.__project_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__contract_distribution_income);
		hash = 97 * hash + Objects.hashCode(this.__contract_distribution_expenditure);
		hash = 97 * hash + Objects.hashCode(this.__dep_deploy);
		hash = 97 * hash + Objects.hashCode(this.__output_account);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCustomEmployeeAccount o = (BaseCustomEmployeeAccount)obj;
		if(!Objects.equals(this.__employee_report_record_id, o.getEmployeeReportRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if (!Objects.equals(this.__left_integral, o.getLeftIntegral()))
			return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__manager_project_integral, o.getManagerProjectIntegral())) return false;
		if(!Objects.equals(this.__salary_advance, o.getSalaryAdvance())) return false;
		if(!Objects.equals(this.__salary_return, o.getSalaryReturn())) return false;
		if(!Objects.equals(this.__salary, o.getSalary())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__is_lock, o.getIsLock())) return false;
		if(!Objects.equals(this.__project_advance, o.getProjectAdvance())) return false;
		if(!Objects.equals(this.__bonus_payment, o.getBonusPayment())) return false;
		if(!Objects.equals(this.__integral_return, o.getIntegralReturn())) return false;
		if(!Objects.equals(this.__violation_charges, o.getViolationCharges())) return false;
		if(!Objects.equals(this.__benefits, o.getBenefits())) return false;
		if(!Objects.equals(this.__benefits_year, o.getBenefitsYear())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__grade_id, o.getGradeId())) return false;
		if (!Objects.equals(this.__performance_bonus, o.getPerformanceBonus()))
			return false;
		if (!Objects.equals(this.__attendance_deduct, o.getAttendanceDeduct()))
			return false;
		if (!Objects.equals(this.__pm_performance_award, o.getPmPerformanceAward()))
			return false;
		if (!Objects.equals(this.__pm_performance_deduct, o.getPmPerformanceDeduct()))
			return false;
		if (!Objects.equals(this.__project_performance, o.getProjectPerformance()))
			return false;
		if (!Objects.equals(this.__contract_change, o.getContractChange()))
			return false;
		if (!Objects.equals(this.__plate_change_achieve, o.getPlateChangeAchieve()))
			return false;
		if (!Objects.equals(this.__plate_change_pay, o.getPlateChangePay()))
			return false;
		if (!Objects.equals(this.__project_performance_pay, o.getProjectPerformancePay()))
			return false;
		if (!Objects.equals(this.__contract_distribution_income, o.getContractDistributionIncome()))
			return false;
		if (!Objects.equals(this.__contract_distribution_expenditure, o.getContractDistributionExpenditure()))
			return false;
		if (!Objects.equals(this.__dep_deploy, o.getDepDeploy()))
			return false;
		if (!Objects.equals(this.__output_account, o.getOutputAccount()))
			return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeReportRecordId() != null) sb.append(__wrapNumber(count++, "employeeReportRecordId", getEmployeeReportRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if (getLeftIntegral() != null)
			sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getManagerProjectIntegral() != null) sb.append(__wrapDecimal(count++, "managerProjectIntegral", getManagerProjectIntegral()));
		if(getSalaryAdvance() != null) sb.append(__wrapDecimal(count++, "salaryAdvance", getSalaryAdvance()));
		if(getSalaryReturn() != null) sb.append(__wrapDecimal(count++, "salaryReturn", getSalaryReturn()));
		if(getSalary() != null) sb.append(__wrapDecimal(count++, "salary", getSalary()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getIsLock() != null) sb.append(__wrapBoolean(count++, "isLock", getIsLock()));
		if(getProjectAdvance() != null) sb.append(__wrapDecimal(count++, "projectAdvance", getProjectAdvance()));
		if(getBonusPayment() != null) sb.append(__wrapDecimal(count++, "bonusPayment", getBonusPayment()));
		if(getIntegralReturn() != null) sb.append(__wrapDecimal(count++, "integralReturn", getIntegralReturn()));
		if(getViolationCharges() != null) sb.append(__wrapDecimal(count++, "violationCharges", getViolationCharges()));
		if(getBenefits() != null) sb.append(__wrapDecimal(count++, "benefits", getBenefits()));
		if(getBenefitsYear() != null) sb.append(__wrapDecimal(count++, "benefitsYear", getBenefitsYear()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getGradeId() != null) sb.append(__wrapNumber(count++, "gradeId", getGradeId()));
		if (getPerformanceBonus() != null)
			sb.append(__wrapDecimal(count++, "performanceBonus", getPerformanceBonus()));
		if (getAttendanceDeduct() != null)
			sb.append(__wrapDecimal(count++, "attendanceDeduct", getAttendanceDeduct()));
		if (getPmPerformanceAward() != null)
			sb.append(__wrapDecimal(count++, "pmPerformanceAward", getPmPerformanceAward()));
		if (getPmPerformanceDeduct() != null)
			sb.append(__wrapDecimal(count++, "pmPerformanceDeduct", getPmPerformanceDeduct()));
		if (getProjectPerformance() != null)
			sb.append(__wrapDecimal(count++, "projectPerformance", getProjectPerformance()));
		if (getContractChange() != null)
			sb.append(__wrapDecimal(count++, "contractChange", getContractChange()));
		if (getPlateChangeAchieve() != null)
			sb.append(__wrapDecimal(count++, "plateChangeAchieve", getPlateChangeAchieve()));
		if (getPlateChangePay() != null)
			sb.append(__wrapDecimal(count++, "plateChangePay", getPlateChangePay()));
		if (getProjectPerformancePay() != null)
			sb.append(__wrapDecimal(count++, "projectPerformancePay", getProjectPerformancePay()));
		if (getContractDistributionIncome() != null)
			sb.append(__wrapDecimal(count++, "contractDistributionIncome", getContractDistributionIncome()));
		if (getContractDistributionExpenditure() != null)
			sb.append(__wrapDecimal(count++, "contractDistributionExpenditure", getContractDistributionExpenditure()));
		if (getOutputAccount() != null)
			sb.append(__wrapDecimal(count++, "outputAccount", getOutputAccount()));
		if (getDepDeploy() != null)
			sb.append(__wrapDecimal(count++, "depDeploy", getDepDeploy()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeReportRecordId")) != null) setEmployeeReportRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if ((val = values.get("leftIntegral")) != null)
			setLeftIntegral(__getDecimal(val));
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("managerProjectIntegral")) != null) setManagerProjectIntegral(__getDecimal(val));  
		if((val = values.get("salaryAdvance")) != null) setSalaryAdvance(__getDecimal(val));  
		if((val = values.get("salaryReturn")) != null) setSalaryReturn(__getDecimal(val));  
		if((val = values.get("salary")) != null) setSalary(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("isLock")) != null) setIsLock(__getBoolean(val));
		if((val = values.get("projectAdvance")) != null) setProjectAdvance(__getDecimal(val));  
		if((val = values.get("bonusPayment")) != null) setBonusPayment(__getDecimal(val));  
		if((val = values.get("integralReturn")) != null) setIntegralReturn(__getDecimal(val));  
		if((val = values.get("violationCharges")) != null) setViolationCharges(__getDecimal(val));  
		if((val = values.get("benefits")) != null) setBenefits(__getDecimal(val));
		if((val = values.get("benefitsYear")) != null) setBenefitsYear(__getDecimal(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("gradeId")) != null) setGradeId(__getInt(val)); 
		if ((val = values.get("performanceBonus")) != null)
			setPerformanceBonus(__getDecimal(val));
		if ((val = values.get("attendanceDeduct")) != null)
			setAttendanceDeduct(__getDecimal(val));
		if ((val = values.get("pmPerformanceAward")) != null)
			setPmPerformanceAward(__getDecimal(val));
		if ((val = values.get("pmPerformanceDeduct")) != null)
			setPmPerformanceDeduct(__getDecimal(val));
		if ((val = values.get("projectPerformance")) != null)
			setProjectPerformance(__getDecimal(val));
		if ((val = values.get("contractChange")) != null)
			setContractChange(__getDecimal(val));
		if ((val = values.get("plateChangeAchieve")) != null)
			setPlateChangeAchieve(__getDecimal(val));
		if ((val = values.get("plateChangePay")) != null)
			setPlateChangePay(__getDecimal(val));
		if ((val = values.get("projectPerformancePay")) != null)
			setProjectPerformancePay(__getDecimal(val));
		if ((val = values.get("contractDistributionIncome")) != null)
			setContractDistributionIncome(__getDecimal(val));
		if ((val = values.get("contractDistributionExpenditure")) != null)
			setContractDistributionExpenditure(__getDecimal(val));
		if ((val = values.get("depDeploy")) != null)
			setDepDeploy(__getDecimal(val));
		if ((val = values.get("outputAccount")) != null)
			setOutputAccount(__getDecimal(val));
	}

	protected java.lang.Integer  __employee_report_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __employee_no ;
	protected java.math.BigDecimal __left_integral;
	protected java.math.BigDecimal  __achieve_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __manager_project_integral ;
	protected java.math.BigDecimal  __salary_advance ;
	protected java.math.BigDecimal  __salary_return ;
	protected java.math.BigDecimal  __salary ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.util.Date  __record_date ;
	protected java.lang.Boolean  __is_lock ;
	protected java.math.BigDecimal  __project_advance ;
	protected java.math.BigDecimal  __bonus_payment ;
	protected java.math.BigDecimal  __integral_return ;
	protected java.math.BigDecimal  __violation_charges ;
	protected java.math.BigDecimal  __benefits ;
	protected java.math.BigDecimal  __benefits_year ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __grade_id ;
	protected java.math.BigDecimal __performance_bonus;
	protected java.math.BigDecimal __attendance_deduct;
	protected java.math.BigDecimal __pm_performance_award;
	protected java.math.BigDecimal __pm_performance_deduct;
	protected java.math.BigDecimal __project_performance;
	protected java.math.BigDecimal __contract_change;
	protected java.math.BigDecimal __plate_change_achieve;
	protected java.math.BigDecimal __plate_change_pay;
	protected java.math.BigDecimal __project_performance_pay;
	protected java.math.BigDecimal __contract_distribution_income;
	protected java.math.BigDecimal __contract_distribution_expenditure;
	protected java.math.BigDecimal __dep_deploy;
	protected java.math.BigDecimal __output_account;
}
