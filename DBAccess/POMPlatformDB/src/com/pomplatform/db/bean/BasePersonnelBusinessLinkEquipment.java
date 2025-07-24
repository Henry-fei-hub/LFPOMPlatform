package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePersonnelBusinessLinkEquipment extends GenericBase implements BaseFactory<BasePersonnelBusinessLinkEquipment>, Comparable<BasePersonnelBusinessLinkEquipment> 
{


	public static BasePersonnelBusinessLinkEquipment newInstance(){
		return new BasePersonnelBusinessLinkEquipment();
	}

	@Override
	public BasePersonnelBusinessLinkEquipment make(){
		BasePersonnelBusinessLinkEquipment b = new BasePersonnelBusinessLinkEquipment();
		return b;
	}

	public final static java.lang.String CS_PERSONNEL_BUSINESS_LINK_EQUIPMENT_ID = "personnel_business_link_equipment_id" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_PRICE = "price" ;
	public final static java.lang.String CS_TOTAL_PRICE = "total_price" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IS_ALLOWED = "is_allowed" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_IS_RETURN = "is_return" ;
	public final static java.lang.String CS_RETURN_AMOUNT = "return_amount" ;
	public final static java.lang.String CS_REMAINING_RETURN = "remaining_return" ;

	public final static java.lang.String ALL_CAPTIONS = "设备采购,父级编码,流程类型,类型,数量,单价,总价,备注,是否允许采购,创建时间,是否归还,归还数量,剩余归还数量";

	public java.lang.Integer getPersonnelBusinessLinkEquipmentId() {
		return this.__personnel_business_link_equipment_id;
	}

	public void setPersonnelBusinessLinkEquipmentId( java.lang.Integer value ) {
		this.__personnel_business_link_equipment_id = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getAmount() {
		return this.__amount;
	}

	public void setAmount( java.lang.Integer value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getPrice() {
		return this.__price;
	}

	public void setPrice( java.math.BigDecimal value ) {
		this.__price = value;
	}

	public java.math.BigDecimal getTotalPrice() {
		return this.__total_price;
	}

	public void setTotalPrice( java.math.BigDecimal value ) {
		this.__total_price = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getIsAllowed() {
		return this.__is_allowed;
	}

	public void setIsAllowed( java.lang.Boolean value ) {
		this.__is_allowed = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Boolean getIsReturn() {
		return this.__is_return;
	}

	public void setIsReturn( java.lang.Boolean value ) {
		this.__is_return = value;
	}

	public java.lang.Integer getReturnAmount() {
		return this.__return_amount;
	}

	public void setReturnAmount( java.lang.Integer value ) {
		this.__return_amount = value;
	}

	public java.lang.Integer getRemainingReturn() {
		return this.__remaining_return;
	}

	public void setRemainingReturn( java.lang.Integer value ) {
		this.__remaining_return = value;
	}

	public void cloneCopy(BasePersonnelBusinessLinkEquipment __bean){
		__bean.setPersonnelBusinessLinkEquipmentId(getPersonnelBusinessLinkEquipmentId());
		__bean.setParentId(getParentId());
		__bean.setProcessType(getProcessType());
		__bean.setType(getType());
		__bean.setAmount(getAmount());
		__bean.setPrice(getPrice());
		__bean.setTotalPrice(getTotalPrice());
		__bean.setRemark(getRemark());
		__bean.setIsAllowed(getIsAllowed());
		__bean.setCreateTime(getCreateTime());
		__bean.setIsReturn(getIsReturn());
		__bean.setReturnAmount(getReturnAmount());
		__bean.setRemainingReturn(getRemainingReturn());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPersonnelBusinessLinkEquipmentId() == null ? "" : getPersonnelBusinessLinkEquipmentId());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getPrice() == null ? "" : getPrice());
		sb.append(",");
		sb.append(getTotalPrice() == null ? "" : getTotalPrice());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIsAllowed() == null ? "" : getIsAllowed());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getIsReturn() == null ? "" : getIsReturn());
		sb.append(",");
		sb.append(getReturnAmount() == null ? "" : getReturnAmount());
		sb.append(",");
		sb.append(getRemainingReturn() == null ? "" : getRemainingReturn());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePersonnelBusinessLinkEquipment o) {
		return __personnel_business_link_equipment_id == null ? -1 : __personnel_business_link_equipment_id.compareTo(o.getPersonnelBusinessLinkEquipmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_link_equipment_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__price);
		hash = 97 * hash + Objects.hashCode(this.__total_price);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__is_allowed);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__is_return);
		hash = 97 * hash + Objects.hashCode(this.__return_amount);
		hash = 97 * hash + Objects.hashCode(this.__remaining_return);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePersonnelBusinessLinkEquipment o = (BasePersonnelBusinessLinkEquipment)obj;
		if(!Objects.equals(this.__personnel_business_link_equipment_id, o.getPersonnelBusinessLinkEquipmentId())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__price, o.getPrice())) return false;
		if(!Objects.equals(this.__total_price, o.getTotalPrice())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__is_allowed, o.getIsAllowed())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__is_return, o.getIsReturn())) return false;
		if(!Objects.equals(this.__return_amount, o.getReturnAmount())) return false;
		if(!Objects.equals(this.__remaining_return, o.getRemainingReturn())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPersonnelBusinessLinkEquipmentId() != null) sb.append(__wrapNumber(count++, "personnelBusinessLinkEquipmentId", getPersonnelBusinessLinkEquipmentId()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getAmount() != null) sb.append(__wrapNumber(count++, "amount", getAmount()));
		if(getPrice() != null) sb.append(__wrapDecimal(count++, "price", getPrice()));
		if(getTotalPrice() != null) sb.append(__wrapDecimal(count++, "totalPrice", getTotalPrice()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIsAllowed() != null) sb.append(__wrapBoolean(count++, "isAllowed", getIsAllowed()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getIsReturn() != null) sb.append(__wrapBoolean(count++, "isReturn", getIsReturn()));
		if(getReturnAmount() != null) sb.append(__wrapNumber(count++, "returnAmount", getReturnAmount()));
		if(getRemainingReturn() != null) sb.append(__wrapNumber(count++, "remainingReturn", getRemainingReturn()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPersonnelBusinessLinkEquipmentId() != null) res.put("personnelBusinessLinkEquipmentId", getPersonnelBusinessLinkEquipmentId());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getType() != null) res.put("type", getType());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getPrice() != null) res.put("price", getPrice());
		if(getTotalPrice() != null) res.put("totalPrice", getTotalPrice());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getIsAllowed() != null) res.put("isAllowed", getIsAllowed());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getIsReturn() != null) res.put("isReturn", getIsReturn());
		if(getReturnAmount() != null) res.put("returnAmount", getReturnAmount());
		if(getRemainingReturn() != null) res.put("remainingReturn", getRemainingReturn());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("personnelBusinessLinkEquipmentId")) != null) setPersonnelBusinessLinkEquipmentId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getInt(val)); 
		if((val = values.get("price")) != null) setPrice(__getDecimal(val));  
		if((val = values.get("totalPrice")) != null) setTotalPrice(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("isAllowed")) != null) setIsAllowed(__getBoolean(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("isReturn")) != null) setIsReturn(__getBoolean(val));
		if((val = values.get("returnAmount")) != null) setReturnAmount(__getInt(val)); 
		if((val = values.get("remainingReturn")) != null) setRemainingReturn(__getInt(val)); 
	}

	protected java.lang.Integer  __personnel_business_link_equipment_id ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __amount ;
	protected java.math.BigDecimal  __price ;
	protected java.math.BigDecimal  __total_price ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __is_allowed ;
	protected java.util.Date  __create_time ;
	protected java.lang.Boolean  __is_return ;
	protected java.lang.Integer  __return_amount ;
	protected java.lang.Integer  __remaining_return ;
}
