package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCwdRecentWorkedProject extends GenericBase implements BaseFactory<BaseCwdRecentWorkedProject>, Comparable<BaseCwdRecentWorkedProject> 
{


	public static BaseCwdRecentWorkedProject newInstance(){
		return new BaseCwdRecentWorkedProject();
	}

	@Override
	public BaseCwdRecentWorkedProject make(){
		BaseCwdRecentWorkedProject b = new BaseCwdRecentWorkedProject();
		return b;
	}

	public final static java.lang.String CS_CWD_RECENT_WORKED_PROJECT_ID = "cwd_recent_worked_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_COMPANY_NO = "company_no" ;
	public final static java.lang.String CS_WORK_TIME = "work_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,人员编码,项目编码,公司编码（默认为JA公司编码）,公司编码（默认为JA公司编码）,工作时间,备注";

	public java.lang.Integer getCwdRecentWorkedProjectId() {
		return this.__cwd_recent_worked_project_id;
	}

	public void setCwdRecentWorkedProjectId( java.lang.Integer value ) {
		this.__cwd_recent_worked_project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getCompanyNo() {
		return this.__company_no;
	}

	public void setCompanyNo( java.lang.String value ) {
		this.__company_no = value;
	}

	public java.util.Date getWorkTime() {
		return this.__work_time;
	}

	public void setWorkTime( java.util.Date value ) {
		this.__work_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseCwdRecentWorkedProject __bean){
		__bean.setCwdRecentWorkedProjectId(getCwdRecentWorkedProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setCompanyId(getCompanyId());
		__bean.setCompanyNo(getCompanyNo());
		__bean.setWorkTime(getWorkTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCwdRecentWorkedProjectId() == null ? "" : getCwdRecentWorkedProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getCompanyNo() == null ? "" : getCompanyNo());
		sb.append(",");
		sb.append(getWorkTime() == null ? "" : sdf.format(getWorkTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCwdRecentWorkedProject o) {
		return __cwd_recent_worked_project_id == null ? -1 : __cwd_recent_worked_project_id.compareTo(o.getCwdRecentWorkedProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cwd_recent_worked_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__company_no);
		hash = 97 * hash + Objects.hashCode(this.__work_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCwdRecentWorkedProject o = (BaseCwdRecentWorkedProject)obj;
		if(!Objects.equals(this.__cwd_recent_worked_project_id, o.getCwdRecentWorkedProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__company_no, o.getCompanyNo())) return false;
		if(!Objects.equals(this.__work_time, o.getWorkTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCwdRecentWorkedProjectId() != null) sb.append(__wrapNumber(count++, "cwdRecentWorkedProjectId", getCwdRecentWorkedProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCompanyNo() != null) sb.append(__wrapString(count++, "companyNo", getCompanyNo()));
		if(getWorkTime() != null) sb.append(__wrapDate(count++, "workTime", getWorkTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("cwdRecentWorkedProjectId")) != null) setCwdRecentWorkedProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("workTime")) != null) setWorkTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __cwd_recent_worked_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __company_no ;
	protected java.util.Date  __work_time ;
	protected java.lang.String  __remark ;
}
