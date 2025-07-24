package pomplatform.workflow.personnelbusiness.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetResignationIntegral extends GenericCondition{

	public ConditionGetResignationIntegral(){
		setParameterCount(5);
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

	public java.util.Date getStartDate() {
		return __start_date;
	}

	public void setStartDate(java.util.Date value) {
		this.__start_date = value;
	}

	public java.lang.Integer getStartMonth() {
		return __start_month;
	}

	public void setStartMonth(java.lang.Integer __start_month) {
		this.__start_month = __start_month;
	}

	public java.lang.Integer getEndMonth() {
		return __end_month;
	}

	public void setEndMonth(java.lang.Integer __end_month) {
		this.__end_month = __end_month;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getStartMonth() != null) sb.append(__wrapNumber(1, "startMonth", getStartMonth()));
		if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("startMonth")) != null) setStartMonth(__getInt(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.util.Date __end_date = null;
	private java.util.Date __start_date = null;
	private java.lang.Integer __start_month = null;
	private java.lang.Integer __end_month = null;
}

