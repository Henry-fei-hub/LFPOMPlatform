package pomplatform.bonusPayment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionLoadEmployeeForSendBonus extends GenericCondition{

	public ConditionLoadEmployeeForSendBonus(){
		setParameterCount(2);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.util.Date __start_date = null;
}

