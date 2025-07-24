package pomplatform.contractsRecords.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractsRecords extends GenericCondition{

	public ConditionContractsRecords(){
		setParameterCount(15);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getRegisterEmployee() {
		return this.__register_employee;
	}

	public void setRegisterEmployee( java.lang.Integer value ) {
		this.__register_employee = value;
	}

	public java.lang.String getRelevantEmployees() {
		return this.__relevant_employees;
	}

	public void setRelevantEmployees( java.lang.String value ) {
		this.__relevant_employees = value;
	}

	public java.lang.String getRelevantEmployeesName() {
		return this.__relevant_employees_name;
	}

	public void setRelevantEmployeesName( java.lang.String value ) {
		this.__relevant_employees_name = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.util.Date getTrackDateStart() {
		return this.__track_date_start;
	}

	public void setTrackDateStart( java.util.Date value ) {
		this.__track_date_start = value;
	}

	public java.util.Date getTrackDateEnd() {
		return this.__track_date_end;
	}

	public void setTrackDateEnd( java.util.Date value ) {
		this.__track_date_end = value;
	}

	public java.lang.Integer getTrackType() {
		return this.__track_type;
	}

	public void setTrackType( java.lang.Integer value ) {
		this.__track_type = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getContractAmount() != null) sb.append(__wrapNumber(1, "contractAmount", getContractAmount()));
		if(getContractStatus() != null) sb.append(__wrapNumber(1, "contractStatus", getContractStatus()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getRegisterEmployee() != null) sb.append(__wrapNumber(1, "registerEmployee", getRegisterEmployee()));
		if(getRelevantEmployees() != null) sb.append(__wrapString(1, "relevantEmployees", getRelevantEmployees()));
		if(getRelevantEmployeesName() != null) sb.append(__wrapString(1, "relevantEmployeesName", getRelevantEmployeesName()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getTrackDateStart() != null) sb.append(__wrapDate(1, "trackDateStart", getTrackDateStart()));
		if(getTrackDateEnd() != null) sb.append(__wrapDate(1, "trackDateEnd", getTrackDateEnd()));
		if(getTrackType() != null) sb.append(__wrapNumber(1, "trackType", getTrackType()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("registerEmployee")) != null) setRegisterEmployee(__getInt(val)); 
		if((val = values.get("relevantEmployees")) != null) setRelevantEmployees(__getString(val));
		if((val = values.get("relevantEmployeesName")) != null) setRelevantEmployeesName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("trackDateStart")) != null) setTrackDateStart(__getDate(val)); 
		if((val = values.get("trackDateEnd")) != null) setTrackDateEnd(__getDate(val)); 
		if((val = values.get("trackType")) != null) setTrackType(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
	}

	private java.lang.Integer __contract_id = null;
	private java.math.BigDecimal __contract_amount = null;
	private java.lang.Integer __contract_status = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __register_employee = null;
	private java.lang.String __relevant_employees = null;
	private java.lang.String __relevant_employees_name = null;
	private java.lang.String __customer_name = null;
	private java.lang.String __contract_code = null;
	private java.util.Date __track_date_start = null;
	private java.util.Date __track_date_end = null;
	private java.lang.Integer __track_type = null;
	private java.lang.String __info_code = null;
	private java.lang.String __project_name = null;
	private java.lang.String __contract_name = null;
}

