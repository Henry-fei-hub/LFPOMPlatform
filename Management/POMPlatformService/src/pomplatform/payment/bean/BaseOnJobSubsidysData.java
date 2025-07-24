package pomplatform.payment.bean;
import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnJobSubsidysData extends GenericBase implements BaseFactory<BaseOnJobSubsidysData>, Comparable<BaseOnJobSubsidysData> 
{


	public static BaseOnJobSubsidysData newInstance(){
		return new BaseOnJobSubsidysData();
	}

	@Override
	public BaseOnJobSubsidysData make(){
		BaseOnJobSubsidysData b = new BaseOnJobSubsidysData();
		return b;
	}

	public final static java.lang.String CS_SALARY_JOB_SUBSIDY_ID = "salary_job_subsidy_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_MILEAGE_SUBSIDY = "mileage_subsidy" ;
	public final static java.lang.String CS_ATTENTION_SUBSIDY = "attention_subsidy" ;
	public final static java.lang.String CS_SALARY_SUBSIDY = "salary_subsidy" ;
	public final static java.lang.String CS_LEAVE_SUBSIDY = "leave_subsidy" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;
	public final static java.lang.String CS_PERFORMANCE_SUBSIDY = "performance_subsidy" ;
	public final static java.lang.String CS_WORK_SITE_SUBSIDY = "work_site_subsidy" ;
	public final static java.lang.String CS_POSITIVE_ACCOUNT = "positive_account" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,员工编号,员工姓名,归属公司,业务部门,归属部门,日期,里程补贴,考勤补发/扣,工资补发/扣,离职工资结算,合计,是否发放,绩效补发/扣,工地补助,转正核算";

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

	public void cloneCopy(BaseOnJobSubsidysData __bean){
		__bean.setSalaryJobSubsidyId(getSalaryJobSubsidyId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRecordDate(getRecordDate());
		__bean.setMileageSubsidy(getMileageSubsidy());
		__bean.setAttentionSubsidy(getAttentionSubsidy());
		__bean.setSalarySubsidy(getSalarySubsidy());
		__bean.setLeaveSubsidy(getLeaveSubsidy());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setIsSended(getIsSended());
		__bean.setPerformanceSubsidy(getPerformanceSubsidy());
		__bean.setWorkSiteSubsidy(getWorkSiteSubsidy());
		__bean.setTotalAmount(getTotalAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryJobSubsidyId() == null ? "" : getSalaryJobSubsidyId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
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
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		sb.append(",");
		sb.append(getPerformanceSubsidy() == null ? "" : getPerformanceSubsidy());
		sb.append(",");
		sb.append(getWorkSiteSubsidy() == null ? "" : getWorkSiteSubsidy());
		sb.append(",");
		sb.append(getPositiveAccount() == null ? "" : getPositiveAccount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnJobSubsidysData o) {
		return __salary_job_subsidy_id == null ? -1 : __salary_job_subsidy_id.compareTo(o.getSalaryJobSubsidyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_job_subsidy_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__mileage_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__attention_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__salary_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__leave_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		hash = 97 * hash + Objects.hashCode(this.__performance_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__work_site_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnJobSubsidysData o = (BaseOnJobSubsidysData)obj;
		if(!Objects.equals(this.__salary_job_subsidy_id, o.getSalaryJobSubsidyId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__mileage_subsidy, o.getMileageSubsidy())) return false;
		if(!Objects.equals(this.__attention_subsidy, o.getAttentionSubsidy())) return false;
		if(!Objects.equals(this.__salary_subsidy, o.getSalarySubsidy())) return false;
		if(!Objects.equals(this.__leave_subsidy, o.getLeaveSubsidy())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		if(!Objects.equals(this.__performance_subsidy, o.getPerformanceSubsidy())) return false;
		if(!Objects.equals(this.__work_site_subsidy, o.getWorkSiteSubsidy())) return false;
		if(!Objects.equals(this.__positive_account, o.getPositiveAccount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryJobSubsidyId() != null) sb.append(__wrapNumber(count++, "salaryJobSubsidyId", getSalaryJobSubsidyId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getMileageSubsidy() != null) sb.append(__wrapString(count++, "mileageSubsidy", getMileageSubsidy()));
		if(getAttentionSubsidy() != null) sb.append(__wrapString(count++, "attentionSubsidy", getAttentionSubsidy()));
		if(getSalarySubsidy() != null) sb.append(__wrapString(count++, "salarySubsidy", getSalarySubsidy()));
		if(getLeaveSubsidy() != null) sb.append(__wrapString(count++, "leaveSubsidy", getLeaveSubsidy()));
		if(getTotalAmount() != null) sb.append(__wrapString(count++, "totalAmount", getTotalAmount()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		if(getPerformanceSubsidy() != null) sb.append(__wrapString(count++, "performanceSubsidy", getPerformanceSubsidy()));
		if(getWorkSiteSubsidy() != null) sb.append(__wrapString(count++, "workSiteSubsidy", getWorkSiteSubsidy()));
		if(getPositiveAccount() != null) sb.append(__wrapString(count++, "positiveAccount", getPositiveAccount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryJobSubsidyId")) != null) setSalaryJobSubsidyId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("mileageSubsidy")) != null) setMileageSubsidy(__getString(val));
		if((val = values.get("attentionSubsidy")) != null) setAttentionSubsidy(__getString(val));
		if((val = values.get("salarySubsidy")) != null) setSalarySubsidy(__getString(val));
		if((val = values.get("leaveSubsidy")) != null) setLeaveSubsidy(__getString(val));
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getString(val));
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
		if((val = values.get("performanceSubsidy")) != null) setPerformanceSubsidy(__getString(val));
		if((val = values.get("workSiteSubsidy")) != null) setWorkSiteSubsidy(__getString(val));
		if((val = values.get("positiveAccount")) != null) setPositiveAccount(__getString(val));
	}

	protected java.lang.Integer  __salary_job_subsidy_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __mileage_subsidy ;
	protected java.lang.String  __attention_subsidy ;
	protected java.lang.String  __salary_subsidy ;
	protected java.lang.String  __leave_subsidy ;
	protected java.lang.String  __total_amount ;
	protected java.lang.Boolean  __is_sended ;
	protected java.lang.String  __performance_subsidy ;
	protected java.lang.String  __work_site_subsidy ;
	protected java.lang.String  __positive_account ;
}
