package pomplatform.plateIntegralAccount.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionQualityFeeDetail extends GenericCondition{

	public ConditionQualityFeeDetail(){
		setParameterCount(4);
	}

	public java.lang.Integer getFromPlateId() {
		return this.__from_plate_id;
	}

	public void setFromPlateId( java.lang.Integer value ) {
		this.__from_plate_id = value;
	}

	public java.lang.Integer getToPlateId() {
		return this.__to_plate_id;
	}

	public void setToPlateId( java.lang.Integer value ) {
		this.__to_plate_id = value;
	}

	public java.lang.Integer getSendYear() {
		return this.__sendYear;
	}

	public void setSendYear( java.lang.Integer value ) {
		this.__sendYear = value;
	}

	public java.lang.Integer getSendMonth() {
		return this.__sendMonth;
	}

	public void setSendMonth( java.lang.Integer value ) {
		this.__sendMonth = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getFromPlateId() != null) sb.append(__wrapNumber(1, "fromPlateId", getFromPlateId()));
		if(getToPlateId() != null) sb.append(__wrapNumber(1, "toPlateId", getToPlateId()));
		if(getSendYear() != null) sb.append(__wrapNumber(1, "sendYear", getSendYear()));
		if(getSendMonth() != null) sb.append(__wrapNumber(1, "sendMonth", getSendMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("fromPlateId")) != null) setFromPlateId(__getInt(val)); 
		if((val = values.get("toPlateId")) != null) setToPlateId(__getInt(val)); 
		if((val = values.get("sendYear")) != null) setSendYear(__getInt(val)); 
		if((val = values.get("sendMonth")) != null) setSendMonth(__getInt(val)); 
	}

	private java.lang.Integer __from_plate_id = null;
	private java.lang.Integer __to_plate_id = null;
	private java.lang.Integer __sendYear = null;
	private java.lang.Integer __sendMonth = null;
}

