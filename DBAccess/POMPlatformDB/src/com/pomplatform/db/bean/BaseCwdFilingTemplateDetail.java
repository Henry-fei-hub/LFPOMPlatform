package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFilingTemplateDetail extends GenericBase implements BaseFactory<BaseCwdFilingTemplateDetail>, Comparable<BaseCwdFilingTemplateDetail> 
{


	public static BaseCwdFilingTemplateDetail newInstance(){
		return new BaseCwdFilingTemplateDetail();
	}

	@Override
	public BaseCwdFilingTemplateDetail make(){
		BaseCwdFilingTemplateDetail b = new BaseCwdFilingTemplateDetail();
		return b;
	}

	public final static java.lang.String CS_CWD_FILING_TEMPLATE_DETAIL_ID = "cwd_filing_template_detail_id" ;
	public final static java.lang.String CS_FILE_NAME = "file_name" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_CWD_FILING_TEMPLATE_ID = "cwd_filing_template_id" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = ",文档名称,父级id,模板主键,操作人,创建时间";

	public java.lang.Integer getCwdFilingTemplateDetailId() {
		return this.__cwd_filing_template_detail_id;
	}

	public void setCwdFilingTemplateDetailId( java.lang.Integer value ) {
		this.__cwd_filing_template_detail_id = value;
	}

	public java.lang.String getFileName() {
		return this.__file_name;
	}

	public void setFileName( java.lang.String value ) {
		this.__file_name = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getCwdFilingTemplateId() {
		return this.__cwd_filing_template_id;
	}

	public void setCwdFilingTemplateId( java.lang.Integer value ) {
		this.__cwd_filing_template_id = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseCwdFilingTemplateDetail __bean){
		__bean.setCwdFilingTemplateDetailId(getCwdFilingTemplateDetailId());
		__bean.setFileName(getFileName());
		__bean.setParentId(getParentId());
		__bean.setCwdFilingTemplateId(getCwdFilingTemplateId());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdFilingTemplateDetailId() == null ? "" : getCwdFilingTemplateDetailId());
		sb.append(",");
		sb.append(getFileName() == null ? "" : getFileName());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getCwdFilingTemplateId() == null ? "" : getCwdFilingTemplateId());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFilingTemplateDetail o) {
		return __cwd_filing_template_detail_id == null ? -1 : __cwd_filing_template_detail_id.compareTo(o.getCwdFilingTemplateDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_template_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_template_id);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFilingTemplateDetail o = (BaseCwdFilingTemplateDetail)obj;
		if(!Objects.equals(this.__cwd_filing_template_detail_id, o.getCwdFilingTemplateDetailId())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__cwd_filing_template_id, o.getCwdFilingTemplateId())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdFilingTemplateDetailId() != null) sb.append(__wrapNumber(count++, "cwdFilingTemplateDetailId", getCwdFilingTemplateDetailId()));
		if(getFileName() != null) sb.append(__wrapString(count++, "fileName", getFileName()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getCwdFilingTemplateId() != null) sb.append(__wrapNumber(count++, "cwdFilingTemplateId", getCwdFilingTemplateId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdFilingTemplateDetailId")) != null) setCwdFilingTemplateDetailId(__getInt(val)); 
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("cwdFilingTemplateId")) != null) setCwdFilingTemplateId(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __cwd_filing_template_detail_id ;
	protected java.lang.String  __file_name ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __cwd_filing_template_id ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __create_time ;
}
