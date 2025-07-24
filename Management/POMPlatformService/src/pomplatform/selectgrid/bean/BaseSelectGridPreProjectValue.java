package pomplatform.selectgrid.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSelectGridPreProjectValue extends GenericBase implements BaseFactory<BaseSelectGridPreProjectValue>, Comparable<BaseSelectGridPreProjectValue> 
{


	public static BaseSelectGridPreProjectValue newInstance(){
		return new BaseSelectGridPreProjectValue();
	}

	@Override
	public BaseSelectGridPreProjectValue make(){
		BaseSelectGridPreProjectValue b = new BaseSelectGridPreProjectValue();
		return b;
	}

	public final static java.lang.String CS_PRE_PROJECT_REIMBURSEMENT_NUMBER_ID = "pre_project_reimbursement_number_id" ;
	public final static java.lang.String CS_CUSTOM_NUMBER = "custom_number" ;
	public final static java.lang.String CS_PROJECT_MANAGER = "project_manager" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PRE_PROJECT_TYPE = "pre_project_type" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PRE_BUSINESS_TYPE = "pre_business_type" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,前期项目信息编号,项目经理(用来指定这个项目的项目经理),创建时间,备注,项目类别,板块,业务类别,项目名称,项目编号,信息编号";

	public java.lang.Integer getPreProjectReimbursementNumberId() {
		return this.__pre_project_reimbursement_number_id;
	}

	public void setPreProjectReimbursementNumberId( java.lang.Integer value ) {
		this.__pre_project_reimbursement_number_id = value;
	}

	public java.lang.String getCustomNumber() {
		return this.__custom_number;
	}

	public void setCustomNumber( java.lang.String value ) {
		this.__custom_number = value;
	}

	public java.lang.Integer getProjectManager() {
		return this.__project_manager;
	}

	public void setProjectManager( java.lang.Integer value ) {
		this.__project_manager = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getPreProjectType() {
		return this.__pre_project_type;
	}

	public void setPreProjectType( java.lang.Integer value ) {
		this.__pre_project_type = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getPreBusinessType() {
		return this.__pre_business_type;
	}

	public void setPreBusinessType( java.lang.Integer value ) {
		this.__pre_business_type = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public void cloneCopy(BaseSelectGridPreProjectValue __bean){
		__bean.setPreProjectReimbursementNumberId(getPreProjectReimbursementNumberId());
		__bean.setCustomNumber(getCustomNumber());
		__bean.setProjectManager(getProjectManager());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
		__bean.setPreProjectType(getPreProjectType());
		__bean.setPlateId(getPlateId());
		__bean.setPreBusinessType(getPreBusinessType());
		__bean.setProjectName(getProjectName());
		__bean.setProjectCode(getProjectCode());
		__bean.setInfoCode(getInfoCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPreProjectReimbursementNumberId() == null ? "" : getPreProjectReimbursementNumberId());
		sb.append(",");
		sb.append(getCustomNumber() == null ? "" : getCustomNumber());
		sb.append(",");
		sb.append(getProjectManager() == null ? "" : getProjectManager());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getPreProjectType() == null ? "" : getPreProjectType());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getPreBusinessType() == null ? "" : getPreBusinessType());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSelectGridPreProjectValue o) {
		return __pre_project_reimbursement_number_id == null ? -1 : __pre_project_reimbursement_number_id.compareTo(o.getPreProjectReimbursementNumberId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pre_project_reimbursement_number_id);
		hash = 97 * hash + Objects.hashCode(this.__custom_number);
		hash = 97 * hash + Objects.hashCode(this.__project_manager);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_type);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__pre_business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSelectGridPreProjectValue o = (BaseSelectGridPreProjectValue)obj;
		if(!Objects.equals(this.__pre_project_reimbursement_number_id, o.getPreProjectReimbursementNumberId())) return false;
		if(!Objects.equals(this.__custom_number, o.getCustomNumber())) return false;
		if(!Objects.equals(this.__project_manager, o.getProjectManager())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__pre_project_type, o.getPreProjectType())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__pre_business_type, o.getPreBusinessType())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPreProjectReimbursementNumberId() != null) sb.append(__wrapNumber(count++, "preProjectReimbursementNumberId", getPreProjectReimbursementNumberId()));
		if(getCustomNumber() != null) sb.append(__wrapString(count++, "customNumber", getCustomNumber()));
		if(getProjectManager() != null) sb.append(__wrapNumber(count++, "projectManager", getProjectManager()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPreProjectType() != null) sb.append(__wrapNumber(count++, "preProjectType", getPreProjectType()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPreBusinessType() != null) sb.append(__wrapNumber(count++, "preBusinessType", getPreBusinessType()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("preProjectReimbursementNumberId")) != null) setPreProjectReimbursementNumberId(__getInt(val)); 
		if((val = values.get("customNumber")) != null) setCustomNumber(__getString(val));
		if((val = values.get("projectManager")) != null) setProjectManager(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("preProjectType")) != null) setPreProjectType(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("preBusinessType")) != null) setPreBusinessType(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
	}

	protected java.lang.Integer  __pre_project_reimbursement_number_id ;
	protected java.lang.String  __custom_number ;
	protected java.lang.Integer  __project_manager ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __pre_project_type ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __pre_business_type ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __info_code ;
}
