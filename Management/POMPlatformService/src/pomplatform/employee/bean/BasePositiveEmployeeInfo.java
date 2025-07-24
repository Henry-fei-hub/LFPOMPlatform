package pomplatform.employee.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePositiveEmployeeInfo extends GenericBase implements BaseFactory<BasePositiveEmployeeInfo>, Comparable<BasePositiveEmployeeInfo> 
{


	public static BasePositiveEmployeeInfo newInstance(){
		return new BasePositiveEmployeeInfo();
	}

	@Override
	public BasePositiveEmployeeInfo make(){
		BasePositiveEmployeeInfo b = new BasePositiveEmployeeInfo();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_DUTY_ID = "duty_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_POSITIVE_DATE = "positive_date" ;
	public final static java.lang.String CS_GRADE_ID = "grade_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,工号,姓名,部门,入职日期,职位名称,归属公司,转正日期,职级";

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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.lang.Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( java.lang.Integer value ) {
		this.__duty_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.util.Date getPositiveDate() {
		return this.__positive_date;
	}

	public void setPositiveDate( java.util.Date value ) {
		this.__positive_date = value;
	}

	public java.lang.Integer getGradeId() {
		return this.__grade_id;
	}

	public void setGradeId( java.lang.Integer value ) {
		this.__grade_id = value;
	}

	public java.lang.String getTryTimePay() {
		return __try_time_pay;
	}

	public void setTryTimePay(java.lang.String value) {
		this.__try_time_pay = value;
	}

	public java.lang.String getPositivePay() {
		return __positive_pay;
	}

	public void setPositivePay(java.lang.String value) {
		this.__positive_pay = value;
	}

	public java.lang.String getAnnualPerformance() {
		return __annual_performance;
	}

	public void setAnnualPerformance(java.lang.String value) {
		this.__annual_performance = value;
	}

	public void cloneCopy(BasePositiveEmployeeInfo __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setDutyId(getDutyId());
		__bean.setCompanyId(getCompanyId());
		__bean.setPositiveDate(getPositiveDate());
		__bean.setGradeId(getGradeId());
		__bean.setTryTimePay(getTryTimePay());
		__bean.setPositivePay(getPositivePay());
		__bean.setAnnualPerformance(getAnnualPerformance());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getDutyId() == null ? "" : getDutyId());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getPositiveDate() == null ? "" : sdf.format(getPositiveDate()));
		sb.append(",");
		sb.append(getGradeId() == null ? "" : getGradeId());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePositiveEmployeeInfo o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__positive_date);
		hash = 97 * hash + Objects.hashCode(this.__grade_id);
		hash = 97 * hash + Objects.hashCode(this.__try_time_pay);
		hash = 97 * hash + Objects.hashCode(this.__positive_pay);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePositiveEmployeeInfo o = (BasePositiveEmployeeInfo)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__positive_date, o.getPositiveDate())) return false;
		if(!Objects.equals(this.__grade_id, o.getGradeId())) return false;
		if(!Objects.equals(this.__try_time_pay, o.getTryTimePay())) return false;
		if(!Objects.equals(this.__positive_pay, o.getPositivePay())) return false;
		if(!Objects.equals(this.__annual_performance, o.getAnnualPerformance())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getDutyId() != null) sb.append(__wrapNumber(count++, "dutyId", getDutyId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPositiveDate() != null) sb.append(__wrapDate(count++, "positiveDate", getPositiveDate()));
		if(getGradeId() != null) sb.append(__wrapNumber(count++, "gradeId", getGradeId()));
		if(getTryTimePay() != null) sb.append(__wrapString(count++, "tryTimePay", getTryTimePay()));
		if(getPositivePay() != null) sb.append(__wrapString(count++, "positivePay", getPositivePay()));
		if(getAnnualPerformance() != null) sb.append(__wrapString(count++, "annualPerformance", getAnnualPerformance()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("positiveDate")) != null) setPositiveDate(__getDate(val)); 
		if((val = values.get("gradeId")) != null) setGradeId(__getInt(val)); 
		if((val = values.get("tryTimePay")) != null) setTryTimePay(__getString(val));
		if((val = values.get("positivePay")) != null) setPositivePay(__getString(val));
		if((val = values.get("annualPerformance")) != null) setAnnualPerformance(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __onboard_date ;
	protected java.lang.Integer  __duty_id ;
	protected java.lang.Integer  __company_id ;
	protected java.util.Date  __positive_date ;
	protected java.lang.Integer  __grade_id ;
	protected java.lang.String  __try_time_pay ;
	protected java.lang.String  __positive_pay ;
	protected java.lang.String  __annual_performance ;
}
