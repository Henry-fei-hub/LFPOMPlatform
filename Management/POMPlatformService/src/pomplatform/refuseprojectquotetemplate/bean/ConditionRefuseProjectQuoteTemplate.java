package pomplatform.refuseprojectquotetemplate.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionRefuseProjectQuoteTemplate extends GenericCondition{

	public ConditionRefuseProjectQuoteTemplate(){
		setParameterCount(8);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.util.Date getCreateTimeStart() {
		return this.__create_time_start;
	}

	public void setCreateTimeStart( java.util.Date value ) {
		this.__create_time_start = value;
	}

	public java.util.Date getCreateTimeEnd() {
		return this.__create_time_end;
	}

	public void setCreateTimeEnd( java.util.Date value ) {
		this.__create_time_end = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
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
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getCreateTimeStart() != null) sb.append(__wrapDate(1, "createTimeStart", getCreateTimeStart()));
		if(getCreateTimeEnd() != null) sb.append(__wrapDate(1, "createTimeEnd", getCreateTimeEnd()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(1, "businessType", getBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("createTimeStart")) != null) setCreateTimeStart(__getDate(val)); 
		if((val = values.get("createTimeEnd")) != null) setCreateTimeEnd(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
	}

	private java.lang.Integer __process_type = null;
	private java.lang.Integer __process_status = null;
	private java.lang.String __project_name = null;
	private java.util.Date __create_time_start = null;
	private java.util.Date __create_time_end = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __operate_employee_id = null;
	private java.lang.Integer __business_type = null;
}

