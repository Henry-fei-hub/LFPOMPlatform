package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSoftwareUpdateFile extends GenericBase implements BaseFactory<BaseSoftwareUpdateFile>, Comparable<BaseSoftwareUpdateFile> 
{


	public static BaseSoftwareUpdateFile newInstance(){
		return new BaseSoftwareUpdateFile();
	}

	@Override
	public BaseSoftwareUpdateFile make(){
		BaseSoftwareUpdateFile b = new BaseSoftwareUpdateFile();
		return b;
	}

	public final static java.lang.String CS_SOFTWARE_UPDATE_FILE_ID = "software_update_file_id" ;
	public final static java.lang.String CS_TO_FILE_PATH = "to_file_path" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SOFTWARE_UPDATE_VERSION_ID = "software_update_version_id" ;

	public final static java.lang.String ALL_CAPTIONS = "软件文件更新编码,相对文件路径，不要写全路径名，我们会把每个需要更新的文件放在一个固定的路径下面,文件管理表主键,备注,更新版本主键";

	public java.lang.Integer getSoftwareUpdateFileId() {
		return this.__software_update_file_id;
	}

	public void setSoftwareUpdateFileId( java.lang.Integer value ) {
		this.__software_update_file_id = value;
	}

	public java.lang.String getToFilePath() {
		return this.__to_file_path;
	}

	public void setToFilePath( java.lang.String value ) {
		this.__to_file_path = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getSoftwareUpdateVersionId() {
		return this.__software_update_version_id;
	}

	public void setSoftwareUpdateVersionId( java.lang.Integer value ) {
		this.__software_update_version_id = value;
	}

	public void cloneCopy(BaseSoftwareUpdateFile __bean){
		__bean.setSoftwareUpdateFileId(getSoftwareUpdateFileId());
		__bean.setToFilePath(getToFilePath());
		__bean.setFileId(getFileId());
		__bean.setRemark(getRemark());
		__bean.setSoftwareUpdateVersionId(getSoftwareUpdateVersionId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSoftwareUpdateFileId() == null ? "" : getSoftwareUpdateFileId());
		sb.append(",");
		sb.append(getToFilePath() == null ? "" : getToFilePath());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getSoftwareUpdateVersionId() == null ? "" : getSoftwareUpdateVersionId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSoftwareUpdateFile o) {
		return __software_update_file_id == null ? -1 : __software_update_file_id.compareTo(o.getSoftwareUpdateFileId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__software_update_file_id);
		hash = 97 * hash + Objects.hashCode(this.__to_file_path);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__software_update_version_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSoftwareUpdateFile o = (BaseSoftwareUpdateFile)obj;
		if(!Objects.equals(this.__software_update_file_id, o.getSoftwareUpdateFileId())) return false;
		if(!Objects.equals(this.__to_file_path, o.getToFilePath())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__software_update_version_id, o.getSoftwareUpdateVersionId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSoftwareUpdateFileId() != null) sb.append(__wrapNumber(count++, "softwareUpdateFileId", getSoftwareUpdateFileId()));
		if(getToFilePath() != null) sb.append(__wrapString(count++, "toFilePath", getToFilePath()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getSoftwareUpdateVersionId() != null) sb.append(__wrapNumber(count++, "softwareUpdateVersionId", getSoftwareUpdateVersionId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("softwareUpdateFileId")) != null) setSoftwareUpdateFileId(__getInt(val)); 
		if((val = values.get("toFilePath")) != null) setToFilePath(__getString(val));
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("softwareUpdateVersionId")) != null) setSoftwareUpdateVersionId(__getInt(val)); 
	}

	protected java.lang.Integer  __software_update_file_id ;
	protected java.lang.String  __to_file_path ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __software_update_version_id ;
}
