package pomplatform.account.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditiononLoadAccountInfoOfPlateAccount extends GenericCondition{

	public ConditiononLoadAccountInfoOfPlateAccount(){
		setParameterCount(4);
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
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

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	private java.lang.Integer __parent_id = null;
	private java.lang.Integer __plate_id = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
}

