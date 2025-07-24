package pomplatform.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSspecialdeductiontypessor extends GenericCondition{

	public ConditionSspecialdeductiontypessor(){
		setParameterCount(2);
	}

	public java.lang.String getSpecialDeductionTypeName() {
		return this.__special_deduction_type_name == null ? null : (this.__special_deduction_type_name.indexOf("%") >= 0 ? this.__special_deduction_type_name : "%"+this.__special_deduction_type_name+"%");
	}

	public void setSpecialDeductionTypeName( java.lang.String value ) {
		this.__special_deduction_type_name = value;
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
		if(getSpecialDeductionTypeName() != null) sb.append(__wrapString(1, "specialDeductionTypeName", getSpecialDeductionTypeName()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(1, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("specialDeductionTypeName")) != null) setSpecialDeductionTypeName(__getString(val));
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
	}

	private java.lang.String __special_deduction_type_name = null;
	private java.lang.Integer __special_deduction_type_id = null;
}

