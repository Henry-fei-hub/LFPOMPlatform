package pomplatform.capitaldistribution.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCapitalDistributionOfProject extends GenericCondition{

	public ConditionCapitalDistributionOfProject(){
		setParameterCount(10);
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

	public java.lang.String getProjectContractCode() {
		return this.__project_contract_code == null ? null : (this.__project_contract_code.indexOf("%") >= 0 ? this.__project_contract_code : "%"+this.__project_contract_code+"%");
	}

	public void setProjectContractCode( java.lang.String value ) {
		this.__project_contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
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
		return __plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}

	public java.lang.Integer getCapitalId() {
		return __capital_id;
	}

	public void setCapitalId(java.lang.Integer value) {
		this.__capital_id = value;
	}
	
	public java.lang.Integer getLoginUser() {
		return __login_user;
	}

	public void setLoginUser(java.lang.Integer value) {
		this.__login_user = value;
	}

	public java.lang.String getFunctionCode() {
		return __function_code;
	}

	public void setFunctionCode(java.lang.String value) {
		this.__function_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getProjectContractCode() != null) sb.append(__wrapString(1, "projectContractCode", getProjectContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getCapitalId() != null) sb.append(__wrapNumber(1, "capitalId", getCapitalId()));
		if(getLoginUser() != null) sb.append(__wrapNumber(1, "loginUser", getLoginUser()));
		if(getFunctionCode() != null) sb.append(__wrapString(1, "functionCode", getFunctionCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("projectContractCode")) != null) setProjectContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("loginUser")) != null) setLoginUser(__getInt(val)); 
		if((val = values.get("functionCode")) != null) setFunctionCode(__getString(val)); 
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.String __project_contract_code = null;
	private java.lang.String __project_name = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __capital_id = null;
	private java.lang.Integer __login_user = null;
	private java.lang.String __function_code = null;
}

