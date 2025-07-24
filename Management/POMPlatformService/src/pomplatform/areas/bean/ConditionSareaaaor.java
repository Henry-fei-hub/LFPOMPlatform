package pomplatform.areas.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionSareaaaor extends GenericCondition{

	public ConditionSareaaaor(){
		setParameterCount(3);
	}

	public java.lang.String getAreaName() {
		return this.__area_name == null ? null : (this.__area_name.indexOf("%") >= 0 ? this.__area_name : "%"+this.__area_name+"%");
	}

	public void setAreaName( java.lang.String value ) {
		this.__area_name = value;
	}

	public java.lang.Integer getAreaLevel() {
		return this.__area_level;
	}

	public void setAreaLevel( java.lang.Integer value ) {
		this.__area_level = value;
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
		if(getAreaName() != null) sb.append(__wrapString(1, "areaName", getAreaName()));
		if(getAreaLevel() != null) sb.append(__wrapNumber(1, "areaLevel", getAreaLevel()));
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("areaName")) != null) setAreaName(__getString(val));
		if((val = values.get("areaLevel")) != null) setAreaLevel(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
	}

	private java.lang.String __area_name = null;
	private java.lang.Integer __area_level = null;
	private java.lang.Integer __parent_id = null;
}

