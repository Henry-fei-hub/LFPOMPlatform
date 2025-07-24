package pomplatform.mcapitaldepartmentdccddor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcapitaldepartmentdccddor extends GenericCondition{

	public ConditionMcapitaldepartmentdccddor(){
		setParameterCount(4);
	}

	public java.lang.Integer getCapitalDepartmentId() {
		return this.__capital_department_id;
	}

	public void setCapitalDepartmentId( java.lang.Integer value ) {
		this.__capital_department_id = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getDepartmentName() {
		return this.__department_name == null ? null : (this.__department_name.indexOf("%") >= 0 ? this.__department_name : "%"+this.__department_name+"%");
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCapitalDepartmentId() != null) sb.append(__wrapNumber(1, "capitalDepartmentId", getCapitalDepartmentId()));
		if(getCapitalId() != null) sb.append(__wrapNumber(1, "capitalId", getCapitalId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getDepartmentName() != null) sb.append(__wrapString(1, "departmentName", getDepartmentName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("capitalDepartmentId")) != null) setCapitalDepartmentId(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
	}

	private java.lang.Integer __capital_department_id = null;
	private java.lang.Integer __capital_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __department_name = null;
}

