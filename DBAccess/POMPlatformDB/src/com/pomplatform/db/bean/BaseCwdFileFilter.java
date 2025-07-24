package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdFileFilter extends GenericBase implements BaseFactory<BaseCwdFileFilter>, Comparable<BaseCwdFileFilter> 
{


	public static BaseCwdFileFilter newInstance(){
		return new BaseCwdFileFilter();
	}

	@Override
	public BaseCwdFileFilter make(){
		BaseCwdFileFilter b = new BaseCwdFileFilter();
		return b;
	}

	public final static java.lang.String CS_FILE_FILTER_ID = "file_filter_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_FILTER_FILE_EXTENSION = "filter_file_extension" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,类型  0公用  1本地文件服务适用  2本地存储适用,过滤的文件后缀名称,描述,创建时间,删除标志 0未删除  1已删除";

	public java.lang.Integer getFileFilterId() {
		return this.__file_filter_id;
	}

	public void setFileFilterId( java.lang.Integer value ) {
		this.__file_filter_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getFilterFileExtension() {
		return this.__filter_file_extension;
	}

	public void setFilterFileExtension( java.lang.String value ) {
		this.__filter_file_extension = value;
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

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public void cloneCopy(BaseCwdFileFilter __bean){
		__bean.setFileFilterId(getFileFilterId());
		__bean.setType(getType());
		__bean.setFilterFileExtension(getFilterFileExtension());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFileFilterId() == null ? "" : getFileFilterId());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getFilterFileExtension() == null ? "" : getFilterFileExtension());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdFileFilter o) {
		return __file_filter_id == null ? -1 : __file_filter_id.compareTo(o.getFileFilterId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__file_filter_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__filter_file_extension);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdFileFilter o = (BaseCwdFileFilter)obj;
		if(!Objects.equals(this.__file_filter_id, o.getFileFilterId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__filter_file_extension, o.getFilterFileExtension())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFileFilterId() != null) sb.append(__wrapNumber(count++, "fileFilterId", getFileFilterId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getFilterFileExtension() != null) sb.append(__wrapString(count++, "filterFileExtension", getFilterFileExtension()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fileFilterId")) != null) setFileFilterId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("filterFileExtension")) != null) setFilterFileExtension(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __file_filter_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __filter_file_extension ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
}
