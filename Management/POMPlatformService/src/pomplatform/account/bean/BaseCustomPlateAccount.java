package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCustomPlateAccount extends GenericBase
		implements BaseFactory<BaseCustomPlateAccount>, Comparable<BaseCustomPlateAccount> {

	public static BaseCustomPlateAccount newInstance() {
		return new BaseCustomPlateAccount();
	}

	@Override
	public BaseCustomPlateAccount make() {
		BaseCustomPlateAccount b = new BaseCustomPlateAccount();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id";
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral";
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral";
	public final static java.lang.String CS_PROJECT_SETTLEMENT = "project_settlement";
	public final static java.lang.String CS_COMPANY_SUBSIDY = "company_subsidy";
	public final static java.lang.String CS_EMPLOYEE_ACHIEVE_INTEGRAL_RETURN = "employee_achieve_integral_return";
	public final static java.lang.String CS_SALARY_RETURN = "salary_return";
	public final static java.lang.String CS_SALARY_ADVANCE = "salary_advance";
	public final static java.lang.String CS_MANAGER_PROJECT_INTEGRAL = "manager_project_integral";
	public final static java.lang.String CS_PLATE_COST = "plate_cost";
	public final static java.lang.String CS_PROJECT_ADVANCE = "project_advance";
	public final static java.lang.String CS_COMPANY_FEE = "company_fee";
	public final static java.lang.String CS_VIOLATION_CHARGES = "violation_charges";
	public final static java.lang.String CS_COLLABORATIVE_ACHIEVE = "collaborative_achieve";//协作收入(品质管理费的收入)
	public final static java.lang.String CS_COLLABORATIVE_PAY = "collaborative_pay";//协作支出(品质管理费的支出)
	public final static java.lang.String CS_COMPANY_ADVANCE = "company_advance";//公司借款
	public final static java.lang.String CS_COMPANY_REFUND = "company_refund";//公司还款
	public final static java.lang.String CS_PERFORMANCE_BONUS = "performance_bonus";//绩效奖金
	public final static java.lang.String CS_DEVELOP_PROJECT = "develop_project";//研发项目
	public final static java.lang.String CS_MANAGE_PROJECT = "manage_project";//管理项目
	public final static java.lang.String CS_ATTENDANCE_DEDUCT = "attendance_deduct";//考勤扣款
	public final static java.lang.String CS_CONTRACT_CHANGE = "contract_change";//合同变更
	public final static java.lang.String CS_END_PROJECT = "end_project";//项目结项
	public final static java.lang.String CS_SALE_INTEGRAL = "sale_integral";//销售积分
	public final static java.lang.String CS_SEND_ACHIEVE = "send_achieve";//分配收入
	public final static java.lang.String CS_SEND_PAY = "send_pay";//分配支出
	public final static java.lang.String CS_EMPLOYEE_COST = "employee_cost";//人工成本
	public final static java.lang.String CS_CONTRACT_DISTRIBUTION_INCOME = "contract_distribution_income";//提成收入
	public final static java.lang.String CS_CONTRACT_DISTRIBUTION_EXPENDITURE = "contract_distribution_expenditure";//提成支出
	public final static java.lang.String CS_PROJECT_PERFORMANCE = "project_performance";//项目绩效收入
	public final static java.lang.String CS_PROJECT_PERFORMANCE_PAY = "project_performance_pay";//项目绩效支出
	public final static java.lang.String CS_DEP_DEPLOY = "dep_deploy";//部门调配
	public final static java.lang.String CS_OUTPUT_ACCOUNT = "output_account";//产值结算
	
	public final static java.lang.String ALL_CAPTIONS = "业务部门,实时余额,价值积分,项目结算,公司补贴,积分回收,积分还款,资源绩效,协作收入,公司借款,考勤扣款,积分借款,奖金补贴,运营成本,项目补贴,公司费用,协作支出,公司还款,绩效奖金,研发项目,管理项目,合同变更,项目结项,销售积分,分配收入,分配支出,人工成本,提成收入,提成支出,项目绩效收入,项目绩效支出,部门调配,产值结算";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
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

	public void setAchieveIntegral(java.math.BigDecimal value) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getProjectSettlement() {
		return this.__project_settlement;
	}

	public void setProjectSettlement(java.math.BigDecimal value) {
		this.__project_settlement = value;
	}

	public java.math.BigDecimal getCompanySubsidy() {
		return this.__company_subsidy;
	}

	public void setCompanySubsidy(java.math.BigDecimal value) {
		this.__company_subsidy = value;
	}

	public java.math.BigDecimal getEmployeeAchieveIntegralReturn() {
		return this.__employee_achieve_integral_return;
	}

	public void setEmployeeAchieveIntegralReturn(java.math.BigDecimal value) {
		this.__employee_achieve_integral_return = value;
	}

	public java.math.BigDecimal getSalaryReturn() {
		return this.__salary_return;
	}

	public void setSalaryReturn(java.math.BigDecimal value) {
		this.__salary_return = value;
	}

	public java.math.BigDecimal getSalaryAdvance() {
		return this.__salary_advance;
	}

	public void setSalaryAdvance(java.math.BigDecimal value) {
		this.__salary_advance = value;
	}

	public java.math.BigDecimal getManagerProjectIntegral() {
		return this.__manager_project_integral;
	}

	public void setManagerProjectIntegral(java.math.BigDecimal value) {
		this.__manager_project_integral = value;
	}

	public java.math.BigDecimal getPlateCost() {
		return this.__plate_cost;
	}

	public void setPlateCost(java.math.BigDecimal value) {
		this.__plate_cost = value;
	}

	public java.math.BigDecimal getProjectAdvance() {
		return this.__project_advance;
	}

	public void setProjectAdvance(java.math.BigDecimal value) {
		this.__project_advance = value;
	}
	

	public java.math.BigDecimal getCompanyFee() {
		return __company_fee;
	}

	public void setCompanyFee(java.math.BigDecimal value) {
		this.__company_fee = value;
	}

	public java.math.BigDecimal getViolationCharges() {
		return __violation_charges;
	}

	public void setViolationCharges(java.math.BigDecimal value) {
		this.__violation_charges = value;
	}
	
	public java.math.BigDecimal getCollaborativeAchieve() {
		return __collaborative_achieve;
	}
	
	public void setCollaborativeAchieve(java.math.BigDecimal value) {
		this.__collaborative_achieve = value;
	}
	
	public java.math.BigDecimal getCollaborativePay() {
		return __collaborative_pay;
	}
	
	public void setCollaborativePay(java.math.BigDecimal value) {
		this.__collaborative_pay = value;
	}
	
	public java.math.BigDecimal getCompanyAdvance() {
		return __company_advance;
	}
	
	public void setCompanyAdvance(java.math.BigDecimal value) {
		this.__company_advance = value;
	}
	
	public java.math.BigDecimal getCompanyRefund() {
		return __company_refund;
	}
	
	public void setCompanyRefund(java.math.BigDecimal value) {
		this.__company_refund = value;
	}
	
	public java.math.BigDecimal getPerformanceBonus() {
		return __performance_bonus;
	}
	
	public void setPerformanceBonus(java.math.BigDecimal value) {
		this.__performance_bonus = value;
	}
	
	public java.math.BigDecimal getDevelopProject() {
		return __develop_project;
	}
	
	public void setDevelopProject(java.math.BigDecimal value) {
		this.__develop_project = value;
	}
	
	public java.math.BigDecimal getManageProject() {
		return __manage_project;
	}
	
	public void setManageProject(java.math.BigDecimal value) {
		this.__manage_project = value;
	}
	
	public java.math.BigDecimal getAttendanceDeduct() {
		return __attendance_deduct;
	}
	
	public void setAttendanceDeduct(java.math.BigDecimal value) {
		this.__attendance_deduct = value;
	}
	
	public java.math.BigDecimal getContractChange() {
		return __contract_change;
	}
	
	public void setContractChange(java.math.BigDecimal value) {
		this.__contract_change = value;
	}

	public java.math.BigDecimal getEndProject() {
		return __end_project;
	}

	public void setEndProject(java.math.BigDecimal __end_project) {
		this.__end_project = __end_project;
	}
	
	public java.math.BigDecimal getSaleIntegral() {
		return __sale_integral;
	}
	
	public void setSaleIntegral(java.math.BigDecimal __sale_integral) {
		this.__sale_integral = __sale_integral;
	}
	
	public java.math.BigDecimal getSendAchieve() {
		return __send_achieve;
	}
	
	public void setSendAchieve(java.math.BigDecimal __send_achieve) {
		this.__send_achieve = __send_achieve;
	}
	
	public java.math.BigDecimal getSendPay() {
		return __send_pay;
	}
	
	public void setSendPay(java.math.BigDecimal __send_pay) {
		this.__send_pay = __send_pay;
	}
	
	public java.math.BigDecimal getEmployeeCost() {
		return __employee_cost;
	}
	
	public void setEmployeeCost(java.math.BigDecimal __employee_cost) {
		this.__employee_cost = __employee_cost;
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
	
	public java.math.BigDecimal getProjectPerformance() {
		return __project_performance;
	}
	
	public void setProjectPerformance(java.math.BigDecimal value) {
		this.__project_performance = value;
	}

	public java.math.BigDecimal getProjectPerformancePay() {
		return __project_performance_pay;
	}
	
	public void setProjectPerformancePay(java.math.BigDecimal value) {
		this.__project_performance_pay = value;
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
	
	public void cloneCopy(BaseCustomPlateAccount __bean) {
		__bean.setPlateId(getPlateId());
		__bean.setLeftIntegral(getLeftIntegral());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setProjectSettlement(getProjectSettlement());
		__bean.setCompanySubsidy(getCompanySubsidy());
		__bean.setEmployeeAchieveIntegralReturn(getEmployeeAchieveIntegralReturn());
		__bean.setSalaryReturn(getSalaryReturn());
		__bean.setSalaryAdvance(getSalaryAdvance());
		__bean.setManagerProjectIntegral(getManagerProjectIntegral());
		__bean.setPlateCost(getPlateCost());
		__bean.setProjectAdvance(getProjectAdvance());
		__bean.setCompanyFee(getCompanyFee());
		__bean.setViolationCharges(getViolationCharges());
		__bean.setCollaborativeAchieve(getCollaborativeAchieve());
		__bean.setCollaborativePay(getCollaborativePay());
		__bean.setCompanyAdvance(getCompanyAdvance());
		__bean.setCompanyRefund(getCompanyRefund());
		__bean.setPerformanceBonus(getPerformanceBonus());
		__bean.setDevelopProject(getDevelopProject());
		__bean.setManageProject(getManageProject());
		__bean.setAttendanceDeduct(getAttendanceDeduct());
		__bean.setContractChange(getContractChange());
		__bean.setEndProject(getEndProject());
		__bean.setSaleIntegral(getSaleIntegral());
		__bean.setSendAchieve(getSendAchieve());
		__bean.setSendPay(getSendPay());
		__bean.setEmployeeCost(getEmployeeCost());
		__bean.setContractDistributionExpenditure(getContractDistributionExpenditure());
		__bean.setContractDistributionIncome(getContractDistributionIncome());
		__bean.setProjectPerformance(getProjectPerformance());
		__bean.setProjectPerformancePay(getProjectPerformancePay());
		__bean.setDepDeploy(getDepDeploy());
		__bean.setOutputAccount(getOutputAccount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1",
				String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getProjectSettlement() == null ? "" : getProjectSettlement());
		sb.append(",");
		sb.append(getCompanySubsidy() == null ? "" : getCompanySubsidy());
		sb.append(",");
		sb.append(getEmployeeAchieveIntegralReturn() == null ? "" : getEmployeeAchieveIntegralReturn());
		sb.append(",");
		sb.append(getSalaryReturn() == null ? "" : getSalaryReturn());
		sb.append(",");
		sb.append(getViolationCharges() == null ? "" : getViolationCharges());
		sb.append(",");
		sb.append(getCollaborativeAchieve() == null ? "" : getCollaborativeAchieve());
		sb.append(",");
		sb.append(getCompanyAdvance() == null ? "" : getCompanyAdvance());
		sb.append(",");
		sb.append(getAttendanceDeduct() == null ? "" : getAttendanceDeduct());
		sb.append(",");
		sb.append(getEndProject() == null ? "" : getEndProject());
		sb.append(",");
		sb.append(getSaleIntegral() == null ? "" : getSaleIntegral());
		sb.append(",");
		sb.append(getSendAchieve() == null ? "" : getSendAchieve());
		sb.append(",");
		sb.append(getProjectPerformance() == null ? "" : getProjectPerformance());
		sb.append(",");
		sb.append(getSalaryAdvance() == null ? "" : getSalaryAdvance());
		sb.append(",");
		sb.append(getManagerProjectIntegral() == null ? "" : getManagerProjectIntegral());
		sb.append(",");
		sb.append(getPlateCost() == null ? "" : getPlateCost());
		sb.append(",");
		sb.append(getProjectAdvance() == null ? "" : getProjectAdvance());
		sb.append(",");
		sb.append(getCompanyFee() == null ? "" : getCompanyFee());
		sb.append(",");
		sb.append(getCollaborativePay() == null ? "" : getCollaborativePay());
		sb.append(",");
		sb.append(getCompanyRefund() == null ? "" : getCompanyRefund());
		sb.append(",");
		sb.append(getPerformanceBonus() == null ? "" : getPerformanceBonus());
		sb.append(",");
		sb.append(getDevelopProject() == null ? "" : getDevelopProject());
		sb.append(",");
		sb.append(getManageProject() == null ? "" : getManageProject());
		sb.append(",");
		sb.append(getContractChange() == null ? "" : getContractChange());
		sb.append(",");
		sb.append(getSendPay() == null ? "" : getSendPay());
		sb.append(",");
		sb.append(getEmployeeCost() == null ? "" : getEmployeeCost());
		sb.append(",");
		sb.append(getContractDistributionIncome() == null ? "" : getContractDistributionIncome());
		sb.append(",");
		sb.append(getContractDistributionExpenditure() == null ? "" : getContractDistributionExpenditure());
		sb.append(",");
		sb.append(getProjectPerformancePay() == null ? "" : getProjectPerformancePay());
		sb.append(",");
		sb.append(getDepDeploy() == null ? "" : getDepDeploy());
		sb.append(",");
		sb.append(getOutputAccount() == null ? "" : getOutputAccount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCustomPlateAccount o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_settlement);
		hash = 97 * hash + Objects.hashCode(this.__company_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__employee_achieve_integral_return);
		hash = 97 * hash + Objects.hashCode(this.__salary_return);
		hash = 97 * hash + Objects.hashCode(this.__salary_advance);
		hash = 97 * hash + Objects.hashCode(this.__manager_project_integral);
		hash = 97 * hash + Objects.hashCode(this.__plate_cost);
		hash = 97 * hash + Objects.hashCode(this.__project_advance);
		hash = 97 * hash + Objects.hashCode(this.__company_fee);
		hash = 97 * hash + Objects.hashCode(this.__violation_charges);
		hash = 97 * hash + Objects.hashCode(this.__collaborative_achieve);
		hash = 97 * hash + Objects.hashCode(this.__collaborative_pay);
		hash = 97 * hash + Objects.hashCode(this.__company_advance);
		hash = 97 * hash + Objects.hashCode(this.__company_refund);
		hash = 97 * hash + Objects.hashCode(this.__performance_bonus);
		hash = 97 * hash + Objects.hashCode(this.__develop_project);
		hash = 97 * hash + Objects.hashCode(this.__manage_project);
		hash = 97 * hash + Objects.hashCode(this.__attendance_deduct);
		hash = 97 * hash + Objects.hashCode(this.__contract_change);
		hash = 97 * hash + Objects.hashCode(this.__end_project);
		hash = 97 * hash + Objects.hashCode(this.__sale_integral);
		hash = 97 * hash + Objects.hashCode(this.__send_achieve);
		hash = 97 * hash + Objects.hashCode(this.__send_pay);
		hash = 97 * hash + Objects.hashCode(this.__employee_cost);
		hash = 97 * hash + Objects.hashCode(this.__contract_distribution_income);
		hash = 97 * hash + Objects.hashCode(this.__contract_distribution_expenditure);
		hash = 97 * hash + Objects.hashCode(this.__project_performance);
		hash = 97 * hash + Objects.hashCode(this.__project_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__dep_deploy);
		hash = 97 * hash + Objects.hashCode(this.__output_account);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BaseCustomPlateAccount o = (BaseCustomPlateAccount) obj;
		if (!Objects.equals(this.__plate_id, o.getPlateId()))
			return false;
		if (!Objects.equals(this.__left_integral, o.getLeftIntegral()))
			return false;
		if (!Objects.equals(this.__achieve_integral, o.getAchieveIntegral()))
			return false;
		if (!Objects.equals(this.__project_settlement, o.getProjectSettlement()))
			return false;
		if (!Objects.equals(this.__company_subsidy, o.getCompanySubsidy()))
			return false;
		if (!Objects.equals(this.__employee_achieve_integral_return, o.getEmployeeAchieveIntegralReturn()))
			return false;
		if (!Objects.equals(this.__salary_return, o.getSalaryReturn()))
			return false;
		if (!Objects.equals(this.__salary_advance, o.getSalaryAdvance()))
			return false;
		if (!Objects.equals(this.__manager_project_integral, o.getManagerProjectIntegral()))
			return false;
		if (!Objects.equals(this.__plate_cost, o.getPlateCost()))
			return false;
		if (!Objects.equals(this.__project_advance, o.getProjectAdvance()))
			return false;
		if (!Objects.equals(this.__company_fee, o.getCompanyFee()))
			return false;
		if (!Objects.equals(this.__violation_charges, o.getViolationCharges()))
			return false;
		if (!Objects.equals(this.__collaborative_achieve, o.getCollaborativeAchieve()))
			return false;
		if (!Objects.equals(this.__collaborative_pay, o.getCollaborativePay()))
			return false;
		if (!Objects.equals(this.__company_advance, o.getCompanyAdvance()))
			return false;
		if (!Objects.equals(this.__company_refund, o.getCompanyRefund()))
			return false;
		if (!Objects.equals(this.__performance_bonus, o.getPerformanceBonus()))
			return false;
		if (!Objects.equals(this.__develop_project, o.getDevelopProject()))
			return false;
		if (!Objects.equals(this.__manage_project, o.getManageProject()))
			return false;
		if (!Objects.equals(this.__attendance_deduct, o.getAttendanceDeduct()))
			return false;
		if (!Objects.equals(this.__contract_change, o.getContractChange()))
			return false;
		if (!Objects.equals(this.__end_project, o.getEndProject()))
			return false;
		if (!Objects.equals(this.__sale_integral, o.getSaleIntegral()))
			return false;
		if (!Objects.equals(this.__send_achieve, o.getSendAchieve()))
			return false;
		if (!Objects.equals(this.__send_pay, o.getSendPay()))
			return false;
		if (!Objects.equals(this.__employee_cost, o.getEmployeeCost()))
			return false;
		if (!Objects.equals(this.__contract_distribution_income, o.getContractDistributionIncome()))
			return false;
		if (!Objects.equals(this.__contract_distribution_expenditure, o.getContractDistributionExpenditure()))
			return false;
		if (!Objects.equals(this.__project_performance, o.getProjectPerformance()))
			return false;
		if (!Objects.equals(this.__project_performance_pay, o.getProjectPerformancePay()))
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
		if (getPlateId() != null)
			sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if (getLeftIntegral() != null)
			sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		if (getAchieveIntegral() != null)
			sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if (getProjectSettlement() != null)
			sb.append(__wrapDecimal(count++, "projectSettlement", getProjectSettlement()));
		if (getCompanySubsidy() != null)
			sb.append(__wrapDecimal(count++, "companySubsidy", getCompanySubsidy()));
		if (getEmployeeAchieveIntegralReturn() != null)
			sb.append(__wrapDecimal(count++, "employeeAchieveIntegralReturn", getEmployeeAchieveIntegralReturn()));
		if (getSalaryReturn() != null)
			sb.append(__wrapDecimal(count++, "salaryReturn", getSalaryReturn()));
		if (getSalaryAdvance() != null)
			sb.append(__wrapDecimal(count++, "salaryAdvance", getSalaryAdvance()));
		if (getManagerProjectIntegral() != null)
			sb.append(__wrapDecimal(count++, "managerProjectIntegral", getManagerProjectIntegral()));
		if (getPlateCost() != null)
			sb.append(__wrapDecimal(count++, "plateCost", getPlateCost()));
		if (getProjectAdvance() != null)
			sb.append(__wrapDecimal(count++, "projectAdvance", getProjectAdvance()));
		if (getCompanyFee() != null)
			sb.append(__wrapDecimal(count++, "companyFee", getCompanyFee()));
		if (getViolationCharges() != null)
			sb.append(__wrapDecimal(count++, "violationCharges", getViolationCharges()));
		if (getCollaborativeAchieve() != null)
			sb.append(__wrapDecimal(count++, "collaborativeAchieve", getCollaborativeAchieve()));
		if (getCollaborativePay() != null)
			sb.append(__wrapDecimal(count++, "collaborativePay", getCollaborativePay()));
		if (getCompanyAdvance() != null)
			sb.append(__wrapDecimal(count++, "companyAdvance", getCompanyAdvance()));
		if (getCompanyRefund() != null)
			sb.append(__wrapDecimal(count++, "companyRefund", getCompanyRefund()));
		if (getPerformanceBonus() != null)
			sb.append(__wrapDecimal(count++, "performanceBonus", getPerformanceBonus()));
		if (getDevelopProject() != null)
			sb.append(__wrapDecimal(count++, "developProject", getDevelopProject()));
		if (getManageProject() != null)
			sb.append(__wrapDecimal(count++, "manageProject", getManageProject()));
		if (getAttendanceDeduct() != null)
			sb.append(__wrapDecimal(count++, "attendanceDeduct", getAttendanceDeduct()));
		if (getContractChange() != null)
			sb.append(__wrapDecimal(count++, "contractChange", getContractChange()));
		if (getEndProject() != null)
			sb.append(__wrapDecimal(count++, "endProject", getEndProject()));
		if (getSaleIntegral() != null)
			sb.append(__wrapDecimal(count++, "saleIntegral", getSaleIntegral()));
		if (getSendAchieve() != null)
			sb.append(__wrapDecimal(count++, "sendAchieve", getSendAchieve()));
		if (getSendPay() != null)
			sb.append(__wrapDecimal(count++, "sendPay", getSendPay()));
		if (getEmployeeCost() != null)
			sb.append(__wrapDecimal(count++, "employeeCost", getEmployeeCost()));
		if (getContractDistributionIncome() != null)
			sb.append(__wrapDecimal(count++, "contractDistributionIncome", getContractDistributionIncome()));
		if (getContractDistributionExpenditure() != null)
			sb.append(__wrapDecimal(count++, "contractDistributionExpenditure", getContractDistributionExpenditure()));
		if (getProjectPerformance() != null)
			sb.append(__wrapDecimal(count++, "projectPerformance", getProjectPerformance()));
		if (getProjectPerformancePay() != null)
			sb.append(__wrapDecimal(count++, "projectPerformancePay", getProjectPerformancePay()));
		if (getOutputAccount() != null)
			sb.append(__wrapDecimal(count++, "outputAccount", getOutputAccount()));
		if (getDepDeploy() != null)
			sb.append(__wrapDecimal(count++, "depDeploy", getDepDeploy()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values) {
		Object val;
		if ((val = values.get("plateId")) != null)
			setPlateId(__getInt(val));
		if ((val = values.get("leftIntegral")) != null)
			setLeftIntegral(__getDecimal(val));
		if ((val = values.get("achieveIntegral")) != null)
			setAchieveIntegral(__getDecimal(val));
		if ((val = values.get("projectSettlement")) != null)
			setProjectSettlement(__getDecimal(val));
		if ((val = values.get("companySubsidy")) != null)
			setCompanySubsidy(__getDecimal(val));
		if ((val = values.get("employeeAchieveIntegralReturn")) != null)
			setEmployeeAchieveIntegralReturn(__getDecimal(val));
		if ((val = values.get("salaryReturn")) != null)
			setSalaryReturn(__getDecimal(val));
		if ((val = values.get("salaryAdvance")) != null)
			setSalaryAdvance(__getDecimal(val));
		if ((val = values.get("managerProjectIntegral")) != null)
			setManagerProjectIntegral(__getDecimal(val));
		if ((val = values.get("plateCost")) != null)
			setPlateCost(__getDecimal(val));
		if ((val = values.get("projectAdvance")) != null)
			setProjectAdvance(__getDecimal(val));
		if ((val = values.get("companyFee")) != null)
			setCompanyFee(__getDecimal(val));
		if ((val = values.get("violationCharges")) != null)
			setViolationCharges(__getDecimal(val));
		if ((val = values.get("collaborativeAchieve")) != null)
			setCollaborativeAchieve(__getDecimal(val));
		if ((val = values.get("collaborativePay")) != null)
			setCollaborativePay(__getDecimal(val));
		if ((val = values.get("companyAdvance")) != null)
			setCompanyAdvance(__getDecimal(val));
		if ((val = values.get("companyRefund")) != null)
			setCompanyRefund(__getDecimal(val));
		if ((val = values.get("performanceBonus")) != null)
			setPerformanceBonus(__getDecimal(val));
		if ((val = values.get("developProject")) != null)
			setDevelopProject(__getDecimal(val));
		if ((val = values.get("manageProject")) != null)
			setManageProject(__getDecimal(val));
		if ((val = values.get("attendanceDeduct")) != null)
			setAttendanceDeduct(__getDecimal(val));
		if ((val = values.get("contractChange")) != null)
			setContractChange(__getDecimal(val));
		if ((val = values.get("endProject")) != null)
			setEndProject(__getDecimal(val));
		if ((val = values.get("saleIntegral")) != null)
			setSaleIntegral(__getDecimal(val));
		if ((val = values.get("sendAchieve")) != null)
			setSendAchieve(__getDecimal(val));
		if ((val = values.get("sendPay")) != null)
			setSendPay(__getDecimal(val));
		if ((val = values.get("employeeCost")) != null)
			setEmployeeCost(__getDecimal(val));
		if ((val = values.get("contractDistributionIncome")) != null)
			setContractDistributionIncome(__getDecimal(val));
		if ((val = values.get("contractDistributionExpenditure")) != null)
			setContractDistributionExpenditure(__getDecimal(val));
		if ((val = values.get("projectPerformance")) != null)
			setProjectPerformance(__getDecimal(val));
		if ((val = values.get("projectPerformancePay")) != null)
			setProjectPerformancePay(__getDecimal(val));
		if ((val = values.get("depDeploy")) != null)
			setDepDeploy(__getDecimal(val));
		if ((val = values.get("outputAccount")) != null)
			setOutputAccount(__getDecimal(val));
	}

	protected java.lang.Integer __plate_id;
	protected java.math.BigDecimal __left_integral;
	protected java.math.BigDecimal __achieve_integral;
	protected java.math.BigDecimal __project_settlement;
	protected java.math.BigDecimal __company_subsidy;
	protected java.math.BigDecimal __employee_achieve_integral_return;
	protected java.math.BigDecimal __salary_return;
	protected java.math.BigDecimal __salary_advance;
	protected java.math.BigDecimal __manager_project_integral;
	protected java.math.BigDecimal __plate_cost;
	protected java.math.BigDecimal __project_advance;
	protected java.math.BigDecimal __company_fee;
	protected java.math.BigDecimal __violation_charges;
	protected java.math.BigDecimal __collaborative_achieve;
	protected java.math.BigDecimal __collaborative_pay;
	protected java.math.BigDecimal __company_advance;
	protected java.math.BigDecimal __company_refund;
	protected java.math.BigDecimal __performance_bonus;
	protected java.math.BigDecimal __develop_project;
	protected java.math.BigDecimal __manage_project;
	protected java.math.BigDecimal __attendance_deduct;
	protected java.math.BigDecimal __contract_change;
	protected java.math.BigDecimal __end_project;
	protected java.math.BigDecimal __sale_integral;
	protected java.math.BigDecimal __send_achieve;
	protected java.math.BigDecimal __send_pay;
	protected java.math.BigDecimal __employee_cost;
	protected java.math.BigDecimal __contract_distribution_income;
	protected java.math.BigDecimal __contract_distribution_expenditure;
	protected java.math.BigDecimal __project_performance;
	protected java.math.BigDecimal __project_performance_pay;
	protected java.math.BigDecimal __dep_deploy;
	protected java.math.BigDecimal __output_account;
}
