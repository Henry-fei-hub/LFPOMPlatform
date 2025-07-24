package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseWorkingHourLinkPersonnelBusines extends GenericBase implements BaseFactory<BaseWorkingHourLinkPersonnelBusines>, Comparable<BaseWorkingHourLinkPersonnelBusines> 
{


	public static BaseWorkingHourLinkPersonnelBusines newInstance(){
		return new BaseWorkingHourLinkPersonnelBusines();
	}

	@Override
	public BaseWorkingHourLinkPersonnelBusines make(){
		BaseWorkingHourLinkPersonnelBusines b = new BaseWorkingHourLinkPersonnelBusines();
		return b;
	}

	public final static java.lang.String CS_WORKING_HOUR_LINK_PERSONNEL_BUSINESS_ID = "working_hour_link_personnel_business_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_WORK_HOUR = "work_hour" ;

	public final static java.lang.String ALL_CAPTIONS = "工时流程表编码,流程主表编码,合同编码,工时";

	public java.lang.Integer getWorkingHourLinkPersonnelBusinessId() {
		return this.__working_hour_link_personnel_business_id;
	}

	public void setWorkingHourLinkPersonnelBusinessId( java.lang.Integer value ) {
		this.__working_hour_link_personnel_business_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getWorkHour() {
		return this.__work_hour;
	}

	public void setWorkHour( java.math.BigDecimal value ) {
		this.__work_hour = value;
	}

	public void cloneCopy(BaseWorkingHourLinkPersonnelBusines __bean){
		__bean.setWorkingHourLinkPersonnelBusinessId(getWorkingHourLinkPersonnelBusinessId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setProjectId(getProjectId());
		__bean.setWorkHour(getWorkHour());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getWorkingHourLinkPersonnelBusinessId() == null ? "" : getWorkingHourLinkPersonnelBusinessId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getWorkHour() == null ? "" : getWorkHour());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseWorkingHourLinkPersonnelBusines o) {
		return __working_hour_link_personnel_business_id == null ? -1 : __working_hour_link_personnel_business_id.compareTo(o.getWorkingHourLinkPersonnelBusinessId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__working_hour_link_personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__work_hour);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseWorkingHourLinkPersonnelBusines o = (BaseWorkingHourLinkPersonnelBusines)obj;
		if(!Objects.equals(this.__working_hour_link_personnel_business_id, o.getWorkingHourLinkPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__work_hour, o.getWorkHour())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getWorkingHourLinkPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "workingHourLinkPersonnelBusinessId", getWorkingHourLinkPersonnelBusinessId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getWorkHour() != null) sb.append(__wrapDecimal(count++, "workHour", getWorkHour()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getWorkingHourLinkPersonnelBusinessId() != null) res.put("workingHourLinkPersonnelBusinessId", getWorkingHourLinkPersonnelBusinessId());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getWorkHour() != null) res.put("workHour", getWorkHour());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("workingHourLinkPersonnelBusinessId")) != null) setWorkingHourLinkPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("workHour")) != null) setWorkHour(__getDecimal(val));  
	}

	protected java.lang.Integer  __working_hour_link_personnel_business_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __work_hour ;
}
