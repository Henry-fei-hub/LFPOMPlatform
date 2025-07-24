package pomplatform.workflow.operation.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadApplyListOfCostAllocation extends GenericCondition{

	public ConditionOnLoadApplyListOfCostAllocation(){
		setParameterCount(6);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name == null ? null : (this.__name.indexOf("%") >= 0 ? this.__name : "%"+this.__name+"%");
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public java.lang.Integer getCostType() {
		return this.__cost_type;
	}

	public void setCostType( java.lang.Integer value ) {
		this.__cost_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getDrafter() != null) sb.append(__wrapNumber(1, "drafter", getDrafter()));
		if(getCode() != null) sb.append(__wrapString(1, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(1, "name", getName()));
		if(getCost() != null) sb.append(__wrapNumber(1, "cost", getCost()));
		if(getCostType() != null) sb.append(__wrapNumber(1, "costType", getCostType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("costType")) != null) setCostType(__getInt(val)); 
	}

	private java.lang.Integer __process_type = null;
	private java.lang.Integer __drafter = null;
	private java.lang.String __code = null;
	private java.lang.String __name = null;
	private java.math.BigDecimal __cost = null;
	private java.lang.Integer __cost_type = null;
}

