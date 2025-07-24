package pomplatform.salary.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSalaryOfFactBonus extends GenericBase implements BaseFactory<BaseSalaryOfFactBonus>, Comparable<BaseSalaryOfFactBonus> 
{


	public static BaseSalaryOfFactBonus newInstance(){
		return new BaseSalaryOfFactBonus();
	}

	@Override
	public BaseSalaryOfFactBonus make(){
		BaseSalaryOfFactBonus b = new BaseSalaryOfFactBonus();
		return b;
	}

	public final static java.lang.String CS_SALARY_OF_BONUS_ID = "salary_of_bonus_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_ONBOARD_STATUS = "onboard_status" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_SHOULD_BONUS = "should_bonus" ;
	public final static java.lang.String CS_SHOULD_TAX = "should_tax" ;
	public final static java.lang.String CS_FACT_BONUS = "fact_bonus" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_RESIGNATION_DATE = "resignation_date" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,员工编号,员工姓名,归属公司,板块,所属部门,在职状态,职员状态,日期,应发奖金,应纳个税,实发奖金,标识,是否发放,年份,月份";

	public java.lang.Integer getSalaryOfBonusId() {
		return this.__salary_of_bonus_id;
	}

	public void setSalaryOfBonusId( java.lang.Integer value ) {
		this.__salary_of_bonus_id = value;
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

	public java.lang.Integer getOnboardStatus() {
		return this.__onboard_status;
	}

	public void setOnboardStatus( java.lang.Integer value ) {
		this.__onboard_status = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.math.BigDecimal getShouldBonus() {
		return this.__should_bonus;
	}

	public void setShouldBonus( java.math.BigDecimal value ) {
		this.__should_bonus = value;
	}

	public java.math.BigDecimal getShouldTax() {
		return this.__should_tax;
	}

	public void setShouldTax( java.math.BigDecimal value ) {
		this.__should_tax = value;
	}

	public java.math.BigDecimal getFactBonus() {
		return this.__fact_bonus;
	}

	public void setFactBonus( java.math.BigDecimal value ) {
		this.__fact_bonus = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Boolean getIsSended() {
		return this.__is_sended;
	}

	public void setIsSended( java.lang.Boolean value ) {
		this.__is_sended = value;
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
	
	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.util.Date getResignationDate() {
		return this.__resignation_date;
	}

	public void setResignationDate( java.util.Date value ) {
		this.__resignation_date = value;
	}
	
	
	public void cloneCopy(BaseSalaryOfFactBonus __bean){
		__bean.setSalaryOfBonusId(getSalaryOfBonusId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setStatus(getStatus());
		__bean.setOnboardStatus(getOnboardStatus());
		__bean.setRecordDate(getRecordDate());
		__bean.setShouldBonus(getShouldBonus());
		__bean.setShouldTax(getShouldTax());
		__bean.setFactBonus(getFactBonus());
		__bean.setFlag(getFlag());
		__bean.setIsSended(getIsSended());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setResignationDate(getResignationDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryOfBonusId() == null ? "" : getSalaryOfBonusId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String status = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_11", String.valueOf(getStatus()));
		sb.append(status == null ? "" : status);
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getResignationDate() == null ? "" : sdf.format(getResignationDate()));
		sb.append(",");
		sb.append(getOnboardStatus() == null ? "" : getOnboardStatus());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getShouldBonus() == null ? "" : getShouldBonus());
		sb.append(",");
		sb.append(getShouldTax() == null ? "" : getShouldTax());
		sb.append(",");
		sb.append(getFactBonus() == null ? "" : getFactBonus());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryOfFactBonus o) {
		return __salary_of_bonus_id == null ? -1 : __salary_of_bonus_id.compareTo(o.getSalaryOfBonusId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_of_bonus_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__onboard_status);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__should_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_tax);
		hash = 97 * hash + Objects.hashCode(this.__fact_bonus);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__resignation_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryOfFactBonus o = (BaseSalaryOfFactBonus)obj;
		if(!Objects.equals(this.__salary_of_bonus_id, o.getSalaryOfBonusId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__onboard_status, o.getOnboardStatus())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__should_bonus, o.getShouldBonus())) return false;
		if(!Objects.equals(this.__should_tax, o.getShouldTax())) return false;
		if(!Objects.equals(this.__fact_bonus, o.getFactBonus())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__resignation_date, o.getResignationDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryOfBonusId() != null) sb.append(__wrapNumber(count++, "salaryOfBonusId", getSalaryOfBonusId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getOnboardStatus() != null) sb.append(__wrapNumber(count++, "onboardStatus", getOnboardStatus()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getShouldBonus() != null) sb.append(__wrapDecimal(count++, "shouldBonus", getShouldBonus()));
		if(getShouldTax() != null) sb.append(__wrapDecimal(count++, "shouldTax", getShouldTax()));
		if(getFactBonus() != null) sb.append(__wrapDecimal(count++, "factBonus", getFactBonus()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getResignationDate() != null) sb.append(__wrapDate(count++, "resignationDate", getResignationDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryOfBonusId")) != null) setSalaryOfBonusId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("onboardStatus")) != null) setOnboardStatus(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("shouldBonus")) != null) setShouldBonus(__getDecimal(val));  
		if((val = values.get("shouldTax")) != null) setShouldTax(__getDecimal(val));  
		if((val = values.get("factBonus")) != null) setFactBonus(__getDecimal(val));  
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("resignationDate")) != null) setResignationDate(__getDate(val)); 
	}

	protected java.lang.Integer  __salary_of_bonus_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __onboard_status ;
	protected java.util.Date  __record_date ;
	protected java.math.BigDecimal  __should_bonus ;
	protected java.math.BigDecimal  __should_tax ;
	protected java.math.BigDecimal  __fact_bonus ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Boolean  __is_sended ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __resignation_date ;
}
