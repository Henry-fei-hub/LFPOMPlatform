package pomplatform.workflow.professional.bean;

import delicacy.common.GenericCondition;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ConditionOnLoadAuditListOfProfessionalApproval extends GenericCondition{

	public final static String NAME_PROCESS_TYPE = "processType" ;
	public final static String NAME_EMPLOYEE_NAME = "employeeName" ;
	public final static String NAME_EMPLOYEE_NO = "employeeNo" ;
	public final static String NAME_DEPARTMENT_ID = "departmentId" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_STATUS = "status" ;

	public ConditionOnLoadAuditListOfProfessionalApproval(){
		setParameterCount(6);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessType() != null) res.put(NAME_PROCESS_TYPE, getProcessType());
		if(getEmployeeName() != null) res.put(NAME_EMPLOYEE_NAME, getEmployeeName());
		if(getEmployeeNo() != null) res.put(NAME_EMPLOYEE_NO, getEmployeeNo());
		if(getDepartmentId() != null) res.put(NAME_DEPARTMENT_ID, getDepartmentId());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getStatus() != null) res.put(NAME_STATUS, getStatus());
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
		if(getProcessType() != null) sb.append(__wrapNumber(1, NAME_PROCESS_TYPE, getProcessType()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, NAME_EMPLOYEE_NAME, getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, NAME_EMPLOYEE_NO, getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, NAME_DEPARTMENT_ID, getDepartmentId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, NAME_STATUS, getStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if(values.containsKey(NAME_PROCESS_TYPE) && (val = values.get(NAME_PROCESS_TYPE)) != null) setProcessType(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_NAME) && (val = values.get(NAME_EMPLOYEE_NAME)) != null) setEmployeeName(__getString(val));
		if(values.containsKey(NAME_EMPLOYEE_NO) && (val = values.get(NAME_EMPLOYEE_NO)) != null) setEmployeeNo(__getString(val));
		if(values.containsKey(NAME_DEPARTMENT_ID) && (val = values.get(NAME_DEPARTMENT_ID)) != null) setDepartmentId(__getInt(val)); 
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_STATUS) && (val = values.get(NAME_STATUS)) != null) setStatus(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProcessType() != null) res.add(NAME_PROCESS_TYPE);
		if(getEmployeeName() != null) res.add(NAME_EMPLOYEE_NAME);
		if(getEmployeeNo() != null) res.add(NAME_EMPLOYEE_NO);
		if(getDepartmentId() != null) res.add(NAME_DEPARTMENT_ID);
		if(getEmployeeId() != null) res.add(NAME_EMPLOYEE_ID);
		if(getStatus() != null) res.add(NAME_STATUS);
		return res;
	}

	private java.lang.Integer __process_type = null;
	private java.lang.String __employee_name = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __status = null;
}

