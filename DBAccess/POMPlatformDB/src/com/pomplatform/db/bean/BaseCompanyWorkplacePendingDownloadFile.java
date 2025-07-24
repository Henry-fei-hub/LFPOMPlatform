package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompanyWorkplacePendingDownloadFile extends GenericBase implements BaseFactory<BaseCompanyWorkplacePendingDownloadFile>, Comparable<BaseCompanyWorkplacePendingDownloadFile> 
{


	public static BaseCompanyWorkplacePendingDownloadFile newInstance(){
		return new BaseCompanyWorkplacePendingDownloadFile();
	}

	@Override
	public BaseCompanyWorkplacePendingDownloadFile make(){
		BaseCompanyWorkplacePendingDownloadFile b = new BaseCompanyWorkplacePendingDownloadFile();
		return b;
	}

	public final static java.lang.String CS_COMPANY_WORKPLACE_PENDING_DOWNLOAD_FILE_ID = "company_workplace_pending_download_file_id" ;
	public final static java.lang.String CS_WORKPLACE_ID = "workplace_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_LAST_MODIFY_TIME = "last_modify_time" ;
	public final static java.lang.String CS_CWD_FILE_ID = "cwd_file_id" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_SRC_WORKPLACE_ID = "src_workplace_id" ;

	public final static java.lang.String ALL_CAPTIONS = ",工作场所编码,创建时间,,文件编码,删除标志,0 - 刚创建，2 - 正在被下载，3 - 已完成,文件来源的工作场所";

	public java.lang.Integer getCompanyWorkplacePendingDownloadFileId() {
		return this.__company_workplace_pending_download_file_id;
	}

	public void setCompanyWorkplacePendingDownloadFileId( java.lang.Integer value ) {
		this.__company_workplace_pending_download_file_id = value;
	}

	public java.lang.Integer getWorkplaceId() {
		return this.__workplace_id;
	}

	public void setWorkplaceId( java.lang.Integer value ) {
		this.__workplace_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getLastModifyTime() {
		return this.__last_modify_time;
	}

	public void setLastModifyTime( java.util.Date value ) {
		this.__last_modify_time = value;
	}

	public java.lang.Integer getCwdFileId() {
		return this.__cwd_file_id;
	}

	public void setCwdFileId( java.lang.Integer value ) {
		this.__cwd_file_id = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getSrcWorkplaceId() {
		return this.__src_workplace_id;
	}

	public void setSrcWorkplaceId( java.lang.Integer value ) {
		this.__src_workplace_id = value;
	}

	public void cloneCopy(BaseCompanyWorkplacePendingDownloadFile __bean){
		__bean.setCompanyWorkplacePendingDownloadFileId(getCompanyWorkplacePendingDownloadFileId());
		__bean.setWorkplaceId(getWorkplaceId());
		__bean.setCreateTime(getCreateTime());
		__bean.setLastModifyTime(getLastModifyTime());
		__bean.setCwdFileId(getCwdFileId());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setStatus(getStatus());
		__bean.setSrcWorkplaceId(getSrcWorkplaceId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyWorkplacePendingDownloadFileId() == null ? "" : getCompanyWorkplacePendingDownloadFileId());
		sb.append(",");
		sb.append(getWorkplaceId() == null ? "" : getWorkplaceId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getLastModifyTime() == null ? "" : sdf.format(getLastModifyTime()));
		sb.append(",");
		sb.append(getCwdFileId() == null ? "" : getCwdFileId());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getSrcWorkplaceId() == null ? "" : getSrcWorkplaceId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyWorkplacePendingDownloadFile o) {
		return __company_workplace_pending_download_file_id == null ? -1 : __company_workplace_pending_download_file_id.compareTo(o.getCompanyWorkplacePendingDownloadFileId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_workplace_pending_download_file_id);
		hash = 97 * hash + Objects.hashCode(this.__workplace_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__last_modify_time);
		hash = 97 * hash + Objects.hashCode(this.__cwd_file_id);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__src_workplace_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyWorkplacePendingDownloadFile o = (BaseCompanyWorkplacePendingDownloadFile)obj;
		if(!Objects.equals(this.__company_workplace_pending_download_file_id, o.getCompanyWorkplacePendingDownloadFileId())) return false;
		if(!Objects.equals(this.__workplace_id, o.getWorkplaceId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__last_modify_time, o.getLastModifyTime())) return false;
		if(!Objects.equals(this.__cwd_file_id, o.getCwdFileId())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__src_workplace_id, o.getSrcWorkplaceId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyWorkplacePendingDownloadFileId() != null) sb.append(__wrapNumber(count++, "companyWorkplacePendingDownloadFileId", getCompanyWorkplacePendingDownloadFileId()));
		if(getWorkplaceId() != null) sb.append(__wrapNumber(count++, "workplaceId", getWorkplaceId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getLastModifyTime() != null) sb.append(__wrapDate(count++, "lastModifyTime", getLastModifyTime()));
		if(getCwdFileId() != null) sb.append(__wrapNumber(count++, "cwdFileId", getCwdFileId()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getSrcWorkplaceId() != null) sb.append(__wrapNumber(count++, "srcWorkplaceId", getSrcWorkplaceId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyWorkplacePendingDownloadFileId")) != null) setCompanyWorkplacePendingDownloadFileId(__getInt(val)); 
		if((val = values.get("workplaceId")) != null) setWorkplaceId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("lastModifyTime")) != null) setLastModifyTime(__getDate(val)); 
		if((val = values.get("cwdFileId")) != null) setCwdFileId(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("srcWorkplaceId")) != null) setSrcWorkplaceId(__getInt(val)); 
	}

	protected java.lang.Integer  __company_workplace_pending_download_file_id ;
	protected java.lang.Integer  __workplace_id ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __last_modify_time ;
	protected java.lang.Integer  __cwd_file_id ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __src_workplace_id ;
}
