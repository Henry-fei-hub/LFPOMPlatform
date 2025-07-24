package pomplatform.projectItem.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectItem extends GenericCondition{

	public ConditionSprojectItem(){
		setParameterCount(2);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(1, "departmentManagerId", getDepartmentManagerId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __department_manager_id = null;
}

