package pomplatform.plateproductionvalue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionSproductionvaluecoefficienttypepcor extends GenericCondition{

	public ConditionSproductionvaluecoefficienttypepcor(){
		setParameterCount(2);
	}

	public Integer getProductionValueCoefficientTypeId() {
		return this.__production_value_coefficient_type_id;
	}

	public void setProductionValueCoefficientTypeId( Integer value ) {
		this.__production_value_coefficient_type_id = value;
	}

	public String getCoefficientType() {
		return this.__coefficient_type;
	}

	public void setCoefficientType( String value ) {
		this.__coefficient_type = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProductionValueCoefficientTypeId() != null) sb.append(__wrapNumber(1, "productionValueCoefficientTypeId", getProductionValueCoefficientTypeId()));
		if(getCoefficientType() != null) sb.append(__wrapString(1, "coefficientType", getCoefficientType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("productionValueCoefficientTypeId")) != null) setProductionValueCoefficientTypeId(__getInt(val)); 
		if((val = values.get("coefficientType")) != null) setCoefficientType(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProductionValueCoefficientTypeId() != null) res.add("productionValueCoefficientTypeId");
		if(getCoefficientType() != null) res.add("coefficientType");
		return res;
	}

	private Integer __production_value_coefficient_type_id = null;
	private String __coefficient_type = null;
}

