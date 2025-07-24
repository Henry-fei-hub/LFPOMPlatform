package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAccountWeightRecord extends GenericBase implements BaseFactory<BaseAccountWeightRecord>, Comparable<BaseAccountWeightRecord> 
{


	public static BaseAccountWeightRecord newInstance(){
		return new BaseAccountWeightRecord();
	}

	@Override
	public BaseAccountWeightRecord make(){
		BaseAccountWeightRecord b = new BaseAccountWeightRecord();
		return b;
	}

	public final static java.lang.String CS_ACCOUNT_WEIGHT_RECORD_ID = "account_weight_record_id" ;
	public final static java.lang.String CS_TYPE_ID = "type_id" ;
	public final static java.lang.String CS_TYPE_NAME = "type_name" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PERCENT_VIEW = "percent_view" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_LEVEL = "level" ;
	public final static java.lang.String CS_SETTLEMENT_LEVEL = "settlement_level" ;
	public final static java.lang.String CS_ORDER_FLAG = "order_flag" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,类型编码,类型名称,权重比例,权重比例(显示专用，带百分号),父级编码,级别(即几级节点),计算级别(即计算优先级),排序标示,是否启用";

	public java.lang.Integer getAccountWeightRecordId() {
		return this.__account_weight_record_id;
	}

	public void setAccountWeightRecordId( java.lang.Integer value ) {
		this.__account_weight_record_id = value;
	}

	public java.lang.Integer getTypeId() {
		return this.__type_id;
	}

	public void setTypeId( java.lang.Integer value ) {
		this.__type_id = value;
	}

	public java.lang.String getTypeName() {
		return this.__type_name;
	}

	public void setTypeName( java.lang.String value ) {
		this.__type_name = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.lang.String getPercentView() {
		return this.__percent_view;
	}

	public void setPercentView( java.lang.String value ) {
		this.__percent_view = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getLevel() {
		return this.__level;
	}

	public void setLevel( java.lang.Integer value ) {
		this.__level = value;
	}

	public java.lang.Integer getSettlementLevel() {
		return this.__settlement_level;
	}

	public void setSettlementLevel( java.lang.Integer value ) {
		this.__settlement_level = value;
	}

	public java.lang.Integer getOrderFlag() {
		return this.__order_flag;
	}

	public void setOrderFlag( java.lang.Integer value ) {
		this.__order_flag = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public void cloneCopy(BaseAccountWeightRecord __bean){
		__bean.setAccountWeightRecordId(getAccountWeightRecordId());
		__bean.setTypeId(getTypeId());
		__bean.setTypeName(getTypeName());
		__bean.setPercent(getPercent());
		__bean.setPercentView(getPercentView());
		__bean.setParentId(getParentId());
		__bean.setLevel(getLevel());
		__bean.setSettlementLevel(getSettlementLevel());
		__bean.setOrderFlag(getOrderFlag());
		__bean.setEnabled(getEnabled());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAccountWeightRecordId() == null ? "" : getAccountWeightRecordId());
		sb.append(",");
		sb.append(getTypeId() == null ? "" : getTypeId());
		sb.append(",");
		sb.append(getTypeName() == null ? "" : getTypeName());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getPercentView() == null ? "" : getPercentView());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getLevel() == null ? "" : getLevel());
		sb.append(",");
		sb.append(getSettlementLevel() == null ? "" : getSettlementLevel());
		sb.append(",");
		sb.append(getOrderFlag() == null ? "" : getOrderFlag());
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAccountWeightRecord o) {
		return __account_weight_record_id == null ? -1 : __account_weight_record_id.compareTo(o.getAccountWeightRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__account_weight_record_id);
		hash = 97 * hash + Objects.hashCode(this.__type_id);
		hash = 97 * hash + Objects.hashCode(this.__type_name);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__percent_view);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__level);
		hash = 97 * hash + Objects.hashCode(this.__settlement_level);
		hash = 97 * hash + Objects.hashCode(this.__order_flag);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAccountWeightRecord o = (BaseAccountWeightRecord)obj;
		if(!Objects.equals(this.__account_weight_record_id, o.getAccountWeightRecordId())) return false;
		if(!Objects.equals(this.__type_id, o.getTypeId())) return false;
		if(!Objects.equals(this.__type_name, o.getTypeName())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__percent_view, o.getPercentView())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__level, o.getLevel())) return false;
		if(!Objects.equals(this.__settlement_level, o.getSettlementLevel())) return false;
		if(!Objects.equals(this.__order_flag, o.getOrderFlag())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAccountWeightRecordId() != null) sb.append(__wrapNumber(count++, "accountWeightRecordId", getAccountWeightRecordId()));
		if(getTypeId() != null) sb.append(__wrapNumber(count++, "typeId", getTypeId()));
		if(getTypeName() != null) sb.append(__wrapString(count++, "typeName", getTypeName()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getPercentView() != null) sb.append(__wrapString(count++, "percentView", getPercentView()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getLevel() != null) sb.append(__wrapNumber(count++, "level", getLevel()));
		if(getSettlementLevel() != null) sb.append(__wrapNumber(count++, "settlementLevel", getSettlementLevel()));
		if(getOrderFlag() != null) sb.append(__wrapNumber(count++, "orderFlag", getOrderFlag()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("accountWeightRecordId")) != null) setAccountWeightRecordId(__getInt(val)); 
		if((val = values.get("typeId")) != null) setTypeId(__getInt(val)); 
		if((val = values.get("typeName")) != null) setTypeName(__getString(val));
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("percentView")) != null) setPercentView(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("level")) != null) setLevel(__getInt(val)); 
		if((val = values.get("settlementLevel")) != null) setSettlementLevel(__getInt(val)); 
		if((val = values.get("orderFlag")) != null) setOrderFlag(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
	}

	protected java.lang.Integer  __account_weight_record_id ;
	protected java.lang.Integer  __type_id ;
	protected java.lang.String  __type_name ;
	protected java.math.BigDecimal  __percent ;
	protected java.lang.String  __percent_view ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __level ;
	protected java.lang.Integer  __settlement_level ;
	protected java.lang.Integer  __order_flag ;
	protected java.lang.Boolean  __enabled ;
}
