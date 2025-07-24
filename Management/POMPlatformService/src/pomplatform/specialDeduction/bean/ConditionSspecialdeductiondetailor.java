package pomplatform.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSspecialdeductiondetailor extends GenericCondition{

	public ConditionSspecialdeductiondetailor(){
		setParameterCount(3);
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(1, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
	}

	private java.lang.Integer __parent_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __special_deduction_type_id = null;
}

