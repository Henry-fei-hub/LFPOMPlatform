package pomplatform.ProjectTransitions.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadProjectTransitionRecord extends GenericCondition{

	public ConditionOnLoadProjectTransitionRecord(){
		setParameterCount(6);
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

	public java.lang.Integer getInitiateDesign() {
		return this.__initiate_design;
	}

	public void setInitiateDesign( java.lang.Integer value ) {
		this.__initiate_design = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getInitiateDesign() != null) sb.append(__wrapNumber(1, "initiateDesign", getInitiateDesign()));
		if(getOperator() != null) sb.append(__wrapNumber(1, "operator", getOperator()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("initiateDesign")) != null) setInitiateDesign(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProjectCode() != null) res.add("projectCode");
		if(getProjectName() != null) res.add("projectName");
		if(getInitiateDesign() != null) res.add("initiateDesign");
		if(getOperator() != null) res.add("operator");
		if(getStatus() != null) res.add("status");
		if(getContractCode() != null) res.add("contractCode");
		return res;
	}

	private java.lang.String __project_code = null;
	private java.lang.String __project_name = null;
	private java.lang.Integer __initiate_design = null;
	private java.lang.Integer __operator = null;
	private java.lang.Integer __status = null;
	private java.lang.String __contract_code = null;
}

