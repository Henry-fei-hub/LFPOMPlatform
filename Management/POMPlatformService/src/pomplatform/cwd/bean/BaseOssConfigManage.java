package pomplatform.cwd.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOssConfigManage extends GenericBase implements BaseFactory<BaseOssConfigManage>, Comparable<BaseOssConfigManage> 
{


	public static BaseOssConfigManage newInstance(){
		return new BaseOssConfigManage();
	}

	@Override
	public BaseOssConfigManage make(){
		BaseOssConfigManage b = new BaseOssConfigManage();
		return b;
	}

	public final static java.lang.String CS_OSS_CONFIG_ID = "oss_config_id" ;
	public final static java.lang.String CS_OSS_ADDRESS = "oss_address" ;
	public final static java.lang.String CS_OSS_BUCKET = "oss_bucket" ;
	public final static java.lang.String CS_OSS_ACCESS_KEY_ID = "oss_access_key_id" ;
	public final static java.lang.String CS_OSS_ACCESS_KEY_SECRET = "oss_access_key_secret" ;

	public final static java.lang.String ALL_CAPTIONS = "oss_config_id,oss地址,oss存储空间,oss_access_key_id,oss_access_key_secret";

	public java.lang.Integer getOssConfigId() {
		return this.__oss_config_id;
	}

	public void setOssConfigId( java.lang.Integer value ) {
		this.__oss_config_id = value;
	}

	public java.lang.String getOssAddress() {
		return this.__oss_address;
	}

	public void setOssAddress( java.lang.String value ) {
		this.__oss_address = value;
	}

	public java.lang.String getOssBucket() {
		return this.__oss_bucket;
	}

	public void setOssBucket( java.lang.String value ) {
		this.__oss_bucket = value;
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

	public void cloneCopy(BaseOssConfigManage __bean){
		__bean.setOssConfigId(getOssConfigId());
		__bean.setOssAddress(getOssAddress());
		__bean.setOssBucket(getOssBucket());
		__bean.setOssAccessKeyId(getOssAccessKeyId());
		__bean.setOssAccessKeySecret(getOssAccessKeySecret());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOssConfigId() == null ? "" : getOssConfigId());
		sb.append(",");
		sb.append(getOssAddress() == null ? "" : getOssAddress());
		sb.append(",");
		sb.append(getOssBucket() == null ? "" : getOssBucket());
		sb.append(",");
		sb.append(getOssAccessKeyId() == null ? "" : getOssAccessKeyId());
		sb.append(",");
		sb.append(getOssAccessKeySecret() == null ? "" : getOssAccessKeySecret());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOssConfigManage o) {
		return __oss_config_id == null ? -1 : __oss_config_id.compareTo(o.getOssConfigId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__oss_config_id);
		hash = 97 * hash + Objects.hashCode(this.__oss_address);
		hash = 97 * hash + Objects.hashCode(this.__oss_bucket);
		hash = 97 * hash + Objects.hashCode(this.__oss_access_key_id);
		hash = 97 * hash + Objects.hashCode(this.__oss_access_key_secret);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOssConfigManage o = (BaseOssConfigManage)obj;
		if(!Objects.equals(this.__oss_config_id, o.getOssConfigId())) return false;
		if(!Objects.equals(this.__oss_address, o.getOssAddress())) return false;
		if(!Objects.equals(this.__oss_bucket, o.getOssBucket())) return false;
		if(!Objects.equals(this.__oss_access_key_id, o.getOssAccessKeyId())) return false;
		if(!Objects.equals(this.__oss_access_key_secret, o.getOssAccessKeySecret())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOssConfigId() != null) sb.append(__wrapNumber(count++, "ossConfigId", getOssConfigId()));
		if(getOssAddress() != null) sb.append(__wrapString(count++, "ossAddress", getOssAddress()));
		if(getOssBucket() != null) sb.append(__wrapString(count++, "ossBucket", getOssBucket()));
		if(getOssAccessKeyId() != null) sb.append(__wrapString(count++, "ossAccessKeyId", getOssAccessKeyId()));
		if(getOssAccessKeySecret() != null) sb.append(__wrapString(count++, "ossAccessKeySecret", getOssAccessKeySecret()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("ossConfigId")) != null) setOssConfigId(__getInt(val)); 
		if((val = values.get("ossAddress")) != null) setOssAddress(__getString(val));
		if((val = values.get("ossBucket")) != null) setOssBucket(__getString(val));
		if((val = values.get("ossAccessKeyId")) != null) setOssAccessKeyId(__getString(val));
		if((val = values.get("ossAccessKeySecret")) != null) setOssAccessKeySecret(__getString(val));
	}

	protected java.lang.Integer  __oss_config_id ;
	protected java.lang.String  __oss_address ;
	protected java.lang.String  __oss_bucket ;
	protected java.lang.String  __oss_access_key_id ;
	protected java.lang.String  __oss_access_key_secret ;
}
