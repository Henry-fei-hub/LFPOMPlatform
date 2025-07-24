package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseWorkHandover extends GenericBase implements BaseFactory<BaseWorkHandover>, Comparable<BaseWorkHandover> 
{


	public static BaseWorkHandover newInstance(){
		return new BaseWorkHandover();
	}

	@Override
	public BaseWorkHandover make(){
		BaseWorkHandover b = new BaseWorkHandover();
		return b;
	}

	public final static java.lang.String CS_WORK_HANDOVER_ID = "work_handover_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_LINK_ID = "link_id" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_CONTENT = "content" ;
	public final static java.lang.String CS_FROM_EMPLOYEE_ID = "from_employee_id" ;
	public final static java.lang.String CS_TO_EMPLOYEE_ID = "to_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "工作交接表编码,工作交接类型  1离职   2转岗,关联编码,名称,主要内容,交接者,被交接者,创建时间";

	public java.lang.Integer getWorkHandoverId() {
		return this.__work_handover_id;
	}

	public void setWorkHandoverId( java.lang.Integer value ) {
		this.__work_handover_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getLinkId() {
		return this.__link_id;
	}

	public void setLinkId( java.lang.Integer value ) {
		this.__link_id = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.String getContent() {
		return this.__content;
	}

	public void setContent( java.lang.String value ) {
		this.__content = value;
	}

	public java.lang.Integer getFromEmployeeId() {
		return this.__from_employee_id;
	}

	public void setFromEmployeeId( java.lang.Integer value ) {
		this.__from_employee_id = value;
	}

	public java.lang.Integer getToEmployeeId() {
		return this.__to_employee_id;
	}

	public void setToEmployeeId( java.lang.Integer value ) {
		this.__to_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseWorkHandover __bean){
		__bean.setWorkHandoverId(getWorkHandoverId());
		__bean.setType(getType());
		__bean.setLinkId(getLinkId());
		__bean.setName(getName());
		__bean.setContent(getContent());
		__bean.setFromEmployeeId(getFromEmployeeId());
		__bean.setToEmployeeId(getToEmployeeId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getWorkHandoverId() == null ? "" : getWorkHandoverId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getLinkId() == null ? "" : getLinkId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getContent() == null ? "" : getContent());
		sb.append(",");
		sb.append(getFromEmployeeId() == null ? "" : getFromEmployeeId());
		sb.append(",");
		sb.append(getToEmployeeId() == null ? "" : getToEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseWorkHandover o) {
		return __work_handover_id == null ? -1 : __work_handover_id.compareTo(o.getWorkHandoverId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__work_handover_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__link_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__content);
		hash = 97 * hash + Objects.hashCode(this.__from_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__to_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseWorkHandover o = (BaseWorkHandover)obj;
		if(!Objects.equals(this.__work_handover_id, o.getWorkHandoverId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__link_id, o.getLinkId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__content, o.getContent())) return false;
		if(!Objects.equals(this.__from_employee_id, o.getFromEmployeeId())) return false;
		if(!Objects.equals(this.__to_employee_id, o.getToEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getWorkHandoverId() != null) sb.append(__wrapNumber(count++, "workHandoverId", getWorkHandoverId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getLinkId() != null) sb.append(__wrapNumber(count++, "linkId", getLinkId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getContent() != null) sb.append(__wrapString(count++, "content", getContent()));
		if(getFromEmployeeId() != null) sb.append(__wrapNumber(count++, "fromEmployeeId", getFromEmployeeId()));
		if(getToEmployeeId() != null) sb.append(__wrapNumber(count++, "toEmployeeId", getToEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("workHandoverId")) != null) setWorkHandoverId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("linkId")) != null) setLinkId(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("content")) != null) setContent(__getString(val));
		if((val = values.get("fromEmployeeId")) != null) setFromEmployeeId(__getInt(val)); 
		if((val = values.get("toEmployeeId")) != null) setToEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __work_handover_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __link_id ;
	protected java.lang.String  __name ;
	protected java.lang.String  __content ;
	protected java.lang.Integer  __from_employee_id ;
	protected java.lang.Integer  __to_employee_id ;
	protected java.util.Date  __create_time ;
}
