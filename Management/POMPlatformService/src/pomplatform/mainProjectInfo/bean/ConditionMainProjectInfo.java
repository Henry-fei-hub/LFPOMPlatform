package pomplatform.mainProjectInfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMainProjectInfo extends GenericCondition{

	public ConditionMainProjectInfo(){
		setParameterCount(3);
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( java.lang.Integer value ) {
		this.__project_base_on = value;
	}

	public java.lang.Boolean getHasContract() {
		return this.__has_contract;
	}

	public void setHasContract( java.lang.Boolean value ) {
		this.__has_contract = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(1, "projectBaseOn", getProjectBaseOn()));
		if(getHasContract() != null) sb.append(__wrapBoolean(1, "hasContract", getHasContract()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("hasContract")) != null) setHasContract(__getBoolean(val));
	}

	private java.lang.String __project_code = null;
	private java.lang.Integer __project_base_on = null;
	private java.lang.Boolean __has_contract = null;
}

