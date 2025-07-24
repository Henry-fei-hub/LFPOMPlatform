package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnLabelDetailed extends GenericBase implements BaseFactory<BaseCnLabelDetailed>, Comparable<BaseCnLabelDetailed> 
{


	public static BaseCnLabelDetailed newInstance(){
		return new BaseCnLabelDetailed();
	}

	@Override
	public BaseCnLabelDetailed make(){
		BaseCnLabelDetailed b = new BaseCnLabelDetailed();
		return b;
	}

	public final static java.lang.String CS_LABEL_DETAILED_ID = "label_detailed_id" ;
	public final static java.lang.String CS_USER_ID = "user_id" ;
	public final static java.lang.String CS_LABEL_ID = "label_id" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = ",,,";

	public java.lang.Integer getLabelDetailedId() {
		return this.__label_detailed_id;
	}

	public void setLabelDetailedId( java.lang.Integer value ) {
		this.__label_detailed_id = value;
	}

	public java.lang.Integer getUserId() {
		return this.__user_id;
	}

	public void setUserId( java.lang.Integer value ) {
		this.__user_id = value;
	}

	public java.lang.Integer getLabelId() {
		return this.__label_id;
	}

	public void setLabelId( java.lang.Integer value ) {
		this.__label_id = value;
	}

	public java.lang.Integer getOrganizationId() {
		return this.__organization_id;
	}

	public void setOrganizationId( java.lang.Integer value ) {
		this.__organization_id = value;
	}

	public void cloneCopy(BaseCnLabelDetailed __bean){
		__bean.setLabelDetailedId(getLabelDetailedId());
		__bean.setUserId(getUserId());
		__bean.setLabelId(getLabelId());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getLabelDetailedId() == null ? "" : getLabelDetailedId());
		sb.append(",");
		sb.append(getUserId() == null ? "" : getUserId());
		sb.append(",");
		sb.append(getLabelId() == null ? "" : getLabelId());
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnLabelDetailed o) {
		return __label_detailed_id == null ? -1 : __label_detailed_id.compareTo(o.getLabelDetailedId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__label_detailed_id);
		hash = 97 * hash + Objects.hashCode(this.__user_id);
		hash = 97 * hash + Objects.hashCode(this.__label_id);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnLabelDetailed o = (BaseCnLabelDetailed)obj;
		if(!Objects.equals(this.__label_detailed_id, o.getLabelDetailedId())) return false;
		if(!Objects.equals(this.__user_id, o.getUserId())) return false;
		if(!Objects.equals(this.__label_id, o.getLabelId())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getLabelDetailedId() != null) sb.append(__wrapNumber(count++, "labelDetailedId", getLabelDetailedId()));
		if(getUserId() != null) sb.append(__wrapNumber(count++, "userId", getUserId()));
		if(getLabelId() != null) sb.append(__wrapNumber(count++, "labelId", getLabelId()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getLabelDetailedId() != null) res.put("labelDetailedId", getLabelDetailedId());
		if(getUserId() != null) res.put("userId", getUserId());
		if(getLabelId() != null) res.put("labelId", getLabelId());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("labelDetailedId")) != null) setLabelDetailedId(__getInt(val)); 
		if((val = values.get("userId")) != null) setUserId(__getInt(val)); 
		if((val = values.get("labelId")) != null) setLabelId(__getInt(val)); 
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __label_detailed_id ;
	protected java.lang.Integer  __user_id ;
	protected java.lang.Integer  __label_id ;
	protected java.lang.Integer  __organization_id ;
}
