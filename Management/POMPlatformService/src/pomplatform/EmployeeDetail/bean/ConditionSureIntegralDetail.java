package pomplatform.EmployeeDetail.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSureIntegralDetail extends GenericCondition{

	public ConditionSureIntegralDetail(){
		setParameterCount(3);
	}

	public java.lang.Integer getSettlementYear() {
		return this.__settlement_year;
	}

	public void setSettlementYear( java.lang.Integer value ) {
		this.__settlement_year = value;
	}

	public java.lang.Integer getSettlementMonth() {
		return this.__settlement_month;
	}

	public void setSettlementMonth( java.lang.Integer value ) {
		this.__settlement_month = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSettlementYear() != null) sb.append(__wrapNumber(1, "settlementYear", getSettlementYear()));
		if(getSettlementMonth() != null) sb.append(__wrapNumber(1, "settlementMonth", getSettlementMonth()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("settlementYear")) != null) setSettlementYear(__getInt(val)); 
		if((val = values.get("settlementMonth")) != null) setSettlementMonth(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __settlement_year = null;
	private java.lang.Integer __settlement_month = null;
	private java.lang.Integer __employee_id = null;
}

