package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionCooperateStatisticsTotal extends GenericCondition{

	public ConditionCooperateStatisticsTotal(){
		setParameterCount(4);
	}

	public String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
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

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
	}

	public Integer getType() {
		return this.__type;
	}

	public void setType( Integer value ) {
		this.__type = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProjectCode() != null) res.add("projectCode");
		if(getProjectName() != null) res.add("projectName");
		if(getDepartmentId() != null) res.add("departmentId");
		if(getType() != null) res.add("type");
		return res;
	}

	private String __project_code = null;
	private String __project_name = null;
	private Integer __department_id = null;
	private Integer __type = null;
}

