package pomplatform.shift.bean;

import delicacy.common.GenericCondition;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ConditionAttendanceCheckinoutData extends GenericCondition{

	public final static String NAME_START_DATE = "startDate" ;
	public final static String NAME_END_DATE = "endDate" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;

	public ConditionAttendanceCheckinoutData(){
		setParameterCount(3);
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

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getStartDate() != null) res.put(NAME_START_DATE, getStartDate());
		if(getEndDate() != null) res.put(NAME_END_DATE, getEndDate());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
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
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, NAME_EMPLOYEE_ID, getEmployeeId()));
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
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getStartDate() != null) res.add(NAME_START_DATE);
		if(getEndDate() != null) res.add(NAME_END_DATE);
		if(getEmployeeId() != null) res.add(NAME_EMPLOYEE_ID);
		return res;
	}

	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __employee_id = null;
}

