package pomplatform.clocks.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionClockList extends GenericCondition{

	public ConditionClockList(){
		setParameterCount(5);
	}

	public java.lang.String getDeviceName() {
		return this.__device_name == null ? null : (this.__device_name.indexOf("%") >= 0 ? this.__device_name : "%"+this.__device_name+"%");
	}

	public void setDeviceName( java.lang.String value ) {
		this.__device_name = value;
	}

	public java.lang.String getAlias() {
		return this.__alias == null ? null : (this.__alias.indexOf("%") >= 0 ? this.__alias : "%"+this.__alias+"%");
	}

	public void setAlias( java.lang.String value ) {
		this.__alias = value;
	}

	public java.lang.Integer getClockTypeId() {
		return this.__clock_type_id;
	}

	public void setClockTypeId( java.lang.Integer value ) {
		this.__clock_type_id = value;
	}

	public java.lang.String getSn() {
		return this.__sn == null ? null : (this.__sn.indexOf("%") >= 0 ? this.__sn : "%"+this.__sn+"%");
	}

	public void setSn( java.lang.String value ) {
		this.__sn = value;
	}

	public java.lang.Integer getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Integer value ) {
		this.__is_enable = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDeviceName() != null) sb.append(__wrapString(1, "deviceName", getDeviceName()));
		if(getAlias() != null) sb.append(__wrapString(1, "alias", getAlias()));
		if(getClockTypeId() != null) sb.append(__wrapNumber(1, "clockTypeId", getClockTypeId()));
		if(getSn() != null) sb.append(__wrapString(1, "sn", getSn()));
		if(getIsEnable() != null) sb.append(__wrapNumber(1, "isEnable", getIsEnable()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("deviceName")) != null) setDeviceName(__getString(val));
		if((val = values.get("alias")) != null) setAlias(__getString(val));
		if((val = values.get("clockTypeId")) != null) setClockTypeId(__getInt(val)); 
		if((val = values.get("sn")) != null) setSn(__getString(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getInt(val)); 
	}

	private java.lang.String __device_name = null;
	private java.lang.String __alias = null;
	private java.lang.Integer __clock_type_id = null;
	private java.lang.String __sn = null;
	private java.lang.Integer __is_enable = null;
}

