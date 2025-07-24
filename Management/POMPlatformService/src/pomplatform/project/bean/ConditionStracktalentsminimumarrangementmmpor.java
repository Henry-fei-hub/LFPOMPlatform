package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionStracktalentsminimumarrangementmmpor extends GenericCondition{

	public ConditionStracktalentsminimumarrangementmmpor(){
		setParameterCount(4);
	}

	public java.math.BigDecimal getMinAmount() {
		return this.__min_amount;
	}

	public void setMinAmount( java.math.BigDecimal value ) {
		this.__min_amount = value;
	}

	public java.math.BigDecimal getMaxAmount() {
		return this.__max_amount;
	}

	public void setMaxAmount( java.math.BigDecimal value ) {
		this.__max_amount = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinAmount() != null) sb.append(__wrapNumber(1, "minAmount", getMinAmount()));
		if(getMaxAmount() != null) sb.append(__wrapNumber(1, "maxAmount", getMaxAmount()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getProjectType() != null) sb.append(__wrapNumber(1, "projectType", getProjectType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minAmount")) != null) setMinAmount(__getDecimal(val));  
		if((val = values.get("maxAmount")) != null) setMaxAmount(__getDecimal(val));  
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
	}

	private java.math.BigDecimal __min_amount = null;
	private java.math.BigDecimal __max_amount = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __project_type = null;
}

