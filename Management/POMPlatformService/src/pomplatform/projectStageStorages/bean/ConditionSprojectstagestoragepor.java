package pomplatform.projectStageStorages.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectstagestoragepor extends GenericCondition{

	public ConditionSprojectstagestoragepor(){
		setParameterCount(1);
	}

	public java.lang.Integer getProjectStageStorageId() {
		return this.__project_stage_storage_id;
	}

	public void setProjectStageStorageId( java.lang.Integer value ) {
		this.__project_stage_storage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectStageStorageId() != null) sb.append(__wrapNumber(1, "projectStageStorageId", getProjectStageStorageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectStageStorageId")) != null) setProjectStageStorageId(__getInt(val)); 
	}

	private java.lang.Integer __project_stage_storage_id = null;
}

