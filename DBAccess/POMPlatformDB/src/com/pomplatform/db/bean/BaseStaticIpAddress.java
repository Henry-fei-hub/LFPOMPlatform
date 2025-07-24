package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseStaticIpAddress extends GenericBase implements BaseFactory<BaseStaticIpAddress>, Comparable<BaseStaticIpAddress> 
{


	public static BaseStaticIpAddress newInstance(){
		return new BaseStaticIpAddress();
	}

	@Override
	public BaseStaticIpAddress make(){
		BaseStaticIpAddress b = new BaseStaticIpAddress();
		return b;
	}

	public final static java.lang.String CS_START_ADDRESS = "start_address" ;
	public final static java.lang.String CS_END_ADDRESS = "end_address" ;
	public final static java.lang.String CS_START_IP = "start_ip" ;
	public final static java.lang.String CS_END_IP = "end_ip" ;
	public final static java.lang.String CS_COUNTRY_ID = "country_id" ;
	public final static java.lang.String CS_PROVINCE_ID = "province_id" ;
	public final static java.lang.String CS_CITY_ID = "city_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "开始地址,结束地址,开始IP地址,结束IP地址,国家代码,省/州代码,城市代码,备注";

	public java.lang.Long getStartAddress() {
		return this.__start_address;
	}

	public void setStartAddress( java.lang.Long value ) {
		this.__start_address = value;
	}

	public java.lang.Long getEndAddress() {
		return this.__end_address;
	}

	public void setEndAddress( java.lang.Long value ) {
		this.__end_address = value;
	}

	public java.lang.String getStartIp() {
		return this.__start_ip;
	}

	public void setStartIp( java.lang.String value ) {
		this.__start_ip = value;
	}

	public java.lang.String getEndIp() {
		return this.__end_ip;
	}

	public void setEndIp( java.lang.String value ) {
		this.__end_ip = value;
	}

	public java.lang.Integer getCountryId() {
		return this.__country_id;
	}

	public void setCountryId( java.lang.Integer value ) {
		this.__country_id = value;
	}

	public java.lang.Integer getProvinceId() {
		return this.__province_id;
	}

	public void setProvinceId( java.lang.Integer value ) {
		this.__province_id = value;
	}

	public java.lang.Integer getCityId() {
		return this.__city_id;
	}

	public void setCityId( java.lang.Integer value ) {
		this.__city_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseStaticIpAddress __bean){
		__bean.setStartAddress(getStartAddress());
		__bean.setEndAddress(getEndAddress());
		__bean.setStartIp(getStartIp());
		__bean.setEndIp(getEndIp());
		__bean.setCountryId(getCountryId());
		__bean.setProvinceId(getProvinceId());
		__bean.setCityId(getCityId());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getStartAddress() == null ? "" : getStartAddress());
		sb.append(",");
		sb.append(getEndAddress() == null ? "" : getEndAddress());
		sb.append(",");
		sb.append(getStartIp() == null ? "" : getStartIp());
		sb.append(",");
		sb.append(getEndIp() == null ? "" : getEndIp());
		sb.append(",");
		sb.append(getCountryId() == null ? "" : getCountryId());
		sb.append(",");
		sb.append(getProvinceId() == null ? "" : getProvinceId());
		sb.append(",");
		sb.append(getCityId() == null ? "" : getCityId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStaticIpAddress o) {
		return __start_address == null ? -1 : __start_address.compareTo(o.getStartAddress());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__start_address);
		hash = 97 * hash + Objects.hashCode(this.__end_address);
		hash = 97 * hash + Objects.hashCode(this.__start_ip);
		hash = 97 * hash + Objects.hashCode(this.__end_ip);
		hash = 97 * hash + Objects.hashCode(this.__country_id);
		hash = 97 * hash + Objects.hashCode(this.__province_id);
		hash = 97 * hash + Objects.hashCode(this.__city_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStaticIpAddress o = (BaseStaticIpAddress)obj;
		if(!Objects.equals(this.__start_address, o.getStartAddress())) return false;
		if(!Objects.equals(this.__end_address, o.getEndAddress())) return false;
		if(!Objects.equals(this.__start_ip, o.getStartIp())) return false;
		if(!Objects.equals(this.__end_ip, o.getEndIp())) return false;
		if(!Objects.equals(this.__country_id, o.getCountryId())) return false;
		if(!Objects.equals(this.__province_id, o.getProvinceId())) return false;
		if(!Objects.equals(this.__city_id, o.getCityId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStartAddress() != null) sb.append(__wrapNumber(count++, "startAddress", getStartAddress()));
		if(getEndAddress() != null) sb.append(__wrapNumber(count++, "endAddress", getEndAddress()));
		if(getStartIp() != null) sb.append(__wrapString(count++, "startIp", getStartIp()));
		if(getEndIp() != null) sb.append(__wrapString(count++, "endIp", getEndIp()));
		if(getCountryId() != null) sb.append(__wrapNumber(count++, "countryId", getCountryId()));
		if(getProvinceId() != null) sb.append(__wrapNumber(count++, "provinceId", getProvinceId()));
		if(getCityId() != null) sb.append(__wrapNumber(count++, "cityId", getCityId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("startAddress")) != null) setStartAddress(__getLong(val)); 
		if((val = values.get("endAddress")) != null) setEndAddress(__getLong(val)); 
		if((val = values.get("startIp")) != null) setStartIp(__getString(val));
		if((val = values.get("endIp")) != null) setEndIp(__getString(val));
		if((val = values.get("countryId")) != null) setCountryId(__getInt(val)); 
		if((val = values.get("provinceId")) != null) setProvinceId(__getInt(val)); 
		if((val = values.get("cityId")) != null) setCityId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Long  __start_address ;
	protected java.lang.Long  __end_address ;
	protected java.lang.String  __start_ip ;
	protected java.lang.String  __end_ip ;
	protected java.lang.Integer  __country_id ;
	protected java.lang.Integer  __province_id ;
	protected java.lang.Integer  __city_id ;
	protected java.lang.String  __remark ;
}
