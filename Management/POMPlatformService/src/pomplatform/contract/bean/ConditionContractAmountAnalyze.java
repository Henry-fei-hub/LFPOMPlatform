package pomplatform.contract.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractAmountAnalyze extends GenericCondition{

	public ConditionContractAmountAnalyze(){
		setParameterCount(3);
	}

	public java.lang.Integer getContractSigningStatus() {
		return this.__contract_signing_status;
	}

	public void setContractSigningStatus( java.lang.Integer value ) {
		this.__contract_signing_status = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractSigningStatus() != null) sb.append(__wrapNumber(1, "contractSigningStatus", getContractSigningStatus()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractSigningStatus")) != null) setContractSigningStatus(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	private java.lang.Integer __contract_signing_status = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __plate_id = null;
}

