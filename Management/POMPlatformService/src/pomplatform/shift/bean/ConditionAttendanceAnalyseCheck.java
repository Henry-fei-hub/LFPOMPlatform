package pomplatform.shift.bean;

import delicacy.common.GenericCondition;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ConditionAttendanceAnalyseCheck extends GenericCondition{

	public final static String NAME_START_DATE = "startDate" ;
	public final static String NAME_END_DATE = "endDate" ;
	public final static String NAME_YEAR = "year" ;
	public final static String NAME_MONTH = "month" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_COMPANY_ID = "companyId" ;

	public ConditionAttendanceAnalyseCheck(){
		setParameterCount(6);
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
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

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getStartDate() != null) res.put(NAME_START_DATE, getStartDate());
		if(getEndDate() != null) res.put(NAME_END_DATE, getEndDate());
		if(getYear() != null) res.put(NAME_YEAR, getYear());
		if(getMonth() != null) res.put(NAME_MONTH, getMonth());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getCompanyId() != null) res.put(NAME_COMPANY_ID, getCompanyId());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartDate() != null) sb.append(__wrapDate(1, NAME_START_DATE, getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, NAME_END_DATE, getEndDate()));
		if(getYear() != null) sb.append(__wrapNumber(1, NAME_YEAR, getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, NAME_MONTH, getMonth()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, NAME_COMPANY_ID, getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_START_DATE) && (val = values.get(NAME_START_DATE)) != null) setStartDate(__getDate(val)); 
		if(values.containsKey(NAME_END_DATE) && (val = values.get(NAME_END_DATE)) != null) setEndDate(__getDate(val)); 
		if(values.containsKey(NAME_YEAR) && (val = values.get(NAME_YEAR)) != null) setYear(__getInt(val)); 
		if(values.containsKey(NAME_MONTH) && (val = values.get(NAME_MONTH)) != null) setMonth(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_COMPANY_ID) && (val = values.get(NAME_COMPANY_ID)) != null) setCompanyId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getStartDate() != null) res.add(NAME_START_DATE);
		if(getEndDate() != null) res.add(NAME_END_DATE);
		if(getYear() != null) res.add(NAME_YEAR);
		if(getMonth() != null) res.add(NAME_MONTH);
		if(getEmployeeId() != null) res.add(NAME_EMPLOYEE_ID);
		if(getCompanyId() != null) res.add(NAME_COMPANY_ID);
		return res;
	}

	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __company_id = null;
}

