package pomplatform.sealKeepers.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionsealKeepersWorkflow extends GenericCondition{

	public ConditionsealKeepersWorkflow(){
		setParameterCount(3);
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getSealName() {
		return this.__seal_name;
	}

	public void setSealName( java.lang.String value ) {
		this.__seal_name = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getSealName() != null) sb.append(__wrapString(1, "sealName", getSealName()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("sealName")) != null) setSealName(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getCompanyId() != null) res.add("companyId");
		if(getSealName() != null) res.add("sealName");
		if(getEmployeeId() != null) res.add("employeeId");
		return res;
	}

	private java.lang.Integer __company_id = null;
	private java.lang.String __seal_name = null;
	private java.lang.Integer __employee_id = null;
}

