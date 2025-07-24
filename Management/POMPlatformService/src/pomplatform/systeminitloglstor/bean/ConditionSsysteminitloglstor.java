package pomplatform.systeminitloglstor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSsysteminitloglstor extends GenericCondition{

	public ConditionSsysteminitloglstor(){
		setParameterCount(4);
	}

	public java.lang.String getLogMsg() {
		return this.__log_msg == null ? null : (this.__log_msg.indexOf("%") >= 0 ? this.__log_msg : "%"+this.__log_msg+"%");
	}

	public void setLogMsg( java.lang.String value ) {
		this.__log_msg = value;
	}

	public java.lang.Integer getSystemInitLogId() {
		return this.__system_init_log_id;
	}

	public void setSystemInitLogId( java.lang.Integer value ) {
		this.__system_init_log_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getLogMsg() != null) sb.append(__wrapString(1, "logMsg", getLogMsg()));
		if(getSystemInitLogId() != null) sb.append(__wrapNumber(1, "systemInitLogId", getSystemInitLogId()));
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		if(getFlag() != null) sb.append(__wrapNumber(1, "flag", getFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("logMsg")) != null) setLogMsg(__getString(val));
		if((val = values.get("systemInitLogId")) != null) setSystemInitLogId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
	}

	private java.lang.String __log_msg = null;
	private java.lang.Integer __system_init_log_id = null;
	private java.lang.Integer __type = null;
	private java.lang.Integer __flag = null;
}

