package pomplatform.selectGridEmployeeValue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionSelectGridEmployeeValue extends GenericCondition{

	public ConditionSelectGridEmployeeValue(){
		setParameterCount(6);
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( java.lang.Integer value ) {
		this.__role_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNameEn() {
		return this.__employee_name_en == null ? null : (this.__employee_name_en.indexOf("%") >= 0 ? this.__employee_name_en : "%"+this.__employee_name_en+"%");
	}

	public void setEmployeeNameEn( java.lang.String value ) {
		this.__employee_name_en = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
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
		if((val = values.get("status")) != null) setStatus(__getInt(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNameEn")) != null) setEmployeeNameEn(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getStatus() != null) res.add("status");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getEmployeeNo() != null) res.add("employeeNo");
		if(getRoleId() != null) res.add("roleId");
		if(getEmployeeName() != null) res.add("employeeName");
		if(getEmployeeNameEn() != null) res.add("employeeNameEn");
		return res;
	}

	private java.lang.Integer __status = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __role_id = null;
	private java.lang.String __employee_name = null;
	private java.lang.String __employee_name_en = null;
}

