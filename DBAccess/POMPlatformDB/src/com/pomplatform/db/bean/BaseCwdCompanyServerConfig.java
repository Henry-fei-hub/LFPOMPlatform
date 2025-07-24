package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdCompanyServerConfig extends GenericBase implements BaseFactory<BaseCwdCompanyServerConfig>, Comparable<BaseCwdCompanyServerConfig> 
{


	public static BaseCwdCompanyServerConfig newInstance(){
		return new BaseCwdCompanyServerConfig();
	}

	@Override
	public BaseCwdCompanyServerConfig make(){
		BaseCwdCompanyServerConfig b = new BaseCwdCompanyServerConfig();
		return b;
	}

	public final static java.lang.String CS_COMPANY_SERVER_CONFIG_ID = "company_server_config_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_COMPANY_NO = "company_no" ;
	public final static java.lang.String CS_CWD_SERVER_URL = "cwd_server_url" ;
	public final static java.lang.String CS_DATA_SERVER_URL = "data_server_url" ;
	public final static java.lang.String CS_OSS_URL = "oss_url" ;
	public final static java.lang.String CS_OSS_BUCKET = "oss_bucket" ;
	public final static java.lang.String CS_STS_URL = "sts_url" ;
	public final static java.lang.String CS_OSS_ACCESS_KEY_ID = "oss_access_key_id" ;
	public final static java.lang.String CS_OSS_ACCESS_KEY_SECRET = "oss_access_key_secret" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,公司,公司编号,协同设计服务器地址,中间数据服务器地址,阿里云存储地址,阿里云存储空间,阿里云安全令牌生成地址,OSS accessKeyId,OSS accessKeySecret,删除标志";

	public java.lang.Integer getCompanyServerConfigId() {
		return this.__company_server_config_id;
	}

	public void setCompanyServerConfigId( java.lang.Integer value ) {
		this.__company_server_config_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getCompanyNo() {
		return this.__company_no;
	}

	public void setCompanyNo( java.lang.String value ) {
		this.__company_no = value;
	}

	public java.lang.String getCwdServerUrl() {
		return this.__cwd_server_url;
	}

	public void setCwdServerUrl( java.lang.String value ) {
		this.__cwd_server_url = value;
	}

	public java.lang.String getDataServerUrl() {
		return this.__data_server_url;
	}

	public void setDataServerUrl( java.lang.String value ) {
		this.__data_server_url = value;
	}

	public java.lang.String getOssUrl() {
		return this.__oss_url;
	}

	public void setOssUrl( java.lang.String value ) {
		this.__oss_url = value;
	}

	public java.lang.String getOssBucket() {
		return this.__oss_bucket;
	}

	public void setOssBucket( java.lang.String value ) {
		this.__oss_bucket = value;
	}

	public java.lang.String getStsUrl() {
		return this.__sts_url;
	}

	public void setStsUrl( java.lang.String value ) {
		this.__sts_url = value;
	}

	public java.lang.String getOssAccessKeyId() {
		return this.__oss_access_key_id;
	}

	public void setOssAccessKeyId( java.lang.String value ) {
		this.__oss_access_key_id = value;
	}

	public java.lang.String getOssAccessKeySecret() {
		return this.__oss_access_key_secret;
	}

	public void setOssAccessKeySecret( java.lang.String value ) {
		this.__oss_access_key_secret = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public void cloneCopy(BaseCwdCompanyServerConfig __bean){
		__bean.setCompanyServerConfigId(getCompanyServerConfigId());
		__bean.setCompanyId(getCompanyId());
		__bean.setCompanyNo(getCompanyNo());
		__bean.setCwdServerUrl(getCwdServerUrl());
		__bean.setDataServerUrl(getDataServerUrl());
		__bean.setOssUrl(getOssUrl());
		__bean.setOssBucket(getOssBucket());
		__bean.setStsUrl(getStsUrl());
		__bean.setOssAccessKeyId(getOssAccessKeyId());
		__bean.setOssAccessKeySecret(getOssAccessKeySecret());
		__bean.setDeleteFlag(getDeleteFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyServerConfigId() == null ? "" : getCompanyServerConfigId());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getCompanyNo() == null ? "" : getCompanyNo());
		sb.append(",");
		sb.append(getCwdServerUrl() == null ? "" : getCwdServerUrl());
		sb.append(",");
		sb.append(getDataServerUrl() == null ? "" : getDataServerUrl());
		sb.append(",");
		sb.append(getOssUrl() == null ? "" : getOssUrl());
		sb.append(",");
		sb.append(getOssBucket() == null ? "" : getOssBucket());
		sb.append(",");
		sb.append(getStsUrl() == null ? "" : getStsUrl());
		sb.append(",");
		sb.append(getOssAccessKeyId() == null ? "" : getOssAccessKeyId());
		sb.append(",");
		sb.append(getOssAccessKeySecret() == null ? "" : getOssAccessKeySecret());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdCompanyServerConfig o) {
		return __company_server_config_id == null ? -1 : __company_server_config_id.compareTo(o.getCompanyServerConfigId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_server_config_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__company_no);
		hash = 97 * hash + Objects.hashCode(this.__cwd_server_url);
		hash = 97 * hash + Objects.hashCode(this.__data_server_url);
		hash = 97 * hash + Objects.hashCode(this.__oss_url);
		hash = 97 * hash + Objects.hashCode(this.__oss_bucket);
		hash = 97 * hash + Objects.hashCode(this.__sts_url);
		hash = 97 * hash + Objects.hashCode(this.__oss_access_key_id);
		hash = 97 * hash + Objects.hashCode(this.__oss_access_key_secret);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdCompanyServerConfig o = (BaseCwdCompanyServerConfig)obj;
		if(!Objects.equals(this.__company_server_config_id, o.getCompanyServerConfigId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__company_no, o.getCompanyNo())) return false;
		if(!Objects.equals(this.__cwd_server_url, o.getCwdServerUrl())) return false;
		if(!Objects.equals(this.__data_server_url, o.getDataServerUrl())) return false;
		if(!Objects.equals(this.__oss_url, o.getOssUrl())) return false;
		if(!Objects.equals(this.__oss_bucket, o.getOssBucket())) return false;
		if(!Objects.equals(this.__sts_url, o.getStsUrl())) return false;
		if(!Objects.equals(this.__oss_access_key_id, o.getOssAccessKeyId())) return false;
		if(!Objects.equals(this.__oss_access_key_secret, o.getOssAccessKeySecret())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyServerConfigId() != null) sb.append(__wrapNumber(count++, "companyServerConfigId", getCompanyServerConfigId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCompanyNo() != null) sb.append(__wrapString(count++, "companyNo", getCompanyNo()));
		if(getCwdServerUrl() != null) sb.append(__wrapString(count++, "cwdServerUrl", getCwdServerUrl()));
		if(getDataServerUrl() != null) sb.append(__wrapString(count++, "dataServerUrl", getDataServerUrl()));
		if(getOssUrl() != null) sb.append(__wrapString(count++, "ossUrl", getOssUrl()));
		if(getOssBucket() != null) sb.append(__wrapString(count++, "ossBucket", getOssBucket()));
		if(getStsUrl() != null) sb.append(__wrapString(count++, "stsUrl", getStsUrl()));
		if(getOssAccessKeyId() != null) sb.append(__wrapString(count++, "ossAccessKeyId", getOssAccessKeyId()));
		if(getOssAccessKeySecret() != null) sb.append(__wrapString(count++, "ossAccessKeySecret", getOssAccessKeySecret()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyServerConfigId")) != null) setCompanyServerConfigId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("cwdServerUrl")) != null) setCwdServerUrl(__getString(val));
		if((val = values.get("dataServerUrl")) != null) setDataServerUrl(__getString(val));
		if((val = values.get("ossUrl")) != null) setOssUrl(__getString(val));
		if((val = values.get("ossBucket")) != null) setOssBucket(__getString(val));
		if((val = values.get("stsUrl")) != null) setStsUrl(__getString(val));
		if((val = values.get("ossAccessKeyId")) != null) setOssAccessKeyId(__getString(val));
		if((val = values.get("ossAccessKeySecret")) != null) setOssAccessKeySecret(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __company_server_config_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __company_no ;
	protected java.lang.String  __cwd_server_url ;
	protected java.lang.String  __data_server_url ;
	protected java.lang.String  __oss_url ;
	protected java.lang.String  __oss_bucket ;
	protected java.lang.String  __sts_url ;
	protected java.lang.String  __oss_access_key_id ;
	protected java.lang.String  __oss_access_key_secret ;
	protected java.lang.Integer  __delete_flag ;
}
