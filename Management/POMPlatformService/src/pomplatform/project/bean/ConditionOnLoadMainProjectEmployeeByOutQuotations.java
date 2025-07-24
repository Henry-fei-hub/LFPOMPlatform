package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadMainProjectEmployeeByOutQuotations extends GenericCondition{

	public ConditionOnLoadMainProjectEmployeeByOutQuotations(){
		setParameterCount(3);
	}

	public java.lang.Integer getQuotationStatus() {
		return this.__quotation_status;
	}

	public void setQuotationStatus( java.lang.Integer value ) {
		this.__quotation_status = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getRelation() {
		return this.__relation;
	}

	public void setRelation( java.lang.Integer value ) {
		this.__relation = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getQuotationStatus() != null) sb.append(__wrapNumber(1, "quotationStatus", getQuotationStatus()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getRelation() != null) sb.append(__wrapNumber(1, "relation", getRelation()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("quotationStatus")) != null) setQuotationStatus(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("relation")) != null) setRelation(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getQuotationStatus() != null) res.add("quotationStatus");
		if(getProjectCode() != null) res.add("projectCode");
		if(getRelation() != null) res.add("relation");
		return res;
	}

	private java.lang.Integer __quotation_status = null;
	private java.lang.String __project_code = null;
	private java.lang.Integer __relation = null;
}

