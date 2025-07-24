package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOutTemplet extends GenericBase implements BaseFactory<BaseOutTemplet>, Comparable<BaseOutTemplet> 
{


	public static BaseOutTemplet newInstance(){
		return new BaseOutTemplet();
	}

	@Override
	public BaseOutTemplet make(){
		BaseOutTemplet b = new BaseOutTemplet();
		return b;
	}

	public final static java.lang.String CS_OUT_TEMPLET_ID = "out_templet_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_TEMPLET_NAME = "templet_name" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DEFAULT_TEMPLET = "default_templet" ;
	public final static java.lang.String CS_DISABLE_TYPE = "disable_type" ;

	public final static java.lang.String ALL_CAPTIONS = "模板的 编码,业务类型,模板名称,模板创建时间,默认模板为1,可操作状态 0可操作,1禁止操作";

	public java.lang.Integer getOutTempletId() {
		return this.__out_templet_id;
	}

	public void setOutTempletId( java.lang.Integer value ) {
		this.__out_templet_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.String getTempletName() {
		return this.__templet_name;
	}

	public void setTempletName( java.lang.String value ) {
		this.__templet_name = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDefaultTemplet() {
		return this.__default_templet;
	}

	public void setDefaultTemplet( java.lang.Integer value ) {
		this.__default_templet = value;
	}

	public java.lang.Integer getDisableType() {
		return this.__disable_type;
	}

	public void setDisableType( java.lang.Integer value ) {
		this.__disable_type = value;
	}

	public void cloneCopy(BaseOutTemplet __bean){
		__bean.setOutTempletId(getOutTempletId());
		__bean.setBusinessType(getBusinessType());
		__bean.setTempletName(getTempletName());
		__bean.setCreateTime(getCreateTime());
		__bean.setDefaultTemplet(getDefaultTemplet());
		__bean.setDisableType(getDisableType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOutTempletId() == null ? "" : getOutTempletId());
		sb.append(",");
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		sb.append(getTempletName() == null ? "" : getTempletName());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDefaultTemplet() == null ? "" : getDefaultTemplet());
		sb.append(",");
		String strDisableType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getDisableType()));
		sb.append(strDisableType == null ? "" : strDisableType);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOutTemplet o) {
		return __out_templet_id == null ? -1 : __out_templet_id.compareTo(o.getOutTempletId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__out_templet_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__templet_name);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__default_templet);
		hash = 97 * hash + Objects.hashCode(this.__disable_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOutTemplet o = (BaseOutTemplet)obj;
		if(!Objects.equals(this.__out_templet_id, o.getOutTempletId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__templet_name, o.getTempletName())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__default_templet, o.getDefaultTemplet())) return false;
		if(!Objects.equals(this.__disable_type, o.getDisableType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOutTempletId() != null) sb.append(__wrapNumber(count++, "outTempletId", getOutTempletId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getTempletName() != null) sb.append(__wrapString(count++, "templetName", getTempletName()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDefaultTemplet() != null) sb.append(__wrapNumber(count++, "defaultTemplet", getDefaultTemplet()));
		if(getDisableType() != null) sb.append(__wrapNumber(count++, "disableType", getDisableType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("outTempletId")) != null) setOutTempletId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("templetName")) != null) setTempletName(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("defaultTemplet")) != null) setDefaultTemplet(__getInt(val)); 
		if((val = values.get("disableType")) != null) setDisableType(__getInt(val)); 
	}

	protected java.lang.Integer  __out_templet_id ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.String  __templet_name ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __default_templet ;
	protected java.lang.Integer  __disable_type ;
}
