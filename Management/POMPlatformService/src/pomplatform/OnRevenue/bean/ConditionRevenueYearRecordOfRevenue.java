package pomplatform.OnRevenue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionRevenueYearRecordOfRevenue extends GenericCondition{

	public ConditionRevenueYearRecordOfRevenue(){
		setParameterCount(4);
	}

	public java.lang.Integer getSigningCompany() {
		return this.__signing_company;
	}

	public void setSigningCompany( java.lang.Integer value ) {
		this.__signing_company = value;
	}

	public java.lang.Boolean getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( java.lang.Boolean value ) {
		this.__is_finish = value;
	}

	public java.lang.Integer getYearRevenue() {
		return this.__year_revenue;
	}

	public void setYearRevenue( java.lang.Integer value ) {
		this.__year_revenue = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSigningCompany() != null) sb.append(__wrapNumber(1, "signingCompany", getSigningCompany()));
		if(getIsFinish() != null) sb.append(__wrapBoolean(1, "isFinish", getIsFinish()));
		if(getYearRevenue() != null) sb.append(__wrapNumber(1, "yearRevenue", getYearRevenue()));
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("signingCompany")) != null) setSigningCompany(__getInt(val)); 
		if((val = values.get("isFinish")) != null) setIsFinish(__getBoolean(val));
		if((val = values.get("yearRevenue")) != null) setYearRevenue(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
	}

	private java.lang.Integer __signing_company = null;
	private java.lang.Boolean __is_finish = null;
	private java.lang.Integer __year_revenue = null;
	private java.lang.Integer __parent_id = null;
}

