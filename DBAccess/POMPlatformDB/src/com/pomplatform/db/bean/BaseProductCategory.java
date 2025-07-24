package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProductCategory extends GenericBase implements BaseFactory<BaseProductCategory>, Comparable<BaseProductCategory> 
{


	public static BaseProductCategory newInstance(){
		return new BaseProductCategory();
	}

	@Override
	public BaseProductCategory make(){
		BaseProductCategory b = new BaseProductCategory();
		return b;
	}

	public final static java.lang.String CS_CATEGORY_ID = "category_id" ;
	public final static java.lang.String CS_CATEGORY_NAME = "category_name" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_IS_ENABLED = "is_enabled" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,类别名称,父级id,是否可用,创建人,创建时间,删除标志 0未删除  1已删除,备注";

	public java.lang.Integer getCategoryId() {
		return this.__category_id;
	}

	public void setCategoryId( java.lang.Integer value ) {
		this.__category_id = value;
	}

	public java.lang.String getCategoryName() {
		return this.__category_name;
	}

	public void setCategoryName( java.lang.String value ) {
		this.__category_name = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Boolean getIsEnabled() {
		return this.__is_enabled;
	}

	public void setIsEnabled( java.lang.Boolean value ) {
		this.__is_enabled = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseProductCategory __bean){
		__bean.setCategoryId(getCategoryId());
		__bean.setCategoryName(getCategoryName());
		__bean.setParentId(getParentId());
		__bean.setIsEnabled(getIsEnabled());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCategoryId() == null ? "" : getCategoryId());
		sb.append(",");
		sb.append(getCategoryName() == null ? "" : getCategoryName());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getIsEnabled() == null ? "" : getIsEnabled());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProductCategory o) {
		return __category_id == null ? -1 : __category_id.compareTo(o.getCategoryId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__category_id);
		hash = 97 * hash + Objects.hashCode(this.__category_name);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__is_enabled);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProductCategory o = (BaseProductCategory)obj;
		if(!Objects.equals(this.__category_id, o.getCategoryId())) return false;
		if(!Objects.equals(this.__category_name, o.getCategoryName())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__is_enabled, o.getIsEnabled())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCategoryId() != null) sb.append(__wrapNumber(count++, "categoryId", getCategoryId()));
		if(getCategoryName() != null) sb.append(__wrapString(count++, "categoryName", getCategoryName()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(count++, "isEnabled", getIsEnabled()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCategoryId() != null) res.put("categoryId", getCategoryId());
		if(getCategoryName() != null) res.put("categoryName", getCategoryName());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getIsEnabled() != null) res.put("isEnabled", getIsEnabled());
		if(getCreateEmployeeId() != null) res.put("createEmployeeId", getCreateEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("categoryId")) != null) setCategoryId(__getInt(val)); 
		if((val = values.get("categoryName")) != null) setCategoryName(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __category_id ;
	protected java.lang.String  __category_name ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Boolean  __is_enabled ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.String  __remark ;
}
