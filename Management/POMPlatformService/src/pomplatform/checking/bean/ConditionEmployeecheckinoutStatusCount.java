package pomplatform.checking.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionEmployeecheckinoutStatusCount extends GenericCondition{

	public ConditionEmployeecheckinoutStatusCount(){
		setParameterCount(2);
	}

	public java.util.Date getToday() {
		return this.__today;
	}

	public void setToday( java.util.Date value ) {
		this.__today = value;
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
		if(getToday() != null) sb.append(__wrapDate(1, "today", getToday()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("today")) != null) setToday(__getDate(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.util.Date __today = null;
	private java.lang.Integer __department_id = null;
}

