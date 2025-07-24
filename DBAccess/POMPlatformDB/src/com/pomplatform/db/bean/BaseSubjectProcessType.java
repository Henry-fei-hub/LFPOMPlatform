package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSubjectProcessType extends GenericBase implements BaseFactory<BaseSubjectProcessType>, Comparable<BaseSubjectProcessType> 
{


	public static BaseSubjectProcessType newInstance(){
		return new BaseSubjectProcessType();
	}

	@Override
	public BaseSubjectProcessType make(){
		BaseSubjectProcessType b = new BaseSubjectProcessType();
		return b;
	}

	public final static java.lang.String CS_SUBJECT_PROCESS_TYPE_ID = "subject_process_type_id" ;
	public final static java.lang.String CS_SUBJECT_TYPE_ID = "subject_type_id" ;
	public final static java.lang.String CS_PROCESS_TYPE_ID = "process_type_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,科目编码,流程类别编码";

	public java.lang.Integer getSubjectProcessTypeId() {
		return this.__subject_process_type_id;
	}

	public void setSubjectProcessTypeId( java.lang.Integer value ) {
		this.__subject_process_type_id = value;
	}

	public java.lang.Integer getSubjectTypeId() {
		return this.__subject_type_id;
	}

	public void setSubjectTypeId( java.lang.Integer value ) {
		this.__subject_type_id = value;
	}

	public java.lang.Integer getProcessTypeId() {
		return this.__process_type_id;
	}

	public void setProcessTypeId( java.lang.Integer value ) {
		this.__process_type_id = value;
	}

	public void cloneCopy(BaseSubjectProcessType __bean){
		__bean.setSubjectProcessTypeId(getSubjectProcessTypeId());
		__bean.setSubjectTypeId(getSubjectTypeId());
		__bean.setProcessTypeId(getProcessTypeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSubjectProcessTypeId() == null ? "" : getSubjectProcessTypeId());
		sb.append(",");
		sb.append(getSubjectTypeId() == null ? "" : getSubjectTypeId());
		sb.append(",");
		sb.append(getProcessTypeId() == null ? "" : getProcessTypeId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSubjectProcessType o) {
		return __subject_process_type_id == null ? -1 : __subject_process_type_id.compareTo(o.getSubjectProcessTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__subject_process_type_id);
		hash = 97 * hash + Objects.hashCode(this.__subject_type_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSubjectProcessType o = (BaseSubjectProcessType)obj;
		if(!Objects.equals(this.__subject_process_type_id, o.getSubjectProcessTypeId())) return false;
		if(!Objects.equals(this.__subject_type_id, o.getSubjectTypeId())) return false;
		if(!Objects.equals(this.__process_type_id, o.getProcessTypeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSubjectProcessTypeId() != null) sb.append(__wrapNumber(count++, "subjectProcessTypeId", getSubjectProcessTypeId()));
		if(getSubjectTypeId() != null) sb.append(__wrapNumber(count++, "subjectTypeId", getSubjectTypeId()));
		if(getProcessTypeId() != null) sb.append(__wrapNumber(count++, "processTypeId", getProcessTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("subjectProcessTypeId")) != null) setSubjectProcessTypeId(__getInt(val)); 
		if((val = values.get("subjectTypeId")) != null) setSubjectTypeId(__getInt(val)); 
		if((val = values.get("processTypeId")) != null) setProcessTypeId(__getInt(val)); 
	}

	protected java.lang.Integer  __subject_process_type_id ;
	protected java.lang.Integer  __subject_type_id ;
	protected java.lang.Integer  __process_type_id ;
}
