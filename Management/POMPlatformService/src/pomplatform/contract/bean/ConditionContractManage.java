package pomplatform.contract.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractManage extends GenericCondition{

	public ConditionContractManage(){
		setParameterCount(4);
	}

	public java.lang.Integer getSigningCompanyName() {
		return this.__signing_company_name;
	}

	public void setSigningCompanyName( java.lang.Integer value ) {
		this.__signing_company_name = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getCustomerId() {
		return __customer_id;
	}

	public void setCustomerId(java.lang.Integer __customer_id) {
		this.__customer_id = __customer_id;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSigningCompanyName() != null) sb.append(__wrapNumber(1, "signingCompanyName", getSigningCompanyName()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getCustomerId() != null) sb.append(__wrapNumber(1, "customerId", getCustomerId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("signingCompanyName")) != null) setSigningCompanyName(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
	}

	private java.lang.Integer __signing_company_name = null;
	private java.lang.String __contract_name = null;
	private java.lang.String __contract_code = null;
	private java.lang.Integer __customer_id = null;
}

