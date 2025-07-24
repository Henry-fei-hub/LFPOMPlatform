package pomplatform.OnRevenue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractInfoOfRevenue extends GenericCondition{

	public ConditionContractInfoOfRevenue(){
		setParameterCount(3);
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getSigningCompany() != null) sb.append(__wrapNumber(1, "signingCompany", getSigningCompany()));
		if(getIsFinish() != null) sb.append(__wrapBoolean(1, "isFinish", getIsFinish()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("signingCompany")) != null) setSigningCompany(__getInt(val)); 
		if((val = values.get("isFinish")) != null) setIsFinish(__getBoolean(val));
	}

	private java.util.Date __end_date = null;
	private java.lang.Integer __signing_company = null;
	private java.lang.Boolean __is_finish = null;
}

