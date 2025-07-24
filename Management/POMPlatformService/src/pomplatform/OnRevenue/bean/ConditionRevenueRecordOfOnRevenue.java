package pomplatform.OnRevenue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionRevenueRecordOfOnRevenue extends GenericCondition{

	public ConditionRevenueRecordOfOnRevenue(){
		setParameterCount(2);
	}

	public java.lang.Integer getSigningCompany() {
		return this.__signing_company;
	}

	public void setSigningCompany( java.lang.Integer value ) {
		this.__signing_company = value;
	}

	public java.lang.String getName() {
		return this.__name == null ? null : (this.__name.indexOf("%") >= 0 ? this.__name : "%"+this.__name+"%");
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSigningCompany() != null) sb.append(__wrapNumber(1, "signingCompany", getSigningCompany()));
		if(getName() != null) sb.append(__wrapString(1, "name", getName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("signingCompany")) != null) setSigningCompany(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
	}

	private java.lang.Integer __signing_company = null;
	private java.lang.String __name = null;
}

