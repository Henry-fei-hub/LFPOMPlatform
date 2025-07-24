package pomplatform.k3voucher.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGenerateCapitalVoucher extends GenericCondition{

	public ConditionGenerateCapitalVoucher(){
		setParameterCount(5);
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
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

	public java.lang.Boolean getHaveVoucher() {
		return this.__have_voucher;
	}

	public void setHaveVoucher( java.lang.Boolean value ) {
		this.__have_voucher = value;
	}

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(1, "moneyAttribute", getMoneyAttribute()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getHaveVoucher() != null) sb.append(__wrapBoolean(1, "haveVoucher", getHaveVoucher()));
		if(getSelfName() != null) sb.append(__wrapNumber(1, "selfName", getSelfName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("haveVoucher")) != null) setHaveVoucher(__getBoolean(val));
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
	}

	private java.lang.Integer __money_attribute = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Boolean __have_voucher = null;
	private java.lang.Integer __self_name = null;
}

