package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionSearchProjectType16Data extends GenericCondition{

	public ConditionSearchProjectType16Data(){
		setParameterCount(1);
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProjectCode() != null) res.add("projectCode");
		return res;
	}

	private java.lang.String __project_code = null;
}

