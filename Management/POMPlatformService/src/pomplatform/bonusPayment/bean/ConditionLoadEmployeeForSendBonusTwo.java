package pomplatform.bonusPayment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionLoadEmployeeForSendBonusTwo extends GenericCondition{

	public ConditionLoadEmployeeForSendBonusTwo(){
		setParameterCount(3);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.util.Date getPayDate() {
		return this.__pay_date;
	}

	public void setPayDate( java.util.Date value ) {
		this.__pay_date = value;
	}

	public java.lang.Integer getState() {
		return this.__state;
	}

	public void setState( java.lang.Integer value ) {
		this.__state = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getPayDate() != null) sb.append(__wrapDate(1, "payDate", getPayDate()));
		if(getState() != null) sb.append(__wrapNumber(1, "state", getState()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("payDate")) != null) setPayDate(__getDate(val)); 
		if((val = values.get("state")) != null) setState(__getInt(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.util.Date __pay_date = null;
	private java.lang.Integer __state = null;
}

