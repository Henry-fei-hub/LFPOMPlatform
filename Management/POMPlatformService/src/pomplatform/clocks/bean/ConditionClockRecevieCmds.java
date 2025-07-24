package pomplatform.clocks.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionClockRecevieCmds extends GenericCondition{

	public ConditionClockRecevieCmds(){
		setParameterCount(4);
	}

	public java.lang.Short getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Short value ) {
		this.__status = value;
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

	public java.lang.String getDeviceName() {
		return this.__device_name == null ? null : (this.__device_name.indexOf("%") >= 0 ? this.__device_name : "%"+this.__device_name+"%");
	}

	public void setDeviceName( java.lang.String value ) {
		this.__device_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getDeviceName() != null) sb.append(__wrapString(1, "deviceName", getDeviceName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("status")) != null) setStatus(__getShort(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("deviceName")) != null) setDeviceName(__getString(val));
	}

	private java.lang.Short __status = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.String __device_name = null;
}

