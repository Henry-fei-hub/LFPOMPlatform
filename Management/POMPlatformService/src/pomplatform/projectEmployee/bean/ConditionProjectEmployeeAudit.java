package pomplatform.projectEmployee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionProjectEmployeeAudit extends GenericCondition{

	public ConditionProjectEmployeeAudit(){
		setParameterCount(7);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Integer getProjectPlateId() {
		return this.__project_plate_id;
	}

	public void setProjectPlateId( java.lang.Integer value ) {
		this.__project_plate_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getFlag() != null) sb.append(__wrapNumber(1, "flag", getFlag()));
		if(getProjectPlateId() != null) sb.append(__wrapNumber(1, "projectPlateId", getProjectPlateId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("projectPlateId")) != null) setProjectPlateId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __flag = null;
	private java.lang.Integer __project_plate_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __project_name = null;
	private java.lang.String __employee_no = null;
	private java.lang.String __employee_name = null;
}

