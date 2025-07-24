package pomplatform.projectperformance.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionProjectPerformanceDetail extends GenericCondition{

	public ConditionProjectPerformanceDetail(){
		setParameterCount(5);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPerformanceFlag() {
		return this.__performance_flag;
	}

	public void setPerformanceFlag( java.lang.Integer value ) {
		this.__performance_flag = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getPerformanceFlag() != null) sb.append(__wrapNumber(1, "performanceFlag", getPerformanceFlag()));
		if(getBusinessType() != null) sb.append(__wrapNumber(1, "businessType", getBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("performanceFlag")) != null) setPerformanceFlag(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __performance_flag = null;
	private java.lang.Integer __business_type = null;
}

