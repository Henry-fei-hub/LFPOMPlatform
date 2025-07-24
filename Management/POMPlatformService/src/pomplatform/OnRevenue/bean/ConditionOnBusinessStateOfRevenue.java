package pomplatform.OnRevenue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnBusinessStateOfRevenue extends GenericCondition{

	public ConditionOnBusinessStateOfRevenue(){
		setParameterCount(4);
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getSigningCompany() {
		return this.__signing_company;
	}

	public void setSigningCompany( java.lang.Integer value ) {
		this.__signing_company = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getSigningCompany() != null) sb.append(__wrapNumber(1, "signingCompany", getSigningCompany()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("signingCompany")) != null) setSigningCompany(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
	}

	private java.lang.Integer __month = null;
	private java.lang.Integer __signing_company = null;
	private java.util.Date __end_date = null;
	private java.lang.String __contract_code = null;
}

