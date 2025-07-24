package pomplatform.account.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnloadPlateSalaryAdvanceInfo extends GenericCondition{

	public ConditionOnloadPlateSalaryAdvanceInfo(){
		setParameterCount(1);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	private java.lang.Integer __plate_id = null;
}

