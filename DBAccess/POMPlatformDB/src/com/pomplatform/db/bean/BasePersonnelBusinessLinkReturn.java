package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePersonnelBusinessLinkReturn extends GenericBase implements BaseFactory<BasePersonnelBusinessLinkReturn>, Comparable<BasePersonnelBusinessLinkReturn> 
{


	public static BasePersonnelBusinessLinkReturn newInstance(){
		return new BasePersonnelBusinessLinkReturn();
	}

	@Override
	public BasePersonnelBusinessLinkReturn make(){
		BasePersonnelBusinessLinkReturn b = new BasePersonnelBusinessLinkReturn();
		return b;
	}

	public final static java.lang.String CS_PERSONNEL_BUSINESS_LINK_RETURN_ID = "personnel_business_link_return_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_LINK_EQUIPMENT_ID = "personnel_business_link_equipment_id" ;
	public final static java.lang.String CS_RETURN_AMOUNT = "return_amount" ;
	public final static java.lang.String CS_RETURN_TIME = "return_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "物品归还流程,流程表主键,物品类型,物品借用表主键,归还数量,归还时间,归还备注";

	public java.lang.Integer getPersonnelBusinessLinkReturnId() {
		return this.__personnel_business_link_return_id;
	}

	public void setPersonnelBusinessLinkReturnId( java.lang.Integer value ) {
		this.__personnel_business_link_return_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getPersonnelBusinessLinkEquipmentId() {
		return this.__personnel_business_link_equipment_id;
	}

	public void setPersonnelBusinessLinkEquipmentId( java.lang.Integer value ) {
		this.__personnel_business_link_equipment_id = value;
	}

	public java.lang.Integer getReturnAmount() {
		return this.__return_amount;
	}

	public void setReturnAmount( java.lang.Integer value ) {
		this.__return_amount = value;
	}

	public java.util.Date getReturnTime() {
		return this.__return_time;
	}

	public void setReturnTime( java.util.Date value ) {
		this.__return_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BasePersonnelBusinessLinkReturn __bean){
		__bean.setPersonnelBusinessLinkReturnId(getPersonnelBusinessLinkReturnId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setType(getType());
		__bean.setPersonnelBusinessLinkEquipmentId(getPersonnelBusinessLinkEquipmentId());
		__bean.setReturnAmount(getReturnAmount());
		__bean.setReturnTime(getReturnTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPersonnelBusinessLinkReturnId() == null ? "" : getPersonnelBusinessLinkReturnId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getPersonnelBusinessLinkEquipmentId() == null ? "" : getPersonnelBusinessLinkEquipmentId());
		sb.append(",");
		sb.append(getReturnAmount() == null ? "" : getReturnAmount());
		sb.append(",");
		sb.append(getReturnTime() == null ? "" : sdf.format(getReturnTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePersonnelBusinessLinkReturn o) {
		return __personnel_business_link_return_id == null ? -1 : __personnel_business_link_return_id.compareTo(o.getPersonnelBusinessLinkReturnId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_link_return_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_link_equipment_id);
		hash = 97 * hash + Objects.hashCode(this.__return_amount);
		hash = 97 * hash + Objects.hashCode(this.__return_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePersonnelBusinessLinkReturn o = (BasePersonnelBusinessLinkReturn)obj;
		if(!Objects.equals(this.__personnel_business_link_return_id, o.getPersonnelBusinessLinkReturnId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__personnel_business_link_equipment_id, o.getPersonnelBusinessLinkEquipmentId())) return false;
		if(!Objects.equals(this.__return_amount, o.getReturnAmount())) return false;
		if(!Objects.equals(this.__return_time, o.getReturnTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPersonnelBusinessLinkReturnId() != null) sb.append(__wrapNumber(count++, "personnelBusinessLinkReturnId", getPersonnelBusinessLinkReturnId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getPersonnelBusinessLinkEquipmentId() != null) sb.append(__wrapNumber(count++, "personnelBusinessLinkEquipmentId", getPersonnelBusinessLinkEquipmentId()));
		if(getReturnAmount() != null) sb.append(__wrapNumber(count++, "returnAmount", getReturnAmount()));
		if(getReturnTime() != null) sb.append(__wrapDate(count++, "returnTime", getReturnTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPersonnelBusinessLinkReturnId() != null) res.put("personnelBusinessLinkReturnId", getPersonnelBusinessLinkReturnId());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getType() != null) res.put("type", getType());
		if(getPersonnelBusinessLinkEquipmentId() != null) res.put("personnelBusinessLinkEquipmentId", getPersonnelBusinessLinkEquipmentId());
		if(getReturnAmount() != null) res.put("returnAmount", getReturnAmount());
		if(getReturnTime() != null) res.put("returnTime", getReturnTime());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("personnelBusinessLinkReturnId")) != null) setPersonnelBusinessLinkReturnId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("personnelBusinessLinkEquipmentId")) != null) setPersonnelBusinessLinkEquipmentId(__getInt(val)); 
		if((val = values.get("returnAmount")) != null) setReturnAmount(__getInt(val)); 
		if((val = values.get("returnTime")) != null) setReturnTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __personnel_business_link_return_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __personnel_business_link_equipment_id ;
	protected java.lang.Integer  __return_amount ;
	protected java.util.Date  __return_time ;
	protected java.lang.String  __remark ;
}
