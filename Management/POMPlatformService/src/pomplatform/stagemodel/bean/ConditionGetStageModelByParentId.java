package pomplatform.stagemodel.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetStageModelByParentId extends GenericCondition{

	public ConditionGetStageModelByParentId(){
		setParameterCount(1);
	}

	public java.lang.Integer getStageModelId() {
		return this.__stage_model_id;
	}

	public void setStageModelId( java.lang.Integer value ) {
		this.__stage_model_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStageModelId() != null) sb.append(__wrapNumber(1, "stageModelId", getStageModelId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("stageModelId")) != null) setStageModelId(__getInt(val)); 
	}

	private java.lang.Integer __stage_model_id = null;
}

