package pomplatform.workflow.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

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

	public final static String CS_WATERMARK_ID = "watermark_id" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_FILE_ID = "file_id" ;
	public final static String CS_FILE_URL = "file_url" ;

	public final static String ALL_CAPTIONS = "水印编号,员工工号,图片编号,水印前的图片路径";

	public Integer getWatermarkId() {
		return this.__watermark_id;
	}

	public void setWatermarkId( Integer value ) {
		this.__watermark_id = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( Integer value ) {
		this.__file_id = value;
	}

	public String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( String value ) {
		this.__file_url = value;
	}

	public void cloneCopy(BaseFileManagesWatermark __bean){
		__bean.setWatermarkId(getWatermarkId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setFileId(getFileId());
		__bean.setFileUrl(getFileUrl());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getWatermarkId() == null ? "" : getWatermarkId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
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
		hash = 97 * hash + Objects.hashCode(this.__file_url);
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
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getWatermarkId() != null) sb.append(__wrapNumber(count++, "watermarkId", getWatermarkId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getWatermarkId() != null) res.put("watermarkId", getWatermarkId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getFileUrl() != null) res.put("fileUrl", getFileUrl());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("watermarkId")) != null) setWatermarkId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
	}

	protected Integer  __watermark_id ;
	protected Integer  __employee_id ;
	protected Integer  __file_id ;
	protected String  __file_url ;
}
