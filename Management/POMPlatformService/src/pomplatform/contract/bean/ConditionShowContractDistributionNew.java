package pomplatform.contract.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionShowContractDistributionNew extends GenericCondition{

	public ConditionShowContractDistributionNew(){
		setParameterCount(5);
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

	public java.lang.String getOrderId() {
		return this.__order_id == null ? null : (this.__order_id.indexOf("%") >= 0 ? this.__order_id : "%"+this.__order_id+"%");
	}

	public void setOrderId( java.lang.String value ) {
		this.__order_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getOperationManagerId() {
		return this.__operation_manager_id;
	}

	public void setOperationManagerId( java.lang.Integer value ) {
		this.__operation_manager_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getOrderId() != null) sb.append(__wrapString(1, "orderId", getOrderId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getOperationManagerId() != null) sb.append(__wrapNumber(1, "operationManagerId", getOperationManagerId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("orderId")) != null) setOrderId(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("operationManagerId")) != null) setOperationManagerId(__getInt(val)); 
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.String __order_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __operation_manager_id = null;
}

