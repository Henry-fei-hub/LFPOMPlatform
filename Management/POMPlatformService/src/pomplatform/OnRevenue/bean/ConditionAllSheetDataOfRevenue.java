package pomplatform.OnRevenue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAllSheetDataOfRevenue extends GenericCondition{

	public ConditionAllSheetDataOfRevenue(){
		setParameterCount(2);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getBusinessStateRecordId() {
		return this.__business_state_record_id;
	}

	public void setBusinessStateRecordId( java.lang.Integer value ) {
		this.__business_state_record_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getBusinessStateRecordId() != null) sb.append(__wrapNumber(1, "businessStateRecordId", getBusinessStateRecordId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("businessStateRecordId")) != null) setBusinessStateRecordId(__getInt(val)); 
	}

	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __business_state_record_id = null;
}

