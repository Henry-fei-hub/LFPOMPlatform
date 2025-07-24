package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSalaryJobSubsidy extends GenericBase implements BaseFactory<BaseSalaryJobSubsidy>, Comparable<BaseSalaryJobSubsidy> 
{


	public static BaseSalaryJobSubsidy newInstance(){
		return new BaseSalaryJobSubsidy();
	}

	@Override
	public BaseSalaryJobSubsidy make(){
		BaseSalaryJobSubsidy b = new BaseSalaryJobSubsidy();
		return b;
	}

	public final static java.lang.String CS_SALARY_JOB_SUBSIDY_ID = "salary_job_subsidy_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_MILEAGE_SUBSIDY = "mileage_subsidy" ;
	public final static java.lang.String CS_ATTENTION_SUBSIDY = "attention_subsidy" ;
	public final static java.lang.String CS_SALARY_SUBSIDY = "salary_subsidy" ;
	public final static java.lang.String CS_LEAVE_SUBSIDY = "leave_subsidy" ;
	public final static java.lang.String CS_PERFORMANCE_SUBSIDY = "performance_subsidy" ;
	public final static java.lang.String CS_WORK_SITE_SUBSIDY = "work_site_subsidy" ;
	public final static java.lang.String CS_POSITIVE_ACCOUNT = "positive_account" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,年份,月份,日期,里程补贴,考勤补发/扣,工资补发/扣,离职工资结算,绩效补发/扣,工地补助,转正核算,合计,是否发放,操作人,操作时间,备注";

	public java.lang.Integer getSalaryJobSubsidyId() {
		return this.__salary_job_subsidy_id;
	}

	public void setSalaryJobSubsidyId( java.lang.Integer value ) {
		this.__salary_job_subsidy_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.String getMileageSubsidy() {
		return this.__mileage_subsidy;
	}

	public void setMileageSubsidy( java.lang.String value ) {
		this.__mileage_subsidy = value;
	}

	public java.lang.String getAttentionSubsidy() {
		return this.__attention_subsidy;
	}

	public void setAttentionSubsidy( java.lang.String value ) {
		this.__attention_subsidy = value;
	}

	public java.lang.String getSalarySubsidy() {
		return this.__salary_subsidy;
	}

	public void setSalarySubsidy( java.lang.String value ) {
		this.__salary_subsidy = value;
	}

	public java.lang.String getLeaveSubsidy() {
		return this.__leave_subsidy;
	}

	public void setLeaveSubsidy( java.lang.String value ) {
		this.__leave_subsidy = value;
	}

	public java.lang.String getPerformanceSubsidy() {
		return this.__performance_subsidy;
	}

	public void setPerformanceSubsidy( java.lang.String value ) {
		this.__performance_subsidy = value;
	}

	public java.lang.String getWorkSiteSubsidy() {
		return this.__work_site_subsidy;
	}

	public void setWorkSiteSubsidy( java.lang.String value ) {
		this.__work_site_subsidy = value;
	}

	public java.lang.String getPositiveAccount() {
		return this.__positive_account;
	}

	public void setPositiveAccount( java.lang.String value ) {
		this.__positive_account = value;
	}

	public java.lang.String getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.lang.String value ) {
		this.__total_amount = value;
	}

	public java.lang.Boolean getIsSended() {
		return this.__is_sended;
	}

	public void setIsSended( java.lang.Boolean value ) {
		this.__is_sended = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSalaryJobSubsidy __bean){
		__bean.setSalaryJobSubsidyId(getSalaryJobSubsidyId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setRecordDate(getRecordDate());
		__bean.setMileageSubsidy(getMileageSubsidy());
		__bean.setAttentionSubsidy(getAttentionSubsidy());
		__bean.setSalarySubsidy(getSalarySubsidy());
		__bean.setLeaveSubsidy(getLeaveSubsidy());
		__bean.setPerformanceSubsidy(getPerformanceSubsidy());
		__bean.setWorkSiteSubsidy(getWorkSiteSubsidy());
		__bean.setPositiveAccount(getPositiveAccount());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setIsSended(getIsSended());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryJobSubsidyId() == null ? "" : getSalaryJobSubsidyId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getMileageSubsidy() == null ? "" : getMileageSubsidy());
		sb.append(",");
		sb.append(getAttentionSubsidy() == null ? "" : getAttentionSubsidy());
		sb.append(",");
		sb.append(getSalarySubsidy() == null ? "" : getSalarySubsidy());
		sb.append(",");
		sb.append(getLeaveSubsidy() == null ? "" : getLeaveSubsidy());
		sb.append(",");
		sb.append(getPerformanceSubsidy() == null ? "" : getPerformanceSubsidy());
		sb.append(",");
		sb.append(getWorkSiteSubsidy() == null ? "" : getWorkSiteSubsidy());
		sb.append(",");
		sb.append(getPositiveAccount() == null ? "" : getPositiveAccount());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryJobSubsidy o) {
		return __salary_job_subsidy_id == null ? -1 : __salary_job_subsidy_id.compareTo(o.getSalaryJobSubsidyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_job_subsidy_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__mileage_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__attention_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__salary_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__leave_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__performance_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__work_site_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__positive_account);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryJobSubsidy o = (BaseSalaryJobSubsidy)obj;
		if(!Objects.equals(this.__salary_job_subsidy_id, o.getSalaryJobSubsidyId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__mileage_subsidy, o.getMileageSubsidy())) return false;
		if(!Objects.equals(this.__attention_subsidy, o.getAttentionSubsidy())) return false;
		if(!Objects.equals(this.__salary_subsidy, o.getSalarySubsidy())) return false;
		if(!Objects.equals(this.__leave_subsidy, o.getLeaveSubsidy())) return false;
		if(!Objects.equals(this.__performance_subsidy, o.getPerformanceSubsidy())) return false;
		if(!Objects.equals(this.__work_site_subsidy, o.getWorkSiteSubsidy())) return false;
		if(!Objects.equals(this.__positive_account, o.getPositiveAccount())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryJobSubsidyId() != null) sb.append(__wrapNumber(count++, "salaryJobSubsidyId", getSalaryJobSubsidyId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getMileageSubsidy() != null) sb.append(__wrapString(count++, "mileageSubsidy", getMileageSubsidy()));
		if(getAttentionSubsidy() != null) sb.append(__wrapString(count++, "attentionSubsidy", getAttentionSubsidy()));
		if(getSalarySubsidy() != null) sb.append(__wrapString(count++, "salarySubsidy", getSalarySubsidy()));
		if(getLeaveSubsidy() != null) sb.append(__wrapString(count++, "leaveSubsidy", getLeaveSubsidy()));
		if(getPerformanceSubsidy() != null) sb.append(__wrapString(count++, "performanceSubsidy", getPerformanceSubsidy()));
		if(getWorkSiteSubsidy() != null) sb.append(__wrapString(count++, "workSiteSubsidy", getWorkSiteSubsidy()));
		if(getPositiveAccount() != null) sb.append(__wrapString(count++, "positiveAccount", getPositiveAccount()));
		if(getTotalAmount() != null) sb.append(__wrapString(count++, "totalAmount", getTotalAmount()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryJobSubsidyId")) != null) setSalaryJobSubsidyId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("mileageSubsidy")) != null) setMileageSubsidy(__getString(val));
		if((val = values.get("attentionSubsidy")) != null) setAttentionSubsidy(__getString(val));
		if((val = values.get("salarySubsidy")) != null) setSalarySubsidy(__getString(val));
		if((val = values.get("leaveSubsidy")) != null) setLeaveSubsidy(__getString(val));
		if((val = values.get("performanceSubsidy")) != null) setPerformanceSubsidy(__getString(val));
		if((val = values.get("workSiteSubsidy")) != null) setWorkSiteSubsidy(__getString(val));
		if((val = values.get("positiveAccount")) != null) setPositiveAccount(__getString(val));
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getString(val));
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __salary_job_subsidy_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __mileage_subsidy ;
	protected java.lang.String  __attention_subsidy ;
	protected java.lang.String  __salary_subsidy ;
	protected java.lang.String  __leave_subsidy ;
	protected java.lang.String  __performance_subsidy ;
	protected java.lang.String  __work_site_subsidy ;
	protected java.lang.String  __positive_account ;
	protected java.lang.String  __total_amount ;
	protected java.lang.Boolean  __is_sended ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
