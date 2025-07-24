package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOutTempletOption extends GenericBase implements BaseFactory<BaseOutTempletOption>, Comparable<BaseOutTempletOption> 
{


	public static BaseOutTempletOption newInstance(){
		return new BaseOutTempletOption();
	}

	@Override
	public BaseOutTempletOption make(){
		BaseOutTempletOption b = new BaseOutTempletOption();
		return b;
	}

	public final static java.lang.String CS_OUT_TEMPLET_OPTION_ID = "out_templet_option_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_OPTION_TYPE = "option_type" ;
	public final static java.lang.String CS_OPTION_NAME = "option_name" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DISABLE_TYPE = "disable_type" ;

	public final static java.lang.String ALL_CAPTIONS = "模板的专项,子项 编码,业务类型,专项标示为1,子项标示2,专项,子项名称,专项,子项 创建时间,可操作状态 0可操作,1禁止操作";

	public java.lang.Integer getOutTempletOptionId() {
		return this.__out_templet_option_id;
	}

	public void setOutTempletOptionId( java.lang.Integer value ) {
		this.__out_templet_option_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getOptionType() {
		return this.__option_type;
	}

	public void setOptionType( java.lang.Integer value ) {
		this.__option_type = value;
	}

	public java.lang.String getOptionName() {
		return this.__option_name;
	}

	public void setOptionName( java.lang.String value ) {
		this.__option_name = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDisableType() {
		return this.__disable_type;
	}

	public void setDisableType( java.lang.Integer value ) {
		this.__disable_type = value;
	}

	public void cloneCopy(BaseOutTempletOption __bean){
		__bean.setOutTempletOptionId(getOutTempletOptionId());
		__bean.setBusinessType(getBusinessType());
		__bean.setOptionType(getOptionType());
		__bean.setOptionName(getOptionName());
		__bean.setCreateTime(getCreateTime());
		__bean.setDisableType(getDisableType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOutTempletOptionId() == null ? "" : getOutTempletOptionId());
		sb.append(",");
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		sb.append(getOptionType() == null ? "" : getOptionType());
		sb.append(",");
		sb.append(getOptionName() == null ? "" : getOptionName());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		String strDisableType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDisableType()));
		sb.append(strDisableType == null ? "" : strDisableType);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOutTempletOption o) {
		return __out_templet_option_id == null ? -1 : __out_templet_option_id.compareTo(o.getOutTempletOptionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__out_templet_option_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__option_type);
		hash = 97 * hash + Objects.hashCode(this.__option_name);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__disable_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOutTempletOption o = (BaseOutTempletOption)obj;
		if(!Objects.equals(this.__out_templet_option_id, o.getOutTempletOptionId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__option_type, o.getOptionType())) return false;
		if(!Objects.equals(this.__option_name, o.getOptionName())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__disable_type, o.getDisableType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOutTempletOptionId() != null) sb.append(__wrapNumber(count++, "outTempletOptionId", getOutTempletOptionId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getOptionType() != null) sb.append(__wrapNumber(count++, "optionType", getOptionType()));
		if(getOptionName() != null) sb.append(__wrapString(count++, "optionName", getOptionName()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDisableType() != null) sb.append(__wrapNumber(count++, "disableType", getDisableType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("outTempletOptionId")) != null) setOutTempletOptionId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("optionType")) != null) setOptionType(__getInt(val)); 
		if((val = values.get("optionName")) != null) setOptionName(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("disableType")) != null) setDisableType(__getInt(val)); 
	}

	protected java.lang.Integer  __out_templet_option_id ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __option_type ;
	protected java.lang.String  __option_name ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __disable_type ;
}
