package pomplatform.projectReportRecordDetail.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionProjectReportRecordDetail extends GenericCondition{

	public ConditionProjectReportRecordDetail(){
		setParameterCount(13);
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
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

	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getMainProjectStageId() {
		return this.__main_project_stage_id;
	}

	public void setMainProjectStageId( java.lang.Integer value ) {
		this.__main_project_stage_id = value;
	}

	public java.lang.String getEmployeeNameTostring5() {
		return this.__employee_name_tostring_5 == null ? null : (this.__employee_name_tostring_5.indexOf("%") >= 0 ? this.__employee_name_tostring_5 : "%"+this.__employee_name_tostring_5+"%");
	}

	public void setEmployeeNameTostring5( java.lang.String value ) {
		this.__employee_name_tostring_5 = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(1, "projectFlag", getProjectFlag()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(1, "departmentManagerId", getDepartmentManagerId()));
		if(getProjectType() != null) sb.append(__wrapNumber(1, "projectType", getProjectType()));
		if(getMainProjectStageId() != null) sb.append(__wrapNumber(1, "mainProjectStageId", getMainProjectStageId()));
		if(getEmployeeNameTostring5() != null) sb.append(__wrapString(1, "employeeNameTostring5", getEmployeeNameTostring5()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectFlag")) != null) setProjectFlag(__getInt(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val));
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val));
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val));
		if((val = values.get("mainProjectStageId")) != null) setMainProjectStageId(__getInt(val));
		if((val = values.get("employeeNameTostring5")) != null) setEmployeeNameTostring5(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getEndDate() != null) res.add("endDate");
		if(getStartDate() != null) res.add("startDate");
		if(getPlateId() != null) res.add("plateId");
		if(getContractCode() != null) res.add("contractCode");
		if(getProjectCode() != null) res.add("projectCode");
		if(getProjectName() != null) res.add("projectName");
		if(getProjectFlag() != null) res.add("projectFlag");
		if(getStatus() != null) res.add("status");
		if(getContractId() != null) res.add("contractId");
		if(getDepartmentManagerId() != null) res.add("departmentManagerId");
		if(getProjectType() != null) res.add("projectType");
		if(getMainProjectStageId() != null) res.add("mainProjectStageId");
		if(getEmployeeNameTostring5() != null) res.add("employeeNameTostring5");
		return res;
	}

	private java.util.Date __end_date = null;
	private java.util.Date __start_date = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __project_code = null;
	private java.lang.String __project_name = null;
	private java.lang.Integer __project_flag = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __department_manager_id = null;
	private java.lang.Integer __project_type = null;
	private java.lang.Integer __main_project_stage_id = null;
	private java.lang.String __employee_name_tostring_5 = null;
}

