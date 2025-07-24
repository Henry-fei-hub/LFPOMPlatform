package pomplatform.leavetype.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSearchLeaveTypes extends GenericCondition{

	public ConditionSearchLeaveTypes(){
		setParameterCount(3);
	}

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId( java.lang.Integer value ) {
		this.__area_id = value;
	}

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAreaId() != null) sb.append(__wrapNumber(1, "areaId", getAreaId()));
		if(getGender() != null) sb.append(__wrapNumber(1, "gender", getGender()));
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("areaId")) != null) setAreaId(__getInt(val)); 
		if((val = values.get("gender")) != null) setGender(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
	}

	private java.lang.Integer __area_id = null;
	private java.lang.Integer __gender = null;
	private java.lang.Integer __parent_id = null;
}

