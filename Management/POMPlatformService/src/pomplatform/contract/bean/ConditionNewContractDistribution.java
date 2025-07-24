package pomplatform.contract.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionNewContractDistribution extends GenericCondition{

	public ConditionNewContractDistribution(){
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

	public java.lang.Integer getSelectYear() {
		return this.__select_year;
	}

	public void setSelectYear( java.lang.Integer value ) {
		this.__select_year = value;
	}

	public java.lang.Integer getSelectMonth() {
		return this.__select_month;
	}

	public void setSelectMonth( java.lang.Integer value ) {
		this.__select_month = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getContractSigningStatus() {
		return this.__contract_signing_status;
	}

	public void setContractSigningStatus( java.lang.Integer value ) {
		this.__contract_signing_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getSelectYear() != null) sb.append(__wrapNumber(1, "selectYear", getSelectYear()));
		if(getSelectMonth() != null) sb.append(__wrapNumber(1, "selectMonth", getSelectMonth()));
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
		if((val = values.get("selectYear")) != null) setSelectYear(__getInt(val)); 
		if((val = values.get("selectMonth")) != null) setSelectMonth(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("contractSigningStatus")) != null) setContractSigningStatus(__getInt(val)); 
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Integer __select_year = null;
	private java.lang.Integer __select_month = null;
	private java.lang.String __business_type = null;
	private java.lang.Integer __contract_signing_status = null;
}

