package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompanyWorkplacePublicIp extends GenericBase implements BaseFactory<BaseCompanyWorkplacePublicIp>, Comparable<BaseCompanyWorkplacePublicIp> 
{


	public static BaseCompanyWorkplacePublicIp newInstance(){
		return new BaseCompanyWorkplacePublicIp();
	}

	@Override
	public BaseCompanyWorkplacePublicIp make(){
		BaseCompanyWorkplacePublicIp b = new BaseCompanyWorkplacePublicIp();
		return b;
	}

	public final static java.lang.String CS_COMPANY_WORKPLACE_PUBLIC_IP_ID = "company_workplace_public_ip_id" ;
	public final static java.lang.String CS_COMPANY_WORKPLACE_ID = "company_workplace_id" ;
	public final static java.lang.String CS_IP_ADDRESS = "ip_address" ;
	public final static java.lang.String CS_ACTIVE = "active" ;

	public final static java.lang.String ALL_CAPTIONS = "工作场所编码,工作场所编码,公网IP地址,是否有效";

	public java.lang.Integer getCompanyWorkplacePublicIpId() {
		return this.__company_workplace_public_ip_id;
	}

	public void setCompanyWorkplacePublicIpId( java.lang.Integer value ) {
		this.__company_workplace_public_ip_id = value;
	}

	public java.lang.Integer getCompanyWorkplaceId() {
		return this.__company_workplace_id;
	}

	public void setCompanyWorkplaceId( java.lang.Integer value ) {
		this.__company_workplace_id = value;
	}

	public java.lang.String getIpAddress() {
		return this.__ip_address;
	}

	public void setIpAddress( java.lang.String value ) {
		this.__ip_address = value;
	}

	public java.lang.Boolean getActive() {
		return this.__active;
	}

	public void setActive( java.lang.Boolean value ) {
		this.__active = value;
	}

	public void cloneCopy(BaseCompanyWorkplacePublicIp __bean){
		__bean.setCompanyWorkplacePublicIpId(getCompanyWorkplacePublicIpId());
		__bean.setCompanyWorkplaceId(getCompanyWorkplaceId());
		__bean.setIpAddress(getIpAddress());
		__bean.setActive(getActive());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyWorkplacePublicIpId() == null ? "" : getCompanyWorkplacePublicIpId());
		sb.append(",");
		sb.append(getCompanyWorkplaceId() == null ? "" : getCompanyWorkplaceId());
		sb.append(",");
		sb.append(getIpAddress() == null ? "" : getIpAddress());
		sb.append(",");
		sb.append(getActive() == null ? "" : getActive());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyWorkplacePublicIp o) {
		return __company_workplace_public_ip_id == null ? -1 : __company_workplace_public_ip_id.compareTo(o.getCompanyWorkplacePublicIpId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_workplace_public_ip_id);
		hash = 97 * hash + Objects.hashCode(this.__company_workplace_id);
		hash = 97 * hash + Objects.hashCode(this.__ip_address);
		hash = 97 * hash + Objects.hashCode(this.__active);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyWorkplacePublicIp o = (BaseCompanyWorkplacePublicIp)obj;
		if(!Objects.equals(this.__company_workplace_public_ip_id, o.getCompanyWorkplacePublicIpId())) return false;
		if(!Objects.equals(this.__company_workplace_id, o.getCompanyWorkplaceId())) return false;
		if(!Objects.equals(this.__ip_address, o.getIpAddress())) return false;
		if(!Objects.equals(this.__active, o.getActive())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyWorkplacePublicIpId() != null) sb.append(__wrapNumber(count++, "companyWorkplacePublicIpId", getCompanyWorkplacePublicIpId()));
		if(getCompanyWorkplaceId() != null) sb.append(__wrapNumber(count++, "companyWorkplaceId", getCompanyWorkplaceId()));
		if(getIpAddress() != null) sb.append(__wrapString(count++, "ipAddress", getIpAddress()));
		if(getActive() != null) sb.append(__wrapBoolean(count++, "active", getActive()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyWorkplacePublicIpId")) != null) setCompanyWorkplacePublicIpId(__getInt(val)); 
		if((val = values.get("companyWorkplaceId")) != null) setCompanyWorkplaceId(__getInt(val)); 
		if((val = values.get("ipAddress")) != null) setIpAddress(__getString(val));
		if((val = values.get("active")) != null) setActive(__getBoolean(val));
	}

	protected java.lang.Integer  __company_workplace_public_ip_id ;
	protected java.lang.Integer  __company_workplace_id ;
	protected java.lang.String  __ip_address ;
	protected java.lang.Boolean  __active ;
}
