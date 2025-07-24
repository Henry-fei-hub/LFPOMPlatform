package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEquipmentRecord extends GenericBase implements BaseFactory<BaseEquipmentRecord>, Comparable<BaseEquipmentRecord> 
{


	public static BaseEquipmentRecord newInstance(){
		return new BaseEquipmentRecord();
	}

	@Override
	public BaseEquipmentRecord make(){
		BaseEquipmentRecord b = new BaseEquipmentRecord();
		return b;
	}

	public final static java.lang.String CS_OPERATION_TYPE = "operation_type" ;
	public final static java.lang.String CS_COUNT = "count" ;
	public final static java.lang.String CS_FOLLOW_STATUS = "follow_status" ;
	public final static java.lang.String CS_OPERATION_PERSON = "operation_person" ;
	public final static java.lang.String CS_OPERATION_TIME = "operation_time" ;
	public final static java.lang.String CS_EQUIPMENT_ID = "equipment_id" ;
	public final static java.lang.String CS_FOLLOW_ID = "follow_id" ;

	public final static java.lang.String ALL_CAPTIONS = "操作类型（新增，库存调整，领用，借用，归还）,数量,,操作人,操作时间,物品id,流程编码";

	public java.lang.Short getOperationType() {
		return this.__operation_type;
	}

	public void setOperationType( java.lang.Short value ) {
		this.__operation_type = value;
	}

	public java.lang.Integer getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Integer value ) {
		this.__count = value;
	}

	public java.lang.Short getFollowStatus() {
		return this.__follow_status;
	}

	public void setFollowStatus( java.lang.Short value ) {
		this.__follow_status = value;
	}

	public java.lang.Integer getOperationPerson() {
		return this.__operation_person;
	}

	public void setOperationPerson( java.lang.Integer value ) {
		this.__operation_person = value;
	}

	public java.util.Date getOperationTime() {
		return this.__operation_time;
	}

	public void setOperationTime( java.util.Date value ) {
		this.__operation_time = value;
	}

	public java.lang.Integer getEquipmentId() {
		return this.__equipment_id;
	}

	public void setEquipmentId( java.lang.Integer value ) {
		this.__equipment_id = value;
	}

	public java.lang.Integer getFollowId() {
		return this.__follow_id;
	}

	public void setFollowId( java.lang.Integer value ) {
		this.__follow_id = value;
	}

	public void cloneCopy(BaseEquipmentRecord __bean){
		__bean.setOperationType(getOperationType());
		__bean.setCount(getCount());
		__bean.setFollowStatus(getFollowStatus());
		__bean.setOperationPerson(getOperationPerson());
		__bean.setOperationTime(getOperationTime());
		__bean.setEquipmentId(getEquipmentId());
		__bean.setFollowId(getFollowId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOperationType() == null ? "" : getOperationType());
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		sb.append(",");
		sb.append(getFollowStatus() == null ? "" : getFollowStatus());
		sb.append(",");
		sb.append(getOperationPerson() == null ? "" : getOperationPerson());
		sb.append(",");
		sb.append(getOperationTime() == null ? "" : sdf.format(getOperationTime()));
		sb.append(",");
		sb.append(getEquipmentId() == null ? "" : getEquipmentId());
		sb.append(",");
		sb.append(getFollowId() == null ? "" : getFollowId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEquipmentRecord o) {
		return __operation_type == null ? -1 : __operation_type.compareTo(o.getOperationType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__operation_type);
		hash = 97 * hash + Objects.hashCode(this.__count);
		hash = 97 * hash + Objects.hashCode(this.__follow_status);
		hash = 97 * hash + Objects.hashCode(this.__operation_person);
		hash = 97 * hash + Objects.hashCode(this.__operation_time);
		hash = 97 * hash + Objects.hashCode(this.__equipment_id);
		hash = 97 * hash + Objects.hashCode(this.__follow_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEquipmentRecord o = (BaseEquipmentRecord)obj;
		if(!Objects.equals(this.__operation_type, o.getOperationType())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		if(!Objects.equals(this.__follow_status, o.getFollowStatus())) return false;
		if(!Objects.equals(this.__operation_person, o.getOperationPerson())) return false;
		if(!Objects.equals(this.__operation_time, o.getOperationTime())) return false;
		if(!Objects.equals(this.__equipment_id, o.getEquipmentId())) return false;
		if(!Objects.equals(this.__follow_id, o.getFollowId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOperationType() != null) sb.append(__wrapNumber(count++, "operationType", getOperationType()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		if(getFollowStatus() != null) sb.append(__wrapNumber(count++, "followStatus", getFollowStatus()));
		if(getOperationPerson() != null) sb.append(__wrapNumber(count++, "operationPerson", getOperationPerson()));
		if(getOperationTime() != null) sb.append(__wrapDate(count++, "operationTime", getOperationTime()));
		if(getEquipmentId() != null) sb.append(__wrapNumber(count++, "equipmentId", getEquipmentId()));
		if(getFollowId() != null) sb.append(__wrapNumber(count++, "followId", getFollowId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getOperationType() != null) res.put("operationType", getOperationType());
		if(getCount() != null) res.put("count", getCount());
		if(getFollowStatus() != null) res.put("followStatus", getFollowStatus());
		if(getOperationPerson() != null) res.put("operationPerson", getOperationPerson());
		if(getOperationTime() != null) res.put("operationTime", getOperationTime());
		if(getEquipmentId() != null) res.put("equipmentId", getEquipmentId());
		if(getFollowId() != null) res.put("followId", getFollowId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("operationType")) != null) setOperationType(__getShort(val));
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
		if((val = values.get("followStatus")) != null) setFollowStatus(__getShort(val));
		if((val = values.get("operationPerson")) != null) setOperationPerson(__getInt(val)); 
		if((val = values.get("operationTime")) != null) setOperationTime(__getDate(val)); 
		if((val = values.get("equipmentId")) != null) setEquipmentId(__getInt(val)); 
		if((val = values.get("followId")) != null) setFollowId(__getInt(val)); 
	}

	protected java.lang.Short  __operation_type ;
	protected java.lang.Integer  __count ;
	protected java.lang.Short  __follow_status ;
	protected java.lang.Integer  __operation_person ;
	protected java.util.Date  __operation_time ;
	protected java.lang.Integer  __equipment_id ;
	protected java.lang.Integer  __follow_id ;
}
