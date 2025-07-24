package delicacy.oa.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionMemployeeworkor extends GenericCondition{

	public ConditionMemployeeworkor(){
		setParameterCount(4);
	}

	public java.lang.String getUserid() {
		return this.__userid;
	}

	public void setUserid( java.lang.String value ) {
		this.__userid = value;
	}

	public java.lang.String getUsername() {
		return this.__username;
	}

	public void setUsername( java.lang.String value ) {
		this.__username = value;
	}

	public java.util.Date getStartdate() {
		return this.__startdate;
	}

	public void setStartdate( java.util.Date value ) {
		this.__startdate = value;
	}

	public java.util.Date getEnddate() {
		return this.__enddate;
	}

	public void setEnddate( java.util.Date value ) {
		this.__enddate = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getUserid() != null) sb.append(__wrapString(1, "userid", getUserid()));
		if(getUsername() != null) sb.append(__wrapString(1, "username", getUsername()));
		if(getStartdate() != null) sb.append(__wrapDate(1, "startdate", getStartdate()));
		if(getEnddate() != null) sb.append(__wrapDate(1, "enddate", getEnddate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("userid")) != null) setUserid(__getString(val));
		if((val = values.get("username")) != null) setUsername(__getString(val));
		if((val = values.get("startdate")) != null) setStartdate(__getDate(val)); 
		if((val = values.get("enddate")) != null) setEnddate(__getDate(val)); 
	}

	private java.lang.String __userid = null;
	private java.lang.String __username = null;
	private java.util.Date __startdate = null;
	private java.util.Date __enddate = null;
}

