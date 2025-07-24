package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompany extends GenericBase implements BaseFactory<BaseCompany>, Comparable<BaseCompany> 
{


	public static BaseCompany newInstance(){
		return new BaseCompany();
	}

	@Override
	public BaseCompany make(){
		BaseCompany b = new BaseCompany();
		return b;
	}

	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_COMPANY_NAME = "company_name" ;
	public final static java.lang.String CS_COMPANY_ADDRESS = "company_address" ;

	public final static java.lang.String ALL_CAPTIONS = "公司编码,公司名称,地址";

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getCompanyName() {
		return this.__company_name;
	}

	public void setCompanyName( java.lang.String value ) {
		this.__company_name = value;
	}

	public java.lang.String getCompanyAddress() {
		return this.__company_address;
	}

	public void setCompanyAddress( java.lang.String value ) {
		this.__company_address = value;
	}

	public void cloneCopy(BaseCompany __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setCompanyName(getCompanyName());
		__bean.setCompanyAddress(getCompanyAddress());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("companies", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getCompanyName() == null ? "" : getCompanyName());
		sb.append(",");
		sb.append(getCompanyAddress() == null ? "" : getCompanyAddress());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompany o) {
		return __company_id == null ? -1 : __company_id.compareTo(o.getCompanyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__company_name);
		hash = 97 * hash + Objects.hashCode(this.__company_address);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompany o = (BaseCompany)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__company_name, o.getCompanyName())) return false;
		if(!Objects.equals(this.__company_address, o.getCompanyAddress())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCompanyName() != null) sb.append(__wrapString(count++, "companyName", getCompanyName()));
		if(getCompanyAddress() != null) sb.append(__wrapString(count++, "companyAddress", getCompanyAddress()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("companyName")) != null) setCompanyName(__getString(val));
		if((val = values.get("companyAddress")) != null) setCompanyAddress(__getString(val));
	}

	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __company_name ;
	protected java.lang.String  __company_address ;
}
