package pomplatform.salary.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSalaryOfOtherBonus extends GenericBase implements BaseFactory<BaseSalaryOfOtherBonus>, Comparable<BaseSalaryOfOtherBonus> 
{


	public static BaseSalaryOfOtherBonus newInstance(){
		return new BaseSalaryOfOtherBonus();
	}

	@Override
	public BaseSalaryOfOtherBonus make(){
		BaseSalaryOfOtherBonus b = new BaseSalaryOfOtherBonus();
		return b;
	}

	public final static java.lang.String CS_SALARY_OF_BONUS_ID = "salary_of_bonus_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ONBOARD_STATUS = "onboard_status" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_OTHER_BONUS = "other_bonus" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,员工编号,员工姓名,归属公司,板块,所属部门,职员状态,日期,其他奖金,标识,是否发放,年份,月份,备注";

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

	public java.math.BigDecimal getOtherBonus() {
		return this.__other_bonus;
	}

	public void setOtherBonus( java.math.BigDecimal value ) {
		this.__other_bonus = value;
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

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}
	
	public void cloneCopy(BaseSalaryOfOtherBonus __bean){
		__bean.setSalaryOfBonusId(getSalaryOfBonusId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOnboardStatus(getOnboardStatus());
		__bean.setRecordDate(getRecordDate());
		__bean.setOtherBonus(getOtherBonus());
		__bean.setFlag(getFlag());
		__bean.setIsSended(getIsSended());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setRemark(getRemark());
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
		sb.append(getOnboardStatus() == null ? "" : getOnboardStatus());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getOtherBonus() == null ? "" : getOtherBonus());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryOfOtherBonus o) {
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
		hash = 97 * hash + Objects.hashCode(this.__onboard_status);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__other_bonus);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryOfOtherBonus o = (BaseSalaryOfOtherBonus)obj;
		if(!Objects.equals(this.__salary_of_bonus_id, o.getSalaryOfBonusId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__onboard_status, o.getOnboardStatus())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__other_bonus, o.getOtherBonus())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
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
		if(getOnboardStatus() != null) sb.append(__wrapNumber(count++, "onboardStatus", getOnboardStatus()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getOtherBonus() != null) sb.append(__wrapDecimal(count++, "otherBonus", getOtherBonus()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
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
		if((val = values.get("onboardStatus")) != null) setOnboardStatus(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("otherBonus")) != null) setOtherBonus(__getDecimal(val));  
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __salary_of_bonus_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __onboard_status ;
	protected java.util.Date  __record_date ;
	protected java.math.BigDecimal  __other_bonus ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Boolean  __is_sended ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.String  __remark ;
}
