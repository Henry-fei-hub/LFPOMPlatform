package pomplatform.payment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionFiveinsuranceSummary extends GenericCondition{

	public ConditionFiveinsuranceSummary(){
		setParameterCount(4);
	}

	public java.lang.Integer getStartMonth() {
		return this.__start_month;
	}

	public void setStartMonth( java.lang.Integer value ) {
		this.__start_month = value;
	}

	public java.lang.Integer getEndMonth() {
		return this.__end_month;
	}

	public void setEndMonth( java.lang.Integer value ) {
		this.__end_month = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartMonth() != null) sb.append(__wrapNumber(1, "startMonth", getStartMonth()));
		if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startMonth")) != null) setStartMonth(__getInt(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val));
	}

	private java.lang.Integer __start_month = null;
	private java.lang.Integer __end_month = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __company_id = null;
}

