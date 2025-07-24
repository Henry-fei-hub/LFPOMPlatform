package pomplatform.employeeWorkClassType.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionEmployeeWorkClassType extends GenericCondition{

	public ConditionEmployeeWorkClassType(){
		setParameterCount(2);
	}

	public java.lang.String getUserid() {
		return this.__userid;
	}

	public void setUserid( java.lang.String value ) {
		this.__userid = value;
	}

	public java.util.Date getCheckdate() {
		return this.__checkdate;
	}

	public void setCheckdate( java.util.Date value ) {
		this.__checkdate = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getUserid() != null) sb.append(__wrapString(1, "userid", getUserid()));
		if(getCheckdate() != null) sb.append(__wrapDate(1, "checkdate", getCheckdate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("userid")) != null) setUserid(__getString(val));
		if((val = values.get("checkdate")) != null) setCheckdate(__getDate(val)); 
	}

	private java.lang.String __userid = null;
	private java.util.Date __checkdate = null;
}

