package pomplatform.newcontractppcor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionScontractppcor extends GenericCondition{

	public ConditionScontractppcor(){
		setParameterCount(25);
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.String value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.lang.String getClientContractId() {
		return this.__client_contract_id == null ? null : (this.__client_contract_id.indexOf("%") >= 0 ? this.__client_contract_id : "%"+this.__client_contract_id+"%");
	}

	public void setClientContractId( java.lang.String value ) {
		this.__client_contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getContractSigningStatus() {
		return this.__contract_signing_status;
	}

	public void setContractSigningStatus( java.lang.Integer value ) {
		this.__contract_signing_status = value;
	}

	public java.lang.Integer getPreProjectType() {
		return this.__pre_project_type;
	}

	public void setPreProjectType( java.lang.Integer value ) {
		this.__pre_project_type = value;
	}

	public java.lang.Integer getContractType() {
		return this.__contract_type;
	}

	public void setContractType( java.lang.Integer value ) {
		this.__contract_type = value;
	}

	public java.util.Date getProjectApprovalTimeStartDate() {
		return this.__project_approval_time_start_date;
	}

	public void setProjectApprovalTimeStartDate( java.util.Date value ) {
		this.__project_approval_time_start_date = value;
	}

	public java.util.Date getProjectApprovalTimeEndDate() {
		return this.__project_approval_time_end_date;
	}

	public void setProjectApprovalTimeEndDate( java.util.Date value ) {
		this.__project_approval_time_end_date = value;
	}

	public java.lang.Integer getGroupId() {
		return this.__group_id;
	}

	public void setGroupId( java.lang.Integer value ) {
		this.__group_id = value;
	}

	public java.lang.Integer getSignCompany() {
		return this.__sign_company;
	}

	public void setSignCompany( java.lang.Integer value ) {
		this.__sign_company = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public java.lang.Integer getProjectSecretaryId() {
		return this.__project_secretary_id;
	}

	public void setProjectSecretaryId( java.lang.Integer value ) {
		this.__project_secretary_id = value;
	}

	public java.lang.Integer getProjectManagerId() {
		return this.__project_manager_id;
	}

	public void setProjectManagerId( java.lang.Integer value ) {
		this.__project_manager_id = value;
	}

	public java.lang.Integer getProjectLeaderId() {
		return this.__project_leader_id;
	}

	public void setProjectLeaderId( java.lang.Integer value ) {
		this.__project_leader_id = value;
	}

	public java.lang.Integer getMainProjectStageId() {
		return this.__main_project_stage_id;
	}

	public void setMainProjectStageId( java.lang.Integer value ) {
		this.__main_project_stage_id = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectLevel() != null) sb.append(__wrapNumber(1, "projectLevel", getProjectLevel()));
		if(getProjectType() != null) sb.append(__wrapString(1, "projectType", getProjectType()));
		if(getContractStatus() != null) sb.append(__wrapNumber(1, "contractStatus", getContractStatus()));
		if(getClientContractId() != null) sb.append(__wrapString(1, "clientContractId", getClientContractId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getCustomerId() != null) sb.append(__wrapNumber(1, "customerId", getCustomerId()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(1, "projectManageId", getProjectManageId()));
		if(getContractSigningStatus() != null) sb.append(__wrapNumber(1, "contractSigningStatus", getContractSigningStatus()));
		if(getPreProjectType() != null) sb.append(__wrapNumber(1, "preProjectType", getPreProjectType()));
		if(getContractType() != null) sb.append(__wrapNumber(1, "contractType", getContractType()));
		if(getProjectApprovalTimeStartDate() != null) sb.append(__wrapDate(1, "projectApprovalTimeStartDate", getProjectApprovalTimeStartDate()));
		if(getProjectApprovalTimeEndDate() != null) sb.append(__wrapDate(1, "projectApprovalTimeEndDate", getProjectApprovalTimeEndDate()));
		if(getGroupId() != null) sb.append(__wrapNumber(1, "groupId", getGroupId()));
		if(getSignCompany() != null) sb.append(__wrapNumber(1, "signCompany", getSignCompany()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(1, "designTeam", getDesignTeam()));
		if(getProjectSecretaryId() != null) sb.append(__wrapNumber(1, "projectSecretaryId", getProjectSecretaryId()));
		if(getProjectManagerId() != null) sb.append(__wrapNumber(1, "projectManagerId", getProjectManagerId()));
		if(getProjectLeaderId() != null) sb.append(__wrapNumber(1, "projectLeaderId", getProjectLeaderId()));
		if(getMainProjectStageId() != null) sb.append(__wrapNumber(1, "mainProjectStageId", getMainProjectStageId()));
		if(getFlag() != null) sb.append(__wrapNumber(1, "flag", getFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val));
		if((val = values.get("clientContractId")) != null) setClientContractId(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val));
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val));
		if((val = values.get("contractSigningStatus")) != null) setContractSigningStatus(__getInt(val));
		if((val = values.get("preProjectType")) != null) setPreProjectType(__getInt(val));
		if((val = values.get("contractType")) != null) setContractType(__getInt(val));
		if((val = values.get("projectApprovalTimeStartDate")) != null) setProjectApprovalTimeStartDate(__getDate(val));
		if((val = values.get("projectApprovalTimeEndDate")) != null) setProjectApprovalTimeEndDate(__getDate(val));
		if((val = values.get("groupId")) != null) setGroupId(__getInt(val));
		if((val = values.get("signCompany")) != null) setSignCompany(__getInt(val));
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val));
		if((val = values.get("projectSecretaryId")) != null) setProjectSecretaryId(__getInt(val));
		if((val = values.get("projectManagerId")) != null) setProjectManagerId(__getInt(val));
		if((val = values.get("projectLeaderId")) != null) setProjectLeaderId(__getInt(val));
		if((val = values.get("mainProjectStageId")) != null) setMainProjectStageId(__getInt(val));
		if((val = values.get("flag")) != null) setFlag(__getInt(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProjectLevel() != null) res.add("projectLevel");
		if(getProjectType() != null) res.add("projectType");
		if(getContractStatus() != null) res.add("contractStatus");
		if(getClientContractId() != null) res.add("clientContractId");
		if(getContractCode() != null) res.add("contractCode");
		if(getContractName() != null) res.add("contractName");
		if(getCustomerId() != null) res.add("customerId");
		if(getProjectCode() != null) res.add("projectCode");
		if(getStartDate() != null) res.add("startDate");
		if(getEndDate() != null) res.add("endDate");
		if(getPlateId() != null) res.add("plateId");
		if(getProjectManageId() != null) res.add("projectManageId");
		if(getContractSigningStatus() != null) res.add("contractSigningStatus");
		if(getPreProjectType() != null) res.add("preProjectType");
		if(getContractType() != null) res.add("contractType");
		if(getProjectApprovalTimeStartDate() != null) res.add("projectApprovalTimeStartDate");
		if(getProjectApprovalTimeEndDate() != null) res.add("projectApprovalTimeEndDate");
		if(getGroupId() != null) res.add("groupId");
		if(getSignCompany() != null) res.add("signCompany");
		if(getDesignTeam() != null) res.add("designTeam");
		if(getProjectSecretaryId() != null) res.add("projectSecretaryId");
		if(getProjectManagerId() != null) res.add("projectManagerId");
		if(getProjectLeaderId() != null) res.add("projectLeaderId");
		if(getMainProjectStageId() != null) res.add("mainProjectStageId");
		if(getFlag() != null) res.add("flag");
		return res;
	}

	private java.lang.Integer __project_level = null;
	private java.lang.String __project_type = null;
	private java.lang.Integer __contract_status = null;
	private java.lang.String __client_contract_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Integer __customer_id = null;
	private java.lang.String __project_code = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __project_manage_id = null;
	private java.lang.Integer __contract_signing_status = null;
	private java.lang.Integer __pre_project_type = null;
	private java.lang.Integer __contract_type = null;
	private java.util.Date __project_approval_time_start_date = null;
	private java.util.Date __project_approval_time_end_date = null;
	private java.lang.Integer __group_id = null;
	private java.lang.Integer __sign_company = null;
	private java.lang.Integer __design_team = null;
	private java.lang.Integer __project_secretary_id = null;
	private java.lang.Integer __project_manager_id = null;
	private java.lang.Integer __project_leader_id = null;
	private java.lang.Integer __main_project_stage_id = null;
	private java.lang.Integer __flag = null;
}

