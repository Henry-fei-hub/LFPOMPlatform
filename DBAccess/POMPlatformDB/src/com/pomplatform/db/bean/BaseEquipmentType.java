package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEquipmentType extends GenericBase implements BaseFactory<BaseEquipmentType>, Comparable<BaseEquipmentType> 
{


	public static BaseEquipmentType newInstance(){
		return new BaseEquipmentType();
	}

	@Override
	public BaseEquipmentType make(){
		BaseEquipmentType b = new BaseEquipmentType();
		return b;
	}

	public final static java.lang.String CS_EQUIPMENT_TYPE_ID = "equipment_type_id" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;
	public final static java.lang.String CS_PRICE = "price" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_UPDATE_PERSON = "update_person" ;
	public final static java.lang.String CS_COUNT = "count" ;
	public final static java.lang.String CS_IS_DELETE = "is_delete" ;

	public final static java.lang.String ALL_CAPTIONS = "设备类型,名称,是否启用,单价,物品类型 0IT物品 1低值易耗品 2电子产品,最近操作时间,最近操作人,数量,是否删除";

	public java.lang.Integer getEquipmentTypeId() {
		return this.__equipment_type_id;
	}

	public void setEquipmentTypeId( java.lang.Integer value ) {
		this.__equipment_type_id = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public java.math.BigDecimal getPrice() {
		return this.__price;
	}

	public void setPrice( java.math.BigDecimal value ) {
		this.__price = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.Integer getUpdatePerson() {
		return this.__update_person;
	}

	public void setUpdatePerson( java.lang.Integer value ) {
		this.__update_person = value;
	}

	public java.lang.Integer getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Integer value ) {
		this.__count = value;
	}

	public java.lang.Boolean getIsDelete() {
		return this.__is_delete;
	}

	public void setIsDelete( java.lang.Boolean value ) {
		this.__is_delete = value;
	}

	public void cloneCopy(BaseEquipmentType __bean){
		__bean.setEquipmentTypeId(getEquipmentTypeId());
		__bean.setName(getName());
		__bean.setEnabled(getEnabled());
		__bean.setPrice(getPrice());
		__bean.setType(getType());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setUpdatePerson(getUpdatePerson());
		__bean.setCount(getCount());
		__bean.setIsDelete(getIsDelete());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEquipmentTypeId() == null ? "" : getEquipmentTypeId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		sb.append(",");
		sb.append(getPrice() == null ? "" : getPrice());
		sb.append(",");
		String strType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_254", String.valueOf(getType()));
		sb.append(strType == null ? "" : strType);
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getUpdatePerson() == null ? "" : getUpdatePerson());
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		sb.append(",");
		sb.append(getIsDelete() == null ? "" : getIsDelete());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEquipmentType o) {
		return __equipment_type_id == null ? -1 : __equipment_type_id.compareTo(o.getEquipmentTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__equipment_type_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		hash = 97 * hash + Objects.hashCode(this.__price);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__update_person);
		hash = 97 * hash + Objects.hashCode(this.__count);
		hash = 97 * hash + Objects.hashCode(this.__is_delete);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEquipmentType o = (BaseEquipmentType)obj;
		if(!Objects.equals(this.__equipment_type_id, o.getEquipmentTypeId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		if(!Objects.equals(this.__price, o.getPrice())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__update_person, o.getUpdatePerson())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		if(!Objects.equals(this.__is_delete, o.getIsDelete())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEquipmentTypeId() != null) sb.append(__wrapNumber(count++, "equipmentTypeId", getEquipmentTypeId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		if(getPrice() != null) sb.append(__wrapDecimal(count++, "price", getPrice()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getUpdatePerson() != null) sb.append(__wrapNumber(count++, "updatePerson", getUpdatePerson()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		if(getIsDelete() != null) sb.append(__wrapBoolean(count++, "isDelete", getIsDelete()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEquipmentTypeId() != null) res.put("equipmentTypeId", getEquipmentTypeId());
		if(getName() != null) res.put("name", getName());
		if(getEnabled() != null) res.put("enabled", getEnabled());
		if(getPrice() != null) res.put("price", getPrice());
		if(getType() != null) res.put("type", getType());
		if(getUpdateTime() != null) res.put("updateTime", getUpdateTime());
		if(getUpdatePerson() != null) res.put("updatePerson", getUpdatePerson());
		if(getCount() != null) res.put("count", getCount());
		if(getIsDelete() != null) res.put("isDelete", getIsDelete());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("equipmentTypeId")) != null) setEquipmentTypeId(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
		if((val = values.get("price")) != null) setPrice(__getDecimal(val));  
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("updatePerson")) != null) setUpdatePerson(__getInt(val)); 
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
		if((val = values.get("isDelete")) != null) setIsDelete(__getBoolean(val));
	}

	protected java.lang.Integer  __equipment_type_id ;
	protected java.lang.String  __name ;
	protected java.lang.Boolean  __enabled ;
	protected java.math.BigDecimal  __price ;
	protected java.lang.Integer  __type ;
	protected java.util.Date  __update_time ;
	protected java.lang.Integer  __update_person ;
	protected java.lang.Integer  __count ;
	protected java.lang.Boolean  __is_delete ;
}
