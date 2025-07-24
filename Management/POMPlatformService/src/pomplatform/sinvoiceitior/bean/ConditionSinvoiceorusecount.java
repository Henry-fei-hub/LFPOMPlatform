package pomplatform.sinvoiceitior.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSinvoiceorusecount extends GenericCondition{

	public ConditionSinvoiceorusecount(){
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

}

