package pomplatform.sumDesignconsideration.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSumDesignconsideration extends GenericCondition{

	public ConditionSumDesignconsideration(){
		setParameterCount(1);
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
	}

	private java.lang.String __info_code = null;
}

