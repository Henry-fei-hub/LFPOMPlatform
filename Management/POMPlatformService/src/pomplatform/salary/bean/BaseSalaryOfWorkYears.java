package pomplatform.salary.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSalaryOfWorkYears extends GenericBase implements BaseFactory<BaseSalaryOfWorkYears>, Comparable<BaseSalaryOfWorkYears> 
{


	public static BaseSalaryOfWorkYears newInstance(){
		return new BaseSalaryOfWorkYears();
	}

	@Override
	public BaseSalaryOfWorkYears make(){
		BaseSalaryOfWorkYears b = new BaseSalaryOfWorkYears();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ONBOARD_STATUS = "onboard_status" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_POSITIVE_DATE = "positive_date" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_JANUARY = "january" ;
	public final static java.lang.String CS_FEBRUARY = "february" ;
	public final static java.lang.String CS_MARCH = "march" ;
	public final static java.lang.String CS_APRIL = "april" ;
	public final static java.lang.String CS_MAY = "may" ;
	public final static java.lang.String CS_JUNE = "june" ;
	public final static java.lang.String CS_JULY = "july" ;
	public final static java.lang.String CS_AUGUST = "august" ;
	public final static java.lang.String CS_SEPTEMBER = "september" ;
	public final static java.lang.String CS_OCTOBER = "october" ;
	public final static java.lang.String CS_NOVEMBER = "november" ;
	public final static java.lang.String CS_DECEMBER = "december" ;

	public final static java.lang.String ALL_CAPTIONS = "员工编码,员工编号,员工姓名,业务部门,所属部门,职员状态,入职日期,转正日期,员工编码,年份,1月,2月,3月,4月,5月,6月,7月,8月,9月,10月,11月,12月";

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

	public java.lang.Integer getOnboardStatus() {
		return this.__onboard_status;
	}

	public void setOnboardStatus( java.lang.Integer value ) {
		this.__onboard_status = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.util.Date getPositiveDate() {
		return this.__positive_date;
	}

	public void setPositiveDate( java.util.Date value ) {
		this.__positive_date = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Long getJanuary() {
		return this.__january;
	}

	public void setJanuary( java.lang.Long value ) {
		this.__january = value;
	}

	public java.lang.Long getFebruary() {
		return this.__february;
	}

	public void setFebruary( java.lang.Long value ) {
		this.__february = value;
	}

	public java.lang.Long getMarch() {
		return this.__march;
	}

	public void setMarch( java.lang.Long value ) {
		this.__march = value;
	}

	public java.lang.Long getApril() {
		return this.__april;
	}

	public void setApril( java.lang.Long value ) {
		this.__april = value;
	}

	public java.lang.Long getMay() {
		return this.__may;
	}

	public void setMay( java.lang.Long value ) {
		this.__may = value;
	}

	public java.lang.Long getJune() {
		return this.__june;
	}

	public void setJune( java.lang.Long value ) {
		this.__june = value;
	}

	public java.lang.Long getJuly() {
		return this.__july;
	}

	public void setJuly( java.lang.Long value ) {
		this.__july = value;
	}

	public java.lang.Long getAugust() {
		return this.__august;
	}

	public void setAugust( java.lang.Long value ) {
		this.__august = value;
	}

	public java.lang.Long getSeptember() {
		return this.__september;
	}

	public void setSeptember( java.lang.Long value ) {
		this.__september = value;
	}

	public java.lang.Long getOctober() {
		return this.__october;
	}

	public void setOctober( java.lang.Long value ) {
		this.__october = value;
	}

	public java.lang.Long getNovember() {
		return this.__november;
	}

	public void setNovember( java.lang.Long value ) {
		this.__november = value;
	}

	public java.lang.Long getDecember() {
		return this.__december;
	}

	public void setDecember( java.lang.Long value ) {
		this.__december = value;
	}

	public void cloneCopy(BaseSalaryOfWorkYears __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOnboardStatus(getOnboardStatus());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setPositiveDate(getPositiveDate());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setJanuary(getJanuary());
		__bean.setFebruary(getFebruary());
		__bean.setMarch(getMarch());
		__bean.setApril(getApril());
		__bean.setMay(getMay());
		__bean.setJune(getJune());
		__bean.setJuly(getJuly());
		__bean.setAugust(getAugust());
		__bean.setSeptember(getSeptember());
		__bean.setOctober(getOctober());
		__bean.setNovember(getNovember());
		__bean.setDecember(getDecember());
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
		sb.append(getOnboardStatus() == null ? "" : getOnboardStatus());
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getPositiveDate() == null ? "" : sdf.format(getPositiveDate()));
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getJanuary() == null ? "" : getJanuary());
		sb.append(",");
		sb.append(getFebruary() == null ? "" : getFebruary());
		sb.append(",");
		sb.append(getMarch() == null ? "" : getMarch());
		sb.append(",");
		sb.append(getApril() == null ? "" : getApril());
		sb.append(",");
		sb.append(getMay() == null ? "" : getMay());
		sb.append(",");
		sb.append(getJune() == null ? "" : getJune());
		sb.append(",");
		sb.append(getJuly() == null ? "" : getJuly());
		sb.append(",");
		sb.append(getAugust() == null ? "" : getAugust());
		sb.append(",");
		sb.append(getSeptember() == null ? "" : getSeptember());
		sb.append(",");
		sb.append(getOctober() == null ? "" : getOctober());
		sb.append(",");
		sb.append(getNovember() == null ? "" : getNovember());
		sb.append(",");
		sb.append(getDecember() == null ? "" : getDecember());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryOfWorkYears o) {
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
		hash = 97 * hash + Objects.hashCode(this.__onboard_status);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__positive_date);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__january);
		hash = 97 * hash + Objects.hashCode(this.__february);
		hash = 97 * hash + Objects.hashCode(this.__march);
		hash = 97 * hash + Objects.hashCode(this.__april);
		hash = 97 * hash + Objects.hashCode(this.__may);
		hash = 97 * hash + Objects.hashCode(this.__june);
		hash = 97 * hash + Objects.hashCode(this.__july);
		hash = 97 * hash + Objects.hashCode(this.__august);
		hash = 97 * hash + Objects.hashCode(this.__september);
		hash = 97 * hash + Objects.hashCode(this.__october);
		hash = 97 * hash + Objects.hashCode(this.__november);
		hash = 97 * hash + Objects.hashCode(this.__december);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryOfWorkYears o = (BaseSalaryOfWorkYears)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__onboard_status, o.getOnboardStatus())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__positive_date, o.getPositiveDate())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__january, o.getJanuary())) return false;
		if(!Objects.equals(this.__february, o.getFebruary())) return false;
		if(!Objects.equals(this.__march, o.getMarch())) return false;
		if(!Objects.equals(this.__april, o.getApril())) return false;
		if(!Objects.equals(this.__may, o.getMay())) return false;
		if(!Objects.equals(this.__june, o.getJune())) return false;
		if(!Objects.equals(this.__july, o.getJuly())) return false;
		if(!Objects.equals(this.__august, o.getAugust())) return false;
		if(!Objects.equals(this.__september, o.getSeptember())) return false;
		if(!Objects.equals(this.__october, o.getOctober())) return false;
		if(!Objects.equals(this.__november, o.getNovember())) return false;
		if(!Objects.equals(this.__december, o.getDecember())) return false;
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
		if(getOnboardStatus() != null) sb.append(__wrapNumber(count++, "onboardStatus", getOnboardStatus()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getPositiveDate() != null) sb.append(__wrapDate(count++, "positiveDate", getPositiveDate()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getJanuary() != null) sb.append(__wrapNumber(count++, "january", getJanuary()));
		if(getFebruary() != null) sb.append(__wrapNumber(count++, "february", getFebruary()));
		if(getMarch() != null) sb.append(__wrapNumber(count++, "march", getMarch()));
		if(getApril() != null) sb.append(__wrapNumber(count++, "april", getApril()));
		if(getMay() != null) sb.append(__wrapNumber(count++, "may", getMay()));
		if(getJune() != null) sb.append(__wrapNumber(count++, "june", getJune()));
		if(getJuly() != null) sb.append(__wrapNumber(count++, "july", getJuly()));
		if(getAugust() != null) sb.append(__wrapNumber(count++, "august", getAugust()));
		if(getSeptember() != null) sb.append(__wrapNumber(count++, "september", getSeptember()));
		if(getOctober() != null) sb.append(__wrapNumber(count++, "october", getOctober()));
		if(getNovember() != null) sb.append(__wrapNumber(count++, "november", getNovember()));
		if(getDecember() != null) sb.append(__wrapNumber(count++, "december", getDecember()));
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
		if((val = values.get("onboardStatus")) != null) setOnboardStatus(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("positiveDate")) != null) setPositiveDate(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("january")) != null) setJanuary(__getLong(val)); 
		if((val = values.get("february")) != null) setFebruary(__getLong(val)); 
		if((val = values.get("march")) != null) setMarch(__getLong(val)); 
		if((val = values.get("april")) != null) setApril(__getLong(val)); 
		if((val = values.get("may")) != null) setMay(__getLong(val)); 
		if((val = values.get("june")) != null) setJune(__getLong(val)); 
		if((val = values.get("july")) != null) setJuly(__getLong(val)); 
		if((val = values.get("august")) != null) setAugust(__getLong(val)); 
		if((val = values.get("september")) != null) setSeptember(__getLong(val)); 
		if((val = values.get("october")) != null) setOctober(__getLong(val)); 
		if((val = values.get("november")) != null) setNovember(__getLong(val)); 
		if((val = values.get("december")) != null) setDecember(__getLong(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __onboard_status ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __positive_date ;
	protected java.lang.Integer  __year ;
	protected java.lang.Long  __january ;
	protected java.lang.Long  __february ;
	protected java.lang.Long  __march ;
	protected java.lang.Long  __april ;
	protected java.lang.Long  __may ;
	protected java.lang.Long  __june ;
	protected java.lang.Long  __july ;
	protected java.lang.Long  __august ;
	protected java.lang.Long  __september ;
	protected java.lang.Long  __october ;
	protected java.lang.Long  __november ;
	protected java.lang.Long  __december ;
}
