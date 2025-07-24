package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateIncomeAndExpenditure extends GenericBase implements BaseFactory<BasePlateIncomeAndExpenditure>, Comparable<BasePlateIncomeAndExpenditure> 
{


	public static BasePlateIncomeAndExpenditure newInstance(){
		return new BasePlateIncomeAndExpenditure();
	}

	@Override
	public BasePlateIncomeAndExpenditure make(){
		BasePlateIncomeAndExpenditure b = new BasePlateIncomeAndExpenditure();
		return b;
	}

	public final static java.lang.String CS_PLATE_INCOME_AND_EXPENDITURE_ID = "plate_income_and_expenditure_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_CONTRACT_STOCK = "contract_stock" ;
	public final static java.lang.String CS_REVENUE = "revenue" ;
	public final static java.lang.String CS_DEPARTMENT_CONFIRMATION_POINTS = "department_confirmation_points" ;
	public final static java.lang.String CS_EMPLOYEE_CONFIRMATION_POINTS = "employee_confirmation_points" ;
	public final static java.lang.String CS_EMPLOYEE_COST = "employee_cost" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_PLATE_COST = "plate_cost" ;

	public final static java.lang.String ALL_CAPTIONS = "部门收支表,年份,月份,部门,合同存量,营收,部门确认积分,员工确认积分,人工成本,项目成本,部门成本";

	public java.lang.Integer getPlateIncomeAndExpenditureId() {
		return this.__plate_income_and_expenditure_id;
	}

	public void setPlateIncomeAndExpenditureId( java.lang.Integer value ) {
		this.__plate_income_and_expenditure_id = value;
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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getContractStock() {
		return this.__contract_stock;
	}

	public void setContractStock( java.math.BigDecimal value ) {
		this.__contract_stock = value;
	}

	public java.math.BigDecimal getRevenue() {
		return this.__revenue;
	}

	public void setRevenue( java.math.BigDecimal value ) {
		this.__revenue = value;
	}

	public java.math.BigDecimal getDepartmentConfirmationPoints() {
		return this.__department_confirmation_points;
	}

	public void setDepartmentConfirmationPoints( java.math.BigDecimal value ) {
		this.__department_confirmation_points = value;
	}

	public java.math.BigDecimal getEmployeeConfirmationPoints() {
		return this.__employee_confirmation_points;
	}

	public void setEmployeeConfirmationPoints( java.math.BigDecimal value ) {
		this.__employee_confirmation_points = value;
	}

	public java.math.BigDecimal getEmployeeCost() {
		return this.__employee_cost;
	}

	public void setEmployeeCost( java.math.BigDecimal value ) {
		this.__employee_cost = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.math.BigDecimal getPlateCost() {
		return this.__plate_cost;
	}

	public void setPlateCost( java.math.BigDecimal value ) {
		this.__plate_cost = value;
	}

	public void cloneCopy(BasePlateIncomeAndExpenditure __bean){
		__bean.setPlateIncomeAndExpenditureId(getPlateIncomeAndExpenditureId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setPlateId(getPlateId());
		__bean.setContractStock(getContractStock());
		__bean.setRevenue(getRevenue());
		__bean.setDepartmentConfirmationPoints(getDepartmentConfirmationPoints());
		__bean.setEmployeeConfirmationPoints(getEmployeeConfirmationPoints());
		__bean.setEmployeeCost(getEmployeeCost());
		__bean.setProjectCost(getProjectCost());
		__bean.setPlateCost(getPlateCost());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateIncomeAndExpenditureId() == null ? "" : getPlateIncomeAndExpenditureId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getContractStock() == null ? "" : getContractStock());
		sb.append(",");
		sb.append(getRevenue() == null ? "" : getRevenue());
		sb.append(",");
		sb.append(getDepartmentConfirmationPoints() == null ? "" : getDepartmentConfirmationPoints());
		sb.append(",");
		sb.append(getEmployeeConfirmationPoints() == null ? "" : getEmployeeConfirmationPoints());
		sb.append(",");
		sb.append(getEmployeeCost() == null ? "" : getEmployeeCost());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getPlateCost() == null ? "" : getPlateCost());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateIncomeAndExpenditure o) {
		return __plate_income_and_expenditure_id == null ? -1 : __plate_income_and_expenditure_id.compareTo(o.getPlateIncomeAndExpenditureId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_income_and_expenditure_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_stock);
		hash = 97 * hash + Objects.hashCode(this.__revenue);
		hash = 97 * hash + Objects.hashCode(this.__department_confirmation_points);
		hash = 97 * hash + Objects.hashCode(this.__employee_confirmation_points);
		hash = 97 * hash + Objects.hashCode(this.__employee_cost);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__plate_cost);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateIncomeAndExpenditure o = (BasePlateIncomeAndExpenditure)obj;
		if(!Objects.equals(this.__plate_income_and_expenditure_id, o.getPlateIncomeAndExpenditureId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__contract_stock, o.getContractStock())) return false;
		if(!Objects.equals(this.__revenue, o.getRevenue())) return false;
		if(!Objects.equals(this.__department_confirmation_points, o.getDepartmentConfirmationPoints())) return false;
		if(!Objects.equals(this.__employee_confirmation_points, o.getEmployeeConfirmationPoints())) return false;
		if(!Objects.equals(this.__employee_cost, o.getEmployeeCost())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__plate_cost, o.getPlateCost())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateIncomeAndExpenditureId() != null) sb.append(__wrapNumber(count++, "plateIncomeAndExpenditureId", getPlateIncomeAndExpenditureId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getContractStock() != null) sb.append(__wrapDecimal(count++, "contractStock", getContractStock()));
		if(getRevenue() != null) sb.append(__wrapDecimal(count++, "revenue", getRevenue()));
		if(getDepartmentConfirmationPoints() != null) sb.append(__wrapDecimal(count++, "departmentConfirmationPoints", getDepartmentConfirmationPoints()));
		if(getEmployeeConfirmationPoints() != null) sb.append(__wrapDecimal(count++, "employeeConfirmationPoints", getEmployeeConfirmationPoints()));
		if(getEmployeeCost() != null) sb.append(__wrapDecimal(count++, "employeeCost", getEmployeeCost()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getPlateCost() != null) sb.append(__wrapDecimal(count++, "plateCost", getPlateCost()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPlateIncomeAndExpenditureId() != null) res.put("plateIncomeAndExpenditureId", getPlateIncomeAndExpenditureId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getContractStock() != null) res.put("contractStock", getContractStock());
		if(getRevenue() != null) res.put("revenue", getRevenue());
		if(getDepartmentConfirmationPoints() != null) res.put("departmentConfirmationPoints", getDepartmentConfirmationPoints());
		if(getEmployeeConfirmationPoints() != null) res.put("employeeConfirmationPoints", getEmployeeConfirmationPoints());
		if(getEmployeeCost() != null) res.put("employeeCost", getEmployeeCost());
		if(getProjectCost() != null) res.put("projectCost", getProjectCost());
		if(getPlateCost() != null) res.put("plateCost", getPlateCost());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateIncomeAndExpenditureId")) != null) setPlateIncomeAndExpenditureId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("contractStock")) != null) setContractStock(__getDecimal(val));  
		if((val = values.get("revenue")) != null) setRevenue(__getDecimal(val));  
		if((val = values.get("departmentConfirmationPoints")) != null) setDepartmentConfirmationPoints(__getDecimal(val));  
		if((val = values.get("employeeConfirmationPoints")) != null) setEmployeeConfirmationPoints(__getDecimal(val));  
		if((val = values.get("employeeCost")) != null) setEmployeeCost(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("plateCost")) != null) setPlateCost(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_income_and_expenditure_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __contract_stock ;
	protected java.math.BigDecimal  __revenue ;
	protected java.math.BigDecimal  __department_confirmation_points ;
	protected java.math.BigDecimal  __employee_confirmation_points ;
	protected java.math.BigDecimal  __employee_cost ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.math.BigDecimal  __plate_cost ;
}
