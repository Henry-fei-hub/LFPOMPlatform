package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeReportRecord extends GenericBase implements BaseFactory<BaseEmployeeReportRecord>, Comparable<BaseEmployeeReportRecord> 
{


	public static BaseEmployeeReportRecord newInstance(){
		return new BaseEmployeeReportRecord();
	}

	@Override
	public BaseEmployeeReportRecord make(){
		BaseEmployeeReportRecord b = new BaseEmployeeReportRecord();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_REPORT_RECORD_ID = "employee_report_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
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

	public final static java.lang.String ALL_CAPTIONS = "编码,业务部门,员工,姓名,工号,价值积分,确认积分,积分发放,人工成本补贴,人工成本回流,人工成本,项目成本,记录产生时间,是否锁定,项目补贴,奖金发放,积分回收,项目违规金";

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

	public void cloneCopy(BaseEmployeeReportRecord __bean){
		__bean.setEmployeeReportRecordId(getEmployeeReportRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setEmployeeNo(getEmployeeNo());
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
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeReportRecordId() == null ? "" : getEmployeeReportRecordId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getManagerProjectIntegral() == null ? "" : getManagerProjectIntegral());
		sb.append(",");
		sb.append(getSalaryAdvance() == null ? "" : getSalaryAdvance());
		sb.append(",");
		sb.append(getSalaryReturn() == null ? "" : getSalaryReturn());
		sb.append(",");
		sb.append(getSalary() == null ? "" : getSalary());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getIsLock() == null ? "" : getIsLock());
		sb.append(",");
		sb.append(getProjectAdvance() == null ? "" : getProjectAdvance());
		sb.append(",");
		sb.append(getBonusPayment() == null ? "" : getBonusPayment());
		sb.append(",");
		sb.append(getIntegralReturn() == null ? "" : getIntegralReturn());
		sb.append(",");
		sb.append(getViolationCharges() == null ? "" : getViolationCharges());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeReportRecord o) {
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeReportRecord o = (BaseEmployeeReportRecord)obj;
		if(!Objects.equals(this.__employee_report_record_id, o.getEmployeeReportRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
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
	}

	protected java.lang.Integer  __employee_report_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __employee_no ;
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
}
