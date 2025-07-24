package pomplatform.cwd.personalregister.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPersonalRegisterAddressManage extends GenericCondition{

	public ConditionPersonalRegisterAddressManage(){
		setParameterCount(4);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getIpAddress() {
		return this.__ip_address == null ? null : (this.__ip_address.indexOf("%") >= 0 ? this.__ip_address : "%"+this.__ip_address+"%");
	}

	public void setIpAddress( java.lang.String value ) {
		this.__ip_address = value;
	}

	public java.lang.String getMacAddress() {
		return this.__mac_address == null ? null : (this.__mac_address.indexOf("%") >= 0 ? this.__mac_address : "%"+this.__mac_address+"%");
	}

	public void setMacAddress( java.lang.String value ) {
		this.__mac_address = value;
	}

	public java.lang.String getWorkplaceName() {
		return this.__workplace_name == null ? null : (this.__workplace_name.indexOf("%") >= 0 ? this.__workplace_name : "%"+this.__workplace_name+"%");
	}

	public void setWorkplaceName( java.lang.String value ) {
		this.__workplace_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getIpAddress() != null) sb.append(__wrapString(1, "ipAddress", getIpAddress()));
		if(getMacAddress() != null) sb.append(__wrapString(1, "macAddress", getMacAddress()));
		if(getWorkplaceName() != null) sb.append(__wrapString(1, "workplaceName", getWorkplaceName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("ipAddress")) != null) setIpAddress(__getString(val));
		if((val = values.get("macAddress")) != null) setMacAddress(__getString(val));
		if((val = values.get("workplaceName")) != null) setWorkplaceName(__getString(val));
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.String __ip_address = null;
	private java.lang.String __mac_address = null;
	private java.lang.String __workplace_name = null;
}

