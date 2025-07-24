package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseDuty extends GenericBase implements BaseFactory<BaseDuty>, Comparable<BaseDuty> 
{


	public static BaseDuty newInstance(){
		return new BaseDuty();
	}

	@Override
	public BaseDuty make(){
		BaseDuty b = new BaseDuty();
		return b;
	}

	public final static java.lang.String CS_DUTY_ID = "duty_id" ;
	public final static java.lang.String CS_DUTY_NAME = "duty_name" ;
	public final static java.lang.String CS_DESCRIPTION = "description" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_ORIGINAL_ID = "original_id" ;
	public final static java.lang.String CS_PARENT_DUTY_ID = "parent_duty_id" ;

	public final static java.lang.String ALL_CAPTIONS = "职位,职位名称,职位描述,备注,OA职位编码,上级职位";

	public java.lang.Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( java.lang.Integer value ) {
		this.__duty_id = value;
	}

	public java.lang.String getDutyName() {
		return this.__duty_name;
	}

	public void setDutyName( java.lang.String value ) {
		this.__duty_name = value;
	}

	public java.lang.String getDescription() {
		return this.__description;
	}

	public void setDescription( java.lang.String value ) {
		this.__description = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getOriginalId() {
		return this.__original_id;
	}

	public void setOriginalId( java.lang.Integer value ) {
		this.__original_id = value;
	}

	public java.lang.Integer getParentDutyId() {
		return this.__parent_duty_id;
	}

	public void setParentDutyId( java.lang.Integer value ) {
		this.__parent_duty_id = value;
	}

	public void cloneCopy(BaseDuty __bean){
		__bean.setDutyId(getDutyId());
		__bean.setDutyName(getDutyName());
		__bean.setDescription(getDescription());
		__bean.setRemark(getRemark());
		__bean.setOriginalId(getOriginalId());
		__bean.setParentDutyId(getParentDutyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDutyId() == null ? "" : getDutyId());
		sb.append(",");
		sb.append(getDutyName() == null ? "" : getDutyName());
		sb.append(",");
		sb.append(getDescription() == null ? "" : getDescription());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getOriginalId() == null ? "" : getOriginalId());
		sb.append(",");
		sb.append(getParentDutyId() == null ? "" : getParentDutyId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseDuty o) {
		return __duty_id == null ? -1 : __duty_id.compareTo(o.getDutyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		hash = 97 * hash + Objects.hashCode(this.__duty_name);
		hash = 97 * hash + Objects.hashCode(this.__description);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__original_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_duty_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseDuty o = (BaseDuty)obj;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		if(!Objects.equals(this.__duty_name, o.getDutyName())) return false;
		if(!Objects.equals(this.__description, o.getDescription())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__original_id, o.getOriginalId())) return false;
		if(!Objects.equals(this.__parent_duty_id, o.getParentDutyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDutyId() != null) sb.append(__wrapNumber(count++, "dutyId", getDutyId()));
		if(getDutyName() != null) sb.append(__wrapString(count++, "dutyName", getDutyName()));
		if(getDescription() != null) sb.append(__wrapString(count++, "description", getDescription()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getOriginalId() != null) sb.append(__wrapNumber(count++, "originalId", getOriginalId()));
		if(getParentDutyId() != null) sb.append(__wrapNumber(count++, "parentDutyId", getParentDutyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
		if((val = values.get("dutyName")) != null) setDutyName(__getString(val));
		if((val = values.get("description")) != null) setDescription(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("originalId")) != null) setOriginalId(__getInt(val)); 
		if((val = values.get("parentDutyId")) != null) setParentDutyId(__getInt(val)); 
	}

	protected java.lang.Integer  __duty_id ;
	protected java.lang.String  __duty_name ;
	protected java.lang.String  __description ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __original_id ;
	protected java.lang.Integer  __parent_duty_id ;
}
