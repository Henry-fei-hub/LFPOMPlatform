package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnProfessionalType extends GenericBase implements BaseFactory<BaseCnProfessionalType>, Comparable<BaseCnProfessionalType> 
{


	public static BaseCnProfessionalType newInstance(){
		return new BaseCnProfessionalType();
	}

	@Override
	public BaseCnProfessionalType make(){
		BaseCnProfessionalType b = new BaseCnProfessionalType();
		return b;
	}

	public final static java.lang.String CS_PROFESSIONAL_TYPE_ID = "professional_type_id" ;
	public final static java.lang.String CS_PROFESSIONAL_TYPE_NAME = "professional_type_name" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = "专业id,专业名称,组织机构代码";

	public java.lang.Integer getProfessionalTypeId() {
		return this.__professional_type_id;
	}

	public void setProfessionalTypeId( java.lang.Integer value ) {
		this.__professional_type_id = value;
	}

	public java.lang.String getProfessionalTypeName() {
		return this.__professional_type_name;
	}

	public void setProfessionalTypeName( java.lang.String value ) {
		this.__professional_type_name = value;
	}

	public java.lang.Integer getOrganizationId() {
		return this.__organization_id;
	}

	public void setOrganizationId( java.lang.Integer value ) {
		this.__organization_id = value;
	}

	public void cloneCopy(BaseCnProfessionalType __bean){
		__bean.setProfessionalTypeId(getProfessionalTypeId());
		__bean.setProfessionalTypeName(getProfessionalTypeName());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProfessionalTypeId() == null ? "" : getProfessionalTypeId());
		sb.append(",");
		sb.append(getProfessionalTypeName() == null ? "" : getProfessionalTypeName());
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnProfessionalType o) {
		return __professional_type_id == null ? -1 : __professional_type_id.compareTo(o.getProfessionalTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__professional_type_id);
		hash = 97 * hash + Objects.hashCode(this.__professional_type_name);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnProfessionalType o = (BaseCnProfessionalType)obj;
		if(!Objects.equals(this.__professional_type_id, o.getProfessionalTypeId())) return false;
		if(!Objects.equals(this.__professional_type_name, o.getProfessionalTypeName())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProfessionalTypeId() != null) sb.append(__wrapNumber(count++, "professionalTypeId", getProfessionalTypeId()));
		if(getProfessionalTypeName() != null) sb.append(__wrapString(count++, "professionalTypeName", getProfessionalTypeName()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProfessionalTypeId() != null) res.put("professionalTypeId", getProfessionalTypeId());
		if(getProfessionalTypeName() != null) res.put("professionalTypeName", getProfessionalTypeName());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("professionalTypeId")) != null) setProfessionalTypeId(__getInt(val)); 
		if((val = values.get("professionalTypeName")) != null) setProfessionalTypeName(__getString(val));
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __professional_type_id ;
	protected java.lang.String  __professional_type_name ;
	protected java.lang.Integer  __organization_id ;
}
