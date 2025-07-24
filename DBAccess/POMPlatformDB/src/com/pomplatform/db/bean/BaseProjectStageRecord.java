package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectStageRecord extends GenericBase implements BaseFactory<BaseProjectStageRecord>, Comparable<BaseProjectStageRecord> 
{


	public static BaseProjectStageRecord newInstance(){
		return new BaseProjectStageRecord();
	}

	@Override
	public BaseProjectStageRecord make(){
		BaseProjectStageRecord b = new BaseProjectStageRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_RECORD_ID = "project_stage_record_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目,项目阶段";

	public java.lang.Integer getProjectStageRecordId() {
		return this.__project_stage_record_id;
	}

	public void setProjectStageRecordId( java.lang.Integer value ) {
		this.__project_stage_record_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public void cloneCopy(BaseProjectStageRecord __bean){
		__bean.setProjectStageRecordId(getProjectStageRecordId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageRecordId() == null ? "" : getProjectStageRecordId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectStageRecord o) {
		return __project_stage_record_id == null ? -1 : __project_stage_record_id.compareTo(o.getProjectStageRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_record_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectStageRecord o = (BaseProjectStageRecord)obj;
		if(!Objects.equals(this.__project_stage_record_id, o.getProjectStageRecordId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageRecordId() != null) sb.append(__wrapNumber(count++, "projectStageRecordId", getProjectStageRecordId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectStageRecordId")) != null) setProjectStageRecordId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_stage_record_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
}
