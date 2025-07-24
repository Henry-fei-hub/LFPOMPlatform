package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseBudgetDetailType extends GenericBase implements BaseFactory<BaseBudgetDetailType>, Comparable<BaseBudgetDetailType> 
{


	public static BaseBudgetDetailType newInstance(){
		return new BaseBudgetDetailType();
	}

	@Override
	public BaseBudgetDetailType make(){
		BaseBudgetDetailType b = new BaseBudgetDetailType();
		return b;
	}

	public final static java.lang.String CS_BUDGET_DETAIL_TYPE = "budget_detail_type" ;
	public final static java.lang.String CS_BUDGET_DETAIL_TYPE_KEY = "budget_detail_type_key" ;
	public final static java.lang.String CS_BUDGET_DETAIL_TYPE_VALUE = "budget_detail_type_value" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;
	public final static java.lang.String CS_TYPE_ID = "type_id" ;

	public final static java.lang.String ALL_CAPTIONS = "预算类别详情编码,预算类别详情key,预算类别详情value,是否启用,类型编码1.采买，2行政";

	public java.lang.Integer getBudgetDetailType() {
		return this.__budget_detail_type;
	}

	public void setBudgetDetailType( java.lang.Integer value ) {
		this.__budget_detail_type = value;
	}

	public java.lang.String getBudgetDetailTypeKey() {
		return this.__budget_detail_type_key;
	}

	public void setBudgetDetailTypeKey( java.lang.String value ) {
		this.__budget_detail_type_key = value;
	}

	public java.lang.String getBudgetDetailTypeValue() {
		return this.__budget_detail_type_value;
	}

	public void setBudgetDetailTypeValue( java.lang.String value ) {
		this.__budget_detail_type_value = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public java.lang.Integer getTypeId() {
		return this.__type_id;
	}

	public void setTypeId( java.lang.Integer value ) {
		this.__type_id = value;
	}

	public void cloneCopy(BaseBudgetDetailType __bean){
		__bean.setBudgetDetailType(getBudgetDetailType());
		__bean.setBudgetDetailTypeKey(getBudgetDetailTypeKey());
		__bean.setBudgetDetailTypeValue(getBudgetDetailTypeValue());
		__bean.setIsEnable(getIsEnable());
		__bean.setTypeId(getTypeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBudgetDetailType() == null ? "" : getBudgetDetailType());
		sb.append(",");
		sb.append(getBudgetDetailTypeKey() == null ? "" : getBudgetDetailTypeKey());
		sb.append(",");
		sb.append(getBudgetDetailTypeValue() == null ? "" : getBudgetDetailTypeValue());
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		sb.append(",");
		sb.append(getTypeId() == null ? "" : getTypeId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBudgetDetailType o) {
		return __budget_detail_type == null ? -1 : __budget_detail_type.compareTo(o.getBudgetDetailType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__budget_detail_type);
		hash = 97 * hash + Objects.hashCode(this.__budget_detail_type_key);
		hash = 97 * hash + Objects.hashCode(this.__budget_detail_type_value);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		hash = 97 * hash + Objects.hashCode(this.__type_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBudgetDetailType o = (BaseBudgetDetailType)obj;
		if(!Objects.equals(this.__budget_detail_type, o.getBudgetDetailType())) return false;
		if(!Objects.equals(this.__budget_detail_type_key, o.getBudgetDetailTypeKey())) return false;
		if(!Objects.equals(this.__budget_detail_type_value, o.getBudgetDetailTypeValue())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		if(!Objects.equals(this.__type_id, o.getTypeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBudgetDetailType() != null) sb.append(__wrapNumber(count++, "budgetDetailType", getBudgetDetailType()));
		if(getBudgetDetailTypeKey() != null) sb.append(__wrapString(count++, "budgetDetailTypeKey", getBudgetDetailTypeKey()));
		if(getBudgetDetailTypeValue() != null) sb.append(__wrapString(count++, "budgetDetailTypeValue", getBudgetDetailTypeValue()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		if(getTypeId() != null) sb.append(__wrapNumber(count++, "typeId", getTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("budgetDetailType")) != null) setBudgetDetailType(__getInt(val)); 
		if((val = values.get("budgetDetailTypeKey")) != null) setBudgetDetailTypeKey(__getString(val));
		if((val = values.get("budgetDetailTypeValue")) != null) setBudgetDetailTypeValue(__getString(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("typeId")) != null) setTypeId(__getInt(val)); 
	}

	protected java.lang.Integer  __budget_detail_type ;
	protected java.lang.String  __budget_detail_type_key ;
	protected java.lang.String  __budget_detail_type_value ;
	protected java.lang.Boolean  __is_enable ;
	protected java.lang.Integer  __type_id ;
}
