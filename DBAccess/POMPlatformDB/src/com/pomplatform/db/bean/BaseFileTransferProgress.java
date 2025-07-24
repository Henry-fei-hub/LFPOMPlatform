package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFileTransferProgress extends GenericBase implements BaseFactory<BaseFileTransferProgress>, Comparable<BaseFileTransferProgress> 
{


	public static BaseFileTransferProgress newInstance(){
		return new BaseFileTransferProgress();
	}

	@Override
	public BaseFileTransferProgress make(){
		BaseFileTransferProgress b = new BaseFileTransferProgress();
		return b;
	}

	public final static java.lang.String CS_FILE_TRANSFER_PROGRESS_ID = "file_transfer_progress_id" ;
	public final static java.lang.String CS_FILE_TRANSFER_KEY = "file_transfer_key" ;
	public final static java.lang.String CS_FULL_FILE_NAME = "full_file_name" ;
	public final static java.lang.String CS_FILE_KEY = "file_key" ;
	public final static java.lang.String CS_FILE_SIZE = "file_size" ;
	public final static java.lang.String CS_TRANSFERED_SIZE = "transfered_size" ;
	public final static java.lang.String CS_TRANSFER_PERCENT = "transfer_percent" ;
	public final static java.lang.String CS_REQUEST_USER_ID = "request_user_id" ;
	public final static java.lang.String CS_REQUEST_COMPANY_ID = "request_company_id" ;
	public final static java.lang.String CS_REQUEST_WORKPLACE_ID = "request_workplace_id" ;
	public final static java.lang.String CS_REQUEST_MAC_ADDRESS = "request_mac_address" ;
	public final static java.lang.String CS_REQUEST_IP_ADDRESS = "request_ip_address" ;
	public final static java.lang.String CS_REQUEST_MACHINE_NAME = "request_machine_name" ;
	public final static java.lang.String CS_START_TRANSFER_TIME = "start_transfer_time" ;
	public final static java.lang.String CS_END_TRANSFER_TIME = "end_transfer_time" ;
	public final static java.lang.String CS_STATUS = "status" ;

	public final static java.lang.String ALL_CAPTIONS = "文件传输编码,文件传输UU编码,传输文件的全路径名,OSS KEY,文件长度,已经传输的长度,传输百分比,请求传输的用户编码,公司编码,工作场所编码,请求传输的机器MAC地址,请求传输的IP地址,请求传输的机器名,开始传输时间,结束传输时间,传输状态 0 - 新建， 1 - 完成";

	public java.lang.Integer getFileTransferProgressId() {
		return this.__file_transfer_progress_id;
	}

	public void setFileTransferProgressId( java.lang.Integer value ) {
		this.__file_transfer_progress_id = value;
	}

	public java.lang.String getFileTransferKey() {
		return this.__file_transfer_key;
	}

	public void setFileTransferKey( java.lang.String value ) {
		this.__file_transfer_key = value;
	}

	public java.lang.String getFullFileName() {
		return this.__full_file_name;
	}

	public void setFullFileName( java.lang.String value ) {
		this.__full_file_name = value;
	}

	public java.lang.String getFileKey() {
		return this.__file_key;
	}

	public void setFileKey( java.lang.String value ) {
		this.__file_key = value;
	}

	public java.lang.Long getFileSize() {
		return this.__file_size;
	}

	public void setFileSize( java.lang.Long value ) {
		this.__file_size = value;
	}

	public java.lang.Long getTransferedSize() {
		return this.__transfered_size;
	}

	public void setTransferedSize( java.lang.Long value ) {
		this.__transfered_size = value;
	}

	public java.math.BigDecimal getTransferPercent() {
		return this.__transfer_percent;
	}

	public void setTransferPercent( java.math.BigDecimal value ) {
		this.__transfer_percent = value;
	}

	public java.lang.Integer getRequestUserId() {
		return this.__request_user_id;
	}

	public void setRequestUserId( java.lang.Integer value ) {
		this.__request_user_id = value;
	}

	public java.lang.Integer getRequestCompanyId() {
		return this.__request_company_id;
	}

	public void setRequestCompanyId( java.lang.Integer value ) {
		this.__request_company_id = value;
	}

	public java.lang.Integer getRequestWorkplaceId() {
		return this.__request_workplace_id;
	}

	public void setRequestWorkplaceId( java.lang.Integer value ) {
		this.__request_workplace_id = value;
	}

	public java.lang.String getRequestMacAddress() {
		return this.__request_mac_address;
	}

	public void setRequestMacAddress( java.lang.String value ) {
		this.__request_mac_address = value;
	}

	public java.lang.String getRequestIpAddress() {
		return this.__request_ip_address;
	}

	public void setRequestIpAddress( java.lang.String value ) {
		this.__request_ip_address = value;
	}

	public java.lang.String getRequestMachineName() {
		return this.__request_machine_name;
	}

	public void setRequestMachineName( java.lang.String value ) {
		this.__request_machine_name = value;
	}

	public java.util.Date getStartTransferTime() {
		return this.__start_transfer_time;
	}

	public void setStartTransferTime( java.util.Date value ) {
		this.__start_transfer_time = value;
	}

	public java.util.Date getEndTransferTime() {
		return this.__end_transfer_time;
	}

	public void setEndTransferTime( java.util.Date value ) {
		this.__end_transfer_time = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public void cloneCopy(BaseFileTransferProgress __bean){
		__bean.setFileTransferProgressId(getFileTransferProgressId());
		__bean.setFileTransferKey(getFileTransferKey());
		__bean.setFullFileName(getFullFileName());
		__bean.setFileKey(getFileKey());
		__bean.setFileSize(getFileSize());
		__bean.setTransferedSize(getTransferedSize());
		__bean.setTransferPercent(getTransferPercent());
		__bean.setRequestUserId(getRequestUserId());
		__bean.setRequestCompanyId(getRequestCompanyId());
		__bean.setRequestWorkplaceId(getRequestWorkplaceId());
		__bean.setRequestMacAddress(getRequestMacAddress());
		__bean.setRequestIpAddress(getRequestIpAddress());
		__bean.setRequestMachineName(getRequestMachineName());
		__bean.setStartTransferTime(getStartTransferTime());
		__bean.setEndTransferTime(getEndTransferTime());
		__bean.setStatus(getStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFileTransferProgressId() == null ? "" : getFileTransferProgressId());
		sb.append(",");
		sb.append(getFileTransferKey() == null ? "" : getFileTransferKey());
		sb.append(",");
		sb.append(getFullFileName() == null ? "" : getFullFileName());
		sb.append(",");
		sb.append(getFileKey() == null ? "" : getFileKey());
		sb.append(",");
		sb.append(getFileSize() == null ? "" : getFileSize());
		sb.append(",");
		sb.append(getTransferedSize() == null ? "" : getTransferedSize());
		sb.append(",");
		sb.append(getTransferPercent() == null ? "" : getTransferPercent());
		sb.append(",");
		sb.append(getRequestUserId() == null ? "" : getRequestUserId());
		sb.append(",");
		sb.append(getRequestCompanyId() == null ? "" : getRequestCompanyId());
		sb.append(",");
		sb.append(getRequestWorkplaceId() == null ? "" : getRequestWorkplaceId());
		sb.append(",");
		sb.append(getRequestMacAddress() == null ? "" : getRequestMacAddress());
		sb.append(",");
		sb.append(getRequestIpAddress() == null ? "" : getRequestIpAddress());
		sb.append(",");
		sb.append(getRequestMachineName() == null ? "" : getRequestMachineName());
		sb.append(",");
		sb.append(getStartTransferTime() == null ? "" : sdf.format(getStartTransferTime()));
		sb.append(",");
		sb.append(getEndTransferTime() == null ? "" : sdf.format(getEndTransferTime()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFileTransferProgress o) {
		return __file_transfer_progress_id == null ? -1 : __file_transfer_progress_id.compareTo(o.getFileTransferProgressId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__file_transfer_progress_id);
		hash = 97 * hash + Objects.hashCode(this.__file_transfer_key);
		hash = 97 * hash + Objects.hashCode(this.__full_file_name);
		hash = 97 * hash + Objects.hashCode(this.__file_key);
		hash = 97 * hash + Objects.hashCode(this.__file_size);
		hash = 97 * hash + Objects.hashCode(this.__transfered_size);
		hash = 97 * hash + Objects.hashCode(this.__transfer_percent);
		hash = 97 * hash + Objects.hashCode(this.__request_user_id);
		hash = 97 * hash + Objects.hashCode(this.__request_company_id);
		hash = 97 * hash + Objects.hashCode(this.__request_workplace_id);
		hash = 97 * hash + Objects.hashCode(this.__request_mac_address);
		hash = 97 * hash + Objects.hashCode(this.__request_ip_address);
		hash = 97 * hash + Objects.hashCode(this.__request_machine_name);
		hash = 97 * hash + Objects.hashCode(this.__start_transfer_time);
		hash = 97 * hash + Objects.hashCode(this.__end_transfer_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFileTransferProgress o = (BaseFileTransferProgress)obj;
		if(!Objects.equals(this.__file_transfer_progress_id, o.getFileTransferProgressId())) return false;
		if(!Objects.equals(this.__file_transfer_key, o.getFileTransferKey())) return false;
		if(!Objects.equals(this.__full_file_name, o.getFullFileName())) return false;
		if(!Objects.equals(this.__file_key, o.getFileKey())) return false;
		if(!Objects.equals(this.__file_size, o.getFileSize())) return false;
		if(!Objects.equals(this.__transfered_size, o.getTransferedSize())) return false;
		if(!Objects.equals(this.__transfer_percent, o.getTransferPercent())) return false;
		if(!Objects.equals(this.__request_user_id, o.getRequestUserId())) return false;
		if(!Objects.equals(this.__request_company_id, o.getRequestCompanyId())) return false;
		if(!Objects.equals(this.__request_workplace_id, o.getRequestWorkplaceId())) return false;
		if(!Objects.equals(this.__request_mac_address, o.getRequestMacAddress())) return false;
		if(!Objects.equals(this.__request_ip_address, o.getRequestIpAddress())) return false;
		if(!Objects.equals(this.__request_machine_name, o.getRequestMachineName())) return false;
		if(!Objects.equals(this.__start_transfer_time, o.getStartTransferTime())) return false;
		if(!Objects.equals(this.__end_transfer_time, o.getEndTransferTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFileTransferProgressId() != null) sb.append(__wrapNumber(count++, "fileTransferProgressId", getFileTransferProgressId()));
		if(getFileTransferKey() != null) sb.append(__wrapString(count++, "fileTransferKey", getFileTransferKey()));
		if(getFullFileName() != null) sb.append(__wrapString(count++, "fullFileName", getFullFileName()));
		if(getFileKey() != null) sb.append(__wrapString(count++, "fileKey", getFileKey()));
		if(getFileSize() != null) sb.append(__wrapNumber(count++, "fileSize", getFileSize()));
		if(getTransferedSize() != null) sb.append(__wrapNumber(count++, "transferedSize", getTransferedSize()));
		if(getTransferPercent() != null) sb.append(__wrapDecimal(count++, "transferPercent", getTransferPercent()));
		if(getRequestUserId() != null) sb.append(__wrapNumber(count++, "requestUserId", getRequestUserId()));
		if(getRequestCompanyId() != null) sb.append(__wrapNumber(count++, "requestCompanyId", getRequestCompanyId()));
		if(getRequestWorkplaceId() != null) sb.append(__wrapNumber(count++, "requestWorkplaceId", getRequestWorkplaceId()));
		if(getRequestMacAddress() != null) sb.append(__wrapString(count++, "requestMacAddress", getRequestMacAddress()));
		if(getRequestIpAddress() != null) sb.append(__wrapString(count++, "requestIpAddress", getRequestIpAddress()));
		if(getRequestMachineName() != null) sb.append(__wrapString(count++, "requestMachineName", getRequestMachineName()));
		if(getStartTransferTime() != null) sb.append(__wrapDate(count++, "startTransferTime", getStartTransferTime()));
		if(getEndTransferTime() != null) sb.append(__wrapDate(count++, "endTransferTime", getEndTransferTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fileTransferProgressId")) != null) setFileTransferProgressId(__getInt(val)); 
		if((val = values.get("fileTransferKey")) != null) setFileTransferKey(__getString(val));
		if((val = values.get("fullFileName")) != null) setFullFileName(__getString(val));
		if((val = values.get("fileKey")) != null) setFileKey(__getString(val));
		if((val = values.get("fileSize")) != null) setFileSize(__getLong(val)); 
		if((val = values.get("transferedSize")) != null) setTransferedSize(__getLong(val)); 
		if((val = values.get("transferPercent")) != null) setTransferPercent(__getDecimal(val));  
		if((val = values.get("requestUserId")) != null) setRequestUserId(__getInt(val)); 
		if((val = values.get("requestCompanyId")) != null) setRequestCompanyId(__getInt(val)); 
		if((val = values.get("requestWorkplaceId")) != null) setRequestWorkplaceId(__getInt(val)); 
		if((val = values.get("requestMacAddress")) != null) setRequestMacAddress(__getString(val));
		if((val = values.get("requestIpAddress")) != null) setRequestIpAddress(__getString(val));
		if((val = values.get("requestMachineName")) != null) setRequestMachineName(__getString(val));
		if((val = values.get("startTransferTime")) != null) setStartTransferTime(__getDate(val)); 
		if((val = values.get("endTransferTime")) != null) setEndTransferTime(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __file_transfer_progress_id ;
	protected java.lang.String  __file_transfer_key ;
	protected java.lang.String  __full_file_name ;
	protected java.lang.String  __file_key ;
	protected java.lang.Long  __file_size ;
	protected java.lang.Long  __transfered_size ;
	protected java.math.BigDecimal  __transfer_percent ;
	protected java.lang.Integer  __request_user_id ;
	protected java.lang.Integer  __request_company_id ;
	protected java.lang.Integer  __request_workplace_id ;
	protected java.lang.String  __request_mac_address ;
	protected java.lang.String  __request_ip_address ;
	protected java.lang.String  __request_machine_name ;
	protected java.util.Date  __start_transfer_time ;
	protected java.util.Date  __end_transfer_time ;
	protected java.lang.Integer  __status ;
}
