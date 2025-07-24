package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionReportOfGenderPlateMonth extends GenericCondition{

	public ConditionReportOfGenderPlateMonth(){
		setParameterCount(2);
	}

	public java.util.Date getTheDate() {
		return this.__the_date;
	}

	public void setTheDate( java.util.Date value ) {
		this.__the_date = value;
	}

	public java.lang.Integer getPlateType() {
		return this.__plate_type;
	}

	public void setPlateType( java.lang.Integer value ) {
		this.__plate_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTheDate() != null) sb.append(__wrapDate(1, "theDate", getTheDate()));
		if(getPlateType() != null) sb.append(__wrapNumber(1, "plateType", getPlateType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("theDate")) != null) setTheDate(__getDate(val)); 
		if((val = values.get("plateType")) != null) setPlateType(__getInt(val)); 
	}

	private java.util.Date __the_date = null;
	private java.lang.Integer __plate_type = null;
}

