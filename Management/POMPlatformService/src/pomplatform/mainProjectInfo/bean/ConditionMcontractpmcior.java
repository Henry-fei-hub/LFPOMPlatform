package pomplatform.mainProjectInfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcontractpmcior extends GenericCondition{

	public ConditionMcontractpmcior(){
		setParameterCount(2);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
	}

	private java.lang.Integer __contract_id = null;
	private java.lang.String __info_code = null;
}

