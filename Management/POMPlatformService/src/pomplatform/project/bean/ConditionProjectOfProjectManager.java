package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionProjectOfProjectManager extends GenericCondition{

	public ConditionProjectOfProjectManager(){
		setParameterCount(1);
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectManageId() != null) sb.append(__wrapNumber(1, "projectManageId", getProjectManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
	}

	private java.lang.Integer __project_manage_id = null;
}

