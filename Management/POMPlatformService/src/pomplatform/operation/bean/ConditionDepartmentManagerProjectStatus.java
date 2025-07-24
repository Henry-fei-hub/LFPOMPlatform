package pomplatform.operation.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionDepartmentManagerProjectStatus extends GenericCondition{

	public ConditionDepartmentManagerProjectStatus(){
		setParameterCount(5);
	}

	public Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( Integer value ) {
		this.__project_id = value;
	}

	public String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( String value ) {
		this.__project_code = value;
	}

	public String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( String value ) {
		this.__project_name = value;
	}

	public Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( Integer value ) {
		this.__contract_id = value;
	}

	public String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( String value ) {
		this.__contract_code = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProjectId() != null) res.add("projectId");
		if(getProjectCode() != null) res.add("projectCode");
		if(getProjectName() != null) res.add("projectName");
		if(getContractId() != null) res.add("contractId");
		if(getContractCode() != null) res.add("contractCode");
		return res;
	}

	private Integer __project_id = null;
	private String __project_code = null;
	private String __project_name = null;
	private Integer __contract_id = null;
	private String __contract_code = null;
}

