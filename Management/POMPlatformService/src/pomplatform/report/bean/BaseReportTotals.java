package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportTotals extends GenericBase implements BaseFactory<BaseReportTotals>, Comparable<BaseReportTotals> 
{


	public static BaseReportTotals newInstance(){
		return new BaseReportTotals();
	}

	@Override
	public BaseReportTotals make(){
		BaseReportTotals b = new BaseReportTotals();
		return b;
	}

	public final static java.lang.String CS_REPORT_TOTAL_ID = "report_total_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH_REVENUE = "month_revenue" ;
	public final static java.lang.String CS_TOTAL_REVENUE = "total_revenue" ;
	public final static java.lang.String CS_MONTH_CAPITAL_PLATE = "month_capital_plate" ;
	public final static java.lang.String CS_TOTAL_CAPITAL_PLATE = "total_capital_plate" ;
	public final static java.lang.String CS_MONTH_CAPITAL_PROJECT = "month_capital_project" ;
	public final static java.lang.String CS_TOTAL_CAPITAL_PROJECT = "total_capital_project" ;
	public final static java.lang.String CS_MONTH_SURE_INTEGRAL_PLATE = "month_sure_integral_plate" ;
	public final static java.lang.String CS_TOTAL_SURE_INTEGRAL_PLATE = "total_sure_integral_plate" ;
	public final static java.lang.String CS_MONTH_SURE_INTEGRAL_PROJECT = "month_sure_integral_project" ;
	public final static java.lang.String CS_TOTAL_SURE_INTEGRAL_PROJECT = "total_sure_integral_project" ;
	public final static java.lang.String CS_MONTH_SALARY = "month_salary" ;
	public final static java.lang.String CS_TOTAL_SALARY = "total_salary" ;
	public final static java.lang.String CS_MONTH_COST_PLATE = "month_cost_plate" ;
	public final static java.lang.String CS_TOTAL_COST_PLATE = "total_cost_plate" ;
	public final static java.lang.String CS_MONTH_COST_PROJECT = "month_cost_project" ;
	public final static java.lang.String CS_TOTAL_COST_PROJECT = "total_cost_project" ;
	public final static java.lang.String CS_MONTH_COST_PROJECT_BEFORE = "month_cost_project_before" ;
	public final static java.lang.String CS_TOTAL_COST_PROJECT_BEFORE = "total_cost_project_before" ;
	public final static java.lang.String CS_MONTH_NEW_CONTRACT = "month_new_contract" ;
	public final static java.lang.String CS_TOTAL_NEW_CONTRACT = "total_new_contract" ;
	public final static java.lang.String CS_CONTRACT_TOTAL = "contract_total" ;
	public final static java.lang.String CS_AVERAGE_EMP_NUM = "average_emp_num" ;
	public final static java.lang.String CS_MIN_EMP_NUM = "min_emp_num" ;
	public final static java.lang.String CS_YEAR_AVERAGE_EMP_REVENUE = "year_average_emp_revenue" ;
	public final static java.lang.String CS_YEAR_CAPITAL = "year_capital" ;
	public final static java.lang.String CS_BENEFIT = "benefit" ;
	public final static java.lang.String CS_YEAR_REVENUE = "year_revenue" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,本月不含税营收,累计不含税营收,本月现金流(部门),累计现金流(部门),本月现金流(项目组),累计现金流(项目组),本月确认积分(部门),累计确认积分(部门),本月确认积分(项目组),累计确认积分(项目组),本月薪酬,累计薪酬,本月成本(部门),累计成本(部门),本月成本(项目),累计成本(项目),本月成本(前期项目),累计成本(前期项目),本月新签合同额,累计新签合同额,合同存量,累计平均人数,最低人数,年人均营收,年现金流,效益指数,年不含税营收";

	public java.lang.Integer getReportTotalId() {
		return this.__report_total_id;
	}

	public void setReportTotalId( java.lang.Integer value ) {
		this.__report_total_id = value;
	}

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

	public java.math.BigDecimal getMonthRevenue() {
		return this.__month_revenue;
	}

	public void setMonthRevenue( java.math.BigDecimal value ) {
		this.__month_revenue = value;
	}

	public java.math.BigDecimal getTotalRevenue() {
		return this.__total_revenue;
	}

	public void setTotalRevenue( java.math.BigDecimal value ) {
		this.__total_revenue = value;
	}

	public java.math.BigDecimal getMonthCapitalPlate() {
		return this.__month_capital_plate;
	}

	public void setMonthCapitalPlate( java.math.BigDecimal value ) {
		this.__month_capital_plate = value;
	}

	public java.math.BigDecimal getTotalCapitalPlate() {
		return this.__total_capital_plate;
	}

	public void setTotalCapitalPlate( java.math.BigDecimal value ) {
		this.__total_capital_plate = value;
	}

	public java.math.BigDecimal getMonthCapitalProject() {
		return this.__month_capital_project;
	}

	public void setMonthCapitalProject( java.math.BigDecimal value ) {
		this.__month_capital_project = value;
	}

	public java.math.BigDecimal getTotalCapitalProject() {
		return this.__total_capital_project;
	}

	public void setTotalCapitalProject( java.math.BigDecimal value ) {
		this.__total_capital_project = value;
	}

	public java.math.BigDecimal getMonthSureIntegralPlate() {
		return this.__month_sure_integral_plate;
	}

	public void setMonthSureIntegralPlate( java.math.BigDecimal value ) {
		this.__month_sure_integral_plate = value;
	}

	public java.math.BigDecimal getTotalSureIntegralPlate() {
		return this.__total_sure_integral_plate;
	}

	public void setTotalSureIntegralPlate( java.math.BigDecimal value ) {
		this.__total_sure_integral_plate = value;
	}

	public java.math.BigDecimal getMonthSureIntegralProject() {
		return this.__month_sure_integral_project;
	}

	public void setMonthSureIntegralProject( java.math.BigDecimal value ) {
		this.__month_sure_integral_project = value;
	}

	public java.math.BigDecimal getTotalSureIntegralProject() {
		return this.__total_sure_integral_project;
	}

	public void setTotalSureIntegralProject( java.math.BigDecimal value ) {
		this.__total_sure_integral_project = value;
	}

	public java.math.BigDecimal getMonthSalary() {
		return this.__month_salary;
	}

	public void setMonthSalary( java.math.BigDecimal value ) {
		this.__month_salary = value;
	}

	public java.math.BigDecimal getTotalSalary() {
		return this.__total_salary;
	}

	public void setTotalSalary( java.math.BigDecimal value ) {
		this.__total_salary = value;
	}

	public java.math.BigDecimal getMonthCostPlate() {
		return this.__month_cost_plate;
	}

	public void setMonthCostPlate( java.math.BigDecimal value ) {
		this.__month_cost_plate = value;
	}

	public java.math.BigDecimal getTotalCostPlate() {
		return this.__total_cost_plate;
	}

	public void setTotalCostPlate( java.math.BigDecimal value ) {
		this.__total_cost_plate = value;
	}

	public java.math.BigDecimal getMonthCostProject() {
		return this.__month_cost_project;
	}

	public void setMonthCostProject( java.math.BigDecimal value ) {
		this.__month_cost_project = value;
	}

	public java.math.BigDecimal getTotalCostProject() {
		return this.__total_cost_project;
	}

	public void setTotalCostProject( java.math.BigDecimal value ) {
		this.__total_cost_project = value;
	}

	public java.math.BigDecimal getMonthCostProjectBefore() {
		return this.__month_cost_project_before;
	}

	public void setMonthCostProjectBefore( java.math.BigDecimal value ) {
		this.__month_cost_project_before = value;
	}

	public java.math.BigDecimal getTotalCostProjectBefore() {
		return this.__total_cost_project_before;
	}

	public void setTotalCostProjectBefore( java.math.BigDecimal value ) {
		this.__total_cost_project_before = value;
	}

	public java.math.BigDecimal getMonthNewContract() {
		return this.__month_new_contract;
	}

	public void setMonthNewContract( java.math.BigDecimal value ) {
		this.__month_new_contract = value;
	}

	public java.math.BigDecimal getTotalNewContract() {
		return this.__total_new_contract;
	}

	public void setTotalNewContract( java.math.BigDecimal value ) {
		this.__total_new_contract = value;
	}

	public java.math.BigDecimal getContractTotal() {
		return this.__contract_total;
	}

	public void setContractTotal( java.math.BigDecimal value ) {
		this.__contract_total = value;
	}

	public java.lang.Integer getAverageEmpNum() {
		return this.__average_emp_num;
	}

	public void setAverageEmpNum( java.lang.Integer value ) {
		this.__average_emp_num = value;
	}

	public java.lang.Integer getMinEmpNum() {
		return this.__min_emp_num;
	}

	public void setMinEmpNum( java.lang.Integer value ) {
		this.__min_emp_num = value;
	}

	public java.math.BigDecimal getYearAverageEmpRevenue() {
		return this.__year_average_emp_revenue;
	}

	public void setYearAverageEmpRevenue( java.math.BigDecimal value ) {
		this.__year_average_emp_revenue = value;
	}

	public java.math.BigDecimal getYearCapital() {
		return this.__year_capital;
	}

	public void setYearCapital( java.math.BigDecimal value ) {
		this.__year_capital = value;
	}

	public java.math.BigDecimal getBenefit() {
		return this.__benefit;
	}

	public void setBenefit( java.math.BigDecimal value ) {
		this.__benefit = value;
	}

	public java.math.BigDecimal getYearRevenue() {
		return this.__year_revenue;
	}

	public void setYearRevenue( java.math.BigDecimal value ) {
		this.__year_revenue = value;
	}

	public void cloneCopy(BaseReportTotals __bean){
		__bean.setReportTotalId(getReportTotalId());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonthRevenue(getMonthRevenue());
		__bean.setTotalRevenue(getTotalRevenue());
		__bean.setMonthCapitalPlate(getMonthCapitalPlate());
		__bean.setTotalCapitalPlate(getTotalCapitalPlate());
		__bean.setMonthCapitalProject(getMonthCapitalProject());
		__bean.setTotalCapitalProject(getTotalCapitalProject());
		__bean.setMonthSureIntegralPlate(getMonthSureIntegralPlate());
		__bean.setTotalSureIntegralPlate(getTotalSureIntegralPlate());
		__bean.setMonthSureIntegralProject(getMonthSureIntegralProject());
		__bean.setTotalSureIntegralProject(getTotalSureIntegralProject());
		__bean.setMonthSalary(getMonthSalary());
		__bean.setTotalSalary(getTotalSalary());
		__bean.setMonthCostPlate(getMonthCostPlate());
		__bean.setTotalCostPlate(getTotalCostPlate());
		__bean.setMonthCostProject(getMonthCostProject());
		__bean.setTotalCostProject(getTotalCostProject());
		__bean.setMonthCostProjectBefore(getMonthCostProjectBefore());
		__bean.setTotalCostProjectBefore(getTotalCostProjectBefore());
		__bean.setMonthNewContract(getMonthNewContract());
		__bean.setTotalNewContract(getTotalNewContract());
		__bean.setContractTotal(getContractTotal());
		__bean.setAverageEmpNum(getAverageEmpNum());
		__bean.setMinEmpNum(getMinEmpNum());
		__bean.setYearAverageEmpRevenue(getYearAverageEmpRevenue());
		__bean.setYearCapital(getYearCapital());
		__bean.setBenefit(getBenefit());
		__bean.setYearRevenue(getYearRevenue());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonthRevenue() == null ? "" : getMonthRevenue());
		sb.append(",");
		sb.append(getTotalRevenue() == null ? "" : getTotalRevenue());
		sb.append(",");
		sb.append(getMonthCapitalPlate() == null ? "" : getMonthCapitalPlate());
		sb.append(",");
		sb.append(getTotalCapitalPlate() == null ? "" : getTotalCapitalPlate());
		sb.append(",");
		sb.append(getMonthCapitalProject() == null ? "" : getMonthCapitalProject());
		sb.append(",");
		sb.append(getTotalCapitalProject() == null ? "" : getTotalCapitalProject());
		sb.append(",");
		sb.append(getMonthSureIntegralPlate() == null ? "" : getMonthSureIntegralPlate());
		sb.append(",");
		sb.append(getTotalSureIntegralPlate() == null ? "" : getTotalSureIntegralPlate());
		sb.append(",");
		sb.append(getMonthSureIntegralProject() == null ? "" : getMonthSureIntegralProject());
		sb.append(",");
		sb.append(getTotalSureIntegralProject() == null ? "" : getTotalSureIntegralProject());
		sb.append(",");
		sb.append(getMonthSalary() == null ? "" : getMonthSalary());
		sb.append(",");
		sb.append(getTotalSalary() == null ? "" : getTotalSalary());
		sb.append(",");
		sb.append(getMonthCostPlate() == null ? "" : getMonthCostPlate());
		sb.append(",");
		sb.append(getTotalCostPlate() == null ? "" : getTotalCostPlate());
		sb.append(",");
		sb.append(getMonthCostProject() == null ? "" : getMonthCostProject());
		sb.append(",");
		sb.append(getTotalCostProject() == null ? "" : getTotalCostProject());
		sb.append(",");
		sb.append(getMonthCostProjectBefore() == null ? "" : getMonthCostProjectBefore());
		sb.append(",");
		sb.append(getTotalCostProjectBefore() == null ? "" : getTotalCostProjectBefore());
		sb.append(",");
		sb.append(getMonthNewContract() == null ? "" : getMonthNewContract());
		sb.append(",");
		sb.append(getTotalNewContract() == null ? "" : getTotalNewContract());
		sb.append(",");
		sb.append(getContractTotal() == null ? "" : getContractTotal());
		sb.append(",");
		sb.append(getAverageEmpNum() == null ? "" : getAverageEmpNum());
		sb.append(",");
		sb.append(getMinEmpNum() == null ? "" : getMinEmpNum());
		sb.append(",");
		sb.append(getYearAverageEmpRevenue() == null ? "" : getYearAverageEmpRevenue());
		sb.append(",");
		sb.append(getYearCapital() == null ? "" : getYearCapital());
		sb.append(",");
		sb.append(getBenefit() == null ? "" : getBenefit());
		sb.append(",");
		sb.append(getYearRevenue() == null ? "" : getYearRevenue());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportTotals o) {
		return __report_total_id == null ? -1 : __report_total_id.compareTo(o.getReportTotalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__report_total_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month_revenue);
		hash = 97 * hash + Objects.hashCode(this.__total_revenue);
		hash = 97 * hash + Objects.hashCode(this.__month_capital_plate);
		hash = 97 * hash + Objects.hashCode(this.__total_capital_plate);
		hash = 97 * hash + Objects.hashCode(this.__month_capital_project);
		hash = 97 * hash + Objects.hashCode(this.__total_capital_project);
		hash = 97 * hash + Objects.hashCode(this.__month_sure_integral_plate);
		hash = 97 * hash + Objects.hashCode(this.__total_sure_integral_plate);
		hash = 97 * hash + Objects.hashCode(this.__month_sure_integral_project);
		hash = 97 * hash + Objects.hashCode(this.__total_sure_integral_project);
		hash = 97 * hash + Objects.hashCode(this.__month_salary);
		hash = 97 * hash + Objects.hashCode(this.__total_salary);
		hash = 97 * hash + Objects.hashCode(this.__month_cost_plate);
		hash = 97 * hash + Objects.hashCode(this.__total_cost_plate);
		hash = 97 * hash + Objects.hashCode(this.__month_cost_project);
		hash = 97 * hash + Objects.hashCode(this.__total_cost_project);
		hash = 97 * hash + Objects.hashCode(this.__month_cost_project_before);
		hash = 97 * hash + Objects.hashCode(this.__total_cost_project_before);
		hash = 97 * hash + Objects.hashCode(this.__month_new_contract);
		hash = 97 * hash + Objects.hashCode(this.__total_new_contract);
		hash = 97 * hash + Objects.hashCode(this.__contract_total);
		hash = 97 * hash + Objects.hashCode(this.__average_emp_num);
		hash = 97 * hash + Objects.hashCode(this.__min_emp_num);
		hash = 97 * hash + Objects.hashCode(this.__year_average_emp_revenue);
		hash = 97 * hash + Objects.hashCode(this.__year_capital);
		hash = 97 * hash + Objects.hashCode(this.__benefit);
		hash = 97 * hash + Objects.hashCode(this.__year_revenue);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportTotals o = (BaseReportTotals)obj;
		if(!Objects.equals(this.__report_total_id, o.getReportTotalId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month_revenue, o.getMonthRevenue())) return false;
		if(!Objects.equals(this.__total_revenue, o.getTotalRevenue())) return false;
		if(!Objects.equals(this.__month_capital_plate, o.getMonthCapitalPlate())) return false;
		if(!Objects.equals(this.__total_capital_plate, o.getTotalCapitalPlate())) return false;
		if(!Objects.equals(this.__month_capital_project, o.getMonthCapitalProject())) return false;
		if(!Objects.equals(this.__total_capital_project, o.getTotalCapitalProject())) return false;
		if(!Objects.equals(this.__month_sure_integral_plate, o.getMonthSureIntegralPlate())) return false;
		if(!Objects.equals(this.__total_sure_integral_plate, o.getTotalSureIntegralPlate())) return false;
		if(!Objects.equals(this.__month_sure_integral_project, o.getMonthSureIntegralProject())) return false;
		if(!Objects.equals(this.__total_sure_integral_project, o.getTotalSureIntegralProject())) return false;
		if(!Objects.equals(this.__month_salary, o.getMonthSalary())) return false;
		if(!Objects.equals(this.__total_salary, o.getTotalSalary())) return false;
		if(!Objects.equals(this.__month_cost_plate, o.getMonthCostPlate())) return false;
		if(!Objects.equals(this.__total_cost_plate, o.getTotalCostPlate())) return false;
		if(!Objects.equals(this.__month_cost_project, o.getMonthCostProject())) return false;
		if(!Objects.equals(this.__total_cost_project, o.getTotalCostProject())) return false;
		if(!Objects.equals(this.__month_cost_project_before, o.getMonthCostProjectBefore())) return false;
		if(!Objects.equals(this.__total_cost_project_before, o.getTotalCostProjectBefore())) return false;
		if(!Objects.equals(this.__month_new_contract, o.getMonthNewContract())) return false;
		if(!Objects.equals(this.__total_new_contract, o.getTotalNewContract())) return false;
		if(!Objects.equals(this.__contract_total, o.getContractTotal())) return false;
		if(!Objects.equals(this.__average_emp_num, o.getAverageEmpNum())) return false;
		if(!Objects.equals(this.__min_emp_num, o.getMinEmpNum())) return false;
		if(!Objects.equals(this.__year_average_emp_revenue, o.getYearAverageEmpRevenue())) return false;
		if(!Objects.equals(this.__year_capital, o.getYearCapital())) return false;
		if(!Objects.equals(this.__benefit, o.getBenefit())) return false;
		if(!Objects.equals(this.__year_revenue, o.getYearRevenue())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReportTotalId() != null) sb.append(__wrapNumber(count++, "reportTotalId", getReportTotalId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonthRevenue() != null) sb.append(__wrapDecimal(count++, "monthRevenue", getMonthRevenue()));
		if(getTotalRevenue() != null) sb.append(__wrapDecimal(count++, "totalRevenue", getTotalRevenue()));
		if(getMonthCapitalPlate() != null) sb.append(__wrapDecimal(count++, "monthCapitalPlate", getMonthCapitalPlate()));
		if(getTotalCapitalPlate() != null) sb.append(__wrapDecimal(count++, "totalCapitalPlate", getTotalCapitalPlate()));
		if(getMonthCapitalProject() != null) sb.append(__wrapDecimal(count++, "monthCapitalProject", getMonthCapitalProject()));
		if(getTotalCapitalProject() != null) sb.append(__wrapDecimal(count++, "totalCapitalProject", getTotalCapitalProject()));
		if(getMonthSureIntegralPlate() != null) sb.append(__wrapDecimal(count++, "monthSureIntegralPlate", getMonthSureIntegralPlate()));
		if(getTotalSureIntegralPlate() != null) sb.append(__wrapDecimal(count++, "totalSureIntegralPlate", getTotalSureIntegralPlate()));
		if(getMonthSureIntegralProject() != null) sb.append(__wrapDecimal(count++, "monthSureIntegralProject", getMonthSureIntegralProject()));
		if(getTotalSureIntegralProject() != null) sb.append(__wrapDecimal(count++, "totalSureIntegralProject", getTotalSureIntegralProject()));
		if(getMonthSalary() != null) sb.append(__wrapDecimal(count++, "monthSalary", getMonthSalary()));
		if(getTotalSalary() != null) sb.append(__wrapDecimal(count++, "totalSalary", getTotalSalary()));
		if(getMonthCostPlate() != null) sb.append(__wrapDecimal(count++, "monthCostPlate", getMonthCostPlate()));
		if(getTotalCostPlate() != null) sb.append(__wrapDecimal(count++, "totalCostPlate", getTotalCostPlate()));
		if(getMonthCostProject() != null) sb.append(__wrapDecimal(count++, "monthCostProject", getMonthCostProject()));
		if(getTotalCostProject() != null) sb.append(__wrapDecimal(count++, "totalCostProject", getTotalCostProject()));
		if(getMonthCostProjectBefore() != null) sb.append(__wrapDecimal(count++, "monthCostProjectBefore", getMonthCostProjectBefore()));
		if(getTotalCostProjectBefore() != null) sb.append(__wrapDecimal(count++, "totalCostProjectBefore", getTotalCostProjectBefore()));
		if(getMonthNewContract() != null) sb.append(__wrapDecimal(count++, "monthNewContract", getMonthNewContract()));
		if(getTotalNewContract() != null) sb.append(__wrapDecimal(count++, "totalNewContract", getTotalNewContract()));
		if(getContractTotal() != null) sb.append(__wrapDecimal(count++, "contractTotal", getContractTotal()));
		if(getAverageEmpNum() != null) sb.append(__wrapNumber(count++, "averageEmpNum", getAverageEmpNum()));
		if(getMinEmpNum() != null) sb.append(__wrapNumber(count++, "minEmpNum", getMinEmpNum()));
		if(getYearAverageEmpRevenue() != null) sb.append(__wrapDecimal(count++, "yearAverageEmpRevenue", getYearAverageEmpRevenue()));
		if(getYearCapital() != null) sb.append(__wrapDecimal(count++, "yearCapital", getYearCapital()));
		if(getBenefit() != null) sb.append(__wrapDecimal(count++, "benefit", getBenefit()));
		if(getYearRevenue() != null) sb.append(__wrapDecimal(count++, "yearRevenue", getYearRevenue()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("reportTotalId")) != null) setReportTotalId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("monthRevenue")) != null) setMonthRevenue(__getDecimal(val));  
		if((val = values.get("totalRevenue")) != null) setTotalRevenue(__getDecimal(val));  
		if((val = values.get("monthCapitalPlate")) != null) setMonthCapitalPlate(__getDecimal(val));  
		if((val = values.get("totalCapitalPlate")) != null) setTotalCapitalPlate(__getDecimal(val));  
		if((val = values.get("monthCapitalProject")) != null) setMonthCapitalProject(__getDecimal(val));  
		if((val = values.get("totalCapitalProject")) != null) setTotalCapitalProject(__getDecimal(val));  
		if((val = values.get("monthSureIntegralPlate")) != null) setMonthSureIntegralPlate(__getDecimal(val));  
		if((val = values.get("totalSureIntegralPlate")) != null) setTotalSureIntegralPlate(__getDecimal(val));  
		if((val = values.get("monthSureIntegralProject")) != null) setMonthSureIntegralProject(__getDecimal(val));  
		if((val = values.get("totalSureIntegralProject")) != null) setTotalSureIntegralProject(__getDecimal(val));  
		if((val = values.get("monthSalary")) != null) setMonthSalary(__getDecimal(val));  
		if((val = values.get("totalSalary")) != null) setTotalSalary(__getDecimal(val));  
		if((val = values.get("monthCostPlate")) != null) setMonthCostPlate(__getDecimal(val));  
		if((val = values.get("totalCostPlate")) != null) setTotalCostPlate(__getDecimal(val));  
		if((val = values.get("monthCostProject")) != null) setMonthCostProject(__getDecimal(val));  
		if((val = values.get("totalCostProject")) != null) setTotalCostProject(__getDecimal(val));  
		if((val = values.get("monthCostProjectBefore")) != null) setMonthCostProjectBefore(__getDecimal(val));  
		if((val = values.get("totalCostProjectBefore")) != null) setTotalCostProjectBefore(__getDecimal(val));  
		if((val = values.get("monthNewContract")) != null) setMonthNewContract(__getDecimal(val));  
		if((val = values.get("totalNewContract")) != null) setTotalNewContract(__getDecimal(val));  
		if((val = values.get("contractTotal")) != null) setContractTotal(__getDecimal(val));  
		if((val = values.get("averageEmpNum")) != null) setAverageEmpNum(__getInt(val)); 
		if((val = values.get("minEmpNum")) != null) setMinEmpNum(__getInt(val)); 
		if((val = values.get("yearAverageEmpRevenue")) != null) setYearAverageEmpRevenue(__getDecimal(val));  
		if((val = values.get("yearCapital")) != null) setYearCapital(__getDecimal(val));  
		if((val = values.get("benefit")) != null) setBenefit(__getDecimal(val));  
		if((val = values.get("yearRevenue")) != null) setYearRevenue(__getDecimal(val));  
	}

	protected java.lang.Integer  __report_total_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __month_revenue ;
	protected java.math.BigDecimal  __total_revenue ;
	protected java.math.BigDecimal  __month_capital_plate ;
	protected java.math.BigDecimal  __total_capital_plate ;
	protected java.math.BigDecimal  __month_capital_project ;
	protected java.math.BigDecimal  __total_capital_project ;
	protected java.math.BigDecimal  __month_sure_integral_plate ;
	protected java.math.BigDecimal  __total_sure_integral_plate ;
	protected java.math.BigDecimal  __month_sure_integral_project ;
	protected java.math.BigDecimal  __total_sure_integral_project ;
	protected java.math.BigDecimal  __month_salary ;
	protected java.math.BigDecimal  __total_salary ;
	protected java.math.BigDecimal  __month_cost_plate ;
	protected java.math.BigDecimal  __total_cost_plate ;
	protected java.math.BigDecimal  __month_cost_project ;
	protected java.math.BigDecimal  __total_cost_project ;
	protected java.math.BigDecimal  __month_cost_project_before ;
	protected java.math.BigDecimal  __total_cost_project_before ;
	protected java.math.BigDecimal  __month_new_contract ;
	protected java.math.BigDecimal  __total_new_contract ;
	protected java.math.BigDecimal  __contract_total ;
	protected java.lang.Integer  __average_emp_num ;
	protected java.lang.Integer  __min_emp_num ;
	protected java.math.BigDecimal  __year_average_emp_revenue ;
	protected java.math.BigDecimal  __year_capital ;
	protected java.math.BigDecimal  __benefit ;
	protected java.math.BigDecimal  __year_revenue ;
}
