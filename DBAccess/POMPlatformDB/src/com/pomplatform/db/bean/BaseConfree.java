package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseConfree extends GenericBase implements BaseFactory<BaseConfree>, Comparable<BaseConfree> 
{


	public static BaseConfree newInstance(){
		return new BaseConfree();
	}

	@Override
	public BaseConfree make(){
		BaseConfree b = new BaseConfree();
		return b;
	}

	public final static java.lang.String CS_CONFEREE_ID = "conferee_id" ;
	public final static java.lang.String CS_MEETING_RELEVANCE_ID = "meeting_relevance_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,主键关联,与会成员编码";

	public java.lang.Integer getConfereeId() {
		return this.__conferee_id;
	}

	public void setConfereeId( java.lang.Integer value ) {
		this.__conferee_id = value;
	}

	public java.lang.Integer getMeetingRelevanceId() {
		return this.__meeting_relevance_id;
	}

	public void setMeetingRelevanceId( java.lang.Integer value ) {
		this.__meeting_relevance_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public void cloneCopy(BaseConfree __bean){
		__bean.setConfereeId(getConfereeId());
		__bean.setMeetingRelevanceId(getMeetingRelevanceId());
		__bean.setEmployeeId(getEmployeeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getConfereeId() == null ? "" : getConfereeId());
		sb.append(",");
		sb.append(getMeetingRelevanceId() == null ? "" : getMeetingRelevanceId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseConfree o) {
		return __conferee_id == null ? -1 : __conferee_id.compareTo(o.getConfereeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__conferee_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_relevance_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseConfree o = (BaseConfree)obj;
		if(!Objects.equals(this.__conferee_id, o.getConfereeId())) return false;
		if(!Objects.equals(this.__meeting_relevance_id, o.getMeetingRelevanceId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getConfereeId() != null) sb.append(__wrapNumber(count++, "confereeId", getConfereeId()));
		if(getMeetingRelevanceId() != null) sb.append(__wrapNumber(count++, "meetingRelevanceId", getMeetingRelevanceId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getConfereeId() != null) res.put("confereeId", getConfereeId());
		if(getMeetingRelevanceId() != null) res.put("meetingRelevanceId", getMeetingRelevanceId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("confereeId")) != null) setConfereeId(__getInt(val)); 
		if((val = values.get("meetingRelevanceId")) != null) setMeetingRelevanceId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	protected java.lang.Integer  __conferee_id ;
	protected java.lang.Integer  __meeting_relevance_id ;
	protected java.lang.Integer  __employee_id ;
}
