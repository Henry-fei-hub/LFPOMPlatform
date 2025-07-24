package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdUserConfig extends GenericBase implements BaseFactory<BaseCwdUserConfig>, Comparable<BaseCwdUserConfig> 
{


	public static BaseCwdUserConfig newInstance(){
		return new BaseCwdUserConfig();
	}

	@Override
	public BaseCwdUserConfig make(){
		BaseCwdUserConfig b = new BaseCwdUserConfig();
		return b;
	}

	public final static java.lang.String CS_USER_CONFIG_ID = "user_config_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_MAC_ADDRESS = "mac_address" ;
	public final static java.lang.String CS_IP_ADDRESS = "ip_address" ;
	public final static java.lang.String CS_NAME_OF_HOST = "name_of_host" ;
	public final static java.lang.String CS_OS_TYPE = "os_type" ;
	public final static java.lang.String CS_WORK_DIR = "work_dir" ;
	public final static java.lang.String CS_LABEL = "label" ;
	public final static java.lang.String CS_IS_DEFAULT = "is_default" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,用户编码,mac地址,ip地址,主机名,操作系统类型,工作空间,标签,是否默认数据,创建时间";

	public java.lang.Integer getUserConfigId() {
		return this.__user_config_id;
	}

	public void setUserConfigId( java.lang.Integer value ) {
		this.__user_config_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getMacAddress() {
		return this.__mac_address;
	}

	public void setMacAddress( java.lang.String value ) {
		this.__mac_address = value;
	}

	public java.lang.String getIpAddress() {
		return this.__ip_address;
	}

	public void setIpAddress( java.lang.String value ) {
		this.__ip_address = value;
	}

	public java.lang.String getNameOfHost() {
		return this.__name_of_host;
	}

	public void setNameOfHost( java.lang.String value ) {
		this.__name_of_host = value;
	}

	public java.lang.Integer getOsType() {
		return this.__os_type;
	}

	public void setOsType( java.lang.Integer value ) {
		this.__os_type = value;
	}

	public java.lang.String getWorkDir() {
		return this.__work_dir;
	}

	public void setWorkDir( java.lang.String value ) {
		this.__work_dir = value;
	}

	public java.lang.String getLabel() {
		return this.__label;
	}

	public void setLabel( java.lang.String value ) {
		this.__label = value;
	}

	public java.lang.Boolean getIsDefault() {
		return this.__is_default;
	}

	public void setIsDefault( java.lang.Boolean value ) {
		this.__is_default = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdUserConfig __bean){
		__bean.setUserConfigId(getUserConfigId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setMacAddress(getMacAddress());
		__bean.setIpAddress(getIpAddress());
		__bean.setNameOfHost(getNameOfHost());
		__bean.setOsType(getOsType());
		__bean.setWorkDir(getWorkDir());
		__bean.setLabel(getLabel());
		__bean.setIsDefault(getIsDefault());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getUserConfigId() == null ? "" : getUserConfigId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getMacAddress() == null ? "" : getMacAddress());
		sb.append(",");
		sb.append(getIpAddress() == null ? "" : getIpAddress());
		sb.append(",");
		sb.append(getNameOfHost() == null ? "" : getNameOfHost());
		sb.append(",");
		sb.append(getOsType() == null ? "" : getOsType());
		sb.append(",");
		sb.append(getWorkDir() == null ? "" : getWorkDir());
		sb.append(",");
		sb.append(getLabel() == null ? "" : getLabel());
		sb.append(",");
		sb.append(getIsDefault() == null ? "" : getIsDefault());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdUserConfig o) {
		return __user_config_id == null ? -1 : __user_config_id.compareTo(o.getUserConfigId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__user_config_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__mac_address);
		hash = 97 * hash + Objects.hashCode(this.__ip_address);
		hash = 97 * hash + Objects.hashCode(this.__name_of_host);
		hash = 97 * hash + Objects.hashCode(this.__os_type);
		hash = 97 * hash + Objects.hashCode(this.__work_dir);
		hash = 97 * hash + Objects.hashCode(this.__label);
		hash = 97 * hash + Objects.hashCode(this.__is_default);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdUserConfig o = (BaseCwdUserConfig)obj;
		if(!Objects.equals(this.__user_config_id, o.getUserConfigId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__mac_address, o.getMacAddress())) return false;
		if(!Objects.equals(this.__ip_address, o.getIpAddress())) return false;
		if(!Objects.equals(this.__name_of_host, o.getNameOfHost())) return false;
		if(!Objects.equals(this.__os_type, o.getOsType())) return false;
		if(!Objects.equals(this.__work_dir, o.getWorkDir())) return false;
		if(!Objects.equals(this.__label, o.getLabel())) return false;
		if(!Objects.equals(this.__is_default, o.getIsDefault())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getUserConfigId() != null) sb.append(__wrapNumber(count++, "userConfigId", getUserConfigId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getMacAddress() != null) sb.append(__wrapString(count++, "macAddress", getMacAddress()));
		if(getIpAddress() != null) sb.append(__wrapString(count++, "ipAddress", getIpAddress()));
		if(getNameOfHost() != null) sb.append(__wrapString(count++, "nameOfHost", getNameOfHost()));
		if(getOsType() != null) sb.append(__wrapNumber(count++, "osType", getOsType()));
		if(getWorkDir() != null) sb.append(__wrapString(count++, "workDir", getWorkDir()));
		if(getLabel() != null) sb.append(__wrapString(count++, "label", getLabel()));
		if(getIsDefault() != null) sb.append(__wrapBoolean(count++, "isDefault", getIsDefault()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("userConfigId")) != null) setUserConfigId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("macAddress")) != null) setMacAddress(__getString(val));
		if((val = values.get("ipAddress")) != null) setIpAddress(__getString(val));
		if((val = values.get("nameOfHost")) != null) setNameOfHost(__getString(val));
		if((val = values.get("osType")) != null) setOsType(__getInt(val)); 
		if((val = values.get("workDir")) != null) setWorkDir(__getString(val));
		if((val = values.get("label")) != null) setLabel(__getString(val));
		if((val = values.get("isDefault")) != null) setIsDefault(__getBoolean(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __user_config_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __mac_address ;
	protected java.lang.String  __ip_address ;
	protected java.lang.String  __name_of_host ;
	protected java.lang.Integer  __os_type ;
	protected java.lang.String  __work_dir ;
	protected java.lang.String  __label ;
	protected java.lang.Boolean  __is_default ;
	protected java.util.Date  __create_time ;
}
