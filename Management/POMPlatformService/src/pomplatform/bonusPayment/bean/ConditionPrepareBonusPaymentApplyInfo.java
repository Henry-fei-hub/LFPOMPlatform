package pomplatform.bonusPayment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPrepareBonusPaymentApplyInfo extends GenericCondition{

	public ConditionPrepareBonusPaymentApplyInfo(){
		setParameterCount(3);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.util.Date getResignationDate() {
		return __resignation_date;
	}

	public void setResignationDate(java.util.Date value) {
		this.__resignation_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getResignationDate() != null) sb.append(__wrapDate(1, "resignationDate", getResignationDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("resignationDate")) != null) setResignationDate(__getDate(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.util.Date __end_date = null;
	private java.util.Date __resignation_date = null;
}

