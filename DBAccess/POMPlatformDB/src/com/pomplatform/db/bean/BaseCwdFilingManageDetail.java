package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFilingManageDetail extends GenericBase implements BaseFactory<BaseCwdFilingManageDetail>, Comparable<BaseCwdFilingManageDetail> 
{


	public static BaseCwdFilingManageDetail newInstance(){
		return new BaseCwdFilingManageDetail();
	}

	@Override
	public BaseCwdFilingManageDetail make(){
		BaseCwdFilingManageDetail b = new BaseCwdFilingManageDetail();
		return b;
	}

	public final static java.lang.String CS_CWD_FILING_MANAGE_DETAIL_ID = "cwd_filing_manage_detail_id" ;
	public final static java.lang.String CS_FILE_NAME = "file_name" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_CWD_FILING_MANAGE_ID = "cwd_filing_manage_id" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;

	public final static java.lang.String ALL_CAPTIONS = ",文档名称,父级id,文件归档管理表主键,操作人,创建时间,大项目主键";

	public java.lang.Integer getCwdFilingManageDetailId() {
		return this.__cwd_filing_manage_detail_id;
	}

	public void setCwdFilingManageDetailId( java.lang.Integer value ) {
		this.__cwd_filing_manage_detail_id = value;
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

	public java.lang.Integer getCwdFilingManageId() {
		return this.__cwd_filing_manage_id;
	}

	public void setCwdFilingManageId( java.lang.Integer value ) {
		this.__cwd_filing_manage_id = value;
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

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public void cloneCopy(BaseCwdFilingManageDetail __bean){
		__bean.setCwdFilingManageDetailId(getCwdFilingManageDetailId());
		__bean.setFileName(getFileName());
		__bean.setParentId(getParentId());
		__bean.setCwdFilingManageId(getCwdFilingManageId());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreateTime(getCreateTime());
		__bean.setMainProjectId(getMainProjectId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdFilingManageDetailId() == null ? "" : getCwdFilingManageDetailId());
		sb.append(",");
		sb.append(getFileName() == null ? "" : getFileName());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getCwdFilingManageId() == null ? "" : getCwdFilingManageId());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFilingManageDetail o) {
		return __cwd_filing_manage_detail_id == null ? -1 : __cwd_filing_manage_detail_id.compareTo(o.getCwdFilingManageDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_manage_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__cwd_filing_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFilingManageDetail o = (BaseCwdFilingManageDetail)obj;
		if(!Objects.equals(this.__cwd_filing_manage_detail_id, o.getCwdFilingManageDetailId())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__cwd_filing_manage_id, o.getCwdFilingManageId())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdFilingManageDetailId() != null) sb.append(__wrapNumber(count++, "cwdFilingManageDetailId", getCwdFilingManageDetailId()));
		if(getFileName() != null) sb.append(__wrapString(count++, "fileName", getFileName()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getCwdFilingManageId() != null) sb.append(__wrapNumber(count++, "cwdFilingManageId", getCwdFilingManageId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdFilingManageDetailId")) != null) setCwdFilingManageDetailId(__getInt(val)); 
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("cwdFilingManageId")) != null) setCwdFilingManageId(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
	}

	protected java.lang.Integer  __cwd_filing_manage_detail_id ;
	protected java.lang.String  __file_name ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __cwd_filing_manage_id ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __main_project_id ;
}
