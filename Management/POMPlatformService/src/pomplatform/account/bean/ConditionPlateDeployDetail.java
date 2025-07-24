package pomplatform.account.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionPlateDeployDetail extends GenericCondition{

	public ConditionPlateDeployDetail(){
		setParameterCount(1);
	}

	public Integer getPlateDeployRecordId() {
		return this.__plate_deploy_record_id;
	}

	public void setPlateDeployRecordId( Integer value ) {
		this.__plate_deploy_record_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateDeployRecordId() != null) sb.append(__wrapNumber(1, "plateDeployRecordId", getPlateDeployRecordId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateDeployRecordId")) != null) setPlateDeployRecordId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getPlateDeployRecordId() != null) res.add("plateDeployRecordId");
		return res;
	}

	private Integer __plate_deploy_record_id = null;
}

