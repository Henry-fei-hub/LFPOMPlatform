package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSoftwareUpdateVersion extends GenericBase implements BaseFactory<BaseSoftwareUpdateVersion>, Comparable<BaseSoftwareUpdateVersion> 
{


	public static BaseSoftwareUpdateVersion newInstance(){
		return new BaseSoftwareUpdateVersion();
	}

	@Override
	public BaseSoftwareUpdateVersion make(){
		BaseSoftwareUpdateVersion b = new BaseSoftwareUpdateVersion();
		return b;
	}

	public final static java.lang.String CS_SOFTWARE_UPDATE_VERSION_ID = "software_update_version_id" ;
	public final static java.lang.String CS_VERSION_NO = "version_no" ;
	public final static java.lang.String CS_TITLE = "title" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SOFTWARE_TYPE = "software_type" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_SQL_SCRIPT = "sql_script" ;
	public final static java.lang.String CS_IS_REBOOT = "is_reboot" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,版本号唯一 初始1.0 每次加0.1,更新主题,更新详情描述,说明更新了什么内容,软件类型，1-本地文件服务器，2-本地存储服务器,操作人,创建时间,sql脚本,是否需要重启服务 true需要 false不需要";

	public java.lang.Integer getSoftwareUpdateVersionId() {
		return this.__software_update_version_id;
	}

	public void setSoftwareUpdateVersionId( java.lang.Integer value ) {
		this.__software_update_version_id = value;
	}

	public java.math.BigDecimal getVersionNo() {
		return this.__version_no;
	}

	public void setVersionNo( java.math.BigDecimal value ) {
		this.__version_no = value;
	}

	public java.lang.String getTitle() {
		return this.__title;
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getSoftwareType() {
		return this.__software_type;
	}

	public void setSoftwareType( java.lang.Integer value ) {
		this.__software_type = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getSqlScript() {
		return this.__sql_script;
	}

	public void setSqlScript( java.lang.String value ) {
		this.__sql_script = value;
	}

	public java.lang.Boolean getIsReboot() {
		return this.__is_reboot;
	}

	public void setIsReboot( java.lang.Boolean value ) {
		this.__is_reboot = value;
	}

	public void cloneCopy(BaseSoftwareUpdateVersion __bean){
		__bean.setSoftwareUpdateVersionId(getSoftwareUpdateVersionId());
		__bean.setVersionNo(getVersionNo());
		__bean.setTitle(getTitle());
		__bean.setRemark(getRemark());
		__bean.setSoftwareType(getSoftwareType());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setSqlScript(getSqlScript());
		__bean.setIsReboot(getIsReboot());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSoftwareUpdateVersionId() == null ? "" : getSoftwareUpdateVersionId());
		sb.append(",");
		sb.append(getVersionNo() == null ? "" : getVersionNo());
		sb.append(",");
		sb.append(getTitle() == null ? "" : getTitle());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getSoftwareType() == null ? "" : getSoftwareType());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getSqlScript() == null ? "" : getSqlScript());
		sb.append(",");
		sb.append(getIsReboot() == null ? "" : getIsReboot());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSoftwareUpdateVersion o) {
		return __software_update_version_id == null ? -1 : __software_update_version_id.compareTo(o.getSoftwareUpdateVersionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__software_update_version_id);
		hash = 97 * hash + Objects.hashCode(this.__version_no);
		hash = 97 * hash + Objects.hashCode(this.__title);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__software_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__sql_script);
		hash = 97 * hash + Objects.hashCode(this.__is_reboot);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSoftwareUpdateVersion o = (BaseSoftwareUpdateVersion)obj;
		if(!Objects.equals(this.__software_update_version_id, o.getSoftwareUpdateVersionId())) return false;
		if(!Objects.equals(this.__version_no, o.getVersionNo())) return false;
		if(!Objects.equals(this.__title, o.getTitle())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__software_type, o.getSoftwareType())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__sql_script, o.getSqlScript())) return false;
		if(!Objects.equals(this.__is_reboot, o.getIsReboot())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSoftwareUpdateVersionId() != null) sb.append(__wrapNumber(count++, "softwareUpdateVersionId", getSoftwareUpdateVersionId()));
		if(getVersionNo() != null) sb.append(__wrapDecimal(count++, "versionNo", getVersionNo()));
		if(getTitle() != null) sb.append(__wrapString(count++, "title", getTitle()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getSoftwareType() != null) sb.append(__wrapNumber(count++, "softwareType", getSoftwareType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getSqlScript() != null) sb.append(__wrapString(count++, "sqlScript", getSqlScript()));
		if(getIsReboot() != null) sb.append(__wrapBoolean(count++, "isReboot", getIsReboot()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("softwareUpdateVersionId")) != null) setSoftwareUpdateVersionId(__getInt(val)); 
		if((val = values.get("versionNo")) != null) setVersionNo(__getDecimal(val));  
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("softwareType")) != null) setSoftwareType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("sqlScript")) != null) setSqlScript(__getString(val));
		if((val = values.get("isReboot")) != null) setIsReboot(__getBoolean(val));
	}

	protected java.lang.Integer  __software_update_version_id ;
	protected java.math.BigDecimal  __version_no ;
	protected java.lang.String  __title ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __software_type ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __sql_script ;
	protected java.lang.Boolean  __is_reboot ;
}
