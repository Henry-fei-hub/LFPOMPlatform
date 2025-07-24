package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionFileManagesWatermark extends GenericCondition{

	public ConditionFileManagesWatermark(){
		setParameterCount(0);
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
	}

}

