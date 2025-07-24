package pomplatform.plateIntegralAccount.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionQualityFeeMonthlyDetail extends GenericCondition{

	public ConditionQualityFeeMonthlyDetail(){
		setParameterCount(3);
	}

	public java.lang.Integer getFromPlateId() {
		return this.__from_plate_id;
	}

	public void setFromPlateId( java.lang.Integer value ) {
		this.__from_plate_id = value;
	}

	public java.lang.Integer getSendYear() {
		return this.__send_year;
	}

	public void setSendYear( java.lang.Integer value ) {
		this.__send_year = value;
	}

	public java.lang.Integer getSendMonth() {
		return this.__send_month;
	}

	public void setSendMonth( java.lang.Integer value ) {
		this.__send_month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getFromPlateId() != null) sb.append(__wrapNumber(1, "fromPlateId", getFromPlateId()));
		if(getSendYear() != null) sb.append(__wrapNumber(1, "sendYear", getSendYear()));
		if(getSendMonth() != null) sb.append(__wrapNumber(1, "sendMonth", getSendMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("fromPlateId")) != null) setFromPlateId(__getInt(val)); 
		if((val = values.get("sendYear")) != null) setSendYear(__getInt(val)); 
		if((val = values.get("sendMonth")) != null) setSendMonth(__getInt(val)); 
	}

	private java.lang.Integer __from_plate_id = null;
	private java.lang.Integer __send_year = null;
	private java.lang.Integer __send_month = null;
}

