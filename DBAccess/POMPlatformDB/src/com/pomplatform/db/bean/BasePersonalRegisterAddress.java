package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePersonalRegisterAddress extends GenericBase implements BaseFactory<BasePersonalRegisterAddress>, Comparable<BasePersonalRegisterAddress> 
{


	public static BasePersonalRegisterAddress newInstance(){
		return new BasePersonalRegisterAddress();
	}

	@Override
	public BasePersonalRegisterAddress make(){
		BasePersonalRegisterAddress b = new BasePersonalRegisterAddress();
		return b;
	}

	public final static java.lang.String CS_PERSONAL_REGISTER_ADDRESS_ID = "personal_register_address_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_IP_ADDRESS = "ip_address" ;
	public final static java.lang.String CS_MAC_ADDRESS = "mac_address" ;
	public final static java.lang.String CS_WORKPLACE_ID = "workplace_id" ;
	public final static java.lang.String CS_REGISTER_TIME = "register_time" ;
	public final static java.lang.String CS_ACTIVE = "active" ;

	public final static java.lang.String ALL_CAPTIONS = "工作场所编码,注册用户编码,公网IP地址,机器MAC地址,工作场所编码, 0 - 未知，1 - 家里，2 - 出差，其他 - 具体公司的工作场所,注册时间,是否有效";

	public java.lang.Integer getPersonalRegisterAddressId() {
		return this.__personal_register_address_id;
	}

	public void setPersonalRegisterAddressId( java.lang.Integer value ) {
		this.__personal_register_address_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getIpAddress() {
		return this.__ip_address;
	}

	public void setIpAddress( java.lang.String value ) {
		this.__ip_address = value;
	}

	public java.lang.String getMacAddress() {
		return this.__mac_address;
	}

	public void setMacAddress( java.lang.String value ) {
		this.__mac_address = value;
	}

	public java.lang.Integer getWorkplaceId() {
		return this.__workplace_id;
	}

	public void setWorkplaceId( java.lang.Integer value ) {
		this.__workplace_id = value;
	}

	public java.util.Date getRegisterTime() {
		return this.__register_time;
	}

	public void setRegisterTime( java.util.Date value ) {
		this.__register_time = value;
	}

	public java.lang.Boolean getActive() {
		return this.__active;
	}

	public void setActive( java.lang.Boolean value ) {
		this.__active = value;
	}

	public void cloneCopy(BasePersonalRegisterAddress __bean){
		__bean.setPersonalRegisterAddressId(getPersonalRegisterAddressId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setIpAddress(getIpAddress());
		__bean.setMacAddress(getMacAddress());
		__bean.setWorkplaceId(getWorkplaceId());
		__bean.setRegisterTime(getRegisterTime());
		__bean.setActive(getActive());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPersonalRegisterAddressId() == null ? "" : getPersonalRegisterAddressId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getIpAddress() == null ? "" : getIpAddress());
		sb.append(",");
		sb.append(getMacAddress() == null ? "" : getMacAddress());
		sb.append(",");
		sb.append(getWorkplaceId() == null ? "" : getWorkplaceId());
		sb.append(",");
		sb.append(getRegisterTime() == null ? "" : sdf.format(getRegisterTime()));
		sb.append(",");
		sb.append(getActive() == null ? "" : getActive());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePersonalRegisterAddress o) {
		return __personal_register_address_id == null ? -1 : __personal_register_address_id.compareTo(o.getPersonalRegisterAddressId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__personal_register_address_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__ip_address);
		hash = 97 * hash + Objects.hashCode(this.__mac_address);
		hash = 97 * hash + Objects.hashCode(this.__workplace_id);
		hash = 97 * hash + Objects.hashCode(this.__register_time);
		hash = 97 * hash + Objects.hashCode(this.__active);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePersonalRegisterAddress o = (BasePersonalRegisterAddress)obj;
		if(!Objects.equals(this.__personal_register_address_id, o.getPersonalRegisterAddressId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__ip_address, o.getIpAddress())) return false;
		if(!Objects.equals(this.__mac_address, o.getMacAddress())) return false;
		if(!Objects.equals(this.__workplace_id, o.getWorkplaceId())) return false;
		if(!Objects.equals(this.__register_time, o.getRegisterTime())) return false;
		if(!Objects.equals(this.__active, o.getActive())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPersonalRegisterAddressId() != null) sb.append(__wrapNumber(count++, "personalRegisterAddressId", getPersonalRegisterAddressId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getIpAddress() != null) sb.append(__wrapString(count++, "ipAddress", getIpAddress()));
		if(getMacAddress() != null) sb.append(__wrapString(count++, "macAddress", getMacAddress()));
		if(getWorkplaceId() != null) sb.append(__wrapNumber(count++, "workplaceId", getWorkplaceId()));
		if(getRegisterTime() != null) sb.append(__wrapDate(count++, "registerTime", getRegisterTime()));
		if(getActive() != null) sb.append(__wrapBoolean(count++, "active", getActive()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("personalRegisterAddressId")) != null) setPersonalRegisterAddressId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("ipAddress")) != null) setIpAddress(__getString(val));
		if((val = values.get("macAddress")) != null) setMacAddress(__getString(val));
		if((val = values.get("workplaceId")) != null) setWorkplaceId(__getInt(val)); 
		if((val = values.get("registerTime")) != null) setRegisterTime(__getDate(val)); 
		if((val = values.get("active")) != null) setActive(__getBoolean(val));
	}

	protected java.lang.Integer  __personal_register_address_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __ip_address ;
	protected java.lang.String  __mac_address ;
	protected java.lang.Integer  __workplace_id ;
	protected java.util.Date  __register_time ;
	protected java.lang.Boolean  __active ;
}
