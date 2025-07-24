package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData extends GenericCondition{

	public ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData(){
		setParameterCount(6);
	}

	public java.lang.Double getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Double value ) {
		this.__year = value;
	}

	public java.lang.Double getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Double value ) {
		this.__month = value;
	}

	public java.lang.Integer getTargetProvince() {
		return this.__target_province;
	}

	public void setTargetProvince( java.lang.Integer value ) {
		this.__target_province = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getDefer() {
		return this.__defer;
	}

	public void setDefer( java.lang.Integer value ) {
		this.__defer = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getTargetProvince() != null) sb.append(__wrapNumber(1, "targetProvince", getTargetProvince()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getDefer() != null) sb.append(__wrapNumber(1, "defer", getDefer()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getDouble(val)); 
		if((val = values.get("month")) != null) setMonth(__getDouble(val)); 
		if((val = values.get("targetProvince")) != null) setTargetProvince(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("defer")) != null) setDefer(__getInt(val)); 
	}

	private java.lang.Double __year = null;
	private java.lang.Double __month = null;
	private java.lang.Integer __target_province = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __defer = null;
}

