package pomplatform.sProjectAdvanceRecord.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSProjectAdvanceRecord extends GenericCondition{

	public ConditionSProjectAdvanceRecord(){
		setParameterCount(3);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getAdvanceYear() {
		return this.__advance_year;
	}

	public void setAdvanceYear( java.lang.Integer value ) {
		this.__advance_year = value;
	}

	public java.lang.Integer getAdvanceMonth() {
		return this.__advance_month;
	}

	public void setAdvanceMonth( java.lang.Integer value ) {
		this.__advance_month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getAdvanceYear() != null) sb.append(__wrapNumber(1, "advanceYear", getAdvanceYear()));
		if(getAdvanceMonth() != null) sb.append(__wrapNumber(1, "advanceMonth", getAdvanceMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("advanceYear")) != null) setAdvanceYear(__getInt(val)); 
		if((val = values.get("advanceMonth")) != null) setAdvanceMonth(__getInt(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __advance_year = null;
	private java.lang.Integer __advance_month = null;
}

