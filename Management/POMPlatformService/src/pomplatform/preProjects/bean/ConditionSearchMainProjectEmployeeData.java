package pomplatform.preProjects.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSearchMainProjectEmployeeData extends GenericCondition{

	public ConditionSearchMainProjectEmployeeData(){
		setParameterCount(3);
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.Integer getRelation() {
		return this.__relation;
	}

	public void setRelation( java.lang.Integer value ) {
		this.__relation = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPreProjectId() != null) sb.append(__wrapNumber(1, "preProjectId", getPreProjectId()));
		if(getRelation() != null) sb.append(__wrapNumber(1, "relation", getRelation()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(1, "mainProjectId", getMainProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("relation")) != null) setRelation(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
	}

	private java.lang.Integer __pre_project_id = null;
	private java.lang.Integer __relation = null;
	private java.lang.Integer __main_project_id = null;
}

