package pomplatform.k3voucher.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionBankTransVoucherInfo extends GenericCondition{

	public ConditionBankTransVoucherInfo(){
		setParameterCount(3);
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getTransYear() {
		return this.__trans_year;
	}

	public void setTransYear( java.lang.Integer value ) {
		this.__trans_year = value;
	}

	public java.lang.Integer getTransMonth() {
		return this.__trans_month;
	}

	public void setTransMonth( java.lang.Integer value ) {
		this.__trans_month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getTransYear() != null) sb.append(__wrapNumber(1, "transYear", getTransYear()));
		if(getTransMonth() != null) sb.append(__wrapNumber(1, "transMonth", getTransMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("transYear")) != null) setTransYear(__getInt(val)); 
		if((val = values.get("transMonth")) != null) setTransMonth(__getInt(val)); 
	}

	private java.lang.Integer __company_id = null;
	private java.lang.Integer __trans_year = null;
	private java.lang.Integer __trans_month = null;
}

