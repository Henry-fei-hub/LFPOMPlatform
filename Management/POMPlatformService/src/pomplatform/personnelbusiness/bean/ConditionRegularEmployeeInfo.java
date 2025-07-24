package pomplatform.personnelbusiness.bean;

import delicacy.common.GenericCondition;
import delicacy.date.util.DateUtil;

import java.util.Map;

public class ConditionRegularEmployeeInfo extends GenericCondition{

	public ConditionRegularEmployeeInfo(){
		setParameterCount(1);
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		value = DateUtil.getNextDayOfDay(value, 1);
		this.__end_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	private java.util.Date __end_date = null;
}

