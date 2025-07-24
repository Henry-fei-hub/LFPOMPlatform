package pomplatform.scontractcccor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScontractcccor extends GenericCondition{

	public ConditionScontractcccor(){
		setParameterCount(21);
	}

	public java.lang.Boolean getHasSplitPrice() {
		return this.__has_split_price;
	}

	public void setHasSplitPrice( java.lang.Boolean value ) {
		this.__has_split_price = value;
	}

	public java.lang.Boolean getIsSystemAdd() {
		return this.__is_system_add;
	}

	public void setIsSystemAdd( java.lang.Boolean value ) {
		this.__is_system_add = value;
	}

	public java.lang.Integer getFlowStatus() {
		return this.__flow_status;
	}

	public void setFlowStatus( java.lang.Integer value ) {
		this.__flow_status = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getContractType() {
		return this.__contract_type;
	}

	public void setContractType( java.lang.Integer value ) {
		this.__contract_type = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getTotalProjectTime() {
		return this.__total_project_time;
	}

	public void setTotalProjectTime( java.lang.Integer value ) {
		this.__total_project_time = value;
	}

	public java.lang.Integer getContractFollower() {
		return this.__contract_follower;
	}

	public void setContractFollower( java.lang.Integer value ) {
		this.__contract_follower = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getSigningCompanyName() {
		return this.__signing_company_name;
	}

	public void setSigningCompanyName( java.lang.Integer value ) {
		this.__signing_company_name = value;
	}

	public java.lang.String getSerialNumber() {
		return this.__serial_number == null ? null : (this.__serial_number.indexOf("%") >= 0 ? this.__serial_number : "%"+this.__serial_number+"%");
	}

	public void setSerialNumber( java.lang.String value ) {
		this.__serial_number = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
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

	public java.lang.Boolean getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( java.lang.Boolean value ) {
		this.__is_finish = value;
	}

	public java.lang.String getDetailAddress() {
		return this.__detail_address == null ? null : (this.__detail_address.indexOf("%") >= 0 ? this.__detail_address : "%"+this.__detail_address+"%");
	}

	public void setDetailAddress( java.lang.String value ) {
		this.__detail_address = value;
	}

	public java.lang.String getCustomerAddress() {
		return this.__customer_address == null ? null : (this.__customer_address.indexOf("%") >= 0 ? this.__customer_address : "%"+this.__customer_address+"%");
	}

	public void setCustomerAddress( java.lang.String value ) {
		this.__customer_address = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getHasSplitPrice() != null) sb.append(__wrapBoolean(1, "hasSplitPrice", getHasSplitPrice()));
		if(getIsSystemAdd() != null) sb.append(__wrapBoolean(1, "isSystemAdd", getIsSystemAdd()));
		if(getFlowStatus() != null) sb.append(__wrapNumber(1, "flowStatus", getFlowStatus()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getContractType() != null) sb.append(__wrapNumber(1, "contractType", getContractType()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(1, "projectLevel", getProjectLevel()));
		if(getTotalProjectTime() != null) sb.append(__wrapNumber(1, "totalProjectTime", getTotalProjectTime()));
		if(getContractFollower() != null) sb.append(__wrapNumber(1, "contractFollower", getContractFollower()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getSigningCompanyName() != null) sb.append(__wrapNumber(1, "signingCompanyName", getSigningCompanyName()));
		if(getSerialNumber() != null) sb.append(__wrapString(1, "serialNumber", getSerialNumber()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getContractStatus() != null) sb.append(__wrapNumber(1, "contractStatus", getContractStatus()));
		if(getClientContractId() != null) sb.append(__wrapString(1, "clientContractId", getClientContractId()));
		if(getIsFinish() != null) sb.append(__wrapBoolean(1, "isFinish", getIsFinish()));
		if(getDetailAddress() != null) sb.append(__wrapString(1, "detailAddress", getDetailAddress()));
		if(getCustomerAddress() != null) sb.append(__wrapString(1, "customerAddress", getCustomerAddress()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("hasSplitPrice")) != null) setHasSplitPrice(__getBoolean(val));
		if((val = values.get("isSystemAdd")) != null) setIsSystemAdd(__getBoolean(val));
		if((val = values.get("flowStatus")) != null) setFlowStatus(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractType")) != null) setContractType(__getInt(val)); 
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("totalProjectTime")) != null) setTotalProjectTime(__getInt(val)); 
		if((val = values.get("contractFollower")) != null) setContractFollower(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("signingCompanyName")) != null) setSigningCompanyName(__getInt(val)); 
		if((val = values.get("serialNumber")) != null) setSerialNumber(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("clientContractId")) != null) setClientContractId(__getString(val));
		if((val = values.get("isFinish")) != null) setIsFinish(__getBoolean(val));
		if((val = values.get("detailAddress")) != null) setDetailAddress(__getString(val));
		if((val = values.get("customerAddress")) != null) setCustomerAddress(__getString(val));
	}

	private java.lang.Boolean __has_split_price = null;
	private java.lang.Boolean __is_system_add = null;
	private java.lang.Integer __flow_status = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Integer __status = null;
	private java.lang.String __project_code = null;
	private java.lang.Integer __contract_type = null;
	private java.lang.Integer __project_level = null;
	private java.lang.Integer __total_project_time = null;
	private java.lang.Integer __contract_follower = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __signing_company_name = null;
	private java.lang.String __serial_number = null;
	private java.lang.String __info_code = null;
	private java.lang.Integer __contract_status = null;
	private java.lang.String __client_contract_id = null;
	private java.lang.Boolean __is_finish = null;
	private java.lang.String __detail_address = null;
	private java.lang.String __customer_address = null;
}

