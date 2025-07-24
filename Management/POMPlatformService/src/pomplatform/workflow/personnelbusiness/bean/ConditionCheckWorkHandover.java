package pomplatform.workflow.personnelbusiness.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCheckWorkHandover extends GenericCondition{

	public ConditionCheckWorkHandover(){
		setParameterCount(4);
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getLinkId() {
		return this.__link_id;
	}

	public void setLinkId( java.lang.Integer value ) {
		this.__link_id = value;
	}

	public java.lang.Integer getFromEmployeeId() {
		return this.__from_employee_id;
	}

	public void setFromEmployeeId( java.lang.Integer value ) {
		this.__from_employee_id = value;
	}

	public java.lang.Integer getToEmployeeId() {
		return this.__to_employee_id;
	}

	public void setToEmployeeId( java.lang.Integer value ) {
		this.__to_employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		if(getLinkId() != null) sb.append(__wrapNumber(1, "linkId", getLinkId()));
		if(getFromEmployeeId() != null) sb.append(__wrapNumber(1, "fromEmployeeId", getFromEmployeeId()));
		if(getToEmployeeId() != null) sb.append(__wrapNumber(1, "toEmployeeId", getToEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("linkId")) != null) setLinkId(__getInt(val)); 
		if((val = values.get("fromEmployeeId")) != null) setFromEmployeeId(__getInt(val)); 
		if((val = values.get("toEmployeeId")) != null) setToEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __type = null;
	private java.lang.Integer __link_id = null;
	private java.lang.Integer __from_employee_id = null;
	private java.lang.Integer __to_employee_id = null;
}

