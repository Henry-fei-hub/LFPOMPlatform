package pomplatform.stagemodel.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetContractStageModelByParentId extends GenericCondition{

	public ConditionGetContractStageModelByParentId(){
		setParameterCount(1);
	}

	public java.lang.Integer getContractStageModelId() {
		return this.__contract_stage_model_id;
	}

	public void setContractStageModelId( java.lang.Integer value ) {
		this.__contract_stage_model_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractStageModelId() != null) sb.append(__wrapNumber(1, "contractStageModelId", getContractStageModelId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractStageModelId")) != null) setContractStageModelId(__getInt(val)); 
	}

	private java.lang.Integer __contract_stage_model_id = null;
}

