package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePmSpecial extends GenericBase implements BaseFactory<BasePmSpecial>, Comparable<BasePmSpecial> 
{


	public static BasePmSpecial newInstance(){
		return new BasePmSpecial();
	}

	@Override
	public BasePmSpecial make(){
		BasePmSpecial b = new BasePmSpecial();
		return b;
	}

	public final static java.lang.String CS_PM_SPECIAL_ID = "pm_special_id" ;
	public final static java.lang.String CS_SPECIAL_CODE = "special_code" ;
	public final static java.lang.String CS_SPECIAL_NAME = "special_name" ;
	public final static java.lang.String CS_IS_DEL = "is_del" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,专业代码,专业名称,是否删除,操作人,操作时间,备注";

	public java.lang.Integer getPmSpecialId() {
		return this.__pm_special_id;
	}

	public void setPmSpecialId( java.lang.Integer value ) {
		this.__pm_special_id = value;
	}

	public java.lang.String getSpecialCode() {
		return this.__special_code;
	}

	public void setSpecialCode( java.lang.String value ) {
		this.__special_code = value;
	}

	public java.lang.String getSpecialName() {
		return this.__special_name;
	}

	public void setSpecialName( java.lang.String value ) {
		this.__special_name = value;
	}

	public java.lang.Boolean getIsDel() {
		return this.__is_del;
	}

	public void setIsDel( java.lang.Boolean value ) {
		this.__is_del = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BasePmSpecial __bean){
		__bean.setPmSpecialId(getPmSpecialId());
		__bean.setSpecialCode(getSpecialCode());
		__bean.setSpecialName(getSpecialName());
		__bean.setIsDel(getIsDel());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPmSpecialId() == null ? "" : getPmSpecialId());
		sb.append(",");
		sb.append(getSpecialCode() == null ? "" : getSpecialCode());
		sb.append(",");
		sb.append(getSpecialName() == null ? "" : getSpecialName());
		sb.append(",");
		sb.append(getIsDel() == null ? "" : getIsDel());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePmSpecial o) {
		return __pm_special_id == null ? -1 : __pm_special_id.compareTo(o.getPmSpecialId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pm_special_id);
		hash = 97 * hash + Objects.hashCode(this.__special_code);
		hash = 97 * hash + Objects.hashCode(this.__special_name);
		hash = 97 * hash + Objects.hashCode(this.__is_del);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePmSpecial o = (BasePmSpecial)obj;
		if(!Objects.equals(this.__pm_special_id, o.getPmSpecialId())) return false;
		if(!Objects.equals(this.__special_code, o.getSpecialCode())) return false;
		if(!Objects.equals(this.__special_name, o.getSpecialName())) return false;
		if(!Objects.equals(this.__is_del, o.getIsDel())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPmSpecialId() != null) sb.append(__wrapNumber(count++, "pmSpecialId", getPmSpecialId()));
		if(getSpecialCode() != null) sb.append(__wrapString(count++, "specialCode", getSpecialCode()));
		if(getSpecialName() != null) sb.append(__wrapString(count++, "specialName", getSpecialName()));
		if(getIsDel() != null) sb.append(__wrapBoolean(count++, "isDel", getIsDel()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("pmSpecialId")) != null) setPmSpecialId(__getInt(val)); 
		if((val = values.get("specialCode")) != null) setSpecialCode(__getString(val));
		if((val = values.get("specialName")) != null) setSpecialName(__getString(val));
		if((val = values.get("isDel")) != null) setIsDel(__getBoolean(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __pm_special_id ;
	protected java.lang.String  __special_code ;
	protected java.lang.String  __special_name ;
	protected java.lang.Boolean  __is_del ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
