package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOutTempletsLinkOutTempletOption extends GenericBase implements BaseFactory<BaseOutTempletsLinkOutTempletOption>, Comparable<BaseOutTempletsLinkOutTempletOption> 
{


	public static BaseOutTempletsLinkOutTempletOption newInstance(){
		return new BaseOutTempletsLinkOutTempletOption();
	}

	@Override
	public BaseOutTempletsLinkOutTempletOption make(){
		BaseOutTempletsLinkOutTempletOption b = new BaseOutTempletsLinkOutTempletOption();
		return b;
	}

	public final static java.lang.String CS_OUT_TEMPLETS_LINK_OUT_TEMPLET_OPTION_ID = "out_templets_link_out_templet_option_id" ;
	public final static java.lang.String CS_OUT_TEMPLET_ID = "out_templet_id" ;
	public final static java.lang.String CS_OUT_TEMPLET_OPTION_ID = "out_templet_option_id" ;

	public final static java.lang.String ALL_CAPTIONS = "模板跟专项,子项关联的中间表 编码,模板的 编码,模板的专项,子项 编码";

	public java.lang.Integer getOutTempletsLinkOutTempletOptionId() {
		return this.__out_templets_link_out_templet_option_id;
	}

	public void setOutTempletsLinkOutTempletOptionId( java.lang.Integer value ) {
		this.__out_templets_link_out_templet_option_id = value;
	}

	public java.lang.Integer getOutTempletId() {
		return this.__out_templet_id;
	}

	public void setOutTempletId( java.lang.Integer value ) {
		this.__out_templet_id = value;
	}

	public java.lang.Integer getOutTempletOptionId() {
		return this.__out_templet_option_id;
	}

	public void setOutTempletOptionId( java.lang.Integer value ) {
		this.__out_templet_option_id = value;
	}

	public void cloneCopy(BaseOutTempletsLinkOutTempletOption __bean){
		__bean.setOutTempletsLinkOutTempletOptionId(getOutTempletsLinkOutTempletOptionId());
		__bean.setOutTempletId(getOutTempletId());
		__bean.setOutTempletOptionId(getOutTempletOptionId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOutTempletsLinkOutTempletOptionId() == null ? "" : getOutTempletsLinkOutTempletOptionId());
		sb.append(",");
		sb.append(getOutTempletId() == null ? "" : getOutTempletId());
		sb.append(",");
		sb.append(getOutTempletOptionId() == null ? "" : getOutTempletOptionId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOutTempletsLinkOutTempletOption o) {
		return __out_templets_link_out_templet_option_id == null ? -1 : __out_templets_link_out_templet_option_id.compareTo(o.getOutTempletsLinkOutTempletOptionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__out_templets_link_out_templet_option_id);
		hash = 97 * hash + Objects.hashCode(this.__out_templet_id);
		hash = 97 * hash + Objects.hashCode(this.__out_templet_option_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOutTempletsLinkOutTempletOption o = (BaseOutTempletsLinkOutTempletOption)obj;
		if(!Objects.equals(this.__out_templets_link_out_templet_option_id, o.getOutTempletsLinkOutTempletOptionId())) return false;
		if(!Objects.equals(this.__out_templet_id, o.getOutTempletId())) return false;
		if(!Objects.equals(this.__out_templet_option_id, o.getOutTempletOptionId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOutTempletsLinkOutTempletOptionId() != null) sb.append(__wrapNumber(count++, "outTempletsLinkOutTempletOptionId", getOutTempletsLinkOutTempletOptionId()));
		if(getOutTempletId() != null) sb.append(__wrapNumber(count++, "outTempletId", getOutTempletId()));
		if(getOutTempletOptionId() != null) sb.append(__wrapNumber(count++, "outTempletOptionId", getOutTempletOptionId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("outTempletsLinkOutTempletOptionId")) != null) setOutTempletsLinkOutTempletOptionId(__getInt(val)); 
		if((val = values.get("outTempletId")) != null) setOutTempletId(__getInt(val)); 
		if((val = values.get("outTempletOptionId")) != null) setOutTempletOptionId(__getInt(val)); 
	}

	protected java.lang.Integer  __out_templets_link_out_templet_option_id ;
	protected java.lang.Integer  __out_templet_id ;
	protected java.lang.Integer  __out_templet_option_id ;
}
