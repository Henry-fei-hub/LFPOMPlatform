package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFilingManage extends GenericBase implements BaseFactory<BaseCwdFilingManage>, Comparable<BaseCwdFilingManage> 
{


	public static BaseCwdFilingManage newInstance(){
		return new BaseCwdFilingManage();
	}

	@Override
	public BaseCwdFilingManage make(){
		BaseCwdFilingManage b = new BaseCwdFilingManage();
		return b;
	}

	public final static java.lang.String CS_CWD_FILING_MANAGE_ID = "cwd_filing_manage_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_TEMPLATE_NAME = "template_name" ;
	public final static java.lang.String CS_CWD_FILING_TEMPLATE_ID = "cwd_filing_template_id" ;
	public final static java.lang.String CS_FILING_TYPE = "filing_type" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = ",大项目主键,存档模板名称,文件归档模板主键,存档类型 1基础资料区 2提资区  3审核区 4出版区,操作人,备注,创建时间";

	public java.lang.Integer getCwdFilingManageId() {
		return this.__cwd_filing_manage_id;
	}

	public void setCwdFilingManageId( java.lang.Integer value ) {
		this.__cwd_filing_manage_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getTemplateName() {
		return this.__template_name;
	}

	public void setTemplateName( java.lang.String value ) {
		this.__template_name = value;
	}

	public java.lang.Integer getCwdFilingTemplateId() {
		return this.__cwd_filing_template_id;
	}

	public void setCwdFilingTemplateId( java.lang.Integer value ) {
		this.__cwd_filing_template_id = value;
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

	public void cloneCopy(BaseCwdFilingManage __bean){
		__bean.setCwdFilingManageId(getCwdFilingManageId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setTemplateName(getTemplateName());
		__bean.setCwdFilingTemplateId(getCwdFilingTemplateId());
		__bean.setFilingType(getFilingType());
		__bean.setOperatorId(getOperatorId());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdFilingManageId() == null ? "" : getCwdFilingManageId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getTemplateName() == null ? "" : getTemplateName());
		sb.append(",");
		sb.append(getCwdFilingTemplateId() == null ? "" : getCwdFilingTemplateId());
		sb.append(",");
		sb.append(getFilingType() == null ? "" : getFilingType());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFilingManage o) {
		return __cwd_filing_manage_id == null ? -1 : __cwd_filing_manage_id.compareTo(o.getCwdFilingManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__template_name);
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_template_id);
		hash = 97 * hash + Objects.hashCode(this.__filing_type);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFilingManage o = (BaseCwdFilingManage)obj;
		if(!Objects.equals(this.__cwd_filing_manage_id, o.getCwdFilingManageId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__template_name, o.getTemplateName())) return false;
		if(!Objects.equals(this.__cwd_filing_template_id, o.getCwdFilingTemplateId())) return false;
		if(!Objects.equals(this.__filing_type, o.getFilingType())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdFilingManageId() != null) sb.append(__wrapNumber(count++, "cwdFilingManageId", getCwdFilingManageId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getTemplateName() != null) sb.append(__wrapString(count++, "templateName", getTemplateName()));
		if(getCwdFilingTemplateId() != null) sb.append(__wrapNumber(count++, "cwdFilingTemplateId", getCwdFilingTemplateId()));
		if(getFilingType() != null) sb.append(__wrapNumber(count++, "filingType", getFilingType()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdFilingManageId")) != null) setCwdFilingManageId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("templateName")) != null) setTemplateName(__getString(val));
		if((val = values.get("cwdFilingTemplateId")) != null) setCwdFilingTemplateId(__getInt(val)); 
		if((val = values.get("filingType")) != null) setFilingType(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __cwd_filing_manage_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __template_name ;
	protected java.lang.Integer  __cwd_filing_template_id ;
	protected java.lang.Integer  __filing_type ;
	protected java.lang.Integer  __operator_id ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
}
