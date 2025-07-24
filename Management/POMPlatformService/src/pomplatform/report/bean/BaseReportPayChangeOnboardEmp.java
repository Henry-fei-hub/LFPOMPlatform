package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportPayChangeOnboardEmp extends GenericBase implements BaseFactory<BaseReportPayChangeOnboardEmp>, Comparable<BaseReportPayChangeOnboardEmp> 
{


	public static BaseReportPayChangeOnboardEmp newInstance(){
		return new BaseReportPayChangeOnboardEmp();
	}

	@Override
	public BaseReportPayChangeOnboardEmp make(){
		BaseReportPayChangeOnboardEmp b = new BaseReportPayChangeOnboardEmp();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_TRY_TIME_PAY = "try_time_pay" ;
	public final static java.lang.String CS_EDUCATION = "education" ;
	public final static java.lang.String CS_PERSONAL_TOTAL_FUND = "personal_total_fund" ;
	public final static java.lang.String CS_PERSONAL_TOTAL_INSURANCE = "personal_total_insurance" ;
	public final static java.lang.String CS_GENDER = "gender";

	public final static java.lang.String ALL_CAPTIONS = "员工编码,工号,姓名,业务部门,所属部门,入职日期,试用期工资,学历,公积金,社保,性别";

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

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.lang.String getTryTimePay() {
		return this.__try_time_pay;
	}

	public void setTryTimePay( java.lang.String value ) {
		this.__try_time_pay = value;
	}

	public java.lang.Integer getEducation() {
		return this.__education;
	}

	public void setEducation( java.lang.Integer value ) {
		this.__education = value;
	}

	public java.math.BigDecimal getPersonalTotalFund() {
		return this.__personal_total_fund;
	}

	public void setPersonalTotalFund( java.math.BigDecimal value ) {
		this.__personal_total_fund = value;
	}

	public java.math.BigDecimal getPersonalTotalInsurance() {
		return this.__personal_total_insurance;
	}

	public void setPersonalTotalInsurance( java.math.BigDecimal value ) {
		this.__personal_total_insurance = value;
	}

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
	}
	
	public void cloneCopy(BaseReportPayChangeOnboardEmp __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setTryTimePay(getTryTimePay());
		__bean.setEducation(getEducation());
		__bean.setPersonalTotalFund(getPersonalTotalFund());
		__bean.setPersonalTotalInsurance(getPersonalTotalInsurance());
		__bean.setGender(getGender());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getTryTimePay() == null ? "" : getTryTimePay());
		sb.append(",");
		sb.append(getEducation() == null ? "" : getEducation());
		sb.append(",");
		sb.append(getPersonalTotalFund() == null ? "" : getPersonalTotalFund());
		sb.append(",");
		sb.append(getPersonalTotalInsurance() == null ? "" : getPersonalTotalInsurance());
		sb.append(",");
		sb.append(getGender() == null ? "" : getGender());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportPayChangeOnboardEmp o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__try_time_pay);
		hash = 97 * hash + Objects.hashCode(this.__education);
		hash = 97 * hash + Objects.hashCode(this.__personal_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__personal_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportPayChangeOnboardEmp o = (BaseReportPayChangeOnboardEmp)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__try_time_pay, o.getTryTimePay())) return false;
		if(!Objects.equals(this.__education, o.getEducation())) return false;
		if(!Objects.equals(this.__personal_total_fund, o.getPersonalTotalFund())) return false;
		if(!Objects.equals(this.__personal_total_insurance, o.getPersonalTotalInsurance())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getTryTimePay() != null) sb.append(__wrapString(count++, "tryTimePay", getTryTimePay()));
		if(getEducation() != null) sb.append(__wrapNumber(count++, "education", getEducation()));
		if(getPersonalTotalFund() != null) sb.append(__wrapDecimal(count++, "personalTotalFund", getPersonalTotalFund()));
		if(getPersonalTotalInsurance() != null) sb.append(__wrapDecimal(count++, "personalTotalInsurance", getPersonalTotalInsurance()));
		if(getGender() != null) sb.append(__wrapNumber(count++, "gender", getGender()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("tryTimePay")) != null) setTryTimePay(__getString(val));
		if((val = values.get("education")) != null) setEducation(__getInt(val)); 
		if((val = values.get("personalTotalFund")) != null) setPersonalTotalFund(__getDecimal(val));  
		if((val = values.get("personalTotalInsurance")) != null) setPersonalTotalInsurance(__getDecimal(val));
		if((val = values.get("gender")) != null) setGender(__getInt(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __onboard_date ;
	protected java.lang.String  __try_time_pay ;
	protected java.lang.Integer  __education ;
	protected java.math.BigDecimal  __personal_total_fund ;
	protected java.math.BigDecimal  __personal_total_insurance ;
	protected java.lang.Integer  __gender ;
}
