package pomplatform.sealKeepers.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionRankMax extends GenericCondition{

	public ConditionRankMax(){
		setParameterCount(0);
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		return res;
	}

}

