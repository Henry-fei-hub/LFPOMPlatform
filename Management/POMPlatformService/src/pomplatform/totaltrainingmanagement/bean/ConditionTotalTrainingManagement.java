package pomplatform.totaltrainingmanagement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionTotalTrainingManagement extends GenericCondition{

	public ConditionTotalTrainingManagement(){
		setParameterCount(2);
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
	}

	private java.lang.Integer __department_id = null;
	private java.lang.Integer __year = null;
}

