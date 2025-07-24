package pomplatform.cwd.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOssConfigManage extends GenericCondition{

	public ConditionOssConfigManage(){
		setParameterCount(4);
	}

	public java.lang.String getOssAddress() {
		return this.__oss_address == null ? null : (this.__oss_address.indexOf("%") >= 0 ? this.__oss_address : "%"+this.__oss_address+"%");
	}

	public void setOssAddress( java.lang.String value ) {
		this.__oss_address = value;
	}

	public java.lang.String getOssBucket() {
		return this.__oss_bucket == null ? null : (this.__oss_bucket.indexOf("%") >= 0 ? this.__oss_bucket : "%"+this.__oss_bucket+"%");
	}

	public void setOssBucket( java.lang.String value ) {
		this.__oss_bucket = value;
	}

	public java.lang.String getOssAccessKeyId() {
		return this.__oss_access_key_id == null ? null : (this.__oss_access_key_id.indexOf("%") >= 0 ? this.__oss_access_key_id : "%"+this.__oss_access_key_id+"%");
	}

	public void setOssAccessKeyId( java.lang.String value ) {
		this.__oss_access_key_id = value;
	}

	public java.lang.String getOssAccessKeySecret() {
		return this.__oss_access_key_secret == null ? null : (this.__oss_access_key_secret.indexOf("%") >= 0 ? this.__oss_access_key_secret : "%"+this.__oss_access_key_secret+"%");
	}

	public void setOssAccessKeySecret( java.lang.String value ) {
		this.__oss_access_key_secret = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getOssAddress() != null) sb.append(__wrapString(1, "ossAddress", getOssAddress()));
		if(getOssBucket() != null) sb.append(__wrapString(1, "ossBucket", getOssBucket()));
		if(getOssAccessKeyId() != null) sb.append(__wrapString(1, "ossAccessKeyId", getOssAccessKeyId()));
		if(getOssAccessKeySecret() != null) sb.append(__wrapString(1, "ossAccessKeySecret", getOssAccessKeySecret()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("ossAddress")) != null) setOssAddress(__getString(val));
		if((val = values.get("ossBucket")) != null) setOssBucket(__getString(val));
		if((val = values.get("ossAccessKeyId")) != null) setOssAccessKeyId(__getString(val));
		if((val = values.get("ossAccessKeySecret")) != null) setOssAccessKeySecret(__getString(val));
	}

	private java.lang.String __oss_address = null;
	private java.lang.String __oss_bucket = null;
	private java.lang.String __oss_access_key_id = null;
	private java.lang.String __oss_access_key_secret = null;
}

