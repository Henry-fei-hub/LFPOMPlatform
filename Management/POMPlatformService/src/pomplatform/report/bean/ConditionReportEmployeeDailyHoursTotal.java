package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionReportEmployeeDailyHoursTotal extends GenericCondition{

	public ConditionReportEmployeeDailyHoursTotal(){
		setParameterCount(4);
	}

	public String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( String value ) {
		this.__employee_no = value;
	}

	public String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public java.util.Date getStartWorkDate() {
		return this.__start_work_date;
	}

	public void setStartWorkDate( java.util.Date value ) {
		this.__start_work_date = value;
	}

	public java.util.Date getEndWorkDate() {
		return this.__end_work_date;
	}

	public void setEndWorkDate( java.util.Date value ) {
		this.__end_work_date = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getStartWorkDate() != null) sb.append(__wrapDate(1, "startWorkDate", getStartWorkDate()));
		if(getEndWorkDate() != null) sb.append(__wrapDate(1, "endWorkDate", getEndWorkDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("startWorkDate")) != null) setStartWorkDate(__getDate(val)); 
		if((val = values.get("endWorkDate")) != null) setEndWorkDate(__getDate(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getEmployeeNo() != null) res.add("employeeNo");
		if(getEmployeeName() != null) res.add("employeeName");
		if(getStartWorkDate() != null) res.add("startWorkDate");
		if(getEndWorkDate() != null) res.add("endWorkDate");
		return res;
	}

	private String __employee_no = null;
	private String __employee_name = null;
	private java.util.Date __start_work_date = null;
	private java.util.Date __end_work_date = null;
}

