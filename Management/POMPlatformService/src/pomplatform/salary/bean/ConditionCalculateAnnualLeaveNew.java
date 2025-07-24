package pomplatform.salary.bean;

import delicacy.common.GenericCondition;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ConditionCalculateAnnualLeaveNew extends GenericCondition{

	public final static String NAME_YEAR = "year" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_EMPLOYEE_NAME = "employeeName" ;
	public final static String NAME_DEPARTMENT_ID = "departmentId" ;
	public final static String NAME_EMPLOYEE_NO = "employeeNo" ;

	public ConditionCalculateAnnualLeaveNew(){
		setParameterCount(5);
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
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

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getYear() != null) res.put(NAME_YEAR, getYear());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getEmployeeName() != null) res.put(NAME_EMPLOYEE_NAME, getEmployeeName());
		if(getDepartmentId() != null) res.put(NAME_DEPARTMENT_ID, getDepartmentId());
		if(getEmployeeNo() != null) res.put(NAME_EMPLOYEE_NO, getEmployeeNo());
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
		if(getYear() != null) sb.append(__wrapNumber(1, NAME_YEAR, getYear()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, NAME_EMPLOYEE_NAME, getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, NAME_DEPARTMENT_ID, getDepartmentId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, NAME_EMPLOYEE_NO, getEmployeeNo()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_YEAR) && (val = values.get(NAME_YEAR)) != null) setYear(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_NAME) && (val = values.get(NAME_EMPLOYEE_NAME)) != null) setEmployeeName(__getString(val));
		if(values.containsKey(NAME_DEPARTMENT_ID) && (val = values.get(NAME_DEPARTMENT_ID)) != null) setDepartmentId(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_NO) && (val = values.get(NAME_EMPLOYEE_NO)) != null) setEmployeeNo(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getYear() != null) res.add(NAME_YEAR);
		if(getEmployeeId() != null) res.add(NAME_EMPLOYEE_ID);
		if(getEmployeeName() != null) res.add(NAME_EMPLOYEE_NAME);
		if(getDepartmentId() != null) res.add(NAME_DEPARTMENT_ID);
		if(getEmployeeNo() != null) res.add(NAME_EMPLOYEE_NO);
		return res;
	}

	private java.lang.Integer __year = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_name = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __employee_no = null;
}

