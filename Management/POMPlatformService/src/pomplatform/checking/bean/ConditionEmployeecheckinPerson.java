package pomplatform.checking.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionEmployeecheckinPerson extends GenericCondition{

	public ConditionEmployeecheckinPerson(){
		setParameterCount(2);
	}

	public java.util.Date getTodate() {
		return this.__todate;
	}

	public void setTodate( java.util.Date value ) {
		this.__todate = value;
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
		if(getTodate() != null) sb.append(__wrapDate(1, "todate", getTodate()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("todate")) != null) setTodate(__getDate(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.util.Date __todate = null;
	private java.lang.Integer __department_id = null;
}

