package pomplatform.contract.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractDistribution extends GenericCondition{

	public ConditionContractDistribution(){
		setParameterCount(6);
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

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getContractSigningStatus() {
		return __contract_signing_status;
	}

	public void setContractSigningStatus(java.lang.Integer __contract_signing_status) {
		this.__contract_signing_status = __contract_signing_status;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getBusinessType() != null) sb.append(__wrapString(1, "businessType", getBusinessType()));
		if(getContractSigningStatus() != null) sb.append(__wrapNumber(1, "contractSigningStatus", getContractSigningStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("contractSigningStatus")) != null) setContractSigningStatus(__getInt(val)); 
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.String __business_type = null;
	private java.lang.Integer __contract_signing_status = null;
}

