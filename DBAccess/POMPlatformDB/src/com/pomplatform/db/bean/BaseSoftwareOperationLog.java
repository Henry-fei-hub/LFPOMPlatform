package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSoftwareOperationLog extends GenericBase implements BaseFactory<BaseSoftwareOperationLog>, Comparable<BaseSoftwareOperationLog> 
{


	public static BaseSoftwareOperationLog newInstance(){
		return new BaseSoftwareOperationLog();
	}

	@Override
	public BaseSoftwareOperationLog make(){
		BaseSoftwareOperationLog b = new BaseSoftwareOperationLog();
		return b;
	}

	public final static java.lang.String CS_SOFTWARE_OPERATION_LOG_ID = "software_operation_log_id" ;
	public final static java.lang.String CS_OPERATION_TYPE = "operation_type" ;
	public final static java.lang.String CS_MAC_ADDRESS = "mac_address" ;
	public final static java.lang.String CS_IP_ADDRESS = "ip_address" ;
	public final static java.lang.String CS_MACHINE_NAME = "machine_name" ;
	public final static java.lang.String CS_SOFTWARE_TYPE = "software_type" ;
	public final static java.lang.String CS_LOCAL_OPERATION_TIME = "local_operation_time" ;
	public final static java.lang.String CS_LOCAL_REQUEST_TIME = "local_request_time" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_CURRENT_VERSION_NO = "current_version_no" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_ORI_VERSION_NO = "ori_version_no" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,操作类型1 安装 2卸载,mac地址,ip地址,机器名称,软件类型 1 本地文件服务 2 本地存储,本地操作时间,本地请求时间,创建时间,当前系统版本号,当前登录人主键,源版本";

	public java.lang.Integer getSoftwareOperationLogId() {
		return this.__software_operation_log_id;
	}

	public void setSoftwareOperationLogId( java.lang.Integer value ) {
		this.__software_operation_log_id = value;
	}

	public java.lang.Integer getOperationType() {
		return this.__operation_type;
	}

	public void setOperationType( java.lang.Integer value ) {
		this.__operation_type = value;
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

	public java.lang.String getMachineName() {
		return this.__machine_name;
	}

	public void setMachineName( java.lang.String value ) {
		this.__machine_name = value;
	}

	public java.lang.Integer getSoftwareType() {
		return this.__software_type;
	}

	public void setSoftwareType( java.lang.Integer value ) {
		this.__software_type = value;
	}

	public java.util.Date getLocalOperationTime() {
		return this.__local_operation_time;
	}

	public void setLocalOperationTime( java.util.Date value ) {
		this.__local_operation_time = value;
	}

	public java.util.Date getLocalRequestTime() {
		return this.__local_request_time;
	}

	public void setLocalRequestTime( java.util.Date value ) {
		this.__local_request_time = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.math.BigDecimal getCurrentVersionNo() {
		return this.__current_version_no;
	}

	public void setCurrentVersionNo( java.math.BigDecimal value ) {
		this.__current_version_no = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.math.BigDecimal getOriVersionNo() {
		return this.__ori_version_no;
	}

	public void setOriVersionNo( java.math.BigDecimal value ) {
		this.__ori_version_no = value;
	}

	public void cloneCopy(BaseSoftwareOperationLog __bean){
		__bean.setSoftwareOperationLogId(getSoftwareOperationLogId());
		__bean.setOperationType(getOperationType());
		__bean.setMacAddress(getMacAddress());
		__bean.setIpAddress(getIpAddress());
		__bean.setMachineName(getMachineName());
		__bean.setSoftwareType(getSoftwareType());
		__bean.setLocalOperationTime(getLocalOperationTime());
		__bean.setLocalRequestTime(getLocalRequestTime());
		__bean.setCreateTime(getCreateTime());
		__bean.setCurrentVersionNo(getCurrentVersionNo());
		__bean.setOperator(getOperator());
		__bean.setOriVersionNo(getOriVersionNo());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSoftwareOperationLogId() == null ? "" : getSoftwareOperationLogId());
		sb.append(",");
		sb.append(getOperationType() == null ? "" : getOperationType());
		sb.append(",");
		sb.append(getMacAddress() == null ? "" : getMacAddress());
		sb.append(",");
		sb.append(getIpAddress() == null ? "" : getIpAddress());
		sb.append(",");
		sb.append(getMachineName() == null ? "" : getMachineName());
		sb.append(",");
		sb.append(getSoftwareType() == null ? "" : getSoftwareType());
		sb.append(",");
		sb.append(getLocalOperationTime() == null ? "" : sdf.format(getLocalOperationTime()));
		sb.append(",");
		sb.append(getLocalRequestTime() == null ? "" : sdf.format(getLocalRequestTime()));
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCurrentVersionNo() == null ? "" : getCurrentVersionNo());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getOriVersionNo() == null ? "" : getOriVersionNo());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSoftwareOperationLog o) {
		return __software_operation_log_id == null ? -1 : __software_operation_log_id.compareTo(o.getSoftwareOperationLogId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__software_operation_log_id);
		hash = 97 * hash + Objects.hashCode(this.__operation_type);
		hash = 97 * hash + Objects.hashCode(this.__mac_address);
		hash = 97 * hash + Objects.hashCode(this.__ip_address);
		hash = 97 * hash + Objects.hashCode(this.__machine_name);
		hash = 97 * hash + Objects.hashCode(this.__software_type);
		hash = 97 * hash + Objects.hashCode(this.__local_operation_time);
		hash = 97 * hash + Objects.hashCode(this.__local_request_time);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__current_version_no);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__ori_version_no);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSoftwareOperationLog o = (BaseSoftwareOperationLog)obj;
		if(!Objects.equals(this.__software_operation_log_id, o.getSoftwareOperationLogId())) return false;
		if(!Objects.equals(this.__operation_type, o.getOperationType())) return false;
		if(!Objects.equals(this.__mac_address, o.getMacAddress())) return false;
		if(!Objects.equals(this.__ip_address, o.getIpAddress())) return false;
		if(!Objects.equals(this.__machine_name, o.getMachineName())) return false;
		if(!Objects.equals(this.__software_type, o.getSoftwareType())) return false;
		if(!Objects.equals(this.__local_operation_time, o.getLocalOperationTime())) return false;
		if(!Objects.equals(this.__local_request_time, o.getLocalRequestTime())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__current_version_no, o.getCurrentVersionNo())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__ori_version_no, o.getOriVersionNo())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSoftwareOperationLogId() != null) sb.append(__wrapNumber(count++, "softwareOperationLogId", getSoftwareOperationLogId()));
		if(getOperationType() != null) sb.append(__wrapNumber(count++, "operationType", getOperationType()));
		if(getMacAddress() != null) sb.append(__wrapString(count++, "macAddress", getMacAddress()));
		if(getIpAddress() != null) sb.append(__wrapString(count++, "ipAddress", getIpAddress()));
		if(getMachineName() != null) sb.append(__wrapString(count++, "machineName", getMachineName()));
		if(getSoftwareType() != null) sb.append(__wrapNumber(count++, "softwareType", getSoftwareType()));
		if(getLocalOperationTime() != null) sb.append(__wrapDate(count++, "localOperationTime", getLocalOperationTime()));
		if(getLocalRequestTime() != null) sb.append(__wrapDate(count++, "localRequestTime", getLocalRequestTime()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCurrentVersionNo() != null) sb.append(__wrapDecimal(count++, "currentVersionNo", getCurrentVersionNo()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getOriVersionNo() != null) sb.append(__wrapDecimal(count++, "oriVersionNo", getOriVersionNo()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSoftwareOperationLogId() != null) res.put("softwareOperationLogId", getSoftwareOperationLogId());
		if(getOperationType() != null) res.put("operationType", getOperationType());
		if(getMacAddress() != null) res.put("macAddress", getMacAddress());
		if(getIpAddress() != null) res.put("ipAddress", getIpAddress());
		if(getMachineName() != null) res.put("machineName", getMachineName());
		if(getSoftwareType() != null) res.put("softwareType", getSoftwareType());
		if(getLocalOperationTime() != null) res.put("localOperationTime", getLocalOperationTime());
		if(getLocalRequestTime() != null) res.put("localRequestTime", getLocalRequestTime());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getCurrentVersionNo() != null) res.put("currentVersionNo", getCurrentVersionNo());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getOriVersionNo() != null) res.put("oriVersionNo", getOriVersionNo());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("softwareOperationLogId")) != null) setSoftwareOperationLogId(__getInt(val)); 
		if((val = values.get("operationType")) != null) setOperationType(__getInt(val)); 
		if((val = values.get("macAddress")) != null) setMacAddress(__getString(val));
		if((val = values.get("ipAddress")) != null) setIpAddress(__getString(val));
		if((val = values.get("machineName")) != null) setMachineName(__getString(val));
		if((val = values.get("softwareType")) != null) setSoftwareType(__getInt(val)); 
		if((val = values.get("localOperationTime")) != null) setLocalOperationTime(__getDate(val)); 
		if((val = values.get("localRequestTime")) != null) setLocalRequestTime(__getDate(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("currentVersionNo")) != null) setCurrentVersionNo(__getDecimal(val));  
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("oriVersionNo")) != null) setOriVersionNo(__getDecimal(val));  
	}

	protected java.lang.Integer  __software_operation_log_id ;
	protected java.lang.Integer  __operation_type ;
	protected java.lang.String  __mac_address ;
	protected java.lang.String  __ip_address ;
	protected java.lang.String  __machine_name ;
	protected java.lang.Integer  __software_type ;
	protected java.util.Date  __local_operation_time ;
	protected java.util.Date  __local_request_time ;
	protected java.util.Date  __create_time ;
	protected java.math.BigDecimal  __current_version_no ;
	protected java.lang.Integer  __operator ;
	protected java.math.BigDecimal  __ori_version_no ;
}
