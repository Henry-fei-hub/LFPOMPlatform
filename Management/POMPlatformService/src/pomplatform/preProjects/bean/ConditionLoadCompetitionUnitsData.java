package pomplatform.preProjects.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionLoadCompetitionUnitsData extends GenericCondition{

	public ConditionLoadCompetitionUnitsData(){
		setParameterCount(2);
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
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
		if(getMainProjectId() != null) sb.append(__wrapNumber(1, "mainProjectId", getMainProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getPreProjectId() != null) res.add("preProjectId");
		if(getMainProjectId() != null) res.add("mainProjectId");
		return res;
	}

	private java.lang.Integer __pre_project_id = null;
	private java.lang.Integer __main_project_id = null;
}

