package pomplatform.plateproductionvalue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionSproductionvaluecoefficienttypepor extends GenericCondition{

	public ConditionSproductionvaluecoefficienttypepor(){
		setParameterCount(1);
	}

	public Integer getProductionValueCoefficientTypeId() {
		return this.__production_value_coefficient_type_id;
	}

	public void setProductionValueCoefficientTypeId( Integer value ) {
		this.__production_value_coefficient_type_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProductionValueCoefficientTypeId() != null) sb.append(__wrapNumber(1, "productionValueCoefficientTypeId", getProductionValueCoefficientTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("productionValueCoefficientTypeId")) != null) setProductionValueCoefficientTypeId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProductionValueCoefficientTypeId() != null) res.add("productionValueCoefficientTypeId");
		return res;
	}

	private Integer __production_value_coefficient_type_id = null;
}

