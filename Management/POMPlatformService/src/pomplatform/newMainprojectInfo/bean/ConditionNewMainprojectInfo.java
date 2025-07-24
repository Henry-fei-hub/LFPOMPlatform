package pomplatform.newMainprojectInfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionNewMainprojectInfo extends GenericCondition{

	public ConditionNewMainprojectInfo(){
		setParameterCount(4);
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
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
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(1, "projectBaseOn", getProjectBaseOn()));
		if(getHasContract() != null) sb.append(__wrapBoolean(1, "hasContract", getHasContract()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("hasContract")) != null) setHasContract(__getBoolean(val));
	}

	private java.lang.String __project_code = null;
	private java.lang.String __project_name = null;
	private java.lang.Integer __project_base_on = null;
	private java.lang.Boolean __has_contract = null;
}

