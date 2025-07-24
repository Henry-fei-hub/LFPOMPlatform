package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFileManagesWatermark extends GenericBase implements BaseFactory<BaseFileManagesWatermark>, Comparable<BaseFileManagesWatermark> 
{


	public static BaseFileManagesWatermark newInstance(){
		return new BaseFileManagesWatermark();
	}

	@Override
	public BaseFileManagesWatermark make(){
		BaseFileManagesWatermark b = new BaseFileManagesWatermark();
		return b;
	}

	public final static java.lang.String CS_WATERMARK_ID = "watermark_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_FILE_TYPE = "file_type" ;

	public final static java.lang.String ALL_CAPTIONS = "水印编号,员工编号,图片编号,1为身份证附件，2为职称证附件，3为学历证附件，";

	public java.lang.Integer getWatermarkId() {
		return this.__watermark_id;
	}

	public void setWatermarkId( java.lang.Integer value ) {
		this.__watermark_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.Integer getFileType() {
		return this.__file_type;
	}

	public void setFileType( java.lang.Integer value ) {
		this.__file_type = value;
	}

	public void cloneCopy(BaseFileManagesWatermark __bean){
		__bean.setWatermarkId(getWatermarkId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setFileId(getFileId());
		__bean.setFileType(getFileType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getWatermarkId() == null ? "" : getWatermarkId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileType() == null ? "" : getFileType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFileManagesWatermark o) {
		return __watermark_id == null ? -1 : __watermark_id.compareTo(o.getWatermarkId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__watermark_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFileManagesWatermark o = (BaseFileManagesWatermark)obj;
		if(!Objects.equals(this.__watermark_id, o.getWatermarkId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__file_type, o.getFileType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getWatermarkId() != null) sb.append(__wrapNumber(count++, "watermarkId", getWatermarkId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getFileType() != null) sb.append(__wrapNumber(count++, "fileType", getFileType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getWatermarkId() != null) res.put("watermarkId", getWatermarkId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getFileType() != null) res.put("fileType", getFileType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("watermarkId")) != null) setWatermarkId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("fileType")) != null) setFileType(__getInt(val)); 
	}

	protected java.lang.Integer  __watermark_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.Integer  __file_type ;
}
