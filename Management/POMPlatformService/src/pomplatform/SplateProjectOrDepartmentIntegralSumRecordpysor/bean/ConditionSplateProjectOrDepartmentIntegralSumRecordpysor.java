package pomplatform.SplateProjectOrDepartmentIntegralSumRecordpysor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSplateProjectOrDepartmentIntegralSumRecordpysor extends GenericCondition{

	public ConditionSplateProjectOrDepartmentIntegralSumRecordpysor(){
		setParameterCount(4);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getStartMonth() {
		return this.__start_month;
	}

	public void setStartMonth( java.lang.Integer value ) {
		this.__start_month = value;
	}

	public java.lang.Integer getEndMonth() {
		return this.__end_month;
	}

	public void setEndMonth( java.lang.Integer value ) {
		this.__end_month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getStartMonth() != null) sb.append(__wrapNumber(1, "startMonth", getStartMonth()));
		if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("startMonth")) != null) setStartMonth(__getInt(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __start_month = null;
	private java.lang.Integer __end_month = null;
}

