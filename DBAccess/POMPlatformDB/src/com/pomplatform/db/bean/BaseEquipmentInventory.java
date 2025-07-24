package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEquipmentInventory extends GenericBase implements BaseFactory<BaseEquipmentInventory>, Comparable<BaseEquipmentInventory> 
{


	public static BaseEquipmentInventory newInstance(){
		return new BaseEquipmentInventory();
	}

	@Override
	public BaseEquipmentInventory make(){
		BaseEquipmentInventory b = new BaseEquipmentInventory();
		return b;
	}

	public final static java.lang.String CS_EQUIPMENT_INVENTORY_ID = "equipment_inventory_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_PRICE = "price" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_INPUT_DATE = "input_date" ;
	public final static java.lang.String CS_PULL_DATE = "pull_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;

	public final static java.lang.String ALL_CAPTIONS = "设备库存,类型,名称,编号,单价,库存数量,状态（0正常； 1外借； 2使用中； 3报废）,入库时间,报废时间,备注,创建时间,修改时间";

	public java.lang.Integer getEquipmentInventoryId() {
		return this.__equipment_inventory_id;
	}

	public void setEquipmentInventoryId( java.lang.Integer value ) {
		this.__equipment_inventory_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.math.BigDecimal getPrice() {
		return this.__price;
	}

	public void setPrice( java.math.BigDecimal value ) {
		this.__price = value;
	}

	public java.lang.Integer getAmount() {
		return this.__amount;
	}

	public void setAmount( java.lang.Integer value ) {
		this.__amount = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.util.Date getInputDate() {
		return this.__input_date;
	}

	public void setInputDate( java.util.Date value ) {
		this.__input_date = value;
	}

	public java.util.Date getPullDate() {
		return this.__pull_date;
	}

	public void setPullDate( java.util.Date value ) {
		this.__pull_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public void cloneCopy(BaseEquipmentInventory __bean){
		__bean.setEquipmentInventoryId(getEquipmentInventoryId());
		__bean.setType(getType());
		__bean.setName(getName());
		__bean.setCode(getCode());
		__bean.setPrice(getPrice());
		__bean.setAmount(getAmount());
		__bean.setStatus(getStatus());
		__bean.setInputDate(getInputDate());
		__bean.setPullDate(getPullDate());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEquipmentInventoryId() == null ? "" : getEquipmentInventoryId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getPrice() == null ? "" : getPrice());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_16", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getInputDate() == null ? "" : sdf.format(getInputDate()));
		sb.append(",");
		sb.append(getPullDate() == null ? "" : sdf.format(getPullDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEquipmentInventory o) {
		return __equipment_inventory_id == null ? -1 : __equipment_inventory_id.compareTo(o.getEquipmentInventoryId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__equipment_inventory_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__price);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__input_date);
		hash = 97 * hash + Objects.hashCode(this.__pull_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEquipmentInventory o = (BaseEquipmentInventory)obj;
		if(!Objects.equals(this.__equipment_inventory_id, o.getEquipmentInventoryId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__price, o.getPrice())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__input_date, o.getInputDate())) return false;
		if(!Objects.equals(this.__pull_date, o.getPullDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEquipmentInventoryId() != null) sb.append(__wrapNumber(count++, "equipmentInventoryId", getEquipmentInventoryId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getPrice() != null) sb.append(__wrapDecimal(count++, "price", getPrice()));
		if(getAmount() != null) sb.append(__wrapNumber(count++, "amount", getAmount()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getInputDate() != null) sb.append(__wrapDate(count++, "inputDate", getInputDate()));
		if(getPullDate() != null) sb.append(__wrapDate(count++, "pullDate", getPullDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("equipmentInventoryId")) != null) setEquipmentInventoryId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("price")) != null) setPrice(__getDecimal(val));  
		if((val = values.get("amount")) != null) setAmount(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("inputDate")) != null) setInputDate(__getDate(val)); 
		if((val = values.get("pullDate")) != null) setPullDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __equipment_inventory_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __name ;
	protected java.lang.String  __code ;
	protected java.math.BigDecimal  __price ;
	protected java.lang.Integer  __amount ;
	protected java.lang.Integer  __status ;
	protected java.util.Date  __input_date ;
	protected java.util.Date  __pull_date ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
}
