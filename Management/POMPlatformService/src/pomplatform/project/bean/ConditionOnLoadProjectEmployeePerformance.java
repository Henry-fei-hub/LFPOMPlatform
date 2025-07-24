package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadProjectEmployeePerformance extends GenericCondition{

	public ConditionOnLoadProjectEmployeePerformance(){
		setParameterCount(2);
	}

	public java.lang.Integer getPerformanceFlag() {
		return this.__performance_flag;
	}

	public void setPerformanceFlag( java.lang.Integer value ) {
		this.__performance_flag = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPerformanceFlag() != null) sb.append(__wrapNumber(1, "performanceFlag", getPerformanceFlag()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("performanceFlag")) != null) setPerformanceFlag(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
	}

	private java.lang.Integer __performance_flag = null;
	private java.lang.Integer __project_id = null;
}

