package pomplatform.role.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSfunctionffor extends GenericCondition{

	public ConditionSfunctionffor(){
		setParameterCount(2);
	}

	public java.lang.String getFunctionName() {
		return this.__function_name == null ? null : (this.__function_name.indexOf("%") >= 0 ? this.__function_name : "%"+this.__function_name+"%");
	}

	public void setFunctionName( java.lang.String value ) {
		this.__function_name = value;
	}

	public java.lang.String getFunctionCode() {
		return this.__function_code;
	}

	public void setFunctionCode( java.lang.String value ) {
		this.__function_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getFunctionName() != null) sb.append(__wrapString(1, "functionName", getFunctionName()));
		if(getFunctionCode() != null) sb.append(__wrapString(1, "functionCode", getFunctionCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("functionName")) != null) setFunctionName(__getString(val));
		if((val = values.get("functionCode")) != null) setFunctionCode(__getString(val));
	}

	private java.lang.String __function_name = null;
	private java.lang.String __function_code = null;
}

