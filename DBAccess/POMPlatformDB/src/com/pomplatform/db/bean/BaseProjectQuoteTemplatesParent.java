package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectQuoteTemplatesParent extends GenericBase implements BaseFactory<BaseProjectQuoteTemplatesParent>, Comparable<BaseProjectQuoteTemplatesParent> 
{


	public static BaseProjectQuoteTemplatesParent newInstance(){
		return new BaseProjectQuoteTemplatesParent();
	}

	@Override
	public BaseProjectQuoteTemplatesParent make(){
		BaseProjectQuoteTemplatesParent b = new BaseProjectQuoteTemplatesParent();
		return b;
	}

	public final static java.lang.String CS_PROJECT_QUOTE_TEMPLATES_PARENT_ID = "project_quote_templates_parent_id" ;
	public final static java.lang.String CS_PARENT_NAME = "parent_name" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,模板名称,业务类别id,公司id,创建人,创建日期,备注";

	public java.lang.Integer getProjectQuoteTemplatesParentId() {
		return this.__project_quote_templates_parent_id;
	}

	public void setProjectQuoteTemplatesParentId( java.lang.Integer value ) {
		this.__project_quote_templates_parent_id = value;
	}

	public java.lang.String getParentName() {
		return this.__parent_name;
	}

	public void setParentName( java.lang.String value ) {
		this.__parent_name = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseProjectQuoteTemplatesParent __bean){
		__bean.setProjectQuoteTemplatesParentId(getProjectQuoteTemplatesParentId());
		__bean.setParentName(getParentName());
		__bean.setBusinessType(getBusinessType());
		__bean.setCompanyId(getCompanyId());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateDate(getCreateDate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectQuoteTemplatesParentId() == null ? "" : getProjectQuoteTemplatesParentId());
		sb.append(",");
		sb.append(getParentName() == null ? "" : getParentName());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectQuoteTemplatesParent o) {
		return __project_quote_templates_parent_id == null ? -1 : __project_quote_templates_parent_id.compareTo(o.getProjectQuoteTemplatesParentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_quote_templates_parent_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_name);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectQuoteTemplatesParent o = (BaseProjectQuoteTemplatesParent)obj;
		if(!Objects.equals(this.__project_quote_templates_parent_id, o.getProjectQuoteTemplatesParentId())) return false;
		if(!Objects.equals(this.__parent_name, o.getParentName())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectQuoteTemplatesParentId() != null) sb.append(__wrapNumber(count++, "projectQuoteTemplatesParentId", getProjectQuoteTemplatesParentId()));
		if(getParentName() != null) sb.append(__wrapString(count++, "parentName", getParentName()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectQuoteTemplatesParentId")) != null) setProjectQuoteTemplatesParentId(__getInt(val)); 
		if((val = values.get("parentName")) != null) setParentName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_quote_templates_parent_id ;
	protected java.lang.String  __parent_name ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_date ;
	protected java.lang.String  __remark ;
}
