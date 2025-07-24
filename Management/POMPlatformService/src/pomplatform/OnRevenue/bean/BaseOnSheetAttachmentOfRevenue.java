package pomplatform.OnRevenue.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnSheetAttachmentOfRevenue extends GenericBase implements BaseFactory<BaseOnSheetAttachmentOfRevenue>, Comparable<BaseOnSheetAttachmentOfRevenue> 
{


	public static BaseOnSheetAttachmentOfRevenue newInstance(){
		return new BaseOnSheetAttachmentOfRevenue();
	}

	@Override
	public BaseOnSheetAttachmentOfRevenue make(){
		BaseOnSheetAttachmentOfRevenue b = new BaseOnSheetAttachmentOfRevenue();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ATTACHMENT_ID = "project_attachment_id" ;
	public final static java.lang.String CS_IS_HANDLE = "is_handle" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_ATTACHMENT_FILE = "attachment_file" ;
	public final static java.lang.String CS_UPLOAD_TIME = "upload_time" ;
	public final static java.lang.String CS_SHEET_CODE = "sheet_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,附件是否处理,项目编码,项目阶段,附件,上传时间,订单编号,订单名称,合同编号";

	public java.lang.Integer getProjectAttachmentId() {
		return this.__project_attachment_id;
	}

	public void setProjectAttachmentId( java.lang.Integer value ) {
		this.__project_attachment_id = value;
	}

	public java.lang.Boolean getIsHandle() {
		return this.__is_handle;
	}

	public void setIsHandle( java.lang.Boolean value ) {
		this.__is_handle = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.lang.String getAttachmentFile() {
		return this.__attachment_file;
	}

	public void setAttachmentFile( java.lang.String value ) {
		this.__attachment_file = value;
	}

	public java.util.Date getUploadTime() {
		return this.__upload_time;
	}

	public void setUploadTime( java.util.Date value ) {
		this.__upload_time = value;
	}

	public java.lang.String getSheetCode() {
		return this.__sheet_code;
	}

	public void setSheetCode( java.lang.String value ) {
		this.__sheet_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public void cloneCopy(BaseOnSheetAttachmentOfRevenue __bean){
		__bean.setProjectAttachmentId(getProjectAttachmentId());
		__bean.setIsHandle(getIsHandle());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setAttachmentFile(getAttachmentFile());
		__bean.setUploadTime(getUploadTime());
		__bean.setSheetCode(getSheetCode());
		__bean.setProjectName(getProjectName());
		__bean.setContractCode(getContractCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectAttachmentId() == null ? "" : getProjectAttachmentId());
		sb.append(",");
		sb.append(getIsHandle() == null ? "" : getIsHandle());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getAttachmentFile() == null ? "" : getAttachmentFile());
		sb.append(",");
		sb.append(getUploadTime() == null ? "" : sdf.format(getUploadTime()));
		sb.append(",");
		sb.append(getSheetCode() == null ? "" : getSheetCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnSheetAttachmentOfRevenue o) {
		return __project_attachment_id == null ? -1 : __project_attachment_id.compareTo(o.getProjectAttachmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__is_handle);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_file);
		hash = 97 * hash + Objects.hashCode(this.__upload_time);
		hash = 97 * hash + Objects.hashCode(this.__sheet_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnSheetAttachmentOfRevenue o = (BaseOnSheetAttachmentOfRevenue)obj;
		if(!Objects.equals(this.__project_attachment_id, o.getProjectAttachmentId())) return false;
		if(!Objects.equals(this.__is_handle, o.getIsHandle())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__attachment_file, o.getAttachmentFile())) return false;
		if(!Objects.equals(this.__upload_time, o.getUploadTime())) return false;
		if(!Objects.equals(this.__sheet_code, o.getSheetCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectAttachmentId() != null) sb.append(__wrapNumber(count++, "projectAttachmentId", getProjectAttachmentId()));
		if(getIsHandle() != null) sb.append(__wrapBoolean(count++, "isHandle", getIsHandle()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getAttachmentFile() != null) sb.append(__wrapString(count++, "attachmentFile", getAttachmentFile()));
		if(getUploadTime() != null) sb.append(__wrapDate(count++, "uploadTime", getUploadTime()));
		if(getSheetCode() != null) sb.append(__wrapString(count++, "sheetCode", getSheetCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectAttachmentId")) != null) setProjectAttachmentId(__getInt(val)); 
		if((val = values.get("isHandle")) != null) setIsHandle(__getBoolean(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("attachmentFile")) != null) setAttachmentFile(__getString(val));
		if((val = values.get("uploadTime")) != null) setUploadTime(__getDate(val)); 
		if((val = values.get("sheetCode")) != null) setSheetCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
	}

	protected java.lang.Integer  __project_attachment_id ;
	protected java.lang.Boolean  __is_handle ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.String  __attachment_file ;
	protected java.util.Date  __upload_time ;
	protected java.lang.String  __sheet_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __contract_code ;
}
