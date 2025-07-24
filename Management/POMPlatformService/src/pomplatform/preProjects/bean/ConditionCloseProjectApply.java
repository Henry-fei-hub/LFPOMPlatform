package pomplatform.preProjects.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCloseProjectApply extends GenericCondition{

	public ConditionCloseProjectApply(){
		setParameterCount(1);
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPreProjectId() != null) sb.append(__wrapNumber(1, "preProjectId", getPreProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
	}

	private java.lang.Integer __pre_project_id = null;
}

