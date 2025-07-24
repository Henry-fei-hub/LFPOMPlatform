package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSelectGridEmployeeValues extends GenericCondition{

	public ConditionSelectGridEmployeeValues(){
		setParameterCount(5);
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( String value ) {
		this.__employee_no = value;
	}

	public Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( Integer value ) {
		this.__role_id = value;
	}

	public String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public String getEmployeeNameEn() {
		return this.__employee_name_en;
	}

	public void setEmployeeNameEn( String value ) {
		this.__employee_name_en = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getRoleId() != null) sb.append(__wrapNumber(1, "roleId", getRoleId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getEmployeeNameEn() != null) sb.append(__wrapString(1, "employeeNameEn", getEmployeeNameEn()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNameEn")) != null) setEmployeeNameEn(__getString(val));
	}

	private Integer __employee_id = null;
	private String __employee_no = null;
	private Integer __role_id = null;
	private String __employee_name = null;
	private String __employee_name_en = null;
}

