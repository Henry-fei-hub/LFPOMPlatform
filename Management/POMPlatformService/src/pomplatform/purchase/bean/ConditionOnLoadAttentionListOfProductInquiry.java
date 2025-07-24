package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadAttentionListOfProductInquiry extends GenericCondition{

	public ConditionOnLoadAttentionListOfProductInquiry(){
		setParameterCount(8);
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.lang.String getMajorTitle() {
		return this.__major_title == null ? null : (this.__major_title.indexOf("%") >= 0 ? this.__major_title : "%"+this.__major_title+"%");
	}

	public void setMajorTitle( java.lang.String value ) {
		this.__major_title = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(1, "createEmployeeId", getCreateEmployeeId()));
		if(getMajorTitle() != null) sb.append(__wrapString(1, "majorTitle", getMajorTitle()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("majorTitle")) != null) setMajorTitle(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.Integer __status = null;
	private java.lang.Integer __process_type = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __create_employee_id = null;
	private java.lang.String __major_title = null;
	private java.lang.String __employee_no = null;
	private java.lang.String __employee_name = null;
	private java.lang.Integer __department_id = null;
}

