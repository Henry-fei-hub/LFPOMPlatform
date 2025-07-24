package pomplatform.duty.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSemployeeDuty extends GenericCondition{

	public ConditionSemployeeDuty(){
		setParameterCount(2);
	}

	public java.lang.String getDutyName() {
		return this.__duty_name == null ? null : (this.__duty_name.indexOf("%") >= 0 ? this.__duty_name : "%"+this.__duty_name+"%");
	}

	public void setDutyName( java.lang.String value ) {
		this.__duty_name = value;
	}

	public java.lang.Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( java.lang.Integer value ) {
		this.__duty_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDutyName() != null) sb.append(__wrapString(1, "dutyName", getDutyName()));
		if(getDutyId() != null) sb.append(__wrapNumber(1, "dutyId", getDutyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("dutyName")) != null) setDutyName(__getString(val));
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
	}

	private java.lang.String __duty_name = null;
	private java.lang.Integer __duty_id = null;
}

