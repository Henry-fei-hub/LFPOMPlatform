package pomplatform.workflow.contractstatus.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractThatCanEnd extends GenericCondition{

	public ConditionContractThatCanEnd(){
		setParameterCount(4);
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.lang.Integer getProjectCostStatus() {
		return this.__project_cost_status;
	}

	public void setProjectCostStatus( java.lang.Integer value ) {
		this.__project_cost_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(1, "moneyAttribute", getMoneyAttribute()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getContractStatus() != null) sb.append(__wrapNumber(1, "contractStatus", getContractStatus()));
		if(getProjectCostStatus() != null) sb.append(__wrapNumber(1, "projectCostStatus", getProjectCostStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("projectCostStatus")) != null) setProjectCostStatus(__getInt(val)); 
	}

	private java.lang.Integer __money_attribute = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __contract_status = null;
	private java.lang.Integer __project_cost_status = null;
}

