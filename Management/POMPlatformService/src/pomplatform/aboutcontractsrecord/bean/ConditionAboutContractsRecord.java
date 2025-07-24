package pomplatform.aboutcontractsrecord.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAboutContractsRecord extends GenericCondition{

	public ConditionAboutContractsRecord(){
		setParameterCount(2);
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
	}

	private java.lang.String __info_code = null;
	private java.lang.Integer __contract_id = null;
}

