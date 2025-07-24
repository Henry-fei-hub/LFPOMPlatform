package pomplatform.approveProjectStageStorage.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionBooleanApprovalProcess extends GenericCondition{

	public ConditionBooleanApprovalProcess(){
		setParameterCount(3);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
	}

	private java.lang.Integer __process_type = null;
	private java.lang.Integer __project_id = null;
	private java.lang.String __employee_no = null;
}

