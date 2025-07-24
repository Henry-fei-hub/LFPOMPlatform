package pomplatform.projectStageTemplate.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectstagetemplatepor extends GenericCondition{

	public ConditionSprojectstagetemplatepor(){
		setParameterCount(1);
	}

	public java.lang.Integer getProjectTemplateId() {
		return this.__project_template_id;
	}

	public void setProjectTemplateId( java.lang.Integer value ) {
		this.__project_template_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectTemplateId() != null) sb.append(__wrapNumber(1, "projectTemplateId", getProjectTemplateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectTemplateId")) != null) setProjectTemplateId(__getInt(val)); 
	}

	private java.lang.Integer __project_template_id = null;
}

