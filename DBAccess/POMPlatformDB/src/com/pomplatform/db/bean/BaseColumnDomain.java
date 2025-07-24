package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseColumnDomain extends GenericBase implements BaseFactory<BaseColumnDomain>, Comparable<BaseColumnDomain> 
{


	public static BaseColumnDomain newInstance(){
		return new BaseColumnDomain();
	}

	@Override
	public BaseColumnDomain make(){
		BaseColumnDomain b = new BaseColumnDomain();
		return b;
	}

	public final static java.lang.String CS_SELECT_ID = "select_id" ;
	public final static java.lang.String CS_TABLE_NAME = "table_name" ;
	public final static java.lang.String CS_KEY_COLUMN = "key_column" ;
	public final static java.lang.String CS_VALUE_COLUMN = "value_column" ;
	public final static java.lang.String CS_CONDITION_COLUMN = "condition_column" ;
	public final static java.lang.String CS_ADDITIONAL_CONDITION = "additional_condition" ;
	public final static java.lang.String CS_LOAD_ON_STARTUP = "load_on_startup" ;

	public final static java.lang.String ALL_CAPTIONS = ",,,,,,";

	public java.lang.String getSelectId() {
		return this.__select_id;
	}

	public void setSelectId( java.lang.String value ) {
		this.__select_id = value;
	}

	public java.lang.String getTableName() {
		return this.__table_name;
	}

	public void setTableName( java.lang.String value ) {
		this.__table_name = value;
	}

	public java.lang.String getKeyColumn() {
		return this.__key_column;
	}

	public void setKeyColumn( java.lang.String value ) {
		this.__key_column = value;
	}

	public java.lang.String getValueColumn() {
		return this.__value_column;
	}

	public void setValueColumn( java.lang.String value ) {
		this.__value_column = value;
	}

	public java.lang.String getConditionColumn() {
		return this.__condition_column;
	}

	public void setConditionColumn( java.lang.String value ) {
		this.__condition_column = value;
	}

	public java.lang.String getAdditionalCondition() {
		return this.__additional_condition;
	}

	public void setAdditionalCondition( java.lang.String value ) {
		this.__additional_condition = value;
	}

	public java.lang.Boolean getLoadOnStartup() {
		return this.__load_on_startup;
	}

	public void setLoadOnStartup( java.lang.Boolean value ) {
		this.__load_on_startup = value;
	}

	public void cloneCopy(BaseColumnDomain __bean){
		__bean.setSelectId(getSelectId());
		__bean.setTableName(getTableName());
		__bean.setKeyColumn(getKeyColumn());
		__bean.setValueColumn(getValueColumn());
		__bean.setConditionColumn(getConditionColumn());
		__bean.setAdditionalCondition(getAdditionalCondition());
		__bean.setLoadOnStartup(getLoadOnStartup());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSelectId() == null ? "" : getSelectId());
		sb.append(",");
		sb.append(getTableName() == null ? "" : getTableName());
		sb.append(",");
		sb.append(getKeyColumn() == null ? "" : getKeyColumn());
		sb.append(",");
		sb.append(getValueColumn() == null ? "" : getValueColumn());
		sb.append(",");
		sb.append(getConditionColumn() == null ? "" : getConditionColumn());
		sb.append(",");
		sb.append(getAdditionalCondition() == null ? "" : getAdditionalCondition());
		sb.append(",");
		sb.append(getLoadOnStartup() == null ? "" : getLoadOnStartup());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseColumnDomain o) {
		return __select_id == null ? -1 : __select_id.compareTo(o.getSelectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__select_id);
		hash = 97 * hash + Objects.hashCode(this.__table_name);
		hash = 97 * hash + Objects.hashCode(this.__key_column);
		hash = 97 * hash + Objects.hashCode(this.__value_column);
		hash = 97 * hash + Objects.hashCode(this.__condition_column);
		hash = 97 * hash + Objects.hashCode(this.__additional_condition);
		hash = 97 * hash + Objects.hashCode(this.__load_on_startup);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseColumnDomain o = (BaseColumnDomain)obj;
		if(!Objects.equals(this.__select_id, o.getSelectId())) return false;
		if(!Objects.equals(this.__table_name, o.getTableName())) return false;
		if(!Objects.equals(this.__key_column, o.getKeyColumn())) return false;
		if(!Objects.equals(this.__value_column, o.getValueColumn())) return false;
		if(!Objects.equals(this.__condition_column, o.getConditionColumn())) return false;
		if(!Objects.equals(this.__additional_condition, o.getAdditionalCondition())) return false;
		if(!Objects.equals(this.__load_on_startup, o.getLoadOnStartup())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSelectId() != null) sb.append(__wrapString(count++, "selectId", getSelectId()));
		if(getTableName() != null) sb.append(__wrapString(count++, "tableName", getTableName()));
		if(getKeyColumn() != null) sb.append(__wrapString(count++, "keyColumn", getKeyColumn()));
		if(getValueColumn() != null) sb.append(__wrapString(count++, "valueColumn", getValueColumn()));
		if(getConditionColumn() != null) sb.append(__wrapString(count++, "conditionColumn", getConditionColumn()));
		if(getAdditionalCondition() != null) sb.append(__wrapString(count++, "additionalCondition", getAdditionalCondition()));
		if(getLoadOnStartup() != null) sb.append(__wrapBoolean(count++, "loadOnStartup", getLoadOnStartup()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("selectId")) != null) setSelectId(__getString(val));
		if((val = values.get("tableName")) != null) setTableName(__getString(val));
		if((val = values.get("keyColumn")) != null) setKeyColumn(__getString(val));
		if((val = values.get("valueColumn")) != null) setValueColumn(__getString(val));
		if((val = values.get("conditionColumn")) != null) setConditionColumn(__getString(val));
		if((val = values.get("additionalCondition")) != null) setAdditionalCondition(__getString(val));
		if((val = values.get("loadOnStartup")) != null) setLoadOnStartup(__getBoolean(val));
	}

	protected java.lang.String  __select_id ;
	protected java.lang.String  __table_name ;
	protected java.lang.String  __key_column ;
	protected java.lang.String  __value_column ;
	protected java.lang.String  __condition_column ;
	protected java.lang.String  __additional_condition ;
	protected java.lang.Boolean  __load_on_startup ;
}
