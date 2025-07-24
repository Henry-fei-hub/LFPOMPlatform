package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnLabel extends GenericBase implements BaseFactory<BaseCnLabel>, Comparable<BaseCnLabel> 
{


	public static BaseCnLabel newInstance(){
		return new BaseCnLabel();
	}

	@Override
	public BaseCnLabel make(){
		BaseCnLabel b = new BaseCnLabel();
		return b;
	}

	public final static java.lang.String CS_LABEL_ID = "label_id" ;
	public final static java.lang.String CS_LABEL_NAME = "label_name" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = ",标签名称,组织机构代码";

	public java.lang.Integer getLabelId() {
		return this.__label_id;
	}

	public void setLabelId( java.lang.Integer value ) {
		this.__label_id = value;
	}

	public java.lang.String getLabelName() {
		return this.__label_name;
	}

	public void setLabelName( java.lang.String value ) {
		this.__label_name = value;
	}

	public java.lang.Integer getOrganizationId() {
		return this.__organization_id;
	}

	public void setOrganizationId( java.lang.Integer value ) {
		this.__organization_id = value;
	}

	public void cloneCopy(BaseCnLabel __bean){
		__bean.setLabelId(getLabelId());
		__bean.setLabelName(getLabelName());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLabelId() == null ? "" : getLabelId());
		sb.append(",");
		sb.append(getLabelName() == null ? "" : getLabelName());
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnLabel o) {
		return __label_id == null ? -1 : __label_id.compareTo(o.getLabelId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__label_id);
		hash = 97 * hash + Objects.hashCode(this.__label_name);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnLabel o = (BaseCnLabel)obj;
		if(!Objects.equals(this.__label_id, o.getLabelId())) return false;
		if(!Objects.equals(this.__label_name, o.getLabelName())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLabelId() != null) sb.append(__wrapNumber(count++, "labelId", getLabelId()));
		if(getLabelName() != null) sb.append(__wrapString(count++, "labelName", getLabelName()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getLabelId() != null) res.put("labelId", getLabelId());
		if(getLabelName() != null) res.put("labelName", getLabelName());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("labelId")) != null) setLabelId(__getInt(val)); 
		if((val = values.get("labelName")) != null) setLabelName(__getString(val));
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __label_id ;
	protected java.lang.String  __label_name ;
	protected java.lang.Integer  __organization_id ;
}
