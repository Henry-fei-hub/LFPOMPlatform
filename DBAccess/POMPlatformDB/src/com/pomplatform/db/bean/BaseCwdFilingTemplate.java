package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFilingTemplate extends GenericBase implements BaseFactory<BaseCwdFilingTemplate>, Comparable<BaseCwdFilingTemplate> 
{


	public static BaseCwdFilingTemplate newInstance(){
		return new BaseCwdFilingTemplate();
	}

	@Override
	public BaseCwdFilingTemplate make(){
		BaseCwdFilingTemplate b = new BaseCwdFilingTemplate();
		return b;
	}

	public final static java.lang.String CS_CWD_FILING_TEMPLATE_ID = "cwd_filing_template_id" ;
	public final static java.lang.String CS_TEMPLATE_NAME = "template_name" ;
	public final static java.lang.String CS_FILING_TYPE = "filing_type" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_CWD_FILING_MAIN_TEMPLATE_ID = "cwd_filing_main_template_id" ;

	public final static java.lang.String ALL_CAPTIONS = ",模板名称,归档类型 1基础资料区 2提资区 3成果区 4出版区,操作人,备注,创建时间,文件归档主模板主键";

	public java.lang.Integer getCwdFilingTemplateId() {
		return this.__cwd_filing_template_id;
	}

	public void setCwdFilingTemplateId( java.lang.Integer value ) {
		this.__cwd_filing_template_id = value;
	}

	public java.lang.String getTemplateName() {
		return this.__template_name;
	}

	public void setTemplateName( java.lang.String value ) {
		this.__template_name = value;
	}

	public java.lang.Integer getFilingType() {
		return this.__filing_type;
	}

	public void setFilingType( java.lang.Integer value ) {
		this.__filing_type = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getCwdFilingMainTemplateId() {
		return this.__cwd_filing_main_template_id;
	}

	public void setCwdFilingMainTemplateId( java.lang.Integer value ) {
		this.__cwd_filing_main_template_id = value;
	}

	public void cloneCopy(BaseCwdFilingTemplate __bean){
		__bean.setCwdFilingTemplateId(getCwdFilingTemplateId());
		__bean.setTemplateName(getTemplateName());
		__bean.setFilingType(getFilingType());
		__bean.setOperatorId(getOperatorId());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setCwdFilingMainTemplateId(getCwdFilingMainTemplateId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdFilingTemplateId() == null ? "" : getCwdFilingTemplateId());
		sb.append(",");
		sb.append(getTemplateName() == null ? "" : getTemplateName());
		sb.append(",");
		sb.append(getFilingType() == null ? "" : getFilingType());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCwdFilingMainTemplateId() == null ? "" : getCwdFilingMainTemplateId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFilingTemplate o) {
		return __cwd_filing_template_id == null ? -1 : __cwd_filing_template_id.compareTo(o.getCwdFilingTemplateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_template_id);
		hash = 97 * hash + Objects.hashCode(this.__template_name);
		hash = 97 * hash + Objects.hashCode(this.__filing_type);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_main_template_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFilingTemplate o = (BaseCwdFilingTemplate)obj;
		if(!Objects.equals(this.__cwd_filing_template_id, o.getCwdFilingTemplateId())) return false;
		if(!Objects.equals(this.__template_name, o.getTemplateName())) return false;
		if(!Objects.equals(this.__filing_type, o.getFilingType())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__cwd_filing_main_template_id, o.getCwdFilingMainTemplateId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdFilingTemplateId() != null) sb.append(__wrapNumber(count++, "cwdFilingTemplateId", getCwdFilingTemplateId()));
		if(getTemplateName() != null) sb.append(__wrapString(count++, "templateName", getTemplateName()));
		if(getFilingType() != null) sb.append(__wrapNumber(count++, "filingType", getFilingType()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCwdFilingMainTemplateId() != null) sb.append(__wrapNumber(count++, "cwdFilingMainTemplateId", getCwdFilingMainTemplateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdFilingTemplateId")) != null) setCwdFilingTemplateId(__getInt(val)); 
		if((val = values.get("templateName")) != null) setTemplateName(__getString(val));
		if((val = values.get("filingType")) != null) setFilingType(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("cwdFilingMainTemplateId")) != null) setCwdFilingMainTemplateId(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_filing_template_id ;
	protected java.lang.String  __template_name ;
	protected java.lang.Integer  __filing_type ;
	protected java.lang.Integer  __operator_id ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __cwd_filing_main_template_id ;
}
