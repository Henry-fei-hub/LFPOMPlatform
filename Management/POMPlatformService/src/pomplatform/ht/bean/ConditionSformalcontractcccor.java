package pomplatform.ht.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSformalcontractcccor extends GenericCondition{

	public ConditionSformalcontractcccor(){
		setParameterCount(8);
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getClientContractId() {
		return this.__client_contract_id;
	}

	public void setClientContractId( java.lang.String value ) {
		this.__client_contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.String value ) {
		this.__project_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getClientContractId() != null) sb.append(__wrapString(1, "clientContractId", getClientContractId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(1, "projectLevel", getProjectLevel()));
		if(getCreateTime() != null) sb.append(__wrapDate(1, "createTime", getCreateTime()));
		if(getBusinessType() != null) sb.append(__wrapString(1, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapString(1, "projectType", getProjectType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("clientContractId")) != null) setClientContractId(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
	}

	private java.lang.String __contract_name = null;
	private java.lang.String __client_contract_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __project_code = null;
	private java.lang.Integer __project_level = null;
	private java.util.Date __create_time = null;
	private java.lang.String __business_type = null;
	private java.lang.String __project_type = null;
}

