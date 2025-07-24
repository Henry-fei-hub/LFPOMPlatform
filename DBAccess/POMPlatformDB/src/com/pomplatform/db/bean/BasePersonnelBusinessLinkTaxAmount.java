package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePersonnelBusinessLinkTaxAmount extends GenericBase implements BaseFactory<BasePersonnelBusinessLinkTaxAmount>, Comparable<BasePersonnelBusinessLinkTaxAmount> 
{


	public static BasePersonnelBusinessLinkTaxAmount newInstance(){
		return new BasePersonnelBusinessLinkTaxAmount();
	}

	@Override
	public BasePersonnelBusinessLinkTaxAmount make(){
		BasePersonnelBusinessLinkTaxAmount b = new BasePersonnelBusinessLinkTaxAmount();
		return b;
	}

	public final static java.lang.String CS_PERSONNEL_BUSINESS_LINK_TAX_AMOUNT_ID = "personnel_business_link_tax_amount_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_TAX_AMOUNT = "tax_amount" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,流程主键,归属公司,报税金额,操作人,创建日期";

	public java.lang.Integer getPersonnelBusinessLinkTaxAmountId() {
		return this.__personnel_business_link_tax_amount_id;
	}

	public void setPersonnelBusinessLinkTaxAmountId( java.lang.Integer value ) {
		this.__personnel_business_link_tax_amount_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.math.BigDecimal getTaxAmount() {
		return this.__tax_amount;
	}

	public void setTaxAmount( java.math.BigDecimal value ) {
		this.__tax_amount = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BasePersonnelBusinessLinkTaxAmount __bean){
		__bean.setPersonnelBusinessLinkTaxAmountId(getPersonnelBusinessLinkTaxAmountId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setCompanyId(getCompanyId());
		__bean.setTaxAmount(getTaxAmount());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPersonnelBusinessLinkTaxAmountId() == null ? "" : getPersonnelBusinessLinkTaxAmountId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getTaxAmount() == null ? "" : getTaxAmount());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BasePersonnelBusinessLinkTaxAmount o) {
		return __personnel_business_link_tax_amount_id == null ? -1 : __personnel_business_link_tax_amount_id.compareTo(o.getPersonnelBusinessLinkTaxAmountId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_link_tax_amount_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePersonnelBusinessLinkTaxAmount o = (BasePersonnelBusinessLinkTaxAmount)obj;
		if(!Objects.equals(this.__personnel_business_link_tax_amount_id, o.getPersonnelBusinessLinkTaxAmountId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__tax_amount, o.getTaxAmount())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPersonnelBusinessLinkTaxAmountId() != null) sb.append(__wrapNumber(count++, "personnelBusinessLinkTaxAmountId", getPersonnelBusinessLinkTaxAmountId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getTaxAmount() != null) sb.append(__wrapDecimal(count++, "taxAmount", getTaxAmount()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("personnelBusinessLinkTaxAmountId")) != null) setPersonnelBusinessLinkTaxAmountId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("taxAmount")) != null) setTaxAmount(__getDecimal(val));  
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __personnel_business_link_tax_amount_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __company_id ;
	protected java.math.BigDecimal  __tax_amount ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
}
