package pomplatform.employee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionLastMarketingCommission extends GenericCondition{

	public ConditionLastMarketingCommission(){
		setParameterCount(2);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getSettlementIdentifier() {
		return this.__settlement_identifier;
	}

	public void setSettlementIdentifier( java.lang.Integer value ) {
		this.__settlement_identifier = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getSettlementIdentifier() != null) sb.append(__wrapNumber(1, "settlementIdentifier", getSettlementIdentifier()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("settlementIdentifier")) != null) setSettlementIdentifier(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __settlement_identifier = null;
}

