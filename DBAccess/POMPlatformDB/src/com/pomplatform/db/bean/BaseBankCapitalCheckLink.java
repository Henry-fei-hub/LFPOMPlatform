package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseBankCapitalCheckLink extends GenericBase implements BaseFactory<BaseBankCapitalCheckLink>, Comparable<BaseBankCapitalCheckLink> 
{


	public static BaseBankCapitalCheckLink newInstance(){
		return new BaseBankCapitalCheckLink();
	}

	@Override
	public BaseBankCapitalCheckLink make(){
		BaseBankCapitalCheckLink b = new BaseBankCapitalCheckLink();
		return b;
	}

	public final static java.lang.String CS_BANK_CAPITAL_CHECK_LINK_ID = "bank_capital_check_link_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_LINK_TYPE = "link_type" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,业务表主键,业务表类型 1cmbc_trans_info 2 capitals,关联类型 1收入  2支出,关联识别码code表示唯一关联关系 code在每一笔关联对应中唯一,创建时间,操作人";

	public java.lang.Integer getBankCapitalCheckLinkId() {
		return this.__bank_capital_check_link_id;
	}

	public void setBankCapitalCheckLinkId( java.lang.Integer value ) {
		this.__bank_capital_check_link_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getLinkType() {
		return this.__link_type;
	}

	public void setLinkType( java.lang.Integer value ) {
		this.__link_type = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public void cloneCopy(BaseBankCapitalCheckLink __bean){
		__bean.setBankCapitalCheckLinkId(getBankCapitalCheckLinkId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessType(getBusinessType());
		__bean.setLinkType(getLinkType());
		__bean.setCode(getCode());
		__bean.setCreateTime(getCreateTime());
		__bean.setOperator(getOperator());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBankCapitalCheckLinkId() == null ? "" : getBankCapitalCheckLinkId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getLinkType() == null ? "" : getLinkType());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBankCapitalCheckLink o) {
		return __bank_capital_check_link_id == null ? -1 : __bank_capital_check_link_id.compareTo(o.getBankCapitalCheckLinkId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__bank_capital_check_link_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__link_type);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBankCapitalCheckLink o = (BaseBankCapitalCheckLink)obj;
		if(!Objects.equals(this.__bank_capital_check_link_id, o.getBankCapitalCheckLinkId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__link_type, o.getLinkType())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBankCapitalCheckLinkId() != null) sb.append(__wrapNumber(count++, "bankCapitalCheckLinkId", getBankCapitalCheckLinkId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getLinkType() != null) sb.append(__wrapNumber(count++, "linkType", getLinkType()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("bankCapitalCheckLinkId")) != null) setBankCapitalCheckLinkId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("linkType")) != null) setLinkType(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
	}

	protected java.lang.Integer  __bank_capital_check_link_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __link_type ;
	protected java.lang.String  __code ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __operator ;
}
