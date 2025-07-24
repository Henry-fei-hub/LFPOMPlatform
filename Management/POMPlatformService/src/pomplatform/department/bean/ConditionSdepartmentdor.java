package pomplatform.department.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionSdepartmentdor extends GenericCondition{

	public ConditionSdepartmentdor(){
		setParameterCount(3);
	}

	public java.lang.String getDepartmentName() {
		return this.__department_name == null ? null : (this.__department_name.indexOf("%") >= 0 ? this.__department_name : "%"+this.__department_name+"%");
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
	}
	
	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}
	
	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDepartmentName() != null) sb.append(__wrapString(1, "departmentName", getDepartmentName()));
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
	}

	private java.lang.String __department_name = null;
	private java.lang.Integer __parent_id = null;
	private java.lang.Integer __plate_id = null;
}

