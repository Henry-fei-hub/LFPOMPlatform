package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompanyRecord extends GenericBase implements BaseFactory<BaseCompanyRecord>, Comparable<BaseCompanyRecord> 
{


	public static BaseCompanyRecord newInstance(){
		return new BaseCompanyRecord();
	}

	@Override
	public BaseCompanyRecord make(){
		BaseCompanyRecord b = new BaseCompanyRecord();
		return b;
	}

	public final static java.lang.String CS_COMPANY_RECORD_ID = "company_record_id" ;
	public final static java.lang.String CS_COMPANY_NAME = "company_name" ;
	public final static java.lang.String CS_COMPANY_CODE = "company_code" ;
	public final static java.lang.String CS_IS_ENABLED = "is_enabled" ;
	public final static java.lang.String CS_COMPANY_NO = "company_no" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_COMPANY_NAME_SIMPLE = "company_name_simple" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,公司名称,公司代码,是否启用,公司编号,父级编码,公司简称";

	public java.lang.Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( java.lang.Integer value ) {
		this.__company_record_id = value;
	}

	public java.lang.String getCompanyName() {
		return this.__company_name;
	}

	public void setCompanyName( java.lang.String value ) {
		this.__company_name = value;
	}

	public java.lang.String getCompanyCode() {
		return this.__company_code;
	}

	public void setCompanyCode( java.lang.String value ) {
		this.__company_code = value;
	}

	public java.lang.Boolean getIsEnabled() {
		return this.__is_enabled;
	}

	public void setIsEnabled( java.lang.Boolean value ) {
		this.__is_enabled = value;
	}

	public java.lang.String getCompanyNo() {
		return this.__company_no;
	}

	public void setCompanyNo( java.lang.String value ) {
		this.__company_no = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getCompanyNameSimple() {
		return this.__company_name_simple;
	}

	public void setCompanyNameSimple( java.lang.String value ) {
		this.__company_name_simple = value;
	}

	public void cloneCopy(BaseCompanyRecord __bean){
		__bean.setCompanyRecordId(getCompanyRecordId());
		__bean.setCompanyName(getCompanyName());
		__bean.setCompanyCode(getCompanyCode());
		__bean.setIsEnabled(getIsEnabled());
		__bean.setCompanyNo(getCompanyNo());
		__bean.setParentId(getParentId());
		__bean.setCompanyNameSimple(getCompanyNameSimple());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyRecordId() == null ? "" : getCompanyRecordId());
		sb.append(",");
		sb.append(getCompanyName() == null ? "" : getCompanyName());
		sb.append(",");
		sb.append(getCompanyCode() == null ? "" : getCompanyCode());
		sb.append(",");
		sb.append(getIsEnabled() == null ? "" : getIsEnabled());
		sb.append(",");
		sb.append(getCompanyNo() == null ? "" : getCompanyNo());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getCompanyNameSimple() == null ? "" : getCompanyNameSimple());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyRecord o) {
		return __company_record_id == null ? -1 : __company_record_id.compareTo(o.getCompanyRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_record_id);
		hash = 97 * hash + Objects.hashCode(this.__company_name);
		hash = 97 * hash + Objects.hashCode(this.__company_code);
		hash = 97 * hash + Objects.hashCode(this.__is_enabled);
		hash = 97 * hash + Objects.hashCode(this.__company_no);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__company_name_simple);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyRecord o = (BaseCompanyRecord)obj;
		if(!Objects.equals(this.__company_record_id, o.getCompanyRecordId())) return false;
		if(!Objects.equals(this.__company_name, o.getCompanyName())) return false;
		if(!Objects.equals(this.__company_code, o.getCompanyCode())) return false;
		if(!Objects.equals(this.__is_enabled, o.getIsEnabled())) return false;
		if(!Objects.equals(this.__company_no, o.getCompanyNo())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__company_name_simple, o.getCompanyNameSimple())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(count++, "companyRecordId", getCompanyRecordId()));
		if(getCompanyName() != null) sb.append(__wrapString(count++, "companyName", getCompanyName()));
		if(getCompanyCode() != null) sb.append(__wrapString(count++, "companyCode", getCompanyCode()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(count++, "isEnabled", getIsEnabled()));
		if(getCompanyNo() != null) sb.append(__wrapString(count++, "companyNo", getCompanyNo()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getCompanyNameSimple() != null) sb.append(__wrapString(count++, "companyNameSimple", getCompanyNameSimple()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyRecordId")) != null) setCompanyRecordId(__getInt(val)); 
		if((val = values.get("companyName")) != null) setCompanyName(__getString(val));
		if((val = values.get("companyCode")) != null) setCompanyCode(__getString(val));
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("companyNameSimple")) != null) setCompanyNameSimple(__getString(val));
	}

	protected java.lang.Integer  __company_record_id ;
	protected java.lang.String  __company_name ;
	protected java.lang.String  __company_code ;
	protected java.lang.Boolean  __is_enabled ;
	protected java.lang.String  __company_no ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __company_name_simple ;
}
