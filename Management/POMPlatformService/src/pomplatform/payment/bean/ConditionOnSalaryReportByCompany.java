package pomplatform.payment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnSalaryReportByCompany extends GenericCondition{

	public ConditionOnSalaryReportByCompany(){
		setParameterCount(3);
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
	}

	private java.lang.Integer __company_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
}

