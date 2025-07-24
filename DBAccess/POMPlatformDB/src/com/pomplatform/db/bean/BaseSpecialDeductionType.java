package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSpecialDeductionType extends GenericBase implements BaseFactory<BaseSpecialDeductionType>, Comparable<BaseSpecialDeductionType> 
{


	public static BaseSpecialDeductionType newInstance(){
		return new BaseSpecialDeductionType();
	}

	@Override
	public BaseSpecialDeductionType make(){
		BaseSpecialDeductionType b = new BaseSpecialDeductionType();
		return b;
	}

	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_ID = "special_deduction_type_id" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_NAME = "special_deduction_type_name" ;
	public final static java.lang.String CS_SCOPE_APPLICATION = "Scope_application" ;
	public final static java.lang.String CS_RANGE_APPLICATION = "range_application" ;
	public final static java.lang.String CS_AMOUNT_DESCRIPTION = "amount_description" ;
	public final static java.lang.String CS_DATE_DESCRIPTION = "date_description" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "id,个税专项扣除类型名称,申请范围说明,适用范围说明,金额范围说明,时间范围说明,是否可用,备注";

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	public java.lang.String getSpecialDeductionTypeName() {
		return this.__special_deduction_type_name;
	}

	public void setSpecialDeductionTypeName( java.lang.String value ) {
		this.__special_deduction_type_name = value;
	}

	public java.lang.String getScopeApplication() {
		return this.__scope_application;
	}

	public void setScopeApplication( java.lang.String value ) {
		this.__scope_application = value;
	}

	public java.lang.String getRangeApplication() {
		return this.__range_application;
	}

	public void setRangeApplication( java.lang.String value ) {
		this.__range_application = value;
	}

	public java.lang.String getAmountDescription() {
		return this.__amount_description;
	}

	public void setAmountDescription( java.lang.String value ) {
		this.__amount_description = value;
	}

	public java.lang.String getDateDescription() {
		return this.__date_description;
	}

	public void setDateDescription( java.lang.String value ) {
		this.__date_description = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSpecialDeductionType __bean){
		__bean.setSpecialDeductionTypeId(getSpecialDeductionTypeId());
		__bean.setSpecialDeductionTypeName(getSpecialDeductionTypeName());
		__bean.setScopeApplication(getScopeApplication());
		__bean.setRangeApplication(getRangeApplication());
		__bean.setAmountDescription(getAmountDescription());
		__bean.setDateDescription(getDateDescription());
		__bean.setIsEnable(getIsEnable());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSpecialDeductionTypeId() == null ? "" : getSpecialDeductionTypeId());
		sb.append(",");
		sb.append(getSpecialDeductionTypeName() == null ? "" : getSpecialDeductionTypeName());
		sb.append(",");
		sb.append(getScopeApplication() == null ? "" : getScopeApplication());
		sb.append(",");
		sb.append(getRangeApplication() == null ? "" : getRangeApplication());
		sb.append(",");
		sb.append(getAmountDescription() == null ? "" : getAmountDescription());
		sb.append(",");
		sb.append(getDateDescription() == null ? "" : getDateDescription());
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSpecialDeductionType o) {
		return __special_deduction_type_id == null ? -1 : __special_deduction_type_id.compareTo(o.getSpecialDeductionTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_id);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_name);
		hash = 97 * hash + Objects.hashCode(this.__scope_application);
		hash = 97 * hash + Objects.hashCode(this.__range_application);
		hash = 97 * hash + Objects.hashCode(this.__amount_description);
		hash = 97 * hash + Objects.hashCode(this.__date_description);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSpecialDeductionType o = (BaseSpecialDeductionType)obj;
		if(!Objects.equals(this.__special_deduction_type_id, o.getSpecialDeductionTypeId())) return false;
		if(!Objects.equals(this.__special_deduction_type_name, o.getSpecialDeductionTypeName())) return false;
		if(!Objects.equals(this.__scope_application, o.getScopeApplication())) return false;
		if(!Objects.equals(this.__range_application, o.getRangeApplication())) return false;
		if(!Objects.equals(this.__amount_description, o.getAmountDescription())) return false;
		if(!Objects.equals(this.__date_description, o.getDateDescription())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(count++, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		if(getSpecialDeductionTypeName() != null) sb.append(__wrapString(count++, "specialDeductionTypeName", getSpecialDeductionTypeName()));
		if(getScopeApplication() != null) sb.append(__wrapString(count++, "scopeApplication", getScopeApplication()));
		if(getRangeApplication() != null) sb.append(__wrapString(count++, "rangeApplication", getRangeApplication()));
		if(getAmountDescription() != null) sb.append(__wrapString(count++, "amountDescription", getAmountDescription()));
		if(getDateDescription() != null) sb.append(__wrapString(count++, "dateDescription", getDateDescription()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSpecialDeductionTypeId() != null) res.put("specialDeductionTypeId", getSpecialDeductionTypeId());
		if(getSpecialDeductionTypeName() != null) res.put("specialDeductionTypeName", getSpecialDeductionTypeName());
		if(getScopeApplication() != null) res.put("scopeApplication", getScopeApplication());
		if(getRangeApplication() != null) res.put("rangeApplication", getRangeApplication());
		if(getAmountDescription() != null) res.put("amountDescription", getAmountDescription());
		if(getDateDescription() != null) res.put("dateDescription", getDateDescription());
		if(getIsEnable() != null) res.put("isEnable", getIsEnable());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
		if((val = values.get("specialDeductionTypeName")) != null) setSpecialDeductionTypeName(__getString(val));
		if((val = values.get("scopeApplication")) != null) setScopeApplication(__getString(val));
		if((val = values.get("rangeApplication")) != null) setRangeApplication(__getString(val));
		if((val = values.get("amountDescription")) != null) setAmountDescription(__getString(val));
		if((val = values.get("dateDescription")) != null) setDateDescription(__getString(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __special_deduction_type_id ;
	protected java.lang.String  __special_deduction_type_name ;
	protected java.lang.String  __scope_application ;
	protected java.lang.String  __range_application ;
	protected java.lang.String  __amount_description ;
	protected java.lang.String  __date_description ;
	protected java.lang.Boolean  __is_enable ;
	protected java.lang.String  __remark ;
}
